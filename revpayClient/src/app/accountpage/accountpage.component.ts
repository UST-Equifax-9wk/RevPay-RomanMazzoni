import { Component, OnInit } from '@angular/core';
import { AccountDto, RemoteService } from '../remote.service';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { HttpErrorResponse } from '@angular/common/http';
import { assert } from 'console';

@Component({
  selector: 'app-accountpage',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './accountpage.component.html',
  styleUrl: './accountpage.component.css'
})
export class AccountpageComponent implements OnInit{
  remoteService:RemoteService;
  username:string;
  email:string;
  phoneNumber:string;
  business:boolean;
  balance:number;

  constructor(remoteService:RemoteService){
    this.username = "";
    this.email = "";
    this.phoneNumber = "";
    this.business = false;
    this.remoteService = remoteService;
    this.balance = 0;
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
          this.phoneNumber = accountDto.phoneNumber;
          this.email = accountDto.email;
          this.business = accountDto.accountBusiness;
          this.balance = accountDto.balance;
        }

      },
      error: (error) => {
        console.log("error: ", error)
      }
    })
  }
}
