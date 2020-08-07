import { Pipe, PipeTransform } from '@angular/core';
import { SchFlights } from './modal/ScheduleFlight'
@Pipe({
  name: 'filterText'
})
export class SearchPipe implements PipeTransform {
  transform(SchFlights: any[], searchText: any):any {
    if(searchText===undefined) return SchFlights;
    else
    {
      return SchFlights.filter(function(x)
      {
        return x.departureDate.toLowerCase().includes(searchText.toLowerCase())
      }

      )
    }
  }
}