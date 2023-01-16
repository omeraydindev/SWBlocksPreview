# SW Blocks Preview
A small port of the BlockPane/blocks preview from Sketchware. See the class [BlockPreviewer.java](app/src/main/java/ma/swblockspreview/BlockPreviewer.java).

It is read-only (hence "preview") so you can't drag-drop blocks around, although that should be trivial to port also. One would just need to port over part of the [onTouch event](https://github.com/Sketchware-Pro/Sketchware-Pro/blob/9f8aeddcf5147c09a9649e2bac9664a5c2dafcff/app/src/main/java/com/besome/sketch/editor/LogicEditorActivity.java#L2424) from LogicEditorActivity. PRs are welcome.

It has no external dependencies, not even AndroidX. I only included Gson to load some dummy block data for preview. Refer to [MainActivity.java](app/src/main/java/ma/swblockspreview/MainActivity.java) for example usage.

### SWB?
[Here](SWBlocksPreview.swb).

### Screenshots
<img src="https://user-images.githubusercontent.com/45513948/212762111-6c206741-cc2d-4ddb-bee6-0a9549168301.png" width="400" />
