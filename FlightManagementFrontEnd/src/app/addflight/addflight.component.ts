import { Component, OnInit } from '@angular/core';
import { Flight } from '../flight';
import { FlightService } from '../flight.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-addflight',
  templateUrl: './addflight.component.html',
  styleUrls: ['./addflight.component.css']
})
export class AddflightComponent {

  flight:Flight = new Flight();
  info:String;
  errorInfo:String;

  constructor(private flightservice:FlightService, private route: Router) { }

  addFlight(){
    this.flightservice.addFlight(this.flight).subscribe(
      data=>{
        this.flight=data;
        console.log(this.flight);
        this.route.navigateByUrl("/show");
        alert("Flight added successfully");
        this.errorInfo=undefined;
      },
      error=>{
        this.info=undefined;
        this.errorInfo=error.error;
      }
    );
   
  }

}
