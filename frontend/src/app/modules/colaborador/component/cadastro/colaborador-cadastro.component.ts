import {
    ColaboradorCompetenciaNivel
} from './../../model/colaboradorCompetenciaNivel.model';
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
} from '../../service/colaborador.service';
import {
    ColaboradorModel
} from '../../model/colaborador.model';
import {
    SelectModel
} from '../../model/select.model';
import {
    NivelService
} from '../../service/nivel.service';
import { type } from 'os';
import { DomSanitizer, SafeResourceUrl } from '@angular/platform-browser';



const baseUrl = '/api/colaboradores';

@Component({
    selector: 'app-colaborador-cadastro',
    templateUrl: './colaborador-cadastro.component.html',
    styleUrls: ['./colaborador-cadastro.component.css']
})


export class ColaboradorCadastroComponent implements OnInit {

    colaborador: ColaboradorModel = new ColaboradorModel;
    imagebase64: string = null;
    idColaborador: any;
    imagem: File;
    categorias: SelectModel[] = [];
    competencias: SelectModel[] = [];
    categoriaSelecionada: CategoriaModel;
    competenciaSelecionada: CompetenciaModel;
    nivelSelecionado: CategoriaCompetenciaListModel;
    categoriaCompetencia: CategoriaCompetenciaListModel[] = [];
    categoriaCompetencias: CategoriaCompetenciaListModel[] = [];

    formato: string = '';
    base64image: string = 'data:*;base64,'

    constructor(private colaboradorService: ColaboradorService,
        private messageService: MessageService, private route: ActivatedRoute, private categoriaService: CategoriaService, private competenciaService: CompetenciaService, private nivelService: NivelService, private domSanitizer: DomSanitizer) {}

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

    buscarNivel() {
        this.nivelService.getAll().subscribe((response) => {
            response.nivel;
            console.log(response.nivel);
        })
    }


    salvar(severity: string) {
        this.colaborador.colaboradorCompetencias = this.categoriaCompetencia.map((categoriaCompetencia) => {
            let ccN = new ColaboradorCompetenciaNivel();
            ccN.competencia = categoriaCompetencia.competencia;
            ccN.nivel = categoriaCompetencia.nivel;
            return ccN;
        });
        this.colaborador.foto = this.imagebase64;
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
        fileReader.readAsBinaryString(this.imagem);
        fileReader.onload = (evento: any) => this.converterParaBase64(evento.srcElement.result);
        this.formato = this.imagem.type;
        console.log(this.imagem.type);
    }


    converterParaBase64(bytes: string){
        this.imagebase64 = this.base64image.replace("*", this.formato) + btoa(bytes);
    }

    tratarUrlImagem(imageEmBase64): SafeResourceUrl {
        return this.domSanitizer.bypassSecurityTrustResourceUrl(imageEmBase64);
    }

    imagemForm(){
        return this.tratarUrlImagem(this.imagebase64 ? this.imagebase64 : this.colaborador.foto);
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
