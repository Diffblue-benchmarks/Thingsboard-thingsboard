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
import org.thingsboard.server.common.data.domain.DomainOauth2Client;
import org.thingsboard.server.common.data.id.DomainId;
import org.thingsboard.server.common.data.id.OAuth2ClientId;
import org.thingsboard.server.dao.model.ModelConstants;

public class DomainOauth2ClientEntityDiffblueTest {
  /**
   * Test {@link DomainOauth2ClientEntity#equals(Object)}, and {@link
   * DomainOauth2ClientEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DomainOauth2ClientEntity#equals(Object)}
   *   <li>{@link DomainOauth2ClientEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DomainOauth2ClientEntity.equals(Object)",
    "int DomainOauth2ClientEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DomainOauth2ClientEntity domainOauth2ClientEntity = new DomainOauth2ClientEntity();
    domainOauth2ClientEntity.setDomainId(ModelConstants.NULL_UUID);
    domainOauth2ClientEntity.setOauth2ClientId(ModelConstants.NULL_UUID);

    DomainOauth2ClientEntity domainOauth2ClientEntity2 = new DomainOauth2ClientEntity();
    domainOauth2ClientEntity2.setDomainId(ModelConstants.NULL_UUID);
    domainOauth2ClientEntity2.setOauth2ClientId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(domainOauth2ClientEntity, domainOauth2ClientEntity2);
    assertEquals(domainOauth2ClientEntity.hashCode(), domainOauth2ClientEntity2.hashCode());
  }

  /**
   * Test {@link DomainOauth2ClientEntity#equals(Object)}, and {@link
   * DomainOauth2ClientEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DomainOauth2ClientEntity#equals(Object)}
   *   <li>{@link DomainOauth2ClientEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DomainOauth2ClientEntity.equals(Object)",
    "int DomainOauth2ClientEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    DomainOauth2ClientEntity domainOauth2ClientEntity = new DomainOauth2ClientEntity();
    domainOauth2ClientEntity.setDomainId(null);
    domainOauth2ClientEntity.setOauth2ClientId(ModelConstants.NULL_UUID);

    DomainOauth2ClientEntity domainOauth2ClientEntity2 = new DomainOauth2ClientEntity();
    domainOauth2ClientEntity2.setDomainId(null);
    domainOauth2ClientEntity2.setOauth2ClientId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(domainOauth2ClientEntity, domainOauth2ClientEntity2);
    assertEquals(domainOauth2ClientEntity.hashCode(), domainOauth2ClientEntity2.hashCode());
  }

  /**
   * Test {@link DomainOauth2ClientEntity#equals(Object)}, and {@link
   * DomainOauth2ClientEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DomainOauth2ClientEntity#equals(Object)}
   *   <li>{@link DomainOauth2ClientEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DomainOauth2ClientEntity.equals(Object)",
    "int DomainOauth2ClientEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    DomainOauth2ClientEntity domainOauth2ClientEntity = new DomainOauth2ClientEntity();
    domainOauth2ClientEntity.setDomainId(ModelConstants.NULL_UUID);
    domainOauth2ClientEntity.setOauth2ClientId(null);

    DomainOauth2ClientEntity domainOauth2ClientEntity2 = new DomainOauth2ClientEntity();
    domainOauth2ClientEntity2.setDomainId(ModelConstants.NULL_UUID);
    domainOauth2ClientEntity2.setOauth2ClientId(null);

    // Act and Assert
    assertEquals(domainOauth2ClientEntity, domainOauth2ClientEntity2);
    assertEquals(domainOauth2ClientEntity.hashCode(), domainOauth2ClientEntity2.hashCode());
  }

  /**
   * Test {@link DomainOauth2ClientEntity#equals(Object)}, and {@link
   * DomainOauth2ClientEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DomainOauth2ClientEntity#equals(Object)}
   *   <li>{@link DomainOauth2ClientEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DomainOauth2ClientEntity.equals(Object)",
    "int DomainOauth2ClientEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DomainOauth2ClientEntity domainOauth2ClientEntity = new DomainOauth2ClientEntity();
    domainOauth2ClientEntity.setDomainId(ModelConstants.NULL_UUID);
    domainOauth2ClientEntity.setOauth2ClientId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(domainOauth2ClientEntity, domainOauth2ClientEntity);
    int expectedHashCodeResult = domainOauth2ClientEntity.hashCode();
    assertEquals(expectedHashCodeResult, domainOauth2ClientEntity.hashCode());
  }

  /**
   * Test {@link DomainOauth2ClientEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DomainOauth2ClientEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DomainOauth2ClientEntity.equals(Object)",
    "int DomainOauth2ClientEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DomainOauth2ClientEntity domainOauth2ClientEntity = new DomainOauth2ClientEntity();
    domainOauth2ClientEntity.setDomainId(UUID.randomUUID());
    domainOauth2ClientEntity.setOauth2ClientId(ModelConstants.NULL_UUID);

    DomainOauth2ClientEntity domainOauth2ClientEntity2 = new DomainOauth2ClientEntity();
    domainOauth2ClientEntity2.setDomainId(ModelConstants.NULL_UUID);
    domainOauth2ClientEntity2.setOauth2ClientId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(domainOauth2ClientEntity, domainOauth2ClientEntity2);
  }

  /**
   * Test {@link DomainOauth2ClientEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DomainOauth2ClientEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DomainOauth2ClientEntity.equals(Object)",
    "int DomainOauth2ClientEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DomainOauth2ClientEntity domainOauth2ClientEntity = new DomainOauth2ClientEntity();
    domainOauth2ClientEntity.setDomainId(null);
    domainOauth2ClientEntity.setOauth2ClientId(ModelConstants.NULL_UUID);

    DomainOauth2ClientEntity domainOauth2ClientEntity2 = new DomainOauth2ClientEntity();
    domainOauth2ClientEntity2.setDomainId(ModelConstants.NULL_UUID);
    domainOauth2ClientEntity2.setOauth2ClientId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(domainOauth2ClientEntity, domainOauth2ClientEntity2);
  }

  /**
   * Test {@link DomainOauth2ClientEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DomainOauth2ClientEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DomainOauth2ClientEntity.equals(Object)",
    "int DomainOauth2ClientEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DomainOauth2ClientEntity domainOauth2ClientEntity = new DomainOauth2ClientEntity();
    domainOauth2ClientEntity.setDomainId(ModelConstants.NULL_UUID);
    domainOauth2ClientEntity.setOauth2ClientId(UUID.randomUUID());

    DomainOauth2ClientEntity domainOauth2ClientEntity2 = new DomainOauth2ClientEntity();
    domainOauth2ClientEntity2.setDomainId(ModelConstants.NULL_UUID);
    domainOauth2ClientEntity2.setOauth2ClientId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(domainOauth2ClientEntity, domainOauth2ClientEntity2);
  }

  /**
   * Test {@link DomainOauth2ClientEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DomainOauth2ClientEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DomainOauth2ClientEntity.equals(Object)",
    "int DomainOauth2ClientEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DomainOauth2ClientEntity domainOauth2ClientEntity = new DomainOauth2ClientEntity();
    domainOauth2ClientEntity.setDomainId(ModelConstants.NULL_UUID);
    domainOauth2ClientEntity.setOauth2ClientId(null);

    DomainOauth2ClientEntity domainOauth2ClientEntity2 = new DomainOauth2ClientEntity();
    domainOauth2ClientEntity2.setDomainId(ModelConstants.NULL_UUID);
    domainOauth2ClientEntity2.setOauth2ClientId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(domainOauth2ClientEntity, domainOauth2ClientEntity2);
  }

  /**
   * Test {@link DomainOauth2ClientEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DomainOauth2ClientEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DomainOauth2ClientEntity.equals(Object)",
    "int DomainOauth2ClientEntity.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    DomainOauth2ClientEntity domainOauth2ClientEntity = new DomainOauth2ClientEntity();
    domainOauth2ClientEntity.setDomainId(ModelConstants.NULL_UUID);
    domainOauth2ClientEntity.setOauth2ClientId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(domainOauth2ClientEntity, null);
  }

  /**
   * Test {@link DomainOauth2ClientEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DomainOauth2ClientEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DomainOauth2ClientEntity.equals(Object)",
    "int DomainOauth2ClientEntity.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    DomainOauth2ClientEntity domainOauth2ClientEntity = new DomainOauth2ClientEntity();
    domainOauth2ClientEntity.setDomainId(ModelConstants.NULL_UUID);
    domainOauth2ClientEntity.setOauth2ClientId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(domainOauth2ClientEntity, "Different type to DomainOauth2ClientEntity");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DomainOauth2ClientEntity#DomainOauth2ClientEntity()}
   *   <li>{@link DomainOauth2ClientEntity#setDomainId(UUID)}
   *   <li>{@link DomainOauth2ClientEntity#setOauth2ClientId(UUID)}
   *   <li>{@link DomainOauth2ClientEntity#toString()}
   *   <li>{@link DomainOauth2ClientEntity#getDomainId()}
   *   <li>{@link DomainOauth2ClientEntity#getOauth2ClientId()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DomainOauth2ClientEntity.<init>()",
    "UUID DomainOauth2ClientEntity.getDomainId()",
    "UUID DomainOauth2ClientEntity.getOauth2ClientId()",
    "void DomainOauth2ClientEntity.setDomainId(UUID)",
    "void DomainOauth2ClientEntity.setOauth2ClientId(UUID)",
    "String DomainOauth2ClientEntity.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    DomainOauth2ClientEntity actualDomainOauth2ClientEntity = new DomainOauth2ClientEntity();
    actualDomainOauth2ClientEntity.setDomainId(ModelConstants.NULL_UUID);
    UUID oauth2ClientId = ModelConstants.NULL_UUID;
    actualDomainOauth2ClientEntity.setOauth2ClientId(oauth2ClientId);
    String actualToStringResult = actualDomainOauth2ClientEntity.toString();
    UUID actualDomainId = actualDomainOauth2ClientEntity.getDomainId();

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualDomainId.toString());
    assertEquals(
        "DomainOauth2ClientEntity(domainId=13814000-1dd2-11b2-8080-808080808080, oauth2ClientId=13814000-1dd2"
            + "-11b2-8080-808080808080)",
        actualToStringResult);
    assertSame(oauth2ClientId, actualDomainId);
    assertSame(oauth2ClientId, actualDomainOauth2ClientEntity.getOauth2ClientId());
  }

  /**
   * Test {@link DomainOauth2ClientEntity#DomainOauth2ClientEntity(DomainOauth2Client)}.
   *
   * <p>Method under test: {@link
   * DomainOauth2ClientEntity#DomainOauth2ClientEntity(DomainOauth2Client)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DomainOauth2ClientEntity.<init>(DomainOauth2Client)"})
  public void testNewDomainOauth2ClientEntity() {
    // Arrange
    DomainOauth2Client domainOauth2Client = new DomainOauth2Client();
    domainOauth2Client.setOAuth2ClientId(new OAuth2ClientId(ModelConstants.NULL_UUID));
    domainOauth2Client.setDomainId(new DomainId(ModelConstants.NULL_UUID));

    // Act
    DomainOauth2ClientEntity actualDomainOauth2ClientEntity =
        new DomainOauth2ClientEntity(domainOauth2Client);

    // Assert
    UUID domainId = actualDomainOauth2ClientEntity.getDomainId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", domainId.toString());
    assertSame(domainId, actualDomainOauth2ClientEntity.getOauth2ClientId());
  }

  /**
   * Test {@link DomainOauth2ClientEntity#toData()}.
   *
   * <p>Method under test: {@link DomainOauth2ClientEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DomainOauth2Client DomainOauth2ClientEntity.toData()"})
  public void testToData() {
    // Arrange and Act
    DomainOauth2Client actualToDataResult = new DomainOauth2ClientEntity().toData();

    // Assert
    DomainId domainId = actualToDataResult.getDomainId();
    assertNull(domainId.getId());
    OAuth2ClientId oAuth2ClientId = actualToDataResult.getOAuth2ClientId();
    assertNull(oAuth2ClientId.getId());
    assertEquals(EntityType.DOMAIN, domainId.getEntityType());
    assertEquals(EntityType.OAUTH2_CLIENT, oAuth2ClientId.getEntityType());
    assertFalse(domainId.isNullUid());
    assertFalse(oAuth2ClientId.isNullUid());
  }
}
