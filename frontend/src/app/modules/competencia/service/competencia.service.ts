import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CompetenciaModel } from '../model/competencia.models';

@Injectable({
  providedIn: 'root'
})
export class CompetenciaService {

    private apiUrl: string;

    constructor(private http: HttpClient) {
        this.apiUrl = '/api/competencias';
    }

    getAll(): Observable<CompetenciaModel[]> {
        return this.http.get<CompetenciaModel[]>(this.apiUrl);
    }

    getAllCompetenciasByCategoriaId(id: number): Observable<CompetenciaModel[]> {
        return this.http.get<CompetenciaModel[]>(`${this.apiUrl}/categorias/${id}`);
    }
}
