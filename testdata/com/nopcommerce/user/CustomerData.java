package com.nopcommerce.user;

import utilities.DataHelper;

public class CustomerData {
	public static class EditCustomer {
		public static final String FIRST_NAME = DataHelper.getDataHelper().getFirstName();
		public static final String LAST_NAME = DataHelper.getDataHelper().getLastName();
		public static final String CITY = DataHelper.getDataHelper().getCityName();
		public static final String ADDRESS = DataHelper.getDataHelper().getAddress();
		public static final String ZIPCODE = DataHelper.getDataHelper().getFirstName();
	}
	public static class AddNewAddress {
		public static final String FIRST_NAME = DataHelper.getDataHelper().getFirstName();
		public static final String LAST_NAME = DataHelper.getDataHelper().getLastName();
		public static final String CITY = DataHelper.getDataHelper().getCityName();
		public static final String ADDRESS = DataHelper.getDataHelper().getAddress();
		public static final String ZIPCODE = DataHelper.getDataHelper().getFirstName();
	}
	public static class ChangePassword {
	}
	
	
	
}
