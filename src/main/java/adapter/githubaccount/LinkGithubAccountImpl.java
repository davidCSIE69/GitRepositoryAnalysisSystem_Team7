package adapter.githubaccount;


import domain.Account;
import usecase.githubaccount.LinkGithubAccount;
import database.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LinkGithubAccountImpl implements LinkGithubAccount {
    private Connection conn;

    public LinkGithubAccountImpl(){
        conn = Database.getConnection();
    }

    @Override
    public void linkGithubAccountById(String id, String token) {
        final String insert = " UPDATE user SET githubCode = ? WHERE id = ? ";

        try {
            assert conn != null;
            PreparedStatement preparedStatement = conn.prepareStatement(insert);
            preparedStatement.setString (1, token);
            preparedStatement.setString (2, id);
            preparedStatement.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void linkGithubAccountByAccount(String account, String token) {
        final String insert = " UPDATE user SET githubToken = ? WHERE account = ? ";

        try {
            assert conn != null;
            PreparedStatement preparedStatement = conn.prepareStatement(insert);
            preparedStatement.setString (1, token);
            preparedStatement.setString (2, account);
            preparedStatement.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public String getClientID() {
        final String query = " SELECT client_id FROM api WHERE name='github'";
        String client_id = null;
        try{
            assert conn!= null;
            ResultSet resultSet;
            PreparedStatement preparedStatement = conn.prepareStatement(query);

            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            client_id = resultSet.getString("client_id");

            return client_id;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getClientSecret() {
        final String query = " SELECT client_secret FROM api WHERE name='github'";
        String client_secret = null;
        try{
            assert conn!= null;
            ResultSet resultSet;
            PreparedStatement preparedStatement = conn.prepareStatement(query);

            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            client_secret = resultSet.getString("client_secret");

            return client_secret;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
