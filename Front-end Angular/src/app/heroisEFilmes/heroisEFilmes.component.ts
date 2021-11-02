import { Component, Input, OnInit } from '@angular/core';

import { CadastroServiceHeroisEFilmes } from '../services/cadastro-heroisEFilmes.service';

@Component({
  selector: 'app-heroisEFilmes',
  templateUrl: './heroisEFilmes.component.html',
  styleUrls: ['./heroisEFilmes.component.scss']
})

export class HeroisEFilmesComponent implements OnInit {
  @Input() cadastros: any[];

  filtro = '';

  constructor(private service: CadastroServiceHeroisEFilmes) {}

  ngOnInit() {
    this.service.todos().subscribe((cadastros: CadastroServiceHeroisEFilmes[]) => {
      console.table(cadastros);
      this.cadastros = cadastros;
    });
  }

  onRemove(cadastro: any, filme: any) {
    this.service.remover(cadastro, filme).subscribe(
      (resultado) => {
        console.log('Ligação removida');
        location.reload();
      },
      (error) => console.error(error)
    )
  }
}
