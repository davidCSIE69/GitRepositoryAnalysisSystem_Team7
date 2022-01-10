package adapter.githubaccount;

import domain.Account;
import usecase.githubaccount.LinkGithubOutput;

public class LinkGithubOutputImpl implements LinkGithubOutput {
    private String id;
    private String access_token;

    @Override
    public void setToken(String access_token) {
        this.access_token = access_token;
    }

    @Override
    public String getToken() {
        return this.access_token;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }
}
