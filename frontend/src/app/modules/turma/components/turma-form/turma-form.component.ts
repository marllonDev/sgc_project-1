import { Component, OnInit, ViewChild } from '@angular/core';
import { AbstractControl, FormControl, FormGroup, FormGroupDirective, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Status } from '../../model/status.model';
import { StatusService } from '../../service/status.service';
import { TurmaService } from '../../service/turma.service';

@Component({
  selector: 'app-turma-form',
  templateUrl: './turma-form.component.html',
  styleUrls: ['./turma-form.component.css']
})
export class TurmaFormComponent implements OnInit {

    @ViewChild(FormGroupDirective) form: FormGroupDirective;

    status: Status[];
    root: FormGroup;
    competenciaColaboradores: any[];

    constructor(
        private turmaService: TurmaService,
        private statusService: StatusService,
        private router: Router,
        private route: ActivatedRoute,
    ) { }

    ngOnInit() {
        this.buscarStatus();
        this.criarForm();
        this.route.paramMap.subscribe(
            params => {
                const id = params.get("id");
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
        )
    }

    protected criarForm() {
        this.root = new FormGroup({
            id: new FormControl(),
            nome: new FormControl(null, [Validators.required, Validators.minLength(5)]),
            descricao: new FormControl(null,[Validators.required, Validators.minLength(10)]),
            dataInicio: new FormControl(null, [Validators.required]),
            dataTermino: new FormControl(null, [Validators.required]),
            status: new FormControl(null)
        });
    }

    submitForm() {

    }

    buscarStatus() {
        return this.statusService.listarStatus().subscribe(
            s => this.status = s
        );
    }

    navigateTo() {
        this.router.navigate(['/turmas'], { relativeTo: this.route });
    }

    deveMostrarMensagemDeErro(control: AbstractControl): boolean {
        return control.errors && control.touched || control.dirty;
    }

    mensagemDeErro(control: AbstractControl) {
        if (control.hasError('required')) {
            return 'Campo obrigatório.'
        }
        if (control.hasError('minlength')) {
            return `O tamanho minímo é de ${control.getError('minlength').requiredLength} caracteres.`;
        }
        return ''
    }

}
