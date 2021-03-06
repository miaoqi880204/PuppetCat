package org.catmint.proxy.execution;

import org.catmint.proxy.packet.DatabasePacket;
import org.catmint.proxy.packet.MySQLEofPacket;
import org.catmint.proxy.packet.command.MySQLComFieldListPacket;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;

/**
 * COM_FIELD_LIST packet executor for MySQL.
 *
 * @author Shuo Xiang
 */
public final class MySQLComFieldListPacketExecutor implements CommandExecutor {

    private static final String SQL = "SHOW COLUMNS FROM %s FROM %s";

    private final MySQLComFieldListPacket packet;

    public MySQLComFieldListPacketExecutor(final MySQLComFieldListPacket packet) {
        this.packet = packet;
    }

    @Override
    public Collection<DatabasePacket> execute() throws SQLException {
        // TODO
        return Collections.singleton(new MySQLEofPacket(1));
    }
}
