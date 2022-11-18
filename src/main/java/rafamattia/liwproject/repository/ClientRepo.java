package rafamattia.liwproject.repository;

import rafamattia.liwproject.factory.ConnectionFactory;
import rafamattia.liwproject.models.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ClientRepo {
    public void save(Client client) {
        String sql = "INSERT INTO usuario (firstName, lastName, phone, email) VALUES (?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{

            //criar uma conexão com o banco de dados
            conn = ConnectionFactory.createConnectionToMySQL();

            //criar uma preparedstatement, para executar uma query
            pstm = conn.prepareStatement(sql);

            //Adicionar os valores que são esperados pela query
            pstm.setString(1, client.getFirstName());
            pstm.setString(2, client.getLastName());
            pstm.setString(3, client.getPhone());
            pstm.setString(4, client.getEmail());

            //executar a query
            pstm.execute();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally{
            System.out.println("Feito!!");
            //fecha as conexões
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null){
                    conn.close();
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
