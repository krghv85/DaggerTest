package com.tradexl.daggertest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.tradexl.daggertest.model.Post;
import com.tradexl.daggertest.util.MySharedPreferences;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Inject
    Retrofit retrofit;
    TextView textView;
    @Inject
    MySharedPreferences mySharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((App) getApplication()).getNetComponent().inject(this);

        mySharedPreferences.putData("info", 10);
        int data = mySharedPreferences.getData("info");
        Toast.makeText(MainActivity.this, data + "", Toast.LENGTH_SHORT).show();
        textView = (TextView) findViewById(R.id.textview_post);
        setApiCall();
    }

    private void setApiCall() {
        Call<Post> call = retrofit.create(Restapi.class).getAnswerData();
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                Toast.makeText(MainActivity.this, response.body().getItems().get(0).getOwner().getDisplayName().toString(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Toast.makeText(MainActivity.this, "onFailure", Toast.LENGTH_SHORT).show();

            }
        });
    }

}
