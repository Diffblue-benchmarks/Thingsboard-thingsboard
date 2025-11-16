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

public class WidgetTypeIdFqnEntityDiffblueTest {
  /**
   * Test {@link WidgetTypeIdFqnEntity#equals(Object)}, and {@link
   * WidgetTypeIdFqnEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WidgetTypeIdFqnEntity#equals(Object)}
   *   <li>{@link WidgetTypeIdFqnEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WidgetTypeIdFqnEntity.equals(Object)",
    "int WidgetTypeIdFqnEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    WidgetTypeIdFqnEntity widgetTypeIdFqnEntity =
        new WidgetTypeIdFqnEntity(ModelConstants.NULL_UUID, "Fqn");
    WidgetTypeIdFqnEntity widgetTypeIdFqnEntity2 =
        new WidgetTypeIdFqnEntity(ModelConstants.NULL_UUID, "Fqn");

    // Act and Assert
    assertEquals(widgetTypeIdFqnEntity, widgetTypeIdFqnEntity2);
    assertEquals(widgetTypeIdFqnEntity.hashCode(), widgetTypeIdFqnEntity2.hashCode());
  }

  /**
   * Test {@link WidgetTypeIdFqnEntity#equals(Object)}, and {@link
   * WidgetTypeIdFqnEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WidgetTypeIdFqnEntity#equals(Object)}
   *   <li>{@link WidgetTypeIdFqnEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WidgetTypeIdFqnEntity.equals(Object)",
    "int WidgetTypeIdFqnEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    WidgetTypeIdFqnEntity widgetTypeIdFqnEntity = new WidgetTypeIdFqnEntity(null, "Fqn");
    WidgetTypeIdFqnEntity widgetTypeIdFqnEntity2 = new WidgetTypeIdFqnEntity(null, "Fqn");

    // Act and Assert
    assertEquals(widgetTypeIdFqnEntity, widgetTypeIdFqnEntity2);
    assertEquals(widgetTypeIdFqnEntity.hashCode(), widgetTypeIdFqnEntity2.hashCode());
  }

  /**
   * Test {@link WidgetTypeIdFqnEntity#equals(Object)}, and {@link
   * WidgetTypeIdFqnEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WidgetTypeIdFqnEntity#equals(Object)}
   *   <li>{@link WidgetTypeIdFqnEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WidgetTypeIdFqnEntity.equals(Object)",
    "int WidgetTypeIdFqnEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    WidgetTypeIdFqnEntity widgetTypeIdFqnEntity =
        new WidgetTypeIdFqnEntity(ModelConstants.NULL_UUID, null);
    WidgetTypeIdFqnEntity widgetTypeIdFqnEntity2 =
        new WidgetTypeIdFqnEntity(ModelConstants.NULL_UUID, null);

    // Act and Assert
    assertEquals(widgetTypeIdFqnEntity, widgetTypeIdFqnEntity2);
    assertEquals(widgetTypeIdFqnEntity.hashCode(), widgetTypeIdFqnEntity2.hashCode());
  }

  /**
   * Test {@link WidgetTypeIdFqnEntity#equals(Object)}, and {@link
   * WidgetTypeIdFqnEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WidgetTypeIdFqnEntity#equals(Object)}
   *   <li>{@link WidgetTypeIdFqnEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WidgetTypeIdFqnEntity.equals(Object)",
    "int WidgetTypeIdFqnEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    WidgetTypeIdFqnEntity widgetTypeIdFqnEntity =
        new WidgetTypeIdFqnEntity(ModelConstants.NULL_UUID, "Fqn");

    // Act and Assert
    assertEquals(widgetTypeIdFqnEntity, widgetTypeIdFqnEntity);
    int expectedHashCodeResult = widgetTypeIdFqnEntity.hashCode();
    assertEquals(expectedHashCodeResult, widgetTypeIdFqnEntity.hashCode());
  }

  /**
   * Test {@link WidgetTypeIdFqnEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeIdFqnEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WidgetTypeIdFqnEntity.equals(Object)",
    "int WidgetTypeIdFqnEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    WidgetTypeIdFqnEntity widgetTypeIdFqnEntity =
        new WidgetTypeIdFqnEntity(UUID.randomUUID(), "Fqn");

    // Act and Assert
    assertNotEquals(
        widgetTypeIdFqnEntity, new WidgetTypeIdFqnEntity(ModelConstants.NULL_UUID, "Fqn"));
  }

  /**
   * Test {@link WidgetTypeIdFqnEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeIdFqnEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WidgetTypeIdFqnEntity.equals(Object)",
    "int WidgetTypeIdFqnEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    WidgetTypeIdFqnEntity widgetTypeIdFqnEntity = new WidgetTypeIdFqnEntity(null, "Fqn");

    // Act and Assert
    assertNotEquals(
        widgetTypeIdFqnEntity, new WidgetTypeIdFqnEntity(ModelConstants.NULL_UUID, "Fqn"));
  }

  /**
   * Test {@link WidgetTypeIdFqnEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeIdFqnEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WidgetTypeIdFqnEntity.equals(Object)",
    "int WidgetTypeIdFqnEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    WidgetTypeIdFqnEntity widgetTypeIdFqnEntity =
        new WidgetTypeIdFqnEntity(ModelConstants.NULL_UUID, null);

    // Act and Assert
    assertNotEquals(
        widgetTypeIdFqnEntity, new WidgetTypeIdFqnEntity(ModelConstants.NULL_UUID, "Fqn"));
  }

  /**
   * Test {@link WidgetTypeIdFqnEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeIdFqnEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WidgetTypeIdFqnEntity.equals(Object)",
    "int WidgetTypeIdFqnEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    WidgetTypeIdFqnEntity widgetTypeIdFqnEntity =
        new WidgetTypeIdFqnEntity(
            ModelConstants.NULL_UUID, "org.thingsboard.server.dao.model.sql.WidgetTypeIdFqnEntity");

    // Act and Assert
    assertNotEquals(
        widgetTypeIdFqnEntity, new WidgetTypeIdFqnEntity(ModelConstants.NULL_UUID, "Fqn"));
  }

  /**
   * Test {@link WidgetTypeIdFqnEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeIdFqnEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WidgetTypeIdFqnEntity.equals(Object)",
    "int WidgetTypeIdFqnEntity.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new WidgetTypeIdFqnEntity(ModelConstants.NULL_UUID, "Fqn"), null);
  }

  /**
   * Test {@link WidgetTypeIdFqnEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeIdFqnEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WidgetTypeIdFqnEntity.equals(Object)",
    "int WidgetTypeIdFqnEntity.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new WidgetTypeIdFqnEntity(ModelConstants.NULL_UUID, "Fqn"),
        "Different type to WidgetTypeIdFqnEntity");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WidgetTypeIdFqnEntity#WidgetTypeIdFqnEntity(UUID, String)}
   *   <li>{@link WidgetTypeIdFqnEntity#setFqn(String)}
   *   <li>{@link WidgetTypeIdFqnEntity#setId(UUID)}
   *   <li>{@link WidgetTypeIdFqnEntity#toString()}
   *   <li>{@link WidgetTypeIdFqnEntity#getFqn()}
   *   <li>{@link WidgetTypeIdFqnEntity#getId()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WidgetTypeIdFqnEntity.<init>(UUID, String)",
    "String WidgetTypeIdFqnEntity.getFqn()",
    "UUID WidgetTypeIdFqnEntity.getId()",
    "void WidgetTypeIdFqnEntity.setFqn(String)",
    "void WidgetTypeIdFqnEntity.setId(UUID)",
    "String WidgetTypeIdFqnEntity.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    WidgetTypeIdFqnEntity actualWidgetTypeIdFqnEntity =
        new WidgetTypeIdFqnEntity(ModelConstants.NULL_UUID, "Fqn");
    actualWidgetTypeIdFqnEntity.setFqn("Fqn");
    UUID id = ModelConstants.NULL_UUID;
    actualWidgetTypeIdFqnEntity.setId(id);
    String actualToStringResult = actualWidgetTypeIdFqnEntity.toString();
    String actualFqn = actualWidgetTypeIdFqnEntity.getFqn();
    UUID actualId = actualWidgetTypeIdFqnEntity.getId();

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualId.toString());
    assertEquals("Fqn", actualFqn);
    assertEquals(
        "WidgetTypeIdFqnEntity(id=13814000-1dd2-11b2-8080-808080808080, fqn=Fqn)",
        actualToStringResult);
    assertSame(id, actualId);
  }
}
