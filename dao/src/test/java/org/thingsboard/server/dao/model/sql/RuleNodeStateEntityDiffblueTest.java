package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.dao.model.ModelConstants;

public class RuleNodeStateEntityDiffblueTest {
  /**
   * Test {@link RuleNodeStateEntity#equals(Object)}, and {@link RuleNodeStateEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RuleNodeStateEntity#equals(Object)}
   *   <li>{@link RuleNodeStateEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RuleNodeStateEntity.equals(Object)", "int RuleNodeStateEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
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
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RuleNodeStateEntity#equals(Object)}
   *   <li>{@link RuleNodeStateEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RuleNodeStateEntity.equals(Object)", "int RuleNodeStateEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
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
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RuleNodeStateEntity#equals(Object)}
   *   <li>{@link RuleNodeStateEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RuleNodeStateEntity.equals(Object)", "int RuleNodeStateEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
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
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RuleNodeStateEntity#equals(Object)}
   *   <li>{@link RuleNodeStateEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RuleNodeStateEntity.equals(Object)", "int RuleNodeStateEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeStateEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RuleNodeStateEntity.equals(Object)", "int RuleNodeStateEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeStateEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RuleNodeStateEntity.equals(Object)", "int RuleNodeStateEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeStateEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RuleNodeStateEntity.equals(Object)", "int RuleNodeStateEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeStateEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RuleNodeStateEntity.equals(Object)", "int RuleNodeStateEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeStateEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RuleNodeStateEntity.equals(Object)", "int RuleNodeStateEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeStateEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RuleNodeStateEntity.equals(Object)", "int RuleNodeStateEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeStateEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RuleNodeStateEntity.equals(Object)", "int RuleNodeStateEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeStateEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RuleNodeStateEntity.equals(Object)", "int RuleNodeStateEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeStateEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RuleNodeStateEntity.equals(Object)", "int RuleNodeStateEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
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
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeStateEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RuleNodeStateEntity.equals(Object)", "int RuleNodeStateEntity.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
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
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeStateEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RuleNodeStateEntity.equals(Object)", "int RuleNodeStateEntity.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
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
   * <p>
   * Methods under test:
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RuleNodeStateEntity.<init>()", "UUID RuleNodeStateEntity.getEntityId()",
      "String RuleNodeStateEntity.getEntityType()", "UUID RuleNodeStateEntity.getRuleNodeId()",
      "String RuleNodeStateEntity.getStateData()", "void RuleNodeStateEntity.setEntityId(UUID)",
      "void RuleNodeStateEntity.setEntityType(String)", "void RuleNodeStateEntity.setRuleNodeId(UUID)",
      "void RuleNodeStateEntity.setStateData(String)", "String RuleNodeStateEntity.toString()"})
  public void testGettersAndSetters() {
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
    assertEquals("RuleNodeStateEntity(ruleNodeId=784f394c-42b6-435a-983c-b7beff2784f9, entityType=Entity Type,"
        + " entityId=784f394c-42b6-435a-983c-b7beff2784f9, stateData=MD)", actualToStringResult);
    assertNull(actualRuleNodeStateEntity.getId());
    assertNull(actualRuleNodeStateEntity.getUuid());
    assertEquals(0L, actualRuleNodeStateEntity.getCreatedTime());
    assertSame(entityId, actualEntityId);
    assertSame(ruleNodeId, actualRuleNodeId);
  }
}
