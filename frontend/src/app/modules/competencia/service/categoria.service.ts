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
}
