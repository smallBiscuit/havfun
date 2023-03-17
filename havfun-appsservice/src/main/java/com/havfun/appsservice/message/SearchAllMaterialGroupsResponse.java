package com.havfun.appsservice.message;

import java.util.List;

import com.havfun.appsservice.data.MaterialGroup;

public class SearchAllMaterialGroupsResponse extends AbstractResponse{

	private List<MaterialGroup> materialGroupList;

	public List<MaterialGroup> getMaterialGroupList() {
		return materialGroupList;
	}

	public void setMaterialGroupList(List<MaterialGroup> materialGroupList) {
		this.materialGroupList = materialGroupList;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SearchAllMaterialGroupsResponse [materialGroupList=");
		builder.append(materialGroupList);
		builder.append("]");
		return builder.toString();
	}

	
}