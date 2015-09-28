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

/**
 * Created by Drew on 9/25/2015.
 */
public class ReportFragment extends Fragment {

    private Report mReport;
    private EditText mTitleField;
    private Button mDateButton;
    private CheckBox mReportedCheckBox;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mReport = new Report();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_report, container, false);

        mTitleField = (EditText)v.findViewById(R.id.report_title);
        mTitleField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //intentionally empty
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mReport.setTitle(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                //intentionally empty
            }
        });

        mDateButton = (Button)v.findViewById(R.id.report_date);
        mDateButton.setText(mReport.getDate().toString());
        mDateButton.setEnabled(false);

        mReportedCheckBox = (CheckBox)v.findViewById(R.id.report_reported);
        mReportedCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //set the report's reported property
                mReport.setReported(isChecked);
            }
        });

        return v;
    }

}
