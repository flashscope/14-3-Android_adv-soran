
package org.nhnnext.soran.ui.session;

import org.nhnnext.soran.R;
import org.nhnnext.soran.db.DBSessionHelper;
import org.nhnnext.soran.db.ObjSession;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.TextView;

public class SessionDetailActivity extends ActionBarActivity {

    // View name of the header image. Used for activity scene transitions
    public static final String VIEW_NAME_HEADER_IMAGE = "detail:header:image";

    // View name of the header title. Used for activity scene transitions
    public static final String VIEW_NAME_HEADER_TITLE = "detail:header:title";
    
	private ActionBar mActionbar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.fragment_session_deatil);
		
		//setContentView(R.layout.activity_session_detail);
		
		mActionbar = getSupportActionBar();
		mActionbar.setIcon(R.drawable.ic_soran_actionbar);
		mActionbar.setDisplayHomeAsUpEnabled(true);
		
		int position = 0;
		if(getIntent() != null) {
			position = getIntent().getIntExtra("position", 0);
		}
		DBSessionHelper db = new DBSessionHelper(this);
		ObjSession session = db.getSession(position);
		
		ProfileView pv = (ProfileView) findViewById(R.id.pvInstructor);
		pv.setTransitionName(VIEW_NAME_HEADER_IMAGE);
		
        
		pv.ivPhoto.setImageResource(Integer.valueOf(session.photo));
		pv.tvName.setText(session.instructor);
		
		
		TextView tvTitle = (TextView) findViewById(R.id.tvTitle);
		tvTitle.setTransitionName(VIEW_NAME_HEADER_TITLE);
        
		
		tvTitle.setText(session.title);
		
		TextView tvDescription = (TextView) findViewById(R.id.tvDescription);
		tvDescription.setText(session.description);
	}
	
	@Override
	public boolean onSupportNavigateUp() {
		finish();
		return true;
	}
	
}
