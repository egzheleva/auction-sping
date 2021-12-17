import { Component, OnInit, ViewChild, TemplateRef} from '@angular/core';
import { Campaign } from 'src/app/model/campaign';
import { HttpClientService } from 'src/app/service/http-client.service';
import { Router } from "@angular/router";
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { faCoffee } from '@fortawesome/free-solid-svg-icons';


@Component({
  selector: 'app-campaign',
  templateUrl: './campaign.component.html',
  styleUrls: ['./campaign.component.css']
})
export class CampaignComponent implements OnInit {

  campaigns:Campaign[];
  @ViewChild('newCampaign') templateRef: TemplateRef<any>;
  createdCampaign: Campaign;
  faCoffee = faCoffee;
  filesToUpload: File[] | null = null;

  constructor(
    private httpClientService:HttpClientService, private router: Router, private modalService: NgbModal
  ) { }

  ngOnInit(): void {
    this.createdCampaign = new Campaign();
    this.filesToUpload = [];
    this.getAllCampaigns();
  }

  getAllCampaigns() {
    this.httpClientService.getAllCampaigns().subscribe(
      response => this.campaigns = response
     );
  }

  redirectToCampaign(event, campaingId)  {
    event.preventDefault();
    this.router.navigate(['/campaign', campaingId])
  }

  open(newCampaign) {
    this.modalService.open(newCampaign, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
      // this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      // this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
    });
  }

  handleFileInput(file: File) {
    this.filesToUpload.push(file);
}

  createNewCampaign() {
    this.httpClientService.createNewCampaign(this.createdCampaign, this.filesToUpload).subscribe(
      response => {
        //this.item = response;
        this.modalService.dismissAll();
        this.getAllCampaigns();
      }
     );
  }


// uploadFileToActivity() {
//   this.httpClientService.postFile(this.fileToUpload).subscribe(data => {
//     // do something, if upload success
//     }, error => {
//       console.log(error);
//     });
// }
}
