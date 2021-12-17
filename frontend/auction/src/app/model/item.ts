export class Item  { 
    public itemId: number;
    public campaignId: number;
    public itemName: string;
    public itemDescription: string;
    public currentPrice: number;
    public bidderId: number;
    public imageNames: any; // fix this to be array of images
    public newPrice: number;
}