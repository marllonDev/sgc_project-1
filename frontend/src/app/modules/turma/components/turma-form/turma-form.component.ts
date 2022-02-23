import { Component, OnDestroy, OnInit, ViewChild } from '@angular/core';
import { AbstractControl, FormControl, FormGroup, FormGroupDirective, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { PageNotificationService } from '@nuvem/primeng-components';
import { SelectItem } from 'primeng/api';
import { Subject } from 'rxjs';
import { takeUntil } from 'rxjs/operators';
import { ColaboradorModel } from 'src/app/modules/colaborador/model/colaborador.model';
import { ColaboradorService } from 'src/app/modules/colaborador/service/colaborador.service';
import { CompetenciaColaboradorNivelMaximo } from '../../models/competencia-colaborador-nivel-maximo.model';
import { CompetenciaColaborador } from '../../models/competencia-colaborador.model';
import { Status } from '../../models/status.model';
import { TurmaDtoInput } from '../../models/turma-dto-input.model';
import { Turma } from '../../models/turma.model';
import { StatusService } from '../../service/status.service';
import { TurmaService } from '../../service/turma.service';

@Component({
    selector: 'app-turma-form',
    templateUrl: './turma-form.component.html',
    styleUrls: ['./turma-form.component.css']
})
export class TurmaFormComponent implements OnInit, OnDestroy {

    @ViewChild(FormGroupDirective) form: FormGroupDirective;
    unsubscribeAll = new Subject<void>();

    //status: SelectItem[];
    status: Status[];
    competenciaColaboradorNivelMax: CompetenciaColaboradorNivelMaximo[];
    root: FormGroup;
    competenciaColaboradorForm: FormGroup;
    submittingForm: boolean = false;
    colaboradores: SelectItem[] = [];

    constructor(
        private turmaService: TurmaService,
        private statusService: StatusService,
        private colaboradorService: ColaboradorService,
        private messageService: PageNotificationService,
        private router: Router,
        private route: ActivatedRoute,
    ) { }

    ngOnInit() {
        this.buscarStatus();
        this.buscarCompetenciaColaboradoreNivelMax();
        this.criarForm();
        this.criarCompetenciaColaboradorForm();
        this.route.paramMap
            .pipe(takeUntil(this.unsubscribeAll))
            .subscribe(
                params => {
                    const id = params.get("id");
                    if (id === 'criar') {
                        this.root.setValue({
                            id: null,
                            nome: null,
                            descricao: null,
                            dataInicio: null,
                            dataTermino: null,
                            status: null,
                            competenciasColaboradores: []
                        });
                        this.root.markAsPristine();
                        this.root.markAsUntouched();
                    } else {
                        this.turmaService.getById(+id).subscribe(
                            turma => {
                                turma.dataInicio = new Date(turma.dataInicio);
                                turma.dataTermino = new Date(turma.dataTermino);
                                this.root.patchValue(turma);
                                this.root.markAsPristine();
                                this.root.markAsUntouched();
                            }
                        )
                    }
                }
            )
    }

    ngOnDestroy() {
        this.unsubscribeAll.next();
        this.unsubscribeAll.complete();
    }

    protected criarForm() {
        this.root = new FormGroup({
            id: new FormControl(),
            nome: new FormControl(null, [Validators.required, Validators.minLength(5)]),
            descricao: new FormControl(null, [Validators.required, Validators.minLength(10)]),
            dataInicio: new FormControl(null, [Validators.required]),
            dataTermino: new FormControl(null, [Validators.required]),
            status: new FormControl(null),
            competenciasColaboradores: new FormControl(null)
        });
    }

    private criarCompetenciaColaboradorForm() {
        this.competenciaColaboradorForm = new FormGroup({
            competencia: new FormControl(null),
            colaborador: new FormControl(null)
        });
        this.competenciaColaboradorForm.get('competencia')
            .valueChanges
            .pipe(takeUntil(this.unsubscribeAll))
            .subscribe((valorSelecionado: CompetenciaColaboradorNivelMaximo) => {
                if (valorSelecionado && valorSelecionado.colaboradores) {
                    this.colaboradores = valorSelecionado.colaboradores.map(c => {
                        const item: SelectItem = {
                            label: `${c.nome} ${c.sobrenome}`,
                            value: c
                        }
                        return item;
                    });
                } else {
                    this.colaboradores = [];
                }
            });
    }

    submitForm() {
        this.submittingForm = true;
        if (!this.root.get('id').value) {
            this.criarTurma();
        } else {
            this.atualizarTurma();
        }
    }

    criarTurma() {
        const turma: Turma = this.root.value
        const turmaDtoInput: TurmaDtoInput = {
            nome: turma.nome,
            descricao: turma.descricao,
            dataInicio: turma.dataInicio,
            dataTermino: turma.dataTermino,
            statusId: turma.status.id,
            competenciasColaboradores: turma.competenciasColaboradores.map(
                cc => ({
                    competenciaId: cc.competencia.id,
                    colaboradorId: cc.colaborador.id
                })
            )
        }
        this.turmaService.save(turmaDtoInput).subscribe(t => {
            this.root.markAsPristine();
            this.root.markAsUntouched();
            this.submittingForm = false;
            this.irParaTurmaList();
        });
        this.messageService.addCreateMsg("Turma criada com sucesso!");
    }

    atualizarTurma() {
        const turma: Turma = this.root.value
        const turmaDtoInput: TurmaDtoInput = {
            nome: turma.nome,
            descricao: turma.descricao,
            dataInicio: turma.dataInicio,
            dataTermino: turma.dataTermino,
            statusId: turma.status.id,
            competenciasColaboradores: turma.competenciasColaboradores.map(
                cc => ({
                    competenciaId: cc.competencia.id,
                    colaboradorId: cc.colaborador.id
                })
            )
        }
        this.turmaService.update(turma.id, turmaDtoInput).subscribe(t => {
            this.root.markAsPristine();
            this.root.markAsUntouched();
            this.submittingForm = false;
            this.irParaTurmaList();
        });
        this.messageService.addUpdateMsg("Turma atualizada com sucesso!");
    }

    buscarStatus() {
        //return this.statusService.listarStatus().subscribe(s => {
        //this.status = s.map(status => ({ value: s, label: status.descricao }))
        //});
        return this.statusService.listarStatus().subscribe(s =>
            this.status = s);
    }

    buscarCompetenciaColaboradoreNivelMax() {
        return this.colaboradorService.buscarColaboradorCompetenciaPorNivelMaximo()
            .subscribe(ccNivelMax =>
                this.competenciaColaboradorNivelMax = ccNivelMax
            );
    }

    irParaTurmaList() {
        this.router.navigate(['/turmas'], { relativeTo: this.route });
    }

    deveMostrarMensagemDeErro(control: AbstractControl): boolean {
        return control.errors && control.touched || control.dirty;
    }

    mensagemDeValidacao(control: AbstractControl) {
        if (control.hasError('required')) {
            return 'Campo obrigatório.';
        }
        if (control.hasError('minlength')) {
            return `O tamanho minímo é de ${control.getError('minlength').requiredLength} caracteres.`;
        }
        return '';
    }

    adicionarCompetenciaColaborador() {
        if (this.competenciaColaboradorForm.get('colaborador').value == null || this.competenciaColaboradorForm.get('competencia').value == null) {
            this.messageService.addErrorMessage("Deve ser informado pelo menos uma competência e um colaborador.", "Falha ao inserir");
            return;
        }
        const competenciaColaboradorForm: {
            competencia: CompetenciaColaboradorNivelMaximo,
            colaborador: ColaboradorModel
        } = this.competenciaColaboradorForm.value;

        const competenciaColaborador: CompetenciaColaborador = {
            competencia: competenciaColaboradorForm.competencia.competencia,
            colaborador: competenciaColaboradorForm.colaborador
        }

        let competenciasColaboradoresItens: CompetenciaColaborador[] = this.root.get('competenciasColaboradores').value;

        if (competenciasColaboradoresItens.some(cc => cc.colaborador.id == competenciaColaboradorForm.colaborador.id && cc.competencia.id == competenciaColaborador.competencia.id)) {
            this.messageService.addErrorMessage("Este colaborador já está cadastrado para esta competência.", "Falha ao inserir");
            return;
        }

        competenciasColaboradoresItens = [...competenciasColaboradoresItens, competenciaColaborador];

        this.root.get('competenciasColaboradores').setValue(competenciasColaboradoresItens);
        this.competenciaColaboradorForm.setValue({
            colaborador: null,
            competencia: null
        })
        this.root.markAsDirty();
    }

    excluirItem(indexRow: number) {
        let ccItens: CompetenciaColaborador[] = [...this.root.get('competenciasColaboradores').value];
        ccItens.splice(indexRow, 1);
        this.root.get('competenciasColaboradores').setValue(ccItens);
        this.root.markAsDirty();
    }
}
