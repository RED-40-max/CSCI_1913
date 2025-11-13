public class ProduceQuantity <T extends Produce, U> {
    private T item;
    private U unit;

    public ProduceQuantity(T item, U unit) {
        this.item = item;
        this.unit = unit;
    }

    public T getItem() {
        return item;
    }
    public U getQuantity() {
        return unit;
    }

    public boolean getInfo() {
        return item.isWeighted();
    }

}