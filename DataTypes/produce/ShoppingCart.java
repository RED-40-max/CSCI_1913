public class ShoppingCart {
    private ProduceQuantity[] items;
    private int howMany = 0;

    public ShoppingCart(int count) {
        items = new ProduceQuantity[count];
    }

    public boolean addItem(ProduceQuantity item) {
        if (howMany == items.length) {
            System.out.println("Item count limit reached");
            return false;
        }
        items[howMany] = item;
        howMany++;
        return true;
    }

    public String toString() {
        String message = "Items in shopping cart:\n";
        for (int i = 0; i < howMany; i++) {
            message += items[i].getQuantity() + " ";
            if (items[i].getQuantity() instanceof Double) {
                message += "lbs ";
            }
            message += items[i].getItem().getClass().getName();
            if (items[i].getQuantity() instanceof Integer) {
                Integer count = (Integer) items[i].getQuantity();
                if (count > 1) {
                    message += "s";
                }
            }
            message += "\n";
        }
        return message.trim();
    }
}
