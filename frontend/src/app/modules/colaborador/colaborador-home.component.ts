import { OnInit, Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-colaborador-home',
  templateUrl: 'colaborador-home.component.html'
})

export class ColaboradorHomeComponent implements OnInit {


  constructor(private router: Router) { 
    this.router.navigate(['colaboradores/lista']);
  }

  ngOnInit(): void {
    this.router.navigate(['colaboradores/lista']);
  }


  

}



