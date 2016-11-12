package com.github.aleksandermielczarek.realmutils.migration;

import io.realm.DynamicRealm;
import io.realm.RealmSchema;

/**
 * Created by Aleksander Mielczarek on 12.11.2016.
 */

public class Migration010 implements Migration {
    @Override
    public void migrate(DynamicRealm realm, RealmSchema schema) {
        schema.create("RealmString")
                .addField("value", String.class);
    }
}
