import { CategoriaModel } from "./categoria.model";

export class CompetenciaModel {
    id: number;
    descricao: string;
    categoria: CategoriaModel;
}