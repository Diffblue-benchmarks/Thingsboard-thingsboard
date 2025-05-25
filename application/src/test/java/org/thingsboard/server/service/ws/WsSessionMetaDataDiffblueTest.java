package org.thingsboard.server.service.ws;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.net.InetSocketAddress;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.service.security.model.SecurityUser;
import org.thingsboard.server.service.ws.WebSocketSessionRef.WebSocketSessionRefBuilder;

@ContextConfiguration(classes = {WsSessionMetaData.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class WsSessionMetaDataDiffblueTest {
  @MockBean
  private WebSocketSessionRef webSocketSessionRef;

  @Autowired
  private WsSessionMetaData wsSessionMetaData;

  /**
   * Test {@link WsSessionMetaData#WsSessionMetaData(WebSocketSessionRef)}.
   * <p>
   * Method under test: {@link WsSessionMetaData#WsSessionMetaData(WebSocketSessionRef)}
   */
  @Test
  @DisplayName("Test new WsSessionMetaData(WebSocketSessionRef)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void WsSessionMetaData.<init>(WebSocketSessionRef)"})
  void testNewWsSessionMetaData() {
    // Arrange, Act and Assert
    assertSame(webSocketSessionRef, (new WsSessionMetaData(webSocketSessionRef)).getSessionRef());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link WsSessionMetaData#setLastActivityTime(long)}
   *   <li>{@link WsSessionMetaData#setSessionRef(WebSocketSessionRef)}
   *   <li>{@link WsSessionMetaData#toString()}
   *   <li>{@link WsSessionMetaData#getLastActivityTime()}
   *   <li>{@link WsSessionMetaData#getSessionRef()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long WsSessionMetaData.getLastActivityTime()",
      "WebSocketSessionRef WsSessionMetaData.getSessionRef()", "void WsSessionMetaData.setLastActivityTime(long)",
      "void WsSessionMetaData.setSessionRef(WebSocketSessionRef)", "String WsSessionMetaData.toString()"})
  void testGettersAndSetters() {
    // Arrange
    WebSocketSessionRefBuilder builderResult = WebSocketSessionRef.builder();
    WebSocketSessionRefBuilder localAddressResult = builderResult
        .localAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRefBuilder remoteAddressResult = localAddressResult
        .remoteAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRef sessionRef = remoteAddressResult.securityCtx(new SecurityUser())
        .sessionId("42")
        .sessionType(WebSocketSessionType.GENERAL)
        .build();
    WsSessionMetaData wsSessionMetaData = new WsSessionMetaData(sessionRef);

    // Act
    wsSessionMetaData.setLastActivityTime(1L);
    WebSocketSessionRefBuilder builderResult2 = WebSocketSessionRef.builder();
    WebSocketSessionRefBuilder localAddressResult2 = builderResult2
        .localAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRefBuilder remoteAddressResult2 = localAddressResult2
        .remoteAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRef sessionRef2 = remoteAddressResult2.securityCtx(new SecurityUser())
        .sessionId("42")
        .sessionType(WebSocketSessionType.GENERAL)
        .build();
    wsSessionMetaData.setSessionRef(sessionRef2);
    String actualToStringResult = wsSessionMetaData.toString();
    long actualLastActivityTime = wsSessionMetaData.getLastActivityTime();

    // Assert
    assertEquals("WsSessionMetaData [sessionRef=[null][null][42], lastActivityTime=1]", actualToStringResult);
    assertEquals(1L, actualLastActivityTime);
    assertSame(sessionRef2, wsSessionMetaData.getSessionRef());
  }
}
