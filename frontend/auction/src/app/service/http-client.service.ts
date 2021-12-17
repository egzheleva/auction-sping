import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Campaign } from '../model/campaign';
import { Item } from '../model/item';
import { formatDate } from "@angular/common";

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json',
    // Authorization: 'my-auth-token'
  })
};

export class Auction {
  constructor(
    public empId: string,
    public empName: string, 
    public designation: string, 
    public salary: number
  ) {}
}

@Injectable({
  providedIn: 'root'
})
export class HttpClientService {

  public localID: string;

  constructor(
    private httpClient: HttpClient, 
  ) { }

  // getEmployees() {
  //   console.log("test call");
  //   return this.httpClient.get<Employee[]>('http://localhost:8091/api/employees');
  // }

  // getEmployees(): Observable<Auction[]> {
  //   return this.httpClient.get<Auction[]>('http://localhost:8091/api/employees');
  // }

  getAllCampaigns(): Observable<Campaign[]> {
    return this.httpClient.get<Campaign[]>('http://localhost:8091/campaign/all');
  }


  getItemsForCampaign(campaignId): Observable<Item[]> {
    const params = new HttpParams().set('campaignId', campaignId);
    return this.httpClient.get<Item[]>('http://localhost:8091/item/campaignItems', {params});
  }

  getItem(itemId): Observable<Item> {
    const params = new HttpParams().set('itemId', itemId);
    return this.httpClient.get<Item>('http://localhost:8091/item/itemById', {params});
  }
  
  submitBid(item: Item): Observable<Item> {
    return this.httpClient.post<Item>('http://localhost:8091/item/submitBid', item, httpOptions);
  }

  getUserItems(userId): Observable<Item[]> {
    const params = new HttpParams().set('userId', userId);
    return this.httpClient.get<Item[]>('http://localhost:8091/item/getUserItems', {params});
  }

  // createNewCampaign(createdCampaign: Campaign, fileToUpload: File): Observable<Campaign> {
  //   const formData: FormData = new FormData();
  //   formData.append('fileKey', fileToUpload, fileToUpload.name);
  //   return this.httpClient.post<Campaign>('http://localhost:8091/campaign/createNewCampaign', formData, { headers: {'Content-Type': 'multipart/form-data' }}, );
  // }

  createNewCampaign(createdCampaign: Campaign, filesToUploads: File[]): Observable<any> {

    let headers = new HttpHeaders();
    //this is the important step. You need to set content type as null
    headers.set('Content-Type', null);
    headers.set('Accept', "multipart/form-data");
    const params = new HttpParams()
    .set('campaignName', createdCampaign.campaignName)
    .set('campaignDescription', createdCampaign.campaignDescription)
    .set('validTo', createdCampaign.validTo.toDateString())
    .set('validFrom', createdCampaign.validFrom.toDateString())
    const formData: FormData = new FormData();
    if(filesToUploads.length > 0) {
      for (let i = 0; i < filesToUploads.length; i++) {
        formData.append('filesArray', filesToUploads[i][0], filesToUploads[i][0].name);
      }
    }
   
    return this.httpClient.post('http://localhost:8091/campaign/createNewCampaign', formData, { params, headers });

  }



//   postFile(fileToUpload: File): Observable<boolean> {
//     const endpoint = 'your-destination-url';
//     const formData: FormData = new FormData();
//     formData.append('fileKey', fileToUpload, fileToUpload.name);
//     return this.httpClient
//       .post(endpoint, formData, { headers: {'Content-Type': 'multipart/form-data' }})
//       .map(() => { return true; })
//       .catch((e) => this.handleError(e));
// }

}
