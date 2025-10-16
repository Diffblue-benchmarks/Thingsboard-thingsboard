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
package org.thingsboard.server.dao.eventsourcing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.eventsourcing.SaveEntityEvent.SaveEntityEventBuilder;
import org.thingsboard.server.dao.model.ModelConstants;

@ContextConfiguration(classes = {SaveEntityEventBuilder.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class SaveEntityEventDiffblueTest {
  @Autowired private SaveEntityEventBuilder<Object> saveEntityEventBuilder;

  /**
   * Test {@link SaveEntityEvent#equals(Object)}, and {@link SaveEntityEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SaveEntityEvent#equals(Object)}
   *   <li>{@link SaveEntityEvent#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SaveEntityEvent.equals(Object)", "int SaveEntityEvent.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SaveEntityEventBuilder<Object> builderResult = SaveEntityEvent.builder();
    SaveEntityEvent<Object> saveEntityEvent =
        builderResult
            .created(true)
            .entity("Entity")
            .entityId(BaseEntityService.NULL_CUSTOMER_ID)
            .oldEntity("Old Entity")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .build();

    SaveEntityEventBuilder<Object> builderResult2 = SaveEntityEvent.builder();
    SaveEntityEvent<Object> saveEntityEvent2 =
        builderResult2
            .created(true)
            .entity("Entity")
            .entityId(BaseEntityService.NULL_CUSTOMER_ID)
            .oldEntity("Old Entity")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .build();

    // Act and Assert
    assertEquals(saveEntityEvent, saveEntityEvent2);
    assertEquals(saveEntityEvent.hashCode(), saveEntityEvent2.hashCode());
  }

  /**
   * Test {@link SaveEntityEvent#equals(Object)}, and {@link SaveEntityEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SaveEntityEvent#equals(Object)}
   *   <li>{@link SaveEntityEvent#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SaveEntityEvent.equals(Object)", "int SaveEntityEvent.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    SaveEntityEventBuilder<Object> builderResult = SaveEntityEvent.builder();
    SaveEntityEvent<Object> saveEntityEvent =
        builderResult
            .created(null)
            .entity("Entity")
            .entityId(BaseEntityService.NULL_CUSTOMER_ID)
            .oldEntity("Old Entity")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .build();

    SaveEntityEventBuilder<Object> builderResult2 = SaveEntityEvent.builder();
    SaveEntityEvent<Object> saveEntityEvent2 =
        builderResult2
            .created(null)
            .entity("Entity")
            .entityId(BaseEntityService.NULL_CUSTOMER_ID)
            .oldEntity("Old Entity")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .build();

    // Act and Assert
    assertEquals(saveEntityEvent, saveEntityEvent2);
    assertEquals(saveEntityEvent.hashCode(), saveEntityEvent2.hashCode());
  }

  /**
   * Test {@link SaveEntityEvent#equals(Object)}, and {@link SaveEntityEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SaveEntityEvent#equals(Object)}
   *   <li>{@link SaveEntityEvent#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SaveEntityEvent.equals(Object)", "int SaveEntityEvent.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    SaveEntityEventBuilder<Object> builderResult = SaveEntityEvent.builder();
    SaveEntityEvent<Object> saveEntityEvent =
        builderResult
            .created(true)
            .entity(null)
            .entityId(BaseEntityService.NULL_CUSTOMER_ID)
            .oldEntity("Old Entity")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .build();

    SaveEntityEventBuilder<Object> builderResult2 = SaveEntityEvent.builder();
    SaveEntityEvent<Object> saveEntityEvent2 =
        builderResult2
            .created(true)
            .entity(null)
            .entityId(BaseEntityService.NULL_CUSTOMER_ID)
            .oldEntity("Old Entity")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .build();

    // Act and Assert
    assertEquals(saveEntityEvent, saveEntityEvent2);
    assertEquals(saveEntityEvent.hashCode(), saveEntityEvent2.hashCode());
  }

  /**
   * Test {@link SaveEntityEvent#equals(Object)}, and {@link SaveEntityEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SaveEntityEvent#equals(Object)}
   *   <li>{@link SaveEntityEvent#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SaveEntityEvent.equals(Object)", "int SaveEntityEvent.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    SaveEntityEventBuilder<Object> builderResult = SaveEntityEvent.builder();
    SaveEntityEvent<Object> saveEntityEvent =
        builderResult
            .created(true)
            .entity("Entity")
            .entityId(null)
            .oldEntity("Old Entity")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .build();

    SaveEntityEventBuilder<Object> builderResult2 = SaveEntityEvent.builder();
    SaveEntityEvent<Object> saveEntityEvent2 =
        builderResult2
            .created(true)
            .entity("Entity")
            .entityId(null)
            .oldEntity("Old Entity")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .build();

    // Act and Assert
    assertEquals(saveEntityEvent, saveEntityEvent2);
    assertEquals(saveEntityEvent.hashCode(), saveEntityEvent2.hashCode());
  }

  /**
   * Test {@link SaveEntityEvent#equals(Object)}, and {@link SaveEntityEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SaveEntityEvent#equals(Object)}
   *   <li>{@link SaveEntityEvent#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SaveEntityEvent.equals(Object)", "int SaveEntityEvent.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    SaveEntityEventBuilder<Object> builderResult = SaveEntityEvent.builder();
    SaveEntityEvent<Object> saveEntityEvent =
        builderResult
            .created(true)
            .entity("Entity")
            .entityId(BaseEntityService.NULL_CUSTOMER_ID)
            .oldEntity(null)
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .build();

    SaveEntityEventBuilder<Object> builderResult2 = SaveEntityEvent.builder();
    SaveEntityEvent<Object> saveEntityEvent2 =
        builderResult2
            .created(true)
            .entity("Entity")
            .entityId(BaseEntityService.NULL_CUSTOMER_ID)
            .oldEntity(null)
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .build();

    // Act and Assert
    assertEquals(saveEntityEvent, saveEntityEvent2);
    assertEquals(saveEntityEvent.hashCode(), saveEntityEvent2.hashCode());
  }

  /**
   * Test {@link SaveEntityEvent#equals(Object)}, and {@link SaveEntityEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SaveEntityEvent#equals(Object)}
   *   <li>{@link SaveEntityEvent#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SaveEntityEvent.equals(Object)", "int SaveEntityEvent.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SaveEntityEventBuilder<Object> builderResult = SaveEntityEvent.builder();
    SaveEntityEvent<Object> saveEntityEvent =
        builderResult
            .created(true)
            .entity("Entity")
            .entityId(BaseEntityService.NULL_CUSTOMER_ID)
            .oldEntity("Old Entity")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .build();

    // Act and Assert
    assertEquals(saveEntityEvent, saveEntityEvent);
    int expectedHashCodeResult = saveEntityEvent.hashCode();
    assertEquals(expectedHashCodeResult, saveEntityEvent.hashCode());
  }

  /**
   * Test {@link SaveEntityEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SaveEntityEvent#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SaveEntityEvent.equals(Object)", "int SaveEntityEvent.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    SaveEntityEventBuilder<Object> builderResult = SaveEntityEvent.builder();
    SaveEntityEvent<Object> saveEntityEvent =
        builderResult
            .created(false)
            .entity("Entity")
            .entityId(BaseEntityService.NULL_CUSTOMER_ID)
            .oldEntity("Old Entity")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .build();

    SaveEntityEventBuilder<Object> builderResult2 = SaveEntityEvent.builder();

    // Act and Assert
    assertNotEquals(
        saveEntityEvent,
        builderResult2
            .created(true)
            .entity("Entity")
            .entityId(BaseEntityService.NULL_CUSTOMER_ID)
            .oldEntity("Old Entity")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .build());
  }

  /**
   * Test {@link SaveEntityEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SaveEntityEvent#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SaveEntityEvent.equals(Object)", "int SaveEntityEvent.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    SaveEntityEventBuilder<Object> builderResult = SaveEntityEvent.builder();
    SaveEntityEvent<Object> saveEntityEvent =
        builderResult
            .created(null)
            .entity("Entity")
            .entityId(BaseEntityService.NULL_CUSTOMER_ID)
            .oldEntity("Old Entity")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .build();

    SaveEntityEventBuilder<Object> builderResult2 = SaveEntityEvent.builder();

    // Act and Assert
    assertNotEquals(
        saveEntityEvent,
        builderResult2
            .created(true)
            .entity("Entity")
            .entityId(BaseEntityService.NULL_CUSTOMER_ID)
            .oldEntity("Old Entity")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .build());
  }

  /**
   * Test {@link SaveEntityEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SaveEntityEvent#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SaveEntityEvent.equals(Object)", "int SaveEntityEvent.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    SaveEntityEventBuilder<Object> builderResult = SaveEntityEvent.builder();
    SaveEntityEvent<Object> saveEntityEvent =
        builderResult
            .created(true)
            .entity(1)
            .entityId(BaseEntityService.NULL_CUSTOMER_ID)
            .oldEntity("Old Entity")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .build();

    SaveEntityEventBuilder<Object> builderResult2 = SaveEntityEvent.builder();

    // Act and Assert
    assertNotEquals(
        saveEntityEvent,
        builderResult2
            .created(true)
            .entity("Entity")
            .entityId(BaseEntityService.NULL_CUSTOMER_ID)
            .oldEntity("Old Entity")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .build());
  }

  /**
   * Test {@link SaveEntityEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SaveEntityEvent#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SaveEntityEvent.equals(Object)", "int SaveEntityEvent.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    SaveEntityEventBuilder<Object> builderResult = SaveEntityEvent.builder();

    SaveEntityEventBuilder<Object> createdResult = builderResult.created(true);

    SaveEntityEventBuilder<Object> builderResult2 = SaveEntityEvent.builder();
    SaveEntityEvent<Object> saveEntityEvent =
        createdResult
            .entity(
                builderResult2
                    .created(true)
                    .entity("Entity")
                    .entityId(BaseEntityService.NULL_CUSTOMER_ID)
                    .oldEntity("Old Entity")
                    .tenantId(ModelConstants.SYSTEM_TENANT)
                    .build())
            .entityId(BaseEntityService.NULL_CUSTOMER_ID)
            .oldEntity("Old Entity")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .build();

    SaveEntityEventBuilder<Object> builderResult3 = SaveEntityEvent.builder();

    // Act and Assert
    assertNotEquals(
        saveEntityEvent,
        builderResult3
            .created(true)
            .entity("Entity")
            .entityId(BaseEntityService.NULL_CUSTOMER_ID)
            .oldEntity("Old Entity")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .build());
  }

  /**
   * Test {@link SaveEntityEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SaveEntityEvent#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SaveEntityEvent.equals(Object)", "int SaveEntityEvent.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    SaveEntityEventBuilder<Object> builderResult = SaveEntityEvent.builder();
    SaveEntityEvent<Object> saveEntityEvent =
        builderResult
            .created(true)
            .entity(null)
            .entityId(BaseEntityService.NULL_CUSTOMER_ID)
            .oldEntity("Old Entity")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .build();

    SaveEntityEventBuilder<Object> builderResult2 = SaveEntityEvent.builder();

    // Act and Assert
    assertNotEquals(
        saveEntityEvent,
        builderResult2
            .created(true)
            .entity("Entity")
            .entityId(BaseEntityService.NULL_CUSTOMER_ID)
            .oldEntity("Old Entity")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .build());
  }

  /**
   * Test {@link SaveEntityEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SaveEntityEvent#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SaveEntityEvent.equals(Object)", "int SaveEntityEvent.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    SaveEntityEventBuilder<Object> builderResult = SaveEntityEvent.builder();
    SaveEntityEvent<Object> saveEntityEvent =
        builderResult
            .created(true)
            .entity("Entity")
            .entityId(ModelConstants.SYSTEM_TENANT)
            .oldEntity("Old Entity")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .build();

    SaveEntityEventBuilder<Object> builderResult2 = SaveEntityEvent.builder();

    // Act and Assert
    assertNotEquals(
        saveEntityEvent,
        builderResult2
            .created(true)
            .entity("Entity")
            .entityId(BaseEntityService.NULL_CUSTOMER_ID)
            .oldEntity("Old Entity")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .build());
  }

  /**
   * Test {@link SaveEntityEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SaveEntityEvent#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SaveEntityEvent.equals(Object)", "int SaveEntityEvent.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    SaveEntityEventBuilder<Object> builderResult = SaveEntityEvent.builder();
    SaveEntityEvent<Object> saveEntityEvent =
        builderResult
            .created(true)
            .entity("Entity")
            .entityId(null)
            .oldEntity("Old Entity")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .build();

    SaveEntityEventBuilder<Object> builderResult2 = SaveEntityEvent.builder();

    // Act and Assert
    assertNotEquals(
        saveEntityEvent,
        builderResult2
            .created(true)
            .entity("Entity")
            .entityId(BaseEntityService.NULL_CUSTOMER_ID)
            .oldEntity("Old Entity")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .build());
  }

  /**
   * Test {@link SaveEntityEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SaveEntityEvent#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SaveEntityEvent.equals(Object)", "int SaveEntityEvent.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    SaveEntityEventBuilder<Object> builderResult = SaveEntityEvent.builder();
    SaveEntityEvent<Object> saveEntityEvent =
        builderResult
            .created(true)
            .entity("Entity")
            .entityId(BaseEntityService.NULL_CUSTOMER_ID)
            .oldEntity(1)
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .build();

    SaveEntityEventBuilder<Object> builderResult2 = SaveEntityEvent.builder();

    // Act and Assert
    assertNotEquals(
        saveEntityEvent,
        builderResult2
            .created(true)
            .entity("Entity")
            .entityId(BaseEntityService.NULL_CUSTOMER_ID)
            .oldEntity("Old Entity")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .build());
  }

  /**
   * Test {@link SaveEntityEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SaveEntityEvent#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SaveEntityEvent.equals(Object)", "int SaveEntityEvent.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    SaveEntityEventBuilder<Object> builderResult = SaveEntityEvent.builder();

    SaveEntityEventBuilder<Object> entityIdResult =
        builderResult.created(true).entity("Entity").entityId(BaseEntityService.NULL_CUSTOMER_ID);

    SaveEntityEventBuilder<Object> builderResult2 = SaveEntityEvent.builder();
    SaveEntityEvent<Object> saveEntityEvent =
        entityIdResult
            .oldEntity(
                builderResult2
                    .created(true)
                    .entity("Entity")
                    .entityId(BaseEntityService.NULL_CUSTOMER_ID)
                    .oldEntity("Old Entity")
                    .tenantId(ModelConstants.SYSTEM_TENANT)
                    .build())
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .build();

    SaveEntityEventBuilder<Object> builderResult3 = SaveEntityEvent.builder();

    // Act and Assert
    assertNotEquals(
        saveEntityEvent,
        builderResult3
            .created(true)
            .entity("Entity")
            .entityId(BaseEntityService.NULL_CUSTOMER_ID)
            .oldEntity("Old Entity")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .build());
  }

  /**
   * Test {@link SaveEntityEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SaveEntityEvent#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SaveEntityEvent.equals(Object)", "int SaveEntityEvent.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    SaveEntityEventBuilder<Object> builderResult = SaveEntityEvent.builder();
    SaveEntityEvent<Object> saveEntityEvent =
        builderResult
            .created(true)
            .entity("Entity")
            .entityId(BaseEntityService.NULL_CUSTOMER_ID)
            .oldEntity(null)
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .build();

    SaveEntityEventBuilder<Object> builderResult2 = SaveEntityEvent.builder();

    // Act and Assert
    assertNotEquals(
        saveEntityEvent,
        builderResult2
            .created(true)
            .entity("Entity")
            .entityId(BaseEntityService.NULL_CUSTOMER_ID)
            .oldEntity("Old Entity")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .build());
  }

  /**
   * Test {@link SaveEntityEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SaveEntityEvent#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SaveEntityEvent.equals(Object)", "int SaveEntityEvent.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    SaveEntityEventBuilder<Object> builderResult = SaveEntityEvent.builder();
    SaveEntityEvent<Object> saveEntityEvent =
        builderResult
            .created(true)
            .entity("Entity")
            .entityId(BaseEntityService.NULL_CUSTOMER_ID)
            .oldEntity("Old Entity")
            .tenantId(null)
            .build();

    SaveEntityEventBuilder<Object> builderResult2 = SaveEntityEvent.builder();

    // Act and Assert
    assertNotEquals(
        saveEntityEvent,
        builderResult2
            .created(true)
            .entity("Entity")
            .entityId(BaseEntityService.NULL_CUSTOMER_ID)
            .oldEntity("Old Entity")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .build());
  }

  /**
   * Test {@link SaveEntityEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SaveEntityEvent#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SaveEntityEvent.equals(Object)", "int SaveEntityEvent.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    SaveEntityEventBuilder<Object> builderResult = SaveEntityEvent.builder();
    SaveEntityEvent<Object> saveEntityEvent =
        builderResult
            .created(true)
            .entity("Entity")
            .entityId(BaseEntityService.NULL_CUSTOMER_ID)
            .oldEntity("Old Entity")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .build();

    SaveEntityEventBuilder<Object> builderResult2 = SaveEntityEvent.builder();

    // Act and Assert
    assertNotEquals(
        saveEntityEvent,
        builderResult2
            .created(true)
            .entity("Entity")
            .entityId(BaseEntityService.NULL_CUSTOMER_ID)
            .oldEntity("Old Entity")
            .tenantId(null)
            .build());
  }

  /**
   * Test {@link SaveEntityEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SaveEntityEvent#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SaveEntityEvent.equals(Object)", "int SaveEntityEvent.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    SaveEntityEventBuilder<Object> builderResult = SaveEntityEvent.builder();

    // Act and Assert
    assertNotEquals(
        builderResult
            .created(true)
            .entity("Entity")
            .entityId(BaseEntityService.NULL_CUSTOMER_ID)
            .oldEntity("Old Entity")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .build(),
        null);
  }

  /**
   * Test {@link SaveEntityEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SaveEntityEvent#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SaveEntityEvent.equals(Object)", "int SaveEntityEvent.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    SaveEntityEventBuilder<Object> builderResult = SaveEntityEvent.builder();

    // Act and Assert
    assertNotEquals(
        builderResult
            .created(true)
            .entity("Entity")
            .entityId(BaseEntityService.NULL_CUSTOMER_ID)
            .oldEntity("Old Entity")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .build(),
        "Different type to SaveEntityEvent");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SaveEntityEvent#SaveEntityEvent(TenantId, Object, Object, EntityId, Boolean)}
   *   <li>{@link SaveEntityEvent#toString()}
   *   <li>{@link SaveEntityEvent#getCreated()}
   *   <li>{@link SaveEntityEvent#getEntity()}
   *   <li>{@link SaveEntityEvent#getEntityId()}
   *   <li>{@link SaveEntityEvent#getOldEntity()}
   *   <li>{@link SaveEntityEvent#getTenantId()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SaveEntityEvent.<init>(TenantId, Object, Object, EntityId, Boolean)",
    "Boolean SaveEntityEvent.getCreated()",
    "Object SaveEntityEvent.getEntity()",
    "EntityId SaveEntityEvent.getEntityId()",
    "Object SaveEntityEvent.getOldEntity()",
    "TenantId SaveEntityEvent.getTenantId()",
    "String SaveEntityEvent.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange
    CustomerId entityId = BaseEntityService.NULL_CUSTOMER_ID;

    // Act
    SaveEntityEvent<Object> actualSaveEntityEvent =
        new SaveEntityEvent<>(ModelConstants.SYSTEM_TENANT, "Entity", "Old Entity", entityId, true);
    String actualToStringResult = actualSaveEntityEvent.toString();
    Boolean actualCreated = actualSaveEntityEvent.getCreated();
    Object actualEntity = actualSaveEntityEvent.getEntity();
    EntityId actualEntityId = actualSaveEntityEvent.getEntityId();
    Object actualOldEntity = actualSaveEntityEvent.getOldEntity();

    // Assert
    assertEquals("Entity", actualEntity);
    assertEquals("Old Entity", actualOldEntity);
    assertEquals(
        "SaveEntityEvent(tenantId=13814000-1dd2-11b2-8080-808080808080, entity=Entity, oldEntity=Old Entity,"
            + " entityId=13814000-1dd2-11b2-8080-808080808080, created=true)",
        actualToStringResult);
    assertTrue(actualCreated);
    assertSame(TenantId.SYS_TENANT_ID, actualSaveEntityEvent.getTenantId());
    assertSame(entityId, actualEntityId);
  }

  /**
   * Test SaveEntityEventBuilder {@link SaveEntityEventBuilder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SaveEntityEventBuilder#build()}
   *   <li>{@link SaveEntityEventBuilder#created(Boolean)}
   *   <li>{@link SaveEntityEventBuilder#entity(Object)}
   *   <li>{@link SaveEntityEventBuilder#entityId(EntityId)}
   *   <li>{@link SaveEntityEventBuilder#oldEntity(Object)}
   *   <li>{@link SaveEntityEventBuilder#tenantId(TenantId)}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SaveEntityEventBuilder.<init>()",
    "SaveEntityEvent SaveEntityEventBuilder.build()",
    "SaveEntityEventBuilder SaveEntityEventBuilder.created(Boolean)",
    "SaveEntityEventBuilder SaveEntityEventBuilder.entity(Object)",
    "SaveEntityEventBuilder SaveEntityEventBuilder.entityId(EntityId)",
    "SaveEntityEventBuilder SaveEntityEventBuilder.oldEntity(Object)",
    "SaveEntityEventBuilder SaveEntityEventBuilder.tenantId(TenantId)",
    "String SaveEntityEventBuilder.toString()"
  })
  public void testSaveEntityEventBuilderBuild() {
    // Arrange and Act
    SaveEntityEventBuilder<Object> actualBuilderResult = SaveEntityEvent.builder();
    CustomerId entityId = BaseEntityService.NULL_CUSTOMER_ID;
    SaveEntityEvent<Object> actualSaveEntityEvent =
        actualBuilderResult
            .created(true)
            .entity("Entity")
            .entityId(entityId)
            .oldEntity("Old Entity")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .build();

    // Assert
    assertEquals("Entity", actualSaveEntityEvent.getEntity());
    assertEquals("Old Entity", actualSaveEntityEvent.getOldEntity());
    assertTrue(actualSaveEntityEvent.getCreated());
    assertSame(TenantId.SYS_TENANT_ID, actualSaveEntityEvent.getTenantId());
    assertSame(entityId, actualSaveEntityEvent.getEntityId());
  }
}
