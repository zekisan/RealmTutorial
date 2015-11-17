package com.example.ezequiel.realm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import com.example.ezequiel.realm.adapter.DisciplineAdapter;
import com.example.ezequiel.realm.domain.Discipline;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;

public class DisciplinesActivity extends AppCompatActivity {

    private Realm realm;
    private RealmResults<Discipline> disciplines;
    private RealmChangeListener realmChangeListener;
    private ListView lvDisciplines;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disciplines);

        realm = Realm.getInstance(this);
        realmChangeListener = new RealmChangeListener() {
            @Override
            public void onChange() {
                ((DisciplineAdapter) lvDisciplines.getAdapter()).notifyDataSetChanged();
            }
        };
        realm.addChangeListener(realmChangeListener);
        disciplines = realm.where(Discipline.class).findAll();

        lvDisciplines = (ListView) findViewById(R.id.lv_disciplines);
        lvDisciplines.setAdapter(new DisciplineAdapter(this, disciplines, true));
    }

    // LISTENERS
    public void callAddDiscipline( View view){
        Intent it = new Intent( this, AddUpdateDisciplineActivity.class );
        startActivity(it);
    }

    @Override
    protected void onDestroy() {
        realm.removeAllChangeListeners();
        realm.close();
        super.onDestroy();
    }

}
