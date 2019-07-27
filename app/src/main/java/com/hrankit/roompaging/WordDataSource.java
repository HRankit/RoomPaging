package com.hrankit.roompaging;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

public class WordDataSource extends PageKeyedDataSource<Long, Word> {
    @Override
    public void loadInitial(@NonNull LoadInitialParams<Long> params, @NonNull LoadInitialCallback<Long, Word> callback) {

    }

    @Override
    public void loadBefore(@NonNull LoadParams<Long> params, @NonNull LoadCallback<Long, Word> callback) {

    }

    @Override
    public void loadAfter(@NonNull LoadParams<Long> params, @NonNull LoadCallback<Long, Word> callback) {

    }
}
