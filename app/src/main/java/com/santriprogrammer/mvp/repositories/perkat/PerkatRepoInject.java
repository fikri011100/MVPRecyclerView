package com.santriprogrammer.mvp.repositories.perkat;

import android.content.Context;
import com.santriprogrammer.mvp.repositories.perkat.remote.PerkatDataRemote;

/**
 * Created by fikriimaduddin on 10/2/17.
 */

public class PerkatRepoInject {

  public static PerkatRepositories provideToPerkatRepo(Context c){
    return new PerkatRepositories(new PerkatDataRemote(c));
  }
}
