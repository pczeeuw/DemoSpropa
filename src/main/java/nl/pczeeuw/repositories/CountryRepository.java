package nl.pczeeuw.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import nl.pczeeuw.countries.Country;
import nl.pczeeuw.countries.Currency;

@Component
public class CountryRepository {
	private static final List<Country> countries = new ArrayList<>();
	
	@PostConstruct
	public void initData () {
		countries.add(initCountryHelper(new Country(), "Spain", "Madrid", Currency.EUR, 46704314));
		countries.add(initCountryHelper(new Country(), "Netherlands", "Amsterdam", Currency.EUR, 16734862));
		countries.add(initCountryHelper(new Country(), "United Kingdom", "London", Currency.GBP, 63705000));
		countries.add(initCountryHelper(new Country(), "United States", "Washington", Currency.USD, 326524967));		
	}
	
	public Country findCountry (String name) {
		Assert.notNull(name);
		
		Country result = null;
		
		for (Country country : countries) {
			if (country.getName().equals(name))
				result = country;
		}
		
		return result;
	}
	
	private Country initCountryHelper (Country country, String name, String capital, Currency currency, int population) {
		country.setName(name);
		country.setCapital(capital);
		country.setCurrency(currency);
		country.setPopulation(population);
		return country;
	}

}
