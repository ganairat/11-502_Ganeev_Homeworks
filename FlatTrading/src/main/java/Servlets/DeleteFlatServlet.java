/*
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

public class DeleteFlatServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean check = false;
        Cookie[] cookies = req.getCookies();
        TokenService tokenService = ServiceFactory.getInstance().getTokenService();
        UserService userService = ServiceFactory.getInstance().getUserService();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("current_user")) {
                if (tokenService.findIdByToken(cookie.getValue()) != -1) {
                    int userId = tokenService.findIdByToken(cookie.getValue());
                    HttpSession session = req.getSession();
                    session.setAttribute("login", userService.findUserById(userId).getLogin());
                    check = true;


                    String email = (String)session.getAttribute("login");
                    FlatService flatService = ServiceFactory.getInstance().getFlatService();
                    List<Flat> list = new LinkedList<Flat>();
                    Client client = userService.getUserByLogin(email);
                    list = flatService.getAll();
                    List<Client> clientList = new ArrayList<Client>();
                    for (int i = 0; i < list.size(); i++){
                        clientList.add(ServiceFactory.getInstance().getUserService().findUserById(list.get(i).getClientId()));
                    }

                }
            }
        }
        if(!check) {
            resp.sendRedirect("/login");
        }

    }


}
*/
