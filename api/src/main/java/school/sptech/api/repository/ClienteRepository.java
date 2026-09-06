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

        String sql = "INSERT INTO clientes (nome,peso,objetivo,frequenciaMusculacao,percentualGordura,proteinaDiaria) VALUES (?,?,?,?,?,?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(con ->{
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1,cliente.getNome());
            ps.setDouble(2,cliente.getPeso());
            ps.setString(3,cliente.getObjetivo());
            ps.setInt(4,cliente.getFrequenciaMusculacao());
            ps.setObject(5,cliente.getPercentualGordura());
            ps.setInt(6,cliente.getProteinaDiaria());
            return ps;
        }, keyHolder);

        cliente.setId(keyHolder.getKey().intValue());
        return cliente;
    }


}
