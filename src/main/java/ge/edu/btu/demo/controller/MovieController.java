package ge.edu.btu.demo.controller;

import ge.edu.btu.demo.dto.movie.*;

import ge.edu.btu.demo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/MovieController")
public class MovieController {
    @Autowired
    MovieService movieService;

    @PostMapping("addMovie")
    public AddMovieOutput addMovie(@RequestBody AddMovieInput addMovieInput){
        return movieService.addMovie(addMovieInput);
    }

    @PostMapping("getMovie")
    public GetMovieOutput getMovie(@RequestBody GetMovieInput getMovieInput){
        return movieService.getMovie(getMovieInput);
    }

    @PostMapping("getMovies")
    public GetMoviesOutput getMovies(@RequestBody GetMoviesInput getMoviesInput){
        return movieService.getMovies(getMoviesInput);
    }

    @PostMapping("deleteMovie")
    public DeleteMovieOutput deleteMovie(@RequestBody DeleteMovieInput deleteMovieInput){
        return movieService.deleteMovie(deleteMovieInput);

    }

}
