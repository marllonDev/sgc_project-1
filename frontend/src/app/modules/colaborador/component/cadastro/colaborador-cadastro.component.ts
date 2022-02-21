import { ColaboradorService } from './../../service/colaborador.service';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { ColaboradorModel } from '../../model/colaborador.model';

const baseUrl = '/api/colaboradores';

@Component({
  selector: 'app-colaborador-cadastro',
  templateUrl: './colaborador-cadastro.component.html',
  styleUrls: ['./colaborador-cadastro.component.css']
})


export class ColaboradorCadastroComponent implements OnInit {
  
  colaborador: ColaboradorModel = new ColaboradorModel;

  constructor(private http: HttpClient) { }

  ngOnInit(): void {}

 validarEmail(email) {
    var re = /\S+@\S+\.\S+/;
    return re.test(email);
  }
  

salvar(){
  console.log(this.colaborador);
}
}
