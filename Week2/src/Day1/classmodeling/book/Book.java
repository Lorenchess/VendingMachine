package Day1.classmodeling.book;

import java.util.Date;

public class Book {
    private String name;
    private String author;
    private String language;
    private String ISBN;
    private String publisher;
    private Date dateOfPublishing;
    private int numberOfPages;
    private int weight;
    private int reviewsNumberOfStars;

    public Book(String name, String author, String language, String ISBN, String publisher, Date dateOfPublishing, int numberOfPages, int weight, int reviewsNumberOfStars) {
        this.name = name;
        this.author = author;
        this.language = language;
        this.ISBN = ISBN;
        this.publisher = publisher;
        this.dateOfPublishing = dateOfPublishing;
        this.numberOfPages = numberOfPages;
        this.weight = weight;
        this.reviewsNumberOfStars = reviewsNumberOfStars;
    }


    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getLanguage() {
        return language;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getPublisher() {
        return publisher;
    }

    public Date getDateOfPublishing() {
        return dateOfPublishing;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public int getWeight() {
        return weight;
    }

    public int getReviewsNumberOfStars() {
        return reviewsNumberOfStars;
    }

    public void setReviewsNumberOfStars(int reviewsNumberOfStars) {
        if (reviewsNumberOfStars >= 0 && reviewsNumberOfStars <= 5){
            this.reviewsNumberOfStars = reviewsNumberOfStars;
        }
    }

}
