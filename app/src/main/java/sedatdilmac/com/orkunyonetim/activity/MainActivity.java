package sedatdilmac.com.orkunyonetim.activity;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.webkit.WebView;

import java.util.ArrayList;

import sedatdilmac.com.orkunyonetim.R;
import sedatdilmac.com.orkunyonetim.adapter.DemoAdapter;
import sedatdilmac.com.orkunyonetim.pojo.Demo;

import static sedatdilmac.com.orkunyonetim.util.Utils.dpToPx;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Demo> demoList = new ArrayList<>();

        demoList.add(new Demo("http://sedatdilmac.com/docs/vizyontower.pdf", "Apartman", "340tl", false));
        demoList.add(new Demo("http://sedatdilmac.com/docs/vizyontower.pdf", "Havuz", "270tl", true));
        demoList.add(new Demo("http://sedatdilmac.com/docs/vizyontower.pdf", "Temizlik", "120tl", false));

        RecyclerView recyclerView_demo = findViewById(R.id.recyclerView_demo);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 1);
        recyclerView_demo.setLayoutManager(mLayoutManager);
        recyclerView_demo.addItemDecoration(new GridSpacingItemDecoration(1, dpToPx(10), true));
        recyclerView_demo.setItemAnimator(new DefaultItemAnimator());

        recyclerView_demo.setAdapter(new DemoAdapter(getApplicationContext(), demoList));

    }

    private class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {
        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

}
