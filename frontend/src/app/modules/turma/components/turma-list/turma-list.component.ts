import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PageNotificationService } from '@nuvem/primeng-components';
import { ConfirmationService } from 'primeng/api';
import { Turma } from '../../models/turma.model';
import { TurmaService } from '../../service/turma.service';

@Component({
    selector: 'app-turma-list',
    templateUrl: './turma-list.component.html',
    styleUrls: ['./turma-list.component.css']
})
export class TurmaListComponent implements OnInit {

    turmas: Turma[];

    constructor(
        private turmaService: TurmaService,
        private messageService: PageNotificationService,
        private router: Router,
        private route: ActivatedRoute,
        private confirmationDialog: ConfirmationService
    ) { }

    ngOnInit() {
        this.listarTurmas();
    }

    listarTurmas() {
        return this.turmaService.getAll().subscribe(
            turma => this.turmas = turma
        );
    }

    excluirTurma(turma: Turma) {
        this.confirmationDialog.confirm({
            header: 'Confirmar exclusão',
            message: "Deseja realmente excluir essa turma?",
            acceptLabel: 'Sim',
            rejectLabel: 'Não',
            accept: () => {
                this.turmaService.delete(turma.id).subscribe(() => {
                    this.turmas = this.turmas.filter(t => t.id !== turma.id);
                },
                (error: HttpErrorResponse) => {
                    this.messageService.addErrorMessage(error.error.userMessage);
                });
            },
            reject: () => {
                this.confirmationDialog.close();
            }
        });
    }

    navigateTo(id: number) {
        this.router.navigate([`${id}`], { relativeTo: this.route });
    }

}
