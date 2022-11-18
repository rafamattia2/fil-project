package rafamattia.liwproject;

import rafamattia.liwproject.models.Client;
import rafamattia.liwproject.repository.ClientRepo;


public class Main {
    public static void main(String[] args) {

        ClientRepo clientRepo = new ClientRepo();
        String nome = "gabrieru";
        String sobrenome = "alfi ramirus";
        String phone = "pega o zap do gato";
        String email = "manda email pro netto";
        Client cliente = new Client(nome, sobrenome, phone, email);

        clientRepo.save(cliente);

    }
}
