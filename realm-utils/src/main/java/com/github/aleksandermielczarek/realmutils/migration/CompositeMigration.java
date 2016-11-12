package com.github.aleksandermielczarek.realmutils.migration;

import java.util.ArrayList;
import java.util.List;

import io.realm.DynamicRealm;
import io.realm.RealmConfiguration;
import io.realm.RealmMigration;
import io.realm.RealmSchema;

/**
 * Created by Aleksander Mielczarek on 11.11.2016.
 */

public class CompositeMigration implements RealmMigration {

    private final List<Migration> migrations = new ArrayList<>();

    public void addMigration(Migration migration) {
        migrations.add(migration);
    }

    @Override
    public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {
        RealmSchema schema = realm.getSchema();
        for (int schemaVersion = 0; schemaVersion < migrations.size(); schemaVersion++) {
            if (schemaVersion == oldVersion) {
                Migration migration = migrations.get(schemaVersion);
                migration.migrate(realm, schema);
                oldVersion++;
            }
        }
    }

    public long schemaVersion() {
        return migrations.size();
    }

    public RealmConfiguration.Builder realmConfigurationBuilder() {
        return new RealmConfiguration.Builder()
                .schemaVersion(schemaVersion())
                .migration(this);
    }
}
