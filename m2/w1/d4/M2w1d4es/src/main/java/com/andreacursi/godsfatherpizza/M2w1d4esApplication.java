package com.andreacursi.godsfatherpizza;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.andreacursi.godsfatherpizza.config.DrinksConfig;
import com.andreacursi.godsfatherpizza.config.FranchiseConfig;
import com.andreacursi.godsfatherpizza.config.PizzaConfig;
import com.andreacursi.godsfatherpizza.config.TableConfig;
import com.andreacursi.godsfatherpizza.config.ToppingsConfig;
import com.andreacursi.godsfatherpizza.dao.DrinksService;
import com.andreacursi.godsfatherpizza.dao.FranchiseService;
import com.andreacursi.godsfatherpizza.dao.PizzaService;
import com.andreacursi.godsfatherpizza.dao.TableService;
import com.andreacursi.godsfatherpizza.dao.ToppingsService;
import com.andreacursi.godsfatherpizza.entity.Drinks;
import com.andreacursi.godsfatherpizza.entity.Franchise;
import com.andreacursi.godsfatherpizza.entity.Pizza;
import com.andreacursi.godsfatherpizza.entity.Tavolo;
import com.andreacursi.godsfatherpizza.entity.Toppings;

@SpringBootApplication
public class M2w1d4esApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(M2w1d4esApplication.class, args);
	}

	@Autowired
	ToppingsService toSe;
//	ApplicationContext ctxTo = new AnnotationConfigApplicationContext(ToppingsConfig.class);
	
	@Autowired
	DrinksService drSe;
	ApplicationContext ctxDr = new AnnotationConfigApplicationContext(DrinksConfig.class);
	
	@Autowired
	FranchiseService fraSe;
//	ApplicationContext ctxFra = new AnnotationConfigApplicationContext(FranchiseConfig.class);
	
	@Autowired
	TableService taSe;
//	ApplicationContext ctxTa = new AnnotationConfigApplicationContext(TableConfig.class);
	
	@Autowired
	PizzaService piSe;
//	ApplicationContext ctxPi = new AnnotationConfigApplicationContext(PizzaConfig.class);
	
	@Override
	public void run(String... args) throws Exception {
		

		insertToppings();
//		((AnnotationConfigApplicationContext)ctxTo).close();
		
		insertDrinks();
//		((AnnotationConfigApplicationContext)ctxDr).close();
		
		insertFranchise();
//		((AnnotationConfigApplicationContext)ctxFra).close();
		
		insertTable();
//		((AnnotationConfigApplicationContext)ctxTa).close();
		
		insertPizza();
//		((AnnotationConfigApplicationContext)ctxPi).close();
		((AnnotationConfigApplicationContext)ctxDr).close();
		
	}
	
	public void insertToppings() {
		Toppings t0=(Toppings)ctxDr.getBean("t0");
		toSe.insert(t0);
		
		Toppings t1=(Toppings)ctxDr.getBean("t1");
		toSe.insert(t1);
		
		Toppings t2=(Toppings)ctxDr.getBean("t2");
		toSe.insert(t2);
		
		Toppings t3=(Toppings)ctxDr.getBean("t3");
		toSe.insert(t3);
		
		Toppings t4=(Toppings)ctxDr.getBean("t4");
		toSe.insert(t4);
		
		Toppings t5=(Toppings)ctxDr.getBean("t5");
		toSe.insert(t5);
	}
	
	public void insertDrinks() {
		Drinks d1=(Drinks)ctxDr.getBean("d1");
		drSe.insert(d1);
		
		Drinks d2=(Drinks)ctxDr.getBean("d2");
		drSe.insert(d2);
		
		Drinks d3=(Drinks)ctxDr.getBean("d3");
		drSe.insert(d3);
		
	}
	
	public void insertFranchise() {
		Franchise f1=(Franchise)ctxDr.getBean("f1");
		fraSe.insert(f1);
		
		Franchise f2=(Franchise)ctxDr.getBean("f2");
		fraSe.insert(f2);
	}
	
	public void insertTable() {
		Tavolo ta1=(Tavolo)ctxDr.getBean("ta1");
		taSe.insert(ta1);
	}
	
	public void insertPizza() {
		Pizza p1=(Pizza)ctxDr.getBean("p1");
		piSe.insert(p1);
		
		Pizza p2=(Pizza)ctxDr.getBean("p2");
		piSe.insert(p2);
		
		Pizza p3=(Pizza)ctxDr.getBean("p3");
		piSe.insert(p3);
	}

}
