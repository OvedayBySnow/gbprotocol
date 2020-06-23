package ai.sangmado.gbprotocol.jt809.protocol.exceptions;

import ai.sangmado.gbprotocol.gbcommon.enums.IMessageId;

/**
 * 不支持协议消息异常
 */
public class UnsupportedJT809MessageException extends RuntimeException {
    static final long serialVersionUID = -6340343831567081202L;

    public UnsupportedJT809MessageException() {
        this("暂不支持该协议消息");
    }

    public UnsupportedJT809MessageException(IMessageId messageId) {
        this(String.format("暂不支持该协议消息: %s / %s / %s ",
                messageId.getName(), messageId.getDescription(), messageId.getSince()));
    }

    public UnsupportedJT809MessageException(String message) {
        super(message);
    }

    public UnsupportedJT809MessageException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnsupportedJT809MessageException(Throwable cause) {
        super(cause);
    }
}