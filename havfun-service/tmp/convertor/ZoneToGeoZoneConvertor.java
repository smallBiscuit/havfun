package com.havfun.service.convertor;

import java.util.ArrayList;
import java.util.List;

import com.havfun.service.entity.ZoneToGeoZone;
import com.havfun.service.message.data.ZoneToGeoZoneMessage;

public class ZoneToGeoZoneConvertor {

	public final static List<ZoneToGeoZone> convertToEntityList(List<ZoneToGeoZoneMessage> zoneToGeoZoneMessageList) {
		if (zoneToGeoZoneMessageList == null) {
			return null;
		}

		List<ZoneToGeoZone> zoneToGeoZoneList = new ArrayList<ZoneToGeoZone>();
		for (ZoneToGeoZoneMessage zoneToGeoZoneMessage : zoneToGeoZoneMessageList) {
			zoneToGeoZoneList.add(convertToEntity(zoneToGeoZoneMessage));
		}

		return zoneToGeoZoneList;
	}

	public final static List<ZoneToGeoZoneMessage> convertToMessageList(List<ZoneToGeoZone> zoneToGeoZoneList) {
		if (zoneToGeoZoneList == null) {
			return null;
		}

		List<ZoneToGeoZoneMessage> zoneToGeoZoneMessageList = new ArrayList<ZoneToGeoZoneMessage>();
		for (ZoneToGeoZone zoneToGeoZone : zoneToGeoZoneList) {
			zoneToGeoZoneMessageList.add(convertToMessage(zoneToGeoZone));
		}

		return zoneToGeoZoneMessageList;
	}

	public final static ZoneToGeoZone convertToEntity(ZoneToGeoZoneMessage zoneToGeoZoneMessage) {
		ZoneToGeoZone zoneToGeoZone = new ZoneToGeoZone();

		zoneToGeoZone.setZoneToGeoZone(zoneToGeoZoneMessage.getZoneToGeoZone());
		zoneToGeoZone.setCountryId(zoneToGeoZoneMessage.getCountryId());
		zoneToGeoZone.setZoneId(zoneToGeoZoneMessage.getZoneId());
		zoneToGeoZone.setCreateTimestamp(zoneToGeoZoneMessage.getCreateTimestamp());
		zoneToGeoZone.setLastModifiedTimestamp(zoneToGeoZoneMessage.getLastModifiedTimestamp());

		return zoneToGeoZone;
	}

	public final static ZoneToGeoZoneMessage convertToMessage(ZoneToGeoZone zoneToGeoZone) {
		ZoneToGeoZoneMessage zoneToGeoZoneMessage = new ZoneToGeoZoneMessage();

		zoneToGeoZoneMessage.setZoneToGeoZone(zoneToGeoZone.getZoneToGeoZone());
		zoneToGeoZoneMessage.setCountryId(zoneToGeoZone.getCountryId());
		zoneToGeoZoneMessage.setZoneId(zoneToGeoZone.getZoneId());
		zoneToGeoZoneMessage.setCreateTimestamp(zoneToGeoZone.getCreateTimestamp());
		zoneToGeoZoneMessage.setLastModifiedTimestamp(zoneToGeoZone.getLastModifiedTimestamp());

		return zoneToGeoZoneMessage;
	}

}


