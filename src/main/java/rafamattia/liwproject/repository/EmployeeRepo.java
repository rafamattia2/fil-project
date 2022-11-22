package rafamattia.liwproject.repository;

import org.mindrot.jbcrypt.BCrypt;
import rafamattia.liwproject.factory.ConnectionFactory;
import rafamattia.liwproject.models.Employee;
import rafamattia.liwproject.models.enuns.MaterialType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepo {

    public void save(Employee employee) {
        String sql = "INSERT INTO funcionario (NOME_FUNCIONARIO, SOBRENOME_FUNCIONARIO, TELEFONE, ENDERECO, LOGIN, SENHA) VALUES (?, ?, ?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{

            //criar uma conexão com o banco de dados
            conn = ConnectionFactory.createConnectionToMySQL();

            //criar uma preparedstatement, para executar uma query
            pstm = conn.prepareStatement(sql);

            //Adicionar os valores que são esperados pela query

            //Encripta login
            String hashedLogin = BCrypt.hashpw(employee.getLogin(), BCrypt.gensalt());

            //encripta senha
            String hashedPassword = BCrypt.hashpw(employee.getPassword(), BCrypt.gensalt());

            pstm.setString(1, employee.getFirstName());
            pstm.setString(2, employee.getLastName());
            pstm.setString(3, employee.getPhone());
            pstm.setString(4, employee.getAddress());
            pstm.setString(5, hashedLogin);
            pstm.setString(6, hashedPassword);

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

    public static Employee findById(int id) {
        String sql = "SELECT * FROM funcionario WHERE COD_FUNCIONARIO = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        Employee employee = new Employee();

        //variável que vai recuperar os dados do banco. ****SELECT****
        ResultSet rset = null;
        try{
            //criar uma conexão com o banco de dados
            conn = ConnectionFactory.createConnectionToMySQL();

            //criar uma preparedstatement, para executar uma query
            pstm = conn.prepareStatement(sql);



            //Adicionar os valores que são esperados pela query
            pstm.setInt(1, id);

            //executar a query
            rset=pstm.executeQuery();

            rset.next();
            employee.setId(rset.getInt("COD_FUNCIONARIO"));
            employee.setFirstName(rset.getString("NOME_FUNCIONARIO"));
            employee.setLastName(rset.getString("SOBRENOME_FUNCIONARIO"));
            employee.setPhone(rset.getString("TELEFONE"));
            employee.setAddress(rset.getString("ENDERECO"));
            employee.setLogin(rset.getString("LOGIN"));
            employee.setPassword(rset.getString("ENDERECO"));
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
        return employee;
    }
    public static Employee findByName(String name) {
        String sql = "SELECT * FROM funcionario WHERE NOME_FUNCIONARIO = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        Employee employee = new Employee();

        //variável que vai recuperar os dados do banco. ****SELECT****
        ResultSet rset = null;
        try{
            //criar uma conexão com o banco de dados
            conn = ConnectionFactory.createConnectionToMySQL();

            //criar uma preparedstatement, para executar uma query
            pstm = conn.prepareStatement(sql);



            //Adicionar os valores que são esperados pela query
            pstm.setString(1, name);

            //executar a query
            rset=pstm.executeQuery();

            rset.next();
            employee.setId(rset.getInt("COD_FUNCIONARIO"));
            employee.setFirstName(rset.getString("NOME_FUNCIONARIO"));
            employee.setLastName(rset.getString("SOBRENOME_FUNCIONARIO"));
            employee.setPhone(rset.getString("TELEFONE"));
            employee.setAddress(rset.getString("ENDERECO"));
            employee.setLogin(rset.getString("LOGIN"));
            employee.setPassword(rset.getString("ENDERECO"));
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
        return employee;
    }

    public static List<Employee> getEmployeeList(){
        String sql = "SELECT * FROM funcionario";
        List<Employee> employees = new ArrayList<Employee>();
        Connection conn = null;
        PreparedStatement pstm = null;

        //variável que vai recuperar os dados do banco. ****SELECT****
        ResultSet rset = null;
        try {
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);

            rset = pstm.executeQuery();

            while(rset.next()){
                Employee employee = new Employee();
                //Recupera o ID
                employee.setId(rset.getInt("COD_FUNCIONARIO"));
                //recupera o nome
                employee.setFirstName(rset.getString("NOME_FUNCIONARIO"));
                //recupera o sobrenome
                employee.setLastName(rset.getString("SOBRENOME_FUNCIONARIO"));
                //recupera telefone
                employee.setPhone(rset.getString("TELEFONE"));
                //recupera endereço
                employee.setAddress(rset.getString("ENDERECO"));
                //recupera login
                employee.setLogin(rset.getString("LOGIN"));
                //recupera senha
                employee.setPassword(rset.getString("SENHA"));

                //adiciona na lista
                employees.add(employee);
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
        return employees;
    }

    public static void update(Employee employee){
        String sql = "UPDATE funcionario SET NOME_FUNCIONARIO = ?, SOBRENOME_FUNCIONARIO = ?, TELEFONE = ?, ENDERECO=? " +
                "WHERE COD_FUNCIONARIO = ?";
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            //Cria conexão com o banco
            conn = ConnectionFactory.createConnectionToMySQL();

            //Cria classe para executar a classe
            pstm = conn.prepareStatement(sql);

            //Adiciona valores para atualizar
            pstm.setString(1, employee.getFirstName());
            pstm.setString(2, employee.getLastName());
            pstm.setString(3, employee.getPhone());
            pstm.setString(4, employee.getAddress());
            //QUAL O ID DO REGISTRO QUE DESEJA ATUALIZAR?
            pstm.setInt(5, employee.getId());

            //Executa a query
            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Usuário atualizado!!!");
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
        String sql = "DELETE FROM funcionario WHERE COD_FUNCIONARIO = ?";

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
            System.out.println("Funcionário com ID " + id + " foi deletado.");

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
