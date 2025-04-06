import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.code.AnalisisVentas;
import com.code.AnalisisVentas.Venta;

public class TestAnalisisVentas {

    private List<String> ventas;
    private AnalisisVentas analisisVentas;

    @BeforeEach
    public void setup() {
        ventas = Arrays.asList(
            "camisa,2,20.00",
            "pantalón,1,35.50",
            "zapatos,3,50.00",
            "camisa,1,20.00",
            "pantalón,2,35.50"
        );
        analisisVentas = new AnalisisVentas(ventas);
    }

    @Test
    public void testCalculateTotalIncome() {
        assertEquals(316.50, analisisVentas.calculateTotalIncome(), 0.01);
    }

    @Test
    public void testCountPurchaseByProduct() {
        Map<String, Integer> counts = analisisVentas.countPurchaseByProduct();
        assertEquals(3, counts.get("camisa"));
        assertEquals(3, counts.get("pantalón"));
        assertEquals(3, counts.get("zapatos"));
    }

    @Test
    public void testFilterPurchasesHigher() {
        List<Venta> filtered = analisisVentas.filterPurchasesHigher(60.00);
        assertEquals(2, filtered.size());
    }

    @Test
    public void testGetProductMorePurchased() {
        Venta mostPurchased = analisisVentas.getProductMorePurchased();
        assertNotNull(mostPurchased);
        assertEquals("zapatos", mostPurchased.getProduct());
    }
}
