package org.thingsboard.server.queue.discovery;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import java.util.UUID;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.TenantProfileId;

class TenantRoutingInfoDiffblueTest {
  /**
   * Test {@link TenantRoutingInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantRoutingInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different")
  @Disabled("TODO: Complete this test")
  void testEquals_whenOtherIsDifferent() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IllegalArgumentException: Invalid UUID string: 42
    //       at java.base/java.util.UUID.fromString1(UUID.java:280)
    //       at java.base/java.util.UUID.fromString(UUID.java:258)
    //       at org.thingsboard.server.common.data.id.TenantProfileId.fromString(TenantProfileId.java:35)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TenantRoutingInfo tenantRoutingInfo = new TenantRoutingInfo(tenantId, TenantProfileId.fromString("42"), true);
    TenantId tenantId2 = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    tenantRoutingInfo.equals(new TenantRoutingInfo(tenantId2, TenantProfileId.fromString("42"), true));
  }

  /**
   * Test {@link TenantRoutingInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantRoutingInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TenantRoutingInfo tenantRoutingInfo = new TenantRoutingInfo(
        new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), mock(TenantProfileId.class), true);

    // Act and Assert
    assertNotEquals(tenantRoutingInfo,
        new TenantRoutingInfo(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), null, true));
  }

  /**
   * Test {@link TenantRoutingInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantRoutingInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new TenantRoutingInfo(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
        mock(TenantProfileId.class), true), "42");
  }

  /**
   * Test {@link TenantRoutingInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantRoutingInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TenantRoutingInfo tenantRoutingInfo = new TenantRoutingInfo(new TenantId(UUID.randomUUID()),
        mock(TenantProfileId.class), true);

    // Act and Assert
    assertNotEquals(tenantRoutingInfo,
        new TenantRoutingInfo(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), null, true));
  }

  /**
   * Test {@link TenantRoutingInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantRoutingInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TenantRoutingInfo tenantRoutingInfo = new TenantRoutingInfo(null, mock(TenantProfileId.class), true);

    // Act and Assert
    assertNotEquals(tenantRoutingInfo,
        new TenantRoutingInfo(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), null, true));
  }

  /**
   * Test {@link TenantRoutingInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantRoutingInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TenantRoutingInfo tenantRoutingInfo = new TenantRoutingInfo(
        new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), mock(TenantProfileId.class), false);

    // Act and Assert
    assertNotEquals(tenantRoutingInfo,
        new TenantRoutingInfo(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), null, true));
  }

  /**
   * Test {@link TenantRoutingInfo#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantRoutingInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'")
  @Disabled("TODO: Complete this test")
  void testEquals_whenOtherIsNull() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    (new TenantRoutingInfo(tenantId, TenantProfileId.fromString("42"), true)).equals(null);
  }

  /**
   * Test {@link TenantRoutingInfo#equals(Object)}.
   * <ul>
   *   <li>When other is same.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantRoutingInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is same")
  @Disabled("TODO: Complete this test")
  void testEquals_whenOtherIsSame() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    (new TenantRoutingInfo(tenantId, TenantProfileId.fromString("42"), true))
        .equals(new TenantRoutingInfo(tenantId, TenantProfileId.fromString("42"), true));
  }

  /**
   * Test {@link TenantRoutingInfo#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantRoutingInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type")
  @Disabled("TODO: Complete this test")
  void testEquals_whenOtherIsWrongType() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    (new TenantRoutingInfo(tenantId, TenantProfileId.fromString("42"), true))
        .equals("Different type to TenantRoutingInfo");
  }
}
