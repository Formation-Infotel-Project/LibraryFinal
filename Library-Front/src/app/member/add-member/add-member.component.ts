import { Component, OnInit } from '@angular/core';
import { Member } from '../../model/Member';
import { MemberBackService } from '../../service/memberBack.service';
import { MessagesService } from '../../service/messages.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-member',
  templateUrl: './add-member.component.html',
  styleUrls: ['./add-member.component.css']
})
export class AddMemberComponent implements OnInit {

  member: Member = {
    memberId: 0,
    memberLastName: "",
    firstName: "",
    email: "",
    password: "",
    address: "",
    city: "", 
    postalCode: "",
    phone: "",
    access: 2  
  };

  constructor(private memberBack: MemberBackService,
    private MessagesService: MessagesService,
    private router: Router) { }

  ngOnInit() {
  }

  addMember() {
    this.memberBack.addMember(this.member).subscribe(
      data => {
          //navigate to home and display navbar or the hidden tabs
          this.router.navigate(['/members']);
      },
      error => {
        console.error(error.message);
        //messageService.displayFailureMessage(error.message);
      }
    );
  }
}
