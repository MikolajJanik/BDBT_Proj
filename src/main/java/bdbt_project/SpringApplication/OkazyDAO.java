package bdbt_project.SpringApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import  org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class OkazyDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public OkazyDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Okazy> list(){
        String sql = "SELECT * FROM OKAZY";

        List<Okazy> listOkazy = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Okazy.class));
        return listOkazy;
    }

    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Okazy okazy) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("okazy").usingColumns("id_zbiornika", "id_gatunku", "typ_okazu", "nazwa", "liczebnosc", "opis");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(okazy);
        insertActor.execute(param);
    }

    /* Read – odczytywanie danych z bazy */
    public Okazy get1(int id_okazu) {
        String sql = "SELECT * FROM OCEANARIA WHERE id_okazu = ?";
        Object[] args = {id_okazu};
        Okazy okazy = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(Okazy.class));
        return okazy;
    }
    public Okazy get(int id_okazu) {
        Object[] args = {id_okazu};
        String sql = "SELECT * FROM OKAZY WHERE id_okazu = " + args[0];
        Okazy okazy = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Okazy.class));
        return okazy;

    }

    /* Update – aktualizacja danych */
    public void update(Okazy okazy) {
    }

    /* Delete – wybrany rekord z danym id */
    public void delete(int id_okazu) {
    }

}
