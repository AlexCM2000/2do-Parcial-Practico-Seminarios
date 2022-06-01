package com.emergentes.controlador;

import com.emergentes.dao.ParticipantesDAOimpl;
import com.emergentes.dao.SeminariosDAOimpl;
import com.emergentes.dao.VentaDAO;
import com.emergentes.dao.VentaDAOimpl;
import com.emergentes.modelo.Participante;
import com.emergentes.modelo.Seminario;
import com.emergentes.modelo.Seminario;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.emergentes.dao.ParticipantesDAO;
import com.emergentes.dao.SeminariosDAO;

@WebServlet(name = "VentaController", urlPatterns = {"/VentaController"})
public class VentaController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("iniciando ventas...");
        try {
            VentaDAO dao = new VentaDAOimpl();
            SeminariosDAO daoP = new SeminariosDAOimpl();
            ParticipantesDAO daoC = new ParticipantesDAOimpl();
            int id;
            List<Seminario> listaP = null;
            List<Participante> listaC = null;

            Seminario ve = new Seminario();

            String action = (request.getParameter("action") != null ? request.getParameter("action") : "view");

            switch (action) {
                case "add":
                    listaP = daoP.getAll();
                    listaC = daoC.getAll();
                    request.setAttribute("lista_productos", listaP);
                    request.setAttribute("lista_clientes", listaC);
                    request.setAttribute("venta", ve);
                    request.getRequestDispatcher("frmventa.jsp").forward(request, response);
                    break;
                case "edit":

                    id = Integer.parseInt(request.getParameter("id"));
                    ve = dao.getById(id);
                    request.setAttribute("venta", ve);
                    request.getRequestDispatcher("frmventa.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("VentaController");
                    break;
                case "view":
                    //obtener la lista de registros
                    List<Seminario> lista = dao.getAll();
                    request.setAttribute("ventas", lista);
                    request.getRequestDispatcher("ventas.jsp").forward(request, response);
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
        int cliente_id = Integer.parseInt(request.getParameter("cliente_id"));
        int producto_id = Integer.parseInt(request.getParameter("producto_id"));
        String fecha = request.getParameter("fecha");

        Seminario ve = new Seminario();

        ve.setId(id);
        ve.setCupos(cliente_id);
        //ve.setProducto_id(producto_id);
        ve.setFecha(convierteFecha(fecha));

        if(id==0){
            VentaDAO dao = new VentaDAOimpl();
            try {
                dao.insert(ve);
                 response.sendRedirect("VentaController");
            } catch (Exception ex) {
                Logger.getLogger(VentaController.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }else{
               VentaDAO dao = new VentaDAOimpl();
            try {
                dao.update(ve);
                 response.sendRedirect("VentaController");
            } catch (Exception ex) {
                Logger.getLogger(VentaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
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
