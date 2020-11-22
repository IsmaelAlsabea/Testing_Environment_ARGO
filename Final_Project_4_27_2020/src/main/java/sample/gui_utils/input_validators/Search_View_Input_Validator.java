package sample.gui_utils.input_validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.scene.control.Alert;
import sample.SearchController;

public class Search_View_Input_Validator {

	private static Search_View_Input_Validator validator;
	
    private String errorMsg = "";
	
    private Search_View_Input_Validator () {
	}
	
	
	public static Search_View_Input_Validator getInstance() {
		
		if (Search_View_Input_Validator.validator == null) {
			validator= new Search_View_Input_Validator();
		}
		
		return validator;
	}
	
	

    public boolean inputValidate(SearchController sc) {

        boolean ageResult = validateAge(sc.getAge());
        boolean zipcodeResult = validateZipcode(sc.getZipCode());
        boolean creditLowResult = validateCreditLow(sc.getCreditLow());
        boolean creditHighResult = validateCreditHigh(sc.getCreditHigh());

        if(ageResult && zipcodeResult && creditLowResult && creditHighResult)
            return true;
        else {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("Input not valid");
            errorAlert.setContentText(errorMsg);
            errorAlert.showAndWait();
            errorMsg = "";
            return false;
        }
    }

    private boolean validateAge(String age) {
        if(age.length() > 0 && age.length() < 4) {
            try {
                Integer.parseInt(age);
            } catch (Exception error) {
                errorMsg += "Age is not a number\n";
                return false;
            }
        }
        else if (age.length() >= 4){
            errorMsg += "Age can only be 3 digits long.\n";
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

    private boolean validateCreditLow(String creditLow) {
        if(creditLow.length() > 0 && creditLow.length() < 4) {
            try {
                Integer.parseInt(creditLow);
            } catch (Exception error) {
                errorMsg += "Credit Score (Low) is not a number\n";
                return false;
            }
        }
        else if (creditLow.length() >= 4){
            errorMsg += "Credit Score (Low) can only be 3 digits long.\n";
            return false;
        }

        return true;
    }

    private boolean validateCreditHigh(String creditHigh) {
        if(creditHigh.length() > 0 && creditHigh.length() < 4) {
            try {
                Integer.parseInt(creditHigh);
            } catch (Exception error) {
                errorMsg += "Credit Score (High) is not a number\n";
                return false;
            }
        }
        else if (creditHigh.length() >= 4) {
            errorMsg += "Credit Score (High) can only be 3 digits long.\n";
            return false;
        }

        return true;
    }

}
