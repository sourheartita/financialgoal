package come.project.financialgoalbe.response;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIgnore;

import come.project.financialgoalbe.entities.Bond;
import come.project.financialgoalbe.entities.Country;
import come.project.financialgoalbe.entities.Market;
import come.project.financialgoalbe.repository.BondRepository;
import come.project.financialgoalbe.repository.MarketRepository;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class CountryResponse {
	
	@Autowired
	@JsonIgnore
	BondRepository bondRepository;
	
	@Autowired
	@JsonIgnore
	MarketRepository marketRepository;
	
	private Long idCountry;
	
	private String shortName;
	
	private String longName;
	
	public CountryResponse toResponse(Country obj) {
		this.idCountry=obj.getIdCountry();
		this.shortName=obj.getShortName();
		this.longName=obj.getLongName();
		return this;
	}
	
	public Country toEntity() {
		Country country = new Country();
		country.setIdCountry(this.idCountry);
		country.setShortName(this.shortName);
		country.setLongName(this.longName);
		//Insert in the entity the list of Bond which belong the country concerned
		List<Bond> listBond = bondRepository.findBondByCountry(this.shortName);
		country.setBond(listBond);
		//Insert in the entity the list of Market which belong the country concerned
		List<Market> listMarket = marketRepository.findMarketByCountry(this.shortName);
		country.setMarket(listMarket);
		
		return country;
	}

}
