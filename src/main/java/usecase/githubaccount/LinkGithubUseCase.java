package usecase.githubaccount;

import domain.Account;
import domain.GithubAccount;
import usecase.account.CreateAccountInput;
import usecase.account.CreateAccountOutput;

public class LinkGithubUseCase {
    private LinkGithubAccount linkGithubAccount;

    public LinkGithubUseCase(LinkGithubAccount linkGithubAccount){
        this.linkGithubAccount = linkGithubAccount;
    }

    public void execute(LinkGithubInput input) {
        String account = input.getAccount();
        String code = input.getGithubCode();
        linkGithubAccount.linkGithubAccountByAccount(account, code);
    }
}
