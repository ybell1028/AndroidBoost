package org.techcompany.mybutton;

import android.content.Context;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatButton;

import org.techcompany.mybutton.R;

public class BitmapButton extends AppCompatButton {
    public BitmapButton(Context context) {
        super(context);

        init(context);
    }

    public BitmapButton(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    private void init(Context context)

    @Override
    public void setBackgroundResource(int resId) {
        setBackgroundResource(R.drawable.title_bitmap_button_normal);

        float textSize = getResources().getDimension(R.dimen.text_size);
        setTextSize(); // 픽셀 단위로만 조정 가능
    }
}
