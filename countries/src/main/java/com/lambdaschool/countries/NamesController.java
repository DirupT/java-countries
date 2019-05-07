package com.lambdaschool.countries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/names")
public class NamesController
{
	// localhost:8080/names/all
	@GetMapping("/all")
	public ResponseEntity<?> getAllCountriesAlphabetically()
	{
		CountriesApplication.ourCountryList.countryList.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
		return new ResponseEntity<>(CountriesApplication.ourCountryList.countryList, HttpStatus.OK);
	}

	// localhost:8080/names/start/a
	@GetMapping("/start/{letter}")
	public ResponseEntity<?> getAllCountriesAlphabetically(@PathVariable char letter)
	{
		ArrayList<Country> rtnList = CountriesApplication
				.ourCountryList.findCountries(c -> c.getName().toUpperCase().charAt(0) == Character.toUpperCase(letter));
		rtnList.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
		return new ResponseEntity<>(rtnList, HttpStatus.OK);
	}
}
