package org.thingsboard.server.service.ws;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.net.InetSocketAddress;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.service.security.model.SecurityUser;
import org.thingsboard.server.service.ws.WebSocketSessionRef.WebSocketSessionRefBuilder;

@ContextConfiguration(classes = {WebSocketSessionRef.class, String.class, WebSocketSessionType.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TenantId WebSocketSessionRef.getTenantId()"})
  void testGetTenantId() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(securityUser.getTenantId()).thenReturn(tenantId);

    // Act
    TenantId actualTenantId = webSocketSessionRef.getTenantId();

    // Assert
    verify(securityUser).getTenantId();
    assertSame(tenantId, actualTenantId);
  }

  /**
   * Test {@link WebSocketSessionRef#getTenantId()}.
   * <ul>
   *   <li>Then return {@link TenantId#SYS_TENANT_ID}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebSocketSessionRef#getTenantId()}
   */
  @Test
  @DisplayName("Test getTenantId(); then return SYS_TENANT_ID")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TenantId WebSocketSessionRef.getTenantId()"})
  void testGetTenantId_thenReturnSys_tenant_id() {
    // Arrange
    InetSocketAddress localAddress = InetSocketAddress.createUnresolved("foo", 1);

    // Act
    TenantId actualTenantId = (new WebSocketSessionRef("42", null, localAddress,
        InetSocketAddress.createUnresolved("foo", 1), WebSocketSessionType.GENERAL)).getTenantId();

    // Assert
    assertSame(actualTenantId.SYS_TENANT_ID, actualTenantId);
  }

  /**
   * Test {@link WebSocketSessionRef#equals(Object)}, and {@link WebSocketSessionRef#hashCode()}.
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean WebSocketSessionRef.equals(Object)", "int WebSocketSessionRef.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    WebSocketSessionRefBuilder builderResult = WebSocketSessionRef.builder();
    WebSocketSessionRefBuilder localAddressResult = builderResult
        .localAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRefBuilder remoteAddressResult = localAddressResult
        .remoteAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRef buildResult = remoteAddressResult.securityCtx(new SecurityUser())
        .sessionId("42")
        .sessionType(WebSocketSessionType.GENERAL)
        .build();
    WebSocketSessionRefBuilder builderResult2 = WebSocketSessionRef.builder();
    WebSocketSessionRefBuilder localAddressResult2 = builderResult2
        .localAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRefBuilder remoteAddressResult2 = localAddressResult2
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
   * Test {@link WebSocketSessionRef#equals(Object)}, and {@link WebSocketSessionRef#hashCode()}.
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean WebSocketSessionRef.equals(Object)", "int WebSocketSessionRef.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    WebSocketSessionRefBuilder builderResult = WebSocketSessionRef.builder();
    WebSocketSessionRefBuilder localAddressResult = builderResult
        .localAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRefBuilder remoteAddressResult = localAddressResult
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean WebSocketSessionRef.equals(Object)", "int WebSocketSessionRef.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    WebSocketSessionRefBuilder builderResult = WebSocketSessionRef.builder();
    WebSocketSessionRefBuilder localAddressResult = builderResult
        .localAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRefBuilder remoteAddressResult = localAddressResult
        .remoteAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRef buildResult = remoteAddressResult.securityCtx(new SecurityUser())
        .sessionId("Session Id")
        .sessionType(WebSocketSessionType.GENERAL)
        .build();
    WebSocketSessionRefBuilder builderResult2 = WebSocketSessionRef.builder();
    WebSocketSessionRefBuilder localAddressResult2 = builderResult2
        .localAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRefBuilder remoteAddressResult2 = localAddressResult2
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean WebSocketSessionRef.equals(Object)", "int WebSocketSessionRef.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    WebSocketSessionRefBuilder builderResult = WebSocketSessionRef.builder();
    WebSocketSessionRefBuilder localAddressResult = builderResult
        .localAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRefBuilder remoteAddressResult = localAddressResult
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean WebSocketSessionRef.equals(Object)", "int WebSocketSessionRef.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    WebSocketSessionRefBuilder builderResult = WebSocketSessionRef.builder();
    WebSocketSessionRefBuilder localAddressResult = builderResult
        .localAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRefBuilder remoteAddressResult = localAddressResult
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
   * <ul>
   *   <li>Then return {@code [42]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebSocketSessionRef#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return '[42]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebSocketSessionRef.toString()"})
  void testToString_thenReturn42() {
    // Arrange
    InetSocketAddress localAddress = InetSocketAddress.createUnresolved("foo", 1);

    // Act and Assert
    assertEquals("[42]", (new WebSocketSessionRef("42", null, localAddress,
        InetSocketAddress.createUnresolved("foo", 1), WebSocketSessionType.GENERAL)).toString());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebSocketSessionRef.toString()"})
  void testToString_thenReturnNullNull42() {
    // Arrange
    SecurityUser securityCtx = new SecurityUser();
    InetSocketAddress localAddress = InetSocketAddress.createUnresolved("foo", 1);

    // Act and Assert
    assertEquals("[null][null][42]", (new WebSocketSessionRef("42", securityCtx, localAddress,
        InetSocketAddress.createUnresolved("foo", 1), WebSocketSessionType.GENERAL)).toString());
  }
}
