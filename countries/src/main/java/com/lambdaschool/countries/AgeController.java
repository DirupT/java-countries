package com.lambdaschool.countries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/age")
public class AgeController
{
	// localhost:8080/age/age/40
	@GetMapping("/age/{age}")
	public ResponseEntity<?> getCountriesByMedianAge(@PathVariable int age)
	{
		ArrayList<Country> rtnList = CountriesApplication.ourCountryList.findCountries(c -> c.getMedianAge() >= age);
		return new ResponseEntity<>(rtnList, HttpStatus.OK);
	}

	// localhost:8080/age/min
	@GetMapping("/min")
	public ResponseEntity<?> getSmallestCountryByMedianAge()
	{
		Country smallestCountry = CountriesApplication.ourCountryList.findSmallestCountryByMedianAge();
		return new ResponseEntity<>(smallestCountry, HttpStatus.OK);
	}
}
