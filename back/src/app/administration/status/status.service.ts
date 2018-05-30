import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import {Status} from './status';


@Injectable()
export class StatusService {

  constructor(protected http: HttpClient) {
  }

  public getStatus(): Observable<Status[]> {
    return this.http.get<Status[]>('http://localhost:8090/api/v1/status');
  }

  public addStatus(status: Status): Observable<any> {
    return this.http.post('http://localhost:8090/api/v1/status', status);
  }

  public deleteStatus(id: number): Observable<any> {
    return this.http.delete('http://localhost:8090/api/v1/status/' + id);
  }

}
