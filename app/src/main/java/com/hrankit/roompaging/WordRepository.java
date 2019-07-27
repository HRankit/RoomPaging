package com.hrankit.roompaging;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;

import java.util.List;

public class WordRepository {

    private final DataSource.Factory<Integer, Word> mFewWords;
    private WordDao mWordDao;
    private LiveData<List<Word>> mAllWords;

    public WordRepository(Application application) {
        WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
        mWordDao = db.wordDao();
        mAllWords = mWordDao.getAllWords();

        mFewWords = mWordDao.getFewWords();
    }

    public LiveData<List<Word>> getAllWords() {
        return mAllWords;
    }

    public DataSource.Factory<Integer, Word> getFewWords() {
        return mFewWords;
    }


    public void insert(Word word) {
        new insertAsyncTask(mWordDao).execute(word);
    }

    private static class insertAsyncTask extends AsyncTask<Word, Void, Void> {

        private WordDao mAsyncTaskDao;

        insertAsyncTask(WordDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Word... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}