package org.thingsboard.server.controller;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.thingsboard.server.common.data.asset.AssetSearchQuery;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.dao.asset.AssetProfileServiceImpl;
import org.thingsboard.server.dao.asset.BaseAssetService;
import org.thingsboard.server.dao.exception.IncorrectParameterException;
import org.thingsboard.server.exception.ThingsboardErrorResponseHandler;
import org.thingsboard.server.service.asset.AssetBulkImportService;
import org.thingsboard.server.service.entitiy.asset.DefaultTbAssetService;

@ExtendWith(MockitoExtension.class)
class AssetControllerDiffblueTest {
  @InjectMocks private AssetController assetController;

  @Mock private ThingsboardErrorResponseHandler thingsboardErrorResponseHandler;

  /**
   * Test {@link AssetController#getTenantAssets(int, int, String, String, String, String)}.
   *
   * <p>Method under test: {@link AssetController#getTenantAssets(int, int, String, String, String,
   * String)}
   */
  @Test
  @DisplayName("Test getTenantAssets(int, int, String, String, String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData AssetController.getTenantAssets(int, int, String, String, String, String)"
  })
  void testGetTenantAssets() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder paramResult =
        MockMvcRequestBuilders.get("/api/tenant/assets")
            .param("page", "https://example.org/example");
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(assetController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }

  /**
   * Test {@link AssetController#getTenantAssetInfos(int, int, String, String, String, String,
   * String)}.
   *
   * <p>Method under test: {@link AssetController#getTenantAssetInfos(int, int, String, String,
   * String, String, String)}
   */
  @Test
  @DisplayName("Test getTenantAssetInfos(int, int, String, String, String, String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData AssetController.getTenantAssetInfos(int, int, String, String, String, String, String)"
  })
  void testGetTenantAssetInfos() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder paramResult =
        MockMvcRequestBuilders.get("/api/tenant/assetInfos")
            .param("page", "https://example.org/example");
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(assetController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }

  /**
   * Test {@link AssetController#getCustomerAssets(String, int, int, String, String, String,
   * String)}.
   *
   * <p>Method under test: {@link AssetController#getCustomerAssets(String, int, int, String,
   * String, String, String)}
   */
  @Test
  @DisplayName("Test getCustomerAssets(String, int, int, String, String, String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData AssetController.getCustomerAssets(String, int, int, String, String, String, String)"
  })
  void testGetCustomerAssets() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder paramResult =
        MockMvcRequestBuilders.get("/api/customer/{customerId}/assets", "42")
            .param("page", "https://example.org/example");
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(assetController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }

  /**
   * Test {@link AssetController#getCustomerAssetInfos(String, int, int, String, String, String,
   * String, String)}.
   *
   * <p>Method under test: {@link AssetController#getCustomerAssetInfos(String, int, int, String,
   * String, String, String, String)}
   */
  @Test
  @DisplayName(
      "Test getCustomerAssetInfos(String, int, int, String, String, String, String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData AssetController.getCustomerAssetInfos(String, int, int, String, String, String, String, String)"
  })
  void testGetCustomerAssetInfos() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder paramResult =
        MockMvcRequestBuilders.get("/api/customer/{customerId}/assetInfos", "42")
            .param("page", "https://example.org/example");
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(assetController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }

  /**
   * Test {@link AssetController#findByQuery(AssetSearchQuery)}.
   *
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.
   * </ul>
   *
   * <p>Method under test: {@link AssetController#findByQuery(AssetSearchQuery)}
   */
  @Test
  @DisplayName("Test findByQuery(AssetSearchQuery); then throw IncorrectParameterException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.List AssetController.findByQuery(AssetSearchQuery)"})
  void testFindByQuery_thenThrowIncorrectParameterException()
      throws InterruptedException, ExecutionException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    BaseAssetService assetService = new BaseAssetService();
    DefaultTbAssetService tbAssetService = new DefaultTbAssetService(new BaseAssetService());
    AssetBulkImportService assetBulkImportService =
        new AssetBulkImportService(assetService, tbAssetService, new AssetProfileServiceImpl());

    AssetController assetController =
        new AssetController(
            assetBulkImportService, new DefaultTbAssetService(new BaseAssetService()));
    AssetSearchQuery query = mock(AssetSearchQuery.class);
    when(query.getParameters()).thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(IncorrectParameterException.class, () -> assetController.findByQuery(query));
    verify(query).getParameters();
  }

  /**
   * Test {@link AssetController#getEdgeAssets(String, int, int, String, String, String, String,
   * Long, Long)}.
   *
   * <p>Method under test: {@link AssetController#getEdgeAssets(String, int, int, String, String,
   * String, String, Long, Long)}
   */
  @Test
  @DisplayName("Test getEdgeAssets(String, int, int, String, String, String, String, Long, Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData AssetController.getEdgeAssets(String, int, int, String, String, String, String, Long, Long)"
  })
  void testGetEdgeAssets() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder paramResult =
        MockMvcRequestBuilders.get("/api/edge/{edgeId}/assets", "42")
            .param("page", "https://example.org/example");
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(assetController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }
}
