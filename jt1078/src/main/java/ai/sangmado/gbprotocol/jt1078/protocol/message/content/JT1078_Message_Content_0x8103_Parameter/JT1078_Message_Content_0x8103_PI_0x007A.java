package ai.sangmado.gbprotocol.jt1078.protocol.message.content.JT1078_Message_Content_0x8103_Parameter;

import ai.sangmado.gbprotocol.jt808.protocol.IVersionedSpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808_Message_Content_0x8103_Parameter.JT808_Message_Content_0x8103_ParameterItem;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808_Message_Content_0x8103_Parameter.JT808_Message_Content_0x8103_ParameterItemId;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferWriter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 平台设置终端参数 - 参数项 - 视频相关报警屏蔽字
 */
@NoArgsConstructor
public class JT1078_Message_Content_0x8103_PI_0x007A extends JT808_Message_Content_0x8103_ParameterItem {
    public static final JT808_Message_Content_0x8103_ParameterItemId PARAMETER_ITEM_ID =
            JT1078_Message_Content_0x8103_ParameterItemId.JT1078_0x8103_0x007A;

    @Override
    public JT808_Message_Content_0x8103_ParameterItemId getParameterItemId() {
        return PARAMETER_ITEM_ID;
    }

    @Override
    public Integer getParameterItemLength() {
        return 4;
    }

    /**
     * 视频相关报警屏蔽字
     * <p>
     * 视频相关报警屏蔽字，和表13 的视频报警标志位定义相对应，相应位为1 则相应类型的报警被屏蔽
     */
    @Getter
    @Setter
    private Long videoRelatedWarningMaskWord;

    @Override
    public void serialize(IVersionedSpecificationContext ctx, IJT808MessageBufferWriter writer) {

    }

    @Override
    public void deserialize(IVersionedSpecificationContext ctx, IJT808MessageBufferReader reader) {

    }

    public static JT1078_Message_Content_0x8103_PI_0x007A decode(IVersionedSpecificationContext ctx, IJT808MessageBufferReader reader) {
        JT1078_Message_Content_0x8103_PI_0x007A content = new JT1078_Message_Content_0x8103_PI_0x007A();
        content.deserialize(ctx, reader);
        return content;
    }
}
