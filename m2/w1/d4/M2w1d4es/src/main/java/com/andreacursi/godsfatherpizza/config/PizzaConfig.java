package com.andreacursi.godsfatherpizza.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.andreacursi.godsfatherpizza.entity.Pizza;

//@Configuration
public class PizzaConfig {

//	@Autowired
//	ToppingsConfig toCon;
//	
//	@Bean
//	@Scope("prototype")
//	public Pizza p1() {
//		Pizza p=Pizza.builder()
//				.name("Pizza Margherita")
//				.topping(toCon.lt1())
//				.calories(1104)
//				.price(4.99)
//				.build();
//		return p;
//	}
//	
//	@Bean
//	@Scope("prototype")
//	public Pizza p2() {
//		Pizza p=Pizza.builder()
//				.name("Hawaiian Pizza")
//				.topping(toCon.lt2())
//				.calories(1024)
//				.price(6.49)
//				.build();
//		return p;
//	}
//	
//	@Bean
//	@Scope("prototype")
//	public Pizza p3() {
//		Pizza p=Pizza.builder()
//				.name("Salami Pizza")
//				.topping(toCon.lt3())
//				.calories(1160)
//				.price(5.99)
//				.build();
//		return p;
//	}

}
