package gerteor.controller;

import gerteor.model.Director;
import gerteor.service.DirectorDAOImpl;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class SearchController extends AbstractController {
    public static final String WELCOME_PAGE = "/filmsList.jsp";
    private static final long serialVersionUID = 1L;
    private DirectorDAOImpl director;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstNameOnPg = req.getParameter("name");
        String yearFirst = req.getParameter("first");
        String yearSecond = req.getParameter("second");

        director = new DirectorDAOImpl();

        if (yearFirst.equals("") && yearSecond.equals("")) {
            List<Director> directorList;
            directorList = director.search(firstNameOnPg);
            req.setAttribute("filmsList", directorList);

        } else if (yearSecond.equals("") && firstNameOnPg.equals("")) {
            int year = Integer.parseInt(yearFirst);
            List<Director> directorList;
            directorList = director.searchBefore(year);
            req.setAttribute("filmsList", directorList);

        } else if (yearFirst.equals("") && firstNameOnPg.equals("")) {
            int year = Integer.parseInt(yearSecond);
            List<Director> directorList;
            directorList = director.searchAfter(year);
            req.setAttribute("filmsList", directorList);

        } else if (firstNameOnPg.equals("")) {
            int firstYear = Integer.parseInt(yearFirst);
            int secondYear = Integer.parseInt(yearSecond);
            List<Director> directorList;
            directorList = director.searchhBetween(firstYear,secondYear);
            req.setAttribute("filmsList", directorList);
        }
        try {
            forward(WELCOME_PAGE, req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
