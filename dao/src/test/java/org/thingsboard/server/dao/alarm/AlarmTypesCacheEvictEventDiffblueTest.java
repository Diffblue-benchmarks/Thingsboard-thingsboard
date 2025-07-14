package org.thingsboard.server.dao.alarm;

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

class AlarmTypesCacheEvictEventDiffblueTest {
  /**
   * Test {@link AlarmTypesCacheEvictEvent#equals(Object)}, and {@link
   * AlarmTypesCacheEvictEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AlarmTypesCacheEvictEvent#equals(Object)}
   *   <li>{@link AlarmTypesCacheEvictEvent#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AlarmTypesCacheEvictEvent.equals(Object)",
    "int AlarmTypesCacheEvictEvent.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AlarmTypesCacheEvictEvent alarmTypesCacheEvictEvent =
        new AlarmTypesCacheEvictEvent(ModelConstants.SYSTEM_TENANT);
    AlarmTypesCacheEvictEvent alarmTypesCacheEvictEvent2 =
        new AlarmTypesCacheEvictEvent(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertEquals(alarmTypesCacheEvictEvent, alarmTypesCacheEvictEvent2);
    int expectedHashCodeResult = alarmTypesCacheEvictEvent.hashCode();
    assertEquals(expectedHashCodeResult, alarmTypesCacheEvictEvent2.hashCode());
  }

  /**
   * Test {@link AlarmTypesCacheEvictEvent#equals(Object)}, and {@link
   * AlarmTypesCacheEvictEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AlarmTypesCacheEvictEvent#equals(Object)}
   *   <li>{@link AlarmTypesCacheEvictEvent#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AlarmTypesCacheEvictEvent.equals(Object)",
    "int AlarmTypesCacheEvictEvent.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    AlarmTypesCacheEvictEvent alarmTypesCacheEvictEvent = new AlarmTypesCacheEvictEvent(null);
    AlarmTypesCacheEvictEvent alarmTypesCacheEvictEvent2 = new AlarmTypesCacheEvictEvent(null);

    // Act and Assert
    assertEquals(alarmTypesCacheEvictEvent, alarmTypesCacheEvictEvent2);
    int expectedHashCodeResult = alarmTypesCacheEvictEvent.hashCode();
    assertEquals(expectedHashCodeResult, alarmTypesCacheEvictEvent2.hashCode());
  }

  /**
   * Test {@link AlarmTypesCacheEvictEvent#equals(Object)}, and {@link
   * AlarmTypesCacheEvictEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AlarmTypesCacheEvictEvent#equals(Object)}
   *   <li>{@link AlarmTypesCacheEvictEvent#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AlarmTypesCacheEvictEvent.equals(Object)",
    "int AlarmTypesCacheEvictEvent.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AlarmTypesCacheEvictEvent alarmTypesCacheEvictEvent =
        new AlarmTypesCacheEvictEvent(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertEquals(alarmTypesCacheEvictEvent, alarmTypesCacheEvictEvent);
    int expectedHashCodeResult = alarmTypesCacheEvictEvent.hashCode();
    assertEquals(expectedHashCodeResult, alarmTypesCacheEvictEvent.hashCode());
  }

  /**
   * Test {@link AlarmTypesCacheEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmTypesCacheEvictEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AlarmTypesCacheEvictEvent.equals(Object)",
    "int AlarmTypesCacheEvictEvent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AlarmTypesCacheEvictEvent alarmTypesCacheEvictEvent =
        new AlarmTypesCacheEvictEvent(
            new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertNotEquals(
        alarmTypesCacheEvictEvent, new AlarmTypesCacheEvictEvent(ModelConstants.SYSTEM_TENANT));
  }

  /**
   * Test {@link AlarmTypesCacheEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmTypesCacheEvictEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AlarmTypesCacheEvictEvent.equals(Object)",
    "int AlarmTypesCacheEvictEvent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AlarmTypesCacheEvictEvent alarmTypesCacheEvictEvent = new AlarmTypesCacheEvictEvent(null);

    // Act and Assert
    assertNotEquals(
        alarmTypesCacheEvictEvent, new AlarmTypesCacheEvictEvent(ModelConstants.SYSTEM_TENANT));
  }

  /**
   * Test {@link AlarmTypesCacheEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmTypesCacheEvictEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AlarmTypesCacheEvictEvent.equals(Object)",
    "int AlarmTypesCacheEvictEvent.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AlarmTypesCacheEvictEvent(ModelConstants.SYSTEM_TENANT), null);
  }

  /**
   * Test {@link AlarmTypesCacheEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmTypesCacheEvictEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AlarmTypesCacheEvictEvent.equals(Object)",
    "int AlarmTypesCacheEvictEvent.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new AlarmTypesCacheEvictEvent(ModelConstants.SYSTEM_TENANT),
        "Different type to AlarmTypesCacheEvictEvent");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AlarmTypesCacheEvictEvent#AlarmTypesCacheEvictEvent(TenantId)}
   *   <li>{@link AlarmTypesCacheEvictEvent#toString()}
   *   <li>{@link AlarmTypesCacheEvictEvent#getTenantId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void AlarmTypesCacheEvictEvent.<init>(TenantId)",
    "TenantId AlarmTypesCacheEvictEvent.getTenantId()",
    "String AlarmTypesCacheEvictEvent.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    AlarmTypesCacheEvictEvent actualAlarmTypesCacheEvictEvent =
        new AlarmTypesCacheEvictEvent(ModelConstants.SYSTEM_TENANT);
    String actualToStringResult = actualAlarmTypesCacheEvictEvent.toString();
    TenantId actualTenantId = actualAlarmTypesCacheEvictEvent.getTenantId();

    // Assert
    assertEquals(
        "AlarmTypesCacheEvictEvent(tenantId=13814000-1dd2-11b2-8080-808080808080)",
        actualToStringResult);
    assertSame(actualTenantId.SYS_TENANT_ID, actualTenantId);
  }
}
