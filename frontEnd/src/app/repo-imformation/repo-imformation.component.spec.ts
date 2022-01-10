import { ComponentFixture, TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { HeaderComponent } from '../header/header.component';

import { RepoImformationComponent } from './repo-imformation.component';

describe('RepoImformationComponent', () => {
  let component: RepoImformationComponent;
  let fixture: ComponentFixture<RepoImformationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RepoImformationComponent,HeaderComponent ],
      imports:[RouterTestingModule],
      providers:[]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RepoImformationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
