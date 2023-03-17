package com.havfun.service.convertor;

import java.util.ArrayList;
import java.util.List;

import com.havfun.service.entity.Courier;
import com.havfun.service.message.data.CourierMessage;

public class CourierConvertor {

	public final static List<Courier> convertToEntityList(List<CourierMessage> courierMessageList) {
		if (courierMessageList == null) {
			return null;
		}

		List<Courier> courierList = new ArrayList<Courier>();
		for (CourierMessage courierMessage : courierMessageList) {
			courierList.add(convertToEntity(courierMessage));
		}

		return courierList;
	}

	public final static List<CourierMessage> convertToMessageList(List<Courier> courierList) {
		if (courierList == null) {
			return null;
		}

		List<CourierMessage> courierMessageList = new ArrayList<CourierMessage>();
		for (Courier courier : courierList) {
			courierMessageList.add(convertToMessage(courier));
		}

		return courierMessageList;
	}

	public final static Courier convertToEntity(CourierMessage courierMessage) {
		Courier courier = new Courier();

		courier.setCourierId(courierMessage.getCourierId());
		courier.setForwarderId(courierMessage.getForwarderId());
		courier.setForwarderNameEn( courierMessage.getForwarderNameEn() );
		courier.setForwarderNameHk( courierMessage.getForwarderNameHk() );
		courier.setForwarderNameCn( courierMessage.getForwarderNameCn() );
		courier.setCountryCode(courierMessage.getCountryCode());
		courier.setFromWeight(courierMessage.getFromWeight());
		courier.setToWeight(courierMessage.getToWeight());
		courier.setBaseWeight(courierMessage.getBaseWeight());
		courier.setBaseCost(courierMessage.getBaseCost());
		courier.setWeightPerTier(courierMessage.getWeightPerTier());
		courier.setChargePerTier(courierMessage.getChargePerTier());
		courier.setServiceChargePercentage(courierMessage.getServiceChargePercentage());
		courier.setFuelChargePercentage(courierMessage.getFuelChargePercentage());

		return courier;
	}

	public final static CourierMessage convertToMessage(Courier courier) {
		CourierMessage courierMessage = new CourierMessage();

		courierMessage.setCourierId(courier.getCourierId());
		courierMessage.setForwarderId(courier.getForwarderId());
		courierMessage.setForwarderNameEn( courier.getForwarderNameEn() );
		courierMessage.setForwarderNameHk( courier.getForwarderNameHk() );
		courierMessage.setForwarderNameCn( courier.getForwarderNameCn() );
		courierMessage.setCountryCode(courier.getCountryCode());
		courierMessage.setFromWeight(courier.getFromWeight());
		courierMessage.setToWeight(courier.getToWeight());
		courierMessage.setBaseWeight(courier.getBaseWeight());
		courierMessage.setBaseCost(courier.getBaseCost());
		courierMessage.setWeightPerTier(courier.getWeightPerTier());
		courierMessage.setChargePerTier(courier.getChargePerTier());
		courierMessage.setServiceChargePercentage(courier.getServiceChargePercentage());
		courierMessage.setFuelChargePercentage(courier.getFuelChargePercentage());

		return courierMessage;
	}

}


