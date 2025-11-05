package org.thingsboard.server.controller;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
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
import org.thingsboard.server.common.data.TenantProfile;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.common.data.id.TenantProfileId;
import org.thingsboard.server.dao.edge.EdgeServiceImpl;
import org.thingsboard.server.dao.queue.BaseQueueService;
import org.thingsboard.server.dao.tenant.DefaultTbTenantProfileCache;
import org.thingsboard.server.dao.tenant.TenantProfileServiceImpl;
import org.thingsboard.server.dao.tenant.TenantServiceImpl;
import org.thingsboard.server.exception.ThingsboardErrorResponseHandler;
import org.thingsboard.server.queue.discovery.TopicService;
import org.thingsboard.server.service.entitiy.queue.DefaultTbQueueService;
import org.thingsboard.server.service.entitiy.tenant.profile.DefaultTbTenantProfileService;
import org.thingsboard.server.service.gateway_device.DefaultGatewayNotificationsService;
import org.thingsboard.server.service.queue.DefaultTbClusterService;

@ExtendWith(MockitoExtension.class)
class TenantProfileControllerDiffblueTest {
  @InjectMocks private TenantProfileController tenantProfileController;

  @Mock private ThingsboardErrorResponseHandler thingsboardErrorResponseHandler;

  /**
   * Test {@link TenantProfileController#getTenantProfileById(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileController#getTenantProfileById(String)}
   */
  @Test
  @DisplayName("Test getTenantProfileById(String); when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TenantProfile TenantProfileController.getTenantProfileById(String)"})
  void testGetTenantProfileById_when42() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    BaseQueueService queueService = new BaseQueueService();
    TopicService topicService = new TopicService();
    DefaultGatewayNotificationsService gatewayNotificationsService =
        new DefaultGatewayNotificationsService();

    DefaultTbClusterService tbClusterService =
        new DefaultTbClusterService(
            topicService, null, null, gatewayNotificationsService, new EdgeServiceImpl(), null);

    DefaultTbQueueService tbQueueService =
        new DefaultTbQueueService(queueService, tbClusterService, null);
    TenantProfileServiceImpl tenantProfileService = new TenantProfileServiceImpl();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    TenantProfileServiceImpl tenantProfileService2 = new TenantProfileServiceImpl();
    DefaultTbTenantProfileCache tenantProfileCache =
        new DefaultTbTenantProfileCache(tenantProfileService2, new TenantServiceImpl());

    DefaultTbTenantProfileService tbTenantProfileService =
        new DefaultTbTenantProfileService(
            tbQueueService, tenantProfileService, tenantService, tenantProfileCache);

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> new TenantProfileController(tbTenantProfileService).getTenantProfileById("42"));
  }

  /**
   * Test {@link TenantProfileController#getTenantProfileById(String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileController#getTenantProfileById(String)}
   */
  @Test
  @DisplayName("Test getTenantProfileById(String); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TenantProfile TenantProfileController.getTenantProfileById(String)"})
  void testGetTenantProfileById_whenEmptyString() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    BaseQueueService queueService = new BaseQueueService();
    TopicService topicService = new TopicService();
    DefaultGatewayNotificationsService gatewayNotificationsService =
        new DefaultGatewayNotificationsService();

    DefaultTbClusterService tbClusterService =
        new DefaultTbClusterService(
            topicService, null, null, gatewayNotificationsService, new EdgeServiceImpl(), null);

    DefaultTbQueueService tbQueueService =
        new DefaultTbQueueService(queueService, tbClusterService, null);
    TenantProfileServiceImpl tenantProfileService = new TenantProfileServiceImpl();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    TenantProfileServiceImpl tenantProfileService2 = new TenantProfileServiceImpl();
    DefaultTbTenantProfileCache tenantProfileCache =
        new DefaultTbTenantProfileCache(tenantProfileService2, new TenantServiceImpl());

    DefaultTbTenantProfileService tbTenantProfileService =
        new DefaultTbTenantProfileService(
            tbQueueService, tenantProfileService, tenantService, tenantProfileCache);

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> new TenantProfileController(tbTenantProfileService).getTenantProfileById(""));
  }

  /**
   * Test {@link TenantProfileController#getTenantProfileInfoById(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileController#getTenantProfileInfoById(String)}
   */
  @Test
  @DisplayName("Test getTenantProfileInfoById(String); when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.EntityInfo TenantProfileController.getTenantProfileInfoById(String)"
  })
  void testGetTenantProfileInfoById_when42() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    BaseQueueService queueService = new BaseQueueService();
    TopicService topicService = new TopicService();
    DefaultGatewayNotificationsService gatewayNotificationsService =
        new DefaultGatewayNotificationsService();

    DefaultTbClusterService tbClusterService =
        new DefaultTbClusterService(
            topicService, null, null, gatewayNotificationsService, new EdgeServiceImpl(), null);

    DefaultTbQueueService tbQueueService =
        new DefaultTbQueueService(queueService, tbClusterService, null);
    TenantProfileServiceImpl tenantProfileService = new TenantProfileServiceImpl();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    TenantProfileServiceImpl tenantProfileService2 = new TenantProfileServiceImpl();
    DefaultTbTenantProfileCache tenantProfileCache =
        new DefaultTbTenantProfileCache(tenantProfileService2, new TenantServiceImpl());

    DefaultTbTenantProfileService tbTenantProfileService =
        new DefaultTbTenantProfileService(
            tbQueueService, tenantProfileService, tenantService, tenantProfileCache);

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> new TenantProfileController(tbTenantProfileService).getTenantProfileInfoById("42"));
  }

  /**
   * Test {@link TenantProfileController#getTenantProfileInfoById(String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileController#getTenantProfileInfoById(String)}
   */
  @Test
  @DisplayName("Test getTenantProfileInfoById(String); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.EntityInfo TenantProfileController.getTenantProfileInfoById(String)"
  })
  void testGetTenantProfileInfoById_whenEmptyString() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    BaseQueueService queueService = new BaseQueueService();
    TopicService topicService = new TopicService();
    DefaultGatewayNotificationsService gatewayNotificationsService =
        new DefaultGatewayNotificationsService();

    DefaultTbClusterService tbClusterService =
        new DefaultTbClusterService(
            topicService, null, null, gatewayNotificationsService, new EdgeServiceImpl(), null);

    DefaultTbQueueService tbQueueService =
        new DefaultTbQueueService(queueService, tbClusterService, null);
    TenantProfileServiceImpl tenantProfileService = new TenantProfileServiceImpl();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    TenantProfileServiceImpl tenantProfileService2 = new TenantProfileServiceImpl();
    DefaultTbTenantProfileCache tenantProfileCache =
        new DefaultTbTenantProfileCache(tenantProfileService2, new TenantServiceImpl());

    DefaultTbTenantProfileService tbTenantProfileService =
        new DefaultTbTenantProfileService(
            tbQueueService, tenantProfileService, tenantService, tenantProfileCache);

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> new TenantProfileController(tbTenantProfileService).getTenantProfileInfoById(""));
  }

  /**
   * Test {@link TenantProfileController#getDefaultTenantProfileInfo()}.
   *
   * <p>Method under test: {@link TenantProfileController#getDefaultTenantProfileInfo()}
   */
  @Test
  @DisplayName("Test getDefaultTenantProfileInfo()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.EntityInfo TenantProfileController.getDefaultTenantProfileInfo()"
  })
  void testGetDefaultTenantProfileInfo() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    BaseQueueService queueService = new BaseQueueService();
    TopicService topicService = new TopicService();
    DefaultGatewayNotificationsService gatewayNotificationsService =
        new DefaultGatewayNotificationsService();

    DefaultTbClusterService tbClusterService =
        new DefaultTbClusterService(
            topicService, null, null, gatewayNotificationsService, new EdgeServiceImpl(), null);

    DefaultTbQueueService tbQueueService =
        new DefaultTbQueueService(queueService, tbClusterService, null);
    TenantProfileServiceImpl tenantProfileService = new TenantProfileServiceImpl();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    TenantProfileServiceImpl tenantProfileService2 = new TenantProfileServiceImpl();
    DefaultTbTenantProfileCache tenantProfileCache =
        new DefaultTbTenantProfileCache(tenantProfileService2, new TenantServiceImpl());

    DefaultTbTenantProfileService tbTenantProfileService =
        new DefaultTbTenantProfileService(
            tbQueueService, tenantProfileService, tenantService, tenantProfileCache);

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> new TenantProfileController(tbTenantProfileService).getDefaultTenantProfileInfo());
  }

  /**
   * Test {@link TenantProfileController#saveTenantProfile(TenantProfile)}.
   *
   * <p>Method under test: {@link TenantProfileController#saveTenantProfile(TenantProfile)}
   */
  @Test
  @DisplayName("Test saveTenantProfile(TenantProfile)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TenantProfile TenantProfileController.saveTenantProfile(TenantProfile)"})
  void testSaveTenantProfile() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    BaseQueueService queueService = new BaseQueueService();
    TopicService topicService = new TopicService();
    DefaultGatewayNotificationsService gatewayNotificationsService =
        new DefaultGatewayNotificationsService();

    DefaultTbClusterService tbClusterService =
        new DefaultTbClusterService(
            topicService, null, null, gatewayNotificationsService, new EdgeServiceImpl(), null);

    DefaultTbQueueService tbQueueService =
        new DefaultTbQueueService(queueService, tbClusterService, null);
    TenantProfileServiceImpl tenantProfileService = new TenantProfileServiceImpl();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    TenantProfileServiceImpl tenantProfileService2 = new TenantProfileServiceImpl();
    DefaultTbTenantProfileCache tenantProfileCache =
        new DefaultTbTenantProfileCache(tenantProfileService2, new TenantServiceImpl());

    DefaultTbTenantProfileService tbTenantProfileService =
        new DefaultTbTenantProfileService(
            tbQueueService, tenantProfileService, tenantService, tenantProfileCache);
    TenantProfileController tenantProfileController =
        new TenantProfileController(tbTenantProfileService);

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> tenantProfileController.saveTenantProfile(new TenantProfile()));
  }

  /**
   * Test {@link TenantProfileController#saveTenantProfile(TenantProfile)}.
   *
   * <p>Method under test: {@link TenantProfileController#saveTenantProfile(TenantProfile)}
   */
  @Test
  @DisplayName("Test saveTenantProfile(TenantProfile)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TenantProfile TenantProfileController.saveTenantProfile(TenantProfile)"})
  void testSaveTenantProfile2() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    TenantProfileId tenantProfileId =
        new TenantProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> tenantProfileController.saveTenantProfile(new TenantProfile(tenantProfileId)));
  }

  /**
   * Test {@link TenantProfileController#saveTenantProfile(TenantProfile)}.
   *
   * <ul>
   *   <li>When {@link TenantProfileId#TenantProfileId(UUID)} with id is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileController#saveTenantProfile(TenantProfile)}
   */
  @Test
  @DisplayName(
      "Test saveTenantProfile(TenantProfile); when TenantProfileId(UUID) with id is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TenantProfile TenantProfileController.saveTenantProfile(TenantProfile)"})
  void testSaveTenantProfile_whenTenantProfileIdWithIdIsNull() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange, Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            tenantProfileController.saveTenantProfile(
                new TenantProfile(new TenantProfileId(null))));
  }

  /**
   * Test {@link TenantProfileController#deleteTenantProfile(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileController#deleteTenantProfile(String)}
   */
  @Test
  @DisplayName("Test deleteTenantProfile(String); when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TenantProfileController.deleteTenantProfile(String)"})
  void testDeleteTenantProfile_when42() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    BaseQueueService queueService = new BaseQueueService();
    TopicService topicService = new TopicService();
    DefaultGatewayNotificationsService gatewayNotificationsService =
        new DefaultGatewayNotificationsService();

    DefaultTbClusterService tbClusterService =
        new DefaultTbClusterService(
            topicService, null, null, gatewayNotificationsService, new EdgeServiceImpl(), null);

    DefaultTbQueueService tbQueueService =
        new DefaultTbQueueService(queueService, tbClusterService, null);
    TenantProfileServiceImpl tenantProfileService = new TenantProfileServiceImpl();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    TenantProfileServiceImpl tenantProfileService2 = new TenantProfileServiceImpl();
    DefaultTbTenantProfileCache tenantProfileCache =
        new DefaultTbTenantProfileCache(tenantProfileService2, new TenantServiceImpl());

    DefaultTbTenantProfileService tbTenantProfileService =
        new DefaultTbTenantProfileService(
            tbQueueService, tenantProfileService, tenantService, tenantProfileCache);

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> new TenantProfileController(tbTenantProfileService).deleteTenantProfile("42"));
  }

  /**
   * Test {@link TenantProfileController#deleteTenantProfile(String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileController#deleteTenantProfile(String)}
   */
  @Test
  @DisplayName("Test deleteTenantProfile(String); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TenantProfileController.deleteTenantProfile(String)"})
  void testDeleteTenantProfile_whenEmptyString() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    BaseQueueService queueService = new BaseQueueService();
    TopicService topicService = new TopicService();
    DefaultGatewayNotificationsService gatewayNotificationsService =
        new DefaultGatewayNotificationsService();

    DefaultTbClusterService tbClusterService =
        new DefaultTbClusterService(
            topicService, null, null, gatewayNotificationsService, new EdgeServiceImpl(), null);

    DefaultTbQueueService tbQueueService =
        new DefaultTbQueueService(queueService, tbClusterService, null);
    TenantProfileServiceImpl tenantProfileService = new TenantProfileServiceImpl();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    TenantProfileServiceImpl tenantProfileService2 = new TenantProfileServiceImpl();
    DefaultTbTenantProfileCache tenantProfileCache =
        new DefaultTbTenantProfileCache(tenantProfileService2, new TenantServiceImpl());

    DefaultTbTenantProfileService tbTenantProfileService =
        new DefaultTbTenantProfileService(
            tbQueueService, tenantProfileService, tenantService, tenantProfileCache);

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> new TenantProfileController(tbTenantProfileService).deleteTenantProfile(""));
  }

  /**
   * Test {@link TenantProfileController#setDefaultTenantProfile(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileController#setDefaultTenantProfile(String)}
   */
  @Test
  @DisplayName("Test setDefaultTenantProfile(String); when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TenantProfile TenantProfileController.setDefaultTenantProfile(String)"})
  void testSetDefaultTenantProfile_when42() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    BaseQueueService queueService = new BaseQueueService();
    TopicService topicService = new TopicService();
    DefaultGatewayNotificationsService gatewayNotificationsService =
        new DefaultGatewayNotificationsService();

    DefaultTbClusterService tbClusterService =
        new DefaultTbClusterService(
            topicService, null, null, gatewayNotificationsService, new EdgeServiceImpl(), null);

    DefaultTbQueueService tbQueueService =
        new DefaultTbQueueService(queueService, tbClusterService, null);
    TenantProfileServiceImpl tenantProfileService = new TenantProfileServiceImpl();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    TenantProfileServiceImpl tenantProfileService2 = new TenantProfileServiceImpl();
    DefaultTbTenantProfileCache tenantProfileCache =
        new DefaultTbTenantProfileCache(tenantProfileService2, new TenantServiceImpl());

    DefaultTbTenantProfileService tbTenantProfileService =
        new DefaultTbTenantProfileService(
            tbQueueService, tenantProfileService, tenantService, tenantProfileCache);

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> new TenantProfileController(tbTenantProfileService).setDefaultTenantProfile("42"));
  }

  /**
   * Test {@link TenantProfileController#setDefaultTenantProfile(String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileController#setDefaultTenantProfile(String)}
   */
  @Test
  @DisplayName("Test setDefaultTenantProfile(String); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TenantProfile TenantProfileController.setDefaultTenantProfile(String)"})
  void testSetDefaultTenantProfile_whenEmptyString() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    BaseQueueService queueService = new BaseQueueService();
    TopicService topicService = new TopicService();
    DefaultGatewayNotificationsService gatewayNotificationsService =
        new DefaultGatewayNotificationsService();

    DefaultTbClusterService tbClusterService =
        new DefaultTbClusterService(
            topicService, null, null, gatewayNotificationsService, new EdgeServiceImpl(), null);

    DefaultTbQueueService tbQueueService =
        new DefaultTbQueueService(queueService, tbClusterService, null);
    TenantProfileServiceImpl tenantProfileService = new TenantProfileServiceImpl();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    TenantProfileServiceImpl tenantProfileService2 = new TenantProfileServiceImpl();
    DefaultTbTenantProfileCache tenantProfileCache =
        new DefaultTbTenantProfileCache(tenantProfileService2, new TenantServiceImpl());

    DefaultTbTenantProfileService tbTenantProfileService =
        new DefaultTbTenantProfileService(
            tbQueueService, tenantProfileService, tenantService, tenantProfileCache);

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> new TenantProfileController(tbTenantProfileService).setDefaultTenantProfile(""));
  }

  /**
   * Test {@link TenantProfileController#setDefaultTenantProfile(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileController#setDefaultTenantProfile(String)}
   */
  @Test
  @DisplayName("Test setDefaultTenantProfile(String); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TenantProfile TenantProfileController.setDefaultTenantProfile(String)"})
  void testSetDefaultTenantProfile_whenNull() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    BaseQueueService queueService = new BaseQueueService();
    TopicService topicService = new TopicService();
    DefaultGatewayNotificationsService gatewayNotificationsService =
        new DefaultGatewayNotificationsService();

    DefaultTbClusterService tbClusterService =
        new DefaultTbClusterService(
            topicService, null, null, gatewayNotificationsService, new EdgeServiceImpl(), null);

    DefaultTbQueueService tbQueueService =
        new DefaultTbQueueService(queueService, tbClusterService, null);
    TenantProfileServiceImpl tenantProfileService = new TenantProfileServiceImpl();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    TenantProfileServiceImpl tenantProfileService2 = new TenantProfileServiceImpl();
    DefaultTbTenantProfileCache tenantProfileCache =
        new DefaultTbTenantProfileCache(tenantProfileService2, new TenantServiceImpl());

    DefaultTbTenantProfileService tbTenantProfileService =
        new DefaultTbTenantProfileService(
            tbQueueService, tenantProfileService, tenantService, tenantProfileCache);

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> new TenantProfileController(tbTenantProfileService).setDefaultTenantProfile(null));
  }

  /**
   * Test {@link TenantProfileController#getTenantProfiles(int, int, String, String, String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileController#getTenantProfiles(int, int, String,
   * String, String)}
   */
  @Test
  @DisplayName(
      "Test getTenantProfiles(int, int, String, String, String); when empty string; then throw ThingsboardException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData TenantProfileController.getTenantProfiles(int, int, String, String, String)"
  })
  void testGetTenantProfiles_whenEmptyString_thenThrowThingsboardException()
      throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    BaseQueueService queueService = new BaseQueueService();
    TopicService topicService = new TopicService();
    DefaultGatewayNotificationsService gatewayNotificationsService =
        new DefaultGatewayNotificationsService();

    DefaultTbClusterService tbClusterService =
        new DefaultTbClusterService(
            topicService, null, null, gatewayNotificationsService, new EdgeServiceImpl(), null);

    DefaultTbQueueService tbQueueService =
        new DefaultTbQueueService(queueService, tbClusterService, null);
    TenantProfileServiceImpl tenantProfileService = new TenantProfileServiceImpl();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    TenantProfileServiceImpl tenantProfileService2 = new TenantProfileServiceImpl();
    DefaultTbTenantProfileCache tenantProfileCache =
        new DefaultTbTenantProfileCache(tenantProfileService2, new TenantServiceImpl());

    DefaultTbTenantProfileService tbTenantProfileService =
        new DefaultTbTenantProfileService(
            tbQueueService, tenantProfileService, tenantService, tenantProfileCache);

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            new TenantProfileController(tbTenantProfileService)
                .getTenantProfiles(3, 1, "Text Search", "", "asc"));
  }

  /**
   * Test {@link TenantProfileController#getTenantProfiles(int, int, String, String, String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileController#getTenantProfiles(int, int, String,
   * String, String)}
   */
  @Test
  @DisplayName(
      "Test getTenantProfiles(int, int, String, String, String); when empty string; then throw ThingsboardException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData TenantProfileController.getTenantProfiles(int, int, String, String, String)"
  })
  void testGetTenantProfiles_whenEmptyString_thenThrowThingsboardException2()
      throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    BaseQueueService queueService = new BaseQueueService();
    TopicService topicService = new TopicService();
    DefaultGatewayNotificationsService gatewayNotificationsService =
        new DefaultGatewayNotificationsService();

    DefaultTbClusterService tbClusterService =
        new DefaultTbClusterService(
            topicService, null, null, gatewayNotificationsService, new EdgeServiceImpl(), null);

    DefaultTbQueueService tbQueueService =
        new DefaultTbQueueService(queueService, tbClusterService, null);
    TenantProfileServiceImpl tenantProfileService = new TenantProfileServiceImpl();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    TenantProfileServiceImpl tenantProfileService2 = new TenantProfileServiceImpl();
    DefaultTbTenantProfileCache tenantProfileCache =
        new DefaultTbTenantProfileCache(tenantProfileService2, new TenantServiceImpl());

    DefaultTbTenantProfileService tbTenantProfileService =
        new DefaultTbTenantProfileService(
            tbQueueService, tenantProfileService, tenantService, tenantProfileCache);

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            new TenantProfileController(tbTenantProfileService)
                .getTenantProfiles(3, 1, "Text Search", "U", ""));
  }

  /**
   * Test {@link TenantProfileController#getTenantProfiles(int, int, String, String, String)}.
   *
   * <ul>
   *   <li>When {@code Sort Property}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileController#getTenantProfiles(int, int, String,
   * String, String)}
   */
  @Test
  @DisplayName(
      "Test getTenantProfiles(int, int, String, String, String); when 'Sort Property'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData TenantProfileController.getTenantProfiles(int, int, String, String, String)"
  })
  void testGetTenantProfiles_whenSortProperty_thenThrowIllegalArgumentException()
      throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    BaseQueueService queueService = new BaseQueueService();
    TopicService topicService = new TopicService();
    DefaultGatewayNotificationsService gatewayNotificationsService =
        new DefaultGatewayNotificationsService();

    DefaultTbClusterService tbClusterService =
        new DefaultTbClusterService(
            topicService, null, null, gatewayNotificationsService, new EdgeServiceImpl(), null);

    DefaultTbQueueService tbQueueService =
        new DefaultTbQueueService(queueService, tbClusterService, null);
    TenantProfileServiceImpl tenantProfileService = new TenantProfileServiceImpl();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    TenantProfileServiceImpl tenantProfileService2 = new TenantProfileServiceImpl();
    DefaultTbTenantProfileCache tenantProfileCache =
        new DefaultTbTenantProfileCache(tenantProfileService2, new TenantServiceImpl());

    DefaultTbTenantProfileService tbTenantProfileService =
        new DefaultTbTenantProfileService(
            tbQueueService, tenantProfileService, tenantService, tenantProfileCache);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new TenantProfileController(tbTenantProfileService)
                .getTenantProfiles(3, 1, "Text Search", "Sort Property", "asc"));
  }

  /**
   * Test {@link TenantProfileController#getTenantProfiles(int, int, String, String, String)}.
   *
   * <ul>
   *   <li>When {@code U}.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileController#getTenantProfiles(int, int, String,
   * String, String)}
   */
  @Test
  @DisplayName(
      "Test getTenantProfiles(int, int, String, String, String); when 'U'; then throw ThingsboardException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData TenantProfileController.getTenantProfiles(int, int, String, String, String)"
  })
  void testGetTenantProfiles_whenU_thenThrowThingsboardException() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    BaseQueueService queueService = new BaseQueueService();
    TopicService topicService = new TopicService();
    DefaultGatewayNotificationsService gatewayNotificationsService =
        new DefaultGatewayNotificationsService();

    DefaultTbClusterService tbClusterService =
        new DefaultTbClusterService(
            topicService, null, null, gatewayNotificationsService, new EdgeServiceImpl(), null);

    DefaultTbQueueService tbQueueService =
        new DefaultTbQueueService(queueService, tbClusterService, null);
    TenantProfileServiceImpl tenantProfileService = new TenantProfileServiceImpl();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    TenantProfileServiceImpl tenantProfileService2 = new TenantProfileServiceImpl();
    DefaultTbTenantProfileCache tenantProfileCache =
        new DefaultTbTenantProfileCache(tenantProfileService2, new TenantServiceImpl());

    DefaultTbTenantProfileService tbTenantProfileService =
        new DefaultTbTenantProfileService(
            tbQueueService, tenantProfileService, tenantService, tenantProfileCache);

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            new TenantProfileController(tbTenantProfileService)
                .getTenantProfiles(3, 1, "Text Search", "U", "asc"));
  }

  /**
   * Test {@link TenantProfileController#getTenantProfiles(int, int, String, String, String)}.
   *
   * <ul>
   *   <li>When {@code U}.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileController#getTenantProfiles(int, int, String,
   * String, String)}
   */
  @Test
  @DisplayName(
      "Test getTenantProfiles(int, int, String, String, String); when 'U'; then throw ThingsboardException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData TenantProfileController.getTenantProfiles(int, int, String, String, String)"
  })
  void testGetTenantProfiles_whenU_thenThrowThingsboardException2() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    BaseQueueService queueService = new BaseQueueService();
    TopicService topicService = new TopicService();
    DefaultGatewayNotificationsService gatewayNotificationsService =
        new DefaultGatewayNotificationsService();

    DefaultTbClusterService tbClusterService =
        new DefaultTbClusterService(
            topicService, null, null, gatewayNotificationsService, new EdgeServiceImpl(), null);

    DefaultTbQueueService tbQueueService =
        new DefaultTbQueueService(queueService, tbClusterService, null);
    TenantProfileServiceImpl tenantProfileService = new TenantProfileServiceImpl();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    TenantProfileServiceImpl tenantProfileService2 = new TenantProfileServiceImpl();
    DefaultTbTenantProfileCache tenantProfileCache =
        new DefaultTbTenantProfileCache(tenantProfileService2, new TenantServiceImpl());

    DefaultTbTenantProfileService tbTenantProfileService =
        new DefaultTbTenantProfileService(
            tbQueueService, tenantProfileService, tenantService, tenantProfileCache);

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            new TenantProfileController(tbTenantProfileService)
                .getTenantProfiles(3, 1, "Text Search", "U", "U"));
  }

  /**
   * Test {@link TenantProfileController#getTenantProfileInfos(int, int, String, String, String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileController#getTenantProfileInfos(int, int, String,
   * String, String)}
   */
  @Test
  @DisplayName(
      "Test getTenantProfileInfos(int, int, String, String, String); when empty string; then throw ThingsboardException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData TenantProfileController.getTenantProfileInfos(int, int, String, String, String)"
  })
  void testGetTenantProfileInfos_whenEmptyString_thenThrowThingsboardException()
      throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    BaseQueueService queueService = new BaseQueueService();
    TopicService topicService = new TopicService();
    DefaultGatewayNotificationsService gatewayNotificationsService =
        new DefaultGatewayNotificationsService();

    DefaultTbClusterService tbClusterService =
        new DefaultTbClusterService(
            topicService, null, null, gatewayNotificationsService, new EdgeServiceImpl(), null);

    DefaultTbQueueService tbQueueService =
        new DefaultTbQueueService(queueService, tbClusterService, null);
    TenantProfileServiceImpl tenantProfileService = new TenantProfileServiceImpl();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    TenantProfileServiceImpl tenantProfileService2 = new TenantProfileServiceImpl();
    DefaultTbTenantProfileCache tenantProfileCache =
        new DefaultTbTenantProfileCache(tenantProfileService2, new TenantServiceImpl());

    DefaultTbTenantProfileService tbTenantProfileService =
        new DefaultTbTenantProfileService(
            tbQueueService, tenantProfileService, tenantService, tenantProfileCache);

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            new TenantProfileController(tbTenantProfileService)
                .getTenantProfileInfos(3, 1, "Text Search", "", "asc"));
  }

  /**
   * Test {@link TenantProfileController#getTenantProfileInfos(int, int, String, String, String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileController#getTenantProfileInfos(int, int, String,
   * String, String)}
   */
  @Test
  @DisplayName(
      "Test getTenantProfileInfos(int, int, String, String, String); when empty string; then throw ThingsboardException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData TenantProfileController.getTenantProfileInfos(int, int, String, String, String)"
  })
  void testGetTenantProfileInfos_whenEmptyString_thenThrowThingsboardException2()
      throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    BaseQueueService queueService = new BaseQueueService();
    TopicService topicService = new TopicService();
    DefaultGatewayNotificationsService gatewayNotificationsService =
        new DefaultGatewayNotificationsService();

    DefaultTbClusterService tbClusterService =
        new DefaultTbClusterService(
            topicService, null, null, gatewayNotificationsService, new EdgeServiceImpl(), null);

    DefaultTbQueueService tbQueueService =
        new DefaultTbQueueService(queueService, tbClusterService, null);
    TenantProfileServiceImpl tenantProfileService = new TenantProfileServiceImpl();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    TenantProfileServiceImpl tenantProfileService2 = new TenantProfileServiceImpl();
    DefaultTbTenantProfileCache tenantProfileCache =
        new DefaultTbTenantProfileCache(tenantProfileService2, new TenantServiceImpl());

    DefaultTbTenantProfileService tbTenantProfileService =
        new DefaultTbTenantProfileService(
            tbQueueService, tenantProfileService, tenantService, tenantProfileCache);

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            new TenantProfileController(tbTenantProfileService)
                .getTenantProfileInfos(3, 1, "Text Search", "U", ""));
  }

  /**
   * Test {@link TenantProfileController#getTenantProfileInfos(int, int, String, String, String)}.
   *
   * <ul>
   *   <li>When {@code Sort Property}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileController#getTenantProfileInfos(int, int, String,
   * String, String)}
   */
  @Test
  @DisplayName(
      "Test getTenantProfileInfos(int, int, String, String, String); when 'Sort Property'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData TenantProfileController.getTenantProfileInfos(int, int, String, String, String)"
  })
  void testGetTenantProfileInfos_whenSortProperty_thenThrowIllegalArgumentException()
      throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    BaseQueueService queueService = new BaseQueueService();
    TopicService topicService = new TopicService();
    DefaultGatewayNotificationsService gatewayNotificationsService =
        new DefaultGatewayNotificationsService();

    DefaultTbClusterService tbClusterService =
        new DefaultTbClusterService(
            topicService, null, null, gatewayNotificationsService, new EdgeServiceImpl(), null);

    DefaultTbQueueService tbQueueService =
        new DefaultTbQueueService(queueService, tbClusterService, null);
    TenantProfileServiceImpl tenantProfileService = new TenantProfileServiceImpl();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    TenantProfileServiceImpl tenantProfileService2 = new TenantProfileServiceImpl();
    DefaultTbTenantProfileCache tenantProfileCache =
        new DefaultTbTenantProfileCache(tenantProfileService2, new TenantServiceImpl());

    DefaultTbTenantProfileService tbTenantProfileService =
        new DefaultTbTenantProfileService(
            tbQueueService, tenantProfileService, tenantService, tenantProfileCache);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new TenantProfileController(tbTenantProfileService)
                .getTenantProfileInfos(3, 1, "Text Search", "Sort Property", "asc"));
  }

  /**
   * Test {@link TenantProfileController#getTenantProfileInfos(int, int, String, String, String)}.
   *
   * <ul>
   *   <li>When {@code U}.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileController#getTenantProfileInfos(int, int, String,
   * String, String)}
   */
  @Test
  @DisplayName(
      "Test getTenantProfileInfos(int, int, String, String, String); when 'U'; then throw ThingsboardException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData TenantProfileController.getTenantProfileInfos(int, int, String, String, String)"
  })
  void testGetTenantProfileInfos_whenU_thenThrowThingsboardException() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    BaseQueueService queueService = new BaseQueueService();
    TopicService topicService = new TopicService();
    DefaultGatewayNotificationsService gatewayNotificationsService =
        new DefaultGatewayNotificationsService();

    DefaultTbClusterService tbClusterService =
        new DefaultTbClusterService(
            topicService, null, null, gatewayNotificationsService, new EdgeServiceImpl(), null);

    DefaultTbQueueService tbQueueService =
        new DefaultTbQueueService(queueService, tbClusterService, null);
    TenantProfileServiceImpl tenantProfileService = new TenantProfileServiceImpl();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    TenantProfileServiceImpl tenantProfileService2 = new TenantProfileServiceImpl();
    DefaultTbTenantProfileCache tenantProfileCache =
        new DefaultTbTenantProfileCache(tenantProfileService2, new TenantServiceImpl());

    DefaultTbTenantProfileService tbTenantProfileService =
        new DefaultTbTenantProfileService(
            tbQueueService, tenantProfileService, tenantService, tenantProfileCache);

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            new TenantProfileController(tbTenantProfileService)
                .getTenantProfileInfos(3, 1, "Text Search", "U", "asc"));
  }

  /**
   * Test {@link TenantProfileController#getTenantProfileInfos(int, int, String, String, String)}.
   *
   * <ul>
   *   <li>When {@code U}.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileController#getTenantProfileInfos(int, int, String,
   * String, String)}
   */
  @Test
  @DisplayName(
      "Test getTenantProfileInfos(int, int, String, String, String); when 'U'; then throw ThingsboardException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData TenantProfileController.getTenantProfileInfos(int, int, String, String, String)"
  })
  void testGetTenantProfileInfos_whenU_thenThrowThingsboardException2()
      throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    BaseQueueService queueService = new BaseQueueService();
    TopicService topicService = new TopicService();
    DefaultGatewayNotificationsService gatewayNotificationsService =
        new DefaultGatewayNotificationsService();

    DefaultTbClusterService tbClusterService =
        new DefaultTbClusterService(
            topicService, null, null, gatewayNotificationsService, new EdgeServiceImpl(), null);

    DefaultTbQueueService tbQueueService =
        new DefaultTbQueueService(queueService, tbClusterService, null);
    TenantProfileServiceImpl tenantProfileService = new TenantProfileServiceImpl();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    TenantProfileServiceImpl tenantProfileService2 = new TenantProfileServiceImpl();
    DefaultTbTenantProfileCache tenantProfileCache =
        new DefaultTbTenantProfileCache(tenantProfileService2, new TenantServiceImpl());

    DefaultTbTenantProfileService tbTenantProfileService =
        new DefaultTbTenantProfileService(
            tbQueueService, tenantProfileService, tenantService, tenantProfileCache);

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            new TenantProfileController(tbTenantProfileService)
                .getTenantProfileInfos(3, 1, "Text Search", "U", "U"));
  }

  /**
   * Test {@link TenantProfileController#getTenantProfilesByIds(UUID[])}.
   *
   * <p>Method under test: {@link TenantProfileController#getTenantProfilesByIds(UUID[])}
   */
  @Test
  @DisplayName("Test getTenantProfilesByIds(UUID[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List TenantProfileController.getTenantProfilesByIds(UUID[])"})
  void testGetTenantProfilesByIds() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/tenantProfiles");

    MockHttpServletRequestBuilder requestBuilder =
        getResult.param(
            "ids",
            String.valueOf(new UUID[] {UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")}));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(tenantProfileController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().is(400));
  }
}
