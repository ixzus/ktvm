package com.ixzus.ktvm.helper.annotation;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static com.ixzus.ktvm.helper.annotation.EmptyState.EMPTY_ARTICLE;
import static com.ixzus.ktvm.helper.annotation.EmptyState.EMPTY_CODE;
import static com.ixzus.ktvm.helper.annotation.EmptyState.EMPTY_COLLECT;
import static com.ixzus.ktvm.helper.annotation.EmptyState.EMPTY_SEARCH;
import static com.ixzus.ktvm.helper.annotation.EmptyState.NORMAL;

@IntDef({NORMAL, EMPTY_ARTICLE, EMPTY_CODE, EMPTY_SEARCH, EMPTY_COLLECT})

@Retention(RetentionPolicy.SOURCE)
public @interface EmptyState {
    int NORMAL = 0;
    int EMPTY_ARTICLE = 1;
    int EMPTY_CODE = 2;
    int EMPTY_SEARCH = 3;
    int EMPTY_COLLECT = 4;

}