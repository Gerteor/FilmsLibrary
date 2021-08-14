package gerteor.model;

import java.util.Date;


public class Director extends Films{

    private Long id;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private Films films;

    public Director() {
    }

    public Director(Long id, String firstName, String lastName, Date birthDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public Director(String firstName, String lastName, Date birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public Director(String firstName, String lastName, Films films) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.films = films;
    }

    public Director(String firstName, String lastName, Date birthDate, Films films) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.films = films;
    }

    public Director(Long id, String firstName, String lastName, Date birthDate, Films films) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.films = films;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Films getFilms() {
        return films;
    }

    public void setFilms(Films films) {
        this.films = films;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDate() {
        return birthDate;
    }

    public void setDate(Date birthdate) {
        this.birthDate = birthdate;
    }

    @Override
    public String toString() {
        return id + ";" + firstName + ";" + lastName +
                ";" + birthDate + ";" + films ;
    }

}
