package com.andreacursi.godsfatherpizza.config_bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

@org.springframework.context.annotation.Configuration
@PropertySource("classpath:application.properties")
public class Configuration {

	//TOPPINGS
		@Bean
		@Scope("prototype")
		public Toppings t0() {
			return new Toppings("Tomato", 0, 0);
		}
		
		@Bean
		@Scope("prototype")
		public Toppings t1() {
			return new Toppings("Cheese", 92, 0.69);
		}
		
		@Bean
		@Scope("prototype")
		public Toppings t2() {
			return new Toppings("Ham", 35, 0.99);
		}
		
		@Bean
		@Scope("prototype")
		public Toppings t3() {
			return new Toppings("Onions", 22, 0.69);
		}
		
		@Bean
		@Scope("prototype")
		public Toppings t4() {
			return new Toppings("Pineapple", 24, 0.79);
		}
		
		@Bean
		@Scope("prototype")
		public Toppings t5() {
			return new Toppings("Salami", 86, 0.99);
		}
		
		//TOPPINGS MIX
		@Bean
		@Scope("prototype")
		public List<Toppings> lt1(){
			 List<Toppings> lt1=new ArrayList<Toppings>();
			 lt1.add(t0());
			 lt1.add(t1());
			 return lt1;
			 
		}
		
		@Bean
		@Scope("prototype")
		public List<Toppings> lt2(){
			 List<Toppings> lt2=new ArrayList<Toppings>();
			 lt2.addAll(lt1());
			 lt2.add(t2());
			 lt2.add(t4());
			 return lt2;
			 
		}
		
		@Bean
		@Scope("prototype")
		public List<Toppings> lt3(){
			 List<Toppings> lt3=new ArrayList<Toppings>();
			 lt3.addAll(lt1());
			 lt3.add(t5());
			 return lt3;
			 
		}
		
		//PIZZAS
		
		@Bean
		@Scope("prototype")
		public Pizza p1() {
			return new Pizza("Pizza Margherita", lt1(), 1104, 4.99);
		}
		
		@Bean
		@Scope("prototype")
		public Pizza p2() {
			return new Pizza("Hawaiian Pizza", lt2(), 1024, 6.49);
		}
		
		@Bean
		@Scope("prototype")
		public Pizza p3() {
			return new Pizza("Salami Pizza", lt3(), 1160, 5.99);
		}
		
		//DRINKS
		
		@Bean
		@Scope("prototype")
		public Drinks d1() {
			return new Drinks("Lemonade", 128, 1.29);
		}
		
		@Bean
		@Scope("prototype")
		public Drinks d2() {
			return new Drinks("Water", 0, 1.29);
		}
		
		@Bean
		@Scope("prototype")
		public Drinks d3() {
			return new Drinks("Wine", 607, 7.49);
		}
		
		//FRANCHISE
		
		@Bean
		@Scope("prototype")
		public Franchise f1() {
			return new Franchise("Shirt", 21.99);
		}
		
		@Bean
		@Scope("prototype")
		public Franchise f2() {
			return new Franchise("Mug", 4.99);
		}
		
		@Value("${order.coperto}")
		private int cop;
		
		//ORDER
		@Bean
		@Scope("prototype")
		public Order o1() {
			int id=555;
			State state=State.READY;
			
			List<Toppings> lt= new ArrayList<Toppings>();
			lt.add(t4());
			lt.add(t5());
			Pizza p1=new Pizza("Pizza Margherita", lt, 1104, 4.99);
			String st1=new String("Very good");
			
			List<Toppings> lt1= new ArrayList<Toppings>();
			lt1.add(t3());
			Pizza p2=new Pizza("Pizza Margherita", lt1, 1104, 4.99);
			String st2=new String("Bad");
			
			List<Toppings> lt2= new ArrayList<Toppings>();
			Pizza p3=new Pizza("Pizza Margherita", lt2, 1104, 4.99);
			String st3=new String("It's ok");
			
			List<Toppings> ltt= new ArrayList<Toppings>();
			ltt.addAll(lt);
			ltt.addAll(lt1);
			ltt.addAll(lt2);
			
			Map<String, Pizza> op= new HashMap<String, Pizza>();
			op.put(st1, p1);
			op.put(st2, p2);
			op.put(st3, p3);
			Map<String, Drinks> od= new HashMap<String, Drinks>();
			od.put("So refreshing", d1());
			od.put("Red", d3());
			Map<String, Franchise> of= new HashMap<String, Franchise>();
			of.put("Beautiful", f1());
			
			Table t1=new Table(4, 4, true);
			int people=3;
			return new Order(id, state, op, lt, od, of, t1, people, cop);
		}
	
}
