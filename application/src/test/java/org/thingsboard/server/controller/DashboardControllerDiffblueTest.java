package org.thingsboard.server.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.FormLoginRequestBuilder;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.LogoutRequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.StatusResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.request.WebRequest;
import org.thingsboard.server.common.data.Dashboard;
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
        .andExpect(status().isOk());
  }

  /**
   * Test {@link DashboardController#getServerTime()}.
   *
   * <p>Method under test: {@link DashboardController#getServerTime()}
   */
  @Test
  @DisplayName("Test getServerTime()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(content().string("Body"));
  }

  /**
   * Test {@link DashboardController#getMaxDatapointsLimit()}.
   *
   * <p>Method under test: {@link DashboardController#getMaxDatapointsLimit()}
   */
  @Test
  @DisplayName("Test getMaxDatapointsLimit()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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

    BaseImageService imageService =
        new BaseImageService(
            resourceDao,
            resourceInfoDao,
            resourceValidator,
            assetProfileDao,
            deviceProfileDao,
            widgetsBundleDao,
            widgetTypeDao,
            new JpaDashboardInfoDao());

    DashboardController dashboardController =
        new DashboardController(tbDashboardService, imageService);

    // Act and Assert
    assertEquals(0L, dashboardController.getMaxDatapointsLimit());
  }

  /**
   * Test {@link DashboardController#getDashboardInfoById(String)}.
   *
   * <p>Method under test: {@link DashboardController#getDashboardInfoById(String)}
   */
  @Test
  @DisplayName("Test getDashboardInfoById(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DashboardInfo DashboardController.getDashboardInfoById(String)"})
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
        .andExpect(status().isOk());
  }

  /**
   * Test {@link DashboardController#getDashboardInfoById(String)}.
   *
   * <p>Method under test: {@link DashboardController#getDashboardInfoById(String)}
   */
  @Test
  @DisplayName("Test getDashboardInfoById(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DashboardInfo DashboardController.getDashboardInfoById(String)"})
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
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(content().string("Body"));
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DashboardInfo DashboardController.getDashboardInfoById(String)"})
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
        .andExpect(status().isNotFound());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DashboardInfo DashboardController.getDashboardInfoById(String)"})
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
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(content().string("42"));
  }

  /**
   * Test {@link DashboardController#getDashboardById(String, boolean)}.
   *
   * <p>Method under test: {@link DashboardController#getDashboardById(String, boolean)}
   */
  @Test
  @DisplayName("Test getDashboardById(String, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Dashboard DashboardController.getDashboardById(String, boolean)"})
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
        .andExpect(status().isOk());
  }

  /**
   * Test {@link DashboardController#getDashboardById(String, boolean)}.
   *
   * <p>Method under test: {@link DashboardController#getDashboardById(String, boolean)}
   */
  @Test
  @DisplayName("Test getDashboardById(String, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Dashboard DashboardController.getDashboardById(String, boolean)"})
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
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(content().string("Body"));
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Dashboard DashboardController.getDashboardById(String, boolean)"})
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
        .andExpect(status().isNotFound());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Dashboard DashboardController.getDashboardById(String, boolean)"})
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
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(content().string("42"));
  }

  /**
   * Test {@link DashboardController#saveDashboard(Dashboard)}.
   *
   * <p>Method under test: {@link DashboardController#saveDashboard(Dashboard)}
   */
  @Test
  @DisplayName("Test saveDashboard(Dashboard)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Dashboard DashboardController.saveDashboard(Dashboard)"})
  void testSaveDashboard() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

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

    BaseImageService imageService =
        new BaseImageService(
            resourceDao,
            resourceInfoDao,
            resourceValidator,
            assetProfileDao,
            deviceProfileDao,
            widgetsBundleDao,
            widgetTypeDao,
            new JpaDashboardInfoDao());

    DashboardController dashboardController =
        new DashboardController(tbDashboardService, imageService);

    // Act and Assert
    assertThrows(
        ThingsboardException.class, () -> dashboardController.saveDashboard(new Dashboard()));
  }

  /**
   * Test {@link DashboardController#deleteDashboard(String)}.
   *
   * <p>Method under test: {@link DashboardController#deleteDashboard(String)}
   */
  @Test
  @DisplayName("Test deleteDashboard(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
        .andExpect(status().isOk());
  }

  /**
   * Test {@link DashboardController#deleteDashboard(String)}.
   *
   * <p>Method under test: {@link DashboardController#deleteDashboard(String)}
   */
  @Test
  @DisplayName("Test deleteDashboard(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(content().string("Body"));
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
        .andExpect(status().isNotFound());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(content().string("42"));
  }

  /**
   * Test {@link DashboardController#assignDashboardToCustomer(String, String)}.
   *
   * <p>Method under test: {@link DashboardController#assignDashboardToCustomer(String, String)}
   */
  @Test
  @DisplayName("Test assignDashboardToCustomer(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Dashboard DashboardController.assignDashboardToCustomer(String, String)"})
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
        .andExpect(status().isOk());
  }

  /**
   * Test {@link DashboardController#assignDashboardToCustomer(String, String)}.
   *
   * <p>Method under test: {@link DashboardController#assignDashboardToCustomer(String, String)}
   */
  @Test
  @DisplayName("Test assignDashboardToCustomer(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Dashboard DashboardController.assignDashboardToCustomer(String, String)"})
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
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(content().string("Body"));
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Dashboard DashboardController.assignDashboardToCustomer(String, String)"})
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
        .andExpect(status().isNotFound());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Dashboard DashboardController.assignDashboardToCustomer(String, String)"})
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
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(content().string("42"));
  }

  /**
   * Test {@link DashboardController#unassignDashboardFromCustomer(String, String)}.
   *
   * <p>Method under test: {@link DashboardController#unassignDashboardFromCustomer(String, String)}
   */
  @Test
  @DisplayName("Test unassignDashboardFromCustomer(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Dashboard DashboardController.unassignDashboardFromCustomer(String, String)"})
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
        .andExpect(status().isOk());
  }

  /**
   * Test {@link DashboardController#unassignDashboardFromCustomer(String, String)}.
   *
   * <p>Method under test: {@link DashboardController#unassignDashboardFromCustomer(String, String)}
   */
  @Test
  @DisplayName("Test unassignDashboardFromCustomer(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Dashboard DashboardController.unassignDashboardFromCustomer(String, String)"})
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
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(content().string("Body"));
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Dashboard DashboardController.unassignDashboardFromCustomer(String, String)"})
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
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(content().string("42"));
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Dashboard DashboardController.unassignDashboardFromCustomer(String, String)"})
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
        .andExpect(status().isNotFound());
  }

  /**
   * Test {@link DashboardController#updateDashboardCustomers(String, String[])}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardController#updateDashboardCustomers(String, String[])}
   */
  @Test
  @DisplayName("Test updateDashboardCustomers(String, String[]); when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Dashboard DashboardController.updateDashboardCustomers(String, String[])"})
  void testUpdateDashboardCustomers_when42() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

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

    BaseImageService imageService =
        new BaseImageService(
            resourceDao,
            resourceInfoDao,
            resourceValidator,
            assetProfileDao,
            deviceProfileDao,
            widgetsBundleDao,
            widgetTypeDao,
            new JpaDashboardInfoDao());

    DashboardController dashboardController =
        new DashboardController(tbDashboardService, imageService);

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            dashboardController.updateDashboardCustomers("42", new String[] {"Str Customer Ids"}));
  }

  /**
   * Test {@link DashboardController#updateDashboardCustomers(String, String[])}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link DashboardController#updateDashboardCustomers(String, String[])}
   */
  @Test
  @DisplayName("Test updateDashboardCustomers(String, String[]); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Dashboard DashboardController.updateDashboardCustomers(String, String[])"})
  void testUpdateDashboardCustomers_whenEmptyString() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

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

    BaseImageService imageService =
        new BaseImageService(
            resourceDao,
            resourceInfoDao,
            resourceValidator,
            assetProfileDao,
            deviceProfileDao,
            widgetsBundleDao,
            widgetTypeDao,
            new JpaDashboardInfoDao());

    DashboardController dashboardController =
        new DashboardController(tbDashboardService, imageService);

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> dashboardController.updateDashboardCustomers("", new String[] {"Str Customer Ids"}));
  }

  /**
   * Test {@link DashboardController#addDashboardCustomers(String, String[])}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardController#addDashboardCustomers(String, String[])}
   */
  @Test
  @DisplayName("Test addDashboardCustomers(String, String[]); when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Dashboard DashboardController.addDashboardCustomers(String, String[])"})
  void testAddDashboardCustomers_when42() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

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

    BaseImageService imageService =
        new BaseImageService(
            resourceDao,
            resourceInfoDao,
            resourceValidator,
            assetProfileDao,
            deviceProfileDao,
            widgetsBundleDao,
            widgetTypeDao,
            new JpaDashboardInfoDao());

    DashboardController dashboardController =
        new DashboardController(tbDashboardService, imageService);

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> dashboardController.addDashboardCustomers("42", new String[] {"Str Customer Ids"}));
  }

  /**
   * Test {@link DashboardController#addDashboardCustomers(String, String[])}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link DashboardController#addDashboardCustomers(String, String[])}
   */
  @Test
  @DisplayName("Test addDashboardCustomers(String, String[]); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Dashboard DashboardController.addDashboardCustomers(String, String[])"})
  void testAddDashboardCustomers_whenEmptyString() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

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

    BaseImageService imageService =
        new BaseImageService(
            resourceDao,
            resourceInfoDao,
            resourceValidator,
            assetProfileDao,
            deviceProfileDao,
            widgetsBundleDao,
            widgetTypeDao,
            new JpaDashboardInfoDao());

    DashboardController dashboardController =
        new DashboardController(tbDashboardService, imageService);

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> dashboardController.addDashboardCustomers("", new String[] {"Str Customer Ids"}));
  }

  /**
   * Test {@link DashboardController#removeDashboardCustomers(String, String[])}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardController#removeDashboardCustomers(String, String[])}
   */
  @Test
  @DisplayName("Test removeDashboardCustomers(String, String[]); when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Dashboard DashboardController.removeDashboardCustomers(String, String[])"})
  void testRemoveDashboardCustomers_when42() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

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

    BaseImageService imageService =
        new BaseImageService(
            resourceDao,
            resourceInfoDao,
            resourceValidator,
            assetProfileDao,
            deviceProfileDao,
            widgetsBundleDao,
            widgetTypeDao,
            new JpaDashboardInfoDao());

    DashboardController dashboardController =
        new DashboardController(tbDashboardService, imageService);

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            dashboardController.removeDashboardCustomers("42", new String[] {"Str Customer Ids"}));
  }

  /**
   * Test {@link DashboardController#removeDashboardCustomers(String, String[])}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link DashboardController#removeDashboardCustomers(String, String[])}
   */
  @Test
  @DisplayName("Test removeDashboardCustomers(String, String[]); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Dashboard DashboardController.removeDashboardCustomers(String, String[])"})
  void testRemoveDashboardCustomers_whenEmptyString() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

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

    BaseImageService imageService =
        new BaseImageService(
            resourceDao,
            resourceInfoDao,
            resourceValidator,
            assetProfileDao,
            deviceProfileDao,
            widgetsBundleDao,
            widgetTypeDao,
            new JpaDashboardInfoDao());

    DashboardController dashboardController =
        new DashboardController(tbDashboardService, imageService);

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> dashboardController.removeDashboardCustomers("", new String[] {"Str Customer Ids"}));
  }

  /**
   * Test {@link DashboardController#assignDashboardToPublicCustomer(String)}.
   *
   * <p>Method under test: {@link DashboardController#assignDashboardToPublicCustomer(String)}
   */
  @Test
  @DisplayName("Test assignDashboardToPublicCustomer(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Dashboard DashboardController.assignDashboardToPublicCustomer(String)"})
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
        .andExpect(status().isOk());
  }

  /**
   * Test {@link DashboardController#assignDashboardToPublicCustomer(String)}.
   *
   * <p>Method under test: {@link DashboardController#assignDashboardToPublicCustomer(String)}
   */
  @Test
  @DisplayName("Test assignDashboardToPublicCustomer(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Dashboard DashboardController.assignDashboardToPublicCustomer(String)"})
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
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(content().string("Body"));
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Dashboard DashboardController.assignDashboardToPublicCustomer(String)"})
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
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(content().string("42"));
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Dashboard DashboardController.assignDashboardToPublicCustomer(String)"})
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
        .andExpect(status().isNotFound());
  }

  /**
   * Test {@link DashboardController#unassignDashboardFromPublicCustomer(String)}.
   *
   * <p>Method under test: {@link DashboardController#unassignDashboardFromPublicCustomer(String)}
   */
  @Test
  @DisplayName("Test unassignDashboardFromPublicCustomer(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Dashboard DashboardController.unassignDashboardFromPublicCustomer(String)"})
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
        .andExpect(status().isOk());
  }

  /**
   * Test {@link DashboardController#unassignDashboardFromPublicCustomer(String)}.
   *
   * <p>Method under test: {@link DashboardController#unassignDashboardFromPublicCustomer(String)}
   */
  @Test
  @DisplayName("Test unassignDashboardFromPublicCustomer(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Dashboard DashboardController.unassignDashboardFromPublicCustomer(String)"})
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
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(content().string("Body"));
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Dashboard DashboardController.unassignDashboardFromPublicCustomer(String)"})
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
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(content().string("42"));
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Dashboard DashboardController.unassignDashboardFromPublicCustomer(String)"})
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
        .andExpect(status().isNotFound());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData DashboardController.getTenantDashboards(int, int, Boolean, String, String, String)"
  })
  void testGetTenantDashboardsWithPageSizePageMobileTextSearchSortPropertySortOrder()
      throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

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

    BaseImageService imageService =
        new BaseImageService(
            resourceDao,
            resourceInfoDao,
            resourceValidator,
            assetProfileDao,
            deviceProfileDao,
            widgetsBundleDao,
            widgetTypeDao,
            new JpaDashboardInfoDao());

    DashboardController dashboardController =
        new DashboardController(tbDashboardService, imageService);

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            dashboardController.getTenantDashboards(
                3, 1, true, "Text Search", "Sort Property", "asc"));
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData DashboardController.getTenantDashboards(String, int, int, String, String, String)"
  })
  void testGetTenantDashboardsWithStrTenantIdPageSizePageTextSearchSortPropertySortOrder()
      throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/tenant/{tenantId}/dashboards", "")
            .param("page", String.valueOf(1))
            .param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(dashboardController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData DashboardController.getTenantDashboards(String, int, int, String, String, String)"
  })
  void testGetTenantDashboardsWithStrTenantIdPageSizePageTextSearchSortPropertySortOrder2()
      throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/tenant/{tenantId}/dashboards", "")
            .param("page", String.valueOf(1))
            .param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(dashboardController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("text/plain;charset=ISO-8859-1"))
        .andExpect(content().string("Body"));
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData DashboardController.getCustomerDashboards(String, int, int, Boolean, String, String, String)"
  })
  void testGetCustomerDashboards() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/customer/{customerId}/dashboards", "")
            .param("page", String.valueOf(1))
            .param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(dashboardController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData DashboardController.getCustomerDashboards(String, int, int, Boolean, String, String, String)"
  })
  void testGetCustomerDashboards_thenContentContentTypeTextPlainCharsetIso88591() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/customer/{customerId}/dashboards", "")
            .param("page", String.valueOf(1))
            .param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(dashboardController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("text/plain;charset=ISO-8859-1"))
        .andExpect(content().string("Body"));
  }

  /**
   * Test {@link DashboardController#getHomeDashboard()}.
   *
   * <p>Method under test: {@link DashboardController#getHomeDashboard()}
   */
  @Test
  @DisplayName("Test getHomeDashboard()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
        .andExpect(status().isOk());
  }

  /**
   * Test {@link DashboardController#getHomeDashboard()}.
   *
   * <p>Method under test: {@link DashboardController#getHomeDashboard()}
   */
  @Test
  @DisplayName("Test getHomeDashboard()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(content().string("Body"));
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
        .andExpect(status().isNotFound());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(content().string("42"));
  }

  /**
   * Test {@link DashboardController#getHomeDashboardInfo()}.
   *
   * <p>Method under test: {@link DashboardController#getHomeDashboardInfo()}
   */
  @Test
  @DisplayName("Test getHomeDashboardInfo()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
        .andExpect(status().isOk());
  }

  /**
   * Test {@link DashboardController#getHomeDashboardInfo()}.
   *
   * <p>Method under test: {@link DashboardController#getHomeDashboardInfo()}
   */
  @Test
  @DisplayName("Test getHomeDashboardInfo()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(content().string("Body"));
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
        .andExpect(status().isNotFound());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(content().string("42"));
  }

  /**
   * Test {@link DashboardController#getTenantHomeDashboardInfo()}.
   *
   * <p>Method under test: {@link DashboardController#getTenantHomeDashboardInfo()}
   */
  @Test
  @DisplayName("Test getTenantHomeDashboardInfo()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
        .andExpect(status().isOk());
  }

  /**
   * Test {@link DashboardController#getTenantHomeDashboardInfo()}.
   *
   * <p>Method under test: {@link DashboardController#getTenantHomeDashboardInfo()}
   */
  @Test
  @DisplayName("Test getTenantHomeDashboardInfo()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(content().string("Body"));
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
        .andExpect(status().isNotFound());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(content().string("42"));
  }

  /**
   * Test {@link DashboardController#setTenantHomeDashboardInfo(HomeDashboardInfo)}.
   *
   * <ul>
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardController#setTenantHomeDashboardInfo(HomeDashboardInfo)}
   */
  @Test
  @DisplayName(
      "Test setTenantHomeDashboardInfo(HomeDashboardInfo); then throw ThingsboardException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DashboardController.setTenantHomeDashboardInfo(HomeDashboardInfo)"})
  void testSetTenantHomeDashboardInfo_thenThrowThingsboardException() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

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

    BaseImageService imageService =
        new BaseImageService(
            resourceDao,
            resourceInfoDao,
            resourceValidator,
            assetProfileDao,
            deviceProfileDao,
            widgetsBundleDao,
            widgetTypeDao,
            new JpaDashboardInfoDao());

    DashboardController dashboardController =
        new DashboardController(tbDashboardService, imageService);

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> dashboardController.setTenantHomeDashboardInfo(new HomeDashboardInfo(null, true)));
  }

  /**
   * Test {@link DashboardController#assignDashboardToEdge(String, String)}.
   *
   * <p>Method under test: {@link DashboardController#assignDashboardToEdge(String, String)}
   */
  @Test
  @DisplayName("Test assignDashboardToEdge(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Dashboard DashboardController.assignDashboardToEdge(String, String)"})
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
        .andExpect(status().isOk());
  }

  /**
   * Test {@link DashboardController#assignDashboardToEdge(String, String)}.
   *
   * <p>Method under test: {@link DashboardController#assignDashboardToEdge(String, String)}
   */
  @Test
  @DisplayName("Test assignDashboardToEdge(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Dashboard DashboardController.assignDashboardToEdge(String, String)"})
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
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(content().string("Body"));
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Dashboard DashboardController.assignDashboardToEdge(String, String)"})
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
        .andExpect(status().isNotFound());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Dashboard DashboardController.assignDashboardToEdge(String, String)"})
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
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(content().string("42"));
  }

  /**
   * Test {@link DashboardController#unassignDashboardFromEdge(String, String)}.
   *
   * <p>Method under test: {@link DashboardController#unassignDashboardFromEdge(String, String)}
   */
  @Test
  @DisplayName("Test unassignDashboardFromEdge(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Dashboard DashboardController.unassignDashboardFromEdge(String, String)"})
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
        .andExpect(status().isOk());
  }

  /**
   * Test {@link DashboardController#unassignDashboardFromEdge(String, String)}.
   *
   * <p>Method under test: {@link DashboardController#unassignDashboardFromEdge(String, String)}
   */
  @Test
  @DisplayName("Test unassignDashboardFromEdge(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Dashboard DashboardController.unassignDashboardFromEdge(String, String)"})
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
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(content().string("Body"));
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Dashboard DashboardController.unassignDashboardFromEdge(String, String)"})
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
        .andExpect(status().isNotFound());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Dashboard DashboardController.unassignDashboardFromEdge(String, String)"})
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
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(content().string("42"));
  }

  /**
   * Test {@link DashboardController#getEdgeDashboards(String, int, int, String, String, String)}.
   *
   * <p>Method under test: {@link DashboardController#getEdgeDashboards(String, int, int, String,
   * String, String)}
   */
  @Test
  @DisplayName("Test getEdgeDashboards(String, int, int, String, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData DashboardController.getEdgeDashboards(String, int, int, String, String, String)"
  })
  void testGetEdgeDashboards() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/edge/{edgeId}/dashboards", "")
            .param("page", String.valueOf(1))
            .param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(dashboardController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData DashboardController.getEdgeDashboards(String, int, int, String, String, String)"
  })
  void testGetEdgeDashboards_thenContentContentTypeTextPlainCharsetIso88591() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/edge/{edgeId}/dashboards", "")
            .param("page", String.valueOf(1))
            .param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(dashboardController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("text/plain;charset=ISO-8859-1"))
        .andExpect(content().string("Body"));
  }
}
