package com.indian.uttara.electrical.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.indian.uttara.BaseActivity;
import com.indian.uttara.R;
import com.indian.uttara.api.model.ServicesRepo;
import com.indian.uttara.common.Constants;
import com.indian.uttara.common.database.DbHelper;
import com.indian.uttara.common.ui.RecyclerTouchListener;
import com.indian.uttara.common.ui.ServicesListRecycleAdapter;
import com.indian.uttara.electrical.model.Services;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vivekathreya on 9/4/2016.
 */
public class ElectricalActivity extends BaseActivity {

    private List<ServicesRepo> servicesList = new ArrayList<>();
    private Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = ElectricalActivity.this;
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.servicesRecyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(context, 2));
        servicesList= new DbHelper(context).getServicesList(Constants.ELECTRICAL_SERVICE);
        ServicesListRecycleAdapter servicesListAdapter = new ServicesListRecycleAdapter(context, servicesList);
//        RecyclerView.ItemDecoration itemDecoration = new
//                DividerItemDecoration(ElectricalActivity.this, GridLayoutManager.VERTICAL);
//        recyclerView.addItemDecoration(itemDecoration);
        recyclerView.setAdapter(servicesListAdapter);
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(context, recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                ServicesRepo services = servicesList.get(position);
                Intent intent = new Intent(context,ElectricalServiceDetail.class);
                intent.putExtra(Constants.SERVICE_NAME,services.getServiceName());
                intent.putExtra(Constants.SERVICE_AVL_QNT,services.getServiceAvlQnt());
                intent.putExtra(Constants.SERVICE_PRICE,services.getServicePrice());
                intent.putExtra(Constants.SERVICE_LONG_DESCRIPTION,services.getServiceLDecp());
                intent.putExtra(Constants.SERVICE_SHORT_DESCRIPTION,services.getServiceSDecp());
                intent.putExtra(Constants.SERVICE_SPEC,services.getServiceSpec());
                startActivity(intent);
            }
        }));
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.electrical;
    }

    @Override
    protected String pageTitle() {
        return getString(R.string.electrical_name);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        LayoutInflater inflater = LayoutInflater.from(this);
//        View view = inflater.inflate(R.layout.cart_badge_count, null);
//        MenuItem menuItem = menu.findItem(R.id.action_cart);
//        menuItem.setIcon(buildCounterDrawable(500, R.drawable.ic_action_cart, view));
//        return true;
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case android.R.id.home:
//                finish();
//                break;
//        }
        return super.onOptionsItemSelected(item);
    }

    private void displayServicesList() {
        DbHelper dbHelper = new DbHelper(ElectricalActivity.this);
        List<ServicesRepo> productDbs = dbHelper.getServicesList(Constants.ELECTRICAL_SERVICE);
        ArrayList<Services> serviceList = new ArrayList<>();

        for (int i = 0; i < productDbs.size(); i++) {
            serviceList.add(new Services(productDbs.get(i).getServiceName(), productDbs.get(i).getServiceSDecp(),
                    productDbs.get(i).getServicePrice(), productDbs.get(i).getServiceLDecp()));
        }

    }



}
