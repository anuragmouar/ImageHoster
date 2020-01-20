package ImageHoster.service;

import org.springframework.stereotype.Controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This component class has purpose to verify password rule set in application :
 * password entered by the user must contain at least 1 alphabet (a-z or A-Z), 1 number (0-9)
 * and 1 special character (any character other than a-z, A-Z and 0-9)
 */
@Controller
public class PasswordValidator {
    private Pattern pattern;
    private Matcher matcher;

    //Regular expression for Password pattern
    private static final String PASSWORD_PATTERN = "^(?=\\D*\\d)(?=.*?[a-zA-Z]).*[\\W_].*$";

    public PasswordValidator() {
        pattern = Pattern.compile(PASSWORD_PATTERN);
    }

    /**
     * Method to validate password pattern
     * @param password
     * @return
     */
    public boolean validate(final String password) {
        matcher = pattern.matcher(password);
        return matcher.matches();
    }
}