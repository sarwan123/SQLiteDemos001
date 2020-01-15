package id.ac.poliban.mi.sarwan.sqlitedemos001;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import id.ac.poliban.mi.sarwan.sqlitedemos001.adapter.FriendAdapter;
import id.ac.poliban.mi.sarwan.sqlitedemos001.dao.Impl.FriendDaoImplSQLite;
import id.ac.poliban.mi.sarwan.sqlitedemos001.domain.Friend;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvFriend;
    private List<Friend> data = new ArrayList<>();
    private FriendDaoImplSQLite db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if(getSupportActionBar()!=null){
            getSupportActionBar().setTitle("SQLite Demo");
            getSupportActionBar().setSubtitle("Sarwan Studios");         }

        db = new FriendDaoImplSQLite(this);
        rvFriend = findViewById(R.id.rv_friend);     }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.action_tambah)
            startActivity(new Intent(this, DetailActivity.class));
        return super.onOptionsItemSelected(item);     }

    @Override
    protected void onResume() {
        super.onResume();
        showDataOnRecyclerView();     }

    private void showDataOnRecyclerView() {
        if(db.getAllFriends().size()>0){
            data.clear();
            data.addAll(db.getAllFriends());
            rvFriend.setLayoutManager(new LinearLayoutManager(this));
            FriendAdapter friendRVAdapter = new FriendAdapter(data);
            rvFriend.setAdapter(friendRVAdapter);
            rvFriend.setHasFixedSize(true);
        }
    }
}
