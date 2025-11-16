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
package org.thingsboard.server.common.data.widget;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.WidgetTypeId;
import org.thingsboard.server.common.data.id.WidgetsBundleId;

class WidgetsBundleWidgetDiffblueTest {
  /**
   * Test {@link WidgetsBundleWidget#equals(Object)}, and {@link WidgetsBundleWidget#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WidgetsBundleWidget#equals(Object)}
   *   <li>{@link WidgetsBundleWidget#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WidgetsBundleWidget.equals(Object)",
    "int WidgetsBundleWidget.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    WidgetsBundleWidget widgetsBundleWidget = new WidgetsBundleWidget();
    WidgetsBundleWidget widgetsBundleWidget2 = new WidgetsBundleWidget();

    // Act and Assert
    assertEquals(widgetsBundleWidget, widgetsBundleWidget2);
    assertEquals(widgetsBundleWidget.hashCode(), widgetsBundleWidget2.hashCode());
  }

  /**
   * Test {@link WidgetsBundleWidget#equals(Object)}, and {@link WidgetsBundleWidget#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WidgetsBundleWidget#equals(Object)}
   *   <li>{@link WidgetsBundleWidget#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WidgetsBundleWidget.equals(Object)",
    "int WidgetsBundleWidget.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    WidgetsBundleId widgetsBundleId = new WidgetsBundleId(EntityId.NULL_UUID);
    WidgetsBundleWidget widgetsBundleWidget =
        new WidgetsBundleWidget(widgetsBundleId, new WidgetTypeId(EntityId.NULL_UUID), 1);
    WidgetsBundleId widgetsBundleId2 = new WidgetsBundleId(EntityId.NULL_UUID);
    WidgetsBundleWidget widgetsBundleWidget2 =
        new WidgetsBundleWidget(widgetsBundleId2, new WidgetTypeId(EntityId.NULL_UUID), 1);

    // Act and Assert
    assertEquals(widgetsBundleWidget, widgetsBundleWidget2);
    assertEquals(widgetsBundleWidget.hashCode(), widgetsBundleWidget2.hashCode());
  }

  /**
   * Test {@link WidgetsBundleWidget#equals(Object)}, and {@link WidgetsBundleWidget#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WidgetsBundleWidget#equals(Object)}
   *   <li>{@link WidgetsBundleWidget#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WidgetsBundleWidget.equals(Object)",
    "int WidgetsBundleWidget.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    WidgetsBundleWidget widgetsBundleWidget = new WidgetsBundleWidget();

    // Act and Assert
    assertEquals(widgetsBundleWidget, widgetsBundleWidget);
    int expectedHashCodeResult = widgetsBundleWidget.hashCode();
    assertEquals(expectedHashCodeResult, widgetsBundleWidget.hashCode());
  }

  /**
   * Test {@link WidgetsBundleWidget#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleWidget#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WidgetsBundleWidget.equals(Object)",
    "int WidgetsBundleWidget.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    WidgetsBundleId widgetsBundleId = new WidgetsBundleId(EntityId.NULL_UUID);
    WidgetsBundleWidget widgetsBundleWidget =
        new WidgetsBundleWidget(widgetsBundleId, new WidgetTypeId(EntityId.NULL_UUID), 1);

    // Act and Assert
    assertNotEquals(widgetsBundleWidget, new WidgetsBundleWidget());
  }

  /**
   * Test {@link WidgetsBundleWidget#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleWidget#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WidgetsBundleWidget.equals(Object)",
    "int WidgetsBundleWidget.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    WidgetsBundleWidget widgetsBundleWidget = new WidgetsBundleWidget();
    widgetsBundleWidget.setWidgetsBundleId(new WidgetsBundleId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(widgetsBundleWidget, new WidgetsBundleWidget());
  }

  /**
   * Test {@link WidgetsBundleWidget#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleWidget#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WidgetsBundleWidget.equals(Object)",
    "int WidgetsBundleWidget.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    WidgetsBundleWidget widgetsBundleWidget = new WidgetsBundleWidget();
    widgetsBundleWidget.setWidgetTypeId(new WidgetTypeId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(widgetsBundleWidget, new WidgetsBundleWidget());
  }

  /**
   * Test {@link WidgetsBundleWidget#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleWidget#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WidgetsBundleWidget.equals(Object)",
    "int WidgetsBundleWidget.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    WidgetsBundleWidget widgetsBundleWidget = new WidgetsBundleWidget();

    WidgetsBundleWidget widgetsBundleWidget2 = new WidgetsBundleWidget();
    widgetsBundleWidget2.setWidgetsBundleId(new WidgetsBundleId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(widgetsBundleWidget, widgetsBundleWidget2);
  }

  /**
   * Test {@link WidgetsBundleWidget#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleWidget#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WidgetsBundleWidget.equals(Object)",
    "int WidgetsBundleWidget.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    WidgetsBundleWidget widgetsBundleWidget = new WidgetsBundleWidget();

    WidgetsBundleWidget widgetsBundleWidget2 = new WidgetsBundleWidget();
    widgetsBundleWidget2.setWidgetTypeId(new WidgetTypeId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(widgetsBundleWidget, widgetsBundleWidget2);
  }

  /**
   * Test {@link WidgetsBundleWidget#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleWidget#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WidgetsBundleWidget.equals(Object)",
    "int WidgetsBundleWidget.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new WidgetsBundleWidget(), null);
  }

  /**
   * Test {@link WidgetsBundleWidget#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleWidget#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WidgetsBundleWidget.equals(Object)",
    "int WidgetsBundleWidget.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new WidgetsBundleWidget(), "Different type to WidgetsBundleWidget");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WidgetsBundleWidget#WidgetsBundleWidget()}
   *   <li>{@link WidgetsBundleWidget#setWidgetTypeId(WidgetTypeId)}
   *   <li>{@link WidgetsBundleWidget#setWidgetTypeOrder(int)}
   *   <li>{@link WidgetsBundleWidget#setWidgetsBundleId(WidgetsBundleId)}
   *   <li>{@link WidgetsBundleWidget#toString()}
   *   <li>{@link WidgetsBundleWidget#getWidgetTypeId()}
   *   <li>{@link WidgetsBundleWidget#getWidgetTypeOrder()}
   *   <li>{@link WidgetsBundleWidget#getWidgetsBundleId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WidgetsBundleWidget.<init>()",
    "void WidgetsBundleWidget.<init>(WidgetsBundleId, WidgetTypeId, int)",
    "WidgetTypeId WidgetsBundleWidget.getWidgetTypeId()",
    "int WidgetsBundleWidget.getWidgetTypeOrder()",
    "WidgetsBundleId WidgetsBundleWidget.getWidgetsBundleId()",
    "void WidgetsBundleWidget.setWidgetTypeId(WidgetTypeId)",
    "void WidgetsBundleWidget.setWidgetTypeOrder(int)",
    "void WidgetsBundleWidget.setWidgetsBundleId(WidgetsBundleId)",
    "String WidgetsBundleWidget.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    WidgetsBundleWidget actualWidgetsBundleWidget = new WidgetsBundleWidget();
    WidgetTypeId widgetTypeId = new WidgetTypeId(EntityId.NULL_UUID);
    actualWidgetsBundleWidget.setWidgetTypeId(widgetTypeId);
    actualWidgetsBundleWidget.setWidgetTypeOrder(1);
    WidgetsBundleId widgetsBundleId = new WidgetsBundleId(EntityId.NULL_UUID);
    actualWidgetsBundleWidget.setWidgetsBundleId(widgetsBundleId);
    String actualToStringResult = actualWidgetsBundleWidget.toString();
    WidgetTypeId actualWidgetTypeId = actualWidgetsBundleWidget.getWidgetTypeId();
    int actualWidgetTypeOrder = actualWidgetsBundleWidget.getWidgetTypeOrder();

    // Assert
    assertEquals(
        "WidgetsBundleWidget(widgetsBundleId=13814000-1dd2-11b2-8080-808080808080, widgetTypeId=13814000-1dd2"
            + "-11b2-8080-808080808080, widgetTypeOrder=1)",
        actualToStringResult);
    assertEquals(1, actualWidgetTypeOrder);
    assertSame(widgetTypeId, actualWidgetTypeId);
    assertSame(widgetsBundleId, actualWidgetsBundleWidget.getWidgetsBundleId());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link WidgetsBundleId#WidgetsBundleId(UUID)} with id is {@link EntityId#NULL_UUID}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WidgetsBundleWidget#WidgetsBundleWidget(WidgetsBundleId, WidgetTypeId, int)}
   *   <li>{@link WidgetsBundleWidget#setWidgetTypeId(WidgetTypeId)}
   *   <li>{@link WidgetsBundleWidget#setWidgetTypeOrder(int)}
   *   <li>{@link WidgetsBundleWidget#setWidgetsBundleId(WidgetsBundleId)}
   *   <li>{@link WidgetsBundleWidget#toString()}
   *   <li>{@link WidgetsBundleWidget#getWidgetTypeId()}
   *   <li>{@link WidgetsBundleWidget#getWidgetTypeOrder()}
   *   <li>{@link WidgetsBundleWidget#getWidgetsBundleId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when WidgetsBundleId(UUID) with id is NULL_UUID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WidgetsBundleWidget.<init>()",
    "void WidgetsBundleWidget.<init>(WidgetsBundleId, WidgetTypeId, int)",
    "WidgetTypeId WidgetsBundleWidget.getWidgetTypeId()",
    "int WidgetsBundleWidget.getWidgetTypeOrder()",
    "WidgetsBundleId WidgetsBundleWidget.getWidgetsBundleId()",
    "void WidgetsBundleWidget.setWidgetTypeId(WidgetTypeId)",
    "void WidgetsBundleWidget.setWidgetTypeOrder(int)",
    "void WidgetsBundleWidget.setWidgetsBundleId(WidgetsBundleId)",
    "String WidgetsBundleWidget.toString()"
  })
  void testGettersAndSetters_whenWidgetsBundleIdWithIdIsNull_uuid() {
    // Arrange
    WidgetsBundleId widgetsBundleId = new WidgetsBundleId(EntityId.NULL_UUID);

    // Act
    WidgetsBundleWidget actualWidgetsBundleWidget =
        new WidgetsBundleWidget(widgetsBundleId, new WidgetTypeId(EntityId.NULL_UUID), 1);
    WidgetTypeId widgetTypeId = new WidgetTypeId(EntityId.NULL_UUID);
    actualWidgetsBundleWidget.setWidgetTypeId(widgetTypeId);
    actualWidgetsBundleWidget.setWidgetTypeOrder(1);
    WidgetsBundleId widgetsBundleId2 = new WidgetsBundleId(EntityId.NULL_UUID);
    actualWidgetsBundleWidget.setWidgetsBundleId(widgetsBundleId2);
    String actualToStringResult = actualWidgetsBundleWidget.toString();
    WidgetTypeId actualWidgetTypeId = actualWidgetsBundleWidget.getWidgetTypeId();
    int actualWidgetTypeOrder = actualWidgetsBundleWidget.getWidgetTypeOrder();

    // Assert
    assertEquals(
        "WidgetsBundleWidget(widgetsBundleId=13814000-1dd2-11b2-8080-808080808080, widgetTypeId=13814000-1dd2"
            + "-11b2-8080-808080808080, widgetTypeOrder=1)",
        actualToStringResult);
    assertEquals(1, actualWidgetTypeOrder);
    assertSame(widgetTypeId, actualWidgetTypeId);
    assertSame(widgetsBundleId2, actualWidgetsBundleWidget.getWidgetsBundleId());
  }
}
