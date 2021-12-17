import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CampaignItemsComponent } from './campaign-items.component';

describe('CampaignItemComponent', () => {
  let component: CampaignItemsComponent;
  let fixture: ComponentFixture<CampaignItemsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CampaignItemsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CampaignItemsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
