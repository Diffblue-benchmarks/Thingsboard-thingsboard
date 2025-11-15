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
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class EntityDataPageLinkDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityDataPageLink#equals(Object)}
   *   <li>{@link EntityDataPageLink#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityDataPageLink entityDataPageLink = new EntityDataPageLink();
    EntityDataPageLink entityDataPageLink2 = new EntityDataPageLink();

    // Act and Assert
    assertEquals(entityDataPageLink, entityDataPageLink2);
    int expectedHashCodeResult = entityDataPageLink.hashCode();
    assertEquals(expectedHashCodeResult, entityDataPageLink2.hashCode());
  }

  /**
   * Method under test: {@link EntityDataPageLink#nextPageLink()}
   */
  @Test
  void testNextPageLink() {
    // Arrange and Act
    EntityDataPageLink actualNextPageLinkResult = (new EntityDataPageLink()).nextPageLink();

    // Assert
    assertNull(actualNextPageLinkResult.getTextSearch());
    assertNull(actualNextPageLinkResult.getSortOrder());
    assertEquals(0, actualNextPageLinkResult.getPageSize());
    assertEquals(1, actualNextPageLinkResult.getPage());
    assertFalse(actualNextPageLinkResult.isDynamic());
  }

  /**
   * Method under test: {@link EntityDataPageLink#nextPageLink()}
   */
  @Test
  void testNextPageLink2() {
    // Arrange and Act
    AlarmDataPageLink actualNextPageLinkResult = (new AlarmDataPageLink()).nextPageLink();

    // Assert
    assertTrue(actualNextPageLinkResult instanceof AlarmDataPageLink);
    assertNull(actualNextPageLinkResult.getTextSearch());
    assertNull(((AlarmDataPageLink) actualNextPageLinkResult).getTypeList());
    assertNull(((AlarmDataPageLink) actualNextPageLinkResult).getStatusList());
    assertNull(((AlarmDataPageLink) actualNextPageLinkResult).getSeverityList());
    assertNull(((AlarmDataPageLink) actualNextPageLinkResult).getAssigneeId());
    assertNull(actualNextPageLinkResult.getSortOrder());
    assertEquals(0, actualNextPageLinkResult.getPageSize());
    assertEquals(0L, ((AlarmDataPageLink) actualNextPageLinkResult).getEndTs());
    assertEquals(0L, ((AlarmDataPageLink) actualNextPageLinkResult).getStartTs());
    assertEquals(0L, ((AlarmDataPageLink) actualNextPageLinkResult).getTimeWindow());
    assertEquals(1, actualNextPageLinkResult.getPage());
    assertFalse(((AlarmDataPageLink) actualNextPageLinkResult).isSearchPropagatedAlarms());
    assertFalse(actualNextPageLinkResult.isDynamic());
  }

  /**
   * Method under test: {@link EntityDataPageLink#nextPageLink()}
   */
  @Test
  void testNextPageLink3() {
    // Arrange
    AlarmDataPageLink alarmDataPageLink = new AlarmDataPageLink();
    alarmDataPageLink.setDynamic(true);

    // Act
    AlarmDataPageLink actualNextPageLinkResult = alarmDataPageLink.nextPageLink();

    // Assert
    assertTrue(actualNextPageLinkResult instanceof AlarmDataPageLink);
    assertNull(actualNextPageLinkResult.getTextSearch());
    assertNull(((AlarmDataPageLink) actualNextPageLinkResult).getTypeList());
    assertNull(((AlarmDataPageLink) actualNextPageLinkResult).getStatusList());
    assertNull(((AlarmDataPageLink) actualNextPageLinkResult).getSeverityList());
    assertNull(((AlarmDataPageLink) actualNextPageLinkResult).getAssigneeId());
    assertNull(actualNextPageLinkResult.getSortOrder());
    assertEquals(0, actualNextPageLinkResult.getPageSize());
    assertEquals(0L, ((AlarmDataPageLink) actualNextPageLinkResult).getEndTs());
    assertEquals(0L, ((AlarmDataPageLink) actualNextPageLinkResult).getStartTs());
    assertEquals(0L, ((AlarmDataPageLink) actualNextPageLinkResult).getTimeWindow());
    assertEquals(1, actualNextPageLinkResult.getPage());
    assertFalse(((AlarmDataPageLink) actualNextPageLinkResult).isSearchPropagatedAlarms());
    assertTrue(actualNextPageLinkResult.isDynamic());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityDataPageLink#equals(Object)}
   *   <li>{@link EntityDataPageLink#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EntityDataPageLink entityDataPageLink = new EntityDataPageLink(3, 1, "Text Search", new EntityDataSortOrder(),
        true);
    AlarmDataPageLink alarmDataPageLink = mock(AlarmDataPageLink.class);
    when(alarmDataPageLink.isDynamic()).thenReturn(true);
    when(alarmDataPageLink.getPage()).thenReturn(1);
    when(alarmDataPageLink.getPageSize()).thenReturn(3);
    when(alarmDataPageLink.getTextSearch()).thenReturn("Text Search");
    when(alarmDataPageLink.getSortOrder()).thenReturn(new EntityDataSortOrder());
    when(alarmDataPageLink.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertEquals(entityDataPageLink, alarmDataPageLink);
    int notExpectedHashCodeResult = entityDataPageLink.hashCode();
    assertNotEquals(notExpectedHashCodeResult, alarmDataPageLink.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityDataPageLink#equals(Object)}
   *   <li>{@link EntityDataPageLink#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityDataPageLink entityDataPageLink = new EntityDataPageLink();

    // Act and Assert
    assertEquals(entityDataPageLink, entityDataPageLink);
    int expectedHashCodeResult = entityDataPageLink.hashCode();
    assertEquals(expectedHashCodeResult, entityDataPageLink.hashCode());
  }

  /**
   * Method under test: {@link EntityDataPageLink#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AlarmDataPageLink alarmDataPageLink = new AlarmDataPageLink();

    // Act and Assert
    assertNotEquals(alarmDataPageLink, new EntityDataPageLink());
  }

  /**
   * Method under test: {@link EntityDataPageLink#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityDataPageLink entityDataPageLink = new EntityDataPageLink(3, 1, "Text Search", new EntityDataSortOrder());

    // Act and Assert
    assertNotEquals(entityDataPageLink, new EntityDataPageLink());
  }

  /**
   * Method under test: {@link EntityDataPageLink#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntityDataPageLink entityDataPageLink = new EntityDataPageLink();

    // Act and Assert
    assertNotEquals(entityDataPageLink, new AlarmDataPageLink());
  }

  /**
   * Method under test: {@link EntityDataPageLink#equals(Object)}
   */
  @Test
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
   * Method under test: {@link EntityDataPageLink#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    EntityDataPageLink entityDataPageLink = new EntityDataPageLink(3, 1, "Text Search", new EntityDataSortOrder());
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
   * Method under test: {@link EntityDataPageLink#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    EntityDataPageLink entityDataPageLink = new EntityDataPageLink();
    AlarmDataPageLink alarmDataPageLink = mock(AlarmDataPageLink.class);
    when(alarmDataPageLink.isDynamic()).thenReturn(true);
    when(alarmDataPageLink.getPage()).thenReturn(1);
    when(alarmDataPageLink.getPageSize()).thenReturn(0);
    when(alarmDataPageLink.getTextSearch()).thenReturn("Text Search");
    when(alarmDataPageLink.getSortOrder()).thenReturn(new EntityDataSortOrder());
    when(alarmDataPageLink.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(entityDataPageLink, alarmDataPageLink);
  }

  /**
   * Method under test: {@link EntityDataPageLink#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    EntityDataPageLink entityDataPageLink = new EntityDataPageLink(3, 1, null, new EntityDataSortOrder(), true);
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
   * Method under test: {@link EntityDataPageLink#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    EntityDataPageLink entityDataPageLink = new EntityDataPageLink(3, 1,
        "org.thingsboard.server.common.data.query.EntityDataPageLink", new EntityDataSortOrder(), true);
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
   * Method under test: {@link EntityDataPageLink#equals(Object)}
   */
  @Test
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
   * Method under test: {@link EntityDataPageLink#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    EntityDataPageLink entityDataPageLink = new EntityDataPageLink(3, 1, "Text Search",
        new EntityDataSortOrder(new EntityKey(EntityKeyType.ATTRIBUTE, "Key")), true);
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
   * Method under test: {@link EntityDataPageLink#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityDataPageLink(), null);
  }

  /**
   * Method under test: {@link EntityDataPageLink#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityDataPageLink(), "Different type to EntityDataPageLink");
  }

  /**
   * Methods under test:
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

    // Assert that nothing has changed
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
   * Methods under test:
   * <ul>
   *   <li>
   * {@link EntityDataPageLink#EntityDataPageLink(int, int, String, EntityDataSortOrder)}
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
  void testGettersAndSetters2() {
    // Arrange and Act
    EntityDataPageLink actualEntityDataPageLink = new EntityDataPageLink(3, 1, "Text Search",
        new EntityDataSortOrder());
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

    // Assert that nothing has changed
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
   * Methods under test:
   * <ul>
   *   <li>
   * {@link EntityDataPageLink#EntityDataPageLink(int, int, String, EntityDataSortOrder, boolean)}
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
  void testGettersAndSetters3() {
    // Arrange and Act
    EntityDataPageLink actualEntityDataPageLink = new EntityDataPageLink(3, 1, "Text Search", new EntityDataSortOrder(),
        true);
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

    // Assert that nothing has changed
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
}
