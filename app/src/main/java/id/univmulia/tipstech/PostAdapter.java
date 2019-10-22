package id.univmulia.tipstech;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.List;

import static android.media.CamcorderProfile.get;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ImageViewHolder>{

    private Context mContext;
    private List<Upload> mUploads;

    public PostAdapter(Context context, List<Upload> uploads)
    {
        mContext=context;
        mUploads=uploads;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(mContext).inflate(R.layout.post_item, viewGroup,false);
        return  new ImageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder imageViewHolder, int i) {
        Upload uploadCur=mUploads.get(i);
        imageViewHolder.img_title.setText(uploadCur.getImgTitle());
        imageViewHolder.img_description.setText(uploadCur.getImgDesc());
        imageViewHolder.img_description.setText(uploadCur.getImgDesc());
        Picasso.get()
                .load(uploadCur.getImgUrl())
                .placeholder(R.drawable.google_photos)
                .fit()
                .centerCrop()
                .into(imageViewHolder.image_view);
    }

    @Override
    public int getItemCount() {
        return mUploads.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder {
        public TextView img_title, img_description;
        public ImageView image_view;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            img_title=itemView.findViewById(R.id.img_title);
            img_description=itemView.findViewById(R.id.img_description);
            image_view=itemView.findViewById(R.id.image_view);
        }
    }
}
