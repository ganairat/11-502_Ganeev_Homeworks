package Servlets;


import Factories.ServiceFactory;
import Service.ClientService;
import Utils.Checker;
import Utils.Hash;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/signUp.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        ClientService clientService = ServiceFactory.getInstance().getClientService();
        String firstName = req.getParameter("firstName");
        String middleName = req.getParameter("middleName");
        String lastName = req.getParameter("lastName");
        String phone = req.getParameter("phone");
        String login =  req.getParameter("login");
        String password = req.getParameter("password");
        Checker  checker = new Checker();
        Hash hash = new Hash();
        Boolean flag = true;



        if (!firstName.equals("") && !middleName.equals("") && !lastName.equals("") && !phone.equals("") && !login.equals("") && !password.equals("")) {
            if((checker.isPhone(phone) != null)){
                req.setAttribute("phoneWrong", checker.isPhone(phone));
                req.getRequestDispatcher("signUp.jsp").include(req,resp);
                flag = false;
            }

            if ((checker.isLetters(firstName)!= null)){
                req.setAttribute("FIOWrong", "Your Name is wrong.");
                req.getRequestDispatcher("signUp.jsp").include(req,resp);
                flag = false;
            }


            if((checker.isLetters(middleName) != null)){
                req.setAttribute("FIOWrong", "Your Name is wrong.");
                req.getRequestDispatcher("signUp.jsp").include(req,resp);
                flag = false;
            }

            if((checker.isLetters(lastName) != null)){
                flag = false;
                req.setAttribute("FIOWrong", "Your Name is wrong.");
                req.getRequestDispatcher("signUp.jsp").include(req,resp);
            }

            if((checker.isLogin(login) != null)){
                flag = false;
                String logWrong = checker.isLogin(login);
                req.setAttribute("logWrong", logWrong);
                req.getRequestDispatcher("signUp.jsp").include(req,resp);
            }

            if((checker.isPassword(password) != null)) {
                flag = false;
                String pasWrong = checker.isPassword(password);
                req.setAttribute("pasWrong", pasWrong);
                req.getRequestDispatcher("signUp.jsp").include(req,resp);
            }
            if (clientService.findClientByLogin(login) != null || !flag) {
                String busyEmailError = "This e-mail address is already in use";
                req.setAttribute("busyEmailError", busyEmailError);
                req.getRequestDispatcher("signUp.jsp").include(req, resp);
            } else {
                clientService.add(phone, login, hash.getMd5Apache(password), firstName, middleName, lastName);
                resp.sendRedirect("/login");
            }



        }else {
            String notFullParam = "Complete all fields fully";
            req.setAttribute("notFullParam", notFullParam);
            req.getRequestDispatcher("signUp.jsp").include(req,resp);

        }
    }
}

