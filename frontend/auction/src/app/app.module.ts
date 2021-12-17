import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { NgbModule, NgbDateAdapter, NgbDateNativeAdapter } from '@ng-bootstrap/ng-bootstrap';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { EmployeeComponent } from './components/employee/employee.component';
import { HttpClientModule } from '@angular/common/http';
import { CampaignComponent } from './components/campaign/campaign.component';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CampaignItemsComponent } from './components/campaign-items/campaign-items.component';
import { ItemComponent } from './components/item/item.component';
import { FormsModule } from '@angular/forms';
import { UserItemsComponent } from './components/user-items/user-items.component';
import { RegisterComponent } from './components/register/register.component';
import { UserProfileComponent } from './components/user-profile/user-profile.component';
import { LoginComponent } from './components/login/login.component';

import { authInterceptorProviders } from './_helpers/auth.interceptor';
import { HomeComponent } from './components/home/home.component';


@NgModule({
  declarations: [
    AppComponent,
    EmployeeComponent,
    CampaignComponent,
    HeaderComponent,
    FooterComponent,
    CampaignItemsComponent,
    ItemComponent,
    UserItemsComponent,
    LoginComponent,
    RegisterComponent,
    UserProfileComponent,
    HomeComponent
  ],
  imports: [    
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    FontAwesomeModule,
    NgbModule
  ],
  providers: [{
    provide: NgbDateAdapter,
    useClass: NgbDateNativeAdapter
  }, authInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
