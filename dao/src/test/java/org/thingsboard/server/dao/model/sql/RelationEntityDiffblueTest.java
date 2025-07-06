package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.relation.EntityRelation;
import org.thingsboard.server.common.data.relation.RelationTypeGroup;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;

public class RelationEntityDiffblueTest {
  /**
   * Test {@link RelationEntity#equals(Object)}, and {@link RelationEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RelationEntity#equals(Object)}
   *   <li>{@link RelationEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RelationEntity.equals(Object)", "int RelationEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RelationEntity relationEntity = new RelationEntity();
    relationEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    relationEntity.setFromId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    relationEntity.setFromType("jane.doe@example.org");
    relationEntity.setRelationType("Relation Type");
    relationEntity.setRelationTypeGroup("Relation Type Group");
    relationEntity.setToId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    relationEntity.setToType("To Type");
    relationEntity.setVersion(1L);

    RelationEntity relationEntity2 = new RelationEntity();
    relationEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    relationEntity2.setFromId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    relationEntity2.setFromType("jane.doe@example.org");
    relationEntity2.setRelationType("Relation Type");
    relationEntity2.setRelationTypeGroup("Relation Type Group");
    relationEntity2.setToId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    relationEntity2.setToType("To Type");
    relationEntity2.setVersion(1L);

    // Act and Assert
    assertEquals(relationEntity, relationEntity2);
    int expectedHashCodeResult = relationEntity.hashCode();
    assertEquals(expectedHashCodeResult, relationEntity2.hashCode());
  }

  /**
   * Test {@link RelationEntity#equals(Object)}, and {@link RelationEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RelationEntity#equals(Object)}
   *   <li>{@link RelationEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RelationEntity.equals(Object)", "int RelationEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    RelationEntity relationEntity = new RelationEntity();
    relationEntity.setAdditionalInfo(null);
    relationEntity.setFromId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    relationEntity.setFromType("jane.doe@example.org");
    relationEntity.setRelationType("Relation Type");
    relationEntity.setRelationTypeGroup("Relation Type Group");
    relationEntity.setToId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    relationEntity.setToType("To Type");
    relationEntity.setVersion(1L);

    RelationEntity relationEntity2 = new RelationEntity();
    relationEntity2.setAdditionalInfo(null);
    relationEntity2.setFromId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    relationEntity2.setFromType("jane.doe@example.org");
    relationEntity2.setRelationType("Relation Type");
    relationEntity2.setRelationTypeGroup("Relation Type Group");
    relationEntity2.setToId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    relationEntity2.setToType("To Type");
    relationEntity2.setVersion(1L);

    // Act and Assert
    assertEquals(relationEntity, relationEntity2);
    int expectedHashCodeResult = relationEntity.hashCode();
    assertEquals(expectedHashCodeResult, relationEntity2.hashCode());
  }

  /**
   * Test {@link RelationEntity#equals(Object)}, and {@link RelationEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RelationEntity#equals(Object)}
   *   <li>{@link RelationEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RelationEntity.equals(Object)", "int RelationEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    RelationEntity relationEntity = new RelationEntity();
    relationEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    relationEntity.setFromId(null);
    relationEntity.setFromType("jane.doe@example.org");
    relationEntity.setRelationType("Relation Type");
    relationEntity.setRelationTypeGroup("Relation Type Group");
    relationEntity.setToId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    relationEntity.setToType("To Type");
    relationEntity.setVersion(1L);

    RelationEntity relationEntity2 = new RelationEntity();
    relationEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    relationEntity2.setFromId(null);
    relationEntity2.setFromType("jane.doe@example.org");
    relationEntity2.setRelationType("Relation Type");
    relationEntity2.setRelationTypeGroup("Relation Type Group");
    relationEntity2.setToId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    relationEntity2.setToType("To Type");
    relationEntity2.setVersion(1L);

    // Act and Assert
    assertEquals(relationEntity, relationEntity2);
    int expectedHashCodeResult = relationEntity.hashCode();
    assertEquals(expectedHashCodeResult, relationEntity2.hashCode());
  }

  /**
   * Test {@link RelationEntity#equals(Object)}, and {@link RelationEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RelationEntity#equals(Object)}
   *   <li>{@link RelationEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RelationEntity.equals(Object)", "int RelationEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    RelationEntity relationEntity = new RelationEntity();
    relationEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    relationEntity.setFromId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    relationEntity.setFromType(null);
    relationEntity.setRelationType("Relation Type");
    relationEntity.setRelationTypeGroup("Relation Type Group");
    relationEntity.setToId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    relationEntity.setToType("To Type");
    relationEntity.setVersion(1L);

    RelationEntity relationEntity2 = new RelationEntity();
    relationEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    relationEntity2.setFromId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    relationEntity2.setFromType(null);
    relationEntity2.setRelationType("Relation Type");
    relationEntity2.setRelationTypeGroup("Relation Type Group");
    relationEntity2.setToId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    relationEntity2.setToType("To Type");
    relationEntity2.setVersion(1L);

    // Act and Assert
    assertEquals(relationEntity, relationEntity2);
    int expectedHashCodeResult = relationEntity.hashCode();
    assertEquals(expectedHashCodeResult, relationEntity2.hashCode());
  }

  /**
   * Test {@link RelationEntity#equals(Object)}, and {@link RelationEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RelationEntity#equals(Object)}
   *   <li>{@link RelationEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RelationEntity.equals(Object)", "int RelationEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RelationEntity relationEntity = new RelationEntity();
    relationEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    relationEntity.setFromId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    relationEntity.setFromType("jane.doe@example.org");
    relationEntity.setRelationType("Relation Type");
    relationEntity.setRelationTypeGroup("Relation Type Group");
    relationEntity.setToId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    relationEntity.setToType("To Type");
    relationEntity.setVersion(1L);

    // Act and Assert
    assertEquals(relationEntity, relationEntity);
    int expectedHashCodeResult = relationEntity.hashCode();
    assertEquals(expectedHashCodeResult, relationEntity.hashCode());
  }

  /**
   * Test {@link RelationEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelationEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RelationEntity.equals(Object)", "int RelationEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RelationEntity relationEntity = new RelationEntity();
    relationEntity.setAdditionalInfo(DoubleNode.valueOf(10.0d));
    relationEntity.setFromId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    relationEntity.setFromType("jane.doe@example.org");
    relationEntity.setRelationType("Relation Type");
    relationEntity.setRelationTypeGroup("Relation Type Group");
    relationEntity.setToId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    relationEntity.setToType("To Type");
    relationEntity.setVersion(1L);

    RelationEntity relationEntity2 = new RelationEntity();
    relationEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    relationEntity2.setFromId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    relationEntity2.setFromType("jane.doe@example.org");
    relationEntity2.setRelationType("Relation Type");
    relationEntity2.setRelationTypeGroup("Relation Type Group");
    relationEntity2.setToId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    relationEntity2.setToType("To Type");
    relationEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(relationEntity, relationEntity2);
  }

  /**
   * Test {@link RelationEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelationEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RelationEntity.equals(Object)", "int RelationEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RelationEntity relationEntity = new RelationEntity();
    relationEntity.setAdditionalInfo(null);
    relationEntity.setFromId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    relationEntity.setFromType("jane.doe@example.org");
    relationEntity.setRelationType("Relation Type");
    relationEntity.setRelationTypeGroup("Relation Type Group");
    relationEntity.setToId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    relationEntity.setToType("To Type");
    relationEntity.setVersion(1L);

    RelationEntity relationEntity2 = new RelationEntity();
    relationEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    relationEntity2.setFromId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    relationEntity2.setFromType("jane.doe@example.org");
    relationEntity2.setRelationType("Relation Type");
    relationEntity2.setRelationTypeGroup("Relation Type Group");
    relationEntity2.setToId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    relationEntity2.setToType("To Type");
    relationEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(relationEntity, relationEntity2);
  }

  /**
   * Test {@link RelationEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelationEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RelationEntity.equals(Object)", "int RelationEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RelationEntity relationEntity = new RelationEntity();
    relationEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    relationEntity.setFromId(ModelConstants.NULL_UUID);
    relationEntity.setFromType("jane.doe@example.org");
    relationEntity.setRelationType("Relation Type");
    relationEntity.setRelationTypeGroup("Relation Type Group");
    relationEntity.setToId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    relationEntity.setToType("To Type");
    relationEntity.setVersion(1L);

    RelationEntity relationEntity2 = new RelationEntity();
    relationEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    relationEntity2.setFromId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    relationEntity2.setFromType("jane.doe@example.org");
    relationEntity2.setRelationType("Relation Type");
    relationEntity2.setRelationTypeGroup("Relation Type Group");
    relationEntity2.setToId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    relationEntity2.setToType("To Type");
    relationEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(relationEntity, relationEntity2);
  }

  /**
   * Test {@link RelationEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelationEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RelationEntity.equals(Object)", "int RelationEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    RelationEntity relationEntity = new RelationEntity();
    relationEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    relationEntity.setFromId(null);
    relationEntity.setFromType("jane.doe@example.org");
    relationEntity.setRelationType("Relation Type");
    relationEntity.setRelationTypeGroup("Relation Type Group");
    relationEntity.setToId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    relationEntity.setToType("To Type");
    relationEntity.setVersion(1L);

    RelationEntity relationEntity2 = new RelationEntity();
    relationEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    relationEntity2.setFromId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    relationEntity2.setFromType("jane.doe@example.org");
    relationEntity2.setRelationType("Relation Type");
    relationEntity2.setRelationTypeGroup("Relation Type Group");
    relationEntity2.setToId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    relationEntity2.setToType("To Type");
    relationEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(relationEntity, relationEntity2);
  }

  /**
   * Test {@link RelationEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelationEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RelationEntity.equals(Object)", "int RelationEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    RelationEntity relationEntity = new RelationEntity();
    relationEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    relationEntity.setFromId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    relationEntity.setFromType("To Type");
    relationEntity.setRelationType("Relation Type");
    relationEntity.setRelationTypeGroup("Relation Type Group");
    relationEntity.setToId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    relationEntity.setToType("To Type");
    relationEntity.setVersion(1L);

    RelationEntity relationEntity2 = new RelationEntity();
    relationEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    relationEntity2.setFromId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    relationEntity2.setFromType("jane.doe@example.org");
    relationEntity2.setRelationType("Relation Type");
    relationEntity2.setRelationTypeGroup("Relation Type Group");
    relationEntity2.setToId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    relationEntity2.setToType("To Type");
    relationEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(relationEntity, relationEntity2);
  }

  /**
   * Test {@link RelationEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelationEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RelationEntity.equals(Object)", "int RelationEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    RelationEntity relationEntity = new RelationEntity();
    relationEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    relationEntity.setFromId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    relationEntity.setFromType(null);
    relationEntity.setRelationType("Relation Type");
    relationEntity.setRelationTypeGroup("Relation Type Group");
    relationEntity.setToId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    relationEntity.setToType("To Type");
    relationEntity.setVersion(1L);

    RelationEntity relationEntity2 = new RelationEntity();
    relationEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    relationEntity2.setFromId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    relationEntity2.setFromType("jane.doe@example.org");
    relationEntity2.setRelationType("Relation Type");
    relationEntity2.setRelationTypeGroup("Relation Type Group");
    relationEntity2.setToId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    relationEntity2.setToType("To Type");
    relationEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(relationEntity, relationEntity2);
  }

  /**
   * Test {@link RelationEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelationEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RelationEntity.equals(Object)", "int RelationEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    RelationEntity relationEntity = new RelationEntity();
    relationEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    relationEntity.setFromId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    relationEntity.setFromType("jane.doe@example.org");
    relationEntity.setRelationType("jane.doe@example.org");
    relationEntity.setRelationTypeGroup("Relation Type Group");
    relationEntity.setToId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    relationEntity.setToType("To Type");
    relationEntity.setVersion(1L);

    RelationEntity relationEntity2 = new RelationEntity();
    relationEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    relationEntity2.setFromId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    relationEntity2.setFromType("jane.doe@example.org");
    relationEntity2.setRelationType("Relation Type");
    relationEntity2.setRelationTypeGroup("Relation Type Group");
    relationEntity2.setToId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    relationEntity2.setToType("To Type");
    relationEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(relationEntity, relationEntity2);
  }

  /**
   * Test {@link RelationEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelationEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RelationEntity.equals(Object)", "int RelationEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    RelationEntity relationEntity = new RelationEntity();
    relationEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    relationEntity.setFromId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    relationEntity.setFromType("jane.doe@example.org");
    relationEntity.setRelationType(null);
    relationEntity.setRelationTypeGroup("Relation Type Group");
    relationEntity.setToId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    relationEntity.setToType("To Type");
    relationEntity.setVersion(1L);

    RelationEntity relationEntity2 = new RelationEntity();
    relationEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    relationEntity2.setFromId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    relationEntity2.setFromType("jane.doe@example.org");
    relationEntity2.setRelationType("Relation Type");
    relationEntity2.setRelationTypeGroup("Relation Type Group");
    relationEntity2.setToId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    relationEntity2.setToType("To Type");
    relationEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(relationEntity, relationEntity2);
  }

  /**
   * Test {@link RelationEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelationEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RelationEntity.equals(Object)", "int RelationEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    RelationEntity relationEntity = new RelationEntity();
    relationEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    relationEntity.setFromId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    relationEntity.setFromType("jane.doe@example.org");
    relationEntity.setRelationType("Relation Type");
    relationEntity.setRelationTypeGroup("jane.doe@example.org");
    relationEntity.setToId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    relationEntity.setToType("To Type");
    relationEntity.setVersion(1L);

    RelationEntity relationEntity2 = new RelationEntity();
    relationEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    relationEntity2.setFromId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    relationEntity2.setFromType("jane.doe@example.org");
    relationEntity2.setRelationType("Relation Type");
    relationEntity2.setRelationTypeGroup("Relation Type Group");
    relationEntity2.setToId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    relationEntity2.setToType("To Type");
    relationEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(relationEntity, relationEntity2);
  }

  /**
   * Test {@link RelationEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelationEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RelationEntity.equals(Object)", "int RelationEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    RelationEntity relationEntity = new RelationEntity();
    relationEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    relationEntity.setFromId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    relationEntity.setFromType("jane.doe@example.org");
    relationEntity.setRelationType("Relation Type");
    relationEntity.setRelationTypeGroup(null);
    relationEntity.setToId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    relationEntity.setToType("To Type");
    relationEntity.setVersion(1L);

    RelationEntity relationEntity2 = new RelationEntity();
    relationEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    relationEntity2.setFromId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    relationEntity2.setFromType("jane.doe@example.org");
    relationEntity2.setRelationType("Relation Type");
    relationEntity2.setRelationTypeGroup("Relation Type Group");
    relationEntity2.setToId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    relationEntity2.setToType("To Type");
    relationEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(relationEntity, relationEntity2);
  }

  /**
   * Test {@link RelationEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelationEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RelationEntity.equals(Object)", "int RelationEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    RelationEntity relationEntity = new RelationEntity();
    relationEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    relationEntity.setFromId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    relationEntity.setFromType("jane.doe@example.org");
    relationEntity.setRelationType("Relation Type");
    relationEntity.setRelationTypeGroup("Relation Type Group");
    relationEntity.setToId(ModelConstants.NULL_UUID);
    relationEntity.setToType("To Type");
    relationEntity.setVersion(1L);

    RelationEntity relationEntity2 = new RelationEntity();
    relationEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    relationEntity2.setFromId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    relationEntity2.setFromType("jane.doe@example.org");
    relationEntity2.setRelationType("Relation Type");
    relationEntity2.setRelationTypeGroup("Relation Type Group");
    relationEntity2.setToId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    relationEntity2.setToType("To Type");
    relationEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(relationEntity, relationEntity2);
  }

  /**
   * Test {@link RelationEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelationEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RelationEntity.equals(Object)", "int RelationEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    RelationEntity relationEntity = new RelationEntity();
    relationEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    relationEntity.setFromId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    relationEntity.setFromType("jane.doe@example.org");
    relationEntity.setRelationType("Relation Type");
    relationEntity.setRelationTypeGroup("Relation Type Group");
    relationEntity.setToId(null);
    relationEntity.setToType("To Type");
    relationEntity.setVersion(1L);

    RelationEntity relationEntity2 = new RelationEntity();
    relationEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    relationEntity2.setFromId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    relationEntity2.setFromType("jane.doe@example.org");
    relationEntity2.setRelationType("Relation Type");
    relationEntity2.setRelationTypeGroup("Relation Type Group");
    relationEntity2.setToId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    relationEntity2.setToType("To Type");
    relationEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(relationEntity, relationEntity2);
  }

  /**
   * Test {@link RelationEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelationEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RelationEntity.equals(Object)", "int RelationEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    RelationEntity relationEntity = new RelationEntity();
    relationEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    relationEntity.setFromId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    relationEntity.setFromType("jane.doe@example.org");
    relationEntity.setRelationType("Relation Type");
    relationEntity.setRelationTypeGroup("Relation Type Group");
    relationEntity.setToId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    relationEntity.setToType("jane.doe@example.org");
    relationEntity.setVersion(1L);

    RelationEntity relationEntity2 = new RelationEntity();
    relationEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    relationEntity2.setFromId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    relationEntity2.setFromType("jane.doe@example.org");
    relationEntity2.setRelationType("Relation Type");
    relationEntity2.setRelationTypeGroup("Relation Type Group");
    relationEntity2.setToId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    relationEntity2.setToType("To Type");
    relationEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(relationEntity, relationEntity2);
  }

  /**
   * Test {@link RelationEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelationEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RelationEntity.equals(Object)", "int RelationEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    RelationEntity relationEntity = new RelationEntity();
    relationEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    relationEntity.setFromId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    relationEntity.setFromType("jane.doe@example.org");
    relationEntity.setRelationType("Relation Type");
    relationEntity.setRelationTypeGroup("Relation Type Group");
    relationEntity.setToId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    relationEntity.setToType(null);
    relationEntity.setVersion(1L);

    RelationEntity relationEntity2 = new RelationEntity();
    relationEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    relationEntity2.setFromId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    relationEntity2.setFromType("jane.doe@example.org");
    relationEntity2.setRelationType("Relation Type");
    relationEntity2.setRelationTypeGroup("Relation Type Group");
    relationEntity2.setToId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    relationEntity2.setToType("To Type");
    relationEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(relationEntity, relationEntity2);
  }

  /**
   * Test {@link RelationEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelationEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RelationEntity.equals(Object)", "int RelationEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    RelationEntity relationEntity = new RelationEntity();
    relationEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    relationEntity.setFromId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    relationEntity.setFromType("jane.doe@example.org");
    relationEntity.setRelationType("Relation Type");
    relationEntity.setRelationTypeGroup("Relation Type Group");
    relationEntity.setToId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    relationEntity.setToType("To Type");
    relationEntity.setVersion(0L);

    RelationEntity relationEntity2 = new RelationEntity();
    relationEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    relationEntity2.setFromId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    relationEntity2.setFromType("jane.doe@example.org");
    relationEntity2.setRelationType("Relation Type");
    relationEntity2.setRelationTypeGroup("Relation Type Group");
    relationEntity2.setToId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    relationEntity2.setToType("To Type");
    relationEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(relationEntity, relationEntity2);
  }

  /**
   * Test {@link RelationEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelationEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RelationEntity.equals(Object)", "int RelationEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    RelationEntity relationEntity = new RelationEntity();
    relationEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    relationEntity.setFromId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    relationEntity.setFromType("jane.doe@example.org");
    relationEntity.setRelationType("Relation Type");
    relationEntity.setRelationTypeGroup("Relation Type Group");
    relationEntity.setToId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    relationEntity.setToType("To Type");
    relationEntity.setVersion(null);

    RelationEntity relationEntity2 = new RelationEntity();
    relationEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    relationEntity2.setFromId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    relationEntity2.setFromType("jane.doe@example.org");
    relationEntity2.setRelationType("Relation Type");
    relationEntity2.setRelationTypeGroup("Relation Type Group");
    relationEntity2.setToId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    relationEntity2.setToType("To Type");
    relationEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(relationEntity, relationEntity2);
  }

  /**
   * Test {@link RelationEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelationEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RelationEntity.equals(Object)", "int RelationEntity.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    RelationEntity relationEntity = new RelationEntity();
    relationEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    relationEntity.setFromId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    relationEntity.setFromType("jane.doe@example.org");
    relationEntity.setRelationType("Relation Type");
    relationEntity.setRelationTypeGroup("Relation Type Group");
    relationEntity.setToId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    relationEntity.setToType("To Type");
    relationEntity.setVersion(1L);

    // Act and Assert
    assertNotEquals(relationEntity, null);
  }

  /**
   * Test {@link RelationEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelationEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RelationEntity.equals(Object)", "int RelationEntity.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    RelationEntity relationEntity = new RelationEntity();
    relationEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    relationEntity.setFromId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    relationEntity.setFromType("jane.doe@example.org");
    relationEntity.setRelationType("Relation Type");
    relationEntity.setRelationTypeGroup("Relation Type Group");
    relationEntity.setToId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    relationEntity.setToType("To Type");
    relationEntity.setVersion(1L);

    // Act and Assert
    assertNotEquals(relationEntity, "Different type to RelationEntity");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RelationEntity#RelationEntity()}
   *   <li>{@link RelationEntity#setAdditionalInfo(JsonNode)}
   *   <li>{@link RelationEntity#setFromId(UUID)}
   *   <li>{@link RelationEntity#setFromType(String)}
   *   <li>{@link RelationEntity#setRelationType(String)}
   *   <li>{@link RelationEntity#setRelationTypeGroup(String)}
   *   <li>{@link RelationEntity#setToId(UUID)}
   *   <li>{@link RelationEntity#setToType(String)}
   *   <li>{@link RelationEntity#setVersion(Long)}
   *   <li>{@link RelationEntity#toString()}
   *   <li>{@link RelationEntity#getAdditionalInfo()}
   *   <li>{@link RelationEntity#getFromId()}
   *   <li>{@link RelationEntity#getFromType()}
   *   <li>{@link RelationEntity#getRelationType()}
   *   <li>{@link RelationEntity#getRelationTypeGroup()}
   *   <li>{@link RelationEntity#getToId()}
   *   <li>{@link RelationEntity#getToType()}
   *   <li>{@link RelationEntity#getVersion()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void RelationEntity.<init>()",
    "JsonNode RelationEntity.getAdditionalInfo()",
    "UUID RelationEntity.getFromId()",
    "String RelationEntity.getFromType()",
    "String RelationEntity.getRelationType()",
    "String RelationEntity.getRelationTypeGroup()",
    "UUID RelationEntity.getToId()",
    "String RelationEntity.getToType()",
    "Long RelationEntity.getVersion()",
    "void RelationEntity.setAdditionalInfo(JsonNode)",
    "void RelationEntity.setFromId(UUID)",
    "void RelationEntity.setFromType(String)",
    "void RelationEntity.setRelationType(String)",
    "void RelationEntity.setRelationTypeGroup(String)",
    "void RelationEntity.setToId(UUID)",
    "void RelationEntity.setToType(String)",
    "void RelationEntity.setVersion(Long)",
    "String RelationEntity.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    RelationEntity actualRelationEntity = new RelationEntity();
    JsonNode additionalInfo = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;
    actualRelationEntity.setAdditionalInfo(additionalInfo);
    UUID fromId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualRelationEntity.setFromId(fromId);
    actualRelationEntity.setFromType("jane.doe@example.org");
    actualRelationEntity.setRelationType("Relation Type");
    actualRelationEntity.setRelationTypeGroup("Relation Type Group");
    UUID toId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualRelationEntity.setToId(toId);
    actualRelationEntity.setToType("To Type");
    actualRelationEntity.setVersion(1L);
    String actualToStringResult = actualRelationEntity.toString();
    JsonNode actualAdditionalInfo = actualRelationEntity.getAdditionalInfo();
    UUID actualFromId = actualRelationEntity.getFromId();
    String actualFromType = actualRelationEntity.getFromType();
    String actualRelationType = actualRelationEntity.getRelationType();
    String actualRelationTypeGroup = actualRelationEntity.getRelationTypeGroup();
    UUID actualToId = actualRelationEntity.getToId();
    String actualToType = actualRelationEntity.getToType();
    Long actualVersion = actualRelationEntity.getVersion();

    // Assert
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualFromId.toString());
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualToId.toString());
    assertEquals("Relation Type Group", actualRelationTypeGroup);
    assertEquals("Relation Type", actualRelationType);
    assertEquals(
        "RelationEntity(fromId=784f394c-42b6-435a-983c-b7beff2784f9, fromType=jane.doe@example.org, toId=784f394c"
            + "-42b6-435a-983c-b7beff2784f9, toType=To Type, relationTypeGroup=Relation Type Group, relationType=Relation"
            + " Type, version=1, additionalInfo={\"isPublic\":true})",
        actualToStringResult);
    assertEquals("To Type", actualToType);
    assertEquals("jane.doe@example.org", actualFromType);
    assertEquals(1L, actualVersion.longValue());
    assertSame(fromId, actualFromId);
    assertSame(toId, actualToId);
    assertSame(additionalInfo, actualAdditionalInfo);
  }

  /**
   * Test {@link RelationEntity#RelationEntity(EntityRelation)}.
   *
   * <p>Method under test: {@link RelationEntity#RelationEntity(EntityRelation)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RelationEntity.<init>(EntityRelation)"})
  public void testNewRelationEntity() {
    // Arrange and Act
    RelationEntity actualRelationEntity =
        new RelationEntity(
            new EntityRelation(
                BaseEntityService.NULL_CUSTOMER_ID, BaseEntityService.NULL_CUSTOMER_ID, "Type"));

    // Assert
    UUID fromId = actualRelationEntity.getFromId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", fromId.toString());
    assertEquals("CUSTOMER", actualRelationEntity.getFromType());
    assertEquals("CUSTOMER", actualRelationEntity.getToType());
    assertEquals("Type", actualRelationEntity.getRelationType());
    assertSame(fromId, actualRelationEntity.getToId());
  }

  /**
   * Test {@link RelationEntity#RelationEntity(EntityRelation)}.
   *
   * <ul>
   *   <li>Given {@code COMMON}.
   *   <li>Then return FromType is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RelationEntity#RelationEntity(EntityRelation)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RelationEntity.<init>(EntityRelation)"})
  public void testNewRelationEntity_givenCommon_thenReturnFromTypeIsNull() {
    // Arrange
    EntityRelation relation = new EntityRelation();
    relation.setTypeGroup(RelationTypeGroup.COMMON);

    // Act
    RelationEntity actualRelationEntity = new RelationEntity(relation);

    // Assert
    assertNull(actualRelationEntity.getFromType());
    assertNull(actualRelationEntity.getRelationType());
    assertNull(actualRelationEntity.getToType());
    assertNull(actualRelationEntity.getFromId());
    assertNull(actualRelationEntity.getToId());
  }

  /**
   * Test {@link RelationEntity#RelationEntity(EntityRelation)}.
   *
   * <ul>
   *   <li>Then return FromType is {@code TENANT}.
   * </ul>
   *
   * <p>Method under test: {@link RelationEntity#RelationEntity(EntityRelation)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RelationEntity.<init>(EntityRelation)"})
  public void testNewRelationEntity_thenReturnFromTypeIsTenant() {
    // Arrange and Act
    RelationEntity actualRelationEntity =
        new RelationEntity(
            new EntityRelation(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, "Type"));

    // Assert
    UUID fromId = actualRelationEntity.getFromId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", fromId.toString());
    assertEquals("CUSTOMER", actualRelationEntity.getToType());
    assertEquals("TENANT", actualRelationEntity.getFromType());
    assertEquals("Type", actualRelationEntity.getRelationType());
    assertSame(fromId, actualRelationEntity.getToId());
  }

  /**
   * Test {@link RelationEntity#RelationEntity(EntityRelation)}.
   *
   * <ul>
   *   <li>Then return ToType is {@code TENANT}.
   * </ul>
   *
   * <p>Method under test: {@link RelationEntity#RelationEntity(EntityRelation)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RelationEntity.<init>(EntityRelation)"})
  public void testNewRelationEntity_thenReturnToTypeIsTenant() {
    // Arrange and Act
    RelationEntity actualRelationEntity =
        new RelationEntity(
            new EntityRelation(
                BaseEntityService.NULL_CUSTOMER_ID, ModelConstants.SYSTEM_TENANT, "Type"));

    // Assert
    UUID fromId = actualRelationEntity.getFromId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", fromId.toString());
    assertEquals("CUSTOMER", actualRelationEntity.getFromType());
    assertEquals("TENANT", actualRelationEntity.getToType());
    assertEquals("Type", actualRelationEntity.getRelationType());
    assertSame(fromId, actualRelationEntity.getToId());
  }

  /**
   * Test {@link RelationEntity#toData()}.
   *
   * <p>Method under test: {@link RelationEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"EntityRelation RelationEntity.toData()"})
  public void testToData() {
    // Arrange
    EntityRelation relation =
        new EntityRelation(
            BaseEntityService.NULL_CUSTOMER_ID, BaseEntityService.NULL_CUSTOMER_ID, "Type");

    // Act and Assert
    assertEquals(relation, new RelationEntity(relation).toData());
  }

  /**
   * Test {@link RelationEntity#toData()}.
   *
   * <p>Method under test: {@link RelationEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"EntityRelation RelationEntity.toData()"})
  public void testToData2() {
    // Arrange
    EntityRelation relation =
        new EntityRelation(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, "Type");

    // Act and Assert
    assertEquals(relation, new RelationEntity(relation).toData());
  }

  /**
   * Test {@link RelationEntity#toData()}.
   *
   * <p>Method under test: {@link RelationEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"EntityRelation RelationEntity.toData()"})
  public void testToData3() {
    // Arrange
    EntityRelation relation =
        new EntityRelation(
            new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
            BaseEntityService.NULL_CUSTOMER_ID,
            "Type");

    // Act and Assert
    assertEquals(relation, new RelationEntity(relation).toData());
  }

  /**
   * Test {@link RelationEntity#toData()}.
   *
   * <p>Method under test: {@link RelationEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"EntityRelation RelationEntity.toData()"})
  public void testToData4() {
    // Arrange
    EntityRelation relation = new EntityRelation(null, BaseEntityService.NULL_CUSTOMER_ID, "Type");

    RelationEntity relationEntity = new RelationEntity(relation);
    relationEntity.setFromId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(relation, relationEntity.toData());
  }

  /**
   * Test {@link RelationEntity#toData()}.
   *
   * <p>Method under test: {@link RelationEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"EntityRelation RelationEntity.toData()"})
  public void testToData5() {
    // Arrange
    EntityRelation relation = new EntityRelation(BaseEntityService.NULL_CUSTOMER_ID, null, "Type");

    RelationEntity relationEntity = new RelationEntity(relation);
    relationEntity.setToId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(relation, relationEntity.toData());
  }

  /**
   * Test {@link RelationEntity#toData()}.
   *
   * <ul>
   *   <li>Then return {@link EntityRelation#EntityRelation(EntityId, EntityId, String)} with from
   *       is {@code null} and to is {@link BaseEntityService#NULL_CUSTOMER_ID} and {@code Type}.
   * </ul>
   *
   * <p>Method under test: {@link RelationEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"EntityRelation RelationEntity.toData()"})
  public void testToData_thenReturnEntityRelationWithFromIsNullAndToIsNull_customer_idAndType() {
    // Arrange
    EntityRelation relation = new EntityRelation(null, BaseEntityService.NULL_CUSTOMER_ID, "Type");

    // Act and Assert
    assertEquals(relation, new RelationEntity(relation).toData());
  }

  /**
   * Test {@link RelationEntity#toData()}.
   *
   * <ul>
   *   <li>Then return {@link EntityRelation#EntityRelation(EntityId, EntityId, String)} with from
   *       is {@link BaseEntityService#NULL_CUSTOMER_ID} and to is {@code null} and {@code Type}.
   * </ul>
   *
   * <p>Method under test: {@link RelationEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"EntityRelation RelationEntity.toData()"})
  public void testToData_thenReturnEntityRelationWithFromIsNull_customer_idAndToIsNullAndType() {
    // Arrange
    EntityRelation relation = new EntityRelation(BaseEntityService.NULL_CUSTOMER_ID, null, "Type");

    // Act and Assert
    assertEquals(relation, new RelationEntity(relation).toData());
  }
}
