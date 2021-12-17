import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../model/user';

const AUTH_API = 'http://localhost:8091/users/';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  constructor(private http: HttpClient) { }

  login(username: string, password: string): Observable<any> {
    return this.http.post(AUTH_API + 'signin', {
      username,
      password
    }, httpOptions);
  }

  register(username: string, email: string, password: string, phone: string, firstName: string, middleName: string, lastName: string): Observable<any> {

    let user = new User();
    user.email = email;
    user.password = password;
    user.userName = username;
    user.phoneNumber = phone;
    user.firstName = firstName;
    user.middleName = middleName;
    user.lastName = lastName;
    return this.http.post<any>('http://localhost:8091/users/createUser', user, httpOptions);

    //return this.http.post(AUTH_API + 'createUser', user)
  }
}