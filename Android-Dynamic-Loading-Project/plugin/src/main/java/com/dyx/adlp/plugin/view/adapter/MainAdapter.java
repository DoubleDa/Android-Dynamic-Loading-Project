package com.dyx.adlp.plugin.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dyx.adlp.plugin.R;

import java.util.List;

/**
 * project name：Android-Dynamic-Loading-Project
 * class describe：
 * create person：dayongxin
 * create time：16/7/26 下午3:44
 * alter person：dayongxin
 * alter time：16/7/26 下午3:44
 * alter remark：
 */
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ItemViewHolder> {
    private Context context;
    private List<String> datas;
    public OnRvItemClickListener mOnRvItemClickListener;

    public interface OnRvItemClickListener {
        void onItemClick(int pos);
    }

    public void setmOnRvItemClickListener(OnRvItemClickListener mOnRvItemClickListener) {
        this.mOnRvItemClickListener = mOnRvItemClickListener;
    }

    public MainAdapter(Context context, List<String> datas) {
        this.context = context;
        this.datas = datas;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rv_item_layout, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ItemViewHolder holder, int position) {
        holder.textView.setText(datas.get(position));
        if (mOnRvItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = holder.getLayoutPosition();
                    mOnRvItemClickListener.onItemClick(pos);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public ItemViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tv_item);
        }
    }
}
