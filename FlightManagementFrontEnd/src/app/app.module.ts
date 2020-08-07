import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ShowflightComponent } from './showflight/showflight.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AddflightComponent } from './addflight/addflight.component';
import { UpdateflightComponent } from './updateflight/updateflight.component';
import { SearchflightComponent } from './searchflight/searchflight.component';
import { HomepageComponent } from './homepage/homepage.component';
import { ContactformComponent } from './contactform/contactform.component';
import { ViewAllFlightComponent } from './view-all-flight/view-all-flight.component';
import { SearchPipe } from './search.pipe';
import { AddscheduleflightComponent } from './addscheduleflight/addscheduleflight.component';
import { UpdatescheduleflightComponent } from './updatescheduleflight/updatescheduleflight.component';
import { SearchscheduleFlightComponent } from './searchscheduleflight/searchscheduleflight.component';


@NgModule({
  declarations: [
    AppComponent,
    ShowflightComponent,
    AddflightComponent,
    UpdateflightComponent,
    SearchflightComponent,
    HomepageComponent,
    ContactformComponent,
    ViewAllFlightComponent,
    AddscheduleflightComponent,
    UpdatescheduleflightComponent,
    SearchscheduleFlightComponent,
    SearchPipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
