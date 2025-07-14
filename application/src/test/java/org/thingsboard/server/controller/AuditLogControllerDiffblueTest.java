package org.thingsboard.server.controller;

import static org.mockito.Mockito.doNothing;
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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
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
   *   <li>When {@code https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link AuditLogController#getAuditLogsByCustomerId(String, int, int,
   * String, String, String, Long, Long, String)}
   */
  @Test
  @DisplayName(
      "Test getAuditLogsByCustomerId(String, int, int, String, String, String, Long, Long, String); when 'https://example.org/example'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData AuditLogController.getAuditLogsByCustomerId(String, int, int, String, String, String, Long, Long, String)"
  })
  void testGetAuditLogsByCustomerId_whenHttpsExampleOrgExample() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder paramResult =
        MockMvcRequestBuilders.get("/api/audit/logs/customer/{customerId}", "42")
            .param("page", "https://example.org/example");
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(auditLogController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData AuditLogController.getAuditLogsByCustomerId(String, int, int, String, String, String, Long, Long, String)"
  })
  void testGetAuditLogsByCustomerId_whenParamPageIsValueOfOne() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder getResult =
        MockMvcRequestBuilders.get("/api/audit/logs/customer/{customerId}", "42");
    MockHttpServletRequestBuilder paramResult = getResult.param("page", String.valueOf(1));
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(auditLogController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link AuditLogController#getAuditLogsByUserId(String, int, int, String, String, String,
   * Long, Long, String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link AuditLogController#getAuditLogsByUserId(String, int, int, String,
   * String, String, Long, Long, String)}
   */
  @Test
  @DisplayName(
      "Test getAuditLogsByUserId(String, int, int, String, String, String, Long, Long, String); when 'https://example.org/example'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData AuditLogController.getAuditLogsByUserId(String, int, int, String, String, String, Long, Long, String)"
  })
  void testGetAuditLogsByUserId_whenHttpsExampleOrgExample() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder paramResult =
        MockMvcRequestBuilders.get("/api/audit/logs/user/{userId}", "42")
            .param("page", "https://example.org/example");
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(auditLogController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData AuditLogController.getAuditLogsByUserId(String, int, int, String, String, String, Long, Long, String)"
  })
  void testGetAuditLogsByUserId_whenParamPageIsValueOfOne() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder getResult =
        MockMvcRequestBuilders.get("/api/audit/logs/user/{userId}", "42");
    MockHttpServletRequestBuilder paramResult = getResult.param("page", String.valueOf(1));
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(auditLogController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link AuditLogController#getAuditLogsByEntityId(String, String, int, int, String, String,
   * String, Long, Long, String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link AuditLogController#getAuditLogsByEntityId(String, String, int,
   * int, String, String, String, Long, Long, String)}
   */
  @Test
  @DisplayName(
      "Test getAuditLogsByEntityId(String, String, int, int, String, String, String, Long, Long, String); when 'https://example.org/example'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData AuditLogController.getAuditLogsByEntityId(String, String, int, int, String, String, String, Long, Long, String)"
  })
  void testGetAuditLogsByEntityId_whenHttpsExampleOrgExample() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder paramResult =
        MockMvcRequestBuilders.get(
                "/api/audit/logs/entity/{entityType}/{entityId}", "Entity Type", "42")
            .param("page", "https://example.org/example");
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(auditLogController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
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
  @Tag("MaintainedByDiffblue")
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
    MockHttpServletRequestBuilder paramResult = getResult.param("page", String.valueOf(1));
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(auditLogController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link AuditLogController#getAuditLogs(int, int, String, String, String, Long, Long,
   * String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link AuditLogController#getAuditLogs(int, int, String, String, String,
   * Long, Long, String)}
   */
  @Test
  @DisplayName(
      "Test getAuditLogs(int, int, String, String, String, Long, Long, String); when 'https://example.org/example'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData AuditLogController.getAuditLogs(int, int, String, String, String, Long, Long, String)"
  })
  void testGetAuditLogs_whenHttpsExampleOrgExample() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder paramResult =
        MockMvcRequestBuilders.get("/api/audit/logs").param("page", "https://example.org/example");
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(auditLogController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData AuditLogController.getAuditLogs(int, int, String, String, String, Long, Long, String)"
  })
  void testGetAuditLogs_whenParamPageIsValueOfOne() throws Exception {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/audit/logs");
    MockHttpServletRequestBuilder paramResult = getResult.param("page", String.valueOf(1));
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(auditLogController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }
}
