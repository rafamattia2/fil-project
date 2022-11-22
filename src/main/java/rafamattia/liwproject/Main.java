package rafamattia.liwproject;

import net.bytebuddy.asm.Advice;
import org.mindrot.jbcrypt.BCrypt;
import rafamattia.liwproject.models.*;
import rafamattia.liwproject.models.enuns.MaterialType;
import rafamattia.liwproject.repository.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;


public class Main {
    public static void main(String[] args) {

        //ADICIONA CLIENTE
//        ClientRepo clientRepo = new ClientRepo();
//        String nome = "Beatriz";
//        String sobrenome = "Mattia";
//        String phone = "51981016655";
//        String address = "uiizinhadashduashd@hotmail.com";
//        Client cliente = new Client(nome, sobrenome, phone, address);
//
//        clientRepo.save(cliente);


        //ADICIONA MATERIAL
//        MaterialRepo materialRepo = new MaterialRepo();
//        int id_stock = 1;
//        String nome = "Tubo Quadrado 20x30 GALVANIZADO";
//        MaterialType tipo = MaterialType.TUBO_QUADRADO;
//        String dimensoes = "20x30x1,2";
//        int qtd_em_estoque = 5;
//        float value = 500;
//        Material material = new Material(id_stock, nome, tipo, dimensoes, qtd_em_estoque, value);
//
//        materialRepo.save(material);


        //ADICIONA FUNCIONARIO
//        EmployeeRepo employeeRepo = new EmployeeRepo();
//        String nome = "Amaral";
//        String sobrenome = "Souza";
//        String phone = "51981016655";
//        String address = "teste@hotmail.com";
//        String login = "testelogin3";
//        String password = "testepassword3";
//        Employee employee = new Employee(nome, sobrenome, phone, address, login, password);
//
//        employeeRepo.save(employee);


        //ATUALIZAR FUNCIONARIO
//        Employee employee2 = new Employee();
//        employee2.setFirstName("CECILIA");
//        employee2.setLastName("BOTELHO SOUZA");
//        employee2.setPhone("1213-1213");
//        employee2.setAddress("RIO GRNADE, CENTRO");
//        employee2.setId(2);
//
//        EmployeeRepo.update(employee2);

        //VISUALIZAR FUNCIONARIO POR ID
//            Employee employee = EmployeeRepo.findById(5);
//            System.out.println("ID: " + employee.getId());
//            System.out.println("Nome: " + employee.getFirstName());
//            System.out.println("Sobrenome: " + employee.getLastName());
//            System.out.println("Telefone: " + employee.getPhone());
//            System.out.println("Endereço: " + employee.getAddress());
//            System.out.println("*****************************************************");

        //VISUALIZAR LISTA COMPLETA FUNCIONARIOS
//        for(Employee e : EmployeeRepo.getEmployeeList()){
//            System.out.println("Funcionário: " + e.getFirstName() + " "+ e.getLastName());
//            System.out.println("Funcionário: " + e.getId());
//        }

        //BUSCA MATERIAL POR ID
//        Material material = MaterialRepo.findMaterialById(3);
//            System.out.println("ID: " + material.getId());
//            System.out.println(material.getName());
//            System.out.println(material.getMeasurements());
//            System.out.println("ID DO LOCAL: " + material.getId_stock());
//            System.out.println(material.getMeasurements());
//            System.out.println("*****************************************************");
//
//
        //ADICIONA QUANTIDADE EM MATERIAL POR ID
        int amount = 15;
        MaterialRepo.updateAmountByMaterialId(1, -amount);


        //VISUALIZAR LISTA COMPLETA MATERIAIS
//        for(Material e : MaterialRepo.getMaterialList()){
//            System.out.println("ID: " + e.getId());
//            System.out.println(e.getName());
//            System.out.println(e.getMeasurements());
//            System.out.println("ID DO LOCAL: " + e.getId_stock());
//            System.out.println(e.getType());
//            System.out.println(e.getMeasurements());
//            System.out.println("*****************************************************");
//
//        }


        //ADICIONA SALARIO
//        WageRepo wageRepo = new WageRepo();
//        int idEmployee = 6;
//        Float value =  1450.00f;
//        Wage wage = new Wage(idEmployee, value);
//
//        wageRepo.save(wage);
//
//        //VISUALIZAR LISTA COMPLETA DE SALARIOS
//
//        for(Wage e : WageRepo.getWageList()){
//            System.out.println("Id Funcionário: "+e.getIdEmployee());
//            System.out.println("Valor: " + e.getValue());
//        }


//
//        int i = 4;
//        EmployeeRepo.deleteById(i);


        //WageRepo.deleteById(2);

        //DAR ENTRADA ENTRA NO SERVIÇO
        //WorkInRepo.signInInService(1, "testelogin3", "testepassword3");
        //WorkInRepo.logoutInService(1);

        //Adiciona Pagamento

//        int wageId = 3;
//        Timestamp date = Timestamp.valueOf(LocalDateTime.now());
//        Payment payment = new Payment(wageId, date);
//        PaymentRepo.save(payment);

        //Procura pagamento por ID de pagamento
//        Payment payment2 = PaymentRepo.findById(1);
//        System.out.println("Id Pagamento: "+payment2.getPaymentId());
//        System.out.println("Id Salário: "+payment2.getWageId());
//        System.out.println("Valor: " + payment2.getValue());

        //Deleta pagamento por ID
        PaymentRepo.deleteById(2);
        //***********TESTA PASSWORD JBCRYPT****************
//
//        String password = args[0];
//        String candidate = args[1];
//        // Hash a password for the first time
//        String hashed = BCrypt.hashpw(password, BCrypt.gensalt());
//
//        // gensalt's log_rounds parameter determines the complexity
//        // the work factor is 2**log_rounds, and the default is 10
//        //String hashed = BCrypt.hashpw(password, BCrypt.gensalt(12));
//
//        // Check that an unencrypted password matches one that has
//        // previously been hashed
//        if (BCrypt.checkpw(candidate, hashed))
//            return true;
//        else
//            return false;
        //***********TESTA PASSWORD JBCRYPT****************
    }
}

