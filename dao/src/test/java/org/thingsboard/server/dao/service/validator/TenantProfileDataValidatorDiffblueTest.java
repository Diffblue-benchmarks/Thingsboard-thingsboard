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
import org.thingsboard.server.common.data.TenantProfile;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.TenantProfileId;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.tenant.TenantProfileDao;

@ContextConfiguration(classes = {TenantProfileDataValidator.class})
@DisabledInAotMode
@RunWith(SpringJUnit4ClassRunner.class)
public class TenantProfileDataValidatorDiffblueTest {
  @MockBean
  private TenantProfileDao tenantProfileDao;

  @Autowired
  private TenantProfileDataValidator tenantProfileDataValidator;

  /**
   * Test {@link TenantProfileDataValidator#validateUpdate(TenantId, TenantProfile)} with {@code TenantId}, {@code TenantProfile}.
   * <p>
   * Method under test: {@link TenantProfileDataValidator#validateUpdate(TenantId, TenantProfile)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TenantProfile TenantProfileDataValidator.validateUpdate(TenantId, TenantProfile)"})
  public void testValidateUpdateWithTenantIdTenantProfile() {
    // Arrange
    when(tenantProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);

    TenantProfile tenantProfile = new TenantProfile();
    tenantProfile.setId(new TenantProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> tenantProfileDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, tenantProfile));
    verify(tenantProfileDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link TenantProfileDataValidator#validateUpdate(TenantId, TenantProfile)} with {@code TenantId}, {@code TenantProfile}.
   * <p>
   * Method under test: {@link TenantProfileDataValidator#validateUpdate(TenantId, TenantProfile)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TenantProfile TenantProfileDataValidator.validateUpdate(TenantId, TenantProfile)"})
  public void testValidateUpdateWithTenantIdTenantProfile2() {
    // Arrange
    when(tenantProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    TenantProfile tenantProfile = new TenantProfile();
    tenantProfile.setId(new TenantProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> tenantProfileDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, tenantProfile));
    verify(tenantProfileDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link TenantProfileDataValidator#validateUpdate(TenantId, TenantProfile)} with {@code TenantId}, {@code TenantProfile}.
   * <ul>
   *   <li>Then return {@link TenantProfile#TenantProfile()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantProfileDataValidator#validateUpdate(TenantId, TenantProfile)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TenantProfile TenantProfileDataValidator.validateUpdate(TenantId, TenantProfile)"})
  public void testValidateUpdateWithTenantIdTenantProfile_thenReturnTenantProfile() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    when(tenantProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(tenantProfile);

    TenantProfile tenantProfile2 = new TenantProfile();
    tenantProfile2.setId(new TenantProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    TenantProfile actualValidateUpdateResult = tenantProfileDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT,
        tenantProfile2);

    // Assert
    verify(tenantProfileDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(tenantProfile, actualValidateUpdateResult);
  }
}
