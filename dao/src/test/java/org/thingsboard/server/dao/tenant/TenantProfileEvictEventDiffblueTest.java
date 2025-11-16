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
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.id.TenantProfileId;
import org.thingsboard.server.dao.model.ModelConstants;

public class TenantProfileEvictEventDiffblueTest {
  /**
   * Test {@link TenantProfileEvictEvent#equals(Object)}, and {@link
   * TenantProfileEvictEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TenantProfileEvictEvent#equals(Object)}
   *   <li>{@link TenantProfileEvictEvent#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TenantProfileEvictEvent.equals(Object)",
    "int TenantProfileEvictEvent.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TenantProfileEvictEvent tenantProfileEvictEvent = new TenantProfileEvictEvent(null, true);
    TenantProfileEvictEvent tenantProfileEvictEvent2 = new TenantProfileEvictEvent(null, true);

    // Act and Assert
    assertEquals(tenantProfileEvictEvent, tenantProfileEvictEvent2);
    assertEquals(tenantProfileEvictEvent.hashCode(), tenantProfileEvictEvent2.hashCode());
  }

  /**
   * Test {@link TenantProfileEvictEvent#equals(Object)}, and {@link
   * TenantProfileEvictEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TenantProfileEvictEvent#equals(Object)}
   *   <li>{@link TenantProfileEvictEvent#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TenantProfileEvictEvent.equals(Object)",
    "int TenantProfileEvictEvent.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TenantProfileEvictEvent tenantProfileEvictEvent =
        new TenantProfileEvictEvent(new TenantProfileId(ModelConstants.NULL_UUID), true);
    TenantProfileEvictEvent tenantProfileEvictEvent2 =
        new TenantProfileEvictEvent(new TenantProfileId(ModelConstants.NULL_UUID), true);

    // Act and Assert
    assertEquals(tenantProfileEvictEvent, tenantProfileEvictEvent2);
    assertEquals(tenantProfileEvictEvent.hashCode(), tenantProfileEvictEvent2.hashCode());
  }

  /**
   * Test {@link TenantProfileEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileEvictEvent#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TenantProfileEvictEvent.equals(Object)",
    "int TenantProfileEvictEvent.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TenantProfileEvictEvent tenantProfileEvictEvent =
        new TenantProfileEvictEvent(new TenantProfileId(ModelConstants.NULL_UUID), true);

    // Act and Assert
    assertNotEquals(tenantProfileEvictEvent, new TenantProfileEvictEvent(null, true));
  }

  /**
   * Test {@link TenantProfileEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileEvictEvent#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TenantProfileEvictEvent.equals(Object)",
    "int TenantProfileEvictEvent.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TenantProfileEvictEvent tenantProfileEvictEvent = new TenantProfileEvictEvent(null, false);

    // Act and Assert
    assertNotEquals(tenantProfileEvictEvent, new TenantProfileEvictEvent(null, true));
  }

  /**
   * Test {@link TenantProfileEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileEvictEvent#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TenantProfileEvictEvent.equals(Object)",
    "int TenantProfileEvictEvent.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange, Act and Assert
    assertNotEquals(new TenantProfileEvictEvent(null, true), 1);
  }

  /**
   * Test {@link TenantProfileEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileEvictEvent#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TenantProfileEvictEvent.equals(Object)",
    "int TenantProfileEvictEvent.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TenantProfileEvictEvent tenantProfileEvictEvent = new TenantProfileEvictEvent(null, true);

    // Act and Assert
    assertNotEquals(
        tenantProfileEvictEvent,
        new TenantProfileEvictEvent(new TenantProfileId(ModelConstants.NULL_UUID), true));
  }
}
