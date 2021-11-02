import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class CadastroServiceFilme {
  private listaCadastroFilme: any[];
  private url = '/Filmes';

  constructor(private httpClient: HttpClient){
    this.listaCadastroFilme = [];
  }

  get cadastros(){
    return this.listaCadastroFilme;
  }

  todos(): Observable<CadastroServiceFilme[]>{
    return this.httpClient.get<CadastroServiceFilme[]>(this.url)
  }

  adicionar(cadastros: any){
    return this.httpClient.post<CadastroServiceFilme[]>(this.url, cadastros);
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
