package group.wnrcorp.com.navigationproject;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class FirstFragment2 extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    TextView addition_result;

    InterfaceSolution interfaceSolution;
    int value;
    public FirstFragment2() {
        // Required empty public constructor
    }

    public static FirstFragment2 newInstance(String param1, String param2) {
        FirstFragment2 fragment = new FirstFragment2();
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
        // Inflate the layout for this fragment
        View childview= inflater.inflate(R.layout.fragment_first_fragment2, container, false);
        addition_result=(TextView) childview.findViewById(R.id.addition);
        try {
            value = getArguments().getInt("add");
            addition_result.setText(""+value);
        }
        catch(Exception e)
        {
            System.out.println("exceptionCheck....."+e);
        }
        System.out.println("fragmentCheck2..."+value);

        return childview;
    }

}
