
package com.emergentes.controlador;

import com.emergentes.dao.SeminariosDAOimpl;
import com.emergentes.modelo.Seminario;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.emergentes.dao.SeminariosDAO;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "SeminarioController", urlPatterns = {"/SeminarioController"})
public class SeminarioController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           try {
            Seminario semi = new Seminario();
            int id;
            SeminariosDAO dao = new SeminariosDAOimpl();
            String action = (request.getParameter("action") != null ? request.getParameter("action") : "view");

            switch (action) {
                case "add":
                    request.setAttribute("seminario", semi);
                    request.getRequestDispatcher("frmseminario.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    semi = dao.getById(id);
                    request.setAttribute("seminario", semi);
                    request.getRequestDispatcher("frmseminario.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("SeminarioController");
                    break;
                case "view":
                    //obtener la lista de registros
                    List<Seminario> lista = dao.getAll();
                    request.setAttribute("seminarios", lista);
                    request.getRequestDispatcher("seminarios.jsp").forward(request, response);
                    break;
            }

        } catch (Exception ex) {
            System.out.println("error" + ex.getMessage());
        }
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        String titulo = request.getParameter("titulo");
        String fecha = request.getParameter("fecha");
        int cupo = Integer.parseInt(request.getParameter("cupo"));

        Seminario semi = new Seminario();

        semi.setId(id);
        semi.setTitulo(titulo);
        semi.setFecha(convierteFecha(fecha));
        semi.setCupos(cupo);

        SeminariosDAO dao = new SeminariosDAOimpl();
        if (id == 0) {
            try {
                //nuevo
                dao.insert(semi);
            } catch (Exception ex) {
                System.out.println("error al insertar" + ex.getMessage());
            }
        } else {
            try {
                //modificar
                dao.update(semi);
            } catch (Exception ex) {
                System.out.println("error al modificar" + ex.getMessage());
            }
        }
        response.sendRedirect("SeminarioController");
    }
    
    public Date convierteFecha(String fecha) {

        Date fechaBD = null;
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

        java.util.Date fechatemp;
        try {
            fechatemp = formato.parse(fecha);
            fechaBD = new Date(fechatemp.getTime());
        } catch (ParseException ex) {
            Logger.getLogger(VentaController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return fechaBD;
    }
}
