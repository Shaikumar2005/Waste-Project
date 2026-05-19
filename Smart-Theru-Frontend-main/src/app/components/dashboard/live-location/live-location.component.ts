import { Component, AfterViewInit } from '@angular/core';
import * as L from 'leaflet';
import { LocationService } from '../../../services/location.service';

@Component({
  selector: 'app-live-location',
  standalone: true,
  templateUrl: './live-location.component.html',
  styleUrls: ['./live-location.component.css']
})
export class LiveLocationComponent implements AfterViewInit {

  private map: any;
  private marker: any;

  constructor(private locationService: LocationService) {}

  ngAfterViewInit(): void {
    this.initMap();
    this.fetchLiveLocation();

    setInterval(() => {
      this.fetchLiveLocation();
    }, 3000);
  }

  initMap() {

    this.map = L.map('map').setView([13.0827, 80.2707], 15);

    L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
      attribution: 'OpenStreetMap'
    }).addTo(this.map);

  }

  fetchLiveLocation() {

    this.locationService.getLocations().subscribe((data: any) => {

      if (data.length > 0) {

        const latest = data[data.length - 1];

        const lat = latest.latitude;
        const lng = latest.longitude;

        if (this.marker) {
          this.map.removeLayer(this.marker);
        }

        this.marker = L.marker([lat, lng]).addTo(this.map)
          .bindPopup('Smart Waste Bin Live Location')
          .openPopup();

        this.map.setView([lat, lng], 15);
      }

    });

  }
}