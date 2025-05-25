package org.thingsboard.server.dao.service.validator;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
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

@ContextConfiguration(classes = {TenantDataValidator.class})
@DisabledInAotMode
@RunWith(SpringJUnit4ClassRunner.class)
public class TenantDataValidatorDiffblueTest {
  @MockBean
  private TenantDao tenantDao;

  @Autowired
  private TenantDataValidator tenantDataValidator;

  /**
   * Test {@link TenantDataValidator#validateUpdate(TenantId, Tenant)} with {@code TenantId}, {@code Tenant}.
   * <p>
   * Method under test: {@link TenantDataValidator#validateUpdate(TenantId, Tenant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Tenant TenantDataValidator.validateUpdate(TenantId, Tenant)"})
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
   * Test {@link TenantDataValidator#validateUpdate(TenantId, Tenant)} with {@code TenantId}, {@code Tenant}.
   * <ul>
   *   <li>Given {@link TenantDao} {@link Dao#findById(TenantId, UUID)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantDataValidator#validateUpdate(TenantId, Tenant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Tenant TenantDataValidator.validateUpdate(TenantId, Tenant)"})
  public void testValidateUpdateWithTenantIdTenant_givenTenantDaoFindByIdReturnNull() {
    // Arrange
    when(tenantDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> tenantDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, new Tenant()));
    verify(tenantDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link TenantDataValidator#validateUpdate(TenantId, Tenant)} with {@code TenantId}, {@code Tenant}.
   * <ul>
   *   <li>Then return {@link Tenant#Tenant()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantDataValidator#validateUpdate(TenantId, Tenant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Tenant TenantDataValidator.validateUpdate(TenantId, Tenant)"})
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
