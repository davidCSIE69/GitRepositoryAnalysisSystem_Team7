import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProjectMemberAnalysisComponent } from './project-member-analysis.component';

describe('ProjectMemberAnalysisComponent', () => {
  let component: ProjectMemberAnalysisComponent;
  let fixture: ComponentFixture<ProjectMemberAnalysisComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProjectMemberAnalysisComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProjectMemberAnalysisComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
