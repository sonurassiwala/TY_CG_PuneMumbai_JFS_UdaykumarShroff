import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { ForgetPasswordComponent } from './forget-password/forget-password.component';
import { NavbarComponent } from './navbar/navbar.component';
import { ProfileComponent } from './profile/profile.component';
import { HotelListComponent } from './hotel-list/hotel-list.component';
import { BookingFormComponent } from './booking-form/booking-form.component';
import { AddhotelComponent } from './addhotel/addhotel.component';
import { ShowAllHotelsComponent } from './show-all-hotels/show-all-hotels.component';
import { FeedbackComponent } from './feedback/feedback.component';
import { AddadminComponent } from './addadmin/addadmin.component';
import { UserHotelListComponent } from './user-hotel-list/user-hotel-list.component';
import { HotelDetailsComponent } from './hotel-details/hotel-details.component';
import { ModeOfPaymentComponent } from './mode-of-payment/mode-of-payment.component';
import { BookigHistoryComponent } from './bookig-history/bookig-history.component';
import { AboutUsComponent } from './about-us/about-us.component';
import { ContactUsComponent } from './contact-us/contact-us.component';
import { AddRoomComponent } from './add-room/add-room.component';
import { RoomListComponent } from './room-list/room-list.component';
import { AuthGuard } from './auth.guard';
import { VisitorHotelDetailsComponent } from './visitor-hotel-details/visitor-hotel-details.component';
import { ManagerHotelComponent } from './manager-hotel/manager-hotel.component';
import { FrontPageComponent } from './front-page/front-page.component';
import { ShowAllUsersComponent } from './show-all-users/show-all-users.component';
import { ShowManagersComponent } from './show-managers/show-managers.component';
import { ShowAllHistoryComponent } from './show-all-history/show-all-history.component';
import { BookingConfirmComponent } from './booking-confirm/booking-confirm.component';
import { UpdateRoomComponent } from './update-room/update-room.component';
import { CardPaymentComponent } from './card-payment/card-payment.component';
import { ContactUsNavbarComponent } from './contact-us-navbar/contact-us-navbar.component';
import { AboutUsNavbarComponent } from './about-us-navbar/about-us-navbar.component';
import { ServicesComponent } from './services/services.component';
import { GetServicesComponent } from './get-services/get-services.component';

const routes: Routes = [
  { path: '', component: HomeComponent},
  { path: 'login', component: LoginComponent},
  { path: 'register', component: RegisterComponent},
  { path: 'booking-form', component: BookingFormComponent},
  { path: 'forget-password', component: ForgetPasswordComponent},
  { path: 'navbar', component: NavbarComponent},
  { path: 'profile', component: ProfileComponent},
  { path: 'hotel-list', component: HotelListComponent},
  { path: 'addhotel', component: AddhotelComponent, canActivate: [AuthGuard], data: {userType : ['Admin']}},
  { path: 'show-all-hotels', component: ShowAllHotelsComponent},
  { path: 'feedback', component: FeedbackComponent},
  { path: 'forget-password', component: ForgetPasswordComponent},
  { path: 'addadmin', component: AddadminComponent, canActivate: [AuthGuard], data: {userType : ['Admin']}},
  { path: 'user-hotel-list', component: UserHotelListComponent},
  { path: 'hotel-details', component: HotelDetailsComponent},
  { path: 'mode-of-payment', component: ModeOfPaymentComponent},
  { path: 'booking-history', component: BookigHistoryComponent},
  { path: 'about-us', component: AboutUsComponent},
  { path: 'contact-us', component: ContactUsComponent},
  { path: 'add-room', component: AddRoomComponent, canActivate: [AuthGuard], data: {userType : ['Manager']}},
  { path: 'room-list', component: RoomListComponent},
  { path: 'visitor-hotel-details', component: VisitorHotelDetailsComponent},
  { path: 'manager-hotel', component: ManagerHotelComponent},
  { path: 'front-page', component: FrontPageComponent},
  { path: 'get-services', component: GetServicesComponent},
  { path: 'show-all-user', component: ShowAllUsersComponent, canActivate: [AuthGuard], data: {userType : ['Admin']}},
  { path: 'show-all-managers', component: ShowManagersComponent, canActivate: [AuthGuard], data: {userType : ['Admin']}},
  { path: 'show-all-history', component: ShowAllHistoryComponent, canActivate: [AuthGuard], data: {userType : ['Admin']}},
  { path: 'booking-confirm', component: BookingConfirmComponent},
  { path: 'update-room', component: UpdateRoomComponent, canActivate: [AuthGuard], data: {userType : ['Manager']}},
  { path: 'card-payment', component: CardPaymentComponent},
  { path: 'contact-us-navbar', component: ContactUsNavbarComponent},
  { path: 'about-us-navbar', component: AboutUsNavbarComponent},
  { path: 'services', component: ServicesComponent},
  { path: '**', component: PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
