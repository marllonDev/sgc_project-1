import { CategoriaCompetenciaListModel } from './../model/categoriaCompetenciaList.model';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';


const baseUrl = '/api/colaborador-competencia';

@Injectable({
    providedIn: 'root'
})

export class NivelService {

    constructor(private httpClient: HttpClient) { }

    getAll(): Observable<CategoriaCompetenciaListModel> {
        return this.httpClient.get<CategoriaCompetenciaListModel>(baseUrl);
    }

    deletar( idColaborador: number, idCompetencia: number): Observable<void> {
        return this.httpClient.delete<void>(`${baseUrl}/colaborador/${idColaborador}/competencia/${idCompetencia}`);
     
    }
}