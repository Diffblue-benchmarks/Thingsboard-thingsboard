package org.thingsboard.server.controller;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.concurrent.ExecutionException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.thingsboard.server.common.data.alarm.Alarm;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.dao.alarm.BaseAlarmCommentService;
import org.thingsboard.server.exception.ThingsboardErrorResponseHandler;
import org.thingsboard.server.service.entitiy.alarm.DefaultTbAlarmCommentService;
import org.thingsboard.server.service.entitiy.alarm.DefaultTbAlarmService;

@ExtendWith(MockitoExtension.class)
class AlarmControllerDiffblueTest {
  @InjectMocks private AlarmController alarmController;

  @Mock private ThingsboardErrorResponseHandler thingsboardErrorResponseHandler;

  /**
   * Test {@link AlarmController#getAlarmById(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmController#getAlarmById(String)}
   */
  @Test
  @DisplayName("Test getAlarmById(String); when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm AlarmController.getAlarmById(String)"})
  void testGetAlarmById_when42() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTbAlarmService tbAlarmService =
        new DefaultTbAlarmService(new DefaultTbAlarmCommentService(new BaseAlarmCommentService()));

    // Act and Assert
    assertThrows(
        ThingsboardException.class, () -> new AlarmController(tbAlarmService).getAlarmById("42"));
  }

  /**
   * Test {@link AlarmController#getAlarmById(String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link AlarmController#getAlarmById(String)}
   */
  @Test
  @DisplayName("Test getAlarmById(String); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm AlarmController.getAlarmById(String)"})
  void testGetAlarmById_whenEmptyString() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTbAlarmService tbAlarmService =
        new DefaultTbAlarmService(new DefaultTbAlarmCommentService(new BaseAlarmCommentService()));

    // Act and Assert
    assertThrows(
        ThingsboardException.class, () -> new AlarmController(tbAlarmService).getAlarmById(""));
  }

  /**
   * Test {@link AlarmController#getAlarmInfoById(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmController#getAlarmInfoById(String)}
   */
  @Test
  @DisplayName("Test getAlarmInfoById(String); when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AlarmInfo AlarmController.getAlarmInfoById(String)"})
  void testGetAlarmInfoById_when42() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTbAlarmService tbAlarmService =
        new DefaultTbAlarmService(new DefaultTbAlarmCommentService(new BaseAlarmCommentService()));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> new AlarmController(tbAlarmService).getAlarmInfoById("42"));
  }

  /**
   * Test {@link AlarmController#getAlarmInfoById(String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link AlarmController#getAlarmInfoById(String)}
   */
  @Test
  @DisplayName("Test getAlarmInfoById(String); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AlarmInfo AlarmController.getAlarmInfoById(String)"})
  void testGetAlarmInfoById_whenEmptyString() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTbAlarmService tbAlarmService =
        new DefaultTbAlarmService(new DefaultTbAlarmCommentService(new BaseAlarmCommentService()));

    // Act and Assert
    assertThrows(
        ThingsboardException.class, () -> new AlarmController(tbAlarmService).getAlarmInfoById(""));
  }

  /**
   * Test {@link AlarmController#saveAlarm(Alarm)}.
   *
   * <p>Method under test: {@link AlarmController#saveAlarm(Alarm)}
   */
  @Test
  @DisplayName("Test saveAlarm(Alarm)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm AlarmController.saveAlarm(Alarm)"})
  void testSaveAlarm() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTbAlarmService tbAlarmService =
        new DefaultTbAlarmService(new DefaultTbAlarmCommentService(new BaseAlarmCommentService()));
    AlarmController alarmController = new AlarmController(tbAlarmService);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> alarmController.saveAlarm(new Alarm()));
  }

  /**
   * Test {@link AlarmController#deleteAlarm(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmController#deleteAlarm(String)}
   */
  @Test
  @DisplayName("Test deleteAlarm(String); when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean AlarmController.deleteAlarm(String)"})
  void testDeleteAlarm_when42() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTbAlarmService tbAlarmService =
        new DefaultTbAlarmService(new DefaultTbAlarmCommentService(new BaseAlarmCommentService()));

    // Act and Assert
    assertThrows(
        ThingsboardException.class, () -> new AlarmController(tbAlarmService).deleteAlarm("42"));
  }

  /**
   * Test {@link AlarmController#deleteAlarm(String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link AlarmController#deleteAlarm(String)}
   */
  @Test
  @DisplayName("Test deleteAlarm(String); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean AlarmController.deleteAlarm(String)"})
  void testDeleteAlarm_whenEmptyString() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTbAlarmService tbAlarmService =
        new DefaultTbAlarmService(new DefaultTbAlarmCommentService(new BaseAlarmCommentService()));

    // Act and Assert
    assertThrows(
        ThingsboardException.class, () -> new AlarmController(tbAlarmService).deleteAlarm(""));
  }

  /**
   * Test {@link AlarmController#ackAlarm(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmController#ackAlarm(String)}
   */
  @Test
  @DisplayName("Test ackAlarm(String); when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AlarmInfo AlarmController.ackAlarm(String)"})
  void testAckAlarm_when42() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTbAlarmService tbAlarmService =
        new DefaultTbAlarmService(new DefaultTbAlarmCommentService(new BaseAlarmCommentService()));

    // Act and Assert
    assertThrows(
        ThingsboardException.class, () -> new AlarmController(tbAlarmService).ackAlarm("42"));
  }

  /**
   * Test {@link AlarmController#ackAlarm(String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link AlarmController#ackAlarm(String)}
   */
  @Test
  @DisplayName("Test ackAlarm(String); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AlarmInfo AlarmController.ackAlarm(String)"})
  void testAckAlarm_whenEmptyString() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTbAlarmService tbAlarmService =
        new DefaultTbAlarmService(new DefaultTbAlarmCommentService(new BaseAlarmCommentService()));

    // Act and Assert
    assertThrows(
        ThingsboardException.class, () -> new AlarmController(tbAlarmService).ackAlarm(""));
  }

  /**
   * Test {@link AlarmController#clearAlarm(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmController#clearAlarm(String)}
   */
  @Test
  @DisplayName("Test clearAlarm(String); when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AlarmInfo AlarmController.clearAlarm(String)"})
  void testClearAlarm_when42() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTbAlarmService tbAlarmService =
        new DefaultTbAlarmService(new DefaultTbAlarmCommentService(new BaseAlarmCommentService()));

    // Act and Assert
    assertThrows(
        ThingsboardException.class, () -> new AlarmController(tbAlarmService).clearAlarm("42"));
  }

  /**
   * Test {@link AlarmController#clearAlarm(String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link AlarmController#clearAlarm(String)}
   */
  @Test
  @DisplayName("Test clearAlarm(String); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AlarmInfo AlarmController.clearAlarm(String)"})
  void testClearAlarm_whenEmptyString() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTbAlarmService tbAlarmService =
        new DefaultTbAlarmService(new DefaultTbAlarmCommentService(new BaseAlarmCommentService()));

    // Act and Assert
    assertThrows(
        ThingsboardException.class, () -> new AlarmController(tbAlarmService).clearAlarm(""));
  }

  /**
   * Test {@link AlarmController#assignAlarm(String, String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmController#assignAlarm(String, String)}
   */
  @Test
  @DisplayName("Test assignAlarm(String, String); when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm AlarmController.assignAlarm(String, String)"})
  void testAssignAlarm_when42() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTbAlarmService tbAlarmService =
        new DefaultTbAlarmService(new DefaultTbAlarmCommentService(new BaseAlarmCommentService()));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> new AlarmController(tbAlarmService).assignAlarm("42", "42"));
  }

  /**
   * Test {@link AlarmController#assignAlarm(String, String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link AlarmController#assignAlarm(String, String)}
   */
  @Test
  @DisplayName("Test assignAlarm(String, String); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm AlarmController.assignAlarm(String, String)"})
  void testAssignAlarm_whenEmptyString() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTbAlarmService tbAlarmService =
        new DefaultTbAlarmService(new DefaultTbAlarmCommentService(new BaseAlarmCommentService()));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> new AlarmController(tbAlarmService).assignAlarm("", "42"));
  }

  /**
   * Test {@link AlarmController#assignAlarm(String, String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link AlarmController#assignAlarm(String, String)}
   */
  @Test
  @DisplayName("Test assignAlarm(String, String); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm AlarmController.assignAlarm(String, String)"})
  void testAssignAlarm_whenEmptyString2() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTbAlarmService tbAlarmService =
        new DefaultTbAlarmService(new DefaultTbAlarmCommentService(new BaseAlarmCommentService()));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> new AlarmController(tbAlarmService).assignAlarm("42", ""));
  }

  /**
   * Test {@link AlarmController#unassignAlarm(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmController#unassignAlarm(String)}
   */
  @Test
  @DisplayName("Test unassignAlarm(String); when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm AlarmController.unassignAlarm(String)"})
  void testUnassignAlarm_when42() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTbAlarmService tbAlarmService =
        new DefaultTbAlarmService(new DefaultTbAlarmCommentService(new BaseAlarmCommentService()));

    // Act and Assert
    assertThrows(
        ThingsboardException.class, () -> new AlarmController(tbAlarmService).unassignAlarm("42"));
  }

  /**
   * Test {@link AlarmController#unassignAlarm(String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link AlarmController#unassignAlarm(String)}
   */
  @Test
  @DisplayName("Test unassignAlarm(String); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm AlarmController.unassignAlarm(String)"})
  void testUnassignAlarm_whenEmptyString() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTbAlarmService tbAlarmService =
        new DefaultTbAlarmService(new DefaultTbAlarmCommentService(new BaseAlarmCommentService()));

    // Act and Assert
    assertThrows(
        ThingsboardException.class, () -> new AlarmController(tbAlarmService).unassignAlarm(""));
  }

  /**
   * Test {@link AlarmController#getAlarms(String, String, String, String, String, int, int, String,
   * String, String, Long, Long, Boolean)}.
   *
   * <ul>
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmController#getAlarms(String, String, String, String, String,
   * int, int, String, String, String, Long, Long, Boolean)}
   */
  @Test
  @DisplayName(
      "Test getAlarms(String, String, String, String, String, int, int, String, String, String, Long, Long, Boolean); then throw ThingsboardException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData AlarmController.getAlarms(String, String, String, String, String, int, int, String, String, String, Long, Long, Boolean)"
  })
  void testGetAlarms_thenThrowThingsboardException()
      throws InterruptedException, ExecutionException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTbAlarmService tbAlarmService =
        new DefaultTbAlarmService(new DefaultTbAlarmCommentService(new BaseAlarmCommentService()));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            new AlarmController(tbAlarmService)
                .getAlarms(
                    "",
                    "42",
                    "Search Status",
                    "Status",
                    "42",
                    3,
                    1,
                    "Text Search",
                    "Sort Property",
                    "asc",
                    1L,
                    1L,
                    true));
  }

  /**
   * Test {@link AlarmController#getAlarms(String, String, String, String, String, int, int, String,
   * String, String, Long, Long, Boolean)}.
   *
   * <ul>
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmController#getAlarms(String, String, String, String, String,
   * int, int, String, String, String, Long, Long, Boolean)}
   */
  @Test
  @DisplayName(
      "Test getAlarms(String, String, String, String, String, int, int, String, String, String, Long, Long, Boolean); then throw ThingsboardException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData AlarmController.getAlarms(String, String, String, String, String, int, int, String, String, String, Long, Long, Boolean)"
  })
  void testGetAlarms_thenThrowThingsboardException2()
      throws InterruptedException, ExecutionException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTbAlarmService tbAlarmService =
        new DefaultTbAlarmService(new DefaultTbAlarmCommentService(new BaseAlarmCommentService()));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            new AlarmController(tbAlarmService)
                .getAlarms(
                    "Str Entity Type",
                    "",
                    "Search Status",
                    "Status",
                    "42",
                    3,
                    1,
                    "Text Search",
                    "Sort Property",
                    "asc",
                    1L,
                    1L,
                    true));
  }

  /**
   * Test {@link AlarmController#getAllAlarms(String, String, String, int, int, String, String,
   * String, Long, Long, Boolean)}.
   *
   * <ul>
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmController#getAllAlarms(String, String, String, int, int,
   * String, String, String, Long, Long, Boolean)}
   */
  @Test
  @DisplayName(
      "Test getAllAlarms(String, String, String, int, int, String, String, String, Long, Long, Boolean); then throw ThingsboardException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData AlarmController.getAllAlarms(String, String, String, int, int, String, String, String, Long, Long, Boolean)"
  })
  void testGetAllAlarms_thenThrowThingsboardException()
      throws InterruptedException, ExecutionException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTbAlarmService tbAlarmService =
        new DefaultTbAlarmService(new DefaultTbAlarmCommentService(new BaseAlarmCommentService()));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            new AlarmController(tbAlarmService)
                .getAllAlarms("", "", null, 3, 1, "Text Search", null, "asc", 1L, 1L, true));
  }

  /**
   * Test {@link AlarmController#getAllAlarms(String, String, String, int, int, String, String,
   * String, Long, Long, Boolean)}.
   *
   * <ul>
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmController#getAllAlarms(String, String, String, int, int,
   * String, String, String, Long, Long, Boolean)}
   */
  @Test
  @DisplayName(
      "Test getAllAlarms(String, String, String, int, int, String, String, String, Long, Long, Boolean); then throw ThingsboardException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData AlarmController.getAllAlarms(String, String, String, int, int, String, String, String, Long, Long, Boolean)"
  })
  void testGetAllAlarms_thenThrowThingsboardException2()
      throws InterruptedException, ExecutionException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTbAlarmService tbAlarmService =
        new DefaultTbAlarmService(new DefaultTbAlarmCommentService(new BaseAlarmCommentService()));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            new AlarmController(tbAlarmService)
                .getAllAlarms("", "", null, 3, 1, "Text Search", "", "asc", 1L, 1L, true));
  }

  /**
   * Test {@link AlarmController#getAllAlarms(String, String, String, int, int, String, String,
   * String, Long, Long, Boolean)}.
   *
   * <ul>
   *   <li>When {@code Sort Property}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmController#getAllAlarms(String, String, String, int, int,
   * String, String, String, Long, Long, Boolean)}
   */
  @Test
  @DisplayName(
      "Test getAllAlarms(String, String, String, int, int, String, String, String, Long, Long, Boolean); when 'Sort Property'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData AlarmController.getAllAlarms(String, String, String, int, int, String, String, String, Long, Long, Boolean)"
  })
  void testGetAllAlarms_whenSortProperty_thenThrowIllegalArgumentException()
      throws InterruptedException, ExecutionException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTbAlarmService tbAlarmService =
        new DefaultTbAlarmService(new DefaultTbAlarmCommentService(new BaseAlarmCommentService()));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new AlarmController(tbAlarmService)
                .getAllAlarms(
                    "", "", null, 3, 1, "Text Search", "Sort Property", "asc", 1L, 1L, true));
  }

  /**
   * Test {@link AlarmController#getAllAlarms(String, String, String, int, int, String, String,
   * String, Long, Long, Boolean)}.
   *
   * <ul>
   *   <li>When {@code U}.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmController#getAllAlarms(String, String, String, int, int,
   * String, String, String, Long, Long, Boolean)}
   */
  @Test
  @DisplayName(
      "Test getAllAlarms(String, String, String, int, int, String, String, String, Long, Long, Boolean); when 'U'; then throw ThingsboardException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData AlarmController.getAllAlarms(String, String, String, int, int, String, String, String, Long, Long, Boolean)"
  })
  void testGetAllAlarms_whenU_thenThrowThingsboardException()
      throws InterruptedException, ExecutionException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTbAlarmService tbAlarmService =
        new DefaultTbAlarmService(new DefaultTbAlarmCommentService(new BaseAlarmCommentService()));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            new AlarmController(tbAlarmService)
                .getAllAlarms("", "", null, 3, 1, "Text Search", "U", "asc", 1L, 1L, true));
  }

  /**
   * Test {@link AlarmController#getAllAlarms(String, String, String, int, int, String, String,
   * String, Long, Long, Boolean)}.
   *
   * <ul>
   *   <li>When {@code U}.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmController#getAllAlarms(String, String, String, int, int,
   * String, String, String, Long, Long, Boolean)}
   */
  @Test
  @DisplayName(
      "Test getAllAlarms(String, String, String, int, int, String, String, String, Long, Long, Boolean); when 'U'; then throw ThingsboardException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData AlarmController.getAllAlarms(String, String, String, int, int, String, String, String, Long, Long, Boolean)"
  })
  void testGetAllAlarms_whenU_thenThrowThingsboardException2()
      throws InterruptedException, ExecutionException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTbAlarmService tbAlarmService =
        new DefaultTbAlarmService(new DefaultTbAlarmCommentService(new BaseAlarmCommentService()));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            new AlarmController(tbAlarmService)
                .getAllAlarms("", "", null, 3, 1, "Text Search", "U", "U", 1L, 1L, true));
  }

  /**
   * Test {@link AlarmController#getAllAlarms(String, String, String, int, int, String, String,
   * String, Long, Long, Boolean)}.
   *
   * <ul>
   *   <li>When {@code U}.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmController#getAllAlarms(String, String, String, int, int,
   * String, String, String, Long, Long, Boolean)}
   */
  @Test
  @DisplayName(
      "Test getAllAlarms(String, String, String, int, int, String, String, String, Long, Long, Boolean); when 'U'; then throw ThingsboardException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData AlarmController.getAllAlarms(String, String, String, int, int, String, String, String, Long, Long, Boolean)"
  })
  void testGetAllAlarms_whenU_thenThrowThingsboardException3()
      throws InterruptedException, ExecutionException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTbAlarmService tbAlarmService =
        new DefaultTbAlarmService(new DefaultTbAlarmCommentService(new BaseAlarmCommentService()));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            new AlarmController(tbAlarmService)
                .getAllAlarms("", "", null, 3, 1, "Text Search", "U", null, 1L, 1L, true));
  }

  /**
   * Test {@link AlarmController#getAlarmsV2(String, String, String[], String[], String[], String,
   * int, int, String, String, String, Long, Long)}.
   *
   * <ul>
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmController#getAlarmsV2(String, String, String[], String[],
   * String[], String, int, int, String, String, String, Long, Long)}
   */
  @Test
  @DisplayName(
      "Test getAlarmsV2(String, String, String[], String[], String[], String, int, int, String, String, String, Long, Long); then throw ThingsboardException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData AlarmController.getAlarmsV2(String, String, String[], String[], String[], String, int, int, String, String, String, Long, Long)"
  })
  void testGetAlarmsV2_thenThrowThingsboardException()
      throws InterruptedException, ExecutionException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTbAlarmService tbAlarmService =
        new DefaultTbAlarmService(new DefaultTbAlarmCommentService(new BaseAlarmCommentService()));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            new AlarmController(tbAlarmService)
                .getAlarmsV2(
                    "",
                    "42",
                    new String[] {"Status List"},
                    new String[] {"S1"},
                    new String[] {"Type List"},
                    "42",
                    3,
                    1,
                    "Text Search",
                    "Sort Property",
                    "asc",
                    1L,
                    1L));
  }

  /**
   * Test {@link AlarmController#getAlarmsV2(String, String, String[], String[], String[], String,
   * int, int, String, String, String, Long, Long)}.
   *
   * <ul>
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmController#getAlarmsV2(String, String, String[], String[],
   * String[], String, int, int, String, String, String, Long, Long)}
   */
  @Test
  @DisplayName(
      "Test getAlarmsV2(String, String, String[], String[], String[], String, int, int, String, String, String, Long, Long); then throw ThingsboardException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData AlarmController.getAlarmsV2(String, String, String[], String[], String[], String, int, int, String, String, String, Long, Long)"
  })
  void testGetAlarmsV2_thenThrowThingsboardException2()
      throws InterruptedException, ExecutionException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTbAlarmService tbAlarmService =
        new DefaultTbAlarmService(new DefaultTbAlarmCommentService(new BaseAlarmCommentService()));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            new AlarmController(tbAlarmService)
                .getAlarmsV2(
                    "Str Entity Type",
                    "",
                    new String[] {"Status List"},
                    new String[] {"S1"},
                    new String[] {"Type List"},
                    "42",
                    3,
                    1,
                    "Text Search",
                    "Sort Property",
                    "asc",
                    1L,
                    1L));
  }

  /**
   * Test {@link AlarmController#getAllAlarmsV2(String[], String[], String[], String, int, int,
   * String, String, String, Long, Long)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmController#getAllAlarmsV2(String[], String[], String[],
   * String, int, int, String, String, String, Long, Long)}
   */
  @Test
  @DisplayName(
      "Test getAllAlarmsV2(String[], String[], String[], String, int, int, String, String, String, Long, Long); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData AlarmController.getAllAlarmsV2(String[], String[], String[], String, int, int, String, String, String, Long, Long)"
  })
  void testGetAllAlarmsV2_thenThrowIllegalArgumentException()
      throws InterruptedException, ExecutionException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTbAlarmService tbAlarmService =
        new DefaultTbAlarmService(new DefaultTbAlarmCommentService(new BaseAlarmCommentService()));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new AlarmController(tbAlarmService)
                .getAllAlarmsV2(
                    null,
                    null,
                    new String[] {"Type List"},
                    null,
                    3,
                    1,
                    "Text Search",
                    "Sort Property",
                    "asc",
                    1L,
                    1L));
  }

  /**
   * Test {@link AlarmController#getAllAlarmsV2(String[], String[], String[], String, int, int,
   * String, String, String, Long, Long)}.
   *
   * <ul>
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmController#getAllAlarmsV2(String[], String[], String[],
   * String, int, int, String, String, String, Long, Long)}
   */
  @Test
  @DisplayName(
      "Test getAllAlarmsV2(String[], String[], String[], String, int, int, String, String, String, Long, Long); then throw ThingsboardException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData AlarmController.getAllAlarmsV2(String[], String[], String[], String, int, int, String, String, String, Long, Long)"
  })
  void testGetAllAlarmsV2_thenThrowThingsboardException()
      throws InterruptedException, ExecutionException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTbAlarmService tbAlarmService =
        new DefaultTbAlarmService(new DefaultTbAlarmCommentService(new BaseAlarmCommentService()));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            new AlarmController(tbAlarmService)
                .getAllAlarmsV2(
                    null,
                    null,
                    new String[] {"Type List"},
                    null,
                    3,
                    1,
                    "Text Search",
                    null,
                    "asc",
                    1L,
                    1L));
  }

  /**
   * Test {@link AlarmController#getAllAlarmsV2(String[], String[], String[], String, int, int,
   * String, String, String, Long, Long)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmController#getAllAlarmsV2(String[], String[], String[],
   * String, int, int, String, String, String, Long, Long)}
   */
  @Test
  @DisplayName(
      "Test getAllAlarmsV2(String[], String[], String[], String, int, int, String, String, String, Long, Long); when empty string; then throw ThingsboardException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData AlarmController.getAllAlarmsV2(String[], String[], String[], String, int, int, String, String, String, Long, Long)"
  })
  void testGetAllAlarmsV2_whenEmptyString_thenThrowThingsboardException()
      throws InterruptedException, ExecutionException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTbAlarmService tbAlarmService =
        new DefaultTbAlarmService(new DefaultTbAlarmCommentService(new BaseAlarmCommentService()));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            new AlarmController(tbAlarmService)
                .getAllAlarmsV2(
                    null,
                    null,
                    new String[] {"Type List"},
                    null,
                    3,
                    1,
                    "Text Search",
                    "",
                    "asc",
                    1L,
                    1L));
  }

  /**
   * Test {@link AlarmController#getAllAlarmsV2(String[], String[], String[], String, int, int,
   * String, String, String, Long, Long)}.
   *
   * <ul>
   *   <li>When {@code U}.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmController#getAllAlarmsV2(String[], String[], String[],
   * String, int, int, String, String, String, Long, Long)}
   */
  @Test
  @DisplayName(
      "Test getAllAlarmsV2(String[], String[], String[], String, int, int, String, String, String, Long, Long); when 'U'; then throw ThingsboardException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData AlarmController.getAllAlarmsV2(String[], String[], String[], String, int, int, String, String, String, Long, Long)"
  })
  void testGetAllAlarmsV2_whenU_thenThrowThingsboardException()
      throws InterruptedException, ExecutionException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTbAlarmService tbAlarmService =
        new DefaultTbAlarmService(new DefaultTbAlarmCommentService(new BaseAlarmCommentService()));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            new AlarmController(tbAlarmService)
                .getAllAlarmsV2(
                    null,
                    null,
                    new String[] {"Type List"},
                    null,
                    3,
                    1,
                    "Text Search",
                    "U",
                    "asc",
                    1L,
                    1L));
  }

  /**
   * Test {@link AlarmController#getAllAlarmsV2(String[], String[], String[], String, int, int,
   * String, String, String, Long, Long)}.
   *
   * <ul>
   *   <li>When {@code U}.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmController#getAllAlarmsV2(String[], String[], String[],
   * String, int, int, String, String, String, Long, Long)}
   */
  @Test
  @DisplayName(
      "Test getAllAlarmsV2(String[], String[], String[], String, int, int, String, String, String, Long, Long); when 'U'; then throw ThingsboardException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData AlarmController.getAllAlarmsV2(String[], String[], String[], String, int, int, String, String, String, Long, Long)"
  })
  void testGetAllAlarmsV2_whenU_thenThrowThingsboardException2()
      throws InterruptedException, ExecutionException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTbAlarmService tbAlarmService =
        new DefaultTbAlarmService(new DefaultTbAlarmCommentService(new BaseAlarmCommentService()));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            new AlarmController(tbAlarmService)
                .getAllAlarmsV2(
                    null,
                    null,
                    new String[] {"Type List"},
                    null,
                    3,
                    1,
                    "Text Search",
                    "U",
                    "U",
                    1L,
                    1L));
  }

  /**
   * Test {@link AlarmController#getAllAlarmsV2(String[], String[], String[], String, int, int,
   * String, String, String, Long, Long)}.
   *
   * <ul>
   *   <li>When {@code U}.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmController#getAllAlarmsV2(String[], String[], String[],
   * String, int, int, String, String, String, Long, Long)}
   */
  @Test
  @DisplayName(
      "Test getAllAlarmsV2(String[], String[], String[], String, int, int, String, String, String, Long, Long); when 'U'; then throw ThingsboardException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData AlarmController.getAllAlarmsV2(String[], String[], String[], String, int, int, String, String, String, Long, Long)"
  })
  void testGetAllAlarmsV2_whenU_thenThrowThingsboardException3()
      throws InterruptedException, ExecutionException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTbAlarmService tbAlarmService =
        new DefaultTbAlarmService(new DefaultTbAlarmCommentService(new BaseAlarmCommentService()));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            new AlarmController(tbAlarmService)
                .getAllAlarmsV2(
                    null,
                    null,
                    new String[] {"Type List"},
                    null,
                    3,
                    1,
                    "Text Search",
                    "U",
                    null,
                    1L,
                    1L));
  }

  /**
   * Test {@link AlarmController#getHighestAlarmSeverity(String, String, String, String, String)}.
   *
   * <p>Method under test: {@link AlarmController#getHighestAlarmSeverity(String, String, String,
   * String, String)}
   */
  @Test
  @DisplayName("Test getHighestAlarmSeverity(String, String, String, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AlarmSeverity AlarmController.getHighestAlarmSeverity(String, String, String, String, String)"
  })
  void testGetHighestAlarmSeverity() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get(
            "/api/alarm/highestSeverity/{entityType}/{entityId}", "Entity Type", "");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(alarmController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().is(400));
  }

  /**
   * Test {@link AlarmController#getAlarmTypes(int, int, String, String)}.
   *
   * <ul>
   *   <li>When {@code asc}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmController#getAlarmTypes(int, int, String, String)}
   */
  @Test
  @DisplayName("Test getAlarmTypes(int, int, String, String); when 'asc'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData AlarmController.getAlarmTypes(int, int, String, String)"
  })
  void testGetAlarmTypes_whenAsc()
      throws InterruptedException, ExecutionException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTbAlarmService tbAlarmService =
        new DefaultTbAlarmService(new DefaultTbAlarmCommentService(new BaseAlarmCommentService()));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> new AlarmController(tbAlarmService).getAlarmTypes(3, 1, "Text Search", "asc"));
  }

  /**
   * Test {@link AlarmController#getAlarmTypes(int, int, String, String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link AlarmController#getAlarmTypes(int, int, String, String)}
   */
  @Test
  @DisplayName("Test getAlarmTypes(int, int, String, String); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData AlarmController.getAlarmTypes(int, int, String, String)"
  })
  void testGetAlarmTypes_whenEmptyString()
      throws InterruptedException, ExecutionException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTbAlarmService tbAlarmService =
        new DefaultTbAlarmService(new DefaultTbAlarmCommentService(new BaseAlarmCommentService()));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> new AlarmController(tbAlarmService).getAlarmTypes(3, 1, "Text Search", ""));
  }

  /**
   * Test {@link AlarmController#getAlarmTypes(int, int, String, String)}.
   *
   * <ul>
   *   <li>When {@code U}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmController#getAlarmTypes(int, int, String, String)}
   */
  @Test
  @DisplayName("Test getAlarmTypes(int, int, String, String); when 'U'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData AlarmController.getAlarmTypes(int, int, String, String)"
  })
  void testGetAlarmTypes_whenU()
      throws InterruptedException, ExecutionException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTbAlarmService tbAlarmService =
        new DefaultTbAlarmService(new DefaultTbAlarmCommentService(new BaseAlarmCommentService()));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> new AlarmController(tbAlarmService).getAlarmTypes(3, 1, "Text Search", "U"));
  }
}
