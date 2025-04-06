import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.code.AnalisisFacturasEmpresa;

public class TestAnalisisFacturasEmpresa {
    
    private AnalisisFacturasEmpresa analisisFacturas;

    @BeforeEach
    public void setup() {
        List<String> facturas = Arrays.asList(
            "F001,Cliente1,100.0,19.0",
            "F002,Cliente2,200.0,19.0",
            "F003,Cliente1,150.0,10.0",
            "F004,Cliente3,300.0,15.0",
            "F005,Cliente2,50.0,5.0"
        );
        analisisFacturas = new AnalisisFacturasEmpresa(facturas);
    }

    @Test
    public void testGetAmountWithIva() {
        Map<String, Double> result = analisisFacturas.getAmountWithIva();
        assertEquals(119.0, result.get("F001"), 0.01);
        assertEquals(238.0, result.get("F002"), 0.01);
        assertEquals(165.0, result.get("F003"), 0.01);
        assertEquals(345.0, result.get("F004"), 0.01);
        assertEquals(52.5, result.get("F005"), 0.01);
    }

    @Test
    public void testGetTotalByCustomer() {
        Map<String, Double> result = analisisFacturas.getTotalByCustomer();
        assertEquals(284.0, result.get("Cliente1"), 0.01);
        assertEquals(290.5, result.get("Cliente2"), 0.01);
        assertEquals(345.0, result.get("Cliente3"), 0.01);
    }

    @Test
    public void testFilterBillsHigher() {
        List<AnalisisFacturasEmpresa.Bill> result = analisisFacturas.filterBillsHigher(100.0);
        assertEquals(3, result.size());
    }

    @Test
    public void testGetCustomerWithIncomeHigher() {
        String result = analisisFacturas.getCustomerWithIncomeHigher();
        assertEquals("Cliente3", result);
    }
}
