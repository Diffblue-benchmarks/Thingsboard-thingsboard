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
package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.dao.model.ModelConstants;

public class MobileAppOauth2ClientCompositeKeyDiffblueTest {
  /**
   * Test {@link MobileAppOauth2ClientCompositeKey#equals(Object)}, and {@link
   * MobileAppOauth2ClientCompositeKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MobileAppOauth2ClientCompositeKey#equals(Object)}
   *   <li>{@link MobileAppOauth2ClientCompositeKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MobileAppOauth2ClientCompositeKey.equals(Object)",
    "int MobileAppOauth2ClientCompositeKey.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MobileAppOauth2ClientCompositeKey mobileAppOauth2ClientCompositeKey =
        new MobileAppOauth2ClientCompositeKey();
    MobileAppOauth2ClientCompositeKey mobileAppOauth2ClientCompositeKey2 =
        new MobileAppOauth2ClientCompositeKey();

    // Act and Assert
    assertEquals(mobileAppOauth2ClientCompositeKey, mobileAppOauth2ClientCompositeKey2);
    assertEquals(
        mobileAppOauth2ClientCompositeKey.hashCode(),
        mobileAppOauth2ClientCompositeKey2.hashCode());
  }

  /**
   * Test {@link MobileAppOauth2ClientCompositeKey#equals(Object)}, and {@link
   * MobileAppOauth2ClientCompositeKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MobileAppOauth2ClientCompositeKey#equals(Object)}
   *   <li>{@link MobileAppOauth2ClientCompositeKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MobileAppOauth2ClientCompositeKey.equals(Object)",
    "int MobileAppOauth2ClientCompositeKey.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    MobileAppOauth2ClientCompositeKey mobileAppOauth2ClientCompositeKey =
        new MobileAppOauth2ClientCompositeKey(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);
    MobileAppOauth2ClientCompositeKey mobileAppOauth2ClientCompositeKey2 =
        new MobileAppOauth2ClientCompositeKey(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(mobileAppOauth2ClientCompositeKey, mobileAppOauth2ClientCompositeKey2);
    assertEquals(
        mobileAppOauth2ClientCompositeKey.hashCode(),
        mobileAppOauth2ClientCompositeKey2.hashCode());
  }

  /**
   * Test {@link MobileAppOauth2ClientCompositeKey#equals(Object)}, and {@link
   * MobileAppOauth2ClientCompositeKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MobileAppOauth2ClientCompositeKey#equals(Object)}
   *   <li>{@link MobileAppOauth2ClientCompositeKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MobileAppOauth2ClientCompositeKey.equals(Object)",
    "int MobileAppOauth2ClientCompositeKey.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MobileAppOauth2ClientCompositeKey mobileAppOauth2ClientCompositeKey =
        new MobileAppOauth2ClientCompositeKey();

    // Act and Assert
    assertEquals(mobileAppOauth2ClientCompositeKey, mobileAppOauth2ClientCompositeKey);
    int expectedHashCodeResult = mobileAppOauth2ClientCompositeKey.hashCode();
    assertEquals(expectedHashCodeResult, mobileAppOauth2ClientCompositeKey.hashCode());
  }

  /**
   * Test {@link MobileAppOauth2ClientCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppOauth2ClientCompositeKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MobileAppOauth2ClientCompositeKey.equals(Object)",
    "int MobileAppOauth2ClientCompositeKey.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    MobileAppOauth2ClientCompositeKey mobileAppOauth2ClientCompositeKey =
        new MobileAppOauth2ClientCompositeKey(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(mobileAppOauth2ClientCompositeKey, new MobileAppOauth2ClientCompositeKey());
  }

  /**
   * Test {@link MobileAppOauth2ClientCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppOauth2ClientCompositeKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MobileAppOauth2ClientCompositeKey.equals(Object)",
    "int MobileAppOauth2ClientCompositeKey.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    MobileAppOauth2ClientCompositeKey mobileAppOauth2ClientCompositeKey =
        new MobileAppOauth2ClientCompositeKey();

    // Act and Assert
    assertNotEquals(
        mobileAppOauth2ClientCompositeKey,
        new MobileAppOauth2ClientCompositeKey(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID));
  }

  /**
   * Test {@link MobileAppOauth2ClientCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppOauth2ClientCompositeKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MobileAppOauth2ClientCompositeKey.equals(Object)",
    "int MobileAppOauth2ClientCompositeKey.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    MobileAppOauth2ClientCompositeKey mobileAppOauth2ClientCompositeKey =
        new MobileAppOauth2ClientCompositeKey();
    mobileAppOauth2ClientCompositeKey.setOauth2ClientId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(mobileAppOauth2ClientCompositeKey, new MobileAppOauth2ClientCompositeKey());
  }

  /**
   * Test {@link MobileAppOauth2ClientCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppOauth2ClientCompositeKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MobileAppOauth2ClientCompositeKey.equals(Object)",
    "int MobileAppOauth2ClientCompositeKey.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    MobileAppOauth2ClientCompositeKey mobileAppOauth2ClientCompositeKey =
        new MobileAppOauth2ClientCompositeKey();

    MobileAppOauth2ClientCompositeKey mobileAppOauth2ClientCompositeKey2 =
        new MobileAppOauth2ClientCompositeKey();
    mobileAppOauth2ClientCompositeKey2.setOauth2ClientId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(mobileAppOauth2ClientCompositeKey, mobileAppOauth2ClientCompositeKey2);
  }

  /**
   * Test {@link MobileAppOauth2ClientCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppOauth2ClientCompositeKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MobileAppOauth2ClientCompositeKey.equals(Object)",
    "int MobileAppOauth2ClientCompositeKey.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MobileAppOauth2ClientCompositeKey(), null);
  }

  /**
   * Test {@link MobileAppOauth2ClientCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppOauth2ClientCompositeKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MobileAppOauth2ClientCompositeKey.equals(Object)",
    "int MobileAppOauth2ClientCompositeKey.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new MobileAppOauth2ClientCompositeKey(),
        "Different type to MobileAppOauth2ClientCompositeKey");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MobileAppOauth2ClientCompositeKey#MobileAppOauth2ClientCompositeKey()}
   *   <li>{@link MobileAppOauth2ClientCompositeKey#setMobileAppId(UUID)}
   *   <li>{@link MobileAppOauth2ClientCompositeKey#setOauth2ClientId(UUID)}
   *   <li>{@link MobileAppOauth2ClientCompositeKey#toString()}
   *   <li>{@link MobileAppOauth2ClientCompositeKey#getMobileAppId()}
   *   <li>{@link MobileAppOauth2ClientCompositeKey#getOauth2ClientId()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MobileAppOauth2ClientCompositeKey.<init>()",
    "void MobileAppOauth2ClientCompositeKey.<init>(UUID, UUID)",
    "UUID MobileAppOauth2ClientCompositeKey.getMobileAppId()",
    "UUID MobileAppOauth2ClientCompositeKey.getOauth2ClientId()",
    "void MobileAppOauth2ClientCompositeKey.setMobileAppId(UUID)",
    "void MobileAppOauth2ClientCompositeKey.setOauth2ClientId(UUID)",
    "String MobileAppOauth2ClientCompositeKey.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    MobileAppOauth2ClientCompositeKey actualMobileAppOauth2ClientCompositeKey =
        new MobileAppOauth2ClientCompositeKey();
    actualMobileAppOauth2ClientCompositeKey.setMobileAppId(ModelConstants.NULL_UUID);
    UUID oauth2ClientId = ModelConstants.NULL_UUID;
    actualMobileAppOauth2ClientCompositeKey.setOauth2ClientId(oauth2ClientId);
    String actualToStringResult = actualMobileAppOauth2ClientCompositeKey.toString();
    UUID actualMobileAppId = actualMobileAppOauth2ClientCompositeKey.getMobileAppId();

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualMobileAppId.toString());
    assertEquals(
        "MobileAppOauth2ClientCompositeKey(mobileAppId=13814000-1dd2-11b2-8080-808080808080, oauth2ClientId"
            + "=13814000-1dd2-11b2-8080-808080808080)",
        actualToStringResult);
    assertSame(oauth2ClientId, actualMobileAppId);
    assertSame(oauth2ClientId, actualMobileAppOauth2ClientCompositeKey.getOauth2ClientId());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MobileAppOauth2ClientCompositeKey#MobileAppOauth2ClientCompositeKey(UUID, UUID)}
   *   <li>{@link MobileAppOauth2ClientCompositeKey#setMobileAppId(UUID)}
   *   <li>{@link MobileAppOauth2ClientCompositeKey#setOauth2ClientId(UUID)}
   *   <li>{@link MobileAppOauth2ClientCompositeKey#toString()}
   *   <li>{@link MobileAppOauth2ClientCompositeKey#getMobileAppId()}
   *   <li>{@link MobileAppOauth2ClientCompositeKey#getOauth2ClientId()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MobileAppOauth2ClientCompositeKey.<init>()",
    "void MobileAppOauth2ClientCompositeKey.<init>(UUID, UUID)",
    "UUID MobileAppOauth2ClientCompositeKey.getMobileAppId()",
    "UUID MobileAppOauth2ClientCompositeKey.getOauth2ClientId()",
    "void MobileAppOauth2ClientCompositeKey.setMobileAppId(UUID)",
    "void MobileAppOauth2ClientCompositeKey.setOauth2ClientId(UUID)",
    "String MobileAppOauth2ClientCompositeKey.toString()"
  })
  public void testGettersAndSetters_whenNull_uuid() {
    // Arrange and Act
    MobileAppOauth2ClientCompositeKey actualMobileAppOauth2ClientCompositeKey =
        new MobileAppOauth2ClientCompositeKey(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);
    actualMobileAppOauth2ClientCompositeKey.setMobileAppId(ModelConstants.NULL_UUID);
    UUID oauth2ClientId = ModelConstants.NULL_UUID;
    actualMobileAppOauth2ClientCompositeKey.setOauth2ClientId(oauth2ClientId);
    String actualToStringResult = actualMobileAppOauth2ClientCompositeKey.toString();
    UUID actualMobileAppId = actualMobileAppOauth2ClientCompositeKey.getMobileAppId();

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualMobileAppId.toString());
    assertEquals(
        "MobileAppOauth2ClientCompositeKey(mobileAppId=13814000-1dd2-11b2-8080-808080808080, oauth2ClientId"
            + "=13814000-1dd2-11b2-8080-808080808080)",
        actualToStringResult);
    assertSame(oauth2ClientId, actualMobileAppId);
    assertSame(oauth2ClientId, actualMobileAppOauth2ClientCompositeKey.getOauth2ClientId());
  }
}
