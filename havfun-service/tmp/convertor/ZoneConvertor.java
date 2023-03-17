package com.havfun.service.convertor;

import java.util.ArrayList;
import java.util.List;

import com.havfun.service.entity.Zone;
import com.havfun.service.message.data.ZoneMessage;

public class ZoneConvertor {

	public final static List<Zone> convertToEntityList(List<ZoneMessage> zoneMessageList) {
		if (zoneMessageList == null) {
			return null;
		}

		List<Zone> zoneList = new ArrayList<Zone>();
		for (ZoneMessage zoneMessage : zoneMessageList) {
			zoneList.add(convertToEntity(zoneMessage));
		}

		return zoneList;
	}

	public final static List<ZoneMessage> convertToMessageList(List<Zone> zoneList) {
		if (zoneList == null) {
			return null;
		}

		List<ZoneMessage> zoneMessageList = new ArrayList<ZoneMessage>();
		for (Zone zone : zoneList) {
			zoneMessageList.add(convertToMessage(zone));
		}

		return zoneMessageList;
	}

	public final static Zone convertToEntity(ZoneMessage zoneMessage) {
		Zone zone = new Zone();

		zone.setZoneId(zoneMessage.getZoneId());
		zone.setCountryId(zoneMessage.getCountryId());
		zone.setName(zoneMessage.getName());
		zone.setCode(zoneMessage.getCode());
		zone.setActive(zoneMessage.isActive());

		return zone;
	}

	public final static ZoneMessage convertToMessage(Zone zone) {
		ZoneMessage zoneMessage = new ZoneMessage();

		zoneMessage.setZoneId(zone.getZoneId());
		zoneMessage.setCountryId(zone.getCountryId());
		zoneMessage.setName(zone.getName());
		zoneMessage.setCode(zone.getCode());
		zoneMessage.setActive(zone.isActive());

		return zoneMessage;
	}

}


