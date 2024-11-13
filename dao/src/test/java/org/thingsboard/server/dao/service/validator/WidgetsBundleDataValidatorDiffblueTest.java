package org.thingsboard.server.dao.service.validator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.UUID;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.WidgetsBundleId;
import org.thingsboard.server.common.data.widget.WidgetsBundle;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.tenant.TenantService;
import org.thingsboard.server.dao.usagerecord.ApiLimitService;
import org.thingsboard.server.dao.widget.WidgetsBundleDao;

@ContextConfiguration(classes = {WidgetsBundleDataValidator.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DisabledInAotMode
public class WidgetsBundleDataValidatorDiffblueTest {
  @MockBean
  private ApiLimitService apiLimitService;

  @MockBean
  private TenantService tenantService;

  @MockBean
  private WidgetsBundleDao widgetsBundleDao;

  @Autowired
  private WidgetsBundleDataValidator widgetsBundleDataValidator;

  /**
   * Test
   * {@link WidgetsBundleDataValidator#validateDataImpl(TenantId, WidgetsBundle)}
   * with {@code TenantId}, {@code WidgetsBundle}.
   * <p>
   * Method under test:
   * {@link WidgetsBundleDataValidator#validateDataImpl(TenantId, WidgetsBundle)}
   */
  @Test
  public void testValidateDataImplWithTenantIdWidgetsBundle() {
    // Arrange
    WidgetsBundle widgetsBundle = mock(WidgetsBundle.class);
    when(widgetsBundle.getTenantId()).thenThrow(new DataValidationException("An error occurred"));
    when(widgetsBundle.getTitle()).thenReturn("Dr");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> widgetsBundleDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, widgetsBundle));
    verify(widgetsBundle).getTenantId();
    verify(widgetsBundle).getTitle();
  }

  /**
   * Test
   * {@link WidgetsBundleDataValidator#validateDataImpl(TenantId, WidgetsBundle)}
   * with {@code TenantId}, {@code WidgetsBundle}.
   * <p>
   * Method under test:
   * {@link WidgetsBundleDataValidator#validateDataImpl(TenantId, WidgetsBundle)}
   */
  @Test
  public void testValidateDataImplWithTenantIdWidgetsBundle2() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);
    WidgetsBundle widgetsBundle = mock(WidgetsBundle.class);
    when(widgetsBundle.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    when(widgetsBundle.getTitle()).thenReturn("Dr");

    // Act
    widgetsBundleDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, widgetsBundle);

    // Assert that nothing has changed
    verify(widgetsBundle, atLeast(1)).getTenantId();
    verify(widgetsBundle).getTitle();
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test
   * {@link WidgetsBundleDataValidator#validateDataImpl(TenantId, WidgetsBundle)}
   * with {@code TenantId}, {@code WidgetsBundle}.
   * <p>
   * Method under test:
   * {@link WidgetsBundleDataValidator#validateDataImpl(TenantId, WidgetsBundle)}
   */
  @Test
  public void testValidateDataImplWithTenantIdWidgetsBundle3() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(false);
    WidgetsBundle widgetsBundle = mock(WidgetsBundle.class);
    when(widgetsBundle.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    when(widgetsBundle.getTitle()).thenReturn("Dr");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> widgetsBundleDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, widgetsBundle));
    verify(widgetsBundle, atLeast(1)).getTenantId();
    verify(widgetsBundle).getTitle();
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test
   * {@link WidgetsBundleDataValidator#validateDataImpl(TenantId, WidgetsBundle)}
   * with {@code TenantId}, {@code WidgetsBundle}.
   * <p>
   * Method under test:
   * {@link WidgetsBundleDataValidator#validateDataImpl(TenantId, WidgetsBundle)}
   */
  @Test
  public void testValidateDataImplWithTenantIdWidgetsBundle4() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any()))
        .thenThrow(new DataValidationException("An error occurred"));
    WidgetsBundle widgetsBundle = mock(WidgetsBundle.class);
    when(widgetsBundle.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    when(widgetsBundle.getTitle()).thenReturn("Dr");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> widgetsBundleDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, widgetsBundle));
    verify(widgetsBundle, atLeast(1)).getTenantId();
    verify(widgetsBundle).getTitle();
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test
   * {@link WidgetsBundleDataValidator#validateDataImpl(TenantId, WidgetsBundle)}
   * with {@code TenantId}, {@code WidgetsBundle}.
   * <ul>
   *   <li>Given {@link ModelConstants#SYSTEM_TENANT}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WidgetsBundleDataValidator#validateDataImpl(TenantId, WidgetsBundle)}
   */
  @Test
  public void testValidateDataImplWithTenantIdWidgetsBundle_givenSystem_tenant() {
    // Arrange
    WidgetsBundle widgetsBundle = mock(WidgetsBundle.class);
    when(widgetsBundle.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(widgetsBundle.getTitle()).thenReturn("Dr");

    // Act
    widgetsBundleDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, widgetsBundle);

    // Assert that nothing has changed
    verify(widgetsBundle, atLeast(1)).getTenantId();
    verify(widgetsBundle).getTitle();
  }

  /**
   * Test
   * {@link WidgetsBundleDataValidator#validateCreate(TenantId, WidgetsBundle)}
   * with {@code TenantId}, {@code WidgetsBundle}.
   * <p>
   * Method under test:
   * {@link WidgetsBundleDataValidator#validateCreate(TenantId, WidgetsBundle)}
   */
  @Test
  public void testValidateCreateWithTenantIdWidgetsBundle() {
    // Arrange
    WidgetsBundle widgetsBundle = mock(WidgetsBundle.class);
    when(widgetsBundle.getTenantId()).thenThrow(new DataValidationException("An error occurred"));
    when(widgetsBundle.getAlias()).thenReturn("Alias");
    doNothing().when(widgetsBundle).setTenantId(Mockito.<TenantId>any());
    doNothing().when(widgetsBundle).setTitle(Mockito.<String>any());
    widgetsBundle.setTenantId(ModelConstants.SYSTEM_TENANT);
    widgetsBundle.setTitle(" ");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> widgetsBundleDataValidator.validateCreate(ModelConstants.SYSTEM_TENANT, widgetsBundle));
    verify(widgetsBundle).getAlias();
    verify(widgetsBundle).getTenantId();
    verify(widgetsBundle).setTenantId(isA(TenantId.class));
    verify(widgetsBundle).setTitle(eq(" "));
  }

  /**
   * Test
   * {@link WidgetsBundleDataValidator#validateCreate(TenantId, WidgetsBundle)}
   * with {@code TenantId}, {@code WidgetsBundle}.
   * <ul>
   *   <li>Given {@code Alias}.</li>
   *   <li>Then calls {@link WidgetsBundle#setAlias(String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WidgetsBundleDataValidator#validateCreate(TenantId, WidgetsBundle)}
   */
  @Test
  public void testValidateCreateWithTenantIdWidgetsBundle_givenAlias_thenCallsSetAlias() {
    // Arrange
    when(widgetsBundleDao.findWidgetsBundleByTenantIdAndAlias(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(null);
    WidgetsBundle widgetsBundle = mock(WidgetsBundle.class);
    doThrow(new DataValidationException("An error occurred")).when(widgetsBundle).setAlias(Mockito.<String>any());
    when(widgetsBundle.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(widgetsBundle.getAlias()).thenReturn("Alias");
    doNothing().when(widgetsBundle).setTenantId(Mockito.<TenantId>any());
    doNothing().when(widgetsBundle).setTitle(Mockito.<String>any());
    widgetsBundle.setTenantId(ModelConstants.SYSTEM_TENANT);
    widgetsBundle.setTitle(" ");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> widgetsBundleDataValidator.validateCreate(ModelConstants.SYSTEM_TENANT, widgetsBundle));
    verify(widgetsBundle).getAlias();
    verify(widgetsBundle).getTenantId();
    verify(widgetsBundle).setAlias(eq("Alias"));
    verify(widgetsBundle).setTenantId(isA(TenantId.class));
    verify(widgetsBundle).setTitle(eq(" "));
    verify(widgetsBundleDao).findWidgetsBundleByTenantIdAndAlias(isA(UUID.class), eq("Alias"));
  }

  /**
   * Test
   * {@link WidgetsBundleDataValidator#validateCreate(TenantId, WidgetsBundle)}
   * with {@code TenantId}, {@code WidgetsBundle}.
   * <ul>
   *   <li>Given empty string.</li>
   *   <li>Then calls {@link WidgetsBundle#getTitle()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WidgetsBundleDataValidator#validateCreate(TenantId, WidgetsBundle)}
   */
  @Test
  public void testValidateCreateWithTenantIdWidgetsBundle_givenEmptyString_thenCallsGetTitle() {
    // Arrange
    when(widgetsBundleDao.findWidgetsBundleByTenantIdAndAlias(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(null);
    WidgetsBundle widgetsBundle = mock(WidgetsBundle.class);
    doThrow(new DataValidationException("An error occurred")).when(widgetsBundle).setAlias(Mockito.<String>any());
    when(widgetsBundle.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(widgetsBundle.getAlias()).thenReturn("");
    when(widgetsBundle.getTitle()).thenReturn("Dr");
    doNothing().when(widgetsBundle).setTenantId(Mockito.<TenantId>any());
    doNothing().when(widgetsBundle).setTitle(Mockito.<String>any());
    widgetsBundle.setTenantId(ModelConstants.SYSTEM_TENANT);
    widgetsBundle.setTitle(" ");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> widgetsBundleDataValidator.validateCreate(ModelConstants.SYSTEM_TENANT, widgetsBundle));
    verify(widgetsBundle).getAlias();
    verify(widgetsBundle).getTenantId();
    verify(widgetsBundle).getTitle();
    verify(widgetsBundle).setAlias(eq("dr"));
    verify(widgetsBundle).setTenantId(isA(TenantId.class));
    verify(widgetsBundle).setTitle(eq(" "));
    verify(widgetsBundleDao).findWidgetsBundleByTenantIdAndAlias(isA(UUID.class), eq("dr"));
  }

  /**
   * Test
   * {@link WidgetsBundleDataValidator#validateCreate(TenantId, WidgetsBundle)}
   * with {@code TenantId}, {@code WidgetsBundle}.
   * <ul>
   *   <li>Given {@code \W+}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WidgetsBundleDataValidator#validateCreate(TenantId, WidgetsBundle)}
   */
  @Test
  public void testValidateCreateWithTenantIdWidgetsBundle_givenW() {
    // Arrange
    when(widgetsBundleDao.findWidgetsBundleByTenantIdAndAlias(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(null);
    WidgetsBundle widgetsBundle = mock(WidgetsBundle.class);
    doThrow(new DataValidationException("An error occurred")).when(widgetsBundle).setAlias(Mockito.<String>any());
    when(widgetsBundle.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(widgetsBundle.getAlias()).thenReturn("");
    when(widgetsBundle.getTitle()).thenReturn("\\W+");
    doNothing().when(widgetsBundle).setTenantId(Mockito.<TenantId>any());
    doNothing().when(widgetsBundle).setTitle(Mockito.<String>any());
    widgetsBundle.setTenantId(ModelConstants.SYSTEM_TENANT);
    widgetsBundle.setTitle(" ");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> widgetsBundleDataValidator.validateCreate(ModelConstants.SYSTEM_TENANT, widgetsBundle));
    verify(widgetsBundle).getAlias();
    verify(widgetsBundle).getTenantId();
    verify(widgetsBundle).getTitle();
    verify(widgetsBundle).setAlias(eq("_w_"));
    verify(widgetsBundle).setTenantId(isA(TenantId.class));
    verify(widgetsBundle).setTitle(eq(" "));
    verify(widgetsBundleDao).findWidgetsBundleByTenantIdAndAlias(isA(UUID.class), eq("_w_"));
  }

  /**
   * Test
   * {@link WidgetsBundleDataValidator#validateCreate(TenantId, WidgetsBundle)}
   * with {@code TenantId}, {@code WidgetsBundle}.
   * <ul>
   *   <li>Then {@link WidgetsBundle#WidgetsBundle()} Alias is {@code _}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WidgetsBundleDataValidator#validateCreate(TenantId, WidgetsBundle)}
   */
  @Test
  public void testValidateCreateWithTenantIdWidgetsBundle_thenWidgetsBundleAliasIsUnderscore() {
    // Arrange
    when(widgetsBundleDao.findWidgetsBundleByTenantIdAndAlias(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(null);

    WidgetsBundle widgetsBundle = new WidgetsBundle();
    widgetsBundle.setTenantId(ModelConstants.SYSTEM_TENANT);
    widgetsBundle.setTitle(" ");

    // Act
    widgetsBundleDataValidator.validateCreate(ModelConstants.SYSTEM_TENANT, widgetsBundle);

    // Assert
    verify(widgetsBundleDao).findWidgetsBundleByTenantIdAndAlias(isA(UUID.class), eq("_"));
    assertEquals("_", widgetsBundle.getAlias());
  }

  /**
   * Test
   * {@link WidgetsBundleDataValidator#validateUpdate(TenantId, WidgetsBundle)}
   * with {@code TenantId}, {@code WidgetsBundle}.
   * <p>
   * Method under test:
   * {@link WidgetsBundleDataValidator#validateUpdate(TenantId, WidgetsBundle)}
   */
  @Test
  public void testValidateUpdateWithTenantIdWidgetsBundle() {
    // Arrange
    WidgetsBundle widgetsBundle = new WidgetsBundle();
    widgetsBundle.setTenantId(new TenantId(UUID.randomUUID()));
    when(widgetsBundleDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(widgetsBundle);

    WidgetsBundle widgetsBundle2 = new WidgetsBundle();
    widgetsBundle2.setTenantId(ModelConstants.SYSTEM_TENANT);
    widgetsBundle2.setId(new WidgetsBundleId(UUID.randomUUID()));

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> widgetsBundleDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, widgetsBundle2));
    verify(widgetsBundleDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test
   * {@link WidgetsBundleDataValidator#validateUpdate(TenantId, WidgetsBundle)}
   * with {@code TenantId}, {@code WidgetsBundle}.
   * <ul>
   *   <li>Given {@link WidgetsBundle#WidgetsBundle()} Alias is {@code Alias}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WidgetsBundleDataValidator#validateUpdate(TenantId, WidgetsBundle)}
   */
  @Test
  public void testValidateUpdateWithTenantIdWidgetsBundle_givenWidgetsBundleAliasIsAlias() {
    // Arrange
    WidgetsBundle widgetsBundle = new WidgetsBundle();
    widgetsBundle.setAlias("Alias");
    widgetsBundle.setTenantId(new TenantId(ModelConstants.NULL_UUID));
    when(widgetsBundleDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(widgetsBundle);

    WidgetsBundle widgetsBundle2 = new WidgetsBundle();
    widgetsBundle2.setTenantId(ModelConstants.SYSTEM_TENANT);
    widgetsBundle2.setId(new WidgetsBundleId(UUID.randomUUID()));

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> widgetsBundleDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, widgetsBundle2));
    verify(widgetsBundleDao).findById(isA(TenantId.class), isA(UUID.class));
  }
}
