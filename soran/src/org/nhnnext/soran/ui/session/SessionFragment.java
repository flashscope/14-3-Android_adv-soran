package org.nhnnext.soran.ui.session;

import org.nhnnext.soran.R;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class SessionFragment extends Fragment {

	
	// View name of the header image. Used for activity scene transitions
    public static final String VIEW_NAME_HEADER_IMAGE = "detail:header:image";

    // View name of the header title. Used for activity scene transitions
    public static final String VIEW_NAME_HEADER_TITLE = "detail:header:title";
    
	SessionAdapter mAdapter;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_session, null);
		
		mAdapter = new SessionAdapter(getActivity());
		((ListView)v).setAdapter(mAdapter);
		((ListView)v).setOnItemClickListener(new OnItemClickListener() {
			
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Intent intent = new Intent(getActivity(), SessionDetailActivity.class);
				intent.putExtra("position", position);
				
				
				ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(
						getActivity(),
		                new Pair<View, String>(
		                        view.findViewById(R.id.pvInstructor),
		                        VIEW_NAME_HEADER_IMAGE),
		                new Pair<View, String>(
		                        view.findViewById(R.id.tvTitle),
		                        VIEW_NAME_HEADER_TITLE)
		        );

		        // Now we can start the Activity, providing the activity options as a bundle
				getActivity().startActivity(intent, activityOptions.toBundle());
				//startActivity(intent);
			}
		});
		
		return v;
	}
	
}
