package com.solvd.block3.services;

import com.solvd.block3.models.Country;

public class SomeClass {
	public static void main(String[] args) {
		CountryServiceMyBatis cs = new CountryServiceMyBatis();
		Country c = cs.getCountry(1);
		System.out.println(c);
	}
}
