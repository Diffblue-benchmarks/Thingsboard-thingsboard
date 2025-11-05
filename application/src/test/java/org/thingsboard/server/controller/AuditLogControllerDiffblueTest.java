package org.thingsboard.server.controller;

import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.thingsboard.server.exception.ThingsboardErrorResponseHandler;

@ExtendWith(MockitoExtension.class)
class AuditLogControllerDiffblueTest {
  @InjectMocks private AuditLogController auditLogController;

  @Mock private ThingsboardErrorResponseHandler thingsboardErrorResponseHandler;

  /**
   * Test {@link AuditLogController#getAuditLogsByCustomerId(String, int, int, String, String,
   * String, Long, Long, String)}.
   *
   * <ul>
   *   <li>When {@code CustomerId}.
   * </ul>
   *
   * <p>Method under test: {@link AuditLogController#getAuditLogsByCustomerId(String, int, int,
   * String, String, String, Long, Long, String)}
   */
  @Test
  @DisplayName(
      "Test getAuditLogsByCustomerId(String, int, int, String, String, String, Long, Long, String); when 'CustomerId'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData AuditLogController.getAuditLogsByCustomerId(String, int, int, String, String, String, Long, Long, String)"
  })
  void testGetAuditLogsByCustomerId_whenCustomerId() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/audit/logs/customer/{customerId}", "42")
            .param("page", "CustomerId")
            .param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(auditLogController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk());
  }

  /**
   * Test {@link AuditLogController#getAuditLogsByCustomerId(String, int, int, String, String,
   * String, Long, Long, String)}.
   *
   * <ul>
   *   <li>When {@link MockHttpServletRequestBuilder#param(String, String[])} {@code page} is
   *       valueOf one.
   * </ul>
   *
   * <p>Method under test: {@link AuditLogController#getAuditLogsByCustomerId(String, int, int,
   * String, String, String, Long, Long, String)}
   */
  @Test
  @DisplayName(
      "Test getAuditLogsByCustomerId(String, int, int, String, String, String, Long, Long, String); when param(String, String[]) 'page' is valueOf one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData AuditLogController.getAuditLogsByCustomerId(String, int, int, String, String, String, Long, Long, String)"
  })
  void testGetAuditLogsByCustomerId_whenParamPageIsValueOfOne() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/audit/logs/customer/{customerId}", "42")
            .param("page", String.valueOf(1))
            .param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(auditLogController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk());
  }

  /**
   * Test {@link AuditLogController#getAuditLogsByUserId(String, int, int, String, String, String,
   * Long, Long, String)}.
   *
   * <ul>
   *   <li>When {@link MockHttpServletRequestBuilder#param(String, String[])} {@code page} is
   *       valueOf one.
   * </ul>
   *
   * <p>Method under test: {@link AuditLogController#getAuditLogsByUserId(String, int, int, String,
   * String, String, Long, Long, String)}
   */
  @Test
  @DisplayName(
      "Test getAuditLogsByUserId(String, int, int, String, String, String, Long, Long, String); when param(String, String[]) 'page' is valueOf one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData AuditLogController.getAuditLogsByUserId(String, int, int, String, String, String, Long, Long, String)"
  })
  void testGetAuditLogsByUserId_whenParamPageIsValueOfOne() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/audit/logs/user/{userId}", "42")
            .param("page", String.valueOf(1))
            .param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(auditLogController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk());
  }

  /**
   * Test {@link AuditLogController#getAuditLogsByUserId(String, int, int, String, String, String,
   * Long, Long, String)}.
   *
   * <ul>
   *   <li>When {@code UserId}.
   * </ul>
   *
   * <p>Method under test: {@link AuditLogController#getAuditLogsByUserId(String, int, int, String,
   * String, String, Long, Long, String)}
   */
  @Test
  @DisplayName(
      "Test getAuditLogsByUserId(String, int, int, String, String, String, Long, Long, String); when 'UserId'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData AuditLogController.getAuditLogsByUserId(String, int, int, String, String, String, Long, Long, String)"
  })
  void testGetAuditLogsByUserId_whenUserId() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/audit/logs/user/{userId}", "42")
            .param("page", "UserId")
            .param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(auditLogController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk());
  }

  /**
   * Test {@link AuditLogController#getAuditLogsByEntityId(String, String, int, int, String, String,
   * String, Long, Long, String)}.
   *
   * <ul>
   *   <li>When {@code EntityId}.
   * </ul>
   *
   * <p>Method under test: {@link AuditLogController#getAuditLogsByEntityId(String, String, int,
   * int, String, String, String, Long, Long, String)}
   */
  @Test
  @DisplayName(
      "Test getAuditLogsByEntityId(String, String, int, int, String, String, String, Long, Long, String); when 'EntityId'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData AuditLogController.getAuditLogsByEntityId(String, String, int, int, String, String, String, Long, Long, String)"
  })
  void testGetAuditLogsByEntityId_whenEntityId() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());

    MockHttpServletRequestBuilder getResult =
        MockMvcRequestBuilders.get(
            "/api/audit/logs/entity/{entityType}/{entityId}", "Entity Type", "42");

    MockHttpServletRequestBuilder requestBuilder =
        getResult.param("page", "EntityId").param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(auditLogController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk());
  }

  /**
   * Test {@link AuditLogController#getAuditLogsByEntityId(String, String, int, int, String, String,
   * String, Long, Long, String)}.
   *
   * <ul>
   *   <li>When {@link MockHttpServletRequestBuilder#param(String, String[])} {@code page} is
   *       valueOf one.
   * </ul>
   *
   * <p>Method under test: {@link AuditLogController#getAuditLogsByEntityId(String, String, int,
   * int, String, String, String, Long, Long, String)}
   */
  @Test
  @DisplayName(
      "Test getAuditLogsByEntityId(String, String, int, int, String, String, String, Long, Long, String); when param(String, String[]) 'page' is valueOf one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData AuditLogController.getAuditLogsByEntityId(String, String, int, int, String, String, String, Long, Long, String)"
  })
  void testGetAuditLogsByEntityId_whenParamPageIsValueOfOne() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());

    MockHttpServletRequestBuilder getResult =
        MockMvcRequestBuilders.get(
            "/api/audit/logs/entity/{entityType}/{entityId}", "Entity Type", "42");

    MockHttpServletRequestBuilder requestBuilder =
        getResult.param("page", String.valueOf(1)).param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(auditLogController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk());
  }

  /**
   * Test {@link AuditLogController#getAuditLogs(int, int, String, String, String, Long, Long,
   * String)}.
   *
   * <ul>
   *   <li>When {@link MockHttpServletRequestBuilder#param(String, String[])} {@code page} is
   *       valueOf one.
   * </ul>
   *
   * <p>Method under test: {@link AuditLogController#getAuditLogs(int, int, String, String, String,
   * Long, Long, String)}
   */
  @Test
  @DisplayName(
      "Test getAuditLogs(int, int, String, String, String, Long, Long, String); when param(String, String[]) 'page' is valueOf one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData AuditLogController.getAuditLogs(int, int, String, String, String, Long, Long, String)"
  })
  void testGetAuditLogs_whenParamPageIsValueOfOne() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/audit/logs")
            .param("page", String.valueOf(1))
            .param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(auditLogController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk());
  }

  /**
   * Test {@link AuditLogController#getAuditLogs(int, int, String, String, String, Long, Long,
   * String)}.
   *
   * <ul>
   *   <li>When {@code You aren't authorized to perform this operation!}.
   * </ul>
   *
   * <p>Method under test: {@link AuditLogController#getAuditLogs(int, int, String, String, String,
   * Long, Long, String)}
   */
  @Test
  @DisplayName(
      "Test getAuditLogs(int, int, String, String, String, Long, Long, String); when 'You aren't authorized to perform this operation!'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData AuditLogController.getAuditLogs(int, int, String, String, String, Long, Long, String)"
  })
  void testGetAuditLogs_whenYouArenTAuthorizedToPerformThisOperation() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/audit/logs")
            .param("page", "You aren't authorized to perform this operation!")
            .param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(auditLogController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk());
  }
}
