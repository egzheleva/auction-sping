import { Component, OnInit } from '@angular/core';
import { Item } from 'src/app/model/item';
import { HttpClientService } from 'src/app/service/http-client.service';

@Component({
  selector: 'app-user-items',
  templateUrl: './user-items.component.html',
  styleUrls: ['./user-items.component.css']
})
export class UserItemsComponent implements OnInit {

  items:Item[];
  
  constructor( private httpClientService:HttpClientService) { }

  ngOnInit(): void {
    //TODO make authentication and remove hardcoded user
    this.httpClientService.getUserItems(1).subscribe(
      response => this.items = response
     );
  }

}
