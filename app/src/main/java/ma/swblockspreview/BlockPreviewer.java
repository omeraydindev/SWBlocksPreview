package ma.swblockspreview;

import android.annotation.SuppressLint;
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
    protected ViewBlockCollectionEditor viewBlockCollectionEditor;
    protected BlockPane blockPane;

    public BlockPreviewer(Context context) {
        this.context = context;
    }

    public void previewInto(ViewGroup container, ArrayList<BlockBean> blocks) {
        viewBlockCollectionEditor = new ViewBlockCollectionEditor(context);
        viewBlockCollectionEditor.setScrollEnabled(true);
        blockPane = viewBlockCollectionEditor.getBlockPane();

        previewBlocks(blocks, 8, 8);
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


    private void previewBlocks(ArrayList<BlockBean> blocks, int var2, int var3) {
        HashMap<Integer, Rs> var4 = new HashMap<>();
        Iterator<BlockBean> var5 = blocks.iterator();
        Rs var6 = null;
        boolean var7 = true;

        while (var5.hasNext()) {
            Rs block = getBlock(var5.next());
            var4.put((Integer) block.getTag(), block);
            blockPane.g = Math.max(blockPane.g, 1 + (Integer) block.getTag());
            blockPane.a(block, var2, var3);
            if (var7) {
                var6 = block;
                var7 = false;
            }
        }

        Iterator<BlockBean> var8 = blocks.iterator();

        while (true) {
            BlockBean var9;
            Rs block;
            if (!var8.hasNext()) {
                var6.k();
                blockPane.b();
                return;
            }

            var9 = var8.next();
            block = var4.get(Integer.valueOf(var9.id));
            while (block == null) {
                if (!var8.hasNext()) {
                    var6.k();
                    blockPane.b();
                    return;
                }

                var9 = var8.next();
                block = var4.get(Integer.valueOf(var9.id));
            }

            int subStack1 = var9.subStack1;
            if (subStack1 >= 0) {
                Rs var20 = var4.get(subStack1);
                if (var20 != null) {
                    block.e(var20);
                }
            }

            int subStack2 = var9.subStack2;
            if (subStack2 >= 0) {
                Rs var19 = var4.get(subStack2);
                if (var19 != null) {
                    block.f(var19);
                }
            }

            int nextBlock = var9.nextBlock;
            if (nextBlock >= 0) {
                Rs var18 = var4.get(nextBlock);
                if (var18 != null) {
                    block.b(var18);
                }
            }

            int paramsSize = var9.parameters.size();

            for (int i = 0; i < paramsSize; ++i) {
                String param = var9.parameters.get(i);
                if (param != null && param.length() > 0) {
                    if (param.charAt(0) == 64) {
                        Rs var17 = var4.get(Integer.valueOf(param.substring(1)));
                        if (var17 != null && block.V.size() > 0) {
                            block.a((Ts) block.V.get(i), var17);
                        }
                    } else {
                        if (block.V.size() > 0) {
                            ((Ss) block.V.get(i)).setArgValue(param);
                            argOnClick(((Ss) block.V.get(i)));
                            block.m();
                        }
                    }
                }
            }
        }
    }

    private Rs getBlock(BlockBean bean) {
        Rs block = new Rs(context, Integer.parseInt(bean.id), bean.spec, bean.type, bean.typeName, bean.opCode);
        block.e = bean.color;
        blockOnClick(block, bean);
        return block;
    }

    private void blockOnClick(Rs rs, BlockBean bean) {
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

    private void argOnClick(Ss ss) {
        ss.setOnClickListener(v -> dialog("Argument info", String.valueOf(ss.getArgValue())));
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
        int height = context.getResources().getDisplayMetrics().heightPixels;
        //  this.r.measure(0, 0);
        int measureHeight = 0;//this.r.getMeasuredHeight();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, height - a(context) - getStatusBarHeight(context) - measureHeight);
        viewBlockCollectionEditor.setLayoutParams(layoutParams);
        viewBlockCollectionEditor.requestLayout();
    }

    private static int a(Context context) {
        return (int) LayoutUtils.getDip(context, 48.0F);
    }

    @SuppressLint({"DiscouragedApi", "InternalInsetResource"})
    private static int getStatusBarHeight(Context context) {
        int statusBarHeight = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        return statusBarHeight > 0 ? context.getResources().getDimensionPixelSize(statusBarHeight) : 0;
    }
}
