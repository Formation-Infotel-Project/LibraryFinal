import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-member',
  templateUrl: './member.component.html',
  styleUrls: ['./member.component.css']
})
export class MemberComponent implements OnInit {
  results = '';
  
  constructor(private http: HttpClient) { }

  ngOnInit():void {  

    this.http.get<MemberResponse>('http://localhost:8080/Library-Web/member/get/10').subscribe(data => {
        console.log("Member ID : " + data.memberId);
        console.log("LastName : " + data.memberLastName);
        console.log("FirstName : " + data.firstName);
        console.log("Email : " + data.email);
        console.log("Password : " + data.password);
        console.log("Address : " + data.address + " " + data.postalCode + " " + data.city);
        console.log("Phone : " + data.phone);
        console.log("Access : " + data.access);
    });
  }
}
