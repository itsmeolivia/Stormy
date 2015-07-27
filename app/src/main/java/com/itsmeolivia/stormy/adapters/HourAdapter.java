package com.itsmeolivia.stormy.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.itsmeolivia.stormy.R;
import com.itsmeolivia.stormy.weather.Hour;

/**
 * Created by olivia on 7/26/15.
 */
public class HourAdapter extends RecyclerView.Adapter<HourAdapter.HourViewHolder>{

    private Hour[] mHours;

    public HourAdapter(Hour[] hours) {
        mHours = hours;
    }

    @Override
    public HourViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.hourly_list_item, parent, false);
        HourViewHolder viewHolder = new HourViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(HourViewHolder holder, int position) {

        holder.bindHour(mHours[position]);

    }

    @Override
    public int getItemCount() {
        return mHours.length;
    }

    public class HourViewHolder extends RecyclerView.ViewHolder {

        public TextView mTimeLabel;
        public TextView mTemperatureLabel;
        public TextView mSummaryLabel;
        public ImageView mIconImageView;

        public HourViewHolder(View itemView) {
            super(itemView);

            mTimeLabel = (TextView) itemView.findViewById(R.id.timeLabel);
            mTemperatureLabel = (TextView) itemView.findViewById(R.id.temperatureLabel);
            mSummaryLabel = (TextView) itemView.findViewById(R.id.summaryLabel);
            mIconImageView = (ImageView) itemView.findViewById(R.id.iconImageView);

        }

        public void bindHour(Hour hour) {

            mTimeLabel.setText(hour.getHour());
            mTemperatureLabel.setText(hour.getTemperature() + "");
            mSummaryLabel.setText(hour.getSummary());
            mIconImageView.setImageResource(hour.getIconId());

        };
    }
}
