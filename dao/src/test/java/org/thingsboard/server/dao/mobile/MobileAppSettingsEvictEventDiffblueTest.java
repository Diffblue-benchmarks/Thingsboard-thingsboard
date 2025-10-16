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
package org.thingsboard.server.dao.mobile;

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

public class MobileAppSettingsEvictEventDiffblueTest {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MobileAppSettingsEvictEvent.equals(Object)",
    "int MobileAppSettingsEvictEvent.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MobileAppSettingsEvictEvent mobileAppSettingsEvictEvent =
        new MobileAppSettingsEvictEvent(ModelConstants.SYSTEM_TENANT);
    MobileAppSettingsEvictEvent mobileAppSettingsEvictEvent2 =
        new MobileAppSettingsEvictEvent(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertEquals(mobileAppSettingsEvictEvent, mobileAppSettingsEvictEvent2);
    assertEquals(mobileAppSettingsEvictEvent.hashCode(), mobileAppSettingsEvictEvent2.hashCode());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MobileAppSettingsEvictEvent.equals(Object)",
    "int MobileAppSettingsEvictEvent.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    MobileAppSettingsEvictEvent mobileAppSettingsEvictEvent = new MobileAppSettingsEvictEvent(null);
    MobileAppSettingsEvictEvent mobileAppSettingsEvictEvent2 =
        new MobileAppSettingsEvictEvent(null);

    // Act and Assert
    assertEquals(mobileAppSettingsEvictEvent, mobileAppSettingsEvictEvent2);
    assertEquals(mobileAppSettingsEvictEvent.hashCode(), mobileAppSettingsEvictEvent2.hashCode());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MobileAppSettingsEvictEvent.equals(Object)",
    "int MobileAppSettingsEvictEvent.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MobileAppSettingsEvictEvent.equals(Object)",
    "int MobileAppSettingsEvictEvent.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
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
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppSettingsEvictEvent#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MobileAppSettingsEvictEvent.equals(Object)",
    "int MobileAppSettingsEvictEvent.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    MobileAppSettingsEvictEvent mobileAppSettingsEvictEvent =
        new MobileAppSettingsEvictEvent(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertNotEquals(mobileAppSettingsEvictEvent, new MobileAppSettingsEvictEvent(null));
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MobileAppSettingsEvictEvent.equals(Object)",
    "int MobileAppSettingsEvictEvent.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MobileAppSettingsEvictEvent.equals(Object)",
    "int MobileAppSettingsEvictEvent.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MobileAppSettingsEvictEvent.<init>(TenantId)",
    "TenantId MobileAppSettingsEvictEvent.getTenantId()",
    "String MobileAppSettingsEvictEvent.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    MobileAppSettingsEvictEvent actualMobileAppSettingsEvictEvent =
        new MobileAppSettingsEvictEvent(ModelConstants.SYSTEM_TENANT);
    String actualToStringResult = actualMobileAppSettingsEvictEvent.toString();

    // Assert
    assertEquals(
        "MobileAppSettingsEvictEvent(tenantId=13814000-1dd2-11b2-8080-808080808080)",
        actualToStringResult);
    assertSame(TenantId.SYS_TENANT_ID, actualMobileAppSettingsEvictEvent.getTenantId());
  }
}
