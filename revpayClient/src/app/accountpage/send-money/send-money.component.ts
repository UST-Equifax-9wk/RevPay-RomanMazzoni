import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { HttpErrorResponse } from '@angular/common/http';
import { RemoteService, CurrentAccount, TransacionDto } from '../../remote.service';
import { waitForAsync } from '@angular/core/testing';
import { delay, forkJoin } from 'rxjs';
import { error } from 'console';

@Component({
  selector: 'app-send-money',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './send-money.component.html',
  styleUrl: './send-money.component.css'
})
export class SendMoneyComponent {
  toAccount:string
  amount:number
  accountDeet:string
  remoteService:RemoteService
  account1:CurrentAccount = {
    id:0,
    username:"",
    password:"",
    email:"",
    phoneNumber:"",
    accountBusiness:false,
    balance:0
  };
  account2:CurrentAccount = {
    id:0,
    username:"",
    password:"",
    email:"",
    phoneNumber:"",
    accountBusiness:false,
    balance:0
  }
  constructor(remoteService:RemoteService){
    this.toAccount ="";
    this.amount = 0;
    this.accountDeet = "";
    this.remoteService = remoteService;
  }
  //fill in account 1 using cookie
  //fill in account 2 using given info
  //change both values
  runFunctions(){
    this.useCookie();
    this.findAccount2();
    console.log(this.account1.username)
    console.log(this.account2.username)
    this.transferFunds();

  }

  transferFunds(){
    if (this.account1.username == this.account2.username){
      alert("You cannot send money to yourself!")
      return;
    }
    if (this.account1.balance < this.amount){
      alert("Insufficient funds!")
      console.log("Your account had a balance of $", this.account1.balance, " and you tried to send $", this.amount)
      return;
    }
    
    
    this.remoteService.transferMoney(this.account2,this.amount).subscribe({
      next: (data) => {
        console.log(data.body)
        if (data.body != null){
        }
      },
      error: (error) => {
        console.log("error: ", error)
      }
    })
    this.remoteService.transferMoney(this.account1,-this.amount).subscribe({
      next: (data) => {
        console.log(data.body)
        if (data.body != null){
          alert("You sent " + this.account2.username + " $" + this.amount)
        }
        this.saveThisTransaction();
      },
      error: (error) => {
        console.log("error: ", error)
      }
    })
    
  }
  useCookie(){
    return this.remoteService.cookieUse().subscribe({
      next: (data) => {
        //console.log(data.body)
        if (data.body != null){
          let accountDto:any = data.body;
          this.account1.id = accountDto.id;
          this.account1.username = accountDto.username;
          this.account1.password = accountDto.password;
          this.account1.phoneNumber = accountDto.phoneNumber;
          this.account1.email = accountDto.email;
          this.account1.accountBusiness = accountDto.accountBusiness;
          this.account1.balance = accountDto.balance;
        }
        this.findAccount2()
      },
      error: (error) => {
        console.log("error: ", error)
      }
    })
  }
  findAccount2(){
    return this.remoteService.getAccountbyBlank(this.accountDeet, this.toAccount).subscribe({
      next: (data) => {
        //console.log(data.body)
        if (data.body != null){
          let accountDto:any = data.body;
          this.account2.id = accountDto.id;
          this.account2.username = accountDto.username;
          this.account2.password = accountDto.password;
          this.account2.email = accountDto.email;
          this.account2.phoneNumber = accountDto.phoneNumber;
          this.account2.accountBusiness = accountDto.accountBusiness;
          this.account2.balance = accountDto.balance;
        }
        this.transferFunds()
      },
      error: (error) => {
        console.log("error: ", error)
      }
    })
  }
  saveThisTransaction() {
    
    let thisTransaction:TransacionDto = {
      transactionDetails:"",
      transactionAmount:this.amount
    }
    thisTransaction.transactionDetails = ("The account " + this.account1.username + ", sent $" + thisTransaction.transactionAmount + " to the account " + this.account2.username)
    this.remoteService.registerTransaction(thisTransaction, this.account1.username, ).subscribe({
      next: (data) => {
        console.log("Transaction posted for ", this.account1.username);
      }, 
      error:(error) =>{
        console.log("error: ", error)
      }
    })
    thisTransaction.transactionDetails = ("The account " + this.account1.username + ", sent $" + thisTransaction.transactionAmount + " to the account " + this.account2.username)
    this.remoteService.registerTransaction(thisTransaction, this.account2.username, ).subscribe({
      next: (data) => {
        console.log("Transaction posted for ", this.account2);
        this.sendEmail();
      }, 
      error:(error) =>{
        console.log("error: ", error)
      }
    })
  }
  sendEmail(){
    
  }
}
