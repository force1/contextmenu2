package com.mycompany.contextmenu2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView listView1;
    String contacts[]={"Action1","Action2","Action3"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView1=(ListView)findViewById(R.id.listView1
        );
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,contacts);
        listView1.setAdapter(adapter);
        registerForContextMenu(listView1);


    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Context menu");
        menu.add(0, v.getId(), 0, "Action1");

        menu.add(0, v.getId(), 0, "Action2");
        menu.add(0, v.getId(), 0, "Action3");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getTitle() == "Action1") {
            Toast.makeText(getApplicationContext(), "action 1 clicked", Toast.LENGTH_LONG).show();
        } else if (item.getTitle() == "Action2") {
            Toast.makeText(getApplicationContext(), "action2 clicked", Toast.LENGTH_LONG).show();
        }
        else if (item.getTitle() == "Action3") {
            Toast.makeText(getApplicationContext(), "action2 clicked", Toast.LENGTH_LONG).show();
        }
        else {
            return false;
        }
        return true;
    }


}
