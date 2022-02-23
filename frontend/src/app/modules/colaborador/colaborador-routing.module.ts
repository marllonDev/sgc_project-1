import { ColaboradorHomeComponent } from './colaborador-home.component';
import { ColaboradorCadastroComponent } from './component/cadastro/colaborador-cadastro.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ColaboradorComponent } from './component/lista/colaborador.component';


const routes: Routes = [
  { path: '', 
    component: ColaboradorHomeComponent,
   children: [
    { path: 'lista', component: ColaboradorComponent},
    { path: 'cadastro', component: ColaboradorCadastroComponent},
    { path: ':id', component: ColaboradorCadastroComponent}
  ]
  }

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ColaboradorRoutingModule { }
