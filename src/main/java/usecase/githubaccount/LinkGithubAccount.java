package usecase.githubaccount;

public interface LinkGithubAccount {
    void linkGithubAccountById(String id, String access_token);
    void linkGithubAccountByAccount(String account, String access_token);
    String getClientID();
    String getClientSecret();
}
