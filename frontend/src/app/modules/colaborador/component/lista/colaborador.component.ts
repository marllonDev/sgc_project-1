import { ColaboradorService } from './../../service/colaborador.service';
import { ColaboradorModel } from './../../model/colaborador.model';
import { ColaboradorListModel } from './../../model/colaboradorList.model';

import { MenuItem, MessageService } from 'primeng/api';
import { OnInit, Component } from '@angular/core';
import { Router } from '@angular/router';





@Component({
  selector: 'app-colaborador',
  templateUrl: 'colaborador.component.html',
  styleUrls: ['colaborador.component.css']
})

export class ColaboradorComponent implements OnInit {

  items: MenuItem[];
  colaboradores: ColaboradorListModel[];
  colaborador: ColaboradorModel;

  constructor(private colaboradorService: ColaboradorService, 
    private messageService: MessageService,  private router: Router) { }

  ngOnInit(): void {
    this.colaboradorService.getAll().subscribe(response => {
      this.colaboradores = response;

      this.items = [
        {label: 'Update', icon: 'pi pi-refresh', command: () => {
            this.update();
        }},
        {label: 'Delete', icon: 'pi pi-times', command: () => {
            this.delete();
        }},
    ];  
    
    });    
  }

 adicionar(){
    this.router.navigate(['colaboradores/cadastro']);
 }

  save(colaborador: ColaboradorModel) {
    this.colaboradorService.save(this.colaborador).subscribe((response) => {
      this.colaborador = response;
    });
  }

  update() {
    this.messageService.add({severity:'success', summary:'Success', detail:'Data Updated'});
  }
  
  delete() {
    this.messageService.add({severity:'success', summary:'Success', detail:'Data Deleted'});
  }
  
  //save(severity: string) {
  //this.messageService.add({severity: severity, summary:'Success', detail:'Data Saved'});
  //}
  

}



