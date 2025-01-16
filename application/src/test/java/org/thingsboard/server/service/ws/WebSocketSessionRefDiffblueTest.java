package org.thingsboard.server.service.ws;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.net.InetSocketAddress;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.service.security.model.SecurityUser;

@ContextConfiguration(classes = {WebSocketSessionRef.class, String.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class WebSocketSessionRefDiffblueTest {
  @MockBean
  private InetSocketAddress inetSocketAddress;

  @MockBean
  private SecurityUser securityUser;

  @Autowired
  private WebSocketSessionRef webSocketSessionRef;

  @MockBean
  private WebSocketSessionType webSocketSessionType;

  /**
   * Test {@link WebSocketSessionRef#getTenantId()}.
   * <p>
   * Method under test: {@link WebSocketSessionRef#getTenantId()}
   */
  @Test
  @DisplayName("Test getTenantId()")
  void testGetTenantId() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    when(securityUser.getTenantId()).thenReturn(tenantId);

    // Act
    TenantId actualTenantId = webSocketSessionRef.getTenantId();

    // Assert
    verify(securityUser).getTenantId();
    assertSame(tenantId, actualTenantId);
  }

  /**
   * Test {@link WebSocketSessionRef#equals(Object)}, and
   * {@link WebSocketSessionRef#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link WebSocketSessionRef#equals(Object)}
   *   <li>{@link WebSocketSessionRef#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    WebSocketSessionRef.WebSocketSessionRefBuilder builderResult = WebSocketSessionRef.builder();
    WebSocketSessionRef.WebSocketSessionRefBuilder localAddressResult = builderResult
        .localAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRef.WebSocketSessionRefBuilder remoteAddressResult = localAddressResult
        .remoteAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRef buildResult = remoteAddressResult.securityCtx(new SecurityUser())
        .sessionId("42")
        .sessionType(WebSocketSessionType.GENERAL)
        .build();
    WebSocketSessionRef.WebSocketSessionRefBuilder builderResult2 = WebSocketSessionRef.builder();
    WebSocketSessionRef.WebSocketSessionRefBuilder localAddressResult2 = builderResult2
        .localAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRef.WebSocketSessionRefBuilder remoteAddressResult2 = localAddressResult2
        .remoteAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRef buildResult2 = remoteAddressResult2.securityCtx(new SecurityUser())
        .sessionId("42")
        .sessionType(WebSocketSessionType.GENERAL)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link WebSocketSessionRef#equals(Object)}, and
   * {@link WebSocketSessionRef#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link WebSocketSessionRef#equals(Object)}
   *   <li>{@link WebSocketSessionRef#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    WebSocketSessionRef.WebSocketSessionRefBuilder webSocketSessionRefBuilder = mock(
        WebSocketSessionRef.WebSocketSessionRefBuilder.class);
    when(webSocketSessionRefBuilder.localAddress(Mockito.<InetSocketAddress>any()))
        .thenReturn(WebSocketSessionRef.builder());
    WebSocketSessionRef.WebSocketSessionRefBuilder localAddressResult = webSocketSessionRefBuilder
        .localAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRef.WebSocketSessionRefBuilder remoteAddressResult = localAddressResult
        .remoteAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRef buildResult = remoteAddressResult.securityCtx(new SecurityUser())
        .sessionId("42")
        .sessionType(WebSocketSessionType.GENERAL)
        .build();
    WebSocketSessionRef.WebSocketSessionRefBuilder builderResult = WebSocketSessionRef.builder();
    WebSocketSessionRef.WebSocketSessionRefBuilder localAddressResult2 = builderResult
        .localAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRef.WebSocketSessionRefBuilder remoteAddressResult2 = localAddressResult2
        .remoteAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRef buildResult2 = remoteAddressResult2.securityCtx(new SecurityUser())
        .sessionId("42")
        .sessionType(WebSocketSessionType.GENERAL)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link WebSocketSessionRef#equals(Object)}, and
   * {@link WebSocketSessionRef#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link WebSocketSessionRef#equals(Object)}
   *   <li>{@link WebSocketSessionRef#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    WebSocketSessionRef.WebSocketSessionRefBuilder builderResult = WebSocketSessionRef.builder();
    WebSocketSessionRef.WebSocketSessionRefBuilder localAddressResult = builderResult
        .localAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRef.WebSocketSessionRefBuilder remoteAddressResult = localAddressResult
        .remoteAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRef buildResult = remoteAddressResult.securityCtx(new SecurityUser())
        .sessionId("42")
        .sessionType(WebSocketSessionType.GENERAL)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link WebSocketSessionRef#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebSocketSessionRef#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    WebSocketSessionRef.WebSocketSessionRefBuilder webSocketSessionRefBuilder = mock(
        WebSocketSessionRef.WebSocketSessionRefBuilder.class);
    when(webSocketSessionRefBuilder.localAddress(Mockito.<InetSocketAddress>any()))
        .thenReturn(WebSocketSessionRef.builder());
    WebSocketSessionRef.WebSocketSessionRefBuilder localAddressResult = webSocketSessionRefBuilder
        .localAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRef.WebSocketSessionRefBuilder remoteAddressResult = localAddressResult
        .remoteAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRef buildResult = remoteAddressResult.securityCtx(new SecurityUser())
        .sessionId("Session Id")
        .sessionType(WebSocketSessionType.GENERAL)
        .build();
    WebSocketSessionRef.WebSocketSessionRefBuilder builderResult = WebSocketSessionRef.builder();
    WebSocketSessionRef.WebSocketSessionRefBuilder localAddressResult2 = builderResult
        .localAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRef.WebSocketSessionRefBuilder remoteAddressResult2 = localAddressResult2
        .remoteAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRef buildResult2 = remoteAddressResult2.securityCtx(new SecurityUser())
        .sessionId("42")
        .sessionType(WebSocketSessionType.GENERAL)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link WebSocketSessionRef#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebSocketSessionRef#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    WebSocketSessionRef.WebSocketSessionRefBuilder builderResult = WebSocketSessionRef.builder();
    WebSocketSessionRef.WebSocketSessionRefBuilder localAddressResult = builderResult
        .localAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRef.WebSocketSessionRefBuilder remoteAddressResult = localAddressResult
        .remoteAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRef buildResult = remoteAddressResult.securityCtx(new SecurityUser())
        .sessionId("42")
        .sessionType(WebSocketSessionType.GENERAL)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link WebSocketSessionRef#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebSocketSessionRef#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    WebSocketSessionRef.WebSocketSessionRefBuilder builderResult = WebSocketSessionRef.builder();
    WebSocketSessionRef.WebSocketSessionRefBuilder localAddressResult = builderResult
        .localAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRef.WebSocketSessionRefBuilder remoteAddressResult = localAddressResult
        .remoteAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRef buildResult = remoteAddressResult.securityCtx(new SecurityUser())
        .sessionId("42")
        .sessionType(WebSocketSessionType.GENERAL)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to WebSocketSessionRef");
  }

  /**
   * Test {@link WebSocketSessionRef#toString()}.
   * <p>
   * Method under test: {@link WebSocketSessionRef#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  void testToString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SecurityUser securityCtx = new SecurityUser();
    InetSocketAddress localAddress = InetSocketAddress.createUnresolved("foo", 1);

    WebSocketSessionRef webSocketSessionRef = new WebSocketSessionRef("42", securityCtx, localAddress,
        InetSocketAddress.createUnresolved("foo", 1), WebSocketSessionType.GENERAL);
    webSocketSessionRef.setSecurityCtx(null);

    // Act
    String actualToStringResult = webSocketSessionRef.toString();

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", webSocketSessionRef.getTenantId().getId().toString());
    assertEquals("[42]", actualToStringResult);
  }

  /**
   * Test {@link WebSocketSessionRef#toString()}.
   * <ul>
   *   <li>Then calls {@link User#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebSocketSessionRef#toString()}
   */
  @Test
  @DisplayName("Test toString(); then calls getId()")
  void testToString_thenCallsGetId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SecurityUser securityCtx = mock(SecurityUser.class);
    when(securityCtx.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    when(securityCtx.getId()).thenReturn(null);
    InetSocketAddress localAddress = InetSocketAddress.createUnresolved("foo", 1);

    // Act
    (new WebSocketSessionRef("42", securityCtx, localAddress, InetSocketAddress.createUnresolved("foo", 1),
        WebSocketSessionType.GENERAL)).toString();

    // Assert
    verify(securityCtx).getId();
    verify(securityCtx).getTenantId();
  }

  /**
   * Test {@link WebSocketSessionRef#toString()}.
   * <ul>
   *   <li>Then return {@code [null][null][42]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebSocketSessionRef#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return '[null][null][42]'")
  void testToString_thenReturnNullNull42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SecurityUser securityCtx = new SecurityUser();
    InetSocketAddress localAddress = InetSocketAddress.createUnresolved("foo", 1);

    // Act and Assert
    assertEquals("[null][null][42]", (new WebSocketSessionRef("42", securityCtx, localAddress,
        InetSocketAddress.createUnresolved("foo", 1), WebSocketSessionType.GENERAL)).toString());
  }
}
