package com.github.aleksandermielczarek.realmutilsexample.ui;

import android.databinding.ObservableField;

import com.github.aleksandermielczarek.realmutils.type.RealmString;
import com.github.aleksandermielczarek.realmutilsexample.BR;
import com.github.aleksandermielczarek.realmutilsexample.R;
import com.github.aleksandermielczarek.realmutilsexample.domain.Names;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmList;
import me.tatarka.bindingcollectionadapter.ItemView;

/**
 * Created by Aleksander Mielczarek on 12.11.2016.
 */

public class MainViewModel {

    public final ObservableField<Names> names = new ObservableField<>();
    public final ItemView itemView = ItemView.of(BR.name, R.layout.item_name);

    private final Realm realm;

    @Inject
    public MainViewModel() {
        realm = Realm.getDefaultInstance();
        long numberOfRealms = realm.where(Names.class)
                .count();
        if (numberOfRealms == 0) {
            realm.beginTransaction();
            Names names = realm.createObject(Names.class);
            RealmList<RealmString> nameList = new RealmList<>();
            for (int i = 1; i <= 100; i++) {
                RealmString name = realm.createObject(RealmString.class);
                name.setAdaptedValue("John Doe " + i);
                nameList.add(name);
            }
            names.setNames(nameList);
            realm.commitTransaction();
            this.names.set(names);
        } else {
            names.set(realm.where(Names.class).findFirst());
        }

    }

    public void close() {
        realm.close();
    }
}
