import java.util.regex.Matcher;
import java.util.regex.Pattern;

class CodeValidator {

    public static String  regex (String code){

        Pattern pattern = Pattern.compile("[A-Z]{3}");
        Matcher m = pattern.matcher(code);
        if (m.matches()){
            return "";
        }else {
            return "Please fix your code Mr.";
        }
    }

}
