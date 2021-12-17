import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CampaignItemsComponent } from './components/campaign-items/campaign-items.component';
import { CampaignComponent } from './components/campaign/campaign.component';
import { EmployeeComponent } from './components/employee/employee.component';
import { HomeComponent } from './components/home/home.component';
import { ItemComponent } from './components/item/item.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { UserItemsComponent } from './components/user-items/user-items.component';
import { UserProfileComponent } from './components/user-profile/user-profile.component';

const routes: Routes = [
  { path:'campaigns', component: CampaignComponent},
  { path: 'campaign/:campaignId', component: CampaignItemsComponent },
  { path: 'item/:itemId', component: ItemComponent },
  { path: 'userItems', component: UserItemsComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'user-profile', component: UserProfileComponent },
  // { path: 'home', component: HomeComponent },
  { path: '', redirectTo: 'campaigns', pathMatch: 'full' }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
