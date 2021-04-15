package ge.edu.btu.demo;

import ge.edu.btu.demo.model.Movie;
import ge.edu.btu.demo.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @Autowired
    MovieRepository movieRepository;

    @GetMapping("addMovie")
    public void addMovie(){
        Movie movie=new Movie();
        movie.setTitle("ფილმი 1");
        movie.setCountry("ქვეყანა");
        movieRepository.save(movie);
    }


    @GetMapping("getMovies")
    public void getMovies(){
        for (Movie movie: movieRepository.findAll()){
            System.out.println(movie);
        }
    }

    @GetMapping("getMovie")
    public void getMovie(){
        Movie movie=movieRepository.getOne(1L);
        System.out.println(movie.getTitle());
        System.out.println(movie.getCountry());

    }

    @GetMapping("deleteMovie")
    public void deleteMovie(){
        Movie movie=movieRepository.getOne(1L);
        movieRepository.delete(movie);
    }


}
