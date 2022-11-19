package rafamattia.liwproject.repository;

import rafamattia.liwproject.factory.ConnectionFactory;
import rafamattia.liwproject.models.Employee;

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
            pstm.setString(1, employee.getFirstName());
            pstm.setString(2, employee.getLastName());
            pstm.setString(3, employee.getPhone());
            pstm.setString(4, employee.getAddress());
            pstm.setString(5, employee.getLogin());
            pstm.setString(6, employee.getPassword());

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
    public Client findByName(Client client) {
        String sql = "SELECT * FROM cliente WHERE NOME_CLIENTE = \"cliente\" ";

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
            pstm.setString(4, client.getAddress());

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
            return client;
        }
    }

    public static void update(Client client){
        String sql = "UPDATE cliente SET NOME_CLIENTE = ?, SOBRENOME_CLIENTE = ?, TELEFONE = ?, ENDERECO=? " +
                "WHERE COD_CLIENTE = ?";
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            //Cria conexão com o banco
            conn = ConnectionFactory.createConnectionToMySQL();

            //Cria classe para executar a classe
            pstm = conn.prepareStatement(sql);

            //Adiciona valores para atualizar
            pstm.setString(1, client.getFirstName());
            pstm.setString(2, client.getLastName());
            pstm.setString(3, client.getPhone());
            pstm.setString(4, client.getAddress());
            //QUAL O ID DO REGISTRO QUE DESEJA ATUALIZAR?
            pstm.setInt(5, client.getId());

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
    public static List<Client> getClientList(){
        String sql = "SELECT * FROM cliente";
        List<Client> clients = new ArrayList<Client>();
        Connection conn = null;
        PreparedStatement pstm = null;

        //variável que vai recuperar os dados do banco. ****SELECT****
        ResultSet rset = null;
        try {
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);

            rset = pstm.executeQuery();

            while(rset.next()){
                Client client = new Client();
                //Recupera o ID
                client.setId(rset.getInt("COD_CLIENTE"));
                //recupera o nome
                client.setFirstName(rset.getString("NOME_CLIENTE"));
                //recupera o sobrenome
                client.setLastName(rset.getString("SOBRENOME_CLIENTE"));
                //recupera telefone
                client.setPhone(rset.getString("TELEFONE"));
                //recupera endereço
                client.setAddress(rset.getString("ENDERECO"));
                //recupera serviços ativos
                client.setActiveServices(rset.getInt("SERVICOS_ATIVOS"));
                //recupera total de serviços
                client.setTotalServices(rset.getInt("SERVICOS_TOTAL"));

                //adiciona na lista
                clients.add(client);
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
        return clients;
    }

}
