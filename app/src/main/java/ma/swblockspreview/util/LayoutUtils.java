package ma.swblockspreview.util;

import android.content.Context;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class LayoutUtils {
    public static float getDip(Context var0, float var1) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, var1, var0.getResources().getDisplayMetrics());
    }

    public static View inflate(Context var0, ViewGroup var1, int var2) {
        return ((LayoutInflater) var0.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(var2, var1, true);
    }
}
