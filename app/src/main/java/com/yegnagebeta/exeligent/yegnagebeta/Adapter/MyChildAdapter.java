package com.yegnagebeta.exeligent.yegnagebeta.Adapter;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.aakira.expandablelayout.ExpandableLinearLayout;
import com.yegnagebeta.exeligent.yegnagebeta.Interface.ItemClickListner;
import com.yegnagebeta.exeligent.yegnagebeta.R;

import java.util.ArrayList;

/**
 * Created by voodoo on 2/28/2018.
 */

class ChildAdapteHOlder extends RecyclerView.ViewHolder{


    private ItemClickListner itemClickListner;
    TextView content;
     FloatingActionButton fab;




    public ChildAdapteHOlder(View itemView) {
        super(itemView);


        content=(TextView) itemView.findViewById(R.id.packagetxt);

    }

    public void setItemClickListner(ItemClickListner itemClickListner) {
        this.itemClickListner = itemClickListner;
    }

}

public class MyChildAdapter extends RecyclerView.Adapter<AdapteHOlder> {

    private Context context;
    private ArrayList<String> content;
    private LayoutInflater inflater;





    public MyChildAdapter(Context context, ArrayList<String> content) {
        this.context = context;
        this.content = content;
        inflater=LayoutInflater.from(context);

    }

    @Override
    public AdapteHOlder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemview = inflater.inflate(R.layout.menu_child, parent, false);

        return new AdapteHOlder(itemview);
    }

    @Override
    public void onBindViewHolder(final AdapteHOlder holder, final int position) {

        holder.titleAmh.setText(content.get(position));







    }
    @Override
    public int getItemCount() {
        Log.i("size", String.valueOf(content.size()));
        return content.size();

    }

    public BitmapDrawable BgCenter(int rid){
        Bitmap bgBit= BitmapFactory.decodeResource(context.getResources(),rid);
        BitmapDrawable bgDrawable=new BitmapDrawable(context.getResources(),bgBit);
        bgDrawable.setGravity(Gravity.CENTER);

        //bgDrawable.setColorFilter(new PorterDuffColorFilter(Color., PorterDuff.Mode.SRC_ATOP));
        return  bgDrawable;

    }
}
