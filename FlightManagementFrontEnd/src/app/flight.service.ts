import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Flight } from './flight';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FlightService {

  private Flights: Flight[]=[];

  constructor(private http:HttpClient) { }

  getAllFlight():Observable<any>{
    return this.http.get("http://localhost:1140/getAllFlight")
  }

  addFlight(flight:Flight):Observable<any>{
    return this.http.post("http://localhost:1140/addFlight",flight,{responseType:"text"});
  }

  searchFlight(flightId:number,flight:Flight):Observable<any>{
    return this.http.get<Flight>("http://localhost:1140/find/"+flightId);
  }

  deleteFlight(flightId:number):Observable<any>{
    return this.http.delete("http://localhost:1140/deleteFlight/"+flightId);
  }

  updateFlight(flightId:number,flight:Flight):Observable<any>{
    return this.http.put("http://localhost:1140/updateFlight/"+flightId,flight,{responseType:"text"});
  }
}
