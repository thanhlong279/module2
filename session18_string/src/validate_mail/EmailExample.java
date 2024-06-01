package validate_mail;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailExamply {
    private static Pattern pattern;
    private Matcher matcher;

    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    public EmailExamply() {
        pattern = Pattern.compile(EMAIL_REGEX);
    }

    public boolean validate(String email){
        matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
