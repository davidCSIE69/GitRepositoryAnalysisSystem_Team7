import {Component, OnInit} from '@angular/core';
import {Router,ActivatedRoute } from '@angular/router';
import {LoginService} from './login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.html',
  styleUrls: ['./loginstyle.css']
})
export class LoginComponent implements OnInit {
  name = 'Hello';
  accountInput: any;
  passwordInput: any;
  datas: any;
  badRequest:any;
  Username = "";
  UserID = "";
  signup="signup";
  constructor(private router: Router, private loginService: LoginService , private acrouter: ActivatedRoute) {
  }

  ngOnInit(): void {
    let code = null;
    
    this.acrouter.queryParamMap
    .subscribe((params) => {
      if(params.keys.includes("code")){
        code = params.get("code");
        this.sendGithubCode(code);
        
      }
    })
    if(code!=null){
      
    }
  }
  sendGithubCode(code){
    let jsonObj = {"code":code};
    let data = JSON.stringify(jsonObj);
    this.loginService.sendGithubCode(data).subscribe(
      request => {
        this.datas = request;
        if (this.datas.isSuccess){
          this.router.navigate(["homepage"]);
          console.log("userId =",this.datas.userId.toString())
          sessionStorage.setItem('Username', this.datas.githubUsername.toString());
          sessionStorage.setItem('UserID', this.datas.userId.toString());
        }
        else{
          this.badRequest = "github 登入失敗";
        }
      });
  }
  // tslint:disable-next-line:typedef
  redirectTo(url){
    this.router.navigateByUrl(url.toString());
  }
  GoToGitHub(){
    let client_id = "d9e8c7044e9fa5c1575a";
    let url = "https://github.com/login/oauth/authorize";
    
    let scopes = [
      'user',
      'repo',
    ];
    let scope = scopes.join(',');
    
    window.location.href = url+
      "?client_id="+client_id+
      "&scope="+scope;
  }
  // tslint:disable-next-line
  logInCheck() {
    const UserLoginData = {
      account: undefined,
      password: undefined
    };

    UserLoginData.account  = this.accountInput;
    UserLoginData.password = this.passwordInput;

    const data = JSON.stringify(UserLoginData);
    this.loginService.verifyUserLoginData(data).subscribe(
      request => {
        this.datas = request;
        if (this.datas.redirect){
          this.router.navigate([this.datas.redirect.toString()]);
          
          sessionStorage.setItem('Username', this.datas.userName.toString());
          sessionStorage.setItem('userId', this.datas.userId.toString());
        }
        else{
          this.badRequest = "帳號或密碼錯誤";
        }
      }
    );
  }

  RoutetoSignup(){
    this.redirectTo("signup");
  }
}
