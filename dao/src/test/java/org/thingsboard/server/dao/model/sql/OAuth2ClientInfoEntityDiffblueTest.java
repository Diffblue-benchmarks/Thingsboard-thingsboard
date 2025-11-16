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
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.id.OAuth2ClientId;
import org.thingsboard.server.common.data.oauth2.OAuth2ClientInfo;
import org.thingsboard.server.dao.model.ModelConstants;

public class OAuth2ClientInfoEntityDiffblueTest {
  /**
   * Test {@link OAuth2ClientInfoEntity#equals(Object)}, and {@link
   * OAuth2ClientInfoEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OAuth2ClientInfoEntity#equals(Object)}
   *   <li>{@link OAuth2ClientInfoEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientInfoEntity.equals(Object)",
    "int OAuth2ClientInfoEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OAuth2ClientInfoEntity oAuth2ClientInfoEntity = new OAuth2ClientInfoEntity();
    oAuth2ClientInfoEntity.setCreatedTime(1L);
    oAuth2ClientInfoEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientInfoEntity.setPlatforms("Platforms");
    oAuth2ClientInfoEntity.setTitle("Dr");
    oAuth2ClientInfoEntity.setUuid(ModelConstants.NULL_UUID);

    OAuth2ClientInfoEntity oAuth2ClientInfoEntity2 = new OAuth2ClientInfoEntity();
    oAuth2ClientInfoEntity2.setCreatedTime(1L);
    oAuth2ClientInfoEntity2.setId(ModelConstants.NULL_UUID);
    oAuth2ClientInfoEntity2.setPlatforms("Platforms");
    oAuth2ClientInfoEntity2.setTitle("Dr");
    oAuth2ClientInfoEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(oAuth2ClientInfoEntity, oAuth2ClientInfoEntity2);
    assertEquals(oAuth2ClientInfoEntity.hashCode(), oAuth2ClientInfoEntity2.hashCode());
  }

  /**
   * Test {@link OAuth2ClientInfoEntity#equals(Object)}, and {@link
   * OAuth2ClientInfoEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OAuth2ClientInfoEntity#equals(Object)}
   *   <li>{@link OAuth2ClientInfoEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientInfoEntity.equals(Object)",
    "int OAuth2ClientInfoEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    OAuth2ClientInfoEntity oAuth2ClientInfoEntity = new OAuth2ClientInfoEntity();
    oAuth2ClientInfoEntity.setCreatedTime(1L);
    oAuth2ClientInfoEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientInfoEntity.setPlatforms(null);
    oAuth2ClientInfoEntity.setTitle("Dr");
    oAuth2ClientInfoEntity.setUuid(ModelConstants.NULL_UUID);

    OAuth2ClientInfoEntity oAuth2ClientInfoEntity2 = new OAuth2ClientInfoEntity();
    oAuth2ClientInfoEntity2.setCreatedTime(1L);
    oAuth2ClientInfoEntity2.setId(ModelConstants.NULL_UUID);
    oAuth2ClientInfoEntity2.setPlatforms(null);
    oAuth2ClientInfoEntity2.setTitle("Dr");
    oAuth2ClientInfoEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(oAuth2ClientInfoEntity, oAuth2ClientInfoEntity2);
    assertEquals(oAuth2ClientInfoEntity.hashCode(), oAuth2ClientInfoEntity2.hashCode());
  }

  /**
   * Test {@link OAuth2ClientInfoEntity#equals(Object)}, and {@link
   * OAuth2ClientInfoEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OAuth2ClientInfoEntity#equals(Object)}
   *   <li>{@link OAuth2ClientInfoEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientInfoEntity.equals(Object)",
    "int OAuth2ClientInfoEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    OAuth2ClientInfoEntity oAuth2ClientInfoEntity = new OAuth2ClientInfoEntity();
    oAuth2ClientInfoEntity.setCreatedTime(1L);
    oAuth2ClientInfoEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientInfoEntity.setPlatforms("Platforms");
    oAuth2ClientInfoEntity.setTitle(null);
    oAuth2ClientInfoEntity.setUuid(ModelConstants.NULL_UUID);

    OAuth2ClientInfoEntity oAuth2ClientInfoEntity2 = new OAuth2ClientInfoEntity();
    oAuth2ClientInfoEntity2.setCreatedTime(1L);
    oAuth2ClientInfoEntity2.setId(ModelConstants.NULL_UUID);
    oAuth2ClientInfoEntity2.setPlatforms("Platforms");
    oAuth2ClientInfoEntity2.setTitle(null);
    oAuth2ClientInfoEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(oAuth2ClientInfoEntity, oAuth2ClientInfoEntity2);
    assertEquals(oAuth2ClientInfoEntity.hashCode(), oAuth2ClientInfoEntity2.hashCode());
  }

  /**
   * Test {@link OAuth2ClientInfoEntity#equals(Object)}, and {@link
   * OAuth2ClientInfoEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OAuth2ClientInfoEntity#equals(Object)}
   *   <li>{@link OAuth2ClientInfoEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientInfoEntity.equals(Object)",
    "int OAuth2ClientInfoEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OAuth2ClientInfoEntity oAuth2ClientInfoEntity = new OAuth2ClientInfoEntity();
    oAuth2ClientInfoEntity.setCreatedTime(1L);
    oAuth2ClientInfoEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientInfoEntity.setPlatforms("Platforms");
    oAuth2ClientInfoEntity.setTitle("Dr");
    oAuth2ClientInfoEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(oAuth2ClientInfoEntity, oAuth2ClientInfoEntity);
    int expectedHashCodeResult = oAuth2ClientInfoEntity.hashCode();
    assertEquals(expectedHashCodeResult, oAuth2ClientInfoEntity.hashCode());
  }

  /**
   * Test {@link OAuth2ClientInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientInfoEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientInfoEntity.equals(Object)",
    "int OAuth2ClientInfoEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    OAuth2ClientInfoEntity oAuth2ClientInfoEntity = new OAuth2ClientInfoEntity();
    oAuth2ClientInfoEntity.setCreatedTime(3L);
    oAuth2ClientInfoEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientInfoEntity.setPlatforms("Platforms");
    oAuth2ClientInfoEntity.setTitle("Dr");
    oAuth2ClientInfoEntity.setUuid(ModelConstants.NULL_UUID);

    OAuth2ClientInfoEntity oAuth2ClientInfoEntity2 = new OAuth2ClientInfoEntity();
    oAuth2ClientInfoEntity2.setCreatedTime(1L);
    oAuth2ClientInfoEntity2.setId(ModelConstants.NULL_UUID);
    oAuth2ClientInfoEntity2.setPlatforms("Platforms");
    oAuth2ClientInfoEntity2.setTitle("Dr");
    oAuth2ClientInfoEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(oAuth2ClientInfoEntity, oAuth2ClientInfoEntity2);
  }

  /**
   * Test {@link OAuth2ClientInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientInfoEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientInfoEntity.equals(Object)",
    "int OAuth2ClientInfoEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    OAuth2ClientInfoEntity oAuth2ClientInfoEntity = new OAuth2ClientInfoEntity();
    oAuth2ClientInfoEntity.setCreatedTime(1L);
    oAuth2ClientInfoEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientInfoEntity.setPlatforms("Dr");
    oAuth2ClientInfoEntity.setTitle("Dr");
    oAuth2ClientInfoEntity.setUuid(ModelConstants.NULL_UUID);

    OAuth2ClientInfoEntity oAuth2ClientInfoEntity2 = new OAuth2ClientInfoEntity();
    oAuth2ClientInfoEntity2.setCreatedTime(1L);
    oAuth2ClientInfoEntity2.setId(ModelConstants.NULL_UUID);
    oAuth2ClientInfoEntity2.setPlatforms("Platforms");
    oAuth2ClientInfoEntity2.setTitle("Dr");
    oAuth2ClientInfoEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(oAuth2ClientInfoEntity, oAuth2ClientInfoEntity2);
  }

  /**
   * Test {@link OAuth2ClientInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientInfoEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientInfoEntity.equals(Object)",
    "int OAuth2ClientInfoEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    OAuth2ClientInfoEntity oAuth2ClientInfoEntity = new OAuth2ClientInfoEntity();
    oAuth2ClientInfoEntity.setCreatedTime(1L);
    oAuth2ClientInfoEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientInfoEntity.setPlatforms(null);
    oAuth2ClientInfoEntity.setTitle("Dr");
    oAuth2ClientInfoEntity.setUuid(ModelConstants.NULL_UUID);

    OAuth2ClientInfoEntity oAuth2ClientInfoEntity2 = new OAuth2ClientInfoEntity();
    oAuth2ClientInfoEntity2.setCreatedTime(1L);
    oAuth2ClientInfoEntity2.setId(ModelConstants.NULL_UUID);
    oAuth2ClientInfoEntity2.setPlatforms("Platforms");
    oAuth2ClientInfoEntity2.setTitle("Dr");
    oAuth2ClientInfoEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(oAuth2ClientInfoEntity, oAuth2ClientInfoEntity2);
  }

  /**
   * Test {@link OAuth2ClientInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientInfoEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientInfoEntity.equals(Object)",
    "int OAuth2ClientInfoEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    OAuth2ClientInfoEntity oAuth2ClientInfoEntity = new OAuth2ClientInfoEntity();
    oAuth2ClientInfoEntity.setCreatedTime(1L);
    oAuth2ClientInfoEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientInfoEntity.setPlatforms("Platforms");
    oAuth2ClientInfoEntity.setTitle("Mr");
    oAuth2ClientInfoEntity.setUuid(ModelConstants.NULL_UUID);

    OAuth2ClientInfoEntity oAuth2ClientInfoEntity2 = new OAuth2ClientInfoEntity();
    oAuth2ClientInfoEntity2.setCreatedTime(1L);
    oAuth2ClientInfoEntity2.setId(ModelConstants.NULL_UUID);
    oAuth2ClientInfoEntity2.setPlatforms("Platforms");
    oAuth2ClientInfoEntity2.setTitle("Dr");
    oAuth2ClientInfoEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(oAuth2ClientInfoEntity, oAuth2ClientInfoEntity2);
  }

  /**
   * Test {@link OAuth2ClientInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientInfoEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientInfoEntity.equals(Object)",
    "int OAuth2ClientInfoEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    OAuth2ClientInfoEntity oAuth2ClientInfoEntity = new OAuth2ClientInfoEntity();
    oAuth2ClientInfoEntity.setCreatedTime(1L);
    oAuth2ClientInfoEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientInfoEntity.setPlatforms("Platforms");
    oAuth2ClientInfoEntity.setTitle(null);
    oAuth2ClientInfoEntity.setUuid(ModelConstants.NULL_UUID);

    OAuth2ClientInfoEntity oAuth2ClientInfoEntity2 = new OAuth2ClientInfoEntity();
    oAuth2ClientInfoEntity2.setCreatedTime(1L);
    oAuth2ClientInfoEntity2.setId(ModelConstants.NULL_UUID);
    oAuth2ClientInfoEntity2.setPlatforms("Platforms");
    oAuth2ClientInfoEntity2.setTitle("Dr");
    oAuth2ClientInfoEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(oAuth2ClientInfoEntity, oAuth2ClientInfoEntity2);
  }

  /**
   * Test {@link OAuth2ClientInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientInfoEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientInfoEntity.equals(Object)",
    "int OAuth2ClientInfoEntity.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    OAuth2ClientInfoEntity oAuth2ClientInfoEntity = new OAuth2ClientInfoEntity();
    oAuth2ClientInfoEntity.setCreatedTime(1L);
    oAuth2ClientInfoEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientInfoEntity.setPlatforms("Platforms");
    oAuth2ClientInfoEntity.setTitle("Dr");
    oAuth2ClientInfoEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(oAuth2ClientInfoEntity, null);
  }

  /**
   * Test {@link OAuth2ClientInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientInfoEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OAuth2ClientInfoEntity.equals(Object)",
    "int OAuth2ClientInfoEntity.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    OAuth2ClientInfoEntity oAuth2ClientInfoEntity = new OAuth2ClientInfoEntity();
    oAuth2ClientInfoEntity.setCreatedTime(1L);
    oAuth2ClientInfoEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientInfoEntity.setPlatforms("Platforms");
    oAuth2ClientInfoEntity.setTitle("Dr");
    oAuth2ClientInfoEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(oAuth2ClientInfoEntity, "Different type to OAuth2ClientInfoEntity");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OAuth2ClientInfoEntity#OAuth2ClientInfoEntity()}
   *   <li>{@link OAuth2ClientInfoEntity#setPlatforms(String)}
   *   <li>{@link OAuth2ClientInfoEntity#setTitle(String)}
   *   <li>{@link OAuth2ClientInfoEntity#toString()}
   *   <li>{@link OAuth2ClientInfoEntity#getPlatforms()}
   *   <li>{@link OAuth2ClientInfoEntity#getTitle()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OAuth2ClientInfoEntity.<init>()",
    "String OAuth2ClientInfoEntity.getPlatforms()",
    "String OAuth2ClientInfoEntity.getTitle()",
    "void OAuth2ClientInfoEntity.setPlatforms(String)",
    "void OAuth2ClientInfoEntity.setTitle(String)",
    "String OAuth2ClientInfoEntity.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    OAuth2ClientInfoEntity actualOAuth2ClientInfoEntity = new OAuth2ClientInfoEntity();
    actualOAuth2ClientInfoEntity.setPlatforms("Platforms");
    actualOAuth2ClientInfoEntity.setTitle("Dr");
    String actualToStringResult = actualOAuth2ClientInfoEntity.toString();
    String actualPlatforms = actualOAuth2ClientInfoEntity.getPlatforms();

    // Assert
    assertEquals("Dr", actualOAuth2ClientInfoEntity.getTitle());
    assertEquals("OAuth2ClientInfoEntity(platforms=Platforms, title=Dr)", actualToStringResult);
    assertEquals("Platforms", actualPlatforms);
    assertNull(actualOAuth2ClientInfoEntity.getId());
    assertNull(actualOAuth2ClientInfoEntity.getUuid());
    assertEquals(0L, actualOAuth2ClientInfoEntity.getCreatedTime());
  }

  /**
   * Test {@link OAuth2ClientInfoEntity#OAuth2ClientInfoEntity(UUID, long, String, String)}.
   *
   * <p>Method under test: {@link OAuth2ClientInfoEntity#OAuth2ClientInfoEntity(UUID, long, String,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OAuth2ClientInfoEntity.<init>(UUID, long, String, String)"})
  public void testNewOAuth2ClientInfoEntity() {
    // Arrange
    UUID id = ModelConstants.NULL_UUID;

    // Act
    OAuth2ClientInfoEntity actualOAuth2ClientInfoEntity =
        new OAuth2ClientInfoEntity(id, 1L, "Platforms", "Dr");

    // Assert
    assertEquals("Dr", actualOAuth2ClientInfoEntity.getTitle());
    assertEquals("Platforms", actualOAuth2ClientInfoEntity.getPlatforms());
    assertEquals(1L, actualOAuth2ClientInfoEntity.getCreatedTime());
    assertSame(id, actualOAuth2ClientInfoEntity.getId());
    assertSame(id, actualOAuth2ClientInfoEntity.getUuid());
  }

  /**
   * Test {@link OAuth2ClientInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link OAuth2ClientInfoEntity#OAuth2ClientInfoEntity()} Platforms is {@code ,}.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientInfoEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OAuth2ClientInfo OAuth2ClientInfoEntity.toData()"})
  public void testToData_givenOAuth2ClientInfoEntityPlatformsIsComma() {
    // Arrange
    OAuth2ClientInfoEntity oAuth2ClientInfoEntity = new OAuth2ClientInfoEntity();
    oAuth2ClientInfoEntity.setCreatedTime(1L);
    oAuth2ClientInfoEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientInfoEntity.setTitle("Dr");
    oAuth2ClientInfoEntity.setUuid(ModelConstants.NULL_UUID);
    oAuth2ClientInfoEntity.setPlatforms(",");

    // Act
    OAuth2ClientInfo actualToDataResult = oAuth2ClientInfoEntity.toData();

    // Assert
    UUID uuidId = actualToDataResult.getUuidId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", uuidId.toString());
    assertEquals("Dr", actualToDataResult.getName());
    assertEquals("Dr", actualToDataResult.getTitle());
    assertEquals(1L, actualToDataResult.getCreatedTime());
    OAuth2ClientId id = actualToDataResult.getId();
    assertTrue(id.isNullUid());
    assertSame(uuidId, id.getId());
  }

  /**
   * Test {@link OAuth2ClientInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link OAuth2ClientInfoEntity#OAuth2ClientInfoEntity()} Platforms is empty string.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientInfoEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OAuth2ClientInfo OAuth2ClientInfoEntity.toData()"})
  public void testToData_givenOAuth2ClientInfoEntityPlatformsIsEmptyString() {
    // Arrange
    OAuth2ClientInfoEntity oAuth2ClientInfoEntity = new OAuth2ClientInfoEntity();
    oAuth2ClientInfoEntity.setCreatedTime(1L);
    oAuth2ClientInfoEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientInfoEntity.setTitle("Dr");
    oAuth2ClientInfoEntity.setUuid(ModelConstants.NULL_UUID);
    oAuth2ClientInfoEntity.setPlatforms("");

    // Act
    OAuth2ClientInfo actualToDataResult = oAuth2ClientInfoEntity.toData();

    // Assert
    UUID uuidId = actualToDataResult.getUuidId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", uuidId.toString());
    assertEquals("Dr", actualToDataResult.getName());
    assertEquals("Dr", actualToDataResult.getTitle());
    assertEquals(1L, actualToDataResult.getCreatedTime());
    OAuth2ClientId id = actualToDataResult.getId();
    assertTrue(id.isNullUid());
    assertSame(uuidId, id.getId());
  }

  /**
   * Test {@link OAuth2ClientInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link OAuth2ClientInfoEntity#OAuth2ClientInfoEntity()}.
   *   <li>Then return Name is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientInfoEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OAuth2ClientInfo OAuth2ClientInfoEntity.toData()"})
  public void testToData_givenOAuth2ClientInfoEntity_thenReturnNameIsNull() {
    // Arrange and Act
    OAuth2ClientInfo actualToDataResult = new OAuth2ClientInfoEntity().toData();

    // Assert
    assertNull(actualToDataResult.getName());
    assertNull(actualToDataResult.getTitle());
    assertNull(actualToDataResult.getUuidId());
    OAuth2ClientId id = actualToDataResult.getId();
    assertNull(id.getId());
    assertEquals(0L, actualToDataResult.getCreatedTime());
    assertFalse(id.isNullUid());
  }
}
