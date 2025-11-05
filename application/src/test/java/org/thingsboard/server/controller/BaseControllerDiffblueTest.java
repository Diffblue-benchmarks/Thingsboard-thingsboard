package org.thingsboard.server.controller;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpResponseException;
import com.google.api.client.http.HttpResponseException.Builder;
import java.sql.SQLException;
import java.util.UUID;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.thingsboard.server.common.data.exception.EntityVersionMismatchException;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.common.data.id.AlarmCommentId;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.exception.IncorrectParameterException;

class BaseControllerDiffblueTest {
  /**
   * Test {@link BaseController#checkAlarmCommentId(AlarmCommentId, AlarmId)}.
   *
   * <p>Method under test: {@link BaseController#checkAlarmCommentId(AlarmCommentId, AlarmId)}
   */
  @Test
  @DisplayName("Test checkAlarmCommentId(AlarmCommentId, AlarmId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.alarm.AlarmComment BaseController.checkAlarmCommentId(AlarmCommentId, AlarmId)"
  })
  void testCheckAlarmCommentId() throws ThingsboardException {
    // Arrange
    AuditLogController auditLogController = new AuditLogController();

    AlarmCommentId alarmCommentId = mock(AlarmCommentId.class);
    when(alarmCommentId.getId()).thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> auditLogController.checkAlarmCommentId(alarmCommentId, null));
    verify(alarmCommentId).getId();
  }

  /**
   * Test {@link BaseController#checkAlarmCommentId(AlarmCommentId, AlarmId)}.
   *
   * <p>Method under test: {@link BaseController#checkAlarmCommentId(AlarmCommentId, AlarmId)}
   */
  @Test
  @DisplayName("Test checkAlarmCommentId(AlarmCommentId, AlarmId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.alarm.AlarmComment BaseController.checkAlarmCommentId(AlarmCommentId, AlarmId)"
  })
  void testCheckAlarmCommentId2() throws ThingsboardException {
    // Arrange
    AuditLogController auditLogController = new AuditLogController();

    AlarmCommentId alarmCommentId = mock(AlarmCommentId.class);
    when(alarmCommentId.getId()).thenThrow(new EmptyResultDataAccessException(3));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> auditLogController.checkAlarmCommentId(alarmCommentId, null));
    verify(alarmCommentId).getId();
  }

  /**
   * Test {@link BaseController#checkAlarmCommentId(AlarmCommentId, AlarmId)}.
   *
   * <p>Method under test: {@link BaseController#checkAlarmCommentId(AlarmCommentId, AlarmId)}
   */
  @Test
  @DisplayName("Test checkAlarmCommentId(AlarmCommentId, AlarmId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.alarm.AlarmComment BaseController.checkAlarmCommentId(AlarmCommentId, AlarmId)"
  })
  void testCheckAlarmCommentId3() throws ThingsboardException {
    // Arrange
    AuditLogController auditLogController = new AuditLogController();

    AlarmCommentId alarmCommentId = mock(AlarmCommentId.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Constraint Name");
    when(alarmCommentId.getId()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> auditLogController.checkAlarmCommentId(alarmCommentId, null));
    verify(alarmCommentId).getId();
  }

  /**
   * Test {@link BaseController#checkAlarmCommentId(AlarmCommentId, AlarmId)}.
   *
   * <p>Method under test: {@link BaseController#checkAlarmCommentId(AlarmCommentId, AlarmId)}
   */
  @Test
  @DisplayName("Test checkAlarmCommentId(AlarmCommentId, AlarmId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.alarm.AlarmComment BaseController.checkAlarmCommentId(AlarmCommentId, AlarmId)"
  })
  void testCheckAlarmCommentId4() throws ThingsboardException {
    // Arrange
    AuditLogController auditLogController = new AuditLogController();

    AlarmCommentId alarmCommentId = mock(AlarmCommentId.class);

    Builder builder = new Builder(1, "https://example.org/example", new HttpHeaders());

    Builder setContentResult = builder.setAttemptCount(3).setContent("https://example.org/example");
    HttpResponseException cause =
        setContentResult
            .setHeaders(new HttpHeaders())
            .setMessage("https://example.org/example")
            .setStatusCode(1)
            .setStatusMessage("https://example.org/example")
            .build();
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", cause);
    when(alarmCommentId.getId()).thenThrow(entityVersionMismatchException);

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> auditLogController.checkAlarmCommentId(alarmCommentId, null));
    verify(alarmCommentId).getId();
  }

  /**
   * Test {@link BaseController#checkAlarmCommentId(AlarmCommentId, AlarmId)}.
   *
   * <ul>
   *   <li>Given {@link AsyncRequestTimeoutException} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link BaseController#checkAlarmCommentId(AlarmCommentId, AlarmId)}
   */
  @Test
  @DisplayName(
      "Test checkAlarmCommentId(AlarmCommentId, AlarmId); given AsyncRequestTimeoutException (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.alarm.AlarmComment BaseController.checkAlarmCommentId(AlarmCommentId, AlarmId)"
  })
  void testCheckAlarmCommentId_givenAsyncRequestTimeoutException() throws ThingsboardException {
    // Arrange
    AuditLogController auditLogController = new AuditLogController();

    AlarmCommentId alarmCommentId = mock(AlarmCommentId.class);
    when(alarmCommentId.getId()).thenThrow(new AsyncRequestTimeoutException());

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> auditLogController.checkAlarmCommentId(alarmCommentId, null));
    verify(alarmCommentId).getId();
  }

  /**
   * Test {@link BaseController#checkAlarmCommentId(AlarmCommentId, AlarmId)}.
   *
   * <ul>
   *   <li>Given {@link DataValidationException#DataValidationException(String)} with message is
   *       {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#checkAlarmCommentId(AlarmCommentId, AlarmId)}
   */
  @Test
  @DisplayName(
      "Test checkAlarmCommentId(AlarmCommentId, AlarmId); given DataValidationException(String) with message is 'An error occurred'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.alarm.AlarmComment BaseController.checkAlarmCommentId(AlarmCommentId, AlarmId)"
  })
  void testCheckAlarmCommentId_givenDataValidationExceptionWithMessageIsAnErrorOccurred()
      throws ThingsboardException {
    // Arrange
    AuditLogController auditLogController = new AuditLogController();

    AlarmCommentId alarmCommentId = mock(AlarmCommentId.class);
    when(alarmCommentId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> auditLogController.checkAlarmCommentId(alarmCommentId, null));
    verify(alarmCommentId).getId();
  }

  /**
   * Test {@link BaseController#checkAlarmCommentId(AlarmCommentId, AlarmId)}.
   *
   * <ul>
   *   <li>Given fromString {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#checkAlarmCommentId(AlarmCommentId, AlarmId)}
   */
  @Test
  @DisplayName(
      "Test checkAlarmCommentId(AlarmCommentId, AlarmId); given fromString '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.alarm.AlarmComment BaseController.checkAlarmCommentId(AlarmCommentId, AlarmId)"
  })
  void testCheckAlarmCommentId_givenFromString784f394c42b6435a983cB7beff2784f9()
      throws ThingsboardException {
    // Arrange
    AuditLogController auditLogController = new AuditLogController();

    AlarmCommentId alarmCommentId = mock(AlarmCommentId.class);
    when(alarmCommentId.getId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> auditLogController.checkAlarmCommentId(alarmCommentId, null));
    verify(alarmCommentId).getId();
  }

  /**
   * Test {@link BaseController#checkAlarmCommentId(AlarmCommentId, AlarmId)}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#checkAlarmCommentId(AlarmCommentId, AlarmId)}
   */
  @Test
  @DisplayName(
      "Test checkAlarmCommentId(AlarmCommentId, AlarmId); given IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.alarm.AlarmComment BaseController.checkAlarmCommentId(AlarmCommentId, AlarmId)"
  })
  void testCheckAlarmCommentId_givenIllegalArgumentException() throws ThingsboardException {
    // Arrange
    AuditLogController auditLogController = new AuditLogController();

    AlarmCommentId alarmCommentId = mock(AlarmCommentId.class);
    when(alarmCommentId.getId()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> auditLogController.checkAlarmCommentId(alarmCommentId, null));
    verify(alarmCommentId).getId();
  }

  /**
   * Test {@link BaseController#checkAlarmCommentId(AlarmCommentId, AlarmId)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link AlarmCommentId} {@link AlarmCommentId#getId()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#checkAlarmCommentId(AlarmCommentId, AlarmId)}
   */
  @Test
  @DisplayName(
      "Test checkAlarmCommentId(AlarmCommentId, AlarmId); given 'null'; when AlarmCommentId getId() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.alarm.AlarmComment BaseController.checkAlarmCommentId(AlarmCommentId, AlarmId)"
  })
  void testCheckAlarmCommentId_givenNull_whenAlarmCommentIdGetIdReturnNull()
      throws ThingsboardException {
    // Arrange
    AuditLogController auditLogController = new AuditLogController();

    AlarmCommentId alarmCommentId = mock(AlarmCommentId.class);
    when(alarmCommentId.getId()).thenReturn(null);

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> auditLogController.checkAlarmCommentId(alarmCommentId, null));
    verify(alarmCommentId).getId();
  }
}
