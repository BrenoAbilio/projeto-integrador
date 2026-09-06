package school.sptech.api.controller;


import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.sptech.api.model.Cliente;
import school.sptech.api.repository.ClienteRepository;
import school.sptech.api.service.ClienteService;

import java.util.List;

@RestController
@RequestMapping("/fichas")
@CrossOrigin(origins = "*")
public class ClienteController {

    private final ClienteRepository clienteRepository;
    private final ClienteService clienteService;


    public ClienteController(ClienteRepository clienteRepository, ClienteService clienteService) {
        this.clienteRepository = clienteRepository;
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listarTodos() {
        return ResponseEntity.status(200).body(clienteRepository.findAll());
    }

    @GetMapping("/{idFicha}")
    public ResponseEntity<Cliente> listarPorId(@PathVariable Integer idFicha) {
        return ResponseEntity.status(200).body(clienteRepository.findById(idFicha));
    }

    @PostMapping
    public ResponseEntity<Cliente> criar(@RequestBody Cliente cliente) {

        System.out.println("ENTROU NO CONTROLLER");

        Cliente clienteSalvo = clienteService.salvar(cliente);

        if(clienteSalvo == null) {
            return ResponseEntity.status(400).build();
        }
        return ResponseEntity.status(201).body(clienteSalvo);
    }
}
