package Notice;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapp20.FullImageView;
import com.example.myapp20.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.NoticeViewAdapter> {
    private Context context;
    private ArrayList<NoticeData> list;

    public NoticeAdapter(Context context, ArrayList<NoticeData> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public NoticeViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.newsfeed_item_layout, parent, false);
        return new NoticeViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoticeViewAdapter holder, @SuppressLint("RecyclerView") int position) {
        NoticeData currentItems = list.get(position);
        holder.Desc.setText(currentItems.getTitle());
        holder.date.setText(currentItems.getDate());
        holder.time.setText(currentItems.getTime());

        try {
            if (currentItems.getImage() != null) {
                Picasso.get().load(currentItems.getImage()).into(holder.imageView);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(context, FullImageView.class);
                intent.putExtra("image",currentItems.getImage());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class NoticeViewAdapter extends RecyclerView.ViewHolder {
        private TextView notice, Desc, date, time;
        private ImageView imageView;
        CircleImageView image;

        public NoticeViewAdapter(@NonNull View itemView) {
            super(itemView);
            notice = itemView.findViewById(R.id.noticeTv);
            image = itemView.findViewById(R.id.CircleImg);
            Desc = itemView.findViewById(R.id.userNoticeTitle);
            imageView = itemView.findViewById(R.id.userNoticeImage);
            date = itemView.findViewById(R.id.date);
            time = itemView.findViewById(R.id.time);

        }
    }

}
