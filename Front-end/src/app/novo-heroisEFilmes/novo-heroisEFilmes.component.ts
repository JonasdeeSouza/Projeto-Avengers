import { Component, EventEmitter, Output } from '@angular/core';
import { Router } from '@angular/router';
import { HeroisEFilmes } from 'models/heroisEFilmes';

import { CadastroServiceHeroisEFilmes } from '../services/cadastro-heroisEFilmes.service';


@Component({
  selector:'app-novo-heroisEFilmes',
  templateUrl:'./novo-heroisEFilmes.component.html',
  styleUrls:['./novo-heroisEFilmes.component.scss']
})

export class NovoHeroisEFilmesComponent{

  @Output() aoCadastrar = new EventEmitter<any>();

  idHeroi: String;
  idFilme: String;

  constructor(private service: CadastroServiceHeroisEFilmes, private router: Router) {}

  novoHeroisEFilmesCadastrado(){
    console.log('Novo Heróis e Filmes cadastrado!')
    const valoresEmitir: HeroisEFilmes = { idHeroi: this.idHeroi, idFilme: this.idFilme };
    this.service.adicionar(valoresEmitir).subscribe(
      (resultado) => {
        console.log(resultado);
        this.limparCampos();
        this.router.navigateByUrl('heroisEFilmes');
      },
      (error) => console.error(error)
    );
  }

  limparCampos(){
    this.idHeroi = '';
    this.idFilme = '';
  }
}
