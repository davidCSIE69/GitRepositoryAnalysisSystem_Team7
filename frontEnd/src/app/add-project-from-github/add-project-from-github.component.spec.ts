import { ComponentFixture, TestBed } from '@angular/core/testing';
import { FormsModule } from '@angular/forms';
import { RouterTestingModule } from '@angular/router/testing';
import { FooterComponent } from '../footer/footer.component';
import { HeaderComponent } from '../header/header.component';
import { PersonalImformationComponent } from '../personal-imformation/personal-imformation.component';

import { AddProjectFromGithubComponent } from './add-project-from-github.component';

describe('AddProjectFromGithubComponent', () => {
  let component: AddProjectFromGithubComponent;
  let fixture: ComponentFixture<AddProjectFromGithubComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports:[FormsModule,RouterTestingModule ],
      declarations: [ AddProjectFromGithubComponent,HeaderComponent,PersonalImformationComponent,FooterComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddProjectFromGithubComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
