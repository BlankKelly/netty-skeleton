package com.mylab.netty.skeleton.server.handler;

import com.mylab.netty.skeleton.common.constant.Constant;
import com.mylab.netty.skeleton.common.decoder.NettyMsgDecoder;
import com.mylab.netty.skeleton.common.encoder.NettyMsgEncoder;
import com.mylab.netty.skeleton.server.business.BusinessServerHandler;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;

import java.nio.charset.StandardCharsets;

/**
 * 自定义消息处理handler编排（入站和出站消息）
 */
public class ChildChannelHandler extends ChannelInitializer<Channel> {
    @Override
    protected void initChannel(Channel ch) throws Exception {
        ByteBuf delimiter = Unpooled.copiedBuffer(Constant.DELIMITER.getBytes(StandardCharsets.UTF_8));

        ch.pipeline()
                .addLast(new DelimiterBasedFrameDecoder(Constant.MAX_LENGTH, delimiter))
                .addLast(new NettyMsgEncoder())
                .addLast(new NettyMsgDecoder())
                .addLast(new BusinessServerHandler());
    }
}
