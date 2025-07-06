package org.thingsboard.server.controller;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.thingsboard.server.exception.ThingsboardErrorResponseHandler;

@ExtendWith(MockitoExtension.class)
class EntityViewControllerDiffblueTest {
  @InjectMocks private EntityViewController entityViewController;

  @Mock private ThingsboardErrorResponseHandler thingsboardErrorResponseHandler;

  /**
   * Test {@link EntityViewController#getCustomerEntityViews(String, int, int, String, String,
   * String, String)}.
   *
   * <p>Method under test: {@link EntityViewController#getCustomerEntityViews(String, int, int,
   * String, String, String, String)}
   */
  @Test
  @DisplayName("Test getCustomerEntityViews(String, int, int, String, String, String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData EntityViewController.getCustomerEntityViews(String, int, int, String, String, String, String)"
  })
  void testGetCustomerEntityViews() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder paramResult =
        MockMvcRequestBuilders.get("/api/customer/{customerId}/entityViews", "42")
            .param("page", "https://example.org/example");
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(entityViewController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }

  /**
   * Test {@link EntityViewController#getCustomerEntityViewInfos(String, int, int, String, String,
   * String, String)}.
   *
   * <p>Method under test: {@link EntityViewController#getCustomerEntityViewInfos(String, int, int,
   * String, String, String, String)}
   */
  @Test
  @DisplayName("Test getCustomerEntityViewInfos(String, int, int, String, String, String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData EntityViewController.getCustomerEntityViewInfos(String, int, int, String, String, String, String)"
  })
  void testGetCustomerEntityViewInfos() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder paramResult =
        MockMvcRequestBuilders.get("/api/customer/{customerId}/entityViewInfos", "42")
            .param("page", "https://example.org/example");
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(entityViewController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }

  /**
   * Test {@link EntityViewController#getTenantEntityViews(int, int, String, String, String,
   * String)}.
   *
   * <p>Method under test: {@link EntityViewController#getTenantEntityViews(int, int, String,
   * String, String, String)}
   */
  @Test
  @DisplayName("Test getTenantEntityViews(int, int, String, String, String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData EntityViewController.getTenantEntityViews(int, int, String, String, String, String)"
  })
  void testGetTenantEntityViews() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder paramResult =
        MockMvcRequestBuilders.get("/api/tenant/entityViews")
            .param("page", "https://example.org/example");
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(entityViewController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }

  /**
   * Test {@link EntityViewController#getTenantEntityViewInfos(int, int, String, String, String,
   * String)}.
   *
   * <p>Method under test: {@link EntityViewController#getTenantEntityViewInfos(int, int, String,
   * String, String, String)}
   */
  @Test
  @DisplayName("Test getTenantEntityViewInfos(int, int, String, String, String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData EntityViewController.getTenantEntityViewInfos(int, int, String, String, String, String)"
  })
  void testGetTenantEntityViewInfos() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder paramResult =
        MockMvcRequestBuilders.get("/api/tenant/entityViewInfos")
            .param("page", "https://example.org/example");
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(entityViewController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }

  /**
   * Test {@link EntityViewController#getEdgeEntityViews(String, int, int, String, String, String,
   * String, Long, Long)}.
   *
   * <p>Method under test: {@link EntityViewController#getEdgeEntityViews(String, int, int, String,
   * String, String, String, Long, Long)}
   */
  @Test
  @DisplayName(
      "Test getEdgeEntityViews(String, int, int, String, String, String, String, Long, Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData EntityViewController.getEdgeEntityViews(String, int, int, String, String, String, String, Long, Long)"
  })
  void testGetEdgeEntityViews() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder paramResult =
        MockMvcRequestBuilders.get("/api/edge/{edgeId}/entityViews", "42")
            .param("page", "https://example.org/example");
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(entityViewController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }
}
