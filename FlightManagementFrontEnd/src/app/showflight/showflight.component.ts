import { Component, OnInit } from '@angular/core';
import { Flight } from '../flight';
import { FlightService } from '../flight.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-showflight',
  templateUrl: './showflight.component.html',
  styleUrls: ['./showflight.component.css']
})
export class ShowflightComponent implements OnInit {
  flights:Flight[]=[];
  constructor(private flightservice:FlightService,private route:Router) { }

  ngOnInit(): void {
    this.flightservice.getAllFlight().subscribe(
      data=>{this.flights=data}
    );
  }

  deleteFlight(flightId:number): void {
    this.flightservice.deleteFlight(flightId).subscribe((data)=>{this.flights=data});
    alert("Flight deleted successfully");

}
  updateFlight(flighId:number){
    console.log(this.flights);
    this.route.navigate(['update',flighId]);
  }
}
