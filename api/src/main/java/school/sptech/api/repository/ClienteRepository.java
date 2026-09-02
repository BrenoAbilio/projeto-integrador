package school.sptech.api.repository;


import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import school.sptech.api.model.Cliente;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class ClienteRepository {

    private final JdbcTemplate jdbcTemplate;
    private final BeanPropertyRowMapper<Cliente> mapper = new BeanPropertyRowMapper<>(Cliente.class);

    public ClienteRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Cliente> findAll() {
        String sql = "SELECT * FROM clientes";
        return jdbcTemplate.query(sql,mapper);
    }

    public Cliente findById(Integer id) {
        String sql = "SELECT * FROM clientes where id = ?";
        return jdbcTemplate.queryForObject(sql,mapper,id);
    }

    public Cliente save(Cliente cliente) {
//        if(cliente.getId() != null && findById(cliente.getId()) != null) {
//            String sql = "UPDATE clientes set nome = ?, peso = ?, objetivo =?, frequenciaMusculacao = ?,percentualGordura = ?";
//            jdbcTemplate.update(sql, cliente.getNome(), cliente.getPeso(), cliente.getObjetivo(),
//                    cliente.getFrequenciaMusculacao(), cliente.getPercentualGordura());
//            return cliente;
//        }

        String sql = "INSERT INTO clientes (nome,peso,objetivo,frequenciaMusculacao,percentualGordura) VALUES (?,?,?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con ->{
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        })




    }
}
