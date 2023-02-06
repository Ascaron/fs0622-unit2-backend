package com.andreacursi.epicode.pizzeria.config_component;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Component("create_pizza")
@Scope("prototype")
public class CreatePizza {
	
	private List<Integer> calories;
	private List<Double> prices;

	public int calories() {
		int sum = 0;
		for(int i=0; i<=calories.size(); i++) {
			sum+=calories.get(i);
		}
		return sum;
	}
	
	public double price() {
		int sum = 0;
		for(int i=0; i<=prices.size(); i++) {
			sum+=prices.get(i);
		}
		return sum;
	}
	
}
