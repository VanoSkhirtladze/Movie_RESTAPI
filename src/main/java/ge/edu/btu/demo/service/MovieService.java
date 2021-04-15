package ge.edu.btu.demo.service;

import ge.edu.btu.demo.dto.movie.*;

public interface MovieService {
    AddMovieOutput addMovie(AddMovieInput addMovieInput);

    GetMovieOutput getMovie(GetMovieInput getMovieInput);

    GetMoviesOutput getMovies(GetMoviesInput getMoviesInput);

    DeleteMovieOutput deleteMovie(DeleteMovieInput deleteMovieInput);
}
