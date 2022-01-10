package usecase.githubaccount;


public interface LinkGithubOutput {
    void setToken(String access_token);
    String getToken();
    void setId(String id);
    String getId();
}
