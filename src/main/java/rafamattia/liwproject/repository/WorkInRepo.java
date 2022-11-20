package rafamattia.liwproject.repository;

import org.mindrot.jbcrypt.BCrypt;
import rafamattia.liwproject.factory.ConnectionFactory;
import rafamattia.liwproject.models.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class WorkInRepo {
    public static void signInInService(int taskId, String login, String password){
            String sql = "INSERT INTO trabalha_em (COD_FUNCIONARIO, COD_SERVICO, HORARIO_ENTRADA) VALUES (?, ?, ?)";

            Connection conn = null;
            PreparedStatement pstm = null;

            try{

                //criar uma conexão com o banco de dados
                conn = ConnectionFactory.createConnectionToMySQL();

                //criar uma preparedstatement, para executar uma query
                pstm = conn.prepareStatement(sql);




                //***********TESTA PASSWORD JBCRYPT******************************************
                String hashedLogin = BCrypt.hashpw(login, BCrypt.gensalt());
                String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
                Employee test = WorkInRepo.employeeExist(login, password);
                //***********TESTA LOGIN E PASSWORD JBCRYPT*********************************

                //Adicionar os valores que são esperados pela query
                if(test != null) {
                    //LocalDateTime lt = LocalDateTime.now();
                    pstm.setInt(1, test.getId());
                    pstm.setInt(2, taskId);
                    pstm.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));

                    //executar a query
                    pstm.execute();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }finally{
                System.out.println("Feito!!!!!!!");
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
    public static Employee employeeExist(String hashedLogin, String hashedPassword){
        try {
            for(Employee e : EmployeeRepo.getEmployeeList()){
                //System.out.println(e.getLogin());
                if ((BCrypt.checkpw(hashedLogin, e.getLogin()) != false)) {
                    return e;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}


