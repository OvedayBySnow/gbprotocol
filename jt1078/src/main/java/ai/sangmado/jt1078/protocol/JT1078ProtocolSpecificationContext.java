package ai.sangmado.jt1078.protocol;

import ai.sangmado.gbcommon.memory.IByteArrayPool;
import ai.sangmado.jt1078.protocol.enums.JT1078ProtocolVersion;
import ai.sangmado.jt808.protocol.ISpecificationContext;
import ai.sangmado.jt808.protocol.enums.JT808MessageContentEncryptionMode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.nio.ByteOrder;
import java.nio.charset.Charset;

/**
 * JT1078 协议上下文
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JT1078ProtocolSpecificationContext implements ISpecificationContext<JT1078ProtocolVersion> {
    @Setter
    @Builder.Default
    private JT1078ProtocolVersion protocolVersion = JT1078ProtocolVersion.V2016;
    @Setter
    @Builder.Default
    private ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
    @Setter
    @Builder.Default
    private Charset charset = Charset.forName("GBK");
    @Setter
    @Builder.Default
    private JT808MessageContentEncryptionMode messageContentEncryptionMode = JT808MessageContentEncryptionMode.RSA;
    @Setter
    private IByteArrayPool byteArrayPool;

    /**
     * 获取协议版本
     *
     * @return 协议版本
     */
    @Override
    public JT1078ProtocolVersion getProtocolVersion() {
        return this.protocolVersion;
    }

    /**
     * 获取字节序
     * <p>
     * 大端（Big-Endian）字节序：高字节存于内存低地址，低字节存于内存高地址。
     * 小端（Little-Endian）字节序：低字节存于内存低地址，高字节存于内存高地址。
     *
     * @return 字节序
     */
    @Override
    public ByteOrder getByteOrder() {
        return byteOrder;
    }

    /**
     * 获取字符集
     *
     * @return 字符集
     */
    @Override
    public Charset getCharset() {
        return charset;
    }

    /**
     * 获取消息体加密方式
     *
     * @return 消息体加密方式
     */
    @Override
    public JT808MessageContentEncryptionMode getMessageContentEncryptionMode() {
        return messageContentEncryptionMode;
    }

    /**
     * 获取数组池
     *
     * @return 数组池
     */
    @Override
    public IByteArrayPool getByteArrayPool() {
        return byteArrayPool;
    }
}