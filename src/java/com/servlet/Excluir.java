package com.servlet;

import com.util.conexao;
import com.dao.daoMedico;
import com.dao.daoPaciente;
import com.dao.daoTratamento;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ExcluirRegistro")
public class Excluir extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String tipo = request.getParameter("tipo");
        String idParam = request.getParameter("id");

        if (tipo != null && idParam != null) {
            int id = Integer.parseInt(idParam);
            conexao connect = new conexao();
            Connection connection = null;
            try {
                connection = connect.getConnection();
            } catch (SQLException ex) {
                Logger.getLogger(Excluir.class.getName()).log(Level.SEVERE, null, ex);
            }

            if ("medico".equals(tipo)) {
                daoMedico medicoDao = new daoMedico(connection);
                medicoDao.excluir(id);
            } else if ("paciente".equals(tipo)) {
                daoPaciente pacienteDao = new daoPaciente(connection);
                pacienteDao.excluir(id);
            } else if ("tratamento".equals(tipo)) {
                daoTratamento tratamentoDao = new daoTratamento(connection);
                tratamentoDao.excluir(id);
            }
            
            if ("medico".equals(tipo)) {
                response.sendRedirect("listaMedico.jsp");
            } else if ("paciente".equals(tipo)) {
                response.sendRedirect("listaPaciente.jsp");
            } else if ("tratamento".equals(tipo)) {
                String idPac = request.getParameter("idPac");
                response.sendRedirect("listaTratamento.jsp?id=" + idPac);
            }
            
        } else {
            response.sendRedirect("erro.jsp");
        }
    }
}
