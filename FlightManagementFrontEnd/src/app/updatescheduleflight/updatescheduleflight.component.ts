import { Component, OnInit } from '@angular/core';
import { ScheduleServiceService } from '../schedule-service.service';
import { SchFlights } from '../modal/ScheduleFlight';

@Component({
  selector: 'app-updatescheduleflight',
  templateUrl: './updatescheduleflight.component.html',
  styleUrls: ['./updatescheduleflight.component.css']
})
export class UpdatescheduleflightComponent implements OnInit {

  constructor(private scheduleservice:ScheduleServiceService) {}
  sflights:SchFlights[]=[];
  schedule:SchFlights = new SchFlights();
  // flight:Flight = new Flight();
  info:String;
  errorInfo:String;

  schid:Number;
    sourAirport:String;
    destAirport:String;
    arrTime:String;
    depTime:String;
    arrDate:String;
    depDate:String;
    tCost:Number;
    fId:number;


  ngOnInit(): void {
    this.scheduleservice.loadschedule().subscribe(data=>
    {this.sflights=data;
      console.log()
  },
  error=>
  {
    console.log("error occured ",error);
  }
    );


   
  }
  edit(schid, sourAirport,destAirport,arrTime,depTime,arrDate,depDate,tCost, fId){
    this.schid=schid;
    this.sourAirport=sourAirport;
    this.destAirport=destAirport;
    this.arrTime=arrTime;
    this.depTime=depTime;
    this.arrDate=arrDate;
    this.depDate=depDate;
    this.tCost=tCost;
    this.fId=fId;
   
  }

  updateFlight(){
    this.scheduleservice.updateSchedule(this.schedule.scheduleflightid,this.schedule).subscribe(
      data=>{
        this.schedule=data;
        console.log(this.schedule);
        alert("Schedule updated successfully");
        this.errorInfo=undefined;
      },
      error=>{
        this.info=undefined;
        this.errorInfo=error.error;
      }
    );
   
  }





}
