import {NgModule} from '@angular/core';
import {ExtraOptions, RouterModule, Routes} from '@angular/router';

import {IssuesComponent} from './issues/issues.component';
import {DashboardComponent} from './dashboard/dashboard.component';


const routes: Routes = [
  {path: '', redirectTo: '/dashboard', pathMatch: 'full'},
  {path: 'dashboard', component: DashboardComponent},
  {path: 'issue', component: IssuesComponent},
  {path: 'administration', loadChildren: 'app/administration/administration.module#AdministrationModule'},
  {path: '', redirectTo: 'dashboard', pathMatch: 'full'},
  {path: '**', redirectTo: 'dashboard'}
];

const config: ExtraOptions = {
  useHash: true,
}

@NgModule({
  imports: [RouterModule.forRoot(routes, config)],
  exports: [RouterModule]
})
export class AppRoutingModule {

}
