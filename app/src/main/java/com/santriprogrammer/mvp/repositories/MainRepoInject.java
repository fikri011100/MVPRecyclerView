package com.santriprogrammer.mvp.repositories;

import android.content.Context;
import com.santriprogrammer.mvp.repositories.MainActivityDataRemote;

/**
 * Created by fikriimaduddin on 9/27/17.
 */

public class MainRepoInject {
  public static MainActivityRepositories provideToMainRepo(Context context){
    return new MainActivityRepositories(new MainActivityDataRemote(context));
  }
}

