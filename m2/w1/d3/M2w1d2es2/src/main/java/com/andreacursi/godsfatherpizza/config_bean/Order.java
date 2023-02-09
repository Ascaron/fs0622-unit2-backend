package com.andreacursi.godsfatherpizza.config_bean;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Scope("prototype")
public class Order {

	private int id;
	private State state;
	private Map<String, Pizza> orderPizza;
	private List<Toppings> toppings;
	private Map<String, Drinks> orderDrinks;
	private Map<String, Franchise> orderFranchise;
	private Table table;
	private int people;
	private int coperto;
	
	//FOOD
	
	public double listPizzaPrice(List<Double> pri) {
		getOrderPizza().forEach((k, v) -> {
			double sum = v.getPrice();
			pri.add(sum);
		});
		double sum = 0;
		for (int i = 0; i < pri.size(); i++) {
			sum += pri.get(i);
		}
		return sum;
	}

	public int listPizzaCalories(List<Integer> cal) {
		getOrderPizza().forEach((k, v) -> {
			int sum = v.getCalories();
			cal.add(sum);
		});
		int sum = 0;
		for (int i = 0; i < cal.size(); i++) {
			sum += cal.get(i);
		}
		return sum;
	}
	
	//TOPPINGS
	
	public double listToppingsPrice(List<Double> pri) {
		getToppings().forEach((t)->{
			double sum=t.getPrice();
			pri.add(sum);
		});
		double sum = 0;
		for (int i = 0; i < pri.size(); i++) {
			sum += pri.get(i);
		}
		return sum;
	}

	public int listToppingsCalories(List<Integer> cal) {
		getToppings().forEach((t)->{
			int sum=t.getCalories();
			cal.add(sum);
		});
		int sum = 0;
		for (int i = 0; i < cal.size(); i++) {
			sum += cal.get(i);
		}
		return sum;
	}
	
	//DRINKS
	public double listDrinksPrice(List<Double> pri) {
		getOrderDrinks().forEach((k, v) -> {
			double sum = v.getPrice();
			pri.add(sum);
		});
		double sum = 0;
		for (int i = 0; i < pri.size(); i++) {
			sum += pri.get(i);
		}
		return sum;
	}

	public int listDrinksCalories(List<Integer> cal) {
		getOrderDrinks().forEach((k, v) -> {
			int sum = v.getCalories();
			cal.add(sum);
		});
		int sum = 0;
		for (int i = 0; i < cal.size(); i++) {
			sum += cal.get(i);
		}
		return sum;
	}
	
	//FRANCHISE
	public double listFranchisePrice(List<Double> pri) {
		getOrderFranchise().forEach((k, v) -> {
			double sum = v.getPrice();
			pri.add(sum);
		});
		double sum = 0;
		for (int i = 0; i < pri.size(); i++) {
			sum += pri.get(i);
		}
		return sum;
	}
	
}
