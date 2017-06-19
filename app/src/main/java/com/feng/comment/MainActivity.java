package com.feng.comment;

import android.widget.ListView;

import org.kymjs.chat.adapter.ChatAdapter;
import org.kymjs.chat.bean.Message;
import org.kymjs.chat.widget.KJChatKeyboard;
import org.kymjs.kjframe.KJActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends KJActivity {

    public static final int REQUEST_CODE_GETIMAGE_BYSDCARD = 0x1;

    private KJChatKeyboard box;
    private ListView mRealListView;

    List<Message> datas = new ArrayList<Message>();
    private ChatAdapter adapter;

    @Override
    public void setRootView() {
        setContentView(org.kymjs.chat.R.layout.activity_chat);
    }
/*
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
                Message message = new Message(Message.MSG_TYPE_TEXT, Message.MSG_STATE_SUCCESS,
                        "msg_id1", "msg_comment_id1", "http://images.057.com/FlRECihcVIo1WRJAwDldRxYti1Pq",
                        "nickname1", content, "2017-06-19 14:33:67", "msg_comment_parent_nick_name1","msg_comment_parent_content1",false,100,"msg_comment_user_id1");
                datas.add(message);
                adapter.refresh(datas);
            }

            @Override
            public void selectedFace(Faceicon content) {
                Message message = new Message(Message.MSG_TYPE_FACE, Message.MSG_STATE_SUCCESS,
                        "msg_id1", "msg_comment_id1", "http://images.057.com/FlRECihcVIo1WRJAwDldRxYti1Pq",
                        "nickname1", content.getPath(), "2017-06-19 14:33:67", "msg_comment_parent_nick_name1","msg_comment_parent_content1",false,100,"msg_comment_user_id1");
                datas.add(message);
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
                        ToastManager.showToast(MainActivity.this, "跳转相机");
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
        *//*Message message = new Message(Message.MSG_TYPE_TEXT,
                Message.MSG_STATE_SUCCESS, "\ue415", "avatar", "Jerry", "avatar",
                new String(emoji), false, true, new Date(System.currentTimeMillis()
                - (1000 * 60 * 60 * 24) * 8));
        Message message1 = new Message(Message.MSG_TYPE_TEXT,
                Message.MSG_STATE_SUCCESS, "Tom", "avatar", "Jerry", "avatar",
                "以后的版本支持链接高亮喔:http://www.kymjs.com支持http、https、svn、ftp开头的链接",
                true, true, new Date(System.currentTimeMillis() - (1000 * 60 * 60 * 24) * 8));
        Message message2 = new Message(Message.MSG_TYPE_PHOTO,
                Message.MSG_STATE_SUCCESS, "Tom", "avatar", "Jerry", "avatar",
                "http://static.oschina.net/uploads/space/2015/0611/103706_rpPc_1157342.png",
                false, true, new Date(
                System.currentTimeMillis() - (1000 * 60 * 60 * 24) * 7));
        Message message6 = new Message(Message.MSG_TYPE_TEXT,
                Message.MSG_STATE_FAIL, "Tom", "avatar", "Jerry", "avatar",
                "test send fail", true, false, new Date(
                System.currentTimeMillis() - (1000 * 60 * 60 * 24) * 6));
        Message message7 = new Message(Message.MSG_TYPE_TEXT,
                Message.MSG_STATE_SENDING, "Tom", "avatar", "Jerry", "avatar",
                "<a href=\"http://kymjs.com\">自定义链接</a>也是支持的", true, true, new Date(System.currentTimeMillis()
                - (1000 * 60 * 60 * 24) * 6));*//*
        Message message1 = new Message(Message.MSG_TYPE_TEXT, Message.MSG_STATE_SUCCESS,
                "msg_id1", "msg_comment_id1", "http://images.057.com/FlRECihcVIo1WRJAwDldRxYti1Pq",
                "nickname1", "message1", "2017-06-19 14:33:67", "msg_comment_parent_nick_name1","msg_comment_parent_content1",false,100,"msg_comment_user_id1");

        Message message2 = new Message(Message.MSG_TYPE_TEXT, Message.MSG_STATE_SUCCESS,
                "msg_id1", "msg_comment_id1", "http://images.057.com/FlRECihcVIo1WRJAwDldRxYti1Pq",
                "nickname1", "message2", "2017-06-19 14:33:67", "msg_comment_parent_nick_name1","msg_comment_parent_content1",false,100,"msg_comment_user_id1");

        Message message3 = new Message(Message.MSG_TYPE_TEXT, Message.MSG_STATE_SUCCESS,
                "msg_id1", "msg_comment_id1", "http://images.057.com/FlRECihcVIo1WRJAwDldRxYti1Pq",
                "nickname1", "message3", "2017-06-19 14:33:67", "msg_comment_parent_nick_name1","msg_comment_parent_content1",false,100,"msg_comment_user_id1");

        Message message4 = new Message(Message.MSG_TYPE_TEXT, Message.MSG_STATE_SUCCESS,
                "msg_id1", "msg_comment_id1", "http://images.057.com/FlRECihcVIo1WRJAwDldRxYti1Pq",
                "nickname1", "message4", "2017-06-19 14:33:67", "msg_comment_parent_nick_name1","msg_comment_parent_content1",false,100,"msg_comment_user_id1");

        Message message5 = new Message(Message.MSG_TYPE_TEXT, Message.MSG_STATE_SUCCESS,
                "msg_id1", "msg_comment_id1", "http://images.057.com/FlRECihcVIo1WRJAwDldRxYti1Pq",
                "nickname1", "message5", "2017-06-19 14:33:67", "msg_comment_parent_nick_name1","msg_comment_parent_content1",false,100,"msg_comment_user_id1");

        Message message6 = new Message(Message.MSG_TYPE_TEXT, Message.MSG_STATE_SUCCESS,
                "msg_id1", "msg_comment_id1", "http://images.057.com/FlRECihcVIo1WRJAwDldRxYti1Pq",
                "nickname1", "message6", "2017-06-19 14:33:67", "msg_comment_parent_nick_name1","msg_comment_parent_content1",false,100,"msg_comment_user_id1");
        Message message7 = new Message(Message.MSG_TYPE_TEXT, Message.MSG_STATE_SUCCESS,
                "msg_id1", "msg_comment_id1", "http://images.057.com/FlRECihcVIo1WRJAwDldRxYti1Pq",
                "nickname1", "message7", "2017-06-19 14:33:67", "msg_comment_parent_nick_name1","msg_comment_parent_content1",false,100,"msg_comment_user_id1");


        datas.add(message1);
        datas.add(message2);
        datas.add(message3);
        datas.add(message4);
        datas.add(message5);
        datas.add(message6);
        datas.add(message7);

        adapter = new ChatAdapter(this, datas, getOnChatItemClickListener());
        mRealListView.setAdapter(adapter);
    }

    *//*private void createReplayMsg(Message message) {
        final Message reMessage = new Message(message.getType(), Message.MSG_STATE_SUCCESS, "Tom",
                "avatar", "Jerry", "avatar", message.getType() == Message.MSG_TYPE_TEXT ? "返回:"
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
    }*//*

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && box.isShow()) {
            box.hideLayout();
            return true;
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }

    *//**
     * 跳转到选择相册界面
     *//*
    private void goToAlbum() {
        Intent intent;
        if (Build.VERSION.SDK_INT < 19) {
            intent = new Intent();
            intent.setAction(Intent.ACTION_GET_CONTENT);
            intent.setType("image*//*");
            startActivityForResult(Intent.createChooser(intent, "选择图片"),
                    REQUEST_CODE_GETIMAGE_BYSDCARD);
        } else {
            intent = new Intent(Intent.ACTION_PICK,
                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            intent.setType("image*//*");
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
        *//*if (requestCode == REQUEST_CODE_GETIMAGE_BYSDCARD) {
            Uri dataUri = data.getData();
            if (dataUri != null) {
                File file = FileUtils.uri2File(aty, dataUri);
                Message message = new Message(Message.MSG_TYPE_PHOTO, Message.MSG_STATE_SUCCESS,
                        "Tom", "avatar", "Jerry",
                        "avatar", file.getAbsolutePath(), true, true, new Date());
                datas.add(message);
                adapter.refresh(datas);
            }
        }*//*
    }

    *//**
     * 若软键盘或表情键盘弹起，点击上端空白处应该隐藏输入法键盘
     *
     * @return 会隐藏输入法键盘的触摸事件监听器
     *//*
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

    *//**
     * @return 聊天列表内存点击事件监听器
     *//*
    private ChatActivity.OnChatItemClickListener getOnChatItemClickListener() {
        return new ChatActivity.OnChatItemClickListener() {
            @Override
            public void onPhotoClick(int position) {
                *//*KJLoger.debug(datas.get(position).getContent() + "点击图片的");
                ViewInject.toast(aty, datas.get(position).getContent() + "点击图片的");*//*
                ToastManager.showToast(MainActivity.this, "onPhotoClick");
            }

            @Override
            public void onTextClick(int position) {
                ToastManager.showToast(MainActivity.this, "text:"+position);
            }

            @Override
            public void onFaceClick(int position) {
                ToastManager.showToast(MainActivity.this, "onFaceClick:" + position);
            }
        };
    }

    *//**
     * 聊天列表中对内容的点击事件监听
     *//*
    public interface OnChatItemClickListener {
        void onPhotoClick(int position);

        void onTextClick(int position);

        void onFaceClick(int position);

        void onFaceClick(int position);
    }*/
}

