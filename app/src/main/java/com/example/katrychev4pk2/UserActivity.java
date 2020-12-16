package com.example.katrychev4pk2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static com.example.katrychev4pk2.UserStaticInfo.POSITION;
import static com.example.katrychev4pk2.UserStaticInfo.users;

public class UserActivity extends AppCompatActivity {
    EditText NameTextView,StateTextView,AgeTextView;
    private User activeUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        int position=getIntent().getIntExtra(POSITION,0);
        activeUser=users.get(position);
        Init();
        setUserInfo();
    }
    private void setUserInfo(){
        NameTextView.setText(activeUser.getName());
        StateTextView.setText(activeUser.getState());

    }
    private void Init(){
        NameTextView=findViewById(R.id.NameTextView);
        StateTextView=findViewById(R.id.StateTextView);


    }
    public void Back (View view){
        onBackPressed();
    }

}