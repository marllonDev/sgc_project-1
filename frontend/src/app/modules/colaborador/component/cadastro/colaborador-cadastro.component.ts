
import {
    CategoriaModel
} from './../../../competencia/model/categoria.model';
import {
    CompetenciaModel
} from './../../../competencia/model/competencia.models';
import {
    ActivatedRoute
} from '@angular/router';
import {
    MessageService,
    MenuItem
} from 'primeng/api';
import {
    Component,
    OnInit
} from '@angular/core';

import {
    ColaboradorService
} from './../../service/colaborador.service';
import {
    ColaboradorModel
} from '../../model/colaborador.model';
import {
    DomSanitizer
} from '@angular/platform-browser';

const baseUrl = '/api/colaboradores';

@Component({
    selector: 'app-colaborador-cadastro',
    templateUrl: './colaborador-cadastro.component.html',
    styleUrls: ['./colaborador-cadastro.component.css']
})


export class ColaboradorCadastroComponent implements OnInit {

    //categoria: CategoriaModel;
    categorias: CategoriaModel[];
    colaborador: ColaboradorModel = new ColaboradorModel;
    imagebase64: string = '';
    idColaborador: any;

    image: string = 'data:image/jpg;base64,'

    constructor(private colaboradorService: ColaboradorService,
        private messageService: MessageService, private route: ActivatedRoute, private _sanitizer: DomSanitizer) {
         this.categorias = [
           //{label:'Categoria', value: this.categoria}
          ]
        }

    ngOnInit() {
        this.idColaborador = this.route.snapshot.paramMap.get('id');
        if (this.idColaborador) {
            this.colaboradorService.findById(this.idColaborador).subscribe((response) => {
                this.colaborador = response;
                this.colaborador.dataAdmissao = new Date(response.dataAdmissao);
                this.colaborador.dataNascimento = new Date(response.dataNascimento);
            });
        }

        

    }

    //domSanitizer() {
     //   this._sanitizer.bypassSecurityTrustUrl(this.imagebase64);
    //}

    //validarEmail(email) {
    //   var re = /\S+@\S+\.\S+/;
    //  return re.test(email);
    //}

   // pegarCategorias() {
   //     this.categoriaService.getAll().subscribe(response => {
   //         this.categoria = response;
   //     });
   // }



    salvar(severity: string) {
        this.colaboradorService.save(this.colaborador).subscribe((response) => {
            this.colaborador = response;
            this.messageService.add({
                severity: severity,
                summary: 'Sucesso',
                detail: 'Dados Salvos'
            });
        })
    }

    tratarFoto(arquivos: any) {
        console.log(arquivos);
        let fileReader: FileReader = new FileReader();
        fileReader.readAsDataURL(arquivos.files[0]);
        fileReader.onload = (evento: any) => this.converterFoto(evento);
    }

    converterFoto(evento){
        this.imagebase64 = evento.srcElement.result;
    }
}
