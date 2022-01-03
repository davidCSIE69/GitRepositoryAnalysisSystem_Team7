package adapter.githubaccount;


import usecase.githubaccount.LinkGithubAccount;
import database.Database;
import domain.Project;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LinkGithubAccountImpl implements LinkGithubAccount {
    private Connection conn;

    public LinkGithubAccountImpl(){
        conn = Database.getConnection();
    }

    @Override
    public void linkGithubAccountById(String id, String code) {
        final String insert = " UPDATE user SET githubCode = ? WHERE id = ? ";

        try {
            assert conn != null;
            PreparedStatement preparedStatement = conn.prepareStatement(insert);
            preparedStatement.setString (1, code);
            preparedStatement.setString (2, id);
            preparedStatement.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void linkGithubAccountByAccount(String account, String code) {
        final String insert = " UPDATE user SET githubCode = ? WHERE account = ? ";

        try {
            assert conn != null;
            PreparedStatement preparedStatement = conn.prepareStatement(insert);
            preparedStatement.setString (1, code);
            preparedStatement.setString (2, account);
            preparedStatement.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
