import { ComponentFixture, TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { FooterComponent } from '../footer/footer.component';
import { HeaderComponent } from '../header/header.component';
import { PersonalImformationComponent } from '../personal-imformation/personal-imformation.component';

import { AddRepoComponent } from './add-repo.component';

describe('AddRepoComponent', () => {
  let component: AddRepoComponent;
  let fixture: ComponentFixture<AddRepoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddRepoComponent,HeaderComponent,PersonalImformationComponent,FooterComponent ],
      imports:[RouterTestingModule]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddRepoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
