import { SelectItem } from 'primeng/api';
import { CategoriaCompetenciaListModel } from './../../colaborador/model/categoriaCompetenciaList.model';
import {
    Observable
} from 'rxjs';
import {
    CategoriaModel
} from '../model/categoria.model';
import {
    HttpClient
} from '@angular/common/http';
import {
    Injectable
} from '@angular/core';

const baseUrl = '/api/categorias';

@Injectable({
    providedIn: 'root'
})
export class CategoriaService {

    constructor(private httpClient: HttpClient) {}


    ngOnInit(): void {}

    getById(id: number): Observable < CategoriaModel > {
        return this.httpClient.get < CategoriaModel > (`${baseUrl}/${id}`);
    }

    getAll(): Observable < CategoriaModel[] > {
       return this.httpClient.get < CategoriaModel[] >(baseUrl);
    }

    deletar(id: any): Observable<CategoriaCompetenciaListModel> {
        return this.httpClient.delete<CategoriaCompetenciaListModel>(`${baseUrl}/${id}`);
    }

    
    getAllSelectItem(): Observable < SelectItem[] > {
        return this.httpClient.get < SelectItem[]>(baseUrl);
     }
}
