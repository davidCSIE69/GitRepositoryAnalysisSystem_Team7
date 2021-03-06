package adapter.githubaccount;

import usecase.githubaccount.LinkGithubInput;

public class LinkGithubInputImpl implements LinkGithubInput {

    private String id;
    private String access_token;
    private String account;

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAccount() {
        return account;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setToken(String access_token) {
        this.access_token = access_token;
    }

    public String getToken() {
        return this.access_token;
    }


}