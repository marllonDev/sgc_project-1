export interface TurmaDtoInput {
    nome: string;
    descricao: string;
    dataInicio: string | Date;
    dataTermino: string | Date;
    statusId: number;
    competenciasColaboradores: CompetenciaColaboradorDtoIdInput[];
}

export interface CompetenciaColaboradorDtoIdInput {
    competenciaId: number;
    colaboradorId: number;
}
