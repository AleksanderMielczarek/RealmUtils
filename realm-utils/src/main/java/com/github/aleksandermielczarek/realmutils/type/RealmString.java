package com.github.aleksandermielczarek.realmutils.type;

import io.realm.RealmObject;

/**
 * Created by Aleksander Mielczarek on 12.11.2016.
 */

public class RealmString extends RealmObject implements RealmTypeAdapter<String, String> {

    private String value;

    public RealmString() {

    }

    public RealmString(String adaptedValue) {
        setAdaptedValue(adaptedValue);
    }

    @Override
    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public void setAdaptedValue(String adaptedValue) {
        value = toRealmType(adaptedValue);
    }

    @Override
    public String getAdaptedValue() {
        return fromRealmType(value);
    }

    @Override
    public String toRealmType(String notRealmType) {
        return notRealmType;
    }

    @Override
    public String fromRealmType(String realmType) {
        return realmType;
    }
}
