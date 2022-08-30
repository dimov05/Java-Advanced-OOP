package InterfaceAndAbstractionExercise.Telephony;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Smartphone implements Callable, Browsable {
    private List<String> numbers;
    private List<String> urls;
    private static final String PHONE_REGEX = "^[0-9]+$";
    private static final String URL_REGEX = "^\\D+$";

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder sb = new StringBuilder();
        Pattern pattern = Pattern.compile(URL_REGEX, Pattern.MULTILINE);
        for (String url : this.urls) {
            if (this.matchesRegex(url, pattern)) {
                sb.append(String.format("Browsing: %s!%n", url));
            } else {
                sb.append(String.format("Invalid URL!%n"));
            }
        }
        return sb.toString();
    }

    @Override
    public String call() {
        StringBuilder sb = new StringBuilder();
        Pattern pattern = Pattern.compile(PHONE_REGEX, Pattern.MULTILINE);
        for (String number : this.numbers) {
            if (this.matchesRegex(number, pattern)) {
                sb.append(String.format("Calling... %s%n", number));
            } else {
                sb.append(String.format("Invalid number!%n"));
            }
        }
        return sb.toString();
    }

    private boolean matchesRegex(String input, Pattern pattern) {
        final Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
}
