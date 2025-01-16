package org.thingsboard.server.dao.alarm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import org.junit.Test;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.model.ModelConstants;

public class AlarmTypesCacheEvictEventDiffblueTest {
  /**
   * Test {@link AlarmTypesCacheEvictEvent#equals(Object)}, and
   * {@link AlarmTypesCacheEvictEvent#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmTypesCacheEvictEvent#equals(Object)}
   *   <li>{@link AlarmTypesCacheEvictEvent#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AlarmTypesCacheEvictEvent alarmTypesCacheEvictEvent = new AlarmTypesCacheEvictEvent(ModelConstants.SYSTEM_TENANT);
    AlarmTypesCacheEvictEvent alarmTypesCacheEvictEvent2 = new AlarmTypesCacheEvictEvent(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertEquals(alarmTypesCacheEvictEvent, alarmTypesCacheEvictEvent2);
    int expectedHashCodeResult = alarmTypesCacheEvictEvent.hashCode();
    assertEquals(expectedHashCodeResult, alarmTypesCacheEvictEvent2.hashCode());
  }

  /**
   * Test {@link AlarmTypesCacheEvictEvent#equals(Object)}, and
   * {@link AlarmTypesCacheEvictEvent#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmTypesCacheEvictEvent#equals(Object)}
   *   <li>{@link AlarmTypesCacheEvictEvent#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    AlarmTypesCacheEvictEvent alarmTypesCacheEvictEvent = new AlarmTypesCacheEvictEvent(null);
    AlarmTypesCacheEvictEvent alarmTypesCacheEvictEvent2 = new AlarmTypesCacheEvictEvent(null);

    // Act and Assert
    assertEquals(alarmTypesCacheEvictEvent, alarmTypesCacheEvictEvent2);
    int expectedHashCodeResult = alarmTypesCacheEvictEvent.hashCode();
    assertEquals(expectedHashCodeResult, alarmTypesCacheEvictEvent2.hashCode());
  }

  /**
   * Test {@link AlarmTypesCacheEvictEvent#equals(Object)}, and
   * {@link AlarmTypesCacheEvictEvent#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmTypesCacheEvictEvent#equals(Object)}
   *   <li>{@link AlarmTypesCacheEvictEvent#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AlarmTypesCacheEvictEvent alarmTypesCacheEvictEvent = new AlarmTypesCacheEvictEvent(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertEquals(alarmTypesCacheEvictEvent, alarmTypesCacheEvictEvent);
    int expectedHashCodeResult = alarmTypesCacheEvictEvent.hashCode();
    assertEquals(expectedHashCodeResult, alarmTypesCacheEvictEvent.hashCode());
  }

  /**
   * Test {@link AlarmTypesCacheEvictEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmTypesCacheEvictEvent#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AlarmTypesCacheEvictEvent alarmTypesCacheEvictEvent = new AlarmTypesCacheEvictEvent(null);

    // Act and Assert
    assertNotEquals(alarmTypesCacheEvictEvent, new AlarmTypesCacheEvictEvent(ModelConstants.SYSTEM_TENANT));
  }

  /**
   * Test {@link AlarmTypesCacheEvictEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmTypesCacheEvictEvent#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AlarmTypesCacheEvictEvent alarmTypesCacheEvictEvent = new AlarmTypesCacheEvictEvent(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertNotEquals(alarmTypesCacheEvictEvent, new AlarmTypesCacheEvictEvent(null));
  }

  /**
   * Test {@link AlarmTypesCacheEvictEvent#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmTypesCacheEvictEvent#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AlarmTypesCacheEvictEvent(ModelConstants.SYSTEM_TENANT), null);
  }

  /**
   * Test {@link AlarmTypesCacheEvictEvent#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmTypesCacheEvictEvent#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AlarmTypesCacheEvictEvent(ModelConstants.SYSTEM_TENANT),
        "Different type to AlarmTypesCacheEvictEvent");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmTypesCacheEvictEvent#AlarmTypesCacheEvictEvent(TenantId)}
   *   <li>{@link AlarmTypesCacheEvictEvent#toString()}
   *   <li>{@link AlarmTypesCacheEvictEvent#getTenantId()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    AlarmTypesCacheEvictEvent actualAlarmTypesCacheEvictEvent = new AlarmTypesCacheEvictEvent(
        ModelConstants.SYSTEM_TENANT);
    String actualToStringResult = actualAlarmTypesCacheEvictEvent.toString();
    TenantId actualTenantId = actualAlarmTypesCacheEvictEvent.getTenantId();

    // Assert
    assertEquals("AlarmTypesCacheEvictEvent(tenantId=13814000-1dd2-11b2-8080-808080808080)", actualToStringResult);
    assertSame(actualTenantId.SYS_TENANT_ID, actualTenantId);
  }
}
