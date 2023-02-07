package com.leopard4.postinglist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.leopard4.postinglist.model.Post;

public class AddActivity extends AppCompatActivity {

    EditText editTitle;
    EditText editBody;
    Button btnSave;

    public static final int SAVE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        getSupportActionBar().setTitle("포스팅 생성");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // 뒤로가기 버튼


        editTitle = findViewById(R.id.editTitle);
        editBody = findViewById(R.id.editBody);
        btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                savePosting();
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int itemId = item.getItemId();

        if(itemId == R.id.menuSave){
            savePosting();

        }
        return super.onOptionsItemSelected(item);
    }

    void savePosting(){
        String title = editTitle.getText().toString().trim();
        String body = editBody.getText().toString().trim();

        if (title.isEmpty() || body.isEmpty()) {
            Toast.makeText(AddActivity.this, "모두 입력해주세요", Toast.LENGTH_SHORT).show();
            return;
        }

        Post post = new Post(title, body);

        // post 를 인텐트에 담아서 메인액티비티로 전달하고
        // 나를실행한 액티비티한테 데이터를 전달해 주는 코드
        Intent intent = new Intent();
        intent.putExtra("post", post);
        setResult(SAVE, intent);

        // 이 액티비티는 사라져야 한다.
        finish();
    }
}