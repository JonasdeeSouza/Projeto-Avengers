import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
    name: 'filtro'
})

export class FilterPipe implements PipeTransform {

  transform(items: any[], filter: string): any {
    if(!items || !filter) {
      return items;
    }
    return items.filter(item => JSON.stringify(item).indexOf(filter) !== -1);
  }
}
