package usecase.githubaccount;

public interface LinkGithubInput {
    void setAccount(String account);
    String getAccount();
    void setId(String id);
    String getId();
    void setToken(String access_token);
    String getToken();
}
