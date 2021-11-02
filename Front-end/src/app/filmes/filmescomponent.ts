import { Component, Input, OnInit } from '@angular/core';

import { CadastroServiceFilme } from '../services/cadastro-filme.service';

@Component({
  selector: 'app-filmes',
  templateUrl: './filmes.component.html',
  styleUrls: ['./filmes.component.scss']
})

export class FilmesComponent implements OnInit {
  @Input() cadastros: any[];

  constructor(private service: CadastroServiceFilme) {}

  ngOnInit() {
    this.service.todos().subscribe((cadastros: CadastroServiceFilme[]) => {
      console.table(cadastros);
      this.cadastros = cadastros;
    });
  }

  onRemove(cadastros: any) {
    this.service.remover(cadastros.id).subscribe(
      (resultado) => {
        console.log('Filme removido');
        location.reload();
      },
      (error) => console.error(error)
    );
  }
}
