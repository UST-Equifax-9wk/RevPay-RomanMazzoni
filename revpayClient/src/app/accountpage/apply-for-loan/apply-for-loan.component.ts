import { Component, OnInit } from '@angular/core';
import { RemoteService, NewLoanDto } from '../../remote.service';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-apply-for-loan',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './apply-for-loan.component.html',
  styleUrl: './apply-for-loan.component.css'
})
export class ApplyForLoanComponent implements OnInit{
  remoteService: RemoteService;
  interest:number;
  distributer:string;
  initialAmount:number;
  username:string;
  business:boolean;

  constructor(remoteService: RemoteService){
    this.remoteService = remoteService;
    this.interest = 0;
    this.distributer = "";
    this.initialAmount = 0;
    this.username = "";
    this.business = false;
  }

  ngOnInit(): void {
    this.cookieUse();
  }
  cookieUse() {
    this.remoteService.cookieUse().subscribe({
      next: (data) => {
        console.log(data.body)
        if (data.body != null){
          let accountDto:any = data.body;
          this.username = accountDto.username;
          this.business = accountDto.accountBusiness;
        }

      },
      error: (error) => {
        console.log("error: ", error)
      }
    })
  }

  registerLoan(){
    let newLoanDto: NewLoanDto={
      distributer:this.distributer,
      interest:this.interest,
      initialAmount:this.initialAmount,
    }
    this.remoteService.registerLoan(newLoanDto, this.username).subscribe({
  
      next:(data)=>{
        alert("Applied for a new loan with: " + this.distributer + "!")
        console.log(data)
    }, 
      error:(error:HttpErrorResponse) =>{
        alert("Error: could not apply for a loan")
        console.log(error.error)

      }
    })
  }
}
