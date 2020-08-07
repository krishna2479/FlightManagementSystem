import { Component, OnInit } from '@angular/core';
import { ScheduleServiceService } from '../schedule-service.service';
import { SchFlights } from '../modal/ScheduleFlight';
@Component({
  selector: 'app-view-all-flight',
  templateUrl: './view-all-flight.component.html',
  styleUrls: ['./view-all-flight.component.css']
})
export class ViewAllFlightComponent implements OnInit {

  constructor(private scheduleservice:ScheduleServiceService) {}
  sflights:SchFlights[]=[];
 

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

  delete(schId: number) {
    this.scheduleservice.deleteSchedule(schId).subscribe(data=> 
      {
        
        this.sflights=data;
        alert("Shedule Deleted Succesfull");
      
     
    },

     error =>
     {
      alert("Shedule Deleted Succesfull");
      console.log("error occured",error);
     });
    }

}
