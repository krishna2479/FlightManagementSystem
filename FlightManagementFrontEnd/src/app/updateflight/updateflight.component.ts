import { Component, OnInit } from '@angular/core';
import { Flight } from '../flight';
import { Router, ActivatedRoute } from '@angular/router';
import { FlightService } from '../flight.service';

@Component({
  selector: 'app-updateflight',
  templateUrl: './updateflight.component.html',
  styleUrls: ['./updateflight.component.css']
})
export class UpdateflightComponent implements OnInit{

  flight:Flight = new Flight();
  flightId:number;
  info:String;
  errorInfo:String;
  
  constructor(private flightservice:FlightService,private router:Router,private route:ActivatedRoute) { }

  updateFlight(){
    this.flightservice.updateFlight(this.flight.flightId,this.flight).subscribe(
      data=>{
        this.flight=data;
        console.log(this.flight);
        this.router.navigateByUrl("/show");
        alert("Flight updated successfully");
        this.errorInfo=undefined;
      },
      error=>{
        this.info=undefined;
        this.errorInfo=error.error;
      }
    );
   
  }
  ngOnInit(){
    this.flightId = this.route.snapshot.params['flightId'];
    this.flightservice.searchFlight(this.flightId,this.flight).subscribe(data=>this.flight=data)
  }

}
