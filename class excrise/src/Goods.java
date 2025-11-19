public class Goods {
    private String goodsName;
    private int ID;
    private double price;
    public Goods(String goodsName, double price) {
        this.goodsName = goodsName;
        this.price = price;
        ID = generateID();
    }
    private int generateID() {
        return ID = (int) Math.floor(Math.random() * 100) + 1;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
