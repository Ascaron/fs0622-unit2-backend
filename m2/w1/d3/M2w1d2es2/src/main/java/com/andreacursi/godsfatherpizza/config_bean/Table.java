package com.andreacursi.godsfatherpizza.config_bean;

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
public class Table {

	private int id;
	private int seat;
	private boolean free;
	
}
