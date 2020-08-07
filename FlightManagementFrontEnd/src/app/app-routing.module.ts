import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ShowflightComponent } from './showflight/showflight.component';
import { AddflightComponent } from './addflight/addflight.component';
import { from } from 'rxjs';
import { UpdateflightComponent } from './updateflight/updateflight.component';
import { SearchflightComponent } from './searchflight/searchflight.component';
import { HomepageComponent } from './homepage/homepage.component';
import { ContactformComponent } from './contactform/contactform.component';
import { ViewAllFlightComponent } from './view-all-flight/view-all-flight.component';
import { AddscheduleflightComponent } from './addscheduleflight/addscheduleflight.component';
import { UpdatescheduleflightComponent } from './updatescheduleflight/updatescheduleflight.component';
import { SearchscheduleFlightComponent } from './searchscheduleflight/searchscheduleflight.component';
const routes: Routes = [
  {path:"add",component : AddflightComponent},
  {path:"search",component : SearchflightComponent},
  {path:"show",component : ShowflightComponent},
  {path:"update",component : UpdateflightComponent},
  {path:"home",component : HomepageComponent},
  {path:"update/:flightId",component : UpdateflightComponent},
  {path:"contact",component : ContactformComponent},
  {path:"viewschedule",component:ViewAllFlightComponent},
  {path:"addschedule", component:AddscheduleflightComponent},
  {path:"updateschedule", component:UpdatescheduleflightComponent},
  {path:"searchschedule", component:SearchscheduleFlightComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
