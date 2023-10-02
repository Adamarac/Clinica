package com.dao;

import com.bean.beanPaciente;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Time;
import java.util.List;

public class daoPaciente {
    
    private final Connection connection;

	public daoPaciente(Connection connection) {
            this.connection = connection;
	}

	public void adiciona(beanPaciente paciente) {
		try {
			String sql = "insert into paciente (medRes,nome,rg,cpf,end,tel,quarto,andar,dataNasc,horaVis) values (?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement query = connection.prepareStatement(sql);

			query.setInt(1, paciente.getMedRes());
                        query.setString(2,paciente.getNome());
                        query.setString(3,paciente.getRg());
                        query.setString(4,paciente.getCpf());
                        query.setString(5,paciente.getEnd());
                        query.setString(6,paciente.getQuarto());
                        query.setString(7,paciente.getTel());
			query.setString(8,paciente.getAndar());
                        query.setDate(9, new Date(paciente.getDataNasc().getTimeInMillis()));
                        query.setTime(10,paciente.getHoraVis());
                        

			query.execute();
			query.close();
                        
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<beanPaciente> getLista() {
		try {
			List<beanPaciente> pacientes = new ArrayList<>();
                    try (PreparedStatement stmt = this.connection.prepareStatement("select * from paciente"); 
                            
                        ResultSet resultSet = stmt.executeQuery()) {
                        
                        while(resultSet.next()) {
                            beanPaciente paciente = new beanPaciente();
                            
                             paciente.setId(resultSet.getInt("id"));
                             paciente.setMedRes(resultSet.getInt("medRes"));
                             paciente.setNome(resultSet.getString("nome"));
                             paciente.setRg(resultSet.getString("rg"));
                             paciente.setCpf(resultSet.getString("cpf"));
                             paciente.setEnd(resultSet.getString("end"));
                             paciente.setTel(resultSet.getString("tel"));
                             paciente.setQuarto(resultSet.getString("quarto"));
                             paciente.setAndar(resultSet.getString("andar"));
                            
                            Date dataNascSql = resultSet.getDate("dataNasc");
                                if (dataNascSql != null) {
                                    Calendar dataNascCalendar = java.util.Calendar.getInstance();
                                    dataNascCalendar.setTimeInMillis(dataNascSql.getTime());
                                    paciente.setDataNasc(dataNascCalendar);
                                } else {
                                    paciente.setDataNasc(null);
                                }
        
        
                            Time horaVisSql = resultSet.getTime("horaVis");
                                if (horaVisSql != null) {
                                      paciente.setHoraVis(horaVisSql);
                                } else {
                                      paciente.setHoraVis(null);
                                }       
                             
                             
                             
                            pacientes.add(paciente);
                        }
                        
                    }

                    return pacientes;
		} catch (SQLException e) {
			throw new RuntimeException(e);
                        
		}
	}

	public void excluir(int paciente) {
		String sql = "delete from paciente where id=?";
		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setLong(1, paciente);
			stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void atualiza(beanPaciente paciente) {
		String sql = "UPDATE paciente SET medRes = ?, nome = ?, rg = ?, cpf = ?, end = ?, tel = ?, quarto = ?, andar = ?, dataNasc = ?, horaVis = ? WHERE id = ?";

		try {
			PreparedStatement query = this.connection.prepareStatement(sql);
			query.setInt(1, paciente.getMedRes());
                        query.setString(2,paciente.getNome());
                        query.setString(3,paciente.getRg());
                        query.setString(4,paciente.getCpf());
                        query.setString(5,paciente.getEnd());
                        query.setString(6,paciente.getTel());
                        query.setString(7,paciente.getQuarto());
                        query.setString(8,paciente.getAndar());
                        query.setDate(9, new Date(paciente.getDataNasc().getTimeInMillis()));
                        query.setTime(10,paciente.getHoraVis());
                        query.setInt(11,paciente.getId());

			query.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
    

