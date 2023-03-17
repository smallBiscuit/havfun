package com.havfun.service.convertor;

import java.util.ArrayList;
import java.util.List;

import com.havfun.service.entity.ReferrerLog;
import com.havfun.service.message.data.ReferrerLogMessage;

public class ReferrerLogConvertor {

	public final static List<ReferrerLog> convertToEntityList(List<ReferrerLogMessage> referrerLogMessageList) {
		if (referrerLogMessageList == null) {
			return null;
		}

		List<ReferrerLog> referrerLogList = new ArrayList<ReferrerLog>();
		for (ReferrerLogMessage referrerLogMessage : referrerLogMessageList) {
			referrerLogList.add(convertToEntity(referrerLogMessage));
		}

		return referrerLogList;
	}

	public final static List<ReferrerLogMessage> convertToMessageList(List<ReferrerLog> referrerLogList) {
		if (referrerLogList == null) {
			return null;
		}

		List<ReferrerLogMessage> referrerLogMessageList = new ArrayList<ReferrerLogMessage>();
		for (ReferrerLog referrerLog : referrerLogList) {
			referrerLogMessageList.add(convertToMessage(referrerLog));
		}

		return referrerLogMessageList;
	}

	public final static ReferrerLog convertToEntity(ReferrerLogMessage referrerLogMessage) {
		ReferrerLog referrerLog = new ReferrerLog();

		referrerLog.setLogId(referrerLogMessage.getLogId());
		referrerLog.setClientId(referrerLogMessage.getClientId());
		referrerLog.setReferrer(referrerLogMessage.getReferrer());
		referrerLog.setOrderId(referrerLogMessage.getOrderId());
		referrerLog.setTotal(referrerLogMessage.getTotal());
		referrerLog.setPrice(referrerLogMessage.getPrice());
		referrerLog.setCreateTimestamp(referrerLogMessage.getCreateTimestamp());

		return referrerLog;
	}

	public final static ReferrerLogMessage convertToMessage(ReferrerLog referrerLog) {
		ReferrerLogMessage referrerLogMessage = new ReferrerLogMessage();

		referrerLogMessage.setLogId(referrerLog.getLogId());
		referrerLogMessage.setClientId(referrerLog.getClientId());
		referrerLogMessage.setReferrer(referrerLog.getReferrer());
		referrerLogMessage.setOrderId(referrerLog.getOrderId());
		referrerLogMessage.setTotal(referrerLog.getTotal());
		referrerLogMessage.setPrice(referrerLog.getPrice());
		referrerLogMessage.setCreateTimestamp(referrerLog.getCreateTimestamp());

		return referrerLogMessage;
	}

}


