package com.github.aleksandermielczarek.realmutilsexample.component;

import com.github.aleksandermielczarek.napkin.module.ActivityModule;
import com.github.aleksandermielczarek.napkin.module.AppModule;
import com.github.aleksandermielczarek.napkin.scope.AppScope;
import com.github.aleksandermielczarek.realmutilsexample.RealmUtilsApplication;
import com.github.aleksandermielczarek.realmutilsexample.module.MainModule;

import dagger.Component;

/**
 * Created by Aleksander Mielczarek on 12.11.2016.
 */
@AppScope
@Component(modules = {AppModule.class, MainModule.class})
public interface AppComponent {

    void inject(RealmUtilsApplication realmUtilsApplication);

    ActivityComponent with(ActivityModule activityModule);
}
