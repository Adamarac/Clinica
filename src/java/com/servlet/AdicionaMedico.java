package com.servlet;

import com.util.conexao;
import com.dao.daoMedico;
import com.bean.beanMedico;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdicionaMedico extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        request.setCharacterEncoding("UTF-8");

        String crm = request.getParameter("crm");
        String nome = request.getParameter("nome");
        String especialidade = request.getParameter("especialidade");
        String salarioParam = request.getParameter("salario");

        beanMedico medico = new beanMedico();

        medico.setCRM(crm);
        medico.setNome(nome);
        medico.setEspecialidade(especialidade);

        try {
          
            double salario = Double.parseDouble(salarioParam);
            medico.setSalario(salario);
        } catch (NumberFormatException e) {
            out.println(e);
            return;
        }

        daoMedico dao;
        conexao connect = new conexao();
        try {
            dao = new daoMedico(connect.getConnection());

            dao.adiciona(medico);

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Sucesso</title>");
            out.println("<link rel='stylesheet' type='text/css' href='CSS/SucessoAdcMedico.css'>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='container'>");
            out.println("<h1>Sucesso</h1>");
            out.println("<p>Médico adicionado com sucesso!</p>");
            out.println("<a href='index.html'><button>Voltar</button></a>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");

        } catch (SQLException ex) {
            Logger.getLogger(AdicionaMedico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
