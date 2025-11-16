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
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.WidgetTypeId;
import org.thingsboard.server.common.data.id.WidgetsBundleId;
import org.thingsboard.server.common.data.widget.WidgetsBundleWidget;
import org.thingsboard.server.dao.model.ModelConstants;

public class WidgetsBundleWidgetEntityDiffblueTest {
  /**
   * Test {@link WidgetsBundleWidgetEntity#equals(Object)}, and {@link
   * WidgetsBundleWidgetEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WidgetsBundleWidgetEntity#equals(Object)}
   *   <li>{@link WidgetsBundleWidgetEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WidgetsBundleWidgetEntity.equals(Object)",
    "int WidgetsBundleWidgetEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    WidgetsBundleWidgetEntity widgetsBundleWidgetEntity = new WidgetsBundleWidgetEntity();
    widgetsBundleWidgetEntity.setWidgetTypeId(ModelConstants.NULL_UUID);
    widgetsBundleWidgetEntity.setWidgetTypeOrder(1);
    widgetsBundleWidgetEntity.setWidgetsBundleId(ModelConstants.NULL_UUID);

    WidgetsBundleWidgetEntity widgetsBundleWidgetEntity2 = new WidgetsBundleWidgetEntity();
    widgetsBundleWidgetEntity2.setWidgetTypeId(ModelConstants.NULL_UUID);
    widgetsBundleWidgetEntity2.setWidgetTypeOrder(1);
    widgetsBundleWidgetEntity2.setWidgetsBundleId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(widgetsBundleWidgetEntity, widgetsBundleWidgetEntity2);
    assertEquals(widgetsBundleWidgetEntity.hashCode(), widgetsBundleWidgetEntity2.hashCode());
  }

  /**
   * Test {@link WidgetsBundleWidgetEntity#equals(Object)}, and {@link
   * WidgetsBundleWidgetEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WidgetsBundleWidgetEntity#equals(Object)}
   *   <li>{@link WidgetsBundleWidgetEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WidgetsBundleWidgetEntity.equals(Object)",
    "int WidgetsBundleWidgetEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    WidgetsBundleWidgetEntity widgetsBundleWidgetEntity = new WidgetsBundleWidgetEntity();
    widgetsBundleWidgetEntity.setWidgetTypeId(null);
    widgetsBundleWidgetEntity.setWidgetTypeOrder(1);
    widgetsBundleWidgetEntity.setWidgetsBundleId(ModelConstants.NULL_UUID);

    WidgetsBundleWidgetEntity widgetsBundleWidgetEntity2 = new WidgetsBundleWidgetEntity();
    widgetsBundleWidgetEntity2.setWidgetTypeId(null);
    widgetsBundleWidgetEntity2.setWidgetTypeOrder(1);
    widgetsBundleWidgetEntity2.setWidgetsBundleId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(widgetsBundleWidgetEntity, widgetsBundleWidgetEntity2);
    assertEquals(widgetsBundleWidgetEntity.hashCode(), widgetsBundleWidgetEntity2.hashCode());
  }

  /**
   * Test {@link WidgetsBundleWidgetEntity#equals(Object)}, and {@link
   * WidgetsBundleWidgetEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WidgetsBundleWidgetEntity#equals(Object)}
   *   <li>{@link WidgetsBundleWidgetEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WidgetsBundleWidgetEntity.equals(Object)",
    "int WidgetsBundleWidgetEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    WidgetsBundleWidgetEntity widgetsBundleWidgetEntity = new WidgetsBundleWidgetEntity();
    widgetsBundleWidgetEntity.setWidgetTypeId(ModelConstants.NULL_UUID);
    widgetsBundleWidgetEntity.setWidgetTypeOrder(1);
    widgetsBundleWidgetEntity.setWidgetsBundleId(null);

    WidgetsBundleWidgetEntity widgetsBundleWidgetEntity2 = new WidgetsBundleWidgetEntity();
    widgetsBundleWidgetEntity2.setWidgetTypeId(ModelConstants.NULL_UUID);
    widgetsBundleWidgetEntity2.setWidgetTypeOrder(1);
    widgetsBundleWidgetEntity2.setWidgetsBundleId(null);

    // Act and Assert
    assertEquals(widgetsBundleWidgetEntity, widgetsBundleWidgetEntity2);
    assertEquals(widgetsBundleWidgetEntity.hashCode(), widgetsBundleWidgetEntity2.hashCode());
  }

  /**
   * Test {@link WidgetsBundleWidgetEntity#equals(Object)}, and {@link
   * WidgetsBundleWidgetEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WidgetsBundleWidgetEntity#equals(Object)}
   *   <li>{@link WidgetsBundleWidgetEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WidgetsBundleWidgetEntity.equals(Object)",
    "int WidgetsBundleWidgetEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    WidgetsBundleWidgetEntity widgetsBundleWidgetEntity = new WidgetsBundleWidgetEntity();
    widgetsBundleWidgetEntity.setWidgetTypeId(ModelConstants.NULL_UUID);
    widgetsBundleWidgetEntity.setWidgetTypeOrder(1);
    widgetsBundleWidgetEntity.setWidgetsBundleId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(widgetsBundleWidgetEntity, widgetsBundleWidgetEntity);
    int expectedHashCodeResult = widgetsBundleWidgetEntity.hashCode();
    assertEquals(expectedHashCodeResult, widgetsBundleWidgetEntity.hashCode());
  }

  /**
   * Test {@link WidgetsBundleWidgetEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleWidgetEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WidgetsBundleWidgetEntity.equals(Object)",
    "int WidgetsBundleWidgetEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    WidgetsBundleWidgetEntity widgetsBundleWidgetEntity = new WidgetsBundleWidgetEntity();
    widgetsBundleWidgetEntity.setWidgetTypeId(UUID.randomUUID());
    widgetsBundleWidgetEntity.setWidgetTypeOrder(1);
    widgetsBundleWidgetEntity.setWidgetsBundleId(ModelConstants.NULL_UUID);

    WidgetsBundleWidgetEntity widgetsBundleWidgetEntity2 = new WidgetsBundleWidgetEntity();
    widgetsBundleWidgetEntity2.setWidgetTypeId(ModelConstants.NULL_UUID);
    widgetsBundleWidgetEntity2.setWidgetTypeOrder(1);
    widgetsBundleWidgetEntity2.setWidgetsBundleId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(widgetsBundleWidgetEntity, widgetsBundleWidgetEntity2);
  }

  /**
   * Test {@link WidgetsBundleWidgetEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleWidgetEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WidgetsBundleWidgetEntity.equals(Object)",
    "int WidgetsBundleWidgetEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    WidgetsBundleWidgetEntity widgetsBundleWidgetEntity = new WidgetsBundleWidgetEntity();
    widgetsBundleWidgetEntity.setWidgetTypeId(null);
    widgetsBundleWidgetEntity.setWidgetTypeOrder(1);
    widgetsBundleWidgetEntity.setWidgetsBundleId(ModelConstants.NULL_UUID);

    WidgetsBundleWidgetEntity widgetsBundleWidgetEntity2 = new WidgetsBundleWidgetEntity();
    widgetsBundleWidgetEntity2.setWidgetTypeId(ModelConstants.NULL_UUID);
    widgetsBundleWidgetEntity2.setWidgetTypeOrder(1);
    widgetsBundleWidgetEntity2.setWidgetsBundleId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(widgetsBundleWidgetEntity, widgetsBundleWidgetEntity2);
  }

  /**
   * Test {@link WidgetsBundleWidgetEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleWidgetEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WidgetsBundleWidgetEntity.equals(Object)",
    "int WidgetsBundleWidgetEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    WidgetsBundleWidgetEntity widgetsBundleWidgetEntity = new WidgetsBundleWidgetEntity();
    widgetsBundleWidgetEntity.setWidgetTypeId(ModelConstants.NULL_UUID);
    widgetsBundleWidgetEntity.setWidgetTypeOrder(2);
    widgetsBundleWidgetEntity.setWidgetsBundleId(ModelConstants.NULL_UUID);

    WidgetsBundleWidgetEntity widgetsBundleWidgetEntity2 = new WidgetsBundleWidgetEntity();
    widgetsBundleWidgetEntity2.setWidgetTypeId(ModelConstants.NULL_UUID);
    widgetsBundleWidgetEntity2.setWidgetTypeOrder(1);
    widgetsBundleWidgetEntity2.setWidgetsBundleId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(widgetsBundleWidgetEntity, widgetsBundleWidgetEntity2);
  }

  /**
   * Test {@link WidgetsBundleWidgetEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleWidgetEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WidgetsBundleWidgetEntity.equals(Object)",
    "int WidgetsBundleWidgetEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    WidgetsBundleWidgetEntity widgetsBundleWidgetEntity = new WidgetsBundleWidgetEntity();
    widgetsBundleWidgetEntity.setWidgetTypeId(ModelConstants.NULL_UUID);
    widgetsBundleWidgetEntity.setWidgetTypeOrder(1);
    widgetsBundleWidgetEntity.setWidgetsBundleId(UUID.randomUUID());

    WidgetsBundleWidgetEntity widgetsBundleWidgetEntity2 = new WidgetsBundleWidgetEntity();
    widgetsBundleWidgetEntity2.setWidgetTypeId(ModelConstants.NULL_UUID);
    widgetsBundleWidgetEntity2.setWidgetTypeOrder(1);
    widgetsBundleWidgetEntity2.setWidgetsBundleId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(widgetsBundleWidgetEntity, widgetsBundleWidgetEntity2);
  }

  /**
   * Test {@link WidgetsBundleWidgetEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleWidgetEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WidgetsBundleWidgetEntity.equals(Object)",
    "int WidgetsBundleWidgetEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    WidgetsBundleWidgetEntity widgetsBundleWidgetEntity = new WidgetsBundleWidgetEntity();
    widgetsBundleWidgetEntity.setWidgetTypeId(ModelConstants.NULL_UUID);
    widgetsBundleWidgetEntity.setWidgetTypeOrder(1);
    widgetsBundleWidgetEntity.setWidgetsBundleId(null);

    WidgetsBundleWidgetEntity widgetsBundleWidgetEntity2 = new WidgetsBundleWidgetEntity();
    widgetsBundleWidgetEntity2.setWidgetTypeId(ModelConstants.NULL_UUID);
    widgetsBundleWidgetEntity2.setWidgetTypeOrder(1);
    widgetsBundleWidgetEntity2.setWidgetsBundleId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(widgetsBundleWidgetEntity, widgetsBundleWidgetEntity2);
  }

  /**
   * Test {@link WidgetsBundleWidgetEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleWidgetEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WidgetsBundleWidgetEntity.equals(Object)",
    "int WidgetsBundleWidgetEntity.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    WidgetsBundleWidgetEntity widgetsBundleWidgetEntity = new WidgetsBundleWidgetEntity();
    widgetsBundleWidgetEntity.setWidgetTypeId(ModelConstants.NULL_UUID);
    widgetsBundleWidgetEntity.setWidgetTypeOrder(1);
    widgetsBundleWidgetEntity.setWidgetsBundleId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(widgetsBundleWidgetEntity, null);
  }

  /**
   * Test {@link WidgetsBundleWidgetEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleWidgetEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WidgetsBundleWidgetEntity.equals(Object)",
    "int WidgetsBundleWidgetEntity.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    WidgetsBundleWidgetEntity widgetsBundleWidgetEntity = new WidgetsBundleWidgetEntity();
    widgetsBundleWidgetEntity.setWidgetTypeId(ModelConstants.NULL_UUID);
    widgetsBundleWidgetEntity.setWidgetTypeOrder(1);
    widgetsBundleWidgetEntity.setWidgetsBundleId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(widgetsBundleWidgetEntity, "Different type to WidgetsBundleWidgetEntity");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WidgetsBundleWidgetEntity#WidgetsBundleWidgetEntity()}
   *   <li>{@link WidgetsBundleWidgetEntity#setWidgetTypeId(UUID)}
   *   <li>{@link WidgetsBundleWidgetEntity#setWidgetTypeOrder(int)}
   *   <li>{@link WidgetsBundleWidgetEntity#setWidgetsBundleId(UUID)}
   *   <li>{@link WidgetsBundleWidgetEntity#toString()}
   *   <li>{@link WidgetsBundleWidgetEntity#getWidgetTypeId()}
   *   <li>{@link WidgetsBundleWidgetEntity#getWidgetTypeOrder()}
   *   <li>{@link WidgetsBundleWidgetEntity#getWidgetsBundleId()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WidgetsBundleWidgetEntity.<init>()",
    "void WidgetsBundleWidgetEntity.<init>(UUID, UUID, int)",
    "UUID WidgetsBundleWidgetEntity.getWidgetTypeId()",
    "int WidgetsBundleWidgetEntity.getWidgetTypeOrder()",
    "UUID WidgetsBundleWidgetEntity.getWidgetsBundleId()",
    "void WidgetsBundleWidgetEntity.setWidgetTypeId(UUID)",
    "void WidgetsBundleWidgetEntity.setWidgetTypeOrder(int)",
    "void WidgetsBundleWidgetEntity.setWidgetsBundleId(UUID)",
    "String WidgetsBundleWidgetEntity.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    WidgetsBundleWidgetEntity actualWidgetsBundleWidgetEntity = new WidgetsBundleWidgetEntity();
    actualWidgetsBundleWidgetEntity.setWidgetTypeId(ModelConstants.NULL_UUID);
    actualWidgetsBundleWidgetEntity.setWidgetTypeOrder(1);
    UUID widgetsBundleId = ModelConstants.NULL_UUID;
    actualWidgetsBundleWidgetEntity.setWidgetsBundleId(widgetsBundleId);
    String actualToStringResult = actualWidgetsBundleWidgetEntity.toString();
    UUID actualWidgetTypeId = actualWidgetsBundleWidgetEntity.getWidgetTypeId();
    int actualWidgetTypeOrder = actualWidgetsBundleWidgetEntity.getWidgetTypeOrder();

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualWidgetTypeId.toString());
    assertEquals(
        "WidgetsBundleWidgetEntity(widgetsBundleId=13814000-1dd2-11b2-8080-808080808080, widgetTypeId=13814000"
            + "-1dd2-11b2-8080-808080808080, widgetTypeOrder=1)",
        actualToStringResult);
    assertEquals(1, actualWidgetTypeOrder);
    assertSame(widgetsBundleId, actualWidgetTypeId);
    assertSame(widgetsBundleId, actualWidgetsBundleWidgetEntity.getWidgetsBundleId());
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
   *   <li>{@link WidgetsBundleWidgetEntity#WidgetsBundleWidgetEntity(UUID, UUID, int)}
   *   <li>{@link WidgetsBundleWidgetEntity#setWidgetTypeId(UUID)}
   *   <li>{@link WidgetsBundleWidgetEntity#setWidgetTypeOrder(int)}
   *   <li>{@link WidgetsBundleWidgetEntity#setWidgetsBundleId(UUID)}
   *   <li>{@link WidgetsBundleWidgetEntity#toString()}
   *   <li>{@link WidgetsBundleWidgetEntity#getWidgetTypeId()}
   *   <li>{@link WidgetsBundleWidgetEntity#getWidgetTypeOrder()}
   *   <li>{@link WidgetsBundleWidgetEntity#getWidgetsBundleId()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WidgetsBundleWidgetEntity.<init>()",
    "void WidgetsBundleWidgetEntity.<init>(UUID, UUID, int)",
    "UUID WidgetsBundleWidgetEntity.getWidgetTypeId()",
    "int WidgetsBundleWidgetEntity.getWidgetTypeOrder()",
    "UUID WidgetsBundleWidgetEntity.getWidgetsBundleId()",
    "void WidgetsBundleWidgetEntity.setWidgetTypeId(UUID)",
    "void WidgetsBundleWidgetEntity.setWidgetTypeOrder(int)",
    "void WidgetsBundleWidgetEntity.setWidgetsBundleId(UUID)",
    "String WidgetsBundleWidgetEntity.toString()"
  })
  public void testGettersAndSetters_whenNull_uuid() {
    // Arrange and Act
    WidgetsBundleWidgetEntity actualWidgetsBundleWidgetEntity =
        new WidgetsBundleWidgetEntity(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, 1);
    actualWidgetsBundleWidgetEntity.setWidgetTypeId(ModelConstants.NULL_UUID);
    actualWidgetsBundleWidgetEntity.setWidgetTypeOrder(1);
    UUID widgetsBundleId = ModelConstants.NULL_UUID;
    actualWidgetsBundleWidgetEntity.setWidgetsBundleId(widgetsBundleId);
    String actualToStringResult = actualWidgetsBundleWidgetEntity.toString();
    UUID actualWidgetTypeId = actualWidgetsBundleWidgetEntity.getWidgetTypeId();
    int actualWidgetTypeOrder = actualWidgetsBundleWidgetEntity.getWidgetTypeOrder();

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualWidgetTypeId.toString());
    assertEquals(
        "WidgetsBundleWidgetEntity(widgetsBundleId=13814000-1dd2-11b2-8080-808080808080, widgetTypeId=13814000"
            + "-1dd2-11b2-8080-808080808080, widgetTypeOrder=1)",
        actualToStringResult);
    assertEquals(1, actualWidgetTypeOrder);
    assertSame(widgetsBundleId, actualWidgetTypeId);
    assertSame(widgetsBundleId, actualWidgetsBundleWidgetEntity.getWidgetsBundleId());
  }

  /**
   * Test {@link WidgetsBundleWidgetEntity#WidgetsBundleWidgetEntity(WidgetsBundleWidget)}.
   *
   * <p>Method under test: {@link
   * WidgetsBundleWidgetEntity#WidgetsBundleWidgetEntity(WidgetsBundleWidget)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WidgetsBundleWidgetEntity.<init>(WidgetsBundleWidget)"})
  public void testNewWidgetsBundleWidgetEntity() {
    // Arrange
    WidgetsBundleId widgetsBundleId = new WidgetsBundleId(ModelConstants.NULL_UUID);

    WidgetsBundleWidget widgetsBundleWidget =
        new WidgetsBundleWidget(widgetsBundleId, new WidgetTypeId(ModelConstants.NULL_UUID), 1);
    UUID id = UUID.randomUUID();
    widgetsBundleWidget.setWidgetsBundleId(new WidgetsBundleId(id));

    // Act
    WidgetsBundleWidgetEntity actualWidgetsBundleWidgetEntity =
        new WidgetsBundleWidgetEntity(widgetsBundleWidget);

    // Assert
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080",
        actualWidgetsBundleWidgetEntity.getWidgetTypeId().toString());
    assertEquals(1, actualWidgetsBundleWidgetEntity.getWidgetTypeOrder());
    assertSame(id, actualWidgetsBundleWidgetEntity.getWidgetsBundleId());
  }

  /**
   * Test {@link WidgetsBundleWidgetEntity#toData()}.
   *
   * <p>Method under test: {@link WidgetsBundleWidgetEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"WidgetsBundleWidget WidgetsBundleWidgetEntity.toData()"})
  public void testToData() {
    // Arrange and Act
    WidgetsBundleWidget actualToDataResult = new WidgetsBundleWidgetEntity().toData();

    // Assert
    WidgetTypeId widgetTypeId = actualToDataResult.getWidgetTypeId();
    assertNull(widgetTypeId.getId());
    WidgetsBundleId widgetsBundleId = actualToDataResult.getWidgetsBundleId();
    assertNull(widgetsBundleId.getId());
    assertEquals(0, actualToDataResult.getWidgetTypeOrder());
    assertEquals(EntityType.WIDGETS_BUNDLE, widgetsBundleId.getEntityType());
    assertEquals(EntityType.WIDGET_TYPE, widgetTypeId.getEntityType());
    assertFalse(widgetTypeId.isNullUid());
    assertFalse(widgetsBundleId.isNullUid());
  }
}
