package org.kymjs.chat.inter;

import org.kymjs.chat.bean.MessageBean;

/**
 * 聊天列表中对内容的点击事件监听
 */
public interface OnChatItemClickListener {
    void onPhotoClick(MessageBean msgBean, int position);

    void onTextClick(MessageBean msgBean, int position);

    void onFaceClick(MessageBean msgBean, int position);

    void onCommentClick(MessageBean msgBean, int position);
}
