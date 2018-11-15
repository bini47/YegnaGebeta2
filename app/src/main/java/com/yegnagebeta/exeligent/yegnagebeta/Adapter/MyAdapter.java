package com.yegnagebeta.exeligent.yegnagebeta.Adapter;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.github.aakira.expandablelayout.ExpandableLinearLayout;
import com.yegnagebeta.exeligent.yegnagebeta.Interface.ItemClickListner;
import com.yegnagebeta.exeligent.yegnagebeta.R;

import java.util.ArrayList;


import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

/**
 * Created by voodoo on 2/28/2018.
 */

class AdapteHOlder extends RecyclerView.ViewHolder{


    private ItemClickListner itemClickListner;
    TextView titleAmh, titleEn,desc;
    ImageView icon;
    ExpandableLinearLayout expandable;
    RelativeLayout childHolder;
    LinearLayout container;
    ImageView arrow;




    public AdapteHOlder(View itemView) {
        super(itemView);

        titleAmh=(TextView) itemView.findViewById(R.id.title_amh);
        titleEn=(TextView) itemView.findViewById(R.id.title_en);
        desc=(TextView) itemView.findViewById(R.id.menu_desc);
        icon=(ImageView) itemView.findViewById(R.id.menu_icon);
        expandable=(ExpandableLinearLayout)itemView.findViewById(R.id.expndablelayout);
        container=(LinearLayout) itemView.findViewById(R.id.container);
        arrow=(ImageView)itemView.findViewById(R.id.arrow);
        childHolder=(RelativeLayout)itemView.findViewById(R.id.childholder);

        Shader textShader=new LinearGradient(0,0,170,0,new int[]{Color.parseColor("#3bb1f4"),Color.parseColor("#db64a7")},
               new float[]{0,1}, Shader.TileMode.CLAMP);

        titleAmh.getPaint().setShader(textShader);
    }

    public void setItemClickListner(ItemClickListner itemClickListner) {
        this.itemClickListner = itemClickListner;
    }

}

public class MyAdapter extends RecyclerView.Adapter<AdapteHOlder> {

    private Context context;
    private ArrayList<String> titlesAmh;
    private ArrayList<String> titlesEn;
    private ArrayList<String> descriptions;
    private ArrayList<Integer> images;
    private LayoutInflater inflater;
    private ArrayList<Integer> arrows;


    ObjectAnimator anim;
    int rotationAngle=0;

    public MyAdapter(Context context, ArrayList<String> titlesAmh, ArrayList<String> titlesEn, ArrayList<String> descriptions, ArrayList<Integer> images, ArrayList<Integer> arrows) {
        this.context = context;
        this.titlesAmh = titlesAmh;
        this.titlesEn = titlesEn;
        this.descriptions = descriptions;
        this.images = images;
        this.arrows=arrows;
        inflater=LayoutInflater.from(context);

    }

    @Override
    public AdapteHOlder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemview = inflater.inflate(R.layout.menu_list_item, parent, false);

        return new AdapteHOlder(itemview);
    }

    @Override
    public void onBindViewHolder(final AdapteHOlder holder, final int position) {

        holder.titleAmh.setText(titlesAmh.get(position));
        holder.titleEn.setText(titlesEn.get(position));
        holder.desc.setText(descriptions.get(position));
        holder.icon.setImageDrawable(BgCenter(images.get(position)));
        holder.arrow.setImageDrawable(BgCenter(arrows.get(position)));

        LinearLayout LL=new LinearLayout(context);
        LL.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        LL.setOrientation(LinearLayout.VERTICAL);




        CardView card = new CardView(context);
        card.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        LL.addView(card);

        TextView text= new TextView(context);
        text.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        LinearLayout.LayoutParams params=(LinearLayout.LayoutParams)text.getLayoutParams();
        params.setMargins(17,3,8,3);
        text.setGravity(Gravity.RIGHT);
        text.setPadding(15,4,8,4);
        params.gravity=Gravity.RIGHT;
        text.setText("haha");
        text.setTextSize(16);
        card.addView(text);



        Button button2 = new Button(context);
        button2.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        button2.setText("texttexttext");
        LL.addView(button2);

        holder.childHolder.addView(LL);





        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                holder.expandable.toggle();
                if(holder.expandable.isExpanded()){


                    anim= ObjectAnimator.ofFloat(holder.arrow,"rotation",180,0 );
                    anim.setDuration(300);
                    anim.start();
                    rotationAngle=0;
                    Log.i("rotation up", String.valueOf(rotationAngle));

                }
                else if(!holder.expandable.isExpanded()){

                    anim= ObjectAnimator.ofFloat(holder.arrow,"rotation",0,180 );
                    anim.setDuration(300);
                    anim.start();
                    rotationAngle=0;



                    Log.i("rotation down", String.valueOf(rotationAngle));


                }

            }
        });




    }
    @Override
    public int getItemCount() {
        Log.i("size", String.valueOf(titlesAmh.size()));
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
