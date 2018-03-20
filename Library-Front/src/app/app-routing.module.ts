import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { BookComponent } from './book/book.component';
import { AddBookComponent } from './book/add-book/add-book.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { AdministrationComponent } from './administration/administration.component';
import { MemberComponent } from './member/member.component';
import { AddMemberComponent } from './member/add-member/add-member.component';
import { UpdateMemberComponent } from './member/update-member/update-member.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';

const routes: Routes = [
    { path:'books', component: BookComponent },  
    { path:'book/add', component: AddBookComponent }, 
    { path: 'home', component: HomeComponent },
    { path: 'login', component: LoginComponent },
    { path: 'administration', component: AdministrationComponent },
    { path: 'members', component: MemberComponent },
    { path: 'member/add', component: AddMemberComponent },
    { path: 'member/update', component: UpdateMemberComponent },
    { path: '**', component: PageNotFoundComponent },
    { path:'', redirectTo:'/home', pathMatch:'full'}
]

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  exports:[RouterModule],
  declarations: []
})
export class AppRoutingModule { }
