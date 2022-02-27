import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TurmaFormComponent } from '../turma/components/turma-form/turma-form.component';
import { CompetenciasComponent } from './competencias-list/competencias.component';

const routes: Routes = [
  { path: '', component: CompetenciasComponent, pathMatch: 'full' },
  
];

@NgModule({
imports: [RouterModule.forChild(routes)],
exports: [RouterModule]
})
export class CompetenciasRoutingModule { }