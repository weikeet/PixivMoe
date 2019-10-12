package com.weicools.pixiv.moe;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.weicools.pixiv.moe.data.Work;
import com.weicools.pixiv.moe.data.Works;
import java.util.ArrayList;
import java.util.List;

/**
 * @author weicools Create on 2018.07.10
 *
 * desc:
 */
public class RankingAdapter extends RecyclerView.Adapter<RankingAdapter.RankingHolder> {

  private Context mContext;
  private List<Works> mWorkList;

  RankingAdapter(Context context) {
    mContext = context;
    mWorkList = new ArrayList<>();
  }

  public void updateWorkList(List<Works> workList) {
    mWorkList = workList;
    notifyDataSetChanged();
  }

  @NonNull
  @Override
  public RankingHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(mContext).inflate(R.layout.item_ranking, parent, false);
    return new RankingHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull RankingHolder holder, int position) {
    final Work work = mWorkList.get(position).getWork();

    holder.mTvAuthorName.setText(work.getUser().getName());

    RequestOptions options =
        new RequestOptions().placeholder(R.drawable.img_place_miku).error(R.drawable.img_load_error);
    Glide.with(mContext).load(work.getImageUrls().getPx128x128()).apply(options).into(holder.mIvPixiv);

    holder.itemView.setOnClickListener(v -> {
      Log.e("zzw", "onBindViewHolder: click++" + position);
      PixivDetailActivity.start(mContext, work.getImageUrls().getLarge());
    });
  }

  @Override
  public int getItemCount() {
    return mWorkList == null ? 0 : mWorkList.size();
  }

  static class RankingHolder extends RecyclerView.ViewHolder {
    ImageView mIvPixiv;
    TextView mTvAuthorName;

    RankingHolder(View itemView) {
      super(itemView);
      mIvPixiv = itemView.findViewById(R.id.iv_pixiv);
      mTvAuthorName = itemView.findViewById(R.id.tv_author_name);
    }
  }
}
