<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Editar Médico</title>
    <link rel="stylesheet" type="text/css" href="CSS/AdicionarMedico.css">
</head>
<body>
    <div class="container">
        <h1>Editar Médico</h1>
        <form action="atualizaMedico" method="post">
            <input type="hidden" name="id" value="<%= request.getParameter("id") %>">
            <label for="crm">CRM</label>
            <input type="text" id="crm" name="crm" value="<%= request.getParameter("crm") %>" required>

            <label for="nome">Nome</label>
            <input type="text" id="nome" name="nome" value="<%= request.getParameter("nome") %>" required>

            <label for="especialidade">Especialidade</label>
            <input type="text" id="especialidade" name="especialidade" value="<%= request.getParameter("especialidade") %>" required>

            <label for="salario">Salário</label>
            <input type="text" id="salario" name="salario" value="<%= request.getParameter("salario") %>" required>

            <button type="submit">Atualizar</button>
            <a href="listaMedico.jsp"><button type="button" class="back"">Voltar</button></a>
        </form>
    </div>
</body>
</html>
