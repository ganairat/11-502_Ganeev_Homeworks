package Servlets;

import Factories.ServiceFactory;
import Models.Client;
import Models.District;
import Models.Flat;
import Models.Requirement;
import Service.ClientService;
import Service.DistrictService;
import Service.FlatService;
import Service.RequirementService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class FlatServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession session = req.getSession();
        if(session.getAttribute("login") != null){
            FlatService flatService = ServiceFactory.getInstance().getFlatService();
            int flatId = Integer.parseInt(req.getParameter("id"));
            String login = (String) req.getSession().getAttribute("login");
            String wrong;
            ClientService clientService = ServiceFactory.getInstance().getClientService();
            Client client = clientService.findClientByLogin(login);
            Flat flat = flatService.findById(flatId);
            if(flat == null) {
                wrong = "There aren't this flat.";
                req.setAttribute("wrongs", wrong);
                resp.sendRedirect("/home");
            }else{
                DistrictService districtService = ServiceFactory.getInstance().getDistrictService();
                String district = districtService.findById(flat.getDistrictId());
                RequirementService requirementService = ServiceFactory.getInstance().getRequirementService();
                Requirement requirement = requirementService.findById(flat.getReqId());
                String reqDist = districtService.findById(requirement.getIdDistrict());
                req.setAttribute("districtReq", reqDist);
                req.setAttribute("req", requirement);
                req.setAttribute("district", district);
                req.setAttribute("flatInfo", flat);
                req.setAttribute("clientInfo", client);
                req.getRequestDispatcher("/flat.jsp").include(req, resp);
            }
        }
        else
            resp.sendRedirect("/login");

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {

        HttpSession session = req.getSession();
        if(session.getAttribute("login")!= null){
            FlatService flatService = ServiceFactory.getInstance().getFlatService();

        }
    }
}
