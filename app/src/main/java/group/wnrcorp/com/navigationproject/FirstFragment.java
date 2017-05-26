package group.wnrcorp.com.navigationproject;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FirstFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FirstFragment extends Fragment{

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public int addResult,subResult;

    FragmentTransaction fragmentTransaction1;
    public FirstFragment() {

    }

    public static FirstFragment newInstance(String param1, String param2) {
        FirstFragment fragment = new FirstFragment();
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
        View rootview=inflater.inflate(R.layout.fragment_first, container, false);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("First Fragment");
        fragmentTransaction1 = getChildFragmentManager().beginTransaction();

        fragmentTransaction1.replace(R.id.ff1, new FirstFragment1());
        fragmentTransaction1.replace(R.id.ff2, new FirstFragment2());
        fragmentTransaction1.replace(R.id.ff3, new FirstFragment3());
        fragmentTransaction1.commit();

        return rootview;
    }

   /* @Override
    public void sendAdditionData(int a) {
        addResult=a;
        FirstFragment2 f2=new FirstFragment2();
        Bundle args = new Bundle();
        args.putInt("add", addResult);
        f2.setArguments(args);
        getChildFragmentManager().beginTransaction().replace(R.id.ff2, f2).commit();

    }

    @Override
    public void sendSubtractionData(int b) {
        subResult=b;
    }

    @Override
    public void sendMultiplicationData(int c) {

    }

    @Override
    public void senddivisionData(int d) {

    }*/
}
