import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-movies',
  templateUrl: './movies.component.html',
  styleUrls: ['./movies.component.css']
})
export class MoviesComponent implements OnInit {

  movies = [];

  constructor(private http: HttpClient) {}

  ngOnInit() {
  }

  searchMovies(movie) {
    console.log(movie.value);
    this.http.get<any>(`http://www.omdbapi.com/?s=${movie.value}&apikey=6e88f86e`).subscribe(
      data => {
        this.movies = data.Search;
        console.log(this.movies);
      },
      err => {
        console.log(err);
      }
    );
  }

}
