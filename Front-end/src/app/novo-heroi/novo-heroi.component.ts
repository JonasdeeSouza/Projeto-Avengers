import { Component, EventEmitter, Output } from '@angular/core';
import { Router } from '@angular/router';

import { CadastroServiceHeroi } from '../services/cadastro-heroi.service';
import { Herois } from './../../../models/herois';

@Component({
  selector:'app-novo-heroi',
  templateUrl:'./novo-heroi.component.html',
  styleUrls:['./novo-heroi.component.scss']
})

export class NovoHeroiComponent{

  @Output() aoCadastrar = new EventEmitter<any>();

  nome: String;
  codinome: String;

  constructor(private service: CadastroServiceHeroi, private router: Router) {}

  novoHeroiCadastrado(){
    console.log('Novo Herói cadastrado!')
    const valoresEmitir: Herois = { nome: this.nome, codinome: this.codinome };
    this.service.adicionar(valoresEmitir).subscribe(
      (resultado) => {
        console.log(resultado);
        this.limparCampos();
        this.router.navigateByUrl('herois');
      },
      (error) => console.error(error)
    );
  }

  limparCampos(){
    this.nome = '';
    this.codinome = '';
  }
}
