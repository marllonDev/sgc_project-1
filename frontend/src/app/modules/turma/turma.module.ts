import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { TurmaRoutingModule } from './turma-routing.module';
import { SharedModule } from 'src/app/shared/shared.module';
import { TurmaListComponent } from './components/turma-list/turma-list.component';
import { TurmaFormComponent } from './components/turma-form/turma-form.component';


@NgModule({
  declarations: [TurmaListComponent, TurmaFormComponent],
  imports: [
    CommonModule,
    TurmaRoutingModule,
    SharedModule
  ]
})
export class TurmaModule { }
