import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TurmaFormComponent } from './components/turma-form/turma-form.component';
import { TurmaListComponent } from './components/turma-list/turma-list.component';


const routes: Routes = [
    { path: '', component: TurmaListComponent, pathMatch: 'full' },
    { path: ':id', component: TurmaFormComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class TurmaRoutingModule { }
