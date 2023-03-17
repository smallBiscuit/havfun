package com.havfun.service.convertor;

import java.util.ArrayList;
import java.util.List;

import com.havfun.service.entity.GeoZone;
import com.havfun.service.message.data.GeoZoneMessage;

public class GeoZoneConvertor {

	public final static List<GeoZone> convertToEntityList(List<GeoZoneMessage> geoZoneMessageList) {
		if (geoZoneMessageList == null) {
			return null;
		}

		List<GeoZone> geoZoneList = new ArrayList<GeoZone>();
		for (GeoZoneMessage geoZoneMessage : geoZoneMessageList) {
			geoZoneList.add(convertToEntity(geoZoneMessage));
		}

		return geoZoneList;
	}

	public final static List<GeoZoneMessage> convertToMessageList(List<GeoZone> geoZoneList) {
		if (geoZoneList == null) {
			return null;
		}

		List<GeoZoneMessage> geoZoneMessageList = new ArrayList<GeoZoneMessage>();
		for (GeoZone geoZone : geoZoneList) {
			geoZoneMessageList.add(convertToMessage(geoZone));
		}

		return geoZoneMessageList;
	}

	public final static GeoZone convertToEntity(GeoZoneMessage geoZoneMessage) {
		GeoZone geoZone = new GeoZone();

		geoZone.setGeoZeonId(geoZoneMessage.getGeoZeonId());
		geoZone.setName(geoZoneMessage.getName());
		geoZone.setDescription(geoZoneMessage.getDescription());
		geoZone.setCreateTimestamp(geoZoneMessage.getCreateTimestamp());
		geoZone.setLastModifedTimestamp(geoZoneMessage.getLastModifedTimestamp());

		return geoZone;
	}

	public final static GeoZoneMessage convertToMessage(GeoZone geoZone) {
		GeoZoneMessage geoZoneMessage = new GeoZoneMessage();

		geoZoneMessage.setGeoZeonId(geoZone.getGeoZeonId());
		geoZoneMessage.setName(geoZone.getName());
		geoZoneMessage.setDescription(geoZone.getDescription());
		geoZoneMessage.setCreateTimestamp(geoZone.getCreateTimestamp());
		geoZoneMessage.setLastModifedTimestamp(geoZone.getLastModifedTimestamp());

		return geoZoneMessage;
	}

}


