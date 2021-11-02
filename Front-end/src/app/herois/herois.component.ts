import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { CadastroServiceHeroi } from './../services/cadastro-heroi.service';

@Component({
  selector: 'app-herois',
  templateUrl: './herois.component.html',
  styleUrls: ['./herois.component.scss']
})

export class HeroisComponent implements OnInit {
  @Input() cadastros: any[] = [];

  constructor(private service: CadastroServiceHeroi,
     private router: Router,
     private route: ActivatedRoute) {}

  ngOnInit() {
    this.service.todos().subscribe((cadastros: CadastroServiceHeroi[]) => {
      console.table(cadastros);
      this.cadastros = cadastros;
    });
  }

  onRemove(cadastros: any) {
    this.service.remover(cadastros.id).subscribe(
      (resultado) => {
        console.log('Herói removido');
        location.reload();
      },
      (error) => console.error(error)
    );
  }
}
