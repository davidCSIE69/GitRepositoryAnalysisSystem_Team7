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
      Labels:['cc', 'sd','cddc'],
      Data:[ 
        {data: [2, 4,0], label: 'Commit'}
      ]
    }
  }
  allCommit = [];
  //all repos
  /*
    data structure
    [{
      name:"",
      Commit:{Labels:[],Data:[data:[],label:'']},
    },...]
  */
  allRepos=[
  ];
  //all members
  allMembers=[];
  constructor(private memberService:ProjectMemberAnalysisService) { }
  
  ngOnInit(): void {
    this.totalrepo = JSON.parse(window.sessionStorage.getItem('totalrepo'));
    this.totalowner = JSON.parse(window.sessionStorage.getItem('totalowner'));
    this.setRepos();
  }
  setRepos(){
    let repos = this.totalrepo;
    let owners = this.totalowner;
    for(let index =0;index<repos.length;index++ ){
      
        this.getCommitDatas(owners[index],repos[index],index);
    }
  }
  getCommitDatasTest(owner,repo,index){
    let datas = [{"Branch Name":"dev","Commit":{"cc":2,"sd":4}},
                {"Branch Name":"head","Commit":{"cddc":2,"sd":4}}];
    //run through所有branch
    
    this.allRepos[index].Commit = this.goThroughBranchs(datas);
  }
  fatchAllMembers(datas){
  
    //fatch出資料內所有成員
    for(let data of datas){
      let members = this.getJsonKeys(data.Commit);;
      let find = false;
      for(let member of members){
        if(!this.allMembers.find(val=>val==member)){
          this.allMembers.push(member);
        }
      }
    }
    
  }
  getCommitDatas(owner,repo,index){
    this.memberService.GetComparecommit(owner,repo).subscribe(
          request=>{
            let datas = request;
            this.allRepos.push({
              "name":repo[index],
              "Commit":{Labels:[],Data:{data:[],label:''}}});
            this.allRepos[index] = this.goThroughBranchs(datas);
            

          }
        );
  }
  goThroughBranchs(datas){
    let json = {Data:[],Labels:null};
    //run through所有branch
    for(let thisData of datas){
      let members = this.getJsonKeys(thisData.Commit);
      let commitData = [];
      
      this.fatchAllMembers(datas);
      //將所有成員資料fetch出來
      for(let member of this.allMembers){
        if(members.find(val=>val==member)){
          commitData.push(Number(thisData.Commit[member]));
          
        }
        else{
          commitData.push(0);
        }
      }

      json.Data.push({data:commitData,label:thisData["Branch Name"]})
      json.Labels = this.allMembers;
      
    }
    return json;
  }
  getJsonKeys(json){
    let keys=[];
    for(let key in json){
      keys.push(key);
    }
    return keys;
  }
  
}
