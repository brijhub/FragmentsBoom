package group.wnrcorp.com.navigationproject;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ThirdFragment1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ThirdFragment1 extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    TextView division_result;
    int value;

    public ThirdFragment1() {
        // Required empty public constructor
    }

    public static ThirdFragment1 newInstance(String param1, String param2) {
        ThirdFragment1 fragment = new ThirdFragment1();
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
        View childview= inflater.inflate(R.layout.fragment_third_fragment1, container, false);
        division_result=(TextView) childview.findViewById(R.id.division);
        try {
            value = getArguments().getInt("divv");
            division_result.setText(""+value);
        }
        catch(Exception e)
        {
            System.out.println("exceptionCheck....."+e);
        }
        System.out.println("fragmentCheckMultiplication..."+value);
        return childview;
    }

}
