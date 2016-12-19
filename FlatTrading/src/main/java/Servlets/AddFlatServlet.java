package Servlets;

import Factories.ServiceFactory;
import Models.Client;
import Service.ClientService;
import Service.DistrictService;
import Service.FlatService;
import Service.RequirementService;
import Utils.Checker;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;


public class AddFlatServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("login") != null){
            req.getRequestDispatcher("/addFlat.jsp").forward(req,resp);
        }
        else
        resp.sendRedirect("/home");


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String login = (String) session.getAttribute("login");
        if (login == null) {
            resp.sendRedirect("/login");
        } else {
            FlatService flatService = ServiceFactory.getInstance().getFlatService();
            ClientService clientService = ServiceFactory.getInstance().getClientService();
            RequirementService requirementService = ServiceFactory.getInstance().getRequirementService();

            String flatSqr = req.getParameter("flatSqr");
            String flatAmtRoom = req.getParameter("flatAmtRoom");
            String flatSqrKitchen = req.getParameter("flatSqrKitchen");
            String flatFloor = req.getParameter("flatFloor");
            String flatKind = req.getParameter("flatKind");
            String flatDistrict = req.getParameter("flatDistrict");


            String reqSqrMin = req.getParameter("reqSqrMin");
            String reqSqrMax = req.getParameter("reqSqrMax");
            String reqAmtRoom = req.getParameter("reqAmtRoom");
            String reqSqrKitchenMin = req.getParameter("reqSqrKitchenMin");
            String reqSqrKitchenMax = req.getParameter("reqSqrKitchenMax");
            String reqFloor = req.getParameter("reqFloor");
            String reqKind = req.getParameter("reqKind");
            String reqDistrict = req.getParameter("reqDist");
            Boolean flag = true;
            String reqParametrs = "";

            if (flatKind.length() > 20 || flatDistrict.length() > 20 || reqKind.length() > 20 || reqDistrict.length() > 20) {
                req.setAttribute("length", "length");
                req.getRequestDispatcher("/addFlat.jsp").include(req, resp);
            } else {
                Checker checker = new Checker();
                String flatParametrs = "";
                if (checker.isDigits(flatSqr) != null) {
                    flatParametrs = checker.isDigits(flatSqr) + "Enter the correct area of the apartment.";
                    req.setAttribute("Wrongs", flatParametrs);
                    flatParametrs = "";
                    req.getRequestDispatcher("/addFlat.jsp").include(req, resp);
                }else

                if (checker.isDigits(flatAmtRoom) != null) {
                    flatParametrs = checker.isDigits(flatAmtRoom) + "Enter the correct number of rooms.";
                    req.setAttribute("Wrongs", flatParametrs);
                    flatParametrs = "";
                    req.getRequestDispatcher("/addFlat.jsp").include(req, resp);
                }else
                if (checker.isDigits(flatSqrKitchen) != null) {
                    flatParametrs = checker.isDigits(flatSqrKitchen) + "Enter the correct kitchen area.";
                    req.setAttribute("Wrongs", flatParametrs);
                    flatParametrs = "";
                    req.getRequestDispatcher("/addFlat.jsp").include(req, resp);
                }else
                    if (Integer.parseInt(flatSqrKitchen) > Integer.parseInt(flatSqr)) {
                        flatParametrs = "Enter the correct kitchen area. Kitchen area is more than flat area.";
                        req.setAttribute("Wrongs", flatParametrs);
                        flatParametrs = "";
                        req.getRequestDispatcher("/addFlat.jsp").include(req, resp);
                }else
                if (checker.isDigits(flatFloor) != null) {
                    flatParametrs = checker.isDigits(flatFloor) + "Enter the correct floor.";
                    req.setAttribute("Wrongs", flatParametrs);
                    flatParametrs = "";
                    req.getRequestDispatcher("/addFlat.jsp").include(req, resp);

                }else


                if (checker.isDigits(reqSqrMin) != null) {
                    reqParametrs = checker.isDigits(reqSqrMin) + "\n Enter the correct minimum area apartments.";
                    flag = false;
                    req.setAttribute("Wrongs", reqParametrs);
                    reqParametrs = "";
                    req.getRequestDispatcher("/addFlat.jsp").include(req, resp);
                }else

                if (checker.isDigits(reqSqrMax) != null) {
                    reqParametrs = checker.isDigits(reqSqrMax) + "\n Enter the correct maximum size of the apartmen.";
                    flag = false;
                    req.setAttribute("Wrongs", reqParametrs);
                    reqParametrs = "";
                    req.getRequestDispatcher("/addFlat.jsp").include(req, resp);
                }else

                if (flag && (Integer.parseInt(reqSqrMin) > Integer.parseInt(reqSqrMax))) {
                    reqParametrs = "The minimum area can not be more than the maximum";
                    flag = false;
                    req.setAttribute("Wrongs", reqParametrs);
                    reqParametrs = "";
                    req.getRequestDispatcher("/addFlat.jsp").include(req, resp);
                }else
                if (checker.isDigits(reqAmtRoom) != null) {
                    flag = false;
                    reqParametrs = checker.isDigits(reqAmtRoom) + "\n Enter the correct number of rooms.";
                    req.setAttribute("Wrongs", reqParametrs);
                    reqParametrs = "";
                    req.getRequestDispatcher("/addFlat.jsp").include(req, resp);
                }else
                if (checker.isDigits(reqSqrKitchenMin) != null) {
                    flag = false;
                    reqParametrs = checker.isDigits(reqSqrKitchenMax) + "\n Enter the correct minimum kitchen area.";
                    req.setAttribute("Wrongs", reqParametrs);
                    reqParametrs = "";
                    req.getRequestDispatcher("/addFlat.jsp").include(req, resp);
                }else
                if (checker.isDigits(reqSqrKitchenMax) != null) {
                    flag = false;
                    reqParametrs = checker.isDigits(reqSqrKitchenMax) + "\n Enter the correct maximum kitchen area.";
                    req.setAttribute("Wrongs", reqParametrs);
                    reqParametrs = "";
                    req.getRequestDispatcher("/addFlat.jsp").include(req, resp);
                }else
                if (flag && (Integer.parseInt(reqSqrKitchenMin) > Integer.parseInt(reqSqrKitchenMax))) {
                    flag = false;
                    reqParametrs = "Minimal kitchen area can not be more than the maximum.";
                    req.setAttribute("Wrongs", reqParametrs);
                    reqParametrs = "";
                    req.getRequestDispatcher("/addFlat.jsp").include(req, resp);
                }else
                if (checker.isDigits(reqFloor) != null) {
                    flag = false;
                    reqParametrs = checker.isDigits(reqFloor) + "\n Enter the correct floor.";
                    req.setAttribute("Wrongs", reqParametrs);
                    reqParametrs = "";
                    req.getRequestDispatcher("/addFlat.jsp").include(req, resp);
                }else
                if (checker.isLetters(flatKind) != null) {
                    flag = false;
                    flatParametrs = "\n" + checker.isLetters(flatKind) + "\n Enter the correct type of home.";
                    req.setAttribute("Wrongs", reqParametrs);
                    flatParametrs = "";
                    req.getRequestDispatcher("/addFlat.jsp").include(req, resp);
                }else
                if (checker.isLetters(flatDistrict) != null) {
                    flag = false;
                    flatParametrs = "\n" + checker.isLetters(flatDistrict) + "\n Enter the correct name of the district.";
                    req.setAttribute("Wrongs", flatParametrs);
                    flatParametrs ="";
                    req.getRequestDispatcher("/addFlat.jsp").include(req, resp);
                }else

                if (!(flatParametrs + reqParametrs != null && (flatParametrs + reqParametrs).equals(""))) {
                    req.setAttribute("flatParam", flatParametrs);
                    req.setAttribute("reqParam", reqParametrs);
                    req.getRequestDispatcher("/addFlat.jsp").include(req, resp);
                } else {

                    DistrictService districtService = ServiceFactory.getInstance().getDistrictService();
                    int flatDistId = districtService.add(flatDistrict);
                    int reqDistId = districtService.add(reqDistrict);
                    int reqId = requirementService.add(reqDistId, reqSqrMin, reqSqrMax, reqAmtRoom, reqSqrKitchenMin, reqSqrKitchenMax, reqFloor, reqKind);
                    flatService.add(flatDistId, String.valueOf(reqId), flatAmtRoom, flatSqrKitchen, flatKind, flatFloor, flatSqr);
                    int clientId = clientService.findClientByLogin(login).getId();
                    int idFlat = flatService.findIdByParameters(flatDistId, String.valueOf(reqId), flatAmtRoom, flatSqrKitchen, flatKind, flatFloor, flatSqr);
                    flatService.addToFlatClient(idFlat, clientId);

                    clientService.findClientByLogin(login).getId();
                    resp.sendRedirect("/home");
                }
            }

        }
    }

}
