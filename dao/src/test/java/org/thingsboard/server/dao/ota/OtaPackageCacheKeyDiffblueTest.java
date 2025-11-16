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
import org.thingsboard.server.dao.ota.OtaPackageCacheKey.OtaPackageCacheKeyBuilder;

public class OtaPackageCacheKeyDiffblueTest {
  /**
   * Test {@link OtaPackageCacheKey#equals(Object)}, and {@link OtaPackageCacheKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OtaPackageCacheKey#equals(Object)}
   *   <li>{@link OtaPackageCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OtaPackageCacheKey.equals(Object)",
    "int OtaPackageCacheKey.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OtaPackageCacheKey otaPackageCacheKey = OtaPackageCacheKey.builder().id(null).build();
    OtaPackageCacheKey otaPackageCacheKey2 = OtaPackageCacheKey.builder().id(null).build();

    // Act and Assert
    assertEquals(otaPackageCacheKey, otaPackageCacheKey2);
    assertEquals(otaPackageCacheKey.hashCode(), otaPackageCacheKey2.hashCode());
  }

  /**
   * Test {@link OtaPackageCacheKey#equals(Object)}, and {@link OtaPackageCacheKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OtaPackageCacheKey#equals(Object)}
   *   <li>{@link OtaPackageCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OtaPackageCacheKey.equals(Object)",
    "int OtaPackageCacheKey.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    OtaPackageCacheKeyBuilder builderResult = OtaPackageCacheKey.builder();
    OtaPackageCacheKey otaPackageCacheKey =
        builderResult.id(new OtaPackageId(ModelConstants.NULL_UUID)).build();

    OtaPackageCacheKeyBuilder builderResult2 = OtaPackageCacheKey.builder();
    OtaPackageCacheKey otaPackageCacheKey2 =
        builderResult2.id(new OtaPackageId(ModelConstants.NULL_UUID)).build();

    // Act and Assert
    assertEquals(otaPackageCacheKey, otaPackageCacheKey2);
    assertEquals(otaPackageCacheKey.hashCode(), otaPackageCacheKey2.hashCode());
  }

  /**
   * Test {@link OtaPackageCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageCacheKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OtaPackageCacheKey.equals(Object)",
    "int OtaPackageCacheKey.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    OtaPackageCacheKeyBuilder builderResult = OtaPackageCacheKey.builder();
    OtaPackageCacheKey otaPackageCacheKey =
        builderResult.id(new OtaPackageId(ModelConstants.NULL_UUID)).build();

    // Act and Assert
    assertNotEquals(otaPackageCacheKey, OtaPackageCacheKey.builder().id(null).build());
  }

  /**
   * Test {@link OtaPackageCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageCacheKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OtaPackageCacheKey.equals(Object)",
    "int OtaPackageCacheKey.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    OtaPackageCacheKey otaPackageCacheKey = OtaPackageCacheKey.builder().id(null).build();

    OtaPackageCacheKeyBuilder builderResult = OtaPackageCacheKey.builder();

    // Act and Assert
    assertNotEquals(
        otaPackageCacheKey, builderResult.id(new OtaPackageId(ModelConstants.NULL_UUID)).build());
  }
}
