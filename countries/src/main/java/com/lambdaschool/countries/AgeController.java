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
	@GetMapping("/age/{age}")
	public ResponseEntity<?> getCountriesByMedian(@PathVariable int age)
	{
		ArrayList<Country> rtnList = CountriesApplication.ourCountryList.findCountries(c -> c.getMedianAge() >= age);
		return new ResponseEntity<>(rtnList, HttpStatus.OK);
	}
}
