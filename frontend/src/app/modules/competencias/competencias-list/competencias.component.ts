import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Categoria } from '../model/categoria';
import {Message} from 'primeng/api';
import {MessageService} from 'primeng/api'
import {ConfirmationService} from 'primeng/api';

import { Competencia } from '../model/competencia';
import { CompetenciasService } from '../services/competencias.service';

@Component({
  selector: 'app-competencias',
  templateUrl: './competencias.component.html',
  styleUrls: ['./competencias.component.scss']
})
export class CompetenciasComponent implements OnInit {

  competencias: Competencia[];

  msgs: Message[] = [];

  categorias: Categoria[]

  competencia: Competencia;
  
  display: boolean = false;
  
  displayBasic2: boolean;

  currentItem: Competencia | undefined;
  
  constructor(private competenciasService: CompetenciasService, 
    private router: Router,
    private messageService: MessageService,
    private confirmationService: ConfirmationService) {

  
  }

  ngOnInit(): void {

    this.listarCompetencia()

    this.listarCategoria()
    
  }


  listarCompetencia(){

    this.competenciasService.listar()
    .subscribe(
      (competencia) => {
        this.competencias = competencia
      

      }    
    ); 

  }

  listarCategoria(){

    this.competenciasService.listarCategoria()
    .subscribe(
      (categoria) => {
        console.log(categoria)
        this.categorias = categoria
      }
    )

  }

  showBasicDialog2() {
    
    this.display = true;
    this.displayBasic2 = true;
  }

  showEditDialog(){

    this.displayBasic2 = true;

  }

  onEdit(id){

    
    this.competenciasService.listaId(id)
    .subscribe(
      (comp) => {

        this.currentItem = comp;
        
      }
    )

    this.showEditDialog();
  
  } 

  escondeu(){
    this.displayBasic2 = false;
    this.currentItem = undefined;
  }

  onDelete(id){

    this.competenciasService.deletar(id)
    .subscribe({
      next: data => {
       this.listarCompetencia()
      },
      error: error => {
        console.error("error", error);
      }
    }
  
    )

  }

  showSuccess() {

    this.messageService.add({severity:'success', summary: 'Success Message', detail:'Order submitted'});
  }


  reciverFeedback(respostaFilho) {


   this.listarCompetencia()

   this.displayBasic2 = respostaFilho

  }

  confirm(id) {

    this.confirmationService.confirm({
        
        message: 'Tem certeza que deseja excluir esta competência?',
        accept: () => {

            console.log("ok")
            this.msgs = [{severity:'info', summary:'Confirmado', detail:'Competência deletada'}];
            this.onDelete(id);
            //this.listarCompetencia();
        }

        
    });


    
}

  
  

}
