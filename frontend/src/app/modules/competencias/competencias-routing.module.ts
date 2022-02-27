import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CompetenciasComponent } from './competencias-list/competencias.component';

const routes: Routes = [
  {path: '', component: CompetenciasComponent},
  {path: 'editar/:id', component: CompetenciasComponent},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CompetenciasRoutingModule { }
