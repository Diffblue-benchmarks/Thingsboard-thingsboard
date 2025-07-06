package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.event.RuleNodeDebugEvent;
import org.thingsboard.server.common.data.event.RuleNodeDebugEvent.RuleNodeDebugEventBuilder;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.EventId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;

public class RuleNodeDebugEventEntityDiffblueTest {
  /**
   * Test {@link RuleNodeDebugEventEntity#equals(Object)}, and {@link
   * RuleNodeDebugEventEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuleNodeDebugEventEntity#equals(Object)}
   *   <li>{@link RuleNodeDebugEventEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean RuleNodeDebugEventEntity.equals(Object)",
    "int RuleNodeDebugEventEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RuleNodeDebugEventEntity ruleNodeDebugEventEntity = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity.setCreatedTime(1L);
    ruleNodeDebugEventEntity.setData("Data");
    ruleNodeDebugEventEntity.setDataType("Data Type");
    ruleNodeDebugEventEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setError("An error occurred");
    ruleNodeDebugEventEntity.setEventEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    ruleNodeDebugEventEntity2.setEventEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
   * Test {@link RuleNodeDebugEventEntity#equals(Object)}, and {@link
   * RuleNodeDebugEventEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuleNodeDebugEventEntity#equals(Object)}
   *   <li>{@link RuleNodeDebugEventEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean RuleNodeDebugEventEntity.equals(Object)",
    "int RuleNodeDebugEventEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RuleNodeDebugEventEntity ruleNodeDebugEventEntity = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity.setCreatedTime(1L);
    ruleNodeDebugEventEntity.setData("Data");
    ruleNodeDebugEventEntity.setDataType("Data Type");
    ruleNodeDebugEventEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setError("An error occurred");
    ruleNodeDebugEventEntity.setEventEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeDebugEventEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean RuleNodeDebugEventEntity.equals(Object)",
    "int RuleNodeDebugEventEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RuleNodeDebugEventEntity ruleNodeDebugEventEntity = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity.setCreatedTime(1L);
    ruleNodeDebugEventEntity.setData("42");
    ruleNodeDebugEventEntity.setDataType("Data Type");
    ruleNodeDebugEventEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setError("An error occurred");
    ruleNodeDebugEventEntity.setEventEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    ruleNodeDebugEventEntity2.setEventEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeDebugEventEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean RuleNodeDebugEventEntity.equals(Object)",
    "int RuleNodeDebugEventEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RuleNodeDebugEventEntity ruleNodeDebugEventEntity = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity.setCreatedTime(1L);
    ruleNodeDebugEventEntity.setData(null);
    ruleNodeDebugEventEntity.setDataType("Data Type");
    ruleNodeDebugEventEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setError("An error occurred");
    ruleNodeDebugEventEntity.setEventEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    ruleNodeDebugEventEntity2.setEventEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeDebugEventEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean RuleNodeDebugEventEntity.equals(Object)",
    "int RuleNodeDebugEventEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RuleNodeDebugEventEntity ruleNodeDebugEventEntity = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity.setCreatedTime(1L);
    ruleNodeDebugEventEntity.setData("Data");
    ruleNodeDebugEventEntity.setDataType("42");
    ruleNodeDebugEventEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setError("An error occurred");
    ruleNodeDebugEventEntity.setEventEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    ruleNodeDebugEventEntity2.setEventEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeDebugEventEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean RuleNodeDebugEventEntity.equals(Object)",
    "int RuleNodeDebugEventEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    RuleNodeDebugEventEntity ruleNodeDebugEventEntity = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity.setCreatedTime(1L);
    ruleNodeDebugEventEntity.setData("Data");
    ruleNodeDebugEventEntity.setDataType(null);
    ruleNodeDebugEventEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setError("An error occurred");
    ruleNodeDebugEventEntity.setEventEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    ruleNodeDebugEventEntity2.setEventEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeDebugEventEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean RuleNodeDebugEventEntity.equals(Object)",
    "int RuleNodeDebugEventEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    RuleNodeDebugEventEntity ruleNodeDebugEventEntity = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity.setCreatedTime(1L);
    ruleNodeDebugEventEntity.setData("Data");
    ruleNodeDebugEventEntity.setDataType("Data Type");
    ruleNodeDebugEventEntity.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setError("An error occurred");
    ruleNodeDebugEventEntity.setEventEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    ruleNodeDebugEventEntity2.setEventEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeDebugEventEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean RuleNodeDebugEventEntity.equals(Object)",
    "int RuleNodeDebugEventEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    RuleNodeDebugEventEntity ruleNodeDebugEventEntity = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity.setCreatedTime(1L);
    ruleNodeDebugEventEntity.setData("Data");
    ruleNodeDebugEventEntity.setDataType("Data Type");
    ruleNodeDebugEventEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setError("42");
    ruleNodeDebugEventEntity.setEventEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    ruleNodeDebugEventEntity2.setEventEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeDebugEventEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean RuleNodeDebugEventEntity.equals(Object)",
    "int RuleNodeDebugEventEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    RuleNodeDebugEventEntity ruleNodeDebugEventEntity = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity.setCreatedTime(1L);
    ruleNodeDebugEventEntity.setData("Data");
    ruleNodeDebugEventEntity.setDataType("Data Type");
    ruleNodeDebugEventEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setError(null);
    ruleNodeDebugEventEntity.setEventEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    ruleNodeDebugEventEntity2.setEventEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeDebugEventEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean RuleNodeDebugEventEntity.equals(Object)",
    "int RuleNodeDebugEventEntity.hashCode()"
  })
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
    ruleNodeDebugEventEntity2.setEventEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeDebugEventEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean RuleNodeDebugEventEntity.equals(Object)",
    "int RuleNodeDebugEventEntity.hashCode()"
  })
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
    ruleNodeDebugEventEntity2.setEventEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeDebugEventEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean RuleNodeDebugEventEntity.equals(Object)",
    "int RuleNodeDebugEventEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    RuleNodeDebugEventEntity ruleNodeDebugEventEntity = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity.setCreatedTime(1L);
    ruleNodeDebugEventEntity.setData("Data");
    ruleNodeDebugEventEntity.setDataType("Data Type");
    ruleNodeDebugEventEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setError("An error occurred");
    ruleNodeDebugEventEntity.setEventEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    ruleNodeDebugEventEntity2.setEventEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeDebugEventEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean RuleNodeDebugEventEntity.equals(Object)",
    "int RuleNodeDebugEventEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    RuleNodeDebugEventEntity ruleNodeDebugEventEntity = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity.setCreatedTime(1L);
    ruleNodeDebugEventEntity.setData("Data");
    ruleNodeDebugEventEntity.setDataType("Data Type");
    ruleNodeDebugEventEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setError("An error occurred");
    ruleNodeDebugEventEntity.setEventEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    ruleNodeDebugEventEntity2.setEventEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeDebugEventEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean RuleNodeDebugEventEntity.equals(Object)",
    "int RuleNodeDebugEventEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    RuleNodeDebugEventEntity ruleNodeDebugEventEntity = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity.setCreatedTime(1L);
    ruleNodeDebugEventEntity.setData("Data");
    ruleNodeDebugEventEntity.setDataType("Data Type");
    ruleNodeDebugEventEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setError("An error occurred");
    ruleNodeDebugEventEntity.setEventEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    ruleNodeDebugEventEntity2.setEventEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeDebugEventEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean RuleNodeDebugEventEntity.equals(Object)",
    "int RuleNodeDebugEventEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    RuleNodeDebugEventEntity ruleNodeDebugEventEntity = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity.setCreatedTime(1L);
    ruleNodeDebugEventEntity.setData("Data");
    ruleNodeDebugEventEntity.setDataType("Data Type");
    ruleNodeDebugEventEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setError("An error occurred");
    ruleNodeDebugEventEntity.setEventEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    ruleNodeDebugEventEntity2.setEventEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeDebugEventEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean RuleNodeDebugEventEntity.equals(Object)",
    "int RuleNodeDebugEventEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    RuleNodeDebugEventEntity ruleNodeDebugEventEntity = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity.setCreatedTime(1L);
    ruleNodeDebugEventEntity.setData("Data");
    ruleNodeDebugEventEntity.setDataType("Data Type");
    ruleNodeDebugEventEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setError("An error occurred");
    ruleNodeDebugEventEntity.setEventEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    ruleNodeDebugEventEntity2.setEventEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeDebugEventEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean RuleNodeDebugEventEntity.equals(Object)",
    "int RuleNodeDebugEventEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    RuleNodeDebugEventEntity ruleNodeDebugEventEntity = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity.setCreatedTime(1L);
    ruleNodeDebugEventEntity.setData("Data");
    ruleNodeDebugEventEntity.setDataType("Data Type");
    ruleNodeDebugEventEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setError("An error occurred");
    ruleNodeDebugEventEntity.setEventEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    ruleNodeDebugEventEntity2.setEventEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeDebugEventEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean RuleNodeDebugEventEntity.equals(Object)",
    "int RuleNodeDebugEventEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    RuleNodeDebugEventEntity ruleNodeDebugEventEntity = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity.setCreatedTime(1L);
    ruleNodeDebugEventEntity.setData("Data");
    ruleNodeDebugEventEntity.setDataType("Data Type");
    ruleNodeDebugEventEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setError("An error occurred");
    ruleNodeDebugEventEntity.setEventEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    ruleNodeDebugEventEntity2.setEventEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeDebugEventEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean RuleNodeDebugEventEntity.equals(Object)",
    "int RuleNodeDebugEventEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    RuleNodeDebugEventEntity ruleNodeDebugEventEntity = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity.setCreatedTime(1L);
    ruleNodeDebugEventEntity.setData("Data");
    ruleNodeDebugEventEntity.setDataType("Data Type");
    ruleNodeDebugEventEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setError("An error occurred");
    ruleNodeDebugEventEntity.setEventEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    ruleNodeDebugEventEntity2.setEventEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeDebugEventEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean RuleNodeDebugEventEntity.equals(Object)",
    "int RuleNodeDebugEventEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    RuleNodeDebugEventEntity ruleNodeDebugEventEntity = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity.setCreatedTime(1L);
    ruleNodeDebugEventEntity.setData("Data");
    ruleNodeDebugEventEntity.setDataType("Data Type");
    ruleNodeDebugEventEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setError("An error occurred");
    ruleNodeDebugEventEntity.setEventEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    ruleNodeDebugEventEntity2.setEventEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeDebugEventEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean RuleNodeDebugEventEntity.equals(Object)",
    "int RuleNodeDebugEventEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual19() {
    // Arrange
    RuleNodeDebugEventEntity ruleNodeDebugEventEntity = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity.setCreatedTime(1L);
    ruleNodeDebugEventEntity.setData("Data");
    ruleNodeDebugEventEntity.setDataType("Data Type");
    ruleNodeDebugEventEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setError("An error occurred");
    ruleNodeDebugEventEntity.setEventEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    ruleNodeDebugEventEntity2.setEventEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeDebugEventEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean RuleNodeDebugEventEntity.equals(Object)",
    "int RuleNodeDebugEventEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual20() {
    // Arrange
    RuleNodeDebugEventEntity ruleNodeDebugEventEntity = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity.setCreatedTime(1L);
    ruleNodeDebugEventEntity.setData("Data");
    ruleNodeDebugEventEntity.setDataType("Data Type");
    ruleNodeDebugEventEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setError("An error occurred");
    ruleNodeDebugEventEntity.setEventEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    ruleNodeDebugEventEntity2.setEventEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeDebugEventEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean RuleNodeDebugEventEntity.equals(Object)",
    "int RuleNodeDebugEventEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual21() {
    // Arrange
    RuleNodeDebugEventEntity ruleNodeDebugEventEntity = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity.setCreatedTime(1L);
    ruleNodeDebugEventEntity.setData("Data");
    ruleNodeDebugEventEntity.setDataType("Data Type");
    ruleNodeDebugEventEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setError("An error occurred");
    ruleNodeDebugEventEntity.setEventEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    ruleNodeDebugEventEntity2.setEventEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeDebugEventEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean RuleNodeDebugEventEntity.equals(Object)",
    "int RuleNodeDebugEventEntity.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    RuleNodeDebugEventEntity ruleNodeDebugEventEntity = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity.setCreatedTime(1L);
    ruleNodeDebugEventEntity.setData("Data");
    ruleNodeDebugEventEntity.setDataType("Data Type");
    ruleNodeDebugEventEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setError("An error occurred");
    ruleNodeDebugEventEntity.setEventEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeDebugEventEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean RuleNodeDebugEventEntity.equals(Object)",
    "int RuleNodeDebugEventEntity.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    RuleNodeDebugEventEntity ruleNodeDebugEventEntity = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity.setCreatedTime(1L);
    ruleNodeDebugEventEntity.setData("Data");
    ruleNodeDebugEventEntity.setDataType("Data Type");
    ruleNodeDebugEventEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setError("An error occurred");
    ruleNodeDebugEventEntity.setEventEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
   *
   * <p>Methods under test:
   *
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
  @MethodsUnderTest({
    "void RuleNodeDebugEventEntity.<init>()",
    "String RuleNodeDebugEventEntity.getData()",
    "String RuleNodeDebugEventEntity.getDataType()",
    "String RuleNodeDebugEventEntity.getError()",
    "UUID RuleNodeDebugEventEntity.getEventEntityId()",
    "String RuleNodeDebugEventEntity.getEventEntityType()",
    "String RuleNodeDebugEventEntity.getEventType()",
    "String RuleNodeDebugEventEntity.getMetadata()",
    "UUID RuleNodeDebugEventEntity.getMsgId()",
    "String RuleNodeDebugEventEntity.getMsgType()",
    "String RuleNodeDebugEventEntity.getRelationType()",
    "void RuleNodeDebugEventEntity.setData(String)",
    "void RuleNodeDebugEventEntity.setDataType(String)",
    "void RuleNodeDebugEventEntity.setError(String)",
    "void RuleNodeDebugEventEntity.setEventEntityId(UUID)",
    "void RuleNodeDebugEventEntity.setEventEntityType(String)",
    "void RuleNodeDebugEventEntity.setEventType(String)",
    "void RuleNodeDebugEventEntity.setMetadata(String)",
    "void RuleNodeDebugEventEntity.setMsgId(UUID)",
    "void RuleNodeDebugEventEntity.setMsgType(String)",
    "void RuleNodeDebugEventEntity.setRelationType(String)",
    "String RuleNodeDebugEventEntity.toString()"
  })
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
    assertEquals(
        "RuleNodeDebugEventEntity(eventType=Event Type, eventEntityId=784f394c-42b6-435a-983c-b7beff2784f9,"
            + " eventEntityType=Event Entity Type, msgId=784f394c-42b6-435a-983c-b7beff2784f9, msgType=Msg Type,"
            + " dataType=Data Type, relationType=Relation Type, data=Data, metadata=Metadata, error=An error"
            + " occurred)",
        actualToStringResult);
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

  /**
   * Test {@link RuleNodeDebugEventEntity#RuleNodeDebugEventEntity(RuleNodeDebugEvent)}.
   *
   * <p>Method under test: {@link
   * RuleNodeDebugEventEntity#RuleNodeDebugEventEntity(RuleNodeDebugEvent)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RuleNodeDebugEventEntity.<init>(RuleNodeDebugEvent)"})
  public void testNewRuleNodeDebugEventEntity() {
    // Arrange
    RuleNodeDebugEventBuilder dataTypeResult =
        RuleNodeDebugEvent.builder().data("Data").dataType("Data Type");
    RuleNodeDebugEventBuilder eventTypeResult =
        dataTypeResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred")
            .eventEntity(BaseEntityService.NULL_CUSTOMER_ID)
            .eventType("Event Type");
    RuleNodeDebugEventBuilder metadataResult =
        eventTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .metadata("Metadata");
    RuleNodeDebugEvent event =
        metadataResult
            .msgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .msgType("Msg Type")
            .relationType("Relation Type")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build();

    // Act
    RuleNodeDebugEventEntity actualRuleNodeDebugEventEntity = new RuleNodeDebugEventEntity(event);

    // Assert
    UUID eventEntityId = actualRuleNodeDebugEventEntity.getEventEntityId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", eventEntityId.toString());
    assertEquals("CUSTOMER", actualRuleNodeDebugEventEntity.getEventEntityType());
    assertSame(eventEntityId, actualRuleNodeDebugEventEntity.getTenantId());
  }

  /**
   * Test {@link RuleNodeDebugEventEntity#RuleNodeDebugEventEntity(RuleNodeDebugEvent)}.
   *
   * <p>Method under test: {@link
   * RuleNodeDebugEventEntity#RuleNodeDebugEventEntity(RuleNodeDebugEvent)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RuleNodeDebugEventEntity.<init>(RuleNodeDebugEvent)"})
  public void testNewRuleNodeDebugEventEntity2() {
    // Arrange
    RuleNodeDebugEvent event = mock(RuleNodeDebugEvent.class);
    when(event.getEventEntity()).thenReturn(null);
    when(event.getServiceId()).thenReturn("42");
    when(event.getData()).thenReturn("Data");
    when(event.getDataType()).thenReturn("Data Type");
    when(event.getError()).thenReturn("An error occurred");
    when(event.getEventType()).thenReturn("Event Type");
    when(event.getMetadata()).thenReturn("Metadata");
    when(event.getMsgType()).thenReturn("Msg Type");
    when(event.getRelationType()).thenReturn("Relation Type");
    when(event.getEntityId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(event.getMsgId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(event.getCreatedTime()).thenReturn(1L);
    when(event.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(event.getId())
        .thenReturn(new EventId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    RuleNodeDebugEventEntity actualRuleNodeDebugEventEntity = new RuleNodeDebugEventEntity(event);

    // Assert
    verify(event).getCreatedTime();
    verify(event).getEntityId();
    verify(event).getServiceId();
    verify(event).getTenantId();
    verify(event).getData();
    verify(event).getDataType();
    verify(event).getError();
    verify(event).getEventEntity();
    verify(event).getEventType();
    verify(event).getMetadata();
    verify(event).getMsgId();
    verify(event).getMsgType();
    verify(event).getRelationType();
    verify(event).getId();
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080",
        actualRuleNodeDebugEventEntity.getTenantId().toString());
    assertNull(actualRuleNodeDebugEventEntity.getEventEntityType());
    assertNull(actualRuleNodeDebugEventEntity.getEventEntityId());
  }

  /**
   * Test {@link RuleNodeDebugEventEntity#RuleNodeDebugEventEntity(RuleNodeDebugEvent)}.
   *
   * <ul>
   *   <li>Given {@link BaseEntityService#NULL_CUSTOMER_ID}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleNodeDebugEventEntity#RuleNodeDebugEventEntity(RuleNodeDebugEvent)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RuleNodeDebugEventEntity.<init>(RuleNodeDebugEvent)"})
  public void testNewRuleNodeDebugEventEntity_givenNull_customer_id() {
    // Arrange
    RuleNodeDebugEvent event = mock(RuleNodeDebugEvent.class);
    when(event.getServiceId()).thenReturn("42");
    when(event.getData()).thenReturn("Data");
    when(event.getDataType()).thenReturn("Data Type");
    when(event.getError()).thenReturn("An error occurred");
    when(event.getEventType()).thenReturn("Event Type");
    when(event.getMetadata()).thenReturn("Metadata");
    when(event.getMsgType()).thenReturn("Msg Type");
    when(event.getRelationType()).thenReturn("Relation Type");
    when(event.getEntityId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(event.getMsgId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(event.getCreatedTime()).thenReturn(1L);
    when(event.getEventEntity()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(event.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(event.getId())
        .thenReturn(new EventId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    RuleNodeDebugEventEntity actualRuleNodeDebugEventEntity = new RuleNodeDebugEventEntity(event);

    // Assert
    verify(event).getCreatedTime();
    verify(event).getEntityId();
    verify(event).getServiceId();
    verify(event).getTenantId();
    verify(event).getData();
    verify(event).getDataType();
    verify(event).getError();
    verify(event, atLeast(1)).getEventEntity();
    verify(event).getEventType();
    verify(event).getMetadata();
    verify(event).getMsgId();
    verify(event).getMsgType();
    verify(event).getRelationType();
    verify(event).getId();
    UUID eventEntityId = actualRuleNodeDebugEventEntity.getEventEntityId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", eventEntityId.toString());
    assertEquals("CUSTOMER", actualRuleNodeDebugEventEntity.getEventEntityType());
    assertSame(eventEntityId, actualRuleNodeDebugEventEntity.getTenantId());
  }

  /**
   * Test {@link RuleNodeDebugEventEntity#RuleNodeDebugEventEntity(RuleNodeDebugEvent)}.
   *
   * <ul>
   *   <li>Then return EventEntityType is {@code TENANT}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleNodeDebugEventEntity#RuleNodeDebugEventEntity(RuleNodeDebugEvent)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RuleNodeDebugEventEntity.<init>(RuleNodeDebugEvent)"})
  public void testNewRuleNodeDebugEventEntity_thenReturnEventEntityTypeIsTenant() {
    // Arrange
    RuleNodeDebugEvent event = mock(RuleNodeDebugEvent.class);
    when(event.getEventEntity()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(event.getServiceId()).thenReturn("42");
    when(event.getData()).thenReturn("Data");
    when(event.getDataType()).thenReturn("Data Type");
    when(event.getError()).thenReturn("An error occurred");
    when(event.getEventType()).thenReturn("Event Type");
    when(event.getMetadata()).thenReturn("Metadata");
    when(event.getMsgType()).thenReturn("Msg Type");
    when(event.getRelationType()).thenReturn("Relation Type");
    when(event.getEntityId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(event.getMsgId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(event.getCreatedTime()).thenReturn(1L);
    when(event.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(event.getId())
        .thenReturn(new EventId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    RuleNodeDebugEventEntity actualRuleNodeDebugEventEntity = new RuleNodeDebugEventEntity(event);

    // Assert
    verify(event).getCreatedTime();
    verify(event).getEntityId();
    verify(event).getServiceId();
    verify(event).getTenantId();
    verify(event).getData();
    verify(event).getDataType();
    verify(event).getError();
    verify(event, atLeast(1)).getEventEntity();
    verify(event).getEventType();
    verify(event).getMetadata();
    verify(event).getMsgId();
    verify(event).getMsgType();
    verify(event).getRelationType();
    verify(event).getId();
    UUID eventEntityId = actualRuleNodeDebugEventEntity.getEventEntityId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", eventEntityId.toString());
    assertEquals("TENANT", actualRuleNodeDebugEventEntity.getEventEntityType());
    assertSame(eventEntityId, actualRuleNodeDebugEventEntity.getTenantId());
  }

  /**
   * Test {@link RuleNodeDebugEventEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link RuleNodeDebugEventEntity#RuleNodeDebugEventEntity()}.
   *   <li>Then return ServiceId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeDebugEventEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"RuleNodeDebugEvent RuleNodeDebugEventEntity.toData()"})
  public void testToData_givenRuleNodeDebugEventEntity_thenReturnServiceIdIsNull() {
    // Arrange and Act
    RuleNodeDebugEvent actualToDataResult = new RuleNodeDebugEventEntity().toData();

    // Assert
    assertNull(actualToDataResult.getServiceId());
    assertNull(actualToDataResult.getData());
    assertNull(actualToDataResult.getDataType());
    assertNull(actualToDataResult.getError());
    assertNull(actualToDataResult.getEventType());
    assertNull(actualToDataResult.getMetadata());
    assertNull(actualToDataResult.getMsgType());
    assertNull(actualToDataResult.getRelationType());
    assertNull(actualToDataResult.getEntityId());
    assertNull(actualToDataResult.getMsgId());
    assertNull(actualToDataResult.getUuidId());
    assertNull(actualToDataResult.getId());
    assertEquals(0L, actualToDataResult.getCreatedTime());
  }

  /**
   * Test {@link RuleNodeDebugEventEntity#toData()}.
   *
   * <ul>
   *   <li>Then EventEntity return {@link AlarmId}.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeDebugEventEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"RuleNodeDebugEvent RuleNodeDebugEventEntity.toData()"})
  public void testToData_thenEventEntityReturnAlarmId() {
    // Arrange
    RuleNodeDebugEventBuilder dataTypeResult =
        RuleNodeDebugEvent.builder().data("Data").dataType("Data Type");
    RuleNodeDebugEventBuilder errorResult =
        dataTypeResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred");
    AlarmId eventEntity = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleNodeDebugEventBuilder eventTypeResult =
        errorResult.eventEntity(eventEntity).eventType("Event Type");
    RuleNodeDebugEventBuilder metadataResult =
        eventTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .metadata("Metadata");
    RuleNodeDebugEvent event =
        metadataResult
            .msgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .msgType("Msg Type")
            .relationType("Relation Type")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build();

    // Act and Assert
    EntityId eventEntity2 = new RuleNodeDebugEventEntity(event).toData().getEventEntity();
    assertTrue(eventEntity2 instanceof AlarmId);
    assertEquals(eventEntity, eventEntity2);
  }

  /**
   * Test {@link RuleNodeDebugEventEntity#toData()}.
   *
   * <ul>
   *   <li>Then EventEntity return {@link CustomerId}.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeDebugEventEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"RuleNodeDebugEvent RuleNodeDebugEventEntity.toData()"})
  public void testToData_thenEventEntityReturnCustomerId() {
    // Arrange
    RuleNodeDebugEventBuilder dataTypeResult =
        RuleNodeDebugEvent.builder().data("Data").dataType("Data Type");
    RuleNodeDebugEventBuilder eventTypeResult =
        dataTypeResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred")
            .eventEntity(BaseEntityService.NULL_CUSTOMER_ID)
            .eventType("Event Type");
    RuleNodeDebugEventBuilder metadataResult =
        eventTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .metadata("Metadata");
    RuleNodeDebugEvent event =
        metadataResult
            .msgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .msgType("Msg Type")
            .relationType("Relation Type")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build();

    // Act and Assert
    EntityId eventEntity = new RuleNodeDebugEventEntity(event).toData().getEventEntity();
    assertTrue(eventEntity instanceof CustomerId);
    assertEquals(EntityType.CUSTOMER, eventEntity.getEntityType());
  }

  /**
   * Test {@link RuleNodeDebugEventEntity#toData()}.
   *
   * <ul>
   *   <li>Then EventEntity return {@link TenantId}.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeDebugEventEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"RuleNodeDebugEvent RuleNodeDebugEventEntity.toData()"})
  public void testToData_thenEventEntityReturnTenantId() {
    // Arrange
    RuleNodeDebugEventBuilder dataTypeResult =
        RuleNodeDebugEvent.builder().data("Data").dataType("Data Type");
    RuleNodeDebugEventBuilder eventTypeResult =
        dataTypeResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred")
            .eventEntity(ModelConstants.SYSTEM_TENANT)
            .eventType("Event Type");
    RuleNodeDebugEventBuilder metadataResult =
        eventTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .metadata("Metadata");
    RuleNodeDebugEvent event =
        metadataResult
            .msgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .msgType("Msg Type")
            .relationType("Relation Type")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build();

    // Act
    RuleNodeDebugEvent actualToDataResult = new RuleNodeDebugEventEntity(event).toData();

    // Assert
    EntityId eventEntity = actualToDataResult.getEventEntity();
    assertTrue(eventEntity instanceof TenantId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", eventEntity.getId().toString());
    assertEquals(EntityType.TENANT, eventEntity.getEntityType());
    assertTrue(((TenantId) eventEntity).isSysTenantId());
    assertSame(eventEntity, actualToDataResult.getTenantId());
  }

  /**
   * Test {@link RuleNodeDebugEventEntity#toData()}.
   *
   * <ul>
   *   <li>Then return TenantId Id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeDebugEventEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"RuleNodeDebugEvent RuleNodeDebugEventEntity.toData()"})
  public void testToData_thenReturnTenantIdIdIsRandomUUID() {
    // Arrange
    RuleNodeDebugEventEntity ruleNodeDebugEventEntity = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity.setCreatedTime(1L);
    ruleNodeDebugEventEntity.setData("Data");
    ruleNodeDebugEventEntity.setDataType("Data Type");
    ruleNodeDebugEventEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setError("An error occurred");
    ruleNodeDebugEventEntity.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity.setEventType("Event Type");
    ruleNodeDebugEventEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setMetadata("Metadata");
    ruleNodeDebugEventEntity.setMsgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setMsgType("Msg Type");
    ruleNodeDebugEventEntity.setRelationType("Relation Type");
    ruleNodeDebugEventEntity.setServiceId("42");
    UUID tenantId = UUID.randomUUID();
    ruleNodeDebugEventEntity.setTenantId(tenantId);
    ruleNodeDebugEventEntity.setTs(1L);
    ruleNodeDebugEventEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setEventEntityId(null);

    // Act
    RuleNodeDebugEvent actualToDataResult = ruleNodeDebugEventEntity.toData();

    // Assert
    assertNull(actualToDataResult.getEventEntity());
    TenantId tenantId2 = actualToDataResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link RuleNodeDebugEventEntity#toData()}.
   *
   * <ul>
   *   <li>Then return TenantId Id toString is {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeDebugEventEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"RuleNodeDebugEvent RuleNodeDebugEventEntity.toData()"})
  public void testToData_thenReturnTenantIdIdToStringIs784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    RuleNodeDebugEventEntity ruleNodeDebugEventEntity = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity.setCreatedTime(1L);
    ruleNodeDebugEventEntity.setData("Data");
    ruleNodeDebugEventEntity.setDataType("Data Type");
    ruleNodeDebugEventEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleNodeDebugEventEntity.setError("An error occurred");
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
    ruleNodeDebugEventEntity.setEventEntityId(null);

    // Act
    RuleNodeDebugEvent actualToDataResult = ruleNodeDebugEventEntity.toData();

    // Assert
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", tenantId.getId().toString());
    assertNull(actualToDataResult.getEventEntity());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
  }
}
