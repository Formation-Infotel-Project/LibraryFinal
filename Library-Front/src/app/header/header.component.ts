import { Component, OnInit } from '@angular/core';
import { DatashareService } from '../service/datashare.service';
import { HttpClient } from '@angular/common/http';
import { LocalStorageService } from 'ngx-webstorage';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  default = true;
  logged = false;
  admin = false;

  constructor(private dss: DatashareService,
  private http: HttpClient,
  private storage: LocalStorageService) { }  

  ngOnInit() {
    this.dss.loggedMember = this.storage.retrieve('me');
    
    console.log("DatashareService");
    console.log(this.dss);
    if(this.dss.loggedMember){
      console.log("okokokokokok");
      this.logged = true;
      this.default = false;

      if(this.dss.loggedMember.access == 1){
        this.admin = true;
        this.logged = false;
      }
    }
  }
}
