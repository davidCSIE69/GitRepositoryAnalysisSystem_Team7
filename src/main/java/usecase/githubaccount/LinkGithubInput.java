package usecase.githubaccount;

public interface LinkGithubInput {
    void setAccount(String account);
    String getAccount();
    void setId(String id);
    String getId();
    void setGithubCode(String githubCode);
    String getGithubCode();
}
