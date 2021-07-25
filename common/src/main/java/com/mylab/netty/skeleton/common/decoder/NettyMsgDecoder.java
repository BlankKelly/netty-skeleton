package com.mylab.netty.skeleton.common.decoder;

import com.mylab.netty.skeleton.common.model.NettyMsg;
import com.mylab.netty.skeleton.common.utils.ProtostuffUtils;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

public class NettyMsgDecoder extends ByteToMessageDecoder {
    public static <T> T deserialize(byte[] data, Class<T> clazz) {
        return ProtostuffUtils.deserialize(data, clazz);
    }

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) {
        try {
            byte[] body = new byte[in.readableBytes()];
            in.readBytes(body);

            out.add(ProtostuffUtils.deserialize(body, NettyMsg.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
