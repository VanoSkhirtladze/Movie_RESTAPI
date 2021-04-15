package ge.edu.btu.demo.repository;

import ge.edu.btu.demo.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
