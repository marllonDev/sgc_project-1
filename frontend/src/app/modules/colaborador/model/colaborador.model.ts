import { ColaboradorCompetenciaNivel } from './colaboradorCompetenciaNivel.model';
import { CompetenciaModel } from 'src/app/modules/competencia/model/competencia.models';

export class ColaboradorModel {
    id: number | String;
    nome: string;
    sobrenome: string;
    cpf: String;
    email: String;
    foto: string;
    senioridadeID: String;
    dataNascimento: Date;
    dataAdmissao: Date;
    colaboradorCompetencias: ColaboradorCompetenciaNivel[];
}
