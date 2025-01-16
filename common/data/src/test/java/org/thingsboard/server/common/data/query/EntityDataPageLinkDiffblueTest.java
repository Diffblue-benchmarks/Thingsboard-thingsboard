package org.thingsboard.server.common.data.query;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class EntityDataPageLinkDiffblueTest {
  /**
   * Test {@link EntityDataPageLink#equals(Object)}, and
   * {@link EntityDataPageLink#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityDataPageLink#equals(Object)}
   *   <li>{@link EntityDataPageLink#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test {@link EntityDataPageLink#equals(Object)}, and
   * {@link EntityDataPageLink#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityDataPageLink#equals(Object)}
   *   <li>{@link EntityDataPageLink#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test {@link EntityDataPageLink#equals(Object)}, and
   * {@link EntityDataPageLink#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityDataPageLink#equals(Object)}
   *   <li>{@link EntityDataPageLink#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityDataPageLink#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AlarmDataPageLink alarmDataPageLink = new AlarmDataPageLink();

    // Act and Assert
    assertNotEquals(alarmDataPageLink, new EntityDataPageLink());
  }

  /**
   * Test {@link EntityDataPageLink#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityDataPageLink#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityDataPageLink entityDataPageLink = new EntityDataPageLink(3, 1, "Text Search", new EntityDataSortOrder());

    // Act and Assert
    assertNotEquals(entityDataPageLink, new EntityDataPageLink());
  }

  /**
   * Test {@link EntityDataPageLink#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityDataPageLink#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntityDataPageLink entityDataPageLink = new EntityDataPageLink();

    // Act and Assert
    assertNotEquals(entityDataPageLink, new AlarmDataPageLink());
  }

  /**
   * Test {@link EntityDataPageLink#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityDataPageLink#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityDataPageLink#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * Test {@link EntityDataPageLink#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityDataPageLink#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * Test {@link EntityDataPageLink#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityDataPageLink#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * Test {@link EntityDataPageLink#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityDataPageLink#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * Test {@link EntityDataPageLink#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityDataPageLink#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityDataPageLink#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * Test {@link EntityDataPageLink#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityDataPageLink#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityDataPageLink(), null);
  }

  /**
   * Test {@link EntityDataPageLink#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityDataPageLink#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityDataPageLink(), "Different type to EntityDataPageLink");
  }

  /**
   * Test getters and setters.
   * <p>
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
  @DisplayName("Test getters and setters")
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
   * Test getters and setters.
   * <ul>
   *   <li>When three.</li>
   * </ul>
   * <p>
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
  @DisplayName("Test getters and setters; when three")
  void testGettersAndSetters_whenThree() {
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
   * Test getters and setters.
   * <ul>
   *   <li>When {@code true}.</li>
   * </ul>
   * <p>
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
  @DisplayName("Test getters and setters; when 'true'")
  void testGettersAndSetters_whenTrue() {
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

  /**
   * Test {@link EntityDataPageLink#nextPageLink()}.
   * <ul>
   *   <li>Given {@link AlarmDataPageLink#AlarmDataPageLink()} Dynamic is
   * {@code true}.</li>
   *   <li>Then return Dynamic.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityDataPageLink#nextPageLink()}
   */
  @Test
  @DisplayName("Test nextPageLink(); given AlarmDataPageLink() Dynamic is 'true'; then return Dynamic")
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
   * <ul>
   *   <li>Given {@link AlarmDataPageLink#AlarmDataPageLink()}.</li>
   *   <li>Then return {@link AlarmDataPageLink}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityDataPageLink#nextPageLink()}
   */
  @Test
  @DisplayName("Test nextPageLink(); given AlarmDataPageLink(); then return AlarmDataPageLink")
  void testNextPageLink_givenAlarmDataPageLink_thenReturnAlarmDataPageLink() {
    // Arrange and Act
    AlarmDataPageLink actualNextPageLinkResult = (new AlarmDataPageLink()).nextPageLink();

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
   * <ul>
   *   <li>Given {@link EntityDataPageLink#EntityDataPageLink()}.</li>
   *   <li>Then return TextSearch is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityDataPageLink#nextPageLink()}
   */
  @Test
  @DisplayName("Test nextPageLink(); given EntityDataPageLink(); then return TextSearch is 'null'")
  void testNextPageLink_givenEntityDataPageLink_thenReturnTextSearchIsNull() {
    // Arrange and Act
    EntityDataPageLink actualNextPageLinkResult = (new EntityDataPageLink()).nextPageLink();

    // Assert
    assertNull(actualNextPageLinkResult.getTextSearch());
    assertNull(actualNextPageLinkResult.getSortOrder());
    assertEquals(0, actualNextPageLinkResult.getPageSize());
    assertEquals(1, actualNextPageLinkResult.getPage());
    assertFalse(actualNextPageLinkResult.isDynamic());
  }
}
