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
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.id.WidgetsBundleId;
import org.thingsboard.server.common.data.widget.WidgetsBundle;
import org.thingsboard.server.dao.model.ModelConstants;

public class WidgetsBundleEntityDiffblueTest {
  /**
   * Test {@link WidgetsBundleEntity#equals(Object)}, and {@link WidgetsBundleEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WidgetsBundleEntity#equals(Object)}
   *   <li>{@link WidgetsBundleEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WidgetsBundleEntity.equals(Object)",
    "int WidgetsBundleEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    WidgetsBundleEntity widgetsBundleEntity = new WidgetsBundleEntity();
    widgetsBundleEntity.setAlias("Alias");
    widgetsBundleEntity.setCreatedTime(1L);
    widgetsBundleEntity.setDescription("The characteristics of someone or something");
    widgetsBundleEntity.setExternalId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setImage("Image");
    widgetsBundleEntity.setOrder(1);
    widgetsBundleEntity.setScada(true);
    widgetsBundleEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setTitle("Dr");
    widgetsBundleEntity.setUuid(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setVersion(1L);

    WidgetsBundleEntity widgetsBundleEntity2 = new WidgetsBundleEntity();
    widgetsBundleEntity2.setAlias("Alias");
    widgetsBundleEntity2.setCreatedTime(1L);
    widgetsBundleEntity2.setDescription("The characteristics of someone or something");
    widgetsBundleEntity2.setExternalId(ModelConstants.NULL_UUID);
    widgetsBundleEntity2.setId(ModelConstants.NULL_UUID);
    widgetsBundleEntity2.setImage("Image");
    widgetsBundleEntity2.setOrder(1);
    widgetsBundleEntity2.setScada(true);
    widgetsBundleEntity2.setTenantId(ModelConstants.NULL_UUID);
    widgetsBundleEntity2.setTitle("Dr");
    widgetsBundleEntity2.setUuid(ModelConstants.NULL_UUID);
    widgetsBundleEntity2.setVersion(1L);

    // Act and Assert
    assertEquals(widgetsBundleEntity, widgetsBundleEntity2);
    assertEquals(widgetsBundleEntity.hashCode(), widgetsBundleEntity2.hashCode());
  }

  /**
   * Test {@link WidgetsBundleEntity#equals(Object)}, and {@link WidgetsBundleEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WidgetsBundleEntity#equals(Object)}
   *   <li>{@link WidgetsBundleEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WidgetsBundleEntity.equals(Object)",
    "int WidgetsBundleEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    WidgetsBundleEntity widgetsBundleEntity = new WidgetsBundleEntity();
    widgetsBundleEntity.setAlias(null);
    widgetsBundleEntity.setCreatedTime(1L);
    widgetsBundleEntity.setDescription("The characteristics of someone or something");
    widgetsBundleEntity.setExternalId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setImage("Image");
    widgetsBundleEntity.setOrder(1);
    widgetsBundleEntity.setScada(true);
    widgetsBundleEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setTitle("Dr");
    widgetsBundleEntity.setUuid(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setVersion(1L);

    WidgetsBundleEntity widgetsBundleEntity2 = new WidgetsBundleEntity();
    widgetsBundleEntity2.setAlias(null);
    widgetsBundleEntity2.setCreatedTime(1L);
    widgetsBundleEntity2.setDescription("The characteristics of someone or something");
    widgetsBundleEntity2.setExternalId(ModelConstants.NULL_UUID);
    widgetsBundleEntity2.setId(ModelConstants.NULL_UUID);
    widgetsBundleEntity2.setImage("Image");
    widgetsBundleEntity2.setOrder(1);
    widgetsBundleEntity2.setScada(true);
    widgetsBundleEntity2.setTenantId(ModelConstants.NULL_UUID);
    widgetsBundleEntity2.setTitle("Dr");
    widgetsBundleEntity2.setUuid(ModelConstants.NULL_UUID);
    widgetsBundleEntity2.setVersion(1L);

    // Act and Assert
    assertEquals(widgetsBundleEntity, widgetsBundleEntity2);
    assertEquals(widgetsBundleEntity.hashCode(), widgetsBundleEntity2.hashCode());
  }

  /**
   * Test {@link WidgetsBundleEntity#equals(Object)}, and {@link WidgetsBundleEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WidgetsBundleEntity#equals(Object)}
   *   <li>{@link WidgetsBundleEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WidgetsBundleEntity.equals(Object)",
    "int WidgetsBundleEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    WidgetsBundleEntity widgetsBundleEntity = new WidgetsBundleEntity();
    widgetsBundleEntity.setAlias("Alias");
    widgetsBundleEntity.setCreatedTime(1L);
    widgetsBundleEntity.setDescription(null);
    widgetsBundleEntity.setExternalId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setImage("Image");
    widgetsBundleEntity.setOrder(1);
    widgetsBundleEntity.setScada(true);
    widgetsBundleEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setTitle("Dr");
    widgetsBundleEntity.setUuid(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setVersion(1L);

    WidgetsBundleEntity widgetsBundleEntity2 = new WidgetsBundleEntity();
    widgetsBundleEntity2.setAlias("Alias");
    widgetsBundleEntity2.setCreatedTime(1L);
    widgetsBundleEntity2.setDescription(null);
    widgetsBundleEntity2.setExternalId(ModelConstants.NULL_UUID);
    widgetsBundleEntity2.setId(ModelConstants.NULL_UUID);
    widgetsBundleEntity2.setImage("Image");
    widgetsBundleEntity2.setOrder(1);
    widgetsBundleEntity2.setScada(true);
    widgetsBundleEntity2.setTenantId(ModelConstants.NULL_UUID);
    widgetsBundleEntity2.setTitle("Dr");
    widgetsBundleEntity2.setUuid(ModelConstants.NULL_UUID);
    widgetsBundleEntity2.setVersion(1L);

    // Act and Assert
    assertEquals(widgetsBundleEntity, widgetsBundleEntity2);
    assertEquals(widgetsBundleEntity.hashCode(), widgetsBundleEntity2.hashCode());
  }

  /**
   * Test {@link WidgetsBundleEntity#equals(Object)}, and {@link WidgetsBundleEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WidgetsBundleEntity#equals(Object)}
   *   <li>{@link WidgetsBundleEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WidgetsBundleEntity.equals(Object)",
    "int WidgetsBundleEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    WidgetsBundleEntity widgetsBundleEntity = new WidgetsBundleEntity();
    widgetsBundleEntity.setAlias("Alias");
    widgetsBundleEntity.setCreatedTime(1L);
    widgetsBundleEntity.setDescription("The characteristics of someone or something");
    widgetsBundleEntity.setExternalId(null);
    widgetsBundleEntity.setId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setImage("Image");
    widgetsBundleEntity.setOrder(1);
    widgetsBundleEntity.setScada(true);
    widgetsBundleEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setTitle("Dr");
    widgetsBundleEntity.setUuid(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setVersion(1L);

    WidgetsBundleEntity widgetsBundleEntity2 = new WidgetsBundleEntity();
    widgetsBundleEntity2.setAlias("Alias");
    widgetsBundleEntity2.setCreatedTime(1L);
    widgetsBundleEntity2.setDescription("The characteristics of someone or something");
    widgetsBundleEntity2.setExternalId(null);
    widgetsBundleEntity2.setId(ModelConstants.NULL_UUID);
    widgetsBundleEntity2.setImage("Image");
    widgetsBundleEntity2.setOrder(1);
    widgetsBundleEntity2.setScada(true);
    widgetsBundleEntity2.setTenantId(ModelConstants.NULL_UUID);
    widgetsBundleEntity2.setTitle("Dr");
    widgetsBundleEntity2.setUuid(ModelConstants.NULL_UUID);
    widgetsBundleEntity2.setVersion(1L);

    // Act and Assert
    assertEquals(widgetsBundleEntity, widgetsBundleEntity2);
    assertEquals(widgetsBundleEntity.hashCode(), widgetsBundleEntity2.hashCode());
  }

  /**
   * Test {@link WidgetsBundleEntity#equals(Object)}, and {@link WidgetsBundleEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WidgetsBundleEntity#equals(Object)}
   *   <li>{@link WidgetsBundleEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WidgetsBundleEntity.equals(Object)",
    "int WidgetsBundleEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    WidgetsBundleEntity widgetsBundleEntity = new WidgetsBundleEntity();
    widgetsBundleEntity.setAlias("Alias");
    widgetsBundleEntity.setCreatedTime(1L);
    widgetsBundleEntity.setDescription("The characteristics of someone or something");
    widgetsBundleEntity.setExternalId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setImage("Image");
    widgetsBundleEntity.setOrder(1);
    widgetsBundleEntity.setScada(true);
    widgetsBundleEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setTitle("Dr");
    widgetsBundleEntity.setUuid(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setVersion(1L);

    // Act and Assert
    assertEquals(widgetsBundleEntity, widgetsBundleEntity);
    int expectedHashCodeResult = widgetsBundleEntity.hashCode();
    assertEquals(expectedHashCodeResult, widgetsBundleEntity.hashCode());
  }

  /**
   * Test {@link WidgetsBundleEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WidgetsBundleEntity.equals(Object)",
    "int WidgetsBundleEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    WidgetsBundleEntity widgetsBundleEntity = new WidgetsBundleEntity();
    widgetsBundleEntity.setAlias("Dr");
    widgetsBundleEntity.setCreatedTime(1L);
    widgetsBundleEntity.setDescription("The characteristics of someone or something");
    widgetsBundleEntity.setExternalId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setImage("Image");
    widgetsBundleEntity.setOrder(1);
    widgetsBundleEntity.setScada(true);
    widgetsBundleEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setTitle("Dr");
    widgetsBundleEntity.setUuid(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setVersion(1L);

    WidgetsBundleEntity widgetsBundleEntity2 = new WidgetsBundleEntity();
    widgetsBundleEntity2.setAlias("Alias");
    widgetsBundleEntity2.setCreatedTime(1L);
    widgetsBundleEntity2.setDescription("The characteristics of someone or something");
    widgetsBundleEntity2.setExternalId(ModelConstants.NULL_UUID);
    widgetsBundleEntity2.setId(ModelConstants.NULL_UUID);
    widgetsBundleEntity2.setImage("Image");
    widgetsBundleEntity2.setOrder(1);
    widgetsBundleEntity2.setScada(true);
    widgetsBundleEntity2.setTenantId(ModelConstants.NULL_UUID);
    widgetsBundleEntity2.setTitle("Dr");
    widgetsBundleEntity2.setUuid(ModelConstants.NULL_UUID);
    widgetsBundleEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(widgetsBundleEntity, widgetsBundleEntity2);
  }

  /**
   * Test {@link WidgetsBundleEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WidgetsBundleEntity.equals(Object)",
    "int WidgetsBundleEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    WidgetsBundleEntity widgetsBundleEntity = new WidgetsBundleEntity();
    widgetsBundleEntity.setAlias(null);
    widgetsBundleEntity.setCreatedTime(1L);
    widgetsBundleEntity.setDescription("The characteristics of someone or something");
    widgetsBundleEntity.setExternalId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setImage("Image");
    widgetsBundleEntity.setOrder(1);
    widgetsBundleEntity.setScada(true);
    widgetsBundleEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setTitle("Dr");
    widgetsBundleEntity.setUuid(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setVersion(1L);

    WidgetsBundleEntity widgetsBundleEntity2 = new WidgetsBundleEntity();
    widgetsBundleEntity2.setAlias("Alias");
    widgetsBundleEntity2.setCreatedTime(1L);
    widgetsBundleEntity2.setDescription("The characteristics of someone or something");
    widgetsBundleEntity2.setExternalId(ModelConstants.NULL_UUID);
    widgetsBundleEntity2.setId(ModelConstants.NULL_UUID);
    widgetsBundleEntity2.setImage("Image");
    widgetsBundleEntity2.setOrder(1);
    widgetsBundleEntity2.setScada(true);
    widgetsBundleEntity2.setTenantId(ModelConstants.NULL_UUID);
    widgetsBundleEntity2.setTitle("Dr");
    widgetsBundleEntity2.setUuid(ModelConstants.NULL_UUID);
    widgetsBundleEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(widgetsBundleEntity, widgetsBundleEntity2);
  }

  /**
   * Test {@link WidgetsBundleEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WidgetsBundleEntity.equals(Object)",
    "int WidgetsBundleEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    WidgetsBundleEntity widgetsBundleEntity = new WidgetsBundleEntity();
    widgetsBundleEntity.setAlias("Alias");
    widgetsBundleEntity.setCreatedTime(3L);
    widgetsBundleEntity.setDescription("The characteristics of someone or something");
    widgetsBundleEntity.setExternalId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setImage("Image");
    widgetsBundleEntity.setOrder(1);
    widgetsBundleEntity.setScada(true);
    widgetsBundleEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setTitle("Dr");
    widgetsBundleEntity.setUuid(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setVersion(1L);

    WidgetsBundleEntity widgetsBundleEntity2 = new WidgetsBundleEntity();
    widgetsBundleEntity2.setAlias("Alias");
    widgetsBundleEntity2.setCreatedTime(1L);
    widgetsBundleEntity2.setDescription("The characteristics of someone or something");
    widgetsBundleEntity2.setExternalId(ModelConstants.NULL_UUID);
    widgetsBundleEntity2.setId(ModelConstants.NULL_UUID);
    widgetsBundleEntity2.setImage("Image");
    widgetsBundleEntity2.setOrder(1);
    widgetsBundleEntity2.setScada(true);
    widgetsBundleEntity2.setTenantId(ModelConstants.NULL_UUID);
    widgetsBundleEntity2.setTitle("Dr");
    widgetsBundleEntity2.setUuid(ModelConstants.NULL_UUID);
    widgetsBundleEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(widgetsBundleEntity, widgetsBundleEntity2);
  }

  /**
   * Test {@link WidgetsBundleEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WidgetsBundleEntity.equals(Object)",
    "int WidgetsBundleEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    WidgetsBundleEntity widgetsBundleEntity = new WidgetsBundleEntity();
    widgetsBundleEntity.setAlias("Alias");
    widgetsBundleEntity.setCreatedTime(1L);
    widgetsBundleEntity.setDescription("Alias");
    widgetsBundleEntity.setExternalId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setImage("Image");
    widgetsBundleEntity.setOrder(1);
    widgetsBundleEntity.setScada(true);
    widgetsBundleEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setTitle("Dr");
    widgetsBundleEntity.setUuid(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setVersion(1L);

    WidgetsBundleEntity widgetsBundleEntity2 = new WidgetsBundleEntity();
    widgetsBundleEntity2.setAlias("Alias");
    widgetsBundleEntity2.setCreatedTime(1L);
    widgetsBundleEntity2.setDescription("The characteristics of someone or something");
    widgetsBundleEntity2.setExternalId(ModelConstants.NULL_UUID);
    widgetsBundleEntity2.setId(ModelConstants.NULL_UUID);
    widgetsBundleEntity2.setImage("Image");
    widgetsBundleEntity2.setOrder(1);
    widgetsBundleEntity2.setScada(true);
    widgetsBundleEntity2.setTenantId(ModelConstants.NULL_UUID);
    widgetsBundleEntity2.setTitle("Dr");
    widgetsBundleEntity2.setUuid(ModelConstants.NULL_UUID);
    widgetsBundleEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(widgetsBundleEntity, widgetsBundleEntity2);
  }

  /**
   * Test {@link WidgetsBundleEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WidgetsBundleEntity.equals(Object)",
    "int WidgetsBundleEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    WidgetsBundleEntity widgetsBundleEntity = new WidgetsBundleEntity();
    widgetsBundleEntity.setAlias("Alias");
    widgetsBundleEntity.setCreatedTime(1L);
    widgetsBundleEntity.setDescription(null);
    widgetsBundleEntity.setExternalId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setImage("Image");
    widgetsBundleEntity.setOrder(1);
    widgetsBundleEntity.setScada(true);
    widgetsBundleEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setTitle("Dr");
    widgetsBundleEntity.setUuid(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setVersion(1L);

    WidgetsBundleEntity widgetsBundleEntity2 = new WidgetsBundleEntity();
    widgetsBundleEntity2.setAlias("Alias");
    widgetsBundleEntity2.setCreatedTime(1L);
    widgetsBundleEntity2.setDescription("The characteristics of someone or something");
    widgetsBundleEntity2.setExternalId(ModelConstants.NULL_UUID);
    widgetsBundleEntity2.setId(ModelConstants.NULL_UUID);
    widgetsBundleEntity2.setImage("Image");
    widgetsBundleEntity2.setOrder(1);
    widgetsBundleEntity2.setScada(true);
    widgetsBundleEntity2.setTenantId(ModelConstants.NULL_UUID);
    widgetsBundleEntity2.setTitle("Dr");
    widgetsBundleEntity2.setUuid(ModelConstants.NULL_UUID);
    widgetsBundleEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(widgetsBundleEntity, widgetsBundleEntity2);
  }

  /**
   * Test {@link WidgetsBundleEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WidgetsBundleEntity.equals(Object)",
    "int WidgetsBundleEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    WidgetsBundleEntity widgetsBundleEntity = new WidgetsBundleEntity();
    widgetsBundleEntity.setAlias("Alias");
    widgetsBundleEntity.setCreatedTime(1L);
    widgetsBundleEntity.setDescription("The characteristics of someone or something");
    widgetsBundleEntity.setExternalId(UUID.randomUUID());
    widgetsBundleEntity.setId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setImage("Image");
    widgetsBundleEntity.setOrder(1);
    widgetsBundleEntity.setScada(true);
    widgetsBundleEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setTitle("Dr");
    widgetsBundleEntity.setUuid(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setVersion(1L);

    WidgetsBundleEntity widgetsBundleEntity2 = new WidgetsBundleEntity();
    widgetsBundleEntity2.setAlias("Alias");
    widgetsBundleEntity2.setCreatedTime(1L);
    widgetsBundleEntity2.setDescription("The characteristics of someone or something");
    widgetsBundleEntity2.setExternalId(ModelConstants.NULL_UUID);
    widgetsBundleEntity2.setId(ModelConstants.NULL_UUID);
    widgetsBundleEntity2.setImage("Image");
    widgetsBundleEntity2.setOrder(1);
    widgetsBundleEntity2.setScada(true);
    widgetsBundleEntity2.setTenantId(ModelConstants.NULL_UUID);
    widgetsBundleEntity2.setTitle("Dr");
    widgetsBundleEntity2.setUuid(ModelConstants.NULL_UUID);
    widgetsBundleEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(widgetsBundleEntity, widgetsBundleEntity2);
  }

  /**
   * Test {@link WidgetsBundleEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WidgetsBundleEntity.equals(Object)",
    "int WidgetsBundleEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    WidgetsBundleEntity widgetsBundleEntity = new WidgetsBundleEntity();
    widgetsBundleEntity.setAlias("Alias");
    widgetsBundleEntity.setCreatedTime(1L);
    widgetsBundleEntity.setDescription("The characteristics of someone or something");
    widgetsBundleEntity.setExternalId(null);
    widgetsBundleEntity.setId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setImage("Image");
    widgetsBundleEntity.setOrder(1);
    widgetsBundleEntity.setScada(true);
    widgetsBundleEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setTitle("Dr");
    widgetsBundleEntity.setUuid(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setVersion(1L);

    WidgetsBundleEntity widgetsBundleEntity2 = new WidgetsBundleEntity();
    widgetsBundleEntity2.setAlias("Alias");
    widgetsBundleEntity2.setCreatedTime(1L);
    widgetsBundleEntity2.setDescription("The characteristics of someone or something");
    widgetsBundleEntity2.setExternalId(ModelConstants.NULL_UUID);
    widgetsBundleEntity2.setId(ModelConstants.NULL_UUID);
    widgetsBundleEntity2.setImage("Image");
    widgetsBundleEntity2.setOrder(1);
    widgetsBundleEntity2.setScada(true);
    widgetsBundleEntity2.setTenantId(ModelConstants.NULL_UUID);
    widgetsBundleEntity2.setTitle("Dr");
    widgetsBundleEntity2.setUuid(ModelConstants.NULL_UUID);
    widgetsBundleEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(widgetsBundleEntity, widgetsBundleEntity2);
  }

  /**
   * Test {@link WidgetsBundleEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WidgetsBundleEntity.equals(Object)",
    "int WidgetsBundleEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    WidgetsBundleEntity widgetsBundleEntity = new WidgetsBundleEntity();
    widgetsBundleEntity.setAlias("Alias");
    widgetsBundleEntity.setCreatedTime(1L);
    widgetsBundleEntity.setDescription("The characteristics of someone or something");
    widgetsBundleEntity.setExternalId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setImage("Alias");
    widgetsBundleEntity.setOrder(1);
    widgetsBundleEntity.setScada(true);
    widgetsBundleEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setTitle("Dr");
    widgetsBundleEntity.setUuid(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setVersion(1L);

    WidgetsBundleEntity widgetsBundleEntity2 = new WidgetsBundleEntity();
    widgetsBundleEntity2.setAlias("Alias");
    widgetsBundleEntity2.setCreatedTime(1L);
    widgetsBundleEntity2.setDescription("The characteristics of someone or something");
    widgetsBundleEntity2.setExternalId(ModelConstants.NULL_UUID);
    widgetsBundleEntity2.setId(ModelConstants.NULL_UUID);
    widgetsBundleEntity2.setImage("Image");
    widgetsBundleEntity2.setOrder(1);
    widgetsBundleEntity2.setScada(true);
    widgetsBundleEntity2.setTenantId(ModelConstants.NULL_UUID);
    widgetsBundleEntity2.setTitle("Dr");
    widgetsBundleEntity2.setUuid(ModelConstants.NULL_UUID);
    widgetsBundleEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(widgetsBundleEntity, widgetsBundleEntity2);
  }

  /**
   * Test {@link WidgetsBundleEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WidgetsBundleEntity.equals(Object)",
    "int WidgetsBundleEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    WidgetsBundleEntity widgetsBundleEntity = new WidgetsBundleEntity();
    widgetsBundleEntity.setAlias("Alias");
    widgetsBundleEntity.setCreatedTime(1L);
    widgetsBundleEntity.setDescription("The characteristics of someone or something");
    widgetsBundleEntity.setExternalId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setImage(null);
    widgetsBundleEntity.setOrder(1);
    widgetsBundleEntity.setScada(true);
    widgetsBundleEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setTitle("Dr");
    widgetsBundleEntity.setUuid(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setVersion(1L);

    WidgetsBundleEntity widgetsBundleEntity2 = new WidgetsBundleEntity();
    widgetsBundleEntity2.setAlias("Alias");
    widgetsBundleEntity2.setCreatedTime(1L);
    widgetsBundleEntity2.setDescription("The characteristics of someone or something");
    widgetsBundleEntity2.setExternalId(ModelConstants.NULL_UUID);
    widgetsBundleEntity2.setId(ModelConstants.NULL_UUID);
    widgetsBundleEntity2.setImage("Image");
    widgetsBundleEntity2.setOrder(1);
    widgetsBundleEntity2.setScada(true);
    widgetsBundleEntity2.setTenantId(ModelConstants.NULL_UUID);
    widgetsBundleEntity2.setTitle("Dr");
    widgetsBundleEntity2.setUuid(ModelConstants.NULL_UUID);
    widgetsBundleEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(widgetsBundleEntity, widgetsBundleEntity2);
  }

  /**
   * Test {@link WidgetsBundleEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WidgetsBundleEntity.equals(Object)",
    "int WidgetsBundleEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    WidgetsBundleEntity widgetsBundleEntity = new WidgetsBundleEntity();
    widgetsBundleEntity.setAlias("Alias");
    widgetsBundleEntity.setCreatedTime(1L);
    widgetsBundleEntity.setDescription("The characteristics of someone or something");
    widgetsBundleEntity.setExternalId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setImage("Image");
    widgetsBundleEntity.setOrder(3);
    widgetsBundleEntity.setScada(true);
    widgetsBundleEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setTitle("Dr");
    widgetsBundleEntity.setUuid(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setVersion(1L);

    WidgetsBundleEntity widgetsBundleEntity2 = new WidgetsBundleEntity();
    widgetsBundleEntity2.setAlias("Alias");
    widgetsBundleEntity2.setCreatedTime(1L);
    widgetsBundleEntity2.setDescription("The characteristics of someone or something");
    widgetsBundleEntity2.setExternalId(ModelConstants.NULL_UUID);
    widgetsBundleEntity2.setId(ModelConstants.NULL_UUID);
    widgetsBundleEntity2.setImage("Image");
    widgetsBundleEntity2.setOrder(1);
    widgetsBundleEntity2.setScada(true);
    widgetsBundleEntity2.setTenantId(ModelConstants.NULL_UUID);
    widgetsBundleEntity2.setTitle("Dr");
    widgetsBundleEntity2.setUuid(ModelConstants.NULL_UUID);
    widgetsBundleEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(widgetsBundleEntity, widgetsBundleEntity2);
  }

  /**
   * Test {@link WidgetsBundleEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WidgetsBundleEntity.equals(Object)",
    "int WidgetsBundleEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    WidgetsBundleEntity widgetsBundleEntity = new WidgetsBundleEntity();
    widgetsBundleEntity.setAlias("Alias");
    widgetsBundleEntity.setCreatedTime(1L);
    widgetsBundleEntity.setDescription("The characteristics of someone or something");
    widgetsBundleEntity.setExternalId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setImage("Image");
    widgetsBundleEntity.setOrder(null);
    widgetsBundleEntity.setScada(true);
    widgetsBundleEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setTitle("Dr");
    widgetsBundleEntity.setUuid(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setVersion(1L);

    WidgetsBundleEntity widgetsBundleEntity2 = new WidgetsBundleEntity();
    widgetsBundleEntity2.setAlias("Alias");
    widgetsBundleEntity2.setCreatedTime(1L);
    widgetsBundleEntity2.setDescription("The characteristics of someone or something");
    widgetsBundleEntity2.setExternalId(ModelConstants.NULL_UUID);
    widgetsBundleEntity2.setId(ModelConstants.NULL_UUID);
    widgetsBundleEntity2.setImage("Image");
    widgetsBundleEntity2.setOrder(1);
    widgetsBundleEntity2.setScada(true);
    widgetsBundleEntity2.setTenantId(ModelConstants.NULL_UUID);
    widgetsBundleEntity2.setTitle("Dr");
    widgetsBundleEntity2.setUuid(ModelConstants.NULL_UUID);
    widgetsBundleEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(widgetsBundleEntity, widgetsBundleEntity2);
  }

  /**
   * Test {@link WidgetsBundleEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WidgetsBundleEntity.equals(Object)",
    "int WidgetsBundleEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    WidgetsBundleEntity widgetsBundleEntity = new WidgetsBundleEntity();
    widgetsBundleEntity.setAlias("Alias");
    widgetsBundleEntity.setCreatedTime(1L);
    widgetsBundleEntity.setDescription("The characteristics of someone or something");
    widgetsBundleEntity.setExternalId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setImage("Image");
    widgetsBundleEntity.setOrder(1);
    widgetsBundleEntity.setScada(false);
    widgetsBundleEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setTitle("Dr");
    widgetsBundleEntity.setUuid(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setVersion(1L);

    WidgetsBundleEntity widgetsBundleEntity2 = new WidgetsBundleEntity();
    widgetsBundleEntity2.setAlias("Alias");
    widgetsBundleEntity2.setCreatedTime(1L);
    widgetsBundleEntity2.setDescription("The characteristics of someone or something");
    widgetsBundleEntity2.setExternalId(ModelConstants.NULL_UUID);
    widgetsBundleEntity2.setId(ModelConstants.NULL_UUID);
    widgetsBundleEntity2.setImage("Image");
    widgetsBundleEntity2.setOrder(1);
    widgetsBundleEntity2.setScada(true);
    widgetsBundleEntity2.setTenantId(ModelConstants.NULL_UUID);
    widgetsBundleEntity2.setTitle("Dr");
    widgetsBundleEntity2.setUuid(ModelConstants.NULL_UUID);
    widgetsBundleEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(widgetsBundleEntity, widgetsBundleEntity2);
  }

  /**
   * Test {@link WidgetsBundleEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WidgetsBundleEntity.equals(Object)",
    "int WidgetsBundleEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    WidgetsBundleEntity widgetsBundleEntity = new WidgetsBundleEntity();
    widgetsBundleEntity.setAlias("Alias");
    widgetsBundleEntity.setCreatedTime(1L);
    widgetsBundleEntity.setDescription("The characteristics of someone or something");
    widgetsBundleEntity.setExternalId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setImage("Image");
    widgetsBundleEntity.setOrder(1);
    widgetsBundleEntity.setScada(true);
    widgetsBundleEntity.setTenantId(UUID.randomUUID());
    widgetsBundleEntity.setTitle("Dr");
    widgetsBundleEntity.setUuid(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setVersion(1L);

    WidgetsBundleEntity widgetsBundleEntity2 = new WidgetsBundleEntity();
    widgetsBundleEntity2.setAlias("Alias");
    widgetsBundleEntity2.setCreatedTime(1L);
    widgetsBundleEntity2.setDescription("The characteristics of someone or something");
    widgetsBundleEntity2.setExternalId(ModelConstants.NULL_UUID);
    widgetsBundleEntity2.setId(ModelConstants.NULL_UUID);
    widgetsBundleEntity2.setImage("Image");
    widgetsBundleEntity2.setOrder(1);
    widgetsBundleEntity2.setScada(true);
    widgetsBundleEntity2.setTenantId(ModelConstants.NULL_UUID);
    widgetsBundleEntity2.setTitle("Dr");
    widgetsBundleEntity2.setUuid(ModelConstants.NULL_UUID);
    widgetsBundleEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(widgetsBundleEntity, widgetsBundleEntity2);
  }

  /**
   * Test {@link WidgetsBundleEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WidgetsBundleEntity.equals(Object)",
    "int WidgetsBundleEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    WidgetsBundleEntity widgetsBundleEntity = new WidgetsBundleEntity();
    widgetsBundleEntity.setAlias("Alias");
    widgetsBundleEntity.setCreatedTime(1L);
    widgetsBundleEntity.setDescription("The characteristics of someone or something");
    widgetsBundleEntity.setExternalId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setImage("Image");
    widgetsBundleEntity.setOrder(1);
    widgetsBundleEntity.setScada(true);
    widgetsBundleEntity.setTenantId(null);
    widgetsBundleEntity.setTitle("Dr");
    widgetsBundleEntity.setUuid(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setVersion(1L);

    WidgetsBundleEntity widgetsBundleEntity2 = new WidgetsBundleEntity();
    widgetsBundleEntity2.setAlias("Alias");
    widgetsBundleEntity2.setCreatedTime(1L);
    widgetsBundleEntity2.setDescription("The characteristics of someone or something");
    widgetsBundleEntity2.setExternalId(ModelConstants.NULL_UUID);
    widgetsBundleEntity2.setId(ModelConstants.NULL_UUID);
    widgetsBundleEntity2.setImage("Image");
    widgetsBundleEntity2.setOrder(1);
    widgetsBundleEntity2.setScada(true);
    widgetsBundleEntity2.setTenantId(ModelConstants.NULL_UUID);
    widgetsBundleEntity2.setTitle("Dr");
    widgetsBundleEntity2.setUuid(ModelConstants.NULL_UUID);
    widgetsBundleEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(widgetsBundleEntity, widgetsBundleEntity2);
  }

  /**
   * Test {@link WidgetsBundleEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WidgetsBundleEntity.equals(Object)",
    "int WidgetsBundleEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    WidgetsBundleEntity widgetsBundleEntity = new WidgetsBundleEntity();
    widgetsBundleEntity.setAlias("Alias");
    widgetsBundleEntity.setCreatedTime(1L);
    widgetsBundleEntity.setDescription("The characteristics of someone or something");
    widgetsBundleEntity.setExternalId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setImage("Image");
    widgetsBundleEntity.setOrder(1);
    widgetsBundleEntity.setScada(true);
    widgetsBundleEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setTitle("Mr");
    widgetsBundleEntity.setUuid(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setVersion(1L);

    WidgetsBundleEntity widgetsBundleEntity2 = new WidgetsBundleEntity();
    widgetsBundleEntity2.setAlias("Alias");
    widgetsBundleEntity2.setCreatedTime(1L);
    widgetsBundleEntity2.setDescription("The characteristics of someone or something");
    widgetsBundleEntity2.setExternalId(ModelConstants.NULL_UUID);
    widgetsBundleEntity2.setId(ModelConstants.NULL_UUID);
    widgetsBundleEntity2.setImage("Image");
    widgetsBundleEntity2.setOrder(1);
    widgetsBundleEntity2.setScada(true);
    widgetsBundleEntity2.setTenantId(ModelConstants.NULL_UUID);
    widgetsBundleEntity2.setTitle("Dr");
    widgetsBundleEntity2.setUuid(ModelConstants.NULL_UUID);
    widgetsBundleEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(widgetsBundleEntity, widgetsBundleEntity2);
  }

  /**
   * Test {@link WidgetsBundleEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WidgetsBundleEntity.equals(Object)",
    "int WidgetsBundleEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    WidgetsBundleEntity widgetsBundleEntity = new WidgetsBundleEntity();
    widgetsBundleEntity.setAlias("Alias");
    widgetsBundleEntity.setCreatedTime(1L);
    widgetsBundleEntity.setDescription("The characteristics of someone or something");
    widgetsBundleEntity.setExternalId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setImage("Image");
    widgetsBundleEntity.setOrder(1);
    widgetsBundleEntity.setScada(true);
    widgetsBundleEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setTitle(null);
    widgetsBundleEntity.setUuid(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setVersion(1L);

    WidgetsBundleEntity widgetsBundleEntity2 = new WidgetsBundleEntity();
    widgetsBundleEntity2.setAlias("Alias");
    widgetsBundleEntity2.setCreatedTime(1L);
    widgetsBundleEntity2.setDescription("The characteristics of someone or something");
    widgetsBundleEntity2.setExternalId(ModelConstants.NULL_UUID);
    widgetsBundleEntity2.setId(ModelConstants.NULL_UUID);
    widgetsBundleEntity2.setImage("Image");
    widgetsBundleEntity2.setOrder(1);
    widgetsBundleEntity2.setScada(true);
    widgetsBundleEntity2.setTenantId(ModelConstants.NULL_UUID);
    widgetsBundleEntity2.setTitle("Dr");
    widgetsBundleEntity2.setUuid(ModelConstants.NULL_UUID);
    widgetsBundleEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(widgetsBundleEntity, widgetsBundleEntity2);
  }

  /**
   * Test {@link WidgetsBundleEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WidgetsBundleEntity.equals(Object)",
    "int WidgetsBundleEntity.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    WidgetsBundleEntity widgetsBundleEntity = new WidgetsBundleEntity();
    widgetsBundleEntity.setAlias("Alias");
    widgetsBundleEntity.setCreatedTime(1L);
    widgetsBundleEntity.setDescription("The characteristics of someone or something");
    widgetsBundleEntity.setExternalId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setImage("Image");
    widgetsBundleEntity.setOrder(1);
    widgetsBundleEntity.setScada(true);
    widgetsBundleEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setTitle("Dr");
    widgetsBundleEntity.setUuid(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setVersion(1L);

    // Act and Assert
    assertNotEquals(widgetsBundleEntity, null);
  }

  /**
   * Test {@link WidgetsBundleEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WidgetsBundleEntity.equals(Object)",
    "int WidgetsBundleEntity.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    WidgetsBundleEntity widgetsBundleEntity = new WidgetsBundleEntity();
    widgetsBundleEntity.setAlias("Alias");
    widgetsBundleEntity.setCreatedTime(1L);
    widgetsBundleEntity.setDescription("The characteristics of someone or something");
    widgetsBundleEntity.setExternalId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setImage("Image");
    widgetsBundleEntity.setOrder(1);
    widgetsBundleEntity.setScada(true);
    widgetsBundleEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setTitle("Dr");
    widgetsBundleEntity.setUuid(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setVersion(1L);

    // Act and Assert
    assertNotEquals(widgetsBundleEntity, "Different type to WidgetsBundleEntity");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WidgetsBundleEntity#WidgetsBundleEntity()}
   *   <li>{@link WidgetsBundleEntity#setAlias(String)}
   *   <li>{@link WidgetsBundleEntity#setDescription(String)}
   *   <li>{@link WidgetsBundleEntity#setExternalId(UUID)}
   *   <li>{@link WidgetsBundleEntity#setImage(String)}
   *   <li>{@link WidgetsBundleEntity#setOrder(Integer)}
   *   <li>{@link WidgetsBundleEntity#setScada(boolean)}
   *   <li>{@link WidgetsBundleEntity#setTenantId(UUID)}
   *   <li>{@link WidgetsBundleEntity#setTitle(String)}
   *   <li>{@link WidgetsBundleEntity#toString()}
   *   <li>{@link WidgetsBundleEntity#getAlias()}
   *   <li>{@link WidgetsBundleEntity#getDescription()}
   *   <li>{@link WidgetsBundleEntity#getExternalId()}
   *   <li>{@link WidgetsBundleEntity#getImage()}
   *   <li>{@link WidgetsBundleEntity#getOrder()}
   *   <li>{@link WidgetsBundleEntity#getTenantId()}
   *   <li>{@link WidgetsBundleEntity#getTitle()}
   *   <li>{@link WidgetsBundleEntity#isScada()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WidgetsBundleEntity.<init>()",
    "String WidgetsBundleEntity.getAlias()",
    "String WidgetsBundleEntity.getDescription()",
    "UUID WidgetsBundleEntity.getExternalId()",
    "String WidgetsBundleEntity.getImage()",
    "Integer WidgetsBundleEntity.getOrder()",
    "UUID WidgetsBundleEntity.getTenantId()",
    "String WidgetsBundleEntity.getTitle()",
    "boolean WidgetsBundleEntity.isScada()",
    "void WidgetsBundleEntity.setAlias(String)",
    "void WidgetsBundleEntity.setDescription(String)",
    "void WidgetsBundleEntity.setExternalId(UUID)",
    "void WidgetsBundleEntity.setImage(String)",
    "void WidgetsBundleEntity.setOrder(Integer)",
    "void WidgetsBundleEntity.setScada(boolean)",
    "void WidgetsBundleEntity.setTenantId(UUID)",
    "void WidgetsBundleEntity.setTitle(String)",
    "String WidgetsBundleEntity.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    WidgetsBundleEntity actualWidgetsBundleEntity = new WidgetsBundleEntity();
    actualWidgetsBundleEntity.setAlias("Alias");
    actualWidgetsBundleEntity.setDescription("The characteristics of someone or something");
    actualWidgetsBundleEntity.setExternalId(ModelConstants.NULL_UUID);
    actualWidgetsBundleEntity.setImage("Image");
    actualWidgetsBundleEntity.setOrder(1);
    actualWidgetsBundleEntity.setScada(true);
    UUID tenantId = ModelConstants.NULL_UUID;
    actualWidgetsBundleEntity.setTenantId(tenantId);
    actualWidgetsBundleEntity.setTitle("Dr");
    String actualToStringResult = actualWidgetsBundleEntity.toString();
    String actualAlias = actualWidgetsBundleEntity.getAlias();
    String actualDescription = actualWidgetsBundleEntity.getDescription();
    UUID actualExternalId = actualWidgetsBundleEntity.getExternalId();
    String actualImage = actualWidgetsBundleEntity.getImage();
    Integer actualOrder = actualWidgetsBundleEntity.getOrder();
    UUID actualTenantId = actualWidgetsBundleEntity.getTenantId();
    String actualTitle = actualWidgetsBundleEntity.getTitle();
    boolean actualIsScadaResult = actualWidgetsBundleEntity.isScada();

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualExternalId.toString());
    assertEquals("Alias", actualAlias);
    assertEquals("Dr", actualTitle);
    assertEquals("Image", actualImage);
    assertEquals("The characteristics of someone or something", actualDescription);
    assertEquals(
        "WidgetsBundleEntity(tenantId=13814000-1dd2-11b2-8080-808080808080, alias=Alias, title=Dr, image=Image,"
            + " scada=true, description=The characteristics of someone or something, order=1, externalId=13814000"
            + "-1dd2-11b2-8080-808080808080)",
        actualToStringResult);
    assertNull(actualWidgetsBundleEntity.getVersion());
    assertNull(actualWidgetsBundleEntity.getId());
    assertNull(actualWidgetsBundleEntity.getUuid());
    assertEquals(0L, actualWidgetsBundleEntity.getCreatedTime());
    assertEquals(1, actualOrder.intValue());
    assertTrue(actualIsScadaResult);
    assertSame(tenantId, actualExternalId);
    assertSame(tenantId, actualTenantId);
  }

  /**
   * Test {@link WidgetsBundleEntity#WidgetsBundleEntity(WidgetsBundle)}.
   *
   * <p>Method under test: {@link WidgetsBundleEntity#WidgetsBundleEntity(WidgetsBundle)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WidgetsBundleEntity.<init>(WidgetsBundle)"})
  public void testNewWidgetsBundleEntity() {
    // Arrange
    WidgetsBundle widgetsBundle = new WidgetsBundle(new WidgetsBundleId(ModelConstants.NULL_UUID));
    widgetsBundle.setTenantId(ModelConstants.SYSTEM_TENANT);
    widgetsBundle.setExternalId(new WidgetsBundleId(ModelConstants.NULL_UUID));

    // Act
    WidgetsBundleEntity actualWidgetsBundleEntity = new WidgetsBundleEntity(widgetsBundle);

    // Assert
    UUID externalId = actualWidgetsBundleEntity.getExternalId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", externalId.toString());
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080", actualWidgetsBundleEntity.getTenantId().toString());
    assertSame(externalId, actualWidgetsBundleEntity.getId());
    assertSame(externalId, actualWidgetsBundleEntity.getUuid());
  }

  /**
   * Test {@link WidgetsBundleEntity#WidgetsBundleEntity(WidgetsBundle)}.
   *
   * <ul>
   *   <li>When {@link WidgetsBundle#WidgetsBundle()}.
   *   <li>Then return Id is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleEntity#WidgetsBundleEntity(WidgetsBundle)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WidgetsBundleEntity.<init>(WidgetsBundle)"})
  public void testNewWidgetsBundleEntity_whenWidgetsBundle_thenReturnIdIsNull() {
    // Arrange and Act
    WidgetsBundleEntity actualWidgetsBundleEntity = new WidgetsBundleEntity(new WidgetsBundle());

    // Assert
    assertNull(actualWidgetsBundleEntity.getId());
    assertNull(actualWidgetsBundleEntity.getUuid());
    assertNull(actualWidgetsBundleEntity.getExternalId());
    assertNull(actualWidgetsBundleEntity.getTenantId());
  }

  /**
   * Test {@link WidgetsBundleEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link WidgetsBundleEntity#WidgetsBundleEntity()} TenantId is {@link
   *       ModelConstants#NULL_UUID}.
   *   <li>Then return {@code Alias}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"WidgetsBundle WidgetsBundleEntity.toData()"})
  public void testToData_givenWidgetsBundleEntityTenantIdIsNull_uuid_thenReturnAlias() {
    // Arrange
    WidgetsBundleEntity widgetsBundleEntity = new WidgetsBundleEntity();
    widgetsBundleEntity.setAlias("Alias");
    widgetsBundleEntity.setCreatedTime(1L);
    widgetsBundleEntity.setDescription("The characteristics of someone or something");
    widgetsBundleEntity.setId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setImage("Image");
    widgetsBundleEntity.setOrder(1);
    widgetsBundleEntity.setScada(true);
    widgetsBundleEntity.setTitle("Dr");
    widgetsBundleEntity.setUuid(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setVersion(1L);
    widgetsBundleEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setExternalId(ModelConstants.NULL_UUID);

    // Act
    WidgetsBundle actualToDataResult = widgetsBundleEntity.toData();

    // Assert
    assertEquals("Alias", actualToDataResult.getAlias());
    assertEquals("Dr", actualToDataResult.getName());
    assertEquals("Dr", actualToDataResult.getTitle());
    assertEquals("Image", actualToDataResult.getImage());
    assertEquals(
        "The characteristics of someone or something", actualToDataResult.getDescription());
    assertEquals(1, actualToDataResult.getOrder().intValue());
    assertEquals(1L, actualToDataResult.getVersion().longValue());
    assertEquals(1L, actualToDataResult.getCreatedTime());
    assertTrue(actualToDataResult.isScada());
  }

  /**
   * Test {@link WidgetsBundleEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link WidgetsBundleEntity#WidgetsBundleEntity()} TenantId is randomUUID.
   *   <li>Then return {@code Alias}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"WidgetsBundle WidgetsBundleEntity.toData()"})
  public void testToData_givenWidgetsBundleEntityTenantIdIsRandomUUID_thenReturnAlias() {
    // Arrange
    WidgetsBundleEntity widgetsBundleEntity = new WidgetsBundleEntity();
    widgetsBundleEntity.setAlias("Alias");
    widgetsBundleEntity.setCreatedTime(1L);
    widgetsBundleEntity.setDescription("The characteristics of someone or something");
    widgetsBundleEntity.setId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setImage("Image");
    widgetsBundleEntity.setOrder(1);
    widgetsBundleEntity.setScada(true);
    widgetsBundleEntity.setTitle("Dr");
    widgetsBundleEntity.setUuid(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setVersion(1L);
    widgetsBundleEntity.setTenantId(UUID.randomUUID());
    widgetsBundleEntity.setExternalId(ModelConstants.NULL_UUID);

    // Act
    WidgetsBundle actualToDataResult = widgetsBundleEntity.toData();

    // Assert
    assertEquals("Alias", actualToDataResult.getAlias());
    assertEquals("Dr", actualToDataResult.getName());
    assertEquals("Dr", actualToDataResult.getTitle());
    assertEquals("Image", actualToDataResult.getImage());
    assertEquals(
        "The characteristics of someone or something", actualToDataResult.getDescription());
    assertEquals(1, actualToDataResult.getOrder().intValue());
    assertEquals(1L, actualToDataResult.getVersion().longValue());
    assertEquals(1L, actualToDataResult.getCreatedTime());
    assertTrue(actualToDataResult.isScada());
  }

  /**
   * Test {@link WidgetsBundleEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link WidgetsBundleEntity#WidgetsBundleEntity()}.
   *   <li>Then return Order is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"WidgetsBundle WidgetsBundleEntity.toData()"})
  public void testToData_givenWidgetsBundleEntity_thenReturnOrderIsNull() {
    // Arrange and Act
    WidgetsBundle actualToDataResult = new WidgetsBundleEntity().toData();

    // Assert
    assertNull(actualToDataResult.getOrder());
    assertNull(actualToDataResult.getVersion());
    assertNull(actualToDataResult.getAlias());
    assertNull(actualToDataResult.getDescription());
    assertNull(actualToDataResult.getImage());
    assertNull(actualToDataResult.getName());
    assertNull(actualToDataResult.getTitle());
    assertNull(actualToDataResult.getUuidId());
    assertNull(actualToDataResult.getTenantId());
    assertNull(actualToDataResult.getExternalId());
    assertEquals(0L, actualToDataResult.getCreatedTime());
    assertFalse(actualToDataResult.isScada());
  }
}
