package com.ciclo3.juanparra.service;

import java.util.List;
import java.util.Optional;
import com.ciclo3.juanparra.model.Client;
import com.ciclo3.juanparra.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll() {
        return clientRepository.getAll();
    }

    public Optional<Client> getClient(int id) {
        return clientRepository.getClient(id);
    }

    public Client save(Client clt) {
        if (clt.getIdCLient() == null) {
            return clientRepository.save(clt);
        } else {
            Optional<Client> consulta = clientRepository.getClient(clt.getIdCLient());
            if (consulta.isEmpty()) {
                return clientRepository.save(clt);
            } else {
                return clt;

            }
        }
    }
}
