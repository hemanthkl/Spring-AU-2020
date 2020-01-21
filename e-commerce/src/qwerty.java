import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class qwerty {
	public static void main(String[] args) {
		int exit=0;
		System.out.println("____________  Hello, Welcome to supermarket!!  ______________");
		System.out.println("------------------ How can i help u..?? ---------------------");
		start available = new start();
		cart obj = new cart();
		order ord_obj = new order(); 
		obj.initialise();
		while(exit!=3) {
		System.out.print("\n1:SHOW AVAILABLE ITEMS\n2:CANCEL ORDERS\n3:EXIT\n");
		Scanner scan = new Scanner(System.in);
		exit = scan.nextInt();
		switch(exit) {
		case 1:{
			int e=0;
			while(e!=3) {
				available.show();
				System.out.print("\n1:VIEW CART    2:ADD ITEM TO CART    3:EXIT\n");
				e=scan.nextInt();
				order:
				switch(e) {
				case 1:{
					int case1=0;
					while(case1!=1) {
					obj.show();
					System.out.print("\n1:GO BACK    2:DELETE ITEM FROM CART    3:PLACE ORDER\n");
					case1 = scan.nextInt();
					switch(case1) {
					case 2:{
							System.out.println("\nENTER PRODUCT ID TO DELETE");
							int id = scan.nextInt();
							obj.remove(id);
							System.out.println("\nSUCCESSFULLY DELETED");
							break;
							}
					case 3:{
						ord_obj.place(obj);
						ord_obj.show();
						available.reduce(obj,available);
						break order;	
						}
						}
					}
					break;
				}
				case 2:{
					System.out.println("\nENTER PRODUCT ID TO ADD");
					int id = scan.nextInt();
					obj.add(id);
					System.out.println("\nSUCCESSFULLY ADDED");
					break;
				}
				}
			}
			break;
		}
		case 2:{
			ord_obj.show();
			System.out.println("\n1:ENTER ORDER ID TO CANCEL ORDER");
			int can_ord = scan.nextInt();
			ord_obj.cancel(can_ord);
			break;
		}
		}	
		}
		System.out.println("Good bye,come back soon");
	}
}
class items{
	private int product_id;
	private String product_name;
	private int quantity;
	private int price;
	public items(int p_id,String p_name,int q,int price)
	{
		this.setProduct_id(p_id);
		this.setProduct_name(p_name);
		this.setQuantity(q);
		this.setPrice(price);
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity += quantity;
		if(this.quantity<0) {
			this.quantity=0;
		}
	}
	
	
}
class start{
	
	
	ArrayList<items> li = new ArrayList<items>();
	public start() {
		items onion = new items(1,"Onion ",90,100);
		items tomato = new items(2,"Tomato",80,25);
		items potato = new items(3,"Potato",80,20);
		items beans = new items(4,"Beans ",50,40);
		items peas = new items(5,"peas  ",30,100);
		li.add(onion);
		li.add(tomato);
		li.add(potato);
		li.add(beans);
		li.add(peas);
		
	}
	public void show() {
		System.out.println("\n--------------------------- ITEMS AVAILABLE -----------------------------\n");
		for(items i:li) {
			System.out.println("id =  "+i.getProduct_id()+"   :   "+"name =  "+i.getProduct_name()+"   :   "+"quantity =   "+i.getQuantity()+"   :   "+"price =   "+i.getPrice());
		}
		System.out.println("\n-------------------------------------------------------------------------\n");
	}
	public void reduce(cart obj,start objs) {
		for(items temp:objs.li) {
			temp.setQuantity(-obj.li_cart.get(temp.getProduct_id()).getQuantity());
		}
	}
}

class cart{
	Map<Integer,items> li_cart = new HashMap<Integer,items>();
	public void initialise() {
		items onion_cart = new items(1,"Onion",0,100);
		items tomato_cart = new items(2,"Tomato",0,25);
		items potato_cart = new items(3,"Potato",0,20);
		items beans_cart = new items(4,"Beans",0,40);
		items peas_cart = new items(5,"peas",0,100);
		li_cart.put(1,onion_cart);
		li_cart.put(2,tomato_cart);
		li_cart.put(3,potato_cart);
		li_cart.put(4,beans_cart);
		li_cart.put(5,peas_cart);
	}
	public void add(int id) {
		//items alter = li_cart.get(id);
		//alter.setQuantity(1);
		li_cart.get(id).setQuantity(1);
		//System.out.println(li_cart.get(id).getQuantity());
		//li_cart.replace(id,alter);
		
	}
	public void remove(int id) {
		li_cart.get(id).setQuantity(-1);
	}
	public void show() {
		int flag=0;
		System.out.println("\n-------------------------------- CART -----------------------------------\n");
	for(Map.Entry<Integer,items> entry:li_cart.entrySet()) {
		if(entry.getValue().getQuantity()!=0) {
			flag=1;
			items temp = entry.getValue();
			System.out.println("id =  "+temp.getProduct_id()+"   :   "+"name =  "+temp.getProduct_name()+"   :   "+"quantity =   "+temp.getQuantity()+"   :   "+"price =   "+temp.getPrice());
		}
	}	
	if(flag==0) {
			System.out.println("CART EMPTY\n");
		}	
		System.out.println("\n-------------------------------------------------------------------------\n");
}
}


class order{
	Map<Integer,cart> ord = new HashMap<Integer,cart>();
	static int order_id=1;
	public void place(cart obj)
	{	
		ord.put(order_id, obj);
		System.out.println("ORDER PLACED SUCCESSFULLY");
		order_id=order_id+1;
	}
	public void cancel(int can_id)
	{
		ord.remove(can_id);
		System.out.println("ORDER DELETED SUCCESSFULLY");
	}
	
	public void show(){
		int total_sum;
		for(Map.Entry<Integer, cart> o : ord.entrySet()) {
			System.out.println("\norder-id = "+o.getKey());
			System.out.println("-------------------------------- ITEMS-ORDERED -----------------------------------\n");
			total_sum=0;
			for(Map.Entry<Integer,items> entry:o.getValue().li_cart.entrySet()) {
				if(entry.getValue().getQuantity()!=0) {
					items temp = entry.getValue();
					total_sum+=temp.getPrice()*temp.getQuantity();
					System.out.println("id =  "+temp.getProduct_id()+"   :   "+"name =  "+temp.getProduct_name()+"   :   "+"quantity =   "+temp.getQuantity()+"   :   "+"price =   "+temp.getPrice());
				}
			}	
			System.out.println("\n-------------------------------------------------------------------------------\n"+"Total-price = "+total_sum);
		}
	}
}
