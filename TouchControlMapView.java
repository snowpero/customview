package com.jobplanet.android.util.customview.map;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.google.android.gms.maps.MapView;

/**
 * Created by gypark on 2016. 11. 4..
 * MapView의 Gesture 이벤트만 하도록해서, RecyclerView의 스크롤과 겹치지 않도록 합니다.
 */

public class TouchControlMapView extends MapView {

    private RecyclerView recyclerView;

    public TouchControlMapView(Context context) {
        super(context);
    }

    public TouchControlMapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TouchControlMapView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setRecyclerView(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                // Disallow ScrollView to intercept touch events.
                if( recyclerView != null )
                    recyclerView.requestDisallowInterceptTouchEvent(true);
                break;

            case MotionEvent.ACTION_UP:
                // Allow ScrollView to intercept touch events.
                if( recyclerView != null )
                    recyclerView.requestDisallowInterceptTouchEvent(false);
                break;
        }

        return super.onInterceptTouchEvent(event);
    }
}
