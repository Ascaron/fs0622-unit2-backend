package com.andreacursi.godsfatherpizza.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.andreacursi.godsfatherpizza.entity.Drinks;
import com.andreacursi.godsfatherpizza.entity.Franchise;
import com.andreacursi.godsfatherpizza.entity.Pizza;
import com.andreacursi.godsfatherpizza.entity.Tavolo;
import com.andreacursi.godsfatherpizza.entity.Toppings;

@Configuration
public class DrinksConfig {

	// DRINKS

	@Bean
	@Scope("prototype")
	public Drinks d1() {
		Drinks d = Drinks.builder().name("Lemonade").calories(128).price(1.29).build();
		return d;
	}

	@Bean
	@Scope("prototype")
	public Drinks d2() {
		Drinks d = Drinks.builder().name("Water").calories(0).price(1.29).build();
		return d;
	}

	@Bean
	@Scope("prototype")
	public Drinks d3() {
		Drinks d = Drinks.builder().name("Wine").calories(607).price(7.49).build();
		return d;
	}

	// FRANCHISE

	@Bean
	@Scope("prototype")
	public Franchise f1() {
		Franchise f = Franchise.builder().name("Shirt").price(21.99).build();
		return f;
	}

	@Bean
	@Scope("prototype")
	public Franchise f2() {
		Franchise f = Franchise.builder().name("Mug").price(4.99).build();
		return f;
	}

	// PIZZA

//	@Autowired
//	ToppingsConfig toCon;

	@Bean
	@Scope("prototype")
	public Pizza p1() {
		Pizza p = Pizza.builder().name("Pizza Margherita").topping(lt1()).calories(1104).price(4.99).build();
		return p;
	}

	@Bean
	@Scope("prototype")
	public Pizza p2() {
		Pizza p = Pizza.builder().name("Hawaiian Pizza").topping(lt2()).calories(1024).price(6.49).build();
		return p;
	}

	@Bean
	@Scope("prototype")
	public Pizza p3() {
		Pizza p = Pizza.builder().name("Salami Pizza").topping(lt3()).calories(1160).price(5.99).build();
		return p;
	}

	// TOPPINGS

	@Bean
	@Scope("prototype")
	public Toppings t0() {
		Toppings t = Toppings.builder().name("Tomato").calories(0).price(0).build();
		return t;
	}

	@Bean
	@Scope("prototype")
	public Toppings t1() {
		Toppings t = Toppings.builder().name("Cheese").calories(92).price(0.69).build();
		return t;
	}

	@Bean
	@Scope("prototype")
	public Toppings t2() {
		Toppings t = Toppings.builder().name("Ham").calories(35).price(0.99).build();
		return t;
	}

	@Bean
	@Scope("prototype")
	public Toppings t3() {
		Toppings t = Toppings.builder().name("Onions").calories(22).price(0.69).build();
		return t;
	}

	@Bean
	@Scope("prototype")
	public Toppings t4() {
		Toppings t = Toppings.builder().name("Pineapple").calories(24).price(0.79).build();
		return t;
	}

	@Bean
	@Scope("prototype")
	public Toppings t5() {
		Toppings t = Toppings.builder().name("Salami").calories(86).price(0.99).build();
		return t;
	}

	// TOPPINGS MIX
	@Bean
	@Scope("prototype")
	public List<Toppings> lt1() {
		List<Toppings> lt1 = new ArrayList<Toppings>();
		lt1.add(t0());
		lt1.add(t1());
		return lt1;

	}

	@Bean
	@Scope("prototype")
	public List<Toppings> lt2() {
		List<Toppings> lt2 = new ArrayList<Toppings>();
		lt2.addAll(lt1());
		lt2.add(t2());
		lt2.add(t4());
		return lt2;

	}

	@Bean
	@Scope("prototype")
	public List<Toppings> lt3() {
		List<Toppings> lt3 = new ArrayList<Toppings>();
		lt3.addAll(lt1());
		lt3.add(t5());
		return lt3;

	}

	// TABLE

	@Bean
	@Scope("prototype")
	public Tavolo ta1() {
		Tavolo t = Tavolo.builder().name("Tavolo1").seat(4).free(true).build();
		return t;
	}

}
