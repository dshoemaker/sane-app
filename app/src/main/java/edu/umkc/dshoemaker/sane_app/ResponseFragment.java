package edu.umkc.dshoemaker.sane_app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import java.util.UUID;

/**
 * Created by Drew on 9/25/2015.
 */
public class ResponseFragment extends Fragment {

    private static final String ARG_RESPONSE_ID = "response_id";

    private Response mResponse;
    private EditText mTitleField;
    private Button mDateButton;
    private CheckBox mReportedCheckBox;

    public static ResponseFragment newInstance(UUID responseId) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_RESPONSE_ID, responseId);

        ResponseFragment fragment = new ResponseFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID responseId = (UUID) getArguments().getSerializable(ARG_RESPONSE_ID);
        mResponse = ViewAllResponsesActivity.get(getActivity()).getResponse(responseId);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_report, container, false);

        mTitleField = (EditText)v.findViewById(R.id.report_title);
        mTitleField.setText(mResponse.getTitle());
        mTitleField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //intentionally empty
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mResponse.setTitle(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                //intentionally empty
            }
        });

        mDateButton = (Button)v.findViewById(R.id.report_date);
        mDateButton.setText(mResponse.getDate().toString());
        mDateButton.setEnabled(false);

        mReportedCheckBox = (CheckBox)v.findViewById(R.id.report_reported);
        mReportedCheckBox.setChecked(mResponse.isReported());
        mReportedCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //set the report's reported property
                mResponse.setReported(isChecked);
            }
        });

        return v;
    }

}
