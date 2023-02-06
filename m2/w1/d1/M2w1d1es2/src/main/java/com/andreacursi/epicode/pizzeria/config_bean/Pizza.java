package com.andreacursi.epicode.pizzeria.config_bean;

import java.util.List;

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
public class Pizza {

	private String name;
	private List<Toppings> topping;
	private int calories;
	private double price;
	
}
