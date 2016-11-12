package com.github.aleksandermielczarek.realmutils.type;

/**
 * Created by Aleksander Mielczarek on 12.11.2016.
 */

public interface RealmTypeAdapter<RT, NRT> {

    void setValue(RT value);

    RT getValue();

    void setAdaptedValue(NRT adaptedValue);

    NRT getAdaptedValue();

    RT toRealmType(NRT notRealmType);

    NRT fromRealmType(RT realmType);
}
