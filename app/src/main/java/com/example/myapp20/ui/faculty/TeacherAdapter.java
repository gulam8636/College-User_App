package com.example.myapp20.ui.faculty;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapp20.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TeacherAdapter extends RecyclerView.Adapter<TeacherAdapter.TeacherViewadapter> {
    private List<TeacherData> list;
    private Context context;

    public TeacherAdapter(List<TeacherData> list, Context context, String category) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public TeacherViewadapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.faculty_item_layout, parent, false);

        return new TeacherViewadapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeacherViewadapter holder, int position) {
        TeacherData item = list.get(position);

        holder.name.setText(item.getName());
        holder.email.setText(item.getEmail());
        holder.post.setText(item.getPost());


        Picasso.get().load(item.getImage()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class TeacherViewadapter extends RecyclerView.ViewHolder {
        private TextView name, email, post;
        private ImageView imageView;

        public TeacherViewadapter(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.teacherName);
            email = itemView.findViewById(R.id.teacherEmail);
            post = itemView.findViewById(R.id.teacherPost);
            imageView = itemView.findViewById(R.id.teacherImg);
        }
    }

}
