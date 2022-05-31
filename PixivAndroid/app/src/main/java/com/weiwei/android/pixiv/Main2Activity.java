package com.weiwei.android.pixiv;

import android.app.ProgressDialog;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author weicools
 */
public class Main2Activity extends AppCompatActivity {
  private static final String TAG = "MainActivity";

  private RecyclerView mRecyclerView;
  private RankingAdapter mAdapter;
  // private CompositeDisposable mDisposable;

  private ProgressDialog mProgressDialog;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main2);

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
