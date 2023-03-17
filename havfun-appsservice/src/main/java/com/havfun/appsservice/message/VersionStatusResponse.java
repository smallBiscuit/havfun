package com.havfun.appsservice.message;

import java.util.List;

import com.havfun.service.message.data.CountryMessage;

public class VersionStatusResponse extends AbstractResponse{

	private boolean forceUpdate;
	
	private List<CountryMessage> countryList;

	public boolean isForceUpdate() {
		return forceUpdate;
	}

	public void setForceUpdate(boolean forceUpdate) {
		this.forceUpdate = forceUpdate;
	}
	
	public List<CountryMessage> getCountryList() {
		return countryList;
	}

	public void setCountryList(List<CountryMessage> countryList) {
		this.countryList = countryList;
	}

	@Override
	public String toString() {
		return "VersionStatusResponse [forceUpdate=" + forceUpdate + ", countryList=" + countryList + ", result="
				+ result + ", reason=" + reason + "]";
	}
	
}
