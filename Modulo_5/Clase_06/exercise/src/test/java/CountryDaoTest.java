import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import com.dev.DAO.CountryDao;
import com.dev.Model.Country;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CountryDaoTest {

    private Connection connection;
    private CountryDao countryDao;

    @BeforeAll
    public void setupDatabase() throws SQLException {
        countryDao = new CountryDao();
    }

    @AfterAll
    public void tearDownDatabase() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    @Test
    public void testInsertAndFindById() {
        // Insertar
        Country newCountry = new Country("TL", "TestLand", 3);
        countryDao.insert(newCountry);

        // Recuperar el último ID insertado
        List<Country> countries = countryDao.findAll();
        Country insertedCountry = countries.get(countries.size() - 1);

        assertNotNull(insertedCountry.getCountry_id());
        assertEquals("TestLand", insertedCountry.getCountry_name());
        assertEquals(3, insertedCountry.getRegion_id());

        // FindById
        Country foundCountry = countryDao.findById(insertedCountry.getCountry_id());
        assertNotNull(foundCountry);
        assertEquals(insertedCountry.getCountry_id(), foundCountry.getCountry_id());
        assertEquals("TestLand", foundCountry.getCountry_name());
    }

    @Test
    public void testUpdate() {
        // Insertar primero
        Country country = new Country(null, "OldName", 1);
        countryDao.insert(country);

        // Obtener el ID insertado
        List<Country> countries = countryDao.findAll();
        Country insertedCountry = countries.get(countries.size() - 1);

        // Modificar el país
        insertedCountry.setCountry_name("UpdatedName");
        insertedCountry.setRegion_id(2);
        countryDao.update(insertedCountry);

        // Consultar y verificar
        Country updatedCountry = countryDao.findById(insertedCountry.getCountry_id());
        assertEquals("UpdatedName", updatedCountry.getCountry_name());
        assertEquals(2, updatedCountry.getRegion_id());
    }

    @Test
    public void testDelete() {
        // Insertar primero
        Country country = new Country("10", "DeleteMe", 1);
        countryDao.insert(country);

        // Obtener el ID insertado
        List<Country> countries = countryDao.findAll();
        Country insertedCountry = countries.get(countries.size() - 1);

        // Borrar
        countryDao.delete(insertedCountry.getCountry_id());

        // Verificar
        Country deletedCountry = countryDao.findById(insertedCountry.getCountry_id());
        assertNull(deletedCountry);
    }

    @Test
    public void testFindAll() {
        List<Country> countries = countryDao.findAll();
        assertNotNull(countries);
        assertTrue(countries.size() >= 0);
    }
}