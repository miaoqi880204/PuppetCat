package org.catmint.io.protocol;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 字符串分块
 *
 * @author Shuo Xiang
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class StringPacketChunk extends PacketChunk {

    private boolean nul;
}
