import { ColaboradorModel } from "../../colaborador/model/colaborador.model";
import { CompetenciaModel } from "../../competencia/model/competencia.models";

export interface CompetenciaColaborador {
    competencia: CompetenciaModel;
    colaborador: ColaboradorModel;
}
