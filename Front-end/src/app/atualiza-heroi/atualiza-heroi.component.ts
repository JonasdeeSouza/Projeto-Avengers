import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { CadastroServiceHeroi } from '../services/cadastro-heroi.service';

@Component({
  selector:'app-atualiza-heroi',
  templateUrl:'./atualiza-heroi.component.html',
  styleUrls:['./atualiza-heroi.component.scss']
})

export class AtualizaHeroiComponent implements OnInit{

  cadastro: any = {nome: '', codinome: ''};

  constructor(
    private service: CadastroServiceHeroi,
    private router: Router,
    private route: ActivatedRoute) {}

  ngOnInit(): void{
    const id = this.route.snapshot.paramMap.get("id");
    this.service.captar(id).subscribe(cadastro => {
      this.cadastro = cadastro;
    });
  }

  onEdit(): void {
    this.service.atualizar(this.cadastro).subscribe(() => {
      console.log('Herói Atualizado!')
      this.router.navigate(["/herois"]);
    })
  }
}
