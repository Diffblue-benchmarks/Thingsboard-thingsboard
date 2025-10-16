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
package org.thingsboard.server.cache.edge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.TenantId;

class RelatedEdgesEvictEventDiffblueTest {
  /**
   * Test {@link RelatedEdgesEvictEvent#equals(Object)}, and {@link
   * RelatedEdgesEvictEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RelatedEdgesEvictEvent#equals(Object)}
   *   <li>{@link RelatedEdgesEvictEvent#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RelatedEdgesEvictEvent.equals(Object)",
    "int RelatedEdgesEvictEvent.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RelatedEdgesEvictEvent relatedEdgesEvictEvent = new RelatedEdgesEvictEvent(null, null);
    RelatedEdgesEvictEvent relatedEdgesEvictEvent2 = new RelatedEdgesEvictEvent(null, null);

    // Act and Assert
    assertEquals(relatedEdgesEvictEvent, relatedEdgesEvictEvent2);
    assertEquals(relatedEdgesEvictEvent.hashCode(), relatedEdgesEvictEvent2.hashCode());
  }

  /**
   * Test {@link RelatedEdgesEvictEvent#equals(Object)}, and {@link
   * RelatedEdgesEvictEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RelatedEdgesEvictEvent#equals(Object)}
   *   <li>{@link RelatedEdgesEvictEvent#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RelatedEdgesEvictEvent.equals(Object)",
    "int RelatedEdgesEvictEvent.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    RelatedEdgesEvictEvent relatedEdgesEvictEvent =
        new RelatedEdgesEvictEvent(new TenantId(null), null);
    RelatedEdgesEvictEvent relatedEdgesEvictEvent2 =
        new RelatedEdgesEvictEvent(new TenantId(null), null);

    // Act and Assert
    assertEquals(relatedEdgesEvictEvent, relatedEdgesEvictEvent2);
    assertEquals(relatedEdgesEvictEvent.hashCode(), relatedEdgesEvictEvent2.hashCode());
  }

  /**
   * Test {@link RelatedEdgesEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelatedEdgesEvictEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RelatedEdgesEvictEvent.equals(Object)",
    "int RelatedEdgesEvictEvent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RelatedEdgesEvictEvent relatedEdgesEvictEvent =
        new RelatedEdgesEvictEvent(new TenantId(UUID.randomUUID()), null);
    RelatedEdgesEvictEvent relatedEdgesEvictEvent2 =
        new RelatedEdgesEvictEvent(new TenantId(UUID.randomUUID()), null);

    // Act and Assert
    assertNotEquals(relatedEdgesEvictEvent, relatedEdgesEvictEvent2);
  }

  /**
   * Test {@link RelatedEdgesEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelatedEdgesEvictEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RelatedEdgesEvictEvent.equals(Object)",
    "int RelatedEdgesEvictEvent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RelatedEdgesEvictEvent relatedEdgesEvictEvent = new RelatedEdgesEvictEvent(null, null);
    RelatedEdgesEvictEvent relatedEdgesEvictEvent2 =
        new RelatedEdgesEvictEvent(new TenantId(UUID.randomUUID()), null);

    // Act and Assert
    assertNotEquals(relatedEdgesEvictEvent, relatedEdgesEvictEvent2);
  }

  /**
   * Test {@link RelatedEdgesEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelatedEdgesEvictEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RelatedEdgesEvictEvent.equals(Object)",
    "int RelatedEdgesEvictEvent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RelatedEdgesEvictEvent relatedEdgesEvictEvent =
        new RelatedEdgesEvictEvent(new TenantId(UUID.randomUUID()), null);

    // Act and Assert
    assertNotEquals(relatedEdgesEvictEvent, 1);
  }

  /**
   * Test {@link RelatedEdgesEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelatedEdgesEvictEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RelatedEdgesEvictEvent.equals(Object)",
    "int RelatedEdgesEvictEvent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    RelatedEdgesEvictEvent relatedEdgesEvictEvent =
        new RelatedEdgesEvictEvent(null, new AlarmId(UUID.randomUUID()));
    RelatedEdgesEvictEvent relatedEdgesEvictEvent2 = new RelatedEdgesEvictEvent(null, null);

    // Act and Assert
    assertNotEquals(relatedEdgesEvictEvent, relatedEdgesEvictEvent2);
  }

  /**
   * Test {@link RelatedEdgesEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelatedEdgesEvictEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RelatedEdgesEvictEvent.equals(Object)",
    "int RelatedEdgesEvictEvent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    RelatedEdgesEvictEvent relatedEdgesEvictEvent = new RelatedEdgesEvictEvent(null, null);
    RelatedEdgesEvictEvent relatedEdgesEvictEvent2 =
        new RelatedEdgesEvictEvent(null, new AlarmId(UUID.randomUUID()));

    // Act and Assert
    assertNotEquals(relatedEdgesEvictEvent, relatedEdgesEvictEvent2);
  }
}
