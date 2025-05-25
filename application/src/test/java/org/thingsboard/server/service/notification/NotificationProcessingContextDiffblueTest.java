package org.thingsboard.server.service.notification;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Supplier;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.NotificationDeliveryMethod;
import org.thingsboard.server.common.data.notification.NotificationRequest;
import org.thingsboard.server.common.data.notification.NotificationRequestStats;
import org.thingsboard.server.common.data.notification.NotificationType;
import org.thingsboard.server.common.data.notification.info.NotificationInfo;
import org.thingsboard.server.common.data.notification.settings.NotificationSettings;
import org.thingsboard.server.common.data.notification.template.DeliveryMethodNotificationTemplate;
import org.thingsboard.server.common.data.notification.template.EmailDeliveryMethodNotificationTemplate;
import org.thingsboard.server.common.data.notification.template.NotificationTemplate;
import org.thingsboard.server.common.data.notification.template.NotificationTemplateConfig;
import org.thingsboard.server.common.data.notification.template.TemplatableValue;

@ContextConfiguration(classes = {TenantId.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class NotificationProcessingContextDiffblueTest {
  @MockBean
  private NotificationDeliveryMethod notificationDeliveryMethod;

  @MockBean
  private NotificationRequest notificationRequest;

  @MockBean
  private NotificationTemplate notificationTemplate;

  @Autowired
  private Set<NotificationDeliveryMethod> set;

  @MockBean
  private UUID uUID;

  /**
   * Test {@link NotificationProcessingContext#NotificationProcessingContext(TenantId, NotificationRequest, Set, NotificationTemplate, NotificationSettings, NotificationSettings)}.
   * <p>
   * Method under test: {@link NotificationProcessingContext#NotificationProcessingContext(TenantId, NotificationRequest, Set, NotificationTemplate, NotificationSettings, NotificationSettings)}
   */
  @Test
  @DisplayName("Test new NotificationProcessingContext(TenantId, NotificationRequest, Set, NotificationTemplate, NotificationSettings, NotificationSettings)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void NotificationProcessingContext.<init>(TenantId, NotificationRequest, Set, NotificationTemplate, NotificationSettings, NotificationSettings)"})
  void testNewNotificationProcessingContext() {
    // Arrange
    HashMap<NotificationDeliveryMethod, DeliveryMethodNotificationTemplate> notificationDeliveryMethodDeliveryMethodNotificationTemplateMap = new HashMap<>();
    notificationDeliveryMethodDeliveryMethodNotificationTemplateMap.put(NotificationDeliveryMethod.WEB,
        new EmailDeliveryMethodNotificationTemplate());
    NotificationTemplateConfig notificationTemplateConfig = mock(NotificationTemplateConfig.class);
    when(notificationTemplateConfig.getDeliveryMethodsTemplates())
        .thenReturn(notificationDeliveryMethodDeliveryMethodNotificationTemplateMap);
    when(notificationTemplate.getNotificationType()).thenReturn(NotificationType.GENERAL);
    when(notificationTemplate.getConfiguration()).thenReturn(notificationTemplateConfig);
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    HashSet<NotificationDeliveryMethod> deliveryMethods = new HashSet<>();

    NotificationSettings settings = new NotificationSettings();
    settings.setDeliveryMethodsConfigs(new HashMap<>());

    NotificationSettings systemSettings = new NotificationSettings();
    systemSettings.setDeliveryMethodsConfigs(new HashMap<>());

    // Act
    NotificationProcessingContext actualNotificationProcessingContext = new NotificationProcessingContext(tenantId,
        notificationRequest, deliveryMethods, notificationTemplate, settings, systemSettings);

    // Assert
    verify(notificationTemplate).getConfiguration();
    verify(notificationTemplate).getNotificationType();
    verify(notificationTemplateConfig).getDeliveryMethodsTemplates();
    NotificationRequestStats stats = actualNotificationProcessingContext.getStats();
    assertNull(stats.getError());
    assertEquals(NotificationType.GENERAL, actualNotificationProcessingContext.getNotificationType());
    assertTrue(stats.getErrors().isEmpty());
    assertTrue(stats.getProcessedRecipients().isEmpty());
    assertTrue(stats.getSent().isEmpty());
    assertTrue(actualNotificationProcessingContext.getDeliveryMethods().isEmpty());
    assertSame(tenantId, actualNotificationProcessingContext.getTenantId());
    assertSame(notificationRequest, actualNotificationProcessingContext.getRequest());
    assertSame(notificationTemplate, actualNotificationProcessingContext.getNotificationTemplate());
  }

  /**
   * Test {@link NotificationProcessingContext#NotificationProcessingContext(TenantId, NotificationRequest, Set, NotificationTemplate, NotificationSettings, NotificationSettings)}.
   * <p>
   * Method under test: {@link NotificationProcessingContext#NotificationProcessingContext(TenantId, NotificationRequest, Set, NotificationTemplate, NotificationSettings, NotificationSettings)}
   */
  @Test
  @DisplayName("Test new NotificationProcessingContext(TenantId, NotificationRequest, Set, NotificationTemplate, NotificationSettings, NotificationSettings)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void NotificationProcessingContext.<init>(TenantId, NotificationRequest, Set, NotificationTemplate, NotificationSettings, NotificationSettings)"})
  void testNewNotificationProcessingContext2() {
    // Arrange
    HashMap<NotificationDeliveryMethod, DeliveryMethodNotificationTemplate> notificationDeliveryMethodDeliveryMethodNotificationTemplateMap = new HashMap<>();
    notificationDeliveryMethodDeliveryMethodNotificationTemplateMap.put(NotificationDeliveryMethod.EMAIL,
        new EmailDeliveryMethodNotificationTemplate());
    notificationDeliveryMethodDeliveryMethodNotificationTemplateMap.put(NotificationDeliveryMethod.WEB,
        new EmailDeliveryMethodNotificationTemplate());
    NotificationTemplateConfig notificationTemplateConfig = mock(NotificationTemplateConfig.class);
    when(notificationTemplateConfig.getDeliveryMethodsTemplates())
        .thenReturn(notificationDeliveryMethodDeliveryMethodNotificationTemplateMap);
    when(notificationTemplate.getNotificationType()).thenReturn(NotificationType.GENERAL);
    when(notificationTemplate.getConfiguration()).thenReturn(notificationTemplateConfig);
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    HashSet<NotificationDeliveryMethod> deliveryMethods = new HashSet<>();

    NotificationSettings settings = new NotificationSettings();
    settings.setDeliveryMethodsConfigs(new HashMap<>());

    NotificationSettings systemSettings = new NotificationSettings();
    systemSettings.setDeliveryMethodsConfigs(new HashMap<>());

    // Act
    NotificationProcessingContext actualNotificationProcessingContext = new NotificationProcessingContext(tenantId,
        notificationRequest, deliveryMethods, notificationTemplate, settings, systemSettings);

    // Assert
    verify(notificationTemplate).getConfiguration();
    verify(notificationTemplate).getNotificationType();
    verify(notificationTemplateConfig).getDeliveryMethodsTemplates();
    NotificationRequestStats stats = actualNotificationProcessingContext.getStats();
    assertNull(stats.getError());
    assertEquals(NotificationType.GENERAL, actualNotificationProcessingContext.getNotificationType());
    assertTrue(stats.getErrors().isEmpty());
    assertTrue(stats.getProcessedRecipients().isEmpty());
    assertTrue(stats.getSent().isEmpty());
    assertTrue(actualNotificationProcessingContext.getDeliveryMethods().isEmpty());
    assertSame(tenantId, actualNotificationProcessingContext.getTenantId());
    assertSame(notificationRequest, actualNotificationProcessingContext.getRequest());
    assertSame(notificationTemplate, actualNotificationProcessingContext.getNotificationTemplate());
  }

  /**
   * Test {@link NotificationProcessingContext#NotificationProcessingContext(TenantId, NotificationRequest, Set, NotificationTemplate, NotificationSettings, NotificationSettings)}.
   * <p>
   * Method under test: {@link NotificationProcessingContext#NotificationProcessingContext(TenantId, NotificationRequest, Set, NotificationTemplate, NotificationSettings, NotificationSettings)}
   */
  @Test
  @DisplayName("Test new NotificationProcessingContext(TenantId, NotificationRequest, Set, NotificationTemplate, NotificationSettings, NotificationSettings)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void NotificationProcessingContext.<init>(TenantId, NotificationRequest, Set, NotificationTemplate, NotificationSettings, NotificationSettings)"})
  void testNewNotificationProcessingContext3() {
    // Arrange
    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("foo", "foo");
    NotificationInfo notificationInfo = mock(NotificationInfo.class);
    when(notificationInfo.getTemplateData()).thenReturn(stringStringMap);
    when(notificationRequest.getInfo()).thenReturn(notificationInfo);
    EmailDeliveryMethodNotificationTemplate emailDeliveryMethodNotificationTemplate = mock(
        EmailDeliveryMethodNotificationTemplate.class);
    when(emailDeliveryMethodNotificationTemplate.copy()).thenReturn(new EmailDeliveryMethodNotificationTemplate());
    when(emailDeliveryMethodNotificationTemplate.isEnabled()).thenReturn(true);

    HashMap<NotificationDeliveryMethod, DeliveryMethodNotificationTemplate> notificationDeliveryMethodDeliveryMethodNotificationTemplateMap = new HashMap<>();
    notificationDeliveryMethodDeliveryMethodNotificationTemplateMap.put(NotificationDeliveryMethod.WEB,
        emailDeliveryMethodNotificationTemplate);
    NotificationTemplateConfig notificationTemplateConfig = mock(NotificationTemplateConfig.class);
    when(notificationTemplateConfig.getDeliveryMethodsTemplates())
        .thenReturn(notificationDeliveryMethodDeliveryMethodNotificationTemplateMap);
    when(notificationTemplate.getNotificationType()).thenReturn(NotificationType.GENERAL);
    when(notificationTemplate.getConfiguration()).thenReturn(notificationTemplateConfig);
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    HashSet<NotificationDeliveryMethod> deliveryMethods = new HashSet<>();

    NotificationSettings settings = new NotificationSettings();
    settings.setDeliveryMethodsConfigs(new HashMap<>());

    NotificationSettings systemSettings = new NotificationSettings();
    systemSettings.setDeliveryMethodsConfigs(new HashMap<>());

    // Act
    NotificationProcessingContext actualNotificationProcessingContext = new NotificationProcessingContext(tenantId,
        notificationRequest, deliveryMethods, notificationTemplate, settings, systemSettings);

    // Assert
    verify(notificationRequest, atLeast(1)).getInfo();
    verify(notificationInfo).getTemplateData();
    verify(emailDeliveryMethodNotificationTemplate).isEnabled();
    verify(emailDeliveryMethodNotificationTemplate).copy();
    verify(notificationTemplate).getConfiguration();
    verify(notificationTemplate).getNotificationType();
    verify(notificationTemplateConfig).getDeliveryMethodsTemplates();
    NotificationRequestStats stats = actualNotificationProcessingContext.getStats();
    assertNull(stats.getError());
    assertEquals(NotificationType.GENERAL, actualNotificationProcessingContext.getNotificationType());
    assertTrue(stats.getErrors().isEmpty());
    assertTrue(stats.getProcessedRecipients().isEmpty());
    assertTrue(stats.getSent().isEmpty());
    assertTrue(actualNotificationProcessingContext.getDeliveryMethods().isEmpty());
    assertSame(tenantId, actualNotificationProcessingContext.getTenantId());
    assertSame(notificationRequest, actualNotificationProcessingContext.getRequest());
    assertSame(notificationTemplate, actualNotificationProcessingContext.getNotificationTemplate());
  }

  /**
   * Test {@link NotificationProcessingContext#NotificationProcessingContext(TenantId, NotificationRequest, Set, NotificationTemplate, NotificationSettings, NotificationSettings)}.
   * <ul>
   *   <li>Given {@code EMAIL}.</li>
   *   <li>When {@link HashSet#HashSet()} add {@code EMAIL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationProcessingContext#NotificationProcessingContext(TenantId, NotificationRequest, Set, NotificationTemplate, NotificationSettings, NotificationSettings)}
   */
  @Test
  @DisplayName("Test new NotificationProcessingContext(TenantId, NotificationRequest, Set, NotificationTemplate, NotificationSettings, NotificationSettings); given 'EMAIL'; when HashSet() add 'EMAIL'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void NotificationProcessingContext.<init>(TenantId, NotificationRequest, Set, NotificationTemplate, NotificationSettings, NotificationSettings)"})
  void testNewNotificationProcessingContext_givenEmail_whenHashSetAddEmail() {
    // Arrange
    NotificationTemplateConfig notificationTemplateConfig = mock(NotificationTemplateConfig.class);
    when(notificationTemplateConfig.getDeliveryMethodsTemplates()).thenReturn(new HashMap<>());
    when(notificationTemplate.getNotificationType()).thenReturn(NotificationType.GENERAL);
    when(notificationTemplate.getConfiguration()).thenReturn(notificationTemplateConfig);
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    HashSet<NotificationDeliveryMethod> deliveryMethods = new HashSet<>();
    deliveryMethods.add(NotificationDeliveryMethod.EMAIL);
    deliveryMethods.add(NotificationDeliveryMethod.WEB);

    NotificationSettings settings = new NotificationSettings();
    settings.setDeliveryMethodsConfigs(new HashMap<>());

    NotificationSettings systemSettings = new NotificationSettings();
    systemSettings.setDeliveryMethodsConfigs(new HashMap<>());

    // Act
    NotificationProcessingContext actualNotificationProcessingContext = new NotificationProcessingContext(tenantId,
        notificationRequest, deliveryMethods, notificationTemplate, settings, systemSettings);

    // Assert
    verify(notificationTemplate).getConfiguration();
    verify(notificationTemplate).getNotificationType();
    verify(notificationTemplateConfig).getDeliveryMethodsTemplates();
    NotificationRequestStats stats = actualNotificationProcessingContext.getStats();
    assertNull(stats.getError());
    assertEquals(NotificationType.GENERAL, actualNotificationProcessingContext.getNotificationType());
    assertTrue(stats.getErrors().isEmpty());
    assertTrue(stats.getProcessedRecipients().isEmpty());
    assertTrue(stats.getSent().isEmpty());
    assertSame(deliveryMethods, actualNotificationProcessingContext.getDeliveryMethods());
    assertSame(tenantId, actualNotificationProcessingContext.getTenantId());
    assertSame(notificationRequest, actualNotificationProcessingContext.getRequest());
    assertSame(notificationTemplate, actualNotificationProcessingContext.getNotificationTemplate());
  }

  /**
   * Test {@link NotificationProcessingContext#NotificationProcessingContext(TenantId, NotificationRequest, Set, NotificationTemplate, NotificationSettings, NotificationSettings)}.
   * <ul>
   *   <li>Given {@link NotificationRequest}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationProcessingContext#NotificationProcessingContext(TenantId, NotificationRequest, Set, NotificationTemplate, NotificationSettings, NotificationSettings)}
   */
  @Test
  @DisplayName("Test new NotificationProcessingContext(TenantId, NotificationRequest, Set, NotificationTemplate, NotificationSettings, NotificationSettings); given NotificationRequest")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void NotificationProcessingContext.<init>(TenantId, NotificationRequest, Set, NotificationTemplate, NotificationSettings, NotificationSettings)"})
  void testNewNotificationProcessingContext_givenNotificationRequest() {
    // Arrange
    NotificationTemplateConfig notificationTemplateConfig = mock(NotificationTemplateConfig.class);
    when(notificationTemplateConfig.getDeliveryMethodsTemplates()).thenReturn(new HashMap<>());
    when(notificationTemplate.getNotificationType()).thenReturn(NotificationType.GENERAL);
    when(notificationTemplate.getConfiguration()).thenReturn(notificationTemplateConfig);
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    HashSet<NotificationDeliveryMethod> deliveryMethods = new HashSet<>();

    NotificationSettings settings = new NotificationSettings();
    settings.setDeliveryMethodsConfigs(new HashMap<>());

    NotificationSettings systemSettings = new NotificationSettings();
    systemSettings.setDeliveryMethodsConfigs(new HashMap<>());

    // Act
    NotificationProcessingContext actualNotificationProcessingContext = new NotificationProcessingContext(tenantId,
        notificationRequest, deliveryMethods, notificationTemplate, settings, systemSettings);

    // Assert
    verify(notificationTemplate).getConfiguration();
    verify(notificationTemplate).getNotificationType();
    verify(notificationTemplateConfig).getDeliveryMethodsTemplates();
    NotificationRequestStats stats = actualNotificationProcessingContext.getStats();
    assertNull(stats.getError());
    assertEquals(NotificationType.GENERAL, actualNotificationProcessingContext.getNotificationType());
    assertTrue(stats.getErrors().isEmpty());
    assertTrue(stats.getProcessedRecipients().isEmpty());
    assertTrue(stats.getSent().isEmpty());
    assertTrue(actualNotificationProcessingContext.getDeliveryMethods().isEmpty());
    assertSame(tenantId, actualNotificationProcessingContext.getTenantId());
    assertSame(notificationRequest, actualNotificationProcessingContext.getRequest());
    assertSame(notificationTemplate, actualNotificationProcessingContext.getNotificationTemplate());
  }

  /**
   * Test {@link NotificationProcessingContext#NotificationProcessingContext(TenantId, NotificationRequest, Set, NotificationTemplate, NotificationSettings, NotificationSettings)}.
   * <ul>
   *   <li>Given {@link Supplier} {@link Supplier#get()} return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationProcessingContext#NotificationProcessingContext(TenantId, NotificationRequest, Set, NotificationTemplate, NotificationSettings, NotificationSettings)}
   */
  @Test
  @DisplayName("Test new NotificationProcessingContext(TenantId, NotificationRequest, Set, NotificationTemplate, NotificationSettings, NotificationSettings); given Supplier get() return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void NotificationProcessingContext.<init>(TenantId, NotificationRequest, Set, NotificationTemplate, NotificationSettings, NotificationSettings)"})
  void testNewNotificationProcessingContext_givenSupplierGetReturnEmptyString() {
    // Arrange
    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("foo", "foo");
    NotificationInfo notificationInfo = mock(NotificationInfo.class);
    when(notificationInfo.getTemplateData()).thenReturn(stringStringMap);
    when(notificationRequest.getInfo()).thenReturn(notificationInfo);
    Supplier<String> getter = mock(Supplier.class);
    when(getter.get()).thenReturn("");
    TemplatableValue templatableValue = new TemplatableValue(getter, mock(Consumer.class));

    ArrayList<TemplatableValue> templatableValueList = new ArrayList<>();
    templatableValueList.add(templatableValue);
    EmailDeliveryMethodNotificationTemplate emailDeliveryMethodNotificationTemplate = mock(
        EmailDeliveryMethodNotificationTemplate.class);
    when(emailDeliveryMethodNotificationTemplate.getTemplatableValues()).thenReturn(templatableValueList);
    EmailDeliveryMethodNotificationTemplate emailDeliveryMethodNotificationTemplate2 = mock(
        EmailDeliveryMethodNotificationTemplate.class);
    when(emailDeliveryMethodNotificationTemplate2.copy()).thenReturn(emailDeliveryMethodNotificationTemplate);
    when(emailDeliveryMethodNotificationTemplate2.isEnabled()).thenReturn(true);

    HashMap<NotificationDeliveryMethod, DeliveryMethodNotificationTemplate> notificationDeliveryMethodDeliveryMethodNotificationTemplateMap = new HashMap<>();
    notificationDeliveryMethodDeliveryMethodNotificationTemplateMap.put(NotificationDeliveryMethod.WEB,
        emailDeliveryMethodNotificationTemplate2);
    NotificationTemplateConfig notificationTemplateConfig = mock(NotificationTemplateConfig.class);
    when(notificationTemplateConfig.getDeliveryMethodsTemplates())
        .thenReturn(notificationDeliveryMethodDeliveryMethodNotificationTemplateMap);
    when(notificationTemplate.getNotificationType()).thenReturn(NotificationType.GENERAL);
    when(notificationTemplate.getConfiguration()).thenReturn(notificationTemplateConfig);
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    HashSet<NotificationDeliveryMethod> deliveryMethods = new HashSet<>();

    NotificationSettings settings = new NotificationSettings();
    settings.setDeliveryMethodsConfigs(new HashMap<>());

    NotificationSettings systemSettings = new NotificationSettings();
    systemSettings.setDeliveryMethodsConfigs(new HashMap<>());

    // Act
    NotificationProcessingContext actualNotificationProcessingContext = new NotificationProcessingContext(tenantId,
        notificationRequest, deliveryMethods, notificationTemplate, settings, systemSettings);

    // Assert
    verify(getter).get();
    verify(notificationRequest, atLeast(1)).getInfo();
    verify(notificationInfo).getTemplateData();
    verify(emailDeliveryMethodNotificationTemplate2).isEnabled();
    verify(emailDeliveryMethodNotificationTemplate2).copy();
    verify(emailDeliveryMethodNotificationTemplate).getTemplatableValues();
    verify(notificationTemplate).getConfiguration();
    verify(notificationTemplate).getNotificationType();
    verify(notificationTemplateConfig).getDeliveryMethodsTemplates();
    NotificationRequestStats stats = actualNotificationProcessingContext.getStats();
    assertNull(stats.getError());
    assertEquals(NotificationType.GENERAL, actualNotificationProcessingContext.getNotificationType());
    assertTrue(stats.getErrors().isEmpty());
    assertTrue(stats.getProcessedRecipients().isEmpty());
    assertTrue(stats.getSent().isEmpty());
    assertTrue(actualNotificationProcessingContext.getDeliveryMethods().isEmpty());
    assertSame(tenantId, actualNotificationProcessingContext.getTenantId());
    assertSame(notificationRequest, actualNotificationProcessingContext.getRequest());
    assertSame(notificationTemplate, actualNotificationProcessingContext.getNotificationTemplate());
  }

  /**
   * Test {@link NotificationProcessingContext#NotificationProcessingContext(TenantId, NotificationRequest, Set, NotificationTemplate, NotificationSettings, NotificationSettings)}.
   * <ul>
   *   <li>Given {@link Supplier} {@link Supplier#get()} return {@code Get}.</li>
   *   <li>Then calls {@link Consumer#accept(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationProcessingContext#NotificationProcessingContext(TenantId, NotificationRequest, Set, NotificationTemplate, NotificationSettings, NotificationSettings)}
   */
  @Test
  @DisplayName("Test new NotificationProcessingContext(TenantId, NotificationRequest, Set, NotificationTemplate, NotificationSettings, NotificationSettings); given Supplier get() return 'Get'; then calls accept(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void NotificationProcessingContext.<init>(TenantId, NotificationRequest, Set, NotificationTemplate, NotificationSettings, NotificationSettings)"})
  void testNewNotificationProcessingContext_givenSupplierGetReturnGet_thenCallsAccept() {
    // Arrange
    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("foo", "foo");
    NotificationInfo notificationInfo = mock(NotificationInfo.class);
    when(notificationInfo.getTemplateData()).thenReturn(stringStringMap);
    when(notificationRequest.getInfo()).thenReturn(notificationInfo);
    Supplier<String> getter = mock(Supplier.class);
    when(getter.get()).thenReturn("Get");
    Consumer<String> setter = mock(Consumer.class);
    doNothing().when(setter).accept(Mockito.<String>any());
    TemplatableValue templatableValue = new TemplatableValue(getter, setter);

    ArrayList<TemplatableValue> templatableValueList = new ArrayList<>();
    templatableValueList.add(templatableValue);
    EmailDeliveryMethodNotificationTemplate emailDeliveryMethodNotificationTemplate = mock(
        EmailDeliveryMethodNotificationTemplate.class);
    when(emailDeliveryMethodNotificationTemplate.getTemplatableValues()).thenReturn(templatableValueList);
    EmailDeliveryMethodNotificationTemplate emailDeliveryMethodNotificationTemplate2 = mock(
        EmailDeliveryMethodNotificationTemplate.class);
    when(emailDeliveryMethodNotificationTemplate2.copy()).thenReturn(emailDeliveryMethodNotificationTemplate);
    when(emailDeliveryMethodNotificationTemplate2.isEnabled()).thenReturn(true);

    HashMap<NotificationDeliveryMethod, DeliveryMethodNotificationTemplate> notificationDeliveryMethodDeliveryMethodNotificationTemplateMap = new HashMap<>();
    notificationDeliveryMethodDeliveryMethodNotificationTemplateMap.put(NotificationDeliveryMethod.WEB,
        emailDeliveryMethodNotificationTemplate2);
    NotificationTemplateConfig notificationTemplateConfig = mock(NotificationTemplateConfig.class);
    when(notificationTemplateConfig.getDeliveryMethodsTemplates())
        .thenReturn(notificationDeliveryMethodDeliveryMethodNotificationTemplateMap);
    when(notificationTemplate.getNotificationType()).thenReturn(NotificationType.GENERAL);
    when(notificationTemplate.getConfiguration()).thenReturn(notificationTemplateConfig);
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    HashSet<NotificationDeliveryMethod> deliveryMethods = new HashSet<>();

    NotificationSettings settings = new NotificationSettings();
    settings.setDeliveryMethodsConfigs(new HashMap<>());

    NotificationSettings systemSettings = new NotificationSettings();
    systemSettings.setDeliveryMethodsConfigs(new HashMap<>());

    // Act
    NotificationProcessingContext actualNotificationProcessingContext = new NotificationProcessingContext(tenantId,
        notificationRequest, deliveryMethods, notificationTemplate, settings, systemSettings);

    // Assert
    verify(setter).accept(eq("Get"));
    verify(getter).get();
    verify(notificationRequest, atLeast(1)).getInfo();
    verify(notificationInfo).getTemplateData();
    verify(emailDeliveryMethodNotificationTemplate2).isEnabled();
    verify(emailDeliveryMethodNotificationTemplate2).copy();
    verify(emailDeliveryMethodNotificationTemplate).getTemplatableValues();
    verify(notificationTemplate).getConfiguration();
    verify(notificationTemplate).getNotificationType();
    verify(notificationTemplateConfig).getDeliveryMethodsTemplates();
    NotificationRequestStats stats = actualNotificationProcessingContext.getStats();
    assertNull(stats.getError());
    assertEquals(NotificationType.GENERAL, actualNotificationProcessingContext.getNotificationType());
    assertTrue(stats.getErrors().isEmpty());
    assertTrue(stats.getProcessedRecipients().isEmpty());
    assertTrue(stats.getSent().isEmpty());
    assertTrue(actualNotificationProcessingContext.getDeliveryMethods().isEmpty());
    assertSame(tenantId, actualNotificationProcessingContext.getTenantId());
    assertSame(notificationRequest, actualNotificationProcessingContext.getRequest());
    assertSame(notificationTemplate, actualNotificationProcessingContext.getNotificationTemplate());
  }

  /**
   * Test {@link NotificationProcessingContext#NotificationProcessingContext(TenantId, NotificationRequest, Set, NotificationTemplate, NotificationSettings, NotificationSettings)}.
   * <ul>
   *   <li>Given {@link Supplier} {@link Supplier#get()} return {@code ${UUU:U}}.</li>
   *   <li>Then calls {@link Consumer#accept(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationProcessingContext#NotificationProcessingContext(TenantId, NotificationRequest, Set, NotificationTemplate, NotificationSettings, NotificationSettings)}
   */
  @Test
  @DisplayName("Test new NotificationProcessingContext(TenantId, NotificationRequest, Set, NotificationTemplate, NotificationSettings, NotificationSettings); given Supplier get() return '${UUU:U}'; then calls accept(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void NotificationProcessingContext.<init>(TenantId, NotificationRequest, Set, NotificationTemplate, NotificationSettings, NotificationSettings)"})
  void testNewNotificationProcessingContext_givenSupplierGetReturnUuuU_thenCallsAccept() {
    // Arrange
    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("foo", "foo");
    NotificationInfo notificationInfo = mock(NotificationInfo.class);
    when(notificationInfo.getTemplateData()).thenReturn(stringStringMap);
    when(notificationRequest.getInfo()).thenReturn(notificationInfo);
    Supplier<String> getter = mock(Supplier.class);
    when(getter.get()).thenReturn("${UUU:U}");
    Consumer<String> setter = mock(Consumer.class);
    doNothing().when(setter).accept(Mockito.<String>any());
    TemplatableValue templatableValue = new TemplatableValue(getter, setter);

    ArrayList<TemplatableValue> templatableValueList = new ArrayList<>();
    templatableValueList.add(templatableValue);
    EmailDeliveryMethodNotificationTemplate emailDeliveryMethodNotificationTemplate = mock(
        EmailDeliveryMethodNotificationTemplate.class);
    when(emailDeliveryMethodNotificationTemplate.getTemplatableValues()).thenReturn(templatableValueList);
    EmailDeliveryMethodNotificationTemplate emailDeliveryMethodNotificationTemplate2 = mock(
        EmailDeliveryMethodNotificationTemplate.class);
    when(emailDeliveryMethodNotificationTemplate2.copy()).thenReturn(emailDeliveryMethodNotificationTemplate);
    when(emailDeliveryMethodNotificationTemplate2.isEnabled()).thenReturn(true);

    HashMap<NotificationDeliveryMethod, DeliveryMethodNotificationTemplate> notificationDeliveryMethodDeliveryMethodNotificationTemplateMap = new HashMap<>();
    notificationDeliveryMethodDeliveryMethodNotificationTemplateMap.put(NotificationDeliveryMethod.WEB,
        emailDeliveryMethodNotificationTemplate2);
    NotificationTemplateConfig notificationTemplateConfig = mock(NotificationTemplateConfig.class);
    when(notificationTemplateConfig.getDeliveryMethodsTemplates())
        .thenReturn(notificationDeliveryMethodDeliveryMethodNotificationTemplateMap);
    when(notificationTemplate.getNotificationType()).thenReturn(NotificationType.GENERAL);
    when(notificationTemplate.getConfiguration()).thenReturn(notificationTemplateConfig);
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    HashSet<NotificationDeliveryMethod> deliveryMethods = new HashSet<>();

    NotificationSettings settings = new NotificationSettings();
    settings.setDeliveryMethodsConfigs(new HashMap<>());

    NotificationSettings systemSettings = new NotificationSettings();
    systemSettings.setDeliveryMethodsConfigs(new HashMap<>());

    // Act
    NotificationProcessingContext actualNotificationProcessingContext = new NotificationProcessingContext(tenantId,
        notificationRequest, deliveryMethods, notificationTemplate, settings, systemSettings);

    // Assert
    verify(setter).accept(eq("${UUU:U}"));
    verify(getter).get();
    verify(notificationRequest, atLeast(1)).getInfo();
    verify(notificationInfo).getTemplateData();
    verify(emailDeliveryMethodNotificationTemplate2).isEnabled();
    verify(emailDeliveryMethodNotificationTemplate2).copy();
    verify(emailDeliveryMethodNotificationTemplate).getTemplatableValues();
    verify(notificationTemplate).getConfiguration();
    verify(notificationTemplate).getNotificationType();
    verify(notificationTemplateConfig).getDeliveryMethodsTemplates();
    NotificationRequestStats stats = actualNotificationProcessingContext.getStats();
    assertNull(stats.getError());
    assertEquals(NotificationType.GENERAL, actualNotificationProcessingContext.getNotificationType());
    assertTrue(stats.getErrors().isEmpty());
    assertTrue(stats.getProcessedRecipients().isEmpty());
    assertTrue(stats.getSent().isEmpty());
    assertTrue(actualNotificationProcessingContext.getDeliveryMethods().isEmpty());
    assertSame(tenantId, actualNotificationProcessingContext.getTenantId());
    assertSame(notificationRequest, actualNotificationProcessingContext.getRequest());
    assertSame(notificationTemplate, actualNotificationProcessingContext.getNotificationTemplate());
  }

  /**
   * Test {@link NotificationProcessingContext#NotificationProcessingContext(TenantId, NotificationRequest, Set, NotificationTemplate, NotificationSettings, NotificationSettings)}.
   * <ul>
   *   <li>Given {@code WEB}.</li>
   *   <li>Then return DeliveryMethods is {@link HashSet#HashSet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationProcessingContext#NotificationProcessingContext(TenantId, NotificationRequest, Set, NotificationTemplate, NotificationSettings, NotificationSettings)}
   */
  @Test
  @DisplayName("Test new NotificationProcessingContext(TenantId, NotificationRequest, Set, NotificationTemplate, NotificationSettings, NotificationSettings); given 'WEB'; then return DeliveryMethods is HashSet()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void NotificationProcessingContext.<init>(TenantId, NotificationRequest, Set, NotificationTemplate, NotificationSettings, NotificationSettings)"})
  void testNewNotificationProcessingContext_givenWeb_thenReturnDeliveryMethodsIsHashSet() {
    // Arrange
    NotificationTemplateConfig notificationTemplateConfig = mock(NotificationTemplateConfig.class);
    when(notificationTemplateConfig.getDeliveryMethodsTemplates()).thenReturn(new HashMap<>());
    when(notificationTemplate.getNotificationType()).thenReturn(NotificationType.GENERAL);
    when(notificationTemplate.getConfiguration()).thenReturn(notificationTemplateConfig);
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    HashSet<NotificationDeliveryMethod> deliveryMethods = new HashSet<>();
    deliveryMethods.add(NotificationDeliveryMethod.WEB);

    NotificationSettings settings = new NotificationSettings();
    settings.setDeliveryMethodsConfigs(new HashMap<>());

    NotificationSettings systemSettings = new NotificationSettings();
    systemSettings.setDeliveryMethodsConfigs(new HashMap<>());

    // Act
    NotificationProcessingContext actualNotificationProcessingContext = new NotificationProcessingContext(tenantId,
        notificationRequest, deliveryMethods, notificationTemplate, settings, systemSettings);

    // Assert
    verify(notificationTemplate).getConfiguration();
    verify(notificationTemplate).getNotificationType();
    verify(notificationTemplateConfig).getDeliveryMethodsTemplates();
    NotificationRequestStats stats = actualNotificationProcessingContext.getStats();
    assertNull(stats.getError());
    assertEquals(NotificationType.GENERAL, actualNotificationProcessingContext.getNotificationType());
    assertTrue(stats.getErrors().isEmpty());
    assertTrue(stats.getProcessedRecipients().isEmpty());
    assertTrue(stats.getSent().isEmpty());
    assertSame(deliveryMethods, actualNotificationProcessingContext.getDeliveryMethods());
    assertSame(tenantId, actualNotificationProcessingContext.getTenantId());
    assertSame(notificationRequest, actualNotificationProcessingContext.getRequest());
    assertSame(notificationTemplate, actualNotificationProcessingContext.getNotificationTemplate());
  }

  /**
   * Test {@link NotificationProcessingContext#NotificationProcessingContext(TenantId, NotificationRequest, Set, NotificationTemplate, NotificationSettings, NotificationSettings)}.
   * <ul>
   *   <li>Then calls {@link TemplatableValue#get()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationProcessingContext#NotificationProcessingContext(TenantId, NotificationRequest, Set, NotificationTemplate, NotificationSettings, NotificationSettings)}
   */
  @Test
  @DisplayName("Test new NotificationProcessingContext(TenantId, NotificationRequest, Set, NotificationTemplate, NotificationSettings, NotificationSettings); then calls get()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void NotificationProcessingContext.<init>(TenantId, NotificationRequest, Set, NotificationTemplate, NotificationSettings, NotificationSettings)"})
  void testNewNotificationProcessingContext_thenCallsGet() {
    // Arrange
    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("foo", "foo");
    NotificationInfo notificationInfo = mock(NotificationInfo.class);
    when(notificationInfo.getTemplateData()).thenReturn(stringStringMap);
    when(notificationRequest.getInfo()).thenReturn(notificationInfo);
    TemplatableValue templatableValue = mock(TemplatableValue.class);
    doNothing().when(templatableValue).set(Mockito.<String>any());
    when(templatableValue.get()).thenReturn("Get");

    ArrayList<TemplatableValue> templatableValueList = new ArrayList<>();
    templatableValueList.add(templatableValue);
    EmailDeliveryMethodNotificationTemplate emailDeliveryMethodNotificationTemplate = mock(
        EmailDeliveryMethodNotificationTemplate.class);
    when(emailDeliveryMethodNotificationTemplate.getTemplatableValues()).thenReturn(templatableValueList);
    EmailDeliveryMethodNotificationTemplate emailDeliveryMethodNotificationTemplate2 = mock(
        EmailDeliveryMethodNotificationTemplate.class);
    when(emailDeliveryMethodNotificationTemplate2.copy()).thenReturn(emailDeliveryMethodNotificationTemplate);
    when(emailDeliveryMethodNotificationTemplate2.isEnabled()).thenReturn(true);

    HashMap<NotificationDeliveryMethod, DeliveryMethodNotificationTemplate> notificationDeliveryMethodDeliveryMethodNotificationTemplateMap = new HashMap<>();
    notificationDeliveryMethodDeliveryMethodNotificationTemplateMap.put(NotificationDeliveryMethod.WEB,
        emailDeliveryMethodNotificationTemplate2);
    NotificationTemplateConfig notificationTemplateConfig = mock(NotificationTemplateConfig.class);
    when(notificationTemplateConfig.getDeliveryMethodsTemplates())
        .thenReturn(notificationDeliveryMethodDeliveryMethodNotificationTemplateMap);
    when(notificationTemplate.getNotificationType()).thenReturn(NotificationType.GENERAL);
    when(notificationTemplate.getConfiguration()).thenReturn(notificationTemplateConfig);
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    HashSet<NotificationDeliveryMethod> deliveryMethods = new HashSet<>();

    NotificationSettings settings = new NotificationSettings();
    settings.setDeliveryMethodsConfigs(new HashMap<>());

    NotificationSettings systemSettings = new NotificationSettings();
    systemSettings.setDeliveryMethodsConfigs(new HashMap<>());

    // Act
    NotificationProcessingContext actualNotificationProcessingContext = new NotificationProcessingContext(tenantId,
        notificationRequest, deliveryMethods, notificationTemplate, settings, systemSettings);

    // Assert
    verify(notificationRequest, atLeast(1)).getInfo();
    verify(notificationInfo).getTemplateData();
    verify(emailDeliveryMethodNotificationTemplate2).isEnabled();
    verify(emailDeliveryMethodNotificationTemplate2).copy();
    verify(emailDeliveryMethodNotificationTemplate).getTemplatableValues();
    verify(notificationTemplate).getConfiguration();
    verify(notificationTemplate).getNotificationType();
    verify(notificationTemplateConfig).getDeliveryMethodsTemplates();
    verify(templatableValue).get();
    verify(templatableValue).set(eq("Get"));
    NotificationRequestStats stats = actualNotificationProcessingContext.getStats();
    assertNull(stats.getError());
    assertEquals(NotificationType.GENERAL, actualNotificationProcessingContext.getNotificationType());
    assertTrue(stats.getErrors().isEmpty());
    assertTrue(stats.getProcessedRecipients().isEmpty());
    assertTrue(stats.getSent().isEmpty());
    assertTrue(actualNotificationProcessingContext.getDeliveryMethods().isEmpty());
    assertSame(tenantId, actualNotificationProcessingContext.getTenantId());
    assertSame(notificationRequest, actualNotificationProcessingContext.getRequest());
    assertSame(notificationTemplate, actualNotificationProcessingContext.getNotificationTemplate());
  }

  /**
   * Test {@link NotificationProcessingContext#NotificationProcessingContext(TenantId, NotificationRequest, Set, NotificationTemplate, NotificationSettings, NotificationSettings)}.
   * <ul>
   *   <li>Then calls {@link NotificationRequest#getInfo()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationProcessingContext#NotificationProcessingContext(TenantId, NotificationRequest, Set, NotificationTemplate, NotificationSettings, NotificationSettings)}
   */
  @Test
  @DisplayName("Test new NotificationProcessingContext(TenantId, NotificationRequest, Set, NotificationTemplate, NotificationSettings, NotificationSettings); then calls getInfo()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void NotificationProcessingContext.<init>(TenantId, NotificationRequest, Set, NotificationTemplate, NotificationSettings, NotificationSettings)"})
  void testNewNotificationProcessingContext_thenCallsGetInfo() {
    // Arrange
    NotificationInfo notificationInfo = mock(NotificationInfo.class);
    when(notificationInfo.getTemplateData()).thenReturn(new HashMap<>());
    when(notificationRequest.getInfo()).thenReturn(notificationInfo);
    EmailDeliveryMethodNotificationTemplate emailDeliveryMethodNotificationTemplate = mock(
        EmailDeliveryMethodNotificationTemplate.class);
    when(emailDeliveryMethodNotificationTemplate.isEnabled()).thenReturn(true);

    HashMap<NotificationDeliveryMethod, DeliveryMethodNotificationTemplate> notificationDeliveryMethodDeliveryMethodNotificationTemplateMap = new HashMap<>();
    notificationDeliveryMethodDeliveryMethodNotificationTemplateMap.put(NotificationDeliveryMethod.WEB,
        emailDeliveryMethodNotificationTemplate);
    NotificationTemplateConfig notificationTemplateConfig = mock(NotificationTemplateConfig.class);
    when(notificationTemplateConfig.getDeliveryMethodsTemplates())
        .thenReturn(notificationDeliveryMethodDeliveryMethodNotificationTemplateMap);
    when(notificationTemplate.getNotificationType()).thenReturn(NotificationType.GENERAL);
    when(notificationTemplate.getConfiguration()).thenReturn(notificationTemplateConfig);
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    HashSet<NotificationDeliveryMethod> deliveryMethods = new HashSet<>();

    NotificationSettings settings = new NotificationSettings();
    settings.setDeliveryMethodsConfigs(new HashMap<>());

    NotificationSettings systemSettings = new NotificationSettings();
    systemSettings.setDeliveryMethodsConfigs(new HashMap<>());

    // Act
    NotificationProcessingContext actualNotificationProcessingContext = new NotificationProcessingContext(tenantId,
        notificationRequest, deliveryMethods, notificationTemplate, settings, systemSettings);

    // Assert
    verify(notificationRequest, atLeast(1)).getInfo();
    verify(notificationInfo).getTemplateData();
    verify(emailDeliveryMethodNotificationTemplate).isEnabled();
    verify(notificationTemplate).getConfiguration();
    verify(notificationTemplate).getNotificationType();
    verify(notificationTemplateConfig).getDeliveryMethodsTemplates();
    NotificationRequestStats stats = actualNotificationProcessingContext.getStats();
    assertNull(stats.getError());
    assertEquals(NotificationType.GENERAL, actualNotificationProcessingContext.getNotificationType());
    assertTrue(stats.getErrors().isEmpty());
    assertTrue(stats.getProcessedRecipients().isEmpty());
    assertTrue(stats.getSent().isEmpty());
    assertTrue(actualNotificationProcessingContext.getDeliveryMethods().isEmpty());
    assertSame(tenantId, actualNotificationProcessingContext.getTenantId());
    assertSame(notificationRequest, actualNotificationProcessingContext.getRequest());
    assertSame(notificationTemplate, actualNotificationProcessingContext.getNotificationTemplate());
  }

  /**
   * Test {@link NotificationProcessingContext#NotificationProcessingContext(TenantId, NotificationRequest, Set, NotificationTemplate, NotificationSettings, NotificationSettings)}.
   * <ul>
   *   <li>Then calls {@link EmailDeliveryMethodNotificationTemplate#getTemplatableValues()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationProcessingContext#NotificationProcessingContext(TenantId, NotificationRequest, Set, NotificationTemplate, NotificationSettings, NotificationSettings)}
   */
  @Test
  @DisplayName("Test new NotificationProcessingContext(TenantId, NotificationRequest, Set, NotificationTemplate, NotificationSettings, NotificationSettings); then calls getTemplatableValues()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void NotificationProcessingContext.<init>(TenantId, NotificationRequest, Set, NotificationTemplate, NotificationSettings, NotificationSettings)"})
  void testNewNotificationProcessingContext_thenCallsGetTemplatableValues() {
    // Arrange
    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("foo", "foo");
    NotificationInfo notificationInfo = mock(NotificationInfo.class);
    when(notificationInfo.getTemplateData()).thenReturn(stringStringMap);
    when(notificationRequest.getInfo()).thenReturn(notificationInfo);
    EmailDeliveryMethodNotificationTemplate emailDeliveryMethodNotificationTemplate = mock(
        EmailDeliveryMethodNotificationTemplate.class);
    when(emailDeliveryMethodNotificationTemplate.getTemplatableValues()).thenReturn(new ArrayList<>());
    EmailDeliveryMethodNotificationTemplate emailDeliveryMethodNotificationTemplate2 = mock(
        EmailDeliveryMethodNotificationTemplate.class);
    when(emailDeliveryMethodNotificationTemplate2.copy()).thenReturn(emailDeliveryMethodNotificationTemplate);
    when(emailDeliveryMethodNotificationTemplate2.isEnabled()).thenReturn(true);

    HashMap<NotificationDeliveryMethod, DeliveryMethodNotificationTemplate> notificationDeliveryMethodDeliveryMethodNotificationTemplateMap = new HashMap<>();
    notificationDeliveryMethodDeliveryMethodNotificationTemplateMap.put(NotificationDeliveryMethod.WEB,
        emailDeliveryMethodNotificationTemplate2);
    NotificationTemplateConfig notificationTemplateConfig = mock(NotificationTemplateConfig.class);
    when(notificationTemplateConfig.getDeliveryMethodsTemplates())
        .thenReturn(notificationDeliveryMethodDeliveryMethodNotificationTemplateMap);
    when(notificationTemplate.getNotificationType()).thenReturn(NotificationType.GENERAL);
    when(notificationTemplate.getConfiguration()).thenReturn(notificationTemplateConfig);
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    HashSet<NotificationDeliveryMethod> deliveryMethods = new HashSet<>();

    NotificationSettings settings = new NotificationSettings();
    settings.setDeliveryMethodsConfigs(new HashMap<>());

    NotificationSettings systemSettings = new NotificationSettings();
    systemSettings.setDeliveryMethodsConfigs(new HashMap<>());

    // Act
    NotificationProcessingContext actualNotificationProcessingContext = new NotificationProcessingContext(tenantId,
        notificationRequest, deliveryMethods, notificationTemplate, settings, systemSettings);

    // Assert
    verify(notificationRequest, atLeast(1)).getInfo();
    verify(notificationInfo).getTemplateData();
    verify(emailDeliveryMethodNotificationTemplate2).isEnabled();
    verify(emailDeliveryMethodNotificationTemplate2).copy();
    verify(emailDeliveryMethodNotificationTemplate).getTemplatableValues();
    verify(notificationTemplate).getConfiguration();
    verify(notificationTemplate).getNotificationType();
    verify(notificationTemplateConfig).getDeliveryMethodsTemplates();
    NotificationRequestStats stats = actualNotificationProcessingContext.getStats();
    assertNull(stats.getError());
    assertEquals(NotificationType.GENERAL, actualNotificationProcessingContext.getNotificationType());
    assertTrue(stats.getErrors().isEmpty());
    assertTrue(stats.getProcessedRecipients().isEmpty());
    assertTrue(stats.getSent().isEmpty());
    assertTrue(actualNotificationProcessingContext.getDeliveryMethods().isEmpty());
    assertSame(tenantId, actualNotificationProcessingContext.getTenantId());
    assertSame(notificationRequest, actualNotificationProcessingContext.getRequest());
    assertSame(notificationTemplate, actualNotificationProcessingContext.getNotificationTemplate());
  }

  /**
   * Test {@link NotificationProcessingContext#NotificationProcessingContext(TenantId, NotificationRequest, Set, NotificationTemplate, NotificationSettings, NotificationSettings)}.
   * <ul>
   *   <li>Then return NotificationType is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationProcessingContext#NotificationProcessingContext(TenantId, NotificationRequest, Set, NotificationTemplate, NotificationSettings, NotificationSettings)}
   */
  @Test
  @DisplayName("Test new NotificationProcessingContext(TenantId, NotificationRequest, Set, NotificationTemplate, NotificationSettings, NotificationSettings); then return NotificationType is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void NotificationProcessingContext.<init>(TenantId, NotificationRequest, Set, NotificationTemplate, NotificationSettings, NotificationSettings)"})
  void testNewNotificationProcessingContext_thenReturnNotificationTypeIsNull() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    NotificationRequest request = new NotificationRequest();
    HashSet<NotificationDeliveryMethod> deliveryMethods = new HashSet<>();
    EmailDeliveryMethodNotificationTemplate emailDeliveryMethodNotificationTemplate = mock(
        EmailDeliveryMethodNotificationTemplate.class);
    when(emailDeliveryMethodNotificationTemplate.isEnabled()).thenReturn(true);

    HashMap<NotificationDeliveryMethod, DeliveryMethodNotificationTemplate> notificationDeliveryMethodDeliveryMethodNotificationTemplateMap = new HashMap<>();
    notificationDeliveryMethodDeliveryMethodNotificationTemplateMap.put(NotificationDeliveryMethod.WEB,
        emailDeliveryMethodNotificationTemplate);
    NotificationTemplateConfig configuration = mock(NotificationTemplateConfig.class);
    when(configuration.getDeliveryMethodsTemplates())
        .thenReturn(notificationDeliveryMethodDeliveryMethodNotificationTemplateMap);

    NotificationTemplate template = new NotificationTemplate();
    template.setConfiguration(configuration);

    NotificationSettings settings = new NotificationSettings();
    settings.setDeliveryMethodsConfigs(new HashMap<>());

    NotificationSettings systemSettings = new NotificationSettings();
    systemSettings.setDeliveryMethodsConfigs(new HashMap<>());

    // Act
    NotificationProcessingContext actualNotificationProcessingContext = new NotificationProcessingContext(tenantId,
        request, deliveryMethods, template, settings, systemSettings);

    // Assert
    verify(emailDeliveryMethodNotificationTemplate).isEnabled();
    verify(configuration).getDeliveryMethodsTemplates();
    assertNull(actualNotificationProcessingContext.getNotificationType());
    assertTrue(actualNotificationProcessingContext.getDeliveryMethods().isEmpty());
    assertSame(tenantId, actualNotificationProcessingContext.getTenantId());
    assertSame(request, actualNotificationProcessingContext.getRequest());
    assertSame(template, actualNotificationProcessingContext.getNotificationTemplate());
  }
}
