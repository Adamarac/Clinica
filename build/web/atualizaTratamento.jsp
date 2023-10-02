<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Formulário de Tratamento</title>
    <link rel="stylesheet" type="text/css" href="./CSS/AdicionarTratamento.css">
</head>
<body>
    <div class="container">
        <h1>Formulário de Tratamento</h1>
        <form action="atualizaTratamento" method="post">
            <label for="idPac">ID do Paciente</label>
            <input type="text" id="idPac" name="idPac" value="<%= request.getParameter("IdPac") %>" readonly>

            <label for="idMed">ID do Médico</label>
            <input type="text" id="idMed" name="idMed" value="<%= request.getParameter("IdMed") %>" required>

            <label for="nome_trat">Nome do Tratamento</label>
            <input type="text" id="nome_trat" name="nome_trat" value="<%= request.getParameter("Nome_trat") %>" required>

            <button type="submit">Enviar</button>
            <button type="button" class="back" onclick="window.history.back()">Voltar</button>
        </form>
    </div>
</body>
</html>
