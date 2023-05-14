import java.util.ArrayList;
import java.util.ListIterator;

class Item {
	private String productName;
	private double unitPrice;
	Item(String productName, double unitPrice) {
		this.productName = productName;
		this.unitPrice = unitPrice;
	}
	public String toString() {
		String s = this.productName + ":";
		return s;
	}
	public String getProductName() {
		return this.productName;
	}
	
	public double getUnitPrice() {
		return this.unitPrice;
	}
}

class InfoCart{
	ArrayList<Item> item;
	double totalBalance;
	double printInvoice;

	InfoCart(){
		this.item = new ArrayList<Item>();
	}

	public double getTotalBalance() {
		ListIterator<Item> iterator2 = item.listIterator();
		this.totalBalance = 0;
		while(iterator2.hasNext()) {
			Item item3 = iterator2.next();
			this.totalBalance = this.totalBalance + (item3.getUnitPrice());
		}
		return this.totalBalance;
	}
	public void printInvoice() {
		ListIterator<Item> iterator3 = item.listIterator();
		while(iterator3.hasNext()) {
			Item item4 = iterator3.next();
			System.out.print(item4.getProductName() + "\t");
			System.out.print(item4.getUnitPrice() + "\t");
			System.out.println(item4.getUnitPrice());
		}
		System.out.println("\t\t\t" + "Total    : " + this.getTotalBalance());
	}
	public void addToCart(Item item) {
		this.item.add(item);
	}
	public void showCart() {
		ListIterator<Item> iterator = item.listIterator();
		while(iterator.hasNext()) {
			Item item1 = iterator.next();
			System.out.print(item1.getProductName() + "\t\t");
			System.out.println(item1.getUnitPrice());
		}
	}
	public void removeFromCart(Item i) {
		ListIterator<Item> iterator1 = item.listIterator();
		while(iterator1.hasNext()) {
			Item item2 = iterator1.next();
			if (item2.getProductName().equals(i.getProductName())) {
				this.item.remove(i);
				break;
			}
		}
	}
	public void thesize(){
		System.out.println("NUMBER OF ITEMS: " + this.item.size());
	}
}
	
public class ShoppingCart{

	public static void main(String[] args){
	  Item i1 = new Item("Olive Oil 1l", 100.0);
	  Item i2 = new Item("Cheese Slices", 50.0);
	  Item i3 = new Item("Bread",75.0);
	  Item i4 = new Item("Eggs", 10.0);
	  Item i5 = new Item("Chicken Salami", 100.0);
	  
	  InfoCart cart = new InfoCart();
	  
	  cart.addToCart(i1);
	  cart.addToCart(i2);
	  cart.addToCart(i3);
	  cart.addToCart(i4);
	  cart.addToCart(i5);
	  
	  System.out.println("LIST OF ITEMS: \n");
	  cart.showCart();
	   
	  double totalAmount = cart.getTotalBalance();
	  System.out.println("TOTAL BALANCE: "+ totalAmount);

	  cart.thesize();
	}
}

