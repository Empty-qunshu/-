public class StoreHouse {
    private Goods[] goodsList;
    private int amount;
    private int capacity;

    public StoreHouse(int capacity) {
        this.capacity = capacity;
        this.goodsList = new Goods[capacity];
        this.amount = 0;
    }

    public void stockln(String name, double price) {
        if (amount < capacity) {
            Goods goods= new Goods(name, price);
            goods.generateID();
            goodsList[amount++] = goods;
        }else {
            System.out.println("仓库已满");
        }
        }


    }

}
