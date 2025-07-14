package org.thingsboard.server.dao.model.sql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.ApiUsageStateId;
import org.thingsboard.server.common.data.id.AssetId;
import org.thingsboard.server.common.data.id.AssetProfileId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.DashboardId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.id.RuleNodeStateId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.rule.RuleNodeState;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;

class RuleNodeStateEntityDiffblueTest {
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
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RuleNodeStateEntity.equals(Object)",
    "int RuleNodeStateEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RuleNodeStateEntity ruleNodeStateEntity = new RuleNodeStateEntity();
    ruleNodeStateEntity.setCreatedTime(1L);
    ruleNodeStateEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeStateEntity.setEntityType("Entity Type");
    ruleNodeStateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeStateEntity.setRuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeStateEntity.setStateData("MD");
    ruleNodeStateEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RuleNodeStateEntity ruleNodeStateEntity2 = new RuleNodeStateEntity();
    ruleNodeStateEntity2.setCreatedTime(1L);
    ruleNodeStateEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeStateEntity2.setEntityType("Entity Type");
    ruleNodeStateEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeStateEntity2.setRuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeStateEntity2.setStateData("MD");
    ruleNodeStateEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(ruleNodeStateEntity, ruleNodeStateEntity2);
    int expectedHashCodeResult = ruleNodeStateEntity.hashCode();
    assertEquals(expectedHashCodeResult, ruleNodeStateEntity2.hashCode());
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
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RuleNodeStateEntity.equals(Object)",
    "int RuleNodeStateEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    RuleNodeStateEntity ruleNodeStateEntity = new RuleNodeStateEntity();
    ruleNodeStateEntity.setCreatedTime(1L);
    ruleNodeStateEntity.setEntityId(null);
    ruleNodeStateEntity.setEntityType("Entity Type");
    ruleNodeStateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeStateEntity.setRuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeStateEntity.setStateData("MD");
    ruleNodeStateEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RuleNodeStateEntity ruleNodeStateEntity2 = new RuleNodeStateEntity();
    ruleNodeStateEntity2.setCreatedTime(1L);
    ruleNodeStateEntity2.setEntityId(null);
    ruleNodeStateEntity2.setEntityType("Entity Type");
    ruleNodeStateEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeStateEntity2.setRuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeStateEntity2.setStateData("MD");
    ruleNodeStateEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(ruleNodeStateEntity, ruleNodeStateEntity2);
    int expectedHashCodeResult = ruleNodeStateEntity.hashCode();
    assertEquals(expectedHashCodeResult, ruleNodeStateEntity2.hashCode());
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
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RuleNodeStateEntity.equals(Object)",
    "int RuleNodeStateEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    RuleNodeStateEntity ruleNodeStateEntity = new RuleNodeStateEntity();
    ruleNodeStateEntity.setCreatedTime(1L);
    ruleNodeStateEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeStateEntity.setEntityType(null);
    ruleNodeStateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeStateEntity.setRuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeStateEntity.setStateData("MD");
    ruleNodeStateEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RuleNodeStateEntity ruleNodeStateEntity2 = new RuleNodeStateEntity();
    ruleNodeStateEntity2.setCreatedTime(1L);
    ruleNodeStateEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeStateEntity2.setEntityType(null);
    ruleNodeStateEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeStateEntity2.setRuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeStateEntity2.setStateData("MD");
    ruleNodeStateEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(ruleNodeStateEntity, ruleNodeStateEntity2);
    int expectedHashCodeResult = ruleNodeStateEntity.hashCode();
    assertEquals(expectedHashCodeResult, ruleNodeStateEntity2.hashCode());
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
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RuleNodeStateEntity.equals(Object)",
    "int RuleNodeStateEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RuleNodeStateEntity ruleNodeStateEntity = new RuleNodeStateEntity();
    ruleNodeStateEntity.setCreatedTime(1L);
    ruleNodeStateEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeStateEntity.setEntityType("Entity Type");
    ruleNodeStateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeStateEntity.setRuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeStateEntity.setStateData("MD");
    ruleNodeStateEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RuleNodeStateEntity.equals(Object)",
    "int RuleNodeStateEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RuleNodeStateEntity ruleNodeStateEntity = new RuleNodeStateEntity();
    ruleNodeStateEntity.setCreatedTime(3L);
    ruleNodeStateEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeStateEntity.setEntityType("Entity Type");
    ruleNodeStateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeStateEntity.setRuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeStateEntity.setStateData("MD");
    ruleNodeStateEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RuleNodeStateEntity ruleNodeStateEntity2 = new RuleNodeStateEntity();
    ruleNodeStateEntity2.setCreatedTime(1L);
    ruleNodeStateEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeStateEntity2.setEntityType("Entity Type");
    ruleNodeStateEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeStateEntity2.setRuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeStateEntity2.setStateData("MD");
    ruleNodeStateEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RuleNodeStateEntity.equals(Object)",
    "int RuleNodeStateEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RuleNodeStateEntity ruleNodeStateEntity = new RuleNodeStateEntity();
    ruleNodeStateEntity.setCreatedTime(1L);
    ruleNodeStateEntity.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity.setEntityType("Entity Type");
    ruleNodeStateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeStateEntity.setRuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeStateEntity.setStateData("MD");
    ruleNodeStateEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RuleNodeStateEntity ruleNodeStateEntity2 = new RuleNodeStateEntity();
    ruleNodeStateEntity2.setCreatedTime(1L);
    ruleNodeStateEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeStateEntity2.setEntityType("Entity Type");
    ruleNodeStateEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeStateEntity2.setRuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeStateEntity2.setStateData("MD");
    ruleNodeStateEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RuleNodeStateEntity.equals(Object)",
    "int RuleNodeStateEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RuleNodeStateEntity ruleNodeStateEntity = new RuleNodeStateEntity();
    ruleNodeStateEntity.setCreatedTime(1L);
    ruleNodeStateEntity.setEntityId(null);
    ruleNodeStateEntity.setEntityType("Entity Type");
    ruleNodeStateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeStateEntity.setRuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeStateEntity.setStateData("MD");
    ruleNodeStateEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RuleNodeStateEntity ruleNodeStateEntity2 = new RuleNodeStateEntity();
    ruleNodeStateEntity2.setCreatedTime(1L);
    ruleNodeStateEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeStateEntity2.setEntityType("Entity Type");
    ruleNodeStateEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeStateEntity2.setRuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeStateEntity2.setStateData("MD");
    ruleNodeStateEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RuleNodeStateEntity.equals(Object)",
    "int RuleNodeStateEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    RuleNodeStateEntity ruleNodeStateEntity = new RuleNodeStateEntity();
    ruleNodeStateEntity.setCreatedTime(1L);
    ruleNodeStateEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeStateEntity.setEntityType("MD");
    ruleNodeStateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeStateEntity.setRuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeStateEntity.setStateData("MD");
    ruleNodeStateEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RuleNodeStateEntity ruleNodeStateEntity2 = new RuleNodeStateEntity();
    ruleNodeStateEntity2.setCreatedTime(1L);
    ruleNodeStateEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeStateEntity2.setEntityType("Entity Type");
    ruleNodeStateEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeStateEntity2.setRuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeStateEntity2.setStateData("MD");
    ruleNodeStateEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RuleNodeStateEntity.equals(Object)",
    "int RuleNodeStateEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    RuleNodeStateEntity ruleNodeStateEntity = new RuleNodeStateEntity();
    ruleNodeStateEntity.setCreatedTime(1L);
    ruleNodeStateEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeStateEntity.setEntityType(null);
    ruleNodeStateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeStateEntity.setRuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeStateEntity.setStateData("MD");
    ruleNodeStateEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RuleNodeStateEntity ruleNodeStateEntity2 = new RuleNodeStateEntity();
    ruleNodeStateEntity2.setCreatedTime(1L);
    ruleNodeStateEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeStateEntity2.setEntityType("Entity Type");
    ruleNodeStateEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeStateEntity2.setRuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeStateEntity2.setStateData("MD");
    ruleNodeStateEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RuleNodeStateEntity.equals(Object)",
    "int RuleNodeStateEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    RuleNodeStateEntity ruleNodeStateEntity = new RuleNodeStateEntity();
    ruleNodeStateEntity.setCreatedTime(1L);
    ruleNodeStateEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeStateEntity.setEntityType("Entity Type");
    ruleNodeStateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeStateEntity.setRuleNodeId(ModelConstants.NULL_UUID);
    ruleNodeStateEntity.setStateData("MD");
    ruleNodeStateEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RuleNodeStateEntity ruleNodeStateEntity2 = new RuleNodeStateEntity();
    ruleNodeStateEntity2.setCreatedTime(1L);
    ruleNodeStateEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeStateEntity2.setEntityType("Entity Type");
    ruleNodeStateEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeStateEntity2.setRuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeStateEntity2.setStateData("MD");
    ruleNodeStateEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RuleNodeStateEntity.equals(Object)",
    "int RuleNodeStateEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    RuleNodeStateEntity ruleNodeStateEntity = new RuleNodeStateEntity();
    ruleNodeStateEntity.setCreatedTime(1L);
    ruleNodeStateEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeStateEntity.setEntityType("Entity Type");
    ruleNodeStateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeStateEntity.setRuleNodeId(null);
    ruleNodeStateEntity.setStateData("MD");
    ruleNodeStateEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RuleNodeStateEntity ruleNodeStateEntity2 = new RuleNodeStateEntity();
    ruleNodeStateEntity2.setCreatedTime(1L);
    ruleNodeStateEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeStateEntity2.setEntityType("Entity Type");
    ruleNodeStateEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeStateEntity2.setRuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeStateEntity2.setStateData("MD");
    ruleNodeStateEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RuleNodeStateEntity.equals(Object)",
    "int RuleNodeStateEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    RuleNodeStateEntity ruleNodeStateEntity = new RuleNodeStateEntity();
    ruleNodeStateEntity.setCreatedTime(1L);
    ruleNodeStateEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeStateEntity.setEntityType("Entity Type");
    ruleNodeStateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeStateEntity.setRuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeStateEntity.setStateData("Entity Type");
    ruleNodeStateEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RuleNodeStateEntity ruleNodeStateEntity2 = new RuleNodeStateEntity();
    ruleNodeStateEntity2.setCreatedTime(1L);
    ruleNodeStateEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeStateEntity2.setEntityType("Entity Type");
    ruleNodeStateEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeStateEntity2.setRuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeStateEntity2.setStateData("MD");
    ruleNodeStateEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RuleNodeStateEntity.equals(Object)",
    "int RuleNodeStateEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    RuleNodeStateEntity ruleNodeStateEntity = new RuleNodeStateEntity();
    ruleNodeStateEntity.setCreatedTime(1L);
    ruleNodeStateEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeStateEntity.setEntityType("Entity Type");
    ruleNodeStateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeStateEntity.setRuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeStateEntity.setStateData(null);
    ruleNodeStateEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RuleNodeStateEntity ruleNodeStateEntity2 = new RuleNodeStateEntity();
    ruleNodeStateEntity2.setCreatedTime(1L);
    ruleNodeStateEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeStateEntity2.setEntityType("Entity Type");
    ruleNodeStateEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeStateEntity2.setRuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeStateEntity2.setStateData("MD");
    ruleNodeStateEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RuleNodeStateEntity.equals(Object)",
    "int RuleNodeStateEntity.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    RuleNodeStateEntity ruleNodeStateEntity = new RuleNodeStateEntity();
    ruleNodeStateEntity.setCreatedTime(1L);
    ruleNodeStateEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeStateEntity.setEntityType("Entity Type");
    ruleNodeStateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeStateEntity.setRuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeStateEntity.setStateData("MD");
    ruleNodeStateEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RuleNodeStateEntity.equals(Object)",
    "int RuleNodeStateEntity.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    RuleNodeStateEntity ruleNodeStateEntity = new RuleNodeStateEntity();
    ruleNodeStateEntity.setCreatedTime(1L);
    ruleNodeStateEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeStateEntity.setEntityType("Entity Type");
    ruleNodeStateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeStateEntity.setRuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeStateEntity.setStateData("MD");
    ruleNodeStateEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
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
  void testGettersAndSetters() {
    // Arrange and Act
    RuleNodeStateEntity actualRuleNodeStateEntity = new RuleNodeStateEntity();
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualRuleNodeStateEntity.setEntityId(entityId);
    actualRuleNodeStateEntity.setEntityType("Entity Type");
    UUID ruleNodeId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualRuleNodeStateEntity.setRuleNodeId(ruleNodeId);
    actualRuleNodeStateEntity.setStateData("MD");
    String actualToStringResult = actualRuleNodeStateEntity.toString();
    UUID actualEntityId = actualRuleNodeStateEntity.getEntityId();
    String actualEntityType = actualRuleNodeStateEntity.getEntityType();
    UUID actualRuleNodeId = actualRuleNodeStateEntity.getRuleNodeId();
    String actualStateData = actualRuleNodeStateEntity.getStateData();

    // Assert
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualEntityId.toString());
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualRuleNodeId.toString());
    assertEquals("Entity Type", actualEntityType);
    assertEquals("MD", actualStateData);
    assertEquals(
        "RuleNodeStateEntity(ruleNodeId=784f394c-42b6-435a-983c-b7beff2784f9, entityType=Entity Type,"
            + " entityId=784f394c-42b6-435a-983c-b7beff2784f9, stateData=MD)",
        actualToStringResult);
    assertNull(actualRuleNodeStateEntity.getId());
    assertNull(actualRuleNodeStateEntity.getUuid());
    assertEquals(0L, actualRuleNodeStateEntity.getCreatedTime());
    assertSame(entityId, actualEntityId);
    assertSame(ruleNodeId, actualRuleNodeId);
  }

  /**
   * Test {@link RuleNodeStateEntity#RuleNodeStateEntity(RuleNodeState)}.
   *
   * <p>Method under test: {@link RuleNodeStateEntity#RuleNodeStateEntity(RuleNodeState)}
   */
  @Test
  @DisplayName("Test new RuleNodeStateEntity(RuleNodeState)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RuleNodeStateEntity.<init>(RuleNodeState)"})
  void testNewRuleNodeStateEntity() {
    // Arrange
    RuleNodeState ruleNodeState = new RuleNodeState((RuleNodeStateId) null);
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ruleNodeState.setRuleNodeId(new RuleNodeId(id));
    ruleNodeState.setEntityId(ModelConstants.SYSTEM_TENANT);

    // Act
    RuleNodeStateEntity actualRuleNodeStateEntity = new RuleNodeStateEntity(ruleNodeState);

    // Assert
    UUID ruleNodeId = actualRuleNodeStateEntity.getRuleNodeId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", ruleNodeId.toString());
    assertEquals("TENANT", actualRuleNodeStateEntity.getEntityType());
    assertEquals(0L, actualRuleNodeStateEntity.getCreatedTime());
    assertSame(id, ruleNodeId);
  }

  /**
   * Test {@link RuleNodeStateEntity#RuleNodeStateEntity(RuleNodeState)}.
   *
   * <p>Method under test: {@link RuleNodeStateEntity#RuleNodeStateEntity(RuleNodeState)}
   */
  @Test
  @DisplayName("Test new RuleNodeStateEntity(RuleNodeState)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RuleNodeStateEntity.<init>(RuleNodeState)"})
  void testNewRuleNodeStateEntity2() {
    // Arrange
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    RuleNodeState ruleNodeState = new RuleNodeState(new RuleNodeStateId(id));
    ruleNodeState.setRuleNodeId(
        new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    ruleNodeState.setEntityId(ModelConstants.SYSTEM_TENANT);

    // Act
    RuleNodeStateEntity actualRuleNodeStateEntity = new RuleNodeStateEntity(ruleNodeState);

    // Assert
    UUID id2 = actualRuleNodeStateEntity.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id2.toString());
    assertSame(id, id2);
    assertSame(id, actualRuleNodeStateEntity.getUuid());
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
  @DisplayName(
      "Test new RuleNodeStateEntity(RuleNodeState); given NULL_CUSTOMER_ID; then return EntityType is 'CUSTOMER'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RuleNodeStateEntity.<init>(RuleNodeState)"})
  void testNewRuleNodeStateEntity_givenNull_customer_id_thenReturnEntityTypeIsCustomer() {
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
  @DisplayName(
      "Test new RuleNodeStateEntity(RuleNodeState); given one; then return CreatedTime is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RuleNodeStateEntity.<init>(RuleNodeState)"})
  void testNewRuleNodeStateEntity_givenOne_thenReturnCreatedTimeIsOne() {
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
  @DisplayName(
      "Test new RuleNodeStateEntity(RuleNodeState); when RuleNodeState() EntityId is SYSTEM_TENANT")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RuleNodeStateEntity.<init>(RuleNodeState)"})
  void testNewRuleNodeStateEntity_whenRuleNodeStateEntityIdIsSystem_tenant() {
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

  /**
   * Test {@link RuleNodeStateEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link RuleNodeState#RuleNodeState()} EntityId is {@link
   *       ModelConstants#SYSTEM_TENANT}.
   *   <li>Then EntityId return {@link TenantId}.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeStateEntity#toData()}
   */
  @Test
  @DisplayName(
      "Test toData(); given RuleNodeState() EntityId is SYSTEM_TENANT; then EntityId return TenantId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuleNodeState RuleNodeStateEntity.toData()"})
  void testToData_givenRuleNodeStateEntityIdIsSystem_tenant_thenEntityIdReturnTenantId() {
    // Arrange
    RuleNodeState ruleNodeState = new RuleNodeState();
    ruleNodeState.setEntityId(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    EntityId entityId = new RuleNodeStateEntity(ruleNodeState).toData().getEntityId();
    assertTrue(entityId instanceof TenantId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.getId().toString());
    assertEquals(EntityType.TENANT, entityId.getEntityType());
    assertTrue(entityId.isNullUid());
    assertTrue(((TenantId) entityId).isSysTenantId());
  }

  /**
   * Test {@link RuleNodeStateEntity#toData()}.
   *
   * <ul>
   *   <li>Then EntityId return {@link AlarmId}.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeStateEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); then EntityId return AlarmId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuleNodeState RuleNodeStateEntity.toData()"})
  void testToData_thenEntityIdReturnAlarmId() {
    // Arrange
    RuleNodeState ruleNodeState = new RuleNodeState();
    ruleNodeState.setEntityId(new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    RuleNodeState actualToDataResult = new RuleNodeStateEntity(ruleNodeState).toData();

    // Assert
    EntityId entityId = actualToDataResult.getEntityId();
    assertTrue(entityId instanceof AlarmId);
    assertNull(actualToDataResult.getRuleNodeId().getId());
    assertEquals(EntityType.ALARM, entityId.getEntityType());
  }

  /**
   * Test {@link RuleNodeStateEntity#toData()}.
   *
   * <ul>
   *   <li>Then EntityId return {@link ApiUsageStateId}.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeStateEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); then EntityId return ApiUsageStateId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuleNodeState RuleNodeStateEntity.toData()"})
  void testToData_thenEntityIdReturnApiUsageStateId() {
    // Arrange
    RuleNodeState ruleNodeState = new RuleNodeState();
    ruleNodeState.setEntityId(
        new ApiUsageStateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    RuleNodeStateEntity ruleNodeStateEntity = new RuleNodeStateEntity(ruleNodeState);
    UUID ruleNodeId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ruleNodeStateEntity.setRuleNodeId(ruleNodeId);

    // Act
    RuleNodeState actualToDataResult = ruleNodeStateEntity.toData();

    // Assert
    EntityId entityId = actualToDataResult.getEntityId();
    assertTrue(entityId instanceof ApiUsageStateId);
    UUID id = actualToDataResult.getRuleNodeId().getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.API_USAGE_STATE, entityId.getEntityType());
    assertSame(ruleNodeId, id);
  }

  /**
   * Test {@link RuleNodeStateEntity#toData()}.
   *
   * <ul>
   *   <li>Then EntityId return {@link AssetId}.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeStateEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); then EntityId return AssetId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuleNodeState RuleNodeStateEntity.toData()"})
  void testToData_thenEntityIdReturnAssetId() {
    // Arrange
    RuleNodeState ruleNodeState = new RuleNodeState();
    ruleNodeState.setEntityId(new AssetId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    RuleNodeStateEntity ruleNodeStateEntity = new RuleNodeStateEntity(ruleNodeState);
    UUID ruleNodeId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ruleNodeStateEntity.setRuleNodeId(ruleNodeId);

    // Act
    RuleNodeState actualToDataResult = ruleNodeStateEntity.toData();

    // Assert
    EntityId entityId = actualToDataResult.getEntityId();
    assertTrue(entityId instanceof AssetId);
    UUID id = actualToDataResult.getRuleNodeId().getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.ASSET, entityId.getEntityType());
    assertSame(ruleNodeId, id);
  }

  /**
   * Test {@link RuleNodeStateEntity#toData()}.
   *
   * <ul>
   *   <li>Then EntityId return {@link AssetProfileId}.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeStateEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); then EntityId return AssetProfileId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuleNodeState RuleNodeStateEntity.toData()"})
  void testToData_thenEntityIdReturnAssetProfileId() {
    // Arrange
    RuleNodeState ruleNodeState = new RuleNodeState();
    ruleNodeState.setEntityId(
        new AssetProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    RuleNodeStateEntity ruleNodeStateEntity = new RuleNodeStateEntity(ruleNodeState);
    UUID ruleNodeId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ruleNodeStateEntity.setRuleNodeId(ruleNodeId);

    // Act
    RuleNodeState actualToDataResult = ruleNodeStateEntity.toData();

    // Assert
    EntityId entityId = actualToDataResult.getEntityId();
    assertTrue(entityId instanceof AssetProfileId);
    UUID id = actualToDataResult.getRuleNodeId().getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.ASSET_PROFILE, entityId.getEntityType());
    assertSame(ruleNodeId, id);
  }

  /**
   * Test {@link RuleNodeStateEntity#toData()}.
   *
   * <ul>
   *   <li>Then EntityId return {@link CustomerId}.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeStateEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); then EntityId return CustomerId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuleNodeState RuleNodeStateEntity.toData()"})
  void testToData_thenEntityIdReturnCustomerId() {
    // Arrange
    RuleNodeState ruleNodeState = new RuleNodeState();
    ruleNodeState.setEntityId(BaseEntityService.NULL_CUSTOMER_ID);

    // Act and Assert
    EntityId entityId = new RuleNodeStateEntity(ruleNodeState).toData().getEntityId();
    assertTrue(entityId instanceof CustomerId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.getId().toString());
    assertEquals(EntityType.CUSTOMER, entityId.getEntityType());
    assertTrue(entityId.isNullUid());
  }

  /**
   * Test {@link RuleNodeStateEntity#toData()}.
   *
   * <ul>
   *   <li>Then EntityId return {@link DashboardId}.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeStateEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); then EntityId return DashboardId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuleNodeState RuleNodeStateEntity.toData()"})
  void testToData_thenEntityIdReturnDashboardId() {
    // Arrange
    RuleNodeState ruleNodeState = new RuleNodeState();
    ruleNodeState.setEntityId(
        new DashboardId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    RuleNodeStateEntity ruleNodeStateEntity = new RuleNodeStateEntity(ruleNodeState);
    UUID ruleNodeId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ruleNodeStateEntity.setRuleNodeId(ruleNodeId);

    // Act
    RuleNodeState actualToDataResult = ruleNodeStateEntity.toData();

    // Assert
    EntityId entityId = actualToDataResult.getEntityId();
    assertTrue(entityId instanceof DashboardId);
    UUID id = actualToDataResult.getRuleNodeId().getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.DASHBOARD, entityId.getEntityType());
    assertSame(ruleNodeId, id);
  }
}
