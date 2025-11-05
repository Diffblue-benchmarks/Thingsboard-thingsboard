package org.thingsboard.server.controller;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.common.data.queue.Queue;

class QueueControllerDiffblueTest {
  /**
   * Test {@link QueueController#getTenantQueuesByServiceType(String, int, int, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link QueueController#getTenantQueuesByServiceType(String, int, int,
   * String, String, String)}
   */
  @Test
  @DisplayName(
      "Test getTenantQueuesByServiceType(String, int, int, String, String, String); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData QueueController.getTenantQueuesByServiceType(String, int, int, String, String, String)"
  })
  void testGetTenantQueuesByServiceType_thenThrowIllegalArgumentException()
      throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new QueueController(null)
                .getTenantQueuesByServiceType(
                    "Service Type", 3, 1, "Text Search", "Sort Property", "asc"));
  }

  /**
   * Test {@link QueueController#getTenantQueuesByServiceType(String, int, int, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link QueueController#getTenantQueuesByServiceType(String, int, int,
   * String, String, String)}
   */
  @Test
  @DisplayName(
      "Test getTenantQueuesByServiceType(String, int, int, String, String, String); then throw ThingsboardException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData QueueController.getTenantQueuesByServiceType(String, int, int, String, String, String)"
  })
  void testGetTenantQueuesByServiceType_thenThrowThingsboardException()
      throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange, Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            new QueueController(null)
                .getTenantQueuesByServiceType("Service Type", 3, 1, "Text Search", "U", "U"));
  }

  /**
   * Test {@link QueueController#getTenantQueuesByServiceType(String, int, int, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code Sort Property}.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link QueueController#getTenantQueuesByServiceType(String, int, int,
   * String, String, String)}
   */
  @Test
  @DisplayName(
      "Test getTenantQueuesByServiceType(String, int, int, String, String, String); when 'Sort Property'; then throw ThingsboardException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData QueueController.getTenantQueuesByServiceType(String, int, int, String, String, String)"
  })
  void testGetTenantQueuesByServiceType_whenSortProperty_thenThrowThingsboardException()
      throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange, Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            new QueueController(null)
                .getTenantQueuesByServiceType("", 3, 1, "Text Search", "Sort Property", "asc"));
  }

  /**
   * Test {@link QueueController#getQueueById(String)}.
   *
   * <ul>
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link QueueController#getQueueById(String)}
   */
  @Test
  @DisplayName("Test getQueueById(String); then throw ThingsboardException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Queue QueueController.getQueueById(String)"})
  void testGetQueueById_thenThrowThingsboardException() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange, Act and Assert
    assertThrows(ThingsboardException.class, () -> new QueueController(null).getQueueById(""));
  }

  /**
   * Test {@link QueueController#getQueueByName(String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link QueueController#getQueueByName(String)}
   */
  @Test
  @DisplayName("Test getQueueByName(String); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Queue QueueController.getQueueByName(String)"})
  void testGetQueueByName_whenEmptyString() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange, Act and Assert
    assertThrows(ThingsboardException.class, () -> new QueueController(null).getQueueByName(""));
  }

  /**
   * Test {@link QueueController#getQueueByName(String)}.
   *
   * <ul>
   *   <li>When {@code Queue Name}.
   * </ul>
   *
   * <p>Method under test: {@link QueueController#getQueueByName(String)}
   */
  @Test
  @DisplayName("Test getQueueByName(String); when 'Queue Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Queue QueueController.getQueueByName(String)"})
  void testGetQueueByName_whenQueueName() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange, Act and Assert
    assertThrows(
        ThingsboardException.class, () -> new QueueController(null).getQueueByName("Queue Name"));
  }

  /**
   * Test {@link QueueController#saveQueue(Queue, String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link QueueController#saveQueue(Queue, String)}
   */
  @Test
  @DisplayName("Test saveQueue(Queue, String); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Queue QueueController.saveQueue(Queue, String)"})
  void testSaveQueue_whenEmptyString() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    QueueController queueController = new QueueController(null);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> queueController.saveQueue(new Queue(), ""));
  }

  /**
   * Test {@link QueueController#saveQueue(Queue, String)}.
   *
   * <ul>
   *   <li>When {@code Service Type}.
   * </ul>
   *
   * <p>Method under test: {@link QueueController#saveQueue(Queue, String)}
   */
  @Test
  @DisplayName("Test saveQueue(Queue, String); when 'Service Type'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Queue QueueController.saveQueue(Queue, String)"})
  void testSaveQueue_whenServiceType() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    QueueController queueController = new QueueController(null);

    // Act and Assert
    assertThrows(
        ThingsboardException.class, () -> queueController.saveQueue(new Queue(), "Service Type"));
  }

  /**
   * Test {@link QueueController#deleteQueue(String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link QueueController#deleteQueue(String)}
   */
  @Test
  @DisplayName("Test deleteQueue(String); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void QueueController.deleteQueue(String)"})
  void testDeleteQueue_whenEmptyString() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange, Act and Assert
    assertThrows(ThingsboardException.class, () -> new QueueController(null).deleteQueue(""));
  }

  /**
   * Test {@link QueueController#deleteQueue(String)}.
   *
   * <ul>
   *   <li>When {@code Queue Id Str}.
   * </ul>
   *
   * <p>Method under test: {@link QueueController#deleteQueue(String)}
   */
  @Test
  @DisplayName("Test deleteQueue(String); when 'Queue Id Str'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void QueueController.deleteQueue(String)"})
  void testDeleteQueue_whenQueueIdStr() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange, Act and Assert
    assertThrows(
        ThingsboardException.class, () -> new QueueController(null).deleteQueue("Queue Id Str"));
  }
}
