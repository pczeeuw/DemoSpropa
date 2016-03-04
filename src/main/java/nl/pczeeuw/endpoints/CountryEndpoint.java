package nl.pczeeuw.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import nl.pczeeuw.countries.GetCountryRequest;
import nl.pczeeuw.countries.GetCountryResponse;
import nl.pczeeuw.repositories.CountryRepository;

@Endpoint
public class CountryEndpoint {
	private static final String NAMESPACE_URI = "http://pczeeuw.nl/countries";
	
	private CountryRepository countryRepository;
	
	@Autowired 
	public CountryEndpoint(CountryRepository countryRepository) {
		System.out.println("Country Endpoint Initialized!");
		this.countryRepository = countryRepository;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
	@ResponsePayload
	public GetCountryResponse getCountry (@RequestPayload GetCountryRequest request) {
		GetCountryResponse response = new GetCountryResponse();
		response.setCountry(countryRepository.findCountry(request.getName()));
		
		return response;
	}
	
}
