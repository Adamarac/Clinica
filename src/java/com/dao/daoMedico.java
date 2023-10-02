package com.dao;

import com.bean.beanMedico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class daoMedico {

    private final Connection connection;

    public daoMedico(Connection connection) {
        this.connection = connection;
    }

    public void adiciona(beanMedico medico) {
        try {
            String sql = "INSERT INTO medico (CRM, nome, especialidade, salario) VALUES (?, ?, ?, ?)";
            PreparedStatement query = connection.prepareStatement(sql);

            query.setString(1, medico.getCRM());
            query.setString(2, medico.getNome());
            query.setString(3, medico.getEspecialidade());
            query.setDouble(4, medico.getSalario());

            query.execute();
            query.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<beanMedico> getLista() {
        try {
            List<beanMedico> medicos = new ArrayList<>();
            try (PreparedStatement stmt = connection.prepareStatement("SELECT * FROM medico");
                    ResultSet resultSet = stmt.executeQuery()) {

                while (resultSet.next()) {
                    beanMedico medico = new beanMedico();

                    medico.setId(resultSet.getInt("id"));
                    medico.setCRM(resultSet.getString("CRM"));
                    medico.setNome(resultSet.getString("nome"));
                    medico.setEspecialidade(resultSet.getString("especialidade"));
                    medico.setSalario(resultSet.getDouble("salario"));

                    medicos.add(medico);
                }

            }

            return medicos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void excluir(int medico) {
        String sql = "DELETE FROM medico WHERE id=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, medico);
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void atualiza(beanMedico medico) {
        String sql = "UPDATE medico SET CRM = ?, nome = ?, especialidade = ?, salario = ? WHERE id = ?";

        try {
            PreparedStatement query = connection.prepareStatement(sql);
            query.setString(1, medico.getCRM());
            query.setString(2, medico.getNome());
            query.setString(3, medico.getEspecialidade());
            query.setDouble(4, medico.getSalario());
            query.setInt(5, medico.getId());

            query.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
