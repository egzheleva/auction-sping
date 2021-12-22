import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Item } from 'src/app/model/item';
import { HttpClientService } from 'src/app/service/http-client.service';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-item',
  templateUrl: './item.component.html',
  styleUrls: ['./item.component.css']
})
export class ItemComponent implements OnInit {

  item: Item;
  itemId: string;
  closeResult = '';

  constructor(
    private httpClientService:HttpClientService, private router: Router, private route: ActivatedRoute, private modalService: NgbModal
  ) { 
    this.itemId = this.route.snapshot.params.itemId;
  }

  ngOnInit(): void {
    this.httpClientService.getItem(this.itemId).subscribe(
      response => {
        this.item = response;
      }
     );
  }


  open(content) {
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
      // this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      // this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
    });
  }



  submitBid() {
    console.log(this.item.newPrice);
    this.httpClientService.submitBid(this.item).subscribe(
      response => {
        this.modalService.dismissAll();
        this.item = response;
      }
     );
  }
}
