package my.assignment.listviewapplication;

import android.database.DataSetObserver;
import android.support.v7.app.AppCompatActivity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends ListActivity {

    Button mAscBtn,mDescBtn;
    String[] months=new String[]{"Jan","Feb","Mar","Apr","May","Jun","July","Aug","Sep","Oct","Nov","Dec"};
    ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       mAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,months);
        setListAdapter(mAdapter);
        mAscBtn= (Button)findViewById(R.id.button2);
        mDescBtn= (Button)findViewById(R.id.button);
        mAscBtn.setOnClickListener(new View.OnClickListener() {
                      @Override
                                       public void onClick(View view) {
                                           Arrays.sort(months);

                                           Toast.makeText(getApplicationContext(),"Array Sorted in Asc order",Toast.LENGTH_SHORT).show();

                                           mAdapter.notifyDataSetChanged();
                                       }
                                   }

        );
        mDescBtn.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View view) {
                                           Arrays.sort(months,Collections.<String>reverseOrder());
                                           Toast.makeText(getApplicationContext(),"Array Sorted in Desc order",Toast.LENGTH_SHORT).show();
                                            mAdapter.notifyDataSetChanged();
                                       }
                                   }

        );


    }
}
