import { Routes } from '@angular/router';
import { RegistrationComponent } from './registration/registration.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { AccountpageComponent } from './accountpage/accountpage.component';
import { CardRegistrationComponent } from './accountpage/card-registration/card-registration.component';
import { SendMoneyComponent } from './accountpage/send-money/send-money.component';
import { LogoutComponent } from './accountpage/logout/logout.component';
import { ViewTransactionsPageComponent } from './accountpage/view-transactions-page/view-transactions-page.component';
import { ViewCardsComponent } from './accountpage/view-cards/view-cards.component';

export const routes: Routes = [
    {path: "registration", component: RegistrationComponent},
    {path: "", component: HomeComponent},
    {path: "login", component: LoginComponent},
    {path: "accountHome", component:AccountpageComponent},
    {path: "cardRegister", component:CardRegistrationComponent},
    {path: "sendMoney", component:SendMoneyComponent},
    {path: "logout", component:LogoutComponent},
    {path: "viewTransactions", component:ViewTransactionsPageComponent},
    {path: "viewCards", component:ViewCardsComponent}
];
