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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.id.RuleNodeStateId;
import org.thingsboard.server.common.data.rule.RuleNodeState;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;

public class RuleNodeStateEntityDiffblueTest {
  /**
   * Test {@link RuleNodeStateEntity#equals(Object)}, and {@link RuleNodeStateEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuleNodeStateEntity#equals(Object)}
   *   <li>{@link RuleNodeStateEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleNodeStateEntity.equals(Object)",
    "int RuleNodeStateEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RuleNodeStateEntity ruleNodeStateEntity = new RuleNodeStateEntity();
    ruleNodeStateEntity.setCreatedTime(1L);
    ruleNodeStateEntity.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity.setEntityType("Entity Type");
    ruleNodeStateEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity.setRuleNodeId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity.setStateData("MD");
    ruleNodeStateEntity.setUuid(ModelConstants.NULL_UUID);

    RuleNodeStateEntity ruleNodeStateEntity2 = new RuleNodeStateEntity();
    ruleNodeStateEntity2.setCreatedTime(1L);
    ruleNodeStateEntity2.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity2.setEntityType("Entity Type");
    ruleNodeStateEntity2.setId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity2.setRuleNodeId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity2.setStateData("MD");
    ruleNodeStateEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(ruleNodeStateEntity, ruleNodeStateEntity2);
    assertEquals(ruleNodeStateEntity.hashCode(), ruleNodeStateEntity2.hashCode());
  }

  /**
   * Test {@link RuleNodeStateEntity#equals(Object)}, and {@link RuleNodeStateEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuleNodeStateEntity#equals(Object)}
   *   <li>{@link RuleNodeStateEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleNodeStateEntity.equals(Object)",
    "int RuleNodeStateEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    RuleNodeStateEntity ruleNodeStateEntity = new RuleNodeStateEntity();
    ruleNodeStateEntity.setCreatedTime(1L);
    ruleNodeStateEntity.setEntityId(null);
    ruleNodeStateEntity.setEntityType("Entity Type");
    ruleNodeStateEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity.setRuleNodeId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity.setStateData("MD");
    ruleNodeStateEntity.setUuid(ModelConstants.NULL_UUID);

    RuleNodeStateEntity ruleNodeStateEntity2 = new RuleNodeStateEntity();
    ruleNodeStateEntity2.setCreatedTime(1L);
    ruleNodeStateEntity2.setEntityId(null);
    ruleNodeStateEntity2.setEntityType("Entity Type");
    ruleNodeStateEntity2.setId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity2.setRuleNodeId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity2.setStateData("MD");
    ruleNodeStateEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(ruleNodeStateEntity, ruleNodeStateEntity2);
    assertEquals(ruleNodeStateEntity.hashCode(), ruleNodeStateEntity2.hashCode());
  }

  /**
   * Test {@link RuleNodeStateEntity#equals(Object)}, and {@link RuleNodeStateEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuleNodeStateEntity#equals(Object)}
   *   <li>{@link RuleNodeStateEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleNodeStateEntity.equals(Object)",
    "int RuleNodeStateEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    RuleNodeStateEntity ruleNodeStateEntity = new RuleNodeStateEntity();
    ruleNodeStateEntity.setCreatedTime(1L);
    ruleNodeStateEntity.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity.setEntityType(null);
    ruleNodeStateEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity.setRuleNodeId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity.setStateData("MD");
    ruleNodeStateEntity.setUuid(ModelConstants.NULL_UUID);

    RuleNodeStateEntity ruleNodeStateEntity2 = new RuleNodeStateEntity();
    ruleNodeStateEntity2.setCreatedTime(1L);
    ruleNodeStateEntity2.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity2.setEntityType(null);
    ruleNodeStateEntity2.setId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity2.setRuleNodeId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity2.setStateData("MD");
    ruleNodeStateEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(ruleNodeStateEntity, ruleNodeStateEntity2);
    assertEquals(ruleNodeStateEntity.hashCode(), ruleNodeStateEntity2.hashCode());
  }

  /**
   * Test {@link RuleNodeStateEntity#equals(Object)}, and {@link RuleNodeStateEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuleNodeStateEntity#equals(Object)}
   *   <li>{@link RuleNodeStateEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleNodeStateEntity.equals(Object)",
    "int RuleNodeStateEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    RuleNodeStateEntity ruleNodeStateEntity = new RuleNodeStateEntity();
    ruleNodeStateEntity.setCreatedTime(1L);
    ruleNodeStateEntity.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity.setEntityType("Entity Type");
    ruleNodeStateEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity.setRuleNodeId(null);
    ruleNodeStateEntity.setStateData("MD");
    ruleNodeStateEntity.setUuid(ModelConstants.NULL_UUID);

    RuleNodeStateEntity ruleNodeStateEntity2 = new RuleNodeStateEntity();
    ruleNodeStateEntity2.setCreatedTime(1L);
    ruleNodeStateEntity2.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity2.setEntityType("Entity Type");
    ruleNodeStateEntity2.setId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity2.setRuleNodeId(null);
    ruleNodeStateEntity2.setStateData("MD");
    ruleNodeStateEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(ruleNodeStateEntity, ruleNodeStateEntity2);
    assertEquals(ruleNodeStateEntity.hashCode(), ruleNodeStateEntity2.hashCode());
  }

  /**
   * Test {@link RuleNodeStateEntity#equals(Object)}, and {@link RuleNodeStateEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuleNodeStateEntity#equals(Object)}
   *   <li>{@link RuleNodeStateEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleNodeStateEntity.equals(Object)",
    "int RuleNodeStateEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    RuleNodeStateEntity ruleNodeStateEntity = new RuleNodeStateEntity();
    ruleNodeStateEntity.setCreatedTime(1L);
    ruleNodeStateEntity.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity.setEntityType("Entity Type");
    ruleNodeStateEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity.setRuleNodeId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity.setStateData(null);
    ruleNodeStateEntity.setUuid(ModelConstants.NULL_UUID);

    RuleNodeStateEntity ruleNodeStateEntity2 = new RuleNodeStateEntity();
    ruleNodeStateEntity2.setCreatedTime(1L);
    ruleNodeStateEntity2.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity2.setEntityType("Entity Type");
    ruleNodeStateEntity2.setId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity2.setRuleNodeId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity2.setStateData(null);
    ruleNodeStateEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(ruleNodeStateEntity, ruleNodeStateEntity2);
    assertEquals(ruleNodeStateEntity.hashCode(), ruleNodeStateEntity2.hashCode());
  }

  /**
   * Test {@link RuleNodeStateEntity#equals(Object)}, and {@link RuleNodeStateEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuleNodeStateEntity#equals(Object)}
   *   <li>{@link RuleNodeStateEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleNodeStateEntity.equals(Object)",
    "int RuleNodeStateEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RuleNodeStateEntity ruleNodeStateEntity = new RuleNodeStateEntity();
    ruleNodeStateEntity.setCreatedTime(1L);
    ruleNodeStateEntity.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity.setEntityType("Entity Type");
    ruleNodeStateEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity.setRuleNodeId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity.setStateData("MD");
    ruleNodeStateEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(ruleNodeStateEntity, ruleNodeStateEntity);
    int expectedHashCodeResult = ruleNodeStateEntity.hashCode();
    assertEquals(expectedHashCodeResult, ruleNodeStateEntity.hashCode());
  }

  /**
   * Test {@link RuleNodeStateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeStateEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleNodeStateEntity.equals(Object)",
    "int RuleNodeStateEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RuleNodeStateEntity ruleNodeStateEntity = new RuleNodeStateEntity();
    ruleNodeStateEntity.setCreatedTime(3L);
    ruleNodeStateEntity.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity.setEntityType("Entity Type");
    ruleNodeStateEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity.setRuleNodeId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity.setStateData("MD");
    ruleNodeStateEntity.setUuid(ModelConstants.NULL_UUID);

    RuleNodeStateEntity ruleNodeStateEntity2 = new RuleNodeStateEntity();
    ruleNodeStateEntity2.setCreatedTime(1L);
    ruleNodeStateEntity2.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity2.setEntityType("Entity Type");
    ruleNodeStateEntity2.setId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity2.setRuleNodeId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity2.setStateData("MD");
    ruleNodeStateEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(ruleNodeStateEntity, ruleNodeStateEntity2);
  }

  /**
   * Test {@link RuleNodeStateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeStateEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleNodeStateEntity.equals(Object)",
    "int RuleNodeStateEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RuleNodeStateEntity ruleNodeStateEntity = new RuleNodeStateEntity();
    ruleNodeStateEntity.setCreatedTime(1L);
    ruleNodeStateEntity.setEntityId(UUID.randomUUID());
    ruleNodeStateEntity.setEntityType("Entity Type");
    ruleNodeStateEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity.setRuleNodeId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity.setStateData("MD");
    ruleNodeStateEntity.setUuid(ModelConstants.NULL_UUID);

    RuleNodeStateEntity ruleNodeStateEntity2 = new RuleNodeStateEntity();
    ruleNodeStateEntity2.setCreatedTime(1L);
    ruleNodeStateEntity2.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity2.setEntityType("Entity Type");
    ruleNodeStateEntity2.setId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity2.setRuleNodeId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity2.setStateData("MD");
    ruleNodeStateEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(ruleNodeStateEntity, ruleNodeStateEntity2);
  }

  /**
   * Test {@link RuleNodeStateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeStateEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleNodeStateEntity.equals(Object)",
    "int RuleNodeStateEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RuleNodeStateEntity ruleNodeStateEntity = new RuleNodeStateEntity();
    ruleNodeStateEntity.setCreatedTime(1L);
    ruleNodeStateEntity.setEntityId(null);
    ruleNodeStateEntity.setEntityType("Entity Type");
    ruleNodeStateEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity.setRuleNodeId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity.setStateData("MD");
    ruleNodeStateEntity.setUuid(ModelConstants.NULL_UUID);

    RuleNodeStateEntity ruleNodeStateEntity2 = new RuleNodeStateEntity();
    ruleNodeStateEntity2.setCreatedTime(1L);
    ruleNodeStateEntity2.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity2.setEntityType("Entity Type");
    ruleNodeStateEntity2.setId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity2.setRuleNodeId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity2.setStateData("MD");
    ruleNodeStateEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(ruleNodeStateEntity, ruleNodeStateEntity2);
  }

  /**
   * Test {@link RuleNodeStateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeStateEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleNodeStateEntity.equals(Object)",
    "int RuleNodeStateEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    RuleNodeStateEntity ruleNodeStateEntity = new RuleNodeStateEntity();
    ruleNodeStateEntity.setCreatedTime(1L);
    ruleNodeStateEntity.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity.setEntityType("MD");
    ruleNodeStateEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity.setRuleNodeId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity.setStateData("MD");
    ruleNodeStateEntity.setUuid(ModelConstants.NULL_UUID);

    RuleNodeStateEntity ruleNodeStateEntity2 = new RuleNodeStateEntity();
    ruleNodeStateEntity2.setCreatedTime(1L);
    ruleNodeStateEntity2.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity2.setEntityType("Entity Type");
    ruleNodeStateEntity2.setId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity2.setRuleNodeId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity2.setStateData("MD");
    ruleNodeStateEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(ruleNodeStateEntity, ruleNodeStateEntity2);
  }

  /**
   * Test {@link RuleNodeStateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeStateEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleNodeStateEntity.equals(Object)",
    "int RuleNodeStateEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    RuleNodeStateEntity ruleNodeStateEntity = new RuleNodeStateEntity();
    ruleNodeStateEntity.setCreatedTime(1L);
    ruleNodeStateEntity.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity.setEntityType(null);
    ruleNodeStateEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity.setRuleNodeId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity.setStateData("MD");
    ruleNodeStateEntity.setUuid(ModelConstants.NULL_UUID);

    RuleNodeStateEntity ruleNodeStateEntity2 = new RuleNodeStateEntity();
    ruleNodeStateEntity2.setCreatedTime(1L);
    ruleNodeStateEntity2.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity2.setEntityType("Entity Type");
    ruleNodeStateEntity2.setId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity2.setRuleNodeId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity2.setStateData("MD");
    ruleNodeStateEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(ruleNodeStateEntity, ruleNodeStateEntity2);
  }

  /**
   * Test {@link RuleNodeStateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeStateEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleNodeStateEntity.equals(Object)",
    "int RuleNodeStateEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    RuleNodeStateEntity ruleNodeStateEntity = new RuleNodeStateEntity();
    ruleNodeStateEntity.setCreatedTime(1L);
    ruleNodeStateEntity.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity.setEntityType("Entity Type");
    ruleNodeStateEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity.setRuleNodeId(UUID.randomUUID());
    ruleNodeStateEntity.setStateData("MD");
    ruleNodeStateEntity.setUuid(ModelConstants.NULL_UUID);

    RuleNodeStateEntity ruleNodeStateEntity2 = new RuleNodeStateEntity();
    ruleNodeStateEntity2.setCreatedTime(1L);
    ruleNodeStateEntity2.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity2.setEntityType("Entity Type");
    ruleNodeStateEntity2.setId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity2.setRuleNodeId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity2.setStateData("MD");
    ruleNodeStateEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(ruleNodeStateEntity, ruleNodeStateEntity2);
  }

  /**
   * Test {@link RuleNodeStateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeStateEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleNodeStateEntity.equals(Object)",
    "int RuleNodeStateEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    RuleNodeStateEntity ruleNodeStateEntity = new RuleNodeStateEntity();
    ruleNodeStateEntity.setCreatedTime(1L);
    ruleNodeStateEntity.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity.setEntityType("Entity Type");
    ruleNodeStateEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity.setRuleNodeId(null);
    ruleNodeStateEntity.setStateData("MD");
    ruleNodeStateEntity.setUuid(ModelConstants.NULL_UUID);

    RuleNodeStateEntity ruleNodeStateEntity2 = new RuleNodeStateEntity();
    ruleNodeStateEntity2.setCreatedTime(1L);
    ruleNodeStateEntity2.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity2.setEntityType("Entity Type");
    ruleNodeStateEntity2.setId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity2.setRuleNodeId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity2.setStateData("MD");
    ruleNodeStateEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(ruleNodeStateEntity, ruleNodeStateEntity2);
  }

  /**
   * Test {@link RuleNodeStateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeStateEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleNodeStateEntity.equals(Object)",
    "int RuleNodeStateEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    RuleNodeStateEntity ruleNodeStateEntity = new RuleNodeStateEntity();
    ruleNodeStateEntity.setCreatedTime(1L);
    ruleNodeStateEntity.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity.setEntityType("Entity Type");
    ruleNodeStateEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity.setRuleNodeId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity.setStateData("Entity Type");
    ruleNodeStateEntity.setUuid(ModelConstants.NULL_UUID);

    RuleNodeStateEntity ruleNodeStateEntity2 = new RuleNodeStateEntity();
    ruleNodeStateEntity2.setCreatedTime(1L);
    ruleNodeStateEntity2.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity2.setEntityType("Entity Type");
    ruleNodeStateEntity2.setId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity2.setRuleNodeId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity2.setStateData("MD");
    ruleNodeStateEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(ruleNodeStateEntity, ruleNodeStateEntity2);
  }

  /**
   * Test {@link RuleNodeStateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeStateEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleNodeStateEntity.equals(Object)",
    "int RuleNodeStateEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    RuleNodeStateEntity ruleNodeStateEntity = new RuleNodeStateEntity();
    ruleNodeStateEntity.setCreatedTime(1L);
    ruleNodeStateEntity.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity.setEntityType("Entity Type");
    ruleNodeStateEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity.setRuleNodeId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity.setStateData(null);
    ruleNodeStateEntity.setUuid(ModelConstants.NULL_UUID);

    RuleNodeStateEntity ruleNodeStateEntity2 = new RuleNodeStateEntity();
    ruleNodeStateEntity2.setCreatedTime(1L);
    ruleNodeStateEntity2.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity2.setEntityType("Entity Type");
    ruleNodeStateEntity2.setId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity2.setRuleNodeId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity2.setStateData("MD");
    ruleNodeStateEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(ruleNodeStateEntity, ruleNodeStateEntity2);
  }

  /**
   * Test {@link RuleNodeStateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeStateEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleNodeStateEntity.equals(Object)",
    "int RuleNodeStateEntity.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    RuleNodeStateEntity ruleNodeStateEntity = new RuleNodeStateEntity();
    ruleNodeStateEntity.setCreatedTime(1L);
    ruleNodeStateEntity.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity.setEntityType("Entity Type");
    ruleNodeStateEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity.setRuleNodeId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity.setStateData("MD");
    ruleNodeStateEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(ruleNodeStateEntity, null);
  }

  /**
   * Test {@link RuleNodeStateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeStateEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleNodeStateEntity.equals(Object)",
    "int RuleNodeStateEntity.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    RuleNodeStateEntity ruleNodeStateEntity = new RuleNodeStateEntity();
    ruleNodeStateEntity.setCreatedTime(1L);
    ruleNodeStateEntity.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity.setEntityType("Entity Type");
    ruleNodeStateEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity.setRuleNodeId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity.setStateData("MD");
    ruleNodeStateEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(ruleNodeStateEntity, "Different type to RuleNodeStateEntity");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuleNodeStateEntity#RuleNodeStateEntity()}
   *   <li>{@link RuleNodeStateEntity#setEntityId(UUID)}
   *   <li>{@link RuleNodeStateEntity#setEntityType(String)}
   *   <li>{@link RuleNodeStateEntity#setRuleNodeId(UUID)}
   *   <li>{@link RuleNodeStateEntity#setStateData(String)}
   *   <li>{@link RuleNodeStateEntity#toString()}
   *   <li>{@link RuleNodeStateEntity#getEntityId()}
   *   <li>{@link RuleNodeStateEntity#getEntityType()}
   *   <li>{@link RuleNodeStateEntity#getRuleNodeId()}
   *   <li>{@link RuleNodeStateEntity#getStateData()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RuleNodeStateEntity.<init>()",
    "UUID RuleNodeStateEntity.getEntityId()",
    "String RuleNodeStateEntity.getEntityType()",
    "UUID RuleNodeStateEntity.getRuleNodeId()",
    "String RuleNodeStateEntity.getStateData()",
    "void RuleNodeStateEntity.setEntityId(UUID)",
    "void RuleNodeStateEntity.setEntityType(String)",
    "void RuleNodeStateEntity.setRuleNodeId(UUID)",
    "void RuleNodeStateEntity.setStateData(String)",
    "String RuleNodeStateEntity.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    RuleNodeStateEntity actualRuleNodeStateEntity = new RuleNodeStateEntity();
    actualRuleNodeStateEntity.setEntityId(ModelConstants.NULL_UUID);
    actualRuleNodeStateEntity.setEntityType("Entity Type");
    UUID ruleNodeId = ModelConstants.NULL_UUID;
    actualRuleNodeStateEntity.setRuleNodeId(ruleNodeId);
    actualRuleNodeStateEntity.setStateData("MD");
    String actualToStringResult = actualRuleNodeStateEntity.toString();
    UUID actualEntityId = actualRuleNodeStateEntity.getEntityId();
    String actualEntityType = actualRuleNodeStateEntity.getEntityType();
    UUID actualRuleNodeId = actualRuleNodeStateEntity.getRuleNodeId();

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEntityId.toString());
    assertEquals("Entity Type", actualEntityType);
    assertEquals("MD", actualRuleNodeStateEntity.getStateData());
    assertEquals(
        "RuleNodeStateEntity(ruleNodeId=13814000-1dd2-11b2-8080-808080808080, entityType=Entity Type,"
            + " entityId=13814000-1dd2-11b2-8080-808080808080, stateData=MD)",
        actualToStringResult);
    assertNull(actualRuleNodeStateEntity.getId());
    assertNull(actualRuleNodeStateEntity.getUuid());
    assertEquals(0L, actualRuleNodeStateEntity.getCreatedTime());
    assertSame(ruleNodeId, actualEntityId);
    assertSame(ruleNodeId, actualRuleNodeId);
  }

  /**
   * Test {@link RuleNodeStateEntity#RuleNodeStateEntity(RuleNodeState)}.
   *
   * <p>Method under test: {@link RuleNodeStateEntity#RuleNodeStateEntity(RuleNodeState)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuleNodeStateEntity.<init>(RuleNodeState)"})
  public void testNewRuleNodeStateEntity() {
    // Arrange
    RuleNodeState ruleNodeState = new RuleNodeState((RuleNodeStateId) null);
    ruleNodeState.setRuleNodeId(new RuleNodeId(ModelConstants.NULL_UUID));
    ruleNodeState.setEntityId(ModelConstants.SYSTEM_TENANT);

    // Act
    RuleNodeStateEntity actualRuleNodeStateEntity = new RuleNodeStateEntity(ruleNodeState);

    // Assert
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080",
        actualRuleNodeStateEntity.getRuleNodeId().toString());
    assertEquals("TENANT", actualRuleNodeStateEntity.getEntityType());
    assertNull(actualRuleNodeStateEntity.getId());
    assertNull(actualRuleNodeStateEntity.getUuid());
    assertEquals(0L, actualRuleNodeStateEntity.getCreatedTime());
  }

  /**
   * Test {@link RuleNodeStateEntity#RuleNodeStateEntity(RuleNodeState)}.
   *
   * <p>Method under test: {@link RuleNodeStateEntity#RuleNodeStateEntity(RuleNodeState)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuleNodeStateEntity.<init>(RuleNodeState)"})
  public void testNewRuleNodeStateEntity2() {
    // Arrange
    RuleNodeState ruleNodeState = new RuleNodeState(new RuleNodeStateId(ModelConstants.NULL_UUID));
    ruleNodeState.setRuleNodeId(new RuleNodeId(ModelConstants.NULL_UUID));
    ruleNodeState.setEntityId(ModelConstants.SYSTEM_TENANT);

    // Act
    RuleNodeStateEntity actualRuleNodeStateEntity = new RuleNodeStateEntity(ruleNodeState);

    // Assert
    UUID id = actualRuleNodeStateEntity.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals("TENANT", actualRuleNodeStateEntity.getEntityType());
    assertEquals(0L, actualRuleNodeStateEntity.getCreatedTime());
    assertSame(id, actualRuleNodeStateEntity.getUuid());
    assertSame(id, actualRuleNodeStateEntity.getRuleNodeId());
  }

  /**
   * Test {@link RuleNodeStateEntity#RuleNodeStateEntity(RuleNodeState)}.
   *
   * <ul>
   *   <li>Given {@link BaseEntityService#NULL_CUSTOMER_ID}.
   *   <li>Then return EntityType is {@code CUSTOMER}.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeStateEntity#RuleNodeStateEntity(RuleNodeState)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuleNodeStateEntity.<init>(RuleNodeState)"})
  public void testNewRuleNodeStateEntity_givenNull_customer_id_thenReturnEntityTypeIsCustomer() {
    // Arrange
    RuleNodeState ruleNodeState = new RuleNodeState();
    ruleNodeState.setEntityId(BaseEntityService.NULL_CUSTOMER_ID);

    // Act
    RuleNodeStateEntity actualRuleNodeStateEntity = new RuleNodeStateEntity(ruleNodeState);

    // Assert
    assertEquals("CUSTOMER", actualRuleNodeStateEntity.getEntityType());
    assertNull(actualRuleNodeStateEntity.getId());
    assertNull(actualRuleNodeStateEntity.getUuid());
    assertNull(actualRuleNodeStateEntity.getRuleNodeId());
    assertEquals(0L, actualRuleNodeStateEntity.getCreatedTime());
  }

  /**
   * Test {@link RuleNodeStateEntity#RuleNodeStateEntity(RuleNodeState)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return CreatedTime is one.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeStateEntity#RuleNodeStateEntity(RuleNodeState)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuleNodeStateEntity.<init>(RuleNodeState)"})
  public void testNewRuleNodeStateEntity_givenOne_thenReturnCreatedTimeIsOne() {
    // Arrange
    RuleNodeState ruleNodeState = new RuleNodeState();
    ruleNodeState.setCreatedTime(1L);
    ruleNodeState.setEntityId(ModelConstants.SYSTEM_TENANT);

    // Act
    RuleNodeStateEntity actualRuleNodeStateEntity = new RuleNodeStateEntity(ruleNodeState);

    // Assert
    assertEquals("TENANT", actualRuleNodeStateEntity.getEntityType());
    assertNull(actualRuleNodeStateEntity.getId());
    assertNull(actualRuleNodeStateEntity.getUuid());
    assertNull(actualRuleNodeStateEntity.getRuleNodeId());
    assertEquals(1L, actualRuleNodeStateEntity.getCreatedTime());
  }

  /**
   * Test {@link RuleNodeStateEntity#RuleNodeStateEntity(RuleNodeState)}.
   *
   * <ul>
   *   <li>When {@link RuleNodeState#RuleNodeState()} EntityId is {@link
   *       ModelConstants#SYSTEM_TENANT}.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeStateEntity#RuleNodeStateEntity(RuleNodeState)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuleNodeStateEntity.<init>(RuleNodeState)"})
  public void testNewRuleNodeStateEntity_whenRuleNodeStateEntityIdIsSystem_tenant() {
    // Arrange
    RuleNodeState ruleNodeState = new RuleNodeState();
    ruleNodeState.setEntityId(ModelConstants.SYSTEM_TENANT);

    // Act
    RuleNodeStateEntity actualRuleNodeStateEntity = new RuleNodeStateEntity(ruleNodeState);

    // Assert
    assertEquals("TENANT", actualRuleNodeStateEntity.getEntityType());
    assertNull(actualRuleNodeStateEntity.getId());
    assertNull(actualRuleNodeStateEntity.getUuid());
    assertNull(actualRuleNodeStateEntity.getRuleNodeId());
    assertEquals(0L, actualRuleNodeStateEntity.getCreatedTime());
  }
}
