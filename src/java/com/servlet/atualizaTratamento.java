package com.servlet;

import com.util.conexao;
import com.bean.beanTratamento;
import com.dao.daoTratamento;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AtualizaTratamento")
public class atualizaTratamento extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        request.setCharacterEncoding("UTF-8");

        int id = Integer.parseInt(request.getParameter("id"));
        int idMedico = Integer.parseInt(request.getParameter("idMed"));
        int idPaciente = Integer.parseInt(request.getParameter("idPac"));
        String obs = request.getParameter("nome_trat");

        conexao connect = new conexao();
        Connection connection = null;
        try {
            connection = connect.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(atualizaMedico.class.getName()).log(Level.SEVERE, null, ex);
        }

        beanTratamento trat = new beanTratamento();
        trat.setId(id);
        trat.setIdMed(idMedico);
        trat.setIdPac(idPaciente);
        trat.setNome_trat(obs);

        daoTratamento dao= new daoTratamento(connection);

        dao.atualiza(trat);
        response.sendRedirect("listaTratamento.jsp?id=" + idPaciente);
    }
}
