package org.thingsboard.server.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import org.apache.catalina.connector.Response;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.HasTenantId;
import org.thingsboard.server.common.data.exception.EntityVersionMismatchException;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.common.data.id.AlarmCommentId;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.ApiUsageStateId;
import org.thingsboard.server.common.data.id.AssetId;
import org.thingsboard.server.common.data.id.AssetProfileId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.DashboardId;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.DeviceProfileId;
import org.thingsboard.server.common.data.id.DomainId;
import org.thingsboard.server.common.data.id.EdgeId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.EntityViewId;
import org.thingsboard.server.common.data.id.MobileAppId;
import org.thingsboard.server.common.data.id.NotificationId;
import org.thingsboard.server.common.data.id.NotificationRequestId;
import org.thingsboard.server.common.data.id.NotificationRuleId;
import org.thingsboard.server.common.data.id.NotificationTargetId;
import org.thingsboard.server.common.data.id.NotificationTemplateId;
import org.thingsboard.server.common.data.id.OAuth2ClientId;
import org.thingsboard.server.common.data.id.OtaPackageId;
import org.thingsboard.server.common.data.id.QueueId;
import org.thingsboard.server.common.data.id.QueueStatsId;
import org.thingsboard.server.common.data.id.RpcId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.id.TbResourceId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.TenantProfileId;
import org.thingsboard.server.common.data.id.UserId;
import org.thingsboard.server.common.data.id.WidgetTypeId;
import org.thingsboard.server.common.data.id.WidgetsBundleId;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.common.data.page.SortOrder.Direction;
import org.thingsboard.server.common.data.page.TimePageLink;
import org.thingsboard.server.common.data.plugin.ComponentDescriptor;
import org.thingsboard.server.common.data.plugin.ComponentType;
import org.thingsboard.server.common.data.query.EntityDataSortOrder;
import org.thingsboard.server.common.data.query.EntityKey;
import org.thingsboard.server.common.data.query.EntityKeyType;
import org.thingsboard.server.common.data.rule.RuleChainType;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.exception.IncorrectParameterException;
import org.thingsboard.server.exception.ThingsboardErrorResponseHandler;
import org.thingsboard.server.service.component.ComponentDiscoveryService;
import org.thingsboard.server.service.security.permission.Operation;
import org.thingsboard.server.service.security.permission.Resource;
import org.thingsboard.server.service.telemetry.AlarmSubscriptionService;

@ExtendWith(MockitoExtension.class)
class BaseControllerDiffblueTest {
  @Mock private AlarmSubscriptionService alarmSubscriptionService;

  @InjectMocks private AuditLogController auditLogController;

  @Mock private ComponentDiscoveryService componentDiscoveryService;

  @Mock private ThingsboardErrorResponseHandler thingsboardErrorResponseHandler;

  /**
   * Test {@link BaseController#handleControllerException(Exception, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Then calls {@link ThingsboardErrorResponseHandler#handle(Exception,
   *       HttpServletResponse)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#handleControllerException(Exception,
   * HttpServletResponse)}
   */
  @Test
  @DisplayName(
      "Test handleControllerException(Exception, HttpServletResponse); then calls handle(Exception, HttpServletResponse)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void BaseController.handleControllerException(Exception, HttpServletResponse)"
  })
  void testHandleControllerException_thenCallsHandle() {
    // Arrange
    doNothing()
        .when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    Exception e = new Exception("foo");

    // Act
    auditLogController.handleControllerException(e, new Response());

    // Assert
    verify(thingsboardErrorResponseHandler)
        .handle(isA(Exception.class), isA(HttpServletResponse.class));
  }

  /**
   * Test {@link BaseController#checkNotNull(Object, String)} with {@code Object}, {@code String}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#checkNotNull(Object, String)}
   */
  @Test
  @DisplayName(
      "Test checkNotNull(Object, String) with 'Object', 'String'; when 'null'; then throw ThingsboardException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object BaseController.checkNotNull(Object, String)"})
  void testCheckNotNullWithObjectString_whenNull_thenThrowThingsboardException()
      throws ThingsboardException {
    // Arrange, Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> new AuditLogController().checkNotNull((Object) null, "Not Found Message"));
  }

  /**
   * Test {@link BaseController#checkNotNull(Object, String)} with {@code Object}, {@code String}.
   *
   * <ul>
   *   <li>When {@code Reference}.
   *   <li>Then return {@code Reference}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#checkNotNull(Object, String)}
   */
  @Test
  @DisplayName(
      "Test checkNotNull(Object, String) with 'Object', 'String'; when 'Reference'; then return 'Reference'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object BaseController.checkNotNull(Object, String)"})
  void testCheckNotNullWithObjectString_whenReference_thenReturnReference()
      throws ThingsboardException {
    // Arrange, Act and Assert
    assertEquals(
        "Reference", new AuditLogController().checkNotNull("Reference", "Not Found Message"));
  }

  /**
   * Test {@link BaseController#checkNotNull(Object)} with {@code Object}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#checkNotNull(Object)}
   */
  @Test
  @DisplayName(
      "Test checkNotNull(Object) with 'Object'; when 'null'; then throw ThingsboardException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object BaseController.checkNotNull(Object)"})
  void testCheckNotNullWithObject_whenNull_thenThrowThingsboardException()
      throws ThingsboardException {
    // Arrange, Act and Assert
    assertThrows(
        ThingsboardException.class, () -> new AuditLogController().checkNotNull((Object) null));
  }

  /**
   * Test {@link BaseController#checkNotNull(Object)} with {@code Object}.
   *
   * <ul>
   *   <li>When {@code Reference}.
   *   <li>Then return {@code Reference}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#checkNotNull(Object)}
   */
  @Test
  @DisplayName("Test checkNotNull(Object) with 'Object'; when 'Reference'; then return 'Reference'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object BaseController.checkNotNull(Object)"})
  void testCheckNotNullWithObject_whenReference_thenReturnReference() throws ThingsboardException {
    // Arrange, Act and Assert
    assertEquals("Reference", new AuditLogController().checkNotNull("Reference"));
  }

  /**
   * Test {@link BaseController#checkNotNull(Optional, String)} with {@code Optional}, {@code
   * String}.
   *
   * <ul>
   *   <li>When empty.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#checkNotNull(Optional, String)}
   */
  @Test
  @DisplayName(
      "Test checkNotNull(Optional, String) with 'Optional', 'String'; when empty; then throw ThingsboardException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object BaseController.checkNotNull(Optional, String)"})
  void testCheckNotNullWithOptionalString_whenEmpty_thenThrowThingsboardException()
      throws ThingsboardException {
    // Arrange
    AuditLogController auditLogController = new AuditLogController();
    Optional<Object> reference = Optional.empty();

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> auditLogController.checkNotNull(reference, "Not Found Message"));
  }

  /**
   * Test {@link BaseController#checkNotNull(Optional, String)} with {@code Optional}, {@code
   * String}.
   *
   * <ul>
   *   <li>When {@link Optional} with {@code 42}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#checkNotNull(Optional, String)}
   */
  @Test
  @DisplayName(
      "Test checkNotNull(Optional, String) with 'Optional', 'String'; when Optional with '42'; then return '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object BaseController.checkNotNull(Optional, String)"})
  void testCheckNotNullWithOptionalString_whenOptionalWith42_thenReturn42()
      throws ThingsboardException {
    // Arrange
    AuditLogController auditLogController = new AuditLogController();
    Optional<Object> reference = Optional.of("42");

    // Act and Assert
    assertEquals("42", auditLogController.checkNotNull(reference, "Not Found Message"));
  }

  /**
   * Test {@link BaseController#checkNotNull(Optional)} with {@code Optional}.
   *
   * <ul>
   *   <li>When empty.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#checkNotNull(Optional)}
   */
  @Test
  @DisplayName(
      "Test checkNotNull(Optional) with 'Optional'; when empty; then throw ThingsboardException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object BaseController.checkNotNull(Optional)"})
  void testCheckNotNullWithOptional_whenEmpty_thenThrowThingsboardException()
      throws ThingsboardException {
    // Arrange
    AuditLogController auditLogController = new AuditLogController();
    Optional<Object> reference = Optional.empty();

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> auditLogController.checkNotNull(reference));
  }

  /**
   * Test {@link BaseController#checkNotNull(Optional)} with {@code Optional}.
   *
   * <ul>
   *   <li>When {@link Optional} with {@code 42}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#checkNotNull(Optional)}
   */
  @Test
  @DisplayName(
      "Test checkNotNull(Optional) with 'Optional'; when Optional with '42'; then return '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object BaseController.checkNotNull(Optional)"})
  void testCheckNotNullWithOptional_whenOptionalWith42_thenReturn42() throws ThingsboardException {
    // Arrange
    AuditLogController auditLogController = new AuditLogController();
    Optional<Object> reference = Optional.of("42");

    // Act and Assert
    assertEquals("42", auditLogController.checkNotNull(reference));
  }

  /**
   * Test {@link BaseController#checkParameter(String, String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#checkParameter(String, String)}
   */
  @Test
  @DisplayName(
      "Test checkParameter(String, String); when empty string; then throw ThingsboardException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseController.checkParameter(String, String)"})
  void testCheckParameter_whenEmptyString_thenThrowThingsboardException()
      throws ThingsboardException {
    // Arrange, Act and Assert
    assertThrows(
        ThingsboardException.class, () -> new AuditLogController().checkParameter("Name", ""));
  }

  /**
   * Test {@link BaseController#checkParameter(String, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#checkParameter(String, String)}
   */
  @Test
  @DisplayName("Test checkParameter(String, String); when 'null'; then throw ThingsboardException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseController.checkParameter(String, String)"})
  void testCheckParameter_whenNull_thenThrowThingsboardException() throws ThingsboardException {
    // Arrange, Act and Assert
    assertThrows(
        ThingsboardException.class, () -> new AuditLogController().checkParameter("Name", null));
  }

  /**
   * Test {@link BaseController#checkArrayParameter(String, String[])}.
   *
   * <ul>
   *   <li>When array of {@link String} with empty string.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#checkArrayParameter(String, String[])}
   */
  @Test
  @DisplayName("Test checkArrayParameter(String, String[]); when array of String with empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseController.checkArrayParameter(String, String[])"})
  void testCheckArrayParameter_whenArrayOfStringWithEmptyString() throws ThingsboardException {
    // Arrange, Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> new AuditLogController().checkArrayParameter("Name", new String[] {""}));
  }

  /**
   * Test {@link BaseController#checkArrayParameter(String, String[])}.
   *
   * <ul>
   *   <li>When array of {@link String} with {@code null}.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#checkArrayParameter(String, String[])}
   */
  @Test
  @DisplayName(
      "Test checkArrayParameter(String, String[]); when array of String with 'null'; then throw ThingsboardException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseController.checkArrayParameter(String, String[])"})
  void testCheckArrayParameter_whenArrayOfStringWithNull_thenThrowThingsboardException()
      throws ThingsboardException {
    // Arrange, Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> new AuditLogController().checkArrayParameter("Name", new String[] {null}));
  }

  /**
   * Test {@link BaseController#checkArrayParameter(String, String[])}.
   *
   * <ul>
   *   <li>When empty array of {@link String}.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#checkArrayParameter(String, String[])}
   */
  @Test
  @DisplayName(
      "Test checkArrayParameter(String, String[]); when empty array of String; then throw ThingsboardException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseController.checkArrayParameter(String, String[])"})
  void testCheckArrayParameter_whenEmptyArrayOfString_thenThrowThingsboardException()
      throws ThingsboardException {
    // Arrange, Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> new AuditLogController().checkArrayParameter("Name", new String[] {}));
  }

  /**
   * Test {@link BaseController#checkArrayParameter(String, String[])}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#checkArrayParameter(String, String[])}
   */
  @Test
  @DisplayName(
      "Test checkArrayParameter(String, String[]); when 'null'; then throw ThingsboardException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseController.checkArrayParameter(String, String[])"})
  void testCheckArrayParameter_whenNull_thenThrowThingsboardException()
      throws ThingsboardException {
    // Arrange, Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> new AuditLogController().checkArrayParameter("Name", null));
  }

  /**
   * Test {@link BaseController#createPageLink(int, int, String, String, String)}.
   *
   * <ul>
   *   <li>Then return SortOrder Property is {@code homeDashboardId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#createPageLink(int, int, String, String, String)}
   */
  @Test
  @DisplayName(
      "Test createPageLink(int, int, String, String, String); then return SortOrder Property is 'homeDashboardId'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PageLink BaseController.createPageLink(int, int, String, String, String)"})
  void testCreatePageLink_thenReturnSortOrderPropertyIsHomeDashboardId()
      throws ThingsboardException {
    // Arrange and Act
    PageLink actualCreatePageLinkResult =
        new AuditLogController().createPageLink(3, 1, "Text Search", "homeDashboardId", "asc");

    // Assert
    assertEquals("Text Search", actualCreatePageLinkResult.getTextSearch());
    SortOrder sortOrder = actualCreatePageLinkResult.getSortOrder();
    assertEquals("homeDashboardId", sortOrder.getProperty());
    assertEquals(1, actualCreatePageLinkResult.getPage());
    assertEquals(3, actualCreatePageLinkResult.getPageSize());
    assertEquals(Direction.ASC, sortOrder.getDirection());
  }

  /**
   * Test {@link BaseController#createPageLink(int, int, String, String, String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return SortOrder is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#createPageLink(int, int, String, String, String)}
   */
  @Test
  @DisplayName(
      "Test createPageLink(int, int, String, String, String); when empty string; then return SortOrder is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PageLink BaseController.createPageLink(int, int, String, String, String)"})
  void testCreatePageLink_whenEmptyString_thenReturnSortOrderIsNull() throws ThingsboardException {
    // Arrange and Act
    PageLink actualCreatePageLinkResult =
        new AuditLogController().createPageLink(3, 1, "Text Search", "", "not empty");

    // Assert
    assertEquals("Text Search", actualCreatePageLinkResult.getTextSearch());
    assertNull(actualCreatePageLinkResult.getSortOrder());
    assertEquals(1, actualCreatePageLinkResult.getPage());
    assertEquals(3, actualCreatePageLinkResult.getPageSize());
  }

  /**
   * Test {@link BaseController#createPageLink(int, int, String, String, String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return SortOrder Property is {@code U}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#createPageLink(int, int, String, String, String)}
   */
  @Test
  @DisplayName(
      "Test createPageLink(int, int, String, String, String); when empty string; then return SortOrder Property is 'U'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PageLink BaseController.createPageLink(int, int, String, String, String)"})
  void testCreatePageLink_whenEmptyString_thenReturnSortOrderPropertyIsU()
      throws ThingsboardException {
    // Arrange and Act
    PageLink actualCreatePageLinkResult =
        new AuditLogController().createPageLink(3, 1, "Text Search", "U", "");

    // Assert
    assertEquals("Text Search", actualCreatePageLinkResult.getTextSearch());
    SortOrder sortOrder = actualCreatePageLinkResult.getSortOrder();
    assertEquals("U", sortOrder.getProperty());
    assertEquals(1, actualCreatePageLinkResult.getPage());
    assertEquals(3, actualCreatePageLinkResult.getPageSize());
    assertEquals(Direction.ASC, sortOrder.getDirection());
  }

  /**
   * Test {@link BaseController#createPageLink(int, int, String, String, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return SortOrder is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#createPageLink(int, int, String, String, String)}
   */
  @Test
  @DisplayName(
      "Test createPageLink(int, int, String, String, String); when 'null'; then return SortOrder is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PageLink BaseController.createPageLink(int, int, String, String, String)"})
  void testCreatePageLink_whenNull_thenReturnSortOrderIsNull() throws ThingsboardException {
    // Arrange and Act
    PageLink actualCreatePageLinkResult =
        new AuditLogController().createPageLink(3, 1, "Text Search", null, "not empty");

    // Assert
    assertEquals("Text Search", actualCreatePageLinkResult.getTextSearch());
    assertNull(actualCreatePageLinkResult.getSortOrder());
    assertEquals(1, actualCreatePageLinkResult.getPage());
    assertEquals(3, actualCreatePageLinkResult.getPageSize());
  }

  /**
   * Test {@link BaseController#createPageLink(int, int, String, String, String)}.
   *
   * <ul>
   *   <li>When {@code Sort Property}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#createPageLink(int, int, String, String, String)}
   */
  @Test
  @DisplayName(
      "Test createPageLink(int, int, String, String, String); when 'Sort Property'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PageLink BaseController.createPageLink(int, int, String, String, String)"})
  void testCreatePageLink_whenSortProperty_thenThrowIllegalArgumentException()
      throws ThingsboardException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new AuditLogController().createPageLink(3, 1, "Text Search", "Sort Property", "asc"));
  }

  /**
   * Test {@link BaseController#createPageLink(int, int, String, String, String)}.
   *
   * <ul>
   *   <li>When {@code U}.
   *   <li>Then return SortOrder Property is {@code U}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#createPageLink(int, int, String, String, String)}
   */
  @Test
  @DisplayName(
      "Test createPageLink(int, int, String, String, String); when 'U'; then return SortOrder Property is 'U'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PageLink BaseController.createPageLink(int, int, String, String, String)"})
  void testCreatePageLink_whenU_thenReturnSortOrderPropertyIsU() throws ThingsboardException {
    // Arrange and Act
    PageLink actualCreatePageLinkResult =
        new AuditLogController().createPageLink(3, 1, "Text Search", "U", "asc");

    // Assert
    assertEquals("Text Search", actualCreatePageLinkResult.getTextSearch());
    SortOrder sortOrder = actualCreatePageLinkResult.getSortOrder();
    assertEquals("U", sortOrder.getProperty());
    assertEquals(1, actualCreatePageLinkResult.getPage());
    assertEquals(3, actualCreatePageLinkResult.getPageSize());
    assertEquals(Direction.ASC, sortOrder.getDirection());
  }

  /**
   * Test {@link BaseController#createPageLink(int, int, String, String, String)}.
   *
   * <ul>
   *   <li>When {@code U}.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#createPageLink(int, int, String, String, String)}
   */
  @Test
  @DisplayName(
      "Test createPageLink(int, int, String, String, String); when 'U'; then throw ThingsboardException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PageLink BaseController.createPageLink(int, int, String, String, String)"})
  void testCreatePageLink_whenU_thenThrowThingsboardException() throws ThingsboardException {
    // Arrange, Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> new AuditLogController().createPageLink(3, 1, "Text Search", "U", "U"));
  }

  /**
   * Test {@link BaseController#createTimePageLink(int, int, String, String, String, Long, Long)}.
   *
   * <ul>
   *   <li>When {@code asc}.
   *   <li>Then return SortOrder Property is {@code U}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#createTimePageLink(int, int, String, String,
   * String, Long, Long)}
   */
  @Test
  @DisplayName(
      "Test createTimePageLink(int, int, String, String, String, Long, Long); when 'asc'; then return SortOrder Property is 'U'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TimePageLink BaseController.createTimePageLink(int, int, String, String, String, Long, Long)"
  })
  void testCreateTimePageLink_whenAsc_thenReturnSortOrderPropertyIsU() throws ThingsboardException {
    // Arrange and Act
    TimePageLink actualCreateTimePageLinkResult =
        new AuditLogController().createTimePageLink(3, 1, "Text Search", "U", "asc", 1L, 1L);

    // Assert
    assertEquals("Text Search", actualCreateTimePageLinkResult.getTextSearch());
    SortOrder sortOrder = actualCreateTimePageLinkResult.getSortOrder();
    assertEquals("U", sortOrder.getProperty());
    assertEquals(1, actualCreateTimePageLinkResult.getPage());
    assertEquals(1L, actualCreateTimePageLinkResult.getEndTime().longValue());
    assertEquals(1L, actualCreateTimePageLinkResult.getStartTime().longValue());
    assertEquals(3, actualCreateTimePageLinkResult.getPageSize());
    assertEquals(Direction.ASC, sortOrder.getDirection());
  }

  /**
   * Test {@link BaseController#createTimePageLink(int, int, String, String, String, Long, Long)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return SortOrder is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#createTimePageLink(int, int, String, String,
   * String, Long, Long)}
   */
  @Test
  @DisplayName(
      "Test createTimePageLink(int, int, String, String, String, Long, Long); when empty string; then return SortOrder is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TimePageLink BaseController.createTimePageLink(int, int, String, String, String, Long, Long)"
  })
  void testCreateTimePageLink_whenEmptyString_thenReturnSortOrderIsNull()
      throws ThingsboardException {
    // Arrange and Act
    TimePageLink actualCreateTimePageLinkResult =
        new AuditLogController().createTimePageLink(3, 1, "Text Search", "", "not empty", 1L, 1L);

    // Assert
    assertEquals("Text Search", actualCreateTimePageLinkResult.getTextSearch());
    assertNull(actualCreateTimePageLinkResult.getSortOrder());
    assertEquals(1, actualCreateTimePageLinkResult.getPage());
    assertEquals(1L, actualCreateTimePageLinkResult.getEndTime().longValue());
    assertEquals(1L, actualCreateTimePageLinkResult.getStartTime().longValue());
    assertEquals(3, actualCreateTimePageLinkResult.getPageSize());
  }

  /**
   * Test {@link BaseController#createTimePageLink(int, int, String, String, String, Long, Long)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return SortOrder Property is {@code U}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#createTimePageLink(int, int, String, String,
   * String, Long, Long)}
   */
  @Test
  @DisplayName(
      "Test createTimePageLink(int, int, String, String, String, Long, Long); when empty string; then return SortOrder Property is 'U'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TimePageLink BaseController.createTimePageLink(int, int, String, String, String, Long, Long)"
  })
  void testCreateTimePageLink_whenEmptyString_thenReturnSortOrderPropertyIsU()
      throws ThingsboardException {
    // Arrange and Act
    TimePageLink actualCreateTimePageLinkResult =
        new AuditLogController().createTimePageLink(3, 1, "Text Search", "U", "", 1L, 1L);

    // Assert
    assertEquals("Text Search", actualCreateTimePageLinkResult.getTextSearch());
    SortOrder sortOrder = actualCreateTimePageLinkResult.getSortOrder();
    assertEquals("U", sortOrder.getProperty());
    assertEquals(1, actualCreateTimePageLinkResult.getPage());
    assertEquals(1L, actualCreateTimePageLinkResult.getEndTime().longValue());
    assertEquals(1L, actualCreateTimePageLinkResult.getStartTime().longValue());
    assertEquals(3, actualCreateTimePageLinkResult.getPageSize());
    assertEquals(Direction.ASC, sortOrder.getDirection());
  }

  /**
   * Test {@link BaseController#createTimePageLink(int, int, String, String, String, Long, Long)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return SortOrder is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#createTimePageLink(int, int, String, String,
   * String, Long, Long)}
   */
  @Test
  @DisplayName(
      "Test createTimePageLink(int, int, String, String, String, Long, Long); when 'null'; then return SortOrder is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TimePageLink BaseController.createTimePageLink(int, int, String, String, String, Long, Long)"
  })
  void testCreateTimePageLink_whenNull_thenReturnSortOrderIsNull() throws ThingsboardException {
    // Arrange and Act
    TimePageLink actualCreateTimePageLinkResult =
        new AuditLogController().createTimePageLink(3, 1, "Text Search", null, "not empty", 1L, 1L);

    // Assert
    assertEquals("Text Search", actualCreateTimePageLinkResult.getTextSearch());
    assertNull(actualCreateTimePageLinkResult.getSortOrder());
    assertEquals(1, actualCreateTimePageLinkResult.getPage());
    assertEquals(1L, actualCreateTimePageLinkResult.getEndTime().longValue());
    assertEquals(1L, actualCreateTimePageLinkResult.getStartTime().longValue());
    assertEquals(3, actualCreateTimePageLinkResult.getPageSize());
  }

  /**
   * Test {@link BaseController#createTimePageLink(int, int, String, String, String, Long, Long)}.
   *
   * <ul>
   *   <li>When {@code Sort Property}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#createTimePageLink(int, int, String, String,
   * String, Long, Long)}
   */
  @Test
  @DisplayName(
      "Test createTimePageLink(int, int, String, String, String, Long, Long); when 'Sort Property'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TimePageLink BaseController.createTimePageLink(int, int, String, String, String, Long, Long)"
  })
  void testCreateTimePageLink_whenSortProperty_thenThrowIllegalArgumentException()
      throws ThingsboardException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new AuditLogController()
                .createTimePageLink(3, 1, "Text Search", "Sort Property", "asc", 1L, 1L));
  }

  /**
   * Test {@link BaseController#createTimePageLink(int, int, String, String, String, Long, Long)}.
   *
   * <ul>
   *   <li>When {@code U}.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#createTimePageLink(int, int, String, String,
   * String, Long, Long)}
   */
  @Test
  @DisplayName(
      "Test createTimePageLink(int, int, String, String, String, Long, Long); when 'U'; then throw ThingsboardException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TimePageLink BaseController.createTimePageLink(int, int, String, String, String, Long, Long)"
  })
  void testCreateTimePageLink_whenU_thenThrowThingsboardException() throws ThingsboardException {
    // Arrange, Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> new AuditLogController().createTimePageLink(3, 1, "Text Search", "U", "U", 1L, 1L));
  }

  /**
   * Test {@link BaseController#getCurrentUser()}.
   *
   * <p>Method under test: {@link BaseController#getCurrentUser()}
   */
  @Test
  @DisplayName("Test getCurrentUser()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.service.security.model.SecurityUser BaseController.getCurrentUser()"
  })
  void testGetCurrentUser() throws ThingsboardException {
    // Arrange, Act and Assert
    assertThrows(ThingsboardException.class, () -> new AuditLogController().getCurrentUser());
  }

  /**
   * Test {@link BaseController#checkTenantId(TenantId, Operation)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#checkTenantId(TenantId, Operation)}
   */
  @Test
  @DisplayName("Test checkTenantId(TenantId, Operation); when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.Tenant BaseController.checkTenantId(TenantId, Operation)"
  })
  void testCheckTenantId_whenNull() throws ThingsboardException {
    // Arrange, Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> new AuditLogController().checkTenantId(null, Operation.ALL));
  }

  /**
   * Test {@link BaseController#checkTenantId(TenantId, Operation)}.
   *
   * <ul>
   *   <li>When {@link TenantId#TenantId(UUID)} with id is fromString {@code
   *       784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#checkTenantId(TenantId, Operation)}
   */
  @Test
  @DisplayName(
      "Test checkTenantId(TenantId, Operation); when TenantId(UUID) with id is fromString '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.Tenant BaseController.checkTenantId(TenantId, Operation)"
  })
  void testCheckTenantId_whenTenantIdWithIdIsFromString784f394c42b6435a983cB7beff2784f9()
      throws ThingsboardException {
    // Arrange
    AuditLogController auditLogController = new AuditLogController();

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            auditLogController.checkTenantId(
                new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
                Operation.ALL));
  }

  /**
   * Test {@link BaseController#checkTenantId(TenantId, Operation)}.
   *
   * <ul>
   *   <li>When {@link TenantId#TenantId(UUID)} with id is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#checkTenantId(TenantId, Operation)}
   */
  @Test
  @DisplayName("Test checkTenantId(TenantId, Operation); when TenantId(UUID) with id is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.Tenant BaseController.checkTenantId(TenantId, Operation)"
  })
  void testCheckTenantId_whenTenantIdWithIdIsNull() throws ThingsboardException {
    // Arrange
    AuditLogController auditLogController = new AuditLogController();

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> auditLogController.checkTenantId(new TenantId(null), Operation.ALL));
  }

  /**
   * Test {@link BaseController#checkTenantInfoId(TenantId, Operation)}.
   *
   * <p>Method under test: {@link BaseController#checkTenantInfoId(TenantId, Operation)}
   */
  @Test
  @DisplayName("Test checkTenantInfoId(TenantId, Operation)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.TenantInfo BaseController.checkTenantInfoId(TenantId, Operation)"
  })
  void testCheckTenantInfoId() throws ThingsboardException {
    // Arrange
    AuditLogController auditLogController = new AuditLogController();

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            auditLogController.checkTenantInfoId(
                new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
                Operation.ALL));
  }

  /**
   * Test {@link BaseController#checkTenantInfoId(TenantId, Operation)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#checkTenantInfoId(TenantId, Operation)}
   */
  @Test
  @DisplayName("Test checkTenantInfoId(TenantId, Operation); when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.TenantInfo BaseController.checkTenantInfoId(TenantId, Operation)"
  })
  void testCheckTenantInfoId_whenNull() throws ThingsboardException {
    // Arrange, Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> new AuditLogController().checkTenantInfoId(null, Operation.ALL));
  }

  /**
   * Test {@link BaseController#checkTenantInfoId(TenantId, Operation)}.
   *
   * <ul>
   *   <li>When {@link TenantId#TenantId(UUID)} with id is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#checkTenantInfoId(TenantId, Operation)}
   */
  @Test
  @DisplayName("Test checkTenantInfoId(TenantId, Operation); when TenantId(UUID) with id is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.TenantInfo BaseController.checkTenantInfoId(TenantId, Operation)"
  })
  void testCheckTenantInfoId_whenTenantIdWithIdIsNull() throws ThingsboardException {
    // Arrange
    AuditLogController auditLogController = new AuditLogController();

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> auditLogController.checkTenantInfoId(new TenantId(null), Operation.ALL));
  }

  /**
   * Test {@link BaseController#checkTenantProfileId(TenantProfileId, Operation)}.
   *
   * <p>Method under test: {@link BaseController#checkTenantProfileId(TenantProfileId, Operation)}
   */
  @Test
  @DisplayName("Test checkTenantProfileId(TenantProfileId, Operation)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.TenantProfile BaseController.checkTenantProfileId(TenantProfileId, Operation)"
  })
  void testCheckTenantProfileId() throws ThingsboardException {
    // Arrange
    AuditLogController auditLogController = new AuditLogController();

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            auditLogController.checkTenantProfileId(
                new TenantProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
                Operation.ALL));
  }

  /**
   * Test {@link BaseController#checkTenantProfileId(TenantProfileId, Operation)}.
   *
   * <p>Method under test: {@link BaseController#checkTenantProfileId(TenantProfileId, Operation)}
   */
  @Test
  @DisplayName("Test checkTenantProfileId(TenantProfileId, Operation)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.TenantProfile BaseController.checkTenantProfileId(TenantProfileId, Operation)"
  })
  void testCheckTenantProfileId2() throws ThingsboardException {
    // Arrange
    AuditLogController auditLogController = new AuditLogController();
    TenantProfileId tenantProfileId = mock(TenantProfileId.class);
    when(tenantProfileId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> auditLogController.checkTenantProfileId(tenantProfileId, Operation.ALL));
    verify(tenantProfileId).getId();
  }

  /**
   * Test {@link BaseController#checkTenantProfileId(TenantProfileId, Operation)}.
   *
   * <p>Method under test: {@link BaseController#checkTenantProfileId(TenantProfileId, Operation)}
   */
  @Test
  @DisplayName("Test checkTenantProfileId(TenantProfileId, Operation)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.TenantProfile BaseController.checkTenantProfileId(TenantProfileId, Operation)"
  })
  void testCheckTenantProfileId3() throws ThingsboardException {
    // Arrange
    AuditLogController auditLogController = new AuditLogController();
    TenantProfileId tenantProfileId = mock(TenantProfileId.class);
    when(tenantProfileId.getId()).thenThrow(new EmptyResultDataAccessException(3));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> auditLogController.checkTenantProfileId(tenantProfileId, Operation.ALL));
    verify(tenantProfileId).getId();
  }

  /**
   * Test {@link BaseController#checkTenantProfileId(TenantProfileId, Operation)}.
   *
   * <p>Method under test: {@link BaseController#checkTenantProfileId(TenantProfileId, Operation)}
   */
  @Test
  @DisplayName("Test checkTenantProfileId(TenantProfileId, Operation)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.TenantProfile BaseController.checkTenantProfileId(TenantProfileId, Operation)"
  })
  void testCheckTenantProfileId4() throws ThingsboardException {
    // Arrange
    AuditLogController auditLogController = new AuditLogController();
    TenantProfileId tenantProfileId = mock(TenantProfileId.class);
    when(tenantProfileId.getId())
        .thenThrow(
            new ConstraintViolationException(
                "An error occurred", new SQLException(), "Constraint Name"));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> auditLogController.checkTenantProfileId(tenantProfileId, Operation.ALL));
    verify(tenantProfileId).getId();
  }

  /**
   * Test {@link BaseController#checkTenantProfileId(TenantProfileId, Operation)}.
   *
   * <p>Method under test: {@link BaseController#checkTenantProfileId(TenantProfileId, Operation)}
   */
  @Test
  @DisplayName("Test checkTenantProfileId(TenantProfileId, Operation)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.TenantProfile BaseController.checkTenantProfileId(TenantProfileId, Operation)"
  })
  void testCheckTenantProfileId5() throws ThingsboardException {
    // Arrange
    AuditLogController auditLogController = new AuditLogController();
    TenantProfileId tenantProfileId = mock(TenantProfileId.class);
    when(tenantProfileId.getId())
        .thenThrow(new EntityVersionMismatchException("0123456789ABCDEF", new Throwable()));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> auditLogController.checkTenantProfileId(tenantProfileId, Operation.ALL));
    verify(tenantProfileId).getId();
  }

  /**
   * Test {@link BaseController#checkTenantProfileId(TenantProfileId, Operation)}.
   *
   * <ul>
   *   <li>Given {@link AsyncRequestTimeoutException} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link BaseController#checkTenantProfileId(TenantProfileId, Operation)}
   */
  @Test
  @DisplayName(
      "Test checkTenantProfileId(TenantProfileId, Operation); given AsyncRequestTimeoutException (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.TenantProfile BaseController.checkTenantProfileId(TenantProfileId, Operation)"
  })
  void testCheckTenantProfileId_givenAsyncRequestTimeoutException() throws ThingsboardException {
    // Arrange
    AuditLogController auditLogController = new AuditLogController();
    TenantProfileId tenantProfileId = mock(TenantProfileId.class);
    when(tenantProfileId.getId()).thenThrow(new AsyncRequestTimeoutException());

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> auditLogController.checkTenantProfileId(tenantProfileId, Operation.ALL));
    verify(tenantProfileId).getId();
  }

  /**
   * Test {@link BaseController#checkTenantProfileId(TenantProfileId, Operation)}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException(String)} with {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#checkTenantProfileId(TenantProfileId, Operation)}
   */
  @Test
  @DisplayName(
      "Test checkTenantProfileId(TenantProfileId, Operation); given IllegalArgumentException(String) with 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.TenantProfile BaseController.checkTenantProfileId(TenantProfileId, Operation)"
  })
  void testCheckTenantProfileId_givenIllegalArgumentExceptionWithFoo() throws ThingsboardException {
    // Arrange
    AuditLogController auditLogController = new AuditLogController();
    TenantProfileId tenantProfileId = mock(TenantProfileId.class);
    when(tenantProfileId.getId()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> auditLogController.checkTenantProfileId(tenantProfileId, Operation.ALL));
    verify(tenantProfileId).getId();
  }

  /**
   * Test {@link BaseController#checkTenantProfileId(TenantProfileId, Operation)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#checkTenantProfileId(TenantProfileId, Operation)}
   */
  @Test
  @DisplayName(
      "Test checkTenantProfileId(TenantProfileId, Operation); when 'null'; then throw ThingsboardException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.TenantProfile BaseController.checkTenantProfileId(TenantProfileId, Operation)"
  })
  void testCheckTenantProfileId_whenNull_thenThrowThingsboardException()
      throws ThingsboardException {
    // Arrange, Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> new AuditLogController().checkTenantProfileId(null, Operation.ALL));
  }

  /**
   * Test {@link BaseController#checkTenantProfileId(TenantProfileId, Operation)}.
   *
   * <ul>
   *   <li>When {@link TenantProfileId#TenantProfileId(UUID)} with id is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#checkTenantProfileId(TenantProfileId, Operation)}
   */
  @Test
  @DisplayName(
      "Test checkTenantProfileId(TenantProfileId, Operation); when TenantProfileId(UUID) with id is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.TenantProfile BaseController.checkTenantProfileId(TenantProfileId, Operation)"
  })
  void testCheckTenantProfileId_whenTenantProfileIdWithIdIsNull() throws ThingsboardException {
    // Arrange
    AuditLogController auditLogController = new AuditLogController();

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> auditLogController.checkTenantProfileId(new TenantProfileId(null), Operation.ALL));
  }

  /**
   * Test {@link BaseController#getTenantId()}.
   *
   * <p>Method under test: {@link BaseController#getTenantId()}
   */
  @Test
  @DisplayName("Test getTenantId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TenantId BaseController.getTenantId()"})
  void testGetTenantId() throws ThingsboardException {
    // Arrange, Act and Assert
    assertThrows(ThingsboardException.class, () -> new AuditLogController().getTenantId());
  }

  /**
   * Test {@link BaseController#checkEntity(EntityId, HasTenantId, Resource)} with {@code entityId},
   * {@code entity}, {@code resource}.
   *
   * <p>Method under test: {@link BaseController#checkEntity(EntityId, HasTenantId, Resource)}
   */
  @Test
  @DisplayName(
      "Test checkEntity(EntityId, HasTenantId, Resource) with 'entityId', 'entity', 'resource'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseController.checkEntity(EntityId, HasTenantId, Resource)"})
  void testCheckEntityWithEntityIdEntityResource() throws ThingsboardException {
    // Arrange
    AuditLogController auditLogController = new AuditLogController();
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getId()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            auditLogController.checkEntity(
                alarmId, mock(HasTenantId.class), Resource.ADMIN_SETTINGS));
    verify(alarmId).getId();
  }

  /**
   * Test {@link BaseController#checkEntity(EntityId, HasTenantId, Resource)} with {@code entityId},
   * {@code entity}, {@code resource}.
   *
   * <p>Method under test: {@link BaseController#checkEntity(EntityId, HasTenantId, Resource)}
   */
  @Test
  @DisplayName(
      "Test checkEntity(EntityId, HasTenantId, Resource) with 'entityId', 'entity', 'resource'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseController.checkEntity(EntityId, HasTenantId, Resource)"})
  void testCheckEntityWithEntityIdEntityResource2() throws ThingsboardException {
    // Arrange
    AuditLogController auditLogController = new AuditLogController();
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            auditLogController.checkEntity(
                alarmId, mock(HasTenantId.class), Resource.ADMIN_SETTINGS));
    verify(alarmId).getId();
  }

  /**
   * Test {@link BaseController#checkEntity(EntityId, HasTenantId, Resource)} with {@code entityId},
   * {@code entity}, {@code resource}.
   *
   * <p>Method under test: {@link BaseController#checkEntity(EntityId, HasTenantId, Resource)}
   */
  @Test
  @DisplayName(
      "Test checkEntity(EntityId, HasTenantId, Resource) with 'entityId', 'entity', 'resource'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseController.checkEntity(EntityId, HasTenantId, Resource)"})
  void testCheckEntityWithEntityIdEntityResource3() throws ThingsboardException {
    // Arrange
    AuditLogController auditLogController = new AuditLogController();
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getId()).thenThrow(new EmptyResultDataAccessException(3));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            auditLogController.checkEntity(
                alarmId, mock(HasTenantId.class), Resource.ADMIN_SETTINGS));
    verify(alarmId).getId();
  }

  /**
   * Test {@link BaseController#checkEntity(EntityId, HasTenantId, Resource)} with {@code entityId},
   * {@code entity}, {@code resource}.
   *
   * <p>Method under test: {@link BaseController#checkEntity(EntityId, HasTenantId, Resource)}
   */
  @Test
  @DisplayName(
      "Test checkEntity(EntityId, HasTenantId, Resource) with 'entityId', 'entity', 'resource'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseController.checkEntity(EntityId, HasTenantId, Resource)"})
  void testCheckEntityWithEntityIdEntityResource4() throws ThingsboardException {
    // Arrange
    AuditLogController auditLogController = new AuditLogController();
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getId())
        .thenThrow(new EntityVersionMismatchException("0123456789ABCDEF", new Throwable()));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            auditLogController.checkEntity(
                alarmId, mock(HasTenantId.class), Resource.ADMIN_SETTINGS));
    verify(alarmId).getId();
  }

  /**
   * Test {@link BaseController#checkEntity(EntityId, HasTenantId, Resource)} with {@code entityId},
   * {@code entity}, {@code resource}.
   *
   * <p>Method under test: {@link BaseController#checkEntity(EntityId, HasTenantId, Resource)}
   */
  @Test
  @DisplayName(
      "Test checkEntity(EntityId, HasTenantId, Resource) with 'entityId', 'entity', 'resource'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseController.checkEntity(EntityId, HasTenantId, Resource)"})
  void testCheckEntityWithEntityIdEntityResource5() throws ThingsboardException {
    // Arrange
    AuditLogController auditLogController = new AuditLogController();
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getEntityType()).thenThrow(new IllegalArgumentException("foo"));
    when(alarmId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            auditLogController.checkEntity(
                alarmId, mock(HasTenantId.class), Resource.ADMIN_SETTINGS));
    verify(alarmId).getEntityType();
    verify(alarmId).getId();
  }

  /**
   * Test {@link BaseController#checkEntity(EntityId, HasTenantId, Resource)} with {@code entityId},
   * {@code entity}, {@code resource}.
   *
   * <ul>
   *   <li>Given {@code ALARM}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#checkEntity(EntityId, HasTenantId, Resource)}
   */
  @Test
  @DisplayName(
      "Test checkEntity(EntityId, HasTenantId, Resource) with 'entityId', 'entity', 'resource'; given 'ALARM'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseController.checkEntity(EntityId, HasTenantId, Resource)"})
  void testCheckEntityWithEntityIdEntityResource_givenAlarm() throws ThingsboardException {
    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getEntityType()).thenReturn(EntityType.ALARM);
    when(alarmId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            auditLogController.checkEntity(
                alarmId, mock(HasTenantId.class), Resource.ADMIN_SETTINGS));
    verify(alarmId).getEntityType();
    verify(alarmId, atLeast(1)).getId();
  }

  /**
   * Test {@link BaseController#checkEntity(EntityId, HasTenantId, Resource)} with {@code entityId},
   * {@code entity}, {@code resource}.
   *
   * <ul>
   *   <li>Given {@code ASSET}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#checkEntity(EntityId, HasTenantId, Resource)}
   */
  @Test
  @DisplayName(
      "Test checkEntity(EntityId, HasTenantId, Resource) with 'entityId', 'entity', 'resource'; given 'ASSET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseController.checkEntity(EntityId, HasTenantId, Resource)"})
  void testCheckEntityWithEntityIdEntityResource_givenAsset() throws ThingsboardException {
    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getEntityType()).thenReturn(EntityType.ASSET);
    when(alarmId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            auditLogController.checkEntity(
                alarmId, mock(HasTenantId.class), Resource.ADMIN_SETTINGS));
    verify(alarmId).getEntityType();
    verify(alarmId, atLeast(1)).getId();
  }

  /**
   * Test {@link BaseController#checkEntity(EntityId, HasTenantId, Resource)} with {@code entityId},
   * {@code entity}, {@code resource}.
   *
   * <ul>
   *   <li>Given {@link AsyncRequestTimeoutException} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link BaseController#checkEntity(EntityId, HasTenantId, Resource)}
   */
  @Test
  @DisplayName(
      "Test checkEntity(EntityId, HasTenantId, Resource) with 'entityId', 'entity', 'resource'; given AsyncRequestTimeoutException (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseController.checkEntity(EntityId, HasTenantId, Resource)"})
  void testCheckEntityWithEntityIdEntityResource_givenAsyncRequestTimeoutException()
      throws ThingsboardException {
    // Arrange
    AuditLogController auditLogController = new AuditLogController();
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getId()).thenThrow(new AsyncRequestTimeoutException());

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            auditLogController.checkEntity(
                alarmId, mock(HasTenantId.class), Resource.ADMIN_SETTINGS));
    verify(alarmId).getId();
  }

  /**
   * Test {@link BaseController#checkEntity(EntityId, HasTenantId, Resource)} with {@code entityId},
   * {@code entity}, {@code resource}.
   *
   * <ul>
   *   <li>Given {@code CUSTOMER}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#checkEntity(EntityId, HasTenantId, Resource)}
   */
  @Test
  @DisplayName(
      "Test checkEntity(EntityId, HasTenantId, Resource) with 'entityId', 'entity', 'resource'; given 'CUSTOMER'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseController.checkEntity(EntityId, HasTenantId, Resource)"})
  void testCheckEntityWithEntityIdEntityResource_givenCustomer() throws ThingsboardException {
    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getEntityType()).thenReturn(EntityType.CUSTOMER);
    when(alarmId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            auditLogController.checkEntity(
                alarmId, mock(HasTenantId.class), Resource.ADMIN_SETTINGS));
    verify(alarmId).getEntityType();
    verify(alarmId, atLeast(1)).getId();
  }

  /**
   * Test {@link BaseController#checkEntity(EntityId, HasTenantId, Resource)} with {@code entityId},
   * {@code entity}, {@code resource}.
   *
   * <ul>
   *   <li>Given {@code DASHBOARD}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#checkEntity(EntityId, HasTenantId, Resource)}
   */
  @Test
  @DisplayName(
      "Test checkEntity(EntityId, HasTenantId, Resource) with 'entityId', 'entity', 'resource'; given 'DASHBOARD'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseController.checkEntity(EntityId, HasTenantId, Resource)"})
  void testCheckEntityWithEntityIdEntityResource_givenDashboard() throws ThingsboardException {
    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getEntityType()).thenReturn(EntityType.DASHBOARD);
    when(alarmId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            auditLogController.checkEntity(
                alarmId, mock(HasTenantId.class), Resource.ADMIN_SETTINGS));
    verify(alarmId).getEntityType();
    verify(alarmId, atLeast(1)).getId();
  }

  /**
   * Test {@link BaseController#checkEntity(EntityId, HasTenantId, Resource)} with {@code entityId},
   * {@code entity}, {@code resource}.
   *
   * <ul>
   *   <li>Given {@code DEVICE}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#checkEntity(EntityId, HasTenantId, Resource)}
   */
  @Test
  @DisplayName(
      "Test checkEntity(EntityId, HasTenantId, Resource) with 'entityId', 'entity', 'resource'; given 'DEVICE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseController.checkEntity(EntityId, HasTenantId, Resource)"})
  void testCheckEntityWithEntityIdEntityResource_givenDevice() throws ThingsboardException {
    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getEntityType()).thenReturn(EntityType.DEVICE);
    when(alarmId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            auditLogController.checkEntity(
                alarmId, mock(HasTenantId.class), Resource.ADMIN_SETTINGS));
    verify(alarmId).getEntityType();
    verify(alarmId, atLeast(1)).getId();
  }

  /**
   * Test {@link BaseController#checkEntity(EntityId, HasTenantId, Resource)} with {@code entityId},
   * {@code entity}, {@code resource}.
   *
   * <ul>
   *   <li>Given {@code DEVICE_PROFILE}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#checkEntity(EntityId, HasTenantId, Resource)}
   */
  @Test
  @DisplayName(
      "Test checkEntity(EntityId, HasTenantId, Resource) with 'entityId', 'entity', 'resource'; given 'DEVICE_PROFILE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseController.checkEntity(EntityId, HasTenantId, Resource)"})
  void testCheckEntityWithEntityIdEntityResource_givenDeviceProfile() throws ThingsboardException {
    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getEntityType()).thenReturn(EntityType.DEVICE_PROFILE);
    when(alarmId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            auditLogController.checkEntity(
                alarmId, mock(HasTenantId.class), Resource.ADMIN_SETTINGS));
    verify(alarmId).getEntityType();
    verify(alarmId, atLeast(1)).getId();
  }

  /**
   * Test {@link BaseController#checkEntity(EntityId, HasTenantId, Resource)} with {@code entityId},
   * {@code entity}, {@code resource}.
   *
   * <ul>
   *   <li>Given {@code ENTITY_VIEW}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#checkEntity(EntityId, HasTenantId, Resource)}
   */
  @Test
  @DisplayName(
      "Test checkEntity(EntityId, HasTenantId, Resource) with 'entityId', 'entity', 'resource'; given 'ENTITY_VIEW'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseController.checkEntity(EntityId, HasTenantId, Resource)"})
  void testCheckEntityWithEntityIdEntityResource_givenEntityView() throws ThingsboardException {
    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getEntityType()).thenReturn(EntityType.ENTITY_VIEW);
    when(alarmId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            auditLogController.checkEntity(
                alarmId, mock(HasTenantId.class), Resource.ADMIN_SETTINGS));
    verify(alarmId).getEntityType();
    verify(alarmId, atLeast(1)).getId();
  }

  /**
   * Test {@link BaseController#checkEntity(EntityId, HasTenantId, Resource)} with {@code entityId},
   * {@code entity}, {@code resource}.
   *
   * <ul>
   *   <li>Given randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#checkEntity(EntityId, HasTenantId, Resource)}
   */
  @Test
  @DisplayName(
      "Test checkEntity(EntityId, HasTenantId, Resource) with 'entityId', 'entity', 'resource'; given randomUUID")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseController.checkEntity(EntityId, HasTenantId, Resource)"})
  void testCheckEntityWithEntityIdEntityResource_givenRandomUUID() throws ThingsboardException {
    // Arrange
    AuditLogController auditLogController = new AuditLogController();
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getEntityType()).thenReturn(EntityType.TENANT);
    when(alarmId.getId()).thenReturn(UUID.randomUUID());

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            auditLogController.checkEntity(
                alarmId, mock(HasTenantId.class), Resource.ADMIN_SETTINGS));
    verify(alarmId).getEntityType();
    verify(alarmId, atLeast(1)).getId();
  }

  /**
   * Test {@link BaseController#checkEntity(EntityId, HasTenantId, Resource)} with {@code entityId},
   * {@code entity}, {@code resource}.
   *
   * <ul>
   *   <li>Given {@code RULE_CHAIN}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#checkEntity(EntityId, HasTenantId, Resource)}
   */
  @Test
  @DisplayName(
      "Test checkEntity(EntityId, HasTenantId, Resource) with 'entityId', 'entity', 'resource'; given 'RULE_CHAIN'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseController.checkEntity(EntityId, HasTenantId, Resource)"})
  void testCheckEntityWithEntityIdEntityResource_givenRuleChain() throws ThingsboardException {
    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getEntityType()).thenReturn(EntityType.RULE_CHAIN);
    when(alarmId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            auditLogController.checkEntity(
                alarmId, mock(HasTenantId.class), Resource.ADMIN_SETTINGS));
    verify(alarmId).getEntityType();
    verify(alarmId, atLeast(1)).getId();
  }

  /**
   * Test {@link BaseController#checkEntity(EntityId, HasTenantId, Resource)} with {@code entityId},
   * {@code entity}, {@code resource}.
   *
   * <ul>
   *   <li>Given {@code RULE_NODE}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#checkEntity(EntityId, HasTenantId, Resource)}
   */
  @Test
  @DisplayName(
      "Test checkEntity(EntityId, HasTenantId, Resource) with 'entityId', 'entity', 'resource'; given 'RULE_NODE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseController.checkEntity(EntityId, HasTenantId, Resource)"})
  void testCheckEntityWithEntityIdEntityResource_givenRuleNode() throws ThingsboardException {
    // Arrange
    AuditLogController auditLogController = new AuditLogController();
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getEntityType()).thenReturn(EntityType.RULE_NODE);
    when(alarmId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            auditLogController.checkEntity(
                alarmId, mock(HasTenantId.class), Resource.ADMIN_SETTINGS));
    verify(alarmId).getEntityType();
    verify(alarmId, atLeast(1)).getId();
  }

  /**
   * Test {@link BaseController#checkEntity(EntityId, HasTenantId, Resource)} with {@code entityId},
   * {@code entity}, {@code resource}.
   *
   * <ul>
   *   <li>Given {@code TENANT}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#checkEntity(EntityId, HasTenantId, Resource)}
   */
  @Test
  @DisplayName(
      "Test checkEntity(EntityId, HasTenantId, Resource) with 'entityId', 'entity', 'resource'; given 'TENANT'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseController.checkEntity(EntityId, HasTenantId, Resource)"})
  void testCheckEntityWithEntityIdEntityResource_givenTenant() throws ThingsboardException {
    // Arrange
    AuditLogController auditLogController = new AuditLogController();
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getEntityType()).thenReturn(EntityType.TENANT);
    when(alarmId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            auditLogController.checkEntity(
                alarmId, mock(HasTenantId.class), Resource.ADMIN_SETTINGS));
    verify(alarmId).getEntityType();
    verify(alarmId, atLeast(1)).getId();
  }

  /**
   * Test {@link BaseController#checkEntity(EntityId, HasTenantId, Resource)} with {@code entityId},
   * {@code entity}, {@code resource}.
   *
   * <ul>
   *   <li>Given {@code TENANT}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#checkEntity(EntityId, HasTenantId, Resource)}
   */
  @Test
  @DisplayName(
      "Test checkEntity(EntityId, HasTenantId, Resource) with 'entityId', 'entity', 'resource'; given 'TENANT'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseController.checkEntity(EntityId, HasTenantId, Resource)"})
  void testCheckEntityWithEntityIdEntityResource_givenTenant2() throws ThingsboardException {
    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getEntityType()).thenReturn(EntityType.TENANT);
    when(alarmId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            auditLogController.checkEntity(
                alarmId, mock(HasTenantId.class), Resource.ADMIN_SETTINGS));
    verify(alarmId).getEntityType();
    verify(alarmId, atLeast(1)).getId();
  }

  /**
   * Test {@link BaseController#checkEntity(EntityId, HasTenantId, Resource)} with {@code entityId},
   * {@code entity}, {@code resource}.
   *
   * <ul>
   *   <li>Given {@code TENANT_PROFILE}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#checkEntity(EntityId, HasTenantId, Resource)}
   */
  @Test
  @DisplayName(
      "Test checkEntity(EntityId, HasTenantId, Resource) with 'entityId', 'entity', 'resource'; given 'TENANT_PROFILE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseController.checkEntity(EntityId, HasTenantId, Resource)"})
  void testCheckEntityWithEntityIdEntityResource_givenTenantProfile() throws ThingsboardException {
    // Arrange
    AuditLogController auditLogController = new AuditLogController();
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getEntityType()).thenReturn(EntityType.TENANT_PROFILE);
    when(alarmId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            auditLogController.checkEntity(
                alarmId, mock(HasTenantId.class), Resource.ADMIN_SETTINGS));
    verify(alarmId).getEntityType();
    verify(alarmId, atLeast(1)).getId();
  }

  /**
   * Test {@link BaseController#checkEntity(EntityId, HasTenantId, Resource)} with {@code entityId},
   * {@code entity}, {@code resource}.
   *
   * <ul>
   *   <li>Given {@code USER}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#checkEntity(EntityId, HasTenantId, Resource)}
   */
  @Test
  @DisplayName(
      "Test checkEntity(EntityId, HasTenantId, Resource) with 'entityId', 'entity', 'resource'; given 'USER'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseController.checkEntity(EntityId, HasTenantId, Resource)"})
  void testCheckEntityWithEntityIdEntityResource_givenUser() throws ThingsboardException {
    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getEntityType()).thenReturn(EntityType.USER);
    when(alarmId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            auditLogController.checkEntity(
                alarmId, mock(HasTenantId.class), Resource.ADMIN_SETTINGS));
    verify(alarmId).getEntityType();
    verify(alarmId, atLeast(1)).getId();
  }

  /**
   * Test {@link BaseController#checkEntity(EntityId, HasTenantId, Resource)} with {@code entityId},
   * {@code entity}, {@code resource}.
   *
   * <ul>
   *   <li>Given {@code WIDGET_TYPE}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#checkEntity(EntityId, HasTenantId, Resource)}
   */
  @Test
  @DisplayName(
      "Test checkEntity(EntityId, HasTenantId, Resource) with 'entityId', 'entity', 'resource'; given 'WIDGET_TYPE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseController.checkEntity(EntityId, HasTenantId, Resource)"})
  void testCheckEntityWithEntityIdEntityResource_givenWidgetType() throws ThingsboardException {
    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getEntityType()).thenReturn(EntityType.WIDGET_TYPE);
    when(alarmId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            auditLogController.checkEntity(
                alarmId, mock(HasTenantId.class), Resource.ADMIN_SETTINGS));
    verify(alarmId).getEntityType();
    verify(alarmId, atLeast(1)).getId();
  }

  /**
   * Test {@link BaseController#checkEntity(EntityId, HasTenantId, Resource)} with {@code entityId},
   * {@code entity}, {@code resource}.
   *
   * <ul>
   *   <li>Given {@code WIDGETS_BUNDLE}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#checkEntity(EntityId, HasTenantId, Resource)}
   */
  @Test
  @DisplayName(
      "Test checkEntity(EntityId, HasTenantId, Resource) with 'entityId', 'entity', 'resource'; given 'WIDGETS_BUNDLE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseController.checkEntity(EntityId, HasTenantId, Resource)"})
  void testCheckEntityWithEntityIdEntityResource_givenWidgetsBundle() throws ThingsboardException {
    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getEntityType()).thenReturn(EntityType.WIDGETS_BUNDLE);
    when(alarmId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            auditLogController.checkEntity(
                alarmId, mock(HasTenantId.class), Resource.ADMIN_SETTINGS));
    verify(alarmId).getEntityType();
    verify(alarmId, atLeast(1)).getId();
  }

  /**
   * Test {@link BaseController#checkEntity(EntityId, HasTenantId, Resource)} with {@code entityId},
   * {@code entity}, {@code resource}.
   *
   * <ul>
   *   <li>When {@link AlarmId#AlarmId(UUID)} with id is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#checkEntity(EntityId, HasTenantId, Resource)}
   */
  @Test
  @DisplayName(
      "Test checkEntity(EntityId, HasTenantId, Resource) with 'entityId', 'entity', 'resource'; when AlarmId(UUID) with id is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseController.checkEntity(EntityId, HasTenantId, Resource)"})
  void testCheckEntityWithEntityIdEntityResource_whenAlarmIdWithIdIsNull()
      throws ThingsboardException {
    // Arrange
    AuditLogController auditLogController = new AuditLogController();

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            auditLogController.checkEntity(
                new AlarmId(null), mock(HasTenantId.class), Resource.ADMIN_SETTINGS));
  }

  /**
   * Test {@link BaseController#checkEntity(EntityId, HasTenantId, Resource)} with {@code entityId},
   * {@code entity}, {@code resource}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#checkEntity(EntityId, HasTenantId, Resource)}
   */
  @Test
  @DisplayName(
      "Test checkEntity(EntityId, HasTenantId, Resource) with 'entityId', 'entity', 'resource'; when 'null'; then throw ThingsboardException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseController.checkEntity(EntityId, HasTenantId, Resource)"})
  void testCheckEntityWithEntityIdEntityResource_whenNull_thenThrowThingsboardException()
      throws ThingsboardException {
    // Arrange, Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            new AuditLogController()
                .checkEntity(null, mock(HasTenantId.class), Resource.ADMIN_SETTINGS));
  }

  /**
   * Test {@link BaseController#checkEntityId(EntityId, Operation)} with {@code entityId}, {@code
   * operation}.
   *
   * <p>Method under test: {@link BaseController#checkEntityId(EntityId, Operation)}
   */
  @Test
  @DisplayName("Test checkEntityId(EntityId, Operation) with 'entityId', 'operation'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseController.checkEntityId(EntityId, Operation)"})
  void testCheckEntityIdWithEntityIdOperation() throws ThingsboardException {
    // Arrange
    AuditLogController auditLogController = new AuditLogController();
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> auditLogController.checkEntityId(entityId, Operation.ALL));
    verify(entityId).getId();
  }

  /**
   * Test {@link BaseController#checkEntityId(EntityId, Operation)} with {@code entityId}, {@code
   * operation}.
   *
   * <p>Method under test: {@link BaseController#checkEntityId(EntityId, Operation)}
   */
  @Test
  @DisplayName("Test checkEntityId(EntityId, Operation) with 'entityId', 'operation'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseController.checkEntityId(EntityId, Operation)"})
  void testCheckEntityIdWithEntityIdOperation2() throws ThingsboardException {
    // Arrange
    AuditLogController auditLogController = new AuditLogController();
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> auditLogController.checkEntityId(entityId, Operation.ALL));
    verify(entityId).getId();
  }

  /**
   * Test {@link BaseController#checkEntityId(EntityId, Operation)} with {@code entityId}, {@code
   * operation}.
   *
   * <p>Method under test: {@link BaseController#checkEntityId(EntityId, Operation)}
   */
  @Test
  @DisplayName("Test checkEntityId(EntityId, Operation) with 'entityId', 'operation'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseController.checkEntityId(EntityId, Operation)"})
  void testCheckEntityIdWithEntityIdOperation3() throws ThingsboardException {
    // Arrange
    AuditLogController auditLogController = new AuditLogController();
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenThrow(new EmptyResultDataAccessException(3));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> auditLogController.checkEntityId(entityId, Operation.ALL));
    verify(entityId).getId();
  }

  /**
   * Test {@link BaseController#checkEntityId(EntityId, Operation)} with {@code entityId}, {@code
   * operation}.
   *
   * <p>Method under test: {@link BaseController#checkEntityId(EntityId, Operation)}
   */
  @Test
  @DisplayName("Test checkEntityId(EntityId, Operation) with 'entityId', 'operation'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseController.checkEntityId(EntityId, Operation)"})
  void testCheckEntityIdWithEntityIdOperation4() throws ThingsboardException {
    // Arrange
    AuditLogController auditLogController = new AuditLogController();
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId())
        .thenThrow(new EntityVersionMismatchException("0123456789ABCDEF", new Throwable()));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> auditLogController.checkEntityId(entityId, Operation.ALL));
    verify(entityId).getId();
  }

  /**
   * Test {@link BaseController#checkEntityId(EntityId, Operation)} with {@code entityId}, {@code
   * operation}.
   *
   * <p>Method under test: {@link BaseController#checkEntityId(EntityId, Operation)}
   */
  @Test
  @DisplayName("Test checkEntityId(EntityId, Operation) with 'entityId', 'operation'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseController.checkEntityId(EntityId, Operation)"})
  void testCheckEntityIdWithEntityIdOperation5() throws ThingsboardException {
    // Arrange
    AuditLogController auditLogController = new AuditLogController();
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenThrow(new IllegalArgumentException("foo"));
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> auditLogController.checkEntityId(entityId, Operation.ALL));
    verify(entityId).getEntityType();
    verify(entityId).getId();
  }

  /**
   * Test {@link BaseController#checkEntityId(EntityId, Operation)} with {@code entityId}, {@code
   * operation}.
   *
   * <ul>
   *   <li>Given {@code ALARM}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#checkEntityId(EntityId, Operation)}
   */
  @Test
  @DisplayName(
      "Test checkEntityId(EntityId, Operation) with 'entityId', 'operation'; given 'ALARM'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseController.checkEntityId(EntityId, Operation)"})
  void testCheckEntityIdWithEntityIdOperation_givenAlarm() throws ThingsboardException {
    // Arrange
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.ALARM);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> auditLogController.checkEntityId(entityId, Operation.ALL));
    verify(entityId).getEntityType();
    verify(entityId, atLeast(1)).getId();
  }

  /**
   * Test {@link BaseController#checkEntityId(EntityId, Operation)} with {@code entityId}, {@code
   * operation}.
   *
   * <ul>
   *   <li>Given {@code ASSET}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#checkEntityId(EntityId, Operation)}
   */
  @Test
  @DisplayName(
      "Test checkEntityId(EntityId, Operation) with 'entityId', 'operation'; given 'ASSET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseController.checkEntityId(EntityId, Operation)"})
  void testCheckEntityIdWithEntityIdOperation_givenAsset() throws ThingsboardException {
    // Arrange
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.ASSET);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> auditLogController.checkEntityId(entityId, Operation.ALL));
    verify(entityId).getEntityType();
    verify(entityId, atLeast(1)).getId();
  }

  /**
   * Test {@link BaseController#checkEntityId(EntityId, Operation)} with {@code entityId}, {@code
   * operation}.
   *
   * <ul>
   *   <li>Given {@link AsyncRequestTimeoutException} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link BaseController#checkEntityId(EntityId, Operation)}
   */
  @Test
  @DisplayName(
      "Test checkEntityId(EntityId, Operation) with 'entityId', 'operation'; given AsyncRequestTimeoutException (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseController.checkEntityId(EntityId, Operation)"})
  void testCheckEntityIdWithEntityIdOperation_givenAsyncRequestTimeoutException()
      throws ThingsboardException {
    // Arrange
    AuditLogController auditLogController = new AuditLogController();
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenThrow(new AsyncRequestTimeoutException());

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> auditLogController.checkEntityId(entityId, Operation.ALL));
    verify(entityId).getId();
  }

  /**
   * Test {@link BaseController#checkEntityId(EntityId, Operation)} with {@code entityId}, {@code
   * operation}.
   *
   * <ul>
   *   <li>Given {@code CUSTOMER}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#checkEntityId(EntityId, Operation)}
   */
  @Test
  @DisplayName(
      "Test checkEntityId(EntityId, Operation) with 'entityId', 'operation'; given 'CUSTOMER'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseController.checkEntityId(EntityId, Operation)"})
  void testCheckEntityIdWithEntityIdOperation_givenCustomer() throws ThingsboardException {
    // Arrange
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.CUSTOMER);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> auditLogController.checkEntityId(entityId, Operation.ALL));
    verify(entityId).getEntityType();
    verify(entityId, atLeast(1)).getId();
  }

  /**
   * Test {@link BaseController#checkEntityId(EntityId, Operation)} with {@code entityId}, {@code
   * operation}.
   *
   * <ul>
   *   <li>Given {@code DASHBOARD}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#checkEntityId(EntityId, Operation)}
   */
  @Test
  @DisplayName(
      "Test checkEntityId(EntityId, Operation) with 'entityId', 'operation'; given 'DASHBOARD'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseController.checkEntityId(EntityId, Operation)"})
  void testCheckEntityIdWithEntityIdOperation_givenDashboard() throws ThingsboardException {
    // Arrange
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.DASHBOARD);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> auditLogController.checkEntityId(entityId, Operation.ALL));
    verify(entityId).getEntityType();
    verify(entityId, atLeast(1)).getId();
  }

  /**
   * Test {@link BaseController#checkEntityId(EntityId, Operation)} with {@code entityId}, {@code
   * operation}.
   *
   * <ul>
   *   <li>Given {@code DEVICE}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#checkEntityId(EntityId, Operation)}
   */
  @Test
  @DisplayName(
      "Test checkEntityId(EntityId, Operation) with 'entityId', 'operation'; given 'DEVICE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseController.checkEntityId(EntityId, Operation)"})
  void testCheckEntityIdWithEntityIdOperation_givenDevice() throws ThingsboardException {
    // Arrange
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.DEVICE);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> auditLogController.checkEntityId(entityId, Operation.ALL));
    verify(entityId).getEntityType();
    verify(entityId, atLeast(1)).getId();
  }

  /**
   * Test {@link BaseController#checkEntityId(EntityId, Operation)} with {@code entityId}, {@code
   * operation}.
   *
   * <ul>
   *   <li>Given {@code DEVICE_PROFILE}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#checkEntityId(EntityId, Operation)}
   */
  @Test
  @DisplayName(
      "Test checkEntityId(EntityId, Operation) with 'entityId', 'operation'; given 'DEVICE_PROFILE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseController.checkEntityId(EntityId, Operation)"})
  void testCheckEntityIdWithEntityIdOperation_givenDeviceProfile() throws ThingsboardException {
    // Arrange
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.DEVICE_PROFILE);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> auditLogController.checkEntityId(entityId, Operation.ALL));
    verify(entityId).getEntityType();
    verify(entityId, atLeast(1)).getId();
  }

  /**
   * Test {@link BaseController#checkEntityId(EntityId, Operation)} with {@code entityId}, {@code
   * operation}.
   *
   * <ul>
   *   <li>Given {@code ENTITY_VIEW}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#checkEntityId(EntityId, Operation)}
   */
  @Test
  @DisplayName(
      "Test checkEntityId(EntityId, Operation) with 'entityId', 'operation'; given 'ENTITY_VIEW'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseController.checkEntityId(EntityId, Operation)"})
  void testCheckEntityIdWithEntityIdOperation_givenEntityView() throws ThingsboardException {
    // Arrange
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.ENTITY_VIEW);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> auditLogController.checkEntityId(entityId, Operation.ALL));
    verify(entityId).getEntityType();
    verify(entityId, atLeast(1)).getId();
  }

  /**
   * Test {@link BaseController#checkEntityId(EntityId, Operation)} with {@code entityId}, {@code
   * operation}.
   *
   * <ul>
   *   <li>Given randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#checkEntityId(EntityId, Operation)}
   */
  @Test
  @DisplayName(
      "Test checkEntityId(EntityId, Operation) with 'entityId', 'operation'; given randomUUID")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseController.checkEntityId(EntityId, Operation)"})
  void testCheckEntityIdWithEntityIdOperation_givenRandomUUID() throws ThingsboardException {
    // Arrange
    AuditLogController auditLogController = new AuditLogController();
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(UUID.randomUUID());

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> auditLogController.checkEntityId(entityId, Operation.ALL));
    verify(entityId).getEntityType();
    verify(entityId, atLeast(1)).getId();
  }

  /**
   * Test {@link BaseController#checkEntityId(EntityId, Operation)} with {@code entityId}, {@code
   * operation}.
   *
   * <ul>
   *   <li>Given {@code RULE_CHAIN}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#checkEntityId(EntityId, Operation)}
   */
  @Test
  @DisplayName(
      "Test checkEntityId(EntityId, Operation) with 'entityId', 'operation'; given 'RULE_CHAIN'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseController.checkEntityId(EntityId, Operation)"})
  void testCheckEntityIdWithEntityIdOperation_givenRuleChain() throws ThingsboardException {
    // Arrange
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.RULE_CHAIN);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> auditLogController.checkEntityId(entityId, Operation.ALL));
    verify(entityId).getEntityType();
    verify(entityId, atLeast(1)).getId();
  }

  /**
   * Test {@link BaseController#checkEntityId(EntityId, Operation)} with {@code entityId}, {@code
   * operation}.
   *
   * <ul>
   *   <li>Given {@code RULE_NODE}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#checkEntityId(EntityId, Operation)}
   */
  @Test
  @DisplayName(
      "Test checkEntityId(EntityId, Operation) with 'entityId', 'operation'; given 'RULE_NODE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseController.checkEntityId(EntityId, Operation)"})
  void testCheckEntityIdWithEntityIdOperation_givenRuleNode() throws ThingsboardException {
    // Arrange
    AuditLogController auditLogController = new AuditLogController();
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.RULE_NODE);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> auditLogController.checkEntityId(entityId, Operation.ALL));
    verify(entityId).getEntityType();
    verify(entityId, atLeast(1)).getId();
  }

  /**
   * Test {@link BaseController#checkEntityId(EntityId, Operation)} with {@code entityId}, {@code
   * operation}.
   *
   * <ul>
   *   <li>Given {@code TENANT}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#checkEntityId(EntityId, Operation)}
   */
  @Test
  @DisplayName(
      "Test checkEntityId(EntityId, Operation) with 'entityId', 'operation'; given 'TENANT'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseController.checkEntityId(EntityId, Operation)"})
  void testCheckEntityIdWithEntityIdOperation_givenTenant() throws ThingsboardException {
    // Arrange
    AuditLogController auditLogController = new AuditLogController();
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> auditLogController.checkEntityId(entityId, Operation.ALL));
    verify(entityId).getEntityType();
    verify(entityId, atLeast(1)).getId();
  }

  /**
   * Test {@link BaseController#checkEntityId(EntityId, Operation)} with {@code entityId}, {@code
   * operation}.
   *
   * <ul>
   *   <li>Given {@code TENANT_PROFILE}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#checkEntityId(EntityId, Operation)}
   */
  @Test
  @DisplayName(
      "Test checkEntityId(EntityId, Operation) with 'entityId', 'operation'; given 'TENANT_PROFILE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseController.checkEntityId(EntityId, Operation)"})
  void testCheckEntityIdWithEntityIdOperation_givenTenantProfile() throws ThingsboardException {
    // Arrange
    AuditLogController auditLogController = new AuditLogController();
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT_PROFILE);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> auditLogController.checkEntityId(entityId, Operation.ALL));
    verify(entityId).getEntityType();
    verify(entityId, atLeast(1)).getId();
  }

  /**
   * Test {@link BaseController#checkEntityId(EntityId, Operation)} with {@code entityId}, {@code
   * operation}.
   *
   * <ul>
   *   <li>Given {@code USER}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#checkEntityId(EntityId, Operation)}
   */
  @Test
  @DisplayName("Test checkEntityId(EntityId, Operation) with 'entityId', 'operation'; given 'USER'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseController.checkEntityId(EntityId, Operation)"})
  void testCheckEntityIdWithEntityIdOperation_givenUser() throws ThingsboardException {
    // Arrange
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.USER);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> auditLogController.checkEntityId(entityId, Operation.ALL));
    verify(entityId).getEntityType();
    verify(entityId, atLeast(1)).getId();
  }

  /**
   * Test {@link BaseController#checkEntityId(EntityId, Operation)} with {@code entityId}, {@code
   * operation}.
   *
   * <ul>
   *   <li>Given {@code WIDGET_TYPE}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#checkEntityId(EntityId, Operation)}
   */
  @Test
  @DisplayName(
      "Test checkEntityId(EntityId, Operation) with 'entityId', 'operation'; given 'WIDGET_TYPE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseController.checkEntityId(EntityId, Operation)"})
  void testCheckEntityIdWithEntityIdOperation_givenWidgetType() throws ThingsboardException {
    // Arrange
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.WIDGET_TYPE);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> auditLogController.checkEntityId(entityId, Operation.ALL));
    verify(entityId).getEntityType();
    verify(entityId, atLeast(1)).getId();
  }

  /**
   * Test {@link BaseController#checkEntityId(EntityId, Operation)} with {@code entityId}, {@code
   * operation}.
   *
   * <ul>
   *   <li>Given {@code WIDGETS_BUNDLE}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#checkEntityId(EntityId, Operation)}
   */
  @Test
  @DisplayName(
      "Test checkEntityId(EntityId, Operation) with 'entityId', 'operation'; given 'WIDGETS_BUNDLE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseController.checkEntityId(EntityId, Operation)"})
  void testCheckEntityIdWithEntityIdOperation_givenWidgetsBundle() throws ThingsboardException {
    // Arrange
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.WIDGETS_BUNDLE);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> auditLogController.checkEntityId(entityId, Operation.ALL));
    verify(entityId).getEntityType();
    verify(entityId, atLeast(1)).getId();
  }

  /**
   * Test {@link BaseController#checkEntityId(EntityId, Operation)} with {@code entityId}, {@code
   * operation}.
   *
   * <ul>
   *   <li>When {@link AlarmId#AlarmId(UUID)} with id is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#checkEntityId(EntityId, Operation)}
   */
  @Test
  @DisplayName(
      "Test checkEntityId(EntityId, Operation) with 'entityId', 'operation'; when AlarmId(UUID) with id is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseController.checkEntityId(EntityId, Operation)"})
  void testCheckEntityIdWithEntityIdOperation_whenAlarmIdWithIdIsNull()
      throws ThingsboardException {
    // Arrange
    AuditLogController auditLogController = new AuditLogController();

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> auditLogController.checkEntityId(new AlarmId(null), Operation.ALL));
  }

  /**
   * Test {@link BaseController#checkEntityId(EntityId, Operation)} with {@code entityId}, {@code
   * operation}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#checkEntityId(EntityId, Operation)}
   */
  @Test
  @DisplayName(
      "Test checkEntityId(EntityId, Operation) with 'entityId', 'operation'; when 'null'; then throw ThingsboardException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseController.checkEntityId(EntityId, Operation)"})
  void testCheckEntityIdWithEntityIdOperation_whenNull_thenThrowThingsboardException()
      throws ThingsboardException {
    // Arrange, Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> new AuditLogController().checkEntityId(null, Operation.ALL));
  }

  /**
   * Test {@link BaseController#checkAlarmId(AlarmId, Operation)}.
   *
   * <p>Method under test: {@link BaseController#checkAlarmId(AlarmId, Operation)}
   */
  @Test
  @DisplayName("Test checkAlarmId(AlarmId, Operation)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.alarm.Alarm BaseController.checkAlarmId(AlarmId, Operation)"
  })
  void testCheckAlarmId() throws ThingsboardException {
    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getId())
        .thenThrow(
            new ConstraintViolationException(
                "An error occurred", new SQLException(), "Invalid entity id"));

    // Act and Assert
    assertThrows(
        ThingsboardException.class, () -> auditLogController.checkAlarmId(alarmId, Operation.ALL));
    verify(alarmId).getId();
  }

  /**
   * Test {@link BaseController#checkAlarmId(AlarmId, Operation)}.
   *
   * <p>Method under test: {@link BaseController#checkAlarmId(AlarmId, Operation)}
   */
  @Test
  @DisplayName("Test checkAlarmId(AlarmId, Operation)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.alarm.Alarm BaseController.checkAlarmId(AlarmId, Operation)"
  })
  void testCheckAlarmId2() throws ThingsboardException {
    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getId())
        .thenThrow(new EntityVersionMismatchException("0123456789ABCDEF", new Throwable()));

    // Act and Assert
    assertThrows(
        ThingsboardException.class, () -> auditLogController.checkAlarmId(alarmId, Operation.ALL));
    verify(alarmId).getId();
  }

  /**
   * Test {@link BaseController#checkAlarmId(AlarmId, Operation)}.
   *
   * <ul>
   *   <li>Given {@link AsyncRequestTimeoutException} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link BaseController#checkAlarmId(AlarmId, Operation)}
   */
  @Test
  @DisplayName(
      "Test checkAlarmId(AlarmId, Operation); given AsyncRequestTimeoutException (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.alarm.Alarm BaseController.checkAlarmId(AlarmId, Operation)"
  })
  void testCheckAlarmId_givenAsyncRequestTimeoutException() throws ThingsboardException {
    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getId()).thenThrow(new AsyncRequestTimeoutException());

    // Act and Assert
    assertThrows(
        ThingsboardException.class, () -> auditLogController.checkAlarmId(alarmId, Operation.ALL));
    verify(alarmId).getId();
  }

  /**
   * Test {@link BaseController#checkAlarmId(AlarmId, Operation)}.
   *
   * <ul>
   *   <li>Given {@link AuditLogController}.
   *   <li>When {@code null}.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#checkAlarmId(AlarmId, Operation)}
   */
  @Test
  @DisplayName(
      "Test checkAlarmId(AlarmId, Operation); given AuditLogController; when 'null'; then throw ThingsboardException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.alarm.Alarm BaseController.checkAlarmId(AlarmId, Operation)"
  })
  void testCheckAlarmId_givenAuditLogController_whenNull_thenThrowThingsboardException()
      throws ThingsboardException {
    // Arrange, Act and Assert
    assertThrows(
        ThingsboardException.class, () -> auditLogController.checkAlarmId(null, Operation.ALL));
  }

  /**
   * Test {@link BaseController#checkAlarmId(AlarmId, Operation)}.
   *
   * <ul>
   *   <li>Given {@link DataValidationException#DataValidationException(String)} with message is
   *       {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#checkAlarmId(AlarmId, Operation)}
   */
  @Test
  @DisplayName(
      "Test checkAlarmId(AlarmId, Operation); given DataValidationException(String) with message is 'An error occurred'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.alarm.Alarm BaseController.checkAlarmId(AlarmId, Operation)"
  })
  void testCheckAlarmId_givenDataValidationExceptionWithMessageIsAnErrorOccurred()
      throws ThingsboardException {
    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        ThingsboardException.class, () -> auditLogController.checkAlarmId(alarmId, Operation.ALL));
    verify(alarmId).getId();
  }

  /**
   * Test {@link BaseController#checkAlarmId(AlarmId, Operation)}.
   *
   * <ul>
   *   <li>Given {@link EmptyResultDataAccessException#EmptyResultDataAccessException(int)} with
   *       expectedSize is three.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#checkAlarmId(AlarmId, Operation)}
   */
  @Test
  @DisplayName(
      "Test checkAlarmId(AlarmId, Operation); given EmptyResultDataAccessException(int) with expectedSize is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.alarm.Alarm BaseController.checkAlarmId(AlarmId, Operation)"
  })
  void testCheckAlarmId_givenEmptyResultDataAccessExceptionWithExpectedSizeIsThree()
      throws ThingsboardException {
    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getId()).thenThrow(new EmptyResultDataAccessException(3));

    // Act and Assert
    assertThrows(
        ThingsboardException.class, () -> auditLogController.checkAlarmId(alarmId, Operation.ALL));
    verify(alarmId).getId();
  }

  /**
   * Test {@link BaseController#checkAlarmId(AlarmId, Operation)}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException(String)} with {@code
   *       Invalid entity id}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#checkAlarmId(AlarmId, Operation)}
   */
  @Test
  @DisplayName(
      "Test checkAlarmId(AlarmId, Operation); given IllegalArgumentException(String) with 'Invalid entity id'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.alarm.Alarm BaseController.checkAlarmId(AlarmId, Operation)"
  })
  void testCheckAlarmId_givenIllegalArgumentExceptionWithInvalidEntityId()
      throws ThingsboardException {
    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getId()).thenThrow(new IllegalArgumentException("Invalid entity id"));

    // Act and Assert
    assertThrows(
        ThingsboardException.class, () -> auditLogController.checkAlarmId(alarmId, Operation.ALL));
    verify(alarmId).getId();
  }

  /**
   * Test {@link BaseController#checkAlarmId(AlarmId, Operation)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link AlarmId} {@link AlarmId#getId()} return {@code null}.
   *   <li>Then calls {@link AlarmId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#checkAlarmId(AlarmId, Operation)}
   */
  @Test
  @DisplayName(
      "Test checkAlarmId(AlarmId, Operation); given 'null'; when AlarmId getId() return 'null'; then calls getId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.alarm.Alarm BaseController.checkAlarmId(AlarmId, Operation)"
  })
  void testCheckAlarmId_givenNull_whenAlarmIdGetIdReturnNull_thenCallsGetId()
      throws ThingsboardException {
    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getId()).thenReturn(null);

    // Act and Assert
    assertThrows(
        ThingsboardException.class, () -> auditLogController.checkAlarmId(alarmId, Operation.ALL));
    verify(alarmId).getId();
  }

  /**
   * Test {@link BaseController#checkAlarmId(AlarmId, Operation)}.
   *
   * <ul>
   *   <li>When {@link AlarmId#AlarmId(UUID)} with id is fromString {@code
   *       784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#checkAlarmId(AlarmId, Operation)}
   */
  @Test
  @DisplayName(
      "Test checkAlarmId(AlarmId, Operation); when AlarmId(UUID) with id is fromString '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.alarm.Alarm BaseController.checkAlarmId(AlarmId, Operation)"
  })
  void testCheckAlarmId_whenAlarmIdWithIdIsFromString784f394c42b6435a983cB7beff2784f9()
      throws ThingsboardException {
    // Arrange, Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            auditLogController.checkAlarmId(
                new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
                Operation.ALL));
  }

  /**
   * Test {@link BaseController#checkAlarmInfoId(AlarmId, Operation)}.
   *
   * <p>Method under test: {@link BaseController#checkAlarmInfoId(AlarmId, Operation)}
   */
  @Test
  @DisplayName("Test checkAlarmInfoId(AlarmId, Operation)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.alarm.AlarmInfo BaseController.checkAlarmInfoId(AlarmId, Operation)"
  })
  void testCheckAlarmInfoId() throws ThingsboardException {
    // Arrange, Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            auditLogController.checkAlarmInfoId(
                new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
                Operation.ALL));
  }

  /**
   * Test {@link BaseController#checkAlarmInfoId(AlarmId, Operation)}.
   *
   * <p>Method under test: {@link BaseController#checkAlarmInfoId(AlarmId, Operation)}
   */
  @Test
  @DisplayName("Test checkAlarmInfoId(AlarmId, Operation)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.alarm.AlarmInfo BaseController.checkAlarmInfoId(AlarmId, Operation)"
  })
  void testCheckAlarmInfoId2() throws ThingsboardException {
    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getId())
        .thenThrow(
            new ConstraintViolationException(
                "An error occurred", new SQLException(), "Invalid entity id"));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> auditLogController.checkAlarmInfoId(alarmId, Operation.ALL));
    verify(alarmId).getId();
  }

  /**
   * Test {@link BaseController#checkAlarmInfoId(AlarmId, Operation)}.
   *
   * <p>Method under test: {@link BaseController#checkAlarmInfoId(AlarmId, Operation)}
   */
  @Test
  @DisplayName("Test checkAlarmInfoId(AlarmId, Operation)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.alarm.AlarmInfo BaseController.checkAlarmInfoId(AlarmId, Operation)"
  })
  void testCheckAlarmInfoId3() throws ThingsboardException {
    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getId())
        .thenThrow(new EntityVersionMismatchException("0123456789ABCDEF", new Throwable()));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> auditLogController.checkAlarmInfoId(alarmId, Operation.ALL));
    verify(alarmId).getId();
  }

  /**
   * Test {@link BaseController#checkAlarmInfoId(AlarmId, Operation)}.
   *
   * <ul>
   *   <li>Given {@link AsyncRequestTimeoutException} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link BaseController#checkAlarmInfoId(AlarmId, Operation)}
   */
  @Test
  @DisplayName(
      "Test checkAlarmInfoId(AlarmId, Operation); given AsyncRequestTimeoutException (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.alarm.AlarmInfo BaseController.checkAlarmInfoId(AlarmId, Operation)"
  })
  void testCheckAlarmInfoId_givenAsyncRequestTimeoutException() throws ThingsboardException {
    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getId()).thenThrow(new AsyncRequestTimeoutException());

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> auditLogController.checkAlarmInfoId(alarmId, Operation.ALL));
    verify(alarmId).getId();
  }

  /**
   * Test {@link BaseController#checkAlarmInfoId(AlarmId, Operation)}.
   *
   * <ul>
   *   <li>Given {@link DataValidationException#DataValidationException(String)} with message is
   *       {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#checkAlarmInfoId(AlarmId, Operation)}
   */
  @Test
  @DisplayName(
      "Test checkAlarmInfoId(AlarmId, Operation); given DataValidationException(String) with message is 'An error occurred'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.alarm.AlarmInfo BaseController.checkAlarmInfoId(AlarmId, Operation)"
  })
  void testCheckAlarmInfoId_givenDataValidationExceptionWithMessageIsAnErrorOccurred()
      throws ThingsboardException {
    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> auditLogController.checkAlarmInfoId(alarmId, Operation.ALL));
    verify(alarmId).getId();
  }

  /**
   * Test {@link BaseController#checkAlarmInfoId(AlarmId, Operation)}.
   *
   * <ul>
   *   <li>Given {@link EmptyResultDataAccessException#EmptyResultDataAccessException(int)} with
   *       expectedSize is three.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#checkAlarmInfoId(AlarmId, Operation)}
   */
  @Test
  @DisplayName(
      "Test checkAlarmInfoId(AlarmId, Operation); given EmptyResultDataAccessException(int) with expectedSize is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.alarm.AlarmInfo BaseController.checkAlarmInfoId(AlarmId, Operation)"
  })
  void testCheckAlarmInfoId_givenEmptyResultDataAccessExceptionWithExpectedSizeIsThree()
      throws ThingsboardException {
    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getId()).thenThrow(new EmptyResultDataAccessException(3));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> auditLogController.checkAlarmInfoId(alarmId, Operation.ALL));
    verify(alarmId).getId();
  }

  /**
   * Test {@link BaseController#checkAlarmInfoId(AlarmId, Operation)}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException(String)} with {@code
   *       Invalid entity id}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#checkAlarmInfoId(AlarmId, Operation)}
   */
  @Test
  @DisplayName(
      "Test checkAlarmInfoId(AlarmId, Operation); given IllegalArgumentException(String) with 'Invalid entity id'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.alarm.AlarmInfo BaseController.checkAlarmInfoId(AlarmId, Operation)"
  })
  void testCheckAlarmInfoId_givenIllegalArgumentExceptionWithInvalidEntityId()
      throws ThingsboardException {
    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getId()).thenThrow(new IllegalArgumentException("Invalid entity id"));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> auditLogController.checkAlarmInfoId(alarmId, Operation.ALL));
    verify(alarmId).getId();
  }

  /**
   * Test {@link BaseController#checkAlarmInfoId(AlarmId, Operation)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link AlarmId} {@link AlarmId#getId()} return {@code null}.
   *   <li>Then calls {@link AlarmId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#checkAlarmInfoId(AlarmId, Operation)}
   */
  @Test
  @DisplayName(
      "Test checkAlarmInfoId(AlarmId, Operation); given 'null'; when AlarmId getId() return 'null'; then calls getId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.alarm.AlarmInfo BaseController.checkAlarmInfoId(AlarmId, Operation)"
  })
  void testCheckAlarmInfoId_givenNull_whenAlarmIdGetIdReturnNull_thenCallsGetId()
      throws ThingsboardException {
    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getId()).thenReturn(null);

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> auditLogController.checkAlarmInfoId(alarmId, Operation.ALL));
    verify(alarmId).getId();
  }

  /**
   * Test {@link BaseController#checkAlarmInfoId(AlarmId, Operation)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#checkAlarmInfoId(AlarmId, Operation)}
   */
  @Test
  @DisplayName(
      "Test checkAlarmInfoId(AlarmId, Operation); when 'null'; then throw ThingsboardException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.alarm.AlarmInfo BaseController.checkAlarmInfoId(AlarmId, Operation)"
  })
  void testCheckAlarmInfoId_whenNull_thenThrowThingsboardException() throws ThingsboardException {
    // Arrange, Act and Assert
    assertThrows(
        ThingsboardException.class, () -> auditLogController.checkAlarmInfoId(null, Operation.ALL));
  }

  /**
   * Test {@link BaseController#checkAlarmCommentId(AlarmCommentId, AlarmId)}.
   *
   * <p>Method under test: {@link BaseController#checkAlarmCommentId(AlarmCommentId, AlarmId)}
   */
  @Test
  @DisplayName("Test checkAlarmCommentId(AlarmCommentId, AlarmId)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.alarm.AlarmComment BaseController.checkAlarmCommentId(AlarmCommentId, AlarmId)"
  })
  void testCheckAlarmCommentId() throws ThingsboardException {
    // Arrange
    AuditLogController auditLogController = new AuditLogController();

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            auditLogController.checkAlarmCommentId(
                new AlarmCommentId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), null));
  }

  /**
   * Test {@link BaseController#checkAlarmCommentId(AlarmCommentId, AlarmId)}.
   *
   * <p>Method under test: {@link BaseController#checkAlarmCommentId(AlarmCommentId, AlarmId)}
   */
  @Test
  @DisplayName("Test checkAlarmCommentId(AlarmCommentId, AlarmId)")
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.alarm.AlarmComment BaseController.checkAlarmCommentId(AlarmCommentId, AlarmId)"
  })
  void testCheckAlarmCommentId3() throws ThingsboardException {
    // Arrange
    AuditLogController auditLogController = new AuditLogController();
    AlarmCommentId alarmCommentId = mock(AlarmCommentId.class);
    when(alarmCommentId.getId())
        .thenThrow(
            new ConstraintViolationException(
                "An error occurred", new SQLException(), "Constraint Name"));

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.alarm.AlarmComment BaseController.checkAlarmCommentId(AlarmCommentId, AlarmId)"
  })
  void testCheckAlarmCommentId4() throws ThingsboardException {
    // Arrange
    AuditLogController auditLogController = new AuditLogController();
    AlarmCommentId alarmCommentId = mock(AlarmCommentId.class);
    when(alarmCommentId.getId())
        .thenThrow(new EntityVersionMismatchException("0123456789ABCDEF", new Throwable()));

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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException(String)} with {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#checkAlarmCommentId(AlarmCommentId, AlarmId)}
   */
  @Test
  @DisplayName(
      "Test checkAlarmCommentId(AlarmCommentId, AlarmId); given IllegalArgumentException(String) with 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.alarm.AlarmComment BaseController.checkAlarmCommentId(AlarmCommentId, AlarmId)"
  })
  void testCheckAlarmCommentId_givenIllegalArgumentExceptionWithFoo() throws ThingsboardException {
    // Arrange
    AuditLogController auditLogController = new AuditLogController();
    AlarmCommentId alarmCommentId = mock(AlarmCommentId.class);
    when(alarmCommentId.getId()).thenThrow(new IllegalArgumentException("foo"));

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
  @Tag("MaintainedByDiffblue")
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

  /**
   * Test {@link BaseController#checkAlarmCommentId(AlarmCommentId, AlarmId)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#checkAlarmCommentId(AlarmCommentId, AlarmId)}
   */
  @Test
  @DisplayName(
      "Test checkAlarmCommentId(AlarmCommentId, AlarmId); when 'null'; then throw ThingsboardException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.alarm.AlarmComment BaseController.checkAlarmCommentId(AlarmCommentId, AlarmId)"
  })
  void testCheckAlarmCommentId_whenNull_thenThrowThingsboardException()
      throws ThingsboardException {
    // Arrange, Act and Assert
    assertThrows(
        ThingsboardException.class, () -> new AuditLogController().checkAlarmCommentId(null, null));
  }

  /**
   * Test {@link BaseController#checkComponentDescriptorByClazz(String)}.
   *
   * <p>Method under test: {@link BaseController#checkComponentDescriptorByClazz(String)}
   */
  @Test
  @DisplayName("Test checkComponentDescriptorByClazz(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ComponentDescriptor BaseController.checkComponentDescriptorByClazz(String)"})
  void testCheckComponentDescriptorByClazz() throws ThingsboardException {
    // Arrange
    when(componentDiscoveryService.getComponent(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException("[{}] Lookup component descriptor"));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> auditLogController.checkComponentDescriptorByClazz("Clazz"));
    verify(componentDiscoveryService).getComponent(eq("Clazz"));
  }

  /**
   * Test {@link BaseController#checkComponentDescriptorByClazz(String)}.
   *
   * <p>Method under test: {@link BaseController#checkComponentDescriptorByClazz(String)}
   */
  @Test
  @DisplayName("Test checkComponentDescriptorByClazz(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ComponentDescriptor BaseController.checkComponentDescriptorByClazz(String)"})
  void testCheckComponentDescriptorByClazz2() throws ThingsboardException {
    // Arrange
    when(componentDiscoveryService.getComponent(Mockito.<String>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> auditLogController.checkComponentDescriptorByClazz("Clazz"));
    verify(componentDiscoveryService).getComponent(eq("Clazz"));
  }

  /**
   * Test {@link BaseController#checkComponentDescriptorByClazz(String)}.
   *
   * <p>Method under test: {@link BaseController#checkComponentDescriptorByClazz(String)}
   */
  @Test
  @DisplayName("Test checkComponentDescriptorByClazz(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ComponentDescriptor BaseController.checkComponentDescriptorByClazz(String)"})
  void testCheckComponentDescriptorByClazz3() throws ThingsboardException {
    // Arrange
    when(componentDiscoveryService.getComponent(Mockito.<String>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> auditLogController.checkComponentDescriptorByClazz("Clazz"));
    verify(componentDiscoveryService).getComponent(eq("Clazz"));
  }

  /**
   * Test {@link BaseController#checkComponentDescriptorByClazz(String)}.
   *
   * <p>Method under test: {@link BaseController#checkComponentDescriptorByClazz(String)}
   */
  @Test
  @DisplayName("Test checkComponentDescriptorByClazz(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ComponentDescriptor BaseController.checkComponentDescriptorByClazz(String)"})
  void testCheckComponentDescriptorByClazz4() throws ThingsboardException {
    // Arrange
    when(componentDiscoveryService.getComponent(Mockito.<String>any()))
        .thenThrow(new AsyncRequestTimeoutException());

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> auditLogController.checkComponentDescriptorByClazz("Clazz"));
    verify(componentDiscoveryService).getComponent(eq("Clazz"));
  }

  /**
   * Test {@link BaseController#checkComponentDescriptorByClazz(String)}.
   *
   * <p>Method under test: {@link BaseController#checkComponentDescriptorByClazz(String)}
   */
  @Test
  @DisplayName("Test checkComponentDescriptorByClazz(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ComponentDescriptor BaseController.checkComponentDescriptorByClazz(String)"})
  void testCheckComponentDescriptorByClazz5() throws ThingsboardException {
    // Arrange
    when(componentDiscoveryService.getComponent(Mockito.<String>any()))
        .thenThrow(new EmptyResultDataAccessException(3));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> auditLogController.checkComponentDescriptorByClazz("Clazz"));
    verify(componentDiscoveryService).getComponent(eq("Clazz"));
  }

  /**
   * Test {@link BaseController#checkComponentDescriptorByClazz(String)}.
   *
   * <p>Method under test: {@link BaseController#checkComponentDescriptorByClazz(String)}
   */
  @Test
  @DisplayName("Test checkComponentDescriptorByClazz(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ComponentDescriptor BaseController.checkComponentDescriptorByClazz(String)"})
  void testCheckComponentDescriptorByClazz6() throws ThingsboardException {
    // Arrange
    when(componentDiscoveryService.getComponent(Mockito.<String>any()))
        .thenThrow(new EntityVersionMismatchException("0123456789ABCDEF", new Throwable()));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> auditLogController.checkComponentDescriptorByClazz("Clazz"));
    verify(componentDiscoveryService).getComponent(eq("Clazz"));
  }

  /**
   * Test {@link BaseController#checkComponentDescriptorByClazz(String)}.
   *
   * <p>Method under test: {@link BaseController#checkComponentDescriptorByClazz(String)}
   */
  @Test
  @DisplayName("Test checkComponentDescriptorByClazz(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ComponentDescriptor BaseController.checkComponentDescriptorByClazz(String)"})
  void testCheckComponentDescriptorByClazz7() throws ThingsboardException {
    // Arrange
    Optional<ComponentDescriptor> emptyResult = Optional.empty();
    when(componentDiscoveryService.getComponent(Mockito.<String>any())).thenReturn(emptyResult);

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> auditLogController.checkComponentDescriptorByClazz("Clazz"));
    verify(componentDiscoveryService).getComponent(eq("Clazz"));
  }

  /**
   * Test {@link BaseController#checkComponentDescriptorByClazz(String)}.
   *
   * <ul>
   *   <li>Then return {@link ComponentDescriptor#ComponentDescriptor()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#checkComponentDescriptorByClazz(String)}
   */
  @Test
  @DisplayName("Test checkComponentDescriptorByClazz(String); then return ComponentDescriptor()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ComponentDescriptor BaseController.checkComponentDescriptorByClazz(String)"})
  void testCheckComponentDescriptorByClazz_thenReturnComponentDescriptor()
      throws ThingsboardException {
    // Arrange
    ComponentDescriptor componentDescriptor = new ComponentDescriptor();
    Optional<ComponentDescriptor> ofResult = Optional.of(componentDescriptor);
    when(componentDiscoveryService.getComponent(Mockito.<String>any())).thenReturn(ofResult);

    // Act
    ComponentDescriptor actualCheckComponentDescriptorByClazzResult =
        auditLogController.checkComponentDescriptorByClazz("Clazz");

    // Assert
    verify(componentDiscoveryService).getComponent(eq("Clazz"));
    assertSame(componentDescriptor, actualCheckComponentDescriptorByClazzResult);
  }

  /**
   * Test {@link BaseController#checkComponentDescriptorsByType(ComponentType, RuleChainType)}.
   *
   * <p>Method under test: {@link BaseController#checkComponentDescriptorsByType(ComponentType,
   * RuleChainType)}
   */
  @Test
  @DisplayName("Test checkComponentDescriptorsByType(ComponentType, RuleChainType)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "List BaseController.checkComponentDescriptorsByType(ComponentType, RuleChainType)"
  })
  void testCheckComponentDescriptorsByType() throws ThingsboardException {
    // Arrange
    when(componentDiscoveryService.getComponents(
            Mockito.<ComponentType>any(), Mockito.<RuleChainType>any()))
        .thenThrow(new IllegalArgumentException("[{}] Lookup component descriptors"));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            auditLogController.checkComponentDescriptorsByType(
                ComponentType.ENRICHMENT, RuleChainType.CORE));
    verify(componentDiscoveryService)
        .getComponents(eq(ComponentType.ENRICHMENT), eq(RuleChainType.CORE));
  }

  /**
   * Test {@link BaseController#checkComponentDescriptorsByType(ComponentType, RuleChainType)}.
   *
   * <p>Method under test: {@link BaseController#checkComponentDescriptorsByType(ComponentType,
   * RuleChainType)}
   */
  @Test
  @DisplayName("Test checkComponentDescriptorsByType(ComponentType, RuleChainType)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "List BaseController.checkComponentDescriptorsByType(ComponentType, RuleChainType)"
  })
  void testCheckComponentDescriptorsByType2() throws ThingsboardException {
    // Arrange
    when(componentDiscoveryService.getComponents(
            Mockito.<ComponentType>any(), Mockito.<RuleChainType>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            auditLogController.checkComponentDescriptorsByType(
                ComponentType.ENRICHMENT, RuleChainType.CORE));
    verify(componentDiscoveryService)
        .getComponents(eq(ComponentType.ENRICHMENT), eq(RuleChainType.CORE));
  }

  /**
   * Test {@link BaseController#checkComponentDescriptorsByType(ComponentType, RuleChainType)}.
   *
   * <p>Method under test: {@link BaseController#checkComponentDescriptorsByType(ComponentType,
   * RuleChainType)}
   */
  @Test
  @DisplayName("Test checkComponentDescriptorsByType(ComponentType, RuleChainType)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "List BaseController.checkComponentDescriptorsByType(ComponentType, RuleChainType)"
  })
  void testCheckComponentDescriptorsByType3() throws ThingsboardException {
    // Arrange
    when(componentDiscoveryService.getComponents(
            Mockito.<ComponentType>any(), Mockito.<RuleChainType>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            auditLogController.checkComponentDescriptorsByType(
                ComponentType.ENRICHMENT, RuleChainType.CORE));
    verify(componentDiscoveryService)
        .getComponents(eq(ComponentType.ENRICHMENT), eq(RuleChainType.CORE));
  }

  /**
   * Test {@link BaseController#checkComponentDescriptorsByType(ComponentType, RuleChainType)}.
   *
   * <p>Method under test: {@link BaseController#checkComponentDescriptorsByType(ComponentType,
   * RuleChainType)}
   */
  @Test
  @DisplayName("Test checkComponentDescriptorsByType(ComponentType, RuleChainType)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "List BaseController.checkComponentDescriptorsByType(ComponentType, RuleChainType)"
  })
  void testCheckComponentDescriptorsByType4() throws ThingsboardException {
    // Arrange
    when(componentDiscoveryService.getComponents(
            Mockito.<ComponentType>any(), Mockito.<RuleChainType>any()))
        .thenThrow(new AsyncRequestTimeoutException());

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            auditLogController.checkComponentDescriptorsByType(
                ComponentType.ENRICHMENT, RuleChainType.CORE));
    verify(componentDiscoveryService)
        .getComponents(eq(ComponentType.ENRICHMENT), eq(RuleChainType.CORE));
  }

  /**
   * Test {@link BaseController#checkComponentDescriptorsByType(ComponentType, RuleChainType)}.
   *
   * <p>Method under test: {@link BaseController#checkComponentDescriptorsByType(ComponentType,
   * RuleChainType)}
   */
  @Test
  @DisplayName("Test checkComponentDescriptorsByType(ComponentType, RuleChainType)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "List BaseController.checkComponentDescriptorsByType(ComponentType, RuleChainType)"
  })
  void testCheckComponentDescriptorsByType5() throws ThingsboardException {
    // Arrange
    when(componentDiscoveryService.getComponents(
            Mockito.<ComponentType>any(), Mockito.<RuleChainType>any()))
        .thenThrow(new EmptyResultDataAccessException(3));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            auditLogController.checkComponentDescriptorsByType(
                ComponentType.ENRICHMENT, RuleChainType.CORE));
    verify(componentDiscoveryService)
        .getComponents(eq(ComponentType.ENRICHMENT), eq(RuleChainType.CORE));
  }

  /**
   * Test {@link BaseController#checkComponentDescriptorsByType(ComponentType, RuleChainType)}.
   *
   * <p>Method under test: {@link BaseController#checkComponentDescriptorsByType(ComponentType,
   * RuleChainType)}
   */
  @Test
  @DisplayName("Test checkComponentDescriptorsByType(ComponentType, RuleChainType)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "List BaseController.checkComponentDescriptorsByType(ComponentType, RuleChainType)"
  })
  void testCheckComponentDescriptorsByType6() throws ThingsboardException {
    // Arrange
    when(componentDiscoveryService.getComponents(
            Mockito.<ComponentType>any(), Mockito.<RuleChainType>any()))
        .thenThrow(new EntityVersionMismatchException("0123456789ABCDEF", new Throwable()));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            auditLogController.checkComponentDescriptorsByType(
                ComponentType.ENRICHMENT, RuleChainType.CORE));
    verify(componentDiscoveryService)
        .getComponents(eq(ComponentType.ENRICHMENT), eq(RuleChainType.CORE));
  }

  /**
   * Test {@link BaseController#checkComponentDescriptorsByType(ComponentType, RuleChainType)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#checkComponentDescriptorsByType(ComponentType,
   * RuleChainType)}
   */
  @Test
  @DisplayName(
      "Test checkComponentDescriptorsByType(ComponentType, RuleChainType); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "List BaseController.checkComponentDescriptorsByType(ComponentType, RuleChainType)"
  })
  void testCheckComponentDescriptorsByType_thenReturnEmpty() throws ThingsboardException {
    // Arrange
    when(componentDiscoveryService.getComponents(
            Mockito.<ComponentType>any(), Mockito.<RuleChainType>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<ComponentDescriptor> actualCheckComponentDescriptorsByTypeResult =
        auditLogController.checkComponentDescriptorsByType(
            ComponentType.ENRICHMENT, RuleChainType.CORE);

    // Assert
    verify(componentDiscoveryService)
        .getComponents(eq(ComponentType.ENRICHMENT), eq(RuleChainType.CORE));
    assertTrue(actualCheckComponentDescriptorsByTypeResult.isEmpty());
  }

  /**
   * Test {@link BaseController#checkComponentDescriptorsByTypes(Set, RuleChainType)}.
   *
   * <p>Method under test: {@link BaseController#checkComponentDescriptorsByTypes(Set,
   * RuleChainType)}
   */
  @Test
  @DisplayName("Test checkComponentDescriptorsByTypes(Set, RuleChainType)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List BaseController.checkComponentDescriptorsByTypes(Set, RuleChainType)"})
  void testCheckComponentDescriptorsByTypes() throws ThingsboardException {
    // Arrange
    when(componentDiscoveryService.getComponents(
            Mockito.<Set<ComponentType>>any(), Mockito.<RuleChainType>any()))
        .thenThrow(new IllegalArgumentException("[{}] Lookup component descriptors"));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            auditLogController.checkComponentDescriptorsByTypes(
                new HashSet<>(), RuleChainType.CORE));
    verify(componentDiscoveryService).getComponents(isA(Set.class), eq(RuleChainType.CORE));
  }

  /**
   * Test {@link BaseController#checkComponentDescriptorsByTypes(Set, RuleChainType)}.
   *
   * <p>Method under test: {@link BaseController#checkComponentDescriptorsByTypes(Set,
   * RuleChainType)}
   */
  @Test
  @DisplayName("Test checkComponentDescriptorsByTypes(Set, RuleChainType)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List BaseController.checkComponentDescriptorsByTypes(Set, RuleChainType)"})
  void testCheckComponentDescriptorsByTypes2() throws ThingsboardException {
    // Arrange
    when(componentDiscoveryService.getComponents(
            Mockito.<Set<ComponentType>>any(), Mockito.<RuleChainType>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            auditLogController.checkComponentDescriptorsByTypes(
                new HashSet<>(), RuleChainType.CORE));
    verify(componentDiscoveryService).getComponents(isA(Set.class), eq(RuleChainType.CORE));
  }

  /**
   * Test {@link BaseController#checkComponentDescriptorsByTypes(Set, RuleChainType)}.
   *
   * <p>Method under test: {@link BaseController#checkComponentDescriptorsByTypes(Set,
   * RuleChainType)}
   */
  @Test
  @DisplayName("Test checkComponentDescriptorsByTypes(Set, RuleChainType)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List BaseController.checkComponentDescriptorsByTypes(Set, RuleChainType)"})
  void testCheckComponentDescriptorsByTypes3() throws ThingsboardException {
    // Arrange
    when(componentDiscoveryService.getComponents(
            Mockito.<Set<ComponentType>>any(), Mockito.<RuleChainType>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            auditLogController.checkComponentDescriptorsByTypes(
                new HashSet<>(), RuleChainType.CORE));
    verify(componentDiscoveryService).getComponents(isA(Set.class), eq(RuleChainType.CORE));
  }

  /**
   * Test {@link BaseController#checkComponentDescriptorsByTypes(Set, RuleChainType)}.
   *
   * <p>Method under test: {@link BaseController#checkComponentDescriptorsByTypes(Set,
   * RuleChainType)}
   */
  @Test
  @DisplayName("Test checkComponentDescriptorsByTypes(Set, RuleChainType)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List BaseController.checkComponentDescriptorsByTypes(Set, RuleChainType)"})
  void testCheckComponentDescriptorsByTypes4() throws ThingsboardException {
    // Arrange
    when(componentDiscoveryService.getComponents(
            Mockito.<Set<ComponentType>>any(), Mockito.<RuleChainType>any()))
        .thenThrow(new AsyncRequestTimeoutException());

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            auditLogController.checkComponentDescriptorsByTypes(
                new HashSet<>(), RuleChainType.CORE));
    verify(componentDiscoveryService).getComponents(isA(Set.class), eq(RuleChainType.CORE));
  }

  /**
   * Test {@link BaseController#checkComponentDescriptorsByTypes(Set, RuleChainType)}.
   *
   * <p>Method under test: {@link BaseController#checkComponentDescriptorsByTypes(Set,
   * RuleChainType)}
   */
  @Test
  @DisplayName("Test checkComponentDescriptorsByTypes(Set, RuleChainType)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List BaseController.checkComponentDescriptorsByTypes(Set, RuleChainType)"})
  void testCheckComponentDescriptorsByTypes5() throws ThingsboardException {
    // Arrange
    when(componentDiscoveryService.getComponents(
            Mockito.<Set<ComponentType>>any(), Mockito.<RuleChainType>any()))
        .thenThrow(new EmptyResultDataAccessException(3));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            auditLogController.checkComponentDescriptorsByTypes(
                new HashSet<>(), RuleChainType.CORE));
    verify(componentDiscoveryService).getComponents(isA(Set.class), eq(RuleChainType.CORE));
  }

  /**
   * Test {@link BaseController#checkComponentDescriptorsByTypes(Set, RuleChainType)}.
   *
   * <p>Method under test: {@link BaseController#checkComponentDescriptorsByTypes(Set,
   * RuleChainType)}
   */
  @Test
  @DisplayName("Test checkComponentDescriptorsByTypes(Set, RuleChainType)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List BaseController.checkComponentDescriptorsByTypes(Set, RuleChainType)"})
  void testCheckComponentDescriptorsByTypes6() throws ThingsboardException {
    // Arrange
    when(componentDiscoveryService.getComponents(
            Mockito.<Set<ComponentType>>any(), Mockito.<RuleChainType>any()))
        .thenThrow(new EntityVersionMismatchException("0123456789ABCDEF", new Throwable()));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            auditLogController.checkComponentDescriptorsByTypes(
                new HashSet<>(), RuleChainType.CORE));
    verify(componentDiscoveryService).getComponents(isA(Set.class), eq(RuleChainType.CORE));
  }

  /**
   * Test {@link BaseController#checkComponentDescriptorsByTypes(Set, RuleChainType)}.
   *
   * <ul>
   *   <li>Given {@code ENRICHMENT}.
   *   <li>When {@link HashSet#HashSet()} add {@code ENRICHMENT}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#checkComponentDescriptorsByTypes(Set,
   * RuleChainType)}
   */
  @Test
  @DisplayName(
      "Test checkComponentDescriptorsByTypes(Set, RuleChainType); given 'ENRICHMENT'; when HashSet() add 'ENRICHMENT'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List BaseController.checkComponentDescriptorsByTypes(Set, RuleChainType)"})
  void testCheckComponentDescriptorsByTypes_givenEnrichment_whenHashSetAddEnrichment()
      throws ThingsboardException {
    // Arrange
    when(componentDiscoveryService.getComponents(
            Mockito.<Set<ComponentType>>any(), Mockito.<RuleChainType>any()))
        .thenReturn(new ArrayList<>());

    HashSet<ComponentType> types = new HashSet<>();
    types.add(ComponentType.ENRICHMENT);

    // Act
    List<ComponentDescriptor> actualCheckComponentDescriptorsByTypesResult =
        auditLogController.checkComponentDescriptorsByTypes(types, RuleChainType.CORE);

    // Assert
    verify(componentDiscoveryService).getComponents(isA(Set.class), eq(RuleChainType.CORE));
    assertTrue(actualCheckComponentDescriptorsByTypesResult.isEmpty());
  }

  /**
   * Test {@link BaseController#checkComponentDescriptorsByTypes(Set, RuleChainType)}.
   *
   * <ul>
   *   <li>Given {@code FILTER}.
   *   <li>When {@link HashSet#HashSet()} add {@code FILTER}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#checkComponentDescriptorsByTypes(Set,
   * RuleChainType)}
   */
  @Test
  @DisplayName(
      "Test checkComponentDescriptorsByTypes(Set, RuleChainType); given 'FILTER'; when HashSet() add 'FILTER'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List BaseController.checkComponentDescriptorsByTypes(Set, RuleChainType)"})
  void testCheckComponentDescriptorsByTypes_givenFilter_whenHashSetAddFilter()
      throws ThingsboardException {
    // Arrange
    when(componentDiscoveryService.getComponents(
            Mockito.<Set<ComponentType>>any(), Mockito.<RuleChainType>any()))
        .thenReturn(new ArrayList<>());

    HashSet<ComponentType> types = new HashSet<>();
    types.add(ComponentType.FILTER);
    types.add(ComponentType.ENRICHMENT);

    // Act
    List<ComponentDescriptor> actualCheckComponentDescriptorsByTypesResult =
        auditLogController.checkComponentDescriptorsByTypes(types, RuleChainType.CORE);

    // Assert
    verify(componentDiscoveryService).getComponents(isA(Set.class), eq(RuleChainType.CORE));
    assertTrue(actualCheckComponentDescriptorsByTypesResult.isEmpty());
  }

  /**
   * Test {@link BaseController#checkComponentDescriptorsByTypes(Set, RuleChainType)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#checkComponentDescriptorsByTypes(Set,
   * RuleChainType)}
   */
  @Test
  @DisplayName("Test checkComponentDescriptorsByTypes(Set, RuleChainType); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List BaseController.checkComponentDescriptorsByTypes(Set, RuleChainType)"})
  void testCheckComponentDescriptorsByTypes_thenReturnEmpty() throws ThingsboardException {
    // Arrange
    when(componentDiscoveryService.getComponents(
            Mockito.<Set<ComponentType>>any(), Mockito.<RuleChainType>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<ComponentDescriptor> actualCheckComponentDescriptorsByTypesResult =
        auditLogController.checkComponentDescriptorsByTypes(new HashSet<>(), RuleChainType.CORE);

    // Assert
    verify(componentDiscoveryService).getComponents(isA(Set.class), eq(RuleChainType.CORE));
    assertTrue(actualCheckComponentDescriptorsByTypesResult.isEmpty());
  }

  /**
   * Test {@link BaseController#checkRuleNode(RuleNodeId, Operation)}.
   *
   * <ul>
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#checkRuleNode(RuleNodeId, Operation)}
   */
  @Test
  @DisplayName("Test checkRuleNode(RuleNodeId, Operation); then throw ThingsboardException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.rule.RuleNode BaseController.checkRuleNode(RuleNodeId, Operation)"
  })
  void testCheckRuleNode_thenThrowThingsboardException() throws ThingsboardException {
    // Arrange
    AuditLogController auditLogController = new AuditLogController();

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            auditLogController.checkRuleNode(
                new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
                Operation.ALL));
  }

  /**
   * Test {@link BaseController#emptyId(EntityType)}.
   *
   * <ul>
   *   <li>When {@code ALARM}.
   *   <li>Then return {@link AlarmId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#emptyId(EntityType)}
   */
  @Test
  @DisplayName("Test emptyId(EntityType); when 'ALARM'; then return AlarmId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityId BaseController.emptyId(EntityType)"})
  void testEmptyId_whenAlarm_thenReturnAlarmId() {
    // Arrange and Act
    EntityId actualEmptyIdResult = new AuditLogController().emptyId(EntityType.ALARM);

    // Assert
    assertTrue(actualEmptyIdResult instanceof AlarmId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEmptyIdResult.getId().toString());
    assertEquals(EntityType.ALARM, actualEmptyIdResult.getEntityType());
    assertTrue(actualEmptyIdResult.isNullUid());
  }

  /**
   * Test {@link BaseController#emptyId(EntityType)}.
   *
   * <ul>
   *   <li>When {@code API_USAGE_STATE}.
   *   <li>Then return {@link ApiUsageStateId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#emptyId(EntityType)}
   */
  @Test
  @DisplayName("Test emptyId(EntityType); when 'API_USAGE_STATE'; then return ApiUsageStateId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityId BaseController.emptyId(EntityType)"})
  void testEmptyId_whenApiUsageState_thenReturnApiUsageStateId() {
    // Arrange and Act
    EntityId actualEmptyIdResult = new AuditLogController().emptyId(EntityType.API_USAGE_STATE);

    // Assert
    assertTrue(actualEmptyIdResult instanceof ApiUsageStateId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEmptyIdResult.getId().toString());
    assertEquals(EntityType.API_USAGE_STATE, actualEmptyIdResult.getEntityType());
    assertTrue(actualEmptyIdResult.isNullUid());
  }

  /**
   * Test {@link BaseController#emptyId(EntityType)}.
   *
   * <ul>
   *   <li>When {@code ASSET_PROFILE}.
   *   <li>Then return {@link AssetProfileId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#emptyId(EntityType)}
   */
  @Test
  @DisplayName("Test emptyId(EntityType); when 'ASSET_PROFILE'; then return AssetProfileId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityId BaseController.emptyId(EntityType)"})
  void testEmptyId_whenAssetProfile_thenReturnAssetProfileId() {
    // Arrange and Act
    EntityId actualEmptyIdResult = new AuditLogController().emptyId(EntityType.ASSET_PROFILE);

    // Assert
    assertTrue(actualEmptyIdResult instanceof AssetProfileId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEmptyIdResult.getId().toString());
    assertEquals(EntityType.ASSET_PROFILE, actualEmptyIdResult.getEntityType());
    assertTrue(actualEmptyIdResult.isNullUid());
  }

  /**
   * Test {@link BaseController#emptyId(EntityType)}.
   *
   * <ul>
   *   <li>When {@code ASSET}.
   *   <li>Then return {@link AssetId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#emptyId(EntityType)}
   */
  @Test
  @DisplayName("Test emptyId(EntityType); when 'ASSET'; then return AssetId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityId BaseController.emptyId(EntityType)"})
  void testEmptyId_whenAsset_thenReturnAssetId() {
    // Arrange and Act
    EntityId actualEmptyIdResult = new AuditLogController().emptyId(EntityType.ASSET);

    // Assert
    assertTrue(actualEmptyIdResult instanceof AssetId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEmptyIdResult.getId().toString());
    assertEquals(EntityType.ASSET, actualEmptyIdResult.getEntityType());
    assertTrue(actualEmptyIdResult.isNullUid());
  }

  /**
   * Test {@link BaseController#emptyId(EntityType)}.
   *
   * <ul>
   *   <li>When {@code CUSTOMER}.
   *   <li>Then return {@link CustomerId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#emptyId(EntityType)}
   */
  @Test
  @DisplayName("Test emptyId(EntityType); when 'CUSTOMER'; then return CustomerId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityId BaseController.emptyId(EntityType)"})
  void testEmptyId_whenCustomer_thenReturnCustomerId() {
    // Arrange and Act
    EntityId actualEmptyIdResult = new AuditLogController().emptyId(EntityType.CUSTOMER);

    // Assert
    assertTrue(actualEmptyIdResult instanceof CustomerId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEmptyIdResult.getId().toString());
    assertEquals(EntityType.CUSTOMER, actualEmptyIdResult.getEntityType());
    assertTrue(actualEmptyIdResult.isNullUid());
  }

  /**
   * Test {@link BaseController#emptyId(EntityType)}.
   *
   * <ul>
   *   <li>When {@code DASHBOARD}.
   *   <li>Then return {@link DashboardId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#emptyId(EntityType)}
   */
  @Test
  @DisplayName("Test emptyId(EntityType); when 'DASHBOARD'; then return DashboardId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityId BaseController.emptyId(EntityType)"})
  void testEmptyId_whenDashboard_thenReturnDashboardId() {
    // Arrange and Act
    EntityId actualEmptyIdResult = new AuditLogController().emptyId(EntityType.DASHBOARD);

    // Assert
    assertTrue(actualEmptyIdResult instanceof DashboardId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEmptyIdResult.getId().toString());
    assertEquals(EntityType.DASHBOARD, actualEmptyIdResult.getEntityType());
    assertTrue(actualEmptyIdResult.isNullUid());
  }

  /**
   * Test {@link BaseController#emptyId(EntityType)}.
   *
   * <ul>
   *   <li>When {@code DEVICE_PROFILE}.
   *   <li>Then return {@link DeviceProfileId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#emptyId(EntityType)}
   */
  @Test
  @DisplayName("Test emptyId(EntityType); when 'DEVICE_PROFILE'; then return DeviceProfileId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityId BaseController.emptyId(EntityType)"})
  void testEmptyId_whenDeviceProfile_thenReturnDeviceProfileId() {
    // Arrange and Act
    EntityId actualEmptyIdResult = new AuditLogController().emptyId(EntityType.DEVICE_PROFILE);

    // Assert
    assertTrue(actualEmptyIdResult instanceof DeviceProfileId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEmptyIdResult.getId().toString());
    assertEquals(EntityType.DEVICE_PROFILE, actualEmptyIdResult.getEntityType());
    assertTrue(actualEmptyIdResult.isNullUid());
  }

  /**
   * Test {@link BaseController#emptyId(EntityType)}.
   *
   * <ul>
   *   <li>When {@code DEVICE}.
   *   <li>Then return {@link DeviceId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#emptyId(EntityType)}
   */
  @Test
  @DisplayName("Test emptyId(EntityType); when 'DEVICE'; then return DeviceId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityId BaseController.emptyId(EntityType)"})
  void testEmptyId_whenDevice_thenReturnDeviceId() {
    // Arrange and Act
    EntityId actualEmptyIdResult = new AuditLogController().emptyId(EntityType.DEVICE);

    // Assert
    assertTrue(actualEmptyIdResult instanceof DeviceId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEmptyIdResult.getId().toString());
    assertEquals(EntityType.DEVICE, actualEmptyIdResult.getEntityType());
    assertTrue(actualEmptyIdResult.isNullUid());
  }

  /**
   * Test {@link BaseController#emptyId(EntityType)}.
   *
   * <ul>
   *   <li>When {@code DOMAIN}.
   *   <li>Then return {@link DomainId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#emptyId(EntityType)}
   */
  @Test
  @DisplayName("Test emptyId(EntityType); when 'DOMAIN'; then return DomainId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityId BaseController.emptyId(EntityType)"})
  void testEmptyId_whenDomain_thenReturnDomainId() {
    // Arrange and Act
    EntityId actualEmptyIdResult = new AuditLogController().emptyId(EntityType.DOMAIN);

    // Assert
    assertTrue(actualEmptyIdResult instanceof DomainId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEmptyIdResult.getId().toString());
    assertEquals(EntityType.DOMAIN, actualEmptyIdResult.getEntityType());
    assertTrue(actualEmptyIdResult.isNullUid());
  }

  /**
   * Test {@link BaseController#emptyId(EntityType)}.
   *
   * <ul>
   *   <li>When {@code EDGE}.
   *   <li>Then return {@link EdgeId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#emptyId(EntityType)}
   */
  @Test
  @DisplayName("Test emptyId(EntityType); when 'EDGE'; then return EdgeId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityId BaseController.emptyId(EntityType)"})
  void testEmptyId_whenEdge_thenReturnEdgeId() {
    // Arrange and Act
    EntityId actualEmptyIdResult = new AuditLogController().emptyId(EntityType.EDGE);

    // Assert
    assertTrue(actualEmptyIdResult instanceof EdgeId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEmptyIdResult.getId().toString());
    assertEquals(EntityType.EDGE, actualEmptyIdResult.getEntityType());
    assertTrue(actualEmptyIdResult.isNullUid());
  }

  /**
   * Test {@link BaseController#emptyId(EntityType)}.
   *
   * <ul>
   *   <li>When {@code ENTITY_VIEW}.
   *   <li>Then return {@link EntityViewId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#emptyId(EntityType)}
   */
  @Test
  @DisplayName("Test emptyId(EntityType); when 'ENTITY_VIEW'; then return EntityViewId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityId BaseController.emptyId(EntityType)"})
  void testEmptyId_whenEntityView_thenReturnEntityViewId() {
    // Arrange and Act
    EntityId actualEmptyIdResult = new AuditLogController().emptyId(EntityType.ENTITY_VIEW);

    // Assert
    assertTrue(actualEmptyIdResult instanceof EntityViewId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEmptyIdResult.getId().toString());
    assertEquals(EntityType.ENTITY_VIEW, actualEmptyIdResult.getEntityType());
    assertTrue(actualEmptyIdResult.isNullUid());
  }

  /**
   * Test {@link BaseController#emptyId(EntityType)}.
   *
   * <ul>
   *   <li>When {@code MOBILE_APP}.
   *   <li>Then return {@link MobileAppId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#emptyId(EntityType)}
   */
  @Test
  @DisplayName("Test emptyId(EntityType); when 'MOBILE_APP'; then return MobileAppId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityId BaseController.emptyId(EntityType)"})
  void testEmptyId_whenMobileApp_thenReturnMobileAppId() {
    // Arrange and Act
    EntityId actualEmptyIdResult = new AuditLogController().emptyId(EntityType.MOBILE_APP);

    // Assert
    assertTrue(actualEmptyIdResult instanceof MobileAppId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEmptyIdResult.getId().toString());
    assertEquals(EntityType.MOBILE_APP, actualEmptyIdResult.getEntityType());
    assertTrue(actualEmptyIdResult.isNullUid());
  }

  /**
   * Test {@link BaseController#emptyId(EntityType)}.
   *
   * <ul>
   *   <li>When {@code NOTIFICATION_REQUEST}.
   *   <li>Then return {@link NotificationRequestId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#emptyId(EntityType)}
   */
  @Test
  @DisplayName(
      "Test emptyId(EntityType); when 'NOTIFICATION_REQUEST'; then return NotificationRequestId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityId BaseController.emptyId(EntityType)"})
  void testEmptyId_whenNotificationRequest_thenReturnNotificationRequestId() {
    // Arrange and Act
    EntityId actualEmptyIdResult =
        new AuditLogController().emptyId(EntityType.NOTIFICATION_REQUEST);

    // Assert
    assertTrue(actualEmptyIdResult instanceof NotificationRequestId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEmptyIdResult.getId().toString());
    assertEquals(EntityType.NOTIFICATION_REQUEST, actualEmptyIdResult.getEntityType());
    assertTrue(actualEmptyIdResult.isNullUid());
  }

  /**
   * Test {@link BaseController#emptyId(EntityType)}.
   *
   * <ul>
   *   <li>When {@code NOTIFICATION_RULE}.
   *   <li>Then return {@link NotificationRuleId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#emptyId(EntityType)}
   */
  @Test
  @DisplayName("Test emptyId(EntityType); when 'NOTIFICATION_RULE'; then return NotificationRuleId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityId BaseController.emptyId(EntityType)"})
  void testEmptyId_whenNotificationRule_thenReturnNotificationRuleId() {
    // Arrange and Act
    EntityId actualEmptyIdResult = new AuditLogController().emptyId(EntityType.NOTIFICATION_RULE);

    // Assert
    assertTrue(actualEmptyIdResult instanceof NotificationRuleId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEmptyIdResult.getId().toString());
    assertEquals(EntityType.NOTIFICATION_RULE, actualEmptyIdResult.getEntityType());
    assertTrue(actualEmptyIdResult.isNullUid());
  }

  /**
   * Test {@link BaseController#emptyId(EntityType)}.
   *
   * <ul>
   *   <li>When {@code NOTIFICATION_TARGET}.
   *   <li>Then return {@link NotificationTargetId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#emptyId(EntityType)}
   */
  @Test
  @DisplayName(
      "Test emptyId(EntityType); when 'NOTIFICATION_TARGET'; then return NotificationTargetId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityId BaseController.emptyId(EntityType)"})
  void testEmptyId_whenNotificationTarget_thenReturnNotificationTargetId() {
    // Arrange and Act
    EntityId actualEmptyIdResult = new AuditLogController().emptyId(EntityType.NOTIFICATION_TARGET);

    // Assert
    assertTrue(actualEmptyIdResult instanceof NotificationTargetId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEmptyIdResult.getId().toString());
    assertEquals(EntityType.NOTIFICATION_TARGET, actualEmptyIdResult.getEntityType());
    assertTrue(actualEmptyIdResult.isNullUid());
  }

  /**
   * Test {@link BaseController#emptyId(EntityType)}.
   *
   * <ul>
   *   <li>When {@code NOTIFICATION_TEMPLATE}.
   *   <li>Then return {@link NotificationTemplateId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#emptyId(EntityType)}
   */
  @Test
  @DisplayName(
      "Test emptyId(EntityType); when 'NOTIFICATION_TEMPLATE'; then return NotificationTemplateId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityId BaseController.emptyId(EntityType)"})
  void testEmptyId_whenNotificationTemplate_thenReturnNotificationTemplateId() {
    // Arrange and Act
    EntityId actualEmptyIdResult =
        new AuditLogController().emptyId(EntityType.NOTIFICATION_TEMPLATE);

    // Assert
    assertTrue(actualEmptyIdResult instanceof NotificationTemplateId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEmptyIdResult.getId().toString());
    assertEquals(EntityType.NOTIFICATION_TEMPLATE, actualEmptyIdResult.getEntityType());
    assertTrue(actualEmptyIdResult.isNullUid());
  }

  /**
   * Test {@link BaseController#emptyId(EntityType)}.
   *
   * <ul>
   *   <li>When {@code NOTIFICATION}.
   *   <li>Then return {@link NotificationId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#emptyId(EntityType)}
   */
  @Test
  @DisplayName("Test emptyId(EntityType); when 'NOTIFICATION'; then return NotificationId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityId BaseController.emptyId(EntityType)"})
  void testEmptyId_whenNotification_thenReturnNotificationId() {
    // Arrange and Act
    EntityId actualEmptyIdResult = new AuditLogController().emptyId(EntityType.NOTIFICATION);

    // Assert
    assertTrue(actualEmptyIdResult instanceof NotificationId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEmptyIdResult.getId().toString());
    assertEquals(EntityType.NOTIFICATION, actualEmptyIdResult.getEntityType());
    assertTrue(actualEmptyIdResult.isNullUid());
  }

  /**
   * Test {@link BaseController#emptyId(EntityType)}.
   *
   * <ul>
   *   <li>When {@code OAUTH2_CLIENT}.
   *   <li>Then return {@link OAuth2ClientId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#emptyId(EntityType)}
   */
  @Test
  @DisplayName("Test emptyId(EntityType); when 'OAUTH2_CLIENT'; then return OAuth2ClientId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityId BaseController.emptyId(EntityType)"})
  void testEmptyId_whenOauth2Client_thenReturnOAuth2ClientId() {
    // Arrange and Act
    EntityId actualEmptyIdResult = new AuditLogController().emptyId(EntityType.OAUTH2_CLIENT);

    // Assert
    assertTrue(actualEmptyIdResult instanceof OAuth2ClientId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEmptyIdResult.getId().toString());
    assertEquals(EntityType.OAUTH2_CLIENT, actualEmptyIdResult.getEntityType());
    assertTrue(actualEmptyIdResult.isNullUid());
  }

  /**
   * Test {@link BaseController#emptyId(EntityType)}.
   *
   * <ul>
   *   <li>When {@code OTA_PACKAGE}.
   *   <li>Then return {@link OtaPackageId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#emptyId(EntityType)}
   */
  @Test
  @DisplayName("Test emptyId(EntityType); when 'OTA_PACKAGE'; then return OtaPackageId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityId BaseController.emptyId(EntityType)"})
  void testEmptyId_whenOtaPackage_thenReturnOtaPackageId() {
    // Arrange and Act
    EntityId actualEmptyIdResult = new AuditLogController().emptyId(EntityType.OTA_PACKAGE);

    // Assert
    assertTrue(actualEmptyIdResult instanceof OtaPackageId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEmptyIdResult.getId().toString());
    assertEquals(EntityType.OTA_PACKAGE, actualEmptyIdResult.getEntityType());
    assertTrue(actualEmptyIdResult.isNullUid());
  }

  /**
   * Test {@link BaseController#emptyId(EntityType)}.
   *
   * <ul>
   *   <li>When {@code QUEUE_STATS}.
   *   <li>Then return {@link QueueStatsId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#emptyId(EntityType)}
   */
  @Test
  @DisplayName("Test emptyId(EntityType); when 'QUEUE_STATS'; then return QueueStatsId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityId BaseController.emptyId(EntityType)"})
  void testEmptyId_whenQueueStats_thenReturnQueueStatsId() {
    // Arrange and Act
    EntityId actualEmptyIdResult = new AuditLogController().emptyId(EntityType.QUEUE_STATS);

    // Assert
    assertTrue(actualEmptyIdResult instanceof QueueStatsId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEmptyIdResult.getId().toString());
    assertEquals(EntityType.QUEUE_STATS, actualEmptyIdResult.getEntityType());
    assertTrue(actualEmptyIdResult.isNullUid());
  }

  /**
   * Test {@link BaseController#emptyId(EntityType)}.
   *
   * <ul>
   *   <li>When {@code QUEUE}.
   *   <li>Then return {@link QueueId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#emptyId(EntityType)}
   */
  @Test
  @DisplayName("Test emptyId(EntityType); when 'QUEUE'; then return QueueId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityId BaseController.emptyId(EntityType)"})
  void testEmptyId_whenQueue_thenReturnQueueId() {
    // Arrange and Act
    EntityId actualEmptyIdResult = new AuditLogController().emptyId(EntityType.QUEUE);

    // Assert
    assertTrue(actualEmptyIdResult instanceof QueueId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEmptyIdResult.getId().toString());
    assertEquals(EntityType.QUEUE, actualEmptyIdResult.getEntityType());
    assertTrue(actualEmptyIdResult.isNullUid());
  }

  /**
   * Test {@link BaseController#emptyId(EntityType)}.
   *
   * <ul>
   *   <li>When {@code RPC}.
   *   <li>Then return {@link RpcId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#emptyId(EntityType)}
   */
  @Test
  @DisplayName("Test emptyId(EntityType); when 'RPC'; then return RpcId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityId BaseController.emptyId(EntityType)"})
  void testEmptyId_whenRpc_thenReturnRpcId() {
    // Arrange and Act
    EntityId actualEmptyIdResult = new AuditLogController().emptyId(EntityType.RPC);

    // Assert
    assertTrue(actualEmptyIdResult instanceof RpcId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEmptyIdResult.getId().toString());
    assertEquals(EntityType.RPC, actualEmptyIdResult.getEntityType());
    assertTrue(actualEmptyIdResult.isNullUid());
  }

  /**
   * Test {@link BaseController#emptyId(EntityType)}.
   *
   * <ul>
   *   <li>When {@code RULE_CHAIN}.
   *   <li>Then return {@link RuleChainId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#emptyId(EntityType)}
   */
  @Test
  @DisplayName("Test emptyId(EntityType); when 'RULE_CHAIN'; then return RuleChainId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityId BaseController.emptyId(EntityType)"})
  void testEmptyId_whenRuleChain_thenReturnRuleChainId() {
    // Arrange and Act
    EntityId actualEmptyIdResult = new AuditLogController().emptyId(EntityType.RULE_CHAIN);

    // Assert
    assertTrue(actualEmptyIdResult instanceof RuleChainId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEmptyIdResult.getId().toString());
    assertEquals(EntityType.RULE_CHAIN, actualEmptyIdResult.getEntityType());
    assertTrue(actualEmptyIdResult.isNullUid());
  }

  /**
   * Test {@link BaseController#emptyId(EntityType)}.
   *
   * <ul>
   *   <li>When {@code RULE_NODE}.
   *   <li>Then return {@link RuleNodeId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#emptyId(EntityType)}
   */
  @Test
  @DisplayName("Test emptyId(EntityType); when 'RULE_NODE'; then return RuleNodeId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityId BaseController.emptyId(EntityType)"})
  void testEmptyId_whenRuleNode_thenReturnRuleNodeId() {
    // Arrange and Act
    EntityId actualEmptyIdResult = new AuditLogController().emptyId(EntityType.RULE_NODE);

    // Assert
    assertTrue(actualEmptyIdResult instanceof RuleNodeId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEmptyIdResult.getId().toString());
    assertEquals(EntityType.RULE_NODE, actualEmptyIdResult.getEntityType());
    assertTrue(actualEmptyIdResult.isNullUid());
  }

  /**
   * Test {@link BaseController#emptyId(EntityType)}.
   *
   * <ul>
   *   <li>When {@code TB_RESOURCE}.
   *   <li>Then return {@link TbResourceId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#emptyId(EntityType)}
   */
  @Test
  @DisplayName("Test emptyId(EntityType); when 'TB_RESOURCE'; then return TbResourceId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityId BaseController.emptyId(EntityType)"})
  void testEmptyId_whenTbResource_thenReturnTbResourceId() {
    // Arrange and Act
    EntityId actualEmptyIdResult = new AuditLogController().emptyId(EntityType.TB_RESOURCE);

    // Assert
    assertTrue(actualEmptyIdResult instanceof TbResourceId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEmptyIdResult.getId().toString());
    assertEquals(EntityType.TB_RESOURCE, actualEmptyIdResult.getEntityType());
    assertTrue(actualEmptyIdResult.isNullUid());
  }

  /**
   * Test {@link BaseController#emptyId(EntityType)}.
   *
   * <ul>
   *   <li>When {@code TENANT_PROFILE}.
   *   <li>Then return {@link TenantProfileId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#emptyId(EntityType)}
   */
  @Test
  @DisplayName("Test emptyId(EntityType); when 'TENANT_PROFILE'; then return TenantProfileId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityId BaseController.emptyId(EntityType)"})
  void testEmptyId_whenTenantProfile_thenReturnTenantProfileId() {
    // Arrange and Act
    EntityId actualEmptyIdResult = new AuditLogController().emptyId(EntityType.TENANT_PROFILE);

    // Assert
    assertTrue(actualEmptyIdResult instanceof TenantProfileId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEmptyIdResult.getId().toString());
    assertEquals(EntityType.TENANT_PROFILE, actualEmptyIdResult.getEntityType());
    assertTrue(actualEmptyIdResult.isNullUid());
  }

  /**
   * Test {@link BaseController#emptyId(EntityType)}.
   *
   * <ul>
   *   <li>When {@code USER}.
   *   <li>Then return {@link UserId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#emptyId(EntityType)}
   */
  @Test
  @DisplayName("Test emptyId(EntityType); when 'USER'; then return UserId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityId BaseController.emptyId(EntityType)"})
  void testEmptyId_whenUser_thenReturnUserId() {
    // Arrange and Act
    EntityId actualEmptyIdResult = new AuditLogController().emptyId(EntityType.USER);

    // Assert
    assertTrue(actualEmptyIdResult instanceof UserId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEmptyIdResult.getId().toString());
    assertEquals(EntityType.USER, actualEmptyIdResult.getEntityType());
    assertTrue(actualEmptyIdResult.isNullUid());
  }

  /**
   * Test {@link BaseController#emptyId(EntityType)}.
   *
   * <ul>
   *   <li>When {@code WIDGET_TYPE}.
   *   <li>Then return {@link WidgetTypeId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#emptyId(EntityType)}
   */
  @Test
  @DisplayName("Test emptyId(EntityType); when 'WIDGET_TYPE'; then return WidgetTypeId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityId BaseController.emptyId(EntityType)"})
  void testEmptyId_whenWidgetType_thenReturnWidgetTypeId() {
    // Arrange and Act
    EntityId actualEmptyIdResult = new AuditLogController().emptyId(EntityType.WIDGET_TYPE);

    // Assert
    assertTrue(actualEmptyIdResult instanceof WidgetTypeId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEmptyIdResult.getId().toString());
    assertEquals(EntityType.WIDGET_TYPE, actualEmptyIdResult.getEntityType());
    assertTrue(actualEmptyIdResult.isNullUid());
  }

  /**
   * Test {@link BaseController#emptyId(EntityType)}.
   *
   * <ul>
   *   <li>When {@code WIDGETS_BUNDLE}.
   *   <li>Then return {@link WidgetsBundleId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#emptyId(EntityType)}
   */
  @Test
  @DisplayName("Test emptyId(EntityType); when 'WIDGETS_BUNDLE'; then return WidgetsBundleId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityId BaseController.emptyId(EntityType)"})
  void testEmptyId_whenWidgetsBundle_thenReturnWidgetsBundleId() {
    // Arrange and Act
    EntityId actualEmptyIdResult = new AuditLogController().emptyId(EntityType.WIDGETS_BUNDLE);

    // Assert
    assertTrue(actualEmptyIdResult instanceof WidgetsBundleId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEmptyIdResult.getId().toString());
    assertEquals(EntityType.WIDGETS_BUNDLE, actualEmptyIdResult.getEntityType());
    assertTrue(actualEmptyIdResult.isNullUid());
  }

  /**
   * Test {@link BaseController#createEntityDataSortOrder(String, String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return Key Key is {@code not empty}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#createEntityDataSortOrder(String, String)}
   */
  @Test
  @DisplayName(
      "Test createEntityDataSortOrder(String, String); when empty string; then return Key Key is 'not empty'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "EntityDataSortOrder BaseController.createEntityDataSortOrder(String, String)"
  })
  void testCreateEntityDataSortOrder_whenEmptyString_thenReturnKeyKeyIsNotEmpty() {
    // Arrange and Act
    EntityDataSortOrder actualCreateEntityDataSortOrderResult =
        new AuditLogController().createEntityDataSortOrder("not empty", "");

    // Assert
    EntityKey key = actualCreateEntityDataSortOrderResult.getKey();
    assertEquals("not empty", key.getKey());
    assertNull(actualCreateEntityDataSortOrderResult.getDirection());
    assertEquals(EntityKeyType.ENTITY_FIELD, key.getType());
  }

  /**
   * Test {@link BaseController#createEntityDataSortOrder(String, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Key Key is {@code not empty}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#createEntityDataSortOrder(String, String)}
   */
  @Test
  @DisplayName(
      "Test createEntityDataSortOrder(String, String); when 'null'; then return Key Key is 'not empty'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "EntityDataSortOrder BaseController.createEntityDataSortOrder(String, String)"
  })
  void testCreateEntityDataSortOrder_whenNull_thenReturnKeyKeyIsNotEmpty() {
    // Arrange and Act
    EntityDataSortOrder actualCreateEntityDataSortOrderResult =
        new AuditLogController().createEntityDataSortOrder("not empty", null);

    // Assert
    EntityKey key = actualCreateEntityDataSortOrderResult.getKey();
    assertEquals("not empty", key.getKey());
    assertNull(actualCreateEntityDataSortOrderResult.getDirection());
    assertEquals(EntityKeyType.ENTITY_FIELD, key.getType());
  }

  /**
   * Test {@link BaseController#createEntityDataSortOrder(String, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#createEntityDataSortOrder(String, String)}
   */
  @Test
  @DisplayName("Test createEntityDataSortOrder(String, String); when 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "EntityDataSortOrder BaseController.createEntityDataSortOrder(String, String)"
  })
  void testCreateEntityDataSortOrder_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new AuditLogController().createEntityDataSortOrder(null, "not empty"));
  }

  /**
   * Test {@link BaseController#getOAuth2ClientIds(UUID[])}.
   *
   * <ul>
   *   <li>Given {@link AuditLogController} (default constructor).
   *   <li>When {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link BaseController#getOAuth2ClientIds(UUID[])}
   */
  @Test
  @DisplayName(
      "Test getOAuth2ClientIds(UUID[]); given AuditLogController (default constructor); when 'null'; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List BaseController.getOAuth2ClientIds(UUID[])"})
  void testGetOAuth2ClientIds_givenAuditLogController_whenNull_thenReturnEmpty()
      throws ThingsboardException {
    // Arrange, Act and Assert
    assertTrue(new AuditLogController().getOAuth2ClientIds(null).isEmpty());
  }
}
