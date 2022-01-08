package adapter.servlet;


import adapter.githubaccount.LinkGithubAccountImpl;
import adapter.githubaccount.LinkGithubInputImpl;
import adapter.githubaccount.LinkGithubOutputImpl;
import domain.Account;
import org.json.JSONArray;
import org.json.JSONObject;
import usecase.GithubRepositoryAccessor;
import usecase.githubaccount.LinkGithubAccount;
import usecase.githubaccount.LinkGithubInput;
import usecase.githubaccount.LinkGithubOutput;
import usecase.githubaccount.LinkGithubUseCase;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

@WebServlet(urlPatterns = "/LinkGithub", name = "LinkGithubAccountServlet")
public class LinkGithubAccountServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JSONObject requestBody = new JSONObject(request.getReader().readLine());
        String account = requestBody.getString("account");
        String code = requestBody.getString("code");
        JSONObject returnJson = new JSONObject();
        String githubname = null;
        try {

            LinkGithubAccount linkGithubAccount = new LinkGithubAccountImpl();
            LinkGithubUseCase linkGithubUseCase = new LinkGithubUseCase(linkGithubAccount);

            // token url
            String client_id = linkGithubUseCase.getClientID();
            String client_secret = linkGithubUseCase.getClientSecret();
            String tokenurl = "https://github.com/login/oauth/access_token?client_id=" +
                    client_id +
                    "&client_secret=" + client_secret +
                    "&code=" + code;

            // get token
            GithubRepositoryAccessor tokenAccessor = new GithubRepositoryAccessor();
            tokenAccessor.addHTTPSGetProperty("Accept", "application/json");
            JSONObject tokenJson = (JSONObject) tokenAccessor.httpsPost(tokenurl).get(0);
            String token = tokenJson.getString("access_token");

            // insert token to sql
            LinkGithubInput input = new LinkGithubInputImpl();
            input.setAccount(account);
            input.setToken(token);
            linkGithubUseCase.execute(input);


            // get username
            String nameurl = "https://api.github.com/user";
            GithubRepositoryAccessor nameAccessor = new GithubRepositoryAccessor();
            nameAccessor.addHTTPSGetProperty("Accept", "application/json");
            nameAccessor.addHTTPSGetProperty("Authorization", token);
            JSONObject nameJson = (JSONObject) nameAccessor.httpsPost(nameurl).get(0);
            githubname = nameJson.getString("name");
            returnJson.put("isSuccess", "true");
            returnJson.put("githubUsername", githubname);
        }
        catch (Exception ignored) {}

        if (githubname == null){
            returnJson.put("isSuccess", "false");
            returnJson.put("githubUsername", "false");
        }

        response.setContentType("text/json");
        PrintWriter out = response.getWriter();
        out.println(returnJson);
        out.close();
    }
}
