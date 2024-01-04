import { Component, OnInit } from '@angular/core';
import {CookieService} from 'ngx-cookie-service';

@Component({
  selector: 'app-logout',
  standalone: true,
  imports: [],
  templateUrl: './logout.component.html',
  styleUrl: './logout.component.css'
})
export class LogoutComponent implements OnInit{
  cookieService:CookieService
  constructor(cookieService:CookieService){
    this.cookieService = cookieService;
  }


  ngOnInit(){
    this.cookieService.deleteAll();
  }
}
