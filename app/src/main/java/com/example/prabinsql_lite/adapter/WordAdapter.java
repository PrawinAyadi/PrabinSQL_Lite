package com.example.prabinsql_lite.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.prabinsql_lite.R;
import com.example.prabinsql_lite.WordDetail;
import com.example.prabinsql_lite.model.Word;

import java.util.List;

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.WordViewHolder> {

    Context context;
    List<Word> wordList;

    public WordAdapter(Context context, List<Word> wordList) {
        this.context = context;
        this.wordList = wordList;
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listword, parent, false);
        return new WordViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, final int position) {
        final Word word = wordList.get(position);
        holder.word.setText(word.getWord());

        holder.word.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, WordDetail.class);
                intent.putExtra("Meaning", word.getMeaning());
                intent.getIntExtra("Id", word.getId());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return wordList.size();
    }

    public class WordViewHolder extends RecyclerView.ViewHolder {
        private TextView word;

        public WordViewHolder(@NonNull View itemView) {
            super(itemView);
            word = itemView.findViewById(R.id.textView);

        }
    }
}

//created by prabin