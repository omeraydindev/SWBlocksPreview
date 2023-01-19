package ma.swblockspreview.editor;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;

import ma.swblockspreview.editor.logic.BlockPane;
import ma.swblockspreview.editor.view.LogicEditorScrollView;

public class ViewBlockCollectionEditor extends LogicEditorScrollView {
    private Context context;
    private BlockPane blockPane;
    private boolean k = true;

    public ViewBlockCollectionEditor(Context context) {
        super(context);
        initialize(context);
    }

    public ViewBlockCollectionEditor(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize(context);
    }

    private void initialize(Context context) {
        this.context = context;
        blockPane = new BlockPane(this.context);
        blockPane.setLayoutParams(new LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        addView(blockPane);
    }

    public BlockPane getBlockPane() {
        return blockPane;
    }

    @Override
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (k) {
            blockPane.getLayoutParams().width = right - left;
            blockPane.getLayoutParams().height = bottom - top;
            blockPane.b();
            k = false;
        }

    }
}
