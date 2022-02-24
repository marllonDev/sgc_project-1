import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { TurmaDtoInput } from '../models/turma-dto-input.model';
import { Turma } from '../models/turma.model';

@Injectable({
  providedIn: 'root'
})
export class TurmaService {

    private apiUrl: string;

    constructor(private http: HttpClient) {
        this.apiUrl = '/api/turmas';
    }

    getAll(): Observable<Turma[]> {
        return this.http.get<Turma[]>(this.apiUrl);
    }

    getById(id: number): Observable<Turma> {
        return this.http.get<Turma>(`${this.apiUrl}/${id}`);
    }

    save(turma: TurmaDtoInput): Observable<Turma> {
        return this.http.post<Turma>(this.apiUrl, turma);
    }

    update(id: number, turma: TurmaDtoInput): Observable<Turma> {
        return this.http.put<Turma>(`${this.apiUrl}/${id}`, turma);
    }

    delete(id: number) {
        return this.http.delete(`${this.apiUrl}/${id}`);
    }
}
