package com.yegnagebeta.exeligent.yegnagebeta.Adapter;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
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

class RechargeAdapterHolder extends RecyclerView.ViewHolder{


    private ItemClickListner itemClickListner;
    TextView titleAmh, titleEn;
    ImageView icon;
    LinearLayout container;





    public RechargeAdapterHolder(View itemView) {
        super(itemView);

        titleAmh=(TextView) itemView.findViewById(R.id.title_amh);
        titleEn=(TextView) itemView.findViewById(R.id.title_en);
        icon=(ImageView) itemView.findViewById(R.id.menu_icon);
        container=(LinearLayout) itemView.findViewById(R.id.container);

    }

    public void setItemClickListner(ItemClickListner itemClickListner) {
        this.itemClickListner = itemClickListner;
    }

}

public class MyRechargeAdapter extends RecyclerView.Adapter<RechargeAdapterHolder> {

    private Context context;
    private ArrayList<String> titlesAmh;
    private ArrayList<String> titlesEn;
    private ArrayList<Integer> images;

    public MyRechargeAdapter(Context context, ArrayList<String> titlesAmh, ArrayList<String> titlesEn, ArrayList<Integer> images) {
        this.context = context;
        this.titlesAmh = titlesAmh;
        this.titlesEn = titlesEn;
        this.images = images;
        this.inflater = inflater;
        inflater=LayoutInflater.from(context);

    }

    private LayoutInflater inflater;


    ObjectAnimator anim;
    int rotationAngle=0;



    @Override
    public RechargeAdapterHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemview = inflater.inflate(R.layout.recharge_layout, parent, false);

        return new RechargeAdapterHolder(itemview);
    }

    @Override
    public void onBindViewHolder(final RechargeAdapterHolder holder, final int position) {

        holder.titleAmh.setText(titlesAmh.get(position));
        holder.titleEn.setText(titlesEn.get(position));
        holder.icon.setImageDrawable(BgCenter(images.get(position)));



        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               //to do when clicked

            }
        });




    }
    @Override
    public int getItemCount() {

        return titlesAmh.size();

    }

    public BitmapDrawable BgCenter(int rid){
        Bitmap bgBit= BitmapFactory.decodeResource(context.getResources(),rid);
        BitmapDrawable bgDrawable=new BitmapDrawable(context.getResources(),bgBit);
        bgDrawable.setGravity(Gravity.CENTER);

        //bgDrawable.setColorFilter(new PorterDuffColorFilter(Color., PorterDuff.Mode.SRC_ATOP));
        return  bgDrawable;

    }
}
