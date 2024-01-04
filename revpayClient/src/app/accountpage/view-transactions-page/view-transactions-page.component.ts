import { Component, OnInit } from '@angular/core';
import { AccountDto, RemoteService } from '../../remote.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-view-transactions-page',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './view-transactions-page.component.html',
  styleUrl: './view-transactions-page.component.css'
})
export class ViewTransactionsPageComponent implements OnInit{
  remoteService:RemoteService;
  username:string;
  transactions:String;
  transactionsArray:Array<string>

  constructor(remoteService:RemoteService){
    this.username = "";
    this.remoteService = remoteService;
    this.transactions = "";
    this.transactionsArray = [];
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
        this.loadTransactions();
      },
      error: (error) => {
        console.log("error: ", error)
      }
    })
  }
  loadTransactions(){
    this.remoteService.getTransactionsWithUsername(this.username).subscribe({
      next: (data) => {
        console.log(data.body)
        if (data.body){
          let transactionDto:any = data.body;
          //this.transactions = transactionDto;
          let transArray:Root = transactionDto
          transArray.forEach((trans) => {this.transactionsArray.push(trans.transactionDetails + "\n")})
          console.log(this.transactions)
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
  transactionId: number
  transactionDetails: string
  transactionAmount: number
}
