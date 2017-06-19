/*
 * Copyright (c) 2015, 张涛.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kymjs.chat.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.rockerhieu.emojicon.EmojiconTextView;

import org.kymjs.chat.R;
import org.kymjs.chat.bean.MessageBean;
import org.kymjs.chat.inter.OnChatItemClickListener;
import org.kymjs.chat.view.CircleImageView;
import org.kymjs.chat.view.ImageLoad;
import org.kymjs.kjframe.KJBitmap;
import org.kymjs.kjframe.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kymjs (http://www.kymjs.com/) on 6/8/15.
 */
public class ChatAdapter extends BaseAdapter {

    private final Context cxt;
    private List<MessageBean> datas = null;
    private KJBitmap kjb;
    private OnChatItemClickListener listener;
    private ImageLoad imageLoad;

    public ChatAdapter(Context cxt, List<MessageBean> datas,OnChatItemClickListener listener) {
        this.cxt = cxt;
        if (datas == null) {
            datas = new ArrayList<MessageBean>(0);
        }
        imageLoad = new ImageLoad(this.cxt);
        this.datas = datas;
        kjb = new KJBitmap();
        this.listener = listener;
    }

    public void refresh(List<MessageBean> datas) {
        if (datas == null) {
            datas = new ArrayList<>(0);
        }
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public View getView(final int position, View v, ViewGroup parent) {
        final ViewHolder holder;
        if (v == null) {
            holder = new ViewHolder();
            v = View.inflate(cxt, R.layout.chat_item_list_right, null);
            holder.cImageView = (CircleImageView) v
                    .findViewById(R.id.msg_avater);
            holder.tv_nick_name = (TextView) v
                    .findViewById(R.id.msg_nick_name);
            holder.tv_create_time = (TextView) v
                    .findViewById(R.id.msg_create_time);
            holder.bt_comment = (ImageButton) v
                    .findViewById(R.id.msg_comment_bt);
            holder.msg_comment_content = (EmojiconTextView) v
                    .findViewById(R.id.msg_comment_content);
            holder.msg_comment_parent_content = (EmojiconTextView) v
                    .findViewById(R.id.msg_comment_parent_content);
            v.setTag(holder);
        } else {
            holder = (ViewHolder) v.getTag();
        }

        final MessageBean msgBean = datas.get(position);
        if (msgBean != null) {
            if (!TextUtils.isEmpty(msgBean.getMsg_comment_avater())) {
                imageLoad.loadImage(holder.cImageView,msgBean.getMsg_comment_avater());
            }

            holder.tv_nick_name.setText(msgBean.getMsg_comment_nick_name());
            holder.tv_create_time.setText(StringUtils.friendlyTime(msgBean.getMsg_comment_create_time()));
            holder.msg_comment_content.setText(msgBean.getMsg_comment_content());
            if (!TextUtils.isEmpty(msgBean.getMsg_comment_parent_content())) {
                holder.msg_comment_parent_content.setText(msgBean.getMsg_comment_parent_nick_name() + ":" + msgBean.getMsg_comment_parent_content());
                holder.msg_comment_parent_content.setVisibility(View.VISIBLE);
            } else {
                holder.msg_comment_parent_content.setVisibility(View.GONE);
            }
            holder.msg_comment_content.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // ToastManager.showToast(context, "bt_comment;" + position);
                    listener.onTextClick(msgBean, position);
                }
            });
            holder.bt_comment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // ToastManager.showToast(context, "bt_comment;" + position);
                    listener.onCommentClick(msgBean, position);
                }
            });
        }
        /*holder.tv_date.setText(StringUtils.friendlyTime(StringUtils.getDataTime("yyyy-MM-dd " +
                "HH:mm:ss")));
        holder.tv_date.setVisibility(View.VISIBLE);

        //如果是文本类型，则隐藏图片，如果是图片则隐藏文本
        if (data.getType() == MessageBean.MSG_TYPE_TEXT) {
            holder.img_chatimage.setVisibility(View.GONE);
            holder.tv_chatcontent.setVisibility(View.VISIBLE);
            if (data.getContent().contains("href")) {
                holder.tv_chatcontent = UrlUtils.handleHtmlText(holder.tv_chatcontent, data
                        .getContent());
            } else {
                holder.tv_chatcontent = UrlUtils.handleText(holder.tv_chatcontent, data
                        .getContent());
            }
        } else {
            holder.tv_chatcontent.setVisibility(View.GONE);
            holder.img_chatimage.setVisibility(View.VISIBLE);

            //如果内存缓存中有要显示的图片，且要显示的图片不是holder复用的图片，则什么也不做，否则显示一张加载中的图片
            if (kjb.getMemoryCache(data.getContent()) != null && data.getContent() != null &&
                    data.getContent().equals(holder.img_chatimage.getTag())) {
            } else {
                holder.img_chatimage.setImageResource(R.drawable.default_head);
            }
            kjb.display(holder.img_chatimage, data.getContent(), 300, 300);
        }

        //如果是表情或图片，则不显示气泡，如果是图片则显示气泡
        if (data.getType() != MessageBean.MSG_TYPE_TEXT) {
            holder.layout_content.setBackgroundResource(android.R.color.transparent);
        } else {
            if (data.getIsSend()) {
                holder.layout_content.setBackgroundResource(R.drawable.chat_to_bg_selector);
            } else {
                holder.layout_content.setBackgroundResource(R.drawable.chat_from_bg_selector);
            }
        }

        //显示头像
        if (data.getIsSend()) {
            kjb.display(holder.img_avatar, data.getFromUserAvatar());
        } else {
            kjb.display(holder.img_avatar, data.getToUserAvatar());
        }

        if (listener != null) {
            holder.tv_chatcontent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onTextClick(position);
                }
            });
            holder.img_chatimage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (data.getType()) {
                        case MessageBean.MSG_TYPE_PHOTO:
                            listener.onPhotoClick(position);
                            break;
                        case MessageBean.MSG_TYPE_FACE:
                            listener.onFaceClick(position);
                            break;
                    }
                }
            });
        }

        //消息发送的状态
        switch (data.getState()) {
            case MessageBean.MSG_STATE_FAIL:
                holder.progress.setVisibility(View.GONE);
                holder.img_sendfail.setVisibility(View.VISIBLE);
                break;
            case MessageBean.MSG_STATE_SUCCESS:
                holder.progress.setVisibility(View.GONE);
                holder.img_sendfail.setVisibility(View.GONE);
                break;
            case MessageBean.MSG_STATE_SENDING:
                holder.progress.setVisibility(View.VISIBLE);
                holder.img_sendfail.setVisibility(View.GONE);
                break;
        }*/
        return v;
    }

    static class ViewHolder {
//        TextView tv_date;
//        ImageView img_avatar;
//        TextView tv_chatcontent;
//        ImageView img_chatimage;
//        ImageView img_sendfail;
//        ProgressBar progress;
//        RelativeLayout layout_content;
        CircleImageView cImageView;// 头像
        TextView tv_nick_name;// 昵称
        TextView tv_create_time;// 创建时间
        ImageButton bt_comment;// 发布评论
        EmojiconTextView msg_comment_content;// 评论内容
        EmojiconTextView msg_comment_parent_content;// 父评论内容
    }
}
