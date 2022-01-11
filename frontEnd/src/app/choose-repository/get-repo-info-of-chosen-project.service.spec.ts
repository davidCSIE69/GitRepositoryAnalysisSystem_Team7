import { HttpClientModule } from '@angular/common/http';
import { TestBed } from '@angular/core/testing';

import { GetRepoInfoOfChosenProjectService } from './get-repo-info-of-chosen-project.service';

describe('GetRepoInfoOfChosenProjectService', () => {
  let service: GetRepoInfoOfChosenProjectService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports:[
        HttpClientModule,
      ],
    });
    service = TestBed.inject(GetRepoInfoOfChosenProjectService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
