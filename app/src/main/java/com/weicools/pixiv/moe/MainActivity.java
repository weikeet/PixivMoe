package com.weicools.pixiv.moe;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.weicools.pixiv.moe.api.PixivMoeClient;
import com.weicools.pixiv.moe.data.Works;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.util.List;

/**
 * @author weicools
 */
public class MainActivity extends AppCompatActivity {
  private static final String TAG = "MainActivity";

  @BindView(R.id.recycler_view) RecyclerView mRecyclerView;
  private RankingAdapter mAdapter;
  private CompositeDisposable mDisposable;

  private ProgressDialog mProgressDialog;

  @Override
  protected void onCreate (Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);

    mDisposable = new CompositeDisposable();
    mAdapter = new RankingAdapter(this);
    RecyclerView.LayoutManager manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
    mRecyclerView.setLayoutManager(manager);
    mRecyclerView.setAdapter(mAdapter);

    mProgressDialog = new ProgressDialog(this);
    mProgressDialog.setMessage(getString(R.string.dialog_progress_title));
    mProgressDialog.show();
    mDisposable.add(PixivMoeClient.getInstance()
        .getMoeApi()
        .getRankingList(1)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(rankingData -> {
          mProgressDialog.dismiss();
          List<Works> dataList = rankingData.getResponse().getWorks();
          mAdapter.updateWorkList(dataList);
        }, throwable -> {
          mProgressDialog.dismiss();
          Toast.makeText(MainActivity.this, "Moe moe moe...", Toast.LENGTH_SHORT).show();
          Log.e(TAG, "accept: " + throwable.getMessage());
        }));
  }

  @Override
  protected void onDestroy () {
    mDisposable.dispose();
    super.onDestroy();
  }
}
