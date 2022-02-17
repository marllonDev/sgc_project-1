import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Turma } from '../model/turma.model';

@Injectable({
  providedIn: 'root'
})
export class TurmaService {

    private apiUrl: string;

    constructor(private http: HttpClient) {
        this.apiUrl = 'http://localhost:8080/api/turmas';
    }

    getAll(): Observable<Turma[]> {
        return this.http.get<Turma[]>(this.apiUrl);
    }

    getById(id: number): Observable<Turma> {
        return this.http.get<Turma>(`${this.apiUrl}/${id}`);
    }

    save(turma: Turma): Observable<Turma> {
        return this.http.post<Turma>(this.apiUrl, turma);
    }

    update(id: number, turma: Turma): Observable<Turma> {
        return this.http.put<Turma>(`${this.apiUrl}/${id}`, turma);
    }

    delete(id: number) {
        return this.http.delete(`${this.apiUrl}/${id}`);
    }
}
