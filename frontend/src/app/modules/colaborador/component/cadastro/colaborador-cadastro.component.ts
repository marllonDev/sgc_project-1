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

const baseUrl = '/api/colaboradores';

@Component({
    selector: 'app-colaborador-cadastro',
    templateUrl: './colaborador-cadastro.component.html',
    styleUrls: ['./colaborador-cadastro.component.css']
})


export class ColaboradorCadastroComponent implements OnInit {

    colaborador: ColaboradorModel = new ColaboradorModel;
    imagebase64: String;
    idColaborador: any;

    constructor(private colaboradorService: ColaboradorService,
        private messageService: MessageService, private route: ActivatedRoute) {}

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

    validarEmail(email) {
        var re = /\S+@\S+\.\S+/;
        return re.test(email);
    }


    salvar(severity: string) {
        this.colaboradorService.save(this.colaborador).subscribe((response) => {
            this.colaborador = response;
            this.messageService.add({
                severity: severity,
                summary: 'Sucesso',
                detail: 'Dados Salvos'
            });
        });
    }

    tratarFoto(arquivos: File[]) {
        let fileReader: FileReader = new FileReader();
        fileReader.onload = (evento: ProgressEvent < FileReader > ) => this.converterFoto(evento);
        fileReader.readAsText(arquivos[0]);
        console.log(arquivos[0]);

    }

    converterFoto(evento: ProgressEvent < FileReader > ) {
        this.imagebase64 = btoa(evento.target.result as string);
    }

}
