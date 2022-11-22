package rafamattia.liwproject.repository;

import org.mindrot.jbcrypt.BCrypt;
import rafamattia.liwproject.factory.ConnectionFactory;
import rafamattia.liwproject.models.Employee;
import rafamattia.liwproject.models.Payment;
import rafamattia.liwproject.models.Wage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PaymentRepo {
    public static void save(Payment payment) {
        String sql = "INSERT INTO pagamento (COD_SALARIO, DATA_EMISSAO, VALOR) VALUES (?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        Wage wage = WageRepo.findById(payment.getWageId());
        try{

            //criar uma conexão com o banco de dados
            conn = ConnectionFactory.createConnectionToMySQL();

            //criar uma preparedstatement, para executar uma query
            pstm = conn.prepareStatement(sql);
            //Adicionar os valores que são esperados pela query

            pstm.setInt(1, payment.getWageId());
            pstm.setTimestamp(2, payment.getIssueDate());
            pstm.setFloat(3, wage.getValue());

            //executar a query
            pstm.execute();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally{
            System.out.println("Pagamento feito!!");
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

    public static Payment findById(int id) {
        String sql = "SELECT * FROM pagamento WHERE COD_PAGAMENTO = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        Payment payment = new Payment();

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
            payment.setPaymentId(rset.getInt("COD_PAGAMENTO"));
            payment.setWageId(rset.getInt("COD_SALARIO"));
            payment.setIssueDate(rset.getTimestamp("DATA_EMISSAO"));
            payment.setValue(rset.getFloat("VALOR"));
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
        return payment;
    }

    public static List<Payment> getEmployeeList(){
        String sql = "SELECT * FROM pagamento";
        List<Payment> payments = new ArrayList<Payment>();
        Connection conn = null;
        PreparedStatement pstm = null;

        //variável que vai recuperar os dados do banco. ****SELECT****
        ResultSet rset = null;
        try {
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);

            rset = pstm.executeQuery();

            while(rset.next()){
                Payment payment = new Payment();
                //Recupera o ID do salario
                payment.setWageId(rset.getInt("COD_SALARIO"));
                //recupera o ID do pagamento
                payment.setPaymentId(rset.getInt("COD_PAGAMENTO"));
                //recupera a data da emissão
                payment.setIssueDate(rset.getTimestamp("DATA_EMISSAO"));
                //recupera o valor do pagamento
                payment.setValue(rset.getInt("VALOR"));

                //adiciona na lista
                payments.add(payment);
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
        return payments;
    }

    public static void deleteById(int id){
        String sql = "DELETE FROM pagamento WHERE COD_PAGAMENTO = ?";

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
            System.out.println("Pagamento com ID " + id + " foi deletado.");

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
