package ma.swblockspreview.editor;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.widget.TextView;

import ma.swblockspreview.util.kq;

public class Ss extends Ts {
    public Context T;
    public Object U = "";
    public TextView V;
    public TextView W;
    public int aa = 20;
    public int ba = 4;
    public int ca = 2;
    public int da = 0;
    public int ea = 0;

    public Ss(Context context, String str, String str2) {
        super(context, str, str2, true);
        T = context;
        as(context);
    }

    private void as(Context var1) {
        byte var4;
        label68:
        {
            String var2 = super.b;
            int var3 = var2.hashCode();
            if (var3 != 98) {
                if (var3 != 100) {
                    if (var3 != 115) {
                        if (var3 != 109) {
                            if (var3 == 110 && var2.equals("n")) {
                                var4 = 2;
                                break label68;
                            }
                        } else if (var2.equals("m")) {
                            var4 = 4;
                            break label68;
                        }
                    } else if (var2.equals("s")) {
                        var4 = 3;
                        break label68;
                    }
                } else if (var2.equals("d")) {
                    var4 = 1;
                    break label68;
                }
            } else if (var2.equals("b")) {
                var4 = 0;
                break label68;
            }

            var4 = -1;
        }

        if (var4 != 0) {
            if (var4 != 1) {
                if (var4 != 2) {
                    if (var4 != 3) {
                        if (var4 == 4) {
                            super.e = 805306368;
                        }
                    } else {
                        super.e = -1;
                    }
                } else {
                    super.e = -3155748;
                }
            } else {
                super.e = -657931;
            }
        } else {
            super.e = 1342177280;
            aa = 25;
        }

        float var5 = (float) aa;
        float var6 = super.D;
        aa = (int) (var5 * var6);
        ba = (int) (var6 * (float) ba);
        ca = (int) (var6 * (float) ca);
        da = ca;
        if (super.b.equals("m") && a(super.c).length() >= 0) {
            W = b(super.c);
            addView(W);
            da = getDropdownTypeWidth();
        }

        if (super.b.equals("m") || super.b.equals("d") || super.b.equals("n") || super.b.equals("s")) {
            V = c("");
            addView(V);
        }

        a((float) (aa + da), (float) super.G, false);
    }

    private int getDropdownTypeWidth() {
        Rect rect = new Rect();
        Paint paint = W.getPaint();
        String a = a(c);
        paint.getTextBounds(a, 0, a.length(), rect);
        return rect.width() + (ca * 2);
    }

    private int getLabelWidth() {
        Rect rect = new Rect();
        V.getPaint().getTextBounds(V.getText().toString(), 0, V.getText().length(), rect);
        return rect.width() + ba;
    }

    public final String a(String str) {
        String b = kq.b(str);
        if (b.length() <= 0) {
            return b;
        }
        return b + " : ";
    }

    public final TextView b(String str) {
        TextView textView = new TextView(T);
        textView.setText(a(str));
        textView.setTextSize(8.0f);
        textView.setTypeface(null, Typeface.BOLD);
        LayoutParams layoutParams = new LayoutParams(-2, G);
        int i = ca;
        layoutParams.setMargins(i, 0, i, 0);
        textView.setPadding(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setBackgroundColor(0);
        textView.setSingleLine();
        textView.setGravity(17);
        textView.setTextColor(-1);
        return textView;
    }

    public final TextView c(String str) {
        TextView textView = new TextView(T);
        textView.setText(str);
        textView.setTextSize(9.0f);
        LayoutParams layoutParams = new LayoutParams(aa, G);
        layoutParams.setMargins(da, 0, ea, 0);
        textView.setPadding(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setBackgroundColor(0);
        textView.setSingleLine();
        textView.setGravity(17);
        if (b.equals("m")) {
            textView.setTextColor(-251658241);
        } else {
            textView.setTextColor(-268435456);
        }
        return textView;
    }

    public Object getArgValue() {
        return (b.equals("d") || b.equals("m") || b.equals("s")) ? V.getText() : U;
    }

    public String getMenuName() {
        return c;
    }

    public void setArgValue(Object obj) {
        U = obj;
        if (b.equals("d") || b.equals("m") || b.equals("s")) {
            V.setText(obj.toString());
            int max = Math.max(aa, getLabelWidth());
            V.getLayoutParams().width = max;
            a((float) (max + da), (float) G, true);
        }
    }
}
