package adapter.servlet;
import java.lang.reflect.Array;
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

@WebServlet(urlPatterns = "/pullrequest", name = "PullrequestServlet")
public class PullrequestServlet extends HttpServlet {
    private JSONArray gitpullrequest(String owner, String repo ) throws IOException{
        String api = "https://api.github.com/repos/"+owner+"/"+repo+"/pulls?state=all";
        GithubRepositoryAccessor accessor = new GithubRepositoryAccessor();
        JSONArray jsonArray = accessor.httpsget(api);
        return  jsonArray;

    }

    private HashMap<String, Object> pull_analytics(JSONArray ja) throws IOException{
        HashMap<String, Object> map = new HashMap<String, Object>();
        ArrayList<Map> open = new ArrayList<>();
        ArrayList<Map> closed = new ArrayList<>();

        map.put("Pull_Request",ja.length());
        for(int i=0;i< ja.length();i++){
            JSONObject obj = ja.getJSONObject(i);
            if(!map.containsKey(obj.getString("state"))){
                map.put(obj.getString("state"),1 );
            }
            else{
                map.put(obj.getString("state"),(Integer)map.get(obj.getString("state"))+1);
            }
            if(obj.getString("state").equals("open")){
                Object o = obj.get("user");
                JSONObject jo = new JSONObject(o.toString());
                Map<String,String> m = new HashMap<>();
                m.put("title",obj.getString("title"));
                m.put("name",jo.getString("login"));
                m.put("date",obj.getString("created_at"));
                open.add(m);

            }else{
                Object o = obj.get("user");
                JSONObject jo = new JSONObject(o.toString());
                Map<String,String> m = new HashMap<>();
                m.put("title",obj.getString("title"));
                m.put("name",jo.getString("login"));
                m.put("date",obj.getString("created_at"));
                closed.add(m);
            }


        }
        map.put("open_state",open);
        map.put("close_state",closed);
        return map;
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String owner = new String(request.getParameter("owner"));
        String repo = new String(request.getParameter("repo"));
        PrintWriter out = response.getWriter();
        JSONArray test = gitpullrequest(owner,repo);
        HashMap<String,Object> map = pull_analytics(test);
        JSONObject jo = new JSONObject(map);
        out.println(jo);
        out.close();
    }

}
