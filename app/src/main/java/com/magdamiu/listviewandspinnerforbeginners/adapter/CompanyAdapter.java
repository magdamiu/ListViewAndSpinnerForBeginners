package com.magdamiu.listviewandspinnerforbeginners.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.magdamiu.listviewandspinnerforbeginners.R;
import com.magdamiu.listviewandspinnerforbeginners.model.Company;

import java.util.List;

/**
 * Created by magdamiu on 06/04/17.
 */

public class CompanyAdapter extends BaseAdapter {
    private List<Company> mCompaniesList;
    private Context mContext;

    public CompanyAdapter(List<Company> mCompaniesList, Context mContext) {
        this.mCompaniesList = mCompaniesList;
        this.mContext = mContext;
    }

    //get the number of the list
    @Override
    public int getCount() {
        if (mCompaniesList == null)
            return 0;
        else
            return mCompaniesList.size();
    }

    //get the object from a specified position
    @Override
    public Object getItem(int position) {
        if (mCompaniesList == null)
            return null;
        else
            return mCompaniesList.get(position);
    }

    //get the item it from a specified position
    @Override
    public long getItemId(int position) {
        return 0;
    }

    //build the view of the item from a specified position
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;
        final int currentPosition = position;
        ViewHolder viewHolder;
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            int layoutId = R.layout.company_item;
            view = layoutInflater.inflate(layoutId, parent, false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "The item from the position " + currentPosition + " was clicked!", Toast.LENGTH_SHORT).show();
            }
        });

        Company company = (Company) getItem(currentPosition);

        viewHolder.mNameTextView.setText(company.getName());
        viewHolder.mAddressTextView.setText(company.getAddress());

        return view;
    }

    class ViewHolder {
        protected TextView mNameTextView;
        protected TextView mAddressTextView;

        public ViewHolder(View view){
            mNameTextView = (TextView) view.findViewById(R.id.tv_name);
            mAddressTextView = (TextView) view.findViewById(R.id.tv_address);
        }
    }
}
