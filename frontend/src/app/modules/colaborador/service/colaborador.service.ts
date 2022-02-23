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


const baseUrl = '/api/colaboradores';

@Injectable({
    providedIn: 'root'
})

export class ColaboradorService {

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
}
