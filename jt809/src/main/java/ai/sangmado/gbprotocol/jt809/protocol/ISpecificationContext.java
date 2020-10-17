package ai.sangmado.gbprotocol.jt809.protocol;

import ai.sangmado.gbprotocol.gbcommon.memory.IBufferPool;
import ai.sangmado.gbprotocol.jt809.protocol.enums.JT809MessageContentEncryptionOptions;

import java.nio.ByteOrder;
import java.nio.charset.Charset;

/**
 * 协议上下文
 */
public interface ISpecificationContext extends Cloneable {

    /**
     * 获取字节序
     * <p>
     * 大端（Big-Endian）字节序：高字节存于内存低地址，低字节存于内存高地址。
     * 小端（Little-Endian）字节序：低字节存于内存低地址，高字节存于内存高地址。
     *
     * @return 字节序
     */
    ByteOrder getByteOrder();

    /**
     * 获取字符集
     *
     * @return 字符集
     */
    Charset getCharset();

    /**
     * 获取消息体加密参数
     *
     * @return 消息体加密参数
     */
    JT809MessageContentEncryptionOptions getMessageContentEncryptionOptions();

    /**
     * 获取数组池
     *
     * @return 数组池
     */
    IBufferPool getBufferPool();
}
