package driver_pac;

import java.sql.Timestamp;
import java.util.Map;

import javax.persistence.EntityManager;

import entities_1.HS_ACCT;
import entities_1.HS_ACCT_CUAC;
import entities_1.HS_ACCT_CUST;
import entities_1.HS_ACCT_HOLD;
import entities_1.HS_ACCT_NOTE;
import entities_1.HS_ACCT_STOP;
import entities_2.ConsumerInfo;
import jpa_hibernate.JpaEntityManagerFactory;
import services_1.impl.HS_ACCT_NOTE_Services_Impl;
import services_1.impl.HS_ACCT_Services_Impl;
import services_2.impl.Consumer_Info_Services_Impl;
import utils.HS_Builder_Impl;

public class driver {

	public static void main(String[] args) {

		EntityManager em= null;
		EntityManager em2=null;
		
		 HS_Builder_Impl builder= HS_Builder_Impl.getInstance();
		 User_Interface ui= User_Interface.getInstance();
		 
		 Map<DATABASE, Map<DB_INFO,String>> dbsMap= ui.get_the_DBS_INFO();
		 
		 Map<DB_INFO,String> hsMap= dbsMap.get(DATABASE.HS_DB);
		 Map<DB_INFO,String> ciMap= dbsMap.get(DATABASE.CONSUMER_INFO_DB);
		 
		 try
	        {

			 Class[] hs_classes= new Class[] {HS_ACCT.class, HS_ACCT_NOTE.class, HS_ACCT_CUAC.class, 
					 HS_ACCT_CUST.class, HS_ACCT_HOLD.class, HS_ACCT_STOP.class};
			 
			 Class[] ci_classes= new Class[] {ConsumerInfo.class};
			 
			 em= new JpaEntityManagerFactory(hs_classes,hsMap.get(DB_INFO.URL), 
					 hsMap.get(DB_INFO.USERNAME), hsMap.get(DB_INFO.PASSWORD)).getEntityManager(); 
			 
			 em2= new JpaEntityManagerFactory(ci_classes,ciMap.get(DB_INFO.URL), 
					 ciMap.get(DB_INFO.USERNAME), ciMap.get(DB_INFO.PASSWORD)).getEntityManager();   
	            
//retrieve from consumer info 
	            
	            Consumer_Info_Services_Impl cis= new Consumer_Info_Services_Impl(em2);
	            
	            System.out.println(cis.count());
	            
	            System.out.println(cis.retrieve(7).get(0).getName());
	          
	            System.out.println(cis.retrieveByCustomerType("BUS").get(0).getName());
	            
	            
//create acct service instances.
	            HS_ACCT_NOTE_Services_Impl acctNoteServ=new HS_ACCT_NOTE_Services_Impl(em);
	            
	            HS_ACCT_Services_Impl 	acctServ = new HS_ACCT_Services_Impl(em);

//**************create of an object      
	            
	            Timestamp timestamp= new Timestamp(System.currentTimeMillis());

// in ACCT_NOTE
	            
//	            HS_ACCT_NOTE acNote= builder.build_HS_ACCT_NOTE("004", "DRS", "121", timestamp, "SSSS", "777", "444" );
//        		acctNoteServ.create(acNote);

	            
// in ACCT
//	            HS_ACCT acct= builder.build_HS_ACCT("010", "FFF", "4578", "ty1", "888", "BOJO", 
//	            		null, null, null, "LLLL", "UP", timestamp, null, null, 
//	            		null, "C1", "C2", "412", "44", "R", null, "V", 
//	            		"B", "BOJOJO", null, null, null, "Dallas", null, "TX", null, 
//	            		"12345", null, null, null, "kkdfjsldfkjs", null, null, null);
//	            
//	            acctServ.create(acct);
	            
// delete an object
	            
	            
	         //   acctServ.delete("010", "FFF", "4578");
	            

// update an object
	            
//	            HS_ACCT acct2= builder.build_HS_ACCT("010", "FFF", "4578", "ty6", "444", "JOBO", 
//	            		null, null, null, "LLLL", "UP", timestamp, null, null, 
//	            		null, "C1", "C2", "412", "44", "R", null, "V", 
//	            		"B", "BOJOJO", null, null, null, "Dallas", null, "TX", null, 
//	            		"12345", null, null, null, "kkdfjsldfkjs", null, null, null);
//	            
//	            acctServ.update(acct2);
//	            
	            
//Retreive from HS_ACCT
	            System.out.println(acctServ.retrieveByTYPEACCT("FFF").get(0).getACTTITLE1());
	            
	            
	            
//retrieve from ACCT_Note
	            System.out.println(acctNoteServ.retrieveByTYPEACCT("RCD").get(0).getREGIONID());
	            
	            System.out.println(acctNoteServ.retrieveByREGIONID("002").get(0).getTYPEACCT());
	            

	        }
	        catch (Exception ex)
	        {
	            ex.printStackTrace();
	        }
	        finally
	        {
	            if (em != null)
	            {
	                em.close();
	            }
	            
	            if (em2 != null)
	            {
	                em2.close();
	            }

	        }
	}
	
}
