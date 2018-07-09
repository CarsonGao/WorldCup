package wc.com.worldcup;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

public class ActivityCollector {
    /*
    管理Activity
     */
    //通过List暂存活动
    public static List<Activity> activities = new ArrayList<>();
    //向List添加活动
    public static void addActivity(Activity activity){
        activities.add(activity);
    }
    //从List中移除活动
    public static void removeActivity(Activity activity){
        activities.remove(activity);
    }
    //将List中所有活动全部销毁
    public static void finishAll(){
        for ( Activity activity : activities){
            if (!activity.isFinishing()){
                activity.finish();
            }
        }
    }
}
