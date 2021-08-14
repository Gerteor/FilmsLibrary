package gerteor.model;

import java.util.Date;


public class Films {

    private Long id;
    private Long idDirector;
    private String nameFilm;
    private Date releaseDate;
    private String genre;
    private int dateYear;

    public Films() {
    }

    public Films(Long id, String nameFilm, Date releaseDate, String genre) {
        this.id = id;
        this.nameFilm = nameFilm;
        this.releaseDate = releaseDate;
        this.genre = genre;
    }

    public Films(String nameFilm, Date releaseDate, String genre) {
        this.nameFilm = nameFilm;
        this.releaseDate = releaseDate;
        this.genre = genre;
    }

    public Films(String nameFilm, String genre) {
        this.nameFilm = nameFilm;
        this.genre = genre;
    }

    public Films(Long id, Long idDirector, String nameFilm, Date releaseDate, String genre) {
        this.id = id;
        this.idDirector = idDirector;
        this.nameFilm = nameFilm;
        this.releaseDate = releaseDate;
        this.genre = genre;
    }

    public Films(String nameFilm, int dateYear, String genre) {
        this.nameFilm = nameFilm;
        this.genre = genre;
        this.dateYear = dateYear;}


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdDirector() {
        return idDirector;
    }

    public void setIdDirector(Long idDirector) {
        this.idDirector = idDirector;
    }

    public String getNameFilm() {
        return nameFilm;
    }

    public void setNameFilm(String nameFilm) {
        this.nameFilm = nameFilm;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getDateYear() {
        return dateYear;
    }

    public void setDateYear(int dateYear) {
        this.dateYear = dateYear;
    }

    @Override
    public String toString() {
        return id + ";" + idDirector + ";" + nameFilm + ";" + releaseDate + ";" +genre;
    }
}
