import {Component, OnInit} from '@angular/core';

import {Status} from './status';
import {StatusService} from './status.service';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-status',
  providers: [StatusService],
  templateUrl: './status.component.html',
  styleUrls: ['./status.component.css']
})
export class StatusComponent implements OnInit {

  public statusList: Status[];
  public modalStatusObj: Status;

  constructor(private statusService: StatusService, private modalService: NgbModal) {
  }

  ngOnInit() {
    this.getStatus();
  }

  getStatus(): void {
    this.statusService.getStatus().subscribe(data => this.statusList = data);
  }

  updateStatus(status: Status, modalId): void {
    this.modalStatusObj = status;
    this.modalStatusObj['modalTitle'] = 'Update Status';
    this.modalService.open(modalId, {centered: true, size: 'lg'});
  }

}
