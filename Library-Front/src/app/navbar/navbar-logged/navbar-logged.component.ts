import { Component, OnInit } from '@angular/core';
import { LogoutService } from '../../service/logout.service';
import { MessagesService } from '../../service/messages.service';
import { Router } from '@angular/router';

@Component({
  selector: 'navbar-logged',
  templateUrl: './navbar-logged.component.html',
  styleUrls: ['./navbar-logged.component.css']
})
export class NavbarLoggedComponent implements OnInit {

  constructor(private logoutService:LogoutService,
    private router: Router) { }

  ngOnInit() {
  }

  logout(){
    this.logoutService.logout();
    
  }
}
