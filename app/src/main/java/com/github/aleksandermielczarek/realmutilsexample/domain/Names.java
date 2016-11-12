package com.github.aleksandermielczarek.realmutilsexample.domain;

import com.github.aleksandermielczarek.realmutils.type.RealmString;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by Aleksander Mielczarek on 12.11.2016.
 */

public class Names extends RealmObject {

    private RealmList<RealmString> names;

    public RealmList<RealmString> getNames() {
        return names;
    }

    public void setNames(RealmList<RealmString> names) {
        this.names = names;
    }
}

