public class UseShoppingCart {
    public static void main(String[] args) {
        ShoppingCart myCart = new ShoppingCart(10);

        // create produce and prices
        Banana banana = new Banana(0.26); // 26 cents each banana
        Avocado avocado = new Avocado(1.50); // $1.50 each avocado
        Spinach spinach = new Spinach(0.50); // 50 cents per pound
        Brocolli brocolli = new Brocolli(1.90); // $1.90 per pound

        Integer count = 4;
        ProduceQuantity<Banana, Integer> itemOne = new ProduceQuantity<>(banana, count);
        myCart.addItem(itemOne);

        count = 1;
        ProduceQuantity<Avocado, Integer> itemTwo = new ProduceQuantity<>(avocado, count);
        myCart.addItem(itemTwo);

        Double weight = 0.5;
        ProduceQuantity<Spinach, Double> itemThree = new ProduceQuantity<>(spinach, weight);
        myCart.addItem(itemThree);

        weight = 1.0;
        ProduceQuantity<Brocolli, Double> itemFour = new ProduceQuantity<>(brocolli, weight);
        myCart.addItem(itemFour);

        System.out.println(myCart);


    }
}
