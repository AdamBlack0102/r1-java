import java.util.ArrayList;

public class DonutShop extends Shop implements Nameable{
    String companyName;

    public DonutShop(){

        companyName = "Sweat Donut";
        Item i1 = new Item("Donuts",1.0);
        Item i2 = new Item("Muffins",1.5);
        Item i3 = new Item("Danish",2.0);
        Item i4 = new Item("Coffee",2.5);
        Item i5 = new Item("Tea",3.0);

        menuItems.add(i1);
        menuItems.add(i2);
        menuItems.add(i3);
        menuItems.add(i4);
        menuItems.add(i5);

        //todo:add code here
        //set the calculator

    }

    ArrayList<Item> menuItems = new ArrayList<Item>();

    public void addItem(Item i){
        menuItems.add(i);
    }
    public ArrayList<Item> getInventory(){
        return menuItems;
    }
    public boolean buyInventory(String name ){
        //todo:add code here


        return false;
    }
    public String getName(){
        //todo:add code here
        return "";
    }
    public void setName(String name){
        companyName = name;
    }
}
