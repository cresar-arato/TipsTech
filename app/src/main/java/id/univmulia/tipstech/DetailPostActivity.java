package id.univmulia.tipstech;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

public class DetailPostActivity extends AppCompatActivity {

    private EditText tvtitle,tvdescription;
    private ImageView det_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_post);
        det_view = findViewById(R.id.imgPreview);
        tvtitle = findViewById(R.id.imgTitle);
        tvdescription = findViewById(R.id.imgDescription);

        ModelUpload post = (ModelUpload) getIntent().getSerializableExtra("data");
        if(post!=null){
            det_view.setImageURI(Uri.parse(post.getImgUrl()));
            tvtitle.setText(post.getImgTitle());
            tvdescription.setText(post.getImgDesc());
        }
    }
    public static Intent getActIntent(Activity mContext) {
        return new Intent(mContext, DetailPostActivity.class);
    }

}
