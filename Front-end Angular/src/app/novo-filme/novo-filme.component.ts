import { Component, EventEmitter, Output } from '@angular/core';
import { Router } from '@angular/router';
import { Filmes } from 'models/filmes';

import { CadastroServiceFilme } from '../services/cadastro-filme.service';

@Component({
  selector:'app-novo-filme',
  templateUrl:'./novo-filme.component.html',
  styleUrls:['./novo-filme.component.scss']
})

export class NovoFilmeComponent{

  @Output() aoCadastrar = new EventEmitter<any>();

  nomeFilme: String;
  ano: Number;

  constructor(private service: CadastroServiceFilme, private router: Router) {}

  novoFilmeCadastrado(){
    console.log('Novo Filme cadastrado!')
    const valoresEmitir: Filmes = { nomeFilme: this.nomeFilme, ano: this.ano };
    this.service.adicionar(valoresEmitir).subscribe(
      (resultado) => {
        console.log(resultado);
        this.limparCampos();
        this.router.navigateByUrl('filmes');
      },
      (error) => console.error(error)
    );
  }

  limparCampos(){
    this.nomeFilme = '';
    this.ano = 0;
  }
}
