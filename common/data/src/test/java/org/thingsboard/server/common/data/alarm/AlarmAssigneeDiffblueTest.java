package org.thingsboard.server.common.data.alarm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AlarmAssigneeDiffblueTest {
  /**
   * Test {@link AlarmAssignee#getTitle()}.
   * <ul>
   *   <li>Then return {@code Doe}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmAssignee#getTitle()}
   */
  @Test
  @DisplayName("Test getTitle(); then return 'Doe'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String AlarmAssignee.getTitle()"})
  void testGetTitle_thenReturnDoe() {
    // Arrange, Act and Assert
    assertEquals("Doe", (new AlarmAssignee(null, "", "Doe", "jane.doe@example.org")).getTitle());
  }

  /**
   * Test {@link AlarmAssignee#getTitle()}.
   * <ul>
   *   <li>Then return {@code Jane}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmAssignee#getTitle()}
   */
  @Test
  @DisplayName("Test getTitle(); then return 'Jane'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String AlarmAssignee.getTitle()"})
  void testGetTitle_thenReturnJane() {
    // Arrange, Act and Assert
    assertEquals("Jane", (new AlarmAssignee(null, "Jane", "", "jane.doe@example.org")).getTitle());
  }

  /**
   * Test {@link AlarmAssignee#getTitle()}.
   * <ul>
   *   <li>Then return {@code Jane Doe}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmAssignee#getTitle()}
   */
  @Test
  @DisplayName("Test getTitle(); then return 'Jane Doe'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String AlarmAssignee.getTitle()"})
  void testGetTitle_thenReturnJaneDoe() {
    // Arrange, Act and Assert
    assertEquals("Jane Doe", (new AlarmAssignee(null, "Jane", "Doe", "jane.doe@example.org")).getTitle());
  }

  /**
   * Test {@link AlarmAssignee#getTitle()}.
   * <ul>
   *   <li>Then return {@code jane.doe@example.org}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmAssignee#getTitle()}
   */
  @Test
  @DisplayName("Test getTitle(); then return 'jane.doe@example.org'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String AlarmAssignee.getTitle()"})
  void testGetTitle_thenReturnJaneDoeExampleOrg() {
    // Arrange, Act and Assert
    assertEquals("jane.doe@example.org", (new AlarmAssignee(null, "", "", "jane.doe@example.org")).getTitle());
  }

  /**
   * Test {@link AlarmAssignee#getTitle()}.
   * <ul>
   *   <li>Then return {@code not empty}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmAssignee#getTitle()}
   */
  @Test
  @DisplayName("Test getTitle(); then return 'not empty'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String AlarmAssignee.getTitle()"})
  void testGetTitle_thenReturnNotEmpty() {
    // Arrange, Act and Assert
    assertEquals("not empty", (new AlarmAssignee(null, "not empty", null, "jane.doe@example.org")).getTitle());
  }
}
