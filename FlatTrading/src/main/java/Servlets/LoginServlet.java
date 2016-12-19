package Servlets;


import Factories.ServiceFactory;
import Service.ClientService;
import Utils.Hash;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("login") != null){
            resp.sendRedirect("/home");
        }
        else
            req.getRequestDispatcher("/login.jsp").forward(req, resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Hash hash = new Hash();
        ClientService clientService = ServiceFactory.getInstance().getClientService();
        String ps = req.getParameter("password");
        String password = hash.getMd5Apache(req.getParameter("password"));
        String login = req.getParameter("login");
        if (clientService.checkLoginWithPassword(login, password)) {
            HttpSession session = req.getSession();
            session.setAttribute("login", login);
            session.setAttribute("password", password);
            resp.sendRedirect("/home");
        }
        else  {
            String invalidPsOrEmail="invalid email or password";
            req.setAttribute("checkLoginWithPassword", invalidPsOrEmail);
            req.getRequestDispatcher("/login.jsp").include(req,resp);
        }

    }

}

