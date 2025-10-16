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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.id.TenantProfileId;
import org.thingsboard.server.dao.model.ModelConstants;

public class TenantProfileCacheKeyDiffblueTest {
  /**
   * Test {@link TenantProfileCacheKey#fromId(TenantProfileId)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return TenantProfileId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileCacheKey#fromId(TenantProfileId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TenantProfileCacheKey TenantProfileCacheKey.fromId(TenantProfileId)"})
  public void testFromId_whenNull_thenReturnTenantProfileIdIsNull() {
    // Arrange and Act
    TenantProfileCacheKey actualFromIdResult = TenantProfileCacheKey.fromId(null);

    // Assert
    assertNull(actualFromIdResult.getTenantProfileId());
    assertFalse(actualFromIdResult.isDefaultProfile());
  }

  /**
   * Test {@link TenantProfileCacheKey#defaultProfile()}.
   *
   * <p>Method under test: {@link TenantProfileCacheKey#defaultProfile()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TenantProfileCacheKey TenantProfileCacheKey.defaultProfile()"})
  public void testDefaultProfile() {
    // Arrange and Act
    TenantProfileCacheKey actualDefaultProfileResult = TenantProfileCacheKey.defaultProfile();

    // Assert
    assertNull(actualDefaultProfileResult.getTenantProfileId());
    assertTrue(actualDefaultProfileResult.isDefaultProfile());
  }

  /**
   * Test {@link TenantProfileCacheKey#toString()}.
   *
   * <ul>
   *   <li>Given defaultProfile.
   *   <li>Then return {@code default}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileCacheKey#toString()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String TenantProfileCacheKey.toString()"})
  public void testToString_givenDefaultProfile_thenReturnDefault() {
    // Arrange, Act and Assert
    assertEquals("default", TenantProfileCacheKey.defaultProfile().toString());
  }

  /**
   * Test {@link TenantProfileCacheKey#toString()}.
   *
   * <ul>
   *   <li>Then return {@code 13814000-1dd2-11b2-8080-808080808080}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileCacheKey#toString()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String TenantProfileCacheKey.toString()"})
  public void testToString_thenReturn138140001dd211b28080808080808080() {
    // Arrange, Act and Assert
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080",
        TenantProfileCacheKey.fromId(new TenantProfileId(ModelConstants.NULL_UUID)).toString());
  }

  /**
   * Test {@link TenantProfileCacheKey#equals(Object)}, and {@link
   * TenantProfileCacheKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TenantProfileCacheKey#equals(Object)}
   *   <li>{@link TenantProfileCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TenantProfileCacheKey.equals(Object)",
    "int TenantProfileCacheKey.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TenantProfileCacheKey defaultProfileResult = TenantProfileCacheKey.defaultProfile();
    TenantProfileCacheKey defaultProfileResult2 = TenantProfileCacheKey.defaultProfile();

    // Act and Assert
    assertEquals(defaultProfileResult, defaultProfileResult2);
    assertEquals(defaultProfileResult.hashCode(), defaultProfileResult2.hashCode());
  }

  /**
   * Test {@link TenantProfileCacheKey#equals(Object)}, and {@link
   * TenantProfileCacheKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TenantProfileCacheKey#equals(Object)}
   *   <li>{@link TenantProfileCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TenantProfileCacheKey.equals(Object)",
    "int TenantProfileCacheKey.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TenantProfileCacheKey fromIdResult =
        TenantProfileCacheKey.fromId(new TenantProfileId(ModelConstants.NULL_UUID));
    TenantProfileCacheKey fromIdResult2 =
        TenantProfileCacheKey.fromId(new TenantProfileId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertEquals(fromIdResult, fromIdResult2);
    assertEquals(fromIdResult.hashCode(), fromIdResult2.hashCode());
  }

  /**
   * Test {@link TenantProfileCacheKey#equals(Object)}, and {@link
   * TenantProfileCacheKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TenantProfileCacheKey#equals(Object)}
   *   <li>{@link TenantProfileCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TenantProfileCacheKey.equals(Object)",
    "int TenantProfileCacheKey.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TenantProfileCacheKey defaultProfileResult = TenantProfileCacheKey.defaultProfile();

    // Act and Assert
    assertEquals(defaultProfileResult, defaultProfileResult);
    int expectedHashCodeResult = defaultProfileResult.hashCode();
    assertEquals(expectedHashCodeResult, defaultProfileResult.hashCode());
  }

  /**
   * Test {@link TenantProfileCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileCacheKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TenantProfileCacheKey.equals(Object)",
    "int TenantProfileCacheKey.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TenantProfileCacheKey.defaultProfile(), 1);
  }

  /**
   * Test {@link TenantProfileCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileCacheKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TenantProfileCacheKey.equals(Object)",
    "int TenantProfileCacheKey.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TenantProfileCacheKey fromIdResult = TenantProfileCacheKey.fromId(null);

    // Act and Assert
    assertNotEquals(fromIdResult, TenantProfileCacheKey.defaultProfile());
  }

  /**
   * Test {@link TenantProfileCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileCacheKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TenantProfileCacheKey.equals(Object)",
    "int TenantProfileCacheKey.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TenantProfileCacheKey fromIdResult = TenantProfileCacheKey.fromId(null);

    // Act and Assert
    assertNotEquals(
        fromIdResult, TenantProfileCacheKey.fromId(new TenantProfileId(ModelConstants.NULL_UUID)));
  }

  /**
   * Test {@link TenantProfileCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileCacheKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TenantProfileCacheKey.equals(Object)",
    "int TenantProfileCacheKey.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TenantProfileCacheKey fromIdResult =
        TenantProfileCacheKey.fromId(new TenantProfileId(UUID.randomUUID()));

    // Act and Assert
    assertNotEquals(
        fromIdResult, TenantProfileCacheKey.fromId(new TenantProfileId(ModelConstants.NULL_UUID)));
  }

  /**
   * Test {@link TenantProfileCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileCacheKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TenantProfileCacheKey.equals(Object)",
    "int TenantProfileCacheKey.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TenantProfileCacheKey.defaultProfile(), null);
  }

  /**
   * Test {@link TenantProfileCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileCacheKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TenantProfileCacheKey.equals(Object)",
    "int TenantProfileCacheKey.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        TenantProfileCacheKey.defaultProfile(), "Different type to TenantProfileCacheKey");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TenantProfileCacheKey#getTenantProfileId()}
   *   <li>{@link TenantProfileCacheKey#isDefaultProfile()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TenantProfileId TenantProfileCacheKey.getTenantProfileId()",
    "boolean TenantProfileCacheKey.isDefaultProfile()"
  })
  public void testGettersAndSetters() {
    // Arrange
    TenantProfileCacheKey defaultProfileResult = TenantProfileCacheKey.defaultProfile();

    // Act
    TenantProfileId actualTenantProfileId = defaultProfileResult.getTenantProfileId();

    // Assert
    assertNull(actualTenantProfileId);
    assertTrue(defaultProfileResult.isDefaultProfile());
  }
}
