import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProjectMemberAnalysisService {

  constructor(private httpClient: HttpClient) { }
  public GetComparecommit(owner,repo){
    const headers = new HttpHeaders({
      'Content-Type': 'text/json'
    });
    const options = {
      headers
    };
    let url = '/GitRepositoryAnalysisSystem/comparecommit?owner='+owner+'&repo='+repo;
    return this.httpClient.get<any>(url, options);
  
  }
  

}
