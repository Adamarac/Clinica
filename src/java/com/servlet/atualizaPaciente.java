package com.servlet;

import com.util.conexao;
import com.dao.daoPaciente;
import com.bean.beanPaciente;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.sql.Time;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AtualizaPaciente")
public class atualizaPaciente extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        request.setCharacterEncoding("UTF-8");

        int id = Integer.parseInt(request.getParameter("id"));
        String rg = request.getParameter("rg");
        String cpf = request.getParameter("cpf");
        String nome = request.getParameter("nome");
        String endereco = request.getParameter("endereco");
        String dataNascParam = request.getParameter("dataNasc");
        String telefone = request.getParameter("telefone");
        String medicoResponsavel = request.getParameter("medicoResponsavel");
        String quarto = request.getParameter("quarto");
        String andar = request.getParameter("andar");
        String horaVisParam = request.getParameter("horaVis");

        conexao connect = new conexao();
        Connection connection = null;
        try {
            connection = connect.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(atualizaPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }

        beanPaciente paciente = new beanPaciente();
        paciente.setId(id);
        paciente.setRg(rg);
        paciente.setCpf(cpf);
        paciente.setNome(nome);
        paciente.setEnd(endereco);
        paciente.setTel(telefone);
        paciente.setMedRes(Integer.parseInt(medicoResponsavel));
        paciente.setQuarto(quarto);
        paciente.setAndar(andar);

        try {
            Calendar dataNasc = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse(dataNascParam);
            dataNasc.setTime(date);
            paciente.setDataNasc(dataNasc);

            SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm");
            Date data = formatoHora.parse(horaVisParam);
            Time horaVisita = new Time(data.getTime());
            paciente.setHoraVis(horaVisita);
        } catch (ParseException e) {
            out.println(e);
        }

        daoPaciente pacienteDao = new daoPaciente(connection);

        pacienteDao.atualiza(paciente);
        response.sendRedirect("listaPaciente.jsp");
    }
}
