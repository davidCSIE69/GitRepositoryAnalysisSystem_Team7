import { HttpClientModule } from '@angular/common/http';
import { TestBed } from '@angular/core/testing';

import { DeleteProjectService } from './delete-project.service';

describe('DeleteProjectService', () => {
  let service: DeleteProjectService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports:[
        HttpClientModule,
      ],
    });
    service = TestBed.inject(DeleteProjectService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
