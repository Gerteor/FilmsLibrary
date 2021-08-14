package gerteor.service;

import gerteor.model.Director;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface DirectorDAO {

    void add(String first_name, String last_name, Date birth_date) ;

    List<Director> getAllDirectors() throws SQLException;

    List<Director> search(String name) throws SQLException;

    List<Director> searchBefore(int year);

    List<Director> searchAfter(int year);

    List<Director> searchhBetween(int yearFirst , int yearLast);


}
