package org.thingsboard.server.controller;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.alarm.AlarmComment;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.dao.alarm.BaseAlarmCommentService;
import org.thingsboard.server.service.entitiy.alarm.DefaultTbAlarmCommentService;

class AlarmCommentControllerDiffblueTest {
  /**
   * Test {@link AlarmCommentController#saveAlarmComment(String, AlarmComment)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmCommentController#saveAlarmComment(String, AlarmComment)}
   */
  @Test
  @DisplayName("Test saveAlarmComment(String, AlarmComment); when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AlarmComment AlarmCommentController.saveAlarmComment(String, AlarmComment)"})
  void testSaveAlarmComment_when42() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    AlarmCommentController alarmCommentController =
        new AlarmCommentController(new DefaultTbAlarmCommentService(new BaseAlarmCommentService()));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> alarmCommentController.saveAlarmComment("42", new AlarmComment()));
  }

  /**
   * Test {@link AlarmCommentController#saveAlarmComment(String, AlarmComment)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link AlarmCommentController#saveAlarmComment(String, AlarmComment)}
   */
  @Test
  @DisplayName("Test saveAlarmComment(String, AlarmComment); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AlarmComment AlarmCommentController.saveAlarmComment(String, AlarmComment)"})
  void testSaveAlarmComment_whenEmptyString() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    AlarmCommentController alarmCommentController =
        new AlarmCommentController(new DefaultTbAlarmCommentService(new BaseAlarmCommentService()));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> alarmCommentController.saveAlarmComment("", new AlarmComment()));
  }

  /**
   * Test {@link AlarmCommentController#deleteAlarmComment(String, String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmCommentController#deleteAlarmComment(String, String)}
   */
  @Test
  @DisplayName("Test deleteAlarmComment(String, String); when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AlarmCommentController.deleteAlarmComment(String, String)"})
  void testDeleteAlarmComment_when42() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange, Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            new AlarmCommentController(
                    new DefaultTbAlarmCommentService(new BaseAlarmCommentService()))
                .deleteAlarmComment("42", "42"));
  }

  /**
   * Test {@link AlarmCommentController#deleteAlarmComment(String, String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link AlarmCommentController#deleteAlarmComment(String, String)}
   */
  @Test
  @DisplayName("Test deleteAlarmComment(String, String); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AlarmCommentController.deleteAlarmComment(String, String)"})
  void testDeleteAlarmComment_whenEmptyString() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange, Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            new AlarmCommentController(
                    new DefaultTbAlarmCommentService(new BaseAlarmCommentService()))
                .deleteAlarmComment("", "42"));
  }

  /**
   * Test {@link AlarmCommentController#getAlarmComments(String, int, int, String, String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmCommentController#getAlarmComments(String, int, int, String,
   * String)}
   */
  @Test
  @DisplayName("Test getAlarmComments(String, int, int, String, String); when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData AlarmCommentController.getAlarmComments(String, int, int, String, String)"
  })
  void testGetAlarmComments_when42() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange, Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            new AlarmCommentController(
                    new DefaultTbAlarmCommentService(new BaseAlarmCommentService()))
                .getAlarmComments("42", 3, 1, "Sort Property", "asc"));
  }

  /**
   * Test {@link AlarmCommentController#getAlarmComments(String, int, int, String, String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link AlarmCommentController#getAlarmComments(String, int, int, String,
   * String)}
   */
  @Test
  @DisplayName("Test getAlarmComments(String, int, int, String, String); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData AlarmCommentController.getAlarmComments(String, int, int, String, String)"
  })
  void testGetAlarmComments_whenEmptyString() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange, Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            new AlarmCommentController(
                    new DefaultTbAlarmCommentService(new BaseAlarmCommentService()))
                .getAlarmComments("", 3, 1, "Sort Property", "asc"));
  }
}
