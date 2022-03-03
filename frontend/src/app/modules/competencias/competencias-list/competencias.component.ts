import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Categoria } from '../model/categoria';
import {Message} from 'primeng/api';
import {MessageService} from 'primeng/api'
import {ConfirmationService} from 'primeng/api';

import { Competencia } from '../model/competencia';
import { CompetenciasService } from '../services/competencias.service';
import { BlockUIService } from 'ng-block-ui';
import { finalize } from 'rxjs/operators';

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
  yearTimeout: any

  currentItem: Competencia | undefined;

  constructor(private competenciasService: CompetenciasService,
    private router: Router,
    private messageService: MessageService,
    private confirmationService: ConfirmationService,
    private blockUI: BlockUIService,
    ) {


  }

  ngOnInit(): void {

    this.listarCompetencia()

    this.listarCategoria()

  }


  listarCompetencia(){
    this.blockUI.start("Carregando Competencias");
    this.competenciasService.listar().pipe(finalize(() => this.blockUI.stop("Carregadas")))
    .subscribe((res) => {
        if(res){
            this.competencias = res;
            this.messageService.add({severity: 'success', summary: 'Sucesso', detail: 'Compentencias Listadas'})
        }
    }, () => this.messageService.add({severity: 'error', summary: 'Erro', detail: 'Erro ao listar competências'})

    )
}

  listarCategoria(){

    this.competenciasService.listarCategoria()
    .subscribe(
      (categoria) => {
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
        this.messageService.add({severity: 'error', summary: 'Erro', detail: 'Erro ao listar competências'})
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



