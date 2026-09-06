package school.sptech.api.service;


import org.springframework.stereotype.Service;
import school.sptech.api.model.Cliente;
import school.sptech.api.repository.ClienteRepository;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;


    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    public Cliente buscarPorID(Integer id) {
        return clienteRepository.findById(id);
    }

    public Cliente salvar(Cliente cliente) {

        String frequencia = "";
        if (cliente.getNome() != null && cliente.getPeso() > 0 &&
                (cliente.getObjetivo().equals("Cutting" )|| cliente.getObjetivo().equals("Manutenção") || cliente.getObjetivo().equals("Bulking") )
                && (cliente.getPercentualGordura() == null || (cliente.getPercentualGordura() > 0 && cliente.getPercentualGordura() < 100)) &&
                cliente.getFrequenciaMusculacao() > 0 && cliente.getFrequenciaMusculacao() <= 7
        ) {
            if(cliente.getFrequenciaMusculacao() <= 2 ) {
                frequencia = "baixa";
            } else if(cliente.getFrequenciaMusculacao() <= 4) {
                frequencia = "media";
            } else if(cliente.getFrequenciaMusculacao() <= 7) {
                frequencia = "alta";
            }



            Double gramaQuilo = 0.0;

            if(cliente.getObjetivo().equals("Bulking")){
                if (frequencia.equals("baixa")) {
                    gramaQuilo = 1.6;
                } else if(frequencia.equals("media")) {
                    gramaQuilo = 1.8;
                } else if(frequencia.equals("alta")) {
                    gramaQuilo = 2.0;
                }
            }

            if (cliente.getObjetivo().equals("Cutting")) {
                if (frequencia.equals("baixa")) {
                    gramaQuilo = 1.8;
                } else if (frequencia.equals("media")) {
                    gramaQuilo = 2.0;
                } else if (frequencia.equals("alta")) {
                    gramaQuilo = 2.2;
                }
            }

            if (cliente.getObjetivo().equals("Manutenção")) {
                if (frequencia.equals("baixa")) {
                    gramaQuilo = 1.6;
                } else if (frequencia.equals("media")) {
                    gramaQuilo = 1.8;
                } else if (frequencia.equals("alta")) {
                    gramaQuilo = 2.0;
                }
            }

            Integer proteinaPorDia;
            if(cliente.getPercentualGordura() != null) {
                Double massaMagra = cliente.getPeso() *
                        (1 - cliente.getPercentualGordura() / 100.0);
                proteinaPorDia = (int) (massaMagra * gramaQuilo);
            } else {
                proteinaPorDia = (int) (cliente.getPeso() * gramaQuilo);
            }

            cliente.setProteinaDiaria(proteinaPorDia);

            return clienteRepository.save(cliente);

        }
            return null;
    }

}
