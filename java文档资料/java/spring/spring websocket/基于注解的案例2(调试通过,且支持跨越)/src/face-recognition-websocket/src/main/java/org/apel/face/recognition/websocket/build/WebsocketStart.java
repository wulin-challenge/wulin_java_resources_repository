package org.apel.face.recognition.websocket.build;

import org.apel.gaia.container.boot.PlatformStarter;

public class WebsocketStart {

	public static void main(String[] args) {
		PlatformStarter.start(args);
		System.out.println("websocket服务启动成功!!");
	}
}
