package com.mylab.netty.skeleton.common.encoder;

import com.mylab.netty.skeleton.common.constant.Constant;
import com.mylab.netty.skeleton.common.model.NettyMsg;
import com.mylab.netty.skeleton.common.serialize.NettyMsgSerializer;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

import java.nio.charset.StandardCharsets;

public class NettyMsgEncoder extends MessageToByteEncoder<NettyMsg> {
    @Override
    protected void encode(ChannelHandlerContext ctx, NettyMsg msg, ByteBuf out) throws Exception {
        byte[] data = NettyMsgSerializer.serialize(msg);
        byte[] delimiter = Constant.DELIMITER.getBytes(StandardCharsets.UTF_8);

        // 此处消息的构建取决于使用什么decoder来解决粘包、半包问题
        // 比如使用基于长度的方案
        byte[] total = new byte[data.length + delimiter.length];
        System.arraycopy(data, 0, total, 0, data.length);
        System.arraycopy(delimiter, 0, total, data.length, delimiter.length);

        out.writeBytes(total);
    }
}
