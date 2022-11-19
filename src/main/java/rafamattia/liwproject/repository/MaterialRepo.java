package rafamattia.liwproject.repository;

import rafamattia.liwproject.factory.ConnectionFactory;

import rafamattia.liwproject.models.Material;
import rafamattia.liwproject.models.enuns.MaterialType;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class MaterialRepo {

    public void save(Material material) {
        String sql = "INSERT INTO material (COD_ESTOQUE, NOME_MATERIAL, TIPO_MATERIAL, DIMENSOES, QTD_EM_ESTOQUE, VALOR) VALUES (?, ?, ?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{

            //criar uma conexão com o banco de dados
            conn = ConnectionFactory.createConnectionToMySQL();

            //criar uma preparedstatement, para executar uma query
            pstm = conn.prepareStatement(sql);

            //Adicionar os valores que são esperados pela query
            pstm.setInt(1, material.getId_stock());
            pstm.setString(2, material.getName());
            pstm.setString(3, material.getType().getDescription());
            pstm.setString(4, material.getMeasurements());
            pstm.setInt(5, material.getAmount());
            pstm.setFloat(6, material.getValue());

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
