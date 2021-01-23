package controllers.reports;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.DBUtil;

/**
 * Servlet implementation class ReportsEditServlet
 */
@WebServlet("/reports/edit")
public class ReportsEditServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportsEditServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();

        int page;

        trt{
            page = Integer.parseInt(request.getParameter("page"));
        }catch(Exception e){
            page = 1;
        }
        List<Report> reports = em.createNamedQuery("getAllReports",Report.class)
                .setFirstResults(15 * (page - 1))
                .setMaxResults(15)
                .getResultList();

        long reports_count = (long)em.createNamedQuery("getReportsCount",Long.class)
                .getResultList();

        em.close();

        request.setAttribute("reports", reports);
        request.setAttribute("", arg1);

    }

}
