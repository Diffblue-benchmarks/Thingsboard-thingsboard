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
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.event.RuleNodeDebugEvent;
import org.thingsboard.server.common.data.id.EventId;
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
    ruleNodeDebugEventEntity.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setError("An error occurred");
    ruleNodeDebugEventEntity.setEventEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity.setEventType("Event Type");
    ruleNodeDebugEventEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setMetadata("Metadata");
    ruleNodeDebugEventEntity.setMsgId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setMsgType("Msg Type");
    ruleNodeDebugEventEntity.setRelationType("Relation Type");
    ruleNodeDebugEventEntity.setServiceId("42");
    ruleNodeDebugEventEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setTs(1L);
    ruleNodeDebugEventEntity.setUuid(ModelConstants.NULL_UUID);

    RuleNodeDebugEventEntity ruleNodeDebugEventEntity2 = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity2.setCreatedTime(1L);
    ruleNodeDebugEventEntity2.setData("Data");
    ruleNodeDebugEventEntity2.setDataType("Data Type");
    ruleNodeDebugEventEntity2.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setError("An error occurred");
    ruleNodeDebugEventEntity2.setEventEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity2.setEventType("Event Type");
    ruleNodeDebugEventEntity2.setId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setMetadata("Metadata");
    ruleNodeDebugEventEntity2.setMsgId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setMsgType("Msg Type");
    ruleNodeDebugEventEntity2.setRelationType("Relation Type");
    ruleNodeDebugEventEntity2.setServiceId("42");
    ruleNodeDebugEventEntity2.setTenantId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setTs(1L);
    ruleNodeDebugEventEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(ruleNodeDebugEventEntity, ruleNodeDebugEventEntity2);
    assertEquals(ruleNodeDebugEventEntity.hashCode(), ruleNodeDebugEventEntity2.hashCode());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
    ruleNodeDebugEventEntity.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setError("An error occurred");
    ruleNodeDebugEventEntity.setEventEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity.setEventType("Event Type");
    ruleNodeDebugEventEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setMetadata("Metadata");
    ruleNodeDebugEventEntity.setMsgId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setMsgType("Msg Type");
    ruleNodeDebugEventEntity.setRelationType("Relation Type");
    ruleNodeDebugEventEntity.setServiceId("42");
    ruleNodeDebugEventEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setTs(1L);
    ruleNodeDebugEventEntity.setUuid(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
    ruleNodeDebugEventEntity.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setError("An error occurred");
    ruleNodeDebugEventEntity.setEventEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity.setEventType("Event Type");
    ruleNodeDebugEventEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setMetadata("Metadata");
    ruleNodeDebugEventEntity.setMsgId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setMsgType("Msg Type");
    ruleNodeDebugEventEntity.setRelationType("Relation Type");
    ruleNodeDebugEventEntity.setServiceId("42");
    ruleNodeDebugEventEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setTs(1L);
    ruleNodeDebugEventEntity.setUuid(ModelConstants.NULL_UUID);

    RuleNodeDebugEventEntity ruleNodeDebugEventEntity2 = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity2.setCreatedTime(1L);
    ruleNodeDebugEventEntity2.setData("Data");
    ruleNodeDebugEventEntity2.setDataType("Data Type");
    ruleNodeDebugEventEntity2.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setError("An error occurred");
    ruleNodeDebugEventEntity2.setEventEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity2.setEventType("Event Type");
    ruleNodeDebugEventEntity2.setId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setMetadata("Metadata");
    ruleNodeDebugEventEntity2.setMsgId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setMsgType("Msg Type");
    ruleNodeDebugEventEntity2.setRelationType("Relation Type");
    ruleNodeDebugEventEntity2.setServiceId("42");
    ruleNodeDebugEventEntity2.setTenantId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setTs(1L);
    ruleNodeDebugEventEntity2.setUuid(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
    ruleNodeDebugEventEntity.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setError("An error occurred");
    ruleNodeDebugEventEntity.setEventEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity.setEventType("Event Type");
    ruleNodeDebugEventEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setMetadata("Metadata");
    ruleNodeDebugEventEntity.setMsgId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setMsgType("Msg Type");
    ruleNodeDebugEventEntity.setRelationType("Relation Type");
    ruleNodeDebugEventEntity.setServiceId("42");
    ruleNodeDebugEventEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setTs(1L);
    ruleNodeDebugEventEntity.setUuid(ModelConstants.NULL_UUID);

    RuleNodeDebugEventEntity ruleNodeDebugEventEntity2 = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity2.setCreatedTime(1L);
    ruleNodeDebugEventEntity2.setData("Data");
    ruleNodeDebugEventEntity2.setDataType("Data Type");
    ruleNodeDebugEventEntity2.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setError("An error occurred");
    ruleNodeDebugEventEntity2.setEventEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity2.setEventType("Event Type");
    ruleNodeDebugEventEntity2.setId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setMetadata("Metadata");
    ruleNodeDebugEventEntity2.setMsgId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setMsgType("Msg Type");
    ruleNodeDebugEventEntity2.setRelationType("Relation Type");
    ruleNodeDebugEventEntity2.setServiceId("42");
    ruleNodeDebugEventEntity2.setTenantId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setTs(1L);
    ruleNodeDebugEventEntity2.setUuid(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
    ruleNodeDebugEventEntity.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setError("An error occurred");
    ruleNodeDebugEventEntity.setEventEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity.setEventType("Event Type");
    ruleNodeDebugEventEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setMetadata("Metadata");
    ruleNodeDebugEventEntity.setMsgId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setMsgType("Msg Type");
    ruleNodeDebugEventEntity.setRelationType("Relation Type");
    ruleNodeDebugEventEntity.setServiceId("42");
    ruleNodeDebugEventEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setTs(1L);
    ruleNodeDebugEventEntity.setUuid(ModelConstants.NULL_UUID);

    RuleNodeDebugEventEntity ruleNodeDebugEventEntity2 = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity2.setCreatedTime(1L);
    ruleNodeDebugEventEntity2.setData("Data");
    ruleNodeDebugEventEntity2.setDataType("Data Type");
    ruleNodeDebugEventEntity2.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setError("An error occurred");
    ruleNodeDebugEventEntity2.setEventEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity2.setEventType("Event Type");
    ruleNodeDebugEventEntity2.setId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setMetadata("Metadata");
    ruleNodeDebugEventEntity2.setMsgId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setMsgType("Msg Type");
    ruleNodeDebugEventEntity2.setRelationType("Relation Type");
    ruleNodeDebugEventEntity2.setServiceId("42");
    ruleNodeDebugEventEntity2.setTenantId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setTs(1L);
    ruleNodeDebugEventEntity2.setUuid(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
    ruleNodeDebugEventEntity.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setError("An error occurred");
    ruleNodeDebugEventEntity.setEventEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity.setEventType("Event Type");
    ruleNodeDebugEventEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setMetadata("Metadata");
    ruleNodeDebugEventEntity.setMsgId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setMsgType("Msg Type");
    ruleNodeDebugEventEntity.setRelationType("Relation Type");
    ruleNodeDebugEventEntity.setServiceId("42");
    ruleNodeDebugEventEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setTs(1L);
    ruleNodeDebugEventEntity.setUuid(ModelConstants.NULL_UUID);

    RuleNodeDebugEventEntity ruleNodeDebugEventEntity2 = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity2.setCreatedTime(1L);
    ruleNodeDebugEventEntity2.setData("Data");
    ruleNodeDebugEventEntity2.setDataType("Data Type");
    ruleNodeDebugEventEntity2.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setError("An error occurred");
    ruleNodeDebugEventEntity2.setEventEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity2.setEventType("Event Type");
    ruleNodeDebugEventEntity2.setId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setMetadata("Metadata");
    ruleNodeDebugEventEntity2.setMsgId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setMsgType("Msg Type");
    ruleNodeDebugEventEntity2.setRelationType("Relation Type");
    ruleNodeDebugEventEntity2.setServiceId("42");
    ruleNodeDebugEventEntity2.setTenantId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setTs(1L);
    ruleNodeDebugEventEntity2.setUuid(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
    ruleNodeDebugEventEntity.setEntityId(UUID.randomUUID());
    ruleNodeDebugEventEntity.setError("An error occurred");
    ruleNodeDebugEventEntity.setEventEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity.setEventType("Event Type");
    ruleNodeDebugEventEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setMetadata("Metadata");
    ruleNodeDebugEventEntity.setMsgId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setMsgType("Msg Type");
    ruleNodeDebugEventEntity.setRelationType("Relation Type");
    ruleNodeDebugEventEntity.setServiceId("42");
    ruleNodeDebugEventEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setTs(1L);
    ruleNodeDebugEventEntity.setUuid(ModelConstants.NULL_UUID);

    RuleNodeDebugEventEntity ruleNodeDebugEventEntity2 = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity2.setCreatedTime(1L);
    ruleNodeDebugEventEntity2.setData("Data");
    ruleNodeDebugEventEntity2.setDataType("Data Type");
    ruleNodeDebugEventEntity2.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setError("An error occurred");
    ruleNodeDebugEventEntity2.setEventEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity2.setEventType("Event Type");
    ruleNodeDebugEventEntity2.setId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setMetadata("Metadata");
    ruleNodeDebugEventEntity2.setMsgId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setMsgType("Msg Type");
    ruleNodeDebugEventEntity2.setRelationType("Relation Type");
    ruleNodeDebugEventEntity2.setServiceId("42");
    ruleNodeDebugEventEntity2.setTenantId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setTs(1L);
    ruleNodeDebugEventEntity2.setUuid(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
    ruleNodeDebugEventEntity.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setError("42");
    ruleNodeDebugEventEntity.setEventEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity.setEventType("Event Type");
    ruleNodeDebugEventEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setMetadata("Metadata");
    ruleNodeDebugEventEntity.setMsgId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setMsgType("Msg Type");
    ruleNodeDebugEventEntity.setRelationType("Relation Type");
    ruleNodeDebugEventEntity.setServiceId("42");
    ruleNodeDebugEventEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setTs(1L);
    ruleNodeDebugEventEntity.setUuid(ModelConstants.NULL_UUID);

    RuleNodeDebugEventEntity ruleNodeDebugEventEntity2 = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity2.setCreatedTime(1L);
    ruleNodeDebugEventEntity2.setData("Data");
    ruleNodeDebugEventEntity2.setDataType("Data Type");
    ruleNodeDebugEventEntity2.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setError("An error occurred");
    ruleNodeDebugEventEntity2.setEventEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity2.setEventType("Event Type");
    ruleNodeDebugEventEntity2.setId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setMetadata("Metadata");
    ruleNodeDebugEventEntity2.setMsgId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setMsgType("Msg Type");
    ruleNodeDebugEventEntity2.setRelationType("Relation Type");
    ruleNodeDebugEventEntity2.setServiceId("42");
    ruleNodeDebugEventEntity2.setTenantId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setTs(1L);
    ruleNodeDebugEventEntity2.setUuid(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
    ruleNodeDebugEventEntity.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setError(null);
    ruleNodeDebugEventEntity.setEventEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity.setEventType("Event Type");
    ruleNodeDebugEventEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setMetadata("Metadata");
    ruleNodeDebugEventEntity.setMsgId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setMsgType("Msg Type");
    ruleNodeDebugEventEntity.setRelationType("Relation Type");
    ruleNodeDebugEventEntity.setServiceId("42");
    ruleNodeDebugEventEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setTs(1L);
    ruleNodeDebugEventEntity.setUuid(ModelConstants.NULL_UUID);

    RuleNodeDebugEventEntity ruleNodeDebugEventEntity2 = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity2.setCreatedTime(1L);
    ruleNodeDebugEventEntity2.setData("Data");
    ruleNodeDebugEventEntity2.setDataType("Data Type");
    ruleNodeDebugEventEntity2.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setError("An error occurred");
    ruleNodeDebugEventEntity2.setEventEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity2.setEventType("Event Type");
    ruleNodeDebugEventEntity2.setId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setMetadata("Metadata");
    ruleNodeDebugEventEntity2.setMsgId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setMsgType("Msg Type");
    ruleNodeDebugEventEntity2.setRelationType("Relation Type");
    ruleNodeDebugEventEntity2.setServiceId("42");
    ruleNodeDebugEventEntity2.setTenantId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setTs(1L);
    ruleNodeDebugEventEntity2.setUuid(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
    ruleNodeDebugEventEntity.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setError("An error occurred");
    ruleNodeDebugEventEntity.setEventEntityId(UUID.randomUUID());
    ruleNodeDebugEventEntity.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity.setEventType("Event Type");
    ruleNodeDebugEventEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setMetadata("Metadata");
    ruleNodeDebugEventEntity.setMsgId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setMsgType("Msg Type");
    ruleNodeDebugEventEntity.setRelationType("Relation Type");
    ruleNodeDebugEventEntity.setServiceId("42");
    ruleNodeDebugEventEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setTs(1L);
    ruleNodeDebugEventEntity.setUuid(ModelConstants.NULL_UUID);

    RuleNodeDebugEventEntity ruleNodeDebugEventEntity2 = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity2.setCreatedTime(1L);
    ruleNodeDebugEventEntity2.setData("Data");
    ruleNodeDebugEventEntity2.setDataType("Data Type");
    ruleNodeDebugEventEntity2.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setError("An error occurred");
    ruleNodeDebugEventEntity2.setEventEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity2.setEventType("Event Type");
    ruleNodeDebugEventEntity2.setId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setMetadata("Metadata");
    ruleNodeDebugEventEntity2.setMsgId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setMsgType("Msg Type");
    ruleNodeDebugEventEntity2.setRelationType("Relation Type");
    ruleNodeDebugEventEntity2.setServiceId("42");
    ruleNodeDebugEventEntity2.setTenantId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setTs(1L);
    ruleNodeDebugEventEntity2.setUuid(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
    ruleNodeDebugEventEntity.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setError("An error occurred");
    ruleNodeDebugEventEntity.setEventEntityId(null);
    ruleNodeDebugEventEntity.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity.setEventType("Event Type");
    ruleNodeDebugEventEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setMetadata("Metadata");
    ruleNodeDebugEventEntity.setMsgId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setMsgType("Msg Type");
    ruleNodeDebugEventEntity.setRelationType("Relation Type");
    ruleNodeDebugEventEntity.setServiceId("42");
    ruleNodeDebugEventEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setTs(1L);
    ruleNodeDebugEventEntity.setUuid(ModelConstants.NULL_UUID);

    RuleNodeDebugEventEntity ruleNodeDebugEventEntity2 = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity2.setCreatedTime(1L);
    ruleNodeDebugEventEntity2.setData("Data");
    ruleNodeDebugEventEntity2.setDataType("Data Type");
    ruleNodeDebugEventEntity2.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setError("An error occurred");
    ruleNodeDebugEventEntity2.setEventEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity2.setEventType("Event Type");
    ruleNodeDebugEventEntity2.setId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setMetadata("Metadata");
    ruleNodeDebugEventEntity2.setMsgId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setMsgType("Msg Type");
    ruleNodeDebugEventEntity2.setRelationType("Relation Type");
    ruleNodeDebugEventEntity2.setServiceId("42");
    ruleNodeDebugEventEntity2.setTenantId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setTs(1L);
    ruleNodeDebugEventEntity2.setUuid(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
    ruleNodeDebugEventEntity.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setError("An error occurred");
    ruleNodeDebugEventEntity.setEventEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setEventEntityType("42");
    ruleNodeDebugEventEntity.setEventType("Event Type");
    ruleNodeDebugEventEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setMetadata("Metadata");
    ruleNodeDebugEventEntity.setMsgId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setMsgType("Msg Type");
    ruleNodeDebugEventEntity.setRelationType("Relation Type");
    ruleNodeDebugEventEntity.setServiceId("42");
    ruleNodeDebugEventEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setTs(1L);
    ruleNodeDebugEventEntity.setUuid(ModelConstants.NULL_UUID);

    RuleNodeDebugEventEntity ruleNodeDebugEventEntity2 = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity2.setCreatedTime(1L);
    ruleNodeDebugEventEntity2.setData("Data");
    ruleNodeDebugEventEntity2.setDataType("Data Type");
    ruleNodeDebugEventEntity2.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setError("An error occurred");
    ruleNodeDebugEventEntity2.setEventEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity2.setEventType("Event Type");
    ruleNodeDebugEventEntity2.setId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setMetadata("Metadata");
    ruleNodeDebugEventEntity2.setMsgId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setMsgType("Msg Type");
    ruleNodeDebugEventEntity2.setRelationType("Relation Type");
    ruleNodeDebugEventEntity2.setServiceId("42");
    ruleNodeDebugEventEntity2.setTenantId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setTs(1L);
    ruleNodeDebugEventEntity2.setUuid(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
    ruleNodeDebugEventEntity.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setError("An error occurred");
    ruleNodeDebugEventEntity.setEventEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setEventEntityType(null);
    ruleNodeDebugEventEntity.setEventType("Event Type");
    ruleNodeDebugEventEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setMetadata("Metadata");
    ruleNodeDebugEventEntity.setMsgId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setMsgType("Msg Type");
    ruleNodeDebugEventEntity.setRelationType("Relation Type");
    ruleNodeDebugEventEntity.setServiceId("42");
    ruleNodeDebugEventEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setTs(1L);
    ruleNodeDebugEventEntity.setUuid(ModelConstants.NULL_UUID);

    RuleNodeDebugEventEntity ruleNodeDebugEventEntity2 = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity2.setCreatedTime(1L);
    ruleNodeDebugEventEntity2.setData("Data");
    ruleNodeDebugEventEntity2.setDataType("Data Type");
    ruleNodeDebugEventEntity2.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setError("An error occurred");
    ruleNodeDebugEventEntity2.setEventEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity2.setEventType("Event Type");
    ruleNodeDebugEventEntity2.setId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setMetadata("Metadata");
    ruleNodeDebugEventEntity2.setMsgId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setMsgType("Msg Type");
    ruleNodeDebugEventEntity2.setRelationType("Relation Type");
    ruleNodeDebugEventEntity2.setServiceId("42");
    ruleNodeDebugEventEntity2.setTenantId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setTs(1L);
    ruleNodeDebugEventEntity2.setUuid(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
    ruleNodeDebugEventEntity.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setError("An error occurred");
    ruleNodeDebugEventEntity.setEventEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity.setEventType("42");
    ruleNodeDebugEventEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setMetadata("Metadata");
    ruleNodeDebugEventEntity.setMsgId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setMsgType("Msg Type");
    ruleNodeDebugEventEntity.setRelationType("Relation Type");
    ruleNodeDebugEventEntity.setServiceId("42");
    ruleNodeDebugEventEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setTs(1L);
    ruleNodeDebugEventEntity.setUuid(ModelConstants.NULL_UUID);

    RuleNodeDebugEventEntity ruleNodeDebugEventEntity2 = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity2.setCreatedTime(1L);
    ruleNodeDebugEventEntity2.setData("Data");
    ruleNodeDebugEventEntity2.setDataType("Data Type");
    ruleNodeDebugEventEntity2.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setError("An error occurred");
    ruleNodeDebugEventEntity2.setEventEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity2.setEventType("Event Type");
    ruleNodeDebugEventEntity2.setId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setMetadata("Metadata");
    ruleNodeDebugEventEntity2.setMsgId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setMsgType("Msg Type");
    ruleNodeDebugEventEntity2.setRelationType("Relation Type");
    ruleNodeDebugEventEntity2.setServiceId("42");
    ruleNodeDebugEventEntity2.setTenantId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setTs(1L);
    ruleNodeDebugEventEntity2.setUuid(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
    ruleNodeDebugEventEntity.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setError("An error occurred");
    ruleNodeDebugEventEntity.setEventEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity.setEventType(null);
    ruleNodeDebugEventEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setMetadata("Metadata");
    ruleNodeDebugEventEntity.setMsgId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setMsgType("Msg Type");
    ruleNodeDebugEventEntity.setRelationType("Relation Type");
    ruleNodeDebugEventEntity.setServiceId("42");
    ruleNodeDebugEventEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setTs(1L);
    ruleNodeDebugEventEntity.setUuid(ModelConstants.NULL_UUID);

    RuleNodeDebugEventEntity ruleNodeDebugEventEntity2 = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity2.setCreatedTime(1L);
    ruleNodeDebugEventEntity2.setData("Data");
    ruleNodeDebugEventEntity2.setDataType("Data Type");
    ruleNodeDebugEventEntity2.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setError("An error occurred");
    ruleNodeDebugEventEntity2.setEventEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity2.setEventType("Event Type");
    ruleNodeDebugEventEntity2.setId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setMetadata("Metadata");
    ruleNodeDebugEventEntity2.setMsgId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setMsgType("Msg Type");
    ruleNodeDebugEventEntity2.setRelationType("Relation Type");
    ruleNodeDebugEventEntity2.setServiceId("42");
    ruleNodeDebugEventEntity2.setTenantId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setTs(1L);
    ruleNodeDebugEventEntity2.setUuid(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
    ruleNodeDebugEventEntity.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setError("An error occurred");
    ruleNodeDebugEventEntity.setEventEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity.setEventType("Event Type");
    ruleNodeDebugEventEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setMetadata("42");
    ruleNodeDebugEventEntity.setMsgId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setMsgType("Msg Type");
    ruleNodeDebugEventEntity.setRelationType("Relation Type");
    ruleNodeDebugEventEntity.setServiceId("42");
    ruleNodeDebugEventEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setTs(1L);
    ruleNodeDebugEventEntity.setUuid(ModelConstants.NULL_UUID);

    RuleNodeDebugEventEntity ruleNodeDebugEventEntity2 = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity2.setCreatedTime(1L);
    ruleNodeDebugEventEntity2.setData("Data");
    ruleNodeDebugEventEntity2.setDataType("Data Type");
    ruleNodeDebugEventEntity2.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setError("An error occurred");
    ruleNodeDebugEventEntity2.setEventEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity2.setEventType("Event Type");
    ruleNodeDebugEventEntity2.setId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setMetadata("Metadata");
    ruleNodeDebugEventEntity2.setMsgId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setMsgType("Msg Type");
    ruleNodeDebugEventEntity2.setRelationType("Relation Type");
    ruleNodeDebugEventEntity2.setServiceId("42");
    ruleNodeDebugEventEntity2.setTenantId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setTs(1L);
    ruleNodeDebugEventEntity2.setUuid(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
    ruleNodeDebugEventEntity.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setError("An error occurred");
    ruleNodeDebugEventEntity.setEventEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity.setEventType("Event Type");
    ruleNodeDebugEventEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setMetadata(null);
    ruleNodeDebugEventEntity.setMsgId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setMsgType("Msg Type");
    ruleNodeDebugEventEntity.setRelationType("Relation Type");
    ruleNodeDebugEventEntity.setServiceId("42");
    ruleNodeDebugEventEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setTs(1L);
    ruleNodeDebugEventEntity.setUuid(ModelConstants.NULL_UUID);

    RuleNodeDebugEventEntity ruleNodeDebugEventEntity2 = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity2.setCreatedTime(1L);
    ruleNodeDebugEventEntity2.setData("Data");
    ruleNodeDebugEventEntity2.setDataType("Data Type");
    ruleNodeDebugEventEntity2.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setError("An error occurred");
    ruleNodeDebugEventEntity2.setEventEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity2.setEventType("Event Type");
    ruleNodeDebugEventEntity2.setId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setMetadata("Metadata");
    ruleNodeDebugEventEntity2.setMsgId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setMsgType("Msg Type");
    ruleNodeDebugEventEntity2.setRelationType("Relation Type");
    ruleNodeDebugEventEntity2.setServiceId("42");
    ruleNodeDebugEventEntity2.setTenantId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setTs(1L);
    ruleNodeDebugEventEntity2.setUuid(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
    ruleNodeDebugEventEntity.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setError("An error occurred");
    ruleNodeDebugEventEntity.setEventEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity.setEventType("Event Type");
    ruleNodeDebugEventEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setMetadata("Metadata");
    ruleNodeDebugEventEntity.setMsgId(UUID.randomUUID());
    ruleNodeDebugEventEntity.setMsgType("Msg Type");
    ruleNodeDebugEventEntity.setRelationType("Relation Type");
    ruleNodeDebugEventEntity.setServiceId("42");
    ruleNodeDebugEventEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setTs(1L);
    ruleNodeDebugEventEntity.setUuid(ModelConstants.NULL_UUID);

    RuleNodeDebugEventEntity ruleNodeDebugEventEntity2 = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity2.setCreatedTime(1L);
    ruleNodeDebugEventEntity2.setData("Data");
    ruleNodeDebugEventEntity2.setDataType("Data Type");
    ruleNodeDebugEventEntity2.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setError("An error occurred");
    ruleNodeDebugEventEntity2.setEventEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity2.setEventType("Event Type");
    ruleNodeDebugEventEntity2.setId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setMetadata("Metadata");
    ruleNodeDebugEventEntity2.setMsgId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setMsgType("Msg Type");
    ruleNodeDebugEventEntity2.setRelationType("Relation Type");
    ruleNodeDebugEventEntity2.setServiceId("42");
    ruleNodeDebugEventEntity2.setTenantId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setTs(1L);
    ruleNodeDebugEventEntity2.setUuid(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
    ruleNodeDebugEventEntity.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setError("An error occurred");
    ruleNodeDebugEventEntity.setEventEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity.setEventType("Event Type");
    ruleNodeDebugEventEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setMetadata("Metadata");
    ruleNodeDebugEventEntity.setMsgId(null);
    ruleNodeDebugEventEntity.setMsgType("Msg Type");
    ruleNodeDebugEventEntity.setRelationType("Relation Type");
    ruleNodeDebugEventEntity.setServiceId("42");
    ruleNodeDebugEventEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setTs(1L);
    ruleNodeDebugEventEntity.setUuid(ModelConstants.NULL_UUID);

    RuleNodeDebugEventEntity ruleNodeDebugEventEntity2 = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity2.setCreatedTime(1L);
    ruleNodeDebugEventEntity2.setData("Data");
    ruleNodeDebugEventEntity2.setDataType("Data Type");
    ruleNodeDebugEventEntity2.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setError("An error occurred");
    ruleNodeDebugEventEntity2.setEventEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity2.setEventType("Event Type");
    ruleNodeDebugEventEntity2.setId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setMetadata("Metadata");
    ruleNodeDebugEventEntity2.setMsgId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setMsgType("Msg Type");
    ruleNodeDebugEventEntity2.setRelationType("Relation Type");
    ruleNodeDebugEventEntity2.setServiceId("42");
    ruleNodeDebugEventEntity2.setTenantId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setTs(1L);
    ruleNodeDebugEventEntity2.setUuid(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
    ruleNodeDebugEventEntity.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setError("An error occurred");
    ruleNodeDebugEventEntity.setEventEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity.setEventType("Event Type");
    ruleNodeDebugEventEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setMetadata("Metadata");
    ruleNodeDebugEventEntity.setMsgId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setMsgType("42");
    ruleNodeDebugEventEntity.setRelationType("Relation Type");
    ruleNodeDebugEventEntity.setServiceId("42");
    ruleNodeDebugEventEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setTs(1L);
    ruleNodeDebugEventEntity.setUuid(ModelConstants.NULL_UUID);

    RuleNodeDebugEventEntity ruleNodeDebugEventEntity2 = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity2.setCreatedTime(1L);
    ruleNodeDebugEventEntity2.setData("Data");
    ruleNodeDebugEventEntity2.setDataType("Data Type");
    ruleNodeDebugEventEntity2.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setError("An error occurred");
    ruleNodeDebugEventEntity2.setEventEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity2.setEventType("Event Type");
    ruleNodeDebugEventEntity2.setId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setMetadata("Metadata");
    ruleNodeDebugEventEntity2.setMsgId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setMsgType("Msg Type");
    ruleNodeDebugEventEntity2.setRelationType("Relation Type");
    ruleNodeDebugEventEntity2.setServiceId("42");
    ruleNodeDebugEventEntity2.setTenantId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setTs(1L);
    ruleNodeDebugEventEntity2.setUuid(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
    ruleNodeDebugEventEntity.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setError("An error occurred");
    ruleNodeDebugEventEntity.setEventEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity.setEventType("Event Type");
    ruleNodeDebugEventEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setMetadata("Metadata");
    ruleNodeDebugEventEntity.setMsgId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setMsgType(null);
    ruleNodeDebugEventEntity.setRelationType("Relation Type");
    ruleNodeDebugEventEntity.setServiceId("42");
    ruleNodeDebugEventEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setTs(1L);
    ruleNodeDebugEventEntity.setUuid(ModelConstants.NULL_UUID);

    RuleNodeDebugEventEntity ruleNodeDebugEventEntity2 = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity2.setCreatedTime(1L);
    ruleNodeDebugEventEntity2.setData("Data");
    ruleNodeDebugEventEntity2.setDataType("Data Type");
    ruleNodeDebugEventEntity2.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setError("An error occurred");
    ruleNodeDebugEventEntity2.setEventEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity2.setEventType("Event Type");
    ruleNodeDebugEventEntity2.setId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setMetadata("Metadata");
    ruleNodeDebugEventEntity2.setMsgId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setMsgType("Msg Type");
    ruleNodeDebugEventEntity2.setRelationType("Relation Type");
    ruleNodeDebugEventEntity2.setServiceId("42");
    ruleNodeDebugEventEntity2.setTenantId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setTs(1L);
    ruleNodeDebugEventEntity2.setUuid(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
    ruleNodeDebugEventEntity.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setError("An error occurred");
    ruleNodeDebugEventEntity.setEventEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity.setEventType("Event Type");
    ruleNodeDebugEventEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setMetadata("Metadata");
    ruleNodeDebugEventEntity.setMsgId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setMsgType("Msg Type");
    ruleNodeDebugEventEntity.setRelationType("42");
    ruleNodeDebugEventEntity.setServiceId("42");
    ruleNodeDebugEventEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setTs(1L);
    ruleNodeDebugEventEntity.setUuid(ModelConstants.NULL_UUID);

    RuleNodeDebugEventEntity ruleNodeDebugEventEntity2 = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity2.setCreatedTime(1L);
    ruleNodeDebugEventEntity2.setData("Data");
    ruleNodeDebugEventEntity2.setDataType("Data Type");
    ruleNodeDebugEventEntity2.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setError("An error occurred");
    ruleNodeDebugEventEntity2.setEventEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity2.setEventType("Event Type");
    ruleNodeDebugEventEntity2.setId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setMetadata("Metadata");
    ruleNodeDebugEventEntity2.setMsgId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setMsgType("Msg Type");
    ruleNodeDebugEventEntity2.setRelationType("Relation Type");
    ruleNodeDebugEventEntity2.setServiceId("42");
    ruleNodeDebugEventEntity2.setTenantId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setTs(1L);
    ruleNodeDebugEventEntity2.setUuid(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
    ruleNodeDebugEventEntity.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setError("An error occurred");
    ruleNodeDebugEventEntity.setEventEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity.setEventType("Event Type");
    ruleNodeDebugEventEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setMetadata("Metadata");
    ruleNodeDebugEventEntity.setMsgId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setMsgType("Msg Type");
    ruleNodeDebugEventEntity.setRelationType(null);
    ruleNodeDebugEventEntity.setServiceId("42");
    ruleNodeDebugEventEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setTs(1L);
    ruleNodeDebugEventEntity.setUuid(ModelConstants.NULL_UUID);

    RuleNodeDebugEventEntity ruleNodeDebugEventEntity2 = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity2.setCreatedTime(1L);
    ruleNodeDebugEventEntity2.setData("Data");
    ruleNodeDebugEventEntity2.setDataType("Data Type");
    ruleNodeDebugEventEntity2.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setError("An error occurred");
    ruleNodeDebugEventEntity2.setEventEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity2.setEventType("Event Type");
    ruleNodeDebugEventEntity2.setId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setMetadata("Metadata");
    ruleNodeDebugEventEntity2.setMsgId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setMsgType("Msg Type");
    ruleNodeDebugEventEntity2.setRelationType("Relation Type");
    ruleNodeDebugEventEntity2.setServiceId("42");
    ruleNodeDebugEventEntity2.setTenantId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity2.setTs(1L);
    ruleNodeDebugEventEntity2.setUuid(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
    ruleNodeDebugEventEntity.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setError("An error occurred");
    ruleNodeDebugEventEntity.setEventEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity.setEventType("Event Type");
    ruleNodeDebugEventEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setMetadata("Metadata");
    ruleNodeDebugEventEntity.setMsgId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setMsgType("Msg Type");
    ruleNodeDebugEventEntity.setRelationType("Relation Type");
    ruleNodeDebugEventEntity.setServiceId("42");
    ruleNodeDebugEventEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setTs(1L);
    ruleNodeDebugEventEntity.setUuid(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
    ruleNodeDebugEventEntity.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setError("An error occurred");
    ruleNodeDebugEventEntity.setEventEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity.setEventType("Event Type");
    ruleNodeDebugEventEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setMetadata("Metadata");
    ruleNodeDebugEventEntity.setMsgId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setMsgType("Msg Type");
    ruleNodeDebugEventEntity.setRelationType("Relation Type");
    ruleNodeDebugEventEntity.setServiceId("42");
    ruleNodeDebugEventEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setTs(1L);
    ruleNodeDebugEventEntity.setUuid(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
    actualRuleNodeDebugEventEntity.setEventEntityId(ModelConstants.NULL_UUID);
    actualRuleNodeDebugEventEntity.setEventEntityType("Event Entity Type");
    actualRuleNodeDebugEventEntity.setEventType("Event Type");
    actualRuleNodeDebugEventEntity.setMetadata("Metadata");
    UUID msgId = ModelConstants.NULL_UUID;
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

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEventEntityId.toString());
    assertEquals("An error occurred", actualError);
    assertEquals("Data Type", actualDataType);
    assertEquals("Data", actualData);
    assertEquals("Event Entity Type", actualEventEntityType);
    assertEquals("Event Type", actualEventType);
    assertEquals("Metadata", actualMetadata);
    assertEquals("Msg Type", actualMsgType);
    assertEquals("Relation Type", actualRuleNodeDebugEventEntity.getRelationType());
    assertEquals(
        "RuleNodeDebugEventEntity(eventType=Event Type, eventEntityId=13814000-1dd2-11b2-8080-808080808080,"
            + " eventEntityType=Event Entity Type, msgId=13814000-1dd2-11b2-8080-808080808080, msgType=Msg Type,"
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
    assertSame(msgId, actualEventEntityId);
    assertSame(msgId, actualMsgId);
  }

  /**
   * Test {@link RuleNodeDebugEventEntity#RuleNodeDebugEventEntity(RuleNodeDebugEvent)}.
   *
   * <p>Method under test: {@link
   * RuleNodeDebugEventEntity#RuleNodeDebugEventEntity(RuleNodeDebugEvent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuleNodeDebugEventEntity.<init>(RuleNodeDebugEvent)"})
  public void testNewRuleNodeDebugEventEntity() {
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
    when(event.getEntityId()).thenReturn(ModelConstants.NULL_UUID);
    when(event.getMsgId()).thenReturn(ModelConstants.NULL_UUID);
    when(event.getCreatedTime()).thenReturn(1L);
    when(event.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(event.getId()).thenReturn(new EventId(ModelConstants.NULL_UUID));

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
   *   <li>Then return EventEntityType is {@code CUSTOMER}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleNodeDebugEventEntity#RuleNodeDebugEventEntity(RuleNodeDebugEvent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuleNodeDebugEventEntity.<init>(RuleNodeDebugEvent)"})
  public void testNewRuleNodeDebugEventEntity_thenReturnEventEntityTypeIsCustomer() {
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
    when(event.getEntityId()).thenReturn(ModelConstants.NULL_UUID);
    when(event.getMsgId()).thenReturn(ModelConstants.NULL_UUID);
    when(event.getCreatedTime()).thenReturn(1L);
    when(event.getEventEntity()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(event.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(event.getId()).thenReturn(new EventId(ModelConstants.NULL_UUID));

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuleNodeDebugEventEntity.<init>(RuleNodeDebugEvent)"})
  public void testNewRuleNodeDebugEventEntity_thenReturnEventEntityTypeIsTenant() {
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
    when(event.getEntityId()).thenReturn(ModelConstants.NULL_UUID);
    when(event.getMsgId()).thenReturn(ModelConstants.NULL_UUID);
    when(event.getCreatedTime()).thenReturn(1L);
    when(event.getEventEntity()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(event.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(event.getId()).thenReturn(new EventId(ModelConstants.NULL_UUID));

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
   *   <li>Given {@link RuleNodeDebugEventEntity#RuleNodeDebugEventEntity()} TenantId is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeDebugEventEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleNodeDebugEvent RuleNodeDebugEventEntity.toData()"})
  public void testToData_givenRuleNodeDebugEventEntityTenantIdIsRandomUUID() {
    // Arrange
    RuleNodeDebugEventEntity ruleNodeDebugEventEntity = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity.setCreatedTime(1L);
    ruleNodeDebugEventEntity.setData("Data");
    ruleNodeDebugEventEntity.setDataType("Data Type");
    ruleNodeDebugEventEntity.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setError("An error occurred");
    ruleNodeDebugEventEntity.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity.setEventType("Event Type");
    ruleNodeDebugEventEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setMetadata("Metadata");
    ruleNodeDebugEventEntity.setMsgId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setMsgType("Msg Type");
    ruleNodeDebugEventEntity.setRelationType("Relation Type");
    ruleNodeDebugEventEntity.setServiceId("42");
    ruleNodeDebugEventEntity.setTenantId(UUID.randomUUID());
    ruleNodeDebugEventEntity.setTs(1L);
    ruleNodeDebugEventEntity.setUuid(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setEventEntityId(null);

    // Act
    RuleNodeDebugEvent actualToDataResult = ruleNodeDebugEventEntity.toData();

    // Assert
    assertEquals("42", actualToDataResult.getServiceId());
    assertEquals("An error occurred", actualToDataResult.getError());
    assertEquals("Data Type", actualToDataResult.getDataType());
    assertEquals("Data", actualToDataResult.getData());
    assertEquals("Event Type", actualToDataResult.getEventType());
    assertEquals("Metadata", actualToDataResult.getMetadata());
    assertEquals("Msg Type", actualToDataResult.getMsgType());
    assertEquals("Relation Type", actualToDataResult.getRelationType());
    assertEquals(1L, actualToDataResult.getCreatedTime());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *   <li>Then return ServiceId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeDebugEventEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleNodeDebugEvent RuleNodeDebugEventEntity.toData()"})
  public void testToData_thenReturnServiceIdIs42() {
    // Arrange
    RuleNodeDebugEventEntity ruleNodeDebugEventEntity = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity.setCreatedTime(1L);
    ruleNodeDebugEventEntity.setData("Data");
    ruleNodeDebugEventEntity.setDataType("Data Type");
    ruleNodeDebugEventEntity.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setError("An error occurred");
    ruleNodeDebugEventEntity.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity.setEventType("Event Type");
    ruleNodeDebugEventEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setMetadata("Metadata");
    ruleNodeDebugEventEntity.setMsgId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setMsgType("Msg Type");
    ruleNodeDebugEventEntity.setRelationType("Relation Type");
    ruleNodeDebugEventEntity.setServiceId("42");
    ruleNodeDebugEventEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setTs(1L);
    ruleNodeDebugEventEntity.setUuid(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setEventEntityId(null);

    // Act
    RuleNodeDebugEvent actualToDataResult = ruleNodeDebugEventEntity.toData();

    // Assert
    assertEquals("42", actualToDataResult.getServiceId());
    assertEquals("An error occurred", actualToDataResult.getError());
    assertEquals("Data Type", actualToDataResult.getDataType());
    assertEquals("Data", actualToDataResult.getData());
    assertEquals("Event Type", actualToDataResult.getEventType());
    assertEquals("Metadata", actualToDataResult.getMetadata());
    assertEquals("Msg Type", actualToDataResult.getMsgType());
    assertEquals("Relation Type", actualToDataResult.getRelationType());
    assertEquals(1L, actualToDataResult.getCreatedTime());
  }
}
