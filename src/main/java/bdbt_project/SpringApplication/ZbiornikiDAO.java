package bdbt_project.SpringApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import  org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class ZbiornikiDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public ZbiornikiDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Zbiorniki> list(){
        String sql = "SELECT * FROM ZBIORNIKI";

        List<Zbiorniki> listZbiorniki = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Zbiorniki.class));
        return listZbiorniki;
    }

    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Zbiorniki zbiorniki) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("zbiorniki").usingColumns("id_oceanarium", "nazwa", "pojemnosc", "wymiary", "typ_zbiornika", "strefa", "data_przegladu", "opis");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(zbiorniki);
        insertActor.execute(param);
    }

    /* Read – odczytywanie danych z bazy */
    public Zbiorniki get(int id) {
        String sql = "SELECT * FROM ZBIORNIKI WHERE id_zbiornika = ?";
        Object[] args = {id};
        Zbiorniki zbiorniki = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(Zbiorniki.class));
        return zbiorniki;
    }


    /* Update – aktualizacja danych */
    public void update(Zbiorniki zbiorniki) {

    }

    /* Delete – wybrany rekord z danym id */
    public void delete(int id_zbiornika) {
    }

}
