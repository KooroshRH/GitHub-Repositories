package com.example.githubrepos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RepoAdapter extends RecyclerView.Adapter<RepoAdapter.RepoViewHolder> {
    private List<Repo> repoList;

    public RepoAdapter(List<Repo> repoList) {
        this.repoList = repoList;
    }

    @NonNull
    @Override
    public RepoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view, parent, false);
        return new RepoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RepoViewHolder holder, int position) {
        holder.language.setText(repoList.get(position).getLanguage());
        holder.repoName.setText(repoList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return repoList.size();
    }

    public static class RepoViewHolder extends RecyclerView.ViewHolder {
        protected TextView repoName;
        protected TextView language;

        public RepoViewHolder(View v) {
            super(v);
            repoName =  (TextView) v.findViewById(R.id.repoName);
            language = (TextView)  v.findViewById(R.id.language);
        }
    }
}
