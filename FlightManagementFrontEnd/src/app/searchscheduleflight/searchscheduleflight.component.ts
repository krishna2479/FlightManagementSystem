import { Component, OnInit } from '@angular/core';
import { SchFlights } from '../modal/ScheduleFlight';
import { ScheduleServiceService } from '../schedule-service.service';
@Component({
  selector: 'app-searchscheduleflight',
  templateUrl: './searchscheduleflight.component.html',
  styleUrls: ['./searchscheduleflight.component.css']
})
export class SearchscheduleFlightComponent implements OnInit {

  constructor(private scheduleservice:ScheduleServiceService) {}
  info:String;
  errorInfo:String;
  sflights:SchFlights[]=[];
  schedule:SchFlights = new SchFlights();
  ngOnInit(){}
  searchFlight(){
    this.scheduleservice.searchSchedule(this.schedule.scheduleflightid,this.schedule).subscribe(
      data=>{
        this.schedule=data;
        console.log(this.schedule);
        alert("Scheduled Flight Found successfully");
        this.errorInfo=undefined;
      },
      error=>{
        this.info=undefined;
        this.errorInfo=error.error;
      }
    );
   
  }
  



}
