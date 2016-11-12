package com.github.aleksandermielczarek.realmutilsexample;

import android.app.Application;

import com.github.aleksandermielczarek.napkin.ComponentProvider;
import com.github.aleksandermielczarek.napkin.module.AppModule;
import com.github.aleksandermielczarek.realmutilsexample.component.AppComponent;
import com.github.aleksandermielczarek.realmutilsexample.component.DaggerAppComponent;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Aleksander Mielczarek on 12.11.2016.
 */

public class RealmUtilsApplication extends Application implements ComponentProvider<AppComponent> {

    @Inject
    protected RealmConfiguration realmConfiguration;

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(this);

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
        appComponent.inject(this);

        Realm.setDefaultConfiguration(realmConfiguration);
    }

    @Override
    public AppComponent provideComponent() {
        return appComponent;
    }
}
