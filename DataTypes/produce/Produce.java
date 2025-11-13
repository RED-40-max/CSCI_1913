public abstract class Produce {
    private double price;

    public Produce(double price) {
        this.price = price;
    }

    public abstract boolean isWeighted();
}
