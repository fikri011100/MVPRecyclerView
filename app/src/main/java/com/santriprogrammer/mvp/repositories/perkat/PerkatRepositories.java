package com.santriprogrammer.mvp.repositories.perkat;

import android.support.annotation.NonNull;

/**
 * Created by fikriimaduddin on 10/2/17.
 */

public class PerkatRepositories implements PerkatDataResource {

  private PerkatDataResource dataResource;

  public PerkatRepositories(PerkatDataResource dataResource) {
    this.dataResource = dataResource;
  }

  @Override
  public void getPerkatList(String id,@NonNull PerkatDataCallback perkatDataCallback) {
    dataResource.getPerkatList(id,perkatDataCallback);
  }
}
