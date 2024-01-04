import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AccountDto, RemoteService } from '../remote.service';
import { error } from 'console';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-registration',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './registration.component.html',
  styleUrl: './registration.component.css'
})
export class RegistrationComponent {
  remoteService:RemoteService;
  username: string;
  password: string;
  email: string;
  phoneNumber: string;
  accountBusiness:boolean;
  constructor(remoteService:RemoteService){
    this.username = "";
    this.password = "";
    this.email = "";
    this.phoneNumber ="";
    this.accountBusiness = false;
    this.remoteService = remoteService;
  }
  dullButton:boolean = false;
  registrationText:string = "";

  registerAccount(){
    
    let newAccount: AccountDto={
      username:this.username,
      password:this.password,
      email:this.email,
      phoneNumber:this.phoneNumber,
      accountBusiness: this.accountBusiness
    }
    this.remoteService.registerAccount(newAccount).subscribe({

      next:(data)=>{
        alert("Registered a new account!")
        console.log(data)
    }, 
      error:(error:HttpErrorResponse) =>{
        alert("Error: could not create account")
        console.log(error.error)

      }
    })
    
  }
}
