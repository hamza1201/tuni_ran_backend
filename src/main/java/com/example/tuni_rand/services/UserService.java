package com.example.tuni_rand.services;

import com.example.tuni_rand.domain.Admin;
import com.example.tuni_rand.domain.Agent;
import com.example.tuni_rand.domain.Client;
import com.example.tuni_rand.domain.User;
import com.example.tuni_rand.exceptions.UsernameAlreadyExistsException;
import com.example.tuni_rand.repositories.AdminRepository;
import com.example.tuni_rand.repositories.AgentRepository;
import com.example.tuni_rand.repositories.ClientRepository;
import com.example.tuni_rand.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private AgentRepository agentRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    public Admin saveAdmin(Admin newAdmin) {
        try {
            newAdmin.setPassword(bCryptPasswordEncoder.encode(newAdmin.getPassword()));
            newAdmin.setUsername(newAdmin.getUsername());
            newAdmin.setConfirmPassword("");
            newAdmin.setRole("Admin");
            return adminRepository.save(newAdmin);

        } catch (Exception e) {
            throw new UsernameAlreadyExistsException("Username '" + newAdmin.getUsername() + "' is already exists");

        }
    }

    public Agent saveAgent(Agent newAgent) {
        try {
            newAgent.setPassword(bCryptPasswordEncoder.encode(newAgent.getPassword()));
            newAgent.setUsername(newAgent.getUsername());
            newAgent.setNomEntreprise(newAgent.getNomEntreprise());
            newAgent.setConfirmPassword("");
            newAgent.setRole("Agent");
            return agentRepository.save(newAgent);

        } catch (Exception e) {
            throw new UsernameAlreadyExistsException("Username '" + newAgent.getUsername() + "' is already exists");

        }
    }

    public Client saveClient(Client newClient) {
        try {
            newClient.setPassword(bCryptPasswordEncoder.encode(newClient.getPassword()));
            newClient.setConfirmPassword("");
            newClient.setUsername(newClient.getUsername());
            newClient.setAge(newClient.getAge());
            newClient.setNom(newClient.getNom());
            newClient.setGenre(newClient.getGenre());
            newClient.setVille(newClient.getVille());
            newClient.setRole("Client");
            return clientRepository.save(newClient);

        } catch (Exception e) {
            throw new UsernameAlreadyExistsException("Username '" + newClient.getUsername() + "' is already exists");

        }
    }
}
