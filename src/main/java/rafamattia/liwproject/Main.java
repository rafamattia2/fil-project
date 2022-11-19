package rafamattia.liwproject;

import rafamattia.liwproject.models.Client;
import rafamattia.liwproject.repository.ClientRepo;


public class Main {
    public static void main(String[] args) {

        /*ClientRepo clientRepo = new ClientRepo();
        String nome = "Beatriz";
        String sobrenome = "Mattia";
        String phone = "51981016655";
        String address = "uiizinhadashduashd@hotmail.com";
        Client cliente = new Client(nome, sobrenome, phone, address);

        clientRepo.save(cliente);*/

        //Visualizar a lista de clients TODOS

        for(Client c : ClientRepo.getClientList()){
            System.out.println("Cliente: " + c.getFirstName());
        }

    }
}
