package org.catmint.io.protocol.mysql;

/**
 * MySQL 状态标识<br />
 * <a href="https://dev.mysql.com/doc/internals/en/status-flags.html#packet-Protocol::StatusFlags">MySQL 官方文档</a>
 *
 * @author Shuo Xiang
 */
public enum StatusFlags {
    /** 启用事务 */
    IN_TRANS(1),
    /** 自动提交 */
    AUTO_COMMIT(2);

    StatusFlags(int flag) {
        this.flag = flag;
    }

    private int flag;

    public int getFlag() {
        return flag;
    }
}
