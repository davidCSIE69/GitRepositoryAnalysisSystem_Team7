import { ComponentFixture, TestBed } from '@angular/core/testing';
import { HeaderComponent } from '../header/header.component';
import { PersonalImformationComponent } from '../personal-imformation/personal-imformation.component';
import { RepoImformationComponent } from '../repo-imformation/repo-imformation.component';

import { IssueTrackComponent } from './issue-track.component';

describe('IssueTrackComponent', () => {
  let component: IssueTrackComponent;
  let fixture: ComponentFixture<IssueTrackComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ IssueTrackComponent,HeaderComponent,PersonalImformationComponent,RepoImformationComponent,HeaderComponent ],
      imports:[]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(IssueTrackComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
