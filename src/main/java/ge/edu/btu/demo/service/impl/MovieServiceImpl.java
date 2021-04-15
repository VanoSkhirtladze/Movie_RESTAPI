package ge.edu.btu.demo.service.impl;

import ge.edu.btu.demo.dto.movie.*;
import ge.edu.btu.demo.model.Movie;
import ge.edu.btu.demo.repository.MovieRepository;
import ge.edu.btu.demo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
@Autowired
MovieRepository movieRepository;

    @Override
    public AddMovieOutput addMovie(AddMovieInput addMovieInput) {
        Movie movie =new Movie();
        movie.setTitle(addMovieInput.getTitle());
        movie.setCountry(addMovieInput.getCountry());
        movieRepository.save(movie);
        AddMovieOutput addMovieOutput=new AddMovieOutput();
        addMovieOutput.setMsg("ფილმი წარმატებით დაემატა");
        return addMovieOutput;
    }

    @Override
    public GetMovieOutput getMovie(GetMovieInput getMovieInput) {
        Movie movie=movieRepository.getOne(getMovieInput.getPostId());
        GetMovieOutput getMovieOutput=new GetMovieOutput();
        getMovieOutput.setPostId(movie.getId());
        getMovieOutput.setTitle(movie.getTitle());
        getMovieOutput.setCountry(movie.getCountry());
        return getMovieOutput;
    }

    @Override
    public GetMoviesOutput getMovies(GetMoviesInput getMoviesInput) {
        List<MovieDTO> movieDTOList=new ArrayList<>();
        GetMoviesOutput movieOutput = new GetMoviesOutput();
        for (Movie movie : movieRepository.findAll()){
            MovieDTO movieDTO=new MovieDTO();
            movieDTO.setId(movie.getId());
            movieDTO.setTitle(movie.getTitle());
            movieDTO.setCountry((movie.getCountry()));
            movieDTOList.add(movieDTO);
        }
        movieOutput.setMovies(movieDTOList);
        return movieOutput;
    }

    @Override
    public DeleteMovieOutput deleteMovie(DeleteMovieInput deleteMovieInput) {
        Movie movie=movieRepository.getOne(deleteMovieInput.getPostId());
        movieRepository.delete(movie);

        DeleteMovieOutput deleteMovieOutput=new DeleteMovieOutput();
        deleteMovieOutput.setMsg("ფილმი წარმატებით წაიშალა");
        return deleteMovieOutput;
    }
}
