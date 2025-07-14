package org.thingsboard.server.dao.mobile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.model.ModelConstants;

class MobileAppSettingsEvictEventDiffblueTest {
  /**
   * Test {@link MobileAppSettingsEvictEvent#equals(Object)}, and {@link
   * MobileAppSettingsEvictEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MobileAppSettingsEvictEvent#equals(Object)}
   *   <li>{@link MobileAppSettingsEvictEvent#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean MobileAppSettingsEvictEvent.equals(Object)",
    "int MobileAppSettingsEvictEvent.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MobileAppSettingsEvictEvent mobileAppSettingsEvictEvent =
        new MobileAppSettingsEvictEvent(ModelConstants.SYSTEM_TENANT);
    MobileAppSettingsEvictEvent mobileAppSettingsEvictEvent2 =
        new MobileAppSettingsEvictEvent(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertEquals(mobileAppSettingsEvictEvent, mobileAppSettingsEvictEvent2);
    int expectedHashCodeResult = mobileAppSettingsEvictEvent.hashCode();
    assertEquals(expectedHashCodeResult, mobileAppSettingsEvictEvent2.hashCode());
  }

  /**
   * Test {@link MobileAppSettingsEvictEvent#equals(Object)}, and {@link
   * MobileAppSettingsEvictEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MobileAppSettingsEvictEvent#equals(Object)}
   *   <li>{@link MobileAppSettingsEvictEvent#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean MobileAppSettingsEvictEvent.equals(Object)",
    "int MobileAppSettingsEvictEvent.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    MobileAppSettingsEvictEvent mobileAppSettingsEvictEvent = new MobileAppSettingsEvictEvent(null);
    MobileAppSettingsEvictEvent mobileAppSettingsEvictEvent2 =
        new MobileAppSettingsEvictEvent(null);

    // Act and Assert
    assertEquals(mobileAppSettingsEvictEvent, mobileAppSettingsEvictEvent2);
    int expectedHashCodeResult = mobileAppSettingsEvictEvent.hashCode();
    assertEquals(expectedHashCodeResult, mobileAppSettingsEvictEvent2.hashCode());
  }

  /**
   * Test {@link MobileAppSettingsEvictEvent#equals(Object)}, and {@link
   * MobileAppSettingsEvictEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MobileAppSettingsEvictEvent#equals(Object)}
   *   <li>{@link MobileAppSettingsEvictEvent#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean MobileAppSettingsEvictEvent.equals(Object)",
    "int MobileAppSettingsEvictEvent.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MobileAppSettingsEvictEvent mobileAppSettingsEvictEvent =
        new MobileAppSettingsEvictEvent(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertEquals(mobileAppSettingsEvictEvent, mobileAppSettingsEvictEvent);
    int expectedHashCodeResult = mobileAppSettingsEvictEvent.hashCode();
    assertEquals(expectedHashCodeResult, mobileAppSettingsEvictEvent.hashCode());
  }

  /**
   * Test {@link MobileAppSettingsEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppSettingsEvictEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean MobileAppSettingsEvictEvent.equals(Object)",
    "int MobileAppSettingsEvictEvent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    MobileAppSettingsEvictEvent mobileAppSettingsEvictEvent =
        new MobileAppSettingsEvictEvent(
            new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertNotEquals(
        mobileAppSettingsEvictEvent, new MobileAppSettingsEvictEvent(ModelConstants.SYSTEM_TENANT));
  }

  /**
   * Test {@link MobileAppSettingsEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppSettingsEvictEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean MobileAppSettingsEvictEvent.equals(Object)",
    "int MobileAppSettingsEvictEvent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    MobileAppSettingsEvictEvent mobileAppSettingsEvictEvent = new MobileAppSettingsEvictEvent(null);

    // Act and Assert
    assertNotEquals(
        mobileAppSettingsEvictEvent, new MobileAppSettingsEvictEvent(ModelConstants.SYSTEM_TENANT));
  }

  /**
   * Test {@link MobileAppSettingsEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppSettingsEvictEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean MobileAppSettingsEvictEvent.equals(Object)",
    "int MobileAppSettingsEvictEvent.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MobileAppSettingsEvictEvent(ModelConstants.SYSTEM_TENANT), null);
  }

  /**
   * Test {@link MobileAppSettingsEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppSettingsEvictEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean MobileAppSettingsEvictEvent.equals(Object)",
    "int MobileAppSettingsEvictEvent.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new MobileAppSettingsEvictEvent(ModelConstants.SYSTEM_TENANT),
        "Different type to MobileAppSettingsEvictEvent");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MobileAppSettingsEvictEvent#MobileAppSettingsEvictEvent(TenantId)}
   *   <li>{@link MobileAppSettingsEvictEvent#toString()}
   *   <li>{@link MobileAppSettingsEvictEvent#getTenantId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void MobileAppSettingsEvictEvent.<init>(TenantId)",
    "TenantId MobileAppSettingsEvictEvent.getTenantId()",
    "String MobileAppSettingsEvictEvent.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    MobileAppSettingsEvictEvent actualMobileAppSettingsEvictEvent =
        new MobileAppSettingsEvictEvent(ModelConstants.SYSTEM_TENANT);
    String actualToStringResult = actualMobileAppSettingsEvictEvent.toString();
    TenantId actualTenantId = actualMobileAppSettingsEvictEvent.getTenantId();

    // Assert
    assertEquals(
        "MobileAppSettingsEvictEvent(tenantId=13814000-1dd2-11b2-8080-808080808080)",
        actualToStringResult);
    assertSame(actualTenantId.SYS_TENANT_ID, actualTenantId);
  }
}
