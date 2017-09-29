package com.santriprogrammer.mvp.remote;

import android.content.Context;

/**
 * Created by fikriimaduddin on 9/27/17.
 */

public class MainRepoInject {
  public static MainActivityRepositories provideToMainRepo(Context context){
    return new MainActivityRepositories(new MainActivityDataRemote(context));
  }
}

