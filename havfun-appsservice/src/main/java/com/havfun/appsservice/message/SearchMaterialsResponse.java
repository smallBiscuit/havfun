package com.havfun.appsservice.message;

import java.util.List;

import com.havfun.appsservice.data.Material;

public class SearchMaterialsResponse extends AbstractResponse{

	private List<Material> materialList;

	public List<Material> getMaterialList() {
		return materialList;
	}

	public void setMaterialList(List<Material> materialList) {
		this.materialList = materialList;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SearchMaterialsResponse [materialList=");
		builder.append(materialList);
		builder.append(", result=");
		builder.append(result);
		builder.append(", reason=");
		builder.append(reason);
		builder.append("]");
		return builder.toString();
	}



}
