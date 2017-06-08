package com.mmtrain.heinzan.mmtrain;

import android.content.Intent;
import android.support.annotation.IntDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.FacebookSdk;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edit_username;
    EditText edit_password;
    TextView txt_forgot_password;
    TextView txt_register;
    Button btn_login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit_username= (EditText) findViewById(R.id.input_user);
        edit_password= (EditText) findViewById(R.id.input_password);

        txt_forgot_password= (TextView) findViewById(R.id.link_forgot_password);
        txt_forgot_password.setOnClickListener(this);

        txt_register= (TextView) findViewById(R.id.link_no_account);
        txt_register.setOnClickListener(this);

        btn_login= (Button) findViewById(R.id.btn_login);
        btn_login.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.link_forgot_password:
                forgotPassword();
                break;

            case R.id.link_no_account:
                register();
                break;

            case R.id.btn_login:
                userLogin();
                break;


            default:
                break;
        }

    }

    private void forgotPassword() {
        Toast.makeText(getApplicationContext(),"click Forgot Password",Toast.LENGTH_SHORT).show();
    }

    private void register() {

        Intent registerIntent=new Intent(getApplicationContext(),Register.class);
        startActivity(registerIntent);

    }

    private void userLogin() {

        Toast.makeText(getApplicationContext(),"click Login Button",Toast.LENGTH_SHORT).show();
    }
}
