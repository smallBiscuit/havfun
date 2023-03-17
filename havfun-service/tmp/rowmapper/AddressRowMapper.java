package com.havfun.service.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.havfun.service.entity.Address;

public class AddressRowMapper implements RowMapper<Address> {

	@Override
	public Address mapRow(ResultSet rs, int rowNum) throws SQLException {

		Address address = new Address();

		address.setAddressId(rs.getInt("address_id"));
		address.setClientId(rs.getInt("client_id"));
		address.setFirstName(rs.getString("first_name"));
		address.setLastName(rs.getString("last_name"));
		address.setAddress1(rs.getString("address1"));
		address.setAddress2(rs.getString("address2"));
		address.setCity(rs.getString("city"));
		address.setPostcode(rs.getString("postcode"));
		address.setCountryId(rs.getInt("country_id"));
		address.setZoneId(rs.getInt("zone_id"));
		address.setTelephone(rs.getString("telephone"));
		address.setBillingAddress(rs.getString("billing_address")=="1");
		address.setShippingAddress(rs.getString("shipping_address")=="1");
		return address;
	}

 }

