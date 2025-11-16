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

public class AttributeKvCompositeKeyDiffblueTest {
  /**
   * Test {@link AttributeKvCompositeKey#equals(Object)}, and {@link
   * AttributeKvCompositeKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AttributeKvCompositeKey#equals(Object)}
   *   <li>{@link AttributeKvCompositeKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AttributeKvCompositeKey.equals(Object)",
    "int AttributeKvCompositeKey.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AttributeKvCompositeKey attributeKvCompositeKey = new AttributeKvCompositeKey();
    attributeKvCompositeKey.setAttributeKey(1);
    attributeKvCompositeKey.setAttributeType(1);
    attributeKvCompositeKey.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvCompositeKey attributeKvCompositeKey2 = new AttributeKvCompositeKey();
    attributeKvCompositeKey2.setAttributeKey(1);
    attributeKvCompositeKey2.setAttributeType(1);
    attributeKvCompositeKey2.setEntityId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(attributeKvCompositeKey, attributeKvCompositeKey2);
    assertEquals(attributeKvCompositeKey.hashCode(), attributeKvCompositeKey2.hashCode());
  }

  /**
   * Test {@link AttributeKvCompositeKey#equals(Object)}, and {@link
   * AttributeKvCompositeKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AttributeKvCompositeKey#equals(Object)}
   *   <li>{@link AttributeKvCompositeKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AttributeKvCompositeKey.equals(Object)",
    "int AttributeKvCompositeKey.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    AttributeKvCompositeKey attributeKvCompositeKey = new AttributeKvCompositeKey();
    attributeKvCompositeKey.setAttributeKey(1);
    attributeKvCompositeKey.setAttributeType(1);
    attributeKvCompositeKey.setEntityId(null);

    AttributeKvCompositeKey attributeKvCompositeKey2 = new AttributeKvCompositeKey();
    attributeKvCompositeKey2.setAttributeKey(1);
    attributeKvCompositeKey2.setAttributeType(1);
    attributeKvCompositeKey2.setEntityId(null);

    // Act and Assert
    assertEquals(attributeKvCompositeKey, attributeKvCompositeKey2);
    assertEquals(attributeKvCompositeKey.hashCode(), attributeKvCompositeKey2.hashCode());
  }

  /**
   * Test {@link AttributeKvCompositeKey#equals(Object)}, and {@link
   * AttributeKvCompositeKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AttributeKvCompositeKey#equals(Object)}
   *   <li>{@link AttributeKvCompositeKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AttributeKvCompositeKey.equals(Object)",
    "int AttributeKvCompositeKey.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AttributeKvCompositeKey attributeKvCompositeKey = new AttributeKvCompositeKey();
    attributeKvCompositeKey.setAttributeKey(1);
    attributeKvCompositeKey.setAttributeType(1);
    attributeKvCompositeKey.setEntityId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(attributeKvCompositeKey, attributeKvCompositeKey);
    int expectedHashCodeResult = attributeKvCompositeKey.hashCode();
    assertEquals(expectedHashCodeResult, attributeKvCompositeKey.hashCode());
  }

  /**
   * Test {@link AttributeKvCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AttributeKvCompositeKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AttributeKvCompositeKey.equals(Object)",
    "int AttributeKvCompositeKey.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AttributeKvCompositeKey attributeKvCompositeKey = new AttributeKvCompositeKey();
    attributeKvCompositeKey.setAttributeKey(3);
    attributeKvCompositeKey.setAttributeType(1);
    attributeKvCompositeKey.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvCompositeKey attributeKvCompositeKey2 = new AttributeKvCompositeKey();
    attributeKvCompositeKey2.setAttributeKey(1);
    attributeKvCompositeKey2.setAttributeType(1);
    attributeKvCompositeKey2.setEntityId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(attributeKvCompositeKey, attributeKvCompositeKey2);
  }

  /**
   * Test {@link AttributeKvCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AttributeKvCompositeKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AttributeKvCompositeKey.equals(Object)",
    "int AttributeKvCompositeKey.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AttributeKvCompositeKey attributeKvCompositeKey = new AttributeKvCompositeKey();
    attributeKvCompositeKey.setAttributeKey(1);
    attributeKvCompositeKey.setAttributeType(3);
    attributeKvCompositeKey.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvCompositeKey attributeKvCompositeKey2 = new AttributeKvCompositeKey();
    attributeKvCompositeKey2.setAttributeKey(1);
    attributeKvCompositeKey2.setAttributeType(1);
    attributeKvCompositeKey2.setEntityId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(attributeKvCompositeKey, attributeKvCompositeKey2);
  }

  /**
   * Test {@link AttributeKvCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AttributeKvCompositeKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AttributeKvCompositeKey.equals(Object)",
    "int AttributeKvCompositeKey.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AttributeKvCompositeKey attributeKvCompositeKey = new AttributeKvCompositeKey();
    attributeKvCompositeKey.setAttributeKey(1);
    attributeKvCompositeKey.setAttributeType(1);
    attributeKvCompositeKey.setEntityId(UUID.randomUUID());

    AttributeKvCompositeKey attributeKvCompositeKey2 = new AttributeKvCompositeKey();
    attributeKvCompositeKey2.setAttributeKey(1);
    attributeKvCompositeKey2.setAttributeType(1);
    attributeKvCompositeKey2.setEntityId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(attributeKvCompositeKey, attributeKvCompositeKey2);
  }

  /**
   * Test {@link AttributeKvCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AttributeKvCompositeKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AttributeKvCompositeKey.equals(Object)",
    "int AttributeKvCompositeKey.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    AttributeKvCompositeKey attributeKvCompositeKey = new AttributeKvCompositeKey();
    attributeKvCompositeKey.setAttributeKey(1);
    attributeKvCompositeKey.setAttributeType(1);
    attributeKvCompositeKey.setEntityId(null);

    AttributeKvCompositeKey attributeKvCompositeKey2 = new AttributeKvCompositeKey();
    attributeKvCompositeKey2.setAttributeKey(1);
    attributeKvCompositeKey2.setAttributeType(1);
    attributeKvCompositeKey2.setEntityId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(attributeKvCompositeKey, attributeKvCompositeKey2);
  }

  /**
   * Test {@link AttributeKvCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AttributeKvCompositeKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AttributeKvCompositeKey.equals(Object)",
    "int AttributeKvCompositeKey.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    AttributeKvCompositeKey attributeKvCompositeKey = new AttributeKvCompositeKey();
    attributeKvCompositeKey.setAttributeKey(1);
    attributeKvCompositeKey.setAttributeType(1);
    attributeKvCompositeKey.setEntityId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(attributeKvCompositeKey, null);
  }

  /**
   * Test {@link AttributeKvCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AttributeKvCompositeKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AttributeKvCompositeKey.equals(Object)",
    "int AttributeKvCompositeKey.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    AttributeKvCompositeKey attributeKvCompositeKey = new AttributeKvCompositeKey();
    attributeKvCompositeKey.setAttributeKey(1);
    attributeKvCompositeKey.setAttributeType(1);
    attributeKvCompositeKey.setEntityId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(attributeKvCompositeKey, "Different type to AttributeKvCompositeKey");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AttributeKvCompositeKey#AttributeKvCompositeKey()}
   *   <li>{@link AttributeKvCompositeKey#setAttributeKey(int)}
   *   <li>{@link AttributeKvCompositeKey#setAttributeType(int)}
   *   <li>{@link AttributeKvCompositeKey#setEntityId(UUID)}
   *   <li>{@link AttributeKvCompositeKey#toString()}
   *   <li>{@link AttributeKvCompositeKey#getAttributeKey()}
   *   <li>{@link AttributeKvCompositeKey#getAttributeType()}
   *   <li>{@link AttributeKvCompositeKey#getEntityId()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AttributeKvCompositeKey.<init>()",
    "void AttributeKvCompositeKey.<init>(UUID, int, int)",
    "int AttributeKvCompositeKey.getAttributeKey()",
    "int AttributeKvCompositeKey.getAttributeType()",
    "UUID AttributeKvCompositeKey.getEntityId()",
    "void AttributeKvCompositeKey.setAttributeKey(int)",
    "void AttributeKvCompositeKey.setAttributeType(int)",
    "void AttributeKvCompositeKey.setEntityId(UUID)",
    "String AttributeKvCompositeKey.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    AttributeKvCompositeKey actualAttributeKvCompositeKey = new AttributeKvCompositeKey();
    actualAttributeKvCompositeKey.setAttributeKey(1);
    actualAttributeKvCompositeKey.setAttributeType(1);
    UUID entityId = ModelConstants.NULL_UUID;
    actualAttributeKvCompositeKey.setEntityId(entityId);
    String actualToStringResult = actualAttributeKvCompositeKey.toString();
    int actualAttributeKey = actualAttributeKvCompositeKey.getAttributeKey();
    int actualAttributeType = actualAttributeKvCompositeKey.getAttributeType();
    UUID actualEntityId = actualAttributeKvCompositeKey.getEntityId();

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEntityId.toString());
    assertEquals(
        "AttributeKvCompositeKey(entityId=13814000-1dd2-11b2-8080-808080808080, attributeType=1,"
            + " attributeKey=1)",
        actualToStringResult);
    assertEquals(1, actualAttributeKey);
    assertEquals(1, actualAttributeType);
    assertSame(entityId, actualEntityId);
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
   *   <li>{@link AttributeKvCompositeKey#AttributeKvCompositeKey(UUID, int, int)}
   *   <li>{@link AttributeKvCompositeKey#setAttributeKey(int)}
   *   <li>{@link AttributeKvCompositeKey#setAttributeType(int)}
   *   <li>{@link AttributeKvCompositeKey#setEntityId(UUID)}
   *   <li>{@link AttributeKvCompositeKey#toString()}
   *   <li>{@link AttributeKvCompositeKey#getAttributeKey()}
   *   <li>{@link AttributeKvCompositeKey#getAttributeType()}
   *   <li>{@link AttributeKvCompositeKey#getEntityId()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AttributeKvCompositeKey.<init>()",
    "void AttributeKvCompositeKey.<init>(UUID, int, int)",
    "int AttributeKvCompositeKey.getAttributeKey()",
    "int AttributeKvCompositeKey.getAttributeType()",
    "UUID AttributeKvCompositeKey.getEntityId()",
    "void AttributeKvCompositeKey.setAttributeKey(int)",
    "void AttributeKvCompositeKey.setAttributeType(int)",
    "void AttributeKvCompositeKey.setEntityId(UUID)",
    "String AttributeKvCompositeKey.toString()"
  })
  public void testGettersAndSetters_whenNull_uuid() {
    // Arrange and Act
    AttributeKvCompositeKey actualAttributeKvCompositeKey =
        new AttributeKvCompositeKey(ModelConstants.NULL_UUID, 1, 1);
    actualAttributeKvCompositeKey.setAttributeKey(1);
    actualAttributeKvCompositeKey.setAttributeType(1);
    UUID entityId = ModelConstants.NULL_UUID;
    actualAttributeKvCompositeKey.setEntityId(entityId);
    String actualToStringResult = actualAttributeKvCompositeKey.toString();
    int actualAttributeKey = actualAttributeKvCompositeKey.getAttributeKey();
    int actualAttributeType = actualAttributeKvCompositeKey.getAttributeType();
    UUID actualEntityId = actualAttributeKvCompositeKey.getEntityId();

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEntityId.toString());
    assertEquals(
        "AttributeKvCompositeKey(entityId=13814000-1dd2-11b2-8080-808080808080, attributeType=1,"
            + " attributeKey=1)",
        actualToStringResult);
    assertEquals(1, actualAttributeKey);
    assertEquals(1, actualAttributeType);
    assertSame(entityId, actualEntityId);
  }
}
