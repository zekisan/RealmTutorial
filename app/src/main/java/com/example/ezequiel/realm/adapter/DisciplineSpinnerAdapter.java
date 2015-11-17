package com.example.ezequiel.realm.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.example.ezequiel.realm.R;
import com.example.ezequiel.realm.domain.Discipline;

import io.realm.RealmBaseAdapter;
import io.realm.RealmResults;


public class DisciplineSpinnerAdapter extends RealmBaseAdapter<Discipline> implements ListAdapter {

    public DisciplineSpinnerAdapter(Context context, RealmResults<Discipline> realmResults) {
        super(context, realmResults, false);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CustomViewHolder holder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_discipline_spinner, parent, false);
            holder = new CustomViewHolder();
            convertView.setTag(holder);

            holder.tvName = (TextView) convertView.findViewById(R.id.tv_name);
        } else {
            holder = (CustomViewHolder) convertView.getTag();
        }

        final Discipline d = realmResults.get(position);
        holder.tvName.setText(d.getName());

        return convertView;
    }

    private static class CustomViewHolder {
        TextView tvName;
    }
}
