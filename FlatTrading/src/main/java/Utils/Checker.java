package Utils;


public class Checker {

    public String isPassword(String s){

        String reg = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\\s).*$";
        if(s.matches(reg))
            return null;
        else return "Password incorrect. Password should has uppercase and lowercase letters, numbers";
    }

    public String isLogin(String s){
        String reg = "^[-\\w.]+@([A-z0-9][-A-z0-9]+\\.)+[A-z]{2,4}$";
        if(s.matches(reg))
            return null;
        else return "It's not email. Please write correct email.";
    }
    public String isDigits(String s){
        String reg = "^\\d+$";
        if(s.matches(reg))
            if(s.length()<4)
                if(Integer.parseInt(s)>=0)
                    return null;
                else return "The number must be non-negative.";
            else
                return "Please enter a valid number.";
        else return "Enter the number.";
    }
    public String isLetters(String s){
        String reg = "^[A-zА-яЁё]+$";
        if(s.matches(reg))
            return null;
        else return "Enter the word correctly. You can only use Latin and Cyrillic letters.";
    }

    public String isPhone(String s){
        String reg = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$";
        if (s.matches(reg))
            return null;
        else
            return "The phone number you entered is invalid.";
    }
}
