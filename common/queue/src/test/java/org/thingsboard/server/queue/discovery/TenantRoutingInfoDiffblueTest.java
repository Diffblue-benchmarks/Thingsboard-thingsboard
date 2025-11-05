package org.thingsboard.server.queue.discovery;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.TenantProfileId;

class TenantRoutingInfoDiffblueTest {
  /**
   * Test {@link TenantRoutingInfo#equals(Object)}, and {@link TenantRoutingInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TenantRoutingInfo#equals(Object)}
   *   <li>{@link TenantRoutingInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TenantRoutingInfo.equals(Object)",
    "int TenantRoutingInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TenantRoutingInfo tenantRoutingInfo = new TenantRoutingInfo(tenantId, null, true);
    TenantId tenantId2 = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TenantRoutingInfo tenantRoutingInfo2 = new TenantRoutingInfo(tenantId2, null, true);

    // Act and Assert
    assertEquals(tenantRoutingInfo, tenantRoutingInfo2);
    assertEquals(tenantRoutingInfo.hashCode(), tenantRoutingInfo2.hashCode());
  }

  /**
   * Test {@link TenantRoutingInfo#equals(Object)}, and {@link TenantRoutingInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TenantRoutingInfo#equals(Object)}
   *   <li>{@link TenantRoutingInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TenantRoutingInfo.equals(Object)",
    "int TenantRoutingInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TenantRoutingInfo tenantRoutingInfo = new TenantRoutingInfo(null, null, true);
    TenantRoutingInfo tenantRoutingInfo2 = new TenantRoutingInfo(null, null, true);

    // Act and Assert
    assertEquals(tenantRoutingInfo, tenantRoutingInfo2);
    assertEquals(tenantRoutingInfo.hashCode(), tenantRoutingInfo2.hashCode());
  }

  /**
   * Test {@link TenantRoutingInfo#equals(Object)}, and {@link TenantRoutingInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TenantRoutingInfo#equals(Object)}
   *   <li>{@link TenantRoutingInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TenantRoutingInfo.equals(Object)",
    "int TenantRoutingInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TenantProfileId profileId =
        new TenantProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TenantRoutingInfo tenantRoutingInfo = new TenantRoutingInfo(tenantId, profileId, true);
    TenantId tenantId2 = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TenantProfileId profileId2 =
        new TenantProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TenantRoutingInfo tenantRoutingInfo2 = new TenantRoutingInfo(tenantId2, profileId2, true);

    // Act and Assert
    assertEquals(tenantRoutingInfo, tenantRoutingInfo2);
    assertEquals(tenantRoutingInfo.hashCode(), tenantRoutingInfo2.hashCode());
  }

  /**
   * Test {@link TenantRoutingInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TenantRoutingInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TenantRoutingInfo.equals(Object)",
    "int TenantRoutingInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TenantRoutingInfo tenantRoutingInfo =
        new TenantRoutingInfo(new TenantId(UUID.randomUUID()), null, true);
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(tenantRoutingInfo, new TenantRoutingInfo(tenantId, null, true));
  }

  /**
   * Test {@link TenantRoutingInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TenantRoutingInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TenantRoutingInfo.equals(Object)",
    "int TenantRoutingInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TenantRoutingInfo tenantRoutingInfo = new TenantRoutingInfo(null, null, true);
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(tenantRoutingInfo, new TenantRoutingInfo(tenantId, null, true));
  }

  /**
   * Test {@link TenantRoutingInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TenantRoutingInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TenantRoutingInfo.equals(Object)",
    "int TenantRoutingInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TenantProfileId profileId =
        new TenantProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TenantRoutingInfo tenantRoutingInfo = new TenantRoutingInfo(tenantId, profileId, true);
    TenantId tenantId2 = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(tenantRoutingInfo, new TenantRoutingInfo(tenantId2, null, true));
  }

  /**
   * Test {@link TenantRoutingInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TenantRoutingInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TenantRoutingInfo.equals(Object)",
    "int TenantRoutingInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TenantRoutingInfo tenantRoutingInfo = new TenantRoutingInfo(tenantId, null, false);
    TenantId tenantId2 = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(tenantRoutingInfo, new TenantRoutingInfo(tenantId2, null, true));
  }

  /**
   * Test {@link TenantRoutingInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TenantRoutingInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TenantRoutingInfo.equals(Object)",
    "int TenantRoutingInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(new TenantRoutingInfo(tenantId, null, true), 1);
  }

  /**
   * Test {@link TenantRoutingInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TenantRoutingInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TenantRoutingInfo.equals(Object)",
    "int TenantRoutingInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TenantRoutingInfo tenantRoutingInfo = new TenantRoutingInfo(null, null, true);
    TenantProfileId profileId =
        new TenantProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(tenantRoutingInfo, new TenantRoutingInfo(null, profileId, true));
  }
}
