package Servlets;


import Factories.ServiceFactory;
import Models.Client;
import Models.Flat;
import Service.*;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HomeServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession session = req.getSession();
        if(session.getAttribute("login") != null){
            String login = (String)session.getAttribute("login");

            //ClientService clientService = ServiceFactory.getInstance().getClientService();

            FlatService flatService = ServiceFactory.getInstance().getFlatService();
            List<Flat> list;

            //Client client = clientService.findClientByLogin(login);

            list = flatService.getAll();
            //List<Client> clientList = new ArrayList<Client>();

            //session.setAttribute("client", client);

            req.setAttribute("flatList",list);
            //req.setAttribute("client", client);

            //req.setAttribute("clientList", clientList);
            req.getRequestDispatcher("/homePage.jsp").forward(req,resp);

        }
        else
            resp.sendRedirect("/login.jsp");
    }
}