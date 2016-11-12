package com.github.aleksandermielczarek.realmutilsexample.module;

import com.github.aleksandermielczarek.napkin.scope.AppScope;
import com.github.aleksandermielczarek.realmutils.module.RealmUtilsModule;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Aleksander Mielczarek on 12.11.2016.
 */
@Module
@AppScope
public class MainModule {

    @Provides
    RealmConfiguration provideRealmConfiguration() {
        return new RealmConfiguration.Builder()
                .modules(Realm.getDefaultModule(), new RealmUtilsModule())
                .build();
    }
}
