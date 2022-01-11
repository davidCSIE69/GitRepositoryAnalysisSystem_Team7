import { TestBed } from '@angular/core/testing';

import { ProjectMemberAnalysisService } from './project-member-analysis.service';

describe('ProjectMemberAnalysisService', () => {
  let service: ProjectMemberAnalysisService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ProjectMemberAnalysisService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
