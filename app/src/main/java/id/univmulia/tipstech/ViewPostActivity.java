package id.univmulia.tipstech;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ViewPostActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private PostAdapter mAdapter;

    private ProgressBar progressBar;

    private DatabaseReference mDatabaseRef;
    private List<ModelUpload> mModelUploads;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_post);

        mRecyclerView=findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        progressBar=findViewById(R.id.progress_circular);

        mModelUploads =new ArrayList<>();
        mDatabaseRef= FirebaseDatabase.getInstance().getReference("uploads");
        mDatabaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot postSnapshot:dataSnapshot.getChildren())
                {
                    ModelUpload modelUpload =postSnapshot.getValue(ModelUpload.class);
                    mModelUploads.add(modelUpload);
                }
                mAdapter=new PostAdapter(ViewPostActivity.this, mModelUploads);
                mRecyclerView.setAdapter(mAdapter);
                progressBar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(ViewPostActivity.this, databaseError.getMessage(), Toast.LENGTH_LONG).show();
                progressBar.setVisibility(View.INVISIBLE);
            }
        });
    }
}
