package com.indian.uttara.electrical.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.indian.uttara.BaseActivity;
import com.indian.uttara.R;
import com.indian.uttara.common.Constants;

import org.w3c.dom.Text;

/**
 * Created by Vivekathreya on 12/21/2016.
 */
public class ElectricalServiceDetail extends BaseActivity {

    private TextView longDescription;
    private TextView price;
    private TextView requestedQnt;
    private String avlQnt;

    private TextView plus;
    private TextView minus;

    @Override
    protected int getLayoutResourceId() {
        return R.layout.service_details;
    }

    @Override
    protected String pageTitle() {
        return  getIntent().getStringExtra(Constants.SERVICE_NAME);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init(){
        longDescription=(TextView) findViewById(R.id.serviceDescription) ;
        price = (TextView) findViewById(R.id.price);
        price.setText(getString(R.string.Rs)+" "+getIntent().getStringExtra(Constants.SERVICE_PRICE));
        longDescription.setText(getIntent().getStringExtra(Constants.SERVICE_LONG_DESCRIPTION));
       // getIntent().getStringExtra(Constants.SERVICE_SHORT_DESCRIPTION);
        avlQnt=getIntent().getStringExtra(Constants.SERVICE_AVL_QNT);
    }
}
