package ge.edu.btu.demo.dto.movie;

import lombok.Data;


@Data
public class GetMovieOutput extends GetMoviesOutput {
    private Long postId;
    private String title;
    private String country;
}
