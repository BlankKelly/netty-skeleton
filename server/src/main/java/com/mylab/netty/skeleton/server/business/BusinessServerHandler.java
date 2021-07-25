package com.mylab.netty.skeleton.server.business;

import com.mylab.netty.skeleton.common.model.NettyMsg;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class BusinessServerHandler extends SimpleChannelInboundHandler<NettyMsg> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, NettyMsg msg) throws Exception {
        if (msg == null) {
            return;
        }

        // 业务处理代码在此

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        //
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        // 新的客户端接入
        super.channelActive(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        // 客户端掉线
        super.channelInactive(ctx);
    }
}
