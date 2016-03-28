package polyu.hw.financenote.ui;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;

import org.achartengine.*;
import org.achartengine.chart.PieChart;

import java.util.HashMap;

import polyu.hw.financenote.R;
import polyu.hw.financenote.ui.achartengine.BudgetPieChart;
import polyu.hw.financenote.ui.achartengine.OverviewPieChart;
import polyu.hw.financenote.ui.achartengine.PieChartBuilder;
import polyu.hw.financenote.ui.dummy.DummyContent;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OverviewFragement.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link OverviewFragement#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OverviewFragement extends NavFragment {

    private OnFragmentInteractionListener mListener;

    public static OverviewFragement newInstance(int sectionNumber) {
        OverviewFragement fragment = new OverviewFragement();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public OverviewFragement() {
        // Required empty public constructor



    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       /** Intent intent = null;
        intent = new BudgetPieChart().execute(OverviewFragement.this.getActivity());

        startActivity(intent);**/

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_overview_fragement, container, false);

     /**   View view = inflater.inflate(R.layout.fragment_overview_fragement, container, false);

        LinearLayout chartContainer = (LinearLayout) view.findViewById(
                R.id.chart);


        return view;**/

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onOverviewFragementInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onOverviewFragementInteraction(Uri uri);
    }


    /**
     *
     */
    @SuppressWarnings("unchecked")
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Intent intent = getActivity().getIntent();
     //   this.connectionData = (HashMap<String, String>) intent.getSerializableExtra("org.elasticdroid.LoginView.connectionData");
    }

    @Override
    public void onResume() {
        super.onResume();
        //check if we need to get region data.
        //if we have neither region data, nor a running retrieveregionmodel
        //execute retrieve region model
		/*if (regionData == null) {
			//execute retrieveregionmodel unless not executing already
			if (retrieveRegionTask == null) {
				retrieveRegionTask = new RetrieveRegionTask();
				retrieveRegionTask.execute(new HashMap<?,?>[]{connectionData});
			}
		}*/

        //new BudgetPieChart().execute(OverviewFragement.this.getActivity());
        drawChart();

    }
    private void drawChart() {
       /** XYMultipleSeriesDataset series = new XYMultipleSeriesDataset();
        XYValueSeries newTicketSeries = new XYValueSeries("New Tickets");
        newTicketSeries.add(1, 2, 14);
        newTicketSeries.add(2, 2, 12);
        newTicketSeries.add(3, 2, 18);
        newTicketSeries.add(4, 2, 5);
        newTicketSeries.add(5, 2, 1);
        series.addSeries(newTicketSeries);
        XYValueSeries fixedTicketSeries = new XYValueSeries("Fixed Tickets");
        fixedTicketSeries.add(1, 1, 7);
        fixedTicketSeries.add(2, 1, 4);
        fixedTicketSeries.add(3, 1, 18);
        fixedTicketSeries.add(4, 1, 3);
        fixedTicketSeries.add(5, 1, 1);
        series.addSeries(fixedTicketSeries);

        XYMultipleSeriesRenderer renderer = new XYMultipleSeriesRenderer();
        renderer.setAxisTitleTextSize(16);
        renderer.setChartTitleTextSize(20);
        renderer.setLabelsTextSize(15);
        renderer.setRange(new double[]{0, 6, 0, 6});

        //renderer.setMargins(new int[] { 20, 30, 15, 0 });
        XYSeriesRenderer newTicketRenderer = new XYSeriesRenderer();
        newTicketRenderer.setColor(Color.BLUE);
        renderer.addSeriesRenderer(newTicketRenderer);
        XYSeriesRenderer fixedTicketRenderer = new XYSeriesRenderer();
        fixedTicketRenderer.setColor(Color.GREEN);
        renderer.addSeriesRenderer(fixedTicketRenderer);

        renderer.setXLabels(0);
        renderer.setYLabels(0);
        renderer.setDisplayChartValues(false);
        renderer.setShowGrid(false);
        renderer.setShowLegend(false);
        renderer.setShowLabels(true);

        //renderer.setZoomEnabled(false, false);
**/
     /**   GraphicalView chartView;

        chartView = ChartFactory.getBubbleChartView(getActivity(), series, renderer);
        //}
**/
        GraphicalView chartView;

        chartView = new OverviewPieChart().getView(getActivity());

        LinearLayout layout = (LinearLayout) getActivity().findViewById(R.id.chart);
        //layout.removeAllViews();
        layout.addView(chartView, new ViewGroup.LayoutParams(960,
                ViewGroup.LayoutParams.FILL_PARENT));
    }

}
