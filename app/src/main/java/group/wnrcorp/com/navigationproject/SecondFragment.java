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
 * Use the {@link SecondFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SecondFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    InterfaceSolution interfaceSolution;
    int value;

    FragmentTransaction fragmentTransaction1;

    public SecondFragment() {
        // Required empty public constructor
    }


    public static SecondFragment newInstance(String param1, String param2) {
        SecondFragment fragment = new SecondFragment();
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
        View childview= inflater.inflate(R.layout.fragment_second, container, false);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Second Fragment");
        try {
            value = getArguments().getInt("mul");
        }
        catch(Exception e)
        {
            System.out.println("exceptionCheck....."+e);
        }

        SecondFragment1 sf1=new SecondFragment1();
        Bundle args = new Bundle();
        args.putInt("mull", value);
        sf1.setArguments(args);
        fragmentTransaction1 = getChildFragmentManager().beginTransaction();
        fragmentTransaction1.replace(R.id.second_frame,sf1);
        fragmentTransaction1.commit();
        fragmentTransaction1.addToBackStack(null);
        return childview;
    }

   /* @Override
    public void sendMultidata(int multiData) {
        multiplication_result.setText(""+multiData);
    }*/
}
