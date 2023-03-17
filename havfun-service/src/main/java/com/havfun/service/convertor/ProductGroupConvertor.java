package com.havfun.service.convertor;

import java.util.ArrayList;
import java.util.List;

import com.havfun.service.entity.ProductGroup;
import com.havfun.service.message.data.ProductGroupMessage;

public class ProductGroupConvertor {

	public final static List<ProductGroup> convertToEntityList(List<ProductGroupMessage> productGroupMessageList) {
		if (productGroupMessageList == null) {
			return null;
		}

		List<ProductGroup> productGroupList = new ArrayList<ProductGroup>();
		for (ProductGroupMessage productGroupMessage : productGroupMessageList) {
			productGroupList.add(convertToEntity(productGroupMessage));
		}

		return productGroupList;
	}

	public final static List<ProductGroupMessage> convertToMessageList(List<ProductGroup> productGroupList) {
		if (productGroupList == null) {
			return null;
		}

		List<ProductGroupMessage> productGroupMessageList = new ArrayList<ProductGroupMessage>();
		for (ProductGroup productGroup : productGroupList) {
			productGroupMessageList.add(convertToMessage(productGroup));
		}

		return productGroupMessageList;
	}

	public final static ProductGroup convertToEntity(ProductGroupMessage productGroupMessage) {
		ProductGroup productGroup = new ProductGroup();

		productGroup.setProductGroupId(productGroupMessage.getProductGroupId());
		productGroup.setNameEn( productGroupMessage.getNameEn() );
		productGroup.setImage(productGroupMessage.getImage());
		productGroup.setParentId(productGroupMessage.getParentId());
		productGroup.setStatus(productGroupMessage.getStatus());
		productGroup.setCreateTimestamp(productGroupMessage.getCreateTimestamp());
		productGroup.setLastModifiedTimestamp(productGroupMessage.getLastModifiedTimestamp());

		return productGroup;
	}

	public final static ProductGroupMessage convertToMessage(ProductGroup productGroup) {
		ProductGroupMessage productGroupMessage = new ProductGroupMessage();

		productGroupMessage.setProductGroupId(productGroup.getProductGroupId());
		productGroupMessage.setNameEn( productGroup.getNameEn() );
		productGroupMessage.setImage(productGroup.getImage());
		productGroupMessage.setParentId(productGroup.getParentId());
		productGroupMessage.setStatus(productGroup.getStatus());
		productGroupMessage.setCreateTimestamp(productGroup.getCreateTimestamp());
		productGroupMessage.setLastModifiedTimestamp(productGroup.getLastModifiedTimestamp());

		return productGroupMessage;
	}

}


