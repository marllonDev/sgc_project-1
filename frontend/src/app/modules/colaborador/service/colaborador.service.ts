
import {
    ColaboradorListModel
} from './../model/colaboradorList.model';
import {
    MessageService
} from 'primeng/api';
import {
    Observable
} from 'rxjs/internal/Observable';
import {
    Injectable
} from '@angular/core';
import {
    HttpClient
} from '@angular/common/http';
import {
    ColaboradorModel
} from '../model/colaborador.model';
=======
import { Observable } from 'rxjs/internal/Observable';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ColaboradorModel } from '../model/colaborador.model';
import { CompetenciaColaboradorNivelMaxino } from '../../turma/model/competencia-colaborador-nivel-maximo.model';



const baseUrl = '/api/colaboradores';

@Injectable({
    providedIn: 'root'
})

export class ColaboradorService {

=======

  constructor(private http: HttpClient) { }
  getAll(): Observable<any> {
    return this.http.get(baseUrl);
  }


    constructor(private httpClient: HttpClient) {}

    getAll(): Observable < any > {
        return this.httpClient.get(baseUrl);
    }


    save(colaborador: ColaboradorModel): Observable < ColaboradorModel > {
        return this.httpClient.post < ColaboradorModel > (baseUrl, colaborador);
    }


    atualizar(id: number, colaborador: ColaboradorModel): Observable < ColaboradorModel > {
        return this.httpClient.put < ColaboradorModel > (`${baseUrl}`, colaborador);
    }

    findById(id: number) {
        return this.httpClient.get < ColaboradorModel > (`${baseUrl}/${id}`);
    }


    deletar(id: any): Observable < ColaboradorListModel > {
        return this.httpClient.delete < ColaboradorListModel > (`${baseUrl}/${id}`);
    }
=======
  buscarColaboradorCompetenciaPorNivelMaximo(): Observable<CompetenciaColaboradorNivelMaxino[]> {
      return this.http.get<CompetenciaColaboradorNivelMaxino[]>(`${baseUrl}/nivel`);
  }

}
