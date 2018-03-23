import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Member } from '../model/member';
import { MessagesService } from '../service/messages.service';
import { MemberBackService } from '../service/memberBack.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-member',
  templateUrl: './member.component.html',
  styleUrls: ['./member.component.css']
})
export class MemberComponent implements OnInit {
    
  members: Member[];

  constructor(private memberBack: MemberBackService,
  private MessagesService: MessagesService,
  private router: Router) { }

  ngOnInit() {  
    this.memberBack.getMembers().subscribe(
      data => {
        this.memberBack.handleData(data);
        if(data.payload){
          this.members = data.payload;
        }
      },
      error => {
        console.error(error.message);
        //messageService.displayFailureMessage(error.message);
      }
    )
  }
}
