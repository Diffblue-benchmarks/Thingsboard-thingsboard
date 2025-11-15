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
package org.thingsboard.server.common.data.page;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.Test;

class TimePageLinkDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TimePageLink#equals(Object)}
   *   <li>{@link TimePageLink#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TimePageLink timePageLink = new TimePageLink(3);
    TimePageLink timePageLink2 = new TimePageLink(3);

    // Act and Assert
    assertEquals(timePageLink, timePageLink2);
    int expectedHashCodeResult = timePageLink.hashCode();
    assertEquals(expectedHashCodeResult, timePageLink2.hashCode());
  }

  /**
   * Method under test: {@link TimePageLink#nextPageLink()}
   */
  @Test
  void testNextPageLink() {
    // Arrange and Act
    TimePageLink actualNextPageLinkResult = (new TimePageLink(3)).nextPageLink();

    // Assert
    assertNull(actualNextPageLinkResult.getEndTime());
    assertNull(actualNextPageLinkResult.getStartTime());
    assertNull(actualNextPageLinkResult.getTextSearch());
    assertNull(actualNextPageLinkResult.getSortOrder());
    assertEquals(1, actualNextPageLinkResult.getPage());
    assertEquals(3, actualNextPageLinkResult.getPageSize());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TimePageLink#equals(Object)}
   *   <li>{@link TimePageLink#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TimePageLink timePageLink = new TimePageLink(3);

    // Act and Assert
    assertEquals(timePageLink, timePageLink);
    int expectedHashCodeResult = timePageLink.hashCode();
    assertEquals(expectedHashCodeResult, timePageLink.hashCode());
  }

  /**
   * Method under test: {@link TimePageLink#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TimePageLink timePageLink = new TimePageLink(1);

    // Act and Assert
    assertNotEquals(timePageLink, new TimePageLink(3));
  }

  /**
   * Method under test: {@link TimePageLink#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new TimePageLink(3), mock(PageLink.class));
  }

  /**
   * Method under test: {@link TimePageLink#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TimePageLink(3), null);
  }

  /**
   * Method under test: {@link TimePageLink#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TimePageLink(3), "Different type to TimePageLink");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TimePageLink#TimePageLink(int)}
   *   <li>{@link TimePageLink#toString()}
   *   <li>{@link TimePageLink#getEndTime()}
   *   <li>{@link TimePageLink#getStartTime()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    TimePageLink actualTimePageLink = new TimePageLink(3);
    String actualToStringResult = actualTimePageLink.toString();
    Long actualEndTime = actualTimePageLink.getEndTime();

    // Assert
    assertEquals("TimePageLink(super=PageLink(textSearch=null, pageSize=3, page=0, sortOrder=null), startTime=null,"
        + " endTime=null)", actualToStringResult);
    assertNull(actualEndTime);
    assertNull(actualTimePageLink.getStartTime());
    assertNull(actualTimePageLink.getTextSearch());
    assertNull(actualTimePageLink.getSortOrder());
    assertEquals(0, actualTimePageLink.getPage());
    assertEquals(3, actualTimePageLink.getPageSize());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TimePageLink#TimePageLink(int, int)}
   *   <li>{@link TimePageLink#toString()}
   *   <li>{@link TimePageLink#getEndTime()}
   *   <li>{@link TimePageLink#getStartTime()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange and Act
    TimePageLink actualTimePageLink = new TimePageLink(3, 1);
    String actualToStringResult = actualTimePageLink.toString();
    Long actualEndTime = actualTimePageLink.getEndTime();

    // Assert
    assertEquals("TimePageLink(super=PageLink(textSearch=null, pageSize=3, page=1, sortOrder=null), startTime=null,"
        + " endTime=null)", actualToStringResult);
    assertNull(actualEndTime);
    assertNull(actualTimePageLink.getStartTime());
    assertNull(actualTimePageLink.getTextSearch());
    assertNull(actualTimePageLink.getSortOrder());
    assertEquals(1, actualTimePageLink.getPage());
    assertEquals(3, actualTimePageLink.getPageSize());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TimePageLink#TimePageLink(int, int, String)}
   *   <li>{@link TimePageLink#toString()}
   *   <li>{@link TimePageLink#getEndTime()}
   *   <li>{@link TimePageLink#getStartTime()}
   * </ul>
   */
  @Test
  void testGettersAndSetters3() {
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
   * Methods under test:
   * <ul>
   *   <li>{@link TimePageLink#TimePageLink(int, int, String, SortOrder)}
   *   <li>{@link TimePageLink#toString()}
   *   <li>{@link TimePageLink#getEndTime()}
   *   <li>{@link TimePageLink#getStartTime()}
   * </ul>
   */
  @Test
  void testGettersAndSetters4() {
    // Arrange
    SortOrder sortOrder = SortOrder.BY_CREATED_TIME_DESC;

    // Act
    TimePageLink actualTimePageLink = new TimePageLink(3, 1, "Text Search", sortOrder);
    String actualToStringResult = actualTimePageLink.toString();
    Long actualEndTime = actualTimePageLink.getEndTime();
    Long actualStartTime = actualTimePageLink.getStartTime();

    // Assert
    assertEquals("Text Search", actualTimePageLink.getTextSearch());
    assertEquals("TimePageLink(super=PageLink(textSearch=Text Search, pageSize=3, page=1, sortOrder=SortOrder(property"
        + "=createdTime, direction=DESC)), startTime=null, endTime=null)", actualToStringResult);
    assertNull(actualEndTime);
    assertNull(actualStartTime);
    assertEquals(1, actualTimePageLink.getPage());
    assertEquals(3, actualTimePageLink.getPageSize());
    SortOrder expectedSortOrder = sortOrder.BY_CREATED_TIME_DESC;
    assertSame(expectedSortOrder, actualTimePageLink.getSortOrder());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link TimePageLink#TimePageLink(int, int, String, SortOrder, Long, Long)}
   *   <li>{@link TimePageLink#toString()}
   *   <li>{@link TimePageLink#getEndTime()}
   *   <li>{@link TimePageLink#getStartTime()}
   * </ul>
   */
  @Test
  void testGettersAndSetters5() {
    // Arrange
    SortOrder sortOrder = SortOrder.BY_CREATED_TIME_DESC;

    // Act
    TimePageLink actualTimePageLink = new TimePageLink(3, 1, "Text Search", sortOrder, 1L, 1L);
    String actualToStringResult = actualTimePageLink.toString();
    Long actualEndTime = actualTimePageLink.getEndTime();
    Long actualStartTime = actualTimePageLink.getStartTime();

    // Assert
    assertEquals("Text Search", actualTimePageLink.getTextSearch());
    assertEquals("TimePageLink(super=PageLink(textSearch=Text Search, pageSize=3, page=1, sortOrder=SortOrder(property"
        + "=createdTime, direction=DESC)), startTime=1, endTime=1)", actualToStringResult);
    assertEquals(1, actualTimePageLink.getPage());
    assertEquals(1L, actualEndTime.longValue());
    assertEquals(1L, actualStartTime.longValue());
    assertEquals(3, actualTimePageLink.getPageSize());
    SortOrder expectedSortOrder = sortOrder.BY_CREATED_TIME_DESC;
    assertSame(expectedSortOrder, actualTimePageLink.getSortOrder());
  }

  /**
   * Method under test: {@link TimePageLink#TimePageLink(PageLink, Long, Long)}
   */
  @Test
  void testNewTimePageLink() {
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
}
