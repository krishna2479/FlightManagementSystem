import { Component, OnInit } from '@angular/core';
import { SchFlights } from '../modal/ScheduleFlight';
import { ScheduleServiceService } from '../schedule-service.service';
@Component({
  selector: 'app-addscheduleflight',
  templateUrl: './addscheduleflight.component.html',
  styleUrls: ['./addscheduleflight.component.css']
})
export class AddscheduleflightComponent implements OnInit {

  schedule:SchFlights = new SchFlights();
  constructor(private scheduleservice:ScheduleServiceService) {}

  ngOnInit() {
  }

  public addSchedule():void
  {
    this.scheduleservice.addNewSchedule(this.schedule).subscribe(data=>{
      alert("Added Schedule Flight Successfully"+this.schedule.scheduleflightid);


    
    },
    error=>
    {
      console.log("error occured ",error);
    }
    );
  }

}
