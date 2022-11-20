package rafamattia.liwproject.repository;

import rafamattia.liwproject.factory.ConnectionFactory;

import rafamattia.liwproject.models.Employee;
import rafamattia.liwproject.models.Material;
import rafamattia.liwproject.models.enuns.MaterialType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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

    public static List<Material> getMaterialList(){
        String sql = "SELECT * FROM material";
        List<Material> materials = new ArrayList<Material>();
        Connection conn = null;
        PreparedStatement pstm = null;

        //variável que vai recuperar os dados do banco. ****SELECT****
        ResultSet rset = null;
        try {
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);

            rset = pstm.executeQuery();

            while(rset.next()){
                Material material = new Material();
                material.setId(rset.getInt("COD_MATERIAL"));
                //Recupera o ID do ESTOQUE
                material.setId_stock(rset.getInt("COD_ESTOQUE"));
                //recupera o nome
                material.setName(rset.getString("NOME_MATERIAL"));
                //recupera o Tipo do material
                material.setType(MaterialType.toEnumString(rset.getString("TIPO_MATERIAL")));
                //recupera a quantidade em estoque
                material.setAmount(rset.getInt("QTD_EM_ESTOQUE"));
                //recupera valor do material
                material.setValue(rset.getFloat("VALOR"));
                //adiciona na lista

                materials.add(material);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if(rset!=null) {
                    rset.close();
                }
                if(pstm != null) {
                    pstm.close();
                }
                if(conn != null){
                    conn.close();
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return materials;
    }
}
