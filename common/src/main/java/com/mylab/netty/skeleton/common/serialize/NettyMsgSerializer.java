package com.mylab.netty.skeleton.common.serialize;

import com.mylab.netty.skeleton.common.utils.ProtostuffUtils;

public class NettyMsgSerializer {
    public static <T> byte[] serialize(T obj) {
        return ProtostuffUtils.serialize(obj);
    }
}
