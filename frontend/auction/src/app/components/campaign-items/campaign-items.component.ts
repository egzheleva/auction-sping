import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Item } from 'src/app/model/item';
import { HttpClientService } from 'src/app/service/http-client.service';

@Component({
  selector: 'app-campaign-items',
  templateUrl: './campaign-items.component.html',
  styleUrls: ['./campaign-items.component.css']
})
export class CampaignItemsComponent implements OnInit {

  items:Item[];
  campaignId: string;

  constructor(
    private httpClientService:HttpClientService, private router: Router, private route: ActivatedRoute
  ) { 
    this.campaignId = this.route.snapshot.params.campaignId;
  }

  ngOnInit(): void {
    this.httpClientService.getItemsForCampaign(this.campaignId).subscribe(
      response => this.items = response
     );
  }

  redirectToItem(event, itemId)  {
    event.preventDefault();
    this.router.navigate(['/item', itemId])
  }

}
