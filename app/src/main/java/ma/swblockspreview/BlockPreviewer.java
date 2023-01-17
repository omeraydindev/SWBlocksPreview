package ma.swblockspreview;

import android.app.AlertDialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import ma.swblockspreview.bean.BlockBean;
import ma.swblockspreview.editor.Rs;
import ma.swblockspreview.editor.Ss;
import ma.swblockspreview.editor.Ts;
import ma.swblockspreview.editor.ViewBlockCollectionEditor;
import ma.swblockspreview.editor.logic.BlockPane;
import ma.swblockspreview.util.LayoutUtils;

public class BlockPreviewer {
    private Context context;

    public BlockPreviewer(Context context) {
        this.context = context;
    }

    public void previewInto(ViewGroup container, ArrayList<BlockBean> blocks) {
        viewBlockCollectionEditor = new ViewBlockCollectionEditor(this, context);
        viewBlockCollectionEditor.setScrollEnabled(true);
        blockPane = viewBlockCollectionEditor.getBlockPane();

        a(blocks, 8, 8);
        l();

        container.removeAllViews();
        container.addView(viewBlockCollectionEditor);
    }

    // idk if this is necessary but here we go anyway.
    // Android is weird when it comes to memory leaks
    public void dispose() {
        viewBlockCollectionEditor = null;
        blockPane = null;
        context = null;
    }

    /**
     * THE CODE BELOW THIS POINT IS *EXTREMELY* MESSY SINCE
     * IT WAS DECOMPILED & PORTED TO *JUST* WORK. NO REFACTORING HAS EVEN
     * BEEN ATTEMPTED BECAUSE I DID NOT WANT TO GO CRAZY, I JUST WANTED
     * IT TO SOMEWHAT WORK.
     * <p>
     * READ/MODIFY AT YOUR OWN RISK !!!
     */

    ViewBlockCollectionEditor viewBlockCollectionEditor;
    BlockPane blockPane;

    private void a(ArrayList<BlockBean> var1, int var2, int var3) {
        HashMap<Integer, Rs> var4 = new HashMap<>();
        Iterator<BlockBean> var5 = var1.iterator();
        Rs var6 = null;
        boolean var7 = true;

        while (var5.hasNext()) {
            Rs var21 = a(var5.next());
            var4.put(Integer.valueOf(((Integer) var21.getTag()).intValue()), var21);
            BlockPane var23 = blockPane;
            var23.g = Math.max(var23.g, 1 + ((Integer) var21.getTag()).intValue());
            blockPane.a(var21, var2, var3);
            if (var7) {
                var6 = var21;
                var7 = false;
            }
        }

        Iterator<BlockBean> var8 = var1.iterator();

        while (true) {
            BlockBean var9;
            Rs var10;
            do {
                if (!var8.hasNext()) {
                    var6.k();
                    blockPane.b();
                    return;
                }

                var9 = var8.next();
                var10 = var4.get(Integer.valueOf(var9.id));
            } while (var10 == null);

            int var11 = var9.subStack1;
            if (var11 >= 0) {
                Rs var20 = var4.get(Integer.valueOf(var11));
                if (var20 != null) {
                    var10.e(var20);
                }
            }

            int var12 = var9.subStack2;
            if (var12 >= 0) {
                Rs var19 = var4.get(Integer.valueOf(var12));
                if (var19 != null) {
                    var10.f(var19);
                }
            }

            int var13 = var9.nextBlock;
            if (var13 >= 0) {
                Rs var18 = var4.get(Integer.valueOf(var13));
                if (var18 != null) {
                    var10.b(var18);
                }
            }

            int var14 = var9.parameters.size();

            for (int var15 = 0; var15 < var14; ++var15) {
                String var16 = (String) var9.parameters.get(var15);
                if (var16 != null && var16.length() > 0) {
                    if (var16.charAt(0) == 64) {
                        Rs var17 = var4.get(Integer.valueOf(Integer.valueOf(var16.substring(1)).intValue()));
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
        return (int) LayoutUtils.getDip(var0, 48.0F);
    }

    private static int f(Context var0) {
        int var1 = var0.getResources().getIdentifier("status_bar_height", "dimen", "android");
        return var1 > 0 ? var0.getResources().getDimensionPixelSize(var1) : 0;
    }


}
