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
import ma.swblockspreview.util.wB;

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
        this.h = 3;
        this.i = 12;
        this.j = 15;
        this.k = 3;
        this.l = 2;
        this.m = 15;
        this.n = 15;
        this.o = 15;
        int var5 = this.o;
        int var6 = this.h;
        this.p = var5 + var6;
        this.q = 10 + this.p;
        this.r = var6 + this.q;
        this.s = 6;
        this.t = 60;
        this.u = 2;
        this.v = 2;
        this.w = 3;
        this.x = 0;
        this.y = 2;
        int var7 = this.i;
        this.B = var7;
        this.C = var7;
        this.E = null;
        this.F = 100;
        this.G = 14;
        this.H = 15;
        this.I = 6;
        this.J = 4;
        this.K = false;
        this.L = false;
        this.P = 1;
        this.Q = 1;
        this.R = 805306368;
        this.S = null;
        this.a = var1;
        this.b = var2;
        if (var3 != null && var3.indexOf(".") > 0) {
            this.c = var3.substring(0, var3.indexOf("."));
        } else {
            this.c = var3;
        }

        byte var10;
        label86:
        {
            this.a();
            String var8 = this.b;
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
                this.u = 4;
                this.d = 4;
                break;
            case 1:
                this.w = 8;
                this.x = 5;
                this.d = 2;
                break;
            case 2:
                this.d = 3;
                this.w = 4;
                break;
            case 3:
                this.d = 3;
                break;
            case 4:
                this.u = 4;
                this.d = 10;
                break;
            case 5:
                this.u = 4;
                this.d = 12;
                break;
            case 6:
                this.u = 4;
                this.d = 5;
                break;
            case 7:
                this.u = 8;
                this.d = 7;
                break;
            case 8:
                this.d = 9;
                break;
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                this.d = 1;
        }

        this.e = this.R;
        this.g = var4;
        this.setWillNotDraw(false);
        this.a(var1);
    }

    public Ts(Context var1, String var2, boolean var3) {
        this(var1, var2, "", var3);
    }

    private float[] getBooleanReflections() {
        float[] var1 = new float[8];
        int var2 = this.A / 2;
        int var3 = this.P;
        var1[0] = (float) (0 + var3 / 2);
        float var4 = (float) var2;
        var1[1] = var4;
        var1[2] = var4;
        var1[3] = (float) (0 + var3 / 2);
        var1[4] = var4;
        var1[5] = (float) (0 + var3 / 2);
        var1[6] = (float) (this.z - var2);
        var1[7] = (float) (0 + var3 / 2);
        return var1;
    }

    private float[] getBooleanShadows() {
        float[] var1 = new float[8];
        int var2 = this.A;
        int var3 = var2 / 2;
        int var4 = this.z;
        int var5 = this.P;
        var1[0] = (float) (var4 - var5 / 2);
        float var6 = (float) var3;
        var1[1] = var6;
        var1[2] = (float) (var4 - var3);
        var1[3] = (float) (var2 - var5 / 2);
        var1[4] = (float) (var4 - var3);
        var1[5] = (float) (var2 - var5 / 2);
        var1[6] = var6;
        var1[7] = (float) (var2 - var5 / 2);
        return var1;
    }

    private float[] getNumberBottomShadows() {
        float[] var1 = new float[4];
        int var2 = this.A;
        int var3 = var2 / 2;
        var1[0] = (float) (this.z - var3);
        int var4 = this.P;
        var1[1] = (float) (var2 - var4 / 2);
        var1[2] = (float) var3;
        var1[3] = (float) (var2 - var4 / 2);
        return var1;
    }

    private float[] getNumberTopReflections() {
        float[] var1 = new float[4];
        int var2 = this.A / 2;
        var1[0] = (float) var2;
        int var3 = this.P;
        var1[1] = (float) (0 + var3 / 2);
        var1[2] = (float) (this.z - var2);
        var1[3] = (float) (0 + var3 / 2);
        return var1;
    }

    private float[] getRectReflections() {
        float[] var1 = new float[8];
        var1[0] = 0.0F;
        int var2 = this.P;
        var1[1] = (float) (0 + var2 / 2);
        var1[2] = (float) (this.z - var2 / 2);
        var1[3] = (float) (0 + var2 / 2);
        var1[4] = (float) (0 + var2 / 2);
        var1[5] = 0.0F;
        var1[6] = (float) (0 + var2 / 2);
        var1[7] = (float) (this.A - var2 / 2);
        return var1;
    }

    private float[] getRectShadows() {
        float[] var1 = new float[8];
        int var2 = this.z;
        int var3 = this.P;
        var1[0] = (float) (var2 - var3 / 2);
        var1[1] = 0.0F;
        var1[2] = (float) (var2 - var3 / 2);
        int var4 = this.A;
        var1[3] = (float) (var4 - var3 / 2);
        var1[4] = (float) (var2 - var3 / 2);
        var1[5] = (float) (var4 - var3 / 2);
        var1[6] = 0.0F;
        var1[7] = (float) (var4 - var3 / 2);
        return var1;
    }

    public void a() {
        this.S = mq.a(this.b, this.c);
    }

    public void a(float var1, float var2, boolean var3) {
        if (this.d == 9) {
            this.z = (int) var1 + this.H;
        } else {
            this.z = (int) var1;
        }

        this.A = (int) var2;
        if (var3) {
            this.e();
        }

    }

    public void a(Ts var1, boolean var2, boolean var3, int var4) {
        this.e = -16777216;
        this.d = var1.d;
        this.z = var1.z;
        this.A = var1.A;
        this.B = var1.B;
        this.C = var1.C;
        if (!var2) {
            if (var3) {
                this.d = 4;
                this.A = (int) (6.0F * this.D);
            } else if (var4 > 0) {
                this.B = var4 - this.h;
            }
        }

        this.e();
    }

    public final void a(Context var1) {
        this.D = wB.a(var1, 1.0F);
        float var2 = (float) this.h;
        float var3 = this.D;
        this.h = (int) (var2 * var3);
        this.i = (int) (var3 * (float) this.i);
        this.j = (int) (var3 * (float) this.j);
        this.m = (int) (var3 * (float) this.m);
        this.n = (int) (var3 * (float) this.n);
        this.k = (int) (var3 * (float) this.k);
        this.l = (int) (var3 * (float) this.l);
        this.o = (int) (var3 * (float) this.o);
        this.p = (int) (var3 * (float) this.p);
        this.q = (int) (var3 * (float) this.q);
        this.r = (int) (var3 * (float) this.r);
        this.s = (int) (var3 * (float) this.s);
        this.t = (int) (var3 * (float) this.t);
        this.B = (int) (var3 * (float) this.B);
        this.C = (int) (var3 * (float) this.C);
        this.w = (int) (var3 * (float) this.w);
        this.u = (int) (var3 * (float) this.u);
        this.x = (int) (var3 * (float) this.x);
        this.v = (int) (var3 * (float) this.v);
        this.y = (int) (var3 * (float) this.y);
        this.F = (int) (var3 * (float) this.F);
        this.G = (int) (var3 * (float) this.G);
        this.I = (int) (var3 * (float) this.I);
        this.J = (int) (var3 * (float) this.J);
        this.H = (int) (var3 * (float) this.H);
        this.P = (int) (var3 * (float) this.P);
        this.Q = (int) (var3 * (float) this.Q);
        if (this.P < 2) {
            this.P = 2;
        }

        if (this.Q < 2) {
            this.Q = 2;
        }

        this.f = new Paint();
        if (!this.g) {
            this.K = true;
            this.L = true;
        }

        this.M = new Paint();
        this.M.setColor(-536870912);
        this.M.setStrokeWidth((float) this.P);
        this.N = new Paint();
        this.N.setColor(-1610612736);
        this.N.setStyle(Paint.Style.STROKE);
        this.N.setStrokeWidth((float) this.P);
        this.O = new Paint();
        this.O.setColor(-1593835521);
        this.O.setStyle(Paint.Style.STROKE);
        this.O.setStrokeWidth((float) this.Q);
        this.setLayerType(View.LAYER_TYPE_SOFTWARE, (Paint) null);
        this.a((float) this.F, (float) (this.G + this.u + this.v), false);
    }

    public final void a(Canvas var1) {
        Path var2 = new Path();
        int var3 = this.A;
        int var4 = var3 / 2;
        float var5 = (float) var4;
        var2.moveTo(var5, (float) var3);
        var2.lineTo(0.0F, var5);
        var2.lineTo(var5, 0.0F);
        var2.lineTo((float) (this.z - var4), 0.0F);
        var2.lineTo((float) this.z, var5);
        var2.lineTo((float) (this.z - var4), (float) this.A);
        var1.drawPath(var2, this.f);
        if (this.K) {
            var1.drawLines(this.getBooleanShadows(), this.N);
        }

        if (this.L) {
            var1.drawLines(this.getBooleanReflections(), this.O);
        }

    }

    public final void a(Path var1) {
        var1.moveTo(0.0F, (float) this.k);
        var1.lineTo((float) this.k, 0.0F);
        var1.lineTo((float) this.o, 0.0F);
        var1.lineTo((float) this.p, (float) this.h);
        var1.lineTo((float) this.q, (float) this.h);
        var1.lineTo((float) this.r, 0.0F);
        var1.lineTo((float) (this.z - this.k), 0.0F);
        var1.lineTo((float) this.z, (float) this.k);
    }

    public final void a(Path var1, int var2) {
        var1.lineTo((float) this.j, (float) (var2 - this.l));
        float var3 = (float) (this.j + this.l);
        float var4 = (float) var2;
        var1.lineTo(var3, var4);
        var1.lineTo((float) (this.z - this.k), var4);
        var1.lineTo((float) this.z, (float) (var2 + this.k));
    }

    public final void a(Path var1, int var2, boolean var3, int var4) {
        var1.lineTo((float) this.z, (float) (var2 - this.k));
        float var5 = (float) (this.z - this.k);
        float var6 = (float) var2;
        var1.lineTo(var5, var6);
        if (var3) {
            var1.lineTo((float) (var4 + this.r), var6);
            var1.lineTo((float) (var4 + this.q), (float) (var2 + this.h));
            var1.lineTo((float) (var4 + this.p), (float) (var2 + this.h));
            var1.lineTo((float) (var4 + this.o), var6);
        }

        if (var4 > 0) {
            var1.lineTo((float) (var4 + this.l), var6);
            var1.lineTo((float) var4, (float) (var2 + this.l));
        } else {
            var1.lineTo((float) (var4 + this.k), var6);
            var1.lineTo(0.0F, (float) (var2 - this.k));
        }
    }

    public final float[] a(int var1) {
        float[] var2 = new float[24];
        int var3 = this.P;
        var2[0] = (float) (0 + var3 / 2);
        int var4 = this.k;
        var2[1] = (float) (var1 - var4);
        var2[2] = (float) (0 + var3 / 2);
        var2[3] = (float) var4;
        var2[4] = (float) (0 + var3 / 2);
        var2[5] = (float) var4;
        var2[6] = (float) var4;
        var2[7] = (float) (0 + var3 / 2);
        var2[8] = (float) var4;
        var2[9] = (float) (0 + var3 / 2);
        var2[10] = (float) this.o;
        var2[11] = (float) (0 + var3 / 2);
        var2[12] = (float) this.p;
        int var5 = this.h;
        var2[13] = (float) (var5 + var3 / 2);
        int var6 = this.q;
        var2[14] = (float) var6;
        var2[15] = (float) (var5 + var3 / 2);
        var2[16] = (float) var6;
        var2[17] = (float) (var5 + var3 / 2);
        int var7 = this.r;
        var2[18] = (float) var7;
        var2[19] = (float) (0 + var3 / 2);
        var2[20] = (float) var7;
        var2[21] = (float) (0 + var3 / 2);
        var2[22] = (float) (this.z - var4);
        var2[23] = (float) (0 + var3 / 2);
        return var2;
    }

    public final float[] a(int var1, int var2) {
        float[] var3 = new float[8];
        int var4 = this.j;
        int var5 = this.l;
        var3[0] = (float) (var4 + var5);
        int var6 = this.P;
        var3[1] = (float) (var1 - var6 / 2);
        var3[2] = (float) (var4 - var6 / 2);
        var3[3] = (float) (var1 + var5);
        var3[4] = (float) (var4 - var6 / 2);
        var3[5] = (float) (var1 + var5);
        var3[6] = (float) (var4 - var6 / 2);
        var3[7] = (float) (var2 - var5);
        return var3;
    }

    public final float[] a(int var1, boolean var2, int var3) {
        float[] var4;
        if (var2) {
            var4 = new float[24];
        } else {
            var4 = new float[8];
        }

        int var5 = this.z;
        var4[0] = (float) var5;
        int var6 = this.k;
        int var7 = var1 - var6;
        int var8 = this.P;
        var4[1] = (float) (var7 - var8 / 2);
        var4[2] = (float) (var5 - var6);
        var4[3] = (float) (var1 - var8 / 2);
        if (var2) {
            var4[4] = (float) (var5 - var6);
            var4[5] = (float) (var1 - var8 / 2);
            int var9 = this.r;
            var4[6] = (float) (var3 + var9);
            var4[7] = (float) (var1 - var8 / 2);
            var4[8] = (float) (var9 + var3);
            var4[9] = (float) (var1 - var8 / 2);
            int var10 = this.q;
            var4[10] = (float) (var3 + var10);
            int var11 = this.h;
            var4[11] = (float) (var1 + var11 - var8 / 2);
            var4[12] = (float) (var10 + var3);
            var4[13] = (float) (var1 + var11 - var8 / 2);
            int var12 = this.p;
            var4[14] = (float) (var3 + var12);
            var4[15] = (float) (var1 + var11 - var8 / 2);
            var4[16] = (float) (var12 + var3);
            var4[17] = (float) (var11 + var1 - var8 / 2);
            int var13 = this.o;
            var4[18] = (float) (var3 + var13);
            var4[19] = (float) (var1 - var8 / 2);
            if (var3 > 0) {
                var4[20] = (float) (var13 + var3);
                var4[21] = (float) (var1 - var8 / 2);
                var4[22] = (float) (var3 + this.l);
                var4[23] = (float) (var1 - var8 / 2);
                return var4;
            } else {
                var4[20] = (float) (var13 + var3);
                var4[21] = (float) (var1 - var8 / 2);
                var4[22] = (float) (var3 + var6);
                var4[23] = (float) (var1 - var8 / 2);
                return var4;
            }
        } else if (var3 > 0) {
            var4[4] = (float) (var5 - var6);
            var4[5] = (float) (var1 - var8 / 2);
            var4[6] = (float) (var3 + this.l);
            var4[7] = (float) (var1 - var8 / 2);
            return var4;
        } else {
            var4[4] = (float) (var5 - var6);
            var4[5] = (float) (var1 - var8 / 2);
            var4[6] = (float) (var3 + var6);
            var4[7] = (float) (var1 - var8 / 2);
            return var4;
        }
    }

    public final void b(Canvas var1) {
        Path var2 = new Path();
        this.a(var2);
        int var3 = this.A;
        int var4 = this.d;
        boolean var5 = true;
        boolean var6;
        if (var4 != 5) {
            var6 = true;
        } else {
            var6 = false;
        }

        this.a(var2, var3, var6, 0);
        var1.drawPath(var2, this.f);
        if (this.K) {
            var1.drawLines(this.b(0, this.A), this.N);
            int var7 = this.A;
            if (this.d == 5) {
                var5 = false;
            }

            var1.drawLines(this.a(var7, var5, 0), this.N);
        }

        if (this.L) {
            var1.drawLines(this.a(this.A), this.O);
        }

    }

    public boolean b() {
        return this.d >= 10;
    }

    public final float[] b(int var1, int var2) {
        float[] var3 = new float[4];
        int var4 = this.z;
        int var5 = this.P;
        var3[0] = (float) (var4 - var5 / 2);
        int var6 = this.k;
        var3[1] = (float) (var1 + var6);
        var3[2] = (float) (var4 - var5 / 2);
        var3[3] = (float) (var2 - var6);
        return var3;
    }

    public final void c(Canvas var1) {
        var1.drawRect(new Rect(0, 0, this.z, this.A), this.f);
        Path var2 = new Path();
        int var3 = this.z;
        int var4 = this.J;
        var2.moveTo((float) (var3 - var4), (float) var4);
        int var5 = this.z;
        int var6 = this.J;
        int var7 = var5 - var6;
        int var8 = this.I;
        var2.lineTo((float) (var7 - var8 / 2), (float) (var6 + var8));
        int var9 = this.z;
        int var10 = this.J;
        var2.lineTo((float) (var9 - var10 - this.I), (float) var10);
        var1.drawPath(var2, this.M);
    }

    public boolean c() {
        return this.d == 12;
    }

    public final float[] c(int var1, int var2) {
        float[] var3 = new float[4];
        var3[0] = (float) (var2 + this.l);
        int var4 = this.P;
        var3[1] = (float) (var1 + var4 / 2);
        var3[2] = (float) (this.z - this.k);
        var3[3] = (float) (var1 + var4 / 2);
        return var3;
    }

    public int d() {
        return this.getTotalHeight() - this.h;
    }

    public final void d(Canvas var1) {
        Path var2 = new Path();
        var2.moveTo(0.0F, (float) this.s);
        var2.arcTo(new RectF(0.0F, 0.0F, (float) this.t, (float) (2 * this.s)), 180.0F, 180.0F);
        var2.lineTo((float) (this.z - this.k), (float) this.s);
        var2.lineTo((float) this.z, (float) (this.s + this.k));
        this.a(var2, this.A, true, 0);
        var1.drawPath(var2, this.f);
        if (this.K) {
            var1.drawLines(this.b(this.s, this.A), this.N);
            var1.drawLines(this.a(this.A, true, 0), this.N);
        }

    }

    public void e() {
        this.requestLayout();
    }

    public final void e(Canvas var1) {
        Path var2 = new Path();
        int var3 = this.A + this.B;
        int var4 = this.h;
        int var5 = var3 - var4;
        int var6 = var5 + this.n + this.C - var4;
        this.a(var2);
        this.a(var2, this.A, true, this.j);
        this.a(var2, var5);
        this.a(var2, var5 + this.n, true, this.j);
        this.a(var2, var6);
        this.a(var2, var6 + this.m, true, 0);
        var1.drawPath(var2, this.f);
        if (this.K) {
            var1.drawLines(this.b(0, this.A), this.N);
            var1.drawLines(this.a(this.A, true, this.j), this.N);
            var1.drawLines(this.a(this.A, var5), this.N);
            var1.drawLines(this.b(var5, var5 + this.n), this.N);
            var1.drawLines(this.a(var5 + this.n, true, this.j), this.N);
            var1.drawLines(this.a(var5 + this.n, var6), this.N);
            var1.drawLines(this.b(var6, var6 + this.m), this.N);
            var1.drawLines(this.a(var6 + this.m, true, 0), this.N);
        }

        if (this.L) {
            var1.drawLines(this.a(var6 + this.m), this.O);
            var1.drawLines(this.c(var5, this.j), this.O);
            var1.drawLines(this.c(var6, this.j), this.O);
        }

    }

    public int f() {
        return this.A;
    }

    public final void f(Canvas var1) {
        Path var2 = new Path();
        int var3 = this.A + this.B - this.h;
        this.a(var2);
        int var4 = this.A;
        int var5 = this.j;
        boolean var6 = true;
        this.a(var2, var4, var6, var5);
        this.a(var2, var3);
        int var7 = var3 + this.m;
        boolean var8;
        if (this.d == 10) {
            var8 = true;
        } else {
            var8 = false;
        }

        this.a(var2, var7, var8, 0);
        var1.drawPath(var2, this.f);
        if (this.K) {
            var1.drawLines(this.b(0, this.A), this.N);
            var1.drawLines(this.a(this.A, var6, this.j), this.N);
            var1.drawLines(this.a(this.A, var3), this.N);
            var1.drawLines(this.b(var3, var3 + this.m), this.N);
            int var9 = var3 + this.m;
            if (this.d != 10) {
                var6 = false;
            }

            var1.drawLines(this.a(var9, var6, 0), this.N);
        }

        if (this.L) {
            var1.drawLines(this.a(var3 + this.m), this.O);
            var1.drawLines(this.c(var3, this.j), this.O);
        }

    }

    public int g() {
        return this.A + this.B + this.n - this.h;
    }

    public final void g(Canvas var1) {
        Path var2 = new Path();
        int var3 = this.A;
        int var4 = var3 / 2;
        var2.moveTo((float) var4, (float) var3);
        int var5 = this.A;
        var2.arcTo(new RectF(0.0F, 0.0F, (float) var5, (float) var5), 90.0F, 180.0F);
        var2.lineTo((float) (this.z - var4), 0.0F);
        int var6 = this.z;
        int var7 = this.A;
        var2.arcTo(new RectF((float) (var6 - var7), 0.0F, (float) var6, (float) var7), 270.0F, 180.0F);
        var1.drawPath(var2, this.f);
        if (this.K) {
            int var16 = this.z;
            int var17 = this.A;
            float var18 = (float) (var16 - var17);
            int var19 = this.P;
            var1.drawArc(new RectF(var18, 0.0F, (float) (var16 - var19 / 2), (float) (var17 - var19 / 2)), 330.0F, 120.0F, false, this.N);
            var1.drawLines(this.getNumberBottomShadows(), this.N);
            int var20 = this.P;
            float var21 = (float) (0 + var20 / 2);
            int var22 = this.A;
            var1.drawArc(new RectF(var21, 0.0F, (float) var22, (float) (var22 - var20 / 2)), 90.0F, 30.0F, false, this.N);
        }

        if (this.L) {
            int var8 = this.P;
            float var9 = (float) (0 + var8 / 2);
            float var10 = (float) (0 + var8 / 2);
            int var11 = this.A;
            var1.drawArc(new RectF(var9, var10, (float) var11, (float) var11), 150.0F, 120.0F, false, this.O);
            var1.drawLines(this.getNumberTopReflections(), this.O);
            int var12 = this.z;
            int var13 = this.A;
            float var14 = (float) (var12 - var13);
            int var15 = this.P;
            var1.drawArc(new RectF(var14, (float) (0 + var15 / 2), (float) (var12 - var15 / 2), (float) var13), 270.0F, 30.0F, false, this.O);
        }

    }

    public Gx getClassInfo() {
        if (this.S == null) {
            this.a();
        }

        return this.S;
    }

    public int getTopH() {
        return this.A;
    }

    public int getTotalHeight() {
        int var1 = this.A;
        if (this.b()) {
            var1 += this.n + this.B - this.h;
        }

        if (this.c()) {
            var1 += this.m + this.C - this.h;
        }

        int var2 = this.d;
        if (var2 == 4 || var2 == 7 || var2 == 10 || var2 == 12) {
            var1 += this.h;
        }

        return var1;
    }

    public int getTotalWidth() {
        return this.z;
    }

    public int getW() {
        return this.z;
    }

    public final void h(Canvas var1) {
        var1.drawRect(new Rect(0, 0, this.z, this.A), this.f);
        if (this.K) {
            var1.drawLines(this.getRectShadows(), this.N);
        }

        if (this.L) {
            var1.drawLines(this.getRectReflections(), this.O);
        }

    }

    public void onDraw(Canvas var1) {
        this.f.setColor(this.e);
        switch (this.d) {
            case 1:
                this.h(var1);
                break;
            case 2:
                this.a(var1);
                break;
            case 3:
                this.g(var1);
                break;
            case 4:
            case 5:
                this.b(var1);
            case 6:
            case 8:
            default:
                break;
            case 7:
                this.d(var1);
                break;
            case 9:
                this.c(var1);
                break;
            case 10:
            case 11:
                this.f(var1);
                break;
            case 12:
                this.e(var1);
        }

        super.onDraw(var1);
    }

    public void onMeasure(int var1, int var2) {
        super.onMeasure(MeasureSpec.makeMeasureSpec(this.getTotalWidth(), MeasureSpec.EXACTLY), MeasureSpec.makeMeasureSpec(this.getTotalHeight(), MeasureSpec.EXACTLY));
    }

    public void setSubstack1Height(int var1) {
        int var2 = Math.max(var1, this.i);
        if (var2 != this.B) {
            this.B = var2;
        }

    }

    public void setSubstack2Height(int var1) {
        int var2 = Math.max(var1, this.i);
        if (var2 != this.C) {
            this.C = var2;
        }

    }
}
