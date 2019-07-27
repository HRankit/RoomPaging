package com.hrankit.roompaging;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.DataSource;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import java.util.List;

public class WordViewModel extends AndroidViewModel {

    private WordRepository mRepository;

    private LiveData<List<Word>> mAllWords;

    public LiveData<PagedList<Word>> mFewWords;

    private WordDao wordDao;


    public WordViewModel(Application application) {
        super(application);
        mRepository = new WordRepository(application);
        mAllWords = mRepository.getAllWords();

        DataSource.Factory<Integer, Word> fewWords = mRepository.getFewWords();


        mFewWords = new LivePagedListBuilder<>(
                fewWords, /* page size */ 2).build();
    }

    public LiveData<List<Word>> getAllWords() {
        return mAllWords;
    }



    public void insert(Word word) {
        mRepository.insert(word);
    }




}


