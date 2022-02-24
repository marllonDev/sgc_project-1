import { ColaboradorModel } from "../../colaborador/model/colaborador.model";
import { CompetenciaModel } from "../../competencia/model/competencia.models";
import { Colaborador } from "./colaborador.model";

export interface CompetenciaColaborador {
    competencia: CompetenciaModel;
    colaborador: Colaborador;
}
