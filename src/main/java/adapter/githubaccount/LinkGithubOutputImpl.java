package adapter.githubaccount;

import domain.Account;
import usecase.githubaccount.LinkGithubOutput;

public class LinkGithubOutputImpl implements LinkGithubOutput {
    private String id;
    private String githubCode;

    @Override
    public void setGithubCode(String githubCode) {
        this.githubCode = githubCode;
    }

    @Override
    public String getGitGithubCode() {
        return this.githubCode;
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
