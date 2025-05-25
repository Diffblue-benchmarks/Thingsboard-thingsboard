package org.thingsboard.server.common.data.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.id.EntityId;

class AbstractUserDashboardInfoDiffblueTest {
  /**
   * Test {@link AbstractUserDashboardInfo#canEqual(Object)}.
   * <ul>
   *   <li>When {@link LastVisitedDashboardInfo} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractUserDashboardInfo#canEqual(Object)}
   */
  @Test
  @DisplayName("Test canEqual(Object); when LastVisitedDashboardInfo (default constructor); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractUserDashboardInfo.canEqual(Object)"})
  void testCanEqual_whenLastVisitedDashboardInfo_thenReturnTrue() {
    // Arrange
    LastVisitedDashboardInfo lastVisitedDashboardInfo = new LastVisitedDashboardInfo();

    // Act and Assert
    assertTrue(lastVisitedDashboardInfo.canEqual(new LastVisitedDashboardInfo()));
  }

  /**
   * Test {@link AbstractUserDashboardInfo#canEqual(Object)}.
   * <ul>
   *   <li>When {@code Other}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractUserDashboardInfo#canEqual(Object)}
   */
  @Test
  @DisplayName("Test canEqual(Object); when 'Other'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractUserDashboardInfo.canEqual(Object)"})
  void testCanEqual_whenOther_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new LastVisitedDashboardInfo()).canEqual("Other"));
  }

  /**
   * Test {@link AbstractUserDashboardInfo#equals(Object)}, and {@link AbstractUserDashboardInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractUserDashboardInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractUserDashboardInfo.equals(Object)", "int AbstractUserDashboardInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    LastVisitedDashboardInfo lastVisitedDashboardInfo = new LastVisitedDashboardInfo();
    LastVisitedDashboardInfo lastVisitedDashboardInfo2 = new LastVisitedDashboardInfo();

    // Act and Assert
    assertEquals(lastVisitedDashboardInfo, lastVisitedDashboardInfo2);
    int expectedHashCodeResult = lastVisitedDashboardInfo.hashCode();
    assertEquals(expectedHashCodeResult, lastVisitedDashboardInfo2.hashCode());
  }

  /**
   * Test {@link AbstractUserDashboardInfo#equals(Object)}, and {@link AbstractUserDashboardInfo#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractUserDashboardInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractUserDashboardInfo.equals(Object)", "int AbstractUserDashboardInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LastVisitedDashboardInfo lastVisitedDashboardInfo = new LastVisitedDashboardInfo();

    // Act and Assert
    assertEquals(lastVisitedDashboardInfo, lastVisitedDashboardInfo);
    int expectedHashCodeResult = lastVisitedDashboardInfo.hashCode();
    assertEquals(expectedHashCodeResult, lastVisitedDashboardInfo.hashCode());
  }

  /**
   * Test {@link AbstractUserDashboardInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractUserDashboardInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractUserDashboardInfo.equals(Object)", "int AbstractUserDashboardInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LastVisitedDashboardInfo lastVisitedDashboardInfo = new LastVisitedDashboardInfo();

    StarredDashboardInfo starredDashboardInfo = new StarredDashboardInfo();
    starredDashboardInfo.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    starredDashboardInfo.setStarredAt(1L);
    starredDashboardInfo.setTitle("Dr");

    // Act and Assert
    assertNotEquals(lastVisitedDashboardInfo, starredDashboardInfo);
  }

  /**
   * Test {@link AbstractUserDashboardInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractUserDashboardInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractUserDashboardInfo.equals(Object)", "int AbstractUserDashboardInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    LastVisitedDashboardInfo lastVisitedDashboardInfo = new LastVisitedDashboardInfo();
    LastVisitedDashboardInfo lastVisitedDashboardInfo2 = mock(LastVisitedDashboardInfo.class);
    when(lastVisitedDashboardInfo2.isStarred()).thenReturn(true);
    when(lastVisitedDashboardInfo2.getTitle()).thenReturn("Dr");
    when(lastVisitedDashboardInfo2.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(lastVisitedDashboardInfo2.getLastVisited()).thenReturn(1L);
    when(lastVisitedDashboardInfo2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(lastVisitedDashboardInfo, lastVisitedDashboardInfo2);
  }

  /**
   * Test {@link AbstractUserDashboardInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractUserDashboardInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractUserDashboardInfo.equals(Object)", "int AbstractUserDashboardInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    LastVisitedDashboardInfo lastVisitedDashboardInfo = new LastVisitedDashboardInfo();
    LastVisitedDashboardInfo lastVisitedDashboardInfo2 = mock(LastVisitedDashboardInfo.class);
    when(lastVisitedDashboardInfo2.isStarred()).thenReturn(true);
    when(lastVisitedDashboardInfo2.getTitle()).thenReturn("Dr");
    when(lastVisitedDashboardInfo2.getId()).thenReturn(null);
    when(lastVisitedDashboardInfo2.getLastVisited()).thenReturn(1L);
    when(lastVisitedDashboardInfo2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(lastVisitedDashboardInfo, lastVisitedDashboardInfo2);
  }

  /**
   * Test {@link AbstractUserDashboardInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractUserDashboardInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractUserDashboardInfo.equals(Object)", "int AbstractUserDashboardInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    LastVisitedDashboardInfo lastVisitedDashboardInfo = new LastVisitedDashboardInfo();
    lastVisitedDashboardInfo.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    LastVisitedDashboardInfo lastVisitedDashboardInfo2 = mock(LastVisitedDashboardInfo.class);
    when(lastVisitedDashboardInfo2.isStarred()).thenReturn(true);
    when(lastVisitedDashboardInfo2.getTitle()).thenReturn("Dr");
    when(lastVisitedDashboardInfo2.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(lastVisitedDashboardInfo2.getLastVisited()).thenReturn(1L);
    when(lastVisitedDashboardInfo2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(lastVisitedDashboardInfo, lastVisitedDashboardInfo2);
  }

  /**
   * Test {@link AbstractUserDashboardInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractUserDashboardInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractUserDashboardInfo.equals(Object)", "int AbstractUserDashboardInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    LastVisitedDashboardInfo lastVisitedDashboardInfo = new LastVisitedDashboardInfo();
    lastVisitedDashboardInfo.setId(EntityId.NULL_UUID);
    LastVisitedDashboardInfo lastVisitedDashboardInfo2 = mock(LastVisitedDashboardInfo.class);
    when(lastVisitedDashboardInfo2.isStarred()).thenReturn(true);
    when(lastVisitedDashboardInfo2.getTitle()).thenReturn("Dr");
    when(lastVisitedDashboardInfo2.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(lastVisitedDashboardInfo2.getLastVisited()).thenReturn(1L);
    when(lastVisitedDashboardInfo2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(lastVisitedDashboardInfo, lastVisitedDashboardInfo2);
  }

  /**
   * Test {@link AbstractUserDashboardInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractUserDashboardInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractUserDashboardInfo.equals(Object)", "int AbstractUserDashboardInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    LastVisitedDashboardInfo lastVisitedDashboardInfo = new LastVisitedDashboardInfo();
    lastVisitedDashboardInfo.setTitle("Dr");
    LastVisitedDashboardInfo lastVisitedDashboardInfo2 = mock(LastVisitedDashboardInfo.class);
    when(lastVisitedDashboardInfo2.isStarred()).thenReturn(true);
    when(lastVisitedDashboardInfo2.getTitle()).thenReturn("Dr");
    when(lastVisitedDashboardInfo2.getId()).thenReturn(null);
    when(lastVisitedDashboardInfo2.getLastVisited()).thenReturn(1L);
    when(lastVisitedDashboardInfo2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(lastVisitedDashboardInfo, lastVisitedDashboardInfo2);
  }

  /**
   * Test {@link AbstractUserDashboardInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractUserDashboardInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractUserDashboardInfo.equals(Object)", "int AbstractUserDashboardInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    LastVisitedDashboardInfo lastVisitedDashboardInfo = new LastVisitedDashboardInfo();
    lastVisitedDashboardInfo.setTitle("Mr");
    LastVisitedDashboardInfo lastVisitedDashboardInfo2 = mock(LastVisitedDashboardInfo.class);
    when(lastVisitedDashboardInfo2.isStarred()).thenReturn(true);
    when(lastVisitedDashboardInfo2.getTitle()).thenReturn("Dr");
    when(lastVisitedDashboardInfo2.getId()).thenReturn(null);
    when(lastVisitedDashboardInfo2.getLastVisited()).thenReturn(1L);
    when(lastVisitedDashboardInfo2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(lastVisitedDashboardInfo, lastVisitedDashboardInfo2);
  }

  /**
   * Test {@link AbstractUserDashboardInfo#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractUserDashboardInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractUserDashboardInfo.equals(Object)", "int AbstractUserDashboardInfo.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new LastVisitedDashboardInfo(), null);
  }

  /**
   * Test {@link AbstractUserDashboardInfo#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractUserDashboardInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractUserDashboardInfo.equals(Object)", "int AbstractUserDashboardInfo.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new LastVisitedDashboardInfo(), "Different type to AbstractUserDashboardInfo");
  }

  /**
   * Test {@link AbstractUserDashboardInfo#getId()}.
   * <p>
   * Method under test: {@link AbstractUserDashboardInfo#getId()}
   */
  @Test
  @DisplayName("Test getId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"UUID AbstractUserDashboardInfo.getId()"})
  void testGetId() {
    // Arrange, Act and Assert
    assertNull((new LastVisitedDashboardInfo()).getId());
  }

  /**
   * Test {@link AbstractUserDashboardInfo#getTitle()}.
   * <p>
   * Method under test: {@link AbstractUserDashboardInfo#getTitle()}
   */
  @Test
  @DisplayName("Test getTitle()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AbstractUserDashboardInfo.getTitle()"})
  void testGetTitle() {
    // Arrange, Act and Assert
    assertNull((new LastVisitedDashboardInfo()).getTitle());
  }

  /**
   * Test {@link AbstractUserDashboardInfo#setId(UUID)}.
   * <p>
   * Method under test: {@link AbstractUserDashboardInfo#setId(UUID)}
   */
  @Test
  @DisplayName("Test setId(UUID)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AbstractUserDashboardInfo.setId(UUID)"})
  void testSetId() {
    // Arrange
    LastVisitedDashboardInfo lastVisitedDashboardInfo = new LastVisitedDashboardInfo();
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    lastVisitedDashboardInfo.setId(id);

    // Assert
    assertSame(id, lastVisitedDashboardInfo.getId());
  }

  /**
   * Test {@link AbstractUserDashboardInfo#setTitle(String)}.
   * <p>
   * Method under test: {@link AbstractUserDashboardInfo#setTitle(String)}
   */
  @Test
  @DisplayName("Test setTitle(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AbstractUserDashboardInfo.setTitle(String)"})
  void testSetTitle() {
    // Arrange
    LastVisitedDashboardInfo lastVisitedDashboardInfo = new LastVisitedDashboardInfo();

    // Act
    lastVisitedDashboardInfo.setTitle("Dr");

    // Assert
    assertEquals("Dr", lastVisitedDashboardInfo.getTitle());
  }

  /**
   * Test {@link AbstractUserDashboardInfo#toString()}.
   * <p>
   * Method under test: {@link AbstractUserDashboardInfo#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AbstractUserDashboardInfo.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("LastVisitedDashboardInfo(starred=false, lastVisited=0)", (new LastVisitedDashboardInfo()).toString());
  }
}
