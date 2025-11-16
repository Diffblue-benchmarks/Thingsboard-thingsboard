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
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.alarm.EntityAlarm;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;

public class EntityAlarmCompositeKeyDiffblueTest {
  /**
   * Test {@link EntityAlarmCompositeKey#equals(Object)}, and {@link
   * EntityAlarmCompositeKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityAlarmCompositeKey#equals(Object)}
   *   <li>{@link EntityAlarmCompositeKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityAlarmCompositeKey.equals(Object)",
    "int EntityAlarmCompositeKey.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityAlarmCompositeKey entityAlarmCompositeKey = new EntityAlarmCompositeKey();
    EntityAlarmCompositeKey entityAlarmCompositeKey2 = new EntityAlarmCompositeKey();

    // Act and Assert
    assertEquals(entityAlarmCompositeKey, entityAlarmCompositeKey2);
    assertEquals(entityAlarmCompositeKey.hashCode(), entityAlarmCompositeKey2.hashCode());
  }

  /**
   * Test {@link EntityAlarmCompositeKey#equals(Object)}, and {@link
   * EntityAlarmCompositeKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityAlarmCompositeKey#equals(Object)}
   *   <li>{@link EntityAlarmCompositeKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityAlarmCompositeKey.equals(Object)",
    "int EntityAlarmCompositeKey.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EntityAlarmCompositeKey entityAlarmCompositeKey =
        new EntityAlarmCompositeKey(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);
    EntityAlarmCompositeKey entityAlarmCompositeKey2 =
        new EntityAlarmCompositeKey(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(entityAlarmCompositeKey, entityAlarmCompositeKey2);
    assertEquals(entityAlarmCompositeKey.hashCode(), entityAlarmCompositeKey2.hashCode());
  }

  /**
   * Test {@link EntityAlarmCompositeKey#equals(Object)}, and {@link
   * EntityAlarmCompositeKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityAlarmCompositeKey#equals(Object)}
   *   <li>{@link EntityAlarmCompositeKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityAlarmCompositeKey.equals(Object)",
    "int EntityAlarmCompositeKey.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityAlarmCompositeKey entityAlarmCompositeKey = new EntityAlarmCompositeKey();

    // Act and Assert
    assertEquals(entityAlarmCompositeKey, entityAlarmCompositeKey);
    int expectedHashCodeResult = entityAlarmCompositeKey.hashCode();
    assertEquals(expectedHashCodeResult, entityAlarmCompositeKey.hashCode());
  }

  /**
   * Test {@link EntityAlarmCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityAlarmCompositeKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityAlarmCompositeKey.equals(Object)",
    "int EntityAlarmCompositeKey.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntityAlarmCompositeKey entityAlarmCompositeKey =
        new EntityAlarmCompositeKey(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(entityAlarmCompositeKey, new EntityAlarmCompositeKey());
  }

  /**
   * Test {@link EntityAlarmCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityAlarmCompositeKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityAlarmCompositeKey.equals(Object)",
    "int EntityAlarmCompositeKey.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityAlarmCompositeKey entityAlarmCompositeKey = new EntityAlarmCompositeKey();

    // Act and Assert
    assertNotEquals(
        entityAlarmCompositeKey,
        new EntityAlarmCompositeKey(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID));
  }

  /**
   * Test {@link EntityAlarmCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityAlarmCompositeKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityAlarmCompositeKey.equals(Object)",
    "int EntityAlarmCompositeKey.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntityAlarmCompositeKey entityAlarmCompositeKey = new EntityAlarmCompositeKey();
    entityAlarmCompositeKey.setAlarmId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(entityAlarmCompositeKey, new EntityAlarmCompositeKey());
  }

  /**
   * Test {@link EntityAlarmCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityAlarmCompositeKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityAlarmCompositeKey.equals(Object)",
    "int EntityAlarmCompositeKey.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EntityAlarmCompositeKey entityAlarmCompositeKey = new EntityAlarmCompositeKey();

    EntityAlarmCompositeKey entityAlarmCompositeKey2 = new EntityAlarmCompositeKey();
    entityAlarmCompositeKey2.setAlarmId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(entityAlarmCompositeKey, entityAlarmCompositeKey2);
  }

  /**
   * Test {@link EntityAlarmCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityAlarmCompositeKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityAlarmCompositeKey.equals(Object)",
    "int EntityAlarmCompositeKey.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityAlarmCompositeKey(), null);
  }

  /**
   * Test {@link EntityAlarmCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityAlarmCompositeKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityAlarmCompositeKey.equals(Object)",
    "int EntityAlarmCompositeKey.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityAlarmCompositeKey(), "Different type to EntityAlarmCompositeKey");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityAlarmCompositeKey#EntityAlarmCompositeKey()}
   *   <li>{@link EntityAlarmCompositeKey#setAlarmId(UUID)}
   *   <li>{@link EntityAlarmCompositeKey#setEntityId(UUID)}
   *   <li>{@link EntityAlarmCompositeKey#toString()}
   *   <li>{@link EntityAlarmCompositeKey#getAlarmId()}
   *   <li>{@link EntityAlarmCompositeKey#getEntityId()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityAlarmCompositeKey.<init>()",
    "void EntityAlarmCompositeKey.<init>(UUID, UUID)",
    "UUID EntityAlarmCompositeKey.getAlarmId()",
    "UUID EntityAlarmCompositeKey.getEntityId()",
    "void EntityAlarmCompositeKey.setAlarmId(UUID)",
    "void EntityAlarmCompositeKey.setEntityId(UUID)",
    "String EntityAlarmCompositeKey.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    EntityAlarmCompositeKey actualEntityAlarmCompositeKey = new EntityAlarmCompositeKey();
    actualEntityAlarmCompositeKey.setAlarmId(ModelConstants.NULL_UUID);
    UUID entityId = ModelConstants.NULL_UUID;
    actualEntityAlarmCompositeKey.setEntityId(entityId);
    String actualToStringResult = actualEntityAlarmCompositeKey.toString();
    UUID actualAlarmId = actualEntityAlarmCompositeKey.getAlarmId();

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualAlarmId.toString());
    assertEquals(
        "EntityAlarmCompositeKey(entityId=13814000-1dd2-11b2-8080-808080808080, alarmId=13814000-1dd2-11b2-8080"
            + "-808080808080)",
        actualToStringResult);
    assertSame(entityId, actualAlarmId);
    assertSame(entityId, actualEntityAlarmCompositeKey.getEntityId());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityAlarmCompositeKey#EntityAlarmCompositeKey(UUID, UUID)}
   *   <li>{@link EntityAlarmCompositeKey#setAlarmId(UUID)}
   *   <li>{@link EntityAlarmCompositeKey#setEntityId(UUID)}
   *   <li>{@link EntityAlarmCompositeKey#toString()}
   *   <li>{@link EntityAlarmCompositeKey#getAlarmId()}
   *   <li>{@link EntityAlarmCompositeKey#getEntityId()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityAlarmCompositeKey.<init>()",
    "void EntityAlarmCompositeKey.<init>(UUID, UUID)",
    "UUID EntityAlarmCompositeKey.getAlarmId()",
    "UUID EntityAlarmCompositeKey.getEntityId()",
    "void EntityAlarmCompositeKey.setAlarmId(UUID)",
    "void EntityAlarmCompositeKey.setEntityId(UUID)",
    "String EntityAlarmCompositeKey.toString()"
  })
  public void testGettersAndSetters_whenNull_uuid() {
    // Arrange and Act
    EntityAlarmCompositeKey actualEntityAlarmCompositeKey =
        new EntityAlarmCompositeKey(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);
    actualEntityAlarmCompositeKey.setAlarmId(ModelConstants.NULL_UUID);
    UUID entityId = ModelConstants.NULL_UUID;
    actualEntityAlarmCompositeKey.setEntityId(entityId);
    String actualToStringResult = actualEntityAlarmCompositeKey.toString();
    UUID actualAlarmId = actualEntityAlarmCompositeKey.getAlarmId();

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualAlarmId.toString());
    assertEquals(
        "EntityAlarmCompositeKey(entityId=13814000-1dd2-11b2-8080-808080808080, alarmId=13814000-1dd2-11b2-8080"
            + "-808080808080)",
        actualToStringResult);
    assertSame(entityId, actualAlarmId);
    assertSame(entityId, actualEntityAlarmCompositeKey.getEntityId());
  }

  /**
   * Test {@link EntityAlarmCompositeKey#EntityAlarmCompositeKey(EntityAlarm)}.
   *
   * <p>Method under test: {@link EntityAlarmCompositeKey#EntityAlarmCompositeKey(EntityAlarm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityAlarmCompositeKey.<init>(EntityAlarm)"})
  public void testNewEntityAlarmCompositeKey() {
    // Arrange
    EntityAlarm entityAlarm = new EntityAlarm();
    entityAlarm.setAlarmId(new AlarmId(ModelConstants.NULL_UUID));
    entityAlarm.setEntityId(BaseEntityService.NULL_CUSTOMER_ID);

    // Act
    EntityAlarmCompositeKey actualEntityAlarmCompositeKey =
        new EntityAlarmCompositeKey(entityAlarm);

    // Assert
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080",
        actualEntityAlarmCompositeKey.getAlarmId().toString());
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080",
        actualEntityAlarmCompositeKey.getEntityId().toString());
  }
}
