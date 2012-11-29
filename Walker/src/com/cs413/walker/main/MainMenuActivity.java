package com.cs413.walker.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;

import com.cs413.walker.actors.Person;
import com.example.walker.R;

/**
 * Main screen for the game.
 * 
 * @author shell
 * 
 */
public class MainMenuActivity extends Activity {
	// Initializing variables
	Person player = new Person(null, null, 0, 0, 0, 0);

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_menu);
		Button play_button = (Button) findViewById(R.id.play);
		final NumberPicker difficulty = (NumberPicker) findViewById(R.id.difficulty);
		difficulty.setMaxValue(100);
		difficulty.setMinValue(1);

		final NumberPicker lives = (NumberPicker) findViewById(R.id.lives);
		lives.setMaxValue(100);
		lives.setMinValue(1);

		final NumberPicker inventory = (NumberPicker) findViewById(R.id.inventory);
		inventory.setMaxValue(100);
		inventory.setMinValue(1);

		final NumberPicker energy = (NumberPicker) findViewById(R.id.energy);
		energy.setMaxValue(100);
		energy.setMinValue(10);

		// new game button
		play_button.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent walker_activity = new Intent(getApplicationContext(),
						WalkerActivity.class);
				walker_activity.putExtra("difficulty", difficulty.getValue());
				walker_activity.putExtra("lives", lives.getValue());
				walker_activity.putExtra("energy", energy.getValue());
				walker_activity.putExtra("inventory", inventory.getValue());

				startActivity(walker_activity);
			}
		});

	}
}