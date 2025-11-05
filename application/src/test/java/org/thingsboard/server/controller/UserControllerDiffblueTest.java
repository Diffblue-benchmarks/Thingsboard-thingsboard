package org.thingsboard.server.controller;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import freemarker.template.Configuration;
import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.FormLoginRequestBuilder;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.LogoutRequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.StatusResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.request.WebRequest;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.dao.audit.AuditLogServiceImpl;
import org.thingsboard.server.dao.entity.BaseEntityCountService;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.service.validator.UserCredentialsDataValidator;
import org.thingsboard.server.dao.service.validator.UserDataValidator;
import org.thingsboard.server.dao.settings.AdminSettingsServiceImpl;
import org.thingsboard.server.dao.settings.DefaultSecuritySettingsService;
import org.thingsboard.server.dao.sql.JpaExecutorService;
import org.thingsboard.server.dao.sql.user.JpaUserAuthSettingsDao;
import org.thingsboard.server.dao.sql.user.JpaUserCredentialsDao;
import org.thingsboard.server.dao.sql.user.JpaUserDao;
import org.thingsboard.server.dao.sql.user.JpaUserSettingsDao;
import org.thingsboard.server.dao.sql.user.UserAuthSettingsRepository;
import org.thingsboard.server.dao.user.UserServiceImpl;
import org.thingsboard.server.dao.user.UserSettingsServiceImpl;
import org.thingsboard.server.exception.ThingsboardErrorResponseHandler;
import org.thingsboard.server.queue.discovery.DefaultTbServiceInfoProvider;
import org.thingsboard.server.queue.discovery.HashPartitionService;
import org.thingsboard.server.queue.discovery.QueueRoutingInfoService;
import org.thingsboard.server.queue.discovery.TenantRoutingInfoService;
import org.thingsboard.server.queue.discovery.TopicService;
import org.thingsboard.server.queue.provider.TbCoreQueueProducerProvider;
import org.thingsboard.server.queue.scheduler.DefaultSchedulerComponent;
import org.thingsboard.server.queue.usagestats.DefaultTbApiUsageReportClient;
import org.thingsboard.server.service.entitiy.user.DefaultUserService;
import org.thingsboard.server.service.mail.DefaultMailService;
import org.thingsboard.server.service.query.DefaultEntityQueryService;
import org.thingsboard.server.service.security.model.token.JwtTokenFactory;
import org.thingsboard.server.service.security.system.DefaultSystemSecurityService;

@ExtendWith(MockitoExtension.class)
class UserControllerDiffblueTest {
  @Mock private ThingsboardErrorResponseHandler thingsboardErrorResponseHandler;

  @InjectMocks private UserController userController;

  /**
   * Test {@link UserController#getUserById(String)}.
   *
   * <p>Method under test: {@link UserController#getUserById(String)}
   */
  @Test
  @DisplayName("Test getUserById(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"User UserController.getUserById(String)"})
  void testGetUserById() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk());
  }

  /**
   * Test {@link UserController#getUserById(String)}.
   *
   * <p>Method under test: {@link UserController#getUserById(String)}
   */
  @Test
  @DisplayName("Test getUserById(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"User UserController.getUserById(String)"})
  void testGetUserById2() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(content().string("Body"));
  }

  /**
   * Test {@link UserController#getUserById(String)}.
   *
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isNotFound()}.
   * </ul>
   *
   * <p>Method under test: {@link UserController#getUserById(String)}
   */
  @Test
  @DisplayName("Test getUserById(String); then status isNotFound()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"User UserController.getUserById(String)"})
  void testGetUserById_thenStatusIsNotFound() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isNotFound());
  }

  /**
   * Test {@link UserController#getUserById(String)}.
   *
   * <ul>
   *   <li>When logout.
   *   <li>Then content contentType {@code application/json}.
   * </ul>
   *
   * <p>Method under test: {@link UserController#getUserById(String)}
   */
  @Test
  @DisplayName("Test getUserById(String); when logout; then content contentType 'application/json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"User UserController.getUserById(String)"})
  void testGetUserById_whenLogout_thenContentContentTypeApplicationJson() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));

    LogoutRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.logout();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(content().string("42"));
  }

  /**
   * Test {@link UserController#getUserToken(String)}.
   *
   * <p>Method under test: {@link UserController#getUserToken(String)}
   */
  @Test
  @DisplayName("Test getUserToken(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.security.model.JwtPair UserController.getUserToken(String)"
  })
  void testGetUserToken() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk());
  }

  /**
   * Test {@link UserController#getUserToken(String)}.
   *
   * <p>Method under test: {@link UserController#getUserToken(String)}
   */
  @Test
  @DisplayName("Test getUserToken(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.security.model.JwtPair UserController.getUserToken(String)"
  })
  void testGetUserToken2() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(content().string("Body"));
  }

  /**
   * Test {@link UserController#getUserToken(String)}.
   *
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isNotFound()}.
   * </ul>
   *
   * <p>Method under test: {@link UserController#getUserToken(String)}
   */
  @Test
  @DisplayName("Test getUserToken(String); then status isNotFound()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.security.model.JwtPair UserController.getUserToken(String)"
  })
  void testGetUserToken_thenStatusIsNotFound() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isNotFound());
  }

  /**
   * Test {@link UserController#getUserToken(String)}.
   *
   * <ul>
   *   <li>When logout.
   *   <li>Then content contentType {@code application/json}.
   * </ul>
   *
   * <p>Method under test: {@link UserController#getUserToken(String)}
   */
  @Test
  @DisplayName(
      "Test getUserToken(String); when logout; then content contentType 'application/json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.security.model.JwtPair UserController.getUserToken(String)"
  })
  void testGetUserToken_whenLogout_thenContentContentTypeApplicationJson() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));

    LogoutRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.logout();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(content().string("42"));
  }

  /**
   * Test {@link UserController#saveUser(User, boolean, HttpServletRequest)}.
   *
   * <p>Method under test: {@link UserController#saveUser(User, boolean, HttpServletRequest)}
   */
  @Test
  @DisplayName("Test saveUser(User, boolean, HttpServletRequest)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"User UserController.saveUser(User, boolean, HttpServletRequest)"})
  void testSaveUser() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    AnnotationConfigReactiveWebApplicationContext messages =
        new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);

    HashPartitionService partitionService =
        new HashPartitionService(
            serviceInfoProvider,
            tenantRoutingInfoService,
            applicationEventPublisher,
            queueRoutingInfoService,
            new TopicService());
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();

    DefaultTbApiUsageReportClient apiUsageClient =
        new DefaultTbApiUsageReportClient(
            partitionService,
            serviceInfoProvider2,
            scheduler,
            new TbCoreQueueProducerProvider(null));

    DefaultMailService mailService =
        new DefaultMailService(messages, freemarkerConfig, adminSettingsService, apiUsageClient);
    JwtTokenFactory tokenFactory = new JwtTokenFactory(null);
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaUserDao userDao = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao = new JpaUserCredentialsDao();
    JpaUserAuthSettingsDao userAuthSettingsDao =
        new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService =
        new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService =
        new DefaultSecuritySettingsService(new AdminSettingsServiceImpl());
    UserDataValidator userValidator = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher2 = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService = new BaseEntityCountService();

    UserServiceImpl userService =
        new UserServiceImpl(
            userDao,
            userCredentialsDao,
            userAuthSettingsDao,
            userSettingsService,
            userSettingsDao,
            securitySettingsService,
            userValidator,
            userCredentialsValidator,
            eventPublisher2,
            countService,
            new JpaExecutorService());
    AnnotationConfigReactiveWebApplicationContext messages2 =
        new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig2 = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    DefaultTbApiUsageReportClient apiUsageClient2 =
        new DefaultTbApiUsageReportClient(
            null, serviceInfoProvider3, new DefaultSchedulerComponent(), null);

    DefaultMailService mailService2 =
        new DefaultMailService(
            messages2, freemarkerConfig2, adminSettingsService2, apiUsageClient2);
    AdminSettingsServiceImpl adminSettingsService3 = new AdminSettingsServiceImpl();
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    JpaUserDao userDao2 = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao2 = new JpaUserCredentialsDao();
    JpaUserSettingsDao userSettingsDao2 = new JpaUserSettingsDao();
    UserDataValidator userValidator2 = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator2 = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher3 = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService2 = new BaseEntityCountService();

    UserServiceImpl userService2 =
        new UserServiceImpl(
            userDao2,
            userCredentialsDao2,
            null,
            null,
            userSettingsDao2,
            null,
            userValidator2,
            userCredentialsValidator2,
            eventPublisher3,
            countService2,
            new JpaExecutorService());
    AnnotationConfigReactiveWebApplicationContext messages3 =
        new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig3 = Configuration.getDefaultConfiguration();

    DefaultMailService mailService3 =
        new DefaultMailService(messages3, freemarkerConfig3, new AdminSettingsServiceImpl(), null);
    AuditLogServiceImpl auditLogService = new AuditLogServiceImpl();

    DefaultSystemSecurityService systemSecurityService =
        new DefaultSystemSecurityService(
            adminSettingsService3,
            encoder,
            userService2,
            mailService3,
            auditLogService,
            new DefaultSecuritySettingsService(new AdminSettingsServiceImpl()));

    DefaultUserService tbUserService =
        new DefaultUserService(userService, mailService2, systemSecurityService);
    DefaultEntityQueryService entityQueryService = new DefaultEntityQueryService();

    UserController userController =
        new UserController(
            mailService,
            tokenFactory,
            eventPublisher,
            tbUserService,
            entityQueryService,
            new BaseEntityService());
    User user = new User();

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> userController.saveUser(user, true, new MockHttpServletRequest()));
  }

  /**
   * Test {@link UserController#getActivationLink(String, HttpServletRequest)}.
   *
   * <p>Method under test: {@link UserController#getActivationLink(String, HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getActivationLink(String, HttpServletRequest)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String UserController.getActivationLink(String, HttpServletRequest)"})
  void testGetActivationLink() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk());
  }

  /**
   * Test {@link UserController#getActivationLink(String, HttpServletRequest)}.
   *
   * <p>Method under test: {@link UserController#getActivationLink(String, HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getActivationLink(String, HttpServletRequest)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String UserController.getActivationLink(String, HttpServletRequest)"})
  void testGetActivationLink2() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(content().string("Body"));
  }

  /**
   * Test {@link UserController#getActivationLink(String, HttpServletRequest)}.
   *
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isNotFound()}.
   * </ul>
   *
   * <p>Method under test: {@link UserController#getActivationLink(String, HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getActivationLink(String, HttpServletRequest); then status isNotFound()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String UserController.getActivationLink(String, HttpServletRequest)"})
  void testGetActivationLink_thenStatusIsNotFound() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isNotFound());
  }

  /**
   * Test {@link UserController#getActivationLink(String, HttpServletRequest)}.
   *
   * <ul>
   *   <li>When logout.
   *   <li>Then content contentType {@code application/json}.
   * </ul>
   *
   * <p>Method under test: {@link UserController#getActivationLink(String, HttpServletRequest)}
   */
  @Test
  @DisplayName(
      "Test getActivationLink(String, HttpServletRequest); when logout; then content contentType 'application/json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String UserController.getActivationLink(String, HttpServletRequest)"})
  void testGetActivationLink_whenLogout_thenContentContentTypeApplicationJson() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));

    LogoutRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.logout();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(content().string("42"));
  }

  /**
   * Test {@link UserController#getActivationLinkInfo(String, HttpServletRequest)}.
   *
   * <p>Method under test: {@link UserController#getActivationLinkInfo(String, HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getActivationLinkInfo(String, HttpServletRequest)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "UserActivationLink UserController.getActivationLinkInfo(String, HttpServletRequest)"
  })
  void testGetActivationLinkInfo() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk());
  }

  /**
   * Test {@link UserController#getActivationLinkInfo(String, HttpServletRequest)}.
   *
   * <p>Method under test: {@link UserController#getActivationLinkInfo(String, HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getActivationLinkInfo(String, HttpServletRequest)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "UserActivationLink UserController.getActivationLinkInfo(String, HttpServletRequest)"
  })
  void testGetActivationLinkInfo2() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(content().string("Body"));
  }

  /**
   * Test {@link UserController#getActivationLinkInfo(String, HttpServletRequest)}.
   *
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isNotFound()}.
   * </ul>
   *
   * <p>Method under test: {@link UserController#getActivationLinkInfo(String, HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getActivationLinkInfo(String, HttpServletRequest); then status isNotFound()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "UserActivationLink UserController.getActivationLinkInfo(String, HttpServletRequest)"
  })
  void testGetActivationLinkInfo_thenStatusIsNotFound() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isNotFound());
  }

  /**
   * Test {@link UserController#getActivationLinkInfo(String, HttpServletRequest)}.
   *
   * <ul>
   *   <li>When logout.
   *   <li>Then content contentType {@code application/json}.
   * </ul>
   *
   * <p>Method under test: {@link UserController#getActivationLinkInfo(String, HttpServletRequest)}
   */
  @Test
  @DisplayName(
      "Test getActivationLinkInfo(String, HttpServletRequest); when logout; then content contentType 'application/json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "UserActivationLink UserController.getActivationLinkInfo(String, HttpServletRequest)"
  })
  void testGetActivationLinkInfo_whenLogout_thenContentContentTypeApplicationJson()
      throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));

    LogoutRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.logout();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(content().string("42"));
  }

  /**
   * Test {@link UserController#deleteUser(String)}.
   *
   * <p>Method under test: {@link UserController#deleteUser(String)}
   */
  @Test
  @DisplayName("Test deleteUser(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserController.deleteUser(String)"})
  void testDeleteUser() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk());
  }

  /**
   * Test {@link UserController#deleteUser(String)}.
   *
   * <p>Method under test: {@link UserController#deleteUser(String)}
   */
  @Test
  @DisplayName("Test deleteUser(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserController.deleteUser(String)"})
  void testDeleteUser2() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(content().string("Body"));
  }

  /**
   * Test {@link UserController#deleteUser(String)}.
   *
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isNotFound()}.
   * </ul>
   *
   * <p>Method under test: {@link UserController#deleteUser(String)}
   */
  @Test
  @DisplayName("Test deleteUser(String); then status isNotFound()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserController.deleteUser(String)"})
  void testDeleteUser_thenStatusIsNotFound() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isNotFound());
  }

  /**
   * Test {@link UserController#deleteUser(String)}.
   *
   * <ul>
   *   <li>When logout.
   *   <li>Then content contentType {@code application/json}.
   * </ul>
   *
   * <p>Method under test: {@link UserController#deleteUser(String)}
   */
  @Test
  @DisplayName("Test deleteUser(String); when logout; then content contentType 'application/json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserController.deleteUser(String)"})
  void testDeleteUser_whenLogout_thenContentContentTypeApplicationJson() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));

    LogoutRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.logout();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(content().string("42"));
  }

  /**
   * Test {@link UserController#getUsers(int, int, String, String, String)}.
   *
   * <ul>
   *   <li>Given {@link UserController}.
   *   <li>When empty string.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link UserController#getUsers(int, int, String, String, String)}
   */
  @Test
  @DisplayName(
      "Test getUsers(int, int, String, String, String); given UserController; when empty string; then throw ThingsboardException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData UserController.getUsers(int, int, String, String, String)"
  })
  void testGetUsers_givenUserController_whenEmptyString_thenThrowThingsboardException()
      throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange, Act and Assert
    assertThrows(
        ThingsboardException.class, () -> userController.getUsers(3, 1, "Text Search", "", "asc"));
  }

  /**
   * Test {@link UserController#getUsers(int, int, String, String, String)}.
   *
   * <ul>
   *   <li>Given {@link UserController}.
   *   <li>When empty string.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link UserController#getUsers(int, int, String, String, String)}
   */
  @Test
  @DisplayName(
      "Test getUsers(int, int, String, String, String); given UserController; when empty string; then throw ThingsboardException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData UserController.getUsers(int, int, String, String, String)"
  })
  void testGetUsers_givenUserController_whenEmptyString_thenThrowThingsboardException2()
      throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange, Act and Assert
    assertThrows(
        ThingsboardException.class, () -> userController.getUsers(3, 1, "Text Search", "U", ""));
  }

  /**
   * Test {@link UserController#getUsers(int, int, String, String, String)}.
   *
   * <ul>
   *   <li>Given {@link UserController}.
   *   <li>When {@code U}.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link UserController#getUsers(int, int, String, String, String)}
   */
  @Test
  @DisplayName(
      "Test getUsers(int, int, String, String, String); given UserController; when 'U'; then throw ThingsboardException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData UserController.getUsers(int, int, String, String, String)"
  })
  void testGetUsers_givenUserController_whenU_thenThrowThingsboardException()
      throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange, Act and Assert
    assertThrows(
        ThingsboardException.class, () -> userController.getUsers(3, 1, "Text Search", "U", "asc"));
  }

  /**
   * Test {@link UserController#getUsers(int, int, String, String, String)}.
   *
   * <ul>
   *   <li>Given {@link UserController}.
   *   <li>When {@code U}.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link UserController#getUsers(int, int, String, String, String)}
   */
  @Test
  @DisplayName(
      "Test getUsers(int, int, String, String, String); given UserController; when 'U'; then throw ThingsboardException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData UserController.getUsers(int, int, String, String, String)"
  })
  void testGetUsers_givenUserController_whenU_thenThrowThingsboardException2()
      throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange, Act and Assert
    assertThrows(
        ThingsboardException.class, () -> userController.getUsers(3, 1, "Text Search", "U", "U"));
  }

  /**
   * Test {@link UserController#getUsers(int, int, String, String, String)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link UserController#getUsers(int, int, String, String, String)}
   */
  @Test
  @DisplayName(
      "Test getUsers(int, int, String, String, String); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData UserController.getUsers(int, int, String, String, String)"
  })
  void testGetUsers_thenThrowIllegalArgumentException() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    AnnotationConfigReactiveWebApplicationContext messages =
        new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);

    HashPartitionService partitionService =
        new HashPartitionService(
            serviceInfoProvider,
            tenantRoutingInfoService,
            applicationEventPublisher,
            queueRoutingInfoService,
            new TopicService());
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();

    DefaultTbApiUsageReportClient apiUsageClient =
        new DefaultTbApiUsageReportClient(
            partitionService,
            serviceInfoProvider2,
            scheduler,
            new TbCoreQueueProducerProvider(null));

    DefaultMailService mailService =
        new DefaultMailService(messages, freemarkerConfig, adminSettingsService, apiUsageClient);
    JwtTokenFactory tokenFactory = new JwtTokenFactory(null);
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaUserDao userDao = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao = new JpaUserCredentialsDao();
    JpaUserAuthSettingsDao userAuthSettingsDao =
        new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService =
        new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService =
        new DefaultSecuritySettingsService(new AdminSettingsServiceImpl());
    UserDataValidator userValidator = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher2 = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService = new BaseEntityCountService();

    UserServiceImpl userService =
        new UserServiceImpl(
            userDao,
            userCredentialsDao,
            userAuthSettingsDao,
            userSettingsService,
            userSettingsDao,
            securitySettingsService,
            userValidator,
            userCredentialsValidator,
            eventPublisher2,
            countService,
            new JpaExecutorService());
    AnnotationConfigReactiveWebApplicationContext messages2 =
        new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig2 = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    DefaultTbApiUsageReportClient apiUsageClient2 =
        new DefaultTbApiUsageReportClient(
            null, serviceInfoProvider3, new DefaultSchedulerComponent(), null);

    DefaultMailService mailService2 =
        new DefaultMailService(
            messages2, freemarkerConfig2, adminSettingsService2, apiUsageClient2);
    AdminSettingsServiceImpl adminSettingsService3 = new AdminSettingsServiceImpl();
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    JpaUserDao userDao2 = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao2 = new JpaUserCredentialsDao();
    JpaUserSettingsDao userSettingsDao2 = new JpaUserSettingsDao();
    UserDataValidator userValidator2 = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator2 = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher3 = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService2 = new BaseEntityCountService();

    UserServiceImpl userService2 =
        new UserServiceImpl(
            userDao2,
            userCredentialsDao2,
            null,
            null,
            userSettingsDao2,
            null,
            userValidator2,
            userCredentialsValidator2,
            eventPublisher3,
            countService2,
            new JpaExecutorService());
    AnnotationConfigReactiveWebApplicationContext messages3 =
        new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig3 = Configuration.getDefaultConfiguration();

    DefaultMailService mailService3 =
        new DefaultMailService(messages3, freemarkerConfig3, new AdminSettingsServiceImpl(), null);
    AuditLogServiceImpl auditLogService = new AuditLogServiceImpl();

    DefaultSystemSecurityService systemSecurityService =
        new DefaultSystemSecurityService(
            adminSettingsService3,
            encoder,
            userService2,
            mailService3,
            auditLogService,
            new DefaultSecuritySettingsService(new AdminSettingsServiceImpl()));

    DefaultUserService tbUserService =
        new DefaultUserService(userService, mailService2, systemSecurityService);
    DefaultEntityQueryService entityQueryService = new DefaultEntityQueryService();

    UserController userController =
        new UserController(
            mailService,
            tokenFactory,
            eventPublisher,
            tbUserService,
            entityQueryService,
            new BaseEntityService());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> userController.getUsers(3, 1, "Text Search", "Sort Property", "asc"));
  }

  /**
   * Test {@link UserController#findUsersByQuery(int, int, String, String, String)}.
   *
   * <p>Method under test: {@link UserController#findUsersByQuery(int, int, String, String, String)}
   */
  @Test
  @DisplayName("Test findUsersByQuery(int, int, String, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData UserController.findUsersByQuery(int, int, String, String, String)"
  })
  void testFindUsersByQuery() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    AnnotationConfigReactiveWebApplicationContext messages =
        new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);

    HashPartitionService partitionService =
        new HashPartitionService(
            serviceInfoProvider,
            tenantRoutingInfoService,
            applicationEventPublisher,
            queueRoutingInfoService,
            new TopicService());
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();

    DefaultTbApiUsageReportClient apiUsageClient =
        new DefaultTbApiUsageReportClient(
            partitionService,
            serviceInfoProvider2,
            scheduler,
            new TbCoreQueueProducerProvider(null));

    DefaultMailService mailService =
        new DefaultMailService(messages, freemarkerConfig, adminSettingsService, apiUsageClient);
    JwtTokenFactory tokenFactory = new JwtTokenFactory(null);
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaUserDao userDao = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao = new JpaUserCredentialsDao();
    JpaUserAuthSettingsDao userAuthSettingsDao =
        new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService =
        new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService =
        new DefaultSecuritySettingsService(new AdminSettingsServiceImpl());
    UserDataValidator userValidator = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher2 = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService = new BaseEntityCountService();

    UserServiceImpl userService =
        new UserServiceImpl(
            userDao,
            userCredentialsDao,
            userAuthSettingsDao,
            userSettingsService,
            userSettingsDao,
            securitySettingsService,
            userValidator,
            userCredentialsValidator,
            eventPublisher2,
            countService,
            new JpaExecutorService());
    AnnotationConfigReactiveWebApplicationContext messages2 =
        new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig2 = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    DefaultTbApiUsageReportClient apiUsageClient2 =
        new DefaultTbApiUsageReportClient(
            null, serviceInfoProvider3, new DefaultSchedulerComponent(), null);

    DefaultMailService mailService2 =
        new DefaultMailService(
            messages2, freemarkerConfig2, adminSettingsService2, apiUsageClient2);
    AdminSettingsServiceImpl adminSettingsService3 = new AdminSettingsServiceImpl();
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    JpaUserDao userDao2 = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao2 = new JpaUserCredentialsDao();
    JpaUserSettingsDao userSettingsDao2 = new JpaUserSettingsDao();
    UserDataValidator userValidator2 = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator2 = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher3 = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService2 = new BaseEntityCountService();

    UserServiceImpl userService2 =
        new UserServiceImpl(
            userDao2,
            userCredentialsDao2,
            null,
            null,
            userSettingsDao2,
            null,
            userValidator2,
            userCredentialsValidator2,
            eventPublisher3,
            countService2,
            new JpaExecutorService());
    AnnotationConfigReactiveWebApplicationContext messages3 =
        new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig3 = Configuration.getDefaultConfiguration();

    DefaultMailService mailService3 =
        new DefaultMailService(messages3, freemarkerConfig3, new AdminSettingsServiceImpl(), null);
    AuditLogServiceImpl auditLogService = new AuditLogServiceImpl();

    DefaultSystemSecurityService systemSecurityService =
        new DefaultSystemSecurityService(
            adminSettingsService3,
            encoder,
            userService2,
            mailService3,
            auditLogService,
            new DefaultSecuritySettingsService(new AdminSettingsServiceImpl()));

    DefaultUserService tbUserService =
        new DefaultUserService(userService, mailService2, systemSecurityService);
    DefaultEntityQueryService entityQueryService = new DefaultEntityQueryService();

    UserController userController =
        new UserController(
            mailService,
            tokenFactory,
            eventPublisher,
            tbUserService,
            entityQueryService,
            new BaseEntityService());

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> userController.findUsersByQuery(3, 1, "Text Search", "Sort Property", "asc"));
  }

  /**
   * Test {@link UserController#getTenantAdmins(String, int, int, String, String, String)}.
   *
   * <p>Method under test: {@link UserController#getTenantAdmins(String, int, int, String, String,
   * String)}
   */
  @Test
  @DisplayName("Test getTenantAdmins(String, int, int, String, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData UserController.getTenantAdmins(String, int, int, String, String, String)"
  })
  void testGetTenantAdmins() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/tenant/{tenantId}/users", "")
            .param("page", String.valueOf(1))
            .param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk());
  }

  /**
   * Test {@link UserController#getTenantAdmins(String, int, int, String, String, String)}.
   *
   * <ul>
   *   <li>Then content contentType {@code text/plain;charset=ISO-8859-1}.
   * </ul>
   *
   * <p>Method under test: {@link UserController#getTenantAdmins(String, int, int, String, String,
   * String)}
   */
  @Test
  @DisplayName(
      "Test getTenantAdmins(String, int, int, String, String, String); then content contentType 'text/plain;charset=ISO-8859-1'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData UserController.getTenantAdmins(String, int, int, String, String, String)"
  })
  void testGetTenantAdmins_thenContentContentTypeTextPlainCharsetIso88591() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/tenant/{tenantId}/users", "")
            .param("page", String.valueOf(1))
            .param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("text/plain;charset=ISO-8859-1"))
        .andExpect(content().string("Body"));
  }

  /**
   * Test {@link UserController#getCustomerUsers(String, int, int, String, String, String)}.
   *
   * <p>Method under test: {@link UserController#getCustomerUsers(String, int, int, String, String,
   * String)}
   */
  @Test
  @DisplayName("Test getCustomerUsers(String, int, int, String, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData UserController.getCustomerUsers(String, int, int, String, String, String)"
  })
  void testGetCustomerUsers() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/customer/{customerId}/users", "")
            .param("page", String.valueOf(1))
            .param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk());
  }

  /**
   * Test {@link UserController#getCustomerUsers(String, int, int, String, String, String)}.
   *
   * <ul>
   *   <li>Then content contentType {@code text/plain;charset=ISO-8859-1}.
   * </ul>
   *
   * <p>Method under test: {@link UserController#getCustomerUsers(String, int, int, String, String,
   * String)}
   */
  @Test
  @DisplayName(
      "Test getCustomerUsers(String, int, int, String, String, String); then content contentType 'text/plain;charset=ISO-8859-1'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData UserController.getCustomerUsers(String, int, int, String, String, String)"
  })
  void testGetCustomerUsers_thenContentContentTypeTextPlainCharsetIso88591() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/customer/{customerId}/users", "")
            .param("page", String.valueOf(1))
            .param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("text/plain;charset=ISO-8859-1"))
        .andExpect(content().string("Body"));
  }

  /**
   * Test {@link UserController#getUsersForAssign(String, int, int, String, String, String)}.
   *
   * <p>Method under test: {@link UserController#getUsersForAssign(String, int, int, String, String,
   * String)}
   */
  @Test
  @DisplayName("Test getUsersForAssign(String, int, int, String, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData UserController.getUsersForAssign(String, int, int, String, String, String)"
  })
  void testGetUsersForAssign() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/users/assign/{alarmId}", "")
            .param("page", String.valueOf(1))
            .param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk());
  }

  /**
   * Test {@link UserController#getUsersForAssign(String, int, int, String, String, String)}.
   *
   * <ul>
   *   <li>Then content contentType {@code text/plain;charset=ISO-8859-1}.
   * </ul>
   *
   * <p>Method under test: {@link UserController#getUsersForAssign(String, int, int, String, String,
   * String)}
   */
  @Test
  @DisplayName(
      "Test getUsersForAssign(String, int, int, String, String, String); then content contentType 'text/plain;charset=ISO-8859-1'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData UserController.getUsersForAssign(String, int, int, String, String, String)"
  })
  void testGetUsersForAssign_thenContentContentTypeTextPlainCharsetIso88591() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/users/assign/{alarmId}", "")
            .param("page", String.valueOf(1))
            .param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("text/plain;charset=ISO-8859-1"))
        .andExpect(content().string("Body"));
  }

  /**
   * Test {@link UserController#putUserSettings(JsonNode)} with {@code settings}.
   *
   * <p>Method under test: {@link UserController#putUserSettings(JsonNode)}
   */
  @Test
  @DisplayName("Test putUserSettings(JsonNode) with 'settings'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserController.putUserSettings(JsonNode)"})
  void testPutUserSettingsWithSettings() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    AnnotationConfigReactiveWebApplicationContext messages =
        new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);

    HashPartitionService partitionService =
        new HashPartitionService(
            serviceInfoProvider,
            tenantRoutingInfoService,
            applicationEventPublisher,
            queueRoutingInfoService,
            new TopicService());
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();

    DefaultTbApiUsageReportClient apiUsageClient =
        new DefaultTbApiUsageReportClient(
            partitionService,
            serviceInfoProvider2,
            scheduler,
            new TbCoreQueueProducerProvider(null));

    DefaultMailService mailService =
        new DefaultMailService(messages, freemarkerConfig, adminSettingsService, apiUsageClient);
    JwtTokenFactory tokenFactory = new JwtTokenFactory(null);
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaUserDao userDao = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao = new JpaUserCredentialsDao();
    JpaUserAuthSettingsDao userAuthSettingsDao =
        new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService =
        new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService =
        new DefaultSecuritySettingsService(new AdminSettingsServiceImpl());
    UserDataValidator userValidator = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher2 = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService = new BaseEntityCountService();

    UserServiceImpl userService =
        new UserServiceImpl(
            userDao,
            userCredentialsDao,
            userAuthSettingsDao,
            userSettingsService,
            userSettingsDao,
            securitySettingsService,
            userValidator,
            userCredentialsValidator,
            eventPublisher2,
            countService,
            new JpaExecutorService());
    AnnotationConfigReactiveWebApplicationContext messages2 =
        new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig2 = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    DefaultTbApiUsageReportClient apiUsageClient2 =
        new DefaultTbApiUsageReportClient(
            null, serviceInfoProvider3, new DefaultSchedulerComponent(), null);

    DefaultMailService mailService2 =
        new DefaultMailService(
            messages2, freemarkerConfig2, adminSettingsService2, apiUsageClient2);
    AdminSettingsServiceImpl adminSettingsService3 = new AdminSettingsServiceImpl();
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    JpaUserDao userDao2 = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao2 = new JpaUserCredentialsDao();
    JpaUserSettingsDao userSettingsDao2 = new JpaUserSettingsDao();
    UserDataValidator userValidator2 = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator2 = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher3 = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService2 = new BaseEntityCountService();

    UserServiceImpl userService2 =
        new UserServiceImpl(
            userDao2,
            userCredentialsDao2,
            null,
            null,
            userSettingsDao2,
            null,
            userValidator2,
            userCredentialsValidator2,
            eventPublisher3,
            countService2,
            new JpaExecutorService());
    AnnotationConfigReactiveWebApplicationContext messages3 =
        new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig3 = Configuration.getDefaultConfiguration();

    DefaultMailService mailService3 =
        new DefaultMailService(messages3, freemarkerConfig3, new AdminSettingsServiceImpl(), null);
    AuditLogServiceImpl auditLogService = new AuditLogServiceImpl();

    DefaultSystemSecurityService systemSecurityService =
        new DefaultSystemSecurityService(
            adminSettingsService3,
            encoder,
            userService2,
            mailService3,
            auditLogService,
            new DefaultSecuritySettingsService(new AdminSettingsServiceImpl()));

    DefaultUserService tbUserService =
        new DefaultUserService(userService, mailService2, systemSecurityService);
    DefaultEntityQueryService entityQueryService = new DefaultEntityQueryService();

    UserController userController =
        new UserController(
            mailService,
            tokenFactory,
            eventPublisher,
            tbUserService,
            entityQueryService,
            new BaseEntityService());

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> userController.putUserSettings(DoubleNode.valueOf(10.0d)));
  }

  /**
   * Test {@link UserController#putUserSettings(String, JsonNode)} with {@code strType}, {@code
   * settings}.
   *
   * <p>Method under test: {@link UserController#putUserSettings(String, JsonNode)}
   */
  @Test
  @DisplayName("Test putUserSettings(String, JsonNode) with 'strType', 'settings'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserController.putUserSettings(String, JsonNode)"})
  void testPutUserSettingsWithStrTypeSettings() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    AnnotationConfigReactiveWebApplicationContext messages =
        new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);

    HashPartitionService partitionService =
        new HashPartitionService(
            serviceInfoProvider,
            tenantRoutingInfoService,
            applicationEventPublisher,
            queueRoutingInfoService,
            new TopicService());
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();

    DefaultTbApiUsageReportClient apiUsageClient =
        new DefaultTbApiUsageReportClient(
            partitionService,
            serviceInfoProvider2,
            scheduler,
            new TbCoreQueueProducerProvider(null));

    DefaultMailService mailService =
        new DefaultMailService(messages, freemarkerConfig, adminSettingsService, apiUsageClient);
    JwtTokenFactory tokenFactory = new JwtTokenFactory(null);
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaUserDao userDao = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao = new JpaUserCredentialsDao();
    JpaUserAuthSettingsDao userAuthSettingsDao =
        new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService =
        new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService =
        new DefaultSecuritySettingsService(new AdminSettingsServiceImpl());
    UserDataValidator userValidator = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher2 = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService = new BaseEntityCountService();

    UserServiceImpl userService =
        new UserServiceImpl(
            userDao,
            userCredentialsDao,
            userAuthSettingsDao,
            userSettingsService,
            userSettingsDao,
            securitySettingsService,
            userValidator,
            userCredentialsValidator,
            eventPublisher2,
            countService,
            new JpaExecutorService());
    AnnotationConfigReactiveWebApplicationContext messages2 =
        new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig2 = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    DefaultTbApiUsageReportClient apiUsageClient2 =
        new DefaultTbApiUsageReportClient(
            null, serviceInfoProvider3, new DefaultSchedulerComponent(), null);

    DefaultMailService mailService2 =
        new DefaultMailService(
            messages2, freemarkerConfig2, adminSettingsService2, apiUsageClient2);
    AdminSettingsServiceImpl adminSettingsService3 = new AdminSettingsServiceImpl();
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    JpaUserDao userDao2 = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao2 = new JpaUserCredentialsDao();
    JpaUserSettingsDao userSettingsDao2 = new JpaUserSettingsDao();
    UserDataValidator userValidator2 = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator2 = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher3 = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService2 = new BaseEntityCountService();

    UserServiceImpl userService2 =
        new UserServiceImpl(
            userDao2,
            userCredentialsDao2,
            null,
            null,
            userSettingsDao2,
            null,
            userValidator2,
            userCredentialsValidator2,
            eventPublisher3,
            countService2,
            new JpaExecutorService());
    AnnotationConfigReactiveWebApplicationContext messages3 =
        new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig3 = Configuration.getDefaultConfiguration();

    DefaultMailService mailService3 =
        new DefaultMailService(messages3, freemarkerConfig3, new AdminSettingsServiceImpl(), null);
    AuditLogServiceImpl auditLogService = new AuditLogServiceImpl();

    DefaultSystemSecurityService systemSecurityService =
        new DefaultSystemSecurityService(
            adminSettingsService3,
            encoder,
            userService2,
            mailService3,
            auditLogService,
            new DefaultSecuritySettingsService(new AdminSettingsServiceImpl()));

    DefaultUserService tbUserService =
        new DefaultUserService(userService, mailService2, systemSecurityService);
    DefaultEntityQueryService entityQueryService = new DefaultEntityQueryService();

    UserController userController =
        new UserController(
            mailService,
            tokenFactory,
            eventPublisher,
            tbUserService,
            entityQueryService,
            new BaseEntityService());

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> userController.putUserSettings("Str Type", DoubleNode.valueOf(10.0d)));
  }

  /**
   * Test {@link UserController#getUserSettings()}.
   *
   * <p>Method under test: {@link UserController#getUserSettings()}
   */
  @Test
  @DisplayName("Test getUserSettings()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode UserController.getUserSettings()"})
  void testGetUserSettings() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk());
  }

  /**
   * Test {@link UserController#getUserSettings()}.
   *
   * <p>Method under test: {@link UserController#getUserSettings()}
   */
  @Test
  @DisplayName("Test getUserSettings()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode UserController.getUserSettings()"})
  void testGetUserSettings2() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(content().string("Body"));
  }

  /**
   * Test {@link UserController#getUserSettings(String)} with {@code String}.
   *
   * <p>Method under test: {@link UserController#getUserSettings(String)}
   */
  @Test
  @DisplayName("Test getUserSettings(String) with 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode UserController.getUserSettings(String)"})
  void testGetUserSettingsWithString() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk());
  }

  /**
   * Test {@link UserController#getUserSettings(String)} with {@code String}.
   *
   * <p>Method under test: {@link UserController#getUserSettings(String)}
   */
  @Test
  @DisplayName("Test getUserSettings(String) with 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode UserController.getUserSettings(String)"})
  void testGetUserSettingsWithString2() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(content().string("Body"));
  }

  /**
   * Test {@link UserController#getUserSettings(String)} with {@code String}.
   *
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isNotFound()}.
   * </ul>
   *
   * <p>Method under test: {@link UserController#getUserSettings(String)}
   */
  @Test
  @DisplayName("Test getUserSettings(String) with 'String'; then status isNotFound()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode UserController.getUserSettings(String)"})
  void testGetUserSettingsWithString_thenStatusIsNotFound() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isNotFound());
  }

  /**
   * Test {@link UserController#getUserSettings(String)} with {@code String}.
   *
   * <ul>
   *   <li>When logout.
   *   <li>Then content contentType {@code application/json}.
   * </ul>
   *
   * <p>Method under test: {@link UserController#getUserSettings(String)}
   */
  @Test
  @DisplayName(
      "Test getUserSettings(String) with 'String'; when logout; then content contentType 'application/json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode UserController.getUserSettings(String)"})
  void testGetUserSettingsWithString_whenLogout_thenContentContentTypeApplicationJson()
      throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));

    LogoutRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.logout();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(content().string("42"));
  }

  /**
   * Test {@link UserController#getUserSettings()}.
   *
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isNotFound()}.
   * </ul>
   *
   * <p>Method under test: {@link UserController#getUserSettings()}
   */
  @Test
  @DisplayName("Test getUserSettings(); then status isNotFound()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode UserController.getUserSettings()"})
  void testGetUserSettings_thenStatusIsNotFound() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isNotFound());
  }

  /**
   * Test {@link UserController#getUserSettings()}.
   *
   * <ul>
   *   <li>When logout.
   *   <li>Then content contentType {@code application/json}.
   * </ul>
   *
   * <p>Method under test: {@link UserController#getUserSettings()}
   */
  @Test
  @DisplayName("Test getUserSettings(); when logout; then content contentType 'application/json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode UserController.getUserSettings()"})
  void testGetUserSettings_whenLogout_thenContentContentTypeApplicationJson() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));

    LogoutRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.logout();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(content().string("42"));
  }

  /**
   * Test {@link UserController#deleteUserSettings(String)} with {@code paths}.
   *
   * <p>Method under test: {@link UserController#deleteUserSettings(String)}
   */
  @Test
  @DisplayName("Test deleteUserSettings(String) with 'paths'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserController.deleteUserSettings(String)"})
  void testDeleteUserSettingsWithPaths() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk());
  }

  /**
   * Test {@link UserController#deleteUserSettings(String)} with {@code paths}.
   *
   * <p>Method under test: {@link UserController#deleteUserSettings(String)}
   */
  @Test
  @DisplayName("Test deleteUserSettings(String) with 'paths'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserController.deleteUserSettings(String)"})
  void testDeleteUserSettingsWithPaths2() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(content().string("Body"));
  }

  /**
   * Test {@link UserController#deleteUserSettings(String, String)} with {@code paths}, {@code
   * strType}.
   *
   * <p>Method under test: {@link UserController#deleteUserSettings(String, String)}
   */
  @Test
  @DisplayName("Test deleteUserSettings(String, String) with 'paths', 'strType'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserController.deleteUserSettings(String, String)"})
  void testDeleteUserSettingsWithPathsStrType() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk());
  }

  /**
   * Test {@link UserController#deleteUserSettings(String, String)} with {@code paths}, {@code
   * strType}.
   *
   * <p>Method under test: {@link UserController#deleteUserSettings(String, String)}
   */
  @Test
  @DisplayName("Test deleteUserSettings(String, String) with 'paths', 'strType'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserController.deleteUserSettings(String, String)"})
  void testDeleteUserSettingsWithPathsStrType2() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(content().string("Body"));
  }

  /**
   * Test {@link UserController#deleteUserSettings(String, String)} with {@code paths}, {@code
   * strType}.
   *
   * <ul>
   *   <li>Then content contentType {@code application/json}.
   * </ul>
   *
   * <p>Method under test: {@link UserController#deleteUserSettings(String, String)}
   */
  @Test
  @DisplayName(
      "Test deleteUserSettings(String, String) with 'paths', 'strType'; then content contentType 'application/json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserController.deleteUserSettings(String, String)"})
  void testDeleteUserSettingsWithPathsStrType_thenContentContentTypeApplicationJson()
      throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));

    LogoutRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.logout();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(content().string("42"));
  }

  /**
   * Test {@link UserController#deleteUserSettings(String, String)} with {@code paths}, {@code
   * strType}.
   *
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isNotFound()}.
   * </ul>
   *
   * <p>Method under test: {@link UserController#deleteUserSettings(String, String)}
   */
  @Test
  @DisplayName(
      "Test deleteUserSettings(String, String) with 'paths', 'strType'; then status isNotFound()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserController.deleteUserSettings(String, String)"})
  void testDeleteUserSettingsWithPathsStrType_thenStatusIsNotFound() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isNotFound());
  }

  /**
   * Test {@link UserController#deleteUserSettings(String)} with {@code paths}.
   *
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isNotFound()}.
   * </ul>
   *
   * <p>Method under test: {@link UserController#deleteUserSettings(String)}
   */
  @Test
  @DisplayName("Test deleteUserSettings(String) with 'paths'; then status isNotFound()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserController.deleteUserSettings(String)"})
  void testDeleteUserSettingsWithPaths_thenStatusIsNotFound() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isNotFound());
  }

  /**
   * Test {@link UserController#deleteUserSettings(String)} with {@code paths}.
   *
   * <ul>
   *   <li>When logout.
   *   <li>Then content contentType {@code application/json}.
   * </ul>
   *
   * <p>Method under test: {@link UserController#deleteUserSettings(String)}
   */
  @Test
  @DisplayName(
      "Test deleteUserSettings(String) with 'paths'; when logout; then content contentType 'application/json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserController.deleteUserSettings(String)"})
  void testDeleteUserSettingsWithPaths_whenLogout_thenContentContentTypeApplicationJson()
      throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));

    LogoutRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.logout();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(content().string("42"));
  }

  /**
   * Test {@link UserController#getUserDashboardsInfo()}.
   *
   * <p>Method under test: {@link UserController#getUserDashboardsInfo()}
   */
  @Test
  @DisplayName("Test getUserDashboardsInfo()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.settings.UserDashboardsInfo UserController.getUserDashboardsInfo()"
  })
  void testGetUserDashboardsInfo() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk());
  }

  /**
   * Test {@link UserController#getUserDashboardsInfo()}.
   *
   * <p>Method under test: {@link UserController#getUserDashboardsInfo()}
   */
  @Test
  @DisplayName("Test getUserDashboardsInfo()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.settings.UserDashboardsInfo UserController.getUserDashboardsInfo()"
  })
  void testGetUserDashboardsInfo2() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(content().string("Body"));
  }

  /**
   * Test {@link UserController#getUserDashboardsInfo()}.
   *
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isNotFound()}.
   * </ul>
   *
   * <p>Method under test: {@link UserController#getUserDashboardsInfo()}
   */
  @Test
  @DisplayName("Test getUserDashboardsInfo(); then status isNotFound()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.settings.UserDashboardsInfo UserController.getUserDashboardsInfo()"
  })
  void testGetUserDashboardsInfo_thenStatusIsNotFound() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isNotFound());
  }

  /**
   * Test {@link UserController#getUserDashboardsInfo()}.
   *
   * <ul>
   *   <li>When logout.
   *   <li>Then content contentType {@code application/json}.
   * </ul>
   *
   * <p>Method under test: {@link UserController#getUserDashboardsInfo()}
   */
  @Test
  @DisplayName(
      "Test getUserDashboardsInfo(); when logout; then content contentType 'application/json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.settings.UserDashboardsInfo UserController.getUserDashboardsInfo()"
  })
  void testGetUserDashboardsInfo_whenLogout_thenContentContentTypeApplicationJson()
      throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));

    LogoutRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.logout();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(content().string("42"));
  }

  /**
   * Test {@link UserController#reportUserDashboardAction(String, String)}.
   *
   * <p>Method under test: {@link UserController#reportUserDashboardAction(String, String)}
   */
  @Test
  @DisplayName("Test reportUserDashboardAction(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.settings.UserDashboardsInfo UserController.reportUserDashboardAction(String, String)"
  })
  void testReportUserDashboardAction() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk());
  }

  /**
   * Test {@link UserController#reportUserDashboardAction(String, String)}.
   *
   * <p>Method under test: {@link UserController#reportUserDashboardAction(String, String)}
   */
  @Test
  @DisplayName("Test reportUserDashboardAction(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.settings.UserDashboardsInfo UserController.reportUserDashboardAction(String, String)"
  })
  void testReportUserDashboardAction2() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(content().string("Body"));
  }

  /**
   * Test {@link UserController#reportUserDashboardAction(String, String)}.
   *
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isNotFound()}.
   * </ul>
   *
   * <p>Method under test: {@link UserController#reportUserDashboardAction(String, String)}
   */
  @Test
  @DisplayName("Test reportUserDashboardAction(String, String); then status isNotFound()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.settings.UserDashboardsInfo UserController.reportUserDashboardAction(String, String)"
  })
  void testReportUserDashboardAction_thenStatusIsNotFound() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isNotFound());
  }

  /**
   * Test {@link UserController#reportUserDashboardAction(String, String)}.
   *
   * <ul>
   *   <li>When logout.
   *   <li>Then content contentType {@code application/json}.
   * </ul>
   *
   * <p>Method under test: {@link UserController#reportUserDashboardAction(String, String)}
   */
  @Test
  @DisplayName(
      "Test reportUserDashboardAction(String, String); when logout; then content contentType 'application/json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.settings.UserDashboardsInfo UserController.reportUserDashboardAction(String, String)"
  })
  void testReportUserDashboardAction_whenLogout_thenContentContentTypeApplicationJson()
      throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));

    LogoutRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.logout();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(content().string("42"));
  }
}
