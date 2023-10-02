package com.servlet;

import com.util.conexao;
import com.dao.daoTratamento;
import com.bean.beanTratamento;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdicionaTratamento extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        request.setCharacterEncoding("UTF-8");

        String idMedicoParam = request.getParameter("idMed");
        String idPacienteParam = request.getParameter("idPac");
        String nomeTratamento = request.getParameter("nome_trat");

        int idMedico;
        int idPaciente;

        try {
            idMedico = Integer.parseInt(idMedicoParam);
            idPaciente = Integer.parseInt(idPacienteParam);
        } catch (NumberFormatException e) {
            out.println(e);
            return;
        }

        beanTratamento tratamento = new beanTratamento();
        tratamento.setIdMed(idMedico);
        tratamento.setIdPac(idPaciente);
        tratamento.setNome_trat(nomeTratamento);

        daoTratamento dao;
        conexao connect = new conexao();
        try {
            dao = new daoTratamento(connect.getConnection());

            dao.adiciona(tratamento);

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Sucesso</title>");
            out.println("<link rel='stylesheet' type='text/css' href='CSS/SucessoAdcMedico.css'>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='container'>");
            out.println("<h1>Sucesso</h1>");
            out.println("<p>Tratamento adicionado com sucesso!</p>");
            out.println("<a href='listaTratamento.jsp?id=" + idPacienteParam + "'><button>Voltar</button></a>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");

        } catch (SQLException ex) {
            Logger.getLogger(AdicionaTratamento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
