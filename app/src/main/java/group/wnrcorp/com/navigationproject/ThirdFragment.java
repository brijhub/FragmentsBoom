package group.wnrcorp.com.navigationproject;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ThirdFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ThirdFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    TextView division_result;

    InterfaceSolution interfaceSolution;
    int value;
    FragmentTransaction fragmentTransaction1;

    public ThirdFragment() {
        // Required empty public constructor
    }

    public static ThirdFragment newInstance(String param1, String param2) {
        ThirdFragment fragment = new ThirdFragment();
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
        View childview= inflater.inflate(R.layout.fragment_third, container, false);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Third Fragment");
        try {
            value = getArguments().getInt("div");
        }
        catch(Exception e)
        {
            System.out.println("exceptionCheck....."+e);
        }

        ThirdFragment1 sf1=new ThirdFragment1();
        Bundle args = new Bundle();
        args.putInt("divv", value);
        sf1.setArguments(args);
        fragmentTransaction1 = getChildFragmentManager().beginTransaction();
        fragmentTransaction1.replace(R.id.third_frame,sf1);
        fragmentTransaction1.addToBackStack(null);
        fragmentTransaction1.commit();
        return childview;
    }

}
