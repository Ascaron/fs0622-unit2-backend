package com.andreacursi.epicode.pizzeria.config_bean;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;

public class Configuration {

	//TOPPINGS
	@Bean
	public Toppings t0() {
		return new Toppings("Tomato", 0, 0);
	}
	
	@Bean
	public Toppings t1() {
		return new Toppings("Cheese", 92, 0.69);
	}
	
	@Bean
	public Toppings t2() {
		return new Toppings("Ham", 35, 0.99);
	}
	
	@Bean
	public Toppings t3() {
		return new Toppings("Onions", 22, 0.69);
	}
	
	@Bean
	public Toppings t4() {
		return new Toppings("Pineapple", 24, 0.79);
	}
	
	@Bean
	public Toppings t5() {
		return new Toppings("Salami", 86, 0.99);
	}
	
	//TOPPINGS MIX
	@Bean
	public List<Toppings> lt1(){
		 List<Toppings> lt1=new ArrayList<Toppings>();
		 lt1.add(t0());
		 lt1.add(t1());
		 return lt1;
		 
	}
	
	@Bean
	public List<Toppings> lt2(){
		 List<Toppings> lt2=new ArrayList<Toppings>();
		 lt2.addAll(lt1());
		 lt2.add(t2());
		 lt2.add(t4());
		 return lt2;
		 
	}
	
	@Bean
	public List<Toppings> lt3(){
		 List<Toppings> lt3=new ArrayList<Toppings>();
		 lt3.addAll(lt1());
		 lt3.add(t5());
		 return lt3;
		 
	}
	
	//PIZZAS
	
	@Bean
	public Pizza p1() {
		return new Pizza("Pizza Margherita", lt1(), 1104, 4.99);
	}
	
	@Bean
	public Pizza p2() {
		return new Pizza("Hawaiian Pizza", lt2(), 1104, 4.99);
	}
	
	@Bean
	public Pizza p3() {
		return new Pizza("Salami Pizza", lt3(), 1104, 4.99);
	}
	
	//DRINKS
	
	@Bean
	public Drinks d1() {
		return new Drinks("Lemonade", 128, 1.29);
	}
	
	@Bean
	public Drinks d2() {
		return new Drinks("Water", 0, 1.29);
	}
	
	@Bean
	public Drinks d3() {
		return new Drinks("Wine", 607, 7.49);
	}
	
	//FRANCHISE
	
	@Bean
	public Franchise f1() {
		return new Franchise("Shirt", 21.99);
	}
	
	@Bean
	public Franchise f2() {
		return new Franchise("Mug", 4.99);
	}
	
}
