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

@WebServlet(urlPatterns = "/comparecommit", name = "comparecommitServlet")
public class comparecommitServlet extends HttpServlet {
    private ArrayList<String> getCommitArrayFromRepo(String owner, String repo,String branch) throws IOException {
        String apiUrl = "https://api.github.com/repos/"+ owner + "/" + repo+ "/" +"commits?sha="+ branch+"&per_page=100";
        GithubRepositoryAccessor accessor = new GithubRepositoryAccessor();
        JSONArray jsonArray = accessor.httpsget(apiUrl);

        ArrayList<String> name = new ArrayList<String>();

        for(int i=0;i< jsonArray.length();i++){
            JSONObject obj = jsonArray.getJSONObject(i);
            try {
                Object b = obj.get("committer");
                JSONObject t = new JSONObject(b.toString());
                name.add(t.getString("login"));
            }catch (Exception JSONException){
                continue;
            }
        }



        return name;
    }



    private Map<String, Integer> getcommittime(ArrayList<String> name) throws IOException{
        Map<String,Integer> map = new HashMap<String, Integer>();
        for(int i=0;i< name.size();i++){
            if(!map.containsKey(name.get(i))) {
                map.put(name.get(i), 1);
            }else{
                map.put(name.get(i),map.get(name.get(i))+1);
            }
        }
        return map;
    }

    private ArrayList<String>getallbranch(String owner,String repo) throws IOException{
        String apiUrl = "https://api.github.com/repos/"+owner+"/"+repo+"/branches";
        GithubRepositoryAccessor accessor = new GithubRepositoryAccessor();
        JSONArray jsonArray = accessor.httpsget(apiUrl);
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
        ArrayList<String> branch = getallbranch(owner,repo);
        for(int i=0;i < branch.size();i++){
            ArrayList<String> test = getCommitArrayFromRepo(owner, repo, branch.get(i));
            Map<String, Integer> map = getcommittime(test);
            Map<String,Object> hm = new HashMap<>();
            hm.put("Branch Name",branch.get(i));
            hm.put("Commit",map);
            JSONObject jo = new JSONObject(hm);
            out.println(jo);
        }
        out.close();
        //ArrayList<String> bname = getallbranch(owner,repo);
        //out.println(bname);

    }




    }

