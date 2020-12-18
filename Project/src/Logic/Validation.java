package Logic;

import java.security.PublicKey;

import javax.lang.model.util.ElementScanner6;

public class Validation {
    
    public boolean ValidateName(String Name){
        boolean valid;
        valid = Name.matches("(?i)(^[a-z])((?![ .,'-]$)[a-z .,'-]){0,24}$");
        return valid;
    }

    public boolean ValidateUrl(String Url){
        boolean valid;
        valid = Url.matches("https://(.*)");
        return valid;
    }

    public boolean ValidateEmail(String Email){
        boolean valid;
        valid = Email.matches("(.*)@(.*)");
        return valid;
    }

    //float punt
    public boolean ValidateGrade(String Name){
        if (Name.equals("goed")) {
            return true;
        }else{
            return false;
        }
    }

    public boolean ValidatePercentage(int Percentage){
        if (Percentage >= 0 && Percentage <= 100) {
            return true;
        }else{
            return false;
        }
    }

    //datum nog doen
    public boolean ValidateDate(String Name){
        return true;
    }

    //check op cijfers en nummers
    public boolean ValidatePostalCode(String PostalCode){
        if (PostalCode.length() < 6) {
            return true;
        }else{
            return false;
        }
    }

}
