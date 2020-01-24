import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule} from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { ForgetPasswordComponent } from './forget-password/forget-password.component';
import { NavbarComponent } from './navbar/navbar.component';
import { ProfileComponent } from './profile/profile.component';
import { HotelListComponent } from './hotel-list/hotel-list.component';
import { FilterPipe } from './filter.pipe';
import { BookingFormComponent } from './booking-form/booking-form.component';
import { HotelDetailsComponent } from './hotel-details/hotel-details.component';
import { ShowAllHotelsComponent } from './show-all-hotels/show-all-hotels.component';
import { AddhotelComponent } from './addhotel/addhotel.component';
import { ShowAllUsersComponent } from './show-all-users/show-all-users.component';
import { FeedbackComponent } from './feedback/feedback.component';
import { AddadminComponent } from './addadmin/addadmin.component';
import { UserHotelListComponent } from './user-hotel-list/user-hotel-list.component';
import { ModeOfPaymentComponent } from './mode-of-payment/mode-of-payment.component';
import { BookigHistoryComponent } from './bookig-history/bookig-history.component';
import { AboutUsComponent } from './about-us/about-us.component';
import { ContactUsComponent } from './contact-us/contact-us.component';
import { AddRoomComponent } from './add-room/add-room.component';
import { RoomListComponent } from './room-list/room-list.component';
import { VisitorHotelDetailsComponent } from './visitor-hotel-details/visitor-hotel-details.component';
import { ManagerHotelComponent } from './manager-hotel/manager-hotel.component';
import { FrontPageComponent } from './front-page/front-page.component';
import { ShowManagersComponent } from './show-managers/show-managers.component';
import { ShowAllHistoryComponent } from './show-all-history/show-all-history.component';
import { BookingConfirmComponent } from './booking-confirm/booking-confirm.component';
import { UpdateRoomComponent } from './update-room/update-room.component';
import { CardPaymentComponent } from './card-payment/card-payment.component';
import { ContactUsNavbarComponent } from './contact-us-navbar/contact-us-navbar.component';
import { AboutUsNavbarComponent } from './about-us-navbar/about-us-navbar.component';
import { ServicesComponent } from './services/services.component';
import { GetServicesComponent } from './get-services/get-services.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomeComponent,
    LoginComponent,
    RegisterComponent,
    PageNotFoundComponent,
    ForgetPasswordComponent,
    NavbarComponent,
    ProfileComponent,
    HotelListComponent,
    FilterPipe,
    BookingFormComponent,
    HotelDetailsComponent,
    ShowAllHotelsComponent,
    AddhotelComponent,
    ShowAllUsersComponent,
    FeedbackComponent,
    AddadminComponent,
    UserHotelListComponent,
    ModeOfPaymentComponent,
    BookigHistoryComponent,
    AboutUsComponent,
    ContactUsComponent,
    AddRoomComponent,
    RoomListComponent,
    VisitorHotelDetailsComponent,
    ManagerHotelComponent,
    FrontPageComponent,
    ShowManagersComponent,
    ShowAllHistoryComponent,
    BookingConfirmComponent,
    UpdateRoomComponent,
    CardPaymentComponent,
    ContactUsNavbarComponent,
    AboutUsNavbarComponent,
    ServicesComponent,
    GetServicesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
