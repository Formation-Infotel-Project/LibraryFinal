import { Component, OnInit } from '@angular/core';
import { DatashareService } from '../service/datashare.service';

@Component({
  selector: 'navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  isConnected = false;

  constructor(private dss: DatashareService) { }

  ngOnInit() {
      if(this.dss.loggedMember){
        this.isConnected = true;
      }
  }

}
