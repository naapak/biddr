import {Component, OnInit, ViewEncapsulation} from '@angular/core';
import {environment} from 'environments/environment';
import {AppState} from './app.service';

@Component({
  selector: 'sidenav',
  styleUrls: ['./sidenav.component.css'],
  templateUrl: './sidenav.component.html'
})
export class SidenavComponent implements OnInit {

  public menuItems: Array<any> = [
    {name: "Products", icon: "fa-tachometer", state: "/products"},
    {name: "Orders", icon: "fa-folder-open-o", state: "/orders"},
    {name: "Settings", icon: "fa-shield", state: "/administration"},
  ];

  constructor() {
  }

  public ngOnInit() {
  }

}
