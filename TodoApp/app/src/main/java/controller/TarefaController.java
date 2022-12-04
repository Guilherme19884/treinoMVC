/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import model.Tarefa;
import util.ConnectionFactory;

/**
 *
 * @author guilh
 */
public class TarefaController {

    public void salvar(Tarefa tarefa) {
        String sql = "INSERT INTO tarefas (idProject, nome, descricao, finalizado"
                + "obeservacoes, prazo, dataCriacao, dataAtualizacao) VALUES(?,?,?,?,?,?,?,?)";
        
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, tarefa.getIdProject());
            statement.setString(2, tarefa.getNome());
            statement.setString(3, tarefa.getDescricao());
            statement.setBoolean(4,tarefa.isFinalizado());
            statement.setString(5, tarefa.getObservacoes());
            statement.setDate(6, new Date(tarefa.getDataCriacao().getTime()));
            statement.setDate(7, new Date(tarefa.getDataCriacao().getTime()));
            statement.setDate(8, new Date(tarefa.getDataAtualizacao().getTime()));
            statement.execute();
            
        } catch (Exception ex) { 
            throw new RuntimeException("Erro ao salvar a tarefa "
            + ex.getMessage(), ex);
        }finally{
            ConnectionFactory.closeConnection(connection);
        }
    }

    public void atualizar(Tarefa tarefa) {

    }

    public void remmoverById(int tarefaID) throws SQLException {
        String sql = "DELETE FROM tarefa WHERE id = ?";

        Connection conn = null;
        PreparedStatement statement = null;

        try {

            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);// ele é um objeto que ajuda a preparar o comando sql que vai ser executado no banco
            statement.setInt(1, tarefaID);
            statement.execute();

        } catch (SQLException e) {
            throw new SQLException("Erro ao deletar a tarefa");
        }finally{
            ConnectionFactory.closeConnection(conn);
        }
    }

    public List<Tarefa> listar(int idProject) {
        return null;
    }
}
