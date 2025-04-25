import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.code.Producto;

public class TestProducto {

    static List<Producto> products;
    static Producto product1;
    static Producto product2;
    static Producto product3;
    static Producto product4;
    static Producto product5;
    
    @BeforeAll
    static void setup(){
        product1 = new Producto("Laptop", 1200.99, 5);
        product2 = new Producto("Celular", 799.49, 10);
        product3 = new Producto("Teclado", 45.99, 50);
        product4 = new Producto("Monitor", 199.99, 7);
        product5 = new Producto("Ratón", 25.50, 50);
        products = Arrays.asList(
        product1, product2, product3, product4, product5);
    }

    // Exercise 1
    @Test
    void testSortByPriceAscending(){
        Collections.sort(products);
        assertIterableEquals(Arrays.asList(product5, product3, product4, product2, product1), products);
    }

    // Exercise 2
    @Test
    void testSortByPriceDescending(){
        products.sort((product1, product2) -> product2.getPrice().compareTo(product1.getPrice()));
        assertIterableEquals(Arrays.asList(product1, product2, product4, product3, product5), products);
    }

    // Exercise 2
    @Test
    void testSortByNameAlphabetically(){
        products.sort((product1, product2) -> product1.getName().compareTo(product2.getName()));
        assertIterableEquals(Arrays.asList(product2, product1,product4, product5, product3), products);
    }

    // Exercise 3
    @Test
    void testSortByQuantityAndPriceAscending(){
        ComparatorMuliplesCriterios cmc = new ComparatorMuliplesCriterios();
        Collections.sort(products, cmc);
        assertIterableEquals(Arrays.asList(product1, product4, product2, product5, product3), products);
    }

    public class ComparatorMuliplesCriterios implements Comparator<Producto> {

        @Override
        public int compare(Producto o1, Producto o2) {
            int comparator = Integer.compare(o1.getQuantity(), o2.getQuantity());
            if(comparator == 0){
                comparator = Double.compare(o1.getPrice(), o2.getPrice());
            }
            return comparator;
        }
        
    }
}
