import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ColaboradorModel } from '../model/colaborador.model';
import { CompetenciaColaboradorNivelMaximo } from '../../turma/models/competencia-colaborador-nivel-maximo.model';
import { ColaboradorListModel } from '../model/colaboradorList.model';


const baseUrl = '/api/colaboradores';

@Injectable({
    providedIn: 'root'
})

export class ColaboradorService {

    constructor(private httpClient: HttpClient) { }

    getAll(): Observable<any> {
        return this.httpClient.get(baseUrl);
    }

    save(colaborador: ColaboradorModel): Observable<ColaboradorModel> {
        return this.httpClient.post<ColaboradorModel>(baseUrl, colaborador);
    }


    atualizar(id: number, colaborador: ColaboradorModel): Observable<ColaboradorModel> {
        return this.httpClient.put<ColaboradorModel>(`${baseUrl}`, colaborador);
    }

    findById(id: number) {
        return this.httpClient.get<ColaboradorModel>(`${baseUrl}/${id}`);
    }


    deletar(id: any): Observable<ColaboradorListModel> {
        return this.httpClient.delete<ColaboradorListModel>(`${baseUrl}/${id}`);
    }

    buscarColaboradorCompetenciaPorNivelMaximo(): Observable<CompetenciaColaboradorNivelMaximo[]> {
        return this.httpClient.get<CompetenciaColaboradorNivelMaximo[]>(`${baseUrl}/competencias/nivel`);
    }

}
