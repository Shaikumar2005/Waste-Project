import { Component, AfterViewInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

declare var google: any;

@Component({
  selector: 'app-routes',
  standalone: false,
  templateUrl: './track-routes.component.html',
  styleUrls: ['./track-routes.component.css']
})
export class RoutesComponent implements AfterViewInit {

  map: any;
  marker: any;

  latitude: number = 0;
  longitude: number = 0;
  vehicleStatus: string = "Active";
  lastUpdated: string = "";

  constructor(private http: HttpClient) {}

  ngAfterViewInit(): void {

    this.initializeMap();

    this.fetchLiveLocation();

    setInterval(() => {
      this.fetchLiveLocation();
    }, 3000);
  }

  initializeMap() {

    const defaultLocation = {
      lat: 13.0827,
      lng: 80.2707
    };

    this.map = new google.maps.Map(
      document.getElementById("map"),
      {
        center: defaultLocation,
        zoom: 14
      }
    );

    this.marker = new google.maps.Marker({
      position: defaultLocation,
      map: this.map,
      title: "Smart Waste Vehicle"
    });
  }

  fetchLiveLocation() {

    this.http.get<any>('http://localhost:8080/api/location')
      .subscribe((data) => {

        if (data.length > 0) {

          const latest = data[data.length - 1];

          this.latitude = latest.latitude;
          this.longitude = latest.longitude;

          this.lastUpdated = new Date().toLocaleTimeString();

          const newPosition = {
            lat: this.latitude,
            lng: this.longitude
          };

          this.marker.setPosition(newPosition);

          this.map.setCenter(newPosition);
        }

      });
  }
}