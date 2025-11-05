package org.thingsboard.server.common.data.page;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TimePageLinkDiffblueTest {
  /**
   * Test {@link TimePageLink#equals(Object)}, and {@link TimePageLink#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TimePageLink#equals(Object)}
   *   <li>{@link TimePageLink#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TimePageLink.equals(Object)", "int TimePageLink.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TimePageLink timePageLink = new TimePageLink(3);
    TimePageLink timePageLink2 = new TimePageLink(3);

    // Act and Assert
    assertEquals(timePageLink, timePageLink2);
    assertEquals(timePageLink.hashCode(), timePageLink2.hashCode());
  }

  /**
   * Test {@link TimePageLink#equals(Object)}, and {@link TimePageLink#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TimePageLink#equals(Object)}
   *   <li>{@link TimePageLink#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TimePageLink.equals(Object)", "int TimePageLink.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TimePageLink timePageLink = new TimePageLink(3);

    // Act and Assert
    assertEquals(timePageLink, timePageLink);
    int expectedHashCodeResult = timePageLink.hashCode();
    assertEquals(expectedHashCodeResult, timePageLink.hashCode());
  }

  /**
   * Test {@link TimePageLink#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TimePageLink#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TimePageLink.equals(Object)", "int TimePageLink.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TimePageLink timePageLink = new TimePageLink(1);

    // Act and Assert
    assertNotEquals(timePageLink, new TimePageLink(3));
  }

  /**
   * Test {@link TimePageLink#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TimePageLink#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TimePageLink.equals(Object)", "int TimePageLink.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TimePageLink(3), null);
  }

  /**
   * Test {@link TimePageLink#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TimePageLink#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TimePageLink.equals(Object)", "int TimePageLink.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TimePageLink(3), "Different type to TimePageLink");
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return SortOrder is {@link SortOrder#BY_CREATED_TIME_DESC}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TimePageLink#TimePageLink(int, int, String, SortOrder)}
   *   <li>{@link TimePageLink#toString()}
   *   <li>{@link TimePageLink#getEndTime()}
   *   <li>{@link TimePageLink#getStartTime()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; then return SortOrder is BY_CREATED_TIME_DESC")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TimePageLink.<init>(int)",
    "void TimePageLink.<init>(int, int)",
    "void TimePageLink.<init>(int, int, String)",
    "void TimePageLink.<init>(int, int, String, SortOrder)",
    "void TimePageLink.<init>(int, int, String, SortOrder, Long, Long)",
    "Long TimePageLink.getEndTime()",
    "Long TimePageLink.getStartTime()",
    "String TimePageLink.toString()"
  })
  void testGettersAndSetters_thenReturnSortOrderIsBy_created_time_desc() {
    // Arrange and Act
    TimePageLink actualTimePageLink =
        new TimePageLink(3, 1, "Text Search", SortOrder.BY_CREATED_TIME_DESC);
    String actualToStringResult = actualTimePageLink.toString();
    Long actualEndTime = actualTimePageLink.getEndTime();
    Long actualStartTime = actualTimePageLink.getStartTime();

    // Assert
    assertEquals("Text Search", actualTimePageLink.getTextSearch());
    assertEquals(
        "TimePageLink(super=PageLink(textSearch=Text Search, pageSize=3, page=1, sortOrder=SortOrder(property"
            + "=createdTime, direction=DESC)), startTime=null, endTime=null)",
        actualToStringResult);
    assertNull(actualEndTime);
    assertNull(actualStartTime);
    assertEquals(1, actualTimePageLink.getPage());
    assertEquals(3, actualTimePageLink.getPageSize());
    assertSame(SortOrder.BY_CREATED_TIME_DESC, actualTimePageLink.getSortOrder());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link SortOrder#BY_CREATED_TIME_DESC}.
   *   <li>Then return EndTime longValue is one.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TimePageLink#TimePageLink(int, int, String, SortOrder, Long, Long)}
   *   <li>{@link TimePageLink#toString()}
   *   <li>{@link TimePageLink#getEndTime()}
   *   <li>{@link TimePageLink#getStartTime()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test getters and setters; when BY_CREATED_TIME_DESC; then return EndTime longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TimePageLink.<init>(int)",
    "void TimePageLink.<init>(int, int)",
    "void TimePageLink.<init>(int, int, String)",
    "void TimePageLink.<init>(int, int, String, SortOrder)",
    "void TimePageLink.<init>(int, int, String, SortOrder, Long, Long)",
    "Long TimePageLink.getEndTime()",
    "Long TimePageLink.getStartTime()",
    "String TimePageLink.toString()"
  })
  void testGettersAndSetters_whenBy_created_time_desc_thenReturnEndTimeLongValueIsOne() {
    // Arrange and Act
    TimePageLink actualTimePageLink =
        new TimePageLink(3, 1, "Text Search", SortOrder.BY_CREATED_TIME_DESC, 1L, 1L);
    String actualToStringResult = actualTimePageLink.toString();
    Long actualEndTime = actualTimePageLink.getEndTime();
    Long actualStartTime = actualTimePageLink.getStartTime();

    // Assert
    assertEquals("Text Search", actualTimePageLink.getTextSearch());
    assertEquals(
        "TimePageLink(super=PageLink(textSearch=Text Search, pageSize=3, page=1, sortOrder=SortOrder(property"
            + "=createdTime, direction=DESC)), startTime=1, endTime=1)",
        actualToStringResult);
    assertEquals(1, actualTimePageLink.getPage());
    assertEquals(1L, actualEndTime.longValue());
    assertEquals(1L, actualStartTime.longValue());
    assertEquals(3, actualTimePageLink.getPageSize());
    assertSame(SortOrder.BY_CREATED_TIME_DESC, actualTimePageLink.getSortOrder());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return TextSearch is {@code null}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TimePageLink#TimePageLink(int, int)}
   *   <li>{@link TimePageLink#toString()}
   *   <li>{@link TimePageLink#getEndTime()}
   *   <li>{@link TimePageLink#getStartTime()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when one; then return TextSearch is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TimePageLink.<init>(int)",
    "void TimePageLink.<init>(int, int)",
    "void TimePageLink.<init>(int, int, String)",
    "void TimePageLink.<init>(int, int, String, SortOrder)",
    "void TimePageLink.<init>(int, int, String, SortOrder, Long, Long)",
    "Long TimePageLink.getEndTime()",
    "Long TimePageLink.getStartTime()",
    "String TimePageLink.toString()"
  })
  void testGettersAndSetters_whenOne_thenReturnTextSearchIsNull() {
    // Arrange and Act
    TimePageLink actualTimePageLink = new TimePageLink(3, 1);
    String actualToStringResult = actualTimePageLink.toString();
    Long actualEndTime = actualTimePageLink.getEndTime();

    // Assert
    assertEquals(
        "TimePageLink(super=PageLink(textSearch=null, pageSize=3, page=1, sortOrder=null), startTime=null,"
            + " endTime=null)",
        actualToStringResult);
    assertNull(actualEndTime);
    assertNull(actualTimePageLink.getStartTime());
    assertNull(actualTimePageLink.getTextSearch());
    assertNull(actualTimePageLink.getSortOrder());
    assertEquals(1, actualTimePageLink.getPage());
    assertEquals(3, actualTimePageLink.getPageSize());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code Text Search}.
   *   <li>Then return {@code Text Search}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TimePageLink#TimePageLink(int, int, String)}
   *   <li>{@link TimePageLink#toString()}
   *   <li>{@link TimePageLink#getEndTime()}
   *   <li>{@link TimePageLink#getStartTime()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'Text Search'; then return 'Text Search'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TimePageLink.<init>(int)",
    "void TimePageLink.<init>(int, int)",
    "void TimePageLink.<init>(int, int, String)",
    "void TimePageLink.<init>(int, int, String, SortOrder)",
    "void TimePageLink.<init>(int, int, String, SortOrder, Long, Long)",
    "Long TimePageLink.getEndTime()",
    "Long TimePageLink.getStartTime()",
    "String TimePageLink.toString()"
  })
  void testGettersAndSetters_whenTextSearch_thenReturnTextSearch() {
    // Arrange and Act
    TimePageLink actualTimePageLink = new TimePageLink(3, 1, "Text Search");
    String actualToStringResult = actualTimePageLink.toString();
    Long actualEndTime = actualTimePageLink.getEndTime();
    Long actualStartTime = actualTimePageLink.getStartTime();

    // Assert
    assertEquals("Text Search", actualTimePageLink.getTextSearch());
    assertEquals(
        "TimePageLink(super=PageLink(textSearch=Text Search, pageSize=3, page=1, sortOrder=null), startTime=null,"
            + " endTime=null)",
        actualToStringResult);
    assertNull(actualEndTime);
    assertNull(actualStartTime);
    assertNull(actualTimePageLink.getSortOrder());
    assertEquals(1, actualTimePageLink.getPage());
    assertEquals(3, actualTimePageLink.getPageSize());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return Page is zero.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TimePageLink#TimePageLink(int)}
   *   <li>{@link TimePageLink#toString()}
   *   <li>{@link TimePageLink#getEndTime()}
   *   <li>{@link TimePageLink#getStartTime()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when three; then return Page is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TimePageLink.<init>(int)",
    "void TimePageLink.<init>(int, int)",
    "void TimePageLink.<init>(int, int, String)",
    "void TimePageLink.<init>(int, int, String, SortOrder)",
    "void TimePageLink.<init>(int, int, String, SortOrder, Long, Long)",
    "Long TimePageLink.getEndTime()",
    "Long TimePageLink.getStartTime()",
    "String TimePageLink.toString()"
  })
  void testGettersAndSetters_whenThree_thenReturnPageIsZero() {
    // Arrange and Act
    TimePageLink actualTimePageLink = new TimePageLink(3);
    String actualToStringResult = actualTimePageLink.toString();
    Long actualEndTime = actualTimePageLink.getEndTime();

    // Assert
    assertEquals(
        "TimePageLink(super=PageLink(textSearch=null, pageSize=3, page=0, sortOrder=null), startTime=null,"
            + " endTime=null)",
        actualToStringResult);
    assertNull(actualEndTime);
    assertNull(actualTimePageLink.getStartTime());
    assertNull(actualTimePageLink.getTextSearch());
    assertNull(actualTimePageLink.getSortOrder());
    assertEquals(0, actualTimePageLink.getPage());
    assertEquals(3, actualTimePageLink.getPageSize());
  }

  /**
   * Test {@link TimePageLink#TimePageLink(PageLink, Long, Long)}.
   *
   * <ul>
   *   <li>When {@link PageLink#PageLink(int)} with pageSize is three.
   *   <li>Then return TextSearch is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TimePageLink#TimePageLink(PageLink, Long, Long)}
   */
  @Test
  @DisplayName(
      "Test new TimePageLink(PageLink, Long, Long); when PageLink(int) with pageSize is three; then return TextSearch is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimePageLink.<init>(PageLink, Long, Long)"})
  void testNewTimePageLink_whenPageLinkWithPageSizeIsThree_thenReturnTextSearchIsNull() {
    // Arrange and Act
    TimePageLink actualTimePageLink = new TimePageLink(new PageLink(3), 1L, 1L);

    // Assert
    assertNull(actualTimePageLink.getTextSearch());
    assertNull(actualTimePageLink.getSortOrder());
    assertEquals(0, actualTimePageLink.getPage());
    assertEquals(1L, actualTimePageLink.getEndTime().longValue());
    assertEquals(1L, actualTimePageLink.getStartTime().longValue());
    assertEquals(3, actualTimePageLink.getPageSize());
  }

  /**
   * Test {@link TimePageLink#nextPageLink()}.
   *
   * <p>Method under test: {@link TimePageLink#nextPageLink()}
   */
  @Test
  @DisplayName("Test nextPageLink()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TimePageLink TimePageLink.nextPageLink()"})
  void testNextPageLink() {
    // Arrange and Act
    TimePageLink actualNextPageLinkResult = new TimePageLink(3).nextPageLink();

    // Assert
    assertNull(actualNextPageLinkResult.getEndTime());
    assertNull(actualNextPageLinkResult.getStartTime());
    assertNull(actualNextPageLinkResult.getTextSearch());
    assertNull(actualNextPageLinkResult.getSortOrder());
    assertEquals(1, actualNextPageLinkResult.getPage());
    assertEquals(3, actualNextPageLinkResult.getPageSize());
  }
}
