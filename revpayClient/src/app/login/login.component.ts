import { Component } from '@angular/core';
import { AccountDto, RemoteService } from '../remote.service';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { HttpErrorResponse } from '@angular/common/http';


@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
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

  login(){
    let loginAttempt:AccountDto = {
      username:this.username,
      password:this.password,
      email:this.email,
      phoneNumber:this.phoneNumber,
      accountBusiness: this.accountBusiness
    }
    console.log(JSON.stringify(loginAttempt))
    this.remoteService.login(loginAttempt).subscribe({
      next:(data)=>{
        alert("Login Sucessful!")
        console.log(data)
    }, 
      error:(error:HttpErrorResponse) =>{
        alert(error.error)
        console.log(error.error)

      }
    })
    }
    cookieTest() {
      this.remoteService.cookieUse().subscribe({
        next: (data) => {
          console.log(data)
        },
        error: (error) => {
          console.log("error: ", error)
        }
      })
    }
  }

