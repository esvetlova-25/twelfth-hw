import org.example.NotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    Product product1 = new Product(11, "духи", 500);
    Product product2 = new Product(222, "пульт", 700);
    Product product3 = new Product(3, "телевизор", 50_000);

    @Test
    public void shouldRemoveFirstProduct() {
        ShopRepository repo = new ShopRepository();
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(11);
        Product[] expected = repo.findAll();
        Product[] actual = {product2, product3};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveProductFromMiddle() {
        ShopRepository repo = new ShopRepository();
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(222);
        Product[] expected = repo.findAll();
        Product[] actual = {product1, product3};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveLastProduct() {
        ShopRepository repo = new ShopRepository();
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(3);
        Product[] expected = repo.findAll();
        Product[] actual = {product1, product2};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotRemoveProduct() {
        ShopRepository repo = new ShopRepository();
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class, () ->
                repo.remove(4)
        );
    }
}