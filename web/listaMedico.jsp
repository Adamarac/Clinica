<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, com.dao.daoMedico, com.bean.beanMedico, com.util.conexao" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Lista de Médicos</title>
    <link rel="stylesheet" type="text/css" href="./CSS/styleListar.css">
</head>
<body>

<a href="index.html"><button class="custom-button">Voltar para o início</button></a>

<table>
    <tr>
        <td>Id</td>
        <td>CRM</td>
        <td>Nome</td>
        <td>Especialidade</td>
        <td>Salario</td>
    </tr>
    <%
        conexao connect = new conexao();
        daoMedico dao = new daoMedico(connect.getConnection());
        List<beanMedico> medicos = dao.getLista();
        for(beanMedico medico: medicos){        
    %>
    <tr>
        <td><%= medico.getId() %></td>
        <td><%= medico.getCRM() %></td>
        <td><%= medico.getNome() %></td>
        <td><%= medico.getEspecialidade() %></td>
        <td><%= medico.getSalario() %></td>
        <td>
            
            <form action="atualizaMedico.jsp" method="post">
            <input type="hidden" name="id" value="<%= medico.getId() %>">
            <input type="hidden" name="crm" value="<%= medico.getCRM() %>">
            <input type="hidden" name="nome" value="<%= medico.getNome() %>">
            <input type="hidden" name="especialidade" value="<%= medico.getEspecialidade() %>">
            <input type="hidden" name="salario" value="<%= medico.getSalario() %>">
            <input type="submit" class="custom-button update-button" value="Editar">
            </form>
            <a href="Excluir?tipo=medico&id=<%=medico.getId()%>"> <button class="custom-button delete-button">Excluir</button> </a>
        </td>
    </tr>
    <%}%>
</table>

</body>
</html>
