package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.event.RuleChainDebugEvent;
import org.thingsboard.server.common.data.event.RuleChainDebugEvent.RuleChainDebugEventBuilder;
import org.thingsboard.server.common.data.id.EventId;
import org.thingsboard.server.dao.model.ModelConstants;

public class RuleChainDebugEventEntityDiffblueTest {
  /**
   * Test {@link RuleChainDebugEventEntity#equals(Object)}, and {@link
   * RuleChainDebugEventEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuleChainDebugEventEntity#equals(Object)}
   *   <li>{@link RuleChainDebugEventEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean RuleChainDebugEventEntity.equals(Object)",
    "int RuleChainDebugEventEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RuleChainDebugEventEntity ruleChainDebugEventEntity = new RuleChainDebugEventEntity();
    ruleChainDebugEventEntity.setCreatedTime(1L);
    ruleChainDebugEventEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainDebugEventEntity.setError("An error occurred");
    ruleChainDebugEventEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainDebugEventEntity.setMessage("Not all who wander are lost");
    ruleChainDebugEventEntity.setServiceId("42");
    ruleChainDebugEventEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainDebugEventEntity.setTs(1L);
    ruleChainDebugEventEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RuleChainDebugEventEntity ruleChainDebugEventEntity2 = new RuleChainDebugEventEntity();
    ruleChainDebugEventEntity2.setCreatedTime(1L);
    ruleChainDebugEventEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainDebugEventEntity2.setError("An error occurred");
    ruleChainDebugEventEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainDebugEventEntity2.setMessage("Not all who wander are lost");
    ruleChainDebugEventEntity2.setServiceId("42");
    ruleChainDebugEventEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainDebugEventEntity2.setTs(1L);
    ruleChainDebugEventEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(ruleChainDebugEventEntity, ruleChainDebugEventEntity2);
    int expectedHashCodeResult = ruleChainDebugEventEntity.hashCode();
    assertEquals(expectedHashCodeResult, ruleChainDebugEventEntity2.hashCode());
  }

  /**
   * Test {@link RuleChainDebugEventEntity#equals(Object)}, and {@link
   * RuleChainDebugEventEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuleChainDebugEventEntity#equals(Object)}
   *   <li>{@link RuleChainDebugEventEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean RuleChainDebugEventEntity.equals(Object)",
    "int RuleChainDebugEventEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RuleChainDebugEventEntity ruleChainDebugEventEntity = new RuleChainDebugEventEntity();
    ruleChainDebugEventEntity.setCreatedTime(1L);
    ruleChainDebugEventEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainDebugEventEntity.setError("An error occurred");
    ruleChainDebugEventEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainDebugEventEntity.setMessage("Not all who wander are lost");
    ruleChainDebugEventEntity.setServiceId("42");
    ruleChainDebugEventEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainDebugEventEntity.setTs(1L);
    ruleChainDebugEventEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(ruleChainDebugEventEntity, ruleChainDebugEventEntity);
    int expectedHashCodeResult = ruleChainDebugEventEntity.hashCode();
    assertEquals(expectedHashCodeResult, ruleChainDebugEventEntity.hashCode());
  }

  /**
   * Test {@link RuleChainDebugEventEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainDebugEventEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean RuleChainDebugEventEntity.equals(Object)",
    "int RuleChainDebugEventEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RuleChainDebugEventEntity ruleChainDebugEventEntity = new RuleChainDebugEventEntity();
    ruleChainDebugEventEntity.setCreatedTime(1L);
    ruleChainDebugEventEntity.setEntityId(ModelConstants.NULL_UUID);
    ruleChainDebugEventEntity.setError("An error occurred");
    ruleChainDebugEventEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainDebugEventEntity.setMessage("Not all who wander are lost");
    ruleChainDebugEventEntity.setServiceId("42");
    ruleChainDebugEventEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainDebugEventEntity.setTs(1L);
    ruleChainDebugEventEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RuleChainDebugEventEntity ruleChainDebugEventEntity2 = new RuleChainDebugEventEntity();
    ruleChainDebugEventEntity2.setCreatedTime(1L);
    ruleChainDebugEventEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainDebugEventEntity2.setError("An error occurred");
    ruleChainDebugEventEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainDebugEventEntity2.setMessage("Not all who wander are lost");
    ruleChainDebugEventEntity2.setServiceId("42");
    ruleChainDebugEventEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainDebugEventEntity2.setTs(1L);
    ruleChainDebugEventEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(ruleChainDebugEventEntity, ruleChainDebugEventEntity2);
  }

  /**
   * Test {@link RuleChainDebugEventEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainDebugEventEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean RuleChainDebugEventEntity.equals(Object)",
    "int RuleChainDebugEventEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RuleChainDebugEventEntity ruleChainDebugEventEntity = new RuleChainDebugEventEntity();
    ruleChainDebugEventEntity.setCreatedTime(1L);
    ruleChainDebugEventEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainDebugEventEntity.setError("42");
    ruleChainDebugEventEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainDebugEventEntity.setMessage("Not all who wander are lost");
    ruleChainDebugEventEntity.setServiceId("42");
    ruleChainDebugEventEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainDebugEventEntity.setTs(1L);
    ruleChainDebugEventEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RuleChainDebugEventEntity ruleChainDebugEventEntity2 = new RuleChainDebugEventEntity();
    ruleChainDebugEventEntity2.setCreatedTime(1L);
    ruleChainDebugEventEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainDebugEventEntity2.setError("An error occurred");
    ruleChainDebugEventEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainDebugEventEntity2.setMessage("Not all who wander are lost");
    ruleChainDebugEventEntity2.setServiceId("42");
    ruleChainDebugEventEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainDebugEventEntity2.setTs(1L);
    ruleChainDebugEventEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(ruleChainDebugEventEntity, ruleChainDebugEventEntity2);
  }

  /**
   * Test {@link RuleChainDebugEventEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainDebugEventEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean RuleChainDebugEventEntity.equals(Object)",
    "int RuleChainDebugEventEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RuleChainDebugEventEntity ruleChainDebugEventEntity = new RuleChainDebugEventEntity();
    ruleChainDebugEventEntity.setCreatedTime(1L);
    ruleChainDebugEventEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainDebugEventEntity.setError(null);
    ruleChainDebugEventEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainDebugEventEntity.setMessage("Not all who wander are lost");
    ruleChainDebugEventEntity.setServiceId("42");
    ruleChainDebugEventEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainDebugEventEntity.setTs(1L);
    ruleChainDebugEventEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RuleChainDebugEventEntity ruleChainDebugEventEntity2 = new RuleChainDebugEventEntity();
    ruleChainDebugEventEntity2.setCreatedTime(1L);
    ruleChainDebugEventEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainDebugEventEntity2.setError("An error occurred");
    ruleChainDebugEventEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainDebugEventEntity2.setMessage("Not all who wander are lost");
    ruleChainDebugEventEntity2.setServiceId("42");
    ruleChainDebugEventEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainDebugEventEntity2.setTs(1L);
    ruleChainDebugEventEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(ruleChainDebugEventEntity, ruleChainDebugEventEntity2);
  }

  /**
   * Test {@link RuleChainDebugEventEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainDebugEventEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean RuleChainDebugEventEntity.equals(Object)",
    "int RuleChainDebugEventEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    RuleChainDebugEventEntity ruleChainDebugEventEntity = new RuleChainDebugEventEntity();
    ruleChainDebugEventEntity.setCreatedTime(1L);
    ruleChainDebugEventEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainDebugEventEntity.setError("An error occurred");
    ruleChainDebugEventEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainDebugEventEntity.setMessage("42");
    ruleChainDebugEventEntity.setServiceId("42");
    ruleChainDebugEventEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainDebugEventEntity.setTs(1L);
    ruleChainDebugEventEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RuleChainDebugEventEntity ruleChainDebugEventEntity2 = new RuleChainDebugEventEntity();
    ruleChainDebugEventEntity2.setCreatedTime(1L);
    ruleChainDebugEventEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainDebugEventEntity2.setError("An error occurred");
    ruleChainDebugEventEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainDebugEventEntity2.setMessage("Not all who wander are lost");
    ruleChainDebugEventEntity2.setServiceId("42");
    ruleChainDebugEventEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainDebugEventEntity2.setTs(1L);
    ruleChainDebugEventEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(ruleChainDebugEventEntity, ruleChainDebugEventEntity2);
  }

  /**
   * Test {@link RuleChainDebugEventEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainDebugEventEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean RuleChainDebugEventEntity.equals(Object)",
    "int RuleChainDebugEventEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    RuleChainDebugEventEntity ruleChainDebugEventEntity = new RuleChainDebugEventEntity();
    ruleChainDebugEventEntity.setCreatedTime(1L);
    ruleChainDebugEventEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainDebugEventEntity.setError("An error occurred");
    ruleChainDebugEventEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainDebugEventEntity.setMessage(null);
    ruleChainDebugEventEntity.setServiceId("42");
    ruleChainDebugEventEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainDebugEventEntity.setTs(1L);
    ruleChainDebugEventEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RuleChainDebugEventEntity ruleChainDebugEventEntity2 = new RuleChainDebugEventEntity();
    ruleChainDebugEventEntity2.setCreatedTime(1L);
    ruleChainDebugEventEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainDebugEventEntity2.setError("An error occurred");
    ruleChainDebugEventEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainDebugEventEntity2.setMessage("Not all who wander are lost");
    ruleChainDebugEventEntity2.setServiceId("42");
    ruleChainDebugEventEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainDebugEventEntity2.setTs(1L);
    ruleChainDebugEventEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(ruleChainDebugEventEntity, ruleChainDebugEventEntity2);
  }

  /**
   * Test {@link RuleChainDebugEventEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainDebugEventEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean RuleChainDebugEventEntity.equals(Object)",
    "int RuleChainDebugEventEntity.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    RuleChainDebugEventEntity ruleChainDebugEventEntity = new RuleChainDebugEventEntity();
    ruleChainDebugEventEntity.setCreatedTime(1L);
    ruleChainDebugEventEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainDebugEventEntity.setError("An error occurred");
    ruleChainDebugEventEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainDebugEventEntity.setMessage("Not all who wander are lost");
    ruleChainDebugEventEntity.setServiceId("42");
    ruleChainDebugEventEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainDebugEventEntity.setTs(1L);
    ruleChainDebugEventEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(ruleChainDebugEventEntity, null);
  }

  /**
   * Test {@link RuleChainDebugEventEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainDebugEventEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean RuleChainDebugEventEntity.equals(Object)",
    "int RuleChainDebugEventEntity.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    RuleChainDebugEventEntity ruleChainDebugEventEntity = new RuleChainDebugEventEntity();
    ruleChainDebugEventEntity.setCreatedTime(1L);
    ruleChainDebugEventEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainDebugEventEntity.setError("An error occurred");
    ruleChainDebugEventEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainDebugEventEntity.setMessage("Not all who wander are lost");
    ruleChainDebugEventEntity.setServiceId("42");
    ruleChainDebugEventEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainDebugEventEntity.setTs(1L);
    ruleChainDebugEventEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(ruleChainDebugEventEntity, "Different type to RuleChainDebugEventEntity");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuleChainDebugEventEntity#RuleChainDebugEventEntity()}
   *   <li>{@link RuleChainDebugEventEntity#setError(String)}
   *   <li>{@link RuleChainDebugEventEntity#setMessage(String)}
   *   <li>{@link RuleChainDebugEventEntity#toString()}
   *   <li>{@link RuleChainDebugEventEntity#getError()}
   *   <li>{@link RuleChainDebugEventEntity#getMessage()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void RuleChainDebugEventEntity.<init>()",
    "String RuleChainDebugEventEntity.getError()",
    "String RuleChainDebugEventEntity.getMessage()",
    "void RuleChainDebugEventEntity.setError(String)",
    "void RuleChainDebugEventEntity.setMessage(String)",
    "String RuleChainDebugEventEntity.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    RuleChainDebugEventEntity actualRuleChainDebugEventEntity = new RuleChainDebugEventEntity();
    actualRuleChainDebugEventEntity.setError("An error occurred");
    actualRuleChainDebugEventEntity.setMessage("Not all who wander are lost");
    String actualToStringResult = actualRuleChainDebugEventEntity.toString();
    String actualError = actualRuleChainDebugEventEntity.getError();

    // Assert
    assertEquals("An error occurred", actualError);
    assertEquals("Not all who wander are lost", actualRuleChainDebugEventEntity.getMessage());
    assertEquals(
        "RuleChainDebugEventEntity(message=Not all who wander are lost, error=An error occurred)",
        actualToStringResult);
    assertNull(actualRuleChainDebugEventEntity.getServiceId());
    assertNull(actualRuleChainDebugEventEntity.getEntityId());
    assertNull(actualRuleChainDebugEventEntity.getId());
    assertNull(actualRuleChainDebugEventEntity.getTenantId());
    assertNull(actualRuleChainDebugEventEntity.getUuid());
    assertEquals(0L, actualRuleChainDebugEventEntity.getCreatedTime());
    assertEquals(0L, actualRuleChainDebugEventEntity.getTs());
  }

  /**
   * Test {@link RuleChainDebugEventEntity#RuleChainDebugEventEntity(RuleChainDebugEvent)}.
   *
   * <p>Method under test: {@link
   * RuleChainDebugEventEntity#RuleChainDebugEventEntity(RuleChainDebugEvent)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RuleChainDebugEventEntity.<init>(RuleChainDebugEvent)"})
  public void testNewRuleChainDebugEventEntity() {
    // Arrange
    RuleChainDebugEventBuilder builderResult = RuleChainDebugEvent.builder();
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    RuleChainDebugEventBuilder errorResult =
        builderResult.entityId(entityId).error("An error occurred");
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    RuleChainDebugEvent event =
        errorResult
            .id(id)
            .message("Not all who wander are lost")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build();

    // Act
    RuleChainDebugEventEntity actualRuleChainDebugEventEntity =
        new RuleChainDebugEventEntity(event);

    // Assert
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080",
        actualRuleChainDebugEventEntity.getTenantId().toString());
    assertEquals("42", actualRuleChainDebugEventEntity.getServiceId());
    UUID entityId2 = actualRuleChainDebugEventEntity.getEntityId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", entityId2.toString());
    UUID id2 = actualRuleChainDebugEventEntity.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id2.toString());
    assertEquals("An error occurred", actualRuleChainDebugEventEntity.getError());
    assertEquals("Not all who wander are lost", actualRuleChainDebugEventEntity.getMessage());
    assertEquals(1L, actualRuleChainDebugEventEntity.getCreatedTime());
    assertEquals(1L, actualRuleChainDebugEventEntity.getTs());
    assertSame(entityId, entityId2);
    assertSame(id, id2);
    assertSame(id, actualRuleChainDebugEventEntity.getUuid());
  }

  /**
   * Test {@link RuleChainDebugEventEntity#RuleChainDebugEventEntity(RuleChainDebugEvent)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then calls {@link RuleChainDebugEvent#getCreatedTime()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleChainDebugEventEntity#RuleChainDebugEventEntity(RuleChainDebugEvent)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RuleChainDebugEventEntity.<init>(RuleChainDebugEvent)"})
  public void testNewRuleChainDebugEventEntity_givenSystem_tenant_thenCallsGetCreatedTime() {
    // Arrange
    RuleChainDebugEvent event = mock(RuleChainDebugEvent.class);
    when(event.getServiceId()).thenReturn("42");
    when(event.getError()).thenReturn("An error occurred");
    when(event.getMessage()).thenReturn("Not all who wander are lost");
    UUID fromStringResult = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    when(event.getEntityId()).thenReturn(fromStringResult);
    when(event.getCreatedTime()).thenReturn(1L);
    when(event.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    when(event.getId()).thenReturn(new EventId(id));

    // Act
    RuleChainDebugEventEntity actualRuleChainDebugEventEntity =
        new RuleChainDebugEventEntity(event);

    // Assert
    verify(event).getCreatedTime();
    verify(event).getEntityId();
    verify(event).getServiceId();
    verify(event).getTenantId();
    verify(event).getError();
    verify(event).getMessage();
    verify(event).getId();
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080",
        actualRuleChainDebugEventEntity.getTenantId().toString());
    assertEquals("42", actualRuleChainDebugEventEntity.getServiceId());
    UUID entityId = actualRuleChainDebugEventEntity.getEntityId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", entityId.toString());
    UUID id2 = actualRuleChainDebugEventEntity.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id2.toString());
    assertEquals("An error occurred", actualRuleChainDebugEventEntity.getError());
    assertEquals("Not all who wander are lost", actualRuleChainDebugEventEntity.getMessage());
    assertEquals(1L, actualRuleChainDebugEventEntity.getCreatedTime());
    assertEquals(1L, actualRuleChainDebugEventEntity.getTs());
    assertSame(fromStringResult, entityId);
    assertSame(id, id2);
    assertSame(id, actualRuleChainDebugEventEntity.getUuid());
  }

  /**
   * Test {@link RuleChainDebugEventEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link RuleChainDebugEventEntity#RuleChainDebugEventEntity()}.
   *   <li>Then return ServiceId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainDebugEventEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"RuleChainDebugEvent RuleChainDebugEventEntity.toData()"})
  public void testToData_givenRuleChainDebugEventEntity_thenReturnServiceIdIsNull() {
    // Arrange and Act
    RuleChainDebugEvent actualToDataResult = new RuleChainDebugEventEntity().toData();

    // Assert
    assertNull(actualToDataResult.getServiceId());
    assertNull(actualToDataResult.getError());
    assertNull(actualToDataResult.getMessage());
    assertNull(actualToDataResult.getEntityId());
    assertNull(actualToDataResult.getUuidId());
    assertNull(actualToDataResult.getTenantId().getId());
    assertNull(actualToDataResult.getId());
    assertEquals(0L, actualToDataResult.getCreatedTime());
  }

  /**
   * Test {@link RuleChainDebugEventEntity#toData()}.
   *
   * <ul>
   *   <li>Then return TenantId Id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainDebugEventEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"RuleChainDebugEvent RuleChainDebugEventEntity.toData()"})
  public void testToData_thenReturnTenantIdIdIsRandomUUID() {
    // Arrange
    RuleChainDebugEventEntity ruleChainDebugEventEntity = new RuleChainDebugEventEntity();
    ruleChainDebugEventEntity.setCreatedTime(1L);
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ruleChainDebugEventEntity.setEntityId(entityId);
    ruleChainDebugEventEntity.setError("An error occurred");
    ruleChainDebugEventEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainDebugEventEntity.setMessage("Not all who wander are lost");
    ruleChainDebugEventEntity.setServiceId("42");
    UUID tenantId = UUID.randomUUID();
    ruleChainDebugEventEntity.setTenantId(tenantId);
    ruleChainDebugEventEntity.setTs(1L);
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ruleChainDebugEventEntity.setUuid(id);

    // Act
    RuleChainDebugEvent actualToDataResult = ruleChainDebugEventEntity.toData();

    // Assert
    assertEquals("42", actualToDataResult.getServiceId());
    UUID entityId2 = actualToDataResult.getEntityId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", entityId2.toString());
    UUID uuidId = actualToDataResult.getUuidId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", uuidId.toString());
    assertEquals("An error occurred", actualToDataResult.getError());
    assertEquals("Not all who wander are lost", actualToDataResult.getMessage());
    assertEquals(1L, actualToDataResult.getCreatedTime());
    assertSame(entityId, entityId2);
    assertSame(id, uuidId);
    assertSame(id, actualToDataResult.getId().getId());
    assertSame(tenantId, actualToDataResult.getTenantId().getId());
  }

  /**
   * Test {@link RuleChainDebugEventEntity#toData()}.
   *
   * <ul>
   *   <li>Then return TenantId Id toString is {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainDebugEventEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"RuleChainDebugEvent RuleChainDebugEventEntity.toData()"})
  public void testToData_thenReturnTenantIdIdToStringIs784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    RuleChainDebugEventEntity ruleChainDebugEventEntity = new RuleChainDebugEventEntity();
    ruleChainDebugEventEntity.setCreatedTime(1L);
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ruleChainDebugEventEntity.setEntityId(entityId);
    ruleChainDebugEventEntity.setError("An error occurred");
    ruleChainDebugEventEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainDebugEventEntity.setMessage("Not all who wander are lost");
    ruleChainDebugEventEntity.setServiceId("42");
    ruleChainDebugEventEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleChainDebugEventEntity.setTs(1L);
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ruleChainDebugEventEntity.setUuid(id);

    // Act
    RuleChainDebugEvent actualToDataResult = ruleChainDebugEventEntity.toData();

    // Assert
    assertEquals("42", actualToDataResult.getServiceId());
    UUID entityId2 = actualToDataResult.getEntityId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", entityId2.toString());
    UUID uuidId = actualToDataResult.getUuidId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", uuidId.toString());
    assertEquals(
        "784f394c-42b6-435a-983c-b7beff2784f9",
        actualToDataResult.getTenantId().getId().toString());
    assertEquals("An error occurred", actualToDataResult.getError());
    assertEquals("Not all who wander are lost", actualToDataResult.getMessage());
    assertEquals(1L, actualToDataResult.getCreatedTime());
    assertSame(entityId, entityId2);
    assertSame(id, uuidId);
    assertSame(id, actualToDataResult.getId().getId());
  }
}
