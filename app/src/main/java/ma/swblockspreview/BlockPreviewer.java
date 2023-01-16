package ma.swblockspreview;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.ClipData;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

public class BlockPreviewer {
    private Context context;

    public BlockPreviewer(Context context) {
        this.context = context;
    }

    public void previewInto(ViewGroup container, ArrayList<BlockBean> blocks) {
        viewBlockCollectionEditor = new ViewBlockCollectionEditor(context);
        viewBlockCollectionEditor.setScrollEnabled(true);
        blockPane = viewBlockCollectionEditor.getBlockPane();

        this.a(blocks, 8, 8);
        this.l();

        container.removeAllViews();
        container.addView(viewBlockCollectionEditor);
    }

    // idk if this is necessary but here we go anyway.
    // Android is weird when it comes to memory leaks
    public void dispose() {
        this.viewBlockCollectionEditor = null;
        this.blockPane = null;
        this.context = null;
    }

    /**
     * THE CODE BELOW THIS POINT IS *EXTREMELY* MESSY SINCE
     * IT WAS DECOMPILED & PORTED TO *JUST* WORK. NO REFACTORING HAS EVEN
     * BEEN ATTEMPTED BECAUSE I DID NOT WANT TO GO CRAZY, I JUST WANTED
     * IT TO SOMEWHAT WORK.
     *
     * READ/MODIFY AT YOUR OWN RISK !!!
     */

    ViewBlockCollectionEditor viewBlockCollectionEditor;
    BlockPane blockPane;

    private void a(ArrayList<BlockBean> var1, int var2, int var3) {
        HashMap var4 = new HashMap();
        Iterator var5 = var1.iterator();
        Rs var6 = null;
        boolean var7 = true;

        while (var5.hasNext()) {
            Rs var21 = this.a((BlockBean) var5.next());
            var4.put(Integer.valueOf(((Integer) var21.getTag()).intValue()), var21);
            BlockPane var23 = blockPane;
            var23.g = Math.max(var23.g, 1 + ((Integer) var21.getTag()).intValue());
            blockPane.a(var21, var2, var3);
            if (var7) {
                var6 = var21;
                var7 = false;
            }
        }

        Iterator var8 = var1.iterator();

        while (true) {
            BlockBean var9;
            Rs var10;
            do {
                if (!var8.hasNext()) {
                    var6.k();
                    blockPane.b();
                    return;
                }

                var9 = (BlockBean) var8.next();
                var10 = (Rs) var4.get(Integer.valueOf(var9.id));
            } while (var10 == null);

            int var11 = var9.subStack1;
            if (var11 >= 0) {
                Rs var20 = (Rs) var4.get(Integer.valueOf(var11));
                if (var20 != null) {
                    var10.e(var20);
                }
            }

            int var12 = var9.subStack2;
            if (var12 >= 0) {
                Rs var19 = (Rs) var4.get(Integer.valueOf(var12));
                if (var19 != null) {
                    var10.f(var19);
                }
            }

            int var13 = var9.nextBlock;
            if (var13 >= 0) {
                Rs var18 = (Rs) var4.get(Integer.valueOf(var13));
                if (var18 != null) {
                    var10.b(var18);
                }
            }

            int var14 = var9.parameters.size();

            for (int var15 = 0; var15 < var14; ++var15) {
                String var16 = (String) var9.parameters.get(var15);
                if (var16 != null && var16.length() > 0) {
                    if (var16.charAt(0) == 64) {
                        Rs var17 = (Rs) var4.get(Integer.valueOf(Integer.valueOf(var16.substring(1)).intValue()));
                        if (var17 != null && var10.V.size() > 0) {
                            var10.a((Ts) var10.V.get(var15), var17);
                        }
                    } else {
                        if (var10.V.size() > 0) {
                            ((Ss) var10.V.get(var15)).setArgValue(var16);

                            _argOnClick(((Ss) var10.V.get(var15)));

                            var10.m();
                        }
                    }
                }
            }
        }
    }

    private Rs a(BlockBean var1) {
        Rs var2 = new Rs(context, Integer.valueOf(var1.id).intValue(), var1.spec, var1.type, var1.typeName, var1.opCode);
        var2.e = var1.color;

        blockOnClick(var2, var1);

        return var2;
    }

    private void blockOnClick(Rs rs, final BlockBean bean) {
        rs.setOnClickListener(v -> {
            StringBuilder info = new StringBuilder();
            info.append("opCode: ");
            info.append(bean.opCode);
            info.append("\n\n");
            info.append("spec: ");
            info.append(bean.spec);
            info.append("\n\n");
            info.append("type: ");
            info.append(bean.type.equals(" ") ? "regular" : bean.type);
            info.append("\n\n");
            if (!bean.typeName.equals("")) {
                info.append("typeName: ");
                info.append(bean.typeName);
                info.append("\n\n");
            }
            info.append("color: ");
            info.append(bean.color);

            dialog("Block info", info.toString());
        });

    }

    private void _argOnClick(final Ss ss) {
        ss.setOnClickListener(v -> {
            dialog("Argument info", String.valueOf(ss.getArgValue()));
        });
    }

    private void dialog(String title, String message) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(context);
        dialog.setTitle(title);
        dialog.setMessage(message);

        dialog.setPositiveButton("OK", null);
        AlertDialog dlg = dialog.create();
        dlg.show();

        View messageView = dlg.findViewById(android.R.id.message);
        if (messageView instanceof TextView) {
            ((TextView) messageView).setTextIsSelectable(true);
        }
    }

    private void l() {
        int var1 = context.getResources().getDisplayMetrics().heightPixels;
        //  this.r.measure(0, 0);
        int var2 = 0;//this.r.getMeasuredHeight();
        LinearLayout.LayoutParams var3 = new LinearLayout.LayoutParams(-1, var1 - a(context) - f(context) - var2);
        viewBlockCollectionEditor.setLayoutParams(var3);
        viewBlockCollectionEditor.requestLayout();
    }

    private static int a(Context var0) {
        return (int) wB.a(var0, 48.0F);
    }

    private static int f(Context var0) {
        int var1 = var0.getResources().getIdentifier("status_bar_height", "dimen", "android");
        return var1 > 0 ? var0.getResources().getDimensionPixelSize(var1) : 0;
    }

    private class ViewBlockCollectionEditor extends LogicEditorScrollView {
        public Context i;
        public BlockPane j;
        public boolean k = true;
        public int[] l = new int[2];

        public ViewBlockCollectionEditor(Context var1) {
            super(var1);
            this.aa(var1);
        }

        public ViewBlockCollectionEditor(Context var1, AttributeSet var2) {
            super(var1, var2);
            this.aa(var1);
        }

        private void aa(Context var1) {
            this.i = var1;
            this.j = new BlockPane(this.i);
            this.j.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            this.addView(this.j);
        }

        public BlockPane getBlockPane() {
            return this.j;
        }

        public void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
            super.onLayout(var1, var2, var3, var4, var5);
            if (this.k) {
                this.j.getLayoutParams().width = var4 - var2;
                this.j.getLayoutParams().height = var5 - var3;
                this.j.b();
                this.k = false;
            }

        }
    }

    private class LogicEditorScrollView extends FrameLayout {
        public float a = 0.0F;
        public float b = 0.0F;
        public int c = 0;
        public boolean d = false;
        public boolean e = true;
        public boolean f = true;
        public float g = -1.0F;
        public float h = -1.0F;

        public LogicEditorScrollView(Context var1) {
            super(var1);
            this.a(var1);
        }

        public LogicEditorScrollView(Context var1, AttributeSet var2) {
            super(var1, var2);
            this.a(var1);
        }

        public final void a(Context var1) {
            this.c = ViewConfiguration.get(var1).getScaledTouchSlop();
        }

        public boolean a() {
            if (this.getChildCount() <= 0) {
                return false;
            } else {
                boolean var1 = this.f;
                boolean var2 = false;
                if (var1) {
                    if (!this.e) {
                        return false;
                    }

                    View var3 = this.getChildAt(0);
                    int var4 = var3.getWidth();
                    int var5 = var3.getHeight();
                    if (this.getWidth() >= var4 + this.getPaddingLeft() + this.getPaddingRight()) {
                        int var6 = this.getHeight();
                        int var7 = var5 + this.getPaddingTop() + this.getPaddingBottom();
                        var2 = false;
                        if (var6 >= var7) {
                            return var2;
                        }
                    }

                    var2 = true;
                }

                return var2;
            }
        }

        public void addView(View var1) {
            if (this.getChildCount() <= 1) {
                super.addView(var1);
            } else {
                throw new IllegalStateException("BothDirectionScrollView should have child View only one");
            }
        }

        public boolean getScrollEnabled() {
            return this.e;
        }

        public boolean getUseScroll() {
            return this.f;
        }

        public boolean onInterceptTouchEvent(MotionEvent var1) {
            if (!this.a()) {
                return false;
            } else {
                int var2 = var1.getAction();
                if (var2 == 2 && this.d) {
                    return true;
                } else {
                    float var3 = var1.getX();
                    float var4 = var1.getY();
                    if (var2 != 0) {
                        if (var2 != 1) {
                            if (var2 == 2) {
                                int var5 = (int) Math.abs(this.a - var3);
                                int var6 = (int) Math.abs(this.b - var4);
                                int var7 = this.c;
                                if (var5 > var7 || var6 > var7) {
                                    this.d = true;
                                }
                            }
                        } else {
                            this.d = false;
                        }
                    } else {
                        this.a = var3;
                        this.b = var4;
                        this.d = false;
                    }

                    return this.d;
                }
            }
        }

        public boolean onTouchEvent(MotionEvent var1) {
            if (!this.a()) {
                return false;
            } else {
                View var2 = this.getChildAt(0);
                int var3 = var1.getAction();
                float var4 = var1.getX();
                float var5 = var1.getY();
                if (var3 != 0) {
                    if (var3 == 1) {
                        this.g = -1.0F;
                        this.h = -1.0F;
                        return true;
                    }

                    if (var3 != 2) {
                        return true;
                    }

                    if (this.g < 0.0F) {
                        this.g = var4;
                    }

                    if (this.h < 0.0F) {
                        this.h = var5;
                    }

                    int var6 = (int) (this.g - var4);
                    int var7 = (int) (this.h - var5);
                    this.g = var4;
                    this.h = var5;
                    int var9;
                    if (var6 <= 0) {
                        if (this.getScrollX() <= 0) {
                            var6 = 0;
                        }

                        var9 = Math.max(0 - this.getScrollX(), var6);
                    } else {
                        int var8 = var2.getRight() - this.getScrollX() - this.getWidth() - this.getPaddingRight();
                        if (var8 > 0) {
                            var9 = Math.min(var8, var6);
                        } else {
                            var9 = 0;
                        }
                    }

                    int var11;
                    if (var7 <= 0) {
                        if (this.getScrollY() <= 0) {
                            var7 = 0;
                        }

                        var11 = Math.max(0 - this.getScrollY(), var7);
                    } else {
                        int var10 = var2.getBottom() - this.getScrollY() - this.getHeight() - this.getPaddingBottom();
                        var11 = 0;
                        if (var10 > 0) {
                            var11 = Math.min(var10, var7);
                        }
                    }

                    if (var9 != 0 || var11 != 0) {
                        this.scrollBy(var9, var11);
                        return true;
                    }
                } else {
                    this.g = var4;
                    this.h = var5;
                }

                return true;
            }
        }

        public void setScrollEnabled(boolean var1) {
            this.e = var1;
        }

        public void setUseScroll(boolean var1) {
            this.f = var1;
        }
    }

    @SuppressLint("ParcelCreator") // TODO
    public class BlockBean extends SelectableBean implements Parcelable {
        /*  public static final Creator CREATOR = new Creator() {
        public BlockBean createFromParcel(Parcel var1) {
            return new BlockBean(var1);
        }

        public BlockBean[] newArray(int var1) {
            return new BlockBean[var1];
        }
    };*/
        public Gx classInfo;
        @com.google.gson.annotations.Expose
        public int color;
        @com.google.gson.annotations.Expose
        public String id;
        @com.google.gson.annotations.Expose
        public int nextBlock;
        @com.google.gson.annotations.Expose
        public String opCode;
        public ArrayList paramClassInfo;
        @com.google.gson.annotations.Expose
        public ArrayList parameters;
        @com.google.gson.annotations.Expose
        public String spec;
        @com.google.gson.annotations.Expose
        public int subStack1;
        @com.google.gson.annotations.Expose
        public int subStack2;
        @com.google.gson.annotations.Expose
        public String type;
        @com.google.gson.annotations.Expose
        public String typeName;

        public BlockBean() {
            this.parameters = new ArrayList();
            this.subStack1 = -1;
            this.subStack2 = -1;
            this.nextBlock = -1;
        }

        public BlockBean(Parcel var1) {
            this.id = var1.readString();
            this.spec = var1.readString();
            this.type = var1.readString();
            this.typeName = var1.readString();
            this.opCode = var1.readString();
            this.color = var1.readInt();
            this.parameters = (ArrayList) var1.readSerializable();
            this.subStack1 = var1.readInt();
            this.subStack2 = var1.readInt();
            this.nextBlock = var1.readInt();
            this.buildClassInfo();
        }

        public BlockBean(String var1, String var2, String var3, String var4) {
            this(var1, var2, var3, "", var4);
        }

        public BlockBean(String var1, String var2, String var3, String var4, String var5) {
            this.id = var1;
            this.spec = var2;
            this.type = var3;
            this.typeName = var4;
            this.opCode = var5;
            this.parameters = new ArrayList();
            this.subStack1 = -1;
            this.subStack2 = -1;
            this.nextBlock = -1;
            this.buildClassInfo();
        }

        private void buildClassInfo() {
            this.classInfo = mq.a(this.type, this.typeName);
            this.paramClassInfo = mq.a(this.spec);
        }

        /*    public static Creator getCreator() {
        return CREATOR;
    }
*/
        public BlockBean clone() {
            BlockBean var1 = new BlockBean();
            var1.copy(this);
            return var1;
        }

        public void copy(BlockBean var1) {
            this.id = var1.id;
            this.spec = var1.spec;
            this.type = var1.type;
            this.typeName = var1.typeName;
            this.opCode = var1.opCode;
            this.color = var1.color;
            this.parameters = new ArrayList(var1.parameters);
            this.subStack1 = var1.subStack1;
            this.subStack2 = var1.subStack2;
            this.nextBlock = var1.nextBlock;
            this.buildClassInfo();
        }

        public int describeContents() {
            return 0;
        }

        public Gx getClassInfo() {
            if (this.classInfo == null) {
                this.buildClassInfo();
            }

            return this.classInfo;
        }

        public ArrayList getParamClassInfo() {
            if (this.paramClassInfo == null) {
                this.buildClassInfo();
            }

            return this.paramClassInfo;
        }

        public boolean isEqual(BlockBean var1) {
            if (var1 == null) {
                return false;
            } else {
                String var2 = this.id;
                if (var2 != null && !var2.equals(var1.id)) {
                    return false;
                } else {
                    String var3 = this.spec;
                    if (var3 != null && !var3.equals(var1.spec)) {
                        return false;
                    } else if (!this.type.equals(var1.type)) {
                        return false;
                    } else {
                        String var4 = this.typeName;
                        if (var4 != null && !var4.equals(var1.typeName)) {
                            return false;
                        } else if (!this.opCode.equals(var1.opCode)) {
                            return false;
                        } else if (this.color != var1.color) {
                            return false;
                        } else if (this.subStack1 != var1.subStack1) {
                            return false;
                        } else if (this.subStack2 != var1.subStack2) {
                            return false;
                        } else if (this.nextBlock != var1.nextBlock) {
                            return false;
                        } else {
                            ArrayList var5 = this.parameters;
                            if (var5 != null && var5.size() != var1.parameters.size()) {
                                return false;
                            } else {
                                for (int var6 = 0; var6 < this.parameters.size(); ++var6) {
                                    String var7 = (String) this.parameters.get(var6);
                                    String var8 = (String) var1.parameters.get(var6);
                                    if (var7 != null && !var7.equals(var8)) {
                                        return false;
                                    }
                                }

                                return true;
                            }
                        }
                    }
                }
            }
        }

        public void print() {
        }

        public void writeToParcel(Parcel var1, int var2) {
            var1.writeString(this.id);
            var1.writeString(this.spec);
            var1.writeString(this.type);
            var1.writeString(this.typeName);
            var1.writeString(this.opCode);
            var1.writeInt(this.color);
            var1.writeSerializable(this.parameters);
            var1.writeInt(this.subStack1);
            var1.writeInt(this.subStack2);
            var1.writeInt(this.nextBlock);
        }
    }


    private class SelectableBean extends nA {
        public static final int SAVED_POS_ETC = 2;
        public static final int SAVED_POS_NONE = -1;
        public static final int SAVED_POS_SKETCHWARE_DATA = 0;
        public static final int SAVED_POS_STORAGE = 1;
        public boolean isNew;
        public boolean isSelected;
        public int savedPos;

        public SelectableBean() {
            this(-1);
        }

        public SelectableBean(int var1) {
            this(var1, false);
        }

        public SelectableBean(int var1, boolean var2) {
            this.savedPos = -1;
            this.isSelected = false;
            this.isNew = false;
            this.isSelected = false;
            this.savedPos = var1;
            this.isNew = var2;
        }
    }

    private class nA {
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

    private class BlockPane extends RelativeLayout {
        public Context a;
        public int[] b = new int[2];
        public Ts c;
        public Rs d;
        public ArrayList e = new ArrayList();
        public Object[] f = null;
        public int g = 10;
        public float h = wB.a(this.getContext(), 1.0F);

        public BlockPane(Context var1) {
            super(var1);
            this.a(var1);
        }

        public Rs a(int var1) {
            return (Rs) this.findViewWithTag(Integer.valueOf(var1));
        }

        public Rs a(Rs var1, int var2, int var3) {
            this.getLocationOnScreen(this.b);
            if (var1.getBlockType() == 1) {
                Context var4 = this.getContext();
                int var5 = this.g;
                this.g = var5 + 1;
                Rs var6 = new Rs(var4, var5, var1.T, var1.b, var1.c, var1.U);
                var1 = var6;
            }

            var1.pa = this;
            this.addView(var1);
            var1.setX((float) (var2 - this.b[0] - this.getPaddingLeft()));
            var1.setY((float) (var3 - this.b[1] - this.getPaddingTop()));
            return var1;
        }

        public Rs a(Rs var1, int var2, int var3, boolean var4) {
            Rs var5;
            if (!var4) {
                var5 = this.a(var1, var2, var3);
            } else {
                var1.setX((float) (var2 - this.b[0] - this.getPaddingLeft()));
                var1.setY((float) (var3 - this.b[1] - this.getPaddingTop()));
                var5 = var1;
            }

            Object[] var6 = this.f;
            if (var6 == null) {
                var5.p().k();
                this.b();
                return var5;
            } else {
                if (var1.fa) {
                    ((Ts) var6[1]).E.a((Ts) var6[1], var5);
                } else {
                    Rs var7 = (Rs) var6[1];
                    int var8 = ((Integer) var6[2]).intValue();
                    if (var8 != 0) {
                        if (var8 != 1) {
                            if (var8 != 2) {
                                if (var8 != 3) {
                                    if (var8 == 4) {
                                        var7.d(var5);
                                    }
                                } else {
                                    var7.f(var5);
                                }
                            } else {
                                var7.e(var5);
                            }
                        } else {
                            var7.c(var5);
                        }
                    } else {
                        var7.b(var5);
                    }
                }

                var5.p().k();
                this.b();
                return var5;
            }
        }

        public Rs a(String var1) {
            return (Rs) this.findViewWithTag(Integer.valueOf(var1));
        }

        public final void a() {
            if (this.c == null) {
                this.c = new Ts(this.a, " ", true);
            }

            this.c.a(10.0F, 10.0F, false);
            this.addView(this.c);
            this.d();
        }

        public void a(Rs var1) {
            boolean var2 = var1.h().ga;
            boolean var3;
            if (var1.b() && -1 == var1.ia) {
                var3 = true;
            } else {
                var3 = false;
            }

            boolean var4 = var1.fa;
            this.a(var1.getTag().toString(), var2, var3, var4, var1.getHeight(), var1.f());
            this.f = null;
        }

        public void a(Rs var1, int var2) {
            while (true) {
                if (var1 != null) {
                    var1.setVisibility(var2);
                    Iterator var3 = var1.V.iterator();

                    while (var3.hasNext()) {
                        View var7 = (View) var3.next();
                        if (var7 instanceof Rs) {
                            this.a((Rs) var7, var2);
                        }
                    }

                    if (var1.b()) {
                        int var6 = var1.ia;
                        if (var6 != -1) {
                            this.a((Rs) this.findViewWithTag(Integer.valueOf(var6)), var2);
                        }
                    }

                    if (var1.c()) {
                        int var5 = var1.ja;
                        if (var5 != -1) {
                            this.a((Rs) this.findViewWithTag(Integer.valueOf(var5)), var2);
                        }
                    }

                    int var4 = var1.ha;
                    if (var4 != -1) {
                        var1 = (Rs) this.findViewWithTag(Integer.valueOf(var4));
                        continue;
                    }
                }

                return;
            }
        }

        public final void a(Rs var1, String var2) {
            while (true) {
                if (var1 != null) {
                    if (!var1.ea) {
                        for (int var6 = 0; var6 < var1.V.size(); ++var6) {
                            View var7 = (View) var1.V.get(var6);
                            boolean var8 = var7 instanceof Rs;
                            if ((var8 || var7 instanceof Ss) && (!var8 || !var7.getTag().toString().equals(var2))) {
                                int[] var9 = new int[2];
                                var7.getLocationOnScreen(var9);
                                this.a(var9, var7, 0);
                                if (var8) {
                                    this.a((Rs) var7, var2);
                                }
                            }
                        }
                    }

                    int var3 = var1.ia;
                    if (var3 != -1) {
                        this.a((Rs) this.findViewWithTag(Integer.valueOf(var3)), var2);
                    }

                    int var4 = var1.ja;
                    if (var4 != -1) {
                        this.a((Rs) this.findViewWithTag(Integer.valueOf(var4)), var2);
                    }

                    int var5 = var1.ha;
                    if (var5 != -1) {
                        var1 = (Rs) this.findViewWithTag(Integer.valueOf(var5));
                        continue;
                    }
                }

                return;
            }
        }

        public void a(Rs var1, ArrayList var2) {
            if (var2.size() <= 0) {
                this.a(var1);
            } else {
                BlockBean var3;
                BlockBean var4;
                byte var7;
                label64:
                {
                    var3 = (BlockBean) var2.get(0);
                    var4 = (BlockBean) var2.get(var2.size() - 1);
                    String var5 = var3.type;
                    int var6 = var5.hashCode();
                    if (var6 != 97) {
                        if (var6 != 98) {
                            if (var6 != 100) {
                                if (var6 != 108) {
                                    if (var6 != 112) {
                                        if (var6 != 115) {
                                            if (var6 == 118 && var5.equals("v")) {
                                                var7 = 3;
                                                break label64;
                                            }
                                        } else if (var5.equals("s")) {
                                            var7 = 1;
                                            break label64;
                                        }
                                    } else if (var5.equals("p")) {
                                        var7 = 4;
                                        break label64;
                                    }
                                } else if (var5.equals("l")) {
                                    var7 = 5;
                                    break label64;
                                }
                            } else if (var5.equals("d")) {
                                var7 = 2;
                                break label64;
                            }
                        } else if (var5.equals("b")) {
                            var7 = 0;
                            break label64;
                        }
                    } else if (var5.equals("a")) {
                        var7 = 6;
                        break label64;
                    }

                    var7 = -1;
                }

                boolean var8;
                switch (var7) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                        var8 = true;
                        break;
                    default:
                        var8 = false;
                }

                boolean var9 = var4.type.equals("f");
                boolean var10;
                if ((var3.type.equals("c") || var3.type.equals("e")) && var3.subStack1 <= 0) {
                    var10 = true;
                } else {
                    var10 = false;
                }

                this.a(var3.id, var9, var10, var8, var1.getHeight(), var1.f());
                this.f = null;
            }
        }

        public final void a(Rs var1, boolean var2) {
            while (var1.getVisibility() != View.GONE) {
                if (!var1.ga && (!var2 || -1 == var1.ha)) {
                    int[] var8 = new int[2];
                    var1.getLocationOnScreen(var8);
                    var8[1] += var1.d();
                    this.a(var8, var1, 0);
                }

                if (var1.b() && (!var2 || var1.ia == -1)) {
                    int[] var7 = new int[2];
                    var1.getLocationOnScreen(var7);
                    var7[0] += var1.j;
                    var7[1] += var1.f();
                    this.a(var7, var1, 2);
                }

                if (var1.c() && (!var2 || var1.ja == -1)) {
                    int[] var6 = new int[2];
                    var1.getLocationOnScreen(var6);
                    var6[0] += var1.j;
                    var6[1] += var1.g();
                    this.a(var6, var1, 3);
                }

                int var3 = var1.ia;
                if (var3 != -1) {
                    this.a((Rs) this.findViewWithTag(Integer.valueOf(var3)), var2);
                }

                int var4 = var1.ja;
                if (var4 != -1) {
                    this.a((Rs) this.findViewWithTag(Integer.valueOf(var4)), var2);
                }

                int var5 = var1.ha;
                if (var5 == -1) {
                    return;
                }

                var1 = (Rs) this.findViewWithTag(Integer.valueOf(var5));
            }

        }

        public final void a(Context var1) {
            this.a = var1;
            this.a();
        }

        public void a(BlockBean var1, boolean var2) {
            String var3 = var1.id;
            if (var3 != null && !var3.equals("")) {
                if (var1.id.equals("0")) {
                    return;
                }

                Rs var4 = (Rs) this.findViewWithTag(Integer.valueOf(var1.id));
                if (var4 == null) {
                    return;
                }

                Rs var5 = var4.E;
                if (var4 != var5) {
                    this.c(var4);
                    this.removeView(var4);
                } else {
                    this.removeView(var4);
                }

                if (var2 && var5 != null) {
                    var5.p().k();
                }
            }

        }

        public void a(String var1, String var2) {
            Rs var3 = new Rs(this.getContext(), 0, var1, "h", var2);
            this.d = var3;
            Rs var4 = this.d;
            var4.pa = this;
            this.addView(var4);
            float var5 = wB.a(this.getContext(), 1.0F);
            Rs var6 = this.d;
            float var7 = var5 * 8.0F;
            var6.setX(var7);
            this.d.setY(var7);
        }

        public void a(String str, boolean z, boolean z2, boolean z3, int i, int i2) {
            this.e = new ArrayList();
            int i3 = (int) (3.0f * this.h);
            for (int i4 = 0; i4 < getChildCount(); i4++) {
                View childAt = getChildAt(i4);
                if (childAt instanceof Rs) {
                    Rs rs = (Rs) childAt;
                    if (rs.getVisibility() != View.GONE && rs.E == null) {
                        if (z3) {
                            a(rs, str);
                        } else if (!rs.fa) {
                            int[] iArr;
                            boolean z4 = true;
                            if (!(z || rs.ea)) {
                                iArr = new int[2];
                                rs.getLocationOnScreen(iArr);
                                iArr[1] = iArr[1] - (i - i3);
                                a(iArr, (View) rs, 1);
                            }
                            if (z2 && !rs.ea) {
                                iArr = new int[2];
                                rs.getLocationOnScreen(iArr);
                                iArr[0] = iArr[0] - rs.j;
                                iArr[1] = iArr[1] - (i2 - i3);
                                a(iArr, (View) rs, 4);
                            }
                            if (!z || z2) {
                                z4 = false;
                            }
                            a(rs, z4);
                        }
                    }
                }
            }
        }

        public final void a(int[] var1, View var2, int var3) {
            Object[] var4 = new Object[]{var1, var2, Integer.valueOf(var3)};
            this.e.add(var4);
        }

        public final boolean a(Rs var1, View var2) {
            if (!var1.fa) {
                return true;
            } else {
                if (var2 instanceof Ts) {
                    Gx var3 = var1.getClassInfo();
                    if (var3 == null) {
                        return false;
                    }

                    Gx var4 = ((Ts) var2).getClassInfo();
                    if (var4 == null) {
                        return false;
                    }

                    if (var3.a(var4)) {
                        return true;
                    }

                    if (var2 instanceof Rs && var3.a(mq.b(((Rs) var2).ra))) {
                        return true;
                    }
                }

                return false;
            }
        }

        public void b() {
            int var1 = this.getChildCount();
            int var2 = this.getLayoutParams().width;
            int var3 = this.getLayoutParams().width;

            for (int var4 = 0; var4 < var1; ++var4) {
                View var5 = this.getChildAt(var4);
                if (var5 instanceof Rs) {
                    float var6 = var5.getX();
                    Rs var7 = (Rs) var5;
                    var2 = Math.max(150 + (int) (var6 + (float) var7.getWidthSum()), var2);
                    var3 = Math.max(150 + (int) (var5.getY() + (float) var7.getHeightSum()), var3);
                }
            }

            this.getLayoutParams().width = var2;
            this.getLayoutParams().height = var3;
        }

        public void b(Rs var1) {
            this.c(var1);
            Iterator var2 = var1.getAllChildren().iterator();

            while (var2.hasNext()) {
                this.removeView((Rs) var2.next());
            }

        }

        public boolean b(String var1) {
            int var2 = this.getChildCount();

            for (int var3 = 0; var3 < var2; ++var3) {
                View var4 = this.getChildAt(var3);
                if (var4 instanceof Rs) {
                    BlockBean var5;
                    byte var7;
                    label112:
                    {
                        var5 = ((Rs) var4).getBean();
                        String var6 = var5.opCode;
                        switch (var6.hashCode()) {
                            case -1998407506:
                                if (var6.equals("listSetData")) {
                                    var7 = 15;
                                    break label112;
                                }
                                break;
                            case -1384861688:
                                if (var6.equals("getAtListInt")) {
                                    var7 = 9;
                                    break label112;
                                }
                                break;
                            case -1384858251:
                                if (var6.equals("getAtListMap")) {
                                    var7 = 21;
                                    break label112;
                                }
                                break;
                            case -1384851894:
                                if (var6.equals("getAtListStr")) {
                                    var7 = 10;
                                    break label112;
                                }
                                break;
                            case -1271141237:
                                if (var6.equals("clearList")) {
                                    var7 = 5;
                                    break label112;
                                }
                                break;
                            case -1249347599:
                                if (var6.equals("getVar")) {
                                    var7 = 0;
                                    break label112;
                                }
                                break;
                            case -1139353316:
                                if (var6.equals("setListMap")) {
                                    var7 = 23;
                                    break label112;
                                }
                                break;
                            case -733318734:
                                if (var6.equals("strToListMap")) {
                                    var7 = 17;
                                    break label112;
                                }
                                break;
                            case -329562760:
                                if (var6.equals("insertListInt")) {
                                    var7 = 18;
                                    break label112;
                                }
                                break;
                            case -329559323:
                                if (var6.equals("insertListMap")) {
                                    var7 = 22;
                                    break label112;
                                }
                                break;
                            case -329552966:
                                if (var6.equals("insertListStr")) {
                                    var7 = 19;
                                    break label112;
                                }
                                break;
                            case -96313603:
                                if (var6.equals("containListInt")) {
                                    var7 = 2;
                                    break label112;
                                }
                                break;
                            case -96310166:
                                if (var6.equals("containListMap")) {
                                    var7 = 4;
                                    break label112;
                                }
                                break;
                            case -96303809:
                                if (var6.equals("containListStr")) {
                                    var7 = 3;
                                    break label112;
                                }
                                break;
                            case 134874756:
                                if (var6.equals("listSetCustomViewData")) {
                                    var7 = 16;
                                    break label112;
                                }
                                break;
                            case 389111867:
                                if (var6.equals("spnSetData")) {
                                    var7 = 14;
                                    break label112;
                                }
                                break;
                            case 762282303:
                                if (var6.equals("indexListInt")) {
                                    var7 = 11;
                                    break label112;
                                }
                                break;
                            case 762292097:
                                if (var6.equals("indexListStr")) {
                                    var7 = 12;
                                    break label112;
                                }
                                break;
                            case 1160674468:
                                if (var6.equals("lengthList")) {
                                    var7 = 1;
                                    break label112;
                                }
                                break;
                            case 1252547704:
                                if (var6.equals("listMapToStr")) {
                                    var7 = 6;
                                    break label112;
                                }
                                break;
                            case 1764351209:
                                if (var6.equals("deleteList")) {
                                    var7 = 13;
                                    break label112;
                                }
                                break;
                            case 2090179216:
                                if (var6.equals("addListInt")) {
                                    var7 = 7;
                                    break label112;
                                }
                                break;
                            case 2090182653:
                                if (var6.equals("addListMap")) {
                                    var7 = 20;
                                    break label112;
                                }
                                break;
                            case 2090189010:
                                if (var6.equals("addListStr")) {
                                    var7 = 8;
                                    break label112;
                                }
                        }

                        var7 = -1;
                    }

                    switch (var7) {
                        case 0:
                            if (var5.spec.equals(var1)) {
                                return true;
                            }
                            break;
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                            if (((String) var5.parameters.get(0)).equals(var1)) {
                                return true;
                            }
                            break;
                        case 7:
                        case 8:
                        case 9:
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                        case 14:
                        case 15:
                        case 16:
                        case 17:
                            if (((String) var5.parameters.get(1)).equals(var1)) {
                                return true;
                            }
                            break;
                        case 18:
                        case 19:
                        case 20:
                        case 21:
                            if (((String) var5.parameters.get(2)).equals(var1)) {
                                return true;
                            }
                            break;
                        case 22:
                        case 23:
                            if (((String) var5.parameters.get(3)).equals(var1)) {
                                return true;
                            }
                    }
                }
            }

            return false;
        }

        public Object[] b(Rs var1, int var2, int var3) {
            byte var4;
            if (var1.fa) {
                var4 = 40;
            } else {
                var4 = 60;
            }

            int var5 = 100000;
            Object[] var6 = null;
            Point var7 = new Point(var2, var3);

            for (int var8 = 0; var8 < this.e.size(); ++var8) {
                Object[] var9 = (Object[]) this.e.get(var8);
                int[] var10 = (int[]) var9[0];
                Point var11 = new Point(var7.x - var10[0], var7.y - var10[1]);
                int var12 = Math.abs(var11.x / 2) + Math.abs(var11.y);
                if (var12 < var5 && var12 < var4 && this.a(var1, (View) var9[1])) {
                    var6 = var9;
                    var5 = var12;
                }
            }

            return var6;
        }

        public void c() {
            this.d();
            this.e = new ArrayList();
            this.f = null;
        }

        public void c(Rs var1) {
            Rs var2 = var1.E;
            if (var2 != null) {
                if (var2 != null) {
                    var2.g(var1);
                    var1.E = null;
                }

            }
        }

        public void c(Rs rs, int i, int i2) {
            Object[] objArr;
            int intValue;
            getLocationOnScreen(this.b);
            this.f = b(rs, i, i2);
            if (rs.b() && -1 == rs.ia) {
                objArr = this.f;
                if (objArr != null) {
                    Rs rs2 = (Rs) objArr[1];
                    intValue = ((Integer) objArr[2]).intValue();
                    if (intValue == 0) {
                        rs2 = (Rs) findViewWithTag(Integer.valueOf(rs2.ha));
                    } else if (intValue == 2) {
                        rs2 = (Rs) findViewWithTag(Integer.valueOf(rs2.ia));
                    } else if (intValue == 3) {
                        rs2 = (Rs) findViewWithTag(Integer.valueOf(rs2.ja));
                    }
                }
            }
            objArr = this.f;
            if (objArr != null) {
                int[] iArr = (int[]) objArr[0];
                View view = (View) objArr[1];
                this.c.setX((float) (iArr[0] - this.b[0]));
                this.c.setY((float) (iArr[1] - this.b[1]));
                this.c.bringToFront();
                this.c.setVisibility(View.VISIBLE);
                if (rs.fa) {
                    if (view instanceof Rs) {
                        this.c.a((Rs) view, true, false, 0);
                    }
                    if (view instanceof Ss) {
                        this.c.a((Ss) view, true, false, 0);
                        return;
                    }
                    return;
                }
                int intValue2 = ((Integer) this.f[2]).intValue();
                intValue = intValue2 == 4 ? ((Rs) view).getHeightSum() : 0;
                boolean z = (intValue2 == 1 || intValue2 == 4) ? false : true;
                this.c.a(rs, false, z, intValue);
                return;
            }
            d();
        }

        public boolean c(String var1) {
            int var2 = this.getChildCount();

            for (int var3 = 0; var3 < var2; ++var3) {
                View var4 = this.getChildAt(var3);
                if (var4 instanceof Rs) {
                    BlockBean var5;
                    byte var7;
                    label97:
                    {
                        var5 = ((Rs) var4).getBean();
                        String var6 = var5.opCode;
                        switch (var6.hashCode()) {
                            case -2120571577:
                                if (var6.equals("mapIsEmpty")) {
                                    var7 = 13;
                                    break label97;
                                }
                                break;
                            case -1920517885:
                                if (var6.equals("setVarBoolean")) {
                                    var7 = 1;
                                    break label97;
                                }
                                break;
                            case -1384858251:
                                if (var6.equals("getAtListMap")) {
                                    var7 = 19;
                                    break label97;
                                }
                                break;
                            case -1377080719:
                                if (var6.equals("decreaseInt")) {
                                    var7 = 5;
                                    break label97;
                                }
                                break;
                            case -1249347599:
                                if (var6.equals("getVar")) {
                                    var7 = 0;
                                    break label97;
                                }
                                break;
                            case -1081400230:
                                if (var6.equals("mapGet")) {
                                    var7 = 8;
                                    break label97;
                                }
                                break;
                            case -1081391085:
                                if (var6.equals("mapPut")) {
                                    var7 = 7;
                                    break label97;
                                }
                                break;
                            case -329559323:
                                if (var6.equals("insertListMap")) {
                                    var7 = 16;
                                    break label97;
                                }
                                break;
                            case 152967761:
                                if (var6.equals("mapClear")) {
                                    var7 = 12;
                                    break label97;
                                }
                                break;
                            case 168740282:
                                if (var6.equals("mapToStr")) {
                                    var7 = 17;
                                    break label97;
                                }
                                break;
                            case 442768763:
                                if (var6.equals("mapGetAllKeys")) {
                                    var7 = 14;
                                    break label97;
                                }
                                break;
                            case 463560551:
                                if (var6.equals("mapContainKey")) {
                                    var7 = 9;
                                    break label97;
                                }
                                break;
                            case 657721930:
                                if (var6.equals("setVarInt")) {
                                    var7 = 2;
                                    break label97;
                                }
                                break;
                            case 747168008:
                                if (var6.equals("mapCreateNew")) {
                                    var7 = 6;
                                    break label97;
                                }
                                break;
                            case 754442829:
                                if (var6.equals("increaseInt")) {
                                    var7 = 4;
                                    break label97;
                                }
                                break;
                            case 836692861:
                                if (var6.equals("mapSize")) {
                                    var7 = 11;
                                    break label97;
                                }
                                break;
                            case 845089750:
                                if (var6.equals("setVarString")) {
                                    var7 = 3;
                                    break label97;
                                }
                                break;
                            case 1431171391:
                                if (var6.equals("mapRemoveKey")) {
                                    var7 = 10;
                                    break label97;
                                }
                                break;
                            case 1775620400:
                                if (var6.equals("strToMap")) {
                                    var7 = 18;
                                    break label97;
                                }
                                break;
                            case 2090182653:
                                if (var6.equals("addListMap")) {
                                    var7 = 15;
                                    break label97;
                                }
                        }

                        var7 = -1;
                    }

                    switch (var7) {
                        case 0:
                            if (var5.spec.equals(var1)) {
                                return true;
                            }
                            break;
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                        case 9:
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                        case 14:
                        case 15:
                        case 16:
                        case 17:
                            if (((String) var5.parameters.get(0)).equals(var1)) {
                                return true;
                            }
                            break;
                        case 18:
                            if (((String) var5.parameters.get(1)).equals(var1)) {
                                return true;
                            }
                            break;
                        case 19:
                            if (((String) var5.parameters.get(2)).equals(var1)) {
                                return true;
                            }
                    }
                }
            }

            return false;
        }

        public void d() {
            this.c.setVisibility(View.GONE);
        }

        public int getAddTargetId() {
            Object[] var1 = this.getNearestTarget();
            int var2 = -1;
            if (var1 != null && var1[2] != null) {
                int var3 = ((Integer) var1[2]).intValue();
                if ((var3 == 0 || var3 == 2 || var3 == 3 || var3 == 5) && var1[1] != null) {
                    View var4 = (View) var1[1];
                    if (var4 instanceof Rs) {
                        Rs var5 = (Rs) var4;
                        if (var5.fa) {
                            var2 = ((Integer) var5.E.getTag()).intValue();
                        } else {
                            var2 = ((Integer) ((Rs) var1[1]).getTag()).intValue();
                        }
                    }

                    if (var4 instanceof Ss) {
                        var2 = ((Integer) ((Ss) var4).E.getTag()).intValue();
                    }
                }
            }

            return var2;
        }

        public ArrayList getBlocks() {
            ArrayList var1 = new ArrayList();
            Rs var2 = (Rs) this.findViewWithTag(Integer.valueOf(this.d.ha));
            if (var2 != null) {
                Iterator var3 = var2.getAllChildren().iterator();

                while (var3.hasNext()) {
                    var1.add(((Rs) var3.next()).getBean());
                }
            }

            return var1;
        }

        public Object[] getNearestTarget() {
            return this.f;
        }

        public Rs getRoot() {
            return this.d;
        }
    }

    private class Rs extends Ts {
        public String T;
        public String U;
        public ArrayList V;
        public int W = 30;
        public int aa = 50;
        public int ba = 90;
        public int ca = 90;
        public int da = 4;
        public boolean ea = false;
        public boolean fa = false;
        public boolean ga = false;
        public int ha = -1;
        public int ia = -1;
        public int ja = -1;
        public ArrayList ka = new ArrayList();
        public ArrayList la = new ArrayList();
        public TextView ma = null;
        public int na = 0;
        public int oa = 0;
        public BlockPane pa = null;
        public String qa;
        public String ra;

        public Rs(Context var1, int var2, String var3, String var4, String var5) {
            super(var1, var4, false);
            this.setTag(Integer.valueOf(var2));
            this.T = var3;
            this.U = var5;
            this.l();
        }

        public Rs(Context var1, int var2, String var3, String var4, String var5, String var6) {
            super(var1, var4, var5, false);
            this.setTag(Integer.valueOf(var2));
            this.T = var3;
            this.U = var6;
            this.l();
        }

        public final int a(TextView var1) {
            Rect var2 = new Rect();
            var1.getPaint().getTextBounds(var1.getText().toString(), 0, var1.getText().length(), var2);
            return var2.width();
        }

        public final TextView a(String var1) {
            TextView var2 = new TextView(super.a);
            if (this.U.equals("getVar") || this.U.equals("getArg")) {
                String var3 = super.c;
                if (var3 != null && var3.length() > 0) {
                    StringBuilder var5 = new StringBuilder();
                    var5.append(super.c);
                    var5.append(" : ");
                    var5.append(var1);
                    var1 = var5.toString();
                }
            }

            var2.setText(var1);
            var2.setTextSize(10.0F);
            var2.setPadding(0, 0, 0, 0);
            var2.setGravity(16);
            var2.setTextColor(-1);
            var2.setTypeface((Typeface) null, Typeface.BOLD);
            LayoutParams var4 = new LayoutParams(-2, super.G);
            var4.setMargins(0, 0, 0, 0);
            var2.setLayoutParams(var4);
            return var2;
        }

        public final void a(Rs var1) {
            if (this.b() && -1 == this.ia) {
                this.e(var1);
            } else {
                Rs var2 = this.h();
                var2.ha = ((Integer) var1.getTag()).intValue();
                var1.E = var2;
            }
        }

        public void a(Ts var1, Rs var2) {
            int var3 = this.ka.indexOf(var1);
            if (var3 >= 0) {
                boolean var4 = var1 instanceof Rs;
                if (var4) {
                    Rs var6 = (Rs) var1;
                    var2.qa = var6.qa;
                    var2.ra = var6.ra;
                } else if (var1 instanceof Ss) {
                    var2.qa = var1.b;
                    var2.ra = var1.c;
                }

                if (!var4) {
                    this.removeView(var1);
                }

                this.ka.set(var3, var2);
                var2.E = this;
                this.i();
                this.o();
                if (var1 != var2 && var4) {
                    var1.E = null;
                    var1.setX(10.0F + this.getX() + (float) this.getWidthSum());
                    var1.setY(5.0F + this.getY());
                    ((Rs) var1).k();
                }

            }
        }

        public final void a(String var1, int var2) {
            ArrayList var3 = FB.c(var1);
            this.ka = new ArrayList();
            this.la = new ArrayList();

            for (int var4 = 0; var4 < var3.size(); ++var4) {
                View var5 = this.b((String) var3.get(var4), var2);
                if (var5 instanceof Ts) {
                    ((Ts) var5).E = this;
                }

                this.ka.add(var5);
                String var7;
                if (var5 instanceof Ss) {
                    var7 = (String) var3.get(var4);
                } else {
                    var7 = "icon";
                }

                if (var5 instanceof TextView) {
                    var7 = "label";
                }

                this.la.add(var7);
            }

        }

        public final View b(String var1, int var2) {
            if (var1.length() >= 2 && var1.charAt(0) == 37) {
                char var3 = var1.charAt(1);
                String var4 = "";
                if (var3 == 98) {
                    return new Ss(super.a, "b", var4);
                }

                if (var3 == 100) {
                    return new Ss(super.a, "d", var4);
                }

                if (var3 == 109) {
                    return new Ss(super.a, "m", var1.substring(3));
                }

                if (var3 == 115) {
                    Context var5 = super.a;
                    if (var1.length() > 2) {
                        var4 = var1.substring(3);
                    }

                    return new Ss(var5, "s", var4);
                }
            }

            return this.a(FB.d(var1));
        }

        public void b(Rs var1) {
            View var2 = this.pa.findViewWithTag(Integer.valueOf(this.ha));
            if (var2 != null) {
                ((Rs) var2).E = null;
            }

            var1.E = this;
            this.ha = ((Integer) var1.getTag()).intValue();
            if (var2 != null) {
                var1.a((Rs) var2);
            }

        }

        public void c(Rs var1) {
            var1.setX(this.getX());
            var1.setY(this.getY() - (float) var1.getHeightSum() + (float) super.h);
            var1.h().b(this);
        }

        public void d(Rs var1) {
            var1.setX(this.getX() - (float) super.j);
            var1.setY(this.getY() - (float) this.f());
            super.E = var1;
            var1.ia = ((Integer) this.getTag()).intValue();
        }

        public void e(Rs var1) {
            View var2 = this.pa.findViewWithTag(Integer.valueOf(this.ia));
            if (var2 != null) {
                ((Rs) var2).E = null;
            }

            var1.E = this;
            this.ia = ((Integer) var1.getTag()).intValue();
            if (var2 != null) {
                var1.a((Rs) var2);
            }

        }

        public void f(Rs var1) {
            View var2 = this.pa.findViewWithTag(Integer.valueOf(this.ja));
            if (var2 != null) {
                ((Rs) var2).E = null;
            }

            var1.E = this;
            this.ja = ((Integer) var1.getTag()).intValue();
            if (var2 != null) {
                var1.a((Rs) var2);
            }

        }

        public void g(Rs var1) {
            if (this.ha == ((Integer) var1.getTag()).intValue()) {
                this.ha = -1;
            }

            if (this.ia == ((Integer) var1.getTag()).intValue()) {
                this.ia = -1;
            }

            if (this.ja == ((Integer) var1.getTag()).intValue()) {
                this.ja = -1;
            }

            if (var1.fa) {
                int var2 = this.ka.indexOf(var1);
                if (var2 < 0) {
                    return;
                }

                var1.qa = "";
                var1.ra = "";
                View var3 = this.b((String) this.la.get(var2), super.e);
                if (var3 instanceof Ts) {
                    ((Ts) var3).E = this;
                }

                this.ka.set(var2, var3);
                this.addView(var3);
                this.i();
                this.o();
            }

            this.p().k();
        }

        public ArrayList getAllChildren() {
            ArrayList var1 = new ArrayList();
            Rs var2 = this;

            while (true) {
                var1.add(var2);
                Iterator var4 = var2.ka.iterator();

                while (var4.hasNext()) {
                    View var10 = (View) var4.next();
                    if (var10 instanceof Rs) {
                        var1.addAll(((Rs) var10).getAllChildren());
                    }
                }

                if (var2.b()) {
                    int var8 = var2.ia;
                    if (var8 != -1) {
                        var1.addAll(((Rs) this.pa.findViewWithTag(Integer.valueOf(var8))).getAllChildren());
                    }
                }

                if (var2.c()) {
                    int var6 = var2.ja;
                    if (var6 != -1) {
                        var1.addAll(((Rs) this.pa.findViewWithTag(Integer.valueOf(var6))).getAllChildren());
                    }
                }

                int var5 = var2.ha;
                if (var5 == -1) {
                    return var1;
                }

                var2 = (Rs) this.pa.findViewWithTag(Integer.valueOf(var5));
            }
        }

        public BlockBean getBean() {
            BlockBean var1 = new BlockBean(this.getTag().toString(), this.T, super.b, super.c, this.U);
            var1.color = super.e;
            Iterator var2 = this.V.iterator();

            while (var2.hasNext()) {
                View var3 = (View) var2.next();
                if (var3 instanceof Ss) {
                    var1.parameters.add(((Ss) var3).getArgValue().toString());
                } else if (var3 instanceof Rs) {
                    ArrayList var4 = var1.parameters;
                    StringBuilder var5 = new StringBuilder();
                    var5.append("@");
                    var5.append(var3.getTag().toString());
                    var4.add(var5.toString());
                }
            }

            var1.subStack1 = this.ia;
            var1.subStack2 = this.ja;
            var1.nextBlock = this.ha;
            return var1;
        }

        public int getBlockType() {
            return this.oa;
        }

        public int getDepth() {
            int var1 = 0;
            Rs var2 = this;

            while (true) {
                var2 = var2.E;
                if (var2 == null) {
                    return var1;
                }

                ++var1;
            }
        }

        public int getHeightSum() {
            int var1 = 0;
            Rs var2 = this;

            while (true) {
                if (var1 > 0) {
                    var1 -= super.h;
                }

                var1 += var2.getTotalHeight();
                int var3 = var2.ha;
                if (var3 == -1) {
                    return var1;
                }

                var2 = (Rs) this.pa.findViewWithTag(Integer.valueOf(var3));
            }
        }

        public int getWidthSum() {
            int var1 = 0;
            Rs var2 = this;

            while (true) {
                var1 = Math.max(var1, var2.getW());
                if (var2.b()) {
                    int var5 = var2.ia;
                    if (var5 != -1) {
                        var1 = Math.max(var1, super.j + ((Rs) this.pa.findViewWithTag(Integer.valueOf(var5))).getWidthSum());
                    }
                }

                if (var2.c()) {
                    int var4 = var2.ja;
                    if (var4 != -1) {
                        var1 = Math.max(var1, super.j + ((Rs) this.pa.findViewWithTag(Integer.valueOf(var4))).getWidthSum());
                    }
                }

                int var3 = var2.ha;
                if (var3 == -1) {
                    return var1;
                }

                var2 = (Rs) this.pa.findViewWithTag(Integer.valueOf(var3));
            }
        }

        public Rs h() {
            Rs var1 = this;

            while (true) {
                int var2 = var1.ha;
                if (var2 == -1) {
                    return var1;
                }

                var1 = (Rs) this.pa.findViewWithTag(Integer.valueOf(var2));
            }
        }

        public final void i() {
            this.V = new ArrayList();

            for (int var1 = 0; var1 < this.ka.size(); ++var1) {
                View var2 = (View) this.ka.get(var1);
                if (var2 instanceof Rs || var2 instanceof Ss) {
                    this.V.add(var2);
                }
            }

        }

        public final void j() {
            TextView var1 = this.ma;
            if (var1 != null) {
                var1.bringToFront();
                this.ma.setX((float) super.w);
                this.ma.setY((float) (this.g() - super.n));
            }

        }

        public void k() {
            this.bringToFront();
            int var1 = super.w;

            for (int var2 = 0; var2 < this.ka.size(); ++var2) {
                View var12 = (View) this.ka.get(var2);
                var12.bringToFront();
                boolean var13 = var12 instanceof Rs;
                if (var13) {
                    var12.setX(this.getX() + (float) var1);
                } else {
                    var12.setX((float) var1);
                }

                int var14;
                if (((String) this.la.get(var2)).equals("label")) {
                    var14 = this.a((TextView) var12);
                } else {
                    var14 = 0;
                }

                if (var12 instanceof Ss) {
                    var14 = ((Ss) var12).getW();
                }

                if (var13) {
                    var14 = ((Rs) var12).getWidthSum();
                }

                var1 += var14 + this.da;
                if (var13) {
                    float var15 = this.getY() + (float) super.u;
                    int var16 = this.na;
                    Rs var17 = (Rs) var12;
                    var12.setY(var15 + (float) ((var16 - var17.na - 1) * super.y));
                    var17.k();
                } else {
                    var12.setY((float) (super.u + this.na * super.y));
                }
            }

            if (super.b.equals("b") || super.b.equals("d") || super.b.equals("s") || super.b.equals("a")) {
                var1 = Math.max(var1, this.W);
            }

            if (super.b.equals(" ") || super.b.equals("") || super.b.equals("f")) {
                var1 = Math.max(var1, this.aa);
            }

            if (super.b.equals("c") || super.b.equals("e")) {
                var1 = Math.max(var1, this.ca);
            }

            if (super.b.equals("h")) {
                var1 = Math.max(var1, this.ba);
            }

            this.a((float) (var1 + super.x), (float) (super.u + super.G + 2 * this.na * super.y + super.v), true);
            if (this.b()) {
                int var5 = super.i;
                int var6 = this.ia;
                if (var6 > -1) {
                    Rs var11 = (Rs) this.pa.findViewWithTag(Integer.valueOf(var6));
                    var11.setX(this.getX() + (float) super.j);
                    var11.setY(this.getY() + (float) this.f());
                    var11.bringToFront();
                    var11.k();
                    var5 = var11.getHeightSum();
                }

                this.setSubstack1Height(var5);
                int var7 = super.i;
                int var8 = this.ja;
                if (var8 > -1) {
                    Rs var9 = (Rs) this.pa.findViewWithTag(Integer.valueOf(var8));
                    var9.setX(this.getX() + (float) super.j);
                    var9.setY(this.getY() + (float) this.g());
                    var9.bringToFront();
                    var9.k();
                    int var10 = var9.getHeightSum();
                    if (var9.h().ga) {
                        var7 = var10 + super.h;
                    } else {
                        var7 = var10;
                    }
                }

                this.setSubstack2Height(var7);
                this.j();
            }

            int var3 = this.ha;
            if (var3 > -1) {
                Rs var4 = (Rs) this.pa.findViewWithTag(Integer.valueOf(var3));
                var4.setX(this.getX());
                var4.setY(this.getY() + (float) this.d());
                var4.bringToFront();
                var4.k();
            }

        }

        public void l() {
            byte var5;
            label84:
            {
                this.setDrawingCacheEnabled(false);
                float var1 = (float) this.W;
                float var2 = super.D;
                this.W = (int) (var1 * var2);
                this.aa = (int) (var2 * (float) this.aa);
                this.ba = (int) (var2 * (float) this.ba);
                this.ca = (int) (var2 * (float) this.ca);
                this.da = (int) (var2 * (float) this.da);
                String var3 = super.b;
                int var4 = var3.hashCode();
                if (var4 != 32) {
                    if (var4 != 104) {
                        if (var4 != 108) {
                            if (var4 != 112) {
                                if (var4 != 115) {
                                    if (var4 != 118) {
                                        switch (var4) {
                                            case 97:
                                                if (var3.equals("a")) {
                                                    var5 = 7;
                                                    break label84;
                                                }
                                                break;
                                            case 98:
                                                if (var3.equals("b")) {
                                                    var5 = 1;
                                                    break label84;
                                                }
                                                break;
                                            case 99:
                                                if (var3.equals("c")) {
                                                    var5 = 8;
                                                    break label84;
                                                }
                                                break;
                                            case 100:
                                                if (var3.equals("d")) {
                                                    var5 = 3;
                                                    break label84;
                                                }
                                                break;
                                            case 101:
                                                if (var3.equals("e")) {
                                                    var5 = 9;
                                                    break label84;
                                                }
                                                break;
                                            case 102:
                                                if (var3.equals("f")) {
                                                    var5 = 10;
                                                    break label84;
                                                }
                                        }
                                    } else if (var3.equals("v")) {
                                        var5 = 4;
                                        break label84;
                                    }
                                } else if (var3.equals("s")) {
                                    var5 = 2;
                                    break label84;
                                }
                            } else if (var3.equals("p")) {
                                var5 = 5;
                                break label84;
                            }
                        } else if (var3.equals("l")) {
                            var5 = 6;
                            break label84;
                        }
                    } else if (var3.equals("h")) {
                        var5 = 11;
                        break label84;
                    }
                } else if (var3.equals(" ")) {
                    var5 = 0;
                    break label84;
                }

                var5 = -1;
            }

            switch (var5) {
                case 0:
                case 8:
                case 9:
                default:
                    break;
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    this.fa = true;
                    break;
                case 10:
                    this.ga = true;
                    break;
                case 11:
                    this.ea = true;
            }

		        /*
         if(!this.ea && !this.U.equals("definedFunc") && !this.U.equals("getVar") && !this.U.equals("getArg")) {
         this.T = xB.b().a(this.getContext(), this.U);
         }
         */

		        /*if(this.T.equals("")) {
         this.T = MakeBlock.getSpecBlock(this.U);
         }*/

            this.setSpec(this.T);

            int colorc = kq.a(this.U, super.b);

            if (colorc != -12289797) {
                super.e = colorc;
            }

            //super.e = /* MakeBlock.getColorBlock(*/kq.a(this.U, super.b);//, this.U);
        }

        public void m() {
            Rs var1 = this;

            do {
                var1.n();
                var1 = var1.E;
            } while (var1 != null);

        }

        public void n() {
            int var1 = super.w;

            for (int var2 = 0; var2 < this.ka.size(); ++var2) {
                View var4 = (View) this.ka.get(var2);
                int var5;
                if (((String) this.la.get(var2)).equals("label")) {
                    var5 = this.a((TextView) var4);
                } else {
                    var5 = 0;
                }

                if (var4 instanceof Ss) {
                    var5 = ((Ss) var4).getW();
                }

                if (var4 instanceof Rs) {
                    var5 = ((Rs) var4).getWidthSum();
                }

                var1 += var5 + this.da;
            }

            if (super.b.equals("b") || super.b.equals("d") || super.b.equals("s") || super.b.equals("a")) {
                var1 = Math.max(var1, this.W);
            }

            if (super.b.equals(" ") || super.b.equals("") || super.b.equals("o")) {
                var1 = Math.max(var1, this.aa);
            }

            if (super.b.equals("c") || super.b.equals("e")) {
                var1 = Math.max(var1, this.ca);
            }

            if (super.b.equals("h")) {
                var1 = Math.max(var1, this.ba);
            }

            TextView var3 = this.ma;
            if (var3 != null) {
                var1 = Math.max(var1, 2 + super.w + var3.getWidth());
            }

            this.a((float) (var1 + super.x), (float) (super.u + super.G + 2 * this.na * super.y + super.v), false);
        }

        public void o() {
            for (Rs var1 = this; var1 != null; var1 = var1.E) {
                int var2 = 0;
                Iterator var3 = var1.V.iterator();

                while (var3.hasNext()) {
                    View var4 = (View) var3.next();
                    if (var4 instanceof Rs) {
                        var2 = Math.max(var2, 1 + ((Rs) var4).na);
                    }
                }

                var1.na = var2;
                var1.n();
                if (!var1.fa) {
                    return;
                }
            }

        }

        public Rs p() {
            Rs var1 = this;

            while (true) {
                Rs var2 = var1.E;
                if (var2 == null) {
                    return var1;
                }

                var1 = var2;
            }
        }

        public void setBlockType(int var1) {
            this.oa = var1;
        }

        public void setSpec(String var1) {
            this.T = var1;
            this.removeAllViews();
            this.a(this.T, super.e);
            Iterator var2 = this.ka.iterator();

            while (var2.hasNext()) {
                this.addView((View) var2.next());
            }

            this.i();
            if (super.b.equals("e") && this.U.equals("ifElse")) {
                this.ma = this.a("else");
                this.addView(this.ma);
            }

            if (super.b.equals("e") && this.U.equals("tryCatch")) {
                this.ma = this.a("Catch");
                this.addView(this.ma);
            }

            this.k();
        }
    }

    private class Ts extends RelativeLayout {
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
            this.N.setStyle(android.graphics.Paint.Style.STROKE);
            this.N.setStrokeWidth((float) this.P);
            this.O = new Paint();
            this.O.setColor(-1593835521);
            this.O.setStyle(android.graphics.Paint.Style.STROKE);
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

    private class Ss extends Ts {
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
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.G);
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
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.aa, this.G);
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

    private static class Gx {
        public String a;
        public String[] b;

        public Gx(String var1) {
            this.a = var1;
            this.b = null;
            this.e();
        }

        public String a() {
            return this.a;
        }

        public boolean a(Gx var1) {
            return this.a(var1.a);
        }

        public boolean a(String var1) {
            if (var1.equals(this.a)) {
                return true;
            } else {
                String[] var2 = this.b;
                int var3 = var2.length;

                for (int var4 = 0; var4 < var3; ++var4) {
                    if (var2[var4].equals(var1)) {
                        return true;
                    }
                }

                return false;
            }
        }

        public boolean b() {
            return this.a("List");
        }

        public boolean b(String var1) {
            return this.a.equals(var1);
        }

        public boolean c() {
            return this.a("Var");
        }

        public boolean d() {
            return this.a("View");
        }

        public final void e() {
            String var2;
            String var4;
            byte var5;
            label209:
            {
                String var1 = this.a;
                var2 = BV.a(var1);
                int var3 = var1.hashCode();
                var4 = "View";
                switch (var3) {
                    case -2099895620:
                        if (var1.equals("Intent")) {
                            var5 = 26;
                            break label209;
                        }
                        break;
                    case -1965257499:
                        if (var1.equals("Gyroscope")) {
                            var5 = 37;
                            break label209;
                        }
                        break;
                    case -1936496017:
                        if (var1.equals("ListString")) {
                            var5 = 5;
                            break label209;
                        }
                        break;
                    case -1908172204:
                        if (var1.equals("FirebaseStorage")) {
                            var5 = 38;
                            break label209;
                        }
                        break;
                    case -1884914774:
                        if (var1.equals("TextToSpeech")) {
                            var5 = 43;
                            break label209;
                        }
                        break;
                    case -1808118735:
                        if (var1.equals("String")) {
                            var5 = 2;
                            break label209;
                        }
                        break;
                    case -1805606060:
                        if (var1.equals("Switch")) {
                            var5 = 17;
                            break label209;
                        }
                        break;
                    case -1793532415:
                        if (var1.equals("MapView")) {
                            var5 = 21;
                            break label209;
                        }
                        break;
                    case -1495589242:
                        if (var1.equals("ProgressBar")) {
                            var5 = 42;
                            break label209;
                        }
                        break;
                    case -1406842887:
                        if (var1.equals("WebView")) {
                            var5 = 16;
                            break label209;
                        }
                        break;
                    case -1325958191:
                        if (var1.equals("double")) {
                            var5 = 1;
                            break label209;
                        }
                        break;
                    case -1125439882:
                        if (var1.equals("HorizontalScrollView")) {
                            var5 = 25;
                            break label209;
                        }
                        break;
                    case -1042830870:
                        if (var1.equals("SpeechToText")) {
                            var5 = 44;
                            break label209;
                        }
                        break;
                    case -1014653761:
                        if (var1.equals("RequestNetwork")) {
                            var5 = 41;
                            break label209;
                        }
                        break;
                    case -938935918:
                        if (var1.equals("TextView")) {
                            var5 = 9;
                            break label209;
                        }
                        break;
                    case -658531749:
                        if (var1.equals("SeekBar")) {
                            var5 = 18;
                            break label209;
                        }
                        break;
                    case -596330166:
                        if (var1.equals("FilePicker")) {
                            var5 = 40;
                            break label209;
                        }
                        break;
                    case -339785223:
                        if (var1.equals("Spinner")) {
                            var5 = 14;
                            break label209;
                        }
                        break;
                    case -294086120:
                        if (var1.equals("LocationManager")) {
                            var5 = 46;
                            break label209;
                        }
                        break;
                    case -188272861:
                        if (var1.equals("CalendarView")) {
                            var5 = 19;
                            break label209;
                        }
                        break;
                    case -113680546:
                        if (var1.equals("Calendar")) {
                            var5 = 28;
                            break label209;
                        }
                        break;
                    case 77116:
                        if (var1.equals("Map")) {
                            var5 = 3;
                            break label209;
                        }
                        break;
                    case 2368702:
                        if (var1.equals("List")) {
                            var5 = 7;
                            break label209;
                        }
                        break;
                    case 2666181:
                        if (var1.equals(var4)) {
                            var5 = 8;
                            break label209;
                        }
                        break;
                    case 64711720:
                        if (var1.equals("boolean")) {
                            var5 = 0;
                            break label209;
                        }
                        break;
                    case 80811813:
                        if (var1.equals("Timer")) {
                            var5 = 30;
                            break label209;
                        }
                        break;
                    case 191354283:
                        if (var1.equals("SoundPool")) {
                            var5 = 33;
                            break label209;
                        }
                        break;
                    case 225459311:
                        if (var1.equals("FirebaseAuth")) {
                            var5 = 36;
                            break label209;
                        }
                        break;
                    case 1100433486:
                        if (var1.equals("FloatingActionButton")) {
                            var5 = 22;
                            break label209;
                        }
                        break;
                    case 1125864064:
                        if (var1.equals("ImageView")) {
                            var5 = 12;
                            break label209;
                        }
                        break;
                    case 1127291599:
                        if (var1.equals("LinearLayout")) {
                            var5 = 23;
                            break label209;
                        }
                        break;
                    case 1170382393:
                        if (var1.equals("Vibrator")) {
                            var5 = 29;
                            break label209;
                        }
                        break;
                    case 1236935621:
                        if (var1.equals("MediaPlayer")) {
                            var5 = 32;
                            break label209;
                        }
                        break;
                    case 1410352259:
                        if (var1.equals("ListView")) {
                            var5 = 15;
                            break label209;
                        }
                        break;
                    case 1512362620:
                        if (var1.equals("BluetoothConnect")) {
                            var5 = 45;
                            break label209;
                        }
                        break;
                    case 1601505219:
                        if (var1.equals("CheckBox")) {
                            var5 = 13;
                            break label209;
                        }
                        break;
                    case 1616304435:
                        if (var1.equals("SharedPreferences")) {
                            var5 = 27;
                            break label209;
                        }
                        break;
                    case 1666676343:
                        if (var1.equals("EditText")) {
                            var5 = 11;
                            break label209;
                        }
                        break;
                    case 1779003621:
                        if (var1.equals("FirebaseDB")) {
                            var5 = 35;
                            break label209;
                        }
                        break;
                    case 1799376742:
                        if (var1.equals("ObjectAnimator")) {
                            var5 = 34;
                            break label209;
                        }
                        break;
                    case 1846598225:
                        if (var1.equals("ListInt")) {
                            var5 = 4;
                            break label209;
                        }
                        break;
                    case 1846601662:
                        if (var1.equals("ListMap")) {
                            var5 = 6;
                            break label209;
                        }
                        break;
                    case 1955913096:
                        if (var1.equals("AdView")) {
                            var5 = 20;
                            break label209;
                        }
                        break;
                    case 2001146706:
                        if (var1.equals("Button")) {
                            var5 = 10;
                            break label209;
                        }
                        break;
                    case 2011082565:
                        if (var1.equals("Camera")) {
                            var5 = 39;
                            break label209;
                        }
                        break;
                    case 2046749032:
                        if (var1.equals("Dialog")) {
                            var5 = 31;
                            break label209;
                        }
                        break;
                    case 2059813682:
                        if (var1.equals("ScrollView")) {
                            var5 = 24;
                            break label209;
                        }
                        break;
                    case 2059883587:
                        if (var1.equals("RadioButton")) {
                            var5 = 47;
                            break label209;
                        }
                }

                var5 = -1;
            }

            switch (var5) {
                case 0:
                    var4 = "Var.boolean";
                    break;
                case 1:
                    var4 = "Var.double";
                    break;
                case 2:
                    var4 = "Var.String";
                    break;
                case 3:
                    var4 = "Var.Map";
                    break;
                case 4:
                    var4 = "List.ListInt";
                    break;
                case 5:
                    var4 = "List.ListString";
                    break;
                case 6:
                    var4 = "List.ListMap";
                    break;
                case 7:
                    var4 = "List";
                case 8:
                    break;
                case 9:
                    var4 = "View.Clickable.TextView";
                    break;
                case 10:
                    var4 = "View.Clickable.TextView.Button";
                    break;
                case 11:
                    var4 = "View.Clickable.TextView.EditText";
                    break;
                case 12:
                    var4 = "View.Clickable.ImageView";
                    break;
                case 13:
                    var4 = "View.Clickable.TextView.Button.CompoundButton.CheckBox";
                    break;
                case 14:
                    var4 = "View.AdapterView.AbsSpinner.Spinner";
                    break;
                case 15:
                    var4 = "View.AdapterView.AbsListView.ListView";
                    break;
                case 16:
                    var4 = "View.AbsoluteLayout.WebView";
                    break;
                case 17:
                    var4 = "View.Clickable.TextView.Button.CompoundButton.Switch";
                    break;
                case 18:
                    var4 = "View.SeekBar";
                    break;
                case 19:
                    var4 = "View.FrameLayout.CalendarView";
                    break;
                case 20:
                    var4 = "View.AdView";
                    break;
                case 21:
                    var4 = "View.MapView";
                    break;
                case 22:
                    var4 = "View.Clickable.FloatingActionButton";
                    break;
                case 23:
                    var4 = "View.Clickable.ViewGroup.LinearLayout";
                    break;
                case 24:
                    var4 = "View.ViewGroup.FrameLayout.ScrollView";
                    break;
                case 25:
                    var4 = "View.ViewGroup.FrameLayout.HorizontalScrollView";
                    break;
                case 26:
                    var4 = "Component.Intent";
                    break;
                case 27:
                    var4 = "Component.SharedPreferences";
                    break;
                case 28:
                    var4 = "Component.Calendar";
                    break;
                case 29:
                    var4 = "Component.Vibrator";
                    break;
                case 30:
                    var4 = "Component.Timer";
                    break;
                case 31:
                    var4 = "Component.Dialog";
                    break;
                case 32:
                    var4 = "Component.MediaPlayer";
                    break;
                case 33:
                    var4 = "Component.SoundPool";
                    break;
                case 34:
                    var4 = "Component.ObjectAnimator";
                    break;
                case 35:
                    var4 = "Component.FirebaseDB";
                    break;
                case 36:
                    var4 = "Component.FirebaseAuth";
                    break;
                case 37:
                    var4 = "Component.Gyroscope";
                    break;
                case 38:
                    var4 = "Component.FirebaseStorage";
                    break;
                case 39:
                    var4 = "Component.Camera";
                    break;
                case 40:
                    var4 = "Component.FilePicker";
                    break;
                case 41:
                    var4 = "Component.RequestNetwork";
                    break;
                case 42:
                    var4 = "View.SeekBar.ProgressBar";
                    break;
                case 43:
                    var4 = "Component.TextToSpeech";
                    break;
                case 44:
                    var4 = "Component.SpeechToText";
                    break;
                case 45:
                    var4 = "Component.BluetoothConnect";
                    break;
                case 46:
                    var4 = "Component.LocationManager";
                    break;
                case 47:
                    var4 = "View.Clickable.TextView.Button.CompoundButton.RadioButton";
                    break;
                default:
                    var4 = var2;
            }

            this.b = var4.split("\\.");
        }
    }

    private static class kq {
        public static int a(String var0, String var1) {
            if (var1.equals("h")) {
                return -3636432;
            } else {
                short var2 = -1;
                switch (var0.hashCode()) {
                    case -2135695280:
                        if (var0.equals("webViewLoadUrl")) {
                            var2 = 153;
                        }
                        break;
                    case -2120571577:
                        if (var0.equals("mapIsEmpty")) {
                            var2 = 13;
                        }
                        break;
                    case -2114384168:
                        if (var0.equals("firebasestorageDownloadFile")) {
                            var2 = 265;
                        }
                        break;
                    case -2055793167:
                        if (var0.equals("fileutillistdir")) {
                            var2 = 301;
                        }
                        break;
                    case -2037144358:
                        if (var0.equals("bluetoothConnectStartConnectionToUuid")) {
                            var2 = 284;
                        }
                        break;
                    case -2027093331:
                        if (var0.equals("calendarViewSetDate")) {
                            var2 = 166;
                        }
                        break;
                    case -2020761366:
                        if (var0.equals("fileRemoveData")) {
                            var2 = 199;
                        }
                        break;
                    case -1998407506:
                        if (var0.equals("listSetData")) {
                            var2 = 141;
                        }
                        break;
                    case -1989678633:
                        if (var0.equals("mapViewSetMarkerVisible")) {
                            var2 = 185;
                        }
                        break;
                    case -1979147952:
                        if (var0.equals("stringContains")) {
                            var2 = 62;
                        }
                        break;
                    case -1975568730:
                        if (var0.equals("copyToClipboard")) {
                            var2 = 187;
                        }
                        break;
                    case -1966668787:
                        if (var0.equals("firebaseauthSignOutUser")) {
                            var2 = 256;
                        }
                        break;
                    case -1937348542:
                        if (var0.equals("firebaseStartListen")) {
                            var2 = 257;
                        }
                        break;
                    case -1922362317:
                        if (var0.equals("getExternalStorageDir")) {
                            var2 = 308;
                        }
                        break;
                    case -1920517885:
                        if (var0.equals("setVarBoolean")) {
                            var2 = 2;
                        }
                        break;
                    case -1919300188:
                        if (var0.equals("toNumber")) {
                            var2 = 66;
                        }
                        break;
                    case -1910071024:
                        if (var0.equals("objectanimatorSetDuration")) {
                            var2 = 237;
                        }
                        break;
                    case -1886802639:
                        if (var0.equals("soundpoolLoad")) {
                            var2 = 230;
                        }
                        break;
                    case -1834369666:
                        if (var0.equals("setBitmapFileBrightness")) {
                            var2 = 320;
                        }
                        break;
                    case -1812313351:
                        if (var0.equals("setColorFilter")) {
                            var2 = 117;
                        }
                        break;
                    case -1778201036:
                        if (var0.equals("listSmoothScrollTo")) {
                            var2 = 148;
                        }
                        break;
                    case -1776922004:
                        if (var0.equals("toString")) {
                            var2 = 70;
                        }
                        break;
                    case -1749698255:
                        if (var0.equals("mediaplayerPause")) {
                            var2 = 220;
                        }
                        break;
                    case -1747734390:
                        if (var0.equals("mediaplayerReset")) {
                            var2 = 227;
                        }
                        break;
                    case -1746380899:
                        if (var0.equals("mediaplayerStart")) {
                            var2 = 219;
                        }
                        break;
                    case -1718917155:
                        if (var0.equals("mediaplayerSeek")) {
                            var2 = 221;
                        }
                        break;
                    case -1699631195:
                        if (var0.equals("isDrawerOpen")) {
                            var2 = 103;
                        }
                        break;
                    case -1699349926:
                        if (var0.equals("objectanimatorSetRepeatMode")) {
                            var2 = 238;
                        }
                        break;
                    case -1684072208:
                        if (var0.equals("intentSetData")) {
                            var2 = 190;
                        }
                        break;
                    case -1679834825:
                        if (var0.equals("setTrackResource")) {
                            var2 = 140;
                        }
                        break;
                    case -1666623936:
                        if (var0.equals("speechToTextShutdown")) {
                            var2 = 280;
                        }
                        break;
                    case -1573371685:
                        if (var0.equals("stringJoin")) {
                            var2 = 57;
                        }
                        break;
                    case -1541653284:
                        if (var0.equals("objectanimatorStart")) {
                            var2 = 241;
                        }
                        break;
                    case -1530840255:
                        if (var0.equals("stringIndex")) {
                            var2 = 58;
                        }
                        break;
                    case -1528850031:
                        if (var0.equals("startActivity")) {
                            var2 = 194;
                        }
                        break;
                    case -1526161572:
                        if (var0.equals("setBgColor")) {
                            var2 = 113;
                        }
                        break;
                    case -1513446476:
                        if (var0.equals("dialogCancelButton")) {
                            var2 = 214;
                        }
                        break;
                    case -1512519571:
                        if (var0.equals("definedFunc")) {
                            var2 = 323;
                        }
                        break;
                    case -1483954587:
                        if (var0.equals("fileutilisdir")) {
                            var2 = 302;
                        }
                        break;
                    case -1477942289:
                        if (var0.equals("mediaplayerIsLooping")) {
                            var2 = 226;
                        }
                        break;
                    case -1471049951:
                        if (var0.equals("fileutilwrite")) {
                            var2 = 296;
                        }
                        break;
                    case -1462744030:
                        if (var0.equals("dialogDismiss")) {
                            var2 = 217;
                        }
                        break;
                    case -1440042085:
                        if (var0.equals("spnSetSelection")) {
                            var2 = 151;
                        }
                        break;
                    case -1438040951:
                        if (var0.equals("seekBarGetMax")) {
                            var2 = 135;
                        }
                        break;
                    case -1422112391:
                        if (var0.equals("bluetoothConnectIsBluetoothEnabled")) {
                            var2 = 287;
                        }
                        break;
                    case -1405157727:
                        if (var0.equals("fileutilmakedir")) {
                            var2 = 300;
                        }
                        break;
                    case -1385076635:
                        if (var0.equals("dialogShow")) {
                            var2 = 216;
                        }
                        break;
                    case -1384861688:
                        if (var0.equals("getAtListInt")) {
                            var2 = 19;
                        }
                        break;
                    case -1384858251:
                        if (var0.equals("getAtListMap")) {
                            var2 = 31;
                        }
                        break;
                    case -1384851894:
                        if (var0.equals("getAtListStr")) {
                            var2 = 26;
                        }
                        break;
                    case -1377080719:
                        if (var0.equals("decreaseInt")) {
                            var2 = 5;
                        }
                        break;
                    case -1376608975:
                        if (var0.equals("calendarSetTime")) {
                            var2 = 206;
                        }
                        break;
                    case -1361468284:
                        if (var0.equals("viewOnClick")) {
                            var2 = 102;
                        }
                        break;
                    case -1348085287:
                        if (var0.equals("mapViewZoomIn")) {
                            var2 = 178;
                        }
                        break;
                    case -1348084945:
                        if (var0.equals("mapViewZoomTo")) {
                            var2 = 177;
                        }
                        break;
                    case -1304067438:
                        if (var0.equals("firebaseDelete")) {
                            var2 = 245;
                        }
                        break;
                    case -1272546178:
                        if (var0.equals("dialogSetTitle")) {
                            var2 = 211;
                        }
                        break;
                    case -1271141237:
                        if (var0.equals("clearList")) {
                            var2 = 23;
                        }
                        break;
                    case -1249367264:
                        if (var0.equals("getArg")) {
                            var2 = 0;
                        }
                        break;
                    case -1249347599:
                        if (var0.equals("getVar")) {
                            var2 = 1;
                        }
                        break;
                    case -1217704075:
                        if (var0.equals("objectanimatorSetValue")) {
                            var2 = 235;
                        }
                        break;
                    case -1206794099:
                        if (var0.equals("getLocationX")) {
                            var2 = 131;
                        }
                        break;
                    case -1206794098:
                        if (var0.equals("getLocationY")) {
                            var2 = 132;
                        }
                        break;
                    case -1195899442:
                        if (var0.equals("bluetoothConnectSendData")) {
                            var2 = 286;
                        }
                        break;
                    case -1192544266:
                        if (var0.equals("ifElse")) {
                            var2 = 41;
                        }
                        break;
                    case -1185284274:
                        if (var0.equals("gyroscopeStopListen")) {
                            var2 = 260;
                        }
                        break;
                    case -1182878167:
                        if (var0.equals("firebaseauthGetUid")) {
                            var2 = 254;
                        }
                        break;
                    case -1160374245:
                        if (var0.equals("bluetoothConnectReadyConnectionToUuid")) {
                            var2 = 282;
                        }
                        break;
                    case -1149848189:
                        if (var0.equals("toStringFormat")) {
                            var2 = 72;
                        }
                        break;
                    case -1149458632:
                        if (var0.equals("objectanimatorSetRepeatCount")) {
                            var2 = 239;
                        }
                        break;
                    case -1143684675:
                        if (var0.equals("firebaseauthGetCurrentUser")) {
                            var2 = 253;
                        }
                        break;
                    case -1139353316:
                        if (var0.equals("setListMap")) {
                            var2 = 32;
                        }
                        break;
                    case -1137582698:
                        if (var0.equals("toLowerCase")) {
                            var2 = 69;
                        }
                        break;
                    case -1123431291:
                        if (var0.equals("calnedarViewSetMaxDate")) {
                            var2 = 168;
                        }
                        break;
                    case -1107376988:
                        if (var0.equals("webViewGoForward")) {
                            var2 = 159;
                        }
                        break;
                    case -1106141754:
                        if (var0.equals("webViewCanGoBack")) {
                            var2 = 156;
                        }
                        break;
                    case -1094491139:
                        if (var0.equals("seekBarSetMax")) {
                            var2 = 137;
                        }
                        break;
                    case -1081400230:
                        if (var0.equals("mapGet")) {
                            var2 = 9;
                        }
                        break;
                    case -1081391085:
                        if (var0.equals("mapPut")) {
                            var2 = 8;
                        }
                        break;
                    case -1081250015:
                        if (var0.equals("mathPi")) {
                            var2 = 81;
                        }
                        break;
                    case -1063598745:
                        if (var0.equals("resizeBitmapFileRetainRatio")) {
                            var2 = 311;
                        }
                        break;
                    case -1043233275:
                        if (var0.equals("mediaplayerGetDuration")) {
                            var2 = 223;
                        }
                        break;
                    case -1033658254:
                        if (var0.equals("mathGetDisplayWidth")) {
                            var2 = 79;
                        }
                        break;
                    case -1021852352:
                        if (var0.equals("objectanimatorCancel")) {
                            var2 = 242;
                        }
                        break;
                    case -1007787615:
                        if (var0.equals("mediaplayerSetLooping")) {
                            var2 = 225;
                        }
                        break;
                    case -996870276:
                        if (var0.equals("insertMapToList")) {
                            var2 = 35;
                        }
                        break;
                    case -995908985:
                        if (var0.equals("soundpoolCreate")) {
                            var2 = 229;
                        }
                        break;
                    case -938285885:
                        if (var0.equals("random")) {
                            var2 = 55;
                        }
                        break;
                    case -934531685:
                        if (var0.equals("repeat")) {
                            var2 = 37;
                        }
                        break;
                    case -918173448:
                        if (var0.equals("listGetCheckedPosition")) {
                            var2 = 145;
                        }
                        break;
                    case -917343271:
                        if (var0.equals("getJpegRotate")) {
                            var2 = 322;
                        }
                        break;
                    case -911199919:
                        if (var0.equals("objectanimatorSetProperty")) {
                            var2 = 234;
                        }
                        break;
                    case -903177036:
                        if (var0.equals("resizeBitmapFileWithRoundedBorder")) {
                            var2 = 314;
                        }
                        break;
                    case -883988307:
                        if (var0.equals("dialogSetMessage")) {
                            var2 = 212;
                        }
                        break;
                    case -869293886:
                        if (var0.equals("finishActivity")) {
                            var2 = 196;
                        }
                        break;
                    case -854558288:
                        if (var0.equals("setVisible")) {
                            var2 = 108;
                        }
                        break;
                    case -853550561:
                        if (var0.equals("timerCancel")) {
                            var2 = 210;
                        }
                        break;
                    case -831887360:
                        if (var0.equals("textToSpeechShutdown")) {
                            var2 = 277;
                        }
                        break;
                    case -733318734:
                        if (var0.equals("strToListMap")) {
                            var2 = 76;
                        }
                        break;
                    case -697616870:
                        if (var0.equals("camerastarttakepicture")) {
                            var2 = 267;
                        }
                        break;
                    case -677662361:
                        if (var0.equals("forever")) {
                            var2 = 38;
                        }
                        break;
                    case -668992194:
                        if (var0.equals("stringReplaceAll")) {
                            var2 = 65;
                        }
                        break;
                    case -664474111:
                        if (var0.equals("intentSetFlags")) {
                            var2 = 193;
                        }
                        break;
                    case -649691581:
                        if (var0.equals("objectanimatorSetInterpolator")) {
                            var2 = 240;
                        }
                        break;
                    case -636363854:
                        if (var0.equals("webViewGetUrl")) {
                            var2 = 154;
                        }
                        break;
                    case -628607128:
                        if (var0.equals("webViewGoBack")) {
                            var2 = 158;
                        }
                        break;
                    case -621198621:
                        if (var0.equals("speechToTextStartListening")) {
                            var2 = 278;
                        }
                        break;
                    case -602241037:
                        if (var0.equals("fileutilcopy")) {
                            var2 = 295;
                        }
                        break;
                    case -601942961:
                        if (var0.equals("fileutilmove")) {
                            var2 = 298;
                        }
                        break;
                    case -601804268:
                        if (var0.equals("fileutilread")) {
                            var2 = 297;
                        }
                        break;
                    case -578987803:
                        if (var0.equals("setChecked")) {
                            var2 = 133;
                        }
                        break;
                    case -509946902:
                        if (var0.equals("spnRefresh")) {
                            var2 = 150;
                        }
                        break;
                    case -439342016:
                        if (var0.equals("webViewClearHistory")) {
                            var2 = 161;
                        }
                        break;
                    case -437272040:
                        if (var0.equals("bluetoothConnectGetRandomUuid")) {
                            var2 = 291;
                        }
                        break;
                    case -425293664:
                        if (var0.equals("setClickable")) {
                            var2 = 109;
                        }
                        break;
                    case -418212114:
                        if (var0.equals("firebaseGetChildren")) {
                            var2 = 248;
                        }
                        break;
                    case -411705840:
                        if (var0.equals("fileSetData")) {
                            var2 = 198;
                        }
                        break;
                    case -399551817:
                        if (var0.equals("toUpperCase")) {
                            var2 = 68;
                        }
                        break;
                    case -390304998:
                        if (var0.equals("mapViewAddMarker")) {
                            var2 = 180;
                        }
                        break;
                    case -356866884:
                        if (var0.equals("webViewSetCacheMode")) {
                            var2 = 155;
                        }
                        break;
                    case -353129373:
                        if (var0.equals("calendarDiff")) {
                            var2 = 204;
                        }
                        break;
                    case -329562760:
                        if (var0.equals("insertListInt")) {
                            var2 = 17;
                        }
                        break;
                    case -329559323:
                        if (var0.equals("insertListMap")) {
                            var2 = 30;
                        }
                        break;
                    case -329552966:
                        if (var0.equals("insertListStr")) {
                            var2 = 25;
                        }
                        break;
                    case -322651344:
                        if (var0.equals("stringEquals")) {
                            var2 = 61;
                        }
                        break;
                    case -283328259:
                        if (var0.equals("intentPutExtra")) {
                            var2 = 192;
                        }
                        break;
                    case -258774775:
                        if (var0.equals("closeDrawer")) {
                            var2 = 105;
                        }
                        break;
                    case -247015294:
                        if (var0.equals("mediaplayerRelease")) {
                            var2 = 228;
                        }
                        break;
                    case -208762465:
                        if (var0.equals("toStringWithDecimal")) {
                            var2 = 71;
                        }
                        break;
                    case -189292433:
                        if (var0.equals("stringSub")) {
                            var2 = 60;
                        }
                        break;
                    case -152473824:
                        if (var0.equals("firebaseauthIsLoggedIn")) {
                            var2 = 252;
                        }
                        break;
                    case -149850417:
                        if (var0.equals("fileutilisexist")) {
                            var2 = 299;
                        }
                        break;
                    case -133532073:
                        if (var0.equals("stringLength")) {
                            var2 = 56;
                        }
                        break;
                    case -96313603:
                        if (var0.equals("containListInt")) {
                            var2 = 22;
                        }
                        break;
                    case -96310166:
                        if (var0.equals("containListMap")) {
                            var2 = 33;
                        }
                        break;
                    case -96303809:
                        if (var0.equals("containListStr")) {
                            var2 = 28;
                        }
                        break;
                    case -83301935:
                        if (var0.equals("webViewZoomIn")) {
                            var2 = 163;
                        }
                        break;
                    case -83186725:
                        if (var0.equals("openDrawer")) {
                            var2 = 104;
                        }
                        break;
                    case -75125341:
                        if (var0.equals("getText")) {
                            var2 = 112;
                        }
                        break;
                    case -60494417:
                        if (var0.equals("vibratorAction")) {
                            var2 = 207;
                        }
                        break;
                    case -60048101:
                        if (var0.equals("firebaseauthResetPassword")) {
                            var2 = 255;
                        }
                        break;
                    case -24451690:
                        if (var0.equals("dialogOkButton")) {
                            var2 = 213;
                        }
                        break;
                    case -14362103:
                        if (var0.equals("bluetoothConnectIsBluetoothActivated")) {
                            var2 = 288;
                        }
                        break;
                    case -10599306:
                        if (var0.equals("firebaseauthCreateUser")) {
                            var2 = 249;
                        }
                        break;
                    case -9742826:
                        if (var0.equals("firebaseGetPushKey")) {
                            var2 = 247;
                        }
                        break;
                    case 37:
                        if (var0.equals("%")) {
                            var2 = 54;
                        }
                        break;
                    case 42:
                        if (var0.equals("*")) {
                            var2 = 52;
                        }
                        break;
                    case 43:
                        if (var0.equals("+")) {
                            var2 = 50;
                        }
                        break;
                    case 45:
                        if (var0.equals("-")) {
                            var2 = 51;
                        }
                        break;
                    case 47:
                        if (var0.equals("/")) {
                            var2 = 53;
                        }
                        break;
                    case 60:
                        if (var0.equals("<")) {
                            var2 = 44;
                        }
                        break;
                    case 61:
                        if (var0.equals("=")) {
                            var2 = 45;
                        }
                        break;
                    case 62:
                        if (var0.equals(">")) {
                            var2 = 46;
                        }
                        break;
                    case 1216:
                        if (var0.equals("&&")) {
                            var2 = 47;
                        }
                        break;
                    case 3357:
                        if (var0.equals("if")) {
                            var2 = 40;
                        }
                        break;
                    case 3968:
                        if (var0.equals("||")) {
                            var2 = 48;
                        }
                        break;
                    case 109267:
                        if (var0.equals("not")) {
                            var2 = 49;
                        }
                        break;
                    case 3568674:
                        if (var0.equals("trim")) {
                            var2 = 67;
                        }
                        break;
                    case 3569038:
                        if (var0.equals("true")) {
                            var2 = 42;
                        }
                        break;
                    case 8255701:
                        if (var0.equals("calendarFormat")) {
                            var2 = 203;
                        }
                        break;
                    case 16308074:
                        if (var0.equals("resizeBitmapFileToCircle")) {
                            var2 = 313;
                        }
                        break;
                    case 25469951:
                        if (var0.equals("bluetoothConnectActivateBluetooth")) {
                            var2 = 289;
                        }
                        break;
                    case 27679870:
                        if (var0.equals("calendarGetNow")) {
                            var2 = 200;
                        }
                        break;
                    case 56167279:
                        if (var0.equals("setBitmapFileContrast")) {
                            var2 = 321;
                        }
                        break;
                    case 61585857:
                        if (var0.equals("firebasePush")) {
                            var2 = 246;
                        }
                        break;
                    case 94001407:
                        if (var0.equals("break")) {
                            var2 = 39;
                        }
                        break;
                    case 97196323:
                        if (var0.equals("false")) {
                            var2 = 43;
                        }
                        break;
                    case 103668285:
                        if (var0.equals("mathE")) {
                            var2 = 82;
                        }
                        break;
                    case 125431087:
                        if (var0.equals("speechToTextStopListening")) {
                            var2 = 279;
                        }
                        break;
                    case 134874756:
                        if (var0.equals("listSetCustomViewData")) {
                            var2 = 142;
                        }
                        break;
                    case 152967761:
                        if (var0.equals("mapClear")) {
                            var2 = 14;
                        }
                        break;
                    case 163812602:
                        if (var0.equals("cropBitmapFileFromCenter")) {
                            var2 = 315;
                        }
                        break;
                    case 168740282:
                        if (var0.equals("mapToStr")) {
                            var2 = 75;
                        }
                        break;
                    case 182549637:
                        if (var0.equals("setEnable")) {
                            var2 = 106;
                        }
                        break;
                    case 207764385:
                        if (var0.equals("calendarViewGetDate")) {
                            var2 = 165;
                        }
                        break;
                    case 255417137:
                        if (var0.equals("adViewLoadAd")) {
                            var2 = 169;
                        }
                        break;
                    case 262073061:
                        if (var0.equals("bluetoothConnectReadyConnection")) {
                            var2 = 281;
                        }
                        break;
                    case 276674391:
                        if (var0.equals("mapViewMoveCamera")) {
                            var2 = 176;
                        }
                        break;
                    case 297379706:
                        if (var0.equals("textToSpeechSetSpeechRate")) {
                            var2 = 273;
                        }
                        break;
                    case 300372142:
                        if (var0.equals("mathAcos")) {
                            var2 = 95;
                        }
                        break;
                    case 300387327:
                        if (var0.equals("mathAsin")) {
                            var2 = 94;
                        }
                        break;
                    case 300388040:
                        if (var0.equals("mathAtan")) {
                            var2 = 96;
                        }
                        break;
                    case 300433453:
                        if (var0.equals("mathCeil")) {
                            var2 = 89;
                        }
                        break;
                    case 300921928:
                        if (var0.equals("mathSqrt")) {
                            var2 = 86;
                        }
                        break;
                    case 317453636:
                        if (var0.equals("textToSpeechIsSpeaking")) {
                            var2 = 275;
                        }
                        break;
                    case 342026220:
                        if (var0.equals("interstitialadShow")) {
                            var2 = 263;
                        }
                        break;
                    case 348377823:
                        if (var0.equals("soundpoolStreamPlay")) {
                            var2 = 231;
                        }
                        break;
                    case 348475309:
                        if (var0.equals("soundpoolStreamStop")) {
                            var2 = 232;
                        }
                        break;
                    case 389111867:
                        if (var0.equals("spnSetData")) {
                            var2 = 149;
                        }
                        break;
                    case 397166713:
                        if (var0.equals("getEnable")) {
                            var2 = 107;
                        }
                        break;
                    case 401012285:
                        if (var0.equals("getTranslationX")) {
                            var2 = 124;
                        }
                        break;
                    case 401012286:
                        if (var0.equals("getTranslationY")) {
                            var2 = 126;
                        }
                        break;
                    case 404247683:
                        if (var0.equals("calendarAdd")) {
                            var2 = 201;
                        }
                        break;
                    case 404265028:
                        if (var0.equals("calendarSet")) {
                            var2 = 202;
                        }
                        break;
                    case 442768763:
                        if (var0.equals("mapGetAllKeys")) {
                            var2 = 15;
                        }
                        break;
                    case 463560551:
                        if (var0.equals("mapContainKey")) {
                            var2 = 10;
                        }
                        break;
                    case 463594049:
                        if (var0.equals("objectanimatorSetFromTo")) {
                            var2 = 236;
                        }
                        break;
                    case 470160234:
                        if (var0.equals("fileutilGetLastSegmentPath")) {
                            var2 = 307;
                        }
                        break;
                    case 475815924:
                        if (var0.equals("setTextColor")) {
                            var2 = 115;
                        }
                        break;
                    case 481850295:
                        if (var0.equals("resizeBitmapFileToSquare")) {
                            var2 = 312;
                        }
                        break;
                    case 490702942:
                        if (var0.equals("filepickerstartpickfiles")) {
                            var2 = 268;
                        }
                        break;
                    case 501171279:
                        if (var0.equals("mathToDegree")) {
                            var2 = 101;
                        }
                        break;
                    case 530759231:
                        if (var0.equals("progressBarSetIndeterminate")) {
                            var2 = 174;
                        }
                        break;
                    case 548860462:
                        if (var0.equals("webViewClearCache")) {
                            var2 = 160;
                        }
                        break;
                    case 556217437:
                        if (var0.equals("setRotate")) {
                            var2 = 119;
                        }
                        break;
                    case 571046965:
                        if (var0.equals("scaleBitmapFile")) {
                            var2 = 317;
                        }
                        break;
                    case 573208400:
                        if (var0.equals("setScaleX")) {
                            var2 = 127;
                        }
                        break;
                    case 573208401:
                        if (var0.equals("setScaleY")) {
                            var2 = 129;
                        }
                        break;
                    case 573295520:
                        if (var0.equals("listGetCheckedCount")) {
                            var2 = 147;
                        }
                        break;
                    case 610313513:
                        if (var0.equals("getMapInList")) {
                            var2 = 36;
                        }
                        break;
                    case 615286641:
                        if (var0.equals("dialogNeutralButton")) {
                            var2 = 215;
                        }
                        break;
                    case 657721930:
                        if (var0.equals("setVarInt")) {
                            var2 = 3;
                        }
                        break;
                    case 683193060:
                        if (var0.equals("bluetoothConnectStartConnection")) {
                            var2 = 283;
                        }
                        break;
                    case 725249532:
                        if (var0.equals("intentSetAction")) {
                            var2 = 189;
                        }
                        break;
                    case 726487524:
                        if (var0.equals("mathFloor")) {
                            var2 = 90;
                        }
                        break;
                    case 726877492:
                        if (var0.equals("mapViewSetMarkerIcon")) {
                            var2 = 184;
                        }
                        break;
                    case 726887785:
                        if (var0.equals("mapViewSetMarkerInfo")) {
                            var2 = 181;
                        }
                        break;
                    case 732108347:
                        if (var0.equals("mathLog10")) {
                            var2 = 99;
                        }
                        break;
                    case 737664870:
                        if (var0.equals("mathRound")) {
                            var2 = 88;
                        }
                        break;
                    case 738846120:
                        if (var0.equals("textToSpeechSetPitch")) {
                            var2 = 272;
                        }
                        break;
                    case 747168008:
                        if (var0.equals("mapCreateNew")) {
                            var2 = 7;
                        }
                        break;
                    case 754442829:
                        if (var0.equals("increaseInt")) {
                            var2 = 4;
                        }
                        break;
                    case 762282303:
                        if (var0.equals("indexListInt")) {
                            var2 = 20;
                        }
                        break;
                    case 762292097:
                        if (var0.equals("indexListStr")) {
                            var2 = 27;
                        }
                        break;
                    case 770834513:
                        if (var0.equals("getRotate")) {
                            var2 = 120;
                        }
                        break;
                    case 787825476:
                        if (var0.equals("getScaleX")) {
                            var2 = 128;
                        }
                        break;
                    case 787825477:
                        if (var0.equals("getScaleY")) {
                            var2 = 130;
                        }
                        break;
                    case 797861524:
                        if (var0.equals("addMapToList")) {
                            var2 = 34;
                        }
                        break;
                    case 836692861:
                        if (var0.equals("mapSize")) {
                            var2 = 12;
                        }
                        break;
                    case 840973386:
                        if (var0.equals("mathAbs")) {
                            var2 = 87;
                        }
                        break;
                    case 840975711:
                        if (var0.equals("mathCos")) {
                            var2 = 92;
                        }
                        break;
                    case 840977909:
                        if (var0.equals("mathExp")) {
                            var2 = 97;
                        }
                        break;
                    case 840984348:
                        if (var0.equals("mathLog")) {
                            var2 = 98;
                        }
                        break;
                    case 840984892:
                        if (var0.equals("mathMax")) {
                            var2 = 85;
                        }
                        break;
                    case 840985130:
                        if (var0.equals("mathMin")) {
                            var2 = 84;
                        }
                        break;
                    case 840988208:
                        if (var0.equals("mathPow")) {
                            var2 = 83;
                        }
                        break;
                    case 840990896:
                        if (var0.equals("mathSin")) {
                            var2 = 91;
                        }
                        break;
                    case 840991609:
                        if (var0.equals("mathTan")) {
                            var2 = 93;
                        }
                        break;
                    case 845089750:
                        if (var0.equals("setVarString")) {
                            var2 = 6;
                        }
                        break;
                    case 848786445:
                        if (var0.equals("objectanimatorSetTarget")) {
                            var2 = 233;
                        }
                        break;
                    case 858248741:
                        if (var0.equals("calendarGetTime")) {
                            var2 = 205;
                        }
                        break;
                    case 898187172:
                        if (var0.equals("mathToRadian")) {
                            var2 = 100;
                        }
                        break;
                    case 932259189:
                        if (var0.equals("setBgResource")) {
                            var2 = 114;
                        }
                        break;
                    case 937017988:
                        if (var0.equals("gyroscopeStartListen")) {
                            var2 = 259;
                        }
                        break;
                    case 948234497:
                        if (var0.equals("webViewStopLoading")) {
                            var2 = 162;
                        }
                        break;
                    case 950609198:
                        if (var0.equals("setBitmapFileColorFilter")) {
                            var2 = 319;
                        }
                        break;
                    case 1053179400:
                        if (var0.equals("mapViewSetMarkerColor")) {
                            var2 = 183;
                        }
                        break;
                    case 1068548733:
                        if (var0.equals("mathGetDip")) {
                            var2 = 78;
                        }
                        break;
                    case 1086207657:
                        if (var0.equals("fileutildelete")) {
                            var2 = 294;
                        }
                        break;
                    case 1088879149:
                        if (var0.equals("setHintTextColor")) {
                            var2 = 173;
                        }
                        break;
                    case 1090517587:
                        if (var0.equals("getPackageDataDir")) {
                            var2 = 309;
                        }
                        break;
                    case 1102670563:
                        if (var0.equals("requestnetworkSetHeaders")) {
                            var2 = 270;
                        }
                        break;
                    case 1129709718:
                        if (var0.equals("setImageUrl")) {
                            var2 = 171;
                        }
                        break;
                    case 1142897724:
                        if (var0.equals("firebaseauthSignInUser")) {
                            var2 = 250;
                        }
                        break;
                    case 1156598140:
                        if (var0.equals("fileutilEndsWith")) {
                            var2 = 306;
                        }
                        break;
                    case 1159035162:
                        if (var0.equals("mapViewZoomOut")) {
                            var2 = 179;
                        }
                        break;
                    case 1160674468:
                        if (var0.equals("lengthList")) {
                            var2 = 21;
                        }
                        break;
                    case 1162069698:
                        if (var0.equals("setThumbResource")) {
                            var2 = 139;
                        }
                        break;
                    case 1179719371:
                        if (var0.equals("stringLastIndex")) {
                            var2 = 59;
                        }
                        break;
                    case 1187505507:
                        if (var0.equals("stringReplace")) {
                            var2 = 63;
                        }
                        break;
                    case 1216249183:
                        if (var0.equals("firebasestorageDelete")) {
                            var2 = 266;
                        }
                        break;
                    case 1219071185:
                        if (var0.equals("firebasestorageUploadFile")) {
                            var2 = 264;
                        }
                        break;
                    case 1219299503:
                        if (var0.equals("objectanimatorIsRunning")) {
                            var2 = 243;
                        }
                        break;
                    case 1220078450:
                        if (var0.equals("addSourceDirectly")) {
                            var2 = 73;
                        }
                        break;
                    case 1236956449:
                        if (var0.equals("mediaplayerCreate")) {
                            var2 = 218;
                        }
                        break;
                    case 1240510514:
                        if (var0.equals("intentSetScreen")) {
                            var2 = 191;
                        }
                        break;
                    case 1242107556:
                        if (var0.equals("fileutilisfile")) {
                            var2 = 303;
                        }
                        break;
                    case 1252547704:
                        if (var0.equals("listMapToStr")) {
                            var2 = 77;
                        }
                        break;
                    case 1280029577:
                        if (var0.equals("requestFocus")) {
                            var2 = 118;
                        }
                        break;
                    case 1303367340:
                        if (var0.equals("textToSpeechStop")) {
                            var2 = 276;
                        }
                        break;
                    case 1305932583:
                        if (var0.equals("spnGetSelection")) {
                            var2 = 152;
                        }
                        break;
                    case 1311764809:
                        if (var0.equals("setTranslationX")) {
                            var2 = 123;
                        }
                        break;
                    case 1311764810:
                        if (var0.equals("setTranslationY")) {
                            var2 = 125;
                        }
                        break;
                    case 1313527577:
                        if (var0.equals("setTypeface")) {
                            var2 = 111;
                        }
                        break;
                    case 1315302372:
                        if (var0.equals("fileutillength")) {
                            var2 = 304;
                        }
                        break;
                    case 1330354473:
                        if (var0.equals("firebaseauthSignInAnonymously")) {
                            var2 = 251;
                        }
                        break;
                    case 1343794064:
                        if (var0.equals("listSetItemChecked")) {
                            var2 = 144;
                        }
                        break;
                    case 1348133645:
                        if (var0.equals("stringReplaceFirst")) {
                            var2 = 64;
                        }
                        break;
                    case 1387622940:
                        if (var0.equals("setAlpha")) {
                            var2 = 121;
                        }
                        break;
                    case 1395026457:
                        if (var0.equals("setImage")) {
                            var2 = 116;
                        }
                        break;
                    case 1397501021:
                        if (var0.equals("listRefresh")) {
                            var2 = 143;
                        }
                        break;
                    case 1405084438:
                        if (var0.equals("setTitle")) {
                            var2 = 188;
                        }
                        break;
                    case 1410284340:
                        if (var0.equals("seekBarSetProgress")) {
                            var2 = 138;
                        }
                        break;
                    case 1431171391:
                        if (var0.equals("mapRemoveKey")) {
                            var2 = 11;
                        }
                        break;
                    case 1437288110:
                        if (var0.equals("getPublicDir")) {
                            var2 = 310;
                        }
                        break;
                    case 1470831563:
                        if (var0.equals("intentGetString")) {
                            var2 = 195;
                        }
                        break;
                    case 1498864168:
                        if (var0.equals("seekBarGetProgress")) {
                            var2 = 136;
                        }
                        break;
                    case 1601394299:
                        if (var0.equals("listGetCheckedPositions")) {
                            var2 = 146;
                        }
                        break;
                    case 1633341847:
                        if (var0.equals("timerAfter")) {
                            var2 = 208;
                        }
                        break;
                    case 1635356258:
                        if (var0.equals("requestnetworkStartRequestNetwork")) {
                            var2 = 271;
                        }
                        break;
                    case 1637498582:
                        if (var0.equals("timerEvery")) {
                            var2 = 209;
                        }
                        break;
                    case 1695890133:
                        if (var0.equals("fileutilStartsWith")) {
                            var2 = 305;
                        }
                        break;
                    case 1712613410:
                        if (var0.equals("webViewZoomOut")) {
                            var2 = 164;
                        }
                        break;
                    case 1749552744:
                        if (var0.equals("textToSpeechSpeak")) {
                            var2 = 274;
                        }
                        break;
                    case 1764351209:
                        if (var0.equals("deleteList")) {
                            var2 = 18;
                        }
                        break;
                    case 1775620400:
                        if (var0.equals("strToMap")) {
                            var2 = 74;
                        }
                        break;
                    case 1779174257:
                        if (var0.equals("getChecked")) {
                            var2 = 134;
                        }
                        break;
                    case 1792552710:
                        if (var0.equals("rotateBitmapFile")) {
                            var2 = 316;
                        }
                        break;
                    case 1814870108:
                        if (var0.equals("doToast")) {
                            var2 = 186;
                        }
                        break;
                    case 1820536363:
                        if (var0.equals("interstitialadCreate")) {
                            var2 = 261;
                        }
                        break;
                    case 1823151876:
                        if (var0.equals("fileGetData")) {
                            var2 = 197;
                        }
                        break;
                    case 1848365301:
                        if (var0.equals("mapViewSetMapType")) {
                            var2 = 175;
                        }
                        break;
                    case 1873103950:
                        if (var0.equals("locationManagerRemoveUpdates")) {
                            var2 = 293;
                        }
                        break;
                    case 1883337723:
                        if (var0.equals("mathGetDisplayHeight")) {
                            var2 = 80;
                        }
                        break;
                    case 1885231494:
                        if (var0.equals("webViewCanGoForward")) {
                            var2 = 157;
                        }
                        break;
                    case 1908132964:
                        if (var0.equals("mapViewSetMarkerPosition")) {
                            var2 = 182;
                        }
                        break;
                    case 1908582864:
                        if (var0.equals("firebaseStopListen")) {
                            var2 = 258;
                        }
                        break;
                    case 1923980937:
                        if (var0.equals("requestnetworkSetParams")) {
                            var2 = 269;
                        }
                        break;
                    case 1941634330:
                        if (var0.equals("firebaseAdd")) {
                            var2 = 244;
                        }
                        break;
                    case 1948735400:
                        if (var0.equals("getAlpha")) {
                            var2 = 122;
                        }
                        break;
                    case 1964823036:
                        if (var0.equals("bluetoothConnectStopConnection")) {
                            var2 = 285;
                        }
                        break;
                    case 1973523807:
                        if (var0.equals("mediaplayerIsPlaying")) {
                            var2 = 224;
                        }
                        break;
                    case 1974249461:
                        if (var0.equals("skewBitmapFile")) {
                            var2 = 318;
                        }
                        break;
                    case 1976325370:
                        if (var0.equals("setImageFilePath")) {
                            var2 = 170;
                        }
                        break;
                    case 1984630281:
                        if (var0.equals("setHint")) {
                            var2 = 172;
                        }
                        break;
                    case 1984984239:
                        if (var0.equals("setText")) {
                            var2 = 110;
                        }
                        break;
                    case 2017929665:
                        if (var0.equals("calendarViewSetMinDate")) {
                            var2 = 167;
                        }
                        break;
                    case 2075310296:
                        if (var0.equals("interstitialadLoadAd")) {
                            var2 = 262;
                        }
                        break;
                    case 2090179216:
                        if (var0.equals("addListInt")) {
                            var2 = 16;
                        }
                        break;
                    case 2090182653:
                        if (var0.equals("addListMap")) {
                            var2 = 29;
                        }
                        break;
                    case 2090189010:
                        if (var0.equals("addListStr")) {
                            var2 = 24;
                        }
                        break;
                    case 2127377128:
                        if (var0.equals("mediaplayerGetCurrent")) {
                            var2 = 222;
                        }
                        break;
                    case 2130649194:
                        if (var0.equals("bluetoothConnectGetPairedDevices")) {
                            var2 = 290;
                        }
                        break;
                    case 2138225950:
                        if (var0.equals("locationManagerRequestLocationUpdates")) {
                            var2 = 292;
                        }
                }

                switch (var2) {
                    case 0:
                    case 323:
                        return -7711273;
                    default:
                        return -12289797;
                    case 1:
                        if (var1.equals("v")) {
                            return -11899692;
                        }

                        if (var1.equals("p")) {
                            return -13851166;
                        }

                        if (var1.equals("l")) {
                            break;
                        }
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                        return -1147626;
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                        break;
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                        return -1988310;
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                    case 50:
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                    case 60:
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                    case 68:
                    case 69:
                    case 70:
                    case 71:
                    case 72:
                    case 73:
                    case 74:
                    case 75:
                    case 76:
                    case 77:
                        return -10701022;
                    case 78:
                    case 79:
                    case 80:
                    case 81:
                    case 82:
                    case 83:
                    case 84:
                    case 85:
                    case 86:
                    case 87:
                    case 88:
                    case 89:
                    case 90:
                    case 91:
                    case 92:
                    case 93:
                    case 94:
                    case 95:
                    case 96:
                    case 97:
                    case 98:
                    case 99:
                    case 100:
                    case 101:
                        return -14435927;
                    case 102:
                    case 103:
                    case 104:
                    case 105:
                    case 106:
                    case 107:
                    case 108:
                    case 109:
                    case 110:
                    case 111:
                    case 112:
                    case 113:
                    case 114:
                    case 115:
                    case 116:
                    case 117:
                    case 118:
                    case 119:
                    case 120:
                    case 121:
                    case 122:
                    case 123:
                    case 124:
                    case 125:
                    case 126:
                    case 127:
                    case 128:
                    case 129:
                    case 130:
                    case 131:
                    case 132:
                    case 133:
                    case 134:
                    case 135:
                    case 136:
                    case 137:
                    case 138:
                    case 139:
                    case 140:
                    case 141:
                    case 142:
                    case 143:
                    case 144:
                    case 145:
                    case 146:
                    case 147:
                    case 148:
                    case 149:
                    case 150:
                    case 151:
                    case 152:
                    case 153:
                    case 154:
                    case 155:
                    case 156:
                    case 157:
                    case 158:
                    case 159:
                    case 160:
                    case 161:
                    case 162:
                    case 163:
                    case 164:
                    case 165:
                    case 166:
                    case 167:
                    case 168:
                    case 169:
                    case 170:
                    case 171:
                    case 172:
                    case 173:
                    case 174:
                    case 175:
                    case 176:
                    case 177:
                    case 178:
                    case 179:
                    case 180:
                    case 181:
                    case 182:
                    case 183:
                    case 184:
                    case 185:
                        return -11899692;
                    case 186:
                    case 187:
                    case 188:
                    case 189:
                    case 190:
                    case 191:
                    case 192:
                    case 193:
                    case 194:
                    case 195:
                    case 196:
                    case 197:
                    case 198:
                    case 199:
                    case 200:
                    case 201:
                    case 202:
                    case 203:
                    case 204:
                    case 205:
                    case 206:
                    case 207:
                    case 208:
                    case 209:
                    case 210:
                    case 211:
                    case 212:
                    case 213:
                    case 214:
                    case 215:
                    case 216:
                    case 217:
                    case 218:
                    case 219:
                    case 220:
                    case 221:
                    case 222:
                    case 223:
                    case 224:
                    case 225:
                    case 226:
                    case 227:
                    case 228:
                    case 229:
                    case 230:
                    case 231:
                    case 232:
                    case 233:
                    case 234:
                    case 235:
                    case 236:
                    case 237:
                    case 238:
                    case 239:
                    case 240:
                    case 241:
                    case 242:
                    case 243:
                    case 244:
                    case 245:
                    case 246:
                    case 247:
                    case 248:
                    case 249:
                    case 250:
                    case 251:
                    case 252:
                    case 253:
                    case 254:
                    case 255:
                    case 256:
                    case 257:
                    case 258:
                    case 259:
                    case 260:
                    case 261:
                    case 262:
                    case 263:
                    case 264:
                    case 265:
                    case 266:
                    case 267:
                    case 268:
                    case 269:
                    case 270:
                    case 271:
                    case 272:
                    case 273:
                    case 274:
                    case 275:
                    case 276:
                    case 277:
                    case 278:
                    case 279:
                    case 280:
                    case 281:
                    case 282:
                    case 283:
                    case 284:
                    case 285:
                    case 286:
                    case 287:
                    case 288:
                    case 289:
                    case 290:
                    case 291:
                    case 292:
                    case 293:
                        return -13851166;
                    case 294:
                    case 295:
                    case 296:
                    case 297:
                    case 298:
                    case 299:
                    case 300:
                    case 301:
                    case 302:
                    case 303:
                    case 304:
                    case 305:
                    case 306:
                    case 307:
                    case 308:
                    case 309:
                    case 310:
                    case 311:
                    case 312:
                    case 313:
                    case 314:
                    case 315:
                    case 316:
                    case 317:
                    case 318:
                    case 319:
                    case 320:
                    case 321:
                    case 322:
                        return -6190977;
                }

                return -3384542;
            }
        }

        public static String a(int var0) {
            return var0 != 1 ? (var0 != 2 ? (var0 != 3 ? "" : "List Map") : "List String") : "List Number";
        }

        public static String a(String var0) {
            byte var1;
            label126:
            {
                switch (var0.hashCode()) {
                    case -2004438503:
                        if (var0.equals("spinner")) {
                            var1 = 11;
                            break label126;
                        }
                        break;
                    case -1811660373:
                        if (var0.equals("soundpool")) {
                            var1 = 25;
                            break label126;
                        }
                        break;
                    case -1677313857:
                        if (var0.equals("requestnetwork")) {
                            var1 = 31;
                            break label126;
                        }
                        break;
                    case -1558241498:
                        if (var0.equals("objectanimator")) {
                            var1 = 26;
                            break label126;
                        }
                        break;
                    case -1421968056:
                        if (var0.equals("adview")) {
                            var1 = 16;
                            break label126;
                        }
                        break;
                    case -1332085432:
                        if (var0.equals("dialog")) {
                            var1 = 23;
                            break label126;
                        }
                        break;
                    case -1197746358:
                        if (var0.equals("texttospeech")) {
                            var1 = 32;
                            break label126;
                        }
                        break;
                    case -1183762788:
                        if (var0.equals("intent")) {
                            var1 = 18;
                            break label126;
                        }
                        break;
                    case -1002626734:
                        if (var0.equals("textview")) {
                            var1 = 5;
                            break label126;
                        }
                        break;
                    case -961721768:
                        if (var0.equals("locationmanager")) {
                            var1 = 35;
                            break label126;
                        }
                        break;
                    case -889473228:
                        if (var0.equals("switch")) {
                            var1 = 9;
                            break label126;
                        }
                        break;
                    case -877150592:
                        if (var0.equals("imageview")) {
                            var1 = 7;
                            break label126;
                        }
                        break;
                    case -823672651:
                        if (var0.equals("varMap")) {
                            var1 = 0;
                            break label126;
                        }
                        break;
                    case -563351033:
                        if (var0.equals("firebase")) {
                            var1 = 27;
                            break label126;
                        }
                        break;
                    case -351639837:
                        if (var0.equals("calendarview")) {
                            var1 = 14;
                            break label126;
                        }
                        break;
                    case -290065014:
                        if (var0.equals("speechtotext")) {
                            var1 = 33;
                            break label126;
                        }
                        break;
                    case -178324674:
                        if (var0.equals("calendar")) {
                            var1 = 20;
                            break label126;
                        }
                        break;
                    case 3143036:
                        if (var0.equals("file")) {
                            var1 = 19;
                            break label126;
                        }
                        break;
                    case 3619493:
                        if (var0.equals("view")) {
                            var1 = 4;
                            break label126;
                        }
                        break;
                    case 62092335:
                        if (var0.equals("firebaseauth")) {
                            var1 = 28;
                            break label126;
                        }
                        break;
                    case 110364485:
                        if (var0.equals("timer")) {
                            var1 = 22;
                            break label126;
                        }
                        break;
                    case 181944945:
                        if (var0.equals("listInt")) {
                            var1 = 1;
                            break label126;
                        }
                        break;
                    case 181948382:
                        if (var0.equals("listMap")) {
                            var1 = 3;
                            break label126;
                        }
                        break;
                    case 181954739:
                        if (var0.equals("listStr")) {
                            var1 = 2;
                            break label126;
                        }
                        break;
                    case 325741829:
                        if (var0.equals("gyroscope")) {
                            var1 = 30;
                            break label126;
                        }
                        break;
                    case 485199813:
                        if (var0.equals("mediaplayer")) {
                            var1 = 24;
                            break label126;
                        }
                        break;
                    case 690484860:
                        if (var0.equals("bluetoothconnect")) {
                            var1 = 34;
                            break label126;
                        }
                        break;
                    case 837734913:
                        if (var0.equals("mapview")) {
                            var1 = 17;
                            break label126;
                        }
                        break;
                    case 1105738265:
                        if (var0.equals("vibrator")) {
                            var1 = 21;
                            break label126;
                        }
                        break;
                    case 1131540166:
                        if (var0.equals("progressbar")) {
                            var1 = 15;
                            break label126;
                        }
                        break;
                    case 1224424441:
                        if (var0.equals("webview")) {
                            var1 = 12;
                            break label126;
                        }
                        break;
                    case 1346661443:
                        if (var0.equals("listview")) {
                            var1 = 10;
                            break label126;
                        }
                        break;
                    case 1536891843:
                        if (var0.equals("checkbox")) {
                            var1 = 8;
                            break label126;
                        }
                        break;
                    case 1602985527:
                        if (var0.equals("edittext")) {
                            var1 = 6;
                            break label126;
                        }
                        break;
                    case 1719159444:
                        if (var0.equals("firebasestorage")) {
                            var1 = 29;
                            break label126;
                        }
                        break;
                    case 1971813019:
                        if (var0.equals("seekbar")) {
                            var1 = 13;
                            break label126;
                        }
                }

                var1 = -1;
            }

            switch (var1) {
                case 0:
                    return "a";
                case 1:
                case 2:
                case 3:
                    return "l";
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                case 16:
                case 17:
                    return "v";
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                    return "p";
                default:
                    return " ";
            }
        }

        public static String b(int var0) {
            return var0 != 3 ? "" : "Map";
        }

        public static String b(String var0) {
            byte var1;
            label190:
            {
                switch (var0.hashCode()) {
                    case -2004438503:
                        if (var0.equals("spinner")) {
                            var1 = 17;
                            break label190;
                        }
                        break;
                    case -1811660373:
                        if (var0.equals("soundpool")) {
                            var1 = 32;
                            break label190;
                        }
                        break;
                    case -1677313857:
                        if (var0.equals("requestnetwork")) {
                            var1 = 39;
                            break label190;
                        }
                        break;
                    case -1673662198:
                        if (var0.equals("filepicker")) {
                            var1 = 38;
                            break label190;
                        }
                        break;
                    case -1558241498:
                        if (var0.equals("objectanimator")) {
                            var1 = 33;
                            break label190;
                        }
                        break;
                    case -1421968056:
                        if (var0.equals("adview")) {
                            var1 = 20;
                            break label190;
                        }
                        break;
                    case -1367751899:
                        if (var0.equals("camera")) {
                            var1 = 37;
                            break label190;
                        }
                        break;
                    case -1332085432:
                        if (var0.equals("dialog")) {
                            var1 = 30;
                            break label190;
                        }
                        break;
                    case -1197746358:
                        if (var0.equals("texttospeech")) {
                            var1 = 40;
                            break label190;
                        }
                        break;
                    case -1183762788:
                        if (var0.equals("intent")) {
                            var1 = 23;
                            break label190;
                        }
                        break;
                    case -1002626734:
                        if (var0.equals("textview")) {
                            var1 = 10;
                            break label190;
                        }
                        break;
                    case -961721768:
                        if (var0.equals("locationmanager")) {
                            var1 = 43;
                            break label190;
                        }
                        break;
                    case -889473228:
                        if (var0.equals("switch")) {
                            var1 = 19;
                            break label190;
                        }
                        break;
                    case -877150592:
                        if (var0.equals("imageview")) {
                            var1 = 13;
                            break label190;
                        }
                        break;
                    case -823676088:
                        if (var0.equals("varInt")) {
                            var1 = 0;
                            break label190;
                        }
                        break;
                    case -823672651:
                        if (var0.equals("varMap")) {
                            var1 = 3;
                            break label190;
                        }
                        break;
                    case -823666294:
                        if (var0.equals("varStr")) {
                            var1 = 2;
                            break label190;
                        }
                        break;
                    case -563351033:
                        if (var0.equals("firebase")) {
                            var1 = 27;
                            break label190;
                        }
                        break;
                    case -351639837:
                        if (var0.equals("calendarview")) {
                            var1 = 15;
                            break label190;
                        }
                        break;
                    case -290065014:
                        if (var0.equals("speechtotext")) {
                            var1 = 41;
                            break label190;
                        }
                        break;
                    case -178324674:
                        if (var0.equals("calendar")) {
                            var1 = 25;
                            break label190;
                        }
                        break;
                    case 3143036:
                        if (var0.equals("file")) {
                            var1 = 24;
                            break label190;
                        }
                        break;
                    case 3322014:
                        if (var0.equals("list")) {
                            var1 = 8;
                            break label190;
                        }
                        break;
                    case 3619493:
                        if (var0.equals("view")) {
                            var1 = 9;
                            break label190;
                        }
                        break;
                    case 62092335:
                        if (var0.equals("firebaseauth")) {
                            var1 = 28;
                            break label190;
                        }
                        break;
                    case 110364485:
                        if (var0.equals("timer")) {
                            var1 = 26;
                            break label190;
                        }
                        break;
                    case 181944945:
                        if (var0.equals("listInt")) {
                            var1 = 4;
                            break label190;
                        }
                        break;
                    case 181948382:
                        if (var0.equals("listMap")) {
                            var1 = 7;
                            break label190;
                        }
                        break;
                    case 181954739:
                        if (var0.equals("listStr")) {
                            var1 = 6;
                            break label190;
                        }
                        break;
                    case 235637425:
                        if (var0.equals("varBool")) {
                            var1 = 1;
                            break label190;
                        }
                        break;
                    case 325741829:
                        if (var0.equals("gyroscope")) {
                            var1 = 34;
                            break label190;
                        }
                        break;
                    case 485199813:
                        if (var0.equals("mediaplayer")) {
                            var1 = 31;
                            break label190;
                        }
                        break;
                    case 690484860:
                        if (var0.equals("bluetoothconnect")) {
                            var1 = 42;
                            break label190;
                        }
                        break;
                    case 837734913:
                        if (var0.equals("mapview")) {
                            var1 = 22;
                            break label190;
                        }
                        break;
                    case 1105738265:
                        if (var0.equals("vibrator")) {
                            var1 = 29;
                            break label190;
                        }
                        break;
                    case 1131540166:
                        if (var0.equals("progressbar")) {
                            var1 = 21;
                            break label190;
                        }
                        break;
                    case 1224424441:
                        if (var0.equals("webview")) {
                            var1 = 18;
                            break label190;
                        }
                        break;
                    case 1322145871:
                        if (var0.equals("interstitialad")) {
                            var1 = 35;
                            break label190;
                        }
                        break;
                    case 1345118376:
                        if (var0.equals("listBool")) {
                            var1 = 5;
                            break label190;
                        }
                        break;
                    case 1346661443:
                        if (var0.equals("listview")) {
                            var1 = 16;
                            break label190;
                        }
                        break;
                    case 1536891843:
                        if (var0.equals("checkbox")) {
                            var1 = 12;
                            break label190;
                        }
                        break;
                    case 1602985527:
                        if (var0.equals("edittext")) {
                            var1 = 11;
                            break label190;
                        }
                        break;
                    case 1719159444:
                        if (var0.equals("firebasestorage")) {
                            var1 = 36;
                            break label190;
                        }
                        break;
                    case 1971813019:
                        if (var0.equals("seekbar")) {
                            var1 = 14;
                            break label190;
                        }
                }

                var1 = -1;
            }

            switch (var1) {
                case 0:
                    return "Number";
                case 1:
                    return "Boolean";
                case 2:
                    return "String";
                case 3:
                    return "Map";
                case 4:
                    return "List Number";
                case 5:
                    return "List Boolean";
                case 6:
                    return "List String";
                case 7:
                    return "List Map";
                case 8:
                    return "List";
                case 9:
                    return "View";
                case 10:
                    return "TextView";
                case 11:
                    return "EditText";
                case 12:
                    return "CheckBox";
                case 13:
                    return "ImageView";
                case 14:
                    return "SeekBar";
                case 15:
                    return "CalendarView";
                case 16:
                    return "ListView";
                case 17:
                    return "Spinner";
                case 18:
                    return "WebView";
                case 19:
                    return "Switch";
                case 20:
                    return "AdView";
                case 21:
                    return "ProgressBar";
                case 22:
                    return "MapView";
                case 23:
                    return "Intent";
                case 24:
                    return "SharedPreferences";
                case 25:
                    return "Calendar";
                case 26:
                    return "Timer";
                case 27:
                    return "Firebase DB";
                case 28:
                    return "Firebase Auth";
                case 29:
                    return "Vibrator";
                case 30:
                    return "Dialog";
                case 31:
                    return "MediaPlayer";
                case 32:
                    return "SoundPool";
                case 33:
                    return "ObjectAnimator";
                case 34:
                    return "Gyroscope";
                case 35:
                    return "InterstitialAd";
                case 36:
                    return "FirebaseStorage";
                case 37:
                    return "Camera";
                case 38:
                    return "FilePicker";
                case 39:
                    return "RequestNetwork";
                case 40:
                    return "TextToSpeech";
                case 41:
                    return "SpeechToText";
                case 42:
                    return "BluetoothConnect";
                case 43:
                    return "LocationManager";
                default:
                    return "";
            }
        }
    }

    private static class mq {
        public static Gx a(String var0, String var1) {
            byte var3;
            label105:
            {
                int var2 = var0.hashCode();
                if (var2 != 97) {
                    if (var2 != 98) {
                        if (var2 != 100) {
                            if (var2 != 112) {
                                if (var2 != 115) {
                                    if (var2 != 118) {
                                        switch (var2) {
                                            case 108:
                                                if (var0.equals("l")) {
                                                    var3 = 5;
                                                    break label105;
                                                }
                                                break;
                                            case 109:
                                                if (var0.equals("m")) {
                                                    var3 = 8;
                                                    break label105;
                                                }
                                                break;
                                            case 110:
                                                if (var0.equals("n")) {
                                                    var3 = 2;
                                                    break label105;
                                                }
                                        }
                                    } else if (var0.equals("v")) {
                                        var3 = 6;
                                        break label105;
                                    }
                                } else if (var0.equals("s")) {
                                    var3 = 3;
                                    break label105;
                                }
                            } else if (var0.equals("p")) {
                                var3 = 7;
                                break label105;
                            }
                        } else if (var0.equals("d")) {
                            var3 = 1;
                            break label105;
                        }
                    } else if (var0.equals("b")) {
                        var3 = 0;
                        break label105;
                    }
                } else if (var0.equals("a")) {
                    var3 = 4;
                    break label105;
                }

                var3 = -1;
            }

            switch (var3) {
                case 0:
                    return new Gx("boolean");
                case 1:
                case 2:
                    return new Gx("double");
                case 3:
                    if (var1 != null && var1.length() > 0) {
                        if (var1.toLowerCase().equals("inputonly")) {
                            return new Gx("Input");
                        }

                        return new Gx("String");
                    }

                    return new Gx("String");
                case 4:
                    return new Gx("Map");
                case 5:
                    int var4 = var1.hashCode();
                    byte var5;
                    if (var4 != 995088651) {
                        if (var4 != 1137466835) {
                            if (var4 == 1408716506 && var1.equals("List Map")) {
                                var5 = 2;
                                return var5 != 0 ? (var5 != 1 ? (var5 != 2 ? null : new Gx("ListMap")) : new Gx("ListString")) : new Gx("ListInt");
                            }
                        } else if (var1.equals("List String")) {
                            var5 = 1;
                            return var5 != 0 ? (var5 != 1 ? (var5 != 2 ? null : new Gx("ListMap")) : new Gx("ListString")) : new Gx("ListInt");
                        }
                    } else if (var1.equals("List Number")) {
                        var5 = 0;
                        return var5 != 0 ? (var5 != 1 ? (var5 != 2 ? null : new Gx("ListMap")) : new Gx("ListString")) : new Gx("ListInt");
                    }

                    var5 = -1;
                    return var5 != 0 ? (var5 != 1 ? (var5 != 2 ? null : new Gx("ListMap")) : new Gx("ListString")) : new Gx("ListInt");
                case 6:
                    return new Gx(var1);
                case 7:
                case 8:
                    return new Gx(b(var1));
                default:
                    return null;
            }
        }


        public static String b(String var0) {
            byte var1;
            label252:
            {
                switch (var0.hashCode()) {
                    case -2099895620:
                        if (var0.equals("Intent")) {
                            var1 = 0;
                            break label252;
                        }
                        break;
                    case -2004438503:
                        if (var0.equals("spinner")) {
                            var1 = 32;
                            break label252;
                        }
                        break;
                    case -1965257499:
                        if (var0.equals("Gyroscope")) {
                            var1 = 13;
                            break label252;
                        }
                        break;
                    case -1811660373:
                        if (var0.equals("soundpool")) {
                            var1 = 44;
                            break label252;
                        }
                        break;
                    case -1677313857:
                        if (var0.equals("requestnetwork")) {
                            var1 = 54;
                            break label252;
                        }
                        break;
                    case -1673662198:
                        if (var0.equals("filepicker")) {
                            var1 = 53;
                            break label252;
                        }
                        break;
                    case -1632719839:
                        if (var0.equals("Firebase Auth")) {
                            var1 = 12;
                            break label252;
                        }
                        break;
                    case -1587760963:
                        if (var0.equals("compoundButton")) {
                            var1 = 27;
                            break label252;
                        }
                        break;
                    case -1558241498:
                        if (var0.equals("objectanimator")) {
                            var1 = 45;
                            break label252;
                        }
                        break;
                    case -1421968056:
                        if (var0.equals("adview")) {
                            var1 = 35;
                            break label252;
                        }
                        break;
                    case -1367751899:
                        if (var0.equals("camera")) {
                            var1 = 52;
                            break label252;
                        }
                        break;
                    case -1332085432:
                        if (var0.equals("dialog")) {
                            var1 = 42;
                            break label252;
                        }
                        break;
                    case -1197746358:
                        if (var0.equals("texttospeech")) {
                            var1 = 56;
                            break label252;
                        }
                        break;
                    case -1183762788:
                        if (var0.equals("intent")) {
                            var1 = 37;
                            break label252;
                        }
                        break;
                    case -1002626734:
                        if (var0.equals("textview")) {
                            var1 = 24;
                            break label252;
                        }
                        break;
                    case -961721768:
                        if (var0.equals("locationmanager")) {
                            var1 = 59;
                            break label252;
                        }
                        break;
                    case -889473228:
                        if (var0.equals("switch")) {
                            var1 = 29;
                            break label252;
                        }
                        break;
                    case -877150592:
                        if (var0.equals("imageview")) {
                            var1 = 26;
                            break label252;
                        }
                        break;
                    case -823676088:
                        if (var0.equals("varInt")) {
                            var1 = 16;
                            break label252;
                        }
                        break;
                    case -823672651:
                        if (var0.equals("varMap")) {
                            var1 = 18;
                            break label252;
                        }
                        break;
                    case -823666294:
                        if (var0.equals("varStr")) {
                            var1 = 17;
                            break label252;
                        }
                        break;
                    case -685497065:
                        if (var0.equals("Firebase DB")) {
                            var1 = 10;
                            break label252;
                        }
                        break;
                    case -563351033:
                        if (var0.equals("firebase")) {
                            var1 = 46;
                            break label252;
                        }
                        break;
                    case -498706905:
                        if (var0.equals("Firebase")) {
                            var1 = 11;
                            break label252;
                        }
                        break;
                    case -351639837:
                        if (var0.equals("calendarview")) {
                            var1 = 34;
                            break label252;
                        }
                        break;
                    case -290065014:
                        if (var0.equals("speechtotext")) {
                            var1 = 57;
                            break label252;
                        }
                        break;
                    case -178324674:
                        if (var0.equals("calendar")) {
                            var1 = 39;
                            break label252;
                        }
                        break;
                    case -113680546:
                        if (var0.equals("Calendar")) {
                            var1 = 3;
                            break label252;
                        }
                        break;
                    case 2189724:
                        if (var0.equals("File")) {
                            var1 = 2;
                            break label252;
                        }
                        break;
                    case 3143036:
                        if (var0.equals("file")) {
                            var1 = 38;
                            break label252;
                        }
                        break;
                    case 3322014:
                        if (var0.equals("list")) {
                            var1 = 22;
                            break label252;
                        }
                        break;
                    case 3619493:
                        if (var0.equals("view")) {
                            var1 = 23;
                            break label252;
                        }
                        break;
                    case 62092335:
                        if (var0.equals("firebaseauth")) {
                            var1 = 47;
                            break label252;
                        }
                        break;
                    case 80811813:
                        if (var0.equals("Timer")) {
                            var1 = 5;
                            break label252;
                        }
                        break;
                    case 110364485:
                        if (var0.equals("timer")) {
                            var1 = 41;
                            break label252;
                        }
                        break;
                    case 181944945:
                        if (var0.equals("listInt")) {
                            var1 = 19;
                            break label252;
                        }
                        break;
                    case 181948382:
                        if (var0.equals("listMap")) {
                            var1 = 21;
                            break label252;
                        }
                        break;
                    case 181954611:
                        if (var0.equals("listSpn")) {
                            var1 = 30;
                            break label252;
                        }
                        break;
                    case 181954739:
                        if (var0.equals("listStr")) {
                            var1 = 20;
                            break label252;
                        }
                        break;
                    case 191354283:
                        if (var0.equals("SoundPool")) {
                            var1 = 8;
                            break label252;
                        }
                        break;
                    case 235637425:
                        if (var0.equals("varBool")) {
                            var1 = 15;
                            break label252;
                        }
                        break;
                    case 320151695:
                        if (var0.equals("InterstitialAd")) {
                            var1 = 14;
                            break label252;
                        }
                        break;
                    case 325741829:
                        if (var0.equals("gyroscope")) {
                            var1 = 49;
                            break label252;
                        }
                        break;
                    case 400845544:
                        if (var0.equals("File (Shared Preferences)")) {
                            var1 = 1;
                            break label252;
                        }
                        break;
                    case 485199813:
                        if (var0.equals("mediaplayer")) {
                            var1 = 43;
                            break label252;
                        }
                        break;
                    case 690484860:
                        if (var0.equals("bluetoothconnect")) {
                            var1 = 58;
                            break label252;
                        }
                        break;
                    case 837734913:
                        if (var0.equals("mapview")) {
                            var1 = 36;
                            break label252;
                        }
                        break;
                    case 1105738265:
                        if (var0.equals("vibrator")) {
                            var1 = 40;
                            break label252;
                        }
                        break;
                    case 1131540166:
                        if (var0.equals("progressbar")) {
                            var1 = 55;
                            break label252;
                        }
                        break;
                    case 1170382393:
                        if (var0.equals("Vibrator")) {
                            var1 = 4;
                            break label252;
                        }
                        break;
                    case 1224424441:
                        if (var0.equals("webview")) {
                            var1 = 33;
                            break label252;
                        }
                        break;
                    case 1236935621:
                        if (var0.equals("MediaPlayer")) {
                            var1 = 7;
                            break label252;
                        }
                        break;
                    case 1322145871:
                        if (var0.equals("interstitialad")) {
                            var1 = 50;
                            break label252;
                        }
                        break;
                    case 1346661443:
                        if (var0.equals("listview")) {
                            var1 = 31;
                            break label252;
                        }
                        break;
                    case 1536891843:
                        if (var0.equals("checkbox")) {
                            var1 = 28;
                            break label252;
                        }
                        break;
                    case 1602985527:
                        if (var0.equals("edittext")) {
                            var1 = 25;
                            break label252;
                        }
                        break;
                    case 1719159444:
                        if (var0.equals("firebasestorage")) {
                            var1 = 51;
                            break label252;
                        }
                        break;
                    case 1799376742:
                        if (var0.equals("ObjectAnimator")) {
                            var1 = 9;
                            break label252;
                        }
                        break;
                    case 1971813019:
                        if (var0.equals("seekbar")) {
                            var1 = 48;
                            break label252;
                        }
                        break;
                    case 2046749032:
                        if (var0.equals("Dialog")) {
                            var1 = 6;
                            break label252;
                        }
                }

                var1 = -1;
            }

            switch (var1) {
                case 0:
                    return "Intent";
                case 1:
                case 2:
                    return "SharedPreferences";
                case 3:
                    return "Calendar";
                case 4:
                    return "Vibrator";
                case 5:
                    return "Timer";
                case 6:
                    return "Dialog";
                case 7:
                    return "MediaPlayer";
                case 8:
                    return "SoundPool";
                case 9:
                    return "ObjectAnimator";
                case 10:
                case 11:
                    return "FirebaseDB";
                case 12:
                    return "FirebaseAuth";
                case 13:
                    return "Gyroscope";
                case 14:
                    return "InterstitialAd";
                case 15:
                    return "boolean.SelectBoolean";
                case 16:
                    return "double.SelectDouble";
                case 17:
                    return "String.SelectString";
                case 18:
                    return "Map";
                case 19:
                    return "ListInt";
                case 20:
                    return "ListString";
                case 21:
                    return "ListMap";
                case 22:
                    return "List";
                case 23:
                    return "View";
                case 24:
                    return "TextView";
                case 25:
                    return "EditText";
                case 26:
                    return "ImageView";
                case 27:
                    return "CompoundButton";
                case 28:
                    return "CheckBox";
                case 29:
                    return "Switch";
                case 30:
                    return "AdapterView";
                case 31:
                    return "ListView";
                case 32:
                    return "Spinner";
                case 33:
                    return "WebView";
                case 34:
                    return "CalendarView";
                case 35:
                    return "AdView";
                case 36:
                    return "MapView";
                case 37:
                    return "Intent";
                case 38:
                    return "SharedPreferences";
                case 39:
                    return "Calendar";
                case 40:
                    return "Vibrator";
                case 41:
                    return "Timer";
                case 42:
                    return "Dialog";
                case 43:
                    return "MediaPlayer";
                case 44:
                    return "SoundPool";
                case 45:
                    return "ObjectAnimator";
                case 46:
                    return "FirebaseDB";
                case 47:
                    return "FirebaseAuth";
                case 48:
                    return "SeekBar";
                case 49:
                    return "Gyroscope";
                case 50:
                    return "InterstitialAd";
                case 51:
                    return "FirebaseStorage";
                case 52:
                    return "Camera";
                case 53:
                    return "FilePicker";
                case 54:
                    return "RequestNetwork";
                case 55:
                    return "ProgressBar";
                case 56:
                    return "TextToSpeech";
                case 57:
                    return "SpeechToText";
                case 58:
                    return "BluetoothConnect";
                case 59:
                    return "LocationManager";
                default:
                    return var0;
            }
        }

        public static ArrayList a(String var0) {
            ArrayList var1 = new ArrayList();
            ArrayList var2 = FB.c(var0);
            if (var2.size() <= 0) {
                return var1;
            } else {
                Iterator var3 = var2.iterator();

                while (var3.hasNext()) {
                    String var4 = (String) var3.next();
                    if (var4.charAt(0) == 37 && var4.length() >= 2) {
                        String var5 = String.valueOf(var4.charAt(1));
                        String var6;
                        if (var4.length() > 3) {
                            var6 = var4.substring(3);
                        } else {
                            var6 = "";
                        }

                        var1.add(a(var5, var6));
                    }
                }

                return var1;
            }
        }
    }

    private static class FB {


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

    private static class wB {
        public static float a(Context var0, float var1) {
            return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, var1, var0.getResources().getDisplayMetrics());
        }

        public static View a(Context var0, ViewGroup var1, int var2) {
            return ((LayoutInflater) var0.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(var2, var1, true);
        }
    }

    private static class BV {
        public static String a(String x) {
            return "";
        }
    }
}
