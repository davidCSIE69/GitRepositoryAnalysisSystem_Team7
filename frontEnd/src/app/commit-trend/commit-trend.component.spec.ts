import { HttpClientModule } from '@angular/common/http';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { ChartsModule } from 'ng2-charts';
import { FooterComponent } from '../footer/footer.component';
import { HeaderComponent } from '../header/header.component';
import { RepoImformationComponent } from '../repo-imformation/repo-imformation.component';

import { CommitTrendComponent } from './commit-trend.component';

describe('CommitTrendComponent', () => {
  let component: CommitTrendComponent;
  let fixture: ComponentFixture<CommitTrendComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CommitTrendComponent,HeaderComponent,RepoImformationComponent,FooterComponent],
      imports:[ChartsModule,HttpClientModule,RouterTestingModule]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CommitTrendComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
