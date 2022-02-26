import { ColaboradorCompetenciaNivel } from './../../model/colaboradorCompetenciaNivel.model';
import {
    CompetenciaModel
} from 'src/app/modules/competencia/model/competencia.models';
import {
    CategoriaCompetenciaListModel
} from './../../model/categoriaCompetenciaList.model';
import {
    CompetenciaService
} from './../../../competencia/service/competencia.service';
import {
    CategoriaService
} from '../../../competencia/service/categoria.service';
import {
    CategoriaModel
} from '../../../competencia/model/categoria.model';
import {
    ActivatedRoute
} from '@angular/router';
import {
    MessageService,
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
    SelectModel
} from '../../model/select.model';



const baseUrl = '/api/colaboradores';

@Component({
    selector: 'app-colaborador-cadastro',
    templateUrl: './colaborador-cadastro.component.html',
    styleUrls: ['./colaborador-cadastro.component.css']
})


export class ColaboradorCadastroComponent implements OnInit {

    colaborador: ColaboradorModel = new ColaboradorModel;
    imagebase64: string = '';
    idColaborador: any;
    imagem: any;
    categorias: SelectModel[] = [];
    competencias: SelectModel[] = [];
    categoriaSelecionada: CategoriaModel;
    competenciaSelecionada: CompetenciaModel;
    categoriaCompetencia: CategoriaCompetenciaListModel[] = [];
    categoriaCompetencias: CategoriaCompetenciaListModel[] = [];


    image: string = 'data:image/jpg;base64,'

    constructor(private colaboradorService: ColaboradorService,
        private messageService: MessageService, private route: ActivatedRoute, private categoriaService: CategoriaService, private competenciaService: CompetenciaService) {}

    ngOnInit() {
        this.idColaborador = this.route.snapshot.paramMap.get('id');
        if (this.idColaborador) {
            this.colaboradorService.findById(this.idColaborador).subscribe((response) => {
                this.colaborador = response;
                this.colaborador.dataAdmissao = new Date(response.dataAdmissao);
                this.colaborador.dataNascimento = new Date(response.dataNascimento);
                this.categoriaCompetencia = this.colaborador.colaboradorCompetencias;
            });
        }
        this.buscarCategorias();
    }

    adicionarCompetencia() {
        let categoriaC = new CategoriaCompetenciaListModel();
        categoriaC.competencia = this.competenciaSelecionada;
        categoriaC.competencia.categoria = this.categoriaSelecionada;
        this.categoriaCompetencia.push(categoriaC);
    }


    buscarCategorias() {
        this.categoriaService.getAll().subscribe((response) => {
            response.map((categoria) => {
                let select = new SelectModel();
                select.label = categoria.nome;
                select.value = categoria;
                this.categorias.push(select);
            });
        })
    }

    buscarCompetencias(event) {
        this.competencias = [];
        this.competenciaService.getAllCompetenciasByCategoriaId(event.value.id).subscribe((response) => {
            response.map((competencia) => {
                let select = new SelectModel();
                select.label = competencia.nome;
                select.value = competencia;
                this.competencias.push(select);
            });
        })
    }


    salvar(severity: string) {
        this.colaborador.colaboradorCompetencias = this.categoriaCompetencia.map((categoriaCompetencia)=>{
            let ccN =  new ColaboradorCompetenciaNivel();
            ccN.competencia = categoriaCompetencia.competencia;
            ccN.nivel = "CONHECE";
            return ccN;
        });
        this.colaborador.foto = this.imagem;
        this.colaboradorService.save(this.colaborador).subscribe((response) => {
            this.colaborador = response;
            this.messageService.add({
                severity: severity,
                summary: 'Sucesso',
                detail: 'Dados Salvos'
            });
        });
    }


    tratarFoto(arquivos: any) {
        this.imagem = arquivos.files[0];
        let fileReader: FileReader = new FileReader();
        fileReader.readAsDataURL(arquivos.files[0]);
        fileReader.onload = (evento: any) => this.converterFoto(evento);
        console.log(arquivos.files[0]);
    }


    converterFoto(evento) {
        this.imagebase64 = evento.srcElement.result;
        console.log(btoa(this.imagebase64));
    }


    deletar(categoriaCompetencia: CategoriaCompetenciaListModel) {
        this.categoriaCompetencias.splice(this.categoriaCompetencias.indexOf(categoriaCompetencia), 1);
        console.log(this.categoriaCompetencias);
    }

   // deletar(categoriaCompetencia: CategoriaCompetenciaListModel) {
     //   this.categoriaService.deletar(categoriaCompetencia.competencia.categoria.id).//subscribe((response) => {
     //      this.categoriaCompetencias.splice(this.categoriaCompetencias.indexOf//(categoriaCompetencia), 1);
     //       this.messageService.add({
     //           severity: 'success',
     //           summary: 'Sucesso',
     //           detail: 'Dados Deletados'
     //       });
    //    });
}


    

