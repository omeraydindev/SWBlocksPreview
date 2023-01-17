package ma.swblockspreview.editor;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.widget.RelativeLayout;

import ma.swblockspreview.util.Gx;
import ma.swblockspreview.util.mq;
import ma.swblockspreview.util.LayoutUtils;

public class Ts extends RelativeLayout {
    public int A;
    public int B;
    public int C;
    public float D;
    public Rs E;
    public int F;
    public int G;
    public int H;
    public int I;
    public int J;
    public boolean K;
    public boolean L;
    public Paint M;
    public Paint N;
    public Paint O;
    public int P;
    public int Q;
    public int R;
    public Gx S;
    public Context a;
    public String b;
    public String c;
    public int d;
    public int e;
    public Paint f;
    public boolean g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public int u;
    public int v;
    public int w;
    public int x;
    public int y;
    public int z;

    public Ts(Context var1, String var2, String var3, boolean var4) {
        super(var1);
        h = 3;
        i = 12;
        j = 15;
        k = 3;
        l = 2;
        m = 15;
        n = 15;
        o = 15;
        int var5 = o;
        int var6 = h;
        p = var5 + var6;
        q = 10 + p;
        r = var6 + q;
        s = 6;
        t = 60;
        u = 2;
        v = 2;
        w = 3;
        x = 0;
        y = 2;
        int var7 = i;
        B = var7;
        C = var7;
        E = null;
        F = 100;
        G = 14;
        H = 15;
        I = 6;
        J = 4;
        K = false;
        L = false;
        P = 1;
        Q = 1;
        R = 805306368;
        S = null;
        a = var1;
        b = var2;
        if (var3 != null && var3.indexOf(".") > 0) {
            c = var3.substring(0, var3.indexOf("."));
        } else {
            c = var3;
        }

        byte var10;
        label86:
        {
            a();
            String var8 = b;
            int var9 = var8.hashCode();
            if (var9 != 32) {
                if (var9 != 104) {
                    if (var9 != 112) {
                        if (var9 != 115) {
                            if (var9 != 118) {
                                switch (var9) {
                                    case 97:
                                        if (var8.equals("a")) {
                                            var10 = 13;
                                            break label86;
                                        }
                                        break;
                                    case 98:
                                        if (var8.equals("b")) {
                                            var10 = 1;
                                            break label86;
                                        }
                                        break;
                                    case 99:
                                        if (var8.equals("c")) {
                                            var10 = 4;
                                            break label86;
                                        }
                                        break;
                                    case 100:
                                        if (var8.equals("d")) {
                                            var10 = 2;
                                            break label86;
                                        }
                                        break;
                                    case 101:
                                        if (var8.equals("e")) {
                                            var10 = 5;
                                            break label86;
                                        }
                                        break;
                                    case 102:
                                        if (var8.equals("f")) {
                                            var10 = 6;
                                            break label86;
                                        }
                                        break;
                                    default:
                                        switch (var9) {
                                            case 108:
                                                if (var8.equals("l")) {
                                                    var10 = 12;
                                                    break label86;
                                                }
                                                break;
                                            case 109:
                                                if (var8.equals("m")) {
                                                    var10 = 8;
                                                    break label86;
                                                }
                                                break;
                                            case 110:
                                                if (var8.equals("n")) {
                                                    var10 = 3;
                                                    break label86;
                                                }
                                        }
                                }
                            } else if (var8.equals("v")) {
                                var10 = 10;
                                break label86;
                            }
                        } else if (var8.equals("s")) {
                            var10 = 9;
                            break label86;
                        }
                    } else if (var8.equals("p")) {
                        var10 = 11;
                        break label86;
                    }
                } else if (var8.equals("h")) {
                    var10 = 7;
                    break label86;
                }
            } else if (var8.equals(" ")) {
                var10 = 0;
                break label86;
            }

            var10 = -1;
        }

        switch (var10) {
            case 0:
                u = 4;
                d = 4;
                break;
            case 1:
                w = 8;
                x = 5;
                d = 2;
                break;
            case 2:
                d = 3;
                w = 4;
                break;
            case 3:
                d = 3;
                break;
            case 4:
                u = 4;
                d = 10;
                break;
            case 5:
                u = 4;
                d = 12;
                break;
            case 6:
                u = 4;
                d = 5;
                break;
            case 7:
                u = 8;
                d = 7;
                break;
            case 8:
                d = 9;
                break;
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                d = 1;
        }

        e = R;
        g = var4;
        setWillNotDraw(false);
        a(var1);
    }

    public Ts(Context var1, String var2, boolean var3) {
        this(var1, var2, "", var3);
    }

    private float[] getBooleanReflections() {
        float[] var1 = new float[8];
        var1[0] = (float) (P / 2);
        var1[1] = (float) (A / 2);
        var1[2] = (float) (A / 2);
        var1[3] = (float) (P / 2);
        var1[4] = (float) (A / 2);
        var1[5] = (float) (P / 2);
        var1[6] = (float) (z - A / 2);
        var1[7] = (float) (P / 2);
        return var1;
    }

    private float[] getBooleanShadows() {
        float[] var1 = new float[8];
        var1[0] = (float) (z - P / 2);
        var1[1] = (float) (A / 2);
        var1[2] = (float) (z - A / 2);
        var1[3] = (float) (A - P / 2);
        var1[4] = (float) (z - A / 2);
        var1[5] = (float) (A - P / 2);
        var1[6] = (float) (A / 2);
        var1[7] = (float) (A - P / 2);
        return var1;
    }

    private float[] getNumberBottomShadows() {
        float[] var1 = new float[4];
        var1[0] = (float) (z - A / 2);
        var1[1] = (float) (A - P / 2);
        var1[2] = (float) (A / 2);
        var1[3] = (float) (A - P / 2);
        return var1;
    }

    private float[] getNumberTopReflections() {
        float[] var1 = new float[4];
        var1[0] = (float) (A / 2);
        var1[1] = (float) (P / 2);
        var1[2] = (float) (z - A / 2);
        var1[3] = (float) (P / 2);
        return var1;
    }

    private float[] getRectReflections() {
        float[] var1 = new float[8];
        var1[0] = 0.0F;
        var1[1] = (float) (P / 2);
        var1[2] = (float) (z - P / 2);
        var1[3] = (float) (P / 2);
        var1[4] = (float) (P / 2);
        var1[5] = 0.0F;
        var1[6] = (float) (P / 2);
        var1[7] = (float) (A - P / 2);
        return var1;
    }

    private float[] getRectShadows() {
        float[] var1 = new float[8];
        var1[0] = (float) (z - P / 2);
        var1[1] = 0.0F;
        var1[2] = (float) (z - P / 2);
        var1[3] = (float) (A - P / 2);
        var1[4] = (float) (z - P / 2);
        var1[5] = (float) (A - P / 2);
        var1[6] = 0.0F;
        var1[7] = (float) (A - P / 2);
        return var1;
    }

    public void a() {
        S = mq.a(b, c);
    }

    public void a(float var1, float var2, boolean var3) {
        if (d == 9) {
            z = (int) var1 + H;
        } else {
            z = (int) var1;
        }

        A = (int) var2;
        if (var3) {
            e();
        }

    }

    public void a(Ts var1, boolean var2, boolean var3, int var4) {
        e = -16777216;
        d = var1.d;
        z = var1.z;
        A = var1.A;
        B = var1.B;
        C = var1.C;
        if (!var2) {
            if (var3) {
                d = 4;
                A = (int) (6.0F * D);
            } else if (var4 > 0) {
                B = var4 - h;
            }
        }

        e();
    }

    public final void a(Context var1) {
        D = LayoutUtils.getDip(var1, 1.0F);
        h = (int) ((float) h * D);
        i = (int) (D * (float) i);
        j = (int) (D * (float) j);
        m = (int) (D * (float) m);
        n = (int) (D * (float) n);
        k = (int) (D * (float) k);
        l = (int) (D * (float) l);
        o = (int) (D * (float) o);
        p = (int) (D * (float) p);
        q = (int) (D * (float) q);
        r = (int) (D * (float) r);
        s = (int) (D * (float) s);
        t = (int) (D * (float) t);
        B = (int) (D * (float) B);
        C = (int) (D * (float) C);
        w = (int) (D * (float) w);
        u = (int) (D * (float) u);
        x = (int) (D * (float) x);
        v = (int) (D * (float) v);
        y = (int) (D * (float) y);
        F = (int) (D * (float) F);
        G = (int) (D * (float) G);
        I = (int) (D * (float) I);
        J = (int) (D * (float) J);
        H = (int) (D * (float) H);
        P = (int) (D * (float) P);
        Q = (int) (D * (float) Q);
        if (P < 2) {
            P = 2;
        }

        if (Q < 2) {
            Q = 2;
        }

        f = new Paint();
        if (!g) {
            K = true;
            L = true;
        }

        M = new Paint();
        M.setColor(-536870912);
        M.setStrokeWidth((float) P);
        N = new Paint();
        N.setColor(-1610612736);
        N.setStyle(Paint.Style.STROKE);
        N.setStrokeWidth((float) P);
        O = new Paint();
        O.setColor(-1593835521);
        O.setStyle(Paint.Style.STROKE);
        O.setStrokeWidth((float) Q);
        setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        a((float) F, (float) (G + u + v), false);
    }

    public final void a(Canvas var1) {
        Path var2 = new Path();
        var2.moveTo((float) (A / 2), (float) A);
        var2.lineTo(0.0F, (float) (A / 2));
        var2.lineTo((float) (A / 2), 0.0F);
        var2.lineTo((float) (z - A / 2), 0.0F);
        var2.lineTo((float) z, (float) (A / 2));
        var2.lineTo((float) (z - A / 2), (float) A);
        var1.drawPath(var2, f);
        if (K) {
            var1.drawLines(getBooleanShadows(), N);
        }

        if (L) {
            var1.drawLines(getBooleanReflections(), O);
        }

    }

    public final void a(Path var1) {
        var1.moveTo(0.0F, (float) k);
        var1.lineTo((float) k, 0.0F);
        var1.lineTo((float) o, 0.0F);
        var1.lineTo((float) p, (float) h);
        var1.lineTo((float) q, (float) h);
        var1.lineTo((float) r, 0.0F);
        var1.lineTo((float) (z - k), 0.0F);
        var1.lineTo((float) z, (float) k);
    }

    public final void a(Path var1, int var2) {
        var1.lineTo((float) j, (float) (var2 - l));
        var1.lineTo((float) (j + l), (float) var2);
        var1.lineTo((float) (z - k), (float) var2);
        var1.lineTo((float) z, (float) (var2 + k));
    }

    public final void a(Path var1, int var2, boolean var3, int var4) {
        var1.lineTo((float) z, (float) (var2 - k));
        var1.lineTo((float) (z - k), (float) var2);
        if (var3) {
            var1.lineTo((float) (var4 + r), (float) var2);
            var1.lineTo((float) (var4 + q), (float) (var2 + h));
            var1.lineTo((float) (var4 + p), (float) (var2 + h));
            var1.lineTo((float) (var4 + o), (float) var2);
        }

        if (var4 > 0) {
            var1.lineTo((float) (var4 + l), (float) var2);
            var1.lineTo((float) var4, (float) (var2 + l));
        } else {
            var1.lineTo((float) (var4 + k), (float) var2);
            var1.lineTo(0.0F, (float) (var2 - k));
        }
    }

    public final float[] a(int var1) {
        float[] var2 = new float[24];
        var2[0] = (float) (P / 2);
        var2[1] = (float) (var1 - k);
        var2[2] = (float) (P / 2);
        var2[3] = (float) k;
        var2[4] = (float) (P / 2);
        var2[5] = (float) k;
        var2[6] = (float) k;
        var2[7] = (float) (P / 2);
        var2[8] = (float) k;
        var2[9] = (float) (P / 2);
        var2[10] = (float) o;
        var2[11] = (float) (P / 2);
        var2[12] = (float) p;
        var2[13] = (float) (h + P / 2);
        var2[14] = (float) q;
        var2[15] = (float) (h + P / 2);
        var2[16] = (float) q;
        var2[17] = (float) (h + P / 2);
        var2[18] = (float) r;
        var2[19] = (float) (P / 2);
        var2[20] = (float) r;
        var2[21] = (float) (P / 2);
        var2[22] = (float) (z - k);
        var2[23] = (float) (P / 2);
        return var2;
    }

    public final float[] a(int var1, int var2) {
        float[] var3 = new float[8];
        var3[0] = (float) (j + l);
        var3[1] = (float) (var1 - P / 2);
        var3[2] = (float) (j - P / 2);
        var3[3] = (float) (var1 + l);
        var3[4] = (float) (j - P / 2);
        var3[5] = (float) (var1 + l);
        var3[6] = (float) (j - P / 2);
        var3[7] = (float) (var2 - l);
        return var3;
    }

    public final float[] a(int var1, boolean var2, int var3) {
        float[] var4;
        if (var2) {
            var4 = new float[24];
        } else {
            var4 = new float[8];
        }

        var4[0] = (float) z;
        var4[1] = (float) (var1 - k - P / 2);
        var4[2] = (float) (z - k);
        var4[3] = (float) (var1 - P / 2);
        if (var2) {
            var4[4] = (float) (z - k);
            var4[5] = (float) (var1 - P / 2);
            var4[6] = (float) (var3 + r);
            var4[7] = (float) (var1 - P / 2);
            var4[8] = (float) (r + var3);
            var4[9] = (float) (var1 - P / 2);
            var4[10] = (float) (var3 + q);
            var4[11] = (float) (var1 + h - P / 2);
            var4[12] = (float) (q + var3);
            var4[13] = (float) (var1 + h - P / 2);
            var4[14] = (float) (var3 + p);
            var4[15] = (float) (var1 + h - P / 2);
            var4[16] = (float) (p + var3);
            var4[17] = (float) (h + var1 - P / 2);
            var4[18] = (float) (var3 + o);
            var4[19] = (float) (var1 - P / 2);
            if (var3 > 0) {
                var4[20] = (float) (o + var3);
                var4[21] = (float) (var1 - P / 2);
                var4[22] = (float) (var3 + l);
                var4[23] = (float) (var1 - P / 2);
                return var4;
            } else {
                var4[20] = (float) (o + var3);
                var4[21] = (float) (var1 - P / 2);
                var4[22] = (float) (var3 + k);
                var4[23] = (float) (var1 - P / 2);
                return var4;
            }
        } else if (var3 > 0) {
            var4[4] = (float) (z - k);
            var4[5] = (float) (var1 - P / 2);
            var4[6] = (float) (var3 + l);
            var4[7] = (float) (var1 - P / 2);
            return var4;
        } else {
            var4[4] = (float) (z - k);
            var4[5] = (float) (var1 - P / 2);
            var4[6] = (float) (var3 + k);
            var4[7] = (float) (var1 - P / 2);
            return var4;
        }
    }

    public final void b(Canvas var1) {
        Path var2 = new Path();
        a(var2);
        boolean var5 = true;
        boolean var6;
        var6 = d != 5;

        a(var2, A, var6, 0);
        var1.drawPath(var2, f);
        if (K) {
            var1.drawLines(b(0, A), N);
            int var7 = A;
            if (d == 5) {
                var5 = false;
            }

            var1.drawLines(a(var7, var5, 0), N);
        }

        if (L) {
            var1.drawLines(a(A), O);
        }

    }

    public boolean b() {
        return d >= 10;
    }

    public final float[] b(int var1, int var2) {
        float[] var3 = new float[4];
        var3[0] = (float) (z - P / 2);
        var3[1] = (float) (var1 + k);
        var3[2] = (float) (z - P / 2);
        var3[3] = (float) (var2 - k);
        return var3;
    }

    public final void c(Canvas var1) {
        var1.drawRect(new Rect(0, 0, z, A), f);
        Path var2 = new Path();
        var2.moveTo((float) (z - J), (float) J);
        var2.lineTo((float) (z - J - I / 2), (float) (J + I));
        var2.lineTo((float) (z - J - I), (float) J);
        var1.drawPath(var2, M);
    }

    public boolean c() {
        return d == 12;
    }

    public final float[] c(int var1, int var2) {
        float[] var3 = new float[4];
        var3[0] = (float) (var2 + l);
        var3[1] = (float) (var1 + P / 2);
        var3[2] = (float) (z - k);
        var3[3] = (float) (var1 + P / 2);
        return var3;
    }

    public int d() {
        return getTotalHeight() - h;
    }

    public final void d(Canvas var1) {
        Path var2 = new Path();
        var2.moveTo(0.0F, (float) s);
        var2.arcTo(new RectF(0.0F, 0.0F, (float) t, (float) (2 * s)), 180.0F, 180.0F);
        var2.lineTo((float) (z - k), (float) s);
        var2.lineTo((float) z, (float) (s + k));
        a(var2, A, true, 0);
        var1.drawPath(var2, f);
        if (K) {
            var1.drawLines(b(s, A), N);
            var1.drawLines(a(A, true, 0), N);
        }

    }

    public void e() {
        requestLayout();
    }

    public final void e(Canvas var1) {
        Path var2 = new Path();
        int var5 = A + B - h;
        int var6 = var5 + n + C - h;
        a(var2);
        a(var2, A, true, j);
        a(var2, var5);
        a(var2, var5 + n, true, j);
        a(var2, var6);
        a(var2, var6 + m, true, 0);
        var1.drawPath(var2, f);
        if (K) {
            var1.drawLines(b(0, A), N);
            var1.drawLines(a(A, true, j), N);
            var1.drawLines(a(A, var5), N);
            var1.drawLines(b(var5, var5 + n), N);
            var1.drawLines(a(var5 + n, true, j), N);
            var1.drawLines(a(var5 + n, var6), N);
            var1.drawLines(b(var6, var6 + m), N);
            var1.drawLines(a(var6 + m, true, 0), N);
        }

        if (L) {
            var1.drawLines(a(var6 + m), O);
            var1.drawLines(c(var5, j), O);
            var1.drawLines(c(var6, j), O);
        }

    }

    public int f() {
        return A;
    }

    public final void f(Canvas var1) {
        Path var2 = new Path();
        int var3 = A + B - h;
        a(var2);
        boolean var6 = true;
        a(var2, A, true, j);
        a(var2, var3);
        int var7 = var3 + m;
        boolean var8;
        var8 = d == 10;

        a(var2, var7, var8, 0);
        var1.drawPath(var2, f);
        if (K) {
            var1.drawLines(b(0, A), N);
            var1.drawLines(a(A, true, j), N);
            var1.drawLines(a(A, var3), N);
            var1.drawLines(b(var3, var3 + m), N);
            int var9 = var3 + m;
            if (d != 10) {
                var6 = false;
            }

            var1.drawLines(a(var9, var6, 0), N);
        }

        if (L) {
            var1.drawLines(a(var3 + m), O);
            var1.drawLines(c(var3, j), O);
        }

    }

    public int g() {
        return A + B + n - h;
    }

    public final void g(Canvas var1) {
        Path var2 = new Path();
        var2.moveTo((float) (A / 2), (float) A);
        var2.arcTo(new RectF(0.0F, 0.0F, (float) A, (float) A), 90.0F, 180.0F);
        var2.lineTo((float) (z - A / 2), 0.0F);
        var2.arcTo(new RectF((float) (z - A), 0.0F, (float) z, (float) A), 270.0F, 180.0F);
        var1.drawPath(var2, f);
        if (K) {
            float var18 = (float) (z - A);
            var1.drawArc(new RectF(var18, 0.0F, (float) (z - P / 2), (float) (A - P / 2)), 330.0F, 120.0F, false, N);
            var1.drawLines(getNumberBottomShadows(), N);
            var1.drawArc(new RectF((float) (P / 2), 0.0F, (float) A, (float) (A - P / 2)), 90.0F, 30.0F, false, N);
        }

        if (L) {
            var1.drawArc(new RectF((float) (P / 2), (float) (P / 2), (float) A, (float) A), 150.0F, 120.0F, false, O);
            var1.drawLines(getNumberTopReflections(), O);
            var1.drawArc(new RectF((float) (z - A), (float) (P / 2), (float) (z - P / 2), (float) A), 270.0F, 30.0F, false, O);
        }
    }

    public Gx getClassInfo() {
        if (S == null) {
            a();
        }

        return S;
    }

    public int getTopH() {
        return A;
    }

    public int getTotalHeight() {
        if (b()) {
            A += n + B - h;
        }

        if (c()) {
            A += m + C - h;
        }

        if (d == 4 || d == 7 || d == 10 || d == 12) {
            A += h;
        }

        return A;
    }

    public int getTotalWidth() {
        return z;
    }

    public int getW() {
        return z;
    }

    public final void h(Canvas var1) {
        var1.drawRect(new Rect(0, 0, z, A), f);
        if (K) {
            var1.drawLines(getRectShadows(), N);
        }

        if (L) {
            var1.drawLines(getRectReflections(), O);
        }

    }

    public void onDraw(Canvas var1) {
        f.setColor(e);
        switch (d) {
            case 1:
                h(var1);
                break;
            case 2:
                a(var1);
                break;
            case 3:
                g(var1);
                break;
            case 4:
            case 5:
                b(var1);
            case 6:
            case 8:
            default:
                break;
            case 7:
                d(var1);
                break;
            case 9:
                c(var1);
                break;
            case 10:
            case 11:
                f(var1);
                break;
            case 12:
                e(var1);
        }

        super.onDraw(var1);
    }

    public void onMeasure(int var1, int var2) {
        super.onMeasure(MeasureSpec.makeMeasureSpec(getTotalWidth(), MeasureSpec.EXACTLY), MeasureSpec.makeMeasureSpec(getTotalHeight(), MeasureSpec.EXACTLY));
    }

    public void setSubstack1Height(int var1) {
        int var2 = Math.max(var1, i);
        if (var2 != B) {
            B = var2;
        }

    }

    public void setSubstack2Height(int var1) {
        int var2 = Math.max(var1, i);
        if (var2 != C) {
            C = var2;
        }
    }
}
