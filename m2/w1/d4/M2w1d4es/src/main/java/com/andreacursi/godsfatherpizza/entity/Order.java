package com.andreacursi.godsfatherpizza.entity;

import java.util.List;
import java.util.Map;

import com.andreacursi.godsfatherpizza.model.State;

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
public class Order {

	private int id;
	private State state;
	private Map<String, Pizza> orderPizza;
	private List<Toppings> toppings;
	private Map<String, Drinks> orderDrinks;
	private Map<String, Franchise> orderFranchise;
	private Tavolo table;
	private int people;
	private int coperto;
	
}
