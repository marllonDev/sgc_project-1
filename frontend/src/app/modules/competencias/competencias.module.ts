import { CommonModule } from '@angular/common';
import {  NgModule } from '@angular/core';


import { CompetenciasRoutingModule } from './competencias-routing.module';
import { CompetenciasComponent } from './competencias-list/competencias.component';
import { SharedModule } from 'src/app/shared/shared.module';
import { CompetenciasFormComponent } from './competencias-form/competencias-form.component';

@NgModule({
  declarations: [
    CompetenciasComponent,
    CompetenciasFormComponent
  ],
  imports: [
    CommonModule,
    CompetenciasRoutingModule,
    SharedModule
  
  
  ]
})
export class CompetenciasModule { }
