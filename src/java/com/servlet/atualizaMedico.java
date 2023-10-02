package com.servlet;

import com.util.conexao;
import com.dao.daoMedico;
import com.bean.beanMedico;

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

@WebServlet("/AtualizaMedico")
public class atualizaMedico extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        request.setCharacterEncoding("UTF-8");

        int id = Integer.parseInt(request.getParameter("id"));
        String crm = request.getParameter("crm");
        String nome = request.getParameter("nome");
        String especialidade = request.getParameter("especialidade");
        double salario = Double.parseDouble(request.getParameter("salario"));

        conexao connect = new conexao();
        Connection connection = null;
        try {
            connection = connect.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(atualizaMedico.class.getName()).log(Level.SEVERE, null, ex);
        }

        beanMedico medico = new beanMedico();
        medico.setId(id);
        medico.setCRM(crm);
        medico.setNome(nome);
        medico.setEspecialidade(especialidade);
        medico.setSalario(salario);

        daoMedico medicoDao = new daoMedico(connection);

        medicoDao.atualiza(medico);
        response.sendRedirect("listaMedico.jsp");
    }
}
