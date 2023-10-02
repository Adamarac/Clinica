<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*
                , com.dao.daoPaciente
                , com.bean.beanPaciente
                ,com.util.conexao" 
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de paciente</title>
        <link rel="stylesheet" type="text/css" href="./CSS/styleListar.css">

    </head>
    <body>
        
        <a href="index.html"><button class="custom-button">Voltar para o início</button></a>
        
        <table>
            <tr>
                <td>Id</td>
                <td>Nome</td>
                <td>Rg</td>
                <td>Cpf</td>
                <td>Endereço</td>
                <td>Telefone</td>
                <td>Quarto</td>
                <td>Andar</td>
                <td>Médico responsável</td>
                <td>Data de nascimento</td>
                <td>Hora de visita</td>
            </tr>
            <% 
                conexao connect = new conexao();
                daoPaciente dao = new daoPaciente(connect.getConnection());
                List<beanPaciente> pacientes = dao.getLista();
                for(beanPaciente paciente: pacientes){        
            %>
                    <tr>
                        <td><%= paciente.getId() %></td>
                        <td><%= paciente.getNome() %></td>
                        <td><%= paciente.getRg() %></td>
                        <td><%= paciente.getCpf() %></td>
                        <td><%= paciente.getEnd() %></td>
                        <td><%= paciente.getTel() %></td>
                        <td><%= paciente.getQuarto() %></td>
                        <td><%= paciente.getAndar() %></td>
                        <td><%= paciente.getMedRes() %></td>
                        <td><%= paciente.getDataNasc().getTime() %></td>
                        <td><%= paciente.getHoraVis() %></td>
                        <td>
                            <form action="atualizaPaciente.jsp" method="post">
                                <input type="hidden" name="id" value="<%= paciente.getId() %>">
                                <input type="hidden" name="rg" value="<%= paciente.getRg() %>">
                                <input type="hidden" name="cpf" value="<%= paciente.getCpf() %>">
                                <input type="hidden" name="nome" value="<%= paciente.getNome() %>">
                                <input type="hidden" name="endereco" value="<%= paciente.getEnd() %>">
                                <input type="hidden" name="dataNasc" value="<%= paciente.getDataNasc() %>">
                                <input type="hidden" name="telefone" value="<%= paciente.getTel() %>">
                                <input type="hidden" name="medicoResponsavel" value="<%= paciente.getMedRes()%>">
                                <input type="hidden" name="quarto" value="<%= paciente.getQuarto() %>">
                                <input type="hidden" name="andar" value="<%= paciente.getAndar() %>">
                                <input type="hidden" name="horaVis" value="<%= paciente.getHoraVis() %>">

                                <input type="submit" class="custom-button update-button" value="Editar">
                            </form>
                                <a href="listaTratamento.jsp?tipo=paciente&id=<%=paciente.getId()%>">
                                    <button class="custom-button t-button">Tratamentos</button>
                                </a><br>

                            <a href="Excluir?tipo=paciente&id=<%=paciente.getId()%>"><button class="custom-button delete-button"> Excluir </button> </a>
                            
                        </td>
                    </tr>
                <%}%>
        </table>
        
    </body>
</html>
