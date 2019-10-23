package id.univmulia.tipstech;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import static android.media.CamcorderProfile.get;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ImageViewHolder>{

    private Context mContext;
    private List<ModelUpload> mModelUploads;

    public PostAdapter(Context context, List<ModelUpload> modelUploads)
    {
        mContext=context;
        mModelUploads = modelUploads;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(mContext).inflate(R.layout.post_item, viewGroup,false);
        return  new ImageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder imageViewHolder, int i) {
        final String title = mModelUploads.get(i).getImgTitle();
        ModelUpload modelUploadCur = mModelUploads.get(i);
        imageViewHolder.img_title.setText(modelUploadCur.getImgTitle());
        imageViewHolder.img_description.setText(modelUploadCur.getImgDesc());
        Picasso.get()
                .load(modelUploadCur.getImgUrl())
                .placeholder(R.drawable.google_photos)
                .fit()
                .centerCrop()
                .into(imageViewHolder.image_view);
    }

    @Override
    public int getItemCount() {
        return mModelUploads.size();
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
