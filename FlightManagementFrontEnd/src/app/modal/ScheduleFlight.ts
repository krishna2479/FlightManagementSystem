import { Flight } from './Flight'
export class SchFlights {

    scheduleflightid:Number;
    sourceAirport:String;
    destinationAirport:String;
    arrivalTime:String;
    departureTime:String;
    arrivalDate:String;
    departureDate:String;
    ticketCost:Number;
    
    flight:Flight = new Flight();


}
