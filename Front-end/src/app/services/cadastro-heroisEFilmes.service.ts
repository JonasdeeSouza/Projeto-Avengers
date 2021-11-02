import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class CadastroServiceHeroisEFilmes {
  private listaCadastroHeroi: any[];
  private url = '/HeroisEFilmes';

  constructor(private httpClient: HttpClient){
    this.listaCadastroHeroi = [];
  }

  get cadastros(){
    return this.listaCadastroHeroi;
  }

  todos(): Observable<CadastroServiceHeroisEFilmes[]>{
    return this.httpClient.get<CadastroServiceHeroisEFilmes[]>(this.url)
  }

  adicionar(cadastro: any){
    return this.httpClient.post<CadastroServiceHeroisEFilmes[]>(this.url + '/' + cadastro.idHeroi + '/' + cadastro.idFilme, null);
  }

  remover(cadastro: any, filme: any) {
    console.log(cadastro);
    return this.httpClient.delete(this.url + '/' + cadastro.id + '/' + filme.id);
  }
}
