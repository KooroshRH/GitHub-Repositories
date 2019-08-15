package com.example.githubrepos;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends Activity {

    private String username;
    private List<Repo> repoList;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.cardList);
    }

    public void search(View v) {
        EditText userName = findViewById(R.id.username);
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        GitHubRepos gitHubRepos = retrofit.create(GitHubRepos.class);
        Call<List<Repo>> reposCalls = gitHubRepos.listRepos(userName.getText().toString());
        username = userName.getText().toString();
        userName.setText("");
        reposCalls.enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                repoList = response.body();
                recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
                recyclerView.setAdapter(new RepoAdapter(repoList));
                recyclerView.setHasFixedSize(true);
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {
                Toast.makeText(getBaseContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
//    @Override
//    protected void onListItemClick(ListView l, View v, int position, long id) {
//        super.onListItemClick(l, v, position, id);
//        String url = "https://github.com/" + username + "/" + repoList.get(position).getName();
//        Intent i = new Intent(Intent.ACTION_VIEW);
//        i.setData(Uri.parse(url));
//        startActivity(i);
//    }
}
