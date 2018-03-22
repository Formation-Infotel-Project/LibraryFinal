import { Component, OnInit } from '@angular/core';
import { BookParam} from '../../model/BookParam';
import { Category} from '../../model/Category';
import { EditorVM} from '../../model/EditorVM';
import { AuthorVM} from '../../model/AuthorVM';
import { BackendService } from '../../service/backend.service';
import { MessagesService } from '../../service/messages.service';
import { DatashareService } from '../../service/datashare.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-book',
  templateUrl: './add-book.component.html',
  styleUrls: ['./add-book.component.css'],
  providers: [MessagesService]
})
export class AddBookComponent implements OnInit {

   bookParam: BookParam = {
    title: "",
    description: "",
    price:7,
    pubDate: "",
    popular:false,
    editorId:"",
    authorsId :[],
    categoryId: "",
     imagePath:null
  };

  category: Category = {
  id:498,
  name: "",
   description: ""
 };

 author: AuthorVM = {
id:0,
authorLastName:"",
firstName:""
};

editor : EditorVM = {
id:0,
name:"",
editorAddress:""
};

constructor(
    private backService: BackendService,
    private MessagesService: MessagesService,
    private dss: DatashareService,
    private router: Router) { }

     
listeCategory: any;
listeAuthor: any;
listeEditor: any;

fileToUpload: File = null;


  ngOnInit() {
  // console.log('getLibrary');
  this.getCategory();
  // console.log(this.getCategory());

  console.log('getAuthor');
   this.getAuthor();
   console.log(this.getAuthor());

  // console.log('getEditor');
  this.getEditor();
  // console.log(this.getEditor());
  }
  insertBook(){
    this.backService.addBook(this.bookParam).subscribe(
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
  getCategory(): any {
   this.backService.getCategory().subscribe(
     data => {
       console.log('data');
       console.log(data);
       this.backService.handleData(data);
       if (data.payload) {
         console.log('data payload');
         console.log(data.payload);
         this.listeCategory = data.payload;
         return this.listeCategory
       }
     },
     error => {
       console.log('error !!!!!');
       console.error(error.message);
       // messageService.displayFailureMessage(error.message);
       return null;
     }
   );
}

getEditor(): any {
   this.backService.getEditor().subscribe(
     data => {
       console.log('data');
       console.log(data);
       this.backService.handleData(data);
       if (data.payload) {
         console.log('data payload');
         console.log(data.payload);
         this.listeEditor = data.payload;
         return this.listeEditor
       }
     },
     error => {
       console.log('error !!!!!');
       console.error(error.message);
       // messageService.displayFailureMessage(error.message);
       return null;
     }
   );
}
getAuthor(): any {
   this.backService.getAuthor().subscribe(
     data => {
       console.log('data');
       console.log(data);
       this.backService.handleData(data);
       if (data.payload) {
         console.log('data payload');
         console.log(data.payload);
         this.listeAuthor = data.payload;
         return this.listeAuthor
       }
     },
     error => {
       console.log('error !!!!!');
       console.error(error.message);
       // messageService.displayFailureMessage(error.message);
       return null;
     }
   );
}

}
