package bdbt_project.SpringApplication;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OceanariumDAOTest extends Object {

    private OceanariumDAO dao;

    @BeforeEach
    void setUp() throws Exception{
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:oracle:thin:@194.29.170.4:1521:xe");
        dataSource.setUsername("BDBTGRC17");
        dataSource.setPassword("BDBTGRC17");
        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");

        dao = new OceanariumDAO(new JdbcTemplate(dataSource));
    }

    @Test
    void list() {
        List<Oceanarium> listOceanarium = dao.list();
        System.out.println(Arrays.toString(listOceanarium.toArray()));

        assertTrue(!listOceanarium.isEmpty());
    }

    @Test
    void save() {
        Oceanarium oceanarium = new Oceanarium(1, 6,  "oceantest", "dsdfsdf@wp.pl", "12/12/12", 123456789);
        dao.save(oceanarium);
    }

    @Test
    void get() {
        int id = 64;
        Oceanarium oceanarium = dao.get(id);

        assertNotNull(oceanarium);
    }

    @Test
    void update() {
        fail("Not yet implemented");
    }

    @Test
    void delete() {
        fail("Not yet implemented");
    }
}