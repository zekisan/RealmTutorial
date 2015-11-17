package com.example.ezequiel.realm;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.example.ezequiel.realm.domain.Discipline;
import com.example.ezequiel.realm.domain.Student;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume(){
        super.onResume();

        Button btDisciplines = (Button) findViewById(R.id.bt_disciplines);
        Button btStudents = (Button) findViewById(R.id.bt_students);

        Realm realm = Realm.getInstance(this);
        RealmResults<Discipline> disciplines = realm.where(Discipline.class).findAll();
        RealmResults<Student> students = realm.where(Student.class).findAll();

        btDisciplines.setText("Disciplinas ("+disciplines.size()+")");
        btStudents.setText("Estudantes ("+students.size()+")");
        realm.close();
    }

    // Listeners
    public void callDisciplines(View view){
        Intent it = new Intent(this, DisciplinesActivity.class);
        startActivity(it);
    }

    public void callStudents(View view){}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
