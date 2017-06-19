package org.kymjs.chat;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;

import org.kymjs.chat.adapter.ChatAdapter;
import org.kymjs.chat.bean.Emojicon;
import org.kymjs.chat.bean.Faceicon;
import org.kymjs.chat.bean.MessageBean;
import org.kymjs.chat.emoji.DisplayRules;
import org.kymjs.chat.util.DateUtil;
import org.kymjs.chat.util.ToastManager;
import org.kymjs.chat.widget.KJChatKeyboard;
import org.kymjs.kjframe.KJActivity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends KJActivity {

    public static final int REQUEST_CODE_GETIMAGE_BYSDCARD = 0x1;

    private KJChatKeyboard box;
    private ListView mRealListView;

    List<MessageBean> datas = new ArrayList<MessageBean>();
    private ChatAdapter adapter;

    @Override
    public void setRootView() {
        setContentView(org.kymjs.chat.R.layout.activity_chat);
    }

    @Override
    public void initWidget() {
        super.initWidget();
        box = (KJChatKeyboard) findViewById(org.kymjs.chat.R.id.chat_msg_input_box);
        mRealListView = (ListView) findViewById(org.kymjs.chat.R.id.chat_listview);

        mRealListView.setSelector(android.R.color.transparent);
        initMessageInputToolBox();
        initListView();
    }

    private void initMessageInputToolBox() {
        box.setOnOperationListener(new OnOperationListener() {
            @Override
            public void send(String content) {
                if (TextUtils.isEmpty(content)) {
                    ToastManager.showToast(ChatActivity.this, "input content");
                    return;
                }
                MessageBean messageBean = new MessageBean(MessageBean.MSG_TYPE_TEXT, MessageBean.MSG_STATE_SUCCESS,
                        "msg_id1", "msg_comment_id1", "http://images.057.com/FlRECihcVIo1WRJAwDldRxYti1Pq",
                        "nickname1", content, DateUtil.transNowTime(), "msg_comment_parent_nick_name1", "msg_comment_parent_content1", false, 100, "msg_comment_user_id1");
                datas.add(messageBean);
                adapter.refresh(datas);
            }

            @Override
            public void selectedFace(Faceicon content) {
                MessageBean messageBean = new MessageBean(MessageBean.MSG_TYPE_FACE, MessageBean.MSG_STATE_SUCCESS,
                        "msg_id1", "msg_comment_id1", "http://images.057.com/FlRECihcVIo1WRJAwDldRxYti1Pq",
                        "nickname1", content.getPath(), "2017-06-19 14:33:67", "msg_comment_parent_nick_name1", "msg_comment_parent_content1", false, 100, "msg_comment_user_id1");
                datas.add(messageBean);
                adapter.refresh(datas);
            }

            @Override
            public void selectedEmoji(Emojicon emoji) {
                box.getEditTextBox().append(emoji.getValue());
            }

            @Override
            public void selectedBackSpace(Emojicon back) {
                DisplayRules.backspace(box.getEditTextBox());
            }

            @Override
            public void selectedFunction(int index) {
                switch (index) {
                    case 0:
                        goToAlbum();
                        break;
                    case 1:
                        //ViewInject.toast("跳转相机");
                        ToastManager.showToast(ChatActivity.this, "跳转相机");
                        break;
                }
            }
        });

        List<String> faceCagegory = new ArrayList<>();
//        File faceList = FileUtils.getSaveFolder("chat");
        File faceList = new File("");
        if (faceList.isDirectory()) {
            File[] faceFolderArray = faceList.listFiles();
            for (File folder : faceFolderArray) {
                if (!folder.isHidden()) {
                    faceCagegory.add(folder.getAbsolutePath());
                }
            }
        }

        box.setFaceData(faceCagegory);
        mRealListView.setOnTouchListener(getOnTouchListener());
    }

    private void initListView() {
        byte[] emoji = new byte[]{
                (byte) 0xF0, (byte) 0x9F, (byte) 0x98, (byte) 0x81
        };
        /*MessageBean message = new MessageBean(MessageBean.MSG_TYPE_TEXT,
                MessageBean.MSG_STATE_SUCCESS, "\ue415", "avatar", "Jerry", "avatar",
                new String(emoji), false, true, new Date(System.currentTimeMillis()
                - (1000 * 60 * 60 * 24) * 8));
        MessageBean messageBean1 = new MessageBean(MessageBean.MSG_TYPE_TEXT,
                MessageBean.MSG_STATE_SUCCESS, "Tom", "avatar", "Jerry", "avatar",
                "以后的版本支持链接高亮喔:http://www.kymjs.com支持http、https、svn、ftp开头的链接",
                true, true, new Date(System.currentTimeMillis() - (1000 * 60 * 60 * 24) * 8));
        MessageBean messageBean2 = new MessageBean(MessageBean.MSG_TYPE_PHOTO,
                MessageBean.MSG_STATE_SUCCESS, "Tom", "avatar", "Jerry", "avatar",
                "http://static.oschina.net/uploads/space/2015/0611/103706_rpPc_1157342.png",
                false, true, new Date(
                System.currentTimeMillis() - (1000 * 60 * 60 * 24) * 7));
        MessageBean messageBean6 = new MessageBean(MessageBean.MSG_TYPE_TEXT,
                MessageBean.MSG_STATE_FAIL, "Tom", "avatar", "Jerry", "avatar",
                "test send fail", true, false, new Date(
                System.currentTimeMillis() - (1000 * 60 * 60 * 24) * 6));
        MessageBean messageBean7 = new MessageBean(MessageBean.MSG_TYPE_TEXT,
                MessageBean.MSG_STATE_SENDING, "Tom", "avatar", "Jerry", "avatar",
                "<a href=\"http://kymjs.com\">自定义链接</a>也是支持的", true, true, new Date(System.currentTimeMillis()
                - (1000 * 60 * 60 * 24) * 6));*/
        MessageBean messageBean1 = new MessageBean(MessageBean.MSG_TYPE_TEXT, MessageBean.MSG_STATE_SUCCESS,
                "msg_id1", "msg_comment_id1", "http://images.057.com/FlRECihcVIo1WRJAwDldRxYti1Pq",
                "nickname1", "message1message1message1message1message1message1message1message1message1message1message1message1message1message1message1message1message1", "2016-06-19 14:33:67", "msg_comment_parent_nick_name1", "", false, 101, "msg_comment_user_id1");

        MessageBean messageBean2 = new MessageBean(MessageBean.MSG_TYPE_TEXT, MessageBean.MSG_STATE_SUCCESS,
                "msg_id2", "msg_comment_id1", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1497864978450&di=68b127823f451fda353b7709444692de&imgtype=0&src=http%3A%2F%2Ftupian.enterdesk.com%2F2012%2F0602%2Fyt%2F18%2F73869f30446c7978916445105b015d97.jpg",
                "nickname2", "messageBean2", "2017-06-19 14:49:67", "msg_comment_parent_nick_name2", "msg_comment_parent_content2", false, 102, "msg_comment_user_id2");

        MessageBean messageBean3 = new MessageBean(MessageBean.MSG_TYPE_TEXT, MessageBean.MSG_STATE_SUCCESS,
                "msg_id3", "msg_comment_id1", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1497864978446&di=e00c8be0a84c0ce718127e530b24c82d&imgtype=0&src=http%3A%2F%2Ftupian.enterdesk.com%2F2013%2Fxll%2F012%2F05%2F9%2F7.jpg",
                "nickname3", "messageBean3", "2017-06-14 14:33:67", "msg_comment_parent_nick_name3", "msg_comment_parent_content3", false, 103, "msg_comment_user_id3");

        MessageBean messageBean4 = new MessageBean(MessageBean.MSG_TYPE_TEXT, MessageBean.MSG_STATE_SUCCESS,
                "msg_id4", "msg_comment_id1", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1497864978447&di=8529af65b1312b0502f41615a3089ebd&imgtype=0&src=http%3A%2F%2Fimg4q.duitang.com%2Fuploads%2Fitem%2F201505%2F10%2F20150510055619_ZhsMQ.thumb.224_0.jpeg",
                "nickname4", "messageBean4", "2017-06-15 14:33:67", "msg_comment_parent_nick_name4", "msg_comment_parent_content4", false, 104, "msg_comment_user_id4");

        MessageBean messageBean5 = new MessageBean(MessageBean.MSG_TYPE_TEXT, MessageBean.MSG_STATE_SUCCESS,
                "msg_id1", "msg_comment_id1", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1497864978447&di=05a9c95ba42fe36c32d8b75c7187594a&imgtype=0&src=http%3A%2F%2Ftupian.aladd.net%2F2014%2F6%2F37.jpg",
                "nickname5", "messageBean5", "2017-06-16 14:33:67", "msg_comment_parent_nick_name5", "msg_comment_parent_content5", false, 105, "msg_comment_user_id5");

        MessageBean messageBean6 = new MessageBean(MessageBean.MSG_TYPE_TEXT, MessageBean.MSG_STATE_SUCCESS,
                "msg_id6", "msg_comment_id1", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1497864978447&di=95f47767514275462af92f4fc940bc63&imgtype=0&src=http%3A%2F%2Fimg.qqzhi.com%2Fupload%2Fimg_1_2808233116D177345603_23.jpg",
                "nickname6", "messageBean6", "2017-06-17 14:33:67", "msg_comment_parent_nick_name6", "msg_comment_parent_content6", false, 106, "msg_comment_user_id6");
        MessageBean messageBean7 = new MessageBean(MessageBean.MSG_TYPE_TEXT, MessageBean.MSG_STATE_SUCCESS,
                "msg_id7", "msg_comment_id1", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1497864978447&di=8aaa2513ba1ef5743006cabc1530c92a&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F609*342%2F22130.jpg",
                "nickname7", "messageBean7", "2017-06-18 14:33:67", "msg_comment_parent_nick_name7", "msg_comment_parent_content7", false, 107, "msg_comment_user_id7");


        datas.add(messageBean1);
        datas.add(messageBean2);
        datas.add(messageBean3);
        datas.add(messageBean4);
        datas.add(messageBean5);
        datas.add(messageBean6);
        datas.add(messageBean7);

        adapter = new ChatAdapter(this, datas, getOnChatItemClickListener());
        mRealListView.setAdapter(adapter);
    }

    /*private void createReplayMsg(MessageBean message) {
        final MessageBean reMessage = new MessageBean(message.getType(), MessageBean.MSG_STATE_SUCCESS, "Tom",
                "avatar", "Jerry", "avatar", message.getType() == MessageBean.MSG_TYPE_TEXT ? "返回:"
                + message.getContent() : message.getContent(), false,
                true, new Date());
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000 * (new Random().nextInt(3) + 1));
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            datas.add(reMessage);
                            adapter.refresh(datas);
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }*/

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && box.isShow()) {
            box.hideLayout();
            return true;
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }

    /**
     * 跳转到选择相册界面
     */
    private void goToAlbum() {
        Intent intent;
        if (Build.VERSION.SDK_INT < 19) {
            intent = new Intent();
            intent.setAction(Intent.ACTION_GET_CONTENT);
            intent.setType("image/*");
            startActivityForResult(Intent.createChooser(intent, "选择图片"),
                    REQUEST_CODE_GETIMAGE_BYSDCARD);
        } else {
            intent = new Intent(Intent.ACTION_PICK,
                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            intent.setType("image/*");
            startActivityForResult(Intent.createChooser(intent, "选择图片"),
                    REQUEST_CODE_GETIMAGE_BYSDCARD);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != Activity.RESULT_OK) {
            return;
        }
        /*if (requestCode == REQUEST_CODE_GETIMAGE_BYSDCARD) {
            Uri dataUri = data.getData();
            if (dataUri != null) {
                File file = FileUtils.uri2File(aty, dataUri);
                MessageBean message = new MessageBean(MessageBean.MSG_TYPE_PHOTO, MessageBean.MSG_STATE_SUCCESS,
                        "Tom", "avatar", "Jerry",
                        "avatar", file.getAbsolutePath(), true, true, new Date());
                datas.add(message);
                adapter.refresh(datas);
            }
        }*/
    }

    /**
     * 若软键盘或表情键盘弹起，点击上端空白处应该隐藏输入法键盘
     *
     * @return 会隐藏输入法键盘的触摸事件监听器
     */
    private View.OnTouchListener getOnTouchListener() {
        return new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                box.hideLayout();
                box.hideKeyboard(aty);
                return false;
            }
        };
    }

    /**
     * @return 聊天列表内存点击事件监听器
     */
    private ChatActivity.OnChatItemClickListener getOnChatItemClickListener() {
        return new ChatActivity.OnChatItemClickListener() {
            @Override
            public void onPhotoClick(int position) {
                /*KJLoger.debug(datas.get(position).getContent() + "点击图片的");
                ViewInject.toast(aty, datas.get(position).getContent() + "点击图片的");*/
                ToastManager.showToast(ChatActivity.this, "onPhotoClick");
            }

            @Override
            public void onTextClick(int position) {
                ToastManager.showToast(ChatActivity.this, "text:" + position);

            }

            @Override
            public void onFaceClick(int position) {
                ToastManager.showToast(ChatActivity.this, "onFaceClick:" + position);
            }

            @Override
            public void onCommentClick(int position) {
                ToastManager.showToast(ChatActivity.this, "onCommentClick:" + position);
            }
        };
    }

    /**
     * 聊天列表中对内容的点击事件监听
     */
    public interface OnChatItemClickListener {
        void onPhotoClick(int position);

        void onTextClick(int position);

        void onFaceClick(int position);

        void onCommentClick(int position);
    }
}

