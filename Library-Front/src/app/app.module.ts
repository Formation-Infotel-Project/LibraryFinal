import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';


import { AppComponent } from './app.component';
import { AppRoutingModule } from './/app-routing.module';
import { MessagesComponent } from './messages/messages.component';
import { MessagesService } from './messages.service';
import { NavbarComponent } from './navbar/navbar.component';
import { FooterComponent } from './footer/footer.component';
import { HomeComponent } from './home/home.component';
import { BookComponent } from './book/book.component';
import { LoginComponent } from './login/login.component';
import { AdministrationComponent } from './administration/administration.component';
import { MemberComponent } from './member/member.component';
import { AddMemberComponent } from './member/add-member/add-member.component';
import { AddBookComponent } from './book/add-book/add-book.component';
import { UpdateMemberComponent } from './member/update-member/update-member.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { HttpClientModule } from '@angular/common/http';
import { ConfigComponent } from './config/config.component';
import { BackendService } from './service/backend.service';
import { DatashareService } from './service/datashare.service';

@NgModule({
  declarations: [
    AppComponent,
    MessagesComponent,
    NavbarComponent,
    FooterComponent,
    HomeComponent,
    BookComponent,
    LoginComponent,
    AdministrationComponent,
    MemberComponent,
    AddMemberComponent,
    AddBookComponent,
    UpdateMemberComponent,
    PageNotFoundComponent,
    ConfigComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [BackendService, MessagesService, DatashareService],
  bootstrap: [AppComponent]
})
export class AppModule { }
