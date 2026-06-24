package co.com.certification.practiceautomatedtesting.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Utils {

    public String formatToLowerCaseSlug(String text) {
        if (text == null) {
            return "";
        }
        return text.trim()
                .toLowerCase()
                .replaceAll("\\s+", "-");
    }
}
