package com.developer.corson.patchdatafromstudentsys;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.developer.corson.patchdatafromstudentsys.utils.SplashView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{



    private ImageView mImageView;
    private EditText userEditText;
    private EditText pwdEditText;
    private Button bt_login;
    private LinearLayout aninLinearLayout;
    private Animation mAnimation;
    private SplashView splashView;
    private FrameLayout mFrameLayout;
    private Dialog mDialog;

    private String username;
    private String pwd;

    Context context;


    /**
     * date:2016/4/29
     *
     * Author:Corson
     *
     * */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        context = this;

        initView();
        setListener();
    }

    private void initView() {

        mImageView   = (ImageView)findViewById(R.id.iv_more_user);
        userEditText = (EditText)findViewById(R.id.et_username);
        pwdEditText  = (EditText)findViewById(R.id.et_pwd);

        aninLinearLayout = (LinearLayout)findViewById(R.id.login_info_layout);
        mAnimation = AnimationUtils.loadAnimation(this, R.anim.login_translate);

        initWaitDlg();


    }

    private void initWaitDlg() {
        mFrameLayout = new FrameLayout(context);

        splashView = new SplashView(context);

        mFrameLayout.addView(splashView);

        mDialog = new Dialog(context, R.style.loginDlg);

        Window window = mDialog.getWindow();
        WindowManager.LayoutParams params = window.getAttributes();



        mDialog.addContentView(mFrameLayout, params);

        mDialog.setCanceledOnTouchOutside(true);

    }

    private void setListener() {

        userEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                username = s.toString();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        pwdEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                pwd = s.toString();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        mImageView.setOnClickListener(this);
        bt_login.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.bt_login:
                if(username != null && "".equals(username))
                    Toast.makeText(context, "账号不能为空！", Toast.LENGTH_SHORT);
                else if(pwd != null && "".equals(pwd))
                    Toast.makeText(context, "密码不能为空！", Toast.LENGTH_SHORT);
                else
                {
                    boolean isSave = true;

                }
                break;
            case R.id.iv_more_user:
                break;
        }

    }
}
