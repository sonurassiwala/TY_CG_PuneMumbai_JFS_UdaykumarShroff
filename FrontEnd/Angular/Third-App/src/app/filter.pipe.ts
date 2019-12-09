import { Pipe, PipeTransform } from '@angular/core';
import { Employee } from './employee';

@Pipe({
  name: 'filter'
})
export class FilterPipe implements PipeTransform {

  transform(employees: Employee[], search: string): Employee[] {
    if (search === undefined) {
      return employees;
    } else {
      return employees.filter((value, index, array) => {
        return value.name.toLowerCase().includes(search.toLowerCase());
      });
    }
  }
}
