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
package org.kymjs.chat.bean;

/**
 * 聊天消息javabean
 *
 * @author kymjs (http://www.kymjs.com/)
 */
public class Message {
    public final static int MSG_TYPE_TEXT = 3;
    public final static int MSG_TYPE_PHOTO = 1;
    public final static int MSG_TYPE_FACE = 2;

    public final static int MSG_STATE_SENDING = 3;
    public final static int MSG_STATE_SUCCESS = 1;
    public final static int MSG_STATE_FAIL = 2;

    private int msg_type; // 0-text | 1-photo | 2-face | more type ...
    private int msg_state; // 0-sending | 1-success | 2-fail

    private String msg_id;//消息编号
    private String msg_comment_id;//评论编号
    private String msg_comment_avater;//评论人头像
    private String msg_comment_nick_name;//评论人昵称
    private String msg_comment_content;//评论内容
    private String msg_comment_create_time;//创建时间(格式"yyyy-MM-dd HH:mm:ss")
    private String msg_comment_parent_nick_name;//父评论昵称
    private String msg_comment_parent_content;//父评论内容
    private boolean msg_comment_parent_is_del;//父评论是否删除
    private int msg_comment_like_num;//赞的数量
    private String msg_comment_user_id;//用户的编号

    public Message(int msg_type, int msg_state, String msg_id, String msg_comment_id, String msg_comment_avater,
                   String msg_comment_nick_name, String msg_comment_content, String msg_comment_create_time,
                   String msg_comment_parent_nick_name, String msg_comment_parent_content, boolean msg_comment_parent_is_del,
                   int msg_comment_like_num, String msg_comment_user_id) {
        super();
        this.msg_type = msg_type;
        this.msg_state = msg_state;
        this.msg_id = msg_id;
        this.msg_comment_id = msg_comment_id;
        this.msg_comment_avater = msg_comment_avater;
        this.msg_comment_nick_name = msg_comment_nick_name;
        this.msg_comment_content = msg_comment_content;
        this.msg_comment_create_time = msg_comment_create_time;
        this.msg_comment_parent_nick_name = msg_comment_parent_nick_name;
        this.msg_comment_parent_content = msg_comment_parent_content;

        this.msg_comment_parent_is_del = msg_comment_parent_is_del;
        this.msg_comment_like_num = msg_comment_like_num;
        this.msg_comment_user_id = msg_comment_user_id;
    }

    public int getMsg_type() {
        return msg_type;
    }

    public void setMsg_type(int msg_type) {
        this.msg_type = msg_type;
    }

    public int getMsg_state() {
        return msg_state;
    }

    public void setMsg_state(int msg_state) {
        this.msg_state = msg_state;
    }

    public String getMsg_id() {
        return msg_id;
    }

    public void setMsg_id(String msg_id) {
        this.msg_id = msg_id;
    }

    public String getMsg_comment_id() {
        return msg_comment_id;
    }

    public void setMsg_comment_id(String msg_comment_id) {
        this.msg_comment_id = msg_comment_id;
    }

    public String getMsg_comment_avater() {
        return msg_comment_avater;
    }

    public void setMsg_comment_avater(String msg_comment_avater) {
        this.msg_comment_avater = msg_comment_avater;
    }

    public String getMsg_comment_nick_name() {
        return msg_comment_nick_name;
    }

    public void setMsg_comment_nick_name(String msg_comment_nick_name) {
        this.msg_comment_nick_name = msg_comment_nick_name;
    }

    public String getMsg_comment_content() {
        return msg_comment_content;
    }

    public void setMsg_comment_content(String msg_comment_content) {
        this.msg_comment_content = msg_comment_content;
    }

    public String getMsg_comment_create_time() {
        return msg_comment_create_time;
    }

    public void setMsg_comment_create_time(String msg_comment_create_time) {
        this.msg_comment_create_time = msg_comment_create_time;
    }

    public String getMsg_comment_parent_nick_name() {
        return msg_comment_parent_nick_name;
    }

    public void setMsg_comment_parent_nick_name(String msg_comment_parent_nick_name) {
        this.msg_comment_parent_nick_name = msg_comment_parent_nick_name;
    }

    public String getMsg_comment_parent_content() {
        return msg_comment_parent_content;
    }

    public void setMsg_comment_parent_content(String msg_comment_parent_content) {
        this.msg_comment_parent_content = msg_comment_parent_content;
    }

    public boolean isMsg_comment_parent_is_del() {
        return msg_comment_parent_is_del;
    }

    public void setMsg_comment_parent_is_del(boolean msg_comment_parent_is_del) {
        this.msg_comment_parent_is_del = msg_comment_parent_is_del;
    }

    public int getMsg_comment_like_num() {
        return msg_comment_like_num;
    }

    public void setMsg_comment_like_num(int msg_comment_like_num) {
        this.msg_comment_like_num = msg_comment_like_num;
    }

    public String getMsg_comment_user_id() {
        return msg_comment_user_id;
    }

    public void setMsg_comment_user_id(String msg_comment_user_id) {
        this.msg_comment_user_id = msg_comment_user_id;
    }

}
