import { Component , OnInit} from '@angular/core';

import { AccountDto, RemoteService, CurrentAccount } from '../../remote.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-view-cards',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './view-cards.component.html',
  styleUrl: './view-cards.component.css'
})
export class ViewCardsComponent {
  remoteService:RemoteService;
  username:string;
  cardsNumber:Array<string>
  cardsType:Array<string>
  cardsExpir:Array<string>
  cardsZip:Array<string>
  cardsArray:Array<Root2>
  account1:CurrentAccount = {
    id:0,
    username:"",
    password:"",
    email:"",
    phoneNumber:"",
    accountBusiness:false,
    balance:0
  };
  constructor(remoteService:RemoteService){
    this.username = "";
    this.remoteService = remoteService;
    this.cardsNumber = [];
    this.cardsType = [];
    this.cardsExpir = [];
    this.cardsZip = [];
    this.cardsArray = [];
  }

  ngOnInit(): void {
    this.cookieUse();
  }
  cookieUse() {
    this.remoteService.cookieUse().subscribe({
      next: (data) => {
        console.log(data.body)
        if (data.body){
          let accountDto:any = data.body;
          this.username = accountDto.username;
          this.account1.id = accountDto.id;
          this.account1.username = accountDto.username;
          this.account1.password = accountDto.password;
          this.account1.phoneNumber = accountDto.phoneNumber;
          this.account1.email = accountDto.email;
          this.account1.accountBusiness = accountDto.accountBusiness;
          this.account1.balance = accountDto.balance;
        }
        this.loadCards();
      },
      error: (error) => {
        console.log("error: ", error)
      }
    })
  }
  loadCards(){
    this.remoteService.getCardsWithUsername(this.username).subscribe({
      next: (data) => {
        console.log(data.body)
        if (data.body){
          let transactionDto:any = data.body;
          //this.transactions = transactionDto;
          let cardsArray:Root = transactionDto
          cardsArray.forEach((card) => {
          let currentCard:Root2 = {
            cardNumber:card.cardNumber,
            cardId:0,
            cardType:card.cardType,
            expirationDate:card.expirationDate,
            zipcode:card.zipcode,
          }
          this.cardsArray.push(currentCard)
          })
        }
      },
      error: (error) => {
        console.log("error: ", error)
      }
    })
  }
  addFunds(){
    this.remoteService.transferMoney(this.account1,5).subscribe({
      next: (data) => {
        console.log(data.body)
        if (data.body != null){
          alert("You added $5 to your account")
        }
      },
      error: (error) => {
        console.log("error: ", error)
      }
    })
  }
  
}
export type Root = Root2[]

export interface Root2 {
  cardId: number
  cardNumber: string
  cardType: string
  expirationDate: string
  zipcode:string
}

