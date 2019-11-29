package com.example.administrator.ct.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.ct.R;
import com.example.administrator.ct.http.entity.CategroyEntity;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

public class CategroyRightAdapter extends RecyclerView.Adapter<CategroyRightAdapter.RightViewHolder> implements View.OnClickListener {
    
    private final List<CategroyEntity> datas;
    private final Activity mContext;
    private OnItemClickListener onItemClickListener;
    
    public CategroyRightAdapter(Activity activity,List<CategroyEntity> data){
        this.datas = data;
        this.mContext = activity;
    }

    @NonNull
    @Override
    public RightViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_categroy_right,parent,false);
        view.setOnClickListener(this);
        return new RightViewHolder(view);
    }
    
    @Override
    public void onBindViewHolder(@NonNull RightViewHolder holder,int position){
        CategroyEntity entity = datas.get(position);
        holder.itemView.setTag(position);
        ImageLoader.getInstance().displayImage(entity.getImage(),holder.iv_image);
        holder.tv_name.setText(entity.getName());
    }
    
    @Override
    public int getItemCount(){
        if(datas != null){
            return datas.size();
        }
        return 0;
    }
    
    @Override
    public void onClick(View v){
        if(onItemClickListener != null){
            int position = (int) v.getTag();
            CategroyEntity entity = datas.get(position);
            onItemClickListener.onItemClick(v,position,entity);
        }
    }

    public class RightViewHolder extends  RecyclerView.ViewHolder{

        public final TextView tv_name;
        public final ImageView iv_image;

        public RightViewHolder(View itemView){
            super(itemView);
            iv_image = itemView.findViewById(R.id.iv_image);
            tv_name = itemView.findViewById(R.id.tv_name);
        }
    }

    public void setOnItemClickListener(OnItemClickListener l){
        this.onItemClickListener = l;
    }

    public interface OnItemClickListener{
        void onItemClick(View view,int position,CategroyEntity entity);
    }
    
}
