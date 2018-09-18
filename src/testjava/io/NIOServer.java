package testjava.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NIOServer {
	public static void main(String[] args) throws IOException {
		Selector selector = Selector.open();
		
		ServerSocketChannel ssChannel = ServerSocketChannel.open();
		ssChannel.configureBlocking(false);
		ssChannel.register(selector, SelectionKey.OP_ACCEPT);
		
		ServerSocket serverSocket = ssChannel.socket();
		InetSocketAddress address = new InetSocketAddress("127.0.0.1", 8888);
		serverSocket.bind(address);
		
		while(true) {
			selector.select();
			Set<SelectionKey> keys = selector.selectedKeys();
			Iterator<SelectionKey> keyIterator = keys.iterator();
			while(keyIterator.hasNext()) {
				SelectionKey key = keyIterator.next();
				if(key.isAcceptable()) {
					ServerSocketChannel ssChannel1 = (ServerSocketChannel) key.channel();
					// Server creates an new SocketChannel for each session.
					SocketChannel sChannel = ssChannel1.accept();
					sChannel.configureBlocking(false);
					
					sChannel.register(selector, SelectionKey.OP_READ);
				}else if (key.isReadable()) {
					SocketChannel sChannel = (SocketChannel) key.channel();
					System.out.println(readDataFromChannel(sChannel));
					sChannel.close();
				}
				keyIterator.remove();
			}
		}
		
	}

	private static String readDataFromChannel(SocketChannel sChannel) throws IOException {
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		StringBuilder data = new StringBuilder();
		while(true) {
			buffer.clear();
			int n = sChannel.read(buffer);
			if(n == -1)
				break;
			buffer.flip();
			int limit = buffer.limit();
			char[] dist = new char[limit];
			for(int i = 0; i < limit; i++) {
				dist[i] = (char) buffer.get(i);
			}
			data.append(dist);
			buffer.clear();
		}
		return data.toString();
	}
}
