import { Component, OnInit } from '@angular/core';
import { LogoutService } from '../../service/logout.service';
import { MessagesService } from '../../service/messages.service';
import { Router } from '@angular/router';
import { BackendService } from '../../service/backend.service';
import { LocalStorageService, LocalStorage} from 'ngx-webstorage';
import { DatashareService } from '../../service/datashare.service';
import { BookBackService } from '../../service/bookBack.service';
import { BookVM } from '../../model/BookVM';

@Component({
  selector: 'navbar-logged-admin',
  templateUrl: './navbar-logged-admin.component.html',
  styleUrls: ['./navbar-logged-admin.component.css']
})
export class NavbarLoggedAdminComponent implements OnInit {

  keyword: string;
  books: BookVM[];

  constructor(private logoutService:LogoutService, private router: Router, private bookService: BookBackService, private storage: LocalStorageService) { }

  ngOnInit() {

  }

  search(recherche:string){
         this.router.navigate(['/search/'+ recherche]);
      
  }

  logout(){
    this.logoutService.logout(); 
  }
}
