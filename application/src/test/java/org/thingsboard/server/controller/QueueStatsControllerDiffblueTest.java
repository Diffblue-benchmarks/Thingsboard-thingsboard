package org.thingsboard.server.controller;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.dao.queue.BaseQueueStatsService;
import org.thingsboard.server.dao.service.validator.QueueStatsDataValidator;
import org.thingsboard.server.dao.sql.queue.JpaQueueStatsDao;

class QueueStatsControllerDiffblueTest {
  /**
   * Test {@link QueueStatsController#getTenantQueueStats(int, int, String, String, String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link QueueStatsController#getTenantQueueStats(int, int, String, String,
   * String)}
   */
  @Test
  @DisplayName(
      "Test getTenantQueueStats(int, int, String, String, String); when empty string; then throw ThingsboardException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData QueueStatsController.getTenantQueueStats(int, int, String, String, String)"
  })
  void testGetTenantQueueStats_whenEmptyString_thenThrowThingsboardException()
      throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    JpaQueueStatsDao queueStatsDao = new JpaQueueStatsDao();
    BaseQueueStatsService queueStatsService =
        new BaseQueueStatsService(queueStatsDao, new QueueStatsDataValidator());

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            new QueueStatsController(queueStatsService)
                .getTenantQueueStats(3, 1, "Text Search", "", "asc"));
  }

  /**
   * Test {@link QueueStatsController#getTenantQueueStats(int, int, String, String, String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link QueueStatsController#getTenantQueueStats(int, int, String, String,
   * String)}
   */
  @Test
  @DisplayName(
      "Test getTenantQueueStats(int, int, String, String, String); when empty string; then throw ThingsboardException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData QueueStatsController.getTenantQueueStats(int, int, String, String, String)"
  })
  void testGetTenantQueueStats_whenEmptyString_thenThrowThingsboardException2()
      throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    JpaQueueStatsDao queueStatsDao = new JpaQueueStatsDao();
    BaseQueueStatsService queueStatsService =
        new BaseQueueStatsService(queueStatsDao, new QueueStatsDataValidator());

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            new QueueStatsController(queueStatsService)
                .getTenantQueueStats(3, 1, "Text Search", "U", ""));
  }

  /**
   * Test {@link QueueStatsController#getTenantQueueStats(int, int, String, String, String)}.
   *
   * <ul>
   *   <li>When {@code Sort Property}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link QueueStatsController#getTenantQueueStats(int, int, String, String,
   * String)}
   */
  @Test
  @DisplayName(
      "Test getTenantQueueStats(int, int, String, String, String); when 'Sort Property'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData QueueStatsController.getTenantQueueStats(int, int, String, String, String)"
  })
  void testGetTenantQueueStats_whenSortProperty_thenThrowIllegalArgumentException()
      throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    JpaQueueStatsDao queueStatsDao = new JpaQueueStatsDao();
    BaseQueueStatsService queueStatsService =
        new BaseQueueStatsService(queueStatsDao, new QueueStatsDataValidator());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new QueueStatsController(queueStatsService)
                .getTenantQueueStats(3, 1, "Text Search", "Sort Property", "asc"));
  }

  /**
   * Test {@link QueueStatsController#getTenantQueueStats(int, int, String, String, String)}.
   *
   * <ul>
   *   <li>When {@code U}.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link QueueStatsController#getTenantQueueStats(int, int, String, String,
   * String)}
   */
  @Test
  @DisplayName(
      "Test getTenantQueueStats(int, int, String, String, String); when 'U'; then throw ThingsboardException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData QueueStatsController.getTenantQueueStats(int, int, String, String, String)"
  })
  void testGetTenantQueueStats_whenU_thenThrowThingsboardException() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    JpaQueueStatsDao queueStatsDao = new JpaQueueStatsDao();
    BaseQueueStatsService queueStatsService =
        new BaseQueueStatsService(queueStatsDao, new QueueStatsDataValidator());

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            new QueueStatsController(queueStatsService)
                .getTenantQueueStats(3, 1, "Text Search", "U", "asc"));
  }

  /**
   * Test {@link QueueStatsController#getTenantQueueStats(int, int, String, String, String)}.
   *
   * <ul>
   *   <li>When {@code U}.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link QueueStatsController#getTenantQueueStats(int, int, String, String,
   * String)}
   */
  @Test
  @DisplayName(
      "Test getTenantQueueStats(int, int, String, String, String); when 'U'; then throw ThingsboardException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData QueueStatsController.getTenantQueueStats(int, int, String, String, String)"
  })
  void testGetTenantQueueStats_whenU_thenThrowThingsboardException2() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    JpaQueueStatsDao queueStatsDao = new JpaQueueStatsDao();
    BaseQueueStatsService queueStatsService =
        new BaseQueueStatsService(queueStatsDao, new QueueStatsDataValidator());

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            new QueueStatsController(queueStatsService)
                .getTenantQueueStats(3, 1, "Text Search", "U", "U"));
  }

  /**
   * Test {@link QueueStatsController#getQueueStatsById(String)}.
   *
   * <ul>
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link QueueStatsController#getQueueStatsById(String)}
   */
  @Test
  @DisplayName("Test getQueueStatsById(String); then throw ThingsboardException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.queue.QueueStats QueueStatsController.getQueueStatsById(String)"
  })
  void testGetQueueStatsById_thenThrowThingsboardException() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    JpaQueueStatsDao queueStatsDao = new JpaQueueStatsDao();
    BaseQueueStatsService queueStatsService =
        new BaseQueueStatsService(queueStatsDao, new QueueStatsDataValidator());

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> new QueueStatsController(queueStatsService).getQueueStatsById(""));
  }

  /**
   * Test {@link QueueStatsController#getQueueStatsByIds(String[])}.
   *
   * <ul>
   *   <li>When array of {@link String} with empty string.
   * </ul>
   *
   * <p>Method under test: {@link QueueStatsController#getQueueStatsByIds(String[])}
   */
  @Test
  @DisplayName("Test getQueueStatsByIds(String[]); when array of String with empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List QueueStatsController.getQueueStatsByIds(String[])"})
  void testGetQueueStatsByIds_whenArrayOfStringWithEmptyString() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    JpaQueueStatsDao queueStatsDao = new JpaQueueStatsDao();
    BaseQueueStatsService queueStatsService =
        new BaseQueueStatsService(queueStatsDao, new QueueStatsDataValidator());

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> new QueueStatsController(queueStatsService).getQueueStatsByIds(new String[] {""}));
  }

  /**
   * Test {@link QueueStatsController#getQueueStatsByIds(String[])}.
   *
   * <ul>
   *   <li>When array of {@link String} with {@code Str Queue Stats Ids}.
   * </ul>
   *
   * <p>Method under test: {@link QueueStatsController#getQueueStatsByIds(String[])}
   */
  @Test
  @DisplayName("Test getQueueStatsByIds(String[]); when array of String with 'Str Queue Stats Ids'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List QueueStatsController.getQueueStatsByIds(String[])"})
  void testGetQueueStatsByIds_whenArrayOfStringWithStrQueueStatsIds() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    JpaQueueStatsDao queueStatsDao = new JpaQueueStatsDao();
    BaseQueueStatsService queueStatsService =
        new BaseQueueStatsService(queueStatsDao, new QueueStatsDataValidator());

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            new QueueStatsController(queueStatsService)
                .getQueueStatsByIds(new String[] {"Str Queue Stats Ids"}));
  }

  /**
   * Test {@link QueueStatsController#getQueueStatsByIds(String[])}.
   *
   * <ul>
   *   <li>When empty array of {@link String}.
   * </ul>
   *
   * <p>Method under test: {@link QueueStatsController#getQueueStatsByIds(String[])}
   */
  @Test
  @DisplayName("Test getQueueStatsByIds(String[]); when empty array of String")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List QueueStatsController.getQueueStatsByIds(String[])"})
  void testGetQueueStatsByIds_whenEmptyArrayOfString() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    JpaQueueStatsDao queueStatsDao = new JpaQueueStatsDao();
    BaseQueueStatsService queueStatsService =
        new BaseQueueStatsService(queueStatsDao, new QueueStatsDataValidator());

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> new QueueStatsController(queueStatsService).getQueueStatsByIds(new String[] {}));
  }
}
