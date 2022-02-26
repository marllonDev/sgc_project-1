import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { TurmaRoutingModule } from './turma-routing.module';
import { SharedModule } from 'src/app/shared/shared.module';
import { TurmaListComponent } from './components/turma-list/turma-list.component';
import { TurmaFormComponent } from './components/turma-form/turma-form.component';
import { ConfirmationService } from 'primeng';


@NgModule({
  declarations: [TurmaListComponent, TurmaFormComponent],
  imports: [
    CommonModule,
    TurmaRoutingModule,
    SharedModule
  ],
  providers: [ConfirmationService]
})
export class TurmaModule { }
