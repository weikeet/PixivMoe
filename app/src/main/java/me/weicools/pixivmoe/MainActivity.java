package me.weicools.pixivmoe;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.weicools.pixiv.moe.R;
import me.weicools.pixivmoe.api.PixivMoeClient;
import me.weicools.pixivmoe.data.Works;
import java.util.List;
import timber.log.Timber;

/**
 * @author weicools
 */
public class MainActivity extends AppCompatActivity {
  private static final String TAG = "MainActivity";

  private RecyclerView mRecyclerView;
  private RankingAdapter mAdapter;
  // private CompositeDisposable mDisposable;

  private ProgressDialog mProgressDialog;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mRecyclerView = findViewById(R.id.recycler_view);

    // mDisposable = new CompositeDisposable();
    // mAdapter = new RankingAdapter(this);
    // RecyclerView.LayoutManager manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
    // mRecyclerView.setLayoutManager(manager);
    // mRecyclerView.setAdapter(mAdapter);
    //
    // mProgressDialog = new ProgressDialog(this);
    // mProgressDialog.setMessage(getString(R.string.dialog_progress_title));
    // mProgressDialog.show();
    // mDisposable.add(PixivMoeClient.get()
    //     .getMoeApi()
    //     .getRankingList(1)
    //     .subscribeOn(Schedulers.io())
    //     .observeOn(AndroidSchedulers.mainThread())
    //     .subscribe(rankingData -> {
    //       mProgressDialog.dismiss();
    //       List<Works> dataList = rankingData.getResponse().getWorks();
    //       mAdapter.updateWorkList(dataList);
    //     }, throwable -> {
    //       mProgressDialog.dismiss();
    //       Toast.makeText(MainActivity.this, "Moe moe moe...", Toast.LENGTH_SHORT).show();
    //       Timber.e("accept: %s", throwable.getMessage());
    //     }));
  }

  @Override
  protected void onDestroy() {
    // mDisposable.dispose();
    super.onDestroy();
  }
}
