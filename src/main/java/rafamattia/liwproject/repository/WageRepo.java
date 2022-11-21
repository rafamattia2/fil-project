package rafamattia.liwproject.repository;

import rafamattia.liwproject.factory.ConnectionFactory;
import rafamattia.liwproject.models.Employee;
import rafamattia.liwproject.models.Material;
import rafamattia.liwproject.models.Wage;
import rafamattia.liwproject.models.enuns.MaterialType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class WageRepo {
    public void save(Wage wage) {
        String sql = "INSERT INTO salario (COD_SALARIO, COD_FUNCIONARIO, VALOR_SALARIO) VALUES (?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            //criar uma conexão com o banco de dados
            conn = ConnectionFactory.createConnectionToMySQL();

            //criar uma preparedstatement, para executar uma query
            pstm = conn.prepareStatement(sql);

            //Adicionar os valores que são esperados pela query
            pstm.setInt(1, wage.getId());
            pstm.setInt(2, wage.getIdEmployee());
            pstm.setFloat(3, wage.getValue());

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
    public static List<Wage> getWageList(){
        String sql = "SELECT * FROM salario";
        List<Wage> wages = new ArrayList<Wage>();
        Connection conn = null;
        PreparedStatement pstm = null;

        //variável que vai recuperar os dados do banco. ****SELECT****
        ResultSet rset = null;
        try {
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);

            rset = pstm.executeQuery();

            while(rset.next()){
                Wage wage = new Wage();
                //Recupera o ID do SALARIO
                wage.setId(rset.getInt("COD_SALARIO"));
                //Recupera o ID do FUNCIONARIO
                wage.setIdEmployee(rset.getInt("COD_FUNCIONARIO"));
                //recupera o VALOR do SALARIO
                wage.setValue(rset.getFloat("VALOR_SALARIO"));

                //adiciona na lista
                wages.add(wage);
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
        return wages;
    }

    public static void updateByEmployeeId(Wage wage){
        String sql = "UPDATE salario SET VALOR_SALARIO = ? " +
                "WHERE COD_FUNCIONARIO = ?";
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            //Cria conexão com o banco
            conn = ConnectionFactory.createConnectionToMySQL();

            //Cria classe para executar a classe
            pstm = conn.prepareStatement(sql);

            //Adiciona valores para atualizar
            pstm.setFloat(3, wage.getValue());

            //QUAL O ID DO REGISTRO QUE DESEJA ATUALIZAR?
            pstm.setInt(5, wage.getIdEmployee());

            //Executa a query
            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Salário do funcionário com ID "+wage.getId()+" foi atualizado!!!");
            try {
                if(conn != null) {
                    conn.close();
                }
                if (pstm != null){
                    pstm.close();
                }
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void deleteById(int id){
        String sql = "DELETE FROM salario WHERE COD_SALARIO = ?";

        Connection conn = null;

        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, id);

            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Salario com ID " + id + " foi deletado.");

            try {
                if(pstm != null){
                    pstm.close();
                }

                if(conn != null){
                    pstm.close();
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
