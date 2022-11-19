package rafamattia.liwproject;

import org.mindrot.jbcrypt.BCrypt;
import rafamattia.liwproject.models.Client;
import rafamattia.liwproject.models.Employee;
import rafamattia.liwproject.repository.ClientRepo;
import rafamattia.liwproject.repository.EmployeeRepo;


public class Main {
    public static void main(String[] args) {
//        ClientRepo clientRepo = new ClientRepo();
//        String nome = "Beatriz";
//        String sobrenome = "Mattia";
//        String phone = "51981016655";
//        String address = "uiizinhadashduashd@hotmail.com";
//        Client cliente = new Client(nome, sobrenome, phone, address);

//        clientRepo.save(cliente);

//        EmployeeRepo employeeRepo = new EmployeeRepo();
//        String nome = "Beatriz";
//        String sobrenome = "Mattia";
//        String phone = "51981016655";
//        String address = "uiizinhadashduashd@hotmail.com";
//        String login = "testelogin";
//        String password = "testepassword";
//        Employee employee = new Employee(nome, sobrenome, phone, address, login, password);
//
//        employeeRepo.save(employee);

        //Atualizar contato
//        Employee employee2 = new Employee();
//        employee2.setFirstName("CECILIA");
//        employee2.setLastName("BOTELHO SOUZA");
//        employee2.setPhone("1213-1213");
//        employee2.setAddress("RIO GRNADE, CENTRO");
//        employee2.setId(2);
//
//        EmployeeRepo.update(employee2);
//
        //Visualizar a lista de clients TODOS
        for(Employee e : EmployeeRepo.getEmployeeList()){
            System.out.println("Funcionário: " + e.getFirstName() + " "+ e.getLastName());
        }
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
