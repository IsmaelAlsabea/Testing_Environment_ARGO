package consumer_info_services;

import java.util.List;

import consumer_info_entities.ConsumerInfo;
import utils.DAOException;

public interface Consumer_Info_Services {

	
	/*
	i.	Customer Type (drop down built on the records in the database)
	ii.	State (drop down built on the records in the database)
	iii.	Zip Code
	iv.	Tax ID Number
	v.	Last Name
	
	i.	Special use (drop down built on the records in the database)
	ii.	PEP (drop down built on the records in the database)


	 */
	
	/*
	 * @Id
	private long 		ID;
	
	private String 		CustomerType;
	
	private String 		LastName;
	
	private String 		TaxIdNumber;
	
	private String 		City;
	private String 		State;
	private String 		ZIPCode;
	private String 		SpecUse;
	
	private String 		CIF;
	private String 		PEP;
	private String 		ConsumerID;
	
	 * */
	
	 List<ConsumerInfo> retrieve(int ID) throws DAOException;
	 
	 List<ConsumerInfo> retrieveByCustomerType(String CustomerType) throws DAOException;  //nvarchar 3
	 
	 List<ConsumerInfo> retrieveByLastName(String LastName) throws DAOException;  //nvarchar  20 
	 
	 List<ConsumerInfo> retrieveByTaxIdNumber(String TaxIdNumber) throws DAOException;  //nvarchar  9 
	 
	 List<ConsumerInfo> retrieveByCity(String City) throws DAOException;  //nvarchar 25
	 
	 List<ConsumerInfo> retrieveByState(String State) throws DAOException;  //nvarchar 2
	 
	 List<ConsumerInfo> retrieveByZIPCode(String ZIPCode) throws DAOException;  //nvarchar 9
	 
	 List<ConsumerInfo> retrieveBySpecUse(String SpecUse) throws DAOException;  //nvarchar 255
	 
	 List<ConsumerInfo> retrieveByCIF(String CIF) throws DAOException;  //nvarchar 20
	 
	 List<ConsumerInfo> retrieveByPEP(String PEP) throws DAOException;  //nvarchar 1
	 
	 List<ConsumerInfo> retrieveByConsumerID(String ConsumerID) throws DAOException;  //nvarchar 36
	 
	 Long count() throws DAOException;
	 
}
