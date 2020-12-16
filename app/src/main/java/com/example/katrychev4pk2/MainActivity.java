package com.example.katrychev4pk2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static com.example.katrychev4pk2.UserStaticInfo.POSITION;
import static com.example.katrychev4pk2.UserStaticInfo.users;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    Context context;
    LayoutInflater layoutInflater;
    //список пользователей

   UserListAdapter userListAdapter;
   FrameLayout UserPanel;
   TextView NameTextView,StateTextView,AgeTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new UserStaticInfo();
        Init();
    }



    private void Init() {
        UserPanel=findViewById(R.id.userPanel);
        NameTextView=findViewById(R.id.StateTextView);
        StateTextView=findViewById(R.id.AgeTextView);
        AgeTextView=findViewById(R.id.AgeTextView);
        listView=findViewById(R.id.listView);
        context=this;
        layoutInflater=LayoutInflater.from(context);
        userListAdapter=new UserListAdapter();
        listView.setAdapter(userListAdapter);
    }
    public void GoToUsersProfile(int position)
    {
        Intent intent=new Intent(context,UserActivity.class);
        intent.putExtra(POSITION,position);
        startActivity(intent);
    }
    

    public void BackToList(View view) {
        UserVisibility(false);
    }

    private void UserVisibility(boolean visible) {
        if(visible)
            UserPanel.setVisibility(View.VISIBLE);
        else
            UserPanel.setVisibility(View.GONE);

    }


    private class UserListAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return users.size();
        }

        @Override
        public User getItem(int position) {
            return users.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            User currentUser=getItem(position);
            convertView=layoutInflater.inflate(R.layout.item_user,parent,false);


            TextView nameView=convertView.findViewById(R.id.NameTextView);

            TextView stateView=convertView.findViewById(R.id.StateTextView);

            FrameLayout StateRound=convertView.findViewById(R.id.StateRound);
            switch (currentUser.getStateSignal())
            {
                case 0:
                    StateRound.setBackgroundResource(R.drawable.back_offline);
                    break;
                case 1:
                    StateRound.setBackgroundResource(R.drawable.back_online);
                    break;
                case 2:
                    StateRound.setBackgroundResource(R.drawable.back_departed);
                    break;
            }


            nameView.setText(currentUser.getName());
            stateView.setText(currentUser.getState());



            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    InitPanel(getItem(position));
                    UserVisibility(true);

                }
            });

            return  convertView;

        }
    }


    private void InitPanel(User item) {
        NameTextView.setText(item.getName());
        StateTextView.setText(item.getState());
        AgeTextView.setText(String.valueOf(item.getAge()));
    }
}