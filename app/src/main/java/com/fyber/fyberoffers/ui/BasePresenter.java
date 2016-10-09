package com.fyber.fyberoffers.ui;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Created by Hend-PC on 10/7/2016.
 */

public interface BasePresenter<T> {

    void setView(T view);

    void clearView();
}
