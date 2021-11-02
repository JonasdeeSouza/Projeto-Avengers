import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { AtualizaFilmeComponent } from './atualiza-filme/atualiza-filme.component';
import { AtualizaHeroiComponent } from './atualiza-heroi/atualiza-heroi.component';
import { FilmesComponent } from './filmes/filmescomponent';
import { HeroisComponent } from './herois/herois.component';
import { HeroisEFilmesComponent } from './heroisEFilmes/heroisEFilmes.component';
import { HomeComponent } from './home/home.component';
import { NovoFilmeComponent } from './novo-filme/novo-filme.component';
import { NovoHeroiComponent } from './novo-heroi/novo-heroi.component';
import { NovoHeroisEFilmesComponent } from './novo-heroisEFilmes/novo-heroisEFilmes.component';

export const routes: Routes = [
  {path: '', redirectTo: 'home', pathMatch: 'full'},
  {path: 'home', component: HomeComponent},
  {path: 'herois', component: HeroisComponent},
  {path: 'novo-heroi', component: NovoHeroiComponent},
  {path: 'atualiza-heroi/:id', component: AtualizaHeroiComponent},
  {path: 'filmes', component: FilmesComponent},
  {path: 'novo-filme', component: NovoFilmeComponent},
  {path: 'atualiza-filme/:id', component: AtualizaFilmeComponent},
  {path: 'heroisEFilmes', component: HeroisEFilmesComponent},
  {path: 'novo-heroisEFilmes', component: NovoHeroisEFilmesComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})

export class AppRoutingModule {}
