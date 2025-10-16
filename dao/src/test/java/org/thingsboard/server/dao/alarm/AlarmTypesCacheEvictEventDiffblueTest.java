/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.dao.alarm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.model.ModelConstants;

public class AlarmTypesCacheEvictEventDiffblueTest {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmTypesCacheEvictEvent.equals(Object)",
    "int AlarmTypesCacheEvictEvent.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AlarmTypesCacheEvictEvent alarmTypesCacheEvictEvent =
        new AlarmTypesCacheEvictEvent(ModelConstants.SYSTEM_TENANT);
    AlarmTypesCacheEvictEvent alarmTypesCacheEvictEvent2 =
        new AlarmTypesCacheEvictEvent(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertEquals(alarmTypesCacheEvictEvent, alarmTypesCacheEvictEvent2);
    assertEquals(alarmTypesCacheEvictEvent.hashCode(), alarmTypesCacheEvictEvent2.hashCode());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmTypesCacheEvictEvent.equals(Object)",
    "int AlarmTypesCacheEvictEvent.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    AlarmTypesCacheEvictEvent alarmTypesCacheEvictEvent = new AlarmTypesCacheEvictEvent(null);
    AlarmTypesCacheEvictEvent alarmTypesCacheEvictEvent2 = new AlarmTypesCacheEvictEvent(null);

    // Act and Assert
    assertEquals(alarmTypesCacheEvictEvent, alarmTypesCacheEvictEvent2);
    assertEquals(alarmTypesCacheEvictEvent.hashCode(), alarmTypesCacheEvictEvent2.hashCode());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmTypesCacheEvictEvent.equals(Object)",
    "int AlarmTypesCacheEvictEvent.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmTypesCacheEvictEvent.equals(Object)",
    "int AlarmTypesCacheEvictEvent.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
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
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmTypesCacheEvictEvent#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmTypesCacheEvictEvent.equals(Object)",
    "int AlarmTypesCacheEvictEvent.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AlarmTypesCacheEvictEvent alarmTypesCacheEvictEvent =
        new AlarmTypesCacheEvictEvent(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertNotEquals(alarmTypesCacheEvictEvent, new AlarmTypesCacheEvictEvent(null));
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmTypesCacheEvictEvent.equals(Object)",
    "int AlarmTypesCacheEvictEvent.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmTypesCacheEvictEvent.equals(Object)",
    "int AlarmTypesCacheEvictEvent.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AlarmTypesCacheEvictEvent.<init>(TenantId)",
    "TenantId AlarmTypesCacheEvictEvent.getTenantId()",
    "String AlarmTypesCacheEvictEvent.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    AlarmTypesCacheEvictEvent actualAlarmTypesCacheEvictEvent =
        new AlarmTypesCacheEvictEvent(ModelConstants.SYSTEM_TENANT);
    String actualToStringResult = actualAlarmTypesCacheEvictEvent.toString();

    // Assert
    assertEquals(
        "AlarmTypesCacheEvictEvent(tenantId=13814000-1dd2-11b2-8080-808080808080)",
        actualToStringResult);
    assertSame(TenantId.SYS_TENANT_ID, actualAlarmTypesCacheEvictEvent.getTenantId());
  }
}
