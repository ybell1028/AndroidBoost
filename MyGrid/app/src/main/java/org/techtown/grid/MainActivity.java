package org.techtown.grid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SingerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridView = (GridView)findViewById(R.id.gridView);


        adapter = new SingerAdapter();
        adapter.addItem(new SingerItem("트와이스", "010-1000-1000", R.drawable.twice));
        adapter.addItem(new SingerItem("아이즈원", "010-1234-1234", R.drawable.izone));
        adapter.addItem(new SingerItem("ITZY", "010-2345-2345", R.drawable.itzy));
        adapter.addItem(new SingerItem("마마무", "010-7890-7890", R.drawable.mamamoo));
        adapter.addItem(new SingerItem("베리굿", "010-3030-3030", R.drawable.berrygood));

        //getCount로 item 갯수가 몇개인지 물어보고 getView를 그 개수만큼 호출하면서 뷰 객체를 받아서 화면에 보여주게 됨.

        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // 아이템을 클릭했을 때 발생하는 이벤트를 설정하는 리스너에서 받게 해달라
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) { // 아이템이 선택되면 호출, 객체를 정의한 코드 번위내에 있기때문에 바깥을 참조 할 수 없음
                SingerItem item = (SingerItem) adapter.getItem(i);

                Toast.makeText(getApplicationContext(), "선택 : " + item.getName(), Toast.LENGTH_LONG).show();
            }
        });

    }

    class SingerAdapter extends BaseAdapter// 기존에 제공되는 어댑터를 상속해서 필요한만큼 코드를 넣을 수 있게 함
    {
        //generate - > implement method 자동생성

        ArrayList<SingerItem> items = new ArrayList<SingerItem>();

        public void addItem(SingerItem item) // ArrayList item에 item 추가하는 메서드
        {
            items.add(item);
        }
        @Override
        public int getCount() { // 아이템의 개수가 몇개인지 알려줌
            return items.size();
        }

        @Override
        public Object getItem(int i) { // 아이템 넘겨주기
            return items.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            /* 실무 Tip. 뷰 객체가 너무 많이 만들어지면 메모리도 그만큼 소모된다
            코드를 재사용 할수 있도록 View view를 사용.
             */
            // 리턴 해주는 뷰는 레이아웃으로 구성이 되야한다.
            // 레이아웃을 부분화면으로 정의를 하고, 객체를 만든 다음에 데이터를 설정해주고 리턴한다.

            SingerItemView siv = null;
            if(view == null)
            {
                siv = new SingerItemView(getApplicationContext()); // 어떤 뷰든 안드로이드에서는 전부 다 컨텍스트 객체를 받게 되어있음.
            } else
            {
                siv = (SingerItemView) view; // view는 이미 사용했던것, 캐스팅만 해서 재활용
            }
            SingerItem item = items.get(i);
            siv.setName(item.getName());
            siv.setMobile(item.getMobile());
            siv.setImage(item.getResId());

            return siv; // 리스트 뷰 하나의 아이템으로 보임
        }
    }
}
