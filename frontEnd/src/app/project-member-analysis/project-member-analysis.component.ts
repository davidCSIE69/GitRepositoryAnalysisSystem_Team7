import { Component, OnInit } from '@angular/core';
import { range } from 'rxjs';
import {ProjectMemberAnalysisService} from './project-member-analysis.service';
@Component({
  selector: 'app-project-member-analysis',
  templateUrl: './project-member-analysis.component.html',
  styleUrls: ['./project-member-analysis.component.css']
})
export class ProjectMemberAnalysisComponent implements OnInit {

  //sessions
  totalrepo:any;
  totalowner:any;
  //pages
  chooseRepository="choose-repository";
  chooseProject="choose-project";
  //bar chart setting
  barChartOptions = {
    responsive: true
  };
  barChartType = 'bar';
  barChartLegend = true; 
  
  //Overview datas
  overview={
    Commit:{
      Labels:['davidCSIE69', 'shouhanchen'],
      Data:[ 
        {data: [65, 59], label: 'master'},
        {data: [28, 48], label: 'dev'}
      ]
    }
  }
  
  //all repos
  /*
    data structure
    [{
      name:"",
      Commit:{Labels:[],Data:[data:[],label:'']},
      PullRequest:{Labels:[],Data:{data:[],label:''}}
    },...]
  */
  allRepos=[{
    name:"aa",
    Commit:{
      Labels:['davidCSIE69', 'shouhanchen'],
      Data:[ 
        {data: [65, 59], label: 'master'},
        {data: [28, 48], label: 'dev'}
      ]
    }
  }
  ]
  
  constructor(private memberService:ProjectMemberAnalysisService) { }
  
  ngOnInit(): void {
    this.totalrepo = window.sessionStorage.getItem('totalrepo');
    this.totalowner = window.sessionStorage.getItem('totalowner');
    
  }
  setRepos(){
    let repos = this.totalrepo;
    let owners = this.totalowner;
    for(let index in range(0,repos.length) ){
      this.allRepos.push({
        name:repos[index],
        Commit:{Labels:[],Data:[]}});
        this.getCommitDatas(owners[index],repos[index],index);
    }
  }

  getCommitDatas(owner,repo,index){
    this.memberService.GetComparecommit(owner,repo).subscribe(
          request=>{
            let datas = request;
            this.allRepos[index].Commit.Data.push({data:[datas["Branch Name"]],label:''})
          }
        );
    }
}
