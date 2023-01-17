package ma.swblockspreview.editor;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.widget.RelativeLayout;
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
        this.T = context;
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
            this.aa = 25;
        }

        float var5 = (float) this.aa;
        float var6 = super.D;
        this.aa = (int) (var5 * var6);
        this.ba = (int) (var6 * (float) this.ba);
        this.ca = (int) (var6 * (float) this.ca);
        this.da = this.ca;
        if (super.b.equals("m") && this.a(super.c).length() >= 0) {
            this.W = this.b(super.c);
            this.addView(this.W);
            this.da = this.getDropdownTypeWidth();
        }

        if (super.b.equals("m") || super.b.equals("d") || super.b.equals("n") || super.b.equals("s")) {
            this.V = this.c("");
            this.addView(this.V);
        }

        this.a((float) (this.aa + this.da), (float) super.G, false);
    }

    private int getDropdownTypeWidth() {
        Rect rect = new Rect();
        Paint paint = this.W.getPaint();
        String a = a(this.c);
        paint.getTextBounds(a, 0, a.length(), rect);
        return rect.width() + (this.ca * 2);
    }

    private int getLabelWidth() {
        Rect rect = new Rect();
        this.V.getPaint().getTextBounds(this.V.getText().toString(), 0, this.V.getText().length(), rect);
        return rect.width() + this.ba;
    }

    public final String a(String str) {
        String b = kq.b(str);
        if (b.length() <= 0) {
            return b;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(b);
        stringBuilder.append(" : ");
        return stringBuilder.toString();
    }

    public final TextView b(String str) {
        TextView textView = new TextView(this.T);
        textView.setText(a(str));
        textView.setTextSize(8.0f);
        textView.setTypeface(null, Typeface.BOLD);
        LayoutParams layoutParams = new LayoutParams(-2, this.G);
        int i = this.ca;
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
        TextView textView = new TextView(this.T);
        textView.setText(str);
        textView.setTextSize(9.0f);
        LayoutParams layoutParams = new LayoutParams(this.aa, this.G);
        layoutParams.setMargins(this.da, 0, this.ea, 0);
        textView.setPadding(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setBackgroundColor(0);
        textView.setSingleLine();
        textView.setGravity(17);
        if (this.b.equals("m")) {
            textView.setTextColor(-251658241);
        } else {
            textView.setTextColor(-268435456);
        }
        return textView;
    }

    public Object getArgValue() {
        return (this.b.equals("d") || this.b.equals("m") || this.b.equals("s")) ? this.V.getText() : this.U;
    }

    public String getMenuName() {
        return this.c;
    }

    public void setArgValue(Object obj) {
        this.U = obj;
        if (this.b.equals("d") || this.b.equals("m") || this.b.equals("s")) {
            this.V.setText(obj.toString());
            int max = Math.max(this.aa, getLabelWidth());
            this.V.getLayoutParams().width = max;
            a((float) (max + this.da), (float) this.G, true);
        }
    }
}
