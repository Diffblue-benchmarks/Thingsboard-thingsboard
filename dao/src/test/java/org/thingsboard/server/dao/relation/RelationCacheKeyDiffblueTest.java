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
package org.thingsboard.server.dao.relation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.relation.EntitySearchDirection;
import org.thingsboard.server.common.data.relation.RelationTypeGroup;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.relation.RelationCacheKey.RelationCacheKeyBuilder;

@ContextConfiguration(classes = {RelationCacheKeyBuilder.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class RelationCacheKeyDiffblueTest {
  @Autowired private RelationCacheKeyBuilder relationCacheKeyBuilder;

  /**
   * Test {@link RelationCacheKey#equals(Object)}, and {@link RelationCacheKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RelationCacheKey#equals(Object)}
   *   <li>{@link RelationCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RelationCacheKey.equals(Object)", "int RelationCacheKey.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RelationCacheKey relationCacheKey =
        RelationCacheKey.builder()
            .direction(EntitySearchDirection.FROM)
            .from(BaseEntityService.NULL_CUSTOMER_ID)
            .to(BaseEntityService.NULL_CUSTOMER_ID)
            .type("Type")
            .typeGroup(RelationTypeGroup.COMMON)
            .build();
    RelationCacheKey relationCacheKey2 =
        RelationCacheKey.builder()
            .direction(EntitySearchDirection.FROM)
            .from(BaseEntityService.NULL_CUSTOMER_ID)
            .to(BaseEntityService.NULL_CUSTOMER_ID)
            .type("Type")
            .typeGroup(RelationTypeGroup.COMMON)
            .build();

    // Act and Assert
    assertEquals(relationCacheKey, relationCacheKey2);
    assertEquals(relationCacheKey.hashCode(), relationCacheKey2.hashCode());
  }

  /**
   * Test {@link RelationCacheKey#equals(Object)}, and {@link RelationCacheKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RelationCacheKey#equals(Object)}
   *   <li>{@link RelationCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RelationCacheKey.equals(Object)", "int RelationCacheKey.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    RelationCacheKey relationCacheKey =
        RelationCacheKey.builder()
            .direction(null)
            .from(BaseEntityService.NULL_CUSTOMER_ID)
            .to(BaseEntityService.NULL_CUSTOMER_ID)
            .type("Type")
            .typeGroup(RelationTypeGroup.COMMON)
            .build();
    RelationCacheKey relationCacheKey2 =
        RelationCacheKey.builder()
            .direction(null)
            .from(BaseEntityService.NULL_CUSTOMER_ID)
            .to(BaseEntityService.NULL_CUSTOMER_ID)
            .type("Type")
            .typeGroup(RelationTypeGroup.COMMON)
            .build();

    // Act and Assert
    assertEquals(relationCacheKey, relationCacheKey2);
    assertEquals(relationCacheKey.hashCode(), relationCacheKey2.hashCode());
  }

  /**
   * Test {@link RelationCacheKey#equals(Object)}, and {@link RelationCacheKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RelationCacheKey#equals(Object)}
   *   <li>{@link RelationCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RelationCacheKey.equals(Object)", "int RelationCacheKey.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    RelationCacheKey relationCacheKey =
        RelationCacheKey.builder()
            .direction(EntitySearchDirection.FROM)
            .from(null)
            .to(BaseEntityService.NULL_CUSTOMER_ID)
            .type("Type")
            .typeGroup(RelationTypeGroup.COMMON)
            .build();
    RelationCacheKey relationCacheKey2 =
        RelationCacheKey.builder()
            .direction(EntitySearchDirection.FROM)
            .from(null)
            .to(BaseEntityService.NULL_CUSTOMER_ID)
            .type("Type")
            .typeGroup(RelationTypeGroup.COMMON)
            .build();

    // Act and Assert
    assertEquals(relationCacheKey, relationCacheKey2);
    assertEquals(relationCacheKey.hashCode(), relationCacheKey2.hashCode());
  }

  /**
   * Test {@link RelationCacheKey#equals(Object)}, and {@link RelationCacheKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RelationCacheKey#equals(Object)}
   *   <li>{@link RelationCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RelationCacheKey.equals(Object)", "int RelationCacheKey.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    RelationCacheKey relationCacheKey =
        RelationCacheKey.builder()
            .direction(EntitySearchDirection.FROM)
            .from(BaseEntityService.NULL_CUSTOMER_ID)
            .to(null)
            .type("Type")
            .typeGroup(RelationTypeGroup.COMMON)
            .build();
    RelationCacheKey relationCacheKey2 =
        RelationCacheKey.builder()
            .direction(EntitySearchDirection.FROM)
            .from(BaseEntityService.NULL_CUSTOMER_ID)
            .to(null)
            .type("Type")
            .typeGroup(RelationTypeGroup.COMMON)
            .build();

    // Act and Assert
    assertEquals(relationCacheKey, relationCacheKey2);
    assertEquals(relationCacheKey.hashCode(), relationCacheKey2.hashCode());
  }

  /**
   * Test {@link RelationCacheKey#equals(Object)}, and {@link RelationCacheKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RelationCacheKey#equals(Object)}
   *   <li>{@link RelationCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RelationCacheKey.equals(Object)", "int RelationCacheKey.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    RelationCacheKey relationCacheKey =
        RelationCacheKey.builder()
            .direction(EntitySearchDirection.FROM)
            .from(BaseEntityService.NULL_CUSTOMER_ID)
            .to(BaseEntityService.NULL_CUSTOMER_ID)
            .type(null)
            .typeGroup(RelationTypeGroup.COMMON)
            .build();
    RelationCacheKey relationCacheKey2 =
        RelationCacheKey.builder()
            .direction(EntitySearchDirection.FROM)
            .from(BaseEntityService.NULL_CUSTOMER_ID)
            .to(BaseEntityService.NULL_CUSTOMER_ID)
            .type(null)
            .typeGroup(RelationTypeGroup.COMMON)
            .build();

    // Act and Assert
    assertEquals(relationCacheKey, relationCacheKey2);
    assertEquals(relationCacheKey.hashCode(), relationCacheKey2.hashCode());
  }

  /**
   * Test {@link RelationCacheKey#equals(Object)}, and {@link RelationCacheKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RelationCacheKey#equals(Object)}
   *   <li>{@link RelationCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RelationCacheKey.equals(Object)", "int RelationCacheKey.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual6() {
    // Arrange
    RelationCacheKey relationCacheKey =
        RelationCacheKey.builder()
            .direction(EntitySearchDirection.FROM)
            .from(BaseEntityService.NULL_CUSTOMER_ID)
            .to(BaseEntityService.NULL_CUSTOMER_ID)
            .type("Type")
            .typeGroup(null)
            .build();
    RelationCacheKey relationCacheKey2 =
        RelationCacheKey.builder()
            .direction(EntitySearchDirection.FROM)
            .from(BaseEntityService.NULL_CUSTOMER_ID)
            .to(BaseEntityService.NULL_CUSTOMER_ID)
            .type("Type")
            .typeGroup(null)
            .build();

    // Act and Assert
    assertEquals(relationCacheKey, relationCacheKey2);
    assertEquals(relationCacheKey.hashCode(), relationCacheKey2.hashCode());
  }

  /**
   * Test {@link RelationCacheKey#equals(Object)}, and {@link RelationCacheKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RelationCacheKey#equals(Object)}
   *   <li>{@link RelationCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RelationCacheKey.equals(Object)", "int RelationCacheKey.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RelationCacheKey relationCacheKey =
        RelationCacheKey.builder()
            .direction(EntitySearchDirection.FROM)
            .from(BaseEntityService.NULL_CUSTOMER_ID)
            .to(BaseEntityService.NULL_CUSTOMER_ID)
            .type("Type")
            .typeGroup(RelationTypeGroup.COMMON)
            .build();

    // Act and Assert
    assertEquals(relationCacheKey, relationCacheKey);
    int expectedHashCodeResult = relationCacheKey.hashCode();
    assertEquals(expectedHashCodeResult, relationCacheKey.hashCode());
  }

  /**
   * Test {@link RelationCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelationCacheKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RelationCacheKey.equals(Object)", "int RelationCacheKey.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RelationCacheKey relationCacheKey =
        RelationCacheKey.builder()
            .direction(null)
            .from(BaseEntityService.NULL_CUSTOMER_ID)
            .to(BaseEntityService.NULL_CUSTOMER_ID)
            .type("Type")
            .typeGroup(RelationTypeGroup.COMMON)
            .build();

    // Act and Assert
    assertNotEquals(
        relationCacheKey,
        RelationCacheKey.builder()
            .direction(EntitySearchDirection.FROM)
            .from(BaseEntityService.NULL_CUSTOMER_ID)
            .to(BaseEntityService.NULL_CUSTOMER_ID)
            .type("Type")
            .typeGroup(RelationTypeGroup.COMMON)
            .build());
  }

  /**
   * Test {@link RelationCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelationCacheKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RelationCacheKey.equals(Object)", "int RelationCacheKey.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RelationCacheKey relationCacheKey =
        RelationCacheKey.builder()
            .direction(EntitySearchDirection.TO)
            .from(BaseEntityService.NULL_CUSTOMER_ID)
            .to(BaseEntityService.NULL_CUSTOMER_ID)
            .type("Type")
            .typeGroup(RelationTypeGroup.COMMON)
            .build();

    // Act and Assert
    assertNotEquals(
        relationCacheKey,
        RelationCacheKey.builder()
            .direction(EntitySearchDirection.FROM)
            .from(BaseEntityService.NULL_CUSTOMER_ID)
            .to(BaseEntityService.NULL_CUSTOMER_ID)
            .type("Type")
            .typeGroup(RelationTypeGroup.COMMON)
            .build());
  }

  /**
   * Test {@link RelationCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelationCacheKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RelationCacheKey.equals(Object)", "int RelationCacheKey.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RelationCacheKey relationCacheKey =
        RelationCacheKey.builder()
            .direction(EntitySearchDirection.FROM)
            .from(ModelConstants.SYSTEM_TENANT)
            .to(BaseEntityService.NULL_CUSTOMER_ID)
            .type("Type")
            .typeGroup(RelationTypeGroup.COMMON)
            .build();

    // Act and Assert
    assertNotEquals(
        relationCacheKey,
        RelationCacheKey.builder()
            .direction(EntitySearchDirection.FROM)
            .from(BaseEntityService.NULL_CUSTOMER_ID)
            .to(BaseEntityService.NULL_CUSTOMER_ID)
            .type("Type")
            .typeGroup(RelationTypeGroup.COMMON)
            .build());
  }

  /**
   * Test {@link RelationCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelationCacheKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RelationCacheKey.equals(Object)", "int RelationCacheKey.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    RelationCacheKey relationCacheKey =
        RelationCacheKey.builder()
            .direction(EntitySearchDirection.FROM)
            .from(null)
            .to(BaseEntityService.NULL_CUSTOMER_ID)
            .type("Type")
            .typeGroup(RelationTypeGroup.COMMON)
            .build();

    // Act and Assert
    assertNotEquals(
        relationCacheKey,
        RelationCacheKey.builder()
            .direction(EntitySearchDirection.FROM)
            .from(BaseEntityService.NULL_CUSTOMER_ID)
            .to(BaseEntityService.NULL_CUSTOMER_ID)
            .type("Type")
            .typeGroup(RelationTypeGroup.COMMON)
            .build());
  }

  /**
   * Test {@link RelationCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelationCacheKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RelationCacheKey.equals(Object)", "int RelationCacheKey.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    RelationCacheKey relationCacheKey =
        RelationCacheKey.builder()
            .direction(EntitySearchDirection.FROM)
            .from(BaseEntityService.NULL_CUSTOMER_ID)
            .to(ModelConstants.SYSTEM_TENANT)
            .type("Type")
            .typeGroup(RelationTypeGroup.COMMON)
            .build();

    // Act and Assert
    assertNotEquals(
        relationCacheKey,
        RelationCacheKey.builder()
            .direction(EntitySearchDirection.FROM)
            .from(BaseEntityService.NULL_CUSTOMER_ID)
            .to(BaseEntityService.NULL_CUSTOMER_ID)
            .type("Type")
            .typeGroup(RelationTypeGroup.COMMON)
            .build());
  }

  /**
   * Test {@link RelationCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelationCacheKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RelationCacheKey.equals(Object)", "int RelationCacheKey.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    RelationCacheKey relationCacheKey =
        RelationCacheKey.builder()
            .direction(EntitySearchDirection.FROM)
            .from(BaseEntityService.NULL_CUSTOMER_ID)
            .to(null)
            .type("Type")
            .typeGroup(RelationTypeGroup.COMMON)
            .build();

    // Act and Assert
    assertNotEquals(
        relationCacheKey,
        RelationCacheKey.builder()
            .direction(EntitySearchDirection.FROM)
            .from(BaseEntityService.NULL_CUSTOMER_ID)
            .to(BaseEntityService.NULL_CUSTOMER_ID)
            .type("Type")
            .typeGroup(RelationTypeGroup.COMMON)
            .build());
  }

  /**
   * Test {@link RelationCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelationCacheKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RelationCacheKey.equals(Object)", "int RelationCacheKey.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    RelationCacheKey relationCacheKey =
        RelationCacheKey.builder()
            .direction(EntitySearchDirection.FROM)
            .from(BaseEntityService.NULL_CUSTOMER_ID)
            .to(BaseEntityService.NULL_CUSTOMER_ID)
            .type(null)
            .typeGroup(RelationTypeGroup.COMMON)
            .build();

    // Act and Assert
    assertNotEquals(
        relationCacheKey,
        RelationCacheKey.builder()
            .direction(EntitySearchDirection.FROM)
            .from(BaseEntityService.NULL_CUSTOMER_ID)
            .to(BaseEntityService.NULL_CUSTOMER_ID)
            .type("Type")
            .typeGroup(RelationTypeGroup.COMMON)
            .build());
  }

  /**
   * Test {@link RelationCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelationCacheKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RelationCacheKey.equals(Object)", "int RelationCacheKey.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    RelationCacheKey relationCacheKey =
        RelationCacheKey.builder()
            .direction(EntitySearchDirection.FROM)
            .from(BaseEntityService.NULL_CUSTOMER_ID)
            .to(BaseEntityService.NULL_CUSTOMER_ID)
            .type("42")
            .typeGroup(RelationTypeGroup.COMMON)
            .build();

    // Act and Assert
    assertNotEquals(
        relationCacheKey,
        RelationCacheKey.builder()
            .direction(EntitySearchDirection.FROM)
            .from(BaseEntityService.NULL_CUSTOMER_ID)
            .to(BaseEntityService.NULL_CUSTOMER_ID)
            .type("Type")
            .typeGroup(RelationTypeGroup.COMMON)
            .build());
  }

  /**
   * Test {@link RelationCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelationCacheKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RelationCacheKey.equals(Object)", "int RelationCacheKey.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    RelationCacheKey relationCacheKey =
        RelationCacheKey.builder()
            .direction(EntitySearchDirection.FROM)
            .from(BaseEntityService.NULL_CUSTOMER_ID)
            .to(BaseEntityService.NULL_CUSTOMER_ID)
            .type("Type")
            .typeGroup(null)
            .build();

    // Act and Assert
    assertNotEquals(
        relationCacheKey,
        RelationCacheKey.builder()
            .direction(EntitySearchDirection.FROM)
            .from(BaseEntityService.NULL_CUSTOMER_ID)
            .to(BaseEntityService.NULL_CUSTOMER_ID)
            .type("Type")
            .typeGroup(RelationTypeGroup.COMMON)
            .build());
  }

  /**
   * Test {@link RelationCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelationCacheKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RelationCacheKey.equals(Object)", "int RelationCacheKey.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    RelationCacheKey relationCacheKey =
        RelationCacheKey.builder()
            .direction(EntitySearchDirection.FROM)
            .from(BaseEntityService.NULL_CUSTOMER_ID)
            .to(BaseEntityService.NULL_CUSTOMER_ID)
            .type("Type")
            .typeGroup(RelationTypeGroup.DASHBOARD)
            .build();

    // Act and Assert
    assertNotEquals(
        relationCacheKey,
        RelationCacheKey.builder()
            .direction(EntitySearchDirection.FROM)
            .from(BaseEntityService.NULL_CUSTOMER_ID)
            .to(BaseEntityService.NULL_CUSTOMER_ID)
            .type("Type")
            .typeGroup(RelationTypeGroup.COMMON)
            .build());
  }

  /**
   * Test {@link RelationCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelationCacheKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RelationCacheKey.equals(Object)", "int RelationCacheKey.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        RelationCacheKey.builder()
            .direction(EntitySearchDirection.FROM)
            .from(BaseEntityService.NULL_CUSTOMER_ID)
            .to(BaseEntityService.NULL_CUSTOMER_ID)
            .type("Type")
            .typeGroup(RelationTypeGroup.COMMON)
            .build(),
        null);
  }

  /**
   * Test {@link RelationCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelationCacheKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RelationCacheKey.equals(Object)", "int RelationCacheKey.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        RelationCacheKey.builder()
            .direction(EntitySearchDirection.FROM)
            .from(BaseEntityService.NULL_CUSTOMER_ID)
            .to(BaseEntityService.NULL_CUSTOMER_ID)
            .type("Type")
            .typeGroup(RelationTypeGroup.COMMON)
            .build(),
        "Different type to RelationCacheKey");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RelationCacheKey#RelationCacheKey(EntityId, EntityId, String, RelationTypeGroup)}
   *   <li>{@link RelationCacheKey#toString()}
   *   <li>{@link RelationCacheKey#getDirection()}
   *   <li>{@link RelationCacheKey#getFrom()}
   *   <li>{@link RelationCacheKey#getTo()}
   *   <li>{@link RelationCacheKey#getType()}
   *   <li>{@link RelationCacheKey#getTypeGroup()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RelationCacheKey.<init>(EntityId, EntityId, String, RelationTypeGroup)",
    "void RelationCacheKey.<init>(EntityId, EntityId, String, RelationTypeGroup, EntitySearchDirection)",
    "EntitySearchDirection RelationCacheKey.getDirection()",
    "EntityId RelationCacheKey.getFrom()",
    "EntityId RelationCacheKey.getTo()",
    "String RelationCacheKey.getType()",
    "RelationTypeGroup RelationCacheKey.getTypeGroup()",
    "String RelationCacheKey.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange
    CustomerId resultTo = BaseEntityService.NULL_CUSTOMER_ID;

    // Act
    RelationCacheKey actualRelationCacheKey =
        new RelationCacheKey(
            BaseEntityService.NULL_CUSTOMER_ID, resultTo, "Type", RelationTypeGroup.COMMON);
    String actualToStringResult = actualRelationCacheKey.toString();
    EntitySearchDirection actualDirection = actualRelationCacheKey.getDirection();
    EntityId actualFrom = actualRelationCacheKey.getFrom();
    EntityId actualTo = actualRelationCacheKey.getTo();
    String actualType = actualRelationCacheKey.getType();

    // Assert
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080_13814000-1dd2-11b2-8080-808080808080_Type_COMMON",
        actualToStringResult);
    assertEquals("Type", actualType);
    assertNull(actualDirection);
    assertEquals(RelationTypeGroup.COMMON, actualRelationCacheKey.getTypeGroup());
    assertSame(resultTo, actualFrom);
    assertSame(resultTo, actualTo);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RelationCacheKey#RelationCacheKey(EntityId, EntityId, String, RelationTypeGroup,
   *       EntitySearchDirection)}
   *   <li>{@link RelationCacheKey#toString()}
   *   <li>{@link RelationCacheKey#getDirection()}
   *   <li>{@link RelationCacheKey#getFrom()}
   *   <li>{@link RelationCacheKey#getTo()}
   *   <li>{@link RelationCacheKey#getType()}
   *   <li>{@link RelationCacheKey#getTypeGroup()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RelationCacheKey.<init>(EntityId, EntityId, String, RelationTypeGroup)",
    "void RelationCacheKey.<init>(EntityId, EntityId, String, RelationTypeGroup, EntitySearchDirection)",
    "EntitySearchDirection RelationCacheKey.getDirection()",
    "EntityId RelationCacheKey.getFrom()",
    "EntityId RelationCacheKey.getTo()",
    "String RelationCacheKey.getType()",
    "RelationTypeGroup RelationCacheKey.getTypeGroup()",
    "String RelationCacheKey.toString()"
  })
  public void testGettersAndSetters2() {
    // Arrange
    CustomerId resultTo = BaseEntityService.NULL_CUSTOMER_ID;

    // Act
    RelationCacheKey actualRelationCacheKey =
        new RelationCacheKey(
            BaseEntityService.NULL_CUSTOMER_ID,
            resultTo,
            "Type",
            RelationTypeGroup.COMMON,
            EntitySearchDirection.FROM);
    String actualToStringResult = actualRelationCacheKey.toString();
    EntitySearchDirection actualDirection = actualRelationCacheKey.getDirection();
    EntityId actualFrom = actualRelationCacheKey.getFrom();
    EntityId actualTo = actualRelationCacheKey.getTo();
    String actualType = actualRelationCacheKey.getType();

    // Assert
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080_13814000-1dd2-11b2-8080-808080808080_Type_COMMON_FROM",
        actualToStringResult);
    assertEquals("Type", actualType);
    assertEquals(EntitySearchDirection.FROM, actualDirection);
    assertEquals(RelationTypeGroup.COMMON, actualRelationCacheKey.getTypeGroup());
    assertSame(resultTo, actualFrom);
    assertSame(resultTo, actualTo);
  }

  /**
   * Test RelationCacheKeyBuilder {@link RelationCacheKeyBuilder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RelationCacheKeyBuilder#build()}
   *   <li>{@link RelationCacheKeyBuilder#direction(EntitySearchDirection)}
   *   <li>{@link RelationCacheKeyBuilder#from(EntityId)}
   *   <li>{@link RelationCacheKeyBuilder#to(EntityId)}
   *   <li>{@link RelationCacheKeyBuilder#type(String)}
   *   <li>{@link RelationCacheKeyBuilder#typeGroup(RelationTypeGroup)}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RelationCacheKeyBuilder.<init>()",
    "RelationCacheKey RelationCacheKeyBuilder.build()",
    "RelationCacheKeyBuilder RelationCacheKeyBuilder.direction(EntitySearchDirection)",
    "RelationCacheKeyBuilder RelationCacheKeyBuilder.from(EntityId)",
    "RelationCacheKeyBuilder RelationCacheKeyBuilder.to(EntityId)",
    "String RelationCacheKeyBuilder.toString()",
    "RelationCacheKeyBuilder RelationCacheKeyBuilder.type(String)",
    "RelationCacheKeyBuilder RelationCacheKeyBuilder.typeGroup(RelationTypeGroup)"
  })
  public void testRelationCacheKeyBuilderBuild() {
    // Arrange
    CustomerId resultTo = BaseEntityService.NULL_CUSTOMER_ID;

    // Act
    RelationCacheKey actualRelationCacheKey =
        RelationCacheKey.builder()
            .direction(EntitySearchDirection.FROM)
            .from(BaseEntityService.NULL_CUSTOMER_ID)
            .to(resultTo)
            .type("Type")
            .typeGroup(RelationTypeGroup.COMMON)
            .build();

    // Assert
    assertEquals("Type", actualRelationCacheKey.getType());
    assertEquals(EntitySearchDirection.FROM, actualRelationCacheKey.getDirection());
    assertEquals(RelationTypeGroup.COMMON, actualRelationCacheKey.getTypeGroup());
    assertSame(resultTo, actualRelationCacheKey.getFrom());
    assertSame(resultTo, actualRelationCacheKey.getTo());
  }
}
