import { ColaboradorCompetenciaNivel } from './colaboradorCompetenciaNivel.model';
import { CompetenciaModel } from 'src/app/modules/competencia/model/competencia.models';

export class ColaboradorModel {
    id: number | string;
    nome: string;
    sobrenome: string;
    cpf: string;
    email: string;
    foto: string;
    senioridadeID: string;
    dataNascimento: Date;
    dataAdmissao: Date;
    colaboradorCompetencias: ColaboradorCompetenciaNivel[];
}
