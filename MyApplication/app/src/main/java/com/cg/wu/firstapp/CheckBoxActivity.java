package com.cg.wu.firstapp;

import android.app.AlertDialog;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class CheckBoxActivity extends ActionBarActivity {

    private CheckBox cbEat;
    private CheckBox cbSport;
    private CheckBox cbSleep;
    private CheckBox cbAll;

    private EditText txtName;
    private Button btnShow;

    private RadioGroup rgGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);

        cbEat = (CheckBox)this.findViewById(R.id.cbEat);
        cbSport = (CheckBox)this.findViewById(R.id.cbSport);
        cbSleep = (CheckBox)this.findViewById(R.id.cbSleep);
        cbAll = (CheckBox)this.findViewById(R.id.cbAll);

        txtName = (EditText) findViewById(R.id.txtName);
        btnShow = (Button)findViewById(R.id.btnShow);

        rgGender = (RadioGroup)findViewById(R.id.rgGender);

        cbAll.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                cbEat.setChecked(isChecked);
                cbSport.setChecked(isChecked);
                cbSleep.setChecked(isChecked);
            }
        });

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = txtName.getText().toString();
                //Toast.makeText(CheckBoxActivity.this,name,Toast.LENGTH_LONG).show();

                new AlertDialog.Builder(CheckBoxActivity.this)
                        .setTitle("标题")
                        .setMessage(name)
                        .setPositiveButton("确定", null)
                        .show();
            }
        });

        rgGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.i("RadioGroup",checkedId + "");
                Log.i("RadioGroup", ((RadioButton)findViewById(checkedId)).getText().toString() );

                if(checkedId == R.id.rbMale){
                    Toast.makeText(CheckBoxActivity.this,"男",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(CheckBoxActivity.this,"女",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_check_box, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
