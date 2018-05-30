import {Component, OnInit} from '@angular/core';

import {Status} from './status';
import {StatusService} from './status.service';
import {NgbModal, NgbModalRef} from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-status',
  providers: [StatusService],
  templateUrl: './status.component.html',
  styleUrls: ['./status.component.css']
})
export class StatusComponent implements OnInit {

  public statusList: Status[];
  public modalStatusObj: Status;
  public modalStatusTitle: String;
  private modalStatusRef: NgbModalRef;

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
    this.modalStatusTitle = 'Update Status';
    this.modalService.open(modalId, {centered: true, size: 'lg'});
  }

  addStatus(modalId): void {
    this.modalStatusObj = new Status({});
    this.modalStatusTitle = 'Add Status';
    this.modalStatusRef = this.modalService.open(modalId, {centered: true, size: 'lg'});
  }

  saveAddStatus(status: Status): void {
    this.statusService.addStatus(status).subscribe((response: Response) => {
      this.statusService.getStatus().subscribe(data => {
        this.statusList = data;
        this.modalStatusRef.close();
      });

    });
  }

  deleteStatus(status: Status): void {
    this.statusService.deleteStatus(status.id).subscribe((response: Response) => {
      console.log(response);
      this.statusService.getStatus().subscribe(data => {
        this.statusList = data;
        this.modalStatusRef.close();
      });
    });
  }


}
