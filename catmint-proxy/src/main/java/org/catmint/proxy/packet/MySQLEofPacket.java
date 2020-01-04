package org.catmint.proxy.packet;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.catmint.proxy.packet.constant.MySQLStatusFlag;

/**
 * EOF packet protocol for MySQL.
 *
 * @author Shuo Xiang
 * @see <a href="https://dev.mysql.com/doc/internals/en/packet-EOF_Packet.html">EOF Packet</a>
 */
@RequiredArgsConstructor
@Getter
public final class MySQLEofPacket implements MySQLPacket {

    /**
     * Header of EOF packet.
     */
    public static final int HEADER = 0xfe;

    private final int sequenceId;

    private final int warnings;

    private final int statusFlags;

    public MySQLEofPacket(final int sequenceId) {
        this(sequenceId, 0, MySQLStatusFlag.SERVER_STATUS_AUTOCOMMIT.getValue());
    }

    @Override
    public void write(final MySQLPacketPayload payload) {
        payload.writeInt1(HEADER);
        payload.writeInt2(warnings);
        payload.writeInt2(statusFlags);
    }
}
