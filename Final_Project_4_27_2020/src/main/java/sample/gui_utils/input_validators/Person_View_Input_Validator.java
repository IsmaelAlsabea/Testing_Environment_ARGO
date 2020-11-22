package sample.gui_utils.input_validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.scene.control.Alert;
import sample.PersonViewController;

public class Person_View_Input_Validator {

	
	private static Person_View_Input_Validator validator;
	
    private String errorMsg = "";
	
	private Person_View_Input_Validator () {
		
	}
	
	public static Person_View_Input_Validator getInstance() {
		
		if (validator == null) {
			validator= new Person_View_Input_Validator();
		}
		
		return validator;
	}
	
	
	
	public boolean inputValidate(PersonViewController pvc) {

        boolean firstnameResult = validateFirstName(pvc.getFirstName());
        boolean lastnameResult = validateLastName(pvc.getLastName());
        boolean dobResult = validateDOB(pvc.getDOB());
        boolean creditScoreResult = validateCreditScore(pvc.getCreditScore());
        boolean ssnResult =  validateSSN(pvc.getSSN());
        boolean emailResult = validateEmail(pvc.getEmail());
        boolean phoneResult = validatePhoneNumber(pvc.getTelephone());

        if(firstnameResult && /*lastnameResult &&*/ dobResult && creditScoreResult &&
                ssnResult && emailResult && phoneResult) {
            System.out.println("Person Validation Correct");
            return true;
        }
        else {
            System.out.println("Person Validation Incorrect");
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("Input not valid");
            errorAlert.setContentText(errorMsg);
            errorAlert.showAndWait();
            errorMsg = "";
            return false;
        }
    }

    //limit is char (20)
    private boolean validateFirstName(String firstName) {
        if(firstName.length() > 20) {
            errorMsg += "First name cannot exceed 20 characters\n";
            return false;
        }

        return true;
    }

    //limit is char (20)
    private boolean validateLastName(String lastName) {
        if(lastName.length() > 20) {
            errorMsg += "Last name cannot exceed 20 characters\n";
            return false;
        }

        return true;
    }

    //as I understand it from screenshots, DOB = YYYY-MM-DD
    private boolean validateDOB(String DOB) {
        String regex = "\\d{4}-\\d{2}-\\d{2}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher;

        if(DOB.length() > 0) {
            matcher = pattern.matcher(DOB);
            if(matcher.matches() == true) { /* we good, dob is valid */ }
            else {
                errorMsg += "DOB is not valid. Must be YYYY-MM-DD\n";
                return false;
            }
        }

        return true;
    }

    //length is nvarchar(9)
    private boolean validateSSN(String ssn) {
        String regex = "^(?!000|666)[0-8][0-9]{2}-(?!00)[0-9]{2}-(?!0000)[0-9]{4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher;

        if(ssn.length() > 0) {
            matcher = pattern.matcher(ssn);
            if(matcher.matches() == true) { /* we good, ssn is valid */ }
            else {
                errorMsg += "SSN is not valid. Must be formatted as xxx-xx-xxxx\n";
                return false;
            }
        }

        return true;
    }

    //length is nvarchar(4)
    private boolean validateCreditScore(String creditScore) {
        if(creditScore.length() > 0 && creditScore.length() < 4) {
            try {
                Integer.parseInt(creditScore);
            } catch (Exception error) {
                errorMsg += "Credit Score is not a number\n";
                return false;
            }
        }
        else if (creditScore.length() >= 4){
            errorMsg += "Credit Score can only be 3 digits long.\n";
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
}
