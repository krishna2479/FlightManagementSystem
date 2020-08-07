import { Component, OnInit } from '@angular/core';
import { Flight } from '../flight';
import { Router } from '@angular/router';
import { FlightService } from '../flight.service';

@Component({
  selector: 'app-searchflight',
  templateUrl: './searchflight.component.html',
  styleUrls: ['./searchflight.component.css']
})
export class SearchflightComponent {

  flight:Flight =new Flight();
  info:String;
  errorInfo:String;

  constructor(private flightservice:FlightService,private route:Router) { }

  searchFlight(){
    this.flightservice.searchFlight(this.flight.flightId,this.flight).subscribe(
      data=>{
        this.flight=data;
        console.log(this.flight);
        alert("Flight Found successfully");
        this.errorInfo=undefined;
      },
      error=>{
        this.info=undefined;
        this.errorInfo=error.error;
      }
    );
   
  }

}
