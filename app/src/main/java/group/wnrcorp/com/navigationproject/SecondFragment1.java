package group.wnrcorp.com.navigationproject;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SecondFragment1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SecondFragment1 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    TextView multiplication_result;

    InterfaceSolution interfaceSolution;
    int value;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public SecondFragment1() {
        // Required empty public constructor
    }

    public static SecondFragment1 newInstance(String param1, String param2) {
        SecondFragment1 fragment = new SecondFragment1();
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
        View childview= inflater.inflate(R.layout.fragment_second_fragment1, container, false);
        multiplication_result=(TextView) childview.findViewById(R.id.multiplication);
        try {
            value = getArguments().getInt("mull");
            multiplication_result.setText(""+value);
        }
        catch(Exception e)
        {
            System.out.println("exceptionCheck....."+e);
        }
        System.out.println("fragmentCheckMultiplication..."+value);
        return childview;
    }

}
