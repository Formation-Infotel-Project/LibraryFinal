import { Component, OnInit } from '@angular/core';
import { IdentifiantsVM } from '../model/IdentifiantsVM';
import { BackendService } from '../service/backend.service';
import { MessagesService } from '../service/messages.service';
import { DatashareService } from '../service/datashare.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  providers: [MessagesService]
})
export class LoginComponent implements OnInit {

  identifiants: IdentifiantsVM = {
    email: "",
    password: ""    
  };

  constructor(
    private backService: BackendService,
    private MessagesService: MessagesService,
    private dss: DatashareService,
    private router: Router) { }

  ngOnInit() {
  }

  login() {
    this.backService.login(this.identifiants).subscribe(
      data => {
        this.backService.handleData(data);
        if (data.payload) {
          console.log(data.payload);
          //cache the logged member in datashare service
          this.dss.loggedMember = data.payload;
          //navigate to home and display navbar or the hidden tabs
          this.router.navigate(['/home']);          
        }
      },
      error => {
        console.error(error.message);
        //messageService.displayFailureMessage(error.message);
      }
    );
  }
}
