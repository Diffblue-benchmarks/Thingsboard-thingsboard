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
package org.thingsboard.server.queue.discovery;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
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
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TenantRoutingInfo tenantRoutingInfo = new TenantRoutingInfo(new TenantId(null), null, true);
    TenantRoutingInfo tenantRoutingInfo2 = new TenantRoutingInfo(new TenantId(null), null, true);

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
    TenantRoutingInfo tenantRoutingInfo =
        new TenantRoutingInfo(null, new TenantProfileId(null), true);
    TenantRoutingInfo tenantRoutingInfo2 =
        new TenantRoutingInfo(null, mock(TenantProfileId.class), true);

    // Act and Assert
    assertEquals(tenantRoutingInfo, tenantRoutingInfo2);
    assertNotEquals(tenantRoutingInfo.hashCode(), tenantRoutingInfo2.hashCode());
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

    // Act and Assert
    assertNotEquals(
        tenantRoutingInfo, new TenantRoutingInfo(new TenantId(UUID.randomUUID()), null, true));
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

    // Act and Assert
    assertNotEquals(
        tenantRoutingInfo, new TenantRoutingInfo(new TenantId(UUID.randomUUID()), null, true));
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
    TenantRoutingInfo tenantRoutingInfo =
        new TenantRoutingInfo(new TenantId(UUID.randomUUID()), null, false);

    // Act and Assert
    assertNotEquals(
        tenantRoutingInfo, new TenantRoutingInfo(new TenantId(UUID.randomUUID()), null, true));
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
    // Arrange, Act and Assert
    assertNotEquals(new TenantRoutingInfo(new TenantId(UUID.randomUUID()), null, true), 1);
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
    TenantRoutingInfo tenantRoutingInfo =
        new TenantRoutingInfo(null, new TenantProfileId(UUID.randomUUID()), true);

    // Act and Assert
    assertNotEquals(tenantRoutingInfo, new TenantRoutingInfo(null, null, true));
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

    // Act and Assert
    assertNotEquals(
        tenantRoutingInfo,
        new TenantRoutingInfo(null, new TenantProfileId(UUID.randomUUID()), true));
  }
}
