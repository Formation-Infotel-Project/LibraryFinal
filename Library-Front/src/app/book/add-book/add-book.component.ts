import { Component, OnInit } from '@angular/core';
import { BookParam} from '../../model/BookParam';
import { Category} from '../../model/Category';
import { EditorVM} from '../../model/EditorVM';
import { AuteurVM} from '../../model/AuteurVM';
import { BackendService } from '../../service/backend.service';
import { BookBackService } from '../../service/bookBack.service';
import { AuteurBackService } from '../../service/auteurBack.service';
import { EditorBackService } from '../../service/editorBack.service';
import { CategoryBackService } from '../../service/categoryBack.service';
import { MessagesService } from '../../service/messages.service';
import { DatashareService } from '../../service/datashare.service';
import { Router } from '@angular/router';
import { LocalStorageService } from 'ngx-webstorage';

@Component({
  selector: 'app-add-book',
  templateUrl: './add-book.component.html',
  styleUrls: ['./add-book.component.css'],
  providers: [MessagesService]
})
export class AddBookComponent implements OnInit {

  isAdmin = false;

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
  author: AuteurVM[] = [];
 /*author: AuteurVM = {
    id: 0,
    authorLastName: "",
	  firstName: "",
	  booksId: []
  };*/

  editor : EditorVM = {
    id:0,
    name:"",
    editorAddress:"",
    booksId: []
  };

constructor(
    private backService: BackendService,
    private auteurBackService: AuteurBackService,
    private bookBackService: BookBackService,
    private categoryBackService: CategoryBackService,
    private editorBackService: EditorBackService,
    private MessagesService: MessagesService,
    private dss: DatashareService,
    private storage: LocalStorageService,
    private router: Router) { }

     
fileToUpload: File = null;


  ngOnInit() {
    if(this.storage.retrieve('me')){
      if(this.storage.retrieve('me').access !== 1){  
        this.router.navigate(['/notAdmin']); 
      }
    }else{
      this.router.navigate(['/notConnected']); 
    }  
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
    this.bookBackService.addBook(this.bookParam).subscribe(
      data => {
        this.backService.handleData(data);
        if (data.payload) {
          console.log(data.payload);
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
    this.categoryBackService.getCategories().subscribe(
      data => {
        console.log('Categorie');
        console.log(data);
        this.categoryBackService.handleData(data);
        if (data.payload) {
          console.log('data payload');
          console.log(data.payload);
          this.category = data.payload;
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
    this.editorBackService.getEditors().subscribe(
      data => {
        console.log('Editeur');
        console.log(data);
        this.editorBackService.handleData(data);
        if (data.payload) {
          console.log('data payload');
          console.log(data.payload);
          this.editor = data.payload;
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
    this.auteurBackService.getAuteurs().subscribe(
      data => {
        console.log('Auteurs :');
        console.log(data);
        this.auteurBackService.handleData(data);
        if (data.payload) {
          console.log('data payload');
          console.log(data.payload);
          this.author = data.payload;
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
