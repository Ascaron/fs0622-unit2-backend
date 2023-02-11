package com.andreacursi.godsfatherpizza.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.andreacursi.godsfatherpizza.entity.Toppings;

//@Configuration
public class ToppingsConfig {

//	@Bean
//	@Scope("prototype")
//	public Toppings t0() {
//		Toppings t=Toppings.builder()
//				.name("Tomato")
//				.calories(0)
//				.price(0)
//				.build();
//		return t;
//	}
//	
//	@Bean
//	@Scope("prototype")
//	public Toppings t1() {
//		Toppings t=Toppings.builder()
//				.name("Cheese")
//				.calories(92)
//				.price(0.69)
//				.build();
//		return t;
//	}
//	
//	@Bean
//	@Scope("prototype")
//	public Toppings t2() {
//		Toppings t=Toppings.builder()
//				.name("Ham")
//				.calories(35)
//				.price(0.99)
//				.build();
//		return t;
//	}
//	
//	@Bean
//	@Scope("prototype")
//	public Toppings t3() {
//		Toppings t=Toppings.builder()
//				.name("Onions")
//				.calories(22)
//				.price(0.69)
//				.build();
//		return t;
//	}
//	
//	@Bean
//	@Scope("prototype")
//	public Toppings t4() {
//		Toppings t=Toppings.builder()
//				.name("Pineapple")
//				.calories(24)
//				.price(0.79)
//				.build();
//		return t;
//	}
//	
//	@Bean
//	@Scope("prototype")
//	public Toppings t5() {
//		Toppings t=Toppings.builder()
//				.name("Salami")
//				.calories(86)
//				.price(0.99)
//				.build();
//		return t;
//	}
//	
//	//TOPPINGS MIX
//			@Bean
//			@Scope("prototype")
//			public List<Toppings> lt1(){
//				 List<Toppings> lt1=new ArrayList<Toppings>();
//				 lt1.add(t0());
//				 lt1.add(t1());
//				 return lt1;
//				 
//			}
//			
//			@Bean
//			@Scope("prototype")
//			public List<Toppings> lt2(){
//				 List<Toppings> lt2=new ArrayList<Toppings>();
//				 lt2.addAll(lt1());
//				 lt2.add(t2());
//				 lt2.add(t4());
//				 return lt2;
//				 
//			}
//			
//			@Bean
//			@Scope("prototype")
//			public List<Toppings> lt3(){
//				 List<Toppings> lt3=new ArrayList<Toppings>();
//				 lt3.addAll(lt1());
//				 lt3.add(t5());
//				 return lt3;
//				 
//			}
	
}
