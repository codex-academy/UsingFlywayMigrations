public class Pizza {

    public Pizza() {
    }

    public Pizza(String type, String size, Double price) {
        this.type = type;
        this.size = size;
        this.price = price;
    }

    private String type;
    private String size;
    private Double price;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "type='" + type + '\'' +
                ", size='" + size + '\'' +
                ", price=" + price +
                '}';
    }
}
