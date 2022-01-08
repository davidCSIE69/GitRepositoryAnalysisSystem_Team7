package domain;

public class GithubAccount {
    private String id;
    private String account;
    private String access_token;

    public GithubAccount(String id, String account, String access_token) {
        this.id = id;
        this.access_token = access_token;
        this.account = account;
    }

    public String getToken() {
        return access_token;
    }

    public String getId() {
        return id;
    }

    public String getAccount() {
        return account;
    }

}
