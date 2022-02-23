import { CompetenciaColaboradorDtoIdInput } from "./competencia-colaborador-dto-input";
import { CompetenciaColaborador } from "./competencia-colaborador.model";

export interface TurmaDtoInput {
    nome: string;
    descricao: string;
    dataInicio: string | Date;
    dataTermino: string | Date;
    statusId: number;
    competenciasColaboradores: any;
}


