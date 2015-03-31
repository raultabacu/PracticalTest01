package ro.pub.cs.systems.pdsd.practicaltest01;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.EditText;

public class PracticalTest01MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practical_test01_main);
		CheckBox emailCheckbox = (CheckBox)findViewById(R.id.emailCheckbox);
		CheckBox phoneCheckbox = (CheckBox)findViewById(R.id.phoneCheckBox);
		emailCheckbox.setEnabled(false);
		phoneCheckbox.setEnabled(false);
		emailCheckbox.setChecked(true);
		phoneCheckbox.setChecked(true);
		
		EditText emailText = (EditText)findViewById(R.id.emailText);
		EditText phoneText = (EditText)findViewById(R.id.phoneText);
		emailText.addTextChangedListener( new TextWatcher(){
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void afterTextChanged(Editable s) {
				String val = s.toString();
				Pattern p = Pattern.compile("[a-z]+@[a-z]+.[a-z]+");
				Matcher m = p.matcher(val);
				CheckBox emailCheckbox = (CheckBox)findViewById(R.id.emailCheckbox);
				if (m.find()) {
					emailCheckbox.setChecked(true);
				} else {
					emailCheckbox.setChecked(false);
				}
				
			}
		});
		phoneText.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				String val = s.toString();
				Pattern p = Pattern.compile("^[0-9]{10,}");
				Matcher m = p.matcher(val);
				CheckBox phoneCheckbox = (CheckBox)findViewById(R.id.phoneCheckBox);
				if (m.find()) {
					phoneCheckbox.setChecked(true);
				} else {
					phoneCheckbox.setChecked(false);
				}
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.practical_test01_main, menu);
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
	
	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {
		EditText emailText = (EditText)findViewById(R.id.emailText);
		EditText phoneText = (EditText)findViewById(R.id.phoneText);
		savedInstanceState.putString("EMAIL", emailText.getText().toString());
		savedInstanceState.putString("PHONE", phoneText.getText().toString());
	}
	
}
