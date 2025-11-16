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
package org.thingsboard.server.dao.ota;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.id.OtaPackageId;
import org.thingsboard.server.dao.model.ModelConstants;

public class OtaPackageCacheEvictEventDiffblueTest {
  /**
   * Test {@link OtaPackageCacheEvictEvent#equals(Object)}, and {@link
   * OtaPackageCacheEvictEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OtaPackageCacheEvictEvent#equals(Object)}
   *   <li>{@link OtaPackageCacheEvictEvent#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OtaPackageCacheEvictEvent.equals(Object)",
    "int OtaPackageCacheEvictEvent.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OtaPackageCacheEvictEvent otaPackageCacheEvictEvent = new OtaPackageCacheEvictEvent(null);
    OtaPackageCacheEvictEvent otaPackageCacheEvictEvent2 = new OtaPackageCacheEvictEvent(null);

    // Act and Assert
    assertEquals(otaPackageCacheEvictEvent, otaPackageCacheEvictEvent2);
    assertEquals(otaPackageCacheEvictEvent.hashCode(), otaPackageCacheEvictEvent2.hashCode());
  }

  /**
   * Test {@link OtaPackageCacheEvictEvent#equals(Object)}, and {@link
   * OtaPackageCacheEvictEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OtaPackageCacheEvictEvent#equals(Object)}
   *   <li>{@link OtaPackageCacheEvictEvent#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OtaPackageCacheEvictEvent.equals(Object)",
    "int OtaPackageCacheEvictEvent.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    OtaPackageCacheEvictEvent otaPackageCacheEvictEvent =
        new OtaPackageCacheEvictEvent(new OtaPackageId(ModelConstants.NULL_UUID));
    OtaPackageCacheEvictEvent otaPackageCacheEvictEvent2 =
        new OtaPackageCacheEvictEvent(new OtaPackageId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertEquals(otaPackageCacheEvictEvent, otaPackageCacheEvictEvent2);
    assertEquals(otaPackageCacheEvictEvent.hashCode(), otaPackageCacheEvictEvent2.hashCode());
  }

  /**
   * Test {@link OtaPackageCacheEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageCacheEvictEvent#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OtaPackageCacheEvictEvent.equals(Object)",
    "int OtaPackageCacheEvictEvent.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    OtaPackageCacheEvictEvent otaPackageCacheEvictEvent =
        new OtaPackageCacheEvictEvent(new OtaPackageId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertNotEquals(otaPackageCacheEvictEvent, new OtaPackageCacheEvictEvent(null));
  }

  /**
   * Test {@link OtaPackageCacheEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageCacheEvictEvent#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OtaPackageCacheEvictEvent.equals(Object)",
    "int OtaPackageCacheEvictEvent.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new OtaPackageCacheEvictEvent(null), 1);
  }

  /**
   * Test {@link OtaPackageCacheEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageCacheEvictEvent#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OtaPackageCacheEvictEvent.equals(Object)",
    "int OtaPackageCacheEvictEvent.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    OtaPackageCacheEvictEvent otaPackageCacheEvictEvent = new OtaPackageCacheEvictEvent(null);

    // Act and Assert
    assertNotEquals(
        otaPackageCacheEvictEvent,
        new OtaPackageCacheEvictEvent(new OtaPackageId(ModelConstants.NULL_UUID)));
  }
}
