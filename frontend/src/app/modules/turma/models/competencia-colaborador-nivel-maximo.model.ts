export interface CompetenciaColaboradorNivelMaximo {
    competencia: CompetenciaResumoDto;
    colaboradores: ColaboradoresResumoDto[];
}

export interface CompetenciaResumoDto {
    id: number;
    nome: string;
}

export interface ColaboradoresResumoDto {
    id: number;
    nome: string;
    sobrenome: string;
}
