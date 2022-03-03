import { Colaborador } from './../../../turma/models/colaborador.model';

import {
    MessageService
} from 'primeng/api';
import {
    OnInit,
    Component
} from '@angular/core';
import {
    Router,
    ActivatedRoute
} from '@angular/router';

import {
    ColaboradorService
} from '../../service/colaborador.service';
import {
    ColaboradorListModel
} from './../../model/colaboradorList.model';


const baseUrl = '/api/colaboradores';

@Component({
    selector: 'app-colaborador',
    templateUrl: 'colaborador.component.html',
    styleUrls: ['colaborador.component.css']
})
export class ColaboradorComponent implements OnInit {

    colaboradores: ColaboradorListModel[];
    colaboradorDate: ColaboradorListModel = new ColaboradorListModel; 
    idColaborador: any;

    constructor(private colaboradorService: ColaboradorService,
        private messageService: MessageService, private router: Router, private route: ActivatedRoute) {}

    ngOnInit(): void {
        this.colaboradorService.getAll().subscribe(response => {
            this.colaboradores = response;
            this.messageService.add({ severity: 'success', summary: 'Sucesso', detail: 'Colaboradores Listados' }) 
        });
    }

    adicionar() {
        this.router.navigate(['colaboradores/cadastro']);
    }

    editar(idColaborador) {
        this.router.navigate(['colaboradores/cadastro', {
            id: idColaborador
        }]);
    }


    deletar(colaborador: ColaboradorListModel) {
        this.colaboradorService.deletar(colaborador.id).subscribe((response) => {
            this.colaboradores.splice(this.colaboradores.indexOf(colaborador), 1);
            this.messageService.add({
                severity: 'success',
                summary: 'Sucesso',
                detail: 'Dados Deletados'
            });
        });
    }
}
