package sedatdilmac.com.orkunyonetim.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import sedatdilmac.com.orkunyonetim.R;
import sedatdilmac.com.orkunyonetim.activity.PDFActivity;
import sedatdilmac.com.orkunyonetim.pojo.Demo;

/**
 * Created by SD
 * on 13.01.2019.
 */
public class DemoAdapter extends RecyclerView.Adapter<DemoAdapter.MyViewHolder> {

    private static final String TAG = "DemoAdapter ";

    private Context mContext;
    private List<Demo> demoList;

    public DemoAdapter(Context context, List<Demo> results) {
        this.mContext = context;
        this.demoList = results;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_demo, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final Demo demo = demoList.get(position);
        holder.textView_name.setText(demo.getName());
        holder.textView_amount.setText(demo.getAmount());
        if (demo.isPayed()) {
            holder.textView_isPayed.setText("Ödendi");
            holder.textView_isPayed.setTextColor(ContextCompat.getColor(mContext, R.color.colorGreen));
        } else {
            holder.textView_isPayed.setText("Ödenmedi");
            holder.textView_isPayed.setTextColor(ContextCompat.getColor(mContext, R.color.colorRed));
        }

        /*Glide.with(mContext)
                .load(allKeepersPojo.getThumbnail())
                .centerCrop()
                .into(holder.imageView_thumbnail);*/

        holder.button_pdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.wtf(TAG, "id : " + demo.getUrl());

                /*Intent intent = new Intent(mContext, PDFActivity.class);
                intent.putExtra("url", demo.getUrl());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(intent);*/

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(demo.getUrl()));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(intent);

                //Intent intent = new Intent(Intent.ACTION_VIEW);
                //intent.setData(Uri.parse(url));
                //startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return demoList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView_name, textView_amount, textView_isPayed;
        Button button_pdf;

        public MyViewHolder(View view) {
            super(view);
            textView_name = view.findViewById(R.id.textView_name);
            textView_amount = view.findViewById(R.id.textView_amount);
            textView_isPayed = view.findViewById(R.id.textView_isPayed);
            button_pdf = view.findViewById(R.id.button_pdf);
        }
    }

}
