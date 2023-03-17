package com.havfun.appsservice.convertor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.havfun.appsservice.data.CustomizeProductBase;
import com.havfun.appsservice.data.CustomizeProductBaseView;
import com.havfun.appsservice.data.CustomizeProductBaseViewElements;
import com.havfun.appsservice.data.CustomizeProductBaseViewElementsParams;
import com.havfun.appsservice.data.CustomizeProductBorderItem;
import com.havfun.appsservice.data.CustomizeProductColorItem;
import com.havfun.appsservice.data.CustomizeProductColorItemLayer;
import com.havfun.appsservice.data.Product;
import com.havfun.appsservice.data.ProductAttribute;
import com.havfun.appsservice.data.ProductAttributeOption;
import com.havfun.service.message.data.CustomizeProductBaseViewMessage;
import com.havfun.service.message.data.CustomizeProductBorderItemMessage;
import com.havfun.service.message.data.CustomizeProductColorItemMessage;
import com.havfun.service.message.data.ProductAttributeOptionMessage;
import com.havfun.service.message.data.ProductMessage;

public class ProductConvertor {

	public static Product convertorProductMessageToProduct( ProductMessage message ){
		
		Product product = new Product();
		
		product.setProductId( message.getProductId() );
		product.setProductGroupId( message.getProductGroupId() );
		product.setNameEn( message.getNameEn() );
		product.setNameHk( message.getNameHk() );
		product.setNameCn( message.getNameCn() );
		product.setThumbnailUrl( message.getThumbnailUrl() );
		product.setDesignerClientId( message.getDesignerClientId() );
		product.setModel( message.getModel() );
		product.setStock( message.getStock() );
		product.setManufacturerId( message.getManufacturerId() );
		product.setPrice( message.getPrice() );
		product.setAvailableDate( message.getAvailableDate() );
		product.setWeight( message.getWeight() );
		product.setLength( message.getLength() );
		product.setWidth( message.getWidth() );
		product.setHeight( message.getHeight() );
		product.setSortingOrder( message.getSortingOrder() );
		product.setStockStatus( message.getStockStatus() );
		product.setProductStatus( message.getProductStatus() );
		product.setCreateTimestamp( message.getCreateTimestamp() );
		product.setLastModifiedTimestamp( message.getLastModifiedTimestamp() );
		
		CustomizeProductBase base = new CustomizeProductBase();
		
		if ( message.getCustomizeProductBase() != null ){
			
			if ( message.getCustomizeProductBase().getVariations() != null ){
			
				List<ProductAttribute> attributeList = new ArrayList<ProductAttribute>();
				
				for ( Map.Entry<String, List<ProductAttributeOptionMessage>> entry : message.getCustomizeProductBase().getVariations().entrySet())
				{
					//System.out.println(entry.getKey() + "/" + entry.getValue());
					
					ProductAttribute productAttribute = new ProductAttribute();
					
					productAttribute.setAttributeKey( entry.getValue().get(0).getProductAttributeKey() );
					productAttribute.setNameEn( entry.getValue().get(0).getProductAttributeNameEn() );
					productAttribute.setNameHk( entry.getValue().get(0).getProductAttributeNameHk() );
					productAttribute.setNameCn( entry.getValue().get(0).getProductAttributeNameCn() );
					
					List<ProductAttributeOption> optionList = new ArrayList<ProductAttributeOption>();
					
					for ( int i = 0; i < entry.getValue().size(); i ++ ){
						
						ProductAttributeOptionMessage optionMessage = entry.getValue().get(i);
						
						ProductAttributeOption option = new ProductAttributeOption();
						
						option.setOptionId( optionMessage.getOptionId() );
						option.setProductAttributeId( optionMessage.getProductAttributeId() );
						option.setName( optionMessage.getName() );
						option.setValue( optionMessage.getValue() );
						
						optionList.add(option);
						
					}
					
					productAttribute.setOptionList(optionList);
					
					attributeList.add( productAttribute);
					
					
				}
				
				base.setAttributeList(attributeList);
				
			}
				
			if ( message.getCustomizeProductBase().getViews() != null ){
				
				List<CustomizeProductBaseView> viewList = new ArrayList<CustomizeProductBaseView>();
				
				for ( CustomizeProductBaseViewMessage viewMessage :message.getCustomizeProductBase().getViews() ){
					
					CustomizeProductBaseView view = new CustomizeProductBaseView();
					
					view.setViewId( viewMessage.getViewId() );
					view.setBaseId( viewMessage.getBaseId() );
					view.setTitle( viewMessage.getTitle() );
					
					CustomizeProductBaseViewElements elements = new CustomizeProductBaseViewElements();
					
					CustomizeProductBaseViewElementsParams params = new CustomizeProductBaseViewElementsParams();
					
					params.setZ( viewMessage.getZ() );
					params.setBoundWidth( viewMessage.getBoundWidth() );
					params.setBoundHeight( viewMessage.getBoundHeight() );
					params.setScale( viewMessage.getScale() );
					
					elements.setParams(params);
					
					List<CustomizeProductBaseViewElements> elementsList = new ArrayList<CustomizeProductBaseViewElements>();
					
					elementsList.add(elements);
					
					view.setElements( elementsList );
					
					if ( viewMessage.getBorderList() != null ){
						
						List<CustomizeProductBorderItem> borderList = new ArrayList<CustomizeProductBorderItem>();
						
						for ( CustomizeProductBorderItemMessage itemMessage : viewMessage.getBorderList() ){
							
							CustomizeProductBorderItem item =  new CustomizeProductBorderItem();
							
							item.setBorderId( itemMessage.getBorderId() );
							item.setViewId( itemMessage.getViewId() );
							item.setItemKey( itemMessage.getItemKey() );
							item.setItemType( itemMessage.getItemType() );
							item.setTitle( itemMessage.getTitle() );
							item.setDefaultOption( itemMessage.isDefaultOption() );
							item.setCost( itemMessage.getCost() );
							item.setX( itemMessage.getX() );
							item.setY( itemMessage.getY() );
							item.setWidth( itemMessage.getWidth() );
							item.setHeight( itemMessage.getHeight() );							
							
							borderList.add(item);
							
						}
					
						view.setBoundingList(borderList);
						
					}
					
					viewList.add(view);
					
				}
				
				base.setViews(viewList);
			}
					

			if ( message.getCustomizeProductBase().getColorItemList() != null ){
				
				List<CustomizeProductColorItem> colorList = new ArrayList<CustomizeProductColorItem>();
				
				for ( int i = 0 ; i < message.getCustomizeProductBase().getColorItemList().size(); i ++ ){
					
					CustomizeProductColorItemMessage colorMessage = message.getCustomizeProductBase().getColorItemList().get(i);
					
					CustomizeProductColorItem color = new CustomizeProductColorItem();
					
					color.setColorId( colorMessage.getColorId() );
					color.setBaseId( colorMessage.getBaseId() );
					color.setLayerName( "LayerName");
					
					List<CustomizeProductColorItemLayer> layerList = new ArrayList<CustomizeProductColorItemLayer>();
					
					for ( int j = 0; j < message.getCustomizeProductBase().getViews().size(); j ++ ){
					
						CustomizeProductColorItemLayer layer = new CustomizeProductColorItemLayer();
						
						String productIdStr = String.format("%05d", message.getProductId() );						
						String colorIdStr = String.format("%02d", (i+1) );
						String layerIdStr = String.format("%02d", (j) );
						
						String RESOURCE_IMAGE_DOMAIN = "http://52.192.251.209:8080//havfun-appsservice/havfun_image/";
//						String RESOURCE_IMAGE_DOMAIN = "http://localhost:8080/havfun-appsservice/havfun_image/";
						String thumbnailUrl = RESOURCE_IMAGE_DOMAIN + "customize_product_color_item/" + "product_"+productIdStr+"_color_" + colorIdStr + ".png"; 
						String imageUrl = RESOURCE_IMAGE_DOMAIN + "customize_product_base_view/" + "product_"+productIdStr+"_image_" + colorIdStr + "_" + layerIdStr + ".png"; 
						
						
						layer.setColorThumbnail( thumbnailUrl );
						layer.setFileType( colorMessage.getFileType() );
						layer.setImageURL( imageUrl );
						layer.setParentImage( colorMessage.getParentImage() );
						
						layerList.add(layer);
					
					}
					
					color.setLowerLayer(layerList);
										
					colorList.add( color );
					
				}
				
				base.setBaseColor( colorList );
				
			}
		
		}
		
		product.setCustomizeProductBase( base );
		
		
		
		return product;
	}
	
}
