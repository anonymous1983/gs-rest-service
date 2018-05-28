import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {FormsModule} from '@angular/forms'; // <-- NgModel lives here
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {HttpClientModule} from '@angular/common/http';

import {AdministrationRoutingModule} from './administration-routing.module';
import {AdministrationComponent} from './administration.component';
import {StatusComponent} from './status/status.component';


@NgModule({
  declarations: [
    StatusComponent,
    AdministrationComponent
  ],
  imports: [
    FormsModule,
    CommonModule,
    AdministrationRoutingModule,
    HttpClientModule,
    NgbModule.forRoot()
  ],
  providers: []
})
export class AdministrationModule {
}
