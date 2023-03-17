package com.havfun.service.convertor;

import java.util.ArrayList;
import java.util.List;

import com.havfun.service.entity.MaterialGroup;
import com.havfun.service.message.data.MaterialGroupMessage;

public class MaterialGroupConvertor {

	public final static List<MaterialGroup> convertToEntityList(List<MaterialGroupMessage> materialGroupMessageList) {
		if (materialGroupMessageList == null) {
			return null;
		}

		List<MaterialGroup> materialGroupList = new ArrayList<MaterialGroup>();
		for (MaterialGroupMessage materialGroupMessage : materialGroupMessageList) {
			materialGroupList.add(convertToEntity(materialGroupMessage));
		}

		return materialGroupList;
	}

	public final static List<MaterialGroupMessage> convertToMessageList(List<MaterialGroup> materialGroupList) {
		if (materialGroupList == null) {
			return null;
		}

		List<MaterialGroupMessage> materialGroupMessageList = new ArrayList<MaterialGroupMessage>();
		for (MaterialGroup materialGroup : materialGroupList) {
			materialGroupMessageList.add(convertToMessage(materialGroup));
		}

		return materialGroupMessageList;
	}

	public final static MaterialGroup convertToEntity(MaterialGroupMessage materialGroupMessage) {
		MaterialGroup materialGroup = new MaterialGroup();

		materialGroup.setMaterialGroupId(materialGroupMessage.getMaterialGroupId());
		materialGroup.setNameEn(materialGroupMessage.getNameEn());
		materialGroup.setNameHk(materialGroupMessage.getNameHk());
		materialGroup.setImage(materialGroupMessage.getImage());
		materialGroup.setParentId(materialGroupMessage.getParentId());
		materialGroup.setActive(materialGroupMessage.isActive());
		materialGroup.setCreateTimestamp(materialGroupMessage.getCreateTimestamp());

		return materialGroup;
	}

	public final static MaterialGroupMessage convertToMessage(MaterialGroup materialGroup) {
		MaterialGroupMessage materialGroupMessage = new MaterialGroupMessage();

		materialGroupMessage.setMaterialGroupId(materialGroup.getMaterialGroupId());
		materialGroupMessage.setNameEn(materialGroup.getNameEn());
		materialGroupMessage.setNameHk(materialGroup.getNameHk());
		materialGroupMessage.setImage(materialGroup.getImage());
		materialGroupMessage.setParentId(materialGroup.getParentId());
		materialGroupMessage.setActive(materialGroup.isActive());
		materialGroupMessage.setCreateTimestamp(materialGroup.getCreateTimestamp());

		return materialGroupMessage;
	}

}


