package polyu.hw.financenote.entity;

import polyu.hw.financenote.ui.NavFragment;

/**
 * Created by Hon on 25/3/2016.
 */
public class NavPage {

    private String title;
    private NavFragment fragment;

    public NavPage(String title, NavFragment fragment) {
        this.title = title;
        this.fragment = fragment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public NavFragment getFragment() {
        return fragment;
    }

    public void setFragment(NavFragment fragment) {
        this.fragment = fragment;
    }
}
