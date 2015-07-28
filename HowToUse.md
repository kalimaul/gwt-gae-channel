# Introduction #

First of all, you should read and be familiar with how to use the App Engine Channel API ([python](http://code.google.com/appengine/docs/python/channel/) | [java](http://code.google.com/appengine/docs/java/channel/)) on the server-side.

This library simply wraps the client-side JavaScript with GWT bindings to make it accessible in a GWT application, and it doesn't manage telling your client the token it should use. That part's up to you, and is described in the documentation for the Channel API.

# A Short Sample #

The following is a simple example of how to open a channel and receive updates when the channel receives a message.

```
  Channel channel = ChannelFactory.createChannel(token);
  Socket socket = channel.open(new SocketListener() {
    @Override
    public void onOpen() {
      Window.alert("Channel opened!");
    }
    @Override
    public void onMessage(String message) {
      Window.alert("Received: " + message);
    }
    @Override
    public void onError(ChannelError error) {
      Window.alert("Channel error: " + error.getCode() + " : " + error.getDescription());
    }
    @Override
    public void onClose() {
      Window.alert("Channel closed!");
    }
  }
  ...
  socket.close();
```

Whenever the server sends a message to your socket, the `onMessage()` method will get called with the message that was sent.