import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-track-routes',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './track-routes.component.html',
  styleUrls: ['./track-routes.component.css']
})
export class TrackRoutesComponent implements OnInit {

  latitude: number = 0;
  longitude: number = 0;

  vehicleStatus: string = 'Offline';
  lastUpdated: string = '-';

  ngOnInit(): void {

    this.loadLocation();

    setInterval(() => {
      this.loadLocation();
    }, 2000);

  }

  loadLocation() {

    fetch('http://localhost:8080/api/location')
      .then(response => response.json())
      .then(data => {

        this.latitude = data.latitude;
        this.longitude = data.longitude;

        this.vehicleStatus = 'Tracking';
        this.lastUpdated = new Date().toLocaleTimeString();

      })
      .catch(error => {

        console.error('Location Fetch Error:', error);

        this.vehicleStatus = 'Offline';

      });
  }
}