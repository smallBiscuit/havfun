package com.havfun.service.convertor;

import java.util.ArrayList;
import java.util.List;

import com.havfun.service.entity.Currency;
import com.havfun.service.message.data.CurrencyMessage;

public class CurrencyConvertor {

	public final static List<Currency> convertToEntityList(List<CurrencyMessage> currencyMessageList) {
		if (currencyMessageList == null) {
			return null;
		}

		List<Currency> currencyList = new ArrayList<Currency>();
		for (CurrencyMessage currencyMessage : currencyMessageList) {
			currencyList.add(convertToEntity(currencyMessage));
		}

		return currencyList;
	}

	public final static List<CurrencyMessage> convertToMessageList(List<Currency> currencyList) {
		if (currencyList == null) {
			return null;
		}

		List<CurrencyMessage> currencyMessageList = new ArrayList<CurrencyMessage>();
		for (Currency currency : currencyList) {
			currencyMessageList.add(convertToMessage(currency));
		}

		return currencyMessageList;
	}

	public final static Currency convertToEntity(CurrencyMessage currencyMessage) {
		Currency currency = new Currency();

		currency.setCurrencyId(currencyMessage.getCurrencyId());
		currency.setCode(currencyMessage.getCode());
		currency.setSymbolLeft(currencyMessage.getSymbolLeft());
		currency.setSymbolRight(currencyMessage.getSymbolRight());
		currency.setDecimalPlace(currencyMessage.getDecimalPlace());
		currency.setLastModifiedTimestamp(currencyMessage.getLastModifiedTimestamp());

		return currency;
	}

	public final static CurrencyMessage convertToMessage(Currency currency) {
		CurrencyMessage currencyMessage = new CurrencyMessage();

		currencyMessage.setCurrencyId(currency.getCurrencyId());
		currencyMessage.setCode(currency.getCode());
		currencyMessage.setSymbolLeft(currency.getSymbolLeft());
		currencyMessage.setSymbolRight(currency.getSymbolRight());
		currencyMessage.setDecimalPlace(currency.getDecimalPlace());
		currencyMessage.setLastModifiedTimestamp(currency.getLastModifiedTimestamp());

		return currencyMessage;
	}

}


