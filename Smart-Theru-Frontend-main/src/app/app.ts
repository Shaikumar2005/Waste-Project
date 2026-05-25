import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { SidebarComponent } from './layout/sidebar.component';
import { HeaderComponent } from './layout/header.component';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    RouterOutlet,
    SidebarComponent,
    HeaderComponent,
    CommonModule
  ],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class AppComponent implements OnInit {

  latitude: number = 0;
  longitude: number = 0;

  ngOnInit(): void {

    setInterval(() => {

      fetch('http://localhost:8080/api/location')
        .then((res) => res.json())
        .then((data) => {

          this.latitude = data.latitude;
          this.longitude = data.longitude;

        })
        .catch((error) => {

          console.log('Error:', error);

        });

    }, 2000);
  }
}