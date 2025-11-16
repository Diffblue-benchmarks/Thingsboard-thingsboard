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
import org.thingsboard.server.common.data.relation.EntityRelation;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;

public class RelationCompositeKeyDiffblueTest {
  /**
   * Test {@link RelationCompositeKey#equals(Object)}, and {@link RelationCompositeKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RelationCompositeKey#equals(Object)}
   *   <li>{@link RelationCompositeKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RelationCompositeKey.equals(Object)",
    "int RelationCompositeKey.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RelationCompositeKey relationCompositeKey = new RelationCompositeKey();
    RelationCompositeKey relationCompositeKey2 = new RelationCompositeKey();

    // Act and Assert
    assertEquals(relationCompositeKey, relationCompositeKey2);
    assertEquals(relationCompositeKey.hashCode(), relationCompositeKey2.hashCode());
  }

  /**
   * Test {@link RelationCompositeKey#equals(Object)}, and {@link RelationCompositeKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RelationCompositeKey#equals(Object)}
   *   <li>{@link RelationCompositeKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RelationCompositeKey.equals(Object)",
    "int RelationCompositeKey.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    RelationCompositeKey relationCompositeKey =
        new RelationCompositeKey(
            ModelConstants.NULL_UUID,
            "jane.doe@example.org",
            ModelConstants.NULL_UUID,
            "To Type",
            "Relation Type",
            "Relation Type Group");
    RelationCompositeKey relationCompositeKey2 =
        new RelationCompositeKey(
            ModelConstants.NULL_UUID,
            "jane.doe@example.org",
            ModelConstants.NULL_UUID,
            "To Type",
            "Relation Type",
            "Relation Type Group");

    // Act and Assert
    assertEquals(relationCompositeKey, relationCompositeKey2);
    assertEquals(relationCompositeKey.hashCode(), relationCompositeKey2.hashCode());
  }

  /**
   * Test {@link RelationCompositeKey#equals(Object)}, and {@link RelationCompositeKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RelationCompositeKey#equals(Object)}
   *   <li>{@link RelationCompositeKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RelationCompositeKey.equals(Object)",
    "int RelationCompositeKey.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RelationCompositeKey relationCompositeKey = new RelationCompositeKey();

    // Act and Assert
    assertEquals(relationCompositeKey, relationCompositeKey);
    int expectedHashCodeResult = relationCompositeKey.hashCode();
    assertEquals(expectedHashCodeResult, relationCompositeKey.hashCode());
  }

  /**
   * Test {@link RelationCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelationCompositeKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RelationCompositeKey.equals(Object)",
    "int RelationCompositeKey.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RelationCompositeKey relationCompositeKey =
        new RelationCompositeKey(
            ModelConstants.NULL_UUID,
            "jane.doe@example.org",
            ModelConstants.NULL_UUID,
            "To Type",
            "Relation Type",
            "Relation Type Group");

    // Act and Assert
    assertNotEquals(relationCompositeKey, new RelationCompositeKey());
  }

  /**
   * Test {@link RelationCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelationCompositeKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RelationCompositeKey.equals(Object)",
    "int RelationCompositeKey.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RelationCompositeKey relationCompositeKey = new RelationCompositeKey();

    // Act and Assert
    assertNotEquals(
        relationCompositeKey,
        new RelationCompositeKey(
            ModelConstants.NULL_UUID,
            "jane.doe@example.org",
            ModelConstants.NULL_UUID,
            "To Type",
            "Relation Type",
            "Relation Type Group"));
  }

  /**
   * Test {@link RelationCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelationCompositeKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RelationCompositeKey.equals(Object)",
    "int RelationCompositeKey.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RelationCompositeKey relationCompositeKey = new RelationCompositeKey();
    relationCompositeKey.setFromType("jane.doe@example.org");

    // Act and Assert
    assertNotEquals(relationCompositeKey, new RelationCompositeKey());
  }

  /**
   * Test {@link RelationCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelationCompositeKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RelationCompositeKey.equals(Object)",
    "int RelationCompositeKey.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    RelationCompositeKey relationCompositeKey = new RelationCompositeKey();
    relationCompositeKey.setToId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(relationCompositeKey, new RelationCompositeKey());
  }

  /**
   * Test {@link RelationCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelationCompositeKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RelationCompositeKey.equals(Object)",
    "int RelationCompositeKey.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    RelationCompositeKey relationCompositeKey = new RelationCompositeKey();
    relationCompositeKey.setToType("To Type");

    // Act and Assert
    assertNotEquals(relationCompositeKey, new RelationCompositeKey());
  }

  /**
   * Test {@link RelationCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelationCompositeKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RelationCompositeKey.equals(Object)",
    "int RelationCompositeKey.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    RelationCompositeKey relationCompositeKey = new RelationCompositeKey();
    relationCompositeKey.setRelationType("Relation Type");

    // Act and Assert
    assertNotEquals(relationCompositeKey, new RelationCompositeKey());
  }

  /**
   * Test {@link RelationCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelationCompositeKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RelationCompositeKey.equals(Object)",
    "int RelationCompositeKey.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    RelationCompositeKey relationCompositeKey = new RelationCompositeKey();
    relationCompositeKey.setRelationTypeGroup("Relation Type Group");

    // Act and Assert
    assertNotEquals(relationCompositeKey, new RelationCompositeKey());
  }

  /**
   * Test {@link RelationCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelationCompositeKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RelationCompositeKey.equals(Object)",
    "int RelationCompositeKey.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    RelationCompositeKey relationCompositeKey = new RelationCompositeKey();

    RelationCompositeKey relationCompositeKey2 = new RelationCompositeKey();
    relationCompositeKey2.setFromType("jane.doe@example.org");

    // Act and Assert
    assertNotEquals(relationCompositeKey, relationCompositeKey2);
  }

  /**
   * Test {@link RelationCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelationCompositeKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RelationCompositeKey.equals(Object)",
    "int RelationCompositeKey.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    RelationCompositeKey relationCompositeKey = new RelationCompositeKey();

    RelationCompositeKey relationCompositeKey2 = new RelationCompositeKey();
    relationCompositeKey2.setToId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(relationCompositeKey, relationCompositeKey2);
  }

  /**
   * Test {@link RelationCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelationCompositeKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RelationCompositeKey.equals(Object)",
    "int RelationCompositeKey.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    RelationCompositeKey relationCompositeKey = new RelationCompositeKey();

    RelationCompositeKey relationCompositeKey2 = new RelationCompositeKey();
    relationCompositeKey2.setToType("To Type");

    // Act and Assert
    assertNotEquals(relationCompositeKey, relationCompositeKey2);
  }

  /**
   * Test {@link RelationCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelationCompositeKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RelationCompositeKey.equals(Object)",
    "int RelationCompositeKey.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    RelationCompositeKey relationCompositeKey = new RelationCompositeKey();

    RelationCompositeKey relationCompositeKey2 = new RelationCompositeKey();
    relationCompositeKey2.setRelationType("Relation Type");

    // Act and Assert
    assertNotEquals(relationCompositeKey, relationCompositeKey2);
  }

  /**
   * Test {@link RelationCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelationCompositeKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RelationCompositeKey.equals(Object)",
    "int RelationCompositeKey.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    RelationCompositeKey relationCompositeKey = new RelationCompositeKey();

    RelationCompositeKey relationCompositeKey2 = new RelationCompositeKey();
    relationCompositeKey2.setRelationTypeGroup("Relation Type Group");

    // Act and Assert
    assertNotEquals(relationCompositeKey, relationCompositeKey2);
  }

  /**
   * Test {@link RelationCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelationCompositeKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RelationCompositeKey.equals(Object)",
    "int RelationCompositeKey.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RelationCompositeKey(), null);
  }

  /**
   * Test {@link RelationCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelationCompositeKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RelationCompositeKey.equals(Object)",
    "int RelationCompositeKey.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RelationCompositeKey(), "Different type to RelationCompositeKey");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RelationCompositeKey#RelationCompositeKey()}
   *   <li>{@link RelationCompositeKey#setFromId(UUID)}
   *   <li>{@link RelationCompositeKey#setFromType(String)}
   *   <li>{@link RelationCompositeKey#setRelationType(String)}
   *   <li>{@link RelationCompositeKey#setRelationTypeGroup(String)}
   *   <li>{@link RelationCompositeKey#setToId(UUID)}
   *   <li>{@link RelationCompositeKey#setToType(String)}
   *   <li>{@link RelationCompositeKey#toString()}
   *   <li>{@link RelationCompositeKey#getFromId()}
   *   <li>{@link RelationCompositeKey#getFromType()}
   *   <li>{@link RelationCompositeKey#getRelationType()}
   *   <li>{@link RelationCompositeKey#getRelationTypeGroup()}
   *   <li>{@link RelationCompositeKey#getToId()}
   *   <li>{@link RelationCompositeKey#getToType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RelationCompositeKey.<init>()",
    "void RelationCompositeKey.<init>(UUID, String, UUID, String, String, String)",
    "UUID RelationCompositeKey.getFromId()",
    "String RelationCompositeKey.getFromType()",
    "String RelationCompositeKey.getRelationType()",
    "String RelationCompositeKey.getRelationTypeGroup()",
    "UUID RelationCompositeKey.getToId()",
    "String RelationCompositeKey.getToType()",
    "void RelationCompositeKey.setFromId(UUID)",
    "void RelationCompositeKey.setFromType(String)",
    "void RelationCompositeKey.setRelationType(String)",
    "void RelationCompositeKey.setRelationTypeGroup(String)",
    "void RelationCompositeKey.setToId(UUID)",
    "void RelationCompositeKey.setToType(String)",
    "String RelationCompositeKey.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    RelationCompositeKey actualRelationCompositeKey = new RelationCompositeKey();
    actualRelationCompositeKey.setFromId(ModelConstants.NULL_UUID);
    actualRelationCompositeKey.setFromType("jane.doe@example.org");
    actualRelationCompositeKey.setRelationType("Relation Type");
    actualRelationCompositeKey.setRelationTypeGroup("Relation Type Group");
    UUID toId = ModelConstants.NULL_UUID;
    actualRelationCompositeKey.setToId(toId);
    actualRelationCompositeKey.setToType("To Type");
    String actualToStringResult = actualRelationCompositeKey.toString();
    UUID actualFromId = actualRelationCompositeKey.getFromId();
    String actualFromType = actualRelationCompositeKey.getFromType();
    String actualRelationType = actualRelationCompositeKey.getRelationType();
    String actualRelationTypeGroup = actualRelationCompositeKey.getRelationTypeGroup();
    UUID actualToId = actualRelationCompositeKey.getToId();

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualFromId.toString());
    assertEquals("Relation Type Group", actualRelationTypeGroup);
    assertEquals("Relation Type", actualRelationType);
    assertEquals(
        "RelationCompositeKey(fromId=13814000-1dd2-11b2-8080-808080808080, fromType=jane.doe@example.org,"
            + " toId=13814000-1dd2-11b2-8080-808080808080, toType=To Type, relationType=Relation Type, relationTypeGroup"
            + "=Relation Type Group)",
        actualToStringResult);
    assertEquals("To Type", actualRelationCompositeKey.getToType());
    assertEquals("jane.doe@example.org", actualFromType);
    assertSame(toId, actualFromId);
    assertSame(toId, actualToId);
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
   *   <li>{@link RelationCompositeKey#RelationCompositeKey(UUID, String, UUID, String, String,
   *       String)}
   *   <li>{@link RelationCompositeKey#setFromId(UUID)}
   *   <li>{@link RelationCompositeKey#setFromType(String)}
   *   <li>{@link RelationCompositeKey#setRelationType(String)}
   *   <li>{@link RelationCompositeKey#setRelationTypeGroup(String)}
   *   <li>{@link RelationCompositeKey#setToId(UUID)}
   *   <li>{@link RelationCompositeKey#setToType(String)}
   *   <li>{@link RelationCompositeKey#toString()}
   *   <li>{@link RelationCompositeKey#getFromId()}
   *   <li>{@link RelationCompositeKey#getFromType()}
   *   <li>{@link RelationCompositeKey#getRelationType()}
   *   <li>{@link RelationCompositeKey#getRelationTypeGroup()}
   *   <li>{@link RelationCompositeKey#getToId()}
   *   <li>{@link RelationCompositeKey#getToType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RelationCompositeKey.<init>()",
    "void RelationCompositeKey.<init>(UUID, String, UUID, String, String, String)",
    "UUID RelationCompositeKey.getFromId()",
    "String RelationCompositeKey.getFromType()",
    "String RelationCompositeKey.getRelationType()",
    "String RelationCompositeKey.getRelationTypeGroup()",
    "UUID RelationCompositeKey.getToId()",
    "String RelationCompositeKey.getToType()",
    "void RelationCompositeKey.setFromId(UUID)",
    "void RelationCompositeKey.setFromType(String)",
    "void RelationCompositeKey.setRelationType(String)",
    "void RelationCompositeKey.setRelationTypeGroup(String)",
    "void RelationCompositeKey.setToId(UUID)",
    "void RelationCompositeKey.setToType(String)",
    "String RelationCompositeKey.toString()"
  })
  public void testGettersAndSetters_whenNull_uuid() {
    // Arrange and Act
    RelationCompositeKey actualRelationCompositeKey =
        new RelationCompositeKey(
            ModelConstants.NULL_UUID,
            "jane.doe@example.org",
            ModelConstants.NULL_UUID,
            "To Type",
            "Relation Type",
            "Relation Type Group");
    actualRelationCompositeKey.setFromId(ModelConstants.NULL_UUID);
    actualRelationCompositeKey.setFromType("jane.doe@example.org");
    actualRelationCompositeKey.setRelationType("Relation Type");
    actualRelationCompositeKey.setRelationTypeGroup("Relation Type Group");
    UUID toId = ModelConstants.NULL_UUID;
    actualRelationCompositeKey.setToId(toId);
    actualRelationCompositeKey.setToType("To Type");
    String actualToStringResult = actualRelationCompositeKey.toString();
    UUID actualFromId = actualRelationCompositeKey.getFromId();
    String actualFromType = actualRelationCompositeKey.getFromType();
    String actualRelationType = actualRelationCompositeKey.getRelationType();
    String actualRelationTypeGroup = actualRelationCompositeKey.getRelationTypeGroup();
    UUID actualToId = actualRelationCompositeKey.getToId();

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualFromId.toString());
    assertEquals("Relation Type Group", actualRelationTypeGroup);
    assertEquals("Relation Type", actualRelationType);
    assertEquals(
        "RelationCompositeKey(fromId=13814000-1dd2-11b2-8080-808080808080, fromType=jane.doe@example.org,"
            + " toId=13814000-1dd2-11b2-8080-808080808080, toType=To Type, relationType=Relation Type, relationTypeGroup"
            + "=Relation Type Group)",
        actualToStringResult);
    assertEquals("To Type", actualRelationCompositeKey.getToType());
    assertEquals("jane.doe@example.org", actualFromType);
    assertSame(toId, actualFromId);
    assertSame(toId, actualToId);
  }

  /**
   * Test {@link RelationCompositeKey#RelationCompositeKey(EntityRelation)}.
   *
   * <p>Method under test: {@link RelationCompositeKey#RelationCompositeKey(EntityRelation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RelationCompositeKey.<init>(EntityRelation)"})
  public void testNewRelationCompositeKey() {
    // Arrange
    EntityRelation relation =
        new EntityRelation(
            BaseEntityService.NULL_CUSTOMER_ID, BaseEntityService.NULL_CUSTOMER_ID, "Type");
    relation.setFrom(ModelConstants.SYSTEM_TENANT);

    // Act
    RelationCompositeKey actualRelationCompositeKey = new RelationCompositeKey(relation);

    // Assert
    UUID fromId = actualRelationCompositeKey.getFromId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", fromId.toString());
    assertEquals("COMMON", actualRelationCompositeKey.getRelationTypeGroup());
    assertEquals("CUSTOMER", actualRelationCompositeKey.getToType());
    assertEquals("TENANT", actualRelationCompositeKey.getFromType());
    assertEquals("Type", actualRelationCompositeKey.getRelationType());
    assertSame(fromId, actualRelationCompositeKey.getToId());
  }
}
