package TestDrivenDevelopment;

import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class ProductStockTest {
    private Instock instock;

    @Before
    public void setupInstock() {
        this.instock = new Instock();
    }


    @Test
    public void testIfContainsMethodReturnsCorrectBoolean() {
        Product product = createProduct();
        //Test not containing product before adding
        assertFalse(instock.contains(product));

        instock.add(product);
        //Test containing product after adding
        assertTrue(instock.contains(product));


        //Test not containing product based on label
        assertFalse(instock.contains(new Product("not_present_label", 3, 1)));
    }

    @Test
    public void testIfGetCountReturnsCorrectSize() {
        assertEquals(0, instock.getCount(), 0);
        Product product = createProduct();
        instock.add(product);
        assertEquals(1, instock.getCount(), 0);
    }

    @Test
    public void testIfAddMethodAddsCorrectProduct() {
        Product product = createProduct();
        instock.add(product);
        assertTrue(instock.contains(product));
    }

    @Test
    public void testFindByIndexShouldReturnCorrectProductIfAtFirstPositionOfStock() {
        fillInStockWithProducts(5);
        Product foundProduct = instock.find(0);
        assertNotNull(foundProduct);
        assertEquals("test_product0", foundProduct.getLabel());
    }

    @Test
    public void testFindByIndexShouldReturnCorrectProductIfAtLastPositionOfStock() {
        fillInStockWithProducts(5);
        Product product = createProduct();
        instock.add(product);
        Product foundProduct = instock.find(instock.getCount() - 1);
        assertNotNull(foundProduct);
        assertEquals(product.getLabel(), foundProduct.getLabel());
    }

    @Test
    public void testFindByIndexShouldReturnCorrectProductIfInTheMiddleOfStock() {
        fillInStockWithProducts(5);
        Product foundProduct = instock.find(2);
        assertNotNull(foundProduct);
        assertEquals("test_product2", foundProduct.getLabel());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindByIndexMethodWithNegativeInput() {
        instock.find(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindByIndexWhenNoProductsInStock() {
        instock.find(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindByIndexWhenIndexEqualsToCount() {
        fillInStockWithProducts(5);
        instock.find(instock.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testChangeQuantityForProductNotNull() {
        Product product = createProduct();
        instock.changeQuantity(product.getLabel(), product.getQuantity() + 10);
    }

    @Test
    public void testChangeQuantityShouldSetNewQuantityToCorrectProduct() {
        Product product = createProduct();
        instock.add(product);
        int newQuantity = product.getQuantity() + 10;
        instock.changeQuantity(product.getLabel(), newQuantity);
        Product foundProduct = instock.find(0);

        assertEquals(newQuantity, product.getQuantity());
        assertNotNull(foundProduct);

        assertEquals(newQuantity, foundProduct.getQuantity(), 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindByLabelForProductNotInStock() {
        instock.findByLabel("not_present_label");
    }

    @Test
    public void testFindByLabelShouldReturnTheCorrectProduct() {
        Product product = createProduct();
        instock.add(product);
        Product foundProduct = instock.findByLabel(product.getLabel());
        assertEquals(product, foundProduct);
    }

    @Test
    public void testFindByAlphabeticalOrderShouldReturnCorrectNumberOfProductsAndOrderedAlphabetical() {
        fillInStockWithProducts(10);

        Iterable<Product> products = instock.findFirstByAlphabeticalOrder(8);
        assertNotNull(products);
        List<Product> returnedProducts = createListFromIterable(products);
        assertEquals(8, returnedProducts.size());

        Set<String> expectedLabels = returnedProducts.stream()
                .map(Product::getLabel)
                .collect(Collectors.toCollection(TreeSet::new));
        int index = 0;
        for (String expectedLabel : expectedLabels) {
            assertEquals(expectedLabel, returnedProducts.get(index++).getLabel());
        }
    }

    @Test
    public void testFindFirstByAlphabeticalOrderShouldReturnEmptyCollectionIfArgumentOutOfRange() {
        fillInStockWithProducts(10);
        Iterable<Product> iterable = instock.findFirstByAlphabeticalOrder(11);
        assertNotNull(iterable);

        List<Product> list = createListFromIterable(iterable);

        assertTrue(list.isEmpty());
    }

    @Test
    public void testFindAllInPriceRangeShouldReturnCorrectItemsWithCorrectOrder() {
        // lower 5 upper 10 -> (5,10]
        Product product1 = new Product("test_label_1", 1, 1);
        Product product2 = new Product("test_label_2", 2, 1);
        Product product5 = new Product("test_label_5", 5, 1);
        Product product6 = new Product("test_label_6", 6, 1);
        Product product7 = new Product("test_label_7", 7, 1);
        Product product9 = new Product("test_label_9", 9, 1);
        Product product10 = new Product("test_label_10", 10, 1);
        Product product11 = new Product("test_label_11", 11, 1);
        Product product12 = new Product("test_label_12", 12, 1);
        instock.add(product1);
        instock.add(product2);
        instock.add(product5);
        instock.add(product6);
        instock.add(product7);
        instock.add(product9);
        instock.add(product10);
        instock.add(product11);
        instock.add(product12);
        Iterable<Product> productsInRange = instock.findAllInRange(5, 10);

        assertNotNull(productsInRange);
        List<Product> products = createListFromIterable(productsInRange);
        assertEquals(4, products.size());
        assertEquals(10, products.get(0).getPrice(), 0);
        assertEquals(9, products.get(1).getPrice(), 0);
        assertEquals(7, products.get(2).getPrice(), 0);
        assertEquals(6, products.get(3).getPrice(), 0);
    }

    @Test
    public void testFindAllInPriceRangeShouldReturnEmptyCollectionWhenNoneInRange() {
        // lower 5 upper 10 -> (5,10]
        Product product1 = new Product("test_label_1", 1, 1);
        Product product2 = new Product("test_label_2", 2, 1);

        instock.add(product1);
        instock.add(product2);
        Iterable<Product> productsInRange = instock.findAllInRange(5, 10);
        assertNotNull(productsInRange);

        List<Product> products = createListFromIterable(productsInRange);
        assertTrue(products.isEmpty());
    }

    @Test
    public void testFindAllByPricesShouldReturnCorrectPricedItems() {
        Product product1 = new Product("test_label_1", 1, 1);
        Product product2 = new Product("test_label_2", 2, 1);
        Product product3 = new Product("test_label_3", 5, 1);
        Product product4 = new Product("test_label_4", 5, 1);
        Product product5 = new Product("test_label_5", 5, 1);
        Product product6 = new Product("test_label_6", 5, 1);
        Product product7 = new Product("test_label_7", 5, 1);
        Product product8 = new Product("test_label_8", 8, 1);
        Product product9 = new Product("test_label_9", 9, 1);

        instock.add(product1);
        instock.add(product2);
        instock.add(product3);
        instock.add(product4);
        instock.add(product5);
        instock.add(product6);
        instock.add(product7);
        instock.add(product8);
        instock.add(product9);

        Iterable<Product> iterable = instock.findAllByPrice(5);

        assertNotNull(iterable);

        List<Product> products = createListFromIterable(iterable);

        assertEquals(5, products.size());
        for (Product product : products) {
            assertEquals(5, product.getPrice(), 0);
        }
    }

    @Test
    public void testFindAllByPricesShouldReturnCorrectEmptyCollectionWhenNoItemsWithPriceSpecified() {
        fillInStockWithProducts(10);
        Product product = instock.find(0);
        assertNotNull(product);
        Iterable<Product> foundByPrice = instock.findAllByPrice(product.getPrice() + 10);
        assertNotNull(foundByPrice);
        List<Product> products = createListFromIterable(foundByPrice);
        assertTrue(products.isEmpty());
    }

    @Test
    public void testFindFirstMostExpensiveProductsShouldReturnCorrectProducts() {
        Product product1 = new Product("test_label_1", 1, 1);
        Product product2 = new Product("test_label_2", 2, 1);
        Product product3 = new Product("test_label_3", 3, 1);
        Product product4 = new Product("test_label_4", 4, 1);
        Product product5 = new Product("test_label_5", 5, 1);
        Product product6 = new Product("test_label_6", 6, 1);
        Product product7 = new Product("test_label_7", 7, 1);
        Product product8 = new Product("test_label_8", 8, 1);
        Product product9 = new Product("test_label_9", 9, 1);

        instock.add(product1);
        instock.add(product2);
        instock.add(product3);
        instock.add(product4);
        instock.add(product5);
        instock.add(product6);
        instock.add(product7);
        instock.add(product8);
        instock.add(product9);

        Iterable<Product> iterable = instock.findFirstMostExpensiveProducts(5);
        assertNotNull(iterable);
        List<Product> products = createListFromIterable(iterable);
        assertEquals(5, products.size());
        assertEquals(9, products.get(0).getPrice(), 0);
        assertEquals(8, products.get(1).getPrice(), 0);
        assertEquals(7, products.get(2).getPrice(), 0);
        assertEquals(6, products.get(3).getPrice(), 0);
        assertEquals(5, products.get(4).getPrice(), 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindFirstMostExpensiveProductsWhenNotEnoughItems() {
        fillInStockWithProducts(10);
        instock.findFirstMostExpensiveProducts(11);
    }

    @Test
    public void testFindAllByQuantityReturnCorrectProducts() {
        Product product1 = new Product("test_label_1", 1, 10);
        Product product2 = new Product("test_label_2", 2, 10);
        Product product3 = new Product("test_label_3", 3, 10);
        Product product4 = new Product("test_label_4", 4, 10);
        Product product5 = new Product("test_label_5", 5, 10);
        Product product6 = new Product("test_label_6", 6, 10);
        Product product7 = new Product("test_label_7", 7, 1);
        Product product8 = new Product("test_label_8", 8, 1);
        Product product9 = new Product("test_label_9", 9, 1);

        instock.add(product1);
        instock.add(product2);
        instock.add(product3);
        instock.add(product4);
        instock.add(product5);
        instock.add(product6);
        instock.add(product7);
        instock.add(product8);
        instock.add(product9);

        Iterable<Product> iterable = instock.findAllByQuantity(10);
        assertNotNull(iterable);
        List<Product> products = createListFromIterable(iterable);
        assertEquals(6, products.size());
        assertEquals(10, products.get(0).getQuantity());
        assertEquals(10, products.get(1).getQuantity());
        assertEquals(10, products.get(2).getQuantity());
        assertEquals(10, products.get(3).getQuantity());
        assertEquals(10, products.get(4).getQuantity());
        assertEquals(10, products.get(5).getQuantity());
    }

    @Test
    public void testFindAllByQuantityShouldReturnEmptyCollectionWhenNoSuchItems() {
        fillInStockWithProducts(10);
        Product product = instock.find(0);
        assertNotNull(product);

        Iterable<Product> iterable = instock.findAllByQuantity(product.getQuantity() + 10);
        assertNotNull(iterable);
        List<Product> products = createListFromIterable(iterable);
        assertTrue(products.isEmpty());
    }

    @Test
    public void testGetIterableShouldReturnAllProducts() {
        Product product1 = new Product("test_label_1", 1, 10);
        Product product2 = new Product("test_label_2", 2, 10);
        Product product3 = new Product("test_label_3", 3, 10);
        Product product4 = new Product("test_label_4", 4, 10);
        Product product5 = new Product("test_label_5", 5, 10);
        Product product6 = new Product("test_label_6", 6, 10);
        Product product7 = new Product("test_label_7", 7, 1);
        Product product8 = new Product("test_label_8", 8, 1);
        Product product9 = new Product("test_label_9", 9, 1);

        instock.add(product1);
        instock.add(product2);
        instock.add(product3);
        instock.add(product4);
        instock.add(product5);
        instock.add(product6);
        instock.add(product7);
        instock.add(product8);
        instock.add(product9);

        Iterator<Product> iterable = instock.iterator();
        assertNotNull(iterable);

        List<Product> products = createListFromIterable(iterable);

        assertEquals(9, products.size());

        assertEquals(10, products.get(0).getQuantity());
        assertEquals(10, products.get(1).getQuantity());
        assertEquals(10, products.get(2).getQuantity());
        assertEquals(10, products.get(3).getQuantity());
        assertEquals(10, products.get(4).getQuantity());
        assertEquals(10, products.get(5).getQuantity());
    }

    @Test
    public void testGetIterableShouldReturnEmptyCollectionWhenNoItems() {
        Iterator<Product> iterable = instock.iterator();
        assertNotNull(iterable);
        List<Product> products = createListFromIterable(iterable);
        assertNotNull(products);
        assertTrue(products.isEmpty());
    }

    private Product createProduct() {
        return new Product("test_product", 2.50, 2);
    }

    private <T> List<T> createListFromIterable(Iterable<T> items) {
        List<T> result = new ArrayList<>();

        for (T item : items) {
            result.add(item);
        }
        return result;
    }

    private <T> List<T> createListFromIterable(Iterator<T> items) {
        List<T> result = new ArrayList<>();

        while (items.hasNext()) {
            result.add(items.next());
        }
        return result;
    }

    private Product[] createMultipleProducts(int count) {
        Product[] products = new Product[count];
        for (int i = 0; i < count; i++) {
            products[i] = new Product("test_product" + i, 2.50, 2);
        }
        return products;
    }

    private void fillInStockWithProducts(int count) {
        Product[] products = createMultipleProducts(count);
        for (Product product : products) {
            instock.add(product);
        }
    }
}