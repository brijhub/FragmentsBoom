package group.wnrcorp.com.navigationproject;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class FirstFragment3 extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    TextView subtraction_result;

    InterfaceSolution interfaceSolution;
    int value;


    public FirstFragment3() {

    }

    public static FirstFragment3 newInstance(String param1, String param2) {
        FirstFragment3 fragment = new FirstFragment3();
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
        View childview= inflater.inflate(R.layout.fragment_first_fragment3, container, false);
        subtraction_result=(TextView) childview.findViewById(R.id.subtraction);
        try {
            value = getArguments().getInt("sub");
            subtraction_result.setText(""+value);
        }
        catch(Exception e)
        {
            System.out.println("exceptionCheck....."+e);
        }
        System.out.println("fragmentCheck2..."+value);

        return childview;
    }

}
