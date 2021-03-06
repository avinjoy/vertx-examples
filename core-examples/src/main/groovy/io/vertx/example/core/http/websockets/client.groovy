import io.vertx.groovy.core.buffer.Buffer
def client = vertx.createHttpClient()

client.websocket(8080, "localhost", "/some-uri", { websocket ->
  websocket.handler({ data ->
    println("Received data ${data.toString("ISO-8859-1")}")
    client.close()
  })
  websocket.writeMessage(Buffer.buffer("Hello world"))
})
