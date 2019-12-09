import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { LoginResponse } from './login-response';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  isLoggedIn(): boolean {
    const user: LoginResponse = JSON.parse(localStorage.getItem('token'));
    if (user && user.registered) {
      return true;
    } else {
      return false;
    }
  }

  constructor(private http: HttpClient) { }

  register(data) {
    return this.http.post(
      'https://identitytoolkit.googleapis.com/v1/accounts:signUp?key=AIzaSyB0VCnSmAVkTNbu2nKuyguRpZ7yP-x7ZJE',
      { ...data, returnSecureToken: true });
  }

  // login(data){
  //   return this.http.post('https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key=AIzaSyB0VCnSmAVkTNbu2nKuyguRpZ7yP-x7ZJE',
  //   {...data, returnSecureToken: true});
  // }

  login(data): Observable<LoginResponse> {
    // tslint:disable-next-line: max-line-length
    return this.http.post<LoginResponse>('https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key=AIzaSyB0VCnSmAVkTNbu2nKuyguRpZ7yP-x7ZJE',
      { ...data, returnSecureToken: true });
  }

}
