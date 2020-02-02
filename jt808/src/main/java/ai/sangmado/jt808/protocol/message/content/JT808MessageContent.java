package ai.sangmado.jt808.protocol.message.content;

import ai.sangmado.jt808.protocol.ISpecificationContext;
import ai.sangmado.jt808.protocol.enums.JT808MessageId;
import ai.sangmado.jt808.protocol.exceptions.UnsupportedJT808OperationException;
import ai.sangmado.jt808.protocol.message.IJT808MessageFormatter;
import ai.sangmado.jt808.protocol.message.codec.IJT808MessageBufferWriter;
import ai.sangmado.jt808.protocol.message.codec.impl.JT808MessageByteBufferWriter;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * JT808 消息体
 */
public abstract class JT808MessageContent implements IJT808MessageFormatter {

    /**
     * 获取消息体定义的消息ID
     *
     * @return 消息ID
     */
    public abstract JT808MessageId getMessageId();

    /**
     * 获取消息体长度
     *
     * @param ctx 协议规范上下文
     * @return 消息体长度
     */
    public int getContentLength(ISpecificationContext ctx) {
        byte[] bufArray = new byte[256];
        ByteBuffer buf = ByteBuffer.wrap(bufArray);
        IJT808MessageBufferWriter bufWriter = new JT808MessageByteBufferWriter(ctx, buf);
        this.serialize(ctx, bufWriter);
        buf.flip();
        return buf.remaining();
    }

    /**
     * 是否能够按条件进行分包
     *
     * @param ctx 协议规范上下文
     * @return 是否能够按条件进行分包
     */
    public boolean couldSplitAccordingly(ISpecificationContext ctx) {
        return false;
    }

    /**
     * 获取分包长度
     *
     * @param ctx 协议规范上下文
     * @return 分包长度
     */
    public int getSplitByLength(ISpecificationContext ctx) {
        throw new UnsupportedJT808OperationException("未设置分包长度");
    }

    /**
     * 分包函数
     *
     * @param ctx 协议规范上下文
     * @return 分包列表
     */
    public List<JT808MessageContent> split(ISpecificationContext ctx) {
        if (!couldSplitAccordingly(ctx)) {
            throw new UnsupportedJT808OperationException("不适当的分包函数调用");
        }

        int contentLength = getContentLength(ctx);
        byte[] bufArray = new byte[contentLength];

        int splitByLength = getSplitByLength(ctx);
        int splitCount = (bufArray.length / splitByLength) + (bufArray.length % splitByLength > 0 ? 1 : 0);
        List<JT808MessageContent> splitContents = new ArrayList<>(splitCount);
        for (int i = 0; i < splitCount; i++) {
            int splitContentLength = (i < splitCount - 1) ? splitByLength : (bufArray.length % splitByLength);
            JT808MessageSplitContent child = new JT808MessageSplitContent(this, splitCount, i, splitContentLength);
            child.setSplitContent(ByteBuffer.wrap(bufArray, (i * splitByLength), splitContentLength));
            splitContents.add(child);
        }
        return splitContents;
    }
}
