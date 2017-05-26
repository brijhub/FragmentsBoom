package group.wnrcorp.com.navigationproject;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import static android.content.Context.INPUT_METHOD_SERVICE;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FirstFragment1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FirstFragment1 extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    EditText ed1,ed2;
    TextView submit_button;
    int first,second,add,sub,mul,div;
    InterfaceSolution addition;
    FirstFragment1 firstFragment1l;

    public FirstFragment1() {

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            addition = (InterfaceSolution)activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement DataPassListener");
        }

    }


    public static FirstFragment1 newInstance(String param1, String param2) {
        FirstFragment1 fragment = new FirstFragment1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View childview= inflater.inflate(R.layout.fragment_first_fragment1, container, false);
        firstFragment1l=this;
        ed1=(EditText) childview.findViewById(R.id.first_no);
        ed2=(EditText) childview.findViewById(R.id.second_no);
        submit_button=(TextView) childview.findViewById(R.id.submit);

        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                first=Integer.parseInt(ed1.getText().toString());
                second=Integer.parseInt(ed2.getText().toString());
                add=first+second;
                sub=first-second;
                mul=first*second;
                div=first/second;
                System.out.println("fragmentCheck1..."+add);
                addition.sendAdditionData(add);
                addition.sendSubtractionData(sub);
                addition.sendMultiplicationData(mul);
                addition.senddivisionData(div);

            }
        });

        return childview;
    }


}
