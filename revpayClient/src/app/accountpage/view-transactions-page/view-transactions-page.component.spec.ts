import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewTransactionsPageComponent } from './view-transactions-page.component';

describe('ViewTransactionsPageComponent', () => {
  let component: ViewTransactionsPageComponent;
  let fixture: ComponentFixture<ViewTransactionsPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ViewTransactionsPageComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ViewTransactionsPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
