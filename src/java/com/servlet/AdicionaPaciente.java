package com.servlet;

import com.util.conexao;
import com.dao.daoPaciente;
import com.bean.beanPaciente;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.sql.Time;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdicionaPaciente extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        request.setCharacterEncoding("UTF-8");
        
       
        String nome = request.getParameter("nome");
        String rg = request.getParameter("rg");
        String cpf = request.getParameter("cpf");
        String end = request.getParameter("end");
        String tel = request.getParameter("tel");
        String quarto = request.getParameter("quarto");
        String andar = request.getParameter("andar");
        String dataNascParam = request.getParameter("dataNasc"); 
        String horaVisParam = request.getParameter("horaVis");
        String medRes = request.getParameter("medRes");

        beanPaciente paciente = new beanPaciente();
        
        paciente.setNome(nome);
        paciente.setRg(rg);
        paciente.setCpf(cpf);
        paciente.setEnd(end);
        paciente.setTel(tel);
        paciente.setQuarto(quarto);
        paciente.setAndar(andar);
        paciente.setMedRes(Integer.parseInt(medRes));
        
        try {
           Calendar dataNasc = Calendar.getInstance();
           SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
           Date date = sdf.parse(dataNascParam);
           dataNasc.setTime(date);
           paciente.setDataNasc(dataNasc);
           
           SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm");
           Date data = formatoHora.parse(horaVisParam);
           
           Time hora = new Time(data.getTime());
           paciente.setHoraVis(hora);
           
        } catch (ParseException e) {
            out.println(e);
        }
          
        
        daoPaciente dao;
        conexao connect = new conexao();
        try {
            dao = new daoPaciente(connect.getConnection());
            
            dao.adiciona(paciente);
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Sucesso</title>");
            out.println("<link rel='stylesheet' type='text/css' href='CSS/SucessoAdcMedico.css'>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='container'>");
            out.println("<h1>Sucesso</h1>");
            out.println("<p>Paciente adicionado com sucesso!</p>");
            out.println("<a href='index.html'><button>Voltar</button></a>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");

        } catch (SQLException ex) {
         Logger.getLogger(AdicionaPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }                
    }
}
