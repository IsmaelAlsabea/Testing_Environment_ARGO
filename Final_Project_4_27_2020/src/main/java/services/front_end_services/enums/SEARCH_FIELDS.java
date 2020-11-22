package services.front_end_services.enums;

public enum SEARCH_FIELDS {

	Customer_TYPE  (" cu.TYPECUST = ") 				//Cus		String
	 	
  	, AGE (" year(GETDATE()) - year(DOB) = ")		//ci		Date 		we calculate the age, then we search.
	, STATE (" STATE1= ") 		   					//cus   	String
	
	, CREDIT_BUREAU (" Bureau= ")					//ci		String
	, PEP (" PEP= ")								//ci		String
	, ZIP_CODE (" ZIP1= ") 							//cus		String
	
	, ONLINE_BANKING (" OnlineBanking = ")			//ci		String 
	, FOREIGN_IND (" ForeignInd = ")				//ci		String 		
	, SPECIAL_USE (" SpecUse = ") 					//ci		String
	
	
	, NAME (" NAMFULL LIKE ") 							//CUS		String  //we should add a % after the word
	, CREDIT_RANGE_L (" CreditScore >= ")			//CI		String		
	, CREDIT_RANGE_H (" CreditScore<= ")			//CI		String	
	, CITY (" City1 = ")							//CUS		String
	;						

	private String val;
	
	private SEARCH_FIELDS (String s) {
		val=s;
	}
	public String getVal() {
		return val;
	}
}