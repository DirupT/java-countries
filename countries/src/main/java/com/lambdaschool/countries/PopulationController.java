package com.lambdaschool.countries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/population")
public class PopulationController
{
	@GetMapping("/size/{people}")
	public ResponseEntity<?> getCountriesByPopulation(@PathVariable int people)
	{
		ArrayList<Country> rtnList = CountriesApplication.ourCountryList.findCountries(c -> c.getPopulation() >= people);
		return new ResponseEntity<>(rtnList, HttpStatus.OK);
	}

	@GetMapping("/size/min")
	public ResponseEntity<?> getSmallestCountryByPopulation()
	{
		Country smallestCountry = CountriesApplication.ourCountryList.findSmallestCountryByPopulation();
		return new ResponseEntity<>(smallestCountry, HttpStatus.OK);
	}
}
