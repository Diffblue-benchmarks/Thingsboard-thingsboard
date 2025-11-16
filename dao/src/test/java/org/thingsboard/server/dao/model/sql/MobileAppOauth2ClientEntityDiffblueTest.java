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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.MobileAppId;
import org.thingsboard.server.common.data.id.OAuth2ClientId;
import org.thingsboard.server.common.data.mobile.MobileAppOauth2Client;
import org.thingsboard.server.dao.model.ModelConstants;

public class MobileAppOauth2ClientEntityDiffblueTest {
  /**
   * Test {@link MobileAppOauth2ClientEntity#equals(Object)}, and {@link
   * MobileAppOauth2ClientEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MobileAppOauth2ClientEntity#equals(Object)}
   *   <li>{@link MobileAppOauth2ClientEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MobileAppOauth2ClientEntity.equals(Object)",
    "int MobileAppOauth2ClientEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MobileAppOauth2ClientEntity mobileAppOauth2ClientEntity = new MobileAppOauth2ClientEntity();
    mobileAppOauth2ClientEntity.setMobileAppId(ModelConstants.NULL_UUID);
    mobileAppOauth2ClientEntity.setOauth2ClientId(ModelConstants.NULL_UUID);

    MobileAppOauth2ClientEntity mobileAppOauth2ClientEntity2 = new MobileAppOauth2ClientEntity();
    mobileAppOauth2ClientEntity2.setMobileAppId(ModelConstants.NULL_UUID);
    mobileAppOauth2ClientEntity2.setOauth2ClientId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(mobileAppOauth2ClientEntity, mobileAppOauth2ClientEntity2);
    assertEquals(mobileAppOauth2ClientEntity.hashCode(), mobileAppOauth2ClientEntity2.hashCode());
  }

  /**
   * Test {@link MobileAppOauth2ClientEntity#equals(Object)}, and {@link
   * MobileAppOauth2ClientEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MobileAppOauth2ClientEntity#equals(Object)}
   *   <li>{@link MobileAppOauth2ClientEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MobileAppOauth2ClientEntity.equals(Object)",
    "int MobileAppOauth2ClientEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    MobileAppOauth2ClientEntity mobileAppOauth2ClientEntity = new MobileAppOauth2ClientEntity();
    mobileAppOauth2ClientEntity.setMobileAppId(null);
    mobileAppOauth2ClientEntity.setOauth2ClientId(ModelConstants.NULL_UUID);

    MobileAppOauth2ClientEntity mobileAppOauth2ClientEntity2 = new MobileAppOauth2ClientEntity();
    mobileAppOauth2ClientEntity2.setMobileAppId(null);
    mobileAppOauth2ClientEntity2.setOauth2ClientId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(mobileAppOauth2ClientEntity, mobileAppOauth2ClientEntity2);
    assertEquals(mobileAppOauth2ClientEntity.hashCode(), mobileAppOauth2ClientEntity2.hashCode());
  }

  /**
   * Test {@link MobileAppOauth2ClientEntity#equals(Object)}, and {@link
   * MobileAppOauth2ClientEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MobileAppOauth2ClientEntity#equals(Object)}
   *   <li>{@link MobileAppOauth2ClientEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MobileAppOauth2ClientEntity.equals(Object)",
    "int MobileAppOauth2ClientEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    MobileAppOauth2ClientEntity mobileAppOauth2ClientEntity = new MobileAppOauth2ClientEntity();
    mobileAppOauth2ClientEntity.setMobileAppId(ModelConstants.NULL_UUID);
    mobileAppOauth2ClientEntity.setOauth2ClientId(null);

    MobileAppOauth2ClientEntity mobileAppOauth2ClientEntity2 = new MobileAppOauth2ClientEntity();
    mobileAppOauth2ClientEntity2.setMobileAppId(ModelConstants.NULL_UUID);
    mobileAppOauth2ClientEntity2.setOauth2ClientId(null);

    // Act and Assert
    assertEquals(mobileAppOauth2ClientEntity, mobileAppOauth2ClientEntity2);
    assertEquals(mobileAppOauth2ClientEntity.hashCode(), mobileAppOauth2ClientEntity2.hashCode());
  }

  /**
   * Test {@link MobileAppOauth2ClientEntity#equals(Object)}, and {@link
   * MobileAppOauth2ClientEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MobileAppOauth2ClientEntity#equals(Object)}
   *   <li>{@link MobileAppOauth2ClientEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MobileAppOauth2ClientEntity.equals(Object)",
    "int MobileAppOauth2ClientEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MobileAppOauth2ClientEntity mobileAppOauth2ClientEntity = new MobileAppOauth2ClientEntity();
    mobileAppOauth2ClientEntity.setMobileAppId(ModelConstants.NULL_UUID);
    mobileAppOauth2ClientEntity.setOauth2ClientId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(mobileAppOauth2ClientEntity, mobileAppOauth2ClientEntity);
    int expectedHashCodeResult = mobileAppOauth2ClientEntity.hashCode();
    assertEquals(expectedHashCodeResult, mobileAppOauth2ClientEntity.hashCode());
  }

  /**
   * Test {@link MobileAppOauth2ClientEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppOauth2ClientEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MobileAppOauth2ClientEntity.equals(Object)",
    "int MobileAppOauth2ClientEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    MobileAppOauth2ClientEntity mobileAppOauth2ClientEntity = new MobileAppOauth2ClientEntity();
    mobileAppOauth2ClientEntity.setMobileAppId(UUID.randomUUID());
    mobileAppOauth2ClientEntity.setOauth2ClientId(ModelConstants.NULL_UUID);

    MobileAppOauth2ClientEntity mobileAppOauth2ClientEntity2 = new MobileAppOauth2ClientEntity();
    mobileAppOauth2ClientEntity2.setMobileAppId(ModelConstants.NULL_UUID);
    mobileAppOauth2ClientEntity2.setOauth2ClientId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(mobileAppOauth2ClientEntity, mobileAppOauth2ClientEntity2);
  }

  /**
   * Test {@link MobileAppOauth2ClientEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppOauth2ClientEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MobileAppOauth2ClientEntity.equals(Object)",
    "int MobileAppOauth2ClientEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    MobileAppOauth2ClientEntity mobileAppOauth2ClientEntity = new MobileAppOauth2ClientEntity();
    mobileAppOauth2ClientEntity.setMobileAppId(null);
    mobileAppOauth2ClientEntity.setOauth2ClientId(ModelConstants.NULL_UUID);

    MobileAppOauth2ClientEntity mobileAppOauth2ClientEntity2 = new MobileAppOauth2ClientEntity();
    mobileAppOauth2ClientEntity2.setMobileAppId(ModelConstants.NULL_UUID);
    mobileAppOauth2ClientEntity2.setOauth2ClientId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(mobileAppOauth2ClientEntity, mobileAppOauth2ClientEntity2);
  }

  /**
   * Test {@link MobileAppOauth2ClientEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppOauth2ClientEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MobileAppOauth2ClientEntity.equals(Object)",
    "int MobileAppOauth2ClientEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    MobileAppOauth2ClientEntity mobileAppOauth2ClientEntity = new MobileAppOauth2ClientEntity();
    mobileAppOauth2ClientEntity.setMobileAppId(ModelConstants.NULL_UUID);
    mobileAppOauth2ClientEntity.setOauth2ClientId(UUID.randomUUID());

    MobileAppOauth2ClientEntity mobileAppOauth2ClientEntity2 = new MobileAppOauth2ClientEntity();
    mobileAppOauth2ClientEntity2.setMobileAppId(ModelConstants.NULL_UUID);
    mobileAppOauth2ClientEntity2.setOauth2ClientId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(mobileAppOauth2ClientEntity, mobileAppOauth2ClientEntity2);
  }

  /**
   * Test {@link MobileAppOauth2ClientEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppOauth2ClientEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MobileAppOauth2ClientEntity.equals(Object)",
    "int MobileAppOauth2ClientEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    MobileAppOauth2ClientEntity mobileAppOauth2ClientEntity = new MobileAppOauth2ClientEntity();
    mobileAppOauth2ClientEntity.setMobileAppId(ModelConstants.NULL_UUID);
    mobileAppOauth2ClientEntity.setOauth2ClientId(null);

    MobileAppOauth2ClientEntity mobileAppOauth2ClientEntity2 = new MobileAppOauth2ClientEntity();
    mobileAppOauth2ClientEntity2.setMobileAppId(ModelConstants.NULL_UUID);
    mobileAppOauth2ClientEntity2.setOauth2ClientId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(mobileAppOauth2ClientEntity, mobileAppOauth2ClientEntity2);
  }

  /**
   * Test {@link MobileAppOauth2ClientEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppOauth2ClientEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MobileAppOauth2ClientEntity.equals(Object)",
    "int MobileAppOauth2ClientEntity.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    MobileAppOauth2ClientEntity mobileAppOauth2ClientEntity = new MobileAppOauth2ClientEntity();
    mobileAppOauth2ClientEntity.setMobileAppId(ModelConstants.NULL_UUID);
    mobileAppOauth2ClientEntity.setOauth2ClientId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(mobileAppOauth2ClientEntity, null);
  }

  /**
   * Test {@link MobileAppOauth2ClientEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppOauth2ClientEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MobileAppOauth2ClientEntity.equals(Object)",
    "int MobileAppOauth2ClientEntity.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    MobileAppOauth2ClientEntity mobileAppOauth2ClientEntity = new MobileAppOauth2ClientEntity();
    mobileAppOauth2ClientEntity.setMobileAppId(ModelConstants.NULL_UUID);
    mobileAppOauth2ClientEntity.setOauth2ClientId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(mobileAppOauth2ClientEntity, "Different type to MobileAppOauth2ClientEntity");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MobileAppOauth2ClientEntity#MobileAppOauth2ClientEntity()}
   *   <li>{@link MobileAppOauth2ClientEntity#setMobileAppId(UUID)}
   *   <li>{@link MobileAppOauth2ClientEntity#setOauth2ClientId(UUID)}
   *   <li>{@link MobileAppOauth2ClientEntity#toString()}
   *   <li>{@link MobileAppOauth2ClientEntity#getMobileAppId()}
   *   <li>{@link MobileAppOauth2ClientEntity#getOauth2ClientId()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MobileAppOauth2ClientEntity.<init>()",
    "UUID MobileAppOauth2ClientEntity.getMobileAppId()",
    "UUID MobileAppOauth2ClientEntity.getOauth2ClientId()",
    "void MobileAppOauth2ClientEntity.setMobileAppId(UUID)",
    "void MobileAppOauth2ClientEntity.setOauth2ClientId(UUID)",
    "String MobileAppOauth2ClientEntity.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    MobileAppOauth2ClientEntity actualMobileAppOauth2ClientEntity =
        new MobileAppOauth2ClientEntity();
    actualMobileAppOauth2ClientEntity.setMobileAppId(ModelConstants.NULL_UUID);
    UUID oauth2ClientId = ModelConstants.NULL_UUID;
    actualMobileAppOauth2ClientEntity.setOauth2ClientId(oauth2ClientId);
    String actualToStringResult = actualMobileAppOauth2ClientEntity.toString();
    UUID actualMobileAppId = actualMobileAppOauth2ClientEntity.getMobileAppId();

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualMobileAppId.toString());
    assertEquals(
        "MobileAppOauth2ClientEntity(mobileAppId=13814000-1dd2-11b2-8080-808080808080, oauth2ClientId=13814000"
            + "-1dd2-11b2-8080-808080808080)",
        actualToStringResult);
    assertSame(oauth2ClientId, actualMobileAppId);
    assertSame(oauth2ClientId, actualMobileAppOauth2ClientEntity.getOauth2ClientId());
  }

  /**
   * Test {@link MobileAppOauth2ClientEntity#MobileAppOauth2ClientEntity(MobileAppOauth2Client)}.
   *
   * <p>Method under test: {@link
   * MobileAppOauth2ClientEntity#MobileAppOauth2ClientEntity(MobileAppOauth2Client)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MobileAppOauth2ClientEntity.<init>(MobileAppOauth2Client)"})
  public void testNewMobileAppOauth2ClientEntity() {
    // Arrange
    MobileAppOauth2Client domainOauth2Provider = new MobileAppOauth2Client();
    domainOauth2Provider.setOAuth2ClientId(new OAuth2ClientId(ModelConstants.NULL_UUID));
    domainOauth2Provider.setMobileAppId(new MobileAppId(ModelConstants.NULL_UUID));

    // Act
    MobileAppOauth2ClientEntity actualMobileAppOauth2ClientEntity =
        new MobileAppOauth2ClientEntity(domainOauth2Provider);

    // Assert
    UUID mobileAppId = actualMobileAppOauth2ClientEntity.getMobileAppId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", mobileAppId.toString());
    assertSame(mobileAppId, actualMobileAppOauth2ClientEntity.getOauth2ClientId());
  }

  /**
   * Test {@link MobileAppOauth2ClientEntity#toData()}.
   *
   * <p>Method under test: {@link MobileAppOauth2ClientEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"MobileAppOauth2Client MobileAppOauth2ClientEntity.toData()"})
  public void testToData() {
    // Arrange and Act
    MobileAppOauth2Client actualToDataResult = new MobileAppOauth2ClientEntity().toData();

    // Assert
    MobileAppId mobileAppId = actualToDataResult.getMobileAppId();
    assertNull(mobileAppId.getId());
    OAuth2ClientId oAuth2ClientId = actualToDataResult.getOAuth2ClientId();
    assertNull(oAuth2ClientId.getId());
    assertEquals(EntityType.MOBILE_APP, mobileAppId.getEntityType());
    assertEquals(EntityType.OAUTH2_CLIENT, oAuth2ClientId.getEntityType());
    assertFalse(mobileAppId.isNullUid());
    assertFalse(oAuth2ClientId.isNullUid());
  }
}
