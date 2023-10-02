<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Editar Paciente</title>
    <link rel="stylesheet" type="text/css" href="CSS/AdicionarPaciente.css">
</head>
<body>
    <div class="container">
        <h1>Editar Paciente</h1>
        <form action="AtualizaPaciente" method="post">
            <input type="hidden" name="id" value="<%= request.getParameter("id") %>">
            <label for="rg">RG (Chave Primária)</label>
            <input type="text" id="rg" name="rg" value="<%= request.getParameter("rg") %>" required>

            <label for="cpf">CPF</label>
            <input type="text" id="cpf" name="cpf" value="<%= request.getParameter("cpf") %>" required>

            <label for="nome">Nome</label>
            <input type="text" id="nome" name="nome" value="<%= request.getParameter("nome") %>" required>

            <label for="endereco">Endereço</label>
            <input type="text" id="endereco" name="endereco" value="<%= request.getParameter("endereco") %>" required>

            <label for="dataNasc">Data de Nascimento</label>
            <input type="text" id="dataNasc" name="dataNasc" value="<%= request.getParameter("dataNasc") %>" required>

            <label for="telefone">Telefone</label>
            <input type="tel" id="telefone" name="telefone" value="<%= request.getParameter("telefone") %>" required>

            <label for="medicoResponsavel">Médico Responsável</label>
            <input type="text" id="medicoResponsavel" name="medicoResponsavel" value="<%= request.getParameter("medicoResponsavel") %>" required>

            <label for="quarto">Número do Quarto</label>
            <input type="text" id="quarto" name="quarto" value="<%= request.getParameter("quarto") %>" required>

            <label for="andar">Andar do Quarto</label>
            <input type="text" id="andar" name="andar" value="<%= request.getParameter("andar") %>" required>
            
            <label for="horaVis">Hora de visita</label>
            <input type="text" id="horaVis" name="horaVis" value="<%= request.getParameter("horaVis") %>" required>

            <button type="submit">Atualizar</button>
            <a href="listaPaciente.jsp"><button type="button" class="back"">Voltar</button></a>
        </form>
    </div>
</body>
</html>
