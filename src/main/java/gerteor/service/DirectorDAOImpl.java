package gerteor.service;

import gerteor.connect.PostgreSQLJDBC;
import gerteor.model.Director;
import gerteor.model.Films;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class DirectorDAOImpl implements DirectorDAO {
    private static final String ALL_DIRECTOR = "SELECT * FROM director AS d INNER JOIN film AS f ON d.id= f.director_id;";
    private static final String ADD_DIRECTOR = "INSERT INTO director (first_name, last_name, birth_date)" +
            " VALUES ( ? , ? , ?) ";
    private static final String SEARCH_DIRECTOR = "SELECT d.first_name,d.last_name,d.birth_date,f.name," +
            "EXTRACT(YEAR FROM release_date) as year,f.genre FROM film " +
            "AS f inner join director AS d ON f.director_id = d.id WHERE d.first_name LIKE";
    private static final String SEARCH_FILM_BEFORE = "SELECT  d.first_name,d.last_name,d.birth_date,f.name," +
            "EXTRACT(YEAR FROM release_date),f.genre FROM director AS d INNER JOIN film AS f ON d.id= f.director_id " +
            "where EXTRACT(YEAR FROM f.release_date) <= ";
    private static final String SEARCH_FILM_AFTER = "SELECT  d.first_name,d.last_name,d.birth_date,f.name," +
            "EXTRACT(YEAR FROM release_date),f.genre FROM director AS d INNER JOIN film AS f ON d.id= f.director_id " +
            "where EXTRACT(YEAR FROM f.release_date) >= ";
    private static final String SEARCH_FILM_BETWEEN = "SELECT  d.first_name,d.last_name,d.birth_date,f.name," +
            "EXTRACT(YEAR FROM release_date),f.genre FROM director AS d INNER JOIN film AS f ON d.id= f.director_id " +
            "where EXTRACT(YEAR FROM f.release_date)  BETWEEN  ";

    @Autowired
    private PostgreSQLJDBC postgreSQLJDBC;

    @Override
    public void add(String first_name, String last_name, Date birth_date) {
        Director director = new Director(first_name, last_name, birth_date);
        try (Connection connection = postgreSQLJDBC.getInst().getConncetion();
             PreparedStatement prst = connection.prepareStatement(ADD_DIRECTOR)) {
            prst.setString(1, director.getFirstName());
            prst.setString(2, director.getLastName());
            prst.setDate(3, (java.sql.Date) director.getDate());
            prst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Director> getAllDirectors() {

        List<Director> directorList = new ArrayList<>();

        try (Connection connection = postgreSQLJDBC.getInst().getConncetion();
             PreparedStatement prst = connection.prepareStatement(ALL_DIRECTOR)) {
            try (ResultSet rest = prst.executeQuery()) {
                while (rest.next()) {
                    Long id = rest.getLong(1);
                    String firstName = rest.getString(2);
                    String lastName = rest.getString(3);
                    Date birthDate = rest.getDate(4);
                    long idFilm = rest.getLong(5);
                    long idDir = rest.getLong(6);
                    String filmName = rest.getString(7);
                    Date releaseDate = rest.getDate(8);
                    String genre = rest.getString(9);
                    directorList.add(new Director(id, firstName, lastName, birthDate,
                            new Films(idFilm, idDir, filmName, releaseDate, genre)));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return directorList;
    }

    @Override
    public List<Director> search(String name) {
        List<Director> listsearch = new ArrayList();
        String searchName = name;
        String searchSQL = "'" + searchName + '%' + "'";
        try (Connection connection = postgreSQLJDBC.getInst().getConncetion();
             PreparedStatement prst = connection.prepareStatement(SEARCH_DIRECTOR + searchSQL + ";")) {
            try (ResultSet rest = prst.executeQuery()) {
                while (rest.next()) {
                    String firstName = rest.getString(1);
                    String lastName = rest.getString(2);
                    Date birthDate = rest.getDate(3);
                    String filmName = rest.getString(4);
                    int releaseDate = rest.getInt(5);
                    String genre = rest.getString(6);
                    listsearch.add(new Director(firstName, lastName, birthDate,
                            new Films(filmName, releaseDate, genre)));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listsearch;
    }

    @Override
    public List<Director> searchBefore(int year) {
        List<Director> listsearch = new ArrayList();
        String searchSQL = "'" + year + "'";
        try (Connection connection = postgreSQLJDBC.getInst().getConncetion();
             PreparedStatement prst = connection.prepareStatement(SEARCH_FILM_BEFORE + searchSQL + ";")) {
            try (ResultSet rest = prst.executeQuery()) {
                while (rest.next()) {
                    String firstName = rest.getString(1);
                    String lastName = rest.getString(2);
                    Date birthDate = rest.getDate(3);
                    String filmName = rest.getString(4);
                    int releaseDate = rest.getInt(5);
                    String genre = rest.getString(6);
                    listsearch.add(new Director(firstName, lastName, birthDate,
                            new Films(filmName, releaseDate, genre)));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listsearch;
    }

    @Override
    public List<Director> searchAfter(int year) {
        List<Director> listsearch = new ArrayList();
        String searchSQL = "'" + year + "'";
        try (Connection connection = postgreSQLJDBC.getInst().getConncetion();
             PreparedStatement prst = connection.prepareStatement(SEARCH_FILM_AFTER + searchSQL + ";")) {
            try (ResultSet rest = prst.executeQuery()) {
                while (rest.next()) {
                    String firstName = rest.getString(1);
                    String lastName = rest.getString(2);
                    Date birthDate = rest.getDate(3);
                    String filmName = rest.getString(4);
                    int releaseDate = rest.getInt(5);
                    String genre = rest.getString(6);
                    listsearch.add(new Director(firstName, lastName, birthDate,
                            new Films(filmName, releaseDate, genre)));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listsearch;
    }

    @Override
    public List<Director> searchhBetween(int yearFirst, int yearLast) {
        List<Director> listsearch = new ArrayList();
        String searchSQL = "'" + yearFirst + "'" + "AND" + "'" + yearLast + "'";
        try (Connection connection = postgreSQLJDBC.getInst().getConncetion();
             PreparedStatement prst = connection.prepareStatement(SEARCH_FILM_BETWEEN + searchSQL + ";")) {
            try (ResultSet rest = prst.executeQuery()) {
                while (rest.next()) {
                    String firstName = rest.getString(1);
                    String lastName = rest.getString(2);
                    Date birthDate = rest.getDate(3);
                    String filmName = rest.getString(4);
                    int releaseDate = rest.getInt(5);
                    String genre = rest.getString(6);
                    listsearch.add(new Director(firstName, lastName, birthDate,
                            new Films(filmName, releaseDate, genre)));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listsearch;
    }
}
