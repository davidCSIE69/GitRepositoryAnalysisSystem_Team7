import { HttpClientJsonpModule, HttpClientModule } from '@angular/common/http';
import { TestBed } from '@angular/core/testing';
import { HeaderComponent } from '../header/header.component';

import { IssueTrackService } from './issue-track.service';

describe('IssueTrackService', () => {
  let service: IssueTrackService;

  beforeEach(async() => {
    await TestBed.configureTestingModule({
      imports:[HttpClientModule],
      declarations:[HeaderComponent]
    }).compileComponents();
    service = TestBed.inject(IssueTrackService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
