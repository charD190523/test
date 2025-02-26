package com.example.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Caculator extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.caculator);

        // Ánh xạ các thành phần giao diện
        EditText editText1 = findViewById(R.id.pt1);
        EditText editText2 = findViewById(R.id.pt2);
        Spinner spinner = findViewById(R.id.spinner_operators);
        Button buttonCalculate = findViewById(R.id.button);
        TextView textResult = findViewById(R.id.hienthi);

        // Danh sách toán tử với mục "Chọn phép tính" đầu tiên
        String[] operators = {"Chọn phép tính", "+", "-", "*", "/"};

        // Gán danh sách vào Spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, operators);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        // Đặt mục mặc định là "Chọn phép tính"
        spinner.setSelection(0);

        // Xử lý khi nhấn nút "Tính"
        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num1Str = editText1.getText().toString();
                String num2Str = editText2.getText().toString();
                String selectedOperator = spinner.getSelectedItem().toString();

                if (num1Str.isEmpty() || num2Str.isEmpty()) {
                    Toast.makeText(Caculator.this, "Vui lòng nhập đủ 2 số!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (selectedOperator.equals("Chọn phép tính")) {
                    Toast.makeText(Caculator.this, "Vui lòng chọn phép tính!", Toast.LENGTH_SHORT).show();
                    return;
                }

                double num1 = Double.parseDouble(num1Str);
                double num2 = Double.parseDouble(num2Str);
                double result = 0.0;

                switch (selectedOperator) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        if (num2 == 0.0) {
                            Toast.makeText(Caculator.this, "Lỗi: Không thể chia cho 0!", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        result = num1 / num2;
                        break;
                }

                // Hiển thị kết quả
                textResult.setText("Hiển thị kết quả: " + result);
            }
        });

        MultiAutoCompleteTextView multi = findViewById(R.id.multiAutoComplete);
        String [] provinces = getResources().getStringArray(R.array.provinces);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, provinces);
        multi.setAdapter(arrayAdapter);
        multi.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
    }
}

