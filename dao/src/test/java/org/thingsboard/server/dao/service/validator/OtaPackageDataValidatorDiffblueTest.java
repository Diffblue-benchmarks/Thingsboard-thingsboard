package org.thingsboard.server.dao.service.validator;

import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
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
import org.thingsboard.server.common.data.OtaPackage;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.device.DeviceProfileDao;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.ota.OtaPackageDao;

@ContextConfiguration(classes = {OtaPackageDataValidator.class})
@DisabledInAotMode
@RunWith(SpringJUnit4ClassRunner.class)
public class OtaPackageDataValidatorDiffblueTest {
  @MockBean
  private DeviceProfileDao deviceProfileDao;

  @MockBean
  private OtaPackageDao otaPackageDao;

  @Autowired
  private OtaPackageDataValidator otaPackageDataValidator;

  /**
   * Test {@link OtaPackageDataValidator#validateUpdate(TenantId, OtaPackage)} with {@code TenantId}, {@code OtaPackage}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageDataValidator#validateUpdate(TenantId, OtaPackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OtaPackage OtaPackageDataValidator.validateUpdate(TenantId, OtaPackage)"})
  public void testValidateUpdateWithTenantIdOtaPackage_thenThrowDataValidationException() {
    // Arrange
    when(otaPackageDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> otaPackageDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, new OtaPackage()));
    verify(otaPackageDao).findById(isA(TenantId.class), isNull());
  }
}
