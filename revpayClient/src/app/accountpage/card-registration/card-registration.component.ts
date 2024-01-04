import { Component } from '@angular/core';
import { RemoteService, CardDto } from '../../remote.service';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { HttpErrorResponse } from '@angular/common/http';
@Component({
  selector: 'app-card-registration',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './card-registration.component.html',
  styleUrl: './card-registration.component.css'
})
export class CardRegistrationComponent {
  remoteService: RemoteService;
  cardType:string
  cardNumber:string
  securityCode:string
  expirationDate:string
  zipcode:string
  dullButton:boolean = false
  username:string
  constructor(remoteService: RemoteService){
      this.remoteService = remoteService;
      this.cardType="";
      this.cardNumber="";
      this.securityCode="";
      this.expirationDate="";
      this.zipcode="";
      this.username=""
    }
  
    registerCard(){
    
      let newCard: CardDto={
        cardType:this.cardType,
        cardNumber:this.cardNumber,
        securityCode:this.securityCode,
        expirationDate:this.expirationDate,
        zipcode:this.zipcode
      }
      this.remoteService.registerCard(newCard, this.username).subscribe({
  
        next:(data)=>{
          alert("Registered a new card to account: " + this.username + "!")
          console.log(data)
      }, 
        error:(error:HttpErrorResponse) =>{
          alert("Error: could not register that card")
          console.log(error.error)
  
        }
      })
      
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
          }

        },
        error: (error) => {
          console.log("error: ", error)
        }
      })
    }

}
