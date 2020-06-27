import com.rakovets.course_java_enterprise.solution.jstl.dao.AbilityDao;
import com.rakovets.course_java_enterprise.solution.jstl.entity.Ability;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet({"read-abilities.jsp"})
public class AbilitiesServlet extends HttpServlet {

    AbilityDao abilityDao = AbilityDao.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/read-abilities.jsp").forward(req, resp);
        List<Ability> abilities = abilityDao.findAll();
        abilities.add(new Ability(1,"Jpi"));
        abilities.add(new Ability(2,"Super"));
        req.setAttribute("abilities", abilities);
    }
}
