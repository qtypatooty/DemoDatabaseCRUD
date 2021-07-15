package sg.edu.rp.c346.id20006949.demodatabasecrud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EditActivity extends AppCompatActivity {

    TextView ID, content;
    EditText editcontent;
    Button update, delete;
    Note data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        //initialize the variables with UI here
        content = findViewById(R.id.content);
        editcontent = findViewById(R.id.editcontent);
        ID = findViewById(R.id.ID);
        update = findViewById(R.id.update);
         delete = findViewById(R.id.delete);
        Intent i = getIntent();
        data = (Note) i.getSerializableExtra("data");

        ID.setText("ID: " + data.getId());
        editcontent.setText(data.getNoteContent());


        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(EditActivity.this);
                data.setNoteContent(editcontent.getText().toString());
                dbh.updateNote(data);
                dbh.close();
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(EditActivity.this);
                dbh.deleteNote(data.getId());

            }
        });


    }
}
