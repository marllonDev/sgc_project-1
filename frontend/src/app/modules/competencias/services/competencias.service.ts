import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { take } from 'rxjs/operators';
import { environment } from 'src/environments/environment';
import { Categoria } from '../model/categoria';

import { Competencia } from '../model/competencia';


@Injectable({
  providedIn: 'root'
})
export class CompetenciasService {

  private readonly BASEURL: string = environment.apiUrl + '/competencias';
  
  private readonly URLcomp: string = environment.apiUrl + '/categorias';

  constructor(private httpClient: HttpClient) { }

  listar(): Observable<Competencia[]> {

      return this.httpClient.get<Competencia[]>(this.BASEURL)
  
  }

  listarCategoria(): Observable<Categoria[]> {
{}
    return this.httpClient.get<Categoria[]>(this.URLcomp)

  }

  postar(competencia): Observable<Competencia> {

    
    return this.httpClient.post<Competencia>(this.BASEURL, competencia).pipe(take(1));
    
  }

  listaId(id) {

    return this.httpClient.get<Competencia>(`${this.BASEURL}/${id}`).pipe(take(1));
  }

  deletar(id){

    return this.httpClient.delete<Competencia>(`${this.BASEURL}/${id}`).pipe(take(1));
  }


  atualizar(competencia){

    return this.httpClient.put<Competencia>(`${this.BASEURL}/${competencia.id}`, competencia).pipe(take(1));
  }
}
