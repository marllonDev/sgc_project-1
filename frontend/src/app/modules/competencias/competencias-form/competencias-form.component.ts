import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { MessageService } from 'primeng/api';
import {SelectItem} from 'primeng/api';


import { Categoria } from '../model/categoria';
import { CompetenciasService } from '../services/competencias.service';


@Component({
  selector: 'app-competencias-form',
  templateUrl: './competencias-form.component.html',
  styleUrls: ['./competencias-form.component.css']
})
export class CompetenciasFormComponent implements OnInit {



  categorias: SelectItem[];

  categorias1: Categoria[];

  selectedCat: Categoria;

  submitted: boolean;

  formulario: FormGroup;

  display: boolean;

  @Input() competencia;

  @Output() respForm: EventEmitter<boolean> = new EventEmitter();

  constructor(private competenciasService: CompetenciasService, private fb: FormBuilder,private messageService: MessageService,
    private route: Router) { }


  ngOnInit(): void {

    this.novoFormulario()

    this.listarCategoria()


  };

  novoFormulario(){
    this.formulario = this.fb.group({
      id: [null, Validators.required],
      nome: [null, [Validators.required,Validators.minLength(3)]],
      descricao: [null, Validators.required],
      idCategoria: [null, Validators.required]
    });

  }

  listarCategoria(){

    this.competenciasService.listarCategoria()
    .subscribe(
      (categoria) => {


        this.categorias = categoria


        if(this.competencia){

          this.atualizaForm(this.competencia)

        }

      }
    )

  }

  onSubmit(){


    if(this.formulario.valid){

      this.formulario.patchValue(this.formulario)

      if(this.formulario.value.id){


        this.competenciasService.atualizar(this.formulario.value).subscribe(

          success => this.showSuccess("Competência atualizada com sucesso"),
          error => this.showError(),

        )

      }else{

        this.competenciasService.postar(this.formulario.value).subscribe(

          success => this.showSuccess("Competência criada com sucesso"),
          error => this.showError(),

        )

      }

    }

  }

  atualizaForm(competencia){

    this.formulario.patchValue(competencia)

  }

  showSuccess(message) {

    this.messageService.add({severity:'success', summary: 'Success Message', detail: message});
    this.fecharForm(false);



  }

  showError() {
    this.messageService.add({severity:'error', summary: 'Error Message', detail:'Erro ao adicionar competência'});
  }

  fecharForm(val){

    this.respForm.emit(val);

  }



}
