package com.example.experiment5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
  public  static final int UPDATE_TEXT =1;
  private TextView text;
  private Handler handler = new Handler(){
      public  void handleMessage(Message message){
          switch (message.what){
              case UPDATE_TEXT:
                  text.setText("2019年11月18日周一晚上");
                  break;
                  default:break;
          }
      }
  };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.change_text);
        text = (TextView) findViewById(R.id.text);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Message message=new Message();
                        message.what=UPDATE_TEXT;
                        handler.sendMessage(message);
                    }
                }).start();
            }
        });
    }
}
