package ai.sangmado.gbprotocol.jt1078.protocol.message.content.JT1078_Message_Content_0x8103_Parameter;

import ai.sangmado.gbprotocol.jt1078.protocol.enums.LogicalChannelNumber;
import ai.sangmado.gbprotocol.jt808.protocol.IVersionedSpecificationContext;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808_Message_Content_0x8103_Parameter.JT808_Message_Content_0x8103_ParameterItem;
import ai.sangmado.gbprotocol.jt808.protocol.message.content.JT808_Message_Content_0x8103_Parameter.JT808_Message_Content_0x8103_ParameterItemId;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferReader;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageBufferWriter;
import ai.sangmado.gbprotocol.jt808.protocol.serialization.IJT808MessageFormatter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * 平台设置终端参数 - 参数项 - 单独视频通道参数设置
 */
@NoArgsConstructor
public class JT1078_Message_Content_0x8103_PI_0x0077 extends JT808_Message_Content_0x8103_ParameterItem {
    public static final JT808_Message_Content_0x8103_ParameterItemId PARAMETER_ITEM_ID =
            JT1078_Message_Content_0x8103_ParameterItemId.JT1078_0x8103_0x0077;

    @Override
    public JT808_Message_Content_0x8103_ParameterItemId getParameterItemId() {
        return PARAMETER_ITEM_ID;
    }

    @Override
    public Integer getParameterItemLength() {
        return 4;
    }

    /**
     * 需单独设置视频参数的通道数量
     */
    @Getter
    @Setter
    private Integer channelCount;

    /**
     * 单独通道视频参数设置列表
     */
    @Getter
    @Setter
    private List<ChannelVideoParameterConfiguration> configurations;

    /**
     * 单独通道视频参数设置
     */
    @Getter
    @Setter
    @NoArgsConstructor
    public static class ChannelVideoParameterConfiguration implements IJT808MessageFormatter {
        /**
         * 逻辑通道号
         */
        private LogicalChannelNumber logicalChannelNumber;
        /**
         * 实时流编码模式
         * <p>
         * 0：CBR(固定码率)；
         * 1：VBR(可变码率)；
         * 2：ABR(平均码率)；
         * 100 ～127：自定义
         */
        @Getter
        @Setter
        private Integer realtimeStreamEncoding;
        /**
         * 实时流分辨率
         * <p>
         * 0：QCIF；
         * 1：CIF；
         * 2：WCIF；
         * 3：D1；
         * 4：WD1；
         * 5：720P；
         * 6：1 080P；
         * 100 ～127：自定义
         */
        @Getter
        @Setter
        private Integer realtimeStreamResolution;
        /**
         * 实时流关键帧间隔
         * <p>
         * 范围(1 ～1000)帧
         */
        @Getter
        @Setter
        private Integer realtimeStreamKeyFrameInterval;
        /**
         * 实时流目标帧率
         * <p>
         * 范围(1～120)帧/s
         */
        @Getter
        @Setter
        private Integer realtimeStreamTargetFps;
        /**
         * 实时流目标码率
         * <p>
         * 单位为千位每秒(kbps)
         */
        @Getter
        @Setter
        private Long realtimeStreamTargetBitRate;
        /**
         * 存储流编码模式
         * <p>
         * 0：CBR(固定码率)；
         * 1：VBR(可变码率)；
         * 2：ABR(平均码率)；
         * 100 ～127：自定义
         */
        @Getter
        @Setter
        private Integer storageStreamEncoding;
        /**
         * 存储流分辨率
         * <p>
         * 0：QCIF；
         * 1：CIF；
         * 2：WCIF；
         * 3：D1；
         * 4：WD1；
         * 5：720P；
         * 6：1 080P；
         * 100 ～127：自定义
         */
        @Getter
        @Setter
        private Integer storageStreamResolution;
        /**
         * 存储流关键帧间隔
         * <p>
         * 范围(1 ～1 000)帧
         */
        @Getter
        @Setter
        private Integer storageStreamKeyFrameInterval;
        /**
         * 存储流目标帧率
         * <p>
         * 范围(1～120)帧/s
         */
        @Getter
        @Setter
        private Integer storageStreamTargetFps;
        /**
         * 存储流目标码率
         * <p>
         * 单位为千位每秒(kbps)
         */
        @Getter
        @Setter
        private Long storageStreamTargetBitRate;
        /**
         * OSD字幕叠加设置
         * <p>
         * 按位设置：0 表示不叠加，1 表示叠加；
         * bit0：日期和时间；
         * bit1：车牌号码；
         * bit2：逻辑通道号；
         * bit3：经纬度；
         * bit4：行驶记录速度；
         * bit5：卫星定位速度；
         * bit6：连续驾驶时间；
         * bit7 ～ bit10：保留；
         * bit11 ～ bit15：自定义
         */
        @Getter
        @Setter
        private Integer osdOverlaySetting;

        @Override
        public void serialize(IVersionedSpecificationContext ctx, IJT808MessageBufferWriter writer) {

        }

        @Override
        public void deserialize(IVersionedSpecificationContext ctx, IJT808MessageBufferReader reader) {

        }
    }

    @Override
    public void serialize(IVersionedSpecificationContext ctx, IJT808MessageBufferWriter writer) {

    }

    @Override
    public void deserialize(IVersionedSpecificationContext ctx, IJT808MessageBufferReader reader) {

    }

    public static JT1078_Message_Content_0x8103_PI_0x0077 decode(IVersionedSpecificationContext ctx, IJT808MessageBufferReader reader) {
        JT1078_Message_Content_0x8103_PI_0x0077 content = new JT1078_Message_Content_0x8103_PI_0x0077();
        content.deserialize(ctx, reader);
        return content;
    }
}
