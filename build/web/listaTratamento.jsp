<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, com.dao.daoTratamento, com.bean.beanTratamento, com.util.conexao" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Lista de Tratamentos</title>
    <link rel="stylesheet" type="text/css" href="./CSS/styleListar.css">
</head>
<body>

<a href="index.html"><button class="custom-button">Voltar para o início</button></a>

<table>
    <tr>
        <td>Id</td>
        <td>Id do médico</td>
        <td>Id do paciente</td>
        <td>Descrição</td>
    </tr>
    <%
        conexao connect = new conexao();
        daoTratamento dao = new daoTratamento(connect.getConnection());
        List<beanTratamento> tratamentos = dao.getLista(Integer.parseInt(request.getParameter("id")));
        for(beanTratamento tratamento: tratamentos){        
    %>
    <tr>
        <td><%= tratamento.getId() %></td>
        <td><%= tratamento.getIdMed() %></td>
        <td><%= tratamento.getIdPac() %></td>
        <td><%= tratamento.getNome_trat() %></td>
        <td>
            <form action="atualizaTratamento.jsp" method="post">
                <input type="hidden" id="Id" name="Id" value="<%= tratamento.getId() %>">
                <input type="hidden" id="IdMed" name="IdMed" value="<%= tratamento.getIdMed() %>">
                <input type="hidden" id="IdPac" name="IdPac" value="<%= tratamento.getIdPac() %>">
                <input type="hidden"  id="Nome_trat" name="Nome_trat" value="<%= tratamento.getNome_trat() %>">
                <input type="submit" class="custom-button update-button" value="Editar">
            </form>
            <a href="Excluir?tipo=tratamento&id=<%=tratamento.getId()%>&idPac=<%=tratamento.getIdPac()%>">
                <button class="custom-button delete-button">Excluir</button>
            </a>
        </td>
    </tr>
    <%}%>
    </table>
    
    <a href="AdicionarTratamento.jsp?id=<%=request.getParameter("id") %>"><button class="custom-button">Adicionar tratamento</button></a>

</body>
</html>
