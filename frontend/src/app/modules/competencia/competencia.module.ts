import { CategoriaService } from './service/categoria.service';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CompetenciaRoutingModule } from './competencia-routing.module';


@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    CompetenciaRoutingModule
  ],
  providers: [CategoriaService]
})
export class CompetenciaModule { }
