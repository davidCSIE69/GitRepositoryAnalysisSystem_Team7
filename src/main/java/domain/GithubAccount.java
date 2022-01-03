package domain;

public class GithubAccount {
    private String id;
    private String githubCode;
    private String account;

    public GithubAccount(String id, String account, String githubCode) {
        this.id = id;
        this.githubCode = githubCode;
        this.account = account;
    }

    public String getGithubCode() {
        return githubCode;
    }

    public String getId() {
        return id;
    }

    public String getAccount() {
        return account;
    }

}
