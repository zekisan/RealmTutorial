package com.example.ezequiel.realm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import com.example.ezequiel.realm.adapter.StudentAdapter;
import com.example.ezequiel.realm.domain.Student;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;

public class StudentsActivity extends AppCompatActivity {

    private Realm realm;
    private RealmResults<Student> students;
    private RealmChangeListener realmChangeListener;
    private ListView lvStudents;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students);

        realm = Realm.getDefaultInstance();

        realmChangeListener = new RealmChangeListener() {
            @Override
            public void onChange() {
                ((StudentAdapter) lvStudents.getAdapter()).notifyDataSetChanged();
            }
        };

        realm.addChangeListener(realmChangeListener);
        students = realm.where( Student.class ).findAll();

        lvStudents = (ListView) findViewById(R.id.lv_students);
        lvStudents.setAdapter( new StudentAdapter( this, students, false ));
    }


    @Override
    protected void onDestroy() {
        realm.removeAllChangeListeners();
        realm.close();
        super.onDestroy();

    }


    public void callAddStudent( View view){
        Intent it = new Intent( this, AddUpdateStudentActivity.class );
        startActivity(it);
    }

}
