package ma.swblockspreview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.google.gson.Gson;

import java.util.ArrayList;

import ma.swblockspreview.bean.BlockBean;

public class MainActivity extends Activity {
    private BlockPreviewer blockPreviewer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        blockPreviewer = new BlockPreviewer(this);
        LinearLayout container = findViewById(R.id.lnContainer);

        findViewById(R.id.btnPreview).setOnClickListener(v -> {
            var gson = new Gson();
            var blocks = new ArrayList<BlockBean>();

            for (var line : Constants.SAMPLE_BLOCKS_STR.split("\n")) {
                blocks.add(gson.fromJson(line, BlockBean.class));
            }

            blockPreviewer.previewInto(container, blocks);
        });
    }

    @Override
    protected void onDestroy() {
        blockPreviewer.dispose();
        super.onDestroy();
    }
}
