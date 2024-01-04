import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable , catchError} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RemoteService{
  httpClient: HttpClient;
  baseUrl: String;
  httpOptions ={
    observe: 'response',
    headers: new HttpHeaders({'Content-Type':'application/json'})
  }
  constructor(httpClient: HttpClient) { 
    this.httpClient = httpClient;
    this.baseUrl = "http://localhost:8080"
  }
  registerAccount(accountDto: AccountDto): Observable<HttpResponse<Object>> {
    console.log("Creating account...");
    return this.httpClient.post(this.baseUrl + "/Accounts", JSON.stringify(accountDto),
    {
    observe:'response',
    headers: new HttpHeaders({'Content-Type': 'application/json'})
    }
    
    )
  }
  login(accountDto: AccountDto): Observable<HttpResponse<Object>>{
    console.log("logging in...");
    return this.httpClient.post(this.baseUrl + "/login", JSON.stringify(accountDto), {
      observe: 'response',
      withCredentials: true,
      headers:new HttpHeaders({'Content-Type': 'application/json'})
    })
  }

  cookieUse(): Observable<HttpResponse<Object>> {
    return this.httpClient.get(this.baseUrl + "/cookie-test", {
      observe: 'response',
      withCredentials: true ,
      headers: new HttpHeaders()
    })
  }
  registerCard(cardDto: CardDto, username: string): Observable<HttpResponse<Object>>{
    console.log("Creating card...");
    return this.httpClient.post(this.baseUrl + "/Accounts/" + username + "/addCard", JSON.stringify(cardDto),{
      observe: 'response',
      withCredentials: true ,
      headers: new HttpHeaders({'Content-Type': 'application/json'})
    })
  }
  transferMoney(account2:CurrentAccount, sentAmount:number): Observable<HttpResponse<Object>>{
    account2.balance = account2.balance + sentAmount;
    //console.log("THIS IS HERE" , account1.username)
    return  this.httpClient.post(this.baseUrl + "/Accounts/updateBalance", JSON.stringify(account2), {
      observe: 'response',
      withCredentials: true,
      headers:new HttpHeaders({'Content-Type': 'application/json'})
    })
  }
  getAccountbyBlank(input:string, type:string): Observable<HttpResponse<Object>>{
      return  this.httpClient.get(this.baseUrl + "/Accounts/" +type+"/" +input ,  {
        observe: 'response',
        withCredentials: true,
        headers:new HttpHeaders({'Content-Type': 'application/json'})
      })
    
  }

  registerTransaction(transacionDto: TransacionDto, recieveUsername: string): Observable<HttpResponse<Object>>{
    console.log("Creating transaction for: ", recieveUsername);
    return this.httpClient.post(this.baseUrl + "/Accounts/" + recieveUsername + "/addTransaction", JSON.stringify(transacionDto),{
      observe: 'response',
      withCredentials: true ,
      headers: new HttpHeaders({'Content-Type': 'application/json'})
    })
  }



  getTransactionsWithUsername(username:string): Observable<HttpResponse<Object>> {
    return this.httpClient.get(this.baseUrl + "/Accounts/"+username + "/transactions", {
      observe: 'response',
      withCredentials: true ,
      headers: new HttpHeaders()
    })
  }

  getCardsWithUsername(username:string): Observable<HttpResponse<Object>> {
    return this.httpClient.get(this.baseUrl + "/Accounts/"+username + "/cards", {
      observe: 'response',
      withCredentials: true ,
      headers: new HttpHeaders()
    })
  }

}
export interface AccountDto{
  username:String
  password:String
  email:String
  phoneNumber:String
  accountBusiness:boolean
}
export interface CurrentAccount{
  id:number
  username:string
  password:string
  email:string
  phoneNumber:string
  accountBusiness:boolean
  balance:number
}
export interface CardDto{
  cardType:string
  cardNumber:string
  securityCode:string
  expirationDate:string
  zipcode:string
}
export interface TransacionDto{
  transactionDetails:string
  transactionAmount:number
}