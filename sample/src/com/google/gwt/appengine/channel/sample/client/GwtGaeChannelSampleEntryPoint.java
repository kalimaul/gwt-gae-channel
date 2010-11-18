package com.google.gwt.appengine.channel.sample.client;

import com.google.gwt.appengine.channel.client.Channel;
import com.google.gwt.appengine.channel.client.ChannelFactory;
import com.google.gwt.appengine.channel.client.SocketListener;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window;

public class GwtGaeChannelSampleEntryPoint implements EntryPoint {
	@Override
	public void onModuleLoad() {

		// Create a new channel with the ID "foo"
		Channel channel = ChannelFactory.createChannel("foo");

		// Open the channel and attach a listener.
		channel.open(new SocketListener() {
			@Override
			public void onOpen() {
				// Alert when the channel opens.
				Window.alert("Channel opened");
			}
			@Override
			public void onMessage(String message) {
				// Alert when the channel receives a message.
				Window.alert("Received: " + message);
			}
		});
	}
}