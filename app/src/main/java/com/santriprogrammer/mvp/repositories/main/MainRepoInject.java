package com.santriprogrammer.mvp.repositories.main;

import android.content.Context;
import com.santriprogrammer.mvp.repositories.main.remote.MainActivityDataRemote;

/**
 * Created by fikriimaduddin on 9/27/17.
 */

public class MainRepoInject {
  public static MainActivityRepositories provideToMainRepo(Context context){
    return new MainActivityRepositories(new MainActivityDataRemote(context));
  }
}

