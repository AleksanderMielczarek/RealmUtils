package com.github.aleksandermielczarek.realmutils.migration;

import io.realm.DynamicRealm;
import io.realm.RealmSchema;

/**
 * Created by Aleksander Mielczarek on 11.11.2016.
 */

public interface Migration {

    void migrate(DynamicRealm realm, RealmSchema schema);

}
