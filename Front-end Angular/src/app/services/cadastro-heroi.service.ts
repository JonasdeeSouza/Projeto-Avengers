import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class CadastroServiceHeroi {
  private listaCadastroHeroi: any[];
  private url = '/Herois';

  constructor(private httpClient: HttpClient){
    this.listaCadastroHeroi = [];
  }

  get cadastros(){
    return this.listaCadastroHeroi;
  }

  todos(): Observable<CadastroServiceHeroi[]>{
    return this.httpClient.get<CadastroServiceHeroi[]>(this.url)
  }

  adicionar(cadastros: any): Observable<CadastroServiceHeroi[]>{
    return this.httpClient.post<CadastroServiceHeroi[]>(this.url, cadastros);
  }

  remover(id) {
    return this.httpClient.delete(`${this.url}/${id}`);
  }

  captar(id: string){
    const url = `${this.url}/${id}`
    return this.httpClient.get(url);
  }

  atualizar(cadastro: any) {
    const url = `${this.url}/${cadastro.id}`
    return this.httpClient.put(url, cadastro);
  }
}
