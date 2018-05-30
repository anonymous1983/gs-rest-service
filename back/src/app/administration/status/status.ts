import {StatusInterface} from './status.interface';

export class Status implements StatusInterface {

  public id: number;
  public name: string;
  public description: string;
  public color: string;
  public icon: string;

  constructor({name = '', description = '', color = '', icon = ''}: { name?: string, description?: string, color?: string, icon?: string }) {
    this.name = name;
    this.description = description;
    this.color = color;
    this.icon = icon;
  }
}
