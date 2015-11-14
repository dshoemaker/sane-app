package edu.umkc.dshoemaker.sane_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
//import java.util.List;

/**
 * Created by Rhonda on 11/13/2015.
 */
public class ResponseListFragment extends Fragment {

    private ArrayList<Response> mResponses;

    private RecyclerView mResponseRecyclerView;
    private ResponseAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_response_list, container, false);

        mResponseRecyclerView = (RecyclerView) view
                .findViewById(R.id.response_recycler_view);
        mResponseRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    private void updateUI() {
        ViewAllResponsesActivity responseListActivity = ViewAllResponsesActivity.get(getActivity());
        List<Response> responses = responseListActivity.getResponses();

        if (mAdapter == null) {
            mAdapter = new ResponseAdapter(responses);
            mResponseRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.notifyDataSetChanged();
        }

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(R.string.responses_title);
        mResponses = ViewAllResponsesActivity.get(getActivity()).getResponses();
    }

    private class ResponseHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {
        private Response mResponse;

        private TextView mTitleTextView;
        private TextView mDateTextView;
        private CheckBox mReportedCheckBox;

        public ResponseHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            mTitleTextView = (TextView) itemView
                    .findViewById(R.id.list_item_response_title_text_view);
            mDateTextView = (TextView) itemView
                    .findViewById(R.id.list_item_response_date_text_view);
            mReportedCheckBox = (CheckBox)itemView
                    .findViewById(R.id.list_item_response_reported_check_box);
        }

        public void bindResponse(Response response) {
            mResponse = response;
            mTitleTextView.setText(mResponse.getTitle());
            mDateTextView.setText(mResponse.getDate().toString());
            mReportedCheckBox.setChecked(mResponse.isReported());
        }

        @Override
        public void onClick(View v) {
            Intent intent = ResponseActivity.newIntent(getActivity(), mResponse.getId());
            startActivity(intent);
        }
    }

    private class ResponseAdapter extends RecyclerView.Adapter<ResponseHolder> {
        private List<Response> mResponses;

        public ResponseAdapter(List<Response> responses) {
            mResponses = responses;
        }

        @Override
        public ResponseHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater
                    .inflate(R.layout.list_item_response, parent, false);
            return new ResponseHolder(view);
        }

        @Override
        public void onBindViewHolder(ResponseHolder holder, int position) {
            Response response = mResponses.get(position);
            holder.bindResponse(response);
        }

        @Override
        public int getItemCount() {
            return mResponses.size();
        }

    }
}
