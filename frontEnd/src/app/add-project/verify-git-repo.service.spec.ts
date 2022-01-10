import { HttpClientModule } from '@angular/common/http';
import { TestBed } from '@angular/core/testing';

import { VerifyGitRepoService } from './verify-git-repo.service';

describe('VerifyGitRepoService', () => {
  let service: VerifyGitRepoService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports:[
        HttpClientModule,
      ],
    });
    service = TestBed.inject(VerifyGitRepoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
