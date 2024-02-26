import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PizzaEditComponent } from './pizza-edit.component';

describe('PizzaEditComponent', () => {
  let component: PizzaEditComponent;
  let fixture: ComponentFixture<PizzaEditComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PizzaEditComponent]
    });
    fixture = TestBed.createComponent(PizzaEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
