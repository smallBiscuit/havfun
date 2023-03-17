package com.havfun.service.convertor;

import java.util.ArrayList;
import java.util.List;

import com.havfun.service.entity.Country;
import com.havfun.service.message.data.CountryMessage;

public class CountryConvertor {

	public final static List<Country> convertToEntityList(List<CountryMessage> countryMessageList) {
		if (countryMessageList == null) {
			return null;
		}

		List<Country> countryList = new ArrayList<Country>();
		for (CountryMessage countryMessage : countryMessageList) {
			countryList.add(convertToEntity(countryMessage));
		}

		return countryList;
	}

	public final static List<CountryMessage> convertToMessageList(List<Country> countryList) {
		if (countryList == null) {
			return null;
		}

		List<CountryMessage> countryMessageList = new ArrayList<CountryMessage>();
		for (Country country : countryList) {
			countryMessageList.add(convertToMessage(country));
		}

		return countryMessageList;
	}

	public final static Country convertToEntity(CountryMessage countryMessage) {
		Country country = new Country();

		country.setCountryId(countryMessage.getCountryId());
		country.setCountryCode( countryMessage.getCountryCode() );
		country.setNameEn(countryMessage.getNameEn());
		country.setNameHk(countryMessage.getNameHk());
		country.setNameCn(countryMessage.getNameCn());
		country.setActive(countryMessage.isActive());

		return country;
	}

	public final static CountryMessage convertToMessage(Country country) {
		CountryMessage countryMessage = new CountryMessage();

		countryMessage.setCountryId(country.getCountryId());
		countryMessage.setCountryCode( country.getCountryCode());
		countryMessage.setNameEn(country.getNameEn());
		countryMessage.setNameHk(country.getNameHk());
		countryMessage.setNameCn(country.getNameCn());
		countryMessage.setActive(country.isActive());

		return countryMessage;
	}

}


