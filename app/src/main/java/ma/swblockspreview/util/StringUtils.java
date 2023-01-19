package ma.swblockspreview.util;

import java.util.ArrayList;

public class StringUtils {

    public static class StringTokenizer {
        public String src;
        public int index;

        public StringTokenizer(String text) {
            src = text;
            index = 0;
        }

        public boolean atEnd() {
            return index >= src.length();
        }

        public String nextToken() {
            skipWhiteSpace();
            boolean atEnd = atEnd();
            StringBuilder stringBuilder = new StringBuilder();
            if (!atEnd) {
                boolean isArg = false;
                int startIndex = index;

                while (index < src.length()) {
                    if (src.charAt(index) == 32) {
                        return stringBuilder.toString();
                    }

                    char var5 = src.charAt(index);
                    if (var5 == 92) {
                        stringBuilder.append(var5 + src.charAt(1 + index));
                        index += 2;
                    } else {
                        if (var5 == 37) {
                            if (index > startIndex) {
                                return stringBuilder.toString();
                            }

                            isArg = true;
                        }

                        if (isArg) {
                            if (var5 == 63) {
                                break;
                            }

                            if (var5 == 45) {
                                return stringBuilder.toString();
                            }
                        }

                        String var9 = String.valueOf(stringBuilder) + var5;
                        stringBuilder = new StringBuilder(var9);
                        ++index;
                    }
                }

            }
            return stringBuilder.toString();
        }

        public void skipWhiteSpace() {
            while (index < src.length() && src.charAt(index) == 32) {
                ++index;
            }
        }
    }


    public static ArrayList<String> tokenize(String text) {
        ArrayList<String> tokenList = new ArrayList<>();
        StringTokenizer stringTokenizer = new StringTokenizer(text);

        while (!stringTokenizer.atEnd()) {
            String nextToken = stringTokenizer.nextToken();
            if (nextToken.length() > 0) {
                tokenList.add(nextToken);
            }
        }

        return tokenList;
    }

    public static String unescape(String text) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < text.length(); ++i) {
            char charAt = text.charAt(i);
            if (charAt == 92) {
                StringBuilder sb = new StringBuilder();
                sb.append(stringBuilder);
                ++i;
                sb.append(text.charAt(i));
                stringBuilder = new StringBuilder(sb.toString());
            } else {
                stringBuilder.append(charAt);
            }
        }

        return stringBuilder.toString();
    }
}
