package adapter.servlet;


import adapter.githubaccount.LinkGithubAccountImpl;
import adapter.githubaccount.LinkGithubInputImpl;
import adapter.githubaccount.LinkGithubOutputImpl;
import domain.Account;
import org.json.JSONObject;
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

@WebServlet(urlPatterns = "/LinkGithub", name = "LinkGithubAccountServlet")
public class LinkGithubAccountServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JSONObject requestBody = new JSONObject(request.getReader().readLine());
        String account = requestBody.getString("account");
        String codeurl = requestBody.getString("codeurl");
        JSONObject returnJson = new JSONObject();

        String[] metadatas = codeurl.split("=");


        if (metadatas.length==2){
            String githubCode = metadatas[1];
            LinkGithubAccount linkGithubAccount = new LinkGithubAccountImpl();
            LinkGithubInput input = new LinkGithubInputImpl();
            input.setAccount(account);
            input.setGithubCode(githubCode);
            LinkGithubUseCase linkGithubUseCase = new LinkGithubUseCase(linkGithubAccount);
            linkGithubUseCase.execute(input);
            returnJson.put("isSuccess", "true");
        }
        else{
            returnJson.put("isSuccess", "false");
        }


        response.setContentType("text/json");
        PrintWriter out = response.getWriter();
        out.println(returnJson);
        out.close();
    }
}
