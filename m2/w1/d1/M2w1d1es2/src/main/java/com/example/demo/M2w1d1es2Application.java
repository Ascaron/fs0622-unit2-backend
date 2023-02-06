package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.andreacursi.epicode.pizzeria.config_bean.Configuration;
import com.andreacursi.epicode.pizzeria.config_bean.Drinks;
import com.andreacursi.epicode.pizzeria.config_bean.Franchise;
import com.andreacursi.epicode.pizzeria.config_bean.Pizza;
import com.andreacursi.epicode.pizzeria.config_bean.Toppings;

@SpringBootApplication
public class M2w1d1es2Application {

	public static void main(String[] args) {
		SpringApplication.run(M2w1d1es2Application.class, args);
		System.out.println("");
		System.out.println("");
		menu();
	}
	
	public static void menu() {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(Configuration.class);
		System.out.println("PIZZAS");
		Pizza p1=(Pizza)ctx.getBean("p1");
		System.out.println(p1.getName()+" ("+p1.getTopping().get(0).getName()+" "
		+p1.getTopping().get(1).getName()+") "+p1.getCalories()+" "+p1.getPrice());
		System.out.println("");
		
		Pizza p2=(Pizza)ctx.getBean("p2");
		System.out.println(p2.getName()+" ("+p2.getTopping().get(0).getName()+" "+
		p2.getTopping().get(1).getName()+" "+p2.getTopping().get(2).getName()+" "+
		p2.getTopping().get(3).getName()+") "+p2.getCalories()+" "+p2.getPrice());
		System.out.println("");
		
		Pizza p3=(Pizza)ctx.getBean("p3");
		System.out.println(p3.getName()+" ("+p3.getTopping().get(0).getName()+" "+
		p3.getTopping().get(1).getName()+" "+p3.getTopping().get(2).getName()+
		") "+p3.getCalories()+" "+p3.getPrice());
		System.out.println("");
		System.out.println("");
		System.out.println("");
		
		System.out.println("TOPPINGS");
		Toppings t1=(Toppings)ctx.getBean("t1");
		System.out.println(t1.getName()+" "+t1.getCalories()+" "+t1.getPrice());
		System.out.println("");
		Toppings t2=(Toppings)ctx.getBean("t2");
		System.out.println(t2.getName()+" "+t2.getCalories()+" "+t2.getPrice());
		System.out.println("");
		Toppings t3=(Toppings)ctx.getBean("t3");
		System.out.println(t3.getName()+" "+t3.getCalories()+" "+t3.getPrice());
		System.out.println("");
		Toppings t4=(Toppings)ctx.getBean("t4");
		System.out.println(t4.getName()+" "+t4.getCalories()+" "+t4.getPrice());
		System.out.println("");
		Toppings t5=(Toppings)ctx.getBean("t5");
		System.out.println(t5.getName()+" "+t5.getCalories()+" "+t5.getPrice());
		System.out.println("");
		
		
		System.out.println("");
		System.out.println("");
		System.out.println("");
		
		System.out.println("DRINKS");
		Drinks d1=(Drinks)ctx.getBean("d1");
		System.out.println(d1.getName()+" "+d1.getCalories()+" "+d1.getPrice());
		System.out.println("");
		
		Drinks d2=(Drinks)ctx.getBean("d2");
		System.out.println(d2.getName()+" "+d2.getCalories()+" "+d2.getPrice());
		System.out.println("");
		
		Drinks d3=(Drinks)ctx.getBean("d3");
		System.out.println(d3.getName()+" "+d3.getCalories()+" "+d3.getPrice());
		System.out.println("");
		System.out.println("");
		System.out.println("");
		
		System.out.println("FRANCHISE");
		Franchise f1=(Franchise)ctx.getBean("f1");
		System.out.println(f1.getName()+" "+f1.getPrice());
		System.out.println("");
		
		Franchise f2=(Franchise)ctx.getBean("f2");
		System.out.println(f2.getName()+" "+f2.getPrice());
		System.out.println("");
		((AnnotationConfigApplicationContext)ctx).close();
	}

}
