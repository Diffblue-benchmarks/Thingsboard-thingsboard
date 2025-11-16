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
import org.thingsboard.server.dao.model.ModelConstants;

public class WidgetsBundleWidgetCompositeKeyDiffblueTest {
  /**
   * Test {@link WidgetsBundleWidgetCompositeKey#equals(Object)}, and {@link
   * WidgetsBundleWidgetCompositeKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WidgetsBundleWidgetCompositeKey#equals(Object)}
   *   <li>{@link WidgetsBundleWidgetCompositeKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WidgetsBundleWidgetCompositeKey.equals(Object)",
    "int WidgetsBundleWidgetCompositeKey.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    WidgetsBundleWidgetCompositeKey widgetsBundleWidgetCompositeKey =
        new WidgetsBundleWidgetCompositeKey();
    WidgetsBundleWidgetCompositeKey widgetsBundleWidgetCompositeKey2 =
        new WidgetsBundleWidgetCompositeKey();

    // Act and Assert
    assertEquals(widgetsBundleWidgetCompositeKey, widgetsBundleWidgetCompositeKey2);
    assertEquals(
        widgetsBundleWidgetCompositeKey.hashCode(), widgetsBundleWidgetCompositeKey2.hashCode());
  }

  /**
   * Test {@link WidgetsBundleWidgetCompositeKey#equals(Object)}, and {@link
   * WidgetsBundleWidgetCompositeKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WidgetsBundleWidgetCompositeKey#equals(Object)}
   *   <li>{@link WidgetsBundleWidgetCompositeKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WidgetsBundleWidgetCompositeKey.equals(Object)",
    "int WidgetsBundleWidgetCompositeKey.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    WidgetsBundleWidgetCompositeKey widgetsBundleWidgetCompositeKey =
        new WidgetsBundleWidgetCompositeKey(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);
    WidgetsBundleWidgetCompositeKey widgetsBundleWidgetCompositeKey2 =
        new WidgetsBundleWidgetCompositeKey(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(widgetsBundleWidgetCompositeKey, widgetsBundleWidgetCompositeKey2);
    assertEquals(
        widgetsBundleWidgetCompositeKey.hashCode(), widgetsBundleWidgetCompositeKey2.hashCode());
  }

  /**
   * Test {@link WidgetsBundleWidgetCompositeKey#equals(Object)}, and {@link
   * WidgetsBundleWidgetCompositeKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WidgetsBundleWidgetCompositeKey#equals(Object)}
   *   <li>{@link WidgetsBundleWidgetCompositeKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WidgetsBundleWidgetCompositeKey.equals(Object)",
    "int WidgetsBundleWidgetCompositeKey.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    WidgetsBundleWidgetCompositeKey widgetsBundleWidgetCompositeKey =
        new WidgetsBundleWidgetCompositeKey();

    // Act and Assert
    assertEquals(widgetsBundleWidgetCompositeKey, widgetsBundleWidgetCompositeKey);
    int expectedHashCodeResult = widgetsBundleWidgetCompositeKey.hashCode();
    assertEquals(expectedHashCodeResult, widgetsBundleWidgetCompositeKey.hashCode());
  }

  /**
   * Test {@link WidgetsBundleWidgetCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleWidgetCompositeKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WidgetsBundleWidgetCompositeKey.equals(Object)",
    "int WidgetsBundleWidgetCompositeKey.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    WidgetsBundleWidgetCompositeKey widgetsBundleWidgetCompositeKey =
        new WidgetsBundleWidgetCompositeKey(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(widgetsBundleWidgetCompositeKey, new WidgetsBundleWidgetCompositeKey());
  }

  /**
   * Test {@link WidgetsBundleWidgetCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleWidgetCompositeKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WidgetsBundleWidgetCompositeKey.equals(Object)",
    "int WidgetsBundleWidgetCompositeKey.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    WidgetsBundleWidgetCompositeKey widgetsBundleWidgetCompositeKey =
        new WidgetsBundleWidgetCompositeKey();

    // Act and Assert
    assertNotEquals(
        widgetsBundleWidgetCompositeKey,
        new WidgetsBundleWidgetCompositeKey(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID));
  }

  /**
   * Test {@link WidgetsBundleWidgetCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleWidgetCompositeKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WidgetsBundleWidgetCompositeKey.equals(Object)",
    "int WidgetsBundleWidgetCompositeKey.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    WidgetsBundleWidgetCompositeKey widgetsBundleWidgetCompositeKey =
        new WidgetsBundleWidgetCompositeKey();
    widgetsBundleWidgetCompositeKey.setWidgetTypeId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(widgetsBundleWidgetCompositeKey, new WidgetsBundleWidgetCompositeKey());
  }

  /**
   * Test {@link WidgetsBundleWidgetCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleWidgetCompositeKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WidgetsBundleWidgetCompositeKey.equals(Object)",
    "int WidgetsBundleWidgetCompositeKey.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    WidgetsBundleWidgetCompositeKey widgetsBundleWidgetCompositeKey =
        new WidgetsBundleWidgetCompositeKey();

    WidgetsBundleWidgetCompositeKey widgetsBundleWidgetCompositeKey2 =
        new WidgetsBundleWidgetCompositeKey();
    widgetsBundleWidgetCompositeKey2.setWidgetTypeId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(widgetsBundleWidgetCompositeKey, widgetsBundleWidgetCompositeKey2);
  }

  /**
   * Test {@link WidgetsBundleWidgetCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleWidgetCompositeKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WidgetsBundleWidgetCompositeKey.equals(Object)",
    "int WidgetsBundleWidgetCompositeKey.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new WidgetsBundleWidgetCompositeKey(), null);
  }

  /**
   * Test {@link WidgetsBundleWidgetCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleWidgetCompositeKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WidgetsBundleWidgetCompositeKey.equals(Object)",
    "int WidgetsBundleWidgetCompositeKey.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new WidgetsBundleWidgetCompositeKey(), "Different type to WidgetsBundleWidgetCompositeKey");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WidgetsBundleWidgetCompositeKey#WidgetsBundleWidgetCompositeKey()}
   *   <li>{@link WidgetsBundleWidgetCompositeKey#setWidgetTypeId(UUID)}
   *   <li>{@link WidgetsBundleWidgetCompositeKey#setWidgetsBundleId(UUID)}
   *   <li>{@link WidgetsBundleWidgetCompositeKey#toString()}
   *   <li>{@link WidgetsBundleWidgetCompositeKey#getWidgetTypeId()}
   *   <li>{@link WidgetsBundleWidgetCompositeKey#getWidgetsBundleId()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WidgetsBundleWidgetCompositeKey.<init>()",
    "void WidgetsBundleWidgetCompositeKey.<init>(UUID, UUID)",
    "UUID WidgetsBundleWidgetCompositeKey.getWidgetTypeId()",
    "UUID WidgetsBundleWidgetCompositeKey.getWidgetsBundleId()",
    "void WidgetsBundleWidgetCompositeKey.setWidgetTypeId(UUID)",
    "void WidgetsBundleWidgetCompositeKey.setWidgetsBundleId(UUID)",
    "String WidgetsBundleWidgetCompositeKey.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    WidgetsBundleWidgetCompositeKey actualWidgetsBundleWidgetCompositeKey =
        new WidgetsBundleWidgetCompositeKey();
    actualWidgetsBundleWidgetCompositeKey.setWidgetTypeId(ModelConstants.NULL_UUID);
    UUID widgetsBundleId = ModelConstants.NULL_UUID;
    actualWidgetsBundleWidgetCompositeKey.setWidgetsBundleId(widgetsBundleId);
    String actualToStringResult = actualWidgetsBundleWidgetCompositeKey.toString();
    UUID actualWidgetTypeId = actualWidgetsBundleWidgetCompositeKey.getWidgetTypeId();

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualWidgetTypeId.toString());
    assertEquals(
        "WidgetsBundleWidgetCompositeKey(widgetsBundleId=13814000-1dd2-11b2-8080-808080808080, widgetTypeId"
            + "=13814000-1dd2-11b2-8080-808080808080)",
        actualToStringResult);
    assertSame(widgetsBundleId, actualWidgetTypeId);
    assertSame(widgetsBundleId, actualWidgetsBundleWidgetCompositeKey.getWidgetsBundleId());
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
   *   <li>{@link WidgetsBundleWidgetCompositeKey#WidgetsBundleWidgetCompositeKey(UUID, UUID)}
   *   <li>{@link WidgetsBundleWidgetCompositeKey#setWidgetTypeId(UUID)}
   *   <li>{@link WidgetsBundleWidgetCompositeKey#setWidgetsBundleId(UUID)}
   *   <li>{@link WidgetsBundleWidgetCompositeKey#toString()}
   *   <li>{@link WidgetsBundleWidgetCompositeKey#getWidgetTypeId()}
   *   <li>{@link WidgetsBundleWidgetCompositeKey#getWidgetsBundleId()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WidgetsBundleWidgetCompositeKey.<init>()",
    "void WidgetsBundleWidgetCompositeKey.<init>(UUID, UUID)",
    "UUID WidgetsBundleWidgetCompositeKey.getWidgetTypeId()",
    "UUID WidgetsBundleWidgetCompositeKey.getWidgetsBundleId()",
    "void WidgetsBundleWidgetCompositeKey.setWidgetTypeId(UUID)",
    "void WidgetsBundleWidgetCompositeKey.setWidgetsBundleId(UUID)",
    "String WidgetsBundleWidgetCompositeKey.toString()"
  })
  public void testGettersAndSetters_whenNull_uuid() {
    // Arrange and Act
    WidgetsBundleWidgetCompositeKey actualWidgetsBundleWidgetCompositeKey =
        new WidgetsBundleWidgetCompositeKey(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);
    actualWidgetsBundleWidgetCompositeKey.setWidgetTypeId(ModelConstants.NULL_UUID);
    UUID widgetsBundleId = ModelConstants.NULL_UUID;
    actualWidgetsBundleWidgetCompositeKey.setWidgetsBundleId(widgetsBundleId);
    String actualToStringResult = actualWidgetsBundleWidgetCompositeKey.toString();
    UUID actualWidgetTypeId = actualWidgetsBundleWidgetCompositeKey.getWidgetTypeId();

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualWidgetTypeId.toString());
    assertEquals(
        "WidgetsBundleWidgetCompositeKey(widgetsBundleId=13814000-1dd2-11b2-8080-808080808080, widgetTypeId"
            + "=13814000-1dd2-11b2-8080-808080808080)",
        actualToStringResult);
    assertSame(widgetsBundleId, actualWidgetTypeId);
    assertSame(widgetsBundleId, actualWidgetsBundleWidgetCompositeKey.getWidgetsBundleId());
  }
}
