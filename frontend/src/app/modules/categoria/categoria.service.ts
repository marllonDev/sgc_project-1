import { Observable } from 'rxjs';
import { CategoriaModel } from './../competencia/model/categoria.model';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

const baseUrl = '/api/colaboradores';

@Injectable({
  providedIn: 'root'
})
export class CategoriaService {

  constructor(private http: HttpClient, private categoria: CategoriaModel) { }


  ngOnInit(): void {
    
  }

  getById(id: number): Observable<CategoriaModel> {
    return this.http.get<CategoriaModel>(`${baseUrl}/${id}`);
  }


}
