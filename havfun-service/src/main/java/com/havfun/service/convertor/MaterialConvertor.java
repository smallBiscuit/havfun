package com.havfun.service.convertor;

import java.util.ArrayList;
import java.util.List;

import com.havfun.service.entity.Material;
import com.havfun.service.message.data.MaterialMessage;

public class MaterialConvertor {

	public final static List<Material> convertToEntityList(List<MaterialMessage> materialMessageList) {
		if (materialMessageList == null) {
			return null;
		}

		List<Material> materialList = new ArrayList<Material>();
		for (MaterialMessage materialMessage : materialMessageList) {
			materialList.add(convertToEntity(materialMessage));
		}

		return materialList;
	}

	public final static List<MaterialMessage> convertToMessageList(List<Material> materialList) {
		if (materialList == null) {
			return null;
		}

		List<MaterialMessage> materialMessageList = new ArrayList<MaterialMessage>();
		for (Material material : materialList) {
			materialMessageList.add(convertToMessage(material));
		}

		return materialMessageList;
	}

	public final static Material convertToEntity(MaterialMessage materialMessage) {
		Material material = new Material();

		material.setMaterialId(materialMessage.getMaterialId());
		material.setImage(materialMessage.getImage());
		material.setMaterialGroupId(materialMessage.getMaterialGroupId());
		material.setMaterialIndex(materialMessage.getMaterialIndex());
		material.setActive( materialMessage.isActive());
		material.setCreateTimestamp( materialMessage.getCreateTimestamp());
		
		return material;
	}

	public final static MaterialMessage convertToMessage(Material material) {
		MaterialMessage materialMessage = new MaterialMessage();

		materialMessage.setMaterialId(material.getMaterialId());
		materialMessage.setImage( material.getImage());
		materialMessage.setMaterialGroupId(material.getMaterialGroupId());
		materialMessage.setMaterialIndex(material.getMaterialIndex());
		materialMessage.setActive( material.isActive());
		materialMessage.setCreateTimestamp( material.getCreateTimestamp() );
		
		return materialMessage;
	}

}


