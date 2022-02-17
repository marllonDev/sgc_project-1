import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Turma } from '../../model/turma.model';
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
        private router: Router,
        private route: ActivatedRoute
    ) { }

    ngOnInit() {
        this.listarTurmas();
    }

    listarTurmas() {
        return this.turmaService.getAll().subscribe(
            turma => this.turmas = turma
        );
    }

    navigateTo(id: number) {
        this.router.navigate([`${id}`], { relativeTo: this.route });
    }

}
