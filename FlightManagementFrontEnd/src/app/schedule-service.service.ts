import { Injectable } from '@angular/core';
import { SchFlights } from './modal/ScheduleFlight';
import {HttpClient, HttpClientModule} from '@angular/common/http';
import {Observable} from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class ScheduleServiceService {
  schflights: SchFlights[]=[];

  constructor(private http:HttpClient) { }

  loadschedule():Observable<any>
  {
    let  url = "http://localhost:1140/getScheduleAllFlight";

    return this.http.get(url);
  }
  deleteSchedule(schId:number):Observable<any>
  {
      let url="http://localhost:1140/DeleteById/";
      return this.http.delete(url+schId);
  }
  addNewSchedule(schedule:SchFlights):Observable<any>
  {
    let url="http://localhost:1140/addScheduleFlight";

    return this.http.post(url,schedule,{responseType:'text'});
  }
  updateSchedule(schId:Number,shedule:SchFlights):Observable<any>
  {
    let url="http://localhost:1140/updateSchFlight/";
    return this.http.put(url+schId,shedule,{responseType:'text'});
  }
  searchSchedule(schId:Number,shedule:SchFlights):Observable<any>
  {
    let url="http://localhost:1140/SearchScheduleFlightById/";
      return this.http.get(url+schId);
  }
 

}
