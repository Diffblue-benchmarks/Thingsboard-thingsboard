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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.alarm.AlarmComment;
import org.thingsboard.server.common.data.alarm.AlarmCommentType;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;

public class AlarmCommentEntityDiffblueTest {
  /**
   * Test {@link AlarmCommentEntity#equals(Object)}, and {@link AlarmCommentEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AlarmCommentEntity#equals(Object)}
   *   <li>{@link AlarmCommentEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmCommentEntity.equals(Object)",
    "int AlarmCommentEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AlarmCommentEntity alarmCommentEntity = new AlarmCommentEntity();
    alarmCommentEntity.setAlarmId(ModelConstants.NULL_UUID);
    alarmCommentEntity.setComment(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmCommentEntity.setCreatedTime(1L);
    alarmCommentEntity.setId(ModelConstants.NULL_UUID);
    alarmCommentEntity.setType(AlarmCommentType.SYSTEM);
    alarmCommentEntity.setUserId(ModelConstants.NULL_UUID);
    alarmCommentEntity.setUuid(ModelConstants.NULL_UUID);

    AlarmCommentEntity alarmCommentEntity2 = new AlarmCommentEntity();
    alarmCommentEntity2.setAlarmId(ModelConstants.NULL_UUID);
    alarmCommentEntity2.setComment(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmCommentEntity2.setCreatedTime(1L);
    alarmCommentEntity2.setId(ModelConstants.NULL_UUID);
    alarmCommentEntity2.setType(AlarmCommentType.SYSTEM);
    alarmCommentEntity2.setUserId(ModelConstants.NULL_UUID);
    alarmCommentEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(alarmCommentEntity, alarmCommentEntity2);
    assertEquals(alarmCommentEntity.hashCode(), alarmCommentEntity2.hashCode());
  }

  /**
   * Test {@link AlarmCommentEntity#equals(Object)}, and {@link AlarmCommentEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AlarmCommentEntity#equals(Object)}
   *   <li>{@link AlarmCommentEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmCommentEntity.equals(Object)",
    "int AlarmCommentEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AlarmCommentEntity alarmCommentEntity = new AlarmCommentEntity();
    alarmCommentEntity.setAlarmId(ModelConstants.NULL_UUID);
    alarmCommentEntity.setComment(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmCommentEntity.setCreatedTime(1L);
    alarmCommentEntity.setId(ModelConstants.NULL_UUID);
    alarmCommentEntity.setType(AlarmCommentType.SYSTEM);
    alarmCommentEntity.setUserId(ModelConstants.NULL_UUID);
    alarmCommentEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(alarmCommentEntity, alarmCommentEntity);
    int expectedHashCodeResult = alarmCommentEntity.hashCode();
    assertEquals(expectedHashCodeResult, alarmCommentEntity.hashCode());
  }

  /**
   * Test {@link AlarmCommentEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmCommentEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmCommentEntity.equals(Object)",
    "int AlarmCommentEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AlarmCommentEntity alarmCommentEntity = new AlarmCommentEntity();
    alarmCommentEntity.setAlarmId(UUID.randomUUID());
    alarmCommentEntity.setComment(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmCommentEntity.setCreatedTime(1L);
    alarmCommentEntity.setId(ModelConstants.NULL_UUID);
    alarmCommentEntity.setType(AlarmCommentType.SYSTEM);
    alarmCommentEntity.setUserId(ModelConstants.NULL_UUID);
    alarmCommentEntity.setUuid(ModelConstants.NULL_UUID);

    AlarmCommentEntity alarmCommentEntity2 = new AlarmCommentEntity();
    alarmCommentEntity2.setAlarmId(ModelConstants.NULL_UUID);
    alarmCommentEntity2.setComment(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmCommentEntity2.setCreatedTime(1L);
    alarmCommentEntity2.setId(ModelConstants.NULL_UUID);
    alarmCommentEntity2.setType(AlarmCommentType.SYSTEM);
    alarmCommentEntity2.setUserId(ModelConstants.NULL_UUID);
    alarmCommentEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(alarmCommentEntity, alarmCommentEntity2);
  }

  /**
   * Test {@link AlarmCommentEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmCommentEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmCommentEntity.equals(Object)",
    "int AlarmCommentEntity.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    AlarmCommentEntity alarmCommentEntity = new AlarmCommentEntity();
    alarmCommentEntity.setAlarmId(ModelConstants.NULL_UUID);
    alarmCommentEntity.setComment(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmCommentEntity.setCreatedTime(1L);
    alarmCommentEntity.setId(ModelConstants.NULL_UUID);
    alarmCommentEntity.setType(AlarmCommentType.SYSTEM);
    alarmCommentEntity.setUserId(ModelConstants.NULL_UUID);
    alarmCommentEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(alarmCommentEntity, null);
  }

  /**
   * Test {@link AlarmCommentEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmCommentEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmCommentEntity.equals(Object)",
    "int AlarmCommentEntity.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    AlarmCommentEntity alarmCommentEntity = new AlarmCommentEntity();
    alarmCommentEntity.setAlarmId(ModelConstants.NULL_UUID);
    alarmCommentEntity.setComment(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmCommentEntity.setCreatedTime(1L);
    alarmCommentEntity.setId(ModelConstants.NULL_UUID);
    alarmCommentEntity.setType(AlarmCommentType.SYSTEM);
    alarmCommentEntity.setUserId(ModelConstants.NULL_UUID);
    alarmCommentEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(alarmCommentEntity, "Different type to AlarmCommentEntity");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AlarmCommentEntity#AlarmCommentEntity()}
   *   <li>{@link AlarmCommentEntity#toString()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AlarmCommentEntity.<init>()",
    "java.lang.String AlarmCommentEntity.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    AlarmCommentEntity actualAlarmCommentEntity = new AlarmCommentEntity();

    // Assert
    assertEquals("AlarmCommentEntity()", actualAlarmCommentEntity.toString());
    assertNull(actualAlarmCommentEntity.getComment());
    assertNull(actualAlarmCommentEntity.getId());
    assertNull(actualAlarmCommentEntity.getUuid());
    assertNull(actualAlarmCommentEntity.getAlarmId());
    assertNull(actualAlarmCommentEntity.getUserId());
    assertNull(actualAlarmCommentEntity.getType());
    assertEquals(0L, actualAlarmCommentEntity.getCreatedTime());
  }

  /**
   * Test {@link AlarmCommentEntity#AlarmCommentEntity(AlarmComment)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return toData CreatedTime is one.
   * </ul>
   *
   * <p>Method under test: {@link AlarmCommentEntity#AlarmCommentEntity(AlarmComment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AlarmCommentEntity.<init>(AlarmComment)"})
  public void testNewAlarmCommentEntity_givenOne_thenReturnToDataCreatedTimeIsOne() {
    // Arrange
    AlarmComment alarmComment = new AlarmComment();
    alarmComment.setCreatedTime(1L);
    alarmComment.setAlarmId(new AlarmId(ModelConstants.NULL_UUID));

    // Act
    AlarmCommentEntity actualAlarmCommentEntity = new AlarmCommentEntity(alarmComment);

    // Assert
    AlarmComment toDataResult = actualAlarmCommentEntity.toData();
    assertNull(toDataResult.getType());
    assertNull(actualAlarmCommentEntity.getType());
    assertEquals(1L, toDataResult.getCreatedTime());
    assertEquals(1L, actualAlarmCommentEntity.getCreatedTime());
  }

  /**
   * Test {@link AlarmCommentEntity#AlarmCommentEntity(AlarmComment)}.
   *
   * <ul>
   *   <li>Given {@code SYSTEM}.
   *   <li>Then return toData Type is {@code SYSTEM}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmCommentEntity#AlarmCommentEntity(AlarmComment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AlarmCommentEntity.<init>(AlarmComment)"})
  public void testNewAlarmCommentEntity_givenSystem_thenReturnToDataTypeIsSystem() {
    // Arrange
    AlarmComment alarmComment = new AlarmComment();
    alarmComment.setType(AlarmCommentType.SYSTEM);
    alarmComment.setAlarmId(new AlarmId(ModelConstants.NULL_UUID));

    // Act
    AlarmCommentEntity actualAlarmCommentEntity = new AlarmCommentEntity(alarmComment);

    // Assert
    AlarmComment toDataResult = actualAlarmCommentEntity.toData();
    assertEquals(0L, toDataResult.getCreatedTime());
    assertEquals(0L, actualAlarmCommentEntity.getCreatedTime());
    assertEquals(AlarmCommentType.SYSTEM, toDataResult.getType());
    assertEquals(AlarmCommentType.SYSTEM, actualAlarmCommentEntity.getType());
  }

  /**
   * Test {@link AlarmCommentEntity#AlarmCommentEntity(AlarmComment)}.
   *
   * <ul>
   *   <li>Then return toData Type is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmCommentEntity#AlarmCommentEntity(AlarmComment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AlarmCommentEntity.<init>(AlarmComment)"})
  public void testNewAlarmCommentEntity_thenReturnToDataTypeIsNull() {
    // Arrange
    AlarmComment alarmComment = new AlarmComment();
    alarmComment.setAlarmId(new AlarmId(ModelConstants.NULL_UUID));

    // Act
    AlarmCommentEntity actualAlarmCommentEntity = new AlarmCommentEntity(alarmComment);

    // Assert
    AlarmComment toDataResult = actualAlarmCommentEntity.toData();
    assertNull(toDataResult.getType());
    assertNull(actualAlarmCommentEntity.getType());
    assertEquals(0L, toDataResult.getCreatedTime());
    assertEquals(0L, actualAlarmCommentEntity.getCreatedTime());
  }

  /**
   * Test {@link AlarmCommentEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link AlarmCommentEntity#AlarmCommentEntity()} AlarmId is {@link
   *       ModelConstants#NULL_UUID}.
   *   <li>Then Comment return {@link ObjectNode}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmCommentEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AlarmComment AlarmCommentEntity.toData()"})
  public void testToData_givenAlarmCommentEntityAlarmIdIsNull_uuid_thenCommentReturnObjectNode() {
    // Arrange
    AlarmCommentEntity alarmCommentEntity = new AlarmCommentEntity();
    alarmCommentEntity.setAlarmId(ModelConstants.NULL_UUID);
    alarmCommentEntity.setComment(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmCommentEntity.setCreatedTime(1L);
    alarmCommentEntity.setId(ModelConstants.NULL_UUID);
    alarmCommentEntity.setType(AlarmCommentType.SYSTEM);
    alarmCommentEntity.setUuid(ModelConstants.NULL_UUID);
    alarmCommentEntity.setUserId(ModelConstants.NULL_UUID);

    // Act
    AlarmComment actualToDataResult = alarmCommentEntity.toData();

    // Assert
    assertTrue(actualToDataResult.getComment() instanceof ObjectNode);
    assertEquals("{\"isPublic\":true}", actualToDataResult.getName());
    assertEquals(1L, actualToDataResult.getCreatedTime());
    assertEquals(AlarmCommentType.SYSTEM, actualToDataResult.getType());
  }

  /**
   * Test {@link AlarmCommentEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link AlarmCommentEntity#AlarmCommentEntity()}.
   *   <li>Then return Comment is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmCommentEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AlarmComment AlarmCommentEntity.toData()"})
  public void testToData_givenAlarmCommentEntity_thenReturnCommentIsNull() {
    // Arrange and Act
    AlarmComment actualToDataResult = new AlarmCommentEntity().toData();

    // Assert
    assertNull(actualToDataResult.getComment());
    assertNull(actualToDataResult.getUuidId());
    AlarmId alarmId = actualToDataResult.getAlarmId();
    assertNull(alarmId.getId());
    assertNull(actualToDataResult.getId().getId());
    assertNull(actualToDataResult.getType());
    assertNull(actualToDataResult.getUserId());
    assertEquals(0L, actualToDataResult.getCreatedTime());
    assertFalse(alarmId.isNullUid());
  }
}
