package ma.swblockspreview.editor;

import android.content.Context;
import android.util.AttributeSet;

import ma.swblockspreview.editor.logic.BlockPane;
import ma.swblockspreview.editor.view.LogicEditorScrollView;

public class ViewBlockCollectionEditor extends LogicEditorScrollView {
    public Context i;
    public BlockPane j;
    public boolean k = true;
    public int[] l = new int[2];

    public ViewBlockCollectionEditor(Context var1) {
        super(var1);
        aa(var1);
    }

    public ViewBlockCollectionEditor(Context var1, AttributeSet var2) {
        super(var1, var2);
        aa(var1);
    }

    private void aa(Context var1) {
        i = var1;
        j = new BlockPane(i);
        j.setLayoutParams(new LayoutParams(-2, -2));
        addView(j);
    }

    public BlockPane getBlockPane() {
        return j;
    }

    public void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
        super.onLayout(var1, var2, var3, var4, var5);
        if (k) {
            j.getLayoutParams().width = var4 - var2;
            j.getLayoutParams().height = var5 - var3;
            j.b();
            k = false;
        }

    }
}
