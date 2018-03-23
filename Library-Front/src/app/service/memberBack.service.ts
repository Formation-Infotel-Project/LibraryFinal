import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { HttpHeaders,HttpErrorResponse } from '@angular/common/http';
import { ErrorObservable } from 'rxjs/observable/ErrorObservable';
import { catchError, retry } from 'rxjs/operators';
import { DatashareService } from '../service/datashare.service';
import { Member } from '../model/Member';

const httpOptions = {
    headers: new HttpHeaders({
        'Content-Type':  'application/json'
    })
}

@Injectable()
export class MemberBackService {

    constructor(private http: HttpClient){}

    addMember(member: Member){
        return this.http.post<Member>("http://localhost:8080/Library-Web/member/add", member, httpOptions).pipe(retry(3), catchError(this.handleError));
    }

    getMembers(){
        return this.http.get("http://localhost:8080/Library-Web/member/get").pipe(retry(3), catchError(this.handleError));
    }

    deleteMember(id){
        return this.http.get("http://localhost:8080/Library-Web/member/delete/"+id).pipe(retry(3), catchError(this.handleError));
    }

    private handleError(error: HttpErrorResponse){
        if(error.error instanceof ErrorEvent){
            console.error('An error occured : ', error.error.message);
        }else{
            console.error(`Backend returned code $(error.status), ` + `body was : $(error.error)`);
        }

        return new ErrorObservable("Something bad happened; please try again later.");        
    }

    handleData(data: any){
        if(data.success){
            console.log(data.message);
            /*messageService.displaySuccessfullMessage(data.message);*/
        }else{
            console.log(data.message);
            /*messageService.displayFailureMessage(data.message);*/
        }
    }
}
