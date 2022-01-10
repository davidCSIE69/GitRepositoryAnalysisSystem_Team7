import { HttpClientModule } from '@angular/common/http';
import { TestBed } from '@angular/core/testing';

import { CodeBaseService } from './code-base.service';

describe('CodeBaseService', () => {
  let service: CodeBaseService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports:[HttpClientModule]
    });
    service = TestBed.inject(CodeBaseService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
