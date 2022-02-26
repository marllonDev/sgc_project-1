import { CategoriaModel } from "./categoria.model";

export class CompetenciaModel {
    id: number;
    nome: string;
    categoria?: CategoriaModel;
}
