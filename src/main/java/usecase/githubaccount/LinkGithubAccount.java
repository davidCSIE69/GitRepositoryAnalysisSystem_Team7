package usecase.githubaccount;

public interface LinkGithubAccount {
    void linkGithubAccountById(String id, String code);
    void linkGithubAccountByAccount(String account, String code);
}
