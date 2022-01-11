package adapter.servlet;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
import usecase.GithubRepositoryAccessor;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
@WebServlet(urlPatterns = "/getbranch", name = "Getbranch")
public class Getbranch extends HttpServlet {
    private ArrayList<String>getallbranch(String owner,String repo) throws IOException{
        String apiUrl = "https://api.github.com/repos/"+owner+"/"+repo+"/branches";
        GithubRepositoryAccessor accessor = new GithubRepositoryAccessor();
        JSONArray jsonArray = accessor.httpsGet(apiUrl);
        ArrayList<String> bname = new ArrayList<String>();
        for(int i=0;i< jsonArray.length();i++){
            JSONObject obj = jsonArray.getJSONObject(i);
            bname.add(obj.getString("name"));
        }
        return  bname;
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String owner = new String(request.getParameter("owner"));
        String repo = new String(request.getParameter("repo"));
        PrintWriter out = response.getWriter();
        HashMap<String,ArrayList<String>> branch = new HashMap<>();
        ArrayList<String> bname = getallbranch(owner,repo);
        branch.put("branch Name",bname);
        JSONObject jo = new JSONObject(branch);
        out.println(jo);
        out.close();
    }

}
