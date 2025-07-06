package org.thingsboard.server.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.FormLoginRequestBuilder;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.LogoutRequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.request.WebRequest;
import org.thingsboard.server.common.data.HomeDashboardInfo;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.dao.dashboard.DashboardServiceImpl;
import org.thingsboard.server.dao.resource.BaseImageService;
import org.thingsboard.server.dao.service.validator.ResourceDataValidator;
import org.thingsboard.server.dao.sql.asset.JpaAssetProfileDao;
import org.thingsboard.server.dao.sql.dashboard.JpaDashboardInfoDao;
import org.thingsboard.server.dao.sql.device.JpaDeviceProfileDao;
import org.thingsboard.server.dao.sql.resource.JpaTbResourceDao;
import org.thingsboard.server.dao.sql.resource.JpaTbResourceInfoDao;
import org.thingsboard.server.dao.sql.resource.TbResourceRepository;
import org.thingsboard.server.dao.sql.widget.JpaWidgetTypeDao;
import org.thingsboard.server.dao.sql.widget.JpaWidgetsBundleDao;
import org.thingsboard.server.exception.ThingsboardErrorResponseHandler;
import org.thingsboard.server.service.entitiy.dashboard.DefaultTbDashboardService;

@ExtendWith(MockitoExtension.class)
class DashboardControllerDiffblueTest {
  @InjectMocks private DashboardController dashboardController;

  @Mock private ThingsboardErrorResponseHandler thingsboardErrorResponseHandler;

  /**
   * Test {@link DashboardController#getServerTime()}.
   *
   * <p>Method under test: {@link DashboardController#getServerTime()}
   */
  @Test
  @DisplayName("Test getServerTime()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long DashboardController.getServerTime()"})
  void testGetServerTime() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(dashboardController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link DashboardController#getServerTime()}.
   *
   * <p>Method under test: {@link DashboardController#getServerTime()}
   */
  @Test
  @DisplayName("Test getServerTime()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long DashboardController.getServerTime()"})
  void testGetServerTime2() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(dashboardController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(
            MockMvcResultMatchers.content()
                .contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(MockMvcResultMatchers.content().string("Body"));
  }

  /**
   * Test {@link DashboardController#getMaxDatapointsLimit()}.
   *
   * <p>Method under test: {@link DashboardController#getMaxDatapointsLimit()}
   */
  @Test
  @DisplayName("Test getMaxDatapointsLimit()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long DashboardController.getMaxDatapointsLimit()"})
  void testGetMaxDatapointsLimit() throws ThingsboardException {
    // Arrange
    DefaultTbDashboardService tbDashboardService =
        new DefaultTbDashboardService(new DashboardServiceImpl());
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    // Act and Assert
    assertEquals(
        0L,
        new DashboardController(
                tbDashboardService,
                new BaseImageService(
                    resourceDao,
                    resourceInfoDao,
                    resourceValidator,
                    assetProfileDao,
                    deviceProfileDao,
                    widgetsBundleDao,
                    widgetTypeDao,
                    new JpaDashboardInfoDao()))
            .getMaxDatapointsLimit());
  }

  /**
   * Test {@link DashboardController#getDashboardInfoById(String)}.
   *
   * <p>Method under test: {@link DashboardController#getDashboardInfoById(String)}
   */
  @Test
  @DisplayName("Test getDashboardInfoById(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.DashboardInfo DashboardController.getDashboardInfoById(String)"
  })
  void testGetDashboardInfoById() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(dashboardController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link DashboardController#getDashboardInfoById(String)}.
   *
   * <p>Method under test: {@link DashboardController#getDashboardInfoById(String)}
   */
  @Test
  @DisplayName("Test getDashboardInfoById(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.DashboardInfo DashboardController.getDashboardInfoById(String)"
  })
  void testGetDashboardInfoById2() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(dashboardController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(
            MockMvcResultMatchers.content()
                .contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(MockMvcResultMatchers.content().string("Body"));
  }

  /**
   * Test {@link DashboardController#getDashboardInfoById(String)}.
   *
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isNotFound()}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardController#getDashboardInfoById(String)}
   */
  @Test
  @DisplayName("Test getDashboardInfoById(String); then status isNotFound()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.DashboardInfo DashboardController.getDashboardInfoById(String)"
  })
  void testGetDashboardInfoById_thenStatusIsNotFound() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(dashboardController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isNotFound());
  }

  /**
   * Test {@link DashboardController#getDashboardInfoById(String)}.
   *
   * <ul>
   *   <li>When logout.
   *   <li>Then content contentType {@code application/json}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardController#getDashboardInfoById(String)}
   */
  @Test
  @DisplayName(
      "Test getDashboardInfoById(String); when logout; then content contentType 'application/json'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.DashboardInfo DashboardController.getDashboardInfoById(String)"
  })
  void testGetDashboardInfoById_whenLogout_thenContentContentTypeApplicationJson()
      throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));
    LogoutRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.logout();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(dashboardController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
        .andExpect(MockMvcResultMatchers.content().string("42"));
  }

  /**
   * Test {@link DashboardController#getDashboardById(String, boolean)}.
   *
   * <p>Method under test: {@link DashboardController#getDashboardById(String, boolean)}
   */
  @Test
  @DisplayName("Test getDashboardById(String, boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.Dashboard DashboardController.getDashboardById(String, boolean)"
  })
  void testGetDashboardById() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(dashboardController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link DashboardController#getDashboardById(String, boolean)}.
   *
   * <p>Method under test: {@link DashboardController#getDashboardById(String, boolean)}
   */
  @Test
  @DisplayName("Test getDashboardById(String, boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.Dashboard DashboardController.getDashboardById(String, boolean)"
  })
  void testGetDashboardById2() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(dashboardController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(
            MockMvcResultMatchers.content()
                .contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(MockMvcResultMatchers.content().string("Body"));
  }

  /**
   * Test {@link DashboardController#getDashboardById(String, boolean)}.
   *
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isNotFound()}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardController#getDashboardById(String, boolean)}
   */
  @Test
  @DisplayName("Test getDashboardById(String, boolean); then status isNotFound()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.Dashboard DashboardController.getDashboardById(String, boolean)"
  })
  void testGetDashboardById_thenStatusIsNotFound() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(dashboardController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isNotFound());
  }

  /**
   * Test {@link DashboardController#getDashboardById(String, boolean)}.
   *
   * <ul>
   *   <li>When logout.
   *   <li>Then content contentType {@code application/json}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardController#getDashboardById(String, boolean)}
   */
  @Test
  @DisplayName(
      "Test getDashboardById(String, boolean); when logout; then content contentType 'application/json'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.Dashboard DashboardController.getDashboardById(String, boolean)"
  })
  void testGetDashboardById_whenLogout_thenContentContentTypeApplicationJson() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));
    LogoutRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.logout();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(dashboardController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
        .andExpect(MockMvcResultMatchers.content().string("42"));
  }

  /**
   * Test {@link DashboardController#deleteDashboard(String)}.
   *
   * <p>Method under test: {@link DashboardController#deleteDashboard(String)}
   */
  @Test
  @DisplayName("Test deleteDashboard(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DashboardController.deleteDashboard(String)"})
  void testDeleteDashboard() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(dashboardController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link DashboardController#deleteDashboard(String)}.
   *
   * <p>Method under test: {@link DashboardController#deleteDashboard(String)}
   */
  @Test
  @DisplayName("Test deleteDashboard(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DashboardController.deleteDashboard(String)"})
  void testDeleteDashboard2() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(dashboardController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(
            MockMvcResultMatchers.content()
                .contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(MockMvcResultMatchers.content().string("Body"));
  }

  /**
   * Test {@link DashboardController#deleteDashboard(String)}.
   *
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isNotFound()}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardController#deleteDashboard(String)}
   */
  @Test
  @DisplayName("Test deleteDashboard(String); then status isNotFound()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DashboardController.deleteDashboard(String)"})
  void testDeleteDashboard_thenStatusIsNotFound() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(dashboardController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isNotFound());
  }

  /**
   * Test {@link DashboardController#deleteDashboard(String)}.
   *
   * <ul>
   *   <li>When logout.
   *   <li>Then content contentType {@code application/json}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardController#deleteDashboard(String)}
   */
  @Test
  @DisplayName(
      "Test deleteDashboard(String); when logout; then content contentType 'application/json'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DashboardController.deleteDashboard(String)"})
  void testDeleteDashboard_whenLogout_thenContentContentTypeApplicationJson() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));
    LogoutRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.logout();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(dashboardController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
        .andExpect(MockMvcResultMatchers.content().string("42"));
  }

  /**
   * Test {@link DashboardController#assignDashboardToCustomer(String, String)}.
   *
   * <p>Method under test: {@link DashboardController#assignDashboardToCustomer(String, String)}
   */
  @Test
  @DisplayName("Test assignDashboardToCustomer(String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.Dashboard DashboardController.assignDashboardToCustomer(String, String)"
  })
  void testAssignDashboardToCustomer() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(dashboardController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link DashboardController#assignDashboardToCustomer(String, String)}.
   *
   * <p>Method under test: {@link DashboardController#assignDashboardToCustomer(String, String)}
   */
  @Test
  @DisplayName("Test assignDashboardToCustomer(String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.Dashboard DashboardController.assignDashboardToCustomer(String, String)"
  })
  void testAssignDashboardToCustomer2() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(dashboardController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(
            MockMvcResultMatchers.content()
                .contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(MockMvcResultMatchers.content().string("Body"));
  }

  /**
   * Test {@link DashboardController#assignDashboardToCustomer(String, String)}.
   *
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isNotFound()}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardController#assignDashboardToCustomer(String, String)}
   */
  @Test
  @DisplayName("Test assignDashboardToCustomer(String, String); then status isNotFound()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.Dashboard DashboardController.assignDashboardToCustomer(String, String)"
  })
  void testAssignDashboardToCustomer_thenStatusIsNotFound() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(dashboardController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isNotFound());
  }

  /**
   * Test {@link DashboardController#assignDashboardToCustomer(String, String)}.
   *
   * <ul>
   *   <li>When logout.
   *   <li>Then content contentType {@code application/json}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardController#assignDashboardToCustomer(String, String)}
   */
  @Test
  @DisplayName(
      "Test assignDashboardToCustomer(String, String); when logout; then content contentType 'application/json'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.Dashboard DashboardController.assignDashboardToCustomer(String, String)"
  })
  void testAssignDashboardToCustomer_whenLogout_thenContentContentTypeApplicationJson()
      throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));
    LogoutRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.logout();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(dashboardController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
        .andExpect(MockMvcResultMatchers.content().string("42"));
  }

  /**
   * Test {@link DashboardController#unassignDashboardFromCustomer(String, String)}.
   *
   * <p>Method under test: {@link DashboardController#unassignDashboardFromCustomer(String, String)}
   */
  @Test
  @DisplayName("Test unassignDashboardFromCustomer(String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.Dashboard DashboardController.unassignDashboardFromCustomer(String, String)"
  })
  void testUnassignDashboardFromCustomer() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(dashboardController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link DashboardController#unassignDashboardFromCustomer(String, String)}.
   *
   * <p>Method under test: {@link DashboardController#unassignDashboardFromCustomer(String, String)}
   */
  @Test
  @DisplayName("Test unassignDashboardFromCustomer(String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.Dashboard DashboardController.unassignDashboardFromCustomer(String, String)"
  })
  void testUnassignDashboardFromCustomer2() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(dashboardController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(
            MockMvcResultMatchers.content()
                .contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(MockMvcResultMatchers.content().string("Body"));
  }

  /**
   * Test {@link DashboardController#unassignDashboardFromCustomer(String, String)}.
   *
   * <ul>
   *   <li>Then content contentType {@code application/json}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardController#unassignDashboardFromCustomer(String, String)}
   */
  @Test
  @DisplayName(
      "Test unassignDashboardFromCustomer(String, String); then content contentType 'application/json'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.Dashboard DashboardController.unassignDashboardFromCustomer(String, String)"
  })
  void testUnassignDashboardFromCustomer_thenContentContentTypeApplicationJson() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));
    LogoutRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.logout();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(dashboardController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
        .andExpect(MockMvcResultMatchers.content().string("42"));
  }

  /**
   * Test {@link DashboardController#unassignDashboardFromCustomer(String, String)}.
   *
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isNotFound()}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardController#unassignDashboardFromCustomer(String, String)}
   */
  @Test
  @DisplayName("Test unassignDashboardFromCustomer(String, String); then status isNotFound()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.Dashboard DashboardController.unassignDashboardFromCustomer(String, String)"
  })
  void testUnassignDashboardFromCustomer_thenStatusIsNotFound() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(dashboardController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isNotFound());
  }

  /**
   * Test {@link DashboardController#updateDashboardCustomers(String, String[])}.
   *
   * <p>Method under test: {@link DashboardController#updateDashboardCustomers(String, String[])}
   */
  @Test
  @DisplayName("Test updateDashboardCustomers(String, String[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.Dashboard DashboardController.updateDashboardCustomers(String, String[])"
  })
  void testUpdateDashboardCustomers() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder postResult =
        MockMvcRequestBuilders.post("/api/dashboard/{dashboardId}/customers", "42");
    postResult.characterEncoding("https://example.org/example");
    MockHttpServletRequestBuilder contentTypeResult =
        postResult.contentType(MediaType.APPLICATION_JSON);
    MockHttpServletRequestBuilder requestBuilder =
        contentTypeResult.content(new ObjectMapper().writeValueAsString(new String[] {"foo"}));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(dashboardController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(415));
  }

  /**
   * Test {@link DashboardController#addDashboardCustomers(String, String[])}.
   *
   * <p>Method under test: {@link DashboardController#addDashboardCustomers(String, String[])}
   */
  @Test
  @DisplayName("Test addDashboardCustomers(String, String[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.Dashboard DashboardController.addDashboardCustomers(String, String[])"
  })
  void testAddDashboardCustomers() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder postResult =
        MockMvcRequestBuilders.post("/api/dashboard/{dashboardId}/customers/add", "42");
    postResult.characterEncoding("https://example.org/example");
    MockHttpServletRequestBuilder contentTypeResult =
        postResult.contentType(MediaType.APPLICATION_JSON);
    MockHttpServletRequestBuilder requestBuilder =
        contentTypeResult.content(new ObjectMapper().writeValueAsString(new String[] {"foo"}));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(dashboardController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(415));
  }

  /**
   * Test {@link DashboardController#removeDashboardCustomers(String, String[])}.
   *
   * <p>Method under test: {@link DashboardController#removeDashboardCustomers(String, String[])}
   */
  @Test
  @DisplayName("Test removeDashboardCustomers(String, String[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.Dashboard DashboardController.removeDashboardCustomers(String, String[])"
  })
  void testRemoveDashboardCustomers() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder postResult =
        MockMvcRequestBuilders.post("/api/dashboard/{dashboardId}/customers/remove", "42");
    postResult.characterEncoding("https://example.org/example");
    MockHttpServletRequestBuilder contentTypeResult =
        postResult.contentType(MediaType.APPLICATION_JSON);
    MockHttpServletRequestBuilder requestBuilder =
        contentTypeResult.content(new ObjectMapper().writeValueAsString(new String[] {"foo"}));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(dashboardController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(415));
  }

  /**
   * Test {@link DashboardController#assignDashboardToPublicCustomer(String)}.
   *
   * <p>Method under test: {@link DashboardController#assignDashboardToPublicCustomer(String)}
   */
  @Test
  @DisplayName("Test assignDashboardToPublicCustomer(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.Dashboard DashboardController.assignDashboardToPublicCustomer(String)"
  })
  void testAssignDashboardToPublicCustomer() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(dashboardController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link DashboardController#assignDashboardToPublicCustomer(String)}.
   *
   * <p>Method under test: {@link DashboardController#assignDashboardToPublicCustomer(String)}
   */
  @Test
  @DisplayName("Test assignDashboardToPublicCustomer(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.Dashboard DashboardController.assignDashboardToPublicCustomer(String)"
  })
  void testAssignDashboardToPublicCustomer2() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(dashboardController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(
            MockMvcResultMatchers.content()
                .contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(MockMvcResultMatchers.content().string("Body"));
  }

  /**
   * Test {@link DashboardController#assignDashboardToPublicCustomer(String)}.
   *
   * <ul>
   *   <li>Then content contentType {@code application/json}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardController#assignDashboardToPublicCustomer(String)}
   */
  @Test
  @DisplayName(
      "Test assignDashboardToPublicCustomer(String); then content contentType 'application/json'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.Dashboard DashboardController.assignDashboardToPublicCustomer(String)"
  })
  void testAssignDashboardToPublicCustomer_thenContentContentTypeApplicationJson()
      throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));
    LogoutRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.logout();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(dashboardController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
        .andExpect(MockMvcResultMatchers.content().string("42"));
  }

  /**
   * Test {@link DashboardController#assignDashboardToPublicCustomer(String)}.
   *
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isNotFound()}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardController#assignDashboardToPublicCustomer(String)}
   */
  @Test
  @DisplayName("Test assignDashboardToPublicCustomer(String); then status isNotFound()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.Dashboard DashboardController.assignDashboardToPublicCustomer(String)"
  })
  void testAssignDashboardToPublicCustomer_thenStatusIsNotFound() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(dashboardController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isNotFound());
  }

  /**
   * Test {@link DashboardController#unassignDashboardFromPublicCustomer(String)}.
   *
   * <p>Method under test: {@link DashboardController#unassignDashboardFromPublicCustomer(String)}
   */
  @Test
  @DisplayName("Test unassignDashboardFromPublicCustomer(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.Dashboard DashboardController.unassignDashboardFromPublicCustomer(String)"
  })
  void testUnassignDashboardFromPublicCustomer() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(dashboardController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link DashboardController#unassignDashboardFromPublicCustomer(String)}.
   *
   * <p>Method under test: {@link DashboardController#unassignDashboardFromPublicCustomer(String)}
   */
  @Test
  @DisplayName("Test unassignDashboardFromPublicCustomer(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.Dashboard DashboardController.unassignDashboardFromPublicCustomer(String)"
  })
  void testUnassignDashboardFromPublicCustomer2() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(dashboardController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(
            MockMvcResultMatchers.content()
                .contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(MockMvcResultMatchers.content().string("Body"));
  }

  /**
   * Test {@link DashboardController#unassignDashboardFromPublicCustomer(String)}.
   *
   * <ul>
   *   <li>Then content contentType {@code application/json}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardController#unassignDashboardFromPublicCustomer(String)}
   */
  @Test
  @DisplayName(
      "Test unassignDashboardFromPublicCustomer(String); then content contentType 'application/json'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.Dashboard DashboardController.unassignDashboardFromPublicCustomer(String)"
  })
  void testUnassignDashboardFromPublicCustomer_thenContentContentTypeApplicationJson()
      throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));
    LogoutRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.logout();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(dashboardController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
        .andExpect(MockMvcResultMatchers.content().string("42"));
  }

  /**
   * Test {@link DashboardController#unassignDashboardFromPublicCustomer(String)}.
   *
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isNotFound()}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardController#unassignDashboardFromPublicCustomer(String)}
   */
  @Test
  @DisplayName("Test unassignDashboardFromPublicCustomer(String); then status isNotFound()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.Dashboard DashboardController.unassignDashboardFromPublicCustomer(String)"
  })
  void testUnassignDashboardFromPublicCustomer_thenStatusIsNotFound() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(dashboardController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isNotFound());
  }

  /**
   * Test {@link DashboardController#getTenantDashboards(int, int, Boolean, String, String, String)}
   * with {@code pageSize}, {@code page}, {@code mobile}, {@code textSearch}, {@code sortProperty},
   * {@code sortOrder}.
   *
   * <p>Method under test: {@link DashboardController#getTenantDashboards(int, int, Boolean, String,
   * String, String)}
   */
  @Test
  @DisplayName(
      "Test getTenantDashboards(int, int, Boolean, String, String, String) with 'pageSize', 'page', 'mobile', 'textSearch', 'sortProperty', 'sortOrder'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData DashboardController.getTenantDashboards(int, int, Boolean, String, String, String)"
  })
  void testGetTenantDashboardsWithPageSizePageMobileTextSearchSortPropertySortOrder()
      throws Exception {
    // Arrange
    MockHttpServletRequestBuilder paramResult =
        MockMvcRequestBuilders.get("/api/tenant/dashboards")
            .param("page", "https://example.org/example");
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(dashboardController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }

  /**
   * Test {@link DashboardController#getTenantDashboards(String, int, int, String, String, String)}
   * with {@code strTenantId}, {@code pageSize}, {@code page}, {@code textSearch}, {@code
   * sortProperty}, {@code sortOrder}.
   *
   * <p>Method under test: {@link DashboardController#getTenantDashboards(String, int, int, String,
   * String, String)}
   */
  @Test
  @DisplayName(
      "Test getTenantDashboards(String, int, int, String, String, String) with 'strTenantId', 'pageSize', 'page', 'textSearch', 'sortProperty', 'sortOrder'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData DashboardController.getTenantDashboards(String, int, int, String, String, String)"
  })
  void testGetTenantDashboardsWithStrTenantIdPageSizePageTextSearchSortPropertySortOrder()
      throws Exception {
    // Arrange
    MockHttpServletRequestBuilder paramResult =
        MockMvcRequestBuilders.get("/api/tenant/{tenantId}/dashboards", "42")
            .param("page", "https://example.org/example");
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(dashboardController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }

  /**
   * Test {@link DashboardController#getTenantDashboards(String, int, int, String, String, String)}
   * with {@code strTenantId}, {@code pageSize}, {@code page}, {@code textSearch}, {@code
   * sortProperty}, {@code sortOrder}.
   *
   * <p>Method under test: {@link DashboardController#getTenantDashboards(String, int, int, String,
   * String, String)}
   */
  @Test
  @DisplayName(
      "Test getTenantDashboards(String, int, int, String, String, String) with 'strTenantId', 'pageSize', 'page', 'textSearch', 'sortProperty', 'sortOrder'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData DashboardController.getTenantDashboards(String, int, int, String, String, String)"
  })
  void testGetTenantDashboardsWithStrTenantIdPageSizePageTextSearchSortPropertySortOrder2()
      throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));
    MockHttpServletRequestBuilder getResult =
        MockMvcRequestBuilders.get("/api/tenant/{tenantId}/dashboards", "");
    MockHttpServletRequestBuilder paramResult = getResult.param("page", String.valueOf(1));
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(dashboardController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link DashboardController#getTenantDashboards(String, int, int, String, String, String)}
   * with {@code strTenantId}, {@code pageSize}, {@code page}, {@code textSearch}, {@code
   * sortProperty}, {@code sortOrder}.
   *
   * <p>Method under test: {@link DashboardController#getTenantDashboards(String, int, int, String,
   * String, String)}
   */
  @Test
  @DisplayName(
      "Test getTenantDashboards(String, int, int, String, String, String) with 'strTenantId', 'pageSize', 'page', 'textSearch', 'sortProperty', 'sortOrder'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData DashboardController.getTenantDashboards(String, int, int, String, String, String)"
  })
  void testGetTenantDashboardsWithStrTenantIdPageSizePageTextSearchSortPropertySortOrder3()
      throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));
    MockHttpServletRequestBuilder getResult =
        MockMvcRequestBuilders.get("/api/tenant/{tenantId}/dashboards", "");
    MockHttpServletRequestBuilder paramResult = getResult.param("page", String.valueOf(1));
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(dashboardController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
        .andExpect(MockMvcResultMatchers.content().string("Body"));
  }

  /**
   * Test {@link DashboardController#getCustomerDashboards(String, int, int, Boolean, String,
   * String, String)}.
   *
   * <p>Method under test: {@link DashboardController#getCustomerDashboards(String, int, int,
   * Boolean, String, String, String)}
   */
  @Test
  @DisplayName("Test getCustomerDashboards(String, int, int, Boolean, String, String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData DashboardController.getCustomerDashboards(String, int, int, Boolean, String, String, String)"
  })
  void testGetCustomerDashboards() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));
    MockHttpServletRequestBuilder getResult =
        MockMvcRequestBuilders.get("/api/customer/{customerId}/dashboards", "");
    MockHttpServletRequestBuilder paramResult = getResult.param("page", String.valueOf(1));
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(dashboardController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link DashboardController#getCustomerDashboards(String, int, int, Boolean, String,
   * String, String)}.
   *
   * <ul>
   *   <li>Then content contentType {@code text/plain;charset=ISO-8859-1}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardController#getCustomerDashboards(String, int, int,
   * Boolean, String, String, String)}
   */
  @Test
  @DisplayName(
      "Test getCustomerDashboards(String, int, int, Boolean, String, String, String); then content contentType 'text/plain;charset=ISO-8859-1'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData DashboardController.getCustomerDashboards(String, int, int, Boolean, String, String, String)"
  })
  void testGetCustomerDashboards_thenContentContentTypeTextPlainCharsetIso88591() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));
    MockHttpServletRequestBuilder getResult =
        MockMvcRequestBuilders.get("/api/customer/{customerId}/dashboards", "");
    MockHttpServletRequestBuilder paramResult = getResult.param("page", String.valueOf(1));
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(dashboardController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
        .andExpect(MockMvcResultMatchers.content().string("Body"));
  }

  /**
   * Test {@link DashboardController#getCustomerDashboards(String, int, int, Boolean, String,
   * String, String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then status four hundred.
   * </ul>
   *
   * <p>Method under test: {@link DashboardController#getCustomerDashboards(String, int, int,
   * Boolean, String, String, String)}
   */
  @Test
  @DisplayName(
      "Test getCustomerDashboards(String, int, int, Boolean, String, String, String); when '42'; then status four hundred")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData DashboardController.getCustomerDashboards(String, int, int, Boolean, String, String, String)"
  })
  void testGetCustomerDashboards_when42_thenStatusFourHundred() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder paramResult =
        MockMvcRequestBuilders.get("/api/customer/{customerId}/dashboards", "42")
            .param("page", "https://example.org/example");
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(dashboardController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }

  /**
   * Test {@link DashboardController#getHomeDashboard()}.
   *
   * <p>Method under test: {@link DashboardController#getHomeDashboard()}
   */
  @Test
  @DisplayName("Test getHomeDashboard()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.HomeDashboard DashboardController.getHomeDashboard()"
  })
  void testGetHomeDashboard() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(dashboardController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link DashboardController#getHomeDashboard()}.
   *
   * <p>Method under test: {@link DashboardController#getHomeDashboard()}
   */
  @Test
  @DisplayName("Test getHomeDashboard()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.HomeDashboard DashboardController.getHomeDashboard()"
  })
  void testGetHomeDashboard2() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(dashboardController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(
            MockMvcResultMatchers.content()
                .contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(MockMvcResultMatchers.content().string("Body"));
  }

  /**
   * Test {@link DashboardController#getHomeDashboard()}.
   *
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isNotFound()}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardController#getHomeDashboard()}
   */
  @Test
  @DisplayName("Test getHomeDashboard(); then status isNotFound()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.HomeDashboard DashboardController.getHomeDashboard()"
  })
  void testGetHomeDashboard_thenStatusIsNotFound() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(dashboardController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isNotFound());
  }

  /**
   * Test {@link DashboardController#getHomeDashboard()}.
   *
   * <ul>
   *   <li>When logout.
   *   <li>Then content contentType {@code application/json}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardController#getHomeDashboard()}
   */
  @Test
  @DisplayName("Test getHomeDashboard(); when logout; then content contentType 'application/json'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.HomeDashboard DashboardController.getHomeDashboard()"
  })
  void testGetHomeDashboard_whenLogout_thenContentContentTypeApplicationJson() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));
    LogoutRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.logout();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(dashboardController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
        .andExpect(MockMvcResultMatchers.content().string("42"));
  }

  /**
   * Test {@link DashboardController#getHomeDashboardInfo()}.
   *
   * <p>Method under test: {@link DashboardController#getHomeDashboardInfo()}
   */
  @Test
  @DisplayName("Test getHomeDashboardInfo()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"HomeDashboardInfo DashboardController.getHomeDashboardInfo()"})
  void testGetHomeDashboardInfo() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(dashboardController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link DashboardController#getHomeDashboardInfo()}.
   *
   * <p>Method under test: {@link DashboardController#getHomeDashboardInfo()}
   */
  @Test
  @DisplayName("Test getHomeDashboardInfo()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"HomeDashboardInfo DashboardController.getHomeDashboardInfo()"})
  void testGetHomeDashboardInfo2() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(dashboardController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(
            MockMvcResultMatchers.content()
                .contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(MockMvcResultMatchers.content().string("Body"));
  }

  /**
   * Test {@link DashboardController#getHomeDashboardInfo()}.
   *
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isNotFound()}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardController#getHomeDashboardInfo()}
   */
  @Test
  @DisplayName("Test getHomeDashboardInfo(); then status isNotFound()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"HomeDashboardInfo DashboardController.getHomeDashboardInfo()"})
  void testGetHomeDashboardInfo_thenStatusIsNotFound() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(dashboardController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isNotFound());
  }

  /**
   * Test {@link DashboardController#getHomeDashboardInfo()}.
   *
   * <ul>
   *   <li>When logout.
   *   <li>Then content contentType {@code application/json}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardController#getHomeDashboardInfo()}
   */
  @Test
  @DisplayName(
      "Test getHomeDashboardInfo(); when logout; then content contentType 'application/json'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"HomeDashboardInfo DashboardController.getHomeDashboardInfo()"})
  void testGetHomeDashboardInfo_whenLogout_thenContentContentTypeApplicationJson()
      throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));
    LogoutRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.logout();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(dashboardController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
        .andExpect(MockMvcResultMatchers.content().string("42"));
  }

  /**
   * Test {@link DashboardController#getTenantHomeDashboardInfo()}.
   *
   * <p>Method under test: {@link DashboardController#getTenantHomeDashboardInfo()}
   */
  @Test
  @DisplayName("Test getTenantHomeDashboardInfo()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"HomeDashboardInfo DashboardController.getTenantHomeDashboardInfo()"})
  void testGetTenantHomeDashboardInfo() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(dashboardController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link DashboardController#getTenantHomeDashboardInfo()}.
   *
   * <p>Method under test: {@link DashboardController#getTenantHomeDashboardInfo()}
   */
  @Test
  @DisplayName("Test getTenantHomeDashboardInfo()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"HomeDashboardInfo DashboardController.getTenantHomeDashboardInfo()"})
  void testGetTenantHomeDashboardInfo2() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(dashboardController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(
            MockMvcResultMatchers.content()
                .contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(MockMvcResultMatchers.content().string("Body"));
  }

  /**
   * Test {@link DashboardController#getTenantHomeDashboardInfo()}.
   *
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isNotFound()}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardController#getTenantHomeDashboardInfo()}
   */
  @Test
  @DisplayName("Test getTenantHomeDashboardInfo(); then status isNotFound()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"HomeDashboardInfo DashboardController.getTenantHomeDashboardInfo()"})
  void testGetTenantHomeDashboardInfo_thenStatusIsNotFound() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(dashboardController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isNotFound());
  }

  /**
   * Test {@link DashboardController#getTenantHomeDashboardInfo()}.
   *
   * <ul>
   *   <li>When logout.
   *   <li>Then content contentType {@code application/json}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardController#getTenantHomeDashboardInfo()}
   */
  @Test
  @DisplayName(
      "Test getTenantHomeDashboardInfo(); when logout; then content contentType 'application/json'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"HomeDashboardInfo DashboardController.getTenantHomeDashboardInfo()"})
  void testGetTenantHomeDashboardInfo_whenLogout_thenContentContentTypeApplicationJson()
      throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));
    LogoutRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.logout();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(dashboardController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
        .andExpect(MockMvcResultMatchers.content().string("42"));
  }

  /**
   * Test {@link DashboardController#setTenantHomeDashboardInfo(HomeDashboardInfo)}.
   *
   * <p>Method under test: {@link DashboardController#setTenantHomeDashboardInfo(HomeDashboardInfo)}
   */
  @Test
  @DisplayName("Test setTenantHomeDashboardInfo(HomeDashboardInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DashboardController.setTenantHomeDashboardInfo(HomeDashboardInfo)"})
  void testSetTenantHomeDashboardInfo() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder postResult =
        MockMvcRequestBuilders.post("/api/tenant/dashboard/home/info");
    postResult.characterEncoding("https://example.org/example");
    MockHttpServletRequestBuilder contentTypeResult =
        postResult.contentType(MediaType.APPLICATION_JSON);

    ObjectMapper objectMapper = new ObjectMapper();
    MockHttpServletRequestBuilder requestBuilder =
        contentTypeResult.content(
            objectMapper.writeValueAsString(new HomeDashboardInfo(null, true)));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(dashboardController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(415));
  }

  /**
   * Test {@link DashboardController#assignDashboardToEdge(String, String)}.
   *
   * <p>Method under test: {@link DashboardController#assignDashboardToEdge(String, String)}
   */
  @Test
  @DisplayName("Test assignDashboardToEdge(String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.Dashboard DashboardController.assignDashboardToEdge(String, String)"
  })
  void testAssignDashboardToEdge() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(dashboardController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link DashboardController#assignDashboardToEdge(String, String)}.
   *
   * <p>Method under test: {@link DashboardController#assignDashboardToEdge(String, String)}
   */
  @Test
  @DisplayName("Test assignDashboardToEdge(String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.Dashboard DashboardController.assignDashboardToEdge(String, String)"
  })
  void testAssignDashboardToEdge2() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(dashboardController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(
            MockMvcResultMatchers.content()
                .contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(MockMvcResultMatchers.content().string("Body"));
  }

  /**
   * Test {@link DashboardController#assignDashboardToEdge(String, String)}.
   *
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isNotFound()}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardController#assignDashboardToEdge(String, String)}
   */
  @Test
  @DisplayName("Test assignDashboardToEdge(String, String); then status isNotFound()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.Dashboard DashboardController.assignDashboardToEdge(String, String)"
  })
  void testAssignDashboardToEdge_thenStatusIsNotFound() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(dashboardController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isNotFound());
  }

  /**
   * Test {@link DashboardController#assignDashboardToEdge(String, String)}.
   *
   * <ul>
   *   <li>When logout.
   *   <li>Then content contentType {@code application/json}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardController#assignDashboardToEdge(String, String)}
   */
  @Test
  @DisplayName(
      "Test assignDashboardToEdge(String, String); when logout; then content contentType 'application/json'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.Dashboard DashboardController.assignDashboardToEdge(String, String)"
  })
  void testAssignDashboardToEdge_whenLogout_thenContentContentTypeApplicationJson()
      throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));
    LogoutRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.logout();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(dashboardController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
        .andExpect(MockMvcResultMatchers.content().string("42"));
  }

  /**
   * Test {@link DashboardController#unassignDashboardFromEdge(String, String)}.
   *
   * <p>Method under test: {@link DashboardController#unassignDashboardFromEdge(String, String)}
   */
  @Test
  @DisplayName("Test unassignDashboardFromEdge(String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.Dashboard DashboardController.unassignDashboardFromEdge(String, String)"
  })
  void testUnassignDashboardFromEdge() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(dashboardController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link DashboardController#unassignDashboardFromEdge(String, String)}.
   *
   * <p>Method under test: {@link DashboardController#unassignDashboardFromEdge(String, String)}
   */
  @Test
  @DisplayName("Test unassignDashboardFromEdge(String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.Dashboard DashboardController.unassignDashboardFromEdge(String, String)"
  })
  void testUnassignDashboardFromEdge2() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(dashboardController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(
            MockMvcResultMatchers.content()
                .contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(MockMvcResultMatchers.content().string("Body"));
  }

  /**
   * Test {@link DashboardController#unassignDashboardFromEdge(String, String)}.
   *
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isNotFound()}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardController#unassignDashboardFromEdge(String, String)}
   */
  @Test
  @DisplayName("Test unassignDashboardFromEdge(String, String); then status isNotFound()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.Dashboard DashboardController.unassignDashboardFromEdge(String, String)"
  })
  void testUnassignDashboardFromEdge_thenStatusIsNotFound() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(dashboardController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isNotFound());
  }

  /**
   * Test {@link DashboardController#unassignDashboardFromEdge(String, String)}.
   *
   * <ul>
   *   <li>When logout.
   *   <li>Then content contentType {@code application/json}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardController#unassignDashboardFromEdge(String, String)}
   */
  @Test
  @DisplayName(
      "Test unassignDashboardFromEdge(String, String); when logout; then content contentType 'application/json'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.Dashboard DashboardController.unassignDashboardFromEdge(String, String)"
  })
  void testUnassignDashboardFromEdge_whenLogout_thenContentContentTypeApplicationJson()
      throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));
    LogoutRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.logout();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(dashboardController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
        .andExpect(MockMvcResultMatchers.content().string("42"));
  }

  /**
   * Test {@link DashboardController#getEdgeDashboards(String, int, int, String, String, String)}.
   *
   * <p>Method under test: {@link DashboardController#getEdgeDashboards(String, int, int, String,
   * String, String)}
   */
  @Test
  @DisplayName("Test getEdgeDashboards(String, int, int, String, String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData DashboardController.getEdgeDashboards(String, int, int, String, String, String)"
  })
  void testGetEdgeDashboards() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));
    MockHttpServletRequestBuilder getResult =
        MockMvcRequestBuilders.get("/api/edge/{edgeId}/dashboards", "");
    MockHttpServletRequestBuilder paramResult = getResult.param("page", String.valueOf(1));
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(dashboardController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link DashboardController#getEdgeDashboards(String, int, int, String, String, String)}.
   *
   * <ul>
   *   <li>Then content contentType {@code text/plain;charset=ISO-8859-1}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardController#getEdgeDashboards(String, int, int, String,
   * String, String)}
   */
  @Test
  @DisplayName(
      "Test getEdgeDashboards(String, int, int, String, String, String); then content contentType 'text/plain;charset=ISO-8859-1'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData DashboardController.getEdgeDashboards(String, int, int, String, String, String)"
  })
  void testGetEdgeDashboards_thenContentContentTypeTextPlainCharsetIso88591() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));
    MockHttpServletRequestBuilder getResult =
        MockMvcRequestBuilders.get("/api/edge/{edgeId}/dashboards", "");
    MockHttpServletRequestBuilder paramResult = getResult.param("page", String.valueOf(1));
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(dashboardController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
        .andExpect(MockMvcResultMatchers.content().string("Body"));
  }

  /**
   * Test {@link DashboardController#getEdgeDashboards(String, int, int, String, String, String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then status four hundred.
   * </ul>
   *
   * <p>Method under test: {@link DashboardController#getEdgeDashboards(String, int, int, String,
   * String, String)}
   */
  @Test
  @DisplayName(
      "Test getEdgeDashboards(String, int, int, String, String, String); when '42'; then status four hundred")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData DashboardController.getEdgeDashboards(String, int, int, String, String, String)"
  })
  void testGetEdgeDashboards_when42_thenStatusFourHundred() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder paramResult =
        MockMvcRequestBuilders.get("/api/edge/{edgeId}/dashboards", "42")
            .param("page", "https://example.org/example");
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(dashboardController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }
}
