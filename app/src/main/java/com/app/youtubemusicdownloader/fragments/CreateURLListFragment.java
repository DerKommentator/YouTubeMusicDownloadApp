package com.app.youtubemusicdownloader.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.InputType;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.app.youtubemusicdownloader.R;

import static android.view.ViewGroup.LayoutParams.FILL_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;
import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.view.ViewGroup.LayoutParams;
import static android.widget.LinearLayout.VERTICAL;

import com.app.youtubemusicdownloader.activity.MainActivity;

import java.util.ArrayList;
import java.util.List;


public class CreateURLListFragment extends Fragment {

    public CreateURLListFragment()
    {
        // Required empty public constructor
    }

    EditText edittext_input;
    Button button_add_url;
    int i = 0;


    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        final View root_view = inflater.inflate(R.layout.fragment_createurllist, container, false);

        //createRowInput(root_view);

        return root_view;
    }

    public void createRowInput(View root_view, String url)
    {
        LinearLayout linearLayout  = (LinearLayout) root_view.findViewById(R.id.holder);
        LinearLayout rowLayout = createLinearLayout();
        rowLayout.addView(createEditText(url));
        rowLayout.addView(createButton());

        linearLayout.addView(rowLayout);
    }

    public LinearLayout createLinearLayout()
    {
        LinearLayout parent = new LinearLayout(getContext());

        parent.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        parent.setOrientation(LinearLayout.HORIZONTAL);

        return parent;
    }

    public EditText createEditText(String url)
    {
        EditText editText = new EditText(getContext());
        editText.setWidth(MATCH_PARENT);
        editText.setFocusable(false);
        editText.setHeight(WRAP_CONTENT);
        editText.layout(8,32, 8, 0);
        editText.setEms(15);
        editText.setHint(url);
        editText.setTag("edit_text_input_url" + i++);
        editText.setInputType(InputType.TYPE_CLASS_TEXT);
        return editText;
    }

    public Button createButton()
    {
        Button button = new Button(getContext());
        button.setWidth(110);
        button.setHeight(WRAP_CONTENT);
        button.layout(8, 32, 8, 8);
        button.setText("Delete");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewGroup parent = (ViewGroup) view.getParent();
                parent.setVisibility(View.GONE);
            }
        });
        return button;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);

        final View root_view = getView();

        if(root_view != null)
        {
            edittext_input = (EditText)root_view.findViewById(R.id.edittext_input_id);
            button_add_url = (Button)root_view.findViewById(R.id.button_add_url);
            //textview_show_song = (TextView)root_view.findViewById(R.id.textview_show_song);




            button_add_url.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    createRowInput(root_view, edittext_input.getText().toString());

                    edittext_input.setText("");
                }
            });
        }
    }
}
