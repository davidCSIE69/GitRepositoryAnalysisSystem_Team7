import { HttpClientModule } from '@angular/common/http';
import { TestBed } from '@angular/core/testing';
import { SignupComponent } from './signup.component';

import { SignupService } from './signup.service';

describe('SignupService', () => {
  let service: SignupService;

  beforeEach(async() => {
    await TestBed.configureTestingModule({
      imports:[HttpClientModule],
      declarations:[SignupComponent,SignupService]
    }).compileComponents();
    service = TestBed.inject(SignupService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
