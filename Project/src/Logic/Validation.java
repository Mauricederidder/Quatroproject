package Logic;

//import domain;

import java.security.PublicKey;

import javax.lang.model.util.ElementScanner6;

import domain.Course;

import domain.Person;

import domain.Student;

import java.text.SimpleDateFormat;

import java.util.Date;

import java.text.ParseException;

public class Validation {
    
    public boolean validateName(String Name){
        boolean valid = true;
        valid = Name.matches("(?i)(^[a-z])((?![ .,'-]$)[a-z .,'-]){0,24}$");
        return valid;
    }

    public boolean validateUrl(String Url){
        boolean valid;
        valid = Url.matches("https://(.*)");
        return valid;
    }

    public boolean validateEmail(String Email){
        boolean valid;
        valid = Email.matches("(.*)@(.*)");
        return valid;
    }

    //float punt
    public boolean validateGrade(float Grade){
        if (Grade >= 0 && Grade <= 100) {
            return true;
        }else{
            return false;
        }
    }

    public boolean validatePercentage(int Percentage){
        if (Percentage >= 0 && Percentage <= 100) {
            return true;
        }else{
            return false;
        }
    }

    // //datum nog doen
    // public boolean validateDate(String strDate){
    //     /* Check if date is 'null' */
	//     if (strDate.trim().equals(""))
	//         {
	//             return true;
	//         }
	//         /* Date is not 'null' */
	//         else
	//         {
	//         /*
	//          * Set preferred date format,
	//          * For example MM-dd-yyyy, MM.dd.yyyy,dd.MM.yyyy etc.*/
	//         SimpleDateFormat sdfrmt = new SimpleDateFormat("MM/dd/yyyy");
	//         sdfrmt.setLenient(false);
	//         /* Create Date object
	//          * parse the string into date 
    //              */
	//         try
	//         {
	//             Date javaDate = sdfrmt.parse(strDate); 
	//             System.out.println(strDate+" is valid date format");
	//         }
	//         /* Date format is invalid */
	//         catch (ParseException e)
	//         {
	//             System.out.println(strDate+" is Invalid Date format");
	//             return false;
	//         }
	//         /* Return true if date format is valid */
	//         return true;
	//     }
    // }

    public boolean validateDate(Date date){
        return true;
    }

    public boolean validateGender(String gender){
        if (gender.equals("Male") || gender.equals("Female")|| gender.equals("Other") ) {
            return true;
        }else{
            return false;
        }
    }

    //check op cijfers en nummers
    public boolean validatePostalCode(String PostalCode){
        boolean validPostalCode = true;
        if (PostalCode.length() == 6) {
            for (int i = 0 ; i != PostalCode.length() ; i++) {
                char c = PostalCode.charAt(i);
                if ((i >= 0) &&  (i < 4)) {
                    if (Character.isDigit(c)) {
                        validPostalCode = false;
                    }
                }
                if ((i >= 0) &&  (i < 4)) {
                    if (Character.isAlphabetic(c)) {
                        validPostalCode = false;
                    }
                }                                             
            }
        }else{
            validPostalCode = false;
        }
        return validPostalCode;
    }

    public boolean validatePerson(Person person){
        if (validateName(person.getName()) && 
        validatePostalCode(person.getPostalCode()) &&
        validateEmail(person.getEmail()) &&
        validateDate(person.getDayOfBirth()) &&
        validateGender(person.getGender()))
        {
         return true;
        }
        //person.getAdress();
        return false;
    }

    public boolean validateCourse(Course course){
        if (validateName(course.getCourseName()) 
         ) {
            
        }
        return true;
    }

}
