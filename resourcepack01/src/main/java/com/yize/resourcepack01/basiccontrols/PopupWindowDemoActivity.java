package com.yize.resourcepack01.basiccontrols;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.yize.resourcepack01.R;
import com.yize.tools.base.BaseDemoActivity;
import com.yize.tools.utils.ScaleUtil;
import com.yize.tools.utils.WindowUtil;

/**
 * @Desc: 弹窗演示页
 * @Date: 2022年01月22日
 * @Time: 12:15
 * @Author: 李易泽
 */
public class PopupWindowDemoActivity extends BaseDemoActivity {
    private static final String TAG = "PopupWindowDemoActivity";
    private ScrollView mSvPage;
    private LinearLayout mLlPage;

    @Override
    protected int initViewRes() {
        return R.layout.activity_popup_window_demo;
    }

    @Override
    protected String initPageTitle() {
        return getString(R.string.str_popup_window_demo_activity_name);
    }

    @Override
    protected void initView() {
        mSvPage = findViewById(R.id.sv_page);
        mLlPage = findViewById(R.id.ll_page);
    }

    @Override
    protected void initData() {

    }

    /**
     * 初始化AlertDialog弹窗
     *
     * @param message 文本信息
     * @return AlertDialog.Builder
     */
    private AlertDialog.Builder initAlertDialog(String message) {
        return new AlertDialog.Builder(this)
                .setMessage(message);
    }

    public void basicToast(View view) {
        Toast.makeText(this, "这是一个最基本的Toast", Toast.LENGTH_SHORT).show();
    }

    public void centeredToast(View view) {
        Toast toast = Toast.makeText(this, "这是一个居中显示的Toast", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    public void randomLocationToast(View view) {
        Toast toast = Toast.makeText(this, "这是一个随机位置的Toast", Toast.LENGTH_SHORT);
        int w, h, bW, bH;
        bW = (int) Math.round(Math.random() * -1);
        w = (int) (Math.random() * (WindowUtil.getScreenWidth(this) / 2));
        if (bW == -1) {
            w = (w * -1);
        }
        bH = (int) Math.round(Math.random() * -1);
        h = (int) (Math.random() * (WindowUtil.getScreenWidth(this) / 2));
        if (bH == -1) {
            h = (h * -1);
        }
        //TODO 日志输出配置
        Log.d(TAG, "w-" + w + ", h-" + h);
        toast.setGravity(Gravity.CENTER, w, h);
        toast.show();
    }

    public void longTimeShowToast(View view) {
        Toast.makeText(this, "这是一个长时间显示的Toast", Toast.LENGTH_LONG).show();
    }

    public void includeImageToast(View view) {
        Toast toast = Toast.makeText(this, "这是一个包含图片的Toast", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        LinearLayout toastView = (LinearLayout) toast.getView();
        ImageView imageCodeProject = new ImageView(this);
        imageCodeProject.setImageResource(R.mipmap.ic_cherry);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(20, 20, 20, 0);
        layoutParams.gravity = Gravity.CENTER;
        imageCodeProject.setLayoutParams(layoutParams);
        toastView.addView(imageCodeProject, 0);
        toast.show();
    }

    @SuppressLint("SetTextI18n")
    public void customizeToast(View view) {
        View toastView = getLayoutInflater().inflate(
                R.layout.layout_customize_toast_view, findViewById(R.id.cl_toast_view));
        TextView textView = toastView.findViewById(R.id.tv_text_show);
        textView.setText("这是一个完全自定义的Toast");
        Toast toast = new Toast(this);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(toastView);
        toast.show();
    }

    public void basicDialogFirst(View view) {
        Dialog dialog = new Dialog(this);
        View dialogView = getLayoutInflater().inflate(
                R.layout.layout_customize_dialog_view, findViewById(R.id.cl_dialog_view));
        dialogView.findViewById(R.id.tv_submit).setVisibility(View.GONE);
        dialog.setContentView(dialogView);
        Window window = dialog.getWindow();
        window.setBackgroundDrawableResource(android.R.color.transparent);
        window.getAttributes().width = ScaleUtil.dp2Px(this, 250f);
        dialog.show();
    }

    public void basicDialogSecond(View view) {
        Dialog dialog = new Dialog(this);
        dialog.setCancelable(false);
        View dialogView = getLayoutInflater().inflate(
                R.layout.layout_customize_dialog_view, findViewById(R.id.cl_dialog_view));
        TextView submitButton = dialogView.findViewById(R.id.tv_submit);
        submitButton.setTag(dialog);
        submitButton.setOnClickListener(v -> ((Dialog) v.getTag()).dismiss());
        dialog.setContentView(dialogView);
        Window window = dialog.getWindow();
        window.setBackgroundDrawableResource(android.R.color.transparent);
        window.getAttributes().width = ScaleUtil.dp2Px(this, 250f);
        dialog.show();
    }

    public void basicAlertDialog(View view) {
        initAlertDialog("这是一个最基本的AlertDialog").create().show();
    }

    public void withTitleAlertDialog(View view) {
        initAlertDialog("这是一个带标题的AlertDialog")
                .setTitle("提示")
                .create().show();
    }

    public void withButtonAlertDialog(View view) {
        initAlertDialog("这是一个带按钮的AlertDialog")
                .setTitle("提示")
                .setPositiveButton("确定", (dialog, which) -> Toast.makeText(
                        PopupWindowDemoActivity.this, "点击了确定",
                        Toast.LENGTH_LONG).show())
                .create().show();
    }

    public void withDoubleButtonsAlertDialog(View view) {
        initAlertDialog("是否执行操作？")
                .setTitle("两个按钮的提示框")
                .setPositiveButton("确定", (dialog, which) -> Toast.makeText(
                        PopupWindowDemoActivity.this, "点击了确定",
                        Toast.LENGTH_LONG).show())
                .setNegativeButton("取消", (dialog, which) -> Toast.makeText(
                        PopupWindowDemoActivity.this, "点击了取消",
                        Toast.LENGTH_LONG).show())
                .create().show();
    }

    public void withThreeButtonsAlertDialog(View view) {
        initAlertDialog("是否执行操作？")
                .setTitle("三个按钮的提示框")
                .setPositiveButton("确定", (dialog, which) -> Toast.makeText(
                        PopupWindowDemoActivity.this, "点击了确定",
                        Toast.LENGTH_LONG).show())
                .setNegativeButton("取消", (dialog, which) -> Toast.makeText(
                        PopupWindowDemoActivity.this, "点击了取消",
                        Toast.LENGTH_LONG).show())
                .setNeutralButton("信息", (dialog, which) -> Toast.makeText(
                        PopupWindowDemoActivity.this, "点击了信息",
                        Toast.LENGTH_LONG).show())
                .create().show();
    }

    public void customPageAlertDialog(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //弹窗点击周围区域不关闭
        builder.setCancelable(false);
        //得到子布局
        View dialogView = View.inflate(this, R.layout.layout_customize_dialog_view, null);
        //获取控件Id
        TextView submit = dialogView.findViewById(R.id.tv_submit);
        //绑定视图
        builder.setView(dialogView);
        builder.create();
        AlertDialog alertDialog = builder.show();
        alertDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        //设置点击事件
        submit.setTag(alertDialog);
        submit.setOnClickListener(v -> ((AlertDialog) v.getTag()).dismiss());
    }

    public void basicProgressDialog(View view) {
        ProgressDialog.show(PopupWindowDemoActivity.this,
                "提示", "资源加载中……").setCancelable(true);
    }

    public void detailedProgressDialogFirst(View view) {
        ProgressDialog progressDialog = new ProgressDialog(PopupWindowDemoActivity.this);
        progressDialog.setTitle("提示");
        progressDialog.setMessage("资源加载中……");
        //设置进度样式
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        //设置进度条是否可以按退回键取消
        progressDialog.setCancelable(true);
        //设置进度条是否可以点击空白区域取消
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
    }

    public void detailedProgressDialogSecond(View view) {
        ProgressDialog progressDialog = new ProgressDialog(PopupWindowDemoActivity.this);
        progressDialog.setTitle("保存资源");
        progressDialog.setMessage("正在保存资源，请稍等……");
        progressDialog.setCancelable(false);
        //设置进度样式
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        //设置ProgressDialog的一个Button
        progressDialog.setButton("取消", (dialog, which) -> Toast.makeText(
                PopupWindowDemoActivity.this, "您已取消保存操作！",
                Toast.LENGTH_LONG).show());
        progressDialog.show();
        //配置进度
        progressDialog.setProgress(50);
    }

    public void textPopupWindow(View view) {
        mLlPage.setVisibility(View.VISIBLE);
        mSvPage.setVisibility(View.GONE);
    }

    public void leftPopupWindow(View view) {
        createPopupWindow(ViewGroup.LayoutParams.WRAP_CONTENT)
                .showAsDropDown(view);
    }

    public void rightPopupWindow(View view) {
        //获取控件宽
        int width = view.getWidth();
        createPopupWindow(ViewGroup.LayoutParams.WRAP_CONTENT)
                .showAsDropDown(view, width / 8, 0);
    }

    public void bottomPopupWindow(View view) {
        createPopupWindow(ViewGroup.LayoutParams.MATCH_PARENT)
                .showAtLocation(view, Gravity.BOTTOM, 0, 0);
    }

    public void back(View view) {
        mLlPage.setVisibility(View.GONE);
        mSvPage.setVisibility(View.VISIBLE);
    }

    @NonNull
    private PopupWindow createPopupWindow(int wrapContent) {
        //获取视图对象
        View view = View.inflate(this, R.layout.layout_popup_window_menu_content, null);
        //创建PopupWindow    1.视图   2.宽   3.高
        PopupWindow popupWindow = new PopupWindow(view, wrapContent,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        //设置背景
        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#EEEEEE")));
        //设置焦点
        popupWindow.setFocusable(true);
        //设置可以触摸弹出框以外的区域
        popupWindow.setOutsideTouchable(true);
        //视图布局配置
        LinearLayout firstItem = view.findViewById(R.id.ll_first_item);
        LinearLayout secondItem = view.findViewById(R.id.ll_second_item);
        LinearLayout thirdItem = view.findViewById(R.id.ll_third_item);
        if (wrapContent == ViewGroup.LayoutParams.MATCH_PARENT) {
            firstItem.getLayoutParams().width = LinearLayout.LayoutParams.MATCH_PARENT;
            secondItem.getLayoutParams().width = LinearLayout.LayoutParams.MATCH_PARENT;
            thirdItem.getLayoutParams().width = LinearLayout.LayoutParams.MATCH_PARENT;
        }
        firstItem.setTag(popupWindow);
        secondItem.setTag(popupWindow);
        thirdItem.setTag(popupWindow);
        firstItem.setOnClickListener(v -> {
            Toast.makeText(PopupWindowDemoActivity.this,
                    "点击了QQ", Toast.LENGTH_SHORT).show();
            ((PopupWindow) v.getTag()).dismiss();
        });
        secondItem.setOnClickListener(v -> {
            Toast.makeText(PopupWindowDemoActivity.this,
                    "点击了微信", Toast.LENGTH_SHORT).show();
            ((PopupWindow) v.getTag()).dismiss();
        });
        thirdItem.setOnClickListener(v -> {
            Toast.makeText(PopupWindowDemoActivity.this,
                    "点击了支付宝", Toast.LENGTH_SHORT).show();
            ((PopupWindow) v.getTag()).dismiss();
        });
        return popupWindow;
    }
}