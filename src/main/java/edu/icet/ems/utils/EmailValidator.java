package edu.icet.ems.utils;

import org.springframework.util.StringUtils;

import java.util.regex.Pattern;

public class EmailValidator {

    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    public static boolean isValidEmail(String email) {
        if (StringUtils.hasText(email)) {
            return false;
        }

        // Validate the email against the regex pattern
        return EMAIL_PATTERN.matcher(email).matches();
    }
}
