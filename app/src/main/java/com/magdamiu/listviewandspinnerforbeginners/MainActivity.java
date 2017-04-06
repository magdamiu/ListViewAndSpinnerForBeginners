package com.magdamiu.listviewandspinnerforbeginners;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.magdamiu.listviewandspinnerforbeginners.adapter.CompanyAdapter;
import com.magdamiu.listviewandspinnerforbeginners.model.Company;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Spinner mLettersSpinner;
    private ListView mCompaniesListView;

    private String[] mDigits;
    private List<Company> mCompaniesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLettersSpinner = (Spinner) findViewById(R.id.sp_digits);
        mCompaniesListView = (ListView) findViewById(R.id.lv_companies);

        addDigitsOnSpinner(10);

        setCompanies(17);
    }

    private void addDigitsOnSpinner(int size) {
        mDigits = new String[size];
        for (int i = 0; i < size; i++) {
            mDigits[i] = i + "";
        }
        setSpinnerAdapter();
    }

    private void setSpinnerAdapter() {
        //build the adapter for the spinner
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, mDigits);

        //set the adapter to the spinner
        mLettersSpinner.setAdapter(spinnerAdapter);
    }

    private void setCompanies(int size) {
        mCompaniesList = new ArrayList<>();
        Company company = null;
        for (int i = 0; i < size; i++) {
            company = new Company();
            company.setAddress("Address " + i);
            company.setName("Name " + i);
            mCompaniesList.add(company);
        }

        //setSimpleAdapterForListView();

        setCustomAdapterForListView();
    }

    private void setSimpleAdapterForListView() {
        //build the adapter for the list view
        ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, mDigits);

        //set the adapter to the list view
        mCompaniesListView.setAdapter(listAdapter);
    }

    private void setCustomAdapterForListView() {
        //build the adapter for the list view
        CompanyAdapter companyAdapter = new CompanyAdapter(mCompaniesList, MainActivity.this);

        //set the adapter to the list view
        mCompaniesListView.setAdapter(companyAdapter);
    }

    private void handleItemClick() {
        mCompaniesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "The item from the position " + position + " was clicked!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
