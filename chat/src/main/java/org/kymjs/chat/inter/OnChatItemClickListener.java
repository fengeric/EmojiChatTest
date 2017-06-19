package org.kymjs.chat.inter;

/**
 * 聊天列表中对内容的点击事件监听
 */
public interface OnChatItemClickListener {
    void onPhotoClick(int position);

    void onTextClick(int position);

    void onFaceClick(int position);

    void onCommentClick(int position);
}
