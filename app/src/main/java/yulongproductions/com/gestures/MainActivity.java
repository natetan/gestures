package yulongproductions.com.gestures;

import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity  implements GestureDetector.OnGestureListener,
                                                                GestureDetector.OnDoubleTapListener {
    private TextView mMessageTextView;
    private GestureDetectorCompat mGestureDetector;
    private Button mTapButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMessageTextView = (TextView) findViewById(R.id.messageTextView);
        mTapButton = (Button) findViewById(R.id.tapButton);
        mGestureDetector = new GestureDetectorCompat(this, this);
        mGestureDetector.setOnDoubleTapListener(this);

        mTapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.setMessage("You just clicked on the button!");
            }
        });

    }

    /*
        Begin Gestures
    */

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        this.setMessage("onSingleTapConfirmed");
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        this.setMessage("onDoubleTap");
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        this.setMessage("onDoubleTapEvent");
        return true;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        this.setMessage("onDown");
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        this.setMessage("onShowPress");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        this.setMessage("onSingleTapUp");
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        this.setMessage("You're scrolling!");
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        this.setMessage("onLongPress");
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        this.setMessage("You're flinging!s");
        return true;
    }

    private void setMessage(String message) {
        mMessageTextView.setText(message);
    }

    /*
        End Gestures
    */

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mGestureDetector.onTouchEvent(event); // Detects if it was a special kind of event first
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
