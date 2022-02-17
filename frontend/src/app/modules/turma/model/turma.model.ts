import { Status } from "./status.model";

export class Turma {
    id: number;
    nome: string;
    descricao: string;
    dataInicio: string | Date;
    dataTermino: string | Date;
    status: Status;
}
