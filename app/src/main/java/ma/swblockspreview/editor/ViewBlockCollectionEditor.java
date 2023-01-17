package ma.swblockspreview.editor;

import android.content.Context;
import android.util.AttributeSet;

import ma.swblockspreview.BlockPreviewer;
import ma.swblockspreview.editor.logic.BlockPane;
import ma.swblockspreview.editor.view.LogicEditorScrollView;

public class ViewBlockCollectionEditor extends LogicEditorScrollView {
    private final BlockPreviewer blockPreviewer;
    public Context i;
    public BlockPane j;
    public boolean k = true;
    public int[] l = new int[2];

    public ViewBlockCollectionEditor(BlockPreviewer blockPreviewer, Context var1) {
        super(var1);
        this.blockPreviewer = blockPreviewer;
        this.aa(var1);
    }

    public ViewBlockCollectionEditor(BlockPreviewer blockPreviewer, Context var1, AttributeSet var2) {
        super(var1, var2);
        this.blockPreviewer = blockPreviewer;
        this.aa(var1);
    }

    private void aa(Context var1) {
        this.i = var1;
        this.j = new BlockPane(this.i);
        this.j.setLayoutParams(new LayoutParams(-2, -2));
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
