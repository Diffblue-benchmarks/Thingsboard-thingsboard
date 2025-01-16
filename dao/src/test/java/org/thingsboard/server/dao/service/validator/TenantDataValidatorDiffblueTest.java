package org.thingsboard.server.dao.service.validator;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
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
import org.thingsboard.server.common.data.Tenant;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.Dao;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.tenant.TenantDao;
import org.thingsboard.server.dao.usagerecord.ApiLimitService;

@ContextConfiguration(classes = {TenantDataValidator.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DisabledInAotMode
public class TenantDataValidatorDiffblueTest {
  @MockBean
  private ApiLimitService apiLimitService;

  @MockBean
  private TenantDao tenantDao;

  @Autowired
  private TenantDataValidator tenantDataValidator;

  /**
   * Test {@link TenantDataValidator#validateDataImpl(TenantId, Tenant)} with
   * {@code TenantId}, {@code Tenant}.
   * <ul>
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantDataValidator#validateDataImpl(TenantId, Tenant)}
   */
  @Test
  public void testValidateDataImplWithTenantIdTenant_givenEmptyString() {
    // Arrange
    Tenant tenant = mock(Tenant.class);
    when(tenant.getEmail()).thenReturn("");
    when(tenant.getTitle()).thenReturn("Dr");

    // Act
    tenantDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, tenant);

    // Assert that nothing has changed
    verify(tenant).getEmail();
    verify(tenant).getTitle();
  }

  /**
   * Test {@link TenantDataValidator#validateDataImpl(TenantId, Tenant)} with
   * {@code TenantId}, {@code Tenant}.
   * <ul>
   *   <li>Given {@code jane.doe@example.org}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantDataValidator#validateDataImpl(TenantId, Tenant)}
   */
  @Test
  public void testValidateDataImplWithTenantIdTenant_givenJaneDoeExampleOrg() {
    // Arrange
    Tenant tenant = mock(Tenant.class);
    when(tenant.getEmail()).thenReturn("jane.doe@example.org");
    when(tenant.getTitle()).thenReturn("Dr");

    // Act
    tenantDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, tenant);

    // Assert that nothing has changed
    verify(tenant, atLeast(1)).getEmail();
    verify(tenant).getTitle();
  }

  /**
   * Test {@link TenantDataValidator#validateDataImpl(TenantId, Tenant)} with
   * {@code TenantId}, {@code Tenant}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantDataValidator#validateDataImpl(TenantId, Tenant)}
   */
  @Test
  public void testValidateDataImplWithTenantIdTenant_thenThrowDataValidationException() {
    // Arrange
    Tenant tenant = mock(Tenant.class);
    when(tenant.getEmail()).thenThrow(new DataValidationException("An error occurred"));
    when(tenant.getTitle()).thenReturn("Dr");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> tenantDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, tenant));
    verify(tenant).getEmail();
    verify(tenant).getTitle();
  }

  /**
   * Test {@link TenantDataValidator#validateUpdate(TenantId, Tenant)} with
   * {@code TenantId}, {@code Tenant}.
   * <p>
   * Method under test:
   * {@link TenantDataValidator#validateUpdate(TenantId, Tenant)}
   */
  @Test
  public void testValidateUpdateWithTenantIdTenant() {
    // Arrange
    when(tenantDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> tenantDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, new Tenant()));
    verify(tenantDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link TenantDataValidator#validateUpdate(TenantId, Tenant)} with
   * {@code TenantId}, {@code Tenant}.
   * <ul>
   *   <li>Given {@link TenantDao} {@link Dao#findById(TenantId, UUID)} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantDataValidator#validateUpdate(TenantId, Tenant)}
   */
  @Test
  public void testValidateUpdateWithTenantIdTenant_givenTenantDaoFindByIdReturnNull() {
    // Arrange
    when(tenantDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> tenantDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, new Tenant()));
    verify(tenantDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link TenantDataValidator#validateUpdate(TenantId, Tenant)} with
   * {@code TenantId}, {@code Tenant}.
   * <ul>
   *   <li>Then return {@link Tenant#Tenant()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantDataValidator#validateUpdate(TenantId, Tenant)}
   */
  @Test
  public void testValidateUpdateWithTenantIdTenant_thenReturnTenant() {
    // Arrange
    Tenant tenant = new Tenant();
    when(tenantDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(tenant);

    // Act
    Tenant actualValidateUpdateResult = tenantDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, new Tenant());

    // Assert
    verify(tenantDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(tenant, actualValidateUpdateResult);
  }
}
