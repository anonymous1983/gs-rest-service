import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {HttpClientModule} from '@angular/common/http';

import {AppRoutingModule} from './/app-routing.module';
import {AppComponent} from './app.component';
import {IssuesComponent} from './issues/issues.component';
import {DashboardComponent} from './dashboard/dashboard.component';
import {StatusComponent} from './administration/status/status.component';



@NgModule({
  declarations: [
    AppComponent,
    IssuesComponent,
    DashboardComponent,
    StatusComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
