package com.github.aleksandermielczarek.realmutilsexample.component;

import com.github.aleksandermielczarek.napkin.module.ActivityModule;
import com.github.aleksandermielczarek.napkin.scope.ActivityScope;
import com.github.aleksandermielczarek.realmutilsexample.ui.MainActivity;

import dagger.Subcomponent;

/**
 * Created by Aleksander Mielczarek on 12.11.2016.
 */
@ActivityScope
@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity mainActivity);
}
