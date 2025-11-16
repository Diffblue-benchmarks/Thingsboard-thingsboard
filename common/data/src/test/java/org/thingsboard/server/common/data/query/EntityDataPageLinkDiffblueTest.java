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
package org.thingsboard.server.common.data.query;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class EntityDataPageLinkDiffblueTest {
  /**
   * Test {@link EntityDataPageLink#equals(Object)}, and {@link EntityDataPageLink#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityDataPageLink#equals(Object)}
   *   <li>{@link EntityDataPageLink#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityDataPageLink.equals(Object)",
    "int EntityDataPageLink.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityDataPageLink entityDataPageLink = new EntityDataPageLink();
    EntityDataPageLink entityDataPageLink2 = new EntityDataPageLink();

    // Act and Assert
    assertEquals(entityDataPageLink, entityDataPageLink2);
    assertEquals(entityDataPageLink.hashCode(), entityDataPageLink2.hashCode());
  }

  /**
   * Test {@link EntityDataPageLink#equals(Object)}, and {@link EntityDataPageLink#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityDataPageLink#equals(Object)}
   *   <li>{@link EntityDataPageLink#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityDataPageLink.equals(Object)",
    "int EntityDataPageLink.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EntityDataPageLink entityDataPageLink =
        new EntityDataPageLink(3, 1, "Text Search", new EntityDataSortOrder(), true);

    AlarmDataPageLink alarmDataPageLink = mock(AlarmDataPageLink.class);
    when(alarmDataPageLink.isDynamic()).thenReturn(true);
    when(alarmDataPageLink.getPage()).thenReturn(1);
    when(alarmDataPageLink.getPageSize()).thenReturn(3);
    when(alarmDataPageLink.getTextSearch()).thenReturn("Text Search");
    when(alarmDataPageLink.getSortOrder()).thenReturn(new EntityDataSortOrder());
    when(alarmDataPageLink.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertEquals(entityDataPageLink, alarmDataPageLink);
    assertNotEquals(entityDataPageLink.hashCode(), alarmDataPageLink.hashCode());
  }

  /**
   * Test {@link EntityDataPageLink#equals(Object)}, and {@link EntityDataPageLink#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityDataPageLink#equals(Object)}
   *   <li>{@link EntityDataPageLink#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityDataPageLink.equals(Object)",
    "int EntityDataPageLink.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityDataPageLink entityDataPageLink = new EntityDataPageLink();

    // Act and Assert
    assertEquals(entityDataPageLink, entityDataPageLink);
    int expectedHashCodeResult = entityDataPageLink.hashCode();
    assertEquals(expectedHashCodeResult, entityDataPageLink.hashCode());
  }

  /**
   * Test {@link EntityDataPageLink#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityDataPageLink#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityDataPageLink.equals(Object)",
    "int EntityDataPageLink.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AlarmDataPageLink alarmDataPageLink = new AlarmDataPageLink();

    // Act and Assert
    assertNotEquals(alarmDataPageLink, new EntityDataPageLink());
  }

  /**
   * Test {@link EntityDataPageLink#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityDataPageLink#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityDataPageLink.equals(Object)",
    "int EntityDataPageLink.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityDataPageLink entityDataPageLink =
        new EntityDataPageLink(3, 1, "Text Search", new EntityDataSortOrder());

    // Act and Assert
    assertNotEquals(entityDataPageLink, new EntityDataPageLink());
  }

  /**
   * Test {@link EntityDataPageLink#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityDataPageLink#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityDataPageLink.equals(Object)",
    "int EntityDataPageLink.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntityDataPageLink entityDataPageLink = new EntityDataPageLink();

    // Act and Assert
    assertNotEquals(entityDataPageLink, new AlarmDataPageLink());
  }

  /**
   * Test {@link EntityDataPageLink#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityDataPageLink#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityDataPageLink.equals(Object)",
    "int EntityDataPageLink.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EntityDataPageLink entityDataPageLink = new EntityDataPageLink();

    AlarmDataPageLink alarmDataPageLink = mock(AlarmDataPageLink.class);
    when(alarmDataPageLink.isDynamic()).thenReturn(true);
    when(alarmDataPageLink.getPage()).thenReturn(1);
    when(alarmDataPageLink.getPageSize()).thenReturn(3);
    when(alarmDataPageLink.getTextSearch()).thenReturn("Text Search");
    when(alarmDataPageLink.getSortOrder()).thenReturn(new EntityDataSortOrder());
    when(alarmDataPageLink.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(entityDataPageLink, alarmDataPageLink);
  }

  /**
   * Test {@link EntityDataPageLink#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityDataPageLink#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityDataPageLink.equals(Object)",
    "int EntityDataPageLink.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    EntityDataPageLink entityDataPageLink =
        new EntityDataPageLink(3, 1, "Text Search", new EntityDataSortOrder());

    AlarmDataPageLink alarmDataPageLink = mock(AlarmDataPageLink.class);
    when(alarmDataPageLink.isDynamic()).thenReturn(true);
    when(alarmDataPageLink.getPage()).thenReturn(1);
    when(alarmDataPageLink.getPageSize()).thenReturn(3);
    when(alarmDataPageLink.getTextSearch()).thenReturn("Text Search");
    when(alarmDataPageLink.getSortOrder()).thenReturn(new EntityDataSortOrder());
    when(alarmDataPageLink.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(entityDataPageLink, alarmDataPageLink);
  }

  /**
   * Test {@link EntityDataPageLink#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityDataPageLink#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityDataPageLink.equals(Object)",
    "int EntityDataPageLink.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    EntityDataPageLink entityDataPageLink = new EntityDataPageLink();
    entityDataPageLink.setPageSize(3);

    AlarmDataPageLink alarmDataPageLink = mock(AlarmDataPageLink.class);
    when(alarmDataPageLink.isDynamic()).thenReturn(true);
    when(alarmDataPageLink.getPage()).thenReturn(1);
    when(alarmDataPageLink.getPageSize()).thenReturn(3);
    when(alarmDataPageLink.getTextSearch()).thenReturn("Text Search");
    when(alarmDataPageLink.getSortOrder()).thenReturn(new EntityDataSortOrder());
    when(alarmDataPageLink.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(entityDataPageLink, alarmDataPageLink);
  }

  /**
   * Test {@link EntityDataPageLink#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityDataPageLink#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityDataPageLink.equals(Object)",
    "int EntityDataPageLink.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    EntityDataPageLink entityDataPageLink =
        new EntityDataPageLink(3, 1, null, new EntityDataSortOrder(), true);

    AlarmDataPageLink alarmDataPageLink = mock(AlarmDataPageLink.class);
    when(alarmDataPageLink.isDynamic()).thenReturn(true);
    when(alarmDataPageLink.getPage()).thenReturn(1);
    when(alarmDataPageLink.getPageSize()).thenReturn(3);
    when(alarmDataPageLink.getTextSearch()).thenReturn("Text Search");
    when(alarmDataPageLink.getSortOrder()).thenReturn(new EntityDataSortOrder());
    when(alarmDataPageLink.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(entityDataPageLink, alarmDataPageLink);
  }

  /**
   * Test {@link EntityDataPageLink#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityDataPageLink#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityDataPageLink.equals(Object)",
    "int EntityDataPageLink.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    EntityDataPageLink entityDataPageLink =
        new EntityDataPageLink(
            3,
            1,
            "org.thingsboard.server.common.data.query.EntityDataPageLink",
            new EntityDataSortOrder(),
            true);

    AlarmDataPageLink alarmDataPageLink = mock(AlarmDataPageLink.class);
    when(alarmDataPageLink.isDynamic()).thenReturn(true);
    when(alarmDataPageLink.getPage()).thenReturn(1);
    when(alarmDataPageLink.getPageSize()).thenReturn(3);
    when(alarmDataPageLink.getTextSearch()).thenReturn("Text Search");
    when(alarmDataPageLink.getSortOrder()).thenReturn(new EntityDataSortOrder());
    when(alarmDataPageLink.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(entityDataPageLink, alarmDataPageLink);
  }

  /**
   * Test {@link EntityDataPageLink#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityDataPageLink#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityDataPageLink.equals(Object)",
    "int EntityDataPageLink.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    EntityDataPageLink entityDataPageLink = new EntityDataPageLink(3, 1, "Text Search", null, true);

    AlarmDataPageLink alarmDataPageLink = mock(AlarmDataPageLink.class);
    when(alarmDataPageLink.isDynamic()).thenReturn(true);
    when(alarmDataPageLink.getPage()).thenReturn(1);
    when(alarmDataPageLink.getPageSize()).thenReturn(3);
    when(alarmDataPageLink.getTextSearch()).thenReturn("Text Search");
    when(alarmDataPageLink.getSortOrder()).thenReturn(new EntityDataSortOrder());
    when(alarmDataPageLink.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(entityDataPageLink, alarmDataPageLink);
  }

  /**
   * Test {@link EntityDataPageLink#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityDataPageLink#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityDataPageLink.equals(Object)",
    "int EntityDataPageLink.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    EntityDataPageLink entityDataPageLink =
        new EntityDataPageLink(
            3,
            1,
            "Text Search",
            new EntityDataSortOrder(new EntityKey(EntityKeyType.ATTRIBUTE, "Key")),
            true);

    AlarmDataPageLink alarmDataPageLink = mock(AlarmDataPageLink.class);
    when(alarmDataPageLink.isDynamic()).thenReturn(true);
    when(alarmDataPageLink.getPage()).thenReturn(1);
    when(alarmDataPageLink.getPageSize()).thenReturn(3);
    when(alarmDataPageLink.getTextSearch()).thenReturn("Text Search");
    when(alarmDataPageLink.getSortOrder()).thenReturn(new EntityDataSortOrder());
    when(alarmDataPageLink.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(entityDataPageLink, alarmDataPageLink);
  }

  /**
   * Test {@link EntityDataPageLink#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityDataPageLink#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityDataPageLink.equals(Object)",
    "int EntityDataPageLink.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityDataPageLink(), null);
  }

  /**
   * Test {@link EntityDataPageLink#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityDataPageLink#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityDataPageLink.equals(Object)",
    "int EntityDataPageLink.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityDataPageLink(), "Different type to EntityDataPageLink");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityDataPageLink#EntityDataPageLink()}
   *   <li>{@link EntityDataPageLink#setDynamic(boolean)}
   *   <li>{@link EntityDataPageLink#setPage(int)}
   *   <li>{@link EntityDataPageLink#setPageSize(int)}
   *   <li>{@link EntityDataPageLink#setSortOrder(EntityDataSortOrder)}
   *   <li>{@link EntityDataPageLink#setTextSearch(String)}
   *   <li>{@link EntityDataPageLink#toString()}
   *   <li>{@link EntityDataPageLink#getPage()}
   *   <li>{@link EntityDataPageLink#getPageSize()}
   *   <li>{@link EntityDataPageLink#getSortOrder()}
   *   <li>{@link EntityDataPageLink#getTextSearch()}
   *   <li>{@link EntityDataPageLink#isDynamic()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityDataPageLink.<init>()",
    "void EntityDataPageLink.<init>(int, int, String, EntityDataSortOrder)",
    "void EntityDataPageLink.<init>(int, int, String, EntityDataSortOrder, boolean)",
    "int EntityDataPageLink.getPage()",
    "int EntityDataPageLink.getPageSize()",
    "EntityDataSortOrder EntityDataPageLink.getSortOrder()",
    "String EntityDataPageLink.getTextSearch()",
    "boolean EntityDataPageLink.isDynamic()",
    "void EntityDataPageLink.setDynamic(boolean)",
    "void EntityDataPageLink.setPage(int)",
    "void EntityDataPageLink.setPageSize(int)",
    "void EntityDataPageLink.setSortOrder(EntityDataSortOrder)",
    "void EntityDataPageLink.setTextSearch(String)",
    "String EntityDataPageLink.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    EntityDataPageLink actualEntityDataPageLink = new EntityDataPageLink();
    actualEntityDataPageLink.setDynamic(true);
    actualEntityDataPageLink.setPage(1);
    actualEntityDataPageLink.setPageSize(3);
    EntityDataSortOrder sortOrder = new EntityDataSortOrder();
    actualEntityDataPageLink.setSortOrder(sortOrder);
    actualEntityDataPageLink.setTextSearch("Text Search");
    String actualToStringResult = actualEntityDataPageLink.toString();
    int actualPage = actualEntityDataPageLink.getPage();
    int actualPageSize = actualEntityDataPageLink.getPageSize();
    EntityDataSortOrder actualSortOrder = actualEntityDataPageLink.getSortOrder();
    String actualTextSearch = actualEntityDataPageLink.getTextSearch();

    // Assert
    assertEquals(
        "EntityDataPageLink(pageSize=3, page=1, textSearch=Text Search, sortOrder=EntityDataSortOrder(key=null,"
            + " direction=null), dynamic=true)",
        actualToStringResult);
    assertEquals("Text Search", actualTextSearch);
    assertEquals(1, actualPage);
    assertEquals(3, actualPageSize);
    assertTrue(actualEntityDataPageLink.isDynamic());
    assertSame(sortOrder, actualSortOrder);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When three.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityDataPageLink#EntityDataPageLink(int, int, String, EntityDataSortOrder)}
   *   <li>{@link EntityDataPageLink#setDynamic(boolean)}
   *   <li>{@link EntityDataPageLink#setPage(int)}
   *   <li>{@link EntityDataPageLink#setPageSize(int)}
   *   <li>{@link EntityDataPageLink#setSortOrder(EntityDataSortOrder)}
   *   <li>{@link EntityDataPageLink#setTextSearch(String)}
   *   <li>{@link EntityDataPageLink#toString()}
   *   <li>{@link EntityDataPageLink#getPage()}
   *   <li>{@link EntityDataPageLink#getPageSize()}
   *   <li>{@link EntityDataPageLink#getSortOrder()}
   *   <li>{@link EntityDataPageLink#getTextSearch()}
   *   <li>{@link EntityDataPageLink#isDynamic()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityDataPageLink.<init>()",
    "void EntityDataPageLink.<init>(int, int, String, EntityDataSortOrder)",
    "void EntityDataPageLink.<init>(int, int, String, EntityDataSortOrder, boolean)",
    "int EntityDataPageLink.getPage()",
    "int EntityDataPageLink.getPageSize()",
    "EntityDataSortOrder EntityDataPageLink.getSortOrder()",
    "String EntityDataPageLink.getTextSearch()",
    "boolean EntityDataPageLink.isDynamic()",
    "void EntityDataPageLink.setDynamic(boolean)",
    "void EntityDataPageLink.setPage(int)",
    "void EntityDataPageLink.setPageSize(int)",
    "void EntityDataPageLink.setSortOrder(EntityDataSortOrder)",
    "void EntityDataPageLink.setTextSearch(String)",
    "String EntityDataPageLink.toString()"
  })
  void testGettersAndSetters_whenThree() {
    // Arrange and Act
    EntityDataPageLink actualEntityDataPageLink =
        new EntityDataPageLink(3, 1, "Text Search", new EntityDataSortOrder());
    actualEntityDataPageLink.setDynamic(true);
    actualEntityDataPageLink.setPage(1);
    actualEntityDataPageLink.setPageSize(3);
    EntityDataSortOrder sortOrder = new EntityDataSortOrder();
    actualEntityDataPageLink.setSortOrder(sortOrder);
    actualEntityDataPageLink.setTextSearch("Text Search");
    String actualToStringResult = actualEntityDataPageLink.toString();
    int actualPage = actualEntityDataPageLink.getPage();
    int actualPageSize = actualEntityDataPageLink.getPageSize();
    EntityDataSortOrder actualSortOrder = actualEntityDataPageLink.getSortOrder();
    String actualTextSearch = actualEntityDataPageLink.getTextSearch();

    // Assert
    assertEquals(
        "EntityDataPageLink(pageSize=3, page=1, textSearch=Text Search, sortOrder=EntityDataSortOrder(key=null,"
            + " direction=null), dynamic=true)",
        actualToStringResult);
    assertEquals("Text Search", actualTextSearch);
    assertEquals(1, actualPage);
    assertEquals(3, actualPageSize);
    assertTrue(actualEntityDataPageLink.isDynamic());
    assertSame(sortOrder, actualSortOrder);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code true}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityDataPageLink#EntityDataPageLink(int, int, String, EntityDataSortOrder,
   *       boolean)}
   *   <li>{@link EntityDataPageLink#setDynamic(boolean)}
   *   <li>{@link EntityDataPageLink#setPage(int)}
   *   <li>{@link EntityDataPageLink#setPageSize(int)}
   *   <li>{@link EntityDataPageLink#setSortOrder(EntityDataSortOrder)}
   *   <li>{@link EntityDataPageLink#setTextSearch(String)}
   *   <li>{@link EntityDataPageLink#toString()}
   *   <li>{@link EntityDataPageLink#getPage()}
   *   <li>{@link EntityDataPageLink#getPageSize()}
   *   <li>{@link EntityDataPageLink#getSortOrder()}
   *   <li>{@link EntityDataPageLink#getTextSearch()}
   *   <li>{@link EntityDataPageLink#isDynamic()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityDataPageLink.<init>()",
    "void EntityDataPageLink.<init>(int, int, String, EntityDataSortOrder)",
    "void EntityDataPageLink.<init>(int, int, String, EntityDataSortOrder, boolean)",
    "int EntityDataPageLink.getPage()",
    "int EntityDataPageLink.getPageSize()",
    "EntityDataSortOrder EntityDataPageLink.getSortOrder()",
    "String EntityDataPageLink.getTextSearch()",
    "boolean EntityDataPageLink.isDynamic()",
    "void EntityDataPageLink.setDynamic(boolean)",
    "void EntityDataPageLink.setPage(int)",
    "void EntityDataPageLink.setPageSize(int)",
    "void EntityDataPageLink.setSortOrder(EntityDataSortOrder)",
    "void EntityDataPageLink.setTextSearch(String)",
    "String EntityDataPageLink.toString()"
  })
  void testGettersAndSetters_whenTrue() {
    // Arrange and Act
    EntityDataPageLink actualEntityDataPageLink =
        new EntityDataPageLink(3, 1, "Text Search", new EntityDataSortOrder(), true);
    actualEntityDataPageLink.setDynamic(true);
    actualEntityDataPageLink.setPage(1);
    actualEntityDataPageLink.setPageSize(3);
    EntityDataSortOrder sortOrder = new EntityDataSortOrder();
    actualEntityDataPageLink.setSortOrder(sortOrder);
    actualEntityDataPageLink.setTextSearch("Text Search");
    String actualToStringResult = actualEntityDataPageLink.toString();
    int actualPage = actualEntityDataPageLink.getPage();
    int actualPageSize = actualEntityDataPageLink.getPageSize();
    EntityDataSortOrder actualSortOrder = actualEntityDataPageLink.getSortOrder();
    String actualTextSearch = actualEntityDataPageLink.getTextSearch();

    // Assert
    assertEquals(
        "EntityDataPageLink(pageSize=3, page=1, textSearch=Text Search, sortOrder=EntityDataSortOrder(key=null,"
            + " direction=null), dynamic=true)",
        actualToStringResult);
    assertEquals("Text Search", actualTextSearch);
    assertEquals(1, actualPage);
    assertEquals(3, actualPageSize);
    assertTrue(actualEntityDataPageLink.isDynamic());
    assertSame(sortOrder, actualSortOrder);
  }

  /**
   * Test {@link EntityDataPageLink#nextPageLink()}.
   *
   * <ul>
   *   <li>Given {@link AlarmDataPageLink#AlarmDataPageLink()} Dynamic is {@code true}.
   *   <li>Then return Dynamic.
   * </ul>
   *
   * <p>Method under test: {@link EntityDataPageLink#nextPageLink()}
   */
  @Test
  @DisplayName(
      "Test nextPageLink(); given AlarmDataPageLink() Dynamic is 'true'; then return Dynamic")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityDataPageLink EntityDataPageLink.nextPageLink()"})
  void testNextPageLink_givenAlarmDataPageLinkDynamicIsTrue_thenReturnDynamic() {
    // Arrange
    AlarmDataPageLink alarmDataPageLink = new AlarmDataPageLink();
    alarmDataPageLink.setDynamic(true);

    // Act
    AlarmDataPageLink actualNextPageLinkResult = alarmDataPageLink.nextPageLink();

    // Assert
    assertTrue(actualNextPageLinkResult instanceof AlarmDataPageLink);
    assertNull(((AlarmDataPageLink) actualNextPageLinkResult).getTypeList());
    assertNull(((AlarmDataPageLink) actualNextPageLinkResult).getStatusList());
    assertNull(((AlarmDataPageLink) actualNextPageLinkResult).getSeverityList());
    assertNull(((AlarmDataPageLink) actualNextPageLinkResult).getAssigneeId());
    assertEquals(0L, ((AlarmDataPageLink) actualNextPageLinkResult).getEndTs());
    assertEquals(0L, ((AlarmDataPageLink) actualNextPageLinkResult).getStartTs());
    assertEquals(0L, ((AlarmDataPageLink) actualNextPageLinkResult).getTimeWindow());
    assertFalse(((AlarmDataPageLink) actualNextPageLinkResult).isSearchPropagatedAlarms());
    assertTrue(actualNextPageLinkResult.isDynamic());
  }

  /**
   * Test {@link EntityDataPageLink#nextPageLink()}.
   *
   * <ul>
   *   <li>Given {@link AlarmDataPageLink#AlarmDataPageLink()}.
   *   <li>Then return not Dynamic.
   * </ul>
   *
   * <p>Method under test: {@link EntityDataPageLink#nextPageLink()}
   */
  @Test
  @DisplayName("Test nextPageLink(); given AlarmDataPageLink(); then return not Dynamic")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityDataPageLink EntityDataPageLink.nextPageLink()"})
  void testNextPageLink_givenAlarmDataPageLink_thenReturnNotDynamic() {
    // Arrange and Act
    AlarmDataPageLink actualNextPageLinkResult = new AlarmDataPageLink().nextPageLink();

    // Assert
    assertTrue(actualNextPageLinkResult instanceof AlarmDataPageLink);
    assertNull(((AlarmDataPageLink) actualNextPageLinkResult).getTypeList());
    assertNull(((AlarmDataPageLink) actualNextPageLinkResult).getStatusList());
    assertNull(((AlarmDataPageLink) actualNextPageLinkResult).getSeverityList());
    assertNull(((AlarmDataPageLink) actualNextPageLinkResult).getAssigneeId());
    assertEquals(0L, ((AlarmDataPageLink) actualNextPageLinkResult).getEndTs());
    assertEquals(0L, ((AlarmDataPageLink) actualNextPageLinkResult).getStartTs());
    assertEquals(0L, ((AlarmDataPageLink) actualNextPageLinkResult).getTimeWindow());
    assertFalse(((AlarmDataPageLink) actualNextPageLinkResult).isSearchPropagatedAlarms());
    assertFalse(actualNextPageLinkResult.isDynamic());
  }

  /**
   * Test {@link EntityDataPageLink#nextPageLink()}.
   *
   * <ul>
   *   <li>Given {@link EntityDataPageLink#EntityDataPageLink()}.
   *   <li>Then return TextSearch is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EntityDataPageLink#nextPageLink()}
   */
  @Test
  @DisplayName("Test nextPageLink(); given EntityDataPageLink(); then return TextSearch is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityDataPageLink EntityDataPageLink.nextPageLink()"})
  void testNextPageLink_givenEntityDataPageLink_thenReturnTextSearchIsNull() {
    // Arrange and Act
    EntityDataPageLink actualNextPageLinkResult = new EntityDataPageLink().nextPageLink();

    // Assert
    assertNull(actualNextPageLinkResult.getTextSearch());
    assertNull(actualNextPageLinkResult.getSortOrder());
    assertEquals(0, actualNextPageLinkResult.getPageSize());
    assertEquals(1, actualNextPageLinkResult.getPage());
  }
}
