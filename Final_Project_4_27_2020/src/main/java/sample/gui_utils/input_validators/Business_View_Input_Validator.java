package sample.gui_utils.input_validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.scene.control.Alert;
import sample.BusinessViewController;

public class Business_View_Input_Validator {

	
	private static Business_View_Input_Validator validator;
	
    private String errorMsg = "";
	
	private Business_View_Input_Validator () {
		
	}
	
	public static Business_View_Input_Validator getInstance() {
		
		if (Business_View_Input_Validator.validator == null) {
			validator= new Business_View_Input_Validator();
		}
		
		return validator;
	}
	
	
	public  boolean inputValidate(BusinessViewController bvc) {

        boolean yearEstResult = validateYearEst(bvc.getYearEstablished());
        boolean phoneResult = validatePhoneNumber(bvc.getTelephone());
        boolean emailResult = validateEmail(bvc.getEmail());
        boolean zipcodeResult = validateZipcode(bvc.getZipCode());

        if(yearEstResult && phoneResult && emailResult && zipcodeResult && emailResult && phoneResult) {
            System.out.println("Business Validation Correct");
            return true;
        }
        else {
            System.out.println("Business Validation Incorrect");
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("Input not valid");
            errorAlert.setContentText(errorMsg);
            errorAlert.showAndWait();
            errorMsg = "";
            return false;
        }
    }

    private boolean validateYearEst(String yearEstablished) {
        if(yearEstablished.length() == 4) {
            try {
                Integer.parseInt(yearEstablished);
            } catch (Exception error) {
                errorMsg += "Year is not a number\n";
                return false;
            }
        }
        else if (yearEstablished.length() != 0){
            errorMsg += "Year must be 4 digits long.\n";
            return false;
        }

        return true;
    }

    //length is nvarchar(10)
    private boolean validatePhoneNumber(String telephone) {
        String regex = "^\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4})$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher;

        if(telephone.length() > 0 /*&& getTelephone().length() <= 10*/) {
            matcher = pattern.matcher(telephone);
            if(matcher.matches() == true) { /* we good, phone is valid */ }
            else {
                errorMsg += "Phone number is not valid.\n";
                return false;
            }
        }
        /* else if (getTelephone().length() > 10) {
            errorMsg += "Phone number is greater than 10 characters.\n";
        } */

        return true;
    }

    //length is nvarchar(40)
    private boolean validateEmail(String email) {
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher;

        if(email.length() > 0 && email.length() <= 40) {
            matcher = pattern.matcher(email);
            if(matcher.matches() == true) { /* we good, email is valid */ }
            else {
                errorMsg += "Email is not valid.\n";
                return false;
            }
        }
        else if (email.length() > 40){
            errorMsg += "Email is greater than 10 characters\n";
            return false;
        }

        return true;
    }

    // Reference: https://howtodoinjava.com/regex/us-postal-zip-code-validation/
    private boolean validateZipcode(String zipCode) {
        String regex = "^[0-9]{5}(?:-[0-9]{4})?$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher;

        if(zipCode.length() > 0) {
            matcher = pattern.matcher(zipCode);
            if(matcher.matches() == true) { /* we good, zip code is valid */ }
            else {
                errorMsg += "Zip Code is not a valid zip code\n";
                return false;
            }
        }

        return true;
    }
	
}
