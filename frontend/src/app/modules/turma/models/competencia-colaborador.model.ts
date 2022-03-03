import { CompetenciaModel } from "../../competencia/model/competencia.models";
import { Colaborador } from "./colaborador.model";

export interface CompetenciaColaborador {
    competencia: CompetenciaModel;
    colaborador: Colaborador;
}
