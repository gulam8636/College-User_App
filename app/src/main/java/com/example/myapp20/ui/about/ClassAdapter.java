package com.example.myapp20.ui.about;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.myapp20.R;

import java.util.List;

public class ClassAdapter extends PagerAdapter {
    private  Context context;
    private List<ClassModel> list;

    public ClassAdapter(Context context, List<ClassModel> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.class_item_layout,container,false);
        ImageView classIcon;
        TextView classTitle,classDesc;
        classIcon=view.findViewById(R.id.classIcon);
        classTitle =view.findViewById(R.id.classTitle);
        classDesc=view.findViewById(R.id.classDesc);
        classIcon.setImageResource(list.get(position).getImage());
        classTitle.setText(list.get(position).getTitle());
        classDesc.setText(list.get(position).getDescription());
        container.addView(view,0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
