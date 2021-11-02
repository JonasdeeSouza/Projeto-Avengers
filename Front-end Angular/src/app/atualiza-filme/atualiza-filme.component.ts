import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { CadastroServiceFilme } from './../services/cadastro-filme.service';

@Component({
  selector:'app-atualiza-filme',
  templateUrl:'./atualiza-filme.component.html',
  styleUrls:['./atualiza-filme.component.scss']
})

export class AtualizaFilmeComponent implements OnInit{

  cadastro: any = {nomeFilme: '', ano: ''};

  constructor(
    private service: CadastroServiceFilme,
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
      console.log('Filme Atualizado!')
      this.router.navigate(["/filmes"]);
    })
  }
}
