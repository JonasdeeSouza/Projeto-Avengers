import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AtualizaFilmeComponent } from './atualiza-filme/atualiza-filme.component';
import { AtualizaHeroiComponent } from './atualiza-heroi/atualiza-heroi.component';
import { FilmesComponent } from './filmes/filmescomponent';
import { HeroisComponent } from './herois/herois.component';
import { HeroisEFilmesComponent } from './heroisEFilmes/heroisEFilmes.component';
import { FilterPipe } from './heroisEFilmes/heroisefilmes.pipe';
import { HomeComponent } from './home/home.component';
import { NovoFilmeComponent } from './novo-filme/novo-filme.component';
import { NovoHeroiComponent } from './novo-heroi/novo-heroi.component';
import { NovoHeroisEFilmesComponent } from './novo-heroisEFilmes/novo-heroisEFilmes.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NovoHeroiComponent,
    HeroisComponent,
    AtualizaHeroiComponent,
    NovoFilmeComponent,
    FilmesComponent,
    NovoHeroisEFilmesComponent,
    HeroisEFilmesComponent,
    AtualizaFilmeComponent,
    FilterPipe
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
