/*You're building a Movie Review Analyzer for a streaming platform. 
Your application will:
 - Read a list of N movies and their viewer ratings and reviews.
 - Compute a popularity score based on ratings and review lengths.
 - Classify movies as Blockbuster, Hit, or Flop.
 - Output a summary report for each movie.

Popularity Score Formula
------------------------
    - ratingScore = rating / 5.0
    - reviewScore = min(1.0, reviewLength / 200.0)
    - Final Score = (0.6 * ratingScore + 0.4 * reviewScore) * 100

Movie Classification
--------------------

    | Score-Range| Classification|
    ------------------------------
    |  ≥ 80	     | Blockbuster   |
    |  50–79	 | Hit           |
    |  < 50	     | Flop          | 


Tasks to Implement:
-------------------
- Create a POJO class Movie
    - Fields: title, rating, review
    - Constructor, getters, setters

- Create a POJO class MovieReport
    - Fields: Movie, score, category
    - toString() to return formatted output

- Define an interface MovieAnalyzer
    - Method: MovieReport analyze(Movie movie);

- Implement the interface in MovieAnalyzerImpl
    - Compute the score
    - Classify into category
    - Return a MovieReport

- Update Main class to:
    - Read N movies and their data from standard input
    - Print formatted analysis for each

Sample Input:
-------------
3
Inception
4.8
Mind-bending thriller with amazing visuals and story.
The Room
1.5
Terrible acting and editing. Poor direction.
Interstellar
4.5
Science fiction masterpiece. Great concept and emotional depth.

Sample Output
-------------
Movie: Inception, Score: 68.2, Category: Hit
Movie: The Room, Score: 26.8, Category: Flop
Movie: Interstellar, Score: 66.6, Category: Hit

*/
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        List<Movie> movies = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String title = sc.nextLine();
            double rating = Double.parseDouble(sc.nextLine());
            String review = sc.nextLine();

            movies.add(new Movie(title, rating, review));
        }

        MovieAnalyzer analyzer = new MovieAnalyzerImpl();

        for (Movie m : movies) {
            MovieReport report = analyzer.analyze(m);
            System.out.println(report);
        }
    }
}

// TODO: Implement this POJO class
class Movie {
    // Fields: title, rating, review
    // Constructor should use Setters
    // Setters
    // Getters
}

// TODO: Implement this POJO class
class MovieReport {
    // Fields: Movie movie, double score, String category
    // Constructor
    // Override toString() to return formatted summary
}

// TODO: Define this interface
interface MovieAnalyzer {
    MovieReport analyze(Movie movie);
}

// TODO: Implement this class
class MovieAnalyzerImpl implements MovieAnalyzer {
    @Override
    public MovieReport analyze(Movie movie) {
        // Use the following formula:
        // ratingScore = rating / 5.0
        // reviewScore = min(1.0, reviewLength / 200.0)
        // score = (0.6 * ratingScore + 0.4 * reviewScore) * 100
        // classify as Blockbuster / Hit / Flop
        return null; // replace with your logic
    }
}












//solution:

import java.util.*;

public class experian {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        List<Movie> movies = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String title = sc.nextLine();
            double rating = Double.parseDouble(sc.nextLine());
            String review = sc.nextLine();

            movies.add(new Movie(title, rating, review));
        }

        MovieAnalyzer analyzer = new MovieAnalyzerImpl();

        for (Movie m : movies) {
            MovieReport report = analyzer.analyze(m);
            System.out.println(report);
        }
    }
}

// TODO: Implement this POJO class
class Movie {
	private String title;
	private double rating;
	private String review;
	Movie(String title, double rating, String review){
		this.title = title;
		this.rating = rating;
		this.review = review;
	}
	public String getTitle() {
		return this.title;
	}
	public double getRating() {
		return this.rating;
	}
	public String getReview() {
		return this.review;
	}
}

// TODO: Implement this POJO class
class MovieReport {
	private Movie movie;
	private double score;
	private String category;
	MovieReport(Movie movie, double score, String category){
		this.movie = movie;
		this.score = score;
		this.category = category;
	}
	
	public String toString() {
		return String.format("Movie: %s, Score: %.1f, Category: %s",this.movie.getTitle(),this.score,this.category);
	}
}

// TODO: Define this interface
interface MovieAnalyzer {
    MovieReport analyze(Movie movie);
}

// TODO: Implement this class
class MovieAnalyzerImpl implements MovieAnalyzer {
    @Override
    public MovieReport analyze(Movie movie) {
        
    	double ratingScore = movie.getRating()/5.0;
    	double reviewScore = Math.min(1.0, (movie.getReview()).length()/200.0);
    	
    	double score = (0.6 * ratingScore + 0.4* reviewScore)*100;
    	
    	String category="";
    	if(score>=80) category="Blockbuster";
    	else if(score>=50 && score<=79) category = "Hit";
    	else category="Flop";
    			
        return new MovieReport(movie, score, category); // replace with your logic
    }
}
