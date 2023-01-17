package ma.swblockspreview.util;

import android.content.ClipData;
import android.content.Context;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

import ma.swblockspreview.BlockPreviewer;

public class FB {


    public static class FB$a {
        public String a;
        public int b;

        public FB$a(String var1) {
            this.a = var1;
            this.b = 0;
        }

        public boolean a() {
            return this.b >= this.a.length();
        }

        public String b() {
            this.c();
            boolean var1 = this.a();
            String var2 = "";
            if (var1) {
                return var2;
            } else {
                boolean var3 = false;
                int var4 = this.b;

                while (this.b < this.a.length()) {
                    if (this.a.charAt(this.b) == 32) {
                        return var2;
                    }

                    char var5 = this.a.charAt(this.b);
                    if (var5 == 92) {
                        StringBuilder var6 = new StringBuilder();
                        var6.append(var2);
                        var6.append(var5 + this.a.charAt(1 + this.b));
                        var2 = var6.toString();
                        this.b += 2;
                    } else {
                        if (var5 == 37) {
                            if (this.b > var4) {
                                return var2;
                            }

                            var3 = true;
                        }

                        if (var3) {
                            if (var5 == 63) {
                                break;
                            }

                            if (var5 == 45) {
                                return var2;
                            }
                        }

                        StringBuilder var9 = new StringBuilder();
                        var9.append(var2);
                        var9.append(var5);
                        var2 = var9.toString();
                        ++this.b;
                    }
                }

                return var2;
            }
        }

        public void c() {
            while (this.b < this.a.length() && this.a.charAt(this.b) == 32) {
                ++this.b;
            }

        }
    }


    public static int a(char var0) {
        if (var0 >= 48 && var0 <= 57) {
            return var0 - 48;
        } else {
            byte var1 = 65;
            if (var0 < var1 || var0 > 70) {
                var1 = 97;
                if (var0 < var1 || var0 > 102) {
                    StringBuilder var2 = new StringBuilder("invalid hex digit \'");
                    var2.append(var0);
                    var2.append("\'");
                    throw new IllegalArgumentException(var2.toString());
                }
            }

            return 10 + (var0 - var1);
        }
    }

    public static String a() {
        Random var0 = new Random();

        int var1;
        for (var1 = var0.nextInt(100000); var1 < 10000 || var1 > 99999; var1 = var0.nextInt(100000)) {
            ;
        }

        return String.valueOf(var1);
    }

    public static String a(int var0) {
        if (var0 < 0) {
            return "0";
        } else {
            float var1 = (float) var0;
            if (var1 >= 1024.0F && var1 < 1048576.0F) {
                float var7 = var1 / 1024.0F;
                return (new DecimalFormat("#.#KB")).format((double) var7);
            } else if (var1 >= 1048576.0F && var1 < 1.07374182E9F) {
                float var6 = var1 / 1048576.0F;
                return (new DecimalFormat("#.#MB")).format((double) var6);
            } else if (var1 >= 1.07374182E9F && var1 < 1.09951163E12F) {
                float var5 = var1 / 1.07374182E9F;
                return (new DecimalFormat("#.#GB")).format((double) var5);
            } else {
                StringBuilder var2 = new StringBuilder();
                var2.append(String.valueOf(var0));
                var2.append("B");
                return var2.toString();
            }
        }
    }

    public static String a(byte[] var0) {
        StringBuffer var1 = new StringBuffer(2 * var0.length);

        for (int var2 = 0; var2 < var0.length; ++var2) {
            if ((255 & var0[var2]) < 16) {
                var1.append("0");
            }

            var1.append(Long.toString((long) (255 & var0[var2]), 16));
        }

        return var1.toString();
    }

    public static void a(Context var0, String var1, String var2) {
        ((android.content.ClipboardManager) var0.getSystemService(Context.CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText(var1, var2));
    }

    public static byte[] a(String var0) {
        int var1 = var0.length();
        byte[] var2 = new byte[(var1 + 1) / 2];
        int var3 = var1 % 2;
        int var4 = 0;
        int var5 = 1;
        if (var3 == var5) {
            var2[0] = (byte) a(var0.charAt(0));
            var4 = 1;
        } else {
            var5 = 0;
        }

        while (var4 < var1) {
            int var6 = var5 + 1;
            int var7 = var4 + 1;
            int var8 = a(var0.charAt(var4)) << 4;
            int var9 = var7 + 1;
            var2[var5] = (byte) (var8 | a(var0.charAt(var7)));
            var5 = var6;
            var4 = var9;
        }

        return var2;
    }

    public static String b(int var0) {
        float var1 = (float) var0;
        if (var1 >= 1000.0F && var1 < 1000000.0F) {
            float var4 = var1 / 1000.0F;
            return (new DecimalFormat("#.#K")).format((double) var4);
        } else if (var1 >= 1000000.0F && var1 < 1.0E9F) {
            float var3 = var1 / 1000000.0F;
            return (new DecimalFormat("#.#M")).format((double) var3);
        } else if (var1 >= 1.0E9F && var1 < 1.0E12F) {
            float var2 = var1 / 1.0E9F;
            return (new DecimalFormat("#.#G")).format((double) var2);
        } else {
            return String.valueOf(var0);
        }
    }

    public static boolean b(String var0) {
        try {
            Double.parseDouble(var0);
            return true;
        } catch (NumberFormatException var1) {
            return false;
        }
    }

    public static String c(int var0) {
        return (new DecimalFormat("#,###")).format((long) var0);
    }

    public static ArrayList c(String var0) {
        ArrayList var1 = new ArrayList();
        FB$a var2 = new FB$a(var0);

        while (!var2.a()) {
            String var3 = var2.b();
            if (var3.length() > 0) {
                var1.add(var3);
            }
        }

        return var1;
    }

    public static String d(String var0) {
        String var1 = "";

        for (int var2 = 0; var2 < var0.length(); ++var2) {
            char var3 = var0.charAt(var2);
            if (var3 == 92) {
                StringBuilder var4 = new StringBuilder();
                var4.append(var1);
                ++var2;
                var4.append(var0.charAt(var2));
                var1 = var4.toString();
            } else {
                StringBuilder var7 = new StringBuilder();
                var7.append(var1);
                var7.append(var3);
                var1 = var7.toString();
            }
        }

        return var1;
    }
}
