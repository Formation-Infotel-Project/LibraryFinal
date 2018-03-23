import { Component, OnInit } from '@angular/core';
import { LogoutService } from '../../service/logout.service';
import { MessagesService } from '../../service/messages.service';
import { Router } from '@angular/router';
import { BackendService } from '../../service/backend.service';
import {LocalStorageService, LocalStorage} from 'ngx-webstorage';
import { DatashareService } from '../../service/datashare.service';

@Component({
  selector: 'navbar-logged-admin',
  templateUrl: './navbar-logged-admin.component.html',
  styleUrls: ['./navbar-logged-admin.component.css']
})
export class NavbarLoggedAdminComponent implements OnInit {

  constructor(private logoutService:LogoutService,private backService: BackendService,private dss: DatashareService,private storage: LocalStorageService,
    private router: Router) { }

  ngOnInit() {
  }

  logout(){
    this.logoutService.logout(); 
  }
}
