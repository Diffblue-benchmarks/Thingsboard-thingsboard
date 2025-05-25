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

public class RuleNodeDebugEventEntityDiffblueTest {
  /**
   * Test {@link RuleNodeDebugEventEntity#equals(Object)}, and {@link RuleNodeDebugEventEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RuleNodeDebugEventEntity#equals(Object)}
   *   <li>{@link RuleNodeDebugEventEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RuleNodeDebugEventEntity.equals(Object)", "int RuleNodeDebugEventEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RuleNodeDebugEventEntity ruleNodeDebugEventEntity = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity.setCreatedTime(1L);
    ruleNodeDebugEventEntity.setData("Data");
    ruleNodeDebugEventEntity.setDataType("Data Type");
    ruleNodeDebugEventEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setError("An error occurred");
    ruleNodeDebugEventEntity.setEventEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity.setEventType("Event Type");
    ruleNodeDebugEventEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setMetadata("Metadata");
    ruleNodeDebugEventEntity.setMsgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setMsgType("Msg Type");
    ruleNodeDebugEventEntity.setRelationType("Relation Type");
    ruleNodeDebugEventEntity.setServiceId("42");
    ruleNodeDebugEventEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setTs(1L);
    ruleNodeDebugEventEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RuleNodeDebugEventEntity ruleNodeDebugEventEntity2 = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity2.setCreatedTime(1L);
    ruleNodeDebugEventEntity2.setData("Data");
    ruleNodeDebugEventEntity2.setDataType("Data Type");
    ruleNodeDebugEventEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setError("An error occurred");
    ruleNodeDebugEventEntity2.setEventEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity2.setEventType("Event Type");
    ruleNodeDebugEventEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setMetadata("Metadata");
    ruleNodeDebugEventEntity2.setMsgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setMsgType("Msg Type");
    ruleNodeDebugEventEntity2.setRelationType("Relation Type");
    ruleNodeDebugEventEntity2.setServiceId("42");
    ruleNodeDebugEventEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setTs(1L);
    ruleNodeDebugEventEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(ruleNodeDebugEventEntity, ruleNodeDebugEventEntity2);
    int expectedHashCodeResult = ruleNodeDebugEventEntity.hashCode();
    assertEquals(expectedHashCodeResult, ruleNodeDebugEventEntity2.hashCode());
  }

  /**
   * Test {@link RuleNodeDebugEventEntity#equals(Object)}, and {@link RuleNodeDebugEventEntity#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RuleNodeDebugEventEntity#equals(Object)}
   *   <li>{@link RuleNodeDebugEventEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RuleNodeDebugEventEntity.equals(Object)", "int RuleNodeDebugEventEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RuleNodeDebugEventEntity ruleNodeDebugEventEntity = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity.setCreatedTime(1L);
    ruleNodeDebugEventEntity.setData("Data");
    ruleNodeDebugEventEntity.setDataType("Data Type");
    ruleNodeDebugEventEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setError("An error occurred");
    ruleNodeDebugEventEntity.setEventEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity.setEventType("Event Type");
    ruleNodeDebugEventEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setMetadata("Metadata");
    ruleNodeDebugEventEntity.setMsgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setMsgType("Msg Type");
    ruleNodeDebugEventEntity.setRelationType("Relation Type");
    ruleNodeDebugEventEntity.setServiceId("42");
    ruleNodeDebugEventEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setTs(1L);
    ruleNodeDebugEventEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(ruleNodeDebugEventEntity, ruleNodeDebugEventEntity);
    int expectedHashCodeResult = ruleNodeDebugEventEntity.hashCode();
    assertEquals(expectedHashCodeResult, ruleNodeDebugEventEntity.hashCode());
  }

  /**
   * Test {@link RuleNodeDebugEventEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeDebugEventEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RuleNodeDebugEventEntity.equals(Object)", "int RuleNodeDebugEventEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RuleNodeDebugEventEntity ruleNodeDebugEventEntity = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity.setCreatedTime(1L);
    ruleNodeDebugEventEntity.setData("42");
    ruleNodeDebugEventEntity.setDataType("Data Type");
    ruleNodeDebugEventEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setError("An error occurred");
    ruleNodeDebugEventEntity.setEventEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity.setEventType("Event Type");
    ruleNodeDebugEventEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setMetadata("Metadata");
    ruleNodeDebugEventEntity.setMsgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setMsgType("Msg Type");
    ruleNodeDebugEventEntity.setRelationType("Relation Type");
    ruleNodeDebugEventEntity.setServiceId("42");
    ruleNodeDebugEventEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setTs(1L);
    ruleNodeDebugEventEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RuleNodeDebugEventEntity ruleNodeDebugEventEntity2 = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity2.setCreatedTime(1L);
    ruleNodeDebugEventEntity2.setData("Data");
    ruleNodeDebugEventEntity2.setDataType("Data Type");
    ruleNodeDebugEventEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setError("An error occurred");
    ruleNodeDebugEventEntity2.setEventEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity2.setEventType("Event Type");
    ruleNodeDebugEventEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setMetadata("Metadata");
    ruleNodeDebugEventEntity2.setMsgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setMsgType("Msg Type");
    ruleNodeDebugEventEntity2.setRelationType("Relation Type");
    ruleNodeDebugEventEntity2.setServiceId("42");
    ruleNodeDebugEventEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setTs(1L);
    ruleNodeDebugEventEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(ruleNodeDebugEventEntity, ruleNodeDebugEventEntity2);
  }

  /**
   * Test {@link RuleNodeDebugEventEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeDebugEventEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RuleNodeDebugEventEntity.equals(Object)", "int RuleNodeDebugEventEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RuleNodeDebugEventEntity ruleNodeDebugEventEntity = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity.setCreatedTime(1L);
    ruleNodeDebugEventEntity.setData(null);
    ruleNodeDebugEventEntity.setDataType("Data Type");
    ruleNodeDebugEventEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setError("An error occurred");
    ruleNodeDebugEventEntity.setEventEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity.setEventType("Event Type");
    ruleNodeDebugEventEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setMetadata("Metadata");
    ruleNodeDebugEventEntity.setMsgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setMsgType("Msg Type");
    ruleNodeDebugEventEntity.setRelationType("Relation Type");
    ruleNodeDebugEventEntity.setServiceId("42");
    ruleNodeDebugEventEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setTs(1L);
    ruleNodeDebugEventEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RuleNodeDebugEventEntity ruleNodeDebugEventEntity2 = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity2.setCreatedTime(1L);
    ruleNodeDebugEventEntity2.setData("Data");
    ruleNodeDebugEventEntity2.setDataType("Data Type");
    ruleNodeDebugEventEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setError("An error occurred");
    ruleNodeDebugEventEntity2.setEventEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity2.setEventType("Event Type");
    ruleNodeDebugEventEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setMetadata("Metadata");
    ruleNodeDebugEventEntity2.setMsgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setMsgType("Msg Type");
    ruleNodeDebugEventEntity2.setRelationType("Relation Type");
    ruleNodeDebugEventEntity2.setServiceId("42");
    ruleNodeDebugEventEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setTs(1L);
    ruleNodeDebugEventEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(ruleNodeDebugEventEntity, ruleNodeDebugEventEntity2);
  }

  /**
   * Test {@link RuleNodeDebugEventEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeDebugEventEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RuleNodeDebugEventEntity.equals(Object)", "int RuleNodeDebugEventEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RuleNodeDebugEventEntity ruleNodeDebugEventEntity = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity.setCreatedTime(1L);
    ruleNodeDebugEventEntity.setData("Data");
    ruleNodeDebugEventEntity.setDataType("42");
    ruleNodeDebugEventEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setError("An error occurred");
    ruleNodeDebugEventEntity.setEventEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity.setEventType("Event Type");
    ruleNodeDebugEventEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setMetadata("Metadata");
    ruleNodeDebugEventEntity.setMsgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setMsgType("Msg Type");
    ruleNodeDebugEventEntity.setRelationType("Relation Type");
    ruleNodeDebugEventEntity.setServiceId("42");
    ruleNodeDebugEventEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setTs(1L);
    ruleNodeDebugEventEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RuleNodeDebugEventEntity ruleNodeDebugEventEntity2 = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity2.setCreatedTime(1L);
    ruleNodeDebugEventEntity2.setData("Data");
    ruleNodeDebugEventEntity2.setDataType("Data Type");
    ruleNodeDebugEventEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setError("An error occurred");
    ruleNodeDebugEventEntity2.setEventEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity2.setEventType("Event Type");
    ruleNodeDebugEventEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setMetadata("Metadata");
    ruleNodeDebugEventEntity2.setMsgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setMsgType("Msg Type");
    ruleNodeDebugEventEntity2.setRelationType("Relation Type");
    ruleNodeDebugEventEntity2.setServiceId("42");
    ruleNodeDebugEventEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setTs(1L);
    ruleNodeDebugEventEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(ruleNodeDebugEventEntity, ruleNodeDebugEventEntity2);
  }

  /**
   * Test {@link RuleNodeDebugEventEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeDebugEventEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RuleNodeDebugEventEntity.equals(Object)", "int RuleNodeDebugEventEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    RuleNodeDebugEventEntity ruleNodeDebugEventEntity = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity.setCreatedTime(1L);
    ruleNodeDebugEventEntity.setData("Data");
    ruleNodeDebugEventEntity.setDataType(null);
    ruleNodeDebugEventEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setError("An error occurred");
    ruleNodeDebugEventEntity.setEventEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity.setEventType("Event Type");
    ruleNodeDebugEventEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setMetadata("Metadata");
    ruleNodeDebugEventEntity.setMsgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setMsgType("Msg Type");
    ruleNodeDebugEventEntity.setRelationType("Relation Type");
    ruleNodeDebugEventEntity.setServiceId("42");
    ruleNodeDebugEventEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setTs(1L);
    ruleNodeDebugEventEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RuleNodeDebugEventEntity ruleNodeDebugEventEntity2 = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity2.setCreatedTime(1L);
    ruleNodeDebugEventEntity2.setData("Data");
    ruleNodeDebugEventEntity2.setDataType("Data Type");
    ruleNodeDebugEventEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setError("An error occurred");
    ruleNodeDebugEventEntity2.setEventEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity2.setEventType("Event Type");
    ruleNodeDebugEventEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setMetadata("Metadata");
    ruleNodeDebugEventEntity2.setMsgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setMsgType("Msg Type");
    ruleNodeDebugEventEntity2.setRelationType("Relation Type");
    ruleNodeDebugEventEntity2.setServiceId("42");
    ruleNodeDebugEventEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setTs(1L);
    ruleNodeDebugEventEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(ruleNodeDebugEventEntity, ruleNodeDebugEventEntity2);
  }

  /**
   * Test {@link RuleNodeDebugEventEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeDebugEventEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RuleNodeDebugEventEntity.equals(Object)", "int RuleNodeDebugEventEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    RuleNodeDebugEventEntity ruleNodeDebugEventEntity = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity.setCreatedTime(1L);
    ruleNodeDebugEventEntity.setData("Data");
    ruleNodeDebugEventEntity.setDataType("Data Type");
    ruleNodeDebugEventEntity.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setError("An error occurred");
    ruleNodeDebugEventEntity.setEventEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity.setEventType("Event Type");
    ruleNodeDebugEventEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setMetadata("Metadata");
    ruleNodeDebugEventEntity.setMsgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setMsgType("Msg Type");
    ruleNodeDebugEventEntity.setRelationType("Relation Type");
    ruleNodeDebugEventEntity.setServiceId("42");
    ruleNodeDebugEventEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setTs(1L);
    ruleNodeDebugEventEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RuleNodeDebugEventEntity ruleNodeDebugEventEntity2 = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity2.setCreatedTime(1L);
    ruleNodeDebugEventEntity2.setData("Data");
    ruleNodeDebugEventEntity2.setDataType("Data Type");
    ruleNodeDebugEventEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setError("An error occurred");
    ruleNodeDebugEventEntity2.setEventEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity2.setEventType("Event Type");
    ruleNodeDebugEventEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setMetadata("Metadata");
    ruleNodeDebugEventEntity2.setMsgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setMsgType("Msg Type");
    ruleNodeDebugEventEntity2.setRelationType("Relation Type");
    ruleNodeDebugEventEntity2.setServiceId("42");
    ruleNodeDebugEventEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setTs(1L);
    ruleNodeDebugEventEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(ruleNodeDebugEventEntity, ruleNodeDebugEventEntity2);
  }

  /**
   * Test {@link RuleNodeDebugEventEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeDebugEventEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RuleNodeDebugEventEntity.equals(Object)", "int RuleNodeDebugEventEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    RuleNodeDebugEventEntity ruleNodeDebugEventEntity = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity.setCreatedTime(1L);
    ruleNodeDebugEventEntity.setData("Data");
    ruleNodeDebugEventEntity.setDataType("Data Type");
    ruleNodeDebugEventEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setError("42");
    ruleNodeDebugEventEntity.setEventEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity.setEventType("Event Type");
    ruleNodeDebugEventEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setMetadata("Metadata");
    ruleNodeDebugEventEntity.setMsgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setMsgType("Msg Type");
    ruleNodeDebugEventEntity.setRelationType("Relation Type");
    ruleNodeDebugEventEntity.setServiceId("42");
    ruleNodeDebugEventEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setTs(1L);
    ruleNodeDebugEventEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RuleNodeDebugEventEntity ruleNodeDebugEventEntity2 = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity2.setCreatedTime(1L);
    ruleNodeDebugEventEntity2.setData("Data");
    ruleNodeDebugEventEntity2.setDataType("Data Type");
    ruleNodeDebugEventEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setError("An error occurred");
    ruleNodeDebugEventEntity2.setEventEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity2.setEventType("Event Type");
    ruleNodeDebugEventEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setMetadata("Metadata");
    ruleNodeDebugEventEntity2.setMsgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setMsgType("Msg Type");
    ruleNodeDebugEventEntity2.setRelationType("Relation Type");
    ruleNodeDebugEventEntity2.setServiceId("42");
    ruleNodeDebugEventEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setTs(1L);
    ruleNodeDebugEventEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(ruleNodeDebugEventEntity, ruleNodeDebugEventEntity2);
  }

  /**
   * Test {@link RuleNodeDebugEventEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeDebugEventEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RuleNodeDebugEventEntity.equals(Object)", "int RuleNodeDebugEventEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    RuleNodeDebugEventEntity ruleNodeDebugEventEntity = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity.setCreatedTime(1L);
    ruleNodeDebugEventEntity.setData("Data");
    ruleNodeDebugEventEntity.setDataType("Data Type");
    ruleNodeDebugEventEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setError(null);
    ruleNodeDebugEventEntity.setEventEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity.setEventType("Event Type");
    ruleNodeDebugEventEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setMetadata("Metadata");
    ruleNodeDebugEventEntity.setMsgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setMsgType("Msg Type");
    ruleNodeDebugEventEntity.setRelationType("Relation Type");
    ruleNodeDebugEventEntity.setServiceId("42");
    ruleNodeDebugEventEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setTs(1L);
    ruleNodeDebugEventEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RuleNodeDebugEventEntity ruleNodeDebugEventEntity2 = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity2.setCreatedTime(1L);
    ruleNodeDebugEventEntity2.setData("Data");
    ruleNodeDebugEventEntity2.setDataType("Data Type");
    ruleNodeDebugEventEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setError("An error occurred");
    ruleNodeDebugEventEntity2.setEventEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity2.setEventType("Event Type");
    ruleNodeDebugEventEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setMetadata("Metadata");
    ruleNodeDebugEventEntity2.setMsgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setMsgType("Msg Type");
    ruleNodeDebugEventEntity2.setRelationType("Relation Type");
    ruleNodeDebugEventEntity2.setServiceId("42");
    ruleNodeDebugEventEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setTs(1L);
    ruleNodeDebugEventEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(ruleNodeDebugEventEntity, ruleNodeDebugEventEntity2);
  }

  /**
   * Test {@link RuleNodeDebugEventEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeDebugEventEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RuleNodeDebugEventEntity.equals(Object)", "int RuleNodeDebugEventEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    RuleNodeDebugEventEntity ruleNodeDebugEventEntity = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity.setCreatedTime(1L);
    ruleNodeDebugEventEntity.setData("Data");
    ruleNodeDebugEventEntity.setDataType("Data Type");
    ruleNodeDebugEventEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setError("An error occurred");
    ruleNodeDebugEventEntity.setEventEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity.setEventType("Event Type");
    ruleNodeDebugEventEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setMetadata("Metadata");
    ruleNodeDebugEventEntity.setMsgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setMsgType("Msg Type");
    ruleNodeDebugEventEntity.setRelationType("Relation Type");
    ruleNodeDebugEventEntity.setServiceId("42");
    ruleNodeDebugEventEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setTs(1L);
    ruleNodeDebugEventEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RuleNodeDebugEventEntity ruleNodeDebugEventEntity2 = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity2.setCreatedTime(1L);
    ruleNodeDebugEventEntity2.setData("Data");
    ruleNodeDebugEventEntity2.setDataType("Data Type");
    ruleNodeDebugEventEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setError("An error occurred");
    ruleNodeDebugEventEntity2.setEventEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity2.setEventType("Event Type");
    ruleNodeDebugEventEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setMetadata("Metadata");
    ruleNodeDebugEventEntity2.setMsgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setMsgType("Msg Type");
    ruleNodeDebugEventEntity2.setRelationType("Relation Type");
    ruleNodeDebugEventEntity2.setServiceId("42");
    ruleNodeDebugEventEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setTs(1L);
    ruleNodeDebugEventEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(ruleNodeDebugEventEntity, ruleNodeDebugEventEntity2);
  }

  /**
   * Test {@link RuleNodeDebugEventEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeDebugEventEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RuleNodeDebugEventEntity.equals(Object)", "int RuleNodeDebugEventEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    RuleNodeDebugEventEntity ruleNodeDebugEventEntity = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity.setCreatedTime(1L);
    ruleNodeDebugEventEntity.setData("Data");
    ruleNodeDebugEventEntity.setDataType("Data Type");
    ruleNodeDebugEventEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setError("An error occurred");
    ruleNodeDebugEventEntity.setEventEntityId(null);
    ruleNodeDebugEventEntity.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity.setEventType("Event Type");
    ruleNodeDebugEventEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setMetadata("Metadata");
    ruleNodeDebugEventEntity.setMsgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setMsgType("Msg Type");
    ruleNodeDebugEventEntity.setRelationType("Relation Type");
    ruleNodeDebugEventEntity.setServiceId("42");
    ruleNodeDebugEventEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setTs(1L);
    ruleNodeDebugEventEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RuleNodeDebugEventEntity ruleNodeDebugEventEntity2 = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity2.setCreatedTime(1L);
    ruleNodeDebugEventEntity2.setData("Data");
    ruleNodeDebugEventEntity2.setDataType("Data Type");
    ruleNodeDebugEventEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setError("An error occurred");
    ruleNodeDebugEventEntity2.setEventEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity2.setEventType("Event Type");
    ruleNodeDebugEventEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setMetadata("Metadata");
    ruleNodeDebugEventEntity2.setMsgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setMsgType("Msg Type");
    ruleNodeDebugEventEntity2.setRelationType("Relation Type");
    ruleNodeDebugEventEntity2.setServiceId("42");
    ruleNodeDebugEventEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setTs(1L);
    ruleNodeDebugEventEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(ruleNodeDebugEventEntity, ruleNodeDebugEventEntity2);
  }

  /**
   * Test {@link RuleNodeDebugEventEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeDebugEventEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RuleNodeDebugEventEntity.equals(Object)", "int RuleNodeDebugEventEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    RuleNodeDebugEventEntity ruleNodeDebugEventEntity = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity.setCreatedTime(1L);
    ruleNodeDebugEventEntity.setData("Data");
    ruleNodeDebugEventEntity.setDataType("Data Type");
    ruleNodeDebugEventEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setError("An error occurred");
    ruleNodeDebugEventEntity.setEventEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setEventEntityType("42");
    ruleNodeDebugEventEntity.setEventType("Event Type");
    ruleNodeDebugEventEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setMetadata("Metadata");
    ruleNodeDebugEventEntity.setMsgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setMsgType("Msg Type");
    ruleNodeDebugEventEntity.setRelationType("Relation Type");
    ruleNodeDebugEventEntity.setServiceId("42");
    ruleNodeDebugEventEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setTs(1L);
    ruleNodeDebugEventEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RuleNodeDebugEventEntity ruleNodeDebugEventEntity2 = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity2.setCreatedTime(1L);
    ruleNodeDebugEventEntity2.setData("Data");
    ruleNodeDebugEventEntity2.setDataType("Data Type");
    ruleNodeDebugEventEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setError("An error occurred");
    ruleNodeDebugEventEntity2.setEventEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity2.setEventType("Event Type");
    ruleNodeDebugEventEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setMetadata("Metadata");
    ruleNodeDebugEventEntity2.setMsgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setMsgType("Msg Type");
    ruleNodeDebugEventEntity2.setRelationType("Relation Type");
    ruleNodeDebugEventEntity2.setServiceId("42");
    ruleNodeDebugEventEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setTs(1L);
    ruleNodeDebugEventEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(ruleNodeDebugEventEntity, ruleNodeDebugEventEntity2);
  }

  /**
   * Test {@link RuleNodeDebugEventEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeDebugEventEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RuleNodeDebugEventEntity.equals(Object)", "int RuleNodeDebugEventEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    RuleNodeDebugEventEntity ruleNodeDebugEventEntity = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity.setCreatedTime(1L);
    ruleNodeDebugEventEntity.setData("Data");
    ruleNodeDebugEventEntity.setDataType("Data Type");
    ruleNodeDebugEventEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setError("An error occurred");
    ruleNodeDebugEventEntity.setEventEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setEventEntityType(null);
    ruleNodeDebugEventEntity.setEventType("Event Type");
    ruleNodeDebugEventEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setMetadata("Metadata");
    ruleNodeDebugEventEntity.setMsgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setMsgType("Msg Type");
    ruleNodeDebugEventEntity.setRelationType("Relation Type");
    ruleNodeDebugEventEntity.setServiceId("42");
    ruleNodeDebugEventEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setTs(1L);
    ruleNodeDebugEventEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RuleNodeDebugEventEntity ruleNodeDebugEventEntity2 = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity2.setCreatedTime(1L);
    ruleNodeDebugEventEntity2.setData("Data");
    ruleNodeDebugEventEntity2.setDataType("Data Type");
    ruleNodeDebugEventEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setError("An error occurred");
    ruleNodeDebugEventEntity2.setEventEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity2.setEventType("Event Type");
    ruleNodeDebugEventEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setMetadata("Metadata");
    ruleNodeDebugEventEntity2.setMsgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setMsgType("Msg Type");
    ruleNodeDebugEventEntity2.setRelationType("Relation Type");
    ruleNodeDebugEventEntity2.setServiceId("42");
    ruleNodeDebugEventEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setTs(1L);
    ruleNodeDebugEventEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(ruleNodeDebugEventEntity, ruleNodeDebugEventEntity2);
  }

  /**
   * Test {@link RuleNodeDebugEventEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeDebugEventEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RuleNodeDebugEventEntity.equals(Object)", "int RuleNodeDebugEventEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    RuleNodeDebugEventEntity ruleNodeDebugEventEntity = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity.setCreatedTime(1L);
    ruleNodeDebugEventEntity.setData("Data");
    ruleNodeDebugEventEntity.setDataType("Data Type");
    ruleNodeDebugEventEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setError("An error occurred");
    ruleNodeDebugEventEntity.setEventEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity.setEventType("42");
    ruleNodeDebugEventEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setMetadata("Metadata");
    ruleNodeDebugEventEntity.setMsgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setMsgType("Msg Type");
    ruleNodeDebugEventEntity.setRelationType("Relation Type");
    ruleNodeDebugEventEntity.setServiceId("42");
    ruleNodeDebugEventEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setTs(1L);
    ruleNodeDebugEventEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RuleNodeDebugEventEntity ruleNodeDebugEventEntity2 = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity2.setCreatedTime(1L);
    ruleNodeDebugEventEntity2.setData("Data");
    ruleNodeDebugEventEntity2.setDataType("Data Type");
    ruleNodeDebugEventEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setError("An error occurred");
    ruleNodeDebugEventEntity2.setEventEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity2.setEventType("Event Type");
    ruleNodeDebugEventEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setMetadata("Metadata");
    ruleNodeDebugEventEntity2.setMsgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setMsgType("Msg Type");
    ruleNodeDebugEventEntity2.setRelationType("Relation Type");
    ruleNodeDebugEventEntity2.setServiceId("42");
    ruleNodeDebugEventEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setTs(1L);
    ruleNodeDebugEventEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(ruleNodeDebugEventEntity, ruleNodeDebugEventEntity2);
  }

  /**
   * Test {@link RuleNodeDebugEventEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeDebugEventEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RuleNodeDebugEventEntity.equals(Object)", "int RuleNodeDebugEventEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    RuleNodeDebugEventEntity ruleNodeDebugEventEntity = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity.setCreatedTime(1L);
    ruleNodeDebugEventEntity.setData("Data");
    ruleNodeDebugEventEntity.setDataType("Data Type");
    ruleNodeDebugEventEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setError("An error occurred");
    ruleNodeDebugEventEntity.setEventEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity.setEventType(null);
    ruleNodeDebugEventEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setMetadata("Metadata");
    ruleNodeDebugEventEntity.setMsgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setMsgType("Msg Type");
    ruleNodeDebugEventEntity.setRelationType("Relation Type");
    ruleNodeDebugEventEntity.setServiceId("42");
    ruleNodeDebugEventEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setTs(1L);
    ruleNodeDebugEventEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RuleNodeDebugEventEntity ruleNodeDebugEventEntity2 = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity2.setCreatedTime(1L);
    ruleNodeDebugEventEntity2.setData("Data");
    ruleNodeDebugEventEntity2.setDataType("Data Type");
    ruleNodeDebugEventEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setError("An error occurred");
    ruleNodeDebugEventEntity2.setEventEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity2.setEventType("Event Type");
    ruleNodeDebugEventEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setMetadata("Metadata");
    ruleNodeDebugEventEntity2.setMsgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setMsgType("Msg Type");
    ruleNodeDebugEventEntity2.setRelationType("Relation Type");
    ruleNodeDebugEventEntity2.setServiceId("42");
    ruleNodeDebugEventEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setTs(1L);
    ruleNodeDebugEventEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(ruleNodeDebugEventEntity, ruleNodeDebugEventEntity2);
  }

  /**
   * Test {@link RuleNodeDebugEventEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeDebugEventEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RuleNodeDebugEventEntity.equals(Object)", "int RuleNodeDebugEventEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    RuleNodeDebugEventEntity ruleNodeDebugEventEntity = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity.setCreatedTime(1L);
    ruleNodeDebugEventEntity.setData("Data");
    ruleNodeDebugEventEntity.setDataType("Data Type");
    ruleNodeDebugEventEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setError("An error occurred");
    ruleNodeDebugEventEntity.setEventEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity.setEventType("Event Type");
    ruleNodeDebugEventEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setMetadata("42");
    ruleNodeDebugEventEntity.setMsgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setMsgType("Msg Type");
    ruleNodeDebugEventEntity.setRelationType("Relation Type");
    ruleNodeDebugEventEntity.setServiceId("42");
    ruleNodeDebugEventEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setTs(1L);
    ruleNodeDebugEventEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RuleNodeDebugEventEntity ruleNodeDebugEventEntity2 = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity2.setCreatedTime(1L);
    ruleNodeDebugEventEntity2.setData("Data");
    ruleNodeDebugEventEntity2.setDataType("Data Type");
    ruleNodeDebugEventEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setError("An error occurred");
    ruleNodeDebugEventEntity2.setEventEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity2.setEventType("Event Type");
    ruleNodeDebugEventEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setMetadata("Metadata");
    ruleNodeDebugEventEntity2.setMsgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setMsgType("Msg Type");
    ruleNodeDebugEventEntity2.setRelationType("Relation Type");
    ruleNodeDebugEventEntity2.setServiceId("42");
    ruleNodeDebugEventEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setTs(1L);
    ruleNodeDebugEventEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(ruleNodeDebugEventEntity, ruleNodeDebugEventEntity2);
  }

  /**
   * Test {@link RuleNodeDebugEventEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeDebugEventEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RuleNodeDebugEventEntity.equals(Object)", "int RuleNodeDebugEventEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    RuleNodeDebugEventEntity ruleNodeDebugEventEntity = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity.setCreatedTime(1L);
    ruleNodeDebugEventEntity.setData("Data");
    ruleNodeDebugEventEntity.setDataType("Data Type");
    ruleNodeDebugEventEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setError("An error occurred");
    ruleNodeDebugEventEntity.setEventEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity.setEventType("Event Type");
    ruleNodeDebugEventEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setMetadata(null);
    ruleNodeDebugEventEntity.setMsgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setMsgType("Msg Type");
    ruleNodeDebugEventEntity.setRelationType("Relation Type");
    ruleNodeDebugEventEntity.setServiceId("42");
    ruleNodeDebugEventEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setTs(1L);
    ruleNodeDebugEventEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RuleNodeDebugEventEntity ruleNodeDebugEventEntity2 = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity2.setCreatedTime(1L);
    ruleNodeDebugEventEntity2.setData("Data");
    ruleNodeDebugEventEntity2.setDataType("Data Type");
    ruleNodeDebugEventEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setError("An error occurred");
    ruleNodeDebugEventEntity2.setEventEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity2.setEventType("Event Type");
    ruleNodeDebugEventEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setMetadata("Metadata");
    ruleNodeDebugEventEntity2.setMsgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setMsgType("Msg Type");
    ruleNodeDebugEventEntity2.setRelationType("Relation Type");
    ruleNodeDebugEventEntity2.setServiceId("42");
    ruleNodeDebugEventEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setTs(1L);
    ruleNodeDebugEventEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(ruleNodeDebugEventEntity, ruleNodeDebugEventEntity2);
  }

  /**
   * Test {@link RuleNodeDebugEventEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeDebugEventEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RuleNodeDebugEventEntity.equals(Object)", "int RuleNodeDebugEventEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    RuleNodeDebugEventEntity ruleNodeDebugEventEntity = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity.setCreatedTime(1L);
    ruleNodeDebugEventEntity.setData("Data");
    ruleNodeDebugEventEntity.setDataType("Data Type");
    ruleNodeDebugEventEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setError("An error occurred");
    ruleNodeDebugEventEntity.setEventEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity.setEventType("Event Type");
    ruleNodeDebugEventEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setMetadata("Metadata");
    ruleNodeDebugEventEntity.setMsgId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setMsgType("Msg Type");
    ruleNodeDebugEventEntity.setRelationType("Relation Type");
    ruleNodeDebugEventEntity.setServiceId("42");
    ruleNodeDebugEventEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setTs(1L);
    ruleNodeDebugEventEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RuleNodeDebugEventEntity ruleNodeDebugEventEntity2 = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity2.setCreatedTime(1L);
    ruleNodeDebugEventEntity2.setData("Data");
    ruleNodeDebugEventEntity2.setDataType("Data Type");
    ruleNodeDebugEventEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setError("An error occurred");
    ruleNodeDebugEventEntity2.setEventEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity2.setEventType("Event Type");
    ruleNodeDebugEventEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setMetadata("Metadata");
    ruleNodeDebugEventEntity2.setMsgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setMsgType("Msg Type");
    ruleNodeDebugEventEntity2.setRelationType("Relation Type");
    ruleNodeDebugEventEntity2.setServiceId("42");
    ruleNodeDebugEventEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setTs(1L);
    ruleNodeDebugEventEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(ruleNodeDebugEventEntity, ruleNodeDebugEventEntity2);
  }

  /**
   * Test {@link RuleNodeDebugEventEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeDebugEventEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RuleNodeDebugEventEntity.equals(Object)", "int RuleNodeDebugEventEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    RuleNodeDebugEventEntity ruleNodeDebugEventEntity = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity.setCreatedTime(1L);
    ruleNodeDebugEventEntity.setData("Data");
    ruleNodeDebugEventEntity.setDataType("Data Type");
    ruleNodeDebugEventEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setError("An error occurred");
    ruleNodeDebugEventEntity.setEventEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity.setEventType("Event Type");
    ruleNodeDebugEventEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setMetadata("Metadata");
    ruleNodeDebugEventEntity.setMsgId(null);
    ruleNodeDebugEventEntity.setMsgType("Msg Type");
    ruleNodeDebugEventEntity.setRelationType("Relation Type");
    ruleNodeDebugEventEntity.setServiceId("42");
    ruleNodeDebugEventEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setTs(1L);
    ruleNodeDebugEventEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RuleNodeDebugEventEntity ruleNodeDebugEventEntity2 = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity2.setCreatedTime(1L);
    ruleNodeDebugEventEntity2.setData("Data");
    ruleNodeDebugEventEntity2.setDataType("Data Type");
    ruleNodeDebugEventEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setError("An error occurred");
    ruleNodeDebugEventEntity2.setEventEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity2.setEventType("Event Type");
    ruleNodeDebugEventEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setMetadata("Metadata");
    ruleNodeDebugEventEntity2.setMsgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setMsgType("Msg Type");
    ruleNodeDebugEventEntity2.setRelationType("Relation Type");
    ruleNodeDebugEventEntity2.setServiceId("42");
    ruleNodeDebugEventEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setTs(1L);
    ruleNodeDebugEventEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(ruleNodeDebugEventEntity, ruleNodeDebugEventEntity2);
  }

  /**
   * Test {@link RuleNodeDebugEventEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeDebugEventEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RuleNodeDebugEventEntity.equals(Object)", "int RuleNodeDebugEventEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    RuleNodeDebugEventEntity ruleNodeDebugEventEntity = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity.setCreatedTime(1L);
    ruleNodeDebugEventEntity.setData("Data");
    ruleNodeDebugEventEntity.setDataType("Data Type");
    ruleNodeDebugEventEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setError("An error occurred");
    ruleNodeDebugEventEntity.setEventEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity.setEventType("Event Type");
    ruleNodeDebugEventEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setMetadata("Metadata");
    ruleNodeDebugEventEntity.setMsgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setMsgType("42");
    ruleNodeDebugEventEntity.setRelationType("Relation Type");
    ruleNodeDebugEventEntity.setServiceId("42");
    ruleNodeDebugEventEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setTs(1L);
    ruleNodeDebugEventEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RuleNodeDebugEventEntity ruleNodeDebugEventEntity2 = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity2.setCreatedTime(1L);
    ruleNodeDebugEventEntity2.setData("Data");
    ruleNodeDebugEventEntity2.setDataType("Data Type");
    ruleNodeDebugEventEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setError("An error occurred");
    ruleNodeDebugEventEntity2.setEventEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity2.setEventType("Event Type");
    ruleNodeDebugEventEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setMetadata("Metadata");
    ruleNodeDebugEventEntity2.setMsgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setMsgType("Msg Type");
    ruleNodeDebugEventEntity2.setRelationType("Relation Type");
    ruleNodeDebugEventEntity2.setServiceId("42");
    ruleNodeDebugEventEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setTs(1L);
    ruleNodeDebugEventEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(ruleNodeDebugEventEntity, ruleNodeDebugEventEntity2);
  }

  /**
   * Test {@link RuleNodeDebugEventEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeDebugEventEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RuleNodeDebugEventEntity.equals(Object)", "int RuleNodeDebugEventEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual19() {
    // Arrange
    RuleNodeDebugEventEntity ruleNodeDebugEventEntity = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity.setCreatedTime(1L);
    ruleNodeDebugEventEntity.setData("Data");
    ruleNodeDebugEventEntity.setDataType("Data Type");
    ruleNodeDebugEventEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setError("An error occurred");
    ruleNodeDebugEventEntity.setEventEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity.setEventType("Event Type");
    ruleNodeDebugEventEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setMetadata("Metadata");
    ruleNodeDebugEventEntity.setMsgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setMsgType(null);
    ruleNodeDebugEventEntity.setRelationType("Relation Type");
    ruleNodeDebugEventEntity.setServiceId("42");
    ruleNodeDebugEventEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setTs(1L);
    ruleNodeDebugEventEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RuleNodeDebugEventEntity ruleNodeDebugEventEntity2 = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity2.setCreatedTime(1L);
    ruleNodeDebugEventEntity2.setData("Data");
    ruleNodeDebugEventEntity2.setDataType("Data Type");
    ruleNodeDebugEventEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setError("An error occurred");
    ruleNodeDebugEventEntity2.setEventEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity2.setEventType("Event Type");
    ruleNodeDebugEventEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setMetadata("Metadata");
    ruleNodeDebugEventEntity2.setMsgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setMsgType("Msg Type");
    ruleNodeDebugEventEntity2.setRelationType("Relation Type");
    ruleNodeDebugEventEntity2.setServiceId("42");
    ruleNodeDebugEventEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setTs(1L);
    ruleNodeDebugEventEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(ruleNodeDebugEventEntity, ruleNodeDebugEventEntity2);
  }

  /**
   * Test {@link RuleNodeDebugEventEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeDebugEventEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RuleNodeDebugEventEntity.equals(Object)", "int RuleNodeDebugEventEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual20() {
    // Arrange
    RuleNodeDebugEventEntity ruleNodeDebugEventEntity = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity.setCreatedTime(1L);
    ruleNodeDebugEventEntity.setData("Data");
    ruleNodeDebugEventEntity.setDataType("Data Type");
    ruleNodeDebugEventEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setError("An error occurred");
    ruleNodeDebugEventEntity.setEventEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity.setEventType("Event Type");
    ruleNodeDebugEventEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setMetadata("Metadata");
    ruleNodeDebugEventEntity.setMsgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setMsgType("Msg Type");
    ruleNodeDebugEventEntity.setRelationType("42");
    ruleNodeDebugEventEntity.setServiceId("42");
    ruleNodeDebugEventEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setTs(1L);
    ruleNodeDebugEventEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RuleNodeDebugEventEntity ruleNodeDebugEventEntity2 = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity2.setCreatedTime(1L);
    ruleNodeDebugEventEntity2.setData("Data");
    ruleNodeDebugEventEntity2.setDataType("Data Type");
    ruleNodeDebugEventEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setError("An error occurred");
    ruleNodeDebugEventEntity2.setEventEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity2.setEventType("Event Type");
    ruleNodeDebugEventEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setMetadata("Metadata");
    ruleNodeDebugEventEntity2.setMsgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setMsgType("Msg Type");
    ruleNodeDebugEventEntity2.setRelationType("Relation Type");
    ruleNodeDebugEventEntity2.setServiceId("42");
    ruleNodeDebugEventEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setTs(1L);
    ruleNodeDebugEventEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(ruleNodeDebugEventEntity, ruleNodeDebugEventEntity2);
  }

  /**
   * Test {@link RuleNodeDebugEventEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeDebugEventEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RuleNodeDebugEventEntity.equals(Object)", "int RuleNodeDebugEventEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual21() {
    // Arrange
    RuleNodeDebugEventEntity ruleNodeDebugEventEntity = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity.setCreatedTime(1L);
    ruleNodeDebugEventEntity.setData("Data");
    ruleNodeDebugEventEntity.setDataType("Data Type");
    ruleNodeDebugEventEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setError("An error occurred");
    ruleNodeDebugEventEntity.setEventEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity.setEventType("Event Type");
    ruleNodeDebugEventEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setMetadata("Metadata");
    ruleNodeDebugEventEntity.setMsgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setMsgType("Msg Type");
    ruleNodeDebugEventEntity.setRelationType(null);
    ruleNodeDebugEventEntity.setServiceId("42");
    ruleNodeDebugEventEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setTs(1L);
    ruleNodeDebugEventEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RuleNodeDebugEventEntity ruleNodeDebugEventEntity2 = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity2.setCreatedTime(1L);
    ruleNodeDebugEventEntity2.setData("Data");
    ruleNodeDebugEventEntity2.setDataType("Data Type");
    ruleNodeDebugEventEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setError("An error occurred");
    ruleNodeDebugEventEntity2.setEventEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity2.setEventType("Event Type");
    ruleNodeDebugEventEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setMetadata("Metadata");
    ruleNodeDebugEventEntity2.setMsgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setMsgType("Msg Type");
    ruleNodeDebugEventEntity2.setRelationType("Relation Type");
    ruleNodeDebugEventEntity2.setServiceId("42");
    ruleNodeDebugEventEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity2.setTs(1L);
    ruleNodeDebugEventEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(ruleNodeDebugEventEntity, ruleNodeDebugEventEntity2);
  }

  /**
   * Test {@link RuleNodeDebugEventEntity#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeDebugEventEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RuleNodeDebugEventEntity.equals(Object)", "int RuleNodeDebugEventEntity.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    RuleNodeDebugEventEntity ruleNodeDebugEventEntity = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity.setCreatedTime(1L);
    ruleNodeDebugEventEntity.setData("Data");
    ruleNodeDebugEventEntity.setDataType("Data Type");
    ruleNodeDebugEventEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setError("An error occurred");
    ruleNodeDebugEventEntity.setEventEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity.setEventType("Event Type");
    ruleNodeDebugEventEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setMetadata("Metadata");
    ruleNodeDebugEventEntity.setMsgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setMsgType("Msg Type");
    ruleNodeDebugEventEntity.setRelationType("Relation Type");
    ruleNodeDebugEventEntity.setServiceId("42");
    ruleNodeDebugEventEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setTs(1L);
    ruleNodeDebugEventEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(ruleNodeDebugEventEntity, null);
  }

  /**
   * Test {@link RuleNodeDebugEventEntity#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeDebugEventEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RuleNodeDebugEventEntity.equals(Object)", "int RuleNodeDebugEventEntity.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    RuleNodeDebugEventEntity ruleNodeDebugEventEntity = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity.setCreatedTime(1L);
    ruleNodeDebugEventEntity.setData("Data");
    ruleNodeDebugEventEntity.setDataType("Data Type");
    ruleNodeDebugEventEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setError("An error occurred");
    ruleNodeDebugEventEntity.setEventEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity.setEventType("Event Type");
    ruleNodeDebugEventEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setMetadata("Metadata");
    ruleNodeDebugEventEntity.setMsgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setMsgType("Msg Type");
    ruleNodeDebugEventEntity.setRelationType("Relation Type");
    ruleNodeDebugEventEntity.setServiceId("42");
    ruleNodeDebugEventEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setTs(1L);
    ruleNodeDebugEventEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(ruleNodeDebugEventEntity, "Different type to RuleNodeDebugEventEntity");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RuleNodeDebugEventEntity#RuleNodeDebugEventEntity()}
   *   <li>{@link RuleNodeDebugEventEntity#setData(String)}
   *   <li>{@link RuleNodeDebugEventEntity#setDataType(String)}
   *   <li>{@link RuleNodeDebugEventEntity#setError(String)}
   *   <li>{@link RuleNodeDebugEventEntity#setEventEntityId(UUID)}
   *   <li>{@link RuleNodeDebugEventEntity#setEventEntityType(String)}
   *   <li>{@link RuleNodeDebugEventEntity#setEventType(String)}
   *   <li>{@link RuleNodeDebugEventEntity#setMetadata(String)}
   *   <li>{@link RuleNodeDebugEventEntity#setMsgId(UUID)}
   *   <li>{@link RuleNodeDebugEventEntity#setMsgType(String)}
   *   <li>{@link RuleNodeDebugEventEntity#setRelationType(String)}
   *   <li>{@link RuleNodeDebugEventEntity#toString()}
   *   <li>{@link RuleNodeDebugEventEntity#getData()}
   *   <li>{@link RuleNodeDebugEventEntity#getDataType()}
   *   <li>{@link RuleNodeDebugEventEntity#getError()}
   *   <li>{@link RuleNodeDebugEventEntity#getEventEntityId()}
   *   <li>{@link RuleNodeDebugEventEntity#getEventEntityType()}
   *   <li>{@link RuleNodeDebugEventEntity#getEventType()}
   *   <li>{@link RuleNodeDebugEventEntity#getMetadata()}
   *   <li>{@link RuleNodeDebugEventEntity#getMsgId()}
   *   <li>{@link RuleNodeDebugEventEntity#getMsgType()}
   *   <li>{@link RuleNodeDebugEventEntity#getRelationType()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RuleNodeDebugEventEntity.<init>()", "String RuleNodeDebugEventEntity.getData()",
      "String RuleNodeDebugEventEntity.getDataType()", "String RuleNodeDebugEventEntity.getError()",
      "UUID RuleNodeDebugEventEntity.getEventEntityId()", "String RuleNodeDebugEventEntity.getEventEntityType()",
      "String RuleNodeDebugEventEntity.getEventType()", "String RuleNodeDebugEventEntity.getMetadata()",
      "UUID RuleNodeDebugEventEntity.getMsgId()", "String RuleNodeDebugEventEntity.getMsgType()",
      "String RuleNodeDebugEventEntity.getRelationType()", "void RuleNodeDebugEventEntity.setData(String)",
      "void RuleNodeDebugEventEntity.setDataType(String)", "void RuleNodeDebugEventEntity.setError(String)",
      "void RuleNodeDebugEventEntity.setEventEntityId(UUID)",
      "void RuleNodeDebugEventEntity.setEventEntityType(String)", "void RuleNodeDebugEventEntity.setEventType(String)",
      "void RuleNodeDebugEventEntity.setMetadata(String)", "void RuleNodeDebugEventEntity.setMsgId(UUID)",
      "void RuleNodeDebugEventEntity.setMsgType(String)", "void RuleNodeDebugEventEntity.setRelationType(String)",
      "String RuleNodeDebugEventEntity.toString()"})
  public void testGettersAndSetters() {
    // Arrange and Act
    RuleNodeDebugEventEntity actualRuleNodeDebugEventEntity = new RuleNodeDebugEventEntity();
    actualRuleNodeDebugEventEntity.setData("Data");
    actualRuleNodeDebugEventEntity.setDataType("Data Type");
    actualRuleNodeDebugEventEntity.setError("An error occurred");
    UUID eventEntityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualRuleNodeDebugEventEntity.setEventEntityId(eventEntityId);
    actualRuleNodeDebugEventEntity.setEventEntityType("Event Entity Type");
    actualRuleNodeDebugEventEntity.setEventType("Event Type");
    actualRuleNodeDebugEventEntity.setMetadata("Metadata");
    UUID msgId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualRuleNodeDebugEventEntity.setMsgId(msgId);
    actualRuleNodeDebugEventEntity.setMsgType("Msg Type");
    actualRuleNodeDebugEventEntity.setRelationType("Relation Type");
    String actualToStringResult = actualRuleNodeDebugEventEntity.toString();
    String actualData = actualRuleNodeDebugEventEntity.getData();
    String actualDataType = actualRuleNodeDebugEventEntity.getDataType();
    String actualError = actualRuleNodeDebugEventEntity.getError();
    UUID actualEventEntityId = actualRuleNodeDebugEventEntity.getEventEntityId();
    String actualEventEntityType = actualRuleNodeDebugEventEntity.getEventEntityType();
    String actualEventType = actualRuleNodeDebugEventEntity.getEventType();
    String actualMetadata = actualRuleNodeDebugEventEntity.getMetadata();
    UUID actualMsgId = actualRuleNodeDebugEventEntity.getMsgId();
    String actualMsgType = actualRuleNodeDebugEventEntity.getMsgType();
    String actualRelationType = actualRuleNodeDebugEventEntity.getRelationType();

    // Assert
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualEventEntityId.toString());
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualMsgId.toString());
    assertEquals("An error occurred", actualError);
    assertEquals("Data Type", actualDataType);
    assertEquals("Data", actualData);
    assertEquals("Event Entity Type", actualEventEntityType);
    assertEquals("Event Type", actualEventType);
    assertEquals("Metadata", actualMetadata);
    assertEquals("Msg Type", actualMsgType);
    assertEquals("Relation Type", actualRelationType);
    assertEquals("RuleNodeDebugEventEntity(eventType=Event Type, eventEntityId=784f394c-42b6-435a-983c-b7beff2784f9,"
        + " eventEntityType=Event Entity Type, msgId=784f394c-42b6-435a-983c-b7beff2784f9, msgType=Msg Type,"
        + " dataType=Data Type, relationType=Relation Type, data=Data, metadata=Metadata, error=An error"
        + " occurred)", actualToStringResult);
    assertNull(actualRuleNodeDebugEventEntity.getServiceId());
    assertNull(actualRuleNodeDebugEventEntity.getEntityId());
    assertNull(actualRuleNodeDebugEventEntity.getId());
    assertNull(actualRuleNodeDebugEventEntity.getTenantId());
    assertNull(actualRuleNodeDebugEventEntity.getUuid());
    assertEquals(0L, actualRuleNodeDebugEventEntity.getCreatedTime());
    assertEquals(0L, actualRuleNodeDebugEventEntity.getTs());
    assertSame(eventEntityId, actualEventEntityId);
    assertSame(msgId, actualMsgId);
  }
}
