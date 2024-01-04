import { Component , OnInit} from '@angular/core';

import { AccountDto, RemoteService } from '../../remote.service';
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

  
}
export type Root = Root2[]

export interface Root2 {
  cardId: number
  cardNumber: string
  cardType: string
  expirationDate: string
  zipcode:string
}

