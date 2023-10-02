package com.dao;

import com.bean.beanTratamento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

public class daoTratamento {

    private final Connection connection;

    public daoTratamento(Connection connection) {
        this.connection = connection;
    }

    public void adiciona(beanTratamento tratamento) {
        try {
            String sql = "INSERT INTO tratamentos (id_medico, id_paciente, nome_tratamento) VALUES (?, ?, ?)";
            PreparedStatement query = connection.prepareStatement(sql);

            query.setInt(1, tratamento.getIdMed());
            query.setInt(2, tratamento.getIdPac());
            query.setString(3, tratamento.getNome_trat());

            query.execute();
            query.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<beanTratamento> getLista(int id_pac) throws SQLException {
        try {
            List<beanTratamento> tratamentos = new ArrayList<>();
            
            String sql = "SELECT * FROM tratamentos where id_paciente=?";
            PreparedStatement query = connection.prepareStatement(sql);
            query.setInt(1,id_pac);

                    
                ResultSet resultSet = query.executeQuery();
                    
                while(resultSet.next()) {
                    beanTratamento tratamento = new beanTratamento();

                    tratamento.setId(resultSet.getInt("id"));
                    tratamento.setIdMed(resultSet.getInt("id_medico"));
                    tratamento.setIdPac(resultSet.getInt("id_paciente"));
                    tratamento.setNome_trat(resultSet.getString("nome_tratamento"));

                    tratamentos.add(tratamento);
                }
                
            return tratamentos;   
            
                       
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void excluir(int id) {
        String sql = "DELETE FROM tratamentos WHERE id=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);

            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void atualiza(beanTratamento tratamento) {
        String sql = "UPDATE tratamentos SET nome_tratamento = ? WHERE id = ?";

        try {
            PreparedStatement query = connection.prepareStatement(sql);
            query.setString(1, tratamento.getNome_trat());
            query.setInt(2,tratamento.getId());

            query.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
