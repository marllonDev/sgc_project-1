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
    AfterViewInit,
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
import {
    DomSanitizer,
    SafeResourceUrl
} from '@angular/platform-browser';
import {
    SelectItem
} from 'primeng/api';



const baseUrl = '/api/colaboradores';

@Component({
    selector: 'app-colaborador-cadastro',
    templateUrl: './colaborador-cadastro.component.html',
    styleUrls: ['./colaborador-cadastro.component.css']
})


export class ColaboradorCadastroComponent implements AfterViewInit {

    colaborador: ColaboradorModel = new ColaboradorModel;
    imagebase64: string = null;
    idColaborador: any;
    imagem: File;
    categorias: SelectItem[] = [];
    competencias: SelectItem[] = [];
    categoriaSelecionada: number;
    competenciaSelecionada: CompetenciaModel;
    nivelSelecionado: string;
    nivel: SelectItem[] = [{
            label: 'Conhece',
            value: 'CONHECE'
        },
        {
            label: 'Sabe Aplicar',
            value: 'SABE_APLICAR'
        },
        {
            label: 'Sabe Ensinar',
            value: 'SABE_ENSINAR'
        }
    ]
    categoriaCompetencia: CategoriaCompetenciaListModel[] = [];
    categoriaCompetencias: CategoriaCompetenciaListModel[] = [];


    formato: string = '';
    base64image: string = 'data:*;base64,'

    constructor(private colaboradorService: ColaboradorService,
        private messageService: MessageService, private route: ActivatedRoute, private categoriaService: CategoriaService, private competenciaService: CompetenciaService, private nivelService: NivelService, private domSanitizer: DomSanitizer) {}

    ngAfterViewInit() {
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


    adicionarCompetencia(severity: string) {
        let categoria = this.categorias.find((cat) => {
            return cat.value == this.categoriaSelecionada;
        });

        if (categoria == null) {
            this.messageService.add({
                severity: 'error',
                summary: 'Erro',
                detail: 'Informe a Categoria'
            });
            return;
        }

        if (this.competenciaSelecionada == null) {
            this.messageService.add({
                severity:  'error',
                summary: 'Erro',
                detail: 'Informe a Competencia'
            });
            return;
        }

        if (this.nivelSelecionado == null) {
            this.messageService.add({
                severity:  'error',
                summary: 'Erro',
                detail: 'Informe o Nível'
            });
            return;
        }

        let categoriaCompetenciaList = new CategoriaCompetenciaListModel();
        categoriaCompetenciaList.competencia = this.competenciaSelecionada;
        categoriaCompetenciaList.competencia.categoria = new CategoriaModel();
        categoriaCompetenciaList.competencia.categoria.id = categoria.value;
        categoriaCompetenciaList.competencia.categoria.nome = categoria.label;
        categoriaCompetenciaList.nivel = this.nivelSelecionado;
        this.nivelSelecionado = null;
        this.categoriaCompetencia.push(categoriaCompetenciaList);
    }


    buscarCategorias() {
        this.categoriaService.getAllSelectItem().subscribe((response) => {
            this.categorias = response;

        });
    }

    buscarCompetencias(event) {
        this.competencias = [];
        this.competenciaService.getAllCompetenciasByCategoriaId(event.value).subscribe((response) => {
            response.map((competencia) => {
                let select = new SelectModel();
                select.label = competencia.nome;
                select.value = competencia;
                this.competencias.push(select);
            });
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
            console.log(this.colaborador)
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


    converterParaBase64(bytes: string) {
        this.imagebase64 = this.base64image.replace("*", this.formato) + btoa(bytes);
    }

    tratarUrlImagem(imageEmBase64): SafeResourceUrl {
        return this.domSanitizer.bypassSecurityTrustResourceUrl(imageEmBase64);
    }

    imagemForm() {
        return this.tratarUrlImagem(this.imagebase64 ? this.imagebase64 : this.colaborador.foto);
    }


    deletar(categoriaCompetencia: CategoriaCompetenciaListModel) {
        this.nivelService.deletar(this.idColaborador, categoriaCompetencia.competencia.id).subscribe();
        this.categoriaCompetencia.splice(this.categoriaCompetencia.indexOf(categoriaCompetencia), 1);
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
