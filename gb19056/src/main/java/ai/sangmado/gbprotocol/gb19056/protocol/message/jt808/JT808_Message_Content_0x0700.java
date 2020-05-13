package ai.sangmado.gbprotocol.gb19056.protocol.message.jt808;

import ai.sangmado.gbprotocol.gb19056.protocol.message.content.GB19056MessagePacket;
import ai.sangmado.gbprotocol.gbcommon.enums.IMessageId;
import ai.sangmado.gbprotocol.jt808.protocol.ISpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.enums.JT808MessageId;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808MessageContent;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferWriter;
import lombok.*;

/**
 * 终端􏰉􏱀􏰏行驶记录仪数据上传
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JT808_Message_Content_0x0700<T extends IMessageId> extends JT808MessageContent {
    public static final JT808MessageId MESSAGE_ID = JT808MessageId.JT808_Message_0x0700;

    @Override
    public JT808MessageId getMessageId() {
        return MESSAGE_ID;
    }

    /**
     * 应答流水号
     */
    private Integer ackSerialNumber;
    /**
     * 命令字
     */
    private Integer commandId;
    /**
     * 数据块
     */
    private GB19056MessagePacket<T> packet;

    @Override
    public void serialize(ISpecificationContext ctx, IJT808MessageBufferWriter writer) {

    }

    @Override
    public void deserialize(ISpecificationContext ctx, IJT808MessageBufferReader reader) {

    }

    public static <T extends IMessageId> JT808_Message_Content_0x0700<T> decode(ISpecificationContext ctx, IJT808MessageBufferReader reader) {
        JT808_Message_Content_0x0700<T> content = new JT808_Message_Content_0x0700<>();
        content.deserialize(ctx, reader);
        return content;
    }
}