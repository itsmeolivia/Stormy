package com.itsmeolivia.stormy.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.itsmeolivia.stormy.R;
import com.itsmeolivia.stormy.weather.Day;

/**
 * Created by olivia on 7/21/15.
 */
public class DayAdapter extends BaseAdapter {

    public static final String TAG = "";

    private Context mContext;
    private Day[] mDays;

    public DayAdapter(Context context, Day[] days) {
        mContext = context;
        mDays = days;
    }

    @Override
    public int getCount() {
        return mDays.length;
    }

    @Override
    public Object getItem(int position) {
        return mDays[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {

            convertView = LayoutInflater.from(mContext).inflate(R.layout.daily_list_item, null);
            holder = new ViewHolder();
            holder.iconImageView = (ImageView) convertView.findViewById(R.id.iconImageView);
            holder.temperatureLabel = (TextView) convertView.findViewById(R.id.temperatureLabel);
            holder.dayLabel  = (TextView) convertView.findViewById(R.id.dayLabel);

            convertView.setTag(holder);

        }

        else {
            holder = (ViewHolder) convertView.getTag();
        }

        Day day = mDays[position];

        holder.iconImageView.setImageResource(day.getIconId());
        try { holder.temperatureLabel.setText(day.getTemperatureMax() + "");
        } catch (Exception e){ Log.e(TAG, "Fatal Exception", e); }

        holder.dayLabel.setText(day.getDayOfWeek());


        return convertView;
    }

    private static class ViewHolder {

        TextView dayLabel;
        TextView temperatureLabel;
        ImageView iconImageView;

    }
}
