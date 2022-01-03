package adapter.githubaccount;

import usecase.githubaccount.LinkGithubInput;

public class LinkGithubInputImpl implements LinkGithubInput {

    private String id;
    private String githubCode;
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

    public void setGithubCode(String githubCode) {
        this.githubCode = githubCode;
    }


    public String getGithubCode() {
        return this.githubCode;
    }
}