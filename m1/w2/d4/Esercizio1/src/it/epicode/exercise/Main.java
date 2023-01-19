package it.epicode.exercise;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		
		LocalDate primaData = LocalDate.of(2021, 2, 1);
		LocalDate secondaData = LocalDate.of(2021, 4, 1);
		
		LocalDate dataOrdine1 = LocalDate.of(2021, 2, 5);
		LocalDate dataOrdine2 = LocalDate.of(2021, 2, 10);
		LocalDate dataOrdine3 = LocalDate.of(2020, 1, 5);
		LocalDate dataInvio1 = LocalDate.of(2021, 3, 5);
		LocalDate dataInvio2 = LocalDate.of(2021, 3, 5);
		LocalDate dataInvio3 = LocalDate.of(2021, 3, 5);

		Product book1 = new Product(123, "Bibbia", "Books", 120);
		Product book2 = new Product(123, "Corano", "Books", 120);
		Product book3 = new Product(123, "L' arte della guerra", "Books", 150);
		Product book4 = new Product(123, "Silmarillion", "Books", 200);
		Product book5 = new Product(123, "Candido", "Books", 50);
		Product baby1 = new Product(123, "Passeggino", "Baby", 200);
		Product baby2 = new Product(123, "Biberon", "Baby", 25);
		Product baby3 = new Product(123, "Ciuccio", "Baby", 15);
		Product boy1 = new Product(123, "Macchinina", "Boys", 30);
		Product boy2 = new Product(123, "Boxer", "Boys", 20);
		Product boy3 = new Product(123, "Calzini", "Boys", 5);
		
		ArrayList<Product> products = new ArrayList<Product>();
		products.add(book1);
		products.add(book2);
		products.add(book3);
		products.add(book4);
		products.add(book5);
		products.add(baby1);
		products.add(baby2);
		products.add(baby3);
		products.add(boy1);
		products.add(boy2);
		products.add(boy3);

		Customer customer1 = new Customer(123, "Pietro", 1);
		Customer customer2 = new Customer(123, "Gianni", 2);
		Customer customer3 = new Customer(123, "Pino", 2);
		Customer customer4 = new Customer(123, "Nina", 3);
		
		ArrayList<Product> productsOrder1 = new ArrayList<Product>();
		productsOrder1.add(baby1);
		Order order1= new Order(015, "Delivered1", dataOrdine1, dataInvio1, productsOrder1, customer1);
		ArrayList<Product> productsOrder2 = new ArrayList<Product>();
		productsOrder1.add(baby2);
		Order order2= new Order(016, "Delivered2", dataOrdine2, dataInvio2, productsOrder2, customer2);
		ArrayList<Product> productsOrder3 = new ArrayList<Product>();
		productsOrder1.add(baby3);
		Order order3= new Order(017, "Delivered3", dataOrdine3, dataInvio3, productsOrder3, customer3);
		
		ArrayList<Order> orders = new ArrayList<Order>();
		orders.add(order1);
		orders.add(order2);
		orders.add(order3);


		// Primo Esercizio
		System.out.println(" ");
		System.out.println("Primo Esercizio");
		System.out.println(" ");
		Stream<Product> productsStream = products.stream().filter((product) -> product.getPrice() > 100);

		ArrayList<Product> productsExpensive = new ArrayList<Product>();
		productsStream.forEach(product -> {
			productsExpensive.add(product);
		});

		Stream<Product> booksStream = productsExpensive.stream().filter((product) -> product.getCategory() == "Books");

		booksStream.forEach(product -> {
			System.out.println(product.getName() + " " + product.getPrice());
		});
		
		//Secondo Esercizio
		System.out.println(" ");
		System.out.println("Secondo Esercizio");
		System.out.println(" ");
		Stream<Order> ordersStream = orders.stream().filter((order) -> order.getProducts().contains(baby2));
		ordersStream.forEach(order->{
			System.out.println(order.getStatus());
		});
		

		// Terzo Esercizio
		System.out.println(" ");
		System.out.println("Terzo Esercizio");
		System.out.println(" ");
		Stream<Product> boysStream = products.stream().filter((product) -> product.getCategory() == "Boys");

		boysStream.forEach(product -> {
			System.out.println(product.getName() + " " + (product.getPrice() * 0.9));
		});
		
		
		//Quarto Esercizio
		System.out.println(" ");
		System.out.println("Quarto Esercizio");
		System.out.println(" ");
		Stream<Order> orders2Stream = orders.stream().filter((order) -> order.getOrderDate().isAfter(primaData));
		ArrayList<Order> ordersNext = new ArrayList<Order>();
		orders2Stream.forEach(order->{
			ordersNext.add(order);
		});
		
		Stream<Order> orders3Stream = ordersNext.stream().filter((order) -> order.getOrderDate().isBefore(secondaData));
		ArrayList<Order> orders2Next = new ArrayList<Order>();
		orders3Stream.forEach(order->{
			orders2Next.add(order);
		});
		
		Stream<Order> orders4Stream = orders2Next.stream().filter((order) -> order.getCustomer().getTier().equals(2));
		orders4Stream.forEach(order->{
			System.out.println(order.getStatus());
		});
		

	}

}