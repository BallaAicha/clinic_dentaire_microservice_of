import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DentistesComponent } from './dentistes.component';

describe('DentistesComponent', () => {
  let component: DentistesComponent;
  let fixture: ComponentFixture<DentistesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [DentistesComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(DentistesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
