package com.gdgwomen.session4;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ListDepartmentActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_department);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.list_department, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_list_department, container, false);
            ListView listView = (ListView)
                    rootView.findViewById(R.id.listView);
            ArrayList<String> departments = new ArrayList<String>();
            departments.add("Arequipa");
            departments.add("La libertad");
            departments.add("Puno");
            departments.add("Cuzco");
            departments.add("Tacna");

            final DepartmentAdapter da =
                    new DepartmentAdapter(getActivity(),
                            departments);
            listView.setAdapter(da);

            Button btnNewDepartment = (Button)
                    rootView.findViewById(R.id.btnNewDepartment);
            btnNewDepartment.setOnClickListener(
                    new View.OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            da.addItem("Departamento Falso");
                            da.notifyDataSetChanged();
                        }
                    }
            );
            return rootView;
        }
    }
}
