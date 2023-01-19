package ma.swblockspreview.util;

import java.util.ArrayList;

public class StringUtils {


    public static class StringTokenizer {
        public String a;
        public int b;

        public StringTokenizer(String var1) {
            a = var1;
            b = 0;
        }

        public boolean a() {
            return b >= a.length();
        }

        public String b() {
            c();
            boolean var1 = a();
            StringBuilder var2 = new StringBuilder();
            if (!var1) {
                boolean var3 = false;
                int var4 = b;

                while (b < a.length()) {
                    if (a.charAt(b) == 32) {
                        return var2.toString();
                    }

                    char var5 = a.charAt(b);
                    if (var5 == 92) {
                        var2.append(var5 + a.charAt(1 + b));
                        b += 2;
                    } else {
                        if (var5 == 37) {
                            if (b > var4) {
                                return var2.toString();
                            }

                            var3 = true;
                        }

                        if (var3) {
                            if (var5 == 63) {
                                break;
                            }

                            if (var5 == 45) {
                                return var2.toString();
                            }
                        }

                        String var9 = String.valueOf(var2) + var5;
                        var2 = new StringBuilder(var9);
                        ++b;
                    }
                }

            }
            return var2.toString();
        }

        public void c() {
            while (b < a.length() && a.charAt(b) == 32) {
                ++b;
            }

        }
    }


    public static ArrayList<String> c(String var0) {
        ArrayList<String> var1 = new ArrayList<>();
        StringTokenizer var2 = new StringTokenizer(var0);

        while (!var2.a()) {
            String var3 = var2.b();
            if (var3.length() > 0) {
                var1.add(var3);
            }
        }

        return var1;
    }

    public static String d(String var0) {
        StringBuilder var1 = new StringBuilder();

        for (int var2 = 0; var2 < var0.length(); ++var2) {
            char var3 = var0.charAt(var2);
            if (var3 == 92) {
                StringBuilder var4 = new StringBuilder();
                var4.append(var1);
                ++var2;
                var4.append(var0.charAt(var2));
                var1 = new StringBuilder(var4.toString());
            } else {
                var1.append(var3);
            }
        }

        return var1.toString();
    }
}
