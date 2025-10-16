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
package org.thingsboard.server.dao.tenant;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.model.ModelConstants;

public class TenantEvictEventDiffblueTest {
  /**
   * Test {@link TenantEvictEvent#equals(Object)}, and {@link TenantEvictEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TenantEvictEvent#equals(Object)}
   *   <li>{@link TenantEvictEvent#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TenantEvictEvent.equals(Object)", "int TenantEvictEvent.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TenantEvictEvent tenantEvictEvent = new TenantEvictEvent(ModelConstants.SYSTEM_TENANT, true);
    TenantEvictEvent tenantEvictEvent2 = new TenantEvictEvent(ModelConstants.SYSTEM_TENANT, true);

    // Act and Assert
    assertEquals(tenantEvictEvent, tenantEvictEvent2);
    assertEquals(tenantEvictEvent.hashCode(), tenantEvictEvent2.hashCode());
  }

  /**
   * Test {@link TenantEvictEvent#equals(Object)}, and {@link TenantEvictEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TenantEvictEvent#equals(Object)}
   *   <li>{@link TenantEvictEvent#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TenantEvictEvent.equals(Object)", "int TenantEvictEvent.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TenantEvictEvent tenantEvictEvent = new TenantEvictEvent(null, true);
    TenantEvictEvent tenantEvictEvent2 = new TenantEvictEvent(null, true);

    // Act and Assert
    assertEquals(tenantEvictEvent, tenantEvictEvent2);
    assertEquals(tenantEvictEvent.hashCode(), tenantEvictEvent2.hashCode());
  }

  /**
   * Test {@link TenantEvictEvent#equals(Object)}, and {@link TenantEvictEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TenantEvictEvent#equals(Object)}
   *   <li>{@link TenantEvictEvent#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TenantEvictEvent.equals(Object)", "int TenantEvictEvent.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TenantEvictEvent tenantEvictEvent = new TenantEvictEvent(ModelConstants.SYSTEM_TENANT, true);

    // Act and Assert
    assertEquals(tenantEvictEvent, tenantEvictEvent);
    int expectedHashCodeResult = tenantEvictEvent.hashCode();
    assertEquals(expectedHashCodeResult, tenantEvictEvent.hashCode());
  }

  /**
   * Test {@link TenantEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TenantEvictEvent#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TenantEvictEvent.equals(Object)", "int TenantEvictEvent.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TenantEvictEvent tenantEvictEvent = new TenantEvictEvent(null, true);

    // Act and Assert
    assertNotEquals(tenantEvictEvent, new TenantEvictEvent(ModelConstants.SYSTEM_TENANT, true));
  }

  /**
   * Test {@link TenantEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TenantEvictEvent#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TenantEvictEvent.equals(Object)", "int TenantEvictEvent.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TenantEvictEvent tenantEvictEvent = new TenantEvictEvent(ModelConstants.SYSTEM_TENANT, false);

    // Act and Assert
    assertNotEquals(tenantEvictEvent, new TenantEvictEvent(ModelConstants.SYSTEM_TENANT, true));
  }

  /**
   * Test {@link TenantEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TenantEvictEvent#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TenantEvictEvent.equals(Object)", "int TenantEvictEvent.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TenantEvictEvent tenantEvictEvent = new TenantEvictEvent(ModelConstants.SYSTEM_TENANT, true);

    // Act and Assert
    assertNotEquals(tenantEvictEvent, new TenantEvictEvent(null, true));
  }

  /**
   * Test {@link TenantEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TenantEvictEvent#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TenantEvictEvent.equals(Object)", "int TenantEvictEvent.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TenantEvictEvent(ModelConstants.SYSTEM_TENANT, true), null);
  }

  /**
   * Test {@link TenantEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TenantEvictEvent#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TenantEvictEvent.equals(Object)", "int TenantEvictEvent.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new TenantEvictEvent(ModelConstants.SYSTEM_TENANT, true),
        "Different type to TenantEvictEvent");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TenantEvictEvent#TenantEvictEvent(TenantId, boolean)}
   *   <li>{@link TenantEvictEvent#toString()}
   *   <li>{@link TenantEvictEvent#getTenantId()}
   *   <li>{@link TenantEvictEvent#isInvalidateExists()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TenantEvictEvent.<init>(TenantId, boolean)",
    "TenantId TenantEvictEvent.getTenantId()",
    "boolean TenantEvictEvent.isInvalidateExists()",
    "String TenantEvictEvent.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    TenantEvictEvent actualTenantEvictEvent =
        new TenantEvictEvent(ModelConstants.SYSTEM_TENANT, true);
    String actualToStringResult = actualTenantEvictEvent.toString();
    TenantId actualTenantId = actualTenantEvictEvent.getTenantId();

    // Assert
    assertEquals(
        "TenantEvictEvent(tenantId=13814000-1dd2-11b2-8080-808080808080, invalidateExists=true)",
        actualToStringResult);
    assertTrue(actualTenantEvictEvent.isInvalidateExists());
    assertSame(TenantId.SYS_TENANT_ID, actualTenantId);
  }
}
