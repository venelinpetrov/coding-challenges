package com.vpe;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/*
    This problem was asked by Microsoft.

    Implement a URL shortener with the following methods:

    shorten(url), which shortens the url into a six-character alphanumeric string, such as zLg6wl.
    restore(short), which expands the shortened string into the original url. If no such shortened string exists, return null.
    Hint: What if we enter the same URL twice?
 */
public class URLShortener {
    private static final int CODE_LENGTH = 6;
    private static final String CHARSET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    private final Map<String, String> codeToUrl;
    private final Map<String, String> urlToCode;
    private final Random random;

    public URLShortener() {
        codeToUrl = new HashMap<>();
        urlToCode = new HashMap<>();
        random = new Random();
    }

    public String shorten(String url) {
        if (urlToCode.containsKey(url)) {
            return urlToCode.get(url);
        }

        String code;

        do {
            code = generateCode();
        } while (codeToUrl.containsKey(code));

        codeToUrl.put(code, url);
        urlToCode.put(url, code);

        return code;
    }

    public String restore(String code) {
        return codeToUrl.getOrDefault(code, null);
    }

    private String generateCode() {
        var sb = new StringBuilder(CODE_LENGTH);
        for (int i = 0; i < CODE_LENGTH; i++) {
            var randChar = CHARSET.charAt(random.nextInt(0, CHARSET.length()));
            sb.append(randChar);
        }

        return sb.toString();
    }
}
