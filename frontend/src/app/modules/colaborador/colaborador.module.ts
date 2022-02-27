import { NivelService } from './service/nivel.service';
import { ColaboradorService } from './service/colaborador.service';
import { ColaboradorHomeComponent } from './colaborador-home.component';
import { ColaboradorCadastroComponent } from './component/cadastro/colaborador-cadastro.component';
import { SharedModule } from './../../shared/shared.module';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ColaboradorRoutingModule } from './colaborador-routing.module';
import { ColaboradorComponent } from './component/lista/colaborador.component';
import { CategoriaModel } from '../competencia/model/categoria.model';





@NgModule({
  declarations: [ColaboradorCadastroComponent, ColaboradorComponent, ColaboradorHomeComponent],
  imports: [
    SharedModule,
    CommonModule,
    ColaboradorRoutingModule
  ],
  providers: [ColaboradorService, NivelService]
})
export class ColaboradorModule { }
