package bdbt_project.SpringApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import  org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class OceanariumDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public OceanariumDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Oceanarium> list(){
        String sql = "SELECT * FROM OCEANARIA";

        List<Oceanarium> listOceanarium = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Oceanarium.class));
        return listOceanarium;
    }

    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Oceanarium oceanarium) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("oceanaria").usingColumns("id_adresu", "nazwa", "email", "data_otwarcia", "telefon");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(oceanarium);
        insertActor.execute(param);
    }

    /* Read – odczytywanie danych z bazy */
    public Oceanarium get1(int id_oceanarium) {
        String sql = "SELECT * FROM OCEANARIA WHERE id_oceanarium = ?";
        Object[] args = {id_oceanarium};
        Oceanarium oceanarium = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(Oceanarium.class));
        return oceanarium;
    }
    public Oceanarium get(int id_oceanarium) {
        Object[] args = {id_oceanarium};
        String sql = "SELECT * FROM OCEANARIA WHERE id_oceanarium = " + args[0];
        Oceanarium oceanarium = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Oceanarium.class));
        return oceanarium;

    }

    /* Update – aktualizacja danych */
    public void update(Oceanarium oceanarium) {
    }

    /* Delete – wybrany rekord z danym id */
    public void delete(int id_oceanarium) {
    }

}
