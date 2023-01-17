package ma.swblockspreview.bean;

import ma.swblockspreview.BlockPreviewer;

public class nA {
    public String toString(nA var1) {
        StringBuffer var2 = new StringBuffer();
        var2.append("[");
        java.lang.reflect.Field[] var4 = var1.getClass().getFields();
        int var5 = var4.length;

        for (int var6 = 0; var6 < var5; ++var6) {
            java.lang.reflect.Field var8 = var4[var6];
            if (!java.lang.reflect.Modifier.isStatic(var8.getModifiers()) && java.lang.reflect.Modifier.isPublic(var8.getModifiers())) {
                try {
                    var2.append(var8.getName());
                    var2.append("=");
                    var2.append(var8.get(var1));
                    var2.append(",");
                } catch (Exception var10) {
                    var10.printStackTrace();
                }
            }
        }

        var2.append("]");
        return var2.toString();
    }
}
