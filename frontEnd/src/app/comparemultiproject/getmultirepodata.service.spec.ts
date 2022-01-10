import { HttpClientModule } from '@angular/common/http';
import { TestBed } from '@angular/core/testing';

import { GetmultirepodataService } from './getmultirepodata.service';

describe('GetmultirepodataService', () => {
  let service: GetmultirepodataService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports:[HttpClientModule]
    });
    service = TestBed.inject(GetmultirepodataService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
