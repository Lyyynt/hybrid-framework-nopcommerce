package utilities;

import java.io.File;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import commons.GlobalConstants;

public class DataJson {
	public static DataJson get(String filename) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			return mapper.readValue(new File(GlobalConstants.PROJECT_PATH + "/resources/" + filename), DataJson.class);
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@JsonProperty("firstname")
	String firstName;
	
	@JsonProperty("lastname")
	String lastName;
	
	@JsonProperty("companyname")
	String companyName;
	
	@JsonProperty("day")
	String dayOfBirth;
	
	@JsonProperty("month")
	String monthOfBirth;
	
	@JsonProperty("year")
	String yearOfBirth;
	
	@JsonProperty("cc")
	CC cc;
	
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public String getDayOfBirth() {
		return dayOfBirth;
	}

	public String getMonthOfBirth() {
		return monthOfBirth;
	}

	public String getYearOfBirth() {
		return yearOfBirth;
	}

	public CC getCc() {
		return cc;
	}

	public static class CC{
		@JsonProperty("number")
		String number;
		
		@JsonProperty("billing")
		String billing;

		public String getNumber() {
			return number;
		}

		public String getBilling() {
			return billing;
		}
	}
}
