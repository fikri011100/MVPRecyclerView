package com.santriprogrammer.mvp.repositories;

import android.content.Context;

/**
 * Created by fikriimaduddin on 10/2/17.
 */

public class PerkatRepoInject {

  public static PerkatRepositories provideToPerkatRepo(Context c){
    return new PerkatRepositories(new PerkatDataRemote(c));
  }
}
