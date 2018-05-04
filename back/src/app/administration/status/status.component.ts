import {Component, OnInit} from '@angular/core';

import {Status} from './status';
import {StatusService} from './status.service';

@Component({
  selector: 'app-status',
  providers: [StatusService],
  templateUrl: './status.component.html',
  styleUrls: ['./status.component.css']
})
export class StatusComponent implements OnInit {

  public statusList: Status[];

  constructor(private statusService: StatusService) {
  }

  ngOnInit() {
    this.getStatus();
  }

  getStatus(): void {
    this.statusService.getStatus().subscribe(data => this.statusList = data);
  }

  updateStatus(id: number): void {
    console.log(id);
  }

}
