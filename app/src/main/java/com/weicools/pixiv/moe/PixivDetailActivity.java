package com.weicools.pixiv.moe;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.github.chrisbanes.photoview.PhotoView;

/**
 * @author Weicools
 *
 * A login screen that offers login via email/password.
 */
public class PixivDetailActivity extends AppCompatActivity {
  public static final String ARG_LARGE_URL = "arg_large_url";
  @BindView(R.id.toolbar) Toolbar mToolbar;
  @BindView(R.id.iv_large_picture) PhotoView mIvLargePicture;

  private String mLargeImgUrl;

  public static void start (Context context, String largeImgUrl) {
    Intent intent = new Intent(context, PixivDetailActivity.class);
    intent.putExtra(ARG_LARGE_URL, largeImgUrl);
    context.startActivity(intent);
  }

  @Override
  protected void onCreate (Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_pixiv_detail);
    ButterKnife.bind(this);

    setSupportActionBar(mToolbar);
    mLargeImgUrl = getIntent().getStringExtra(ARG_LARGE_URL);

    RequestOptions options =
        new RequestOptions().placeholder(R.drawable.img_place_miku).error(R.drawable.img_load_error);
    Glide.with(this).load(mLargeImgUrl).apply(options).into(mIvLargePicture);
  }

  @Override
  public boolean onCreateOptionsMenu (Menu menu) {
    getMenuInflater().inflate(R.menu.pixiv_detail, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected (MenuItem item) {
    switch (item.getItemId()) {
      case R.id.menu_save:
        // TODO: 2018/7/11 download
        Toast.makeText(this, "download moe", Toast.LENGTH_SHORT).show();
        break;
      default:
        break;
    }
    return super.onOptionsItemSelected(item);
  }
}
