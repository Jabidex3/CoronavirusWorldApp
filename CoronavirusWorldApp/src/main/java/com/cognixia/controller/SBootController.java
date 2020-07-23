package com.cognixia.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.model.Country;

@RestController
@RequestMapping(value="/")
public class SBootController {
	private String[] country_names = {"Germany", "Greece", "Italy","China", "Japan", "United States"};
	private String[] capital_names = {"Berlin","Athens","Rome","Beijing","Tokyo","Washington DC"};
	private int[] country_pop = {83000000,11000000,60000000,1393000000,127000000,328200000} ;
	private int[] corona_cases = {204000,4048,245000,85921,27090,4004000} ;
	private List<Country> countryObj;
	
	public SBootController(){
		countryObj = new ArrayList<Country>();
		
		for (int i = 0; i < capital_names.length; i++) {
			Country c = new Country();
			c.setCname(country_names[i]);
			c.setCapname(capital_names[i]);
			c.setPopulation(country_pop[i]);
			c.setCoronaCases(corona_cases[i]);
			countryObj.add(c);
		}
	}
	
//	@GetMapping("hello")
//	public String hello() {
//		return "hello world";
//	}
	
	@GetMapping("index")
	public String home() {
		return "<h1>Welcome to the World App</h1><br><a href =\"http://localhost:8080/countries\"><button>View Countries</button></a>";
	}
	
	@GetMapping("countries")
	public String countriesListed() {
		String s ="<table border=1><tr><th>Country Name</th><th>Country Capital</th><th>Popuation</th><th>Total Coronavirus Cases</th></tr>";
		
		for (Country c : countryObj) {
			s+= "<tr><td>"+c.getCname()+"</td><td>"+c.getCapname()+"</td><td><a href =\"http://localhost:8080/countries/"+c.getCname()+"\"><button>Show Population</button></a></td><td>"+c.getCoronaCases()+"</td></tr>";
		}
		s+="</table>";
		return s;
	}
	
	@GetMapping("countries/{country_name}")
	public String printPop(@PathVariable String country_name)
	{
		int index=-1;
		for(int i =0;i<countryObj.size();i++) {
			if(countryObj.get(i).getCname().equals(country_name)) {
				index=i;
				break;
			}
		}
		if(index!=-1) {
			return "The population for <u>"+ countryObj.get(index).getCname() +"</u> is : <b>"+countryObj.get(index).getPopulation()+"</b> <br><a href =\"http://localhost:8080/countries\"><button>Back</button></a>";
		}
		else {
			return "You have entered a country that is not listed!<br><a href =\"http://localhost:8080/countries\"><button>Back</button></a>";
		}
		
	}
	
	@GetMapping("countries/compare/{country_name}/{country_name_two}")
	public String compareCoronaCases(@PathVariable String country_name,@PathVariable String country_name_two)
	{
		int indexOne=-1;
		int indexTwo=-1;
		for(int i =0;i<countryObj.size();i++) {
			if(countryObj.get(i).getCname().equals(country_name)) {
				indexOne=i;
				break;
			}
		}
		
		for(int i =0;i<countryObj.size();i++) {
			if(countryObj.get(i).getCname().equals(country_name_two)) {
				indexTwo=i;
				break;
			}
		}
		
		if(indexOne==-1 || indexTwo==-1) {
			return "You have entered a country that is not listed in this application!"+"<br><a href =\"http://localhost:8080/index\"><button>Back</button></a>";
		}
		else {
			String c1 = countryObj.get(indexOne).getCname();
			int CCase1 = countryObj.get(indexOne).getCoronaCases();
			String c2 = countryObj.get(indexTwo).getCname();
			int CCase2 = countryObj.get(indexTwo).getCoronaCases();
			
			if(CCase1<CCase2) {
				return c1 + " has "+ Integer.toString(CCase2-CCase1)+ " less cases than " + c2+"<br><a href =\"http://localhost:8080/index\"><button>Back</button></a>";
			}
			else if (CCase1==CCase2) {
				return "Both countries have the same amount of Coronavirus cases"+"<br><a href =\"http://localhost:8080/index\"><button>Back</button></a>";
			}
			else {
				return c1 + " has "+ Integer.toString(CCase1-CCase2)+ " more cases than " + c2 +"<br><a href =\"http://localhost:8080/index\"><button>Back</button></a>";
			}
		}
	}
}
