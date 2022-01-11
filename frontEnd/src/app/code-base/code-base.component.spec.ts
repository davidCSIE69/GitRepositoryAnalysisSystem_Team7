import { ComponentFixture, TestBed } from '@angular/core/testing';
import { HeaderComponent } from '../header/header.component';
import { PersonalImformationComponent } from '../personal-imformation/personal-imformation.component';
import { RepoImformationComponent } from '../repo-imformation/repo-imformation.component';

import { CodeBaseComponent } from './code-base.component';

describe('CodeBaseComponent', () => {
  let component: CodeBaseComponent;
  let fixture: ComponentFixture<CodeBaseComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations:[CodeBaseComponent,HeaderComponent,PersonalImformationComponent,RepoImformationComponent]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CodeBaseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
