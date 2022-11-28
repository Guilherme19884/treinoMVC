/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
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
