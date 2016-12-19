package one.lee.myexpandtextdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseArray;

import cn.carbs.android.expandabletextview.library.ExpandableTextView;

public class MainActivity extends AppCompatActivity  implements ExpandableTextView.OnExpandListener{

    String str = "很简单的一个Demo，就是一张“安第斯山脉”全景图，没有其他交互，内容也没什么好说的，你可以转动头部查看四周的环境，受制于手机硬件配置，不同的设备在转动时，延迟可能不同，反正我的测试机对VR的体验不算太好，是时候换个pixel XL或华为Mate9了.";
    private ExpandableTextView etv;
    private int etvWidth;
    private SparseArray<Integer> mPositionsAndStates = new SparseArray<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etv = (ExpandableTextView) findViewById(R.id.etv);

        if(etvWidth == 0){
            etv.post(new Runnable() {
                @Override
                public void run() {
                    etvWidth = etv.getWidth();
                }
            });
        }
        etv.setExpandListener(this);
        Integer state = mPositionsAndStates.get(0);
        etv.updateForRecyclerView(str, etvWidth, state== null ? 0 : state);
    }

    @Override
    public void onExpand(ExpandableTextView view) {
//        Object obj = view.getTag();
//        if(obj != null && obj instanceof Integer){
//            mPositionsAndStates.put((Integer)obj, view.getExpandState());
//        }
    }

    @Override
    public void onShrink(ExpandableTextView view) {
//        Object obj = view.getTag();
//        if(obj != null && obj instanceof Integer){
//            mPositionsAndStates.put((Integer)obj, view.getExpandState());
//        }
    }
}
