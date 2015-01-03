
package org.nhnnext.soran.ui.session;

import org.nhnnext.soran.R;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

public class CopyOfSessionDetailActivity extends ActionBarActivity {

    // View name of the header image. Used for activity scene transitions
    public static final String VIEW_NAME_HEADER_IMAGE = "detail:header:image";

    // View name of the header title. Used for activity scene transitions
    public static final String VIEW_NAME_HEADER_TITLE = "detail:header:title";
    
	private ActionBar mActionbar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
		setContentView(R.layout.activity_session_detail);
		
		mActionbar = getSupportActionBar();
		mActionbar.setIcon(R.drawable.ic_soran_actionbar);
		mActionbar.setDisplayHomeAsUpEnabled(true);
		
		//View v = inflater.inflate(R.layout.fragment_notice, null);
		
	}
	
	@Override
	public boolean onSupportNavigateUp() {
		finish();
		return true;
	}
	
}
