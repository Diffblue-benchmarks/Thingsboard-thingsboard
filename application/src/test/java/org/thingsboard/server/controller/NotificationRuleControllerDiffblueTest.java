package org.thingsboard.server.controller;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
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
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.StatusResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.common.data.id.NotificationRuleId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.rule.NotificationRule;
import org.thingsboard.server.common.data.notification.rule.NotificationRuleInfo;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.dao.notification.DefaultNotificationRuleService;
import org.thingsboard.server.dao.notification.NotificationRuleService;
import org.thingsboard.server.dao.sql.notification.JpaNotificationRuleDao;
import org.thingsboard.server.dao.sql.notification.NotificationRuleRepository;
import org.thingsboard.server.exception.ThingsboardErrorResponseHandler;
import org.thingsboard.server.service.security.model.SecurityUser;

@ExtendWith(MockitoExtension.class)
class NotificationRuleControllerDiffblueTest {
  @InjectMocks private NotificationRuleController notificationRuleController;

  @Mock private NotificationRuleService notificationRuleService;

  @Mock private ThingsboardErrorResponseHandler thingsboardErrorResponseHandler;

  /**
   * Test {@link NotificationRuleController#saveNotificationRule(NotificationRule, SecurityUser)}.
   *
   * <p>Method under test: {@link NotificationRuleController#saveNotificationRule(NotificationRule,
   * SecurityUser)}
   */
  @Test
  @DisplayName("Test saveNotificationRule(NotificationRule, SecurityUser)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NotificationRule NotificationRuleController.saveNotificationRule(NotificationRule, SecurityUser)"
  })
  void testSaveNotificationRule() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    JpaNotificationRuleDao notificationRuleDao =
        new JpaNotificationRuleDao(mock(NotificationRuleRepository.class));
    DefaultNotificationRuleService notificationRuleService =
        new DefaultNotificationRuleService(notificationRuleDao);
    NotificationRuleController notificationRuleController =
        new NotificationRuleController(notificationRuleService);

    NotificationRuleId notificationRuleId = mock(NotificationRuleId.class);
    when(notificationRuleId.getId()).thenThrow(new IllegalArgumentException());

    NotificationRule notificationRule = new NotificationRule();
    notificationRule.setId(notificationRuleId);

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            notificationRuleController.saveNotificationRule(notificationRule, new SecurityUser()));
    verify(notificationRuleId).getId();
  }

  /**
   * Test {@link NotificationRuleController#saveNotificationRule(NotificationRule, SecurityUser)}.
   *
   * <p>Method under test: {@link NotificationRuleController#saveNotificationRule(NotificationRule,
   * SecurityUser)}
   */
  @Test
  @DisplayName("Test saveNotificationRule(NotificationRule, SecurityUser)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NotificationRule NotificationRuleController.saveNotificationRule(NotificationRule, SecurityUser)"
  })
  void testSaveNotificationRule2() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    JpaNotificationRuleDao notificationRuleDao =
        new JpaNotificationRuleDao(mock(NotificationRuleRepository.class));
    DefaultNotificationRuleService notificationRuleService =
        new DefaultNotificationRuleService(notificationRuleDao);
    NotificationRuleController notificationRuleController =
        new NotificationRuleController(notificationRuleService);

    NotificationRuleId notificationRuleId = mock(NotificationRuleId.class);
    when(notificationRuleId.getEntityType()).thenThrow(new IllegalArgumentException());
    when(notificationRuleId.getId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationRule notificationRule = new NotificationRule();
    notificationRule.setId(notificationRuleId);

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            notificationRuleController.saveNotificationRule(notificationRule, new SecurityUser()));
    verify(notificationRuleId).getEntityType();
    verify(notificationRuleId).getId();
  }

  /**
   * Test {@link NotificationRuleController#saveNotificationRule(NotificationRule, SecurityUser)}.
   *
   * <ul>
   *   <li>Given {@link NotificationRuleId} {@link NotificationRuleId#getEntityType()} return {@code
   *       TENANT}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRuleController#saveNotificationRule(NotificationRule,
   * SecurityUser)}
   */
  @Test
  @DisplayName(
      "Test saveNotificationRule(NotificationRule, SecurityUser); given NotificationRuleId getEntityType() return 'TENANT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NotificationRule NotificationRuleController.saveNotificationRule(NotificationRule, SecurityUser)"
  })
  void testSaveNotificationRule_givenNotificationRuleIdGetEntityTypeReturnTenant()
      throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    JpaNotificationRuleDao notificationRuleDao =
        new JpaNotificationRuleDao(mock(NotificationRuleRepository.class));
    DefaultNotificationRuleService notificationRuleService =
        new DefaultNotificationRuleService(notificationRuleDao);
    NotificationRuleController notificationRuleController =
        new NotificationRuleController(notificationRuleService);

    NotificationRuleId notificationRuleId = mock(NotificationRuleId.class);
    when(notificationRuleId.getEntityType()).thenReturn(EntityType.TENANT);
    when(notificationRuleId.getId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationRule notificationRule = new NotificationRule();
    notificationRule.setId(notificationRuleId);

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            notificationRuleController.saveNotificationRule(notificationRule, new SecurityUser()));
    verify(notificationRuleId).getEntityType();
    verify(notificationRuleId, atLeast(1)).getId();
  }

  /**
   * Test {@link NotificationRuleController#saveNotificationRule(NotificationRule, SecurityUser)}.
   *
   * <ul>
   *   <li>Given {@link NotificationRuleId} {@link NotificationRuleId#getId()} return randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRuleController#saveNotificationRule(NotificationRule,
   * SecurityUser)}
   */
  @Test
  @DisplayName(
      "Test saveNotificationRule(NotificationRule, SecurityUser); given NotificationRuleId getId() return randomUUID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NotificationRule NotificationRuleController.saveNotificationRule(NotificationRule, SecurityUser)"
  })
  void testSaveNotificationRule_givenNotificationRuleIdGetIdReturnRandomUUID() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    JpaNotificationRuleDao notificationRuleDao =
        new JpaNotificationRuleDao(mock(NotificationRuleRepository.class));
    DefaultNotificationRuleService notificationRuleService =
        new DefaultNotificationRuleService(notificationRuleDao);
    NotificationRuleController notificationRuleController =
        new NotificationRuleController(notificationRuleService);

    NotificationRuleId notificationRuleId = mock(NotificationRuleId.class);
    when(notificationRuleId.getEntityType()).thenReturn(EntityType.TENANT);
    when(notificationRuleId.getId()).thenReturn(UUID.randomUUID());

    NotificationRule notificationRule = new NotificationRule();
    notificationRule.setId(notificationRuleId);

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            notificationRuleController.saveNotificationRule(notificationRule, new SecurityUser()));
    verify(notificationRuleId).getEntityType();
    verify(notificationRuleId, atLeast(1)).getId();
  }

  /**
   * Test {@link NotificationRuleController#saveNotificationRule(NotificationRule, SecurityUser)}.
   *
   * <ul>
   *   <li>Given {@link NotificationRuleId#NotificationRuleId(UUID)} with id is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRuleController#saveNotificationRule(NotificationRule,
   * SecurityUser)}
   */
  @Test
  @DisplayName(
      "Test saveNotificationRule(NotificationRule, SecurityUser); given NotificationRuleId(UUID) with id is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NotificationRule NotificationRuleController.saveNotificationRule(NotificationRule, SecurityUser)"
  })
  void testSaveNotificationRule_givenNotificationRuleIdWithIdIsNull() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    JpaNotificationRuleDao notificationRuleDao =
        new JpaNotificationRuleDao(mock(NotificationRuleRepository.class));
    DefaultNotificationRuleService notificationRuleService =
        new DefaultNotificationRuleService(notificationRuleDao);
    NotificationRuleController notificationRuleController =
        new NotificationRuleController(notificationRuleService);

    NotificationRule notificationRule = new NotificationRule();
    notificationRule.setId(new NotificationRuleId(null));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            notificationRuleController.saveNotificationRule(notificationRule, new SecurityUser()));
  }

  /**
   * Test {@link NotificationRuleController#saveNotificationRule(NotificationRule, SecurityUser)}.
   *
   * <ul>
   *   <li>When {@link NotificationRule#NotificationRule()}.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRuleController#saveNotificationRule(NotificationRule,
   * SecurityUser)}
   */
  @Test
  @DisplayName(
      "Test saveNotificationRule(NotificationRule, SecurityUser); when NotificationRule(); then throw ThingsboardException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NotificationRule NotificationRuleController.saveNotificationRule(NotificationRule, SecurityUser)"
  })
  void testSaveNotificationRule_whenNotificationRule_thenThrowThingsboardException()
      throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    JpaNotificationRuleDao notificationRuleDao =
        new JpaNotificationRuleDao(mock(NotificationRuleRepository.class));
    DefaultNotificationRuleService notificationRuleService =
        new DefaultNotificationRuleService(notificationRuleDao);
    NotificationRuleController notificationRuleController =
        new NotificationRuleController(notificationRuleService);
    NotificationRule notificationRule = new NotificationRule();

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            notificationRuleController.saveNotificationRule(notificationRule, new SecurityUser()));
  }

  /**
   * Test {@link NotificationRuleController#getNotificationRuleById(UUID)}.
   *
   * <p>Method under test: {@link NotificationRuleController#getNotificationRuleById(UUID)}
   */
  @Test
  @DisplayName("Test getNotificationRuleById(UUID)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NotificationRuleInfo NotificationRuleController.getNotificationRuleById(UUID)"
  })
  void testGetNotificationRuleById() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/notification/rule/{id}", "42");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(notificationRuleController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().is(400));
  }

  /**
   * Test {@link NotificationRuleController#getNotificationRules(int, int, String, String, String,
   * SecurityUser)}.
   *
   * <ul>
   *   <li>Then status four hundred six.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRuleController#getNotificationRules(int, int, String,
   * String, String, SecurityUser)}
   */
  @Test
  @DisplayName(
      "Test getNotificationRules(int, int, String, String, String, SecurityUser); then status four hundred six")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData NotificationRuleController.getNotificationRules(int, int, String, String, String, SecurityUser)"
  })
  void testGetNotificationRules_thenStatusFourHundredSix() throws Exception {
    // Arrange
    PageData<NotificationRuleInfo> emptyPageDataResult = PageData.emptyPageData();
    when(notificationRuleService.findNotificationRulesInfosByTenantId(
            Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/notification/rules");
    getResult.accept("Media Types");

    MockHttpServletRequestBuilder requestBuilder =
        getResult.param("page", String.valueOf(1)).param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(notificationRuleController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().is(406));
  }

  /**
   * Test {@link NotificationRuleController#getNotificationRules(int, int, String, String, String,
   * SecurityUser)}.
   *
   * <ul>
   *   <li>When {@code foo}.
   *   <li>Then status {@link StatusResultMatchers#isOk()}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRuleController#getNotificationRules(int, int, String,
   * String, String, SecurityUser)}
   */
  @Test
  @DisplayName(
      "Test getNotificationRules(int, int, String, String, String, SecurityUser); when 'foo'; then status isOk()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData NotificationRuleController.getNotificationRules(int, int, String, String, String, SecurityUser)"
  })
  void testGetNotificationRules_whenFoo_thenStatusIsOk() throws Exception {
    // Arrange
    PageData<NotificationRuleInfo> emptyPageDataResult = PageData.emptyPageData();
    when(notificationRuleService.findNotificationRulesInfosByTenantId(
            Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/notification/rules")
            .param("page", String.valueOf(1))
            .param("pageSize", String.valueOf(1))
            .param("sortProperty", "foo");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(notificationRuleController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(
            content()
                .string("{\"data\":[],\"totalPages\":0,\"totalElements\":0,\"hasNext\":false}"));
  }

  /**
   * Test {@link NotificationRuleController#getNotificationRules(int, int, String, String, String,
   * SecurityUser)}.
   *
   * <ul>
   *   <li>When {@link MockMvcRequestBuilders#get(String, Object[])} {@code
   *       /api/notification/rules}.
   *   <li>Then status {@link StatusResultMatchers#isOk()}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRuleController#getNotificationRules(int, int, String,
   * String, String, SecurityUser)}
   */
  @Test
  @DisplayName(
      "Test getNotificationRules(int, int, String, String, String, SecurityUser); when get(String, Object[]) '/api/notification/rules'; then status isOk()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData NotificationRuleController.getNotificationRules(int, int, String, String, String, SecurityUser)"
  })
  void testGetNotificationRules_whenGetApiNotificationRules_thenStatusIsOk() throws Exception {
    // Arrange
    PageData<NotificationRuleInfo> emptyPageDataResult = PageData.emptyPageData();
    when(notificationRuleService.findNotificationRulesInfosByTenantId(
            Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/notification/rules")
            .param("page", String.valueOf(1))
            .param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(notificationRuleController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(
            content()
                .string("{\"data\":[],\"totalPages\":0,\"totalElements\":0,\"hasNext\":false}"));
  }

  /**
   * Test {@link NotificationRuleController#deleteNotificationRule(UUID, SecurityUser)}.
   *
   * <p>Method under test: {@link NotificationRuleController#deleteNotificationRule(UUID,
   * SecurityUser)}
   */
  @Test
  @DisplayName("Test deleteNotificationRule(UUID, SecurityUser)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NotificationRuleController.deleteNotificationRule(UUID, SecurityUser)"})
  void testDeleteNotificationRule() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.delete(
            "/api/notification/rule/{id}", UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(notificationRuleController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().is(400));
  }

  /**
   * Test {@link NotificationRuleController#deleteNotificationRule(UUID, SecurityUser)}.
   *
   * <p>Method under test: {@link NotificationRuleController#deleteNotificationRule(UUID,
   * SecurityUser)}
   */
  @Test
  @DisplayName("Test deleteNotificationRule(UUID, SecurityUser)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NotificationRuleController.deleteNotificationRule(UUID, SecurityUser)"})
  void testDeleteNotificationRule2() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.delete("/api/notification/rule/{id}", "42");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(notificationRuleController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().is(400));
  }

  /**
   * Test {@link NotificationRuleController#deleteNotificationRule(UUID, SecurityUser)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRuleController#deleteNotificationRule(UUID,
   * SecurityUser)}
   */
  @Test
  @DisplayName("Test deleteNotificationRule(UUID, SecurityUser); given 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NotificationRuleController.deleteNotificationRule(UUID, SecurityUser)"})
  void testDeleteNotificationRule_givenTrue() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.delete(
            "/api/notification/rule/{id}", UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    requestBuilder.secure(true);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(notificationRuleController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().is(400));
  }
}
