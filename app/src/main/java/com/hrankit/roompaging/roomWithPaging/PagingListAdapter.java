package com.hrankit.roompaging.roomWithPaging;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.hrankit.roompaging.R;
import com.hrankit.roompaging.Word;

public class PagingListAdapter extends PagedListAdapter<Word, PagingListAdapter.WordViewHolder> {

    private LayoutInflater mInflater;


    PagingListAdapter(Context context) {
        super(DIFF_CALLBACK);
        this.mInflater = LayoutInflater.from(context);

    }


    class WordViewHolder extends RecyclerView.ViewHolder {
        private final TextView wordItemView;
        private final TextView definitionItemView;

        private WordViewHolder(View itemView) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.textView);
            definitionItemView = itemView.findViewById(R.id.definition);

        }

        void bindTo(Word word) {
            this.wordItemView.setText(word.getWord());
            this.definitionItemView.setText(word.getDefinition());
        }

        void clear() {
            this.wordItemView.setText("No Word");
            this.definitionItemView.setText("");
        }
    }


    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new WordViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder,
                                 int position) {
        Word word = getItem(position);
        if (word != null) {
            holder.bindTo(word);
        } else {
            holder.clear();
        }
    }


    @Override
    public int getItemCount() {
        return super.getItemCount();
    }

    private static DiffUtil.ItemCallback<Word> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<Word>() {
                // Concert details may have changed if reloaded from the database,
                // but ID is fixed.
                @Override
                public boolean areItemsTheSame(Word oldConcert, Word newConcert) {
                    return oldConcert.getWord().equals(newConcert.getWord());
                }

                @SuppressLint("DiffUtilEquals")
                @Override
                public boolean areContentsTheSame(Word oldConcert,
                                                  @NonNull Word newConcert) {
                    return oldConcert.equals(newConcert);
                }
            };

}