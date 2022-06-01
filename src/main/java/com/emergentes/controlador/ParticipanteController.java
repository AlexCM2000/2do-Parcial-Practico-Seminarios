package com.emergentes.controlador;

import com.emergentes.dao.ParticipantesDAOimpl;
import com.emergentes.modelo.Participante;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.emergentes.dao.ParticipantesDAO;

@WebServlet(name = "ParticipanteController", urlPatterns = {"/ParticipanteController"})
public class ParticipanteController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Participante parti = new Participante();
            int id;
            ParticipantesDAO dao = new ParticipantesDAOimpl();
            String action = (request.getParameter("action") != null ? request.getParameter("action") : "view");

            switch (action) {
                case "add":
                    request.setAttribute("participante", parti);
                    request.getRequestDispatcher("frmparticipante.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    parti = dao.getById(id);
                    request.setAttribute("participante", parti);
                    request.getRequestDispatcher("frmparticipante.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("ParticipanteController");
                    break;
                case "view":
                    //obtener la lista de registros
                    List<Participante> lista = dao.getAll();
                    request.setAttribute("participan", lista);
                    request.getRequestDispatcher("participantes.jsp").forward(request, response);
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
        String apellido = request.getParameter("apellido");
        String nombre = request.getParameter("nombre");
        int id_semi = Integer.parseInt(request.getParameter("id_seminario"));
        int confirmado = Integer.parseInt(request.getParameter("confirmado"));

        Participante parti = new Participante();

        parti.setId(id);
        parti.setApellidos(apellido);
        parti.setNombres(nombre);
        parti.setSeminario_id(id_semi);
        parti.setConfirmado(confirmado);

        ParticipantesDAO dao = new ParticipantesDAOimpl();
        if (id == 0) {
            try {
                //nuevo
                dao.insert(parti);
            } catch (Exception ex) {
                System.out.println("error al insertar" + ex.getMessage());
            }
        } else {
            try {
                //modificar
                dao.update(parti);
            } catch (Exception ex) {
                System.out.println("error al modificar" + ex.getMessage());
            }
        }
        response.sendRedirect("ParticipanteController");

    }
}
